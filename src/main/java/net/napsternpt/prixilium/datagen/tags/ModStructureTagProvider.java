package net.napsternpt.prixilium.datagen.tags;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.world.gen.structure.Structure;
import net.napsternpt.prixilium.util.ModTags;
import net.napsternpt.prixilium.world.ModStructures;
import org.jspecify.annotations.NonNull;

import java.util.concurrent.CompletableFuture;

public class ModStructureTagProvider extends FabricTagProvider<Structure> {
    public ModStructureTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, RegistryKeys.STRUCTURE, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.@NonNull WrapperLookup wrapperLookup) {
        builder(ModTags.Structures.GENERATE_PATH)
                .add(ModStructures.SPAWN)
                .add(ModStructures.PORTAL)
                .add(ModStructures.RIFT_TEMPLE)
                .add(ModStructures.SINGLE_TOWER)
                .add(ModStructures.DOUBLE_TOWER)
                .add(ModStructures.QUADRUPLE_TOWER);
    }
}