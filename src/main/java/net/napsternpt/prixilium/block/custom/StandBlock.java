package net.napsternpt.prixilium.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;

public class StandBlock extends Block {
    private static final VoxelShape BOTTOM = Block.createCuboidShape(1.0, 0.0, 1.0, 15.0, 2.0, 15.0);
    private static final VoxelShape TOP = Block.createCuboidShape(6.0, 2.0, 6.0, 10.0, 9.0, 10.0);
    private static final VoxelShape SHAPE = VoxelShapes.union(BOTTOM, TOP);

    @Override
    protected VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }

    public StandBlock(Settings settings) {
        super(settings);
    }
}
