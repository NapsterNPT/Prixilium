package net.napsternpt.prixilium.entity.custom;

import net.minecraft.entity.AnimationState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.sound.SoundEvent;
import net.minecraft.world.World;
import net.napsternpt.prixilium.entity.ai.JumpAttackGoal;
import net.napsternpt.prixilium.sound.ModSounds;
import org.jetbrains.annotations.Nullable;

public class AirisEntity extends HostileEntity {
    public final AnimationState idleAnimationState = new AnimationState();
    public final AnimationState walkAnimationState = new AnimationState();

    public AirisEntity(EntityType<? extends HostileEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    protected void initGoals() {
        this.goalSelector.add(0, new SwimGoal(this));
        this.goalSelector.add(2, new JumpAttackGoal(this, 1.5));
        this.goalSelector.add(3, new WanderAroundFarGoal(this, 1.0));
        this.goalSelector.add(4, new LookAtEntityGoal(this, PlayerEntity.class, 8.0F));
        this.goalSelector.add(5, new LookAroundGoal(this));

        this.targetSelector.add(1, new ActiveTargetGoal<>(this, PlayerEntity.class, true));
    }

    public static DefaultAttributeContainer.Builder createAttributes() {
        return HostileEntity.createHostileAttributes()
                .add(EntityAttributes.MAX_HEALTH, 10)
                .add(EntityAttributes.MOVEMENT_SPEED, 0.35)
                .add(EntityAttributes.FOLLOW_RANGE, 16)
                .add(EntityAttributes.ATTACK_DAMAGE, 10);
    }

    @Override
    public void tick() {
        super.tick();

        if (this.getWorld().isClient) {
            if (this.getVelocity().horizontalLengthSquared() != 0) {
                this.idleAnimationState.stop();
                this.walkAnimationState.startIfNotRunning(this.age);
            } else {
                this.idleAnimationState.startIfNotRunning(this.age);
                this.walkAnimationState.stop();
            }
        }
    }

    @Override
    public boolean isBaby() {
        // No
        return false;
    }

    @Override
    public boolean handleFallDamage(double fallDistance, float damagePerDistance, DamageSource damageSource) {
        // No
        return false;
    }

    @Override
    public void updatePassengerPosition(Entity passenger, PositionUpdater positionUpdater) {
        if (this.hasPassenger(passenger)) {
            positionUpdater.accept(passenger, this.getX(), this.getY() + this.getHeight() + 0.1, this.getZ());
        }
    }

    //Sounds
    @Override
    protected @Nullable SoundEvent getAmbientSound() {return ModSounds.AIRIS_AMBIENT;}

    @Override
    protected @Nullable SoundEvent getHurtSound(DamageSource source) {return ModSounds.AIRIS_HURT;}

    @Override
    protected @Nullable SoundEvent getDeathSound() {return ModSounds.AIRIS_DEATH;}
}
