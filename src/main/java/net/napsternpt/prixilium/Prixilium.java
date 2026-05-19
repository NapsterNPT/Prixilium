package net.napsternpt.prixilium;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.entity.event.v1.ServerEntityWorldChangeEvents;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.registry.FabricBrewingRecipeRegistryBuilder;
import net.minecraft.block.Block;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtIo;
import net.minecraft.nbt.NbtSizeTracker;
import net.minecraft.potion.Potions;
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
import net.napsternpt.prixilium.block.ModBlocks;
import net.napsternpt.prixilium.block.entity.ModBlockEntities;
import net.napsternpt.prixilium.component.ModDataComponentTypes;
import net.napsternpt.prixilium.datagen.ModWorldGen;
import net.napsternpt.prixilium.effect.ModEffects;
import net.napsternpt.prixilium.entity.ModEntities;
import net.napsternpt.prixilium.entity.custom.*;
import net.napsternpt.prixilium.hud.*;
import net.napsternpt.prixilium.item.ModItemGroups;
import net.napsternpt.prixilium.item.ModItems;
import net.napsternpt.prixilium.particle.ModParticles;
import net.napsternpt.prixilium.potion.ModPotions;
import net.napsternpt.prixilium.sound.ModSounds;
import net.napsternpt.prixilium.world.gen.ModWorldGeneration;
import net.napsternpt.prixilium.world.PrixiverseSpawnState;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Optional;
import java.util.Set;

public class Prixilium implements ModInitializer {
	public static final String MOD_ID = "prixilium";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	private static final int SPAWN_X = 100;
	private static final int SPAWN_Z = 0;

	@Override
	public void onInitialize() {
		ModItemGroups.registerItemGroups();
		ModItems.registerItems();
		ModBlocks.registerBlocks();
		ModBlockEntities.registerBlockEntities();
		ModDataComponentTypes.registerDataComponentTypes();
		ModSounds.registerSounds();
		ModEffects.registerEffects();
		ModPotions.registerPotions();
		ModEntities.registerEntities();
		ModParticles.registerModParticles();

		ThermometerHud.register();

		ModWorldGeneration.generateModWorldGen();

		FabricBrewingRecipeRegistryBuilder.BUILD.register(builder -> builder.registerPotionRecipe(Potions.AWKWARD, ModBlocks.PRIXILIUM.asItem(), ModPotions.PRIXILIUM_SLOWNESS_POTION));

		FabricDefaultAttributeRegistry.register(ModEntities.BLIKO, BlikoEntity.createAttributes());
		FabricDefaultAttributeRegistry.register(ModEntities.BLOKITO, BlokitoEntity.createAttributes());
		FabricDefaultAttributeRegistry.register(ModEntities.AIRIS, AirisEntity.createAttributes());

		ServerLifecycleEvents.SERVER_STARTED.register(server -> {
			ServerWorld prixiverse = server.getWorld(ModWorldGen.PRIXILIUM_WORLD);
			if (prixiverse == null) return;
			placeSpawnStructure(server, prixiverse);
		});

		ServerEntityWorldChangeEvents.AFTER_PLAYER_CHANGE_WORLD.register((player, origin, destination) -> {
			if (destination.getRegistryKey().equals(ModWorldGen.PRIXILIUM_WORLD)) {player.teleport(destination, SPAWN_X + 0.5, 120, SPAWN_Z + 0.5, Set.of(), 90, 0, true);}
		});
	}
	private static void placeSpawnStructure(MinecraftServer server, ServerWorld world) {
		PrixiverseSpawnState state = world.getPersistentStateManager().getOrCreate(PrixiverseSpawnState.TYPE);

		if (state.isSpawnPlaced()) return;

		world.getChunk(new BlockPos(SPAWN_X, 0, SPAWN_Z));
		int surfaceY = world.getTopY(Heightmap.Type.WORLD_SURFACE, SPAWN_X, SPAWN_Z);
		StructureTemplateManager templateManager = server.getStructureTemplateManager();
		Identifier resourceId = Identifier.of(MOD_ID, "structures/spawn.nbt");
		Optional<Resource> resourceOpt = server.getResourceManager().getResource(resourceId);

		StructureTemplate template = null;
		if (resourceOpt.isPresent()) {
			try (InputStream stream = resourceOpt.get().getInputStream()) {
				NbtCompound nbt = NbtIo.readCompressed(stream, NbtSizeTracker.ofUnlimitedBytes());
				template = templateManager.createTemplate(nbt);
			} catch (IOException e) {
				return;
			}
		}

        assert template != null;
        BlockPos structureOrigin = new BlockPos(SPAWN_X - template.getSize().getX() / 2, surfaceY - 1, SPAWN_Z - template.getSize().getZ() / 2);
		StructurePlacementData placementData = new StructurePlacementData()
				.setMirror(BlockMirror.NONE)
				.setRotation(BlockRotation.NONE)
				.setIgnoreEntities(false);
        template.place(world, structureOrigin, structureOrigin, placementData, world.getRandom(), Block.NOTIFY_ALL);

		state.markSpawnPlaced();
	}
}
