package net.napsternpt.prixilium;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.registry.FabricBrewingRecipeRegistryBuilder;
import net.minecraft.potion.Potions;
import net.napsternpt.prixilium.block.ModBlocks;
import net.napsternpt.prixilium.block.entity.ModBlockEntities;
import net.napsternpt.prixilium.component.ModDataComponentTypes;
import net.napsternpt.prixilium.effect.ModEffects;
import net.napsternpt.prixilium.entity.ModEntities;
import net.napsternpt.prixilium.entity.custom.*;
import net.napsternpt.prixilium.item.ModItemGroups;
import net.napsternpt.prixilium.item.ModItems;
import net.napsternpt.prixilium.particle.ModParticles;
import net.napsternpt.prixilium.potion.ModPotions;
import net.napsternpt.prixilium.sound.ModSounds;
import net.napsternpt.prixilium.world.gen.ModWorldGeneration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Prixilium implements ModInitializer {
	public static final String MOD_ID = "prixilium";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

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

		ModWorldGeneration.generateModWorldGen();

		FabricBrewingRecipeRegistryBuilder.BUILD.register(builder -> {
			builder.registerPotionRecipe(Potions.AWKWARD, ModBlocks.PRIXILIUM.asItem(), ModPotions.PRIXILIUM_SLOWNESS_POTION);
		});

		FabricDefaultAttributeRegistry.register(ModEntities.BLIKO, BlikoEntity.createAttributes());
		FabricDefaultAttributeRegistry.register(ModEntities.BLOKITO, BlokitoEntity.createAttributes());
		FabricDefaultAttributeRegistry.register(ModEntities.AIRIS, AirisEntity.createAttributes());
	}
}