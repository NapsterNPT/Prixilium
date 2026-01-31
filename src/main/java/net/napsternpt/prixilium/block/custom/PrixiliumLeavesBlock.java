package net.napsternpt.prixilium.block.custom;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.LeavesBlock;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;

public class PrixiliumLeavesBlock extends LeavesBlock {
    public PrixiliumLeavesBlock(Settings settings) {
        super(settings);
    }

    @Override
    protected boolean hasRandomTicks(BlockState state) {
        return true;
    }

    @Override
    protected void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        super.randomTick(state, world, pos, random);

        if (!state.get(PERSISTENT) && state.get(DISTANCE) >= 7) {
            return;
        }

        for (int i = 0; i < 64; ++i) {
            BlockPos targetPos = pos.add(
                    random.nextInt(3) - 1,
                    random.nextInt(5) - 3,
                    random.nextInt(3) - 1
            );

            BlockState targetState = world.getBlockState(targetPos);

            if (canSpreadTo(targetState)) {
                BlockState newState = this.getDefaultState();
                if (targetState.contains(PERSISTENT)) {
                    newState = newState.with(PERSISTENT, targetState.get(PERSISTENT));
                }
                if (targetState.contains(DISTANCE)) {
                    newState = newState.with(DISTANCE, targetState.get(DISTANCE));
                }
                world.setBlockState(targetPos, newState);
            }
        }
    }

    private boolean canSpreadTo(BlockState state) {
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