package net.napsternpt.prixilium.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;

public class VirusReactorBlock extends Block {
    private static final VoxelShape BOTTOM = Block.createCuboidShape(1.0, 0.0, 1.0, 15.0, 2.0, 15.0);
    private static final VoxelShape TOP = Block.createCuboidShape(6.0, 2.0, 6.0, 10.0, 9.0, 10.0);
    private static final VoxelShape MIDDLE = Block.createCuboidShape(2.0, 9.0, 2.0, 14.0, 21.0, 14.0);
    private static final VoxelShape SHAPE = VoxelShapes.union(BOTTOM, MIDDLE, TOP);

    @Override
    protected VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }

    public VirusReactorBlock(Settings settings) {
        super(settings);
    }
}
