package net.napsternpt.prixilium.entity.ai;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.napsternpt.prixilium.entity.custom.RiftEntity;
import net.napsternpt.prixilium.sound.ModSounds;

import java.util.EnumSet;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RiftSpinGoal extends Goal {
    private static final int SPIN_TICKS = 30;
    private static final int COOLDOWN_TICKS = 30;
    private static final double TRIGGER_DISTANCE = 6.0;
    private static final double ATTACK_RADIUS = 2.5;
    private static final float SPIN_DAMAGE = 4.0F;
    private static final double KNOCKBACK = 1.8;
    private static final double KNOCKBACK_UP = 0.4;

    private final RiftEntity rift;
    private final Set<LivingEntity> hitEntities = new HashSet<>();
    private int spinTicks;
    private int cooldownTicks;

    public RiftSpinGoal(RiftEntity rift) {
        this.rift = rift;
        this.setControls(EnumSet.noneOf(Control.class));
    }

    @Override
    public boolean canStart() {
        if (this.rift.isSpawning()) {
            return false;
        }
        if (this.cooldownTicks > 0) {
            this.cooldownTicks--;
            return false;
        }
        LivingEntity target = this.rift.getTarget();
        return target instanceof PlayerEntity player
                && player.isAlive()
                && this.rift.squaredDistanceTo(player) < TRIGGER_DISTANCE * TRIGGER_DISTANCE;
    }

    @Override
    public boolean shouldContinue() {
        return this.spinTicks > 0;
    }

    @Override
    public void start() {
        this.spinTicks = SPIN_TICKS;
        this.hitEntities.clear();
        this.rift.getNavigation().stop();
        this.rift.playSpinAnimation();
        ServerWorld world = (ServerWorld) this.rift.getEntityWorld();
        world.playSound(null, this.rift.getX(), this.rift.getY(), this.rift.getZ(),
                ModSounds.RIFT_SPIN, SoundCategory.HOSTILE, 1.0F, 1.0F);
    }

    @Override
    public void stop() {
        this.spinTicks = 0;
        this.cooldownTicks = COOLDOWN_TICKS;
        this.rift.stopSpinAnimation();
    }

    @Override
    public void tick() {
        if (this.spinTicks > 0) {
            this.rift.setYaw(this.rift.getYaw() + 20.0F);
            this.rift.setHeadYaw(this.rift.getHeadYaw() + 20.0F);

            ServerWorld world = (ServerWorld) this.rift.getEntityWorld();
            List<LivingEntity> targets = world.getEntitiesByClass(LivingEntity.class,
                    this.rift.getBoundingBox().expand(ATTACK_RADIUS),
                    e -> e != this.rift && e.isAlive()
                            && !(e instanceof PlayerEntity p && (p.isCreative() || p.isSpectator())));
            for (LivingEntity e : targets) {
                if (this.hitEntities.add(e)) {
                    double dx = e.getX() - this.rift.getX();
                    double dz = e.getZ() - this.rift.getZ();
                    double len = Math.max(Math.sqrt(dx * dx + dz * dz), 0.001);
                    e.addVelocity(dx / len * KNOCKBACK, KNOCKBACK_UP, dz / len * KNOCKBACK);
                }
                e.damage(world, world.getDamageSources().mobAttack(this.rift), SPIN_DAMAGE);
            }

            this.spinTicks--;
        }
    }
}
