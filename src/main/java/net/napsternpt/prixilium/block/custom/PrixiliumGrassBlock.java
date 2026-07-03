package net.napsternpt.prixilium.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
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
    protected ActionResult onUseWithItem(ItemStack stack, BlockState state, World world,
                                         BlockPos pos, PlayerEntity player,
                                         Hand hand, BlockHitResult hit) {

        if (stack.isOf(Items.SHEARS)) {
            if (!world.isClient()) {
                world.setBlockState(pos, Blocks.GRASS_BLOCK.getDefaultState());

                ItemScatterer.spawn(
                        world,
                        pos.getX(),
                        pos.getY(),
                        pos.getZ(),
                        new ItemStack(ModBlocks.PRIXILIUM)
                );

                stack.damage(1, player, hand == Hand.MAIN_HAND ? EquipmentSlot.MAINHAND : EquipmentSlot.OFFHAND);

                world.playSound(
                        null,
                        pos,
                        SoundEvents.ENTITY_SHEEP_SHEAR,
                        SoundCategory.BLOCKS,
                        1.0F,
                        1.0F
                );
            }
            return ActionResult.SUCCESS;
        }

        return super.onUseWithItem(stack, state, world, pos, player, hand, hit);
    }

    @Override
    protected boolean hasRandomTicks(BlockState state) {
        return true;
    }

    @Override
    protected void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        if (!canSurvive(world, pos)) {
            world.setBlockState(pos, Blocks.DIRT.getDefaultState());
            return;
        }

        new PrixiliumExpandMethod(world, pos);
    }

    private boolean canSurvive(WorldView world, BlockPos pos) {
        BlockPos abovePos = pos.up();
        BlockState aboveState = world.getBlockState(abovePos);
        return !aboveState.isOpaqueFullCube() ||
                aboveState.isOf(Blocks.WATER) ||
                aboveState.isOf(Blocks.BUBBLE_COLUMN) ||
                aboveState.getFluidState().isOf(net.minecraft.fluid.Fluids.WATER) ||
                aboveState.isOf(Blocks.LAVA);
    }
}