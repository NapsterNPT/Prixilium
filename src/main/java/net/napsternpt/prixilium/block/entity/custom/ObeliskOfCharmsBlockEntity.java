package net.napsternpt.prixilium.block.entity.custom;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;
import net.napsternpt.prixilium.block.entity.ModBlockEntities;

public class ObeliskOfCharmsBlockEntity extends BlockEntity {
    public ObeliskOfCharmsBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.OBELISK_OF_CHARMS_BE, pos, state);
    }
}
