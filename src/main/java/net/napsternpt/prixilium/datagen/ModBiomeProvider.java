package net.napsternpt.prixilium.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricDynamicRegistryProvider;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeEffects;
import net.minecraft.world.biome.GenerationSettings;
import net.minecraft.world.biome.SpawnSettings;
import net.minecraft.world.attribute.EnvironmentAttributes;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.carver.ConfiguredCarver;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.napsternpt.prixilium.entity.ModEntities;
import net.napsternpt.prixilium.world.ModPlacedFeatures;

import java.util.concurrent.CompletableFuture;

public class ModBiomeProvider extends FabricDynamicRegistryProvider {

    public ModBiomeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> lookup) {
        super(output, lookup);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup lookup, Entries entries) {
        RegistryWrapper.Impl<PlacedFeature> placedFeatures = lookup.getOrThrow(RegistryKeys.PLACED_FEATURE);
        RegistryWrapper.Impl<ConfiguredCarver<?>> carvers = lookup.getOrThrow(RegistryKeys.CONFIGURED_CARVER);

        SpawnSettings.Builder spawnSettings = new SpawnSettings.Builder();
        spawnSettings.spawn(SpawnGroup.CREATURE, 3, new SpawnSettings.SpawnEntry(ModEntities.BLIKO, 1, 2));
        spawnSettings.spawn(SpawnGroup.MONSTER, 5, new SpawnSettings.SpawnEntry(ModEntities.BLOKITO, 1, 2));
        spawnSettings.spawn(SpawnGroup.MONSTER, 2, new SpawnSettings.SpawnEntry(ModEntities.AIRIS, 1, 2));

        GenerationSettings.LookupBackedBuilder generationSettings = new GenerationSettings.LookupBackedBuilder(placedFeatures, carvers);
        generationSettings.feature(GenerationStep.Feature.VEGETAL_DECORATION,
                placedFeatures.getOrThrow(ModPlacedFeatures.PRIXILIUM_TREE));

        entries.add(ModWorldGen.PRIXILIUM_BIOME, new Biome.Builder()
                .precipitation(false)
                .temperature(0.5f)
                .downfall(0.0f)
                .effects(new BiomeEffects.Builder()
                        .waterColor(0x6BAF00)
                        .build())
                .setEnvironmentAttribute(EnvironmentAttributes.SKY_COLOR_VISUAL, 0xFFCB00)
                .setEnvironmentAttribute(EnvironmentAttributes.FOG_COLOR_VISUAL, 0x1A0A2E)
                .setEnvironmentAttribute(EnvironmentAttributes.WATER_FOG_COLOR_VISUAL, 0x329011)
                .spawnSettings(spawnSettings.build())
                .generationSettings(generationSettings.build())
                .build()
        );
    }

    @Override
    public String getName() {
        return "Prixilium Biomes";
    }
}