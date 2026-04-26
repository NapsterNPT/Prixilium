package net.napsternpt.prixilium.entity.projectile;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.napsternpt.prixilium.entity.ModEntities;
import net.napsternpt.prixilium.item.ModItems;
import org.jetbrains.annotations.Nullable;

public class PrixiliumHookEntity extends ProjectileEntity {
    private static final double SPEED = 5.0;
    private static final double MAX_RANGE_BLOCKS = 64.0;
    private static final double MAX_DISTANCE_SQ = MAX_RANGE_BLOCKS * MAX_RANGE_BLOCKS;
    private static final double MAX_TRAVEL_DISTANCE = 64.0;
    private static final double PULL_FORCE = 0.15;
    private static final double MIN_DISTANCE = 1.5;

    private double traveledDistance = 0.0;

    private static final TrackedData<Boolean> IN_BLOCK;
    private static final TrackedData<Float> LENGTH;

    static {
        IN_BLOCK = DataTracker.registerData(PrixiliumHookEntity.class, TrackedDataHandlerRegistry.BOOLEAN);
        LENGTH = DataTracker.registerData(PrixiliumHookEntity.class, TrackedDataHandlerRegistry.FLOAT);
    }

    public PrixiliumHookEntity(EntityType<? extends PrixiliumHookEntity> type, World world) {
        super(type, world);
    }

    public PrixiliumHookEntity(World world, PlayerEntity owner) {
        this(ModEntities.PRIXILIUM_HOOK, world);
        this.setOwner(owner);
        
        Vec3d spawnPos = new Vec3d(owner.getX(), owner.getEyeY() - 0.1, owner.getZ());
        this.setPosition(spawnPos);
        
        Vec3d direction = owner.getRotationVector();
        this.setVelocity(direction.multiply(SPEED));
    }

    @Override
    protected void initDataTracker(DataTracker.Builder builder) {
        builder.add(IN_BLOCK, false);
        builder.add(LENGTH, 0.0f);
    }

    @Override
    public boolean shouldRender(double distance) {
        return true;
    }

    private void spawnClientParticles() {
        PlayerEntity owner = this.getPlayerOwner();
        if (owner == null || !this.getWorld().isClient()) return;
        
        net.minecraft.util.math.Vec3d hookPos = this.getPos();
        net.minecraft.util.math.Vec3d playerPos = owner.getEyePos();
        
        net.minecraft.util.math.Vec3d diff = playerPos.subtract(hookPos);
        double dist = diff.length();
        if (dist < 1.0) return;
        
        net.minecraft.world.World world = this.getWorld();
        
        int count = Math.min((int)(dist * 3.0), 100);
        for (int i = 0; i < count; i++) {
            double t = (double) i / count;
            double baseX = hookPos.x + diff.x * t;
            double baseY = hookPos.y + diff.y * t;
            double baseZ = hookPos.z + diff.z * t;
            
            for (int j = 0; j < 3; j++) {
                double x = baseX + (Math.random() - 0.5) * 0.15;
                double y = baseY + (Math.random() - 0.5) * 0.15;
                double z = baseZ + (Math.random() - 0.5) * 0.15;
                world.addParticleClient(ParticleTypes.WAX_ON, x, y, z, 0, 0, 0);
            }
        }
    }

