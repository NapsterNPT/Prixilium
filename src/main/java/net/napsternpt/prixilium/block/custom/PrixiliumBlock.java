package net.napsternpt.prixilium.block.custom;

import net.minecraft.block.BlockState;
import net.minecraft.block.SaplingBlock;
import net.minecraft.block.SaplingGenerator;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.napsternpt.prixilium.effect.ModEffects;
import net.napsternpt.prixilium.util.ModTags;

public class PrixiliumBlock extends SaplingBlock {
    public PrixiliumBlock(SaplingGenerator generator, Settings settings) {
        super(generator, settings);
    }

    @Override
    public void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity) {
        if (!world.isClient && entity instanceof LivingEntity livingEntity) {
            if (!hasProtectionItem(livingEntity) && !livingEntity.getType().isIn(ModTags.Entities.IMMUNE_TO_PRIXILIUM_SLOWNESS)) {
                    livingEntity.addStatusEffect(new StatusEffectInstance(ModEffects.PRIXILIUM_SLOWNESS, 40, 0));
            }
        }
        super.onEntityCollision(state, world, pos, entity);
    }

    private boolean hasProtectionItem(LivingEntity entity) {
        for (ItemStack armorStack : entity.getArmorItems()) {
            if (armorStack.isIn(ModTags.Items.PREVENT_PRIXILIUM_SLOWNESS)) {
                return true;
            }
        }
        return false;
    }
}