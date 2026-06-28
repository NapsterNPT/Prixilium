package net.napsternpt.prixilium.block.custom;

import net.minecraft.block.BlockState;
import net.minecraft.block.SaplingBlock;
import net.minecraft.block.SaplingGenerator;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCollisionHandler;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import net.napsternpt.prixilium.effect.ModEffects;
import net.napsternpt.prixilium.particle.ModParticles;
import net.napsternpt.prixilium.util.ModTags;

public class PrixiliumBlock extends SaplingBlock {
    public PrixiliumBlock(SaplingGenerator generator, Settings settings) {
        super(generator, settings);
    }

    @Override
    protected void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity, EntityCollisionHandler handler, boolean bl) {
        if (!world.isClient() && entity instanceof LivingEntity livingEntity) {
            if (!hasProtectionItem(livingEntity) && !livingEntity.getType().isIn(ModTags.Entities.IMMUNE_TO_PRIXILIUM_SLOWNESS)) {
                    livingEntity.addStatusEffect(new StatusEffectInstance(ModEffects.PRIXILIUM_SLOWNESS, 40, 0));
            }
        }
        super.onEntityCollision(state, world, pos, entity, handler, bl);
    }

    private boolean hasProtectionItem(LivingEntity entity) {
        for (EquipmentSlot slot : new EquipmentSlot[]{EquipmentSlot.HEAD, EquipmentSlot.CHEST, EquipmentSlot.LEGS, EquipmentSlot.FEET}) {
            if (entity.getEquippedStack(slot).isIn(ModTags.Items.PREVENT_PRIXILIUM_SLOWNESS)) return true;
        }
        return false;
    }

    @Override
    public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {
        if (random.nextInt(5) == 0) {
            double x = pos.getX() + random.nextDouble();
            double y = pos.getY() + random.nextDouble();
            double z = pos.getZ() + random.nextDouble();

            world.addParticleClient(ModParticles.PRIXILIUM_AMBIENT, x, y, z, 0, 0.1, 0);
        }
    }
}