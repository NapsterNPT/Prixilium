package net.napsternpt.prixilium.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;

public class ReactorCoreBlock extends Block {
    private static final VoxelShape SHAPE = Block.createCuboidShape(2.0, 2.0, 2.0, 14.0, 14.0, 14.0);

    @Override
    protected VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }

    public ReactorCoreBlock(Settings settings) {
        super(settings);
    }
}
