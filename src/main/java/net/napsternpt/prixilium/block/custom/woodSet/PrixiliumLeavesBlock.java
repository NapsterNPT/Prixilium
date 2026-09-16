package net.napsternpt.prixilium.block.custom.woodSet;

import net.minecraft.block.BlockState;
import net.minecraft.block.MultifaceBlock;
import net.minecraft.block.UntintedParticleLeavesBlock;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.napsternpt.prixilium.block.ModBlocks;
import net.napsternpt.prixilium.block.custom.PrixiliumExpandMethod;
import net.napsternpt.prixilium.util.ModGameRules;

public class PrixiliumLeavesBlock extends UntintedParticleLeavesBlock {

    public PrixiliumLeavesBlock(float leafParticleChance, ParticleEffect leafParticleEffect, Settings settings) {
        super(leafParticleChance, leafParticleEffect, settings);
    }

    @Override
    protected boolean hasRandomTicks(BlockState state) {
        return true;
    }

    @Override
    protected void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        super.randomTick(state, world, pos, random);
        new PrixiliumExpandMethod(world, pos);

        if (!world.getGameRules().getValue(ModGameRules.PRIXILIUM_EXPANDS)) {
            return;
        }

        Direction[] directions = Direction.values();
        for (int i = 0; i < directions.length; i++) {
            Direction direction = directions[random.nextInt(directions.length)];
            BlockPos resinPos = pos.offset(direction);
            BlockState existing = world.getBlockState(resinPos);
            if (!existing.isAir() && !existing.isOf(ModBlocks.PRIXILIUM_RESIN)) {
                continue;
            }
            BlockState grown = ((MultifaceBlock) ModBlocks.PRIXILIUM_RESIN).withDirection(
                    existing.isOf(ModBlocks.PRIXILIUM_RESIN) ? existing : ModBlocks.PRIXILIUM_RESIN.getDefaultState(),
                    world, resinPos, direction.getOpposite());
            if (grown != null) {
                world.setBlockState(resinPos, grown);
                break;
            }
        }
    }
}