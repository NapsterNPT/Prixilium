package net.napsternpt.prixilium.world;

import net.minecraft.block.Block;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtIo;
import net.minecraft.nbt.NbtSizeTracker;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.registry.entry.RegistryEntryList;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.resource.Resource;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.structure.StructurePlacementData;
import net.minecraft.structure.StructureTemplate;
import net.minecraft.structure.StructureTemplateManager;
import net.minecraft.structure.pool.StructurePool;
import net.minecraft.util.BlockMirror;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Heightmap;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.StructureTerrainAdaptation;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.heightprovider.ConstantHeightProvider;
import net.minecraft.world.gen.structure.JigsawStructure;
import net.minecraft.world.gen.structure.Structure;
import net.napsternpt.prixilium.Prixilium;

import java.io.IOException;
import java.io.InputStream;
import java.util.Optional;

public class ModStructures {
    public static final RegistryKey<Structure> SPAWN = RegistryKey.of(RegistryKeys.STRUCTURE, Identifier.of(Prixilium.MOD_ID, "spawn"));
    public static final RegistryKey<Structure> PORTAL = RegistryKey.of(RegistryKeys.STRUCTURE, Identifier.of(Prixilium.MOD_ID, "portal"));
    public static final RegistryKey<Structure> EXHAUST_TOWER = RegistryKey.of(RegistryKeys.STRUCTURE, Identifier.of(Prixilium.MOD_ID, "exhaust_tower"));

    public static void bootstrap(Registerable<Structure> context) {
        RegistryEntry.Reference<StructurePool> spawnPool = context.getRegistryLookup(RegistryKeys.TEMPLATE_POOL).getOrThrow(ModTemplatePools.SPAWN_START_POOL);
        RegistryEntry.Reference<StructurePool> portalPool = context.getRegistryLookup(RegistryKeys.TEMPLATE_POOL).getOrThrow(ModTemplatePools.PORTAL_START_POOL);
        RegistryEntry.Reference<StructurePool> exhaustTowerPool = context.getRegistryLookup(RegistryKeys.TEMPLATE_POOL).getOrThrow(ModTemplatePools.EXHAUST_TOWER_START_POOL);

        RegistryEntryList<Biome> biomes = context.getRegistryLookup(RegistryKeys.BIOME)
                .getOrThrow(TagKey.of(RegistryKeys.BIOME, Identifier.of(Prixilium.MOD_ID, "has_structure/structures")));

        Structure.Config config = new Structure.Config(biomes, java.util.Map.of(),
                GenerationStep.Feature.SURFACE_STRUCTURES, StructureTerrainAdaptation.BEARD_THIN);

        context.register(SPAWN, new JigsawStructure(config, spawnPool, 1,
                ConstantHeightProvider.create(YOffset.fixed(0)), false, Heightmap.Type.WORLD_SURFACE_WG));

        context.register(PORTAL, new JigsawStructure(config, portalPool, 1,
                ConstantHeightProvider.create(YOffset.fixed(0)), false, Heightmap.Type.WORLD_SURFACE_WG));

        context.register(EXHAUST_TOWER, new JigsawStructure(config, exhaustTowerPool, 1,
                ConstantHeightProvider.create(YOffset.fixed(0)), false, Heightmap.Type.WORLD_SURFACE_WG));
    }

    public static void placeStructure(MinecraftServer server, ServerWorld world, String structureName, BlockPos centerPos) {
        world.getChunk(centerPos);
        int surfaceY = world.getTopY(Heightmap.Type.WORLD_SURFACE, centerPos.getX(), centerPos.getZ());
        StructureTemplateManager templateManager = server.getStructureTemplateManager();
        Identifier resourceId = Identifier.of(Prixilium.MOD_ID, "structure/" + structureName + ".nbt");
        Optional<Resource> resourceOpt = server.getResourceManager().getResource(resourceId);
        if (resourceOpt.isEmpty()) return;
        StructureTemplate template;
        try (InputStream stream = resourceOpt.get().getInputStream()) {
            NbtCompound nbt = NbtIo.readCompressed(stream, NbtSizeTracker.ofUnlimitedBytes());
            template = templateManager.createTemplate(nbt);
        } catch (IOException e) {
            Prixilium.LOGGER.error("Failed to load structure{}", resourceId, e);
            return;
        }

        BlockPos structureOrigin = new BlockPos(centerPos.getX() - template.getSize().getX() / 2, surfaceY - 1, centerPos.getZ() - template.getSize().getZ() / 2);

        StructurePlacementData placementData = new StructurePlacementData()
                .setMirror(BlockMirror.NONE)
                .setRotation(BlockRotation.NONE)
                .setIgnoreEntities(false);

        template.place(world, structureOrigin, structureOrigin, placementData, world.getRandom(), Block.NOTIFY_ALL);
    }

    public static void spawnStructures(MinecraftServer server, ServerWorld world) {
        Prixilium.LOGGER.info("Registering Prixilium Structures.");
        placeStructure(server, world, "spawn", Prixilium.SPAWN_POS);
        placeStructure(server, world, "portal", BlockPos.ORIGIN);
    }
}
