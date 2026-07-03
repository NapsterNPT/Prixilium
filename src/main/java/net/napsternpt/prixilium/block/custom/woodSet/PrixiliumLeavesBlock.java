package net.napsternpt.prixilium.block.custom.woodSet;

import net.minecraft.block.BlockState;
import net.minecraft.block.UntintedParticleLeavesBlock;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.napsternpt.prixilium.block.custom.PrixiliumExpandMethod;

public class PrixiliumLeavesBlock extends UntintedParticleLeavesBlock {

    public PrixiliumLeavesBlock(float leafParticleChance, ParticleEffect leafParticleEffect, Settings settings) {
        super(leafParticleChance, leafParticleEffect, settings);
    }

    @Override
    protected boolean hasRandomTicks(BlockState state) {
        return true;
    }

    @Override
    public void scheduledTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
    }

    @Override
    protected void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        new PrixiliumExpandMethod(world, pos);
    }
}