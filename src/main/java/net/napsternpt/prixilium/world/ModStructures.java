package net.napsternpt.prixilium.world;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
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
import net.minecraft.structure.StructurePlacementData;
import net.minecraft.structure.StructureTemplate;
import net.minecraft.structure.StructureTemplateManager;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockBox;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.Heightmap;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.noise.NoiseConfig;
import net.minecraft.world.gen.structure.JigsawStructure;
import net.minecraft.world.gen.structure.Structure;
import net.minecraft.resource.Resource;
import net.napsternpt.prixilium.Prixilium;
import net.napsternpt.prixilium.world.gen.chunk.PrixiliumChunkGenerator;

import java.io.IOException;
import java.io.Reader;
import java.util.List;
import java.util.Optional;

public class ModStructures {

    public static void placeStructure(MinecraftServer server, ServerWorld world, String structureName, BlockPos centerPos) {
        placeStructure(server, world, structureName, new BlockPos(centerPos.getX(), 0, centerPos.getZ()), true);
    }

    public static void placeStructure(MinecraftServer server, ServerWorld world, String structureName, BlockPos pos, boolean snapToSurface) {
        world.getChunk(pos);
        NoiseConfig noiseConfig = world.getChunkManager().getNoiseConfig();

        String startPool = Identifier.of(Prixilium.MOD_ID, structureName).toString();
        Identifier startJigsaw = Identifier.of(Prixilium.MOD_ID, "start");
        int depth = 1;
        int maxDistance = 80;

        Optional<Resource> resource = server.getResourceManager().getResource(
                Identifier.of(Prixilium.MOD_ID, "worldgen/structure/" + structureName + ".json"));
        if (resource.isPresent()) {
            try (Reader reader = resource.get().getReader()) {
                JsonObject json = new Gson().fromJson(reader, JsonObject.class);
                startPool = json.get("start_pool").getAsString();
                startJigsaw = Identifier.tryParse(json.get("start_jigsaw_name").getAsString());
                depth = json.get("size").getAsInt();
                maxDistance = json.get("max_distance_from_center").getAsInt();
            } catch (IOException | RuntimeException e) {
                Prixilium.LOGGER.warn("Could not read structure json {}", structureName, e);
            }
        }

        RegistryKey<StructurePool> poolKey = RegistryKey.of(RegistryKeys.TEMPLATE_POOL, Identifier.of(startPool));
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

        assert startJigsaw != null;
        Optional<Structure.StructurePosition> position = StructurePoolBasedGenerator.generate(
                context, pool, Optional.of(startJigsaw), depth, pos, false,
                Optional.empty(),
                new JigsawStructure.MaxDistanceFromCenter(maxDistance),
                StructurePoolAliasLookup.EMPTY,
                JigsawStructure.DEFAULT_DIMENSION_PADDING,
                JigsawStructure.DEFAULT_LIQUID_SETTINGS);
        if (position.isEmpty()) return;

        StructurePiecesCollector collector = position.get().generate();
        List<StructurePiece> pieces = collector.toList().pieces();

        if (snapToSurface && !pieces.isEmpty() && pieces.getFirst() instanceof PoolStructurePiece startPiece) {
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

        NoiseConfig noiseConfig = world.getChunkManager().getNoiseConfig();
        List<ModStructureSpots.Spot> spots = ModStructureSpots.computeSpots(noiseConfig, PrixiliumChunkGenerator.getRadiusBlocks(noiseConfig));

        placeStructure(server, world, "spawn", Prixilium.SPAWN_POS);
        placeStructure(server, world, "fountain", BlockPos.ORIGIN);
        for (ModStructureSpots.Spot spot : spots) {
            placeStructure(server, world, spot.name(), spot.center());
        }

        var generator = world.getChunkManager().getChunkGenerator();
        int surfaceY = generator.getHeight(0, 0, Heightmap.Type.WORLD_SURFACE_WG, world, noiseConfig);
        placeStructure(server, world, "shaft", new BlockPos(0, surfaceY, 0), false);

        placeBridges(world, noiseConfig);
    }

    private static final int BRIDGE_Y_PROBE_STEP = 4;

    private static void placeBridges(ServerWorld world, NoiseConfig noiseConfig) {
        ChunkGenerator generator = world.getChunkManager().getChunkGenerator();
        int radius = PrixiliumChunkGenerator.getRadiusBlocks(noiseConfig);
        for (PrixiliumWorldgenAnchors.BridgeTarget target : PrixiliumWorldgenAnchors.bridgeTargets(noiseConfig)) {
            Direction direction = target.direction();
            int ringCenterDistance = PrixiliumChunkGenerator.ringCenter(radius, target.ring());
            int surfaceY = bridgeSurfaceY(generator, world, noiseConfig, direction, ringCenterDistance);
            placeBridge(world, direction, new BlockPos(target.baseAnchor().getX(), surfaceY, target.baseAnchor().getZ()));
        }
    }

    private static int bridgeSurfaceY(ChunkGenerator generator, ServerWorld world, NoiseConfig noiseConfig,
                                      Direction direction, int ringCenterDistance) {
        int minimumY = generator.getMinimumY();
        for (int offset = 0; offset <= 12; offset += BRIDGE_Y_PROBE_STEP) {
            for (int sign : new int[]{1, -1}) {
                int distance = ringCenterDistance + sign * offset;
                int x = direction.getOffsetX() * distance;
                int z = direction.getOffsetZ() * distance;
                int analyticY = generator.getHeight(x, z, Heightmap.Type.WORLD_SURFACE_WG, world, noiseConfig);
                if (analyticY > minimumY) {
                    return analyticY;
                }
            }
        }
        return minimumY;
    }

    public static void placeBridge(ServerWorld world, Direction direction, BlockPos anchor) {
        world.getChunk(anchor);
        StructureTemplateManager templateManager = world.getStructureTemplateManager();
        Identifier templateId = Identifier.of(Prixilium.MOD_ID, "bridge");
        StructureTemplate template = templateManager.getTemplateOrBlank(templateId);
        StructurePlacementData placementData = new StructurePlacementData()
                .setRotation(bridgeRotation(direction))
                .setUpdateNeighbors(false);

        List<StructureTemplate.StructureBlockInfo> jigsaws = template.getInfosForBlock(BlockPos.ORIGIN, placementData, Blocks.JIGSAW);
        if (jigsaws.isEmpty()) return;

        StructureTemplate.StructureBlockInfo start = jigsaws.stream()
                .filter(info -> info.nbt() != null && info.nbt().getString("name").orElse("").equals(Identifier.of(Prixilium.MOD_ID, "start").toString()))
                .findFirst()
                .orElse(jigsaws.getFirst());

        BlockPos origin = anchor.subtract(start.pos());
        BlockBox box = template.calculateBoundingBox(placementData, origin);
        placementData.setBoundingBox(box);
        template.place(world, origin, BlockPos.ORIGIN, placementData, world.getRandom(), Block.NOTIFY_ALL);

        for (BlockPos blockPos : BlockPos.iterate(box.getMinX(), box.getMinY(), box.getMinZ(),
                box.getMaxX(), box.getMaxY(), box.getMaxZ())) {
            if (world.getBlockState(blockPos).isOf(Blocks.JIGSAW) || world.getBlockState(blockPos).isOf(Blocks.STRUCTURE_BLOCK)) {
                world.setBlockState(blockPos, Blocks.AIR.getDefaultState(), Block.NOTIFY_ALL);
            }
        }
    }

    private static BlockRotation bridgeRotation(Direction direction) {
        return switch (direction) {
            case EAST -> BlockRotation.COUNTERCLOCKWISE_90;
            case WEST -> BlockRotation.CLOCKWISE_90;
            case SOUTH -> BlockRotation.NONE;
            default -> BlockRotation.CLOCKWISE_180;
        };
    }
}
