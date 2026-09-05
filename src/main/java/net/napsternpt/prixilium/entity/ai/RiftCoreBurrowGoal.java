package net.napsternpt.prixilium.entity.ai;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.napsternpt.prixilium.entity.custom.RiftCoreEntity;
import net.napsternpt.prixilium.sound.ModSounds;

import java.util.EnumSet;
import java.util.List;

public class RiftCoreBurrowGoal extends Goal {
    private static final int BURROW_TICKS = 10;
    private static final int EMERGE_TICKS = 10;
    private static final int COOLDOWN_TICKS = 160;
    private static final double ATTACK_RADIUS = 3.0;
    private static final double TRIGGER_DISTANCE = 16.0;
    private static final float EMERGE_DAMAGE = 12.0F;

    private final RiftCoreEntity core;
    private PlayerEntity target;
    private int phase;
    private int phaseTimer;
    private int cooldownTicks;

    public RiftCoreBurrowGoal(RiftCoreEntity core) {
        this.core = core;
        this.setControls(EnumSet.of(Control.MOVE, Control.LOOK));
    }

    @Override
    public boolean canStart() {
        if (this.core.isStunned() || this.cooldownTicks > 0) {
            return false;
        }
        this.target = this.core.getEntityWorld().getClosestPlayer(this.core, TRIGGER_DISTANCE);
        return this.target != null && this.target.isAlive();
    }

    @Override
    public boolean shouldContinue() {
        return this.phase != -1;
    }

    @Override
    public void start() {
        this.phase = 0;
        this.phaseTimer = BURROW_TICKS;
        this.core.getNavigation().stop();
        this.core.playBurrowAnimation();
    }

    @Override
    public void stop() {
        this.phase = -1;
        this.cooldownTicks = COOLDOWN_TICKS;
        this.target = null;
        this.core.setInvisible(false);
        this.core.setInvulnerable(false);
        this.core.stopBurrowAnimation();
        this.core.stopEmergeAnimation();
    }

    @Override
    public void tick() {
        if (this.cooldownTicks > 0) {
            this.cooldownTicks--;
        }
        if (this.target == null) {
            return;
        }

        this.phaseTimer--;

        switch (this.phase) {
            case 0 -> {
                this.core.setInvisible(true);
                this.core.setInvulnerable(true);
                ServerWorld world = (ServerWorld) this.core.getEntityWorld();
                world.playSound(null, this.core.getX(), this.core.getY(), this.core.getZ(), ModSounds.RIFT_CORE_BURROW, SoundCategory.HOSTILE, 1.0F, 1.0F);
                if (this.phaseTimer <= 0) {
                    this.phase = 1;
                }
            }
            case 1 -> {
                this.phase = 2;
                this.phaseTimer = EMERGE_TICKS;
            }
            case 2 -> {
                if (this.phaseTimer == EMERGE_TICKS - 1) {
                    this.core.refreshPositionAndAngles(this.target.getX(), this.target.getY() - 0.5, this.target.getZ(), this.core.getYaw(), 0.0F);
                    this.core.setInvisible(false);
                    this.core.setInvulnerable(false);
                    this.core.playEmergeAnimation();
                    ServerWorld world = (ServerWorld) this.core.getEntityWorld();
                    world.playSound(null, this.core.getX(), this.core.getY(), this.core.getZ(), ModSounds.RIFT_CORE_EMERGE, SoundCategory.HOSTILE, 1.0F, 1.0F);
                    this.emerge(world);
                }
                if (this.phaseTimer <= 0) {
                    this.phase = -1;
                }
            }
        }
    }

    private void emerge(ServerWorld world) {
        List<LivingEntity> targets = world.getEntitiesByClass(LivingEntity.class,
                this.core.getBoundingBox().expand(ATTACK_RADIUS),
                e -> e != this.core && e.isAlive());
        for (LivingEntity e : targets) {
            e.damage(world, world.getDamageSources().mobAttack(this.core), EMERGE_DAMAGE);
            e.takeKnockback(1.0, this.core.getX() - e.getX(), this.core.getZ() - e.getZ());
        }
    }
}
