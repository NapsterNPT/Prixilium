package net.napsternpt.prixilium.world.gen;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.gen.GenerationStep;
import net.napsternpt.prixilium.util.ModTags;
import net.napsternpt.prixilium.world.ModPlacedFeatures;

public class ModWorldGeneration {
    public static void generateModWorldGen() {
        BiomeModifications.addFeature(
                BiomeSelectors.tag(ModTags.Biomes.PRIXILIUM_TREE_BIOMES),
                GenerationStep.Feature.VEGETAL_DECORATION,
                ModPlacedFeatures.PRIXILIUM_TREE
        );
    }
}
