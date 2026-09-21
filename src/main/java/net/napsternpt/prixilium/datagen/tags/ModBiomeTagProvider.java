package net.napsternpt.prixilium.datagen.tags;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.world.biome.Biome;
import net.napsternpt.prixilium.datagen.ModWorldGen;
import net.napsternpt.prixilium.util.ModTags;
import org.jspecify.annotations.NonNull;

import java.util.concurrent.CompletableFuture;

public class ModBiomeTagProvider extends FabricTagProvider<Biome> {
    public ModBiomeTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, RegistryKeys.BIOME, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.@NonNull WrapperLookup wrapperLookup) {
        builder(ModTags.Biomes.OPENS_PRIXILIUM_PERL)
                .addOptional(ModWorldGen.PRIXILIUM_BIOME);
        builder(ModTags.Biomes.PRIXILIUM_TREE_BIOMES)
                .addOptional(ModWorldGen.PRIXILIUM_BIOME);
    }
}