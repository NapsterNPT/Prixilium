package net.napsternpt.prixilium.block.custom.woodSet;

import net.minecraft.block.BlockState;
import net.minecraft.block.StairsBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.napsternpt.prixilium.block.ModBlocks;
import net.napsternpt.prixilium.block.custom.BurnableBlock;

public class PrixiliumStairsBlock extends StairsBlock {
    public PrixiliumStairsBlock(BlockState baseBlockState, Settings settings) {
        super(baseBlockState, settings);
    }

    @Override
    protected ActionResult onUseWithItem(ItemStack stack, BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        return BurnableBlock.convert(stack, state, world, pos, player, hand, ModBlocks.BURNED_PRIXILIUM_STAIRS, () -> super.onUse(state, world, pos, player, hit));
    }
}