    @Override
    public void tick() {
        super.tick();
        
        if (this.getWorld().isClient()) {
            this.spawnClientParticles();
        }
        
        PlayerEntity owner = this.getPlayerOwner();
        if (owner == null) {
            this.discard();
            return;
        }
        
        if (!this.getWorld().isClient()) {
            double distFromPlayer = this.squaredDistanceTo(owner);
            if (distFromPlayer > MAX_DISTANCE_SQ) {
                owner.getWorld().playSound(null, owner.getX(), owner.getY(), owner.getZ(),
                        net.minecraft.sound.SoundEvents.ITEM_CROSSBOW_LOADING_END,
                        net.minecraft.sound.SoundCategory.PLAYERS, 0.5f, 1.2f);
                net.napsternpt.prixilium.item.custom.PrixiliumHookItem.clearHook(owner);
                this.discard();
                return;
            }
            
            Vec3d pos = this.getPos();
            Vec3d vel = this.getVelocity();
            
            if (vel.length() > 0.01) {
                Vec3d nextPos = pos.add(vel);
                
                var raycast = this.getWorld().raycast(new net.minecraft.world.RaycastContext(
                    pos, nextPos,
                    net.minecraft.world.RaycastContext.ShapeType.COLLIDER,
                    net.minecraft.world.RaycastContext.FluidHandling.NONE,
                    this
                ));
                
                if (raycast.getType() != HitResult.Type.MISS) {
                    this.setPosition(raycast.getPos());
                    this.setVelocity(Vec3d.ZERO);
                    this.setInBlock(true);
                    double distance = owner.getEyePos().distanceTo(raycast.getPos());
                    this.setHookLength(Math.max((float) distance * 0.5f - 3.0f, 1.5f));
                } else {
                    this.setPosition(nextPos);
                    traveledDistance += vel.length();
                }
                
                this.velocityDirty = true;
            }
            
            if (this.inBlock()) {
                Vec3d playerPos = owner.getPos().add(0, owner.getHeight() / 2, 0);
                Vec3d hookPos = this.getPos();
                double distance = playerPos.distanceTo(hookPos);
                
                if (distance > MIN_DISTANCE) {
                    Vec3d direction = hookPos.subtract(playerPos).normalize();
                    double forceFactor = Math.min(distance / 10.0, 2.0);
                    Vec3d pullForce = direction.multiply(PULL_FORCE * forceFactor);
                    
                    Vec3d currentVelocity = owner.getVelocity();
                    Vec3d newVelocity = currentVelocity.add(pullForce);
                    
                    double maxSpeed = 2.0;
                    if (newVelocity.length() > maxSpeed) {
                        newVelocity = newVelocity.normalize().multiply(maxSpeed);
                    }
                    
                    owner.setVelocity(newVelocity);
                    owner.velocityModified = true;
                    owner.fallDistance = 0;
                } else {
                    owner.setVelocity(owner.getVelocity().multiply(0.5, 0.5, 0.5));
                    owner.velocityModified = true;
                }
            }
        }

        if (!this.getWorld().isClient() && this.shouldRetract(owner)) {
            owner.getWorld().playSound(null, owner.getX(), owner.getY(), owner.getZ(),
                    net.minecraft.sound.SoundEvents.ITEM_CROSSBOW_LOADING_END,
                    net.minecraft.sound.SoundCategory.PLAYERS, 0.5f, 1.2f);
            net.napsternpt.prixilium.item.custom.PrixiliumHookItem.clearHook(owner);
            this.discard();
        }
    }

    private boolean shouldRetract(PlayerEntity player) {
        return player.isRemoved() || !player.isAlive() || !player.isHolding(ModItems.PRIXILIUM_HOOK) || this.squaredDistanceTo(player) > MAX_DISTANCE_SQ;
    }

    @Override
    public void writeCustomDataToNbt(NbtCompound nbt) {
        nbt.putBoolean("in_block", this.inBlock());
        nbt.putFloat("length", this.hookLength());
    }

    @Override
    public void readCustomDataFromNbt(NbtCompound nbt) {
        if (nbt.getBoolean("in_block").isPresent() && nbt.getFloat("length").isPresent()) {
            this.setInBlock(nbt.getBoolean("in_block").get());
            this.setHookLength(nbt.getFloat("length").get());
        }
    }

    public boolean inBlock() {
        return this.dataTracker.get(IN_BLOCK);
    }

    public void setInBlock(boolean value) {
        this.dataTracker.set(IN_BLOCK, value);
    }

    public float hookLength() {
        return this.dataTracker.get(LENGTH);
    }

    public void setHookLength(float value) {
        this.dataTracker.set(LENGTH, value);
    }

    @Override
    public void remove(RemovalReason reason) {
        this.updateOwnerInfo();
        super.remove(reason);
    }

    @Override
    public void onRemoved() {
        this.updateOwnerInfo();
    }

    private void updateOwnerInfo() {
    }

    @Nullable
    public PlayerEntity getPlayerOwner() {
        Entity owner = this.getOwner();
        return owner instanceof PlayerEntity player ? player : null;
    }

    public boolean isInBlock() {return false;}

    public float getHookLength() {return 0.0f;}
}