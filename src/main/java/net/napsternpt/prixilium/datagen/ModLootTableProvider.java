package net.napsternpt.prixilium.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Blocks;
import net.minecraft.registry.RegistryWrapper;
import net.napsternpt.prixilium.block.ModBlocks;

import java.util.concurrent.CompletableFuture;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.PRIXILIUM_LOG);
        addDrop(ModBlocks.PRIXILIUM_PLANKS);
        addDrop(ModBlocks.PRIXILIUM_BRICKS);

        addDrop(ModBlocks.PRIXILIUM_GRASS, drops(ModBlocks.PRIXILIUM_GRASS, Blocks.DIRT));
        addDrop(ModBlocks.PRIXILIUM, drops(ModBlocks.PRIXILIUM));

        addDrop(ModBlocks.PRIXILIUM_LEAVES, drops(ModBlocks.PRIXILIUM_LEAVES, ModBlocks.PRIXILIUM));
    }
}
