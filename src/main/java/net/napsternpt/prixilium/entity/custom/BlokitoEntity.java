package net.napsternpt.prixilium.entity.custom;

import net.minecraft.advancement.AdvancementEntry;
import net.minecraft.entity.AnimationState;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.ZombieEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;
import net.napsternpt.prixilium.Prixilium;
import net.napsternpt.prixilium.sound.ModSounds;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;

public class BlokitoEntity extends ZombieEntity {
    public final AnimationState idleAnimationState = new AnimationState();
    public final AnimationState walkAnimationState = new AnimationState();

    public BlokitoEntity(EntityType<? extends ZombieEntity> entityType, World world) {
        super(entityType, world);
    }


    @Override
    protected void initGoals() {
        this.goalSelector.add(0, new SwimGoal(this));
        this.goalSelector.add(1, new ZombieAttackGoal(this, 1.0D, false));
        this.goalSelector.add(2, new WanderAroundFarGoal(this, 1.0D));
        this.goalSelector.add(3, new WanderAroundGoal(this, 1.0D));
        this.goalSelector.add(4, new LookAtEntityGoal(this, PlayerEntity.class, 4.0F));
        this.goalSelector.add(5, new LookAroundGoal(this));

        this.targetSelector.add(1, new ActiveTargetGoal<>(this, PlayerEntity.class, true));
    }

    @Override
    protected void initAttributes() {
        // No
    }

    public static DefaultAttributeContainer.Builder createAttributes() {
        return HostileEntity.createMobAttributes()
                .add(EntityAttributes.MAX_HEALTH, 10)
                .add(EntityAttributes.MOVEMENT_SPEED, 0.25)
                .add(EntityAttributes.ATTACK_DAMAGE, 3.0)
                .add(EntityAttributes.FOLLOW_RANGE, 50)
                .add(EntityAttributes.TEMPT_RANGE, 10);
    }

    @Override
    public void tick() {
        super.tick();

        if (this.getEntityWorld().isClient()) {
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
    public void takeKnockback(double strength, double x, double z) {
        // No
    }

    @Override
    protected boolean burnsInDaylight() {
        // No
        return false;
    }

    @Override
    public boolean isBaby() {
        // No
        return false;
    }

    @Override
    public void onDeath(DamageSource source) {
        super.onDeath(source);
        if (!this.getEntityWorld().isClient() && source.getAttacker() instanceof ServerPlayerEntity serverPlayer) {
            AdvancementEntry advancement = Objects.requireNonNull(this.getEntityWorld().getServer()).getAdvancementLoader().get(Identifier.of(Prixilium.MOD_ID, "block_entity"));
            serverPlayer.getAdvancementTracker().grantCriterion(advancement, "block_entity");
        }
    }

    //Sounds
    @Override
    protected @Nullable SoundEvent getAmbientSound() {
        return null;
        // No
    }

    @Override
    protected @Nullable SoundEvent getHurtSound(DamageSource source) {return ModSounds.BLOKITO_HURT;}

    @Override
    protected @Nullable SoundEvent getDeathSound() {return ModSounds.BLOKITO_DEATH;}

    @Override
    protected SoundEvent getStepSound() {return ModSounds.BLOKITO_WALK;}
}
