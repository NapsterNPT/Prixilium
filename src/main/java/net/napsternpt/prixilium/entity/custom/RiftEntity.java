package net.napsternpt.prixilium.entity.custom;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.world.World;

public class RiftEntity extends HostileEntity {
    public RiftEntity(EntityType<? extends HostileEntity> entityType, World world) {
        super(entityType, world);
    }
}
