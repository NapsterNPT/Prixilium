package net.napsternpt.prixilium.entity.custom;

import net.minecraft.entity.AnimationState;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.goal.ActiveTargetGoal;
import net.minecraft.entity.ai.goal.LookAroundGoal;
import net.minecraft.entity.ai.goal.LookAtEntityGoal;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.napsternpt.prixilium.entity.ModEntities;
import net.napsternpt.prixilium.entity.ai.RiftPursuitGoal;
import net.napsternpt.prixilium.entity.ai.RiftShockwaveGoal;
import net.napsternpt.prixilium.entity.ai.RiftSpinGoal;
import net.napsternpt.prixilium.sound.ModSounds;
import org.jetbrains.annotations.Nullable;

public class RiftEntity extends HostileEntity {
    private static final TrackedData<Boolean> SLAM_ACTIVE = DataTracker.registerData(
            RiftEntity.class, TrackedDataHandlerRegistry.BOOLEAN);
    private static final TrackedData<Boolean> SPIN_ACTIVE = DataTracker.registerData(
            RiftEntity.class, TrackedDataHandlerRegistry.BOOLEAN);
    private static final int SPAWN_ANIMATION_TICKS = 140;

    public final AnimationState idleAnimationState = new AnimationState();
    public final AnimationState walkAnimationState = new AnimationState();
    public final AnimationState slamAnimationState = new AnimationState();
    public final AnimationState spinAnimationState = new AnimationState();
    public final AnimationState spawnAnimationState = new AnimationState();

    private boolean hasPlayedSpawnAnimation = false;
    private int spawnTicks = SPAWN_ANIMATION_TICKS;

    public RiftEntity(EntityType<? extends HostileEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    protected void initDataTracker(DataTracker.Builder builder) {
        super.initDataTracker(builder);
        builder.add(SLAM_ACTIVE, false);
        builder.add(SPIN_ACTIVE, false);
    }

    @Override
    protected void initGoals() {
        this.goalSelector.add(0, new RiftShockwaveGoal(this));
        this.goalSelector.add(1, new RiftSpinGoal(this));
        this.goalSelector.add(2, new RiftPursuitGoal(this));
        this.goalSelector.add(3, new LookAtEntityGoal(this, PlayerEntity.class, 8.0F));
        this.goalSelector.add(4, new LookAroundGoal(this));

        this.targetSelector.add(1, new ActiveTargetGoal<>(this, PlayerEntity.class, 10, true, false,
                (candidate, world) -> candidate instanceof PlayerEntity player && player.isAlive() && !player.isCreative() && !player.isSpectator()));
    }

    public static DefaultAttributeContainer.Builder createAttributes() {
        return HostileEntity.createHostileAttributes()
                .add(EntityAttributes.MAX_HEALTH, 600)
                .add(EntityAttributes.MOVEMENT_SPEED, 0.3)
                .add(EntityAttributes.FOLLOW_RANGE, 24)
                .add(EntityAttributes.ATTACK_DAMAGE, 8)
                .add(EntityAttributes.KNOCKBACK_RESISTANCE, 1.0);
    }

    @Override
    public void tick() {
        super.tick();

        if (!this.getEntityWorld().isClient() && this.spawnTicks > 0) {
            this.spawnTicks--;
        }

        if (this.getEntityWorld().isClient()) {
            if (!this.hasPlayedSpawnAnimation) {
                this.hasPlayedSpawnAnimation = true;
                this.spawnAnimationState.start(this.age);
            }
            if (this.spawnAnimationState.isRunning() && this.spawnAnimationState.getTimeInMilliseconds(this.age) >= 7000L) {
                this.spawnAnimationState.stop();
            }

            if (this.dataTracker.get(SLAM_ACTIVE)) {
                this.slamAnimationState.startIfNotRunning(this.age);
            } else {
                this.slamAnimationState.stop();
            }
            if (this.dataTracker.get(SPIN_ACTIVE)) {
                this.spinAnimationState.startIfNotRunning(this.age);
            } else {
                this.spinAnimationState.stop();
            }

            boolean attacking = this.slamAnimationState.isRunning() || this.spinAnimationState.isRunning()
                    || this.spawnAnimationState.isRunning();
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

    @Override
    public boolean isBaby() {
        // No
        return false;
    }

    @Override
    public boolean isPersistent() {
        // Yes
        return true;
    }

    @Override
    public boolean canBreatheInWater() {
        // Yes
        return true;
    }

    @Override
    public boolean handleFallDamage(double fallDistance, float damagePerDistance, DamageSource damageSource) {
        // No
        return false;
    }

    @Override
    public boolean damage(ServerWorld world, DamageSource source, float amount) {
        if (source.getSource() instanceof ProjectileEntity projectile) {
            if (!world.isClient() && source.getAttacker() instanceof LivingEntity attacker) {
                Vec3d projectilePos = new Vec3d(projectile.getX(), projectile.getY(), projectile.getZ());
                Vec3d direction = attacker.getEyePos().subtract(projectilePos).normalize();
                double speed = Math.max(projectile.getVelocity().length(), 0.1);
                projectile.setVelocity(direction.multiply(speed).add(0.0, 0.05, 0.0));
                projectile.setOwner(this);
                projectile.velocityDirty = true;
            }
            return false;
        }
        return super.damage(world, source, amount);
    }

    @Override
    public void onDeath(DamageSource damageSource) {
        super.onDeath(damageSource);
        if (!this.getEntityWorld().isClient() && this.getEntityWorld() instanceof ServerWorld serverWorld) {
            RiftCoreEntity core = ModEntities.RIFT_CORE.create(serverWorld, SpawnReason.EVENT);
            if (core != null) {
                core.refreshPositionAndAngles(this.getX(), this.getY(), this.getZ(), this.getYaw(), 0.0F);
                serverWorld.spawnEntity(core);
            }
        }
    }

    //Attack animations - called by the AI goals (server sets the synced flag, client plays the animation)
    public void playSlamAnimation() {
        if (!this.getEntityWorld().isClient()) {
            this.dataTracker.set(SLAM_ACTIVE, true);
        }
    }

    public void stopSlamAnimation() {
        if (!this.getEntityWorld().isClient()) {
            this.dataTracker.set(SLAM_ACTIVE, false);
        }
    }

    public void playSpinAnimation() {
        if (!this.getEntityWorld().isClient()) {
            this.dataTracker.set(SPIN_ACTIVE, true);
        }
    }

    public void stopSpinAnimation() {
        if (!this.getEntityWorld().isClient()) {
            this.dataTracker.set(SPIN_ACTIVE, false);
        }
    }

    public boolean isSpinActive() {
        return this.dataTracker.get(SPIN_ACTIVE);
    }

    public boolean isSpawning() {
        return this.spawnTicks > 0;
    }

    //Sounds
    @Override
    protected @Nullable SoundEvent getAmbientSound() {return ModSounds.RIFT_AMBIENT;}

    @Override
    protected @Nullable SoundEvent getHurtSound(DamageSource source) {return ModSounds.RIFT_HURT;}

    @Override
    protected @Nullable SoundEvent getDeathSound() {return ModSounds.RIFT_DEATH;}
}
