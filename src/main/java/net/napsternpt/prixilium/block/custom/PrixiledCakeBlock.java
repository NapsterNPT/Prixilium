package net.napsternpt.prixilium.block.custom;

import net.minecraft.block.BlockState;
import net.minecraft.block.CakeBlock;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.napsternpt.prixilium.effect.ModEffects;

public class PrixiledCakeBlock extends CakeBlock {
    public PrixiledCakeBlock(Settings settings) {
        super(settings);
    }

    @Override
    protected ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
        ActionResult result = CakeBlock.tryEat(world, pos, state, player);
        if (result.isAccepted() && !world.isClient()) {
            player.addStatusEffect(new StatusEffectInstance(ModEffects.PRIXILIUM_IMMUNITY, 200, 0));
        }
        return result;
    }
}
