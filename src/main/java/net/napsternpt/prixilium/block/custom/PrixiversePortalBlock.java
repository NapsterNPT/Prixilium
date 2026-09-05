package net.napsternpt.prixilium.block.custom;

import com.mojang.serialization.MapCodec;
import net.minecraft.advancement.AdvancementEntry;
import net.minecraft.block.*;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCollisionHandler;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;
import net.minecraft.world.tick.ScheduledTickView;
import net.napsternpt.prixilium.Prixilium;
import net.napsternpt.prixilium.block.ModBlocks;
import net.napsternpt.prixilium.datagen.ModWorldGen;
import net.napsternpt.prixilium.network.ModPackets;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

public class PrixiversePortalBlock extends Block {
    private static final VoxelShape SHAPE = Block.createCuboidShape(0.0, 6.0, 0.0, 16.0, 12.0, 16.0);
    public static final MapCodec<PrixiversePortalBlock> CODEC = createCodec(PrixiversePortalBlock::new);

    public static final BooleanProperty NORTH = BooleanProperty.of("north");
    public static final BooleanProperty EAST = BooleanProperty.of("east");
    public static final BooleanProperty SOUTH = BooleanProperty.of("south");
    public static final BooleanProperty WEST = BooleanProperty.of("west");
    private static final Set<UUID> VIEWING_PLAYERS = new HashSet<>();

    public PrixiversePortalBlock(Settings settings) {
        super(settings);
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(NORTH, EAST, SOUTH, WEST);
    }

    @Override
    protected VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }

    @Override
    protected MapCodec<? extends Block> getCodec() {
        return CODEC;
    }

    @Override
    protected BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        World world = ctx.getWorld();
        BlockPos pos = ctx.getBlockPos();

        return getDefaultState()
                .with(NORTH, world.getBlockState(pos.north()).isOf(ModBlocks.PRIXIVERSE_PORTAL))
                .with(EAST, world.getBlockState(pos.east()).isOf(ModBlocks.PRIXIVERSE_PORTAL))
                .with(SOUTH, world.getBlockState(pos.south()).isOf(ModBlocks.PRIXIVERSE_PORTAL))
                .with(WEST, world.getBlockState(pos.west()).isOf(ModBlocks.PRIXIVERSE_PORTAL));
    }

    @Override
    protected BlockState getStateForNeighborUpdate(BlockState state, WorldView world, ScheduledTickView tickView, BlockPos pos, Direction direction, BlockPos neighborPos, BlockState neighborState, Random random) {
        if (direction.getAxis() == Direction.Axis.Y) {
            return state;
        }

        BooleanProperty property = switch (direction) {
            case NORTH -> NORTH;
            case EAST -> EAST;
            case SOUTH -> SOUTH;
            case WEST -> WEST;
            default -> null;
        };
        return property == null ? state : state.with(property, neighborState.isOf(ModBlocks.PRIXIVERSE_PORTAL));
    }


    @Override
    protected void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity, EntityCollisionHandler handler, boolean bl) {
        if (!world.isClient() && entity instanceof ServerPlayerEntity player) {
            if (player.getEntityWorld().getRegistryKey().equals(ModWorldGen.PRIXILIUM_WORLD)) {
                UUID uuid = player.getUuid();
                if (VIEWING_PLAYERS.contains(uuid)) return;
                VIEWING_PLAYERS.add(uuid);
                ModPackets.sendShowCredits(player);
                AdvancementEntry advancement = Objects.requireNonNull(world.getServer()).getAdvancementLoader().get(Identifier.of(Prixilium.MOD_ID, "the_end"));
                player.getAdvancementTracker().grantCriterion(advancement, "the_end");
                Prixilium.LOGGER.info(Text.translatable("thank_you").getString());
            }
        }

        super.onEntityCollision(state, world, pos, entity, handler, bl);
    }

    public static void markCreditsFinished(ServerPlayerEntity player) {
        VIEWING_PLAYERS.remove(player.getUuid());
    }
}
