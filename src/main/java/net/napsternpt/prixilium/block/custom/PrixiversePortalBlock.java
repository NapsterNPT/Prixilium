package net.napsternpt.prixilium.block.custom;

import com.mojang.serialization.MapCodec;
import net.minecraft.advancement.AdvancementEntry;
import net.minecraft.block.*;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCollisionHandler;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.napsternpt.prixilium.Prixilium;
import net.napsternpt.prixilium.datagen.ModWorldGen;
import net.napsternpt.prixilium.network.ModPackets;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

public class PrixiversePortalBlock extends Block {

    private static final VoxelShape SHAPE = Block.createColumnShape(16.0F, 6.0F, 12.0F);
    public static final MapCodec<PrixiversePortalBlock> CODEC = createCodec(PrixiversePortalBlock::new);
    private static final Set<UUID> VIEWING_PLAYERS = new HashSet<>();

    public PrixiversePortalBlock(Settings settings) {
        super(settings);
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

    public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {
        double d = (double)pos.getX() + random.nextDouble();
        double e = (double)pos.getY() + 0.8;
        double f = (double)pos.getZ() + random.nextDouble();
        world.addParticleClient(ParticleTypes.SMOKE, d, e, f, 0.0F, 0.0F, 0.0F);
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
