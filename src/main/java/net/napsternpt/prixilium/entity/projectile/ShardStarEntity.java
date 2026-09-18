package net.napsternpt.prixilium.entity.projectile;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.FlyingItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.world.World;
import net.napsternpt.prixilium.entity.ModEntities;
import net.napsternpt.prixilium.item.ModItems;

public class ShardStarEntity extends PersistentProjectileEntity implements FlyingItemEntity {
    private static final float MIN_DAMAGE = 1.0F;
    private static final float FULL_DAMAGE = 4.5F;
    private final float yawOffset = -30.0F + this.random.nextFloat() * 60.0F;
    private float spin = 0.0F;

    public float getYawOffset() {
        return yawOffset;
    }

    public float getSpin() {
        if (isStuck()) return spin;
        spin += 10.0F;
        if (spin >= 360) spin = 0;
        return spin;
    }

    public boolean isStuck() {
        return this.isInGround();
    }

    public ShardStarEntity(EntityType<? extends PersistentProjectileEntity> entityType, World world) {
        super(entityType, world);
    }

    public ShardStarEntity(World world, PlayerEntity owner, float power) {
        super(ModEntities.SHARD_STAR, owner, world, new ItemStack(ModItems.SHARD_STAR), null);

        this.setDamage(MIN_DAMAGE + power * (FULL_DAMAGE - MIN_DAMAGE));
        this.setCritical(power >= 1.0F);
        if (owner.isCreative()) this.pickupType = PickupPermission.DISALLOWED;
        else this.pickupType = PickupPermission.ALLOWED;
        this.setVelocity(owner, owner.getPitch(), owner.getYaw(), 0.0F,
                1F + power * (3F - 1F),
                1.0F - power * 0.5F);
    }

    @Override
    protected ItemStack getDefaultItemStack() {
        return new ItemStack(ModItems.SHARD_STAR);
    }

    @Override
    public ItemStack getStack() {
        return this.getItemStack();
    }

    @Override
    protected boolean canHit(Entity entity) {
        return entity != this.getOwner() && super.canHit(entity);
    }

    @Override
    protected void onEntityHit(EntityHitResult hitResult) {
        super.onEntityHit(hitResult);
        this.discard();
    }
}
