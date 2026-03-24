package net.napsternpt.prixilium.block.custom;

import net.minecraft.block.BlockState;
import net.minecraft.block.ShortPlantBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.napsternpt.prixilium.effect.ModEffects;
import net.napsternpt.prixilium.util.ModTags;

public class PrixiliumBlock extends ShortPlantBlock {
    public PrixiliumBlock(Settings settings) {
        super(settings);
    }

    @Override
    public void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity) {
        if (!world.isClient && entity instanceof LivingEntity livingEntity) {
            if (!hasProtectionItem(livingEntity)) {
                livingEntity.addStatusEffect(
                        new net.minecraft.entity.effect.StatusEffectInstance(
                                ModEffects.PRIXILIUM_SLOWNESS,
                                40,
                                0
                        )
                );
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
