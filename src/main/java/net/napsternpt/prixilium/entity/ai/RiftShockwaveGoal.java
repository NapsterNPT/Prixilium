package net.napsternpt.prixilium.entity.ai;

import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.napsternpt.prixilium.effect.ModEffects;
import net.napsternpt.prixilium.entity.custom.RiftEntity;
import net.napsternpt.prixilium.sound.ModSounds;

import java.util.EnumSet;

public class RiftShockwaveGoal extends Goal {
    private static final int WIND_UP_TICKS = 20;
    private static final int ACTIVE_TICKS = 35;
    private static final int COOLDOWN_TICKS = 20;
    private static final int REST_TICKS = 10;
    private static final double MAX_RING_RADIUS = 14.0;
    private static final float SLAM_DAMAGE = 8.0F;

    private final RiftEntity rift;
    private PlayerEntity target;
    private int phase;
    private int phaseTimer;
    private int restTicks;
    private double ringRadius;

    public RiftShockwaveGoal(RiftEntity rift) {
        this.rift = rift;
        this.restTicks = 20;
        this.setControls(EnumSet.of(Control.MOVE, Control.LOOK));
    }

    @Override
    public boolean canStart() {
        if (this.rift.isSpawning()) {
            return false;
        }
        if (this.restTicks > 0) {
            this.restTicks--;
            return false;
        }
        this.target = this.rift.getEntityWorld().getClosestPlayer(
                this.rift.getX(), this.rift.getY(), this.rift.getZ(), 12.0,
                entity -> entity instanceof PlayerEntity player && player.isAlive()
                        && !player.isCreative() && !player.isSpectator());
        return this.target != null && !this.rift.isSneaking();
    }

    @Override
    public boolean shouldContinue() {
        return this.phase != -1 && this.target != null && this.target.isAlive();
    }

    @Override
    public void start() {
        this.phase = 0;
        this.phaseTimer = WIND_UP_TICKS;
        this.ringRadius = 0;
        this.rift.playSlamAnimation();
    }

    @Override
    public void stop() {
        this.phase = -1;
        this.rift.stopSlamAnimation();
    }

    @Override
    public void tick() {
        if (this.target == null) {
            return;
        }

        this.phaseTimer--;
        switch (this.phase) {
            case 0 -> {
                if (this.phaseTimer <= 0) {
                    this.slam();
                    this.phase = 1;
                    this.phaseTimer = ACTIVE_TICKS;
                }
            }
            case 1 -> {
                double waveProgress = 1.0 - ((double) this.phaseTimer / (double) ACTIVE_TICKS);
                this.ringRadius = waveProgress * MAX_RING_RADIUS;
                this.applyRingEffects();
                this.spawnHitboxParticles();
                if (this.phaseTimer <= 0) {
                    this.phase = 2;
                    this.phaseTimer = COOLDOWN_TICKS;
                }
            }
            case 2 -> {
                if (this.phaseTimer <= 0) {
                    this.phase = -1;
                    this.restTicks = REST_TICKS;
                }
            }
        }
    }

    private void slam() {
        ServerWorld world = (ServerWorld) this.rift.getEntityWorld();
        world.playSound(null, this.rift.getX(), this.rift.getY() + 0.2, this.rift.getZ(),
                ModSounds.RIFT_SLAM, SoundCategory.HOSTILE, 1.0F, 1.0F);
    }

    private void spawnHitboxParticles() {
        ServerWorld world = (ServerWorld) this.rift.getEntityWorld();
        double x = this.rift.getX();
        double y = this.rift.getY() + 0.2;
        double z = this.rift.getZ();
        double inner = this.ringRadius - 0.8;
        double outer = this.ringRadius + 0.8;
        int count = 32;
        for (int i = 0; i < count; i++) {
            double angle = (2.0 * Math.PI * i) / count;
            world.spawnParticles(ParticleTypes.ELECTRIC_SPARK,
                    x + Math.cos(angle) * inner, y, z + Math.sin(angle) * inner,
                    1, 0.0, 0.0, 0.0, 0.0);
            world.spawnParticles(ParticleTypes.ELECTRIC_SPARK,
                    x + Math.cos(angle) * outer, y, z + Math.sin(angle) * outer,
                    1, 0.0, 0.0, 0.0, 0.0);
        }
    }

    private void applyRingEffects() {
        double bandMin = this.ringRadius - 0.8;
        double bandMax = this.ringRadius + 0.8;
        double ringY = this.rift.getY() + 0.2;

        for (PlayerEntity player : this.rift.getEntityWorld().getPlayers()) {
            if (player == null || !player.isAlive() || player.isCreative() || player.isSpectator()) {
                continue;
            }
            double dx = player.getX() - this.rift.getX();
            double dz = player.getZ() - this.rift.getZ();
            double horizontalDist = Math.sqrt(dx * dx + dz * dz);
            if (horizontalDist < bandMin || horizontalDist > bandMax) {
                continue;
            }
            if (player.getY() > ringY + 0.35) {
                continue;
            }
            ServerWorld world = (ServerWorld) this.rift.getEntityWorld();
            player.damage(world, world.getDamageSources().mobAttack(this.rift), SLAM_DAMAGE);
            player.addStatusEffect(new StatusEffectInstance(ModEffects.STUNNED, 100, 0));
            world.spawnParticles(ParticleTypes.ELECTRIC_SPARK,
                    player.getX(), player.getY() + 1.0, player.getZ(), 30, 0.4, 0.6, 0.4, 0.2);
        }
    }
}
