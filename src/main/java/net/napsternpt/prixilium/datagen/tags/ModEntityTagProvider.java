package net.napsternpt.prixilium.datagen.tags;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.napsternpt.prixilium.entity.ModEntities;
import net.napsternpt.prixilium.util.ModTags;

import java.util.concurrent.CompletableFuture;

public class ModEntityTagProvider extends FabricTagProvider.EntityTypeTagProvider {
    public ModEntityTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        // Mod Tags
        valueLookupBuilder(ModTags.Entities.IMMUNE_TO_PRIXILIUM_SLOWNESS)
                .add(ModEntities.BLIKO)
                .add(ModEntities.BLOKITO)
                .add(ModEntities.AIRIS);
    }
}
