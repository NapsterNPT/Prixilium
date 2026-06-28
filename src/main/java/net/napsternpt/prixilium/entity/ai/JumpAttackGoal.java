package net.napsternpt.prixilium.entity.ai;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.Vec3d;

import java.util.EnumSet;

public class JumpAttackGoal extends Goal {

    private final MobEntity mob;
    private final double speed;
    private LivingEntity target;

    private enum Phase { APPROACH, JUMP }
    private Phase phase = Phase.APPROACH;
    private int cooldownTimer = 0;
    private static final int JUMP_COOLDOWN = 20;

    public JumpAttackGoal(MobEntity mob, double speed) {
        this.mob = mob;
        this.speed = speed;
        this.setControls(EnumSet.of(Control.MOVE, Control.LOOK));
    }

    @Override
    public boolean canStart() {
        LivingEntity target = this.mob.getTarget();
        if (target == null || !target.isAlive()) return false;
        this.target = target;
        return true;
    }

    @Override
    public boolean shouldContinue() {
        return target != null && target.isAlive();
    }

    @Override
    public void stop() {
        this.target = null;
        this.phase = Phase.APPROACH;
        this.cooldownTimer = 0;
        this.mob.getNavigation().stop();
    }

    @Override
    public void tick() {
        if (target == null) return;

        if (cooldownTimer > 0) {
            cooldownTimer--;
            this.mob.getNavigation().stop();
            return;
        }

        switch (phase) {
            case APPROACH -> {
                this.mob.getNavigation().startMovingTo(target, speed);
                this.mob.getLookControl().lookAt(target, 30F, 30F);

                if (this.mob.squaredDistanceTo(target) < 9.0) {
                    doJump();
                    phase = Phase.JUMP;
                }
            }
            case JUMP -> {
                if (this.mob.getEntityWorld() instanceof ServerWorld serverWorld) {
                    if (this.mob.squaredDistanceTo(target) < 6.0) {
                        this.mob.tryAttack(serverWorld, target);
                        cooldownTimer = JUMP_COOLDOWN;
                        phase = Phase.APPROACH;
                        return;
                    }
                }
                if (this.mob.isOnGround() && this.mob.age > 5) {
                    cooldownTimer = JUMP_COOLDOWN;
                    phase = Phase.APPROACH;
                }
            }
        }
    }

    private void doJump() {
        if (target == null) return;

        Vec3d targetHead = new Vec3d(target.getX(), target.getY() + target.getHeight(), target.getZ());

        Vec3d toTarget = targetHead.subtract(this.mob.getEntityPos()).normalize();

        this.mob.setVelocity(toTarget.x * 0.8, 0.5, toTarget.z * 0.8);
        this.mob.velocityModified = true;
    }
}