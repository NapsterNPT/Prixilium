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
        addDrop(ModBlocks.PRIXILIUM_GRASS, drops(ModBlocks.PRIXILIUM_GRASS, Blocks.DIRT));
        addDrop(ModBlocks.PRIXILIUM, drops(ModBlocks.PRIXILIUM));
        addDrop(ModBlocks.PRIXILIUM_LEAVES, leavesDrops(ModBlocks.PRIXILIUM_LEAVES, ModBlocks.PRIXILIUM, 0.0625F));
        addDrop(ModBlocks.PRIXILIUM_LOG);
        addDrop(ModBlocks.PRIXILIUM_PLANKS);
        addDrop(ModBlocks.PRIXILIUM_STAIRS);
        addDrop(ModBlocks.PRIXILIUM_SLAB, slabDrops(ModBlocks.PRIXILIUM_SLAB));
        addDrop(ModBlocks.PRIXILIUM_FENCE);
        addDrop(ModBlocks.PRIXILIUM_FENCE_GATE);
        addDrop(ModBlocks.PRIXILIUM_DOOR, doorDrops(ModBlocks.PRIXILIUM_DOOR));
        addDrop(ModBlocks.PRIXILIUM_TRAPDOOR);
        addDrop(ModBlocks.PRIXILIUM_BRICKS);
        addDrop(ModBlocks.CRACKED_PRIXILIUM_BRICKS);
        addDrop(ModBlocks.PRIXILIUM_BRICKS_WALL);
        addDrop(ModBlocks.PRIXILIUM_LAMP);
        addDrop(ModBlocks.PRIXILIUM_EXHAUST);
        addDrop(ModBlocks.STAND);
        addDrop(ModBlocks.REACTOR_CORE);
        addDrop(ModBlocks.VIRUS_REACTOR);
    }
}
