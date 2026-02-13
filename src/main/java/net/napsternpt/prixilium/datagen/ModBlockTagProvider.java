package net.napsternpt.prixilium.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.ItemTags;
import net.napsternpt.prixilium.block.ModBlocks;
import net.napsternpt.prixilium.item.ModItems;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(BlockTags.AXE_MINEABLE)
                .add(ModBlocks.PRIXILIUM_LOG)
                .add(ModBlocks.PRIXILIUM_WOOD)
                .add(ModBlocks.PRIXILIUM_PLANKS);

        getOrCreateTagBuilder(BlockTags.HOE_MINEABLE)
                .add(ModBlocks.PRIXILIUM_LEAVES);

        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(ModBlocks.PRIXILIUM_BRICKS);

        getOrCreateTagBuilder(BlockTags.SHOVEL_MINEABLE)
                .add(ModBlocks.PRIXILIUM_GRASS);

        getOrCreateTagBuilder(BlockTags.DIRT)
                .add(ModBlocks.PRIXILIUM_GRASS);

        getOrCreateTagBuilder(BlockTags.LEAVES)
                .add(ModBlocks.PRIXILIUM_LEAVES);

        getOrCreateTagBuilder(BlockTags.LOGS)
                .add(ModBlocks.PRIXILIUM_LOG);

        getOrCreateTagBuilder(BlockTags.PLANKS)
                .add(ModBlocks.PRIXILIUM_PLANKS);

        getOrCreateTagBuilder(BlockTags.SNAPS_GOAT_HORN)
                .add(ModBlocks.PRIXILIUM_LOG);

        getOrCreateTagBuilder(BlockTags.WOODEN_FENCES)
                .add(ModBlocks.PRIXILIUM_FENCE);

        getOrCreateTagBuilder(BlockTags.FENCE_GATES)
                .add(ModBlocks.PRIXILIUM_FENCE_GATE);

        getOrCreateTagBuilder(BlockTags.WALLS)
                .add(ModBlocks.PRIXILIUM_BRICKS_WALL);
    }
}
