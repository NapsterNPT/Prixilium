package net.napsternpt.prixilium.entity.ai;

import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.player.PlayerEntity;
import net.napsternpt.prixilium.entity.custom.RiftEntity;

import java.util.EnumSet;

public class RiftPursuitGoal extends Goal {
    private static final double STOP_DISTANCE = 5.0;
    private static final double TARGET_DISTANCE = 12.0;
    private static final double MOVE_SPEED = 0.85;

    private final RiftEntity rift;
    private PlayerEntity target;

    public RiftPursuitGoal(RiftEntity rift) {
        this.rift = rift;
        this.setControls(EnumSet.of(Control.MOVE, Control.LOOK));
    }

    @Override
    public boolean canStart() {
        if (this.rift.isSpinActive() || this.rift.isSpawning()) {
            return false;
        }
        this.target = this.rift.getEntityWorld().getClosestPlayer(
                this.rift.getX(), this.rift.getY(), this.rift.getZ(), TARGET_DISTANCE, entity ->
                        entity instanceof PlayerEntity player && player.isAlive() && !player.isCreative() && !player.isSpectator());
        return this.target != null;
    }

    @Override
    public boolean shouldContinue() {
        return !this.rift.isSpinActive() && !this.rift.isSpawning()
                && this.target != null && this.target.isAlive();
    }

    @Override
    public void tick() {
        if (this.target == null) {
            return;
        }

        if (this.rift.squaredDistanceTo(this.target) > STOP_DISTANCE * STOP_DISTANCE) {
            this.rift.getNavigation().startMovingTo(this.target, MOVE_SPEED);
        } else {
            this.rift.getNavigation().stop();
        }

        this.rift.getLookControl().lookAt(this.target);
    }
}