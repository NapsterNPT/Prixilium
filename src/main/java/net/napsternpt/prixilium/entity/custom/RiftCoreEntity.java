package net.napsternpt.prixilium.entity.custom;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.world.World;

public class RiftCoreEntity extends HostileEntity {
    public RiftCoreEntity(EntityType<? extends HostileEntity> entityType, World world) {
        super(entityType, world);
    }
}
