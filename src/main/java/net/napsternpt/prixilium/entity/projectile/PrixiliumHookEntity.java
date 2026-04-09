package net.napsternpt.prixilium.entity.projectile;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.napsternpt.prixilium.Prixilium;
import net.napsternpt.prixilium.item.ModItems;
import org.jetbrains.annotations.Nullable;

public class PrixiliumHookEntity extends ProjectileEntity {
    private static final double SPEED = 5.0;
    private static final double MAX_DISTANCE_SQ = 2500.0;
    private static final double PULL_FORCE = 0.15;
    private static final double MIN_DISTANCE = 1.5;
    private static final int MAX_LIFETIME = 200;

    private int lifetime = 0;

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
        this((EntityType<PrixiliumHookEntity>) net.napsternpt.prixilium.entity.ModEntities.PRIXILIUM_HOOK, world);
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

    @Override
    public void tick() {
        super.tick();
        
        lifetime++;
        
        PlayerEntity owner = this.getPlayerOwner();
        if (owner == null) {
            this.discard();
            return;
        }
        
        if (!this.getWorld().isClient()) {
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
                    lifetime = 0;
                } else {
                    this.setPosition(nextPos);
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

        if (!this.getWorld().isClient() && (this.shouldRetract(owner) || lifetime > MAX_LIFETIME)) {
            net.napsternpt.prixilium.item.custom.PrixiliumHookItem.clearClientHook(owner.getUuid());
            this.discard();
        }
    }

    private boolean shouldRetract(PlayerEntity player) {
        if (!player.isRemoved() && player.isAlive() && player.isHolding(ModItems.PRIXILIUM_HOOK) && !(this.squaredDistanceTo(player) > MAX_DISTANCE_SQ)) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public void writeCustomDataToNbt(NbtCompound nbt) {
        nbt.putBoolean("in_block", this.inBlock());
        nbt.putFloat("length", this.hookLength());
    }

    @Override
    public void readCustomDataFromNbt(NbtCompound nbt) {
        this.setInBlock(nbt.getBoolean("in_block"));
        this.setHookLength(nbt.getFloat("length"));
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

    public boolean isInBlock() {
        return false;
    }

    public float getHookLength() {
        return 0.0f;
    }
}