package net.napsternpt.prixilium.block.custom.woodSet;

import net.minecraft.block.BlockState;
import net.minecraft.block.PillarBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import net.napsternpt.prixilium.block.ModBlocks;
import net.napsternpt.prixilium.block.custom.BurnableBlock;
import net.napsternpt.prixilium.block.custom.PrixiliumExpandMethod;

public class PrixiliumLogBlock extends PillarBlock {
    public PrixiliumLogBlock(Settings settings) {
        super(settings);
    }

    @Override
    protected boolean hasRandomTicks(BlockState state) {
        return true;
    }

    @Override
    protected void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        new PrixiliumExpandMethod(world, pos);
    }

    @Override
    protected ActionResult onUseWithItem(ItemStack stack, BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        return BurnableBlock.convert(stack, state, world, pos, player, hand, ModBlocks.BURNED_PRIXILIUM_LOG);
    }
}