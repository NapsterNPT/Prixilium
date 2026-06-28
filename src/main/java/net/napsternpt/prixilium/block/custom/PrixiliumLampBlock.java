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
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import net.minecraft.world.block.WireOrientation;

public class PrixiliumLampBlock extends Block {
    public static final IntProperty LIGHT = IntProperty.of("power", 0, 15);
    public static final BooleanProperty POWERED = BooleanProperty.of("powered");

    public PrixiliumLampBlock(Settings settings) {
        super(settings);
        setDefaultState(getDefaultState().with(LIGHT, 0).with(POWERED, false));
    }

    @Override
    protected ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
        if (!world.isClient() && !state.get(POWERED)) {
            world.setBlockState(pos, state.cycle(LIGHT));
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
    protected int getComparatorOutput(BlockState state, World world, BlockPos pos, Direction direction) {
        return state.get(LIGHT);
    }

    @Override
    protected void neighborUpdate(BlockState state, World world, BlockPos pos, Block sourceBlock, WireOrientation orientation, boolean notify) {
        if (!world.isClient()) {
            int receivedPower = world.getReceivedRedstonePower(pos);

            if (receivedPower > 0) {
                world.setBlockState(pos, state.with(LIGHT, receivedPower).with(POWERED, true), Block.NOTIFY_ALL);
            } else {
                world.setBlockState(pos, state.with(POWERED, false), Block.NOTIFY_ALL);
            }
        }
    }
}