package net.napsternpt.prixilium.block.custom;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.napsternpt.prixilium.block.entity.custom.ObeliskOfCharmsBlockEntity;
import org.jspecify.annotations.Nullable;

public class ObeliskOfCharmsBlock extends BlockWithEntity implements BlockEntityProvider {
    public static final MapCodec<ObeliskOfCharmsBlock> CODEC = ObeliskOfCharmsBlock.createCodec(ObeliskOfCharmsBlock::new);
    private static final VoxelShape SHAPE = Block.createCuboidShape(1.0, 0.0, 1.0, 15.0, 13.0, 15.0);

    public ObeliskOfCharmsBlock(Settings settings) {
        super(settings);
    }

    @Override
    protected VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }

    @Override
    protected MapCodec<? extends BlockWithEntity> getCodec() {
        return CODEC;
    }

    @Override
    public @Nullable BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new ObeliskOfCharmsBlockEntity(pos, state);
    }

    @Override
    protected BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }
}
