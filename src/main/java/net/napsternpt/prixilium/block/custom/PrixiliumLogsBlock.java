package net.napsternpt.prixilium.block.custom;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.PillarBlock;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.napsternpt.prixilium.block.ModBlocks;

public class PrixiliumLogsBlock extends PillarBlock {
    public PrixiliumLogsBlock(Settings settings) {
        super(settings);
    }

    @Override
    protected boolean hasRandomTicks(BlockState state) {
        return true;
    }

    @Override
    protected void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {

        for (int i = 0; i < 64; ++i) {
            BlockPos targetPos = pos.add(
                    random.nextInt(3) - 1,
                    random.nextInt(5) - 3,
                    random.nextInt(3) - 1
            );

            BlockState targetState = world.getBlockState(targetPos);

            if (canSpreadTo(targetState)) {
                BlockState newState = this.getDefaultState();
                if (targetState.contains(AXIS)) {
                    newState = newState.with(AXIS, targetState.get(AXIS));
                }
                world.setBlockState(targetPos, newState);
            }

            if (canSpreadToBecomeLeaves(targetState)) {
                world.setBlockState(targetPos, ModBlocks.PRIXILIUM_LEAVES.getDefaultState());
            }
        }
    }

    private boolean canSpreadTo(BlockState state) {
        return state.isOf(Blocks.OAK_LOG) ||
                state.isOf(Blocks.SPRUCE_LOG) ||
                state.isOf(Blocks.BIRCH_LOG) ||
                state.isOf(Blocks.JUNGLE_LOG) ||
                state.isOf(Blocks.ACACIA_LOG) ||
                state.isOf(Blocks.DARK_OAK_LOG) ||
                state.isOf(Blocks.MANGROVE_LOG) ||
                state.isOf(Blocks.CHERRY_LOG) ||
                state.isOf(Blocks.CRIMSON_STEM) ||
                state.isOf(Blocks.WARPED_STEM);
    }

    private boolean canSpreadToBecomeLeaves(BlockState state) {
        return state.isOf(Blocks.OAK_LEAVES) ||
                state.isOf(Blocks.SPRUCE_LEAVES) ||
                state.isOf(Blocks.BIRCH_LEAVES) ||
                state.isOf(Blocks.JUNGLE_LEAVES) ||
                state.isOf(Blocks.ACACIA_LEAVES) ||
                state.isOf(Blocks.DARK_OAK_LEAVES) ||
                state.isOf(Blocks.MANGROVE_LEAVES) ||
                state.isOf(Blocks.CHERRY_LEAVES) ||
                state.isOf(Blocks.AZALEA_LEAVES) ||
                state.isOf(Blocks.FLOWERING_AZALEA_LEAVES);
    }
}