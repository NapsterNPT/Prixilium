package net.napsternpt.prixilium.block.custom;

import net.minecraft.advancement.AdvancementEntry;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.napsternpt.prixilium.Prixilium;
import net.napsternpt.prixilium.block.ModBlocks;
import net.napsternpt.prixilium.particle.ModParticles;
import net.napsternpt.prixilium.sound.ModSounds;
import net.napsternpt.prixilium.util.ModGameRules;
import net.napsternpt.prixilium.util.ModTags;

import static net.minecraft.block.LeavesBlock.DISTANCE;
import static net.minecraft.block.LeavesBlock.PERSISTENT;

public class PrixiliumExpandMethod {

    public PrixiliumExpandMethod(ServerWorld world, BlockPos pos) {
        if (world.getGameRules().getBoolean(ModGameRules.PRIXILIUM_EXPANDS)) {
            for (int i = 0; i < 128; ++i) {
                BlockPos targetPos = pos.add(
                        world.getRandom().nextInt(5) - 2,
                        world.getRandom().nextInt(5) - 2,
                        world.getRandom().nextInt(5) - 2
                );

                BlockState targetState = world.getBlockState(targetPos);

                // Prixilium
                if (targetState.isIn(ModTags.Blocks.PRIXILIUM_CONVERTIBLE)) {
                    world.setBlockState(targetPos, ModBlocks.PRIXILIUM.getDefaultState());
                    world.playSound(null, pos, ModSounds.PRIXILIUM_EXPAND, SoundCategory.BLOCKS);
                    world.spawnParticles(ModParticles.PRIXILIUM_EXPAND, targetPos.getX() + 0.5, targetPos.getY() + 1, targetPos.getZ() + 0.5,
                            3, 0.2, 0.2, 0.2, 0);
                    for (ServerPlayerEntity player : world.getPlayers()) {
                        AdvancementEntry advancement = world.getServer().getAdvancementLoader().get(Identifier.of(Prixilium.MOD_ID, "its_spreading"));
                        player.getAdvancementTracker().grantCriterion(advancement, "its_spreading");
                    }
                }

                // Grass
                BlockPos targetAbovePos = targetPos.up();
                BlockState targetAboveState = world.getBlockState(targetAbovePos);
                if (!targetAboveState.isOpaqueFullCube() ||
                        targetAboveState.isOf(Blocks.WATER) ||
                        targetAboveState.isOf(Blocks.BUBBLE_COLUMN) ||
                        targetAboveState.getFluidState().isOf(net.minecraft.fluid.Fluids.WATER) ||
                        targetAboveState.isOf(Blocks.LAVA)) {
                    if (targetState.isIn(ModTags.Blocks.PRIXILIUM_GRASS_CONVERTIBLE)) {
                        world.setBlockState(targetPos, ModBlocks.PRIXILIUM_GRASS.getDefaultState());
                        world.playSound(null, pos, ModSounds.PRIXILIUM_EXPAND, SoundCategory.BLOCKS);
                        world.spawnParticles(ModParticles.PRIXILIUM_EXPAND, targetPos.getX() + 0.5, targetPos.getY() + 1, targetPos.getZ() + 0.5,
                                3, 0.2, 0.2, 0.2, 0);
                    }
                }

                // Log
                if (targetState.isIn(ModTags.Blocks.PRIXILIUM_LOG_CONVERTIBLE)) {
                    BlockState newState = ModBlocks.PRIXILIUM_LOG.getDefaultState();
                    if (targetState.contains(net.minecraft.block.PillarBlock.AXIS)) {
                        newState = newState.with(net.minecraft.block.PillarBlock.AXIS,
                                targetState.get(net.minecraft.block.PillarBlock.AXIS));
                    }
                    world.setBlockState(targetPos, newState);
                    world.playSound(null, pos, ModSounds.PRIXILIUM_EXPAND, SoundCategory.BLOCKS);
                    world.spawnParticles(ModParticles.PRIXILIUM_EXPAND, targetPos.getX() + 0.5, targetPos.getY() + 1, targetPos.getZ() + 0.5,
                            3, 0.2, 0.2, 0.2, 0);
                }

                // Wood
                if (targetState.isIn(ModTags.Blocks.PRIXILIUM_WOOD_CONVERTIBLE)) {
                    world.setBlockState(targetPos, ModBlocks.PRIXILIUM_WOOD.getDefaultState());
                    world.playSound(null, pos, ModSounds.PRIXILIUM_EXPAND, SoundCategory.BLOCKS);
                    world.spawnParticles(ModParticles.PRIXILIUM_EXPAND, targetPos.getX() + 0.5, targetPos.getY() + 1, targetPos.getZ() + 0.5,
                            3, 0.2, 0.2, 0.2, 0);
                }

                // Leaves
                if (targetState.isIn(ModTags.Blocks.PRIXILIUM_LEAVES_CONVERTIBLE)) {
                    BlockState newState = ModBlocks.PRIXILIUM_LEAVES.getDefaultState();
                    if (targetState.contains(PERSISTENT))
                        newState = newState.with(PERSISTENT, targetState.get(PERSISTENT));
                    if (targetState.contains(DISTANCE)) newState = newState.with(DISTANCE, targetState.get(DISTANCE));
                    world.setBlockState(targetPos, newState);
                    world.playSound(null, pos, ModSounds.PRIXILIUM_EXPAND, SoundCategory.BLOCKS);
                    world.spawnParticles(ModParticles.PRIXILIUM_EXPAND, targetPos.getX() + 0.5, targetPos.getY() + 1, targetPos.getZ() + 0.5,
                            3, 0.2, 0.2, 0.2, 0);
                }
            }
        }
    }
}