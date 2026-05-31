package net.napsternpt.prixilium;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.entity.event.v1.ServerEntityWorldChangeEvents;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.registry.FabricBrewingRecipeRegistryBuilder;
import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.fabricmc.fabric.api.resource.ResourcePackActivationType;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.potion.Potions;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.napsternpt.prixilium.block.ModBlocks;
import net.napsternpt.prixilium.block.entity.ModBlockEntities;
import net.napsternpt.prixilium.component.ModDataComponentTypes;
import net.napsternpt.prixilium.datagen.ModWorldGen;
import net.napsternpt.prixilium.effect.ModEffects;
import net.napsternpt.prixilium.entity.ModEntities;
import net.napsternpt.prixilium.entity.custom.*;
import net.napsternpt.prixilium.item.ModItemGroups;
import net.napsternpt.prixilium.item.ModItems;
import net.napsternpt.prixilium.network.ModPackets;
import net.napsternpt.prixilium.particle.ModParticles;
import net.napsternpt.prixilium.potion.ModPotions;
import net.napsternpt.prixilium.screen.hud.ModHuds;
import net.napsternpt.prixilium.sound.ModSounds;
import net.napsternpt.prixilium.util.ModGameRules;
import net.napsternpt.prixilium.world.ModStructures;
import net.napsternpt.prixilium.world.gen.ModWorldGeneration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Set;

public class Prixilium implements ModInitializer {
	public static final String MOD_ID = "prixilium";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
	public static final BlockPos SPAWN_POS = new BlockPos(100, 120, 0);

	@Override
	public void onInitialize() {
		ModItemGroups.registerItemGroups();
		ModItems.registerItems();
		FabricBrewingRecipeRegistryBuilder.BUILD.register(builder -> builder.registerPotionRecipe(Potions.AWKWARD, ModBlocks.PRIXILIUM.asItem(), ModPotions.PRIXILIUM_SLOWNESS_POTION));

		ModBlocks.registerBlocks();
		ModBlockEntities.registerBlockEntities();
		ModDataComponentTypes.registerDataComponentTypes();
		ModSounds.registerSounds();
		ModEffects.registerEffects();
		ModPotions.registerPotions();
		ModEntities.registerEntities();
		FabricDefaultAttributeRegistry.register(ModEntities.BLIKO, BlikoEntity.createAttributes());
		FabricDefaultAttributeRegistry.register(ModEntities.BLOKITO, BlokitoEntity.createAttributes());
		FabricDefaultAttributeRegistry.register(ModEntities.AIRIS, AirisEntity.createAttributes());

		ModParticles.registerParticles();
		ModHuds.registerHuds();
		ModGameRules.registerGameRules();

		ModWorldGeneration.generateModWorldGen();

		ServerLifecycleEvents.SERVER_STARTED.register(server -> {
			ServerWorld prixiverse = server.getWorld(ModWorldGen.PRIXILIUM_WORLD);
			if (prixiverse == null) return;
			ModStructures.spawnStructures(server, prixiverse);
		});

		ServerEntityWorldChangeEvents.AFTER_PLAYER_CHANGE_WORLD.register((player, origin, destination) -> {
			if (destination.getRegistryKey().equals(ModWorldGen.PRIXILIUM_WORLD)) {player.teleport(destination, SPAWN_POS.getX() + 0.5, SPAWN_POS.getY(), SPAWN_POS.getZ() + 0.5, Set.of(), 90, 0, true);}
		});

		ModPackets.registerServer();
		ModPackets.registerReturnHandler();

		ResourceManagerHelper.registerBuiltinResourcePack(Identifier.of(MOD_ID, "static_charms"),
				FabricLoader.getInstance().getModContainer(MOD_ID).orElseThrow(),
				Text.translatable("resourcepacks.static_charms"),
				ResourcePackActivationType.NORMAL
		);
	}
}
