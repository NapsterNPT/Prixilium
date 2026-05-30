package net.napsternpt.prixilium.world;

import net.minecraft.block.Block;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtIo;
import net.minecraft.nbt.NbtSizeTracker;
import net.minecraft.resource.Resource;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.structure.StructurePlacementData;
import net.minecraft.structure.StructureTemplate;
import net.minecraft.structure.StructureTemplateManager;
import net.minecraft.util.BlockMirror;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Heightmap;
import net.napsternpt.prixilium.Prixilium;

import java.io.IOException;
import java.io.InputStream;
import java.util.Optional;

public class ModStructures {
    public static void placeStructure(MinecraftServer server, ServerWorld world, String structureName, BlockPos centerPos) {
        world.getChunk(centerPos);
        int surfaceY = world.getTopY(Heightmap.Type.WORLD_SURFACE, centerPos.getX(), centerPos.getZ());
        StructureTemplateManager templateManager = server.getStructureTemplateManager();
        Identifier resourceId = Identifier.of(Prixilium.MOD_ID, "structures/" + structureName + ".nbt");
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
