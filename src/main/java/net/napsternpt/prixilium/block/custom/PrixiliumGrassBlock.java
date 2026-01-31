package net.napsternpt.prixilium.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ItemActionResult;
import net.minecraft.util.ItemScatterer;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;
import net.napsternpt.prixilium.block.ModBlocks;

public class PrixiliumGrassBlock extends Block {
    public PrixiliumGrassBlock(Settings settings) {
        super(settings);
    }

    @Override
    protected ItemActionResult onUseWithItem(ItemStack stack, BlockState state, World world,
                                             BlockPos pos, PlayerEntity player,
                                             net.minecraft.util.Hand hand, BlockHitResult hit) {

        if (stack.isOf(Items.SHEARS)) {
            if (!world.isClient) {
                world.setBlockState(pos, Blocks.GRASS_BLOCK.getDefaultState());

                ItemScatterer.spawn(
                        world,
                        pos.getX(),
                        pos.getY(),
                        pos.getZ(),
                        new ItemStack(ModBlocks.PRIXILIUM)
                );

                stack.damage(1, player, LivingEntity.getSlotForHand(hand));

                world.playSound(
                        null,
                        pos,
                        SoundEvents.ENTITY_SHEEP_SHEAR,
                        SoundCategory.BLOCKS,
                        1.0F,
                        1.0F
                );
            }

            return ItemActionResult.success(world.isClient);
        }

        return super.onUseWithItem(stack, state, world, pos, player, hand, hit);
    }

    @Override
    protected boolean hasRandomTicks(BlockState state) {
        return true;
    }

    @Override
    protected void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        if (!canSurvive(state, world, pos)) {
            world.setBlockState(pos, Blocks.DIRT.getDefaultState());
            return;
        }

        for (int i = 0; i < 64; ++i) {
            BlockPos targetPos = pos.add(
                    random.nextInt(3) - 1,
                    random.nextInt(5) - 3,
                    random.nextInt(3) - 1
            );

            BlockState targetState = world.getBlockState(targetPos);

            if (canSpreadTo(targetState) && canSurvive(state, world, targetPos)) {
                world.setBlockState(targetPos, this.getDefaultState());
            }

            if (canSpreadToBecomePrixilium(targetState)) {
                world.setBlockState(targetPos, ModBlocks.PRIXILIUM.getDefaultState());
            }

            if (canSpreadToBecomePrixiliumLog(targetState)) {
                BlockState newState = ModBlocks.PRIXILIUM_LOGS.getDefaultState();
                if (targetState.contains(net.minecraft.block.PillarBlock.AXIS)) {
                    newState = newState.with(net.minecraft.block.PillarBlock.AXIS,
                            targetState.get(net.minecraft.block.PillarBlock.AXIS));
                }
                world.setBlockState(targetPos, newState);
            }
        }
    }

    private boolean canSpreadTo(BlockState state) {
        return state.isOf(Blocks.DIRT) ||
                state.isOf(Blocks.GRASS_BLOCK) ||
                state.isOf(Blocks.PODZOL) ||
                state.isOf(Blocks.MYCELIUM) ||
                state.isOf(Blocks.COARSE_DIRT);
    }

    private boolean canSpreadToBecomePrixilium(BlockState state) {
        return state.isOf(Blocks.SHORT_GRASS) ||
                state.isOf(Blocks.FERN) ||
                state.isOf(Blocks.DEAD_BUSH) ||
                state.isOf(Blocks.TALL_SEAGRASS) ||
                state.isOf(Blocks.DANDELION) ||
                state.isOf(Blocks.TORCHFLOWER) ||
                state.isOf(Blocks.POPPY) ||
                state.isOf(Blocks.BLUE_ORCHID) ||
                state.isOf(Blocks.ALLIUM) ||
                state.isOf(Blocks.RED_TULIP) ||
                state.isOf(Blocks.ORANGE_TULIP) ||
                state.isOf(Blocks.WHITE_TULIP) ||
                state.isOf(Blocks.PINK_TULIP) ||
                state.isOf(Blocks.OXEYE_DAISY) ||
                state.isOf(Blocks.CORNFLOWER) ||
                state.isOf(Blocks.LILY_OF_THE_VALLEY);
    }

    private boolean canSpreadToBecomePrixiliumLog(BlockState state) {
        return state.isOf(Blocks.OAK_LOG) ||
                state.isOf(Blocks.SPRUCE_LOG) ||
                state.isOf(Blocks.BIRCH_LOG) ||
                state.isOf(Blocks.JUNGLE_LOG) ||
                state.isOf(Blocks.ACACIA_LOG) ||
                state.isOf(Blocks.DARK_OAK_LOG) ||
                state.isOf(Blocks.MANGROVE_LOG) ||
                state.isOf(Blocks.CHERRY_LOG) ||
                state.isOf(Blocks.CRIMSON_STEM) ||
                state.isOf(Blocks.WARPED_STEM) ||
                state.isOf(Blocks.STRIPPED_OAK_LOG) ||
                state.isOf(Blocks.STRIPPED_SPRUCE_LOG) ||
                state.isOf(Blocks.STRIPPED_BIRCH_LOG) ||
                state.isOf(Blocks.STRIPPED_JUNGLE_LOG) ||
                state.isOf(Blocks.STRIPPED_ACACIA_LOG) ||
                state.isOf(Blocks.STRIPPED_DARK_OAK_LOG) ||
                state.isOf(Blocks.STRIPPED_MANGROVE_LOG) ||
                state.isOf(Blocks.STRIPPED_CHERRY_LOG) ||
                state.isOf(Blocks.STRIPPED_CRIMSON_STEM) ||
                state.isOf(Blocks.STRIPPED_WARPED_STEM);
    }

    private boolean canSurvive(BlockState state, WorldView world, BlockPos pos) {
        BlockPos abovePos = pos.up();
        BlockState aboveState = world.getBlockState(abovePos);
        return !aboveState.isOpaqueFullCube(world, abovePos);
    }
}