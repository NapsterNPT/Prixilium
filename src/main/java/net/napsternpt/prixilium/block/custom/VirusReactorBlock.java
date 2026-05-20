package net.napsternpt.prixilium.block.custom;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.napsternpt.prixilium.block.ModBlocks;
import net.napsternpt.prixilium.block.entity.custom.VirusReactorBlockEntity;
import net.napsternpt.prixilium.item.ModItems;
import net.napsternpt.prixilium.util.ModTags;
import org.jetbrains.annotations.Nullable;

public class VirusReactorBlock extends BlockWithEntity implements BlockEntityProvider {
    private static final VoxelShape BOTTOM = Block.createCuboidShape(1.0, 0.0, 1.0, 15.0, 2.0, 15.0);
    private static final VoxelShape MIDDLE = Block.createCuboidShape(6.0, 2.0, 6.0, 10.0, 9.0, 10.0);
    private static final VoxelShape TOP = Block.createCuboidShape(2.0, 9.0, 2.0, 14.0, 21.0, 14.0);
    private static final VoxelShape SHAPE = VoxelShapes.union(BOTTOM, MIDDLE, TOP);
    public static final MapCodec<VirusReactorBlock> CODEC = VirusReactorBlock.createCodec(VirusReactorBlock::new);

    public VirusReactorBlock(Settings settings) {
        super(settings);
    }

    @Override
    protected VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }

    @Override
    protected MapCodec<? extends BlockWithEntity> getCodec() {
        return CODEC;
    }

    @Override
    public @Nullable BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new VirusReactorBlockEntity(pos, state);
    }

    @Override
    protected BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }

    @Override
    protected ActionResult onUseWithItem(ItemStack stack, BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if(world.getBlockEntity(pos) instanceof VirusReactorBlockEntity virusReactorEntity) {
            if(virusReactorEntity.isEmpty() && !stack.isEmpty()) {
                virusReactorEntity.setStack(0, stack.copyWithCount(1));
                world.playSound(player, pos, SoundEvents.ENTITY_ITEM_PICKUP, SoundCategory.BLOCKS, 1f, 2f);
                stack.decrement(1);

                virusReactorEntity.markDirty();
                world.updateListeners(pos, state, state, 0);

                if (virusReactorEntity.getStack(0).isOf(ModItems.VIRUS_ALIVE)) {
                    BlockPos center = pos.down();

                    for (int x = -2; x <= 2; x++) {
                        for (int z = -2; z <= 2; z++) {
                            if (x * x + z * z <= 2 * 2) {
                                BlockPos targetPos = center.add(x, 0, z);
                                BlockState targetState = world.getBlockState(targetPos);

                                if (targetState.isIn(ModTags.Blocks.PRIXILIUM_GRASS_CONVERTIBLE)) {
                                    world.setBlockState(targetPos, ModBlocks.PRIXILIUM_GRASS.getDefaultState());
                                }
                            }
                        }
                    }
                }

            } else if(stack.isEmpty() && !player.isSneaking() && !virusReactorEntity.isEmpty()) {
                ItemStack stackOnVirusReactor = virusReactorEntity.getStack(0);
                player.setStackInHand(Hand.MAIN_HAND, stackOnVirusReactor);
                world.playSound(player, pos, SoundEvents.ENTITY_ITEM_PICKUP, SoundCategory.BLOCKS, 1f, 1f);
                virusReactorEntity.clear();

                virusReactorEntity.markDirty();
                world.updateListeners(pos, state, state, 0);
            }
            return ActionResult.SUCCESS;
        }
        return ActionResult.FAIL;
    }
}
