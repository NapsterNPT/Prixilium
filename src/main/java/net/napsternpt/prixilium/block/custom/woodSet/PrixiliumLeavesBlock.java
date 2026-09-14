package net.napsternpt.prixilium.block.custom.woodSet;

import net.minecraft.block.BlockState;
import net.minecraft.block.UntintedParticleLeavesBlock;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Property;
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
        if (world.getGameRules().getValue(ModGameRules.PRIXILIUM_EXPANDS)) {
            Direction[] directions = Direction.values();
            for (int i = 0; i < directions.length; i++) {
                Direction direction = directions[random.nextInt(directions.length)];
                BlockPos resinPos = pos.offset(direction);
                if (!world.getBlockState(resinPos).isAir()) {
                    continue;
                }
                BooleanProperty face = null;
                for (Property<?> property : ModBlocks.PRIXILIUM_RESIN.getDefaultState().getProperties()) {
                    if (property.getName().equals(direction.getOpposite().asString())) {
                        face = (BooleanProperty) property;
                        break;
                    }
                }
                if (face != null) {
                    world.setBlockState(resinPos, ModBlocks.PRIXILIUM_RESIN.getDefaultState().with(face, true));
                    break;
                }
            }
        }
    }
}