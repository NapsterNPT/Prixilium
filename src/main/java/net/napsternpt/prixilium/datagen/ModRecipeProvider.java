package net.napsternpt.prixilium.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.data.server.recipe.SmithingTransformRecipeJsonBuilder;
import net.minecraft.item.*;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;
import net.napsternpt.prixilium.block.ModBlocks;
import net.napsternpt.prixilium.item.ModItems;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter exporter) {
        // Items
        offerSmithingTemplateCopyingRecipe(exporter, ModItems.PRIXILIUM_UPGRADE_SMITHING_TEMPLATE, ModBlocks.PRIXILIUM);

        //region [Tools]

        //region [wood]
        offerPrixiliumUpgrade(exporter, Items.WOODEN_SWORD, RecipeCategory.COMBAT);
        offerPrixiliumUpgrade(exporter, Items.WOODEN_PICKAXE, RecipeCategory.TOOLS);
        offerPrixiliumUpgrade(exporter, Items.WOODEN_AXE, RecipeCategory.TOOLS);
        offerPrixiliumUpgrade(exporter, Items.WOODEN_SHOVEL, RecipeCategory.TOOLS);
        offerPrixiliumUpgrade(exporter, Items.WOODEN_HOE, RecipeCategory.TOOLS);
        //endregion

        //region [stone]
        offerPrixiliumUpgrade(exporter, Items.STONE_SWORD, RecipeCategory.COMBAT);
        offerPrixiliumUpgrade(exporter, Items.STONE_PICKAXE, RecipeCategory.TOOLS);
        offerPrixiliumUpgrade(exporter, Items.STONE_AXE, RecipeCategory.TOOLS);
        offerPrixiliumUpgrade(exporter, Items.STONE_SHOVEL, RecipeCategory.TOOLS);
        offerPrixiliumUpgrade(exporter, Items.STONE_HOE, RecipeCategory.TOOLS);
        //endregion

        //region [copper]
        /* 1.21.9+
        offerPrixiliumUpgrade(exporter, Items.COPPER_SWORD, RecipeCategory.COMBAT);
        offerPrixiliumUpgrade(exporter, Items.COPPER_PICKAXE, RecipeCategory.TOOLS);
        offerPrixiliumUpgrade(exporter, Items.COPPER_AXE, RecipeCategory.TOOLS);
        offerPrixiliumUpgrade(exporter, Items.COPPER_SHOVEL, RecipeCategory.TOOLS);
        offerPrixiliumUpgrade(exporter, Items.COPPER_HOE, RecipeCategory.TOOLS);
        */
        //endregion

        //region [iron]
        offerPrixiliumUpgrade(exporter, Items.IRON_SWORD, RecipeCategory.COMBAT);
        offerPrixiliumUpgrade(exporter, Items.IRON_PICKAXE, RecipeCategory.TOOLS);
        offerPrixiliumUpgrade(exporter, Items.IRON_AXE, RecipeCategory.TOOLS);
        offerPrixiliumUpgrade(exporter, Items.IRON_SHOVEL, RecipeCategory.TOOLS);
        offerPrixiliumUpgrade(exporter, Items.IRON_HOE, RecipeCategory.TOOLS);
        //endregion

        //region [gold]
        offerPrixiliumUpgrade(exporter, Items.GOLDEN_SWORD, RecipeCategory.COMBAT);
        offerPrixiliumUpgrade(exporter, Items.GOLDEN_PICKAXE, RecipeCategory.TOOLS);
        offerPrixiliumUpgrade(exporter, Items.GOLDEN_AXE, RecipeCategory.TOOLS);
        offerPrixiliumUpgrade(exporter, Items.GOLDEN_SHOVEL, RecipeCategory.TOOLS);
        offerPrixiliumUpgrade(exporter, Items.GOLDEN_HOE, RecipeCategory.TOOLS);
        //endregion

        //region [diamond]
        offerPrixiliumUpgrade(exporter, Items.DIAMOND_SWORD, RecipeCategory.COMBAT);
        offerPrixiliumUpgrade(exporter, Items.DIAMOND_PICKAXE, RecipeCategory.TOOLS);
        offerPrixiliumUpgrade(exporter, Items.DIAMOND_AXE, RecipeCategory.TOOLS);
        offerPrixiliumUpgrade(exporter, Items.DIAMOND_SHOVEL, RecipeCategory.TOOLS);
        offerPrixiliumUpgrade(exporter, Items.DIAMOND_HOE, RecipeCategory.TOOLS);
        //endregion

        //region [netherite]
        offerPrixiliumUpgrade(exporter, Items.NETHERITE_SWORD, RecipeCategory.COMBAT);
        offerPrixiliumUpgrade(exporter, Items.NETHERITE_PICKAXE, RecipeCategory.TOOLS);
        offerPrixiliumUpgrade(exporter, Items.NETHERITE_AXE, RecipeCategory.TOOLS);
        offerPrixiliumUpgrade(exporter, Items.NETHERITE_SHOVEL, RecipeCategory.TOOLS);
        offerPrixiliumUpgrade(exporter, Items.NETHERITE_HOE, RecipeCategory.TOOLS);
        //endregion

        //endregion

        // Blocks
        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.PRIXILIUM_GRASS)
                .input(Items.GRASS_BLOCK)
                .input(ModBlocks.PRIXILIUM)
                .criterion(hasItem(Items.GRASS_BLOCK), conditionsFromItem(Items.GRASS_BLOCK))
                .criterion(hasItem(ModBlocks.PRIXILIUM), conditionsFromItem(ModBlocks.PRIXILIUM))
                .offerTo(exporter);

        offerShapelessRecipe(exporter, ModBlocks.PRIXILIUM_PLANKS, ModBlocks.PRIXILIUM_LOG, "prixilium", 4);
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.PRIXILIUM_WOOD, 3)
                .input('#', ModBlocks.PRIXILIUM_LOG)
                .pattern("##")
                .pattern("##")
                .criterion(hasItem(ModBlocks.PRIXILIUM_LOG), conditionsFromItem(ModBlocks.PRIXILIUM_LOG))
                .offerTo(exporter);
        createStairsRecipe(ModBlocks.PRIXILIUM_STAIRS, Ingredient.ofItems(ModBlocks.PRIXILIUM_PLANKS))
                .criterion(hasItem(ModBlocks.PRIXILIUM_PLANKS), conditionsFromItem(ModBlocks.PRIXILIUM_PLANKS))
                .offerTo(exporter);
        createSlabRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.PRIXILIUM_SLAB, Ingredient.ofItems(ModBlocks.PRIXILIUM_PLANKS))
                .criterion(hasItem(ModBlocks.PRIXILIUM_PLANKS), conditionsFromItem(ModBlocks.PRIXILIUM_PLANKS))
                .offerTo(exporter);
        createDoorRecipe(ModBlocks.PRIXILIUM_DOOR, Ingredient.ofItems(ModBlocks.PRIXILIUM_PLANKS))
                .criterion(hasItem(ModBlocks.PRIXILIUM_PLANKS), conditionsFromItem(ModBlocks.PRIXILIUM_PLANKS))
                .offerTo(exporter);
        createTrapdoorRecipe(ModBlocks.PRIXILIUM_TRAPDOOR, Ingredient.ofItems(ModBlocks.PRIXILIUM_PLANKS))
                .criterion(hasItem(ModBlocks.PRIXILIUM_PLANKS), conditionsFromItem(ModBlocks.PRIXILIUM_PLANKS))
                .offerTo(exporter);
        createFenceRecipe(ModBlocks.PRIXILIUM_FENCE, Ingredient.ofItems(ModBlocks.PRIXILIUM_PLANKS))
                .criterion(hasItem(ModBlocks.PRIXILIUM_PLANKS), conditionsFromItem(ModBlocks.PRIXILIUM_PLANKS))
                .offerTo(exporter);
        createFenceGateRecipe(ModBlocks.PRIXILIUM_FENCE_GATE, Ingredient.ofItems(ModBlocks.PRIXILIUM_PLANKS))
                .criterion(hasItem(ModBlocks.PRIXILIUM_PLANKS), conditionsFromItem(ModBlocks.PRIXILIUM_PLANKS))
                .offerTo(exporter);

        offer2x2CompactingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.PRIXILIUM_BRICKS, ModBlocks.PRIXILIUM);
        ShapedRecipeJsonBuilder.create(
                        RecipeCategory.BUILDING_BLOCKS,
                        ModBlocks.PRIXILIUM_BRICKS_WALL,
                        6
                )
                .pattern("###")
                .pattern("###")
                .input('#', ModBlocks.PRIXILIUM_BRICKS)
                .criterion(hasItem(ModBlocks.PRIXILIUM_BRICKS), conditionsFromItem(ModBlocks.PRIXILIUM_BRICKS))
                .offerTo(exporter);
    }

    private void offerPrixiliumUpgrade(RecipeExporter exporter, Item input, RecipeCategory category) {
        Identifier inputId = Registries.ITEM.getId(input);

        Identifier resultId = Identifier.of("prixilium", "prixiled_" + inputId.getPath());

        Item result = Registries.ITEM.get(resultId);

        SmithingTransformRecipeJsonBuilder.create(
                        Ingredient.ofItems(ModItems.PRIXILIUM_UPGRADE_SMITHING_TEMPLATE),
                        Ingredient.ofItems(input),
                        Ingredient.ofItems(ModBlocks.PRIXILIUM),
                        category,
                        result
                )
                .criterion(hasItem(ModBlocks.PRIXILIUM), conditionsFromItem(ModBlocks.PRIXILIUM))
                .offerTo(exporter, resultId);
    }
}
