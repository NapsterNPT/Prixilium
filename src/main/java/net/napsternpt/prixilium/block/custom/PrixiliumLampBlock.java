package net.napsternpt.prixilium.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.IntProperty;
import net.minecraft.util.ActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class PrixiliumLampBlock extends Block {
    public static final IntProperty LIGHT = IntProperty.of("power", 0, 15);
    public static final BooleanProperty POWERED = BooleanProperty.of("powered");

    public PrixiliumLampBlock(Settings settings) {
        super(settings);
        setDefaultState(this.getDefaultState().with(LIGHT, 0).with(POWERED, false));
    }

    @Override
    protected ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
        if (!world.isClient) {
            if (!state.get(POWERED)) {
                world.setBlockState(pos, state.cycle(LIGHT));
            }
        }

        return ActionResult.SUCCESS;
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(LIGHT, POWERED);
    }

    @Override
    protected boolean hasComparatorOutput(BlockState state) {
        return true;
    }

    @Override
    protected int getComparatorOutput(BlockState state, World world, BlockPos pos) {
        return state.get(LIGHT);
    }

    @Override
    protected void neighborUpdate(BlockState state, World world, BlockPos pos, Block sourceBlock, BlockPos sourcePos, boolean notify) {
        if (!world.isClient) {
            int receivedPower = world.getReceivedRedstonePower(pos);

            if (receivedPower > 0) {
                world.setBlockState(pos, state.with(LIGHT, receivedPower).with(POWERED, true), Block.NOTIFY_ALL);
            } else {
                world.setBlockState(pos, state.with(POWERED, false), Block.NOTIFY_ALL);
            }
        }
    }
}