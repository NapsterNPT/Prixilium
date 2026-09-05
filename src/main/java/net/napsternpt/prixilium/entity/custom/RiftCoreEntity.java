package net.napsternpt.prixilium.entity.custom;

import net.minecraft.entity.AnimationState;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.ActiveTargetGoal;
import net.minecraft.entity.ai.goal.LookAroundGoal;
import net.minecraft.entity.ai.goal.LookAtEntityGoal;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.DamageTypes;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvent;
import net.minecraft.world.World;
import net.napsternpt.prixilium.block.ModBlocks;
import net.napsternpt.prixilium.entity.ai.RiftCoreBurrowGoal;
import net.napsternpt.prixilium.sound.ModSounds;
import org.jetbrains.annotations.Nullable;

public class RiftCoreEntity extends HostileEntity {
    private static final TrackedData<Boolean> STUNNED =
            DataTracker.registerData(RiftCoreEntity.class, TrackedDataHandlerRegistry.BOOLEAN);

    private static final int STUN_DURATION = 100; // 5 seconds
    private int stunTicks = 0;

    public final AnimationState idleAnimationState = new AnimationState();
    public final AnimationState walkAnimationState = new AnimationState();
    public final AnimationState burrowAnimationState = new AnimationState();
    public final AnimationState emergeAnimationState = new AnimationState();
    public final AnimationState spawnAnimationState = new AnimationState();

    private boolean hasPlayedSpawnAnimation = false;

    public RiftCoreEntity(EntityType<? extends HostileEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    protected void initDataTracker(DataTracker.Builder builder) {
        super.initDataTracker(builder);
        builder.add(STUNNED, false);
    }

    @Override
    protected void initGoals() {
        this.goalSelector.add(0, new SwimGoal(this));
        this.goalSelector.add(1, new RiftCoreBurrowGoal(this));
        this.goalSelector.add(4, new LookAtEntityGoal(this, PlayerEntity.class, 8.0F));
        this.goalSelector.add(5, new LookAroundGoal(this));

        this.targetSelector.add(1, new ActiveTargetGoal<>(this, PlayerEntity.class, true));
    }

    public static DefaultAttributeContainer.Builder createAttributes() {
        return HostileEntity.createHostileAttributes()
                .add(EntityAttributes.MAX_HEALTH, 200)
                .add(EntityAttributes.MOVEMENT_SPEED, 0.4)
                .add(EntityAttributes.FOLLOW_RANGE, 24)
                .add(EntityAttributes.ATTACK_DAMAGE, 12)
                .add(EntityAttributes.KNOCKBACK_RESISTANCE, 1.0);
    }

    @Override
    public void tick() {
        super.tick();
        if (!this.getEntityWorld().isClient() && stunTicks > 0) {
            stunTicks--;
            if (stunTicks <= 0) {
                this.setStunned(false);
            }
        }

        if (this.getEntityWorld().isClient()) {
            if (!this.hasPlayedSpawnAnimation) {
                this.hasPlayedSpawnAnimation = true;
                this.spawnAnimationState.start(this.age);
            }

            boolean attacking = this.burrowAnimationState.isRunning() || this.emergeAnimationState.isRunning() || this.spawnAnimationState.isRunning();
            if (!attacking) {
                if (this.getVelocity().horizontalLengthSquared() != 0) {
                    this.idleAnimationState.stop();
                    this.walkAnimationState.startIfNotRunning(this.age);
                } else {
                    this.idleAnimationState.startIfNotRunning(this.age);
                    this.walkAnimationState.stop();
                }
            }
        }
    }

    public boolean isStunned() {
        return this.dataTracker.get(STUNNED);
    }

    public void setStunned(boolean stunned) {
        this.dataTracker.set(STUNNED, stunned);
        if (stunned) {
            this.stunTicks = STUN_DURATION;
        } else {
            this.stunTicks = 0;
        }
    }

    @Override
    public boolean damage(ServerWorld world, DamageSource source, float amount) {
        if (!this.isStunned() && !source.isOf(DamageTypes.OUT_OF_WORLD) && !source.isSourceCreativePlayer()) {
            return false;
        }
        return super.damage(world, source, amount);
    }

    @Override
    public boolean isBaby() {
        //No
        return false;
    }

    @Override
    public boolean handleFallDamage(double fallDistance, float damagePerDistance, DamageSource damageSource) {
        //No
        return false;
    }

    @Override
    protected void dropLoot(ServerWorld world, DamageSource damageSource, boolean causedByPlayer) {
        super.dropLoot(world, damageSource, causedByPlayer);
        this.dropStack(world, new ItemStack(ModBlocks.RIFT_CORE));
    }

    public void playBurrowAnimation() {
        if (this.getEntityWorld().isClient()) {
            this.burrowAnimationState.start(this.age);
        }
    }

    public void stopBurrowAnimation() {
        if (this.getEntityWorld().isClient()) {
            this.burrowAnimationState.stop();
        }
    }

    public void playEmergeAnimation() {
        if (this.getEntityWorld().isClient()) {
            this.emergeAnimationState.start(this.age);
        }
    }

    public void stopEmergeAnimation() {
        if (this.getEntityWorld().isClient()) {
            this.emergeAnimationState.stop();
        }
    }

    //Sounds
    @Override
    protected @Nullable SoundEvent getAmbientSound() {return ModSounds.RIFT_CORE_AMBIENT;}

    @Override
    protected @Nullable SoundEvent getHurtSound(DamageSource source) {return ModSounds.RIFT_CORE_HURT;}

    @Override
    protected @Nullable SoundEvent getDeathSound() {return ModSounds.RIFT_CORE_DEATH;}
}
