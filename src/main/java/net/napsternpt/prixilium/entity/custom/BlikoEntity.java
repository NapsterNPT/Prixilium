package net.napsternpt.prixilium.entity.custom;

import net.minecraft.advancement.AdvancementEntry;
import net.minecraft.entity.AnimationState;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.Ingredient;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;
import net.napsternpt.prixilium.Prixilium;
import net.napsternpt.prixilium.block.ModBlocks;
import net.napsternpt.prixilium.entity.ModEntities;
import net.napsternpt.prixilium.sound.ModSounds;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;

public class BlikoEntity extends TameableEntity {
    public final AnimationState idleAnimationState = new AnimationState();
    public final AnimationState walkAnimationState = new AnimationState();
    public final AnimationState sitAnimationState = new AnimationState();

    public BlikoEntity(EntityType<? extends TameableEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    protected void initGoals() {
        this.goalSelector.add(0, new SwimGoal(this));
        this.goalSelector.add(1, new SitGoal(this));
        this.goalSelector.add(2, new FollowOwnerGoal(this, 1.5F, 10.0F, 2.0F));
        this.goalSelector.add(3, new AnimalMateGoal(this, 1.15D));
        this.goalSelector.add(4, new TemptGoal(this, 1.25D, Ingredient.ofItem(ModBlocks.PRIXILIUM), false));
        this.goalSelector.add(5, new FollowParentGoal(this, 1.1D));
        this.goalSelector.add(6, new WanderAroundFarGoal(this, 1.0D));
        this.goalSelector.add(7, new LookAtEntityGoal(this, PlayerEntity.class, 4.0F));
        this.goalSelector.add(8, new LookAroundGoal(this));
    }

    public static DefaultAttributeContainer.Builder createAttributes() {
        return MobEntity.createMobAttributes()
                .add(EntityAttributes.MAX_HEALTH, 10)
                .add(EntityAttributes.MOVEMENT_SPEED, 0.25)
                .add(EntityAttributes.FOLLOW_RANGE, 20)
                .add(EntityAttributes.TEMPT_RANGE, 10);
    }

    @Override
    public ActionResult interactMob(PlayerEntity player, Hand hand) {
        ItemStack stack = player.getStackInHand(hand);

        if (!this.isTamed()) {
            if (stack.isOf(ModBlocks.PRIXILIUM.asItem())) {
                if (!player.getAbilities().creativeMode) {
                    stack.decrement(1);
                }
                if (this.random.nextInt(3) == 0) {
                    this.setOwner(player);
                    this.getWorld().sendEntityStatus(this, (byte) 7);
                    if (!this.getWorld().isClient && player instanceof ServerPlayerEntity serverPlayer) {
                        AdvancementEntry advancement = Objects.requireNonNull(serverPlayer.getServer()).getAdvancementLoader().get(Identifier.of(Prixilium.MOD_ID, "team_bliko"));
                        serverPlayer.getAdvancementTracker().grantCriterion(advancement, "team_bliko");
                    }
                } else {
                    this.getWorld().sendEntityStatus(this, (byte) 6);
                }
                return ActionResult.SUCCESS;
            }
        } else {
            if (this.isOwner(player) && stack.isEmpty()) {
                this.setSitting(!this.isSitting());
                return ActionResult.SUCCESS;
            }
        }
        return super.interactMob(player, hand);
    }

    @Override
    public void tick() {
        super.tick();

        if (this.getWorld().isClient) {
            if (this.isSitting()) {
                this.idleAnimationState.stop();
                this.walkAnimationState.stop();
                this.sitAnimationState.startIfNotRunning(this.age);
            } else {
                if (this.getVelocity().horizontalLengthSquared() != 0) {
                    this.idleAnimationState.stop();
                    this.walkAnimationState.startIfNotRunning(this.age);
                    this.sitAnimationState.stop();
                } else {
                    this.idleAnimationState.startIfNotRunning(this.age);
                    this.walkAnimationState.stop();
                    this.sitAnimationState.stop();
                }
            }
        }
    }

    @Override
    public boolean isBreedingItem(ItemStack stack) {
        return false;
    }

    @Override
    public @Nullable PassiveEntity createChild(ServerWorld world, PassiveEntity entity) {
        BlikoEntity child = ModEntities.BLIKO.create(world, SpawnReason.BREEDING);
        if (child != null) child.setBaby(true);
        return child;
    }

    @Override
    public void onDeath(DamageSource source) {
        super.onDeath(source);

        if (!this.getWorld().isClient) {
            if (source.getAttacker() instanceof ServerPlayerEntity killer) {
                AdvancementEntry advancement = Objects.requireNonNull(killer.getServer()).getAdvancementLoader().get(Identifier.of(Prixilium.MOD_ID, "kill_bliko"));
                killer.getAdvancementTracker().grantCriterion(advancement, "kill_bliko");
            }

            if (!this.isBaby()) {
                ServerWorld world = (ServerWorld) this.getWorld();
                for (int i = 0; i < 2; i++) {
                    BlikoEntity baby = ModEntities.BLIKO.create(world, SpawnReason.CONVERSION);
                    if (baby != null) {
                        baby.setBaby(true);
                        if (this.isTamed() && this.getOwner() != null) {
                            baby.setOwner(this.getOwner());
                            baby.setSitting(false);
                        }
                        baby.refreshPositionAndAngles(
                                this.getX(),
                                this.getY(),
                                this.getZ(),
                                world.random.nextFloat() * 360F,
                                0.0F
                        );
                        baby.setVelocity(
                                -0.1 + this.random.nextDouble() * 0.2,
                                0.1 + this.random.nextDouble() * 0.15,
                                -0.1 + this.random.nextDouble() * 0.2
                        );
                        world.spawnEntity(baby);
                    }
                }
            }
        }
    }


    //Sounds
    @Override
    protected @Nullable SoundEvent getAmbientSound() {return ModSounds.BLIKO_AMBIENT;}

    @Override
    protected @Nullable SoundEvent getHurtSound(DamageSource source) {return ModSounds.BLIKO_HURT;}

    @Override
    protected @Nullable SoundEvent getDeathSound() {return ModSounds.BLIKO_DEATH;}
}
