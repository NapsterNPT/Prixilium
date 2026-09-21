package net.napsternpt.prixilium.world;

import net.minecraft.registry.Registerable;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.registry.entry.RegistryEntryList;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.structure.StructurePiece;
import net.minecraft.structure.StructurePiecesCollector;
import net.minecraft.structure.PoolStructurePiece;
import net.minecraft.structure.pool.StructurePool;
import net.minecraft.structure.pool.StructurePoolBasedGenerator;
import net.minecraft.structure.pool.alias.StructurePoolAliasLookup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockBox;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.Heightmap;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.StructureTerrainAdaptation;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.heightprovider.ConstantHeightProvider;
import net.minecraft.world.gen.noise.NoiseConfig;
import net.minecraft.world.gen.structure.JigsawStructure;
import net.minecraft.world.gen.structure.Structure;
import net.napsternpt.prixilium.Prixilium;
import net.napsternpt.prixilium.util.ModTags;
import net.napsternpt.prixilium.world.gen.chunk.PrixiliumChunkGenerator;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public class ModStructures {
    public static final Identifier START_JIGSAW_NAME = Identifier.of(Prixilium.MOD_ID, "anchor");

    public static final RegistryKey<Structure> SPAWN = RegistryKey.of(RegistryKeys.STRUCTURE, Identifier.of(Prixilium.MOD_ID, "spawn"));
    public static final RegistryKey<Structure> PORTAL = RegistryKey.of(RegistryKeys.STRUCTURE, Identifier.of(Prixilium.MOD_ID, "portal"));
    public static final RegistryKey<Structure> EXHAUST_TOWER = RegistryKey.of(RegistryKeys.STRUCTURE, Identifier.of(Prixilium.MOD_ID, "exhaust_tower"));
    public static final RegistryKey<Structure> FOUNTAIN = RegistryKey.of(RegistryKeys.STRUCTURE, Identifier.of(Prixilium.MOD_ID, "fountain"));
    public static final RegistryKey<Structure> SINGLE_TOWER = RegistryKey.of(RegistryKeys.STRUCTURE, Identifier.of(Prixilium.MOD_ID, "single_tower"));
    public static final RegistryKey<Structure> DOUBLE_TOWER = RegistryKey.of(RegistryKeys.STRUCTURE, Identifier.of(Prixilium.MOD_ID, "double_tower"));
    public static final RegistryKey<Structure> QUADRUPLE_TOWER = RegistryKey.of(RegistryKeys.STRUCTURE, Identifier.of(Prixilium.MOD_ID, "quadruple_tower"));
    public static final RegistryKey<Structure> BLOCKITO = RegistryKey.of(RegistryKeys.STRUCTURE, Identifier.of(Prixilium.MOD_ID, "blockito"));
    public static final RegistryKey<Structure> BLOCKITO_FAKE = RegistryKey.of(RegistryKeys.STRUCTURE, Identifier.of(Prixilium.MOD_ID, "blockito_fake"));
    public static final RegistryKey<Structure> RIFT_TEMPLE = RegistryKey.of(RegistryKeys.STRUCTURE, Identifier.of(Prixilium.MOD_ID, "rift_temple"));

    public static void bootstrap(Registerable<Structure> context) {
        RegistryEntry.Reference<StructurePool> spawnPool = context.getRegistryLookup(RegistryKeys.TEMPLATE_POOL).getOrThrow(ModTemplatePools.SPAWN_START_POOL);
        RegistryEntry.Reference<StructurePool> portalPool = context.getRegistryLookup(RegistryKeys.TEMPLATE_POOL).getOrThrow(ModTemplatePools.PORTAL_START_POOL);
        RegistryEntry.Reference<StructurePool> exhaustTowerPool = context.getRegistryLookup(RegistryKeys.TEMPLATE_POOL).getOrThrow(ModTemplatePools.EXHAUST_TOWER_START_POOL);
        RegistryEntry.Reference<StructurePool> fountainPool = context.getRegistryLookup(RegistryKeys.TEMPLATE_POOL).getOrThrow(ModTemplatePools.FOUNTAIN_START_POOL);
        RegistryEntry.Reference<StructurePool> singleTowerPool = context.getRegistryLookup(RegistryKeys.TEMPLATE_POOL).getOrThrow(ModTemplatePools.SINGLE_TOWER_START_POOL);
        RegistryEntry.Reference<StructurePool> doubleTowerPool = context.getRegistryLookup(RegistryKeys.TEMPLATE_POOL).getOrThrow(ModTemplatePools.DOUBLE_TOWER_START_POOL);
        RegistryEntry.Reference<StructurePool> quadrupleTowerPool = context.getRegistryLookup(RegistryKeys.TEMPLATE_POOL).getOrThrow(ModTemplatePools.QUADRUPLE_TOWER_START_POOL);
        RegistryEntry.Reference<StructurePool> blockitoPool = context.getRegistryLookup(RegistryKeys.TEMPLATE_POOL).getOrThrow(ModTemplatePools.BLOCKITO_START_POOL);
        RegistryEntry.Reference<StructurePool> blockitoFakePool = context.getRegistryLookup(RegistryKeys.TEMPLATE_POOL).getOrThrow(ModTemplatePools.BLOCKITO_FAKE_START_POOL);
        RegistryEntry.Reference<StructurePool> riftTemplePool = context.getRegistryLookup(RegistryKeys.TEMPLATE_POOL).getOrThrow(ModTemplatePools.RIFT_TEMPLE_START_POOL);

        RegistryEntryList<Biome> biomes = context.getRegistryLookup(RegistryKeys.BIOME)
                .getOrThrow(ModTags.Biomes.STRUCTURE_BIOME_TAG);

        Structure.Config config = new Structure.Config(biomes, java.util.Map.of(),
                GenerationStep.Feature.SURFACE_STRUCTURES, StructureTerrainAdaptation.BEARD_THIN);

        context.register(SPAWN, jigsaw(config, spawnPool));
        context.register(PORTAL, jigsaw(config, portalPool));
        context.register(EXHAUST_TOWER, jigsaw(config, exhaustTowerPool));
        context.register(FOUNTAIN, jigsaw(config, fountainPool));
        context.register(SINGLE_TOWER, jigsaw(config, singleTowerPool));
        context.register(DOUBLE_TOWER, jigsaw(config, doubleTowerPool));
        context.register(QUADRUPLE_TOWER, jigsaw(config, quadrupleTowerPool));
        context.register(BLOCKITO, jigsaw(config, blockitoPool));
        context.register(BLOCKITO_FAKE, jigsaw(config, blockitoFakePool));
        context.register(RIFT_TEMPLE, jigsaw(config, riftTemplePool));
    }

    private static JigsawStructure jigsaw(Structure.Config config, RegistryEntry.Reference<StructurePool> pool) {
        return new JigsawStructure(config, pool, Optional.of(START_JIGSAW_NAME), 1,
                ConstantHeightProvider.create(YOffset.fixed(0)), false, Optional.of(Heightmap.Type.WORLD_SURFACE_WG),
                new JigsawStructure.MaxDistanceFromCenter(80), List.of(),
                JigsawStructure.DEFAULT_DIMENSION_PADDING, JigsawStructure.DEFAULT_LIQUID_SETTINGS);
    }

    public static void placeStructure(MinecraftServer server, ServerWorld world, String structureName, BlockPos centerPos) {
        world.getChunk(centerPos);
        NoiseConfig noiseConfig = world.getChunkManager().getNoiseConfig();
        BlockPos pos = new BlockPos(centerPos.getX(), 0, centerPos.getZ());

        RegistryKey<StructurePool> poolKey = RegistryKey.of(RegistryKeys.TEMPLATE_POOL, Identifier.of(Prixilium.MOD_ID, structureName + "/start_pool"));
        Registry<StructurePool> poolRegistry = server.getRegistryManager().getOrThrow(RegistryKeys.TEMPLATE_POOL);
        StructurePool poolValue = poolRegistry.get(poolKey);
        if (poolValue == null) return;
        RegistryEntry<StructurePool> pool = poolRegistry.getEntry(poolValue);

        Structure.Context context = new Structure.Context(
                server.getRegistryManager(),
                world.getChunkManager().getChunkGenerator(),
                world.getChunkManager().getChunkGenerator().getBiomeSource(),
                noiseConfig,
                world.getStructureTemplateManager(),
                world.getSeed(),
                new ChunkPos(pos),
                world,
                biome -> true);

        Optional<Structure.StructurePosition> position = StructurePoolBasedGenerator.generate(
                context, pool, Optional.of(START_JIGSAW_NAME), 1, pos, false,
                Optional.empty(),
                new JigsawStructure.MaxDistanceFromCenter(80),
                StructurePoolAliasLookup.EMPTY,
                JigsawStructure.DEFAULT_DIMENSION_PADDING,
                JigsawStructure.DEFAULT_LIQUID_SETTINGS);
        if (position.isEmpty()) return;

        StructurePiecesCollector collector = position.get().generate();
        List<StructurePiece> pieces = collector.toList().pieces();

        if (!pieces.isEmpty() && pieces.getFirst() instanceof PoolStructurePiece startPiece) {
            BlockBox box = startPiece.getBoundingBox();
            int centerX = (box.getMinX() + box.getMaxX()) / 2;
            int centerZ = (box.getMinZ() + box.getMaxZ()) / 2;
            int surfaceY = world.getChunkManager().getChunkGenerator()
                    .getHeight(centerX, centerZ, Heightmap.Type.WORLD_SURFACE_WG, world, noiseConfig);
            for (StructurePiece piece : pieces) {
                piece.translate(0, surfaceY + 1, 0);
            }
        }

        for (StructurePiece piece : pieces) {
            if (piece instanceof PoolStructurePiece poolPiece) {
                poolPiece.generate(world, world.getStructureAccessor(), world.getChunkManager().getChunkGenerator(),
                        world.getRandom(), BlockBox.infinite(), pos, false);
                BlockBox box = poolPiece.getBoundingBox();
                for (BlockPos blockPos : BlockPos.iterate(box.getMinX(), box.getMinY(), box.getMinZ(),
                        box.getMaxX(), box.getMaxY(), box.getMaxZ())) {
                    if (world.getBlockState(blockPos).isOf(Blocks.JIGSAW)) {
                        world.setBlockState(blockPos, Blocks.AIR.getDefaultState(), Block.NOTIFY_ALL);
                    }
                }
            }
        }
    }

    public static void spawnStructures(MinecraftServer server, ServerWorld world) {
        Prixilium.LOGGER.info("Registering Structures.");

        Set<String> pathEnabled = readPathEnabled(server);
        NoiseConfig noiseConfig = world.getChunkManager().getNoiseConfig();
        List<ModStructureSpots.Spot> spots = ModStructureSpots.computeSpots(noiseConfig, PrixiliumChunkGenerator.getRadiusBlocks(noiseConfig));

        List<ModPath.PathTarget> targets = new ArrayList<>();
        if (pathEnabled.contains("spawn")) {
            targets.add(new ModPath.PathTarget(Prixilium.SPAWN_POS, ModPath.STRUCTURE_HALF));
        }
        for (ModStructureSpots.Spot spot : spots) {
            if (pathEnabled.contains(spot.name())) {
                targets.add(new ModPath.PathTarget(spot.center(), spot.halfExtent()));
            }
        }

        var generator = world.getChunkManager().getChunkGenerator();
        if (generator instanceof PrixiliumChunkGenerator prixiliumGenerator) {
            prixiliumGenerator.setPathTargets(targets);
        }

        placeStructure(server, world, "spawn", Prixilium.SPAWN_POS);
        placeStructure(server, world, "fountain", BlockPos.ORIGIN);
        for (ModStructureSpots.Spot spot : spots) {
            placeStructure(server, world, spot.name(), spot.center());
        }
    }

    private static Set<String> readPathEnabled(MinecraftServer server) {
        Set<String> enabled = new HashSet<>();
        server.getRegistryManager().getOrThrow(RegistryKeys.STRUCTURE)
                .iterateEntries(ModTags.Structures.GENERATE_PATH)
                .forEach(entry -> entry.getKey().ifPresent(key -> enabled.add(key.getValue().getPath())));
        return enabled;
    }
}
