package net.napsternpt.prixilium.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.Blocks;
import net.minecraft.data.recipe.RecipeExporter;
import net.minecraft.data.recipe.RecipeGenerator;
import net.minecraft.data.recipe.SmithingTransformRecipeJsonBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;
import net.napsternpt.prixilium.Prixilium;
import net.napsternpt.prixilium.block.ModBlocks;
import net.napsternpt.prixilium.item.ModItems;
import org.jspecify.annotations.NonNull;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected @NonNull RecipeGenerator getRecipeGenerator(RegistryWrapper.@NonNull WrapperLookup registryLookup, @NonNull RecipeExporter exporter) {
        return new RecipeGenerator(registryLookup, exporter) {
            @Override
            public void generate() {
                //region [Items]
                offerSmithingTemplateCopyingRecipe(ModItems.PRIXILIUM_UPGRADE_SMITHING_TEMPLATE, ModBlocks.PRIXILIUM);
                createShaped(RecipeCategory.MISC, ModItems.THERMOMETER)
                        .input('!', Items.REDSTONE)
                        .input('#', Blocks.GLASS_PANE)
                        .input('@', Items.GLASS_BOTTLE)
                        .pattern(" ! ")
                        .pattern(" # ")
                        .pattern(" @ ")
                        .criterion(hasItem(Items.GLASS_BOTTLE), conditionsFromItem(Items.GLASS_BOTTLE))
                        .offerTo(exporter);

                createShaped(RecipeCategory.TOOLS, ModItems.PRIXILIUM_HOOK)
                        .input('#', ModBlocks.PRIXILIUM)
                        .pattern(" ##")
                        .pattern(" ##")
                        .pattern("#  ")
                        .criterion(hasItem(ModBlocks.PRIXILIUM), conditionsFromItem(ModBlocks.PRIXILIUM))
                        .offerTo(exporter);

                //region [Charms]

                //region [Tier I]
                createShaped(RecipeCategory.TOOLS, ModItems.CHARM_I)
                        .input('!', Items.EMERALD)
                        .input('#', ModBlocks.PRIXILIUM)
                        .pattern("#!#")
                        .pattern("! !")
                        .pattern("#!#")
                        .criterion(hasItem(ModBlocks.PRIXILIUM), conditionsFromItem(ModBlocks.PRIXILIUM))
                        .criterion(hasItem(Items.EMERALD), conditionsFromItem(Items.EMERALD))
                        .offerTo(exporter);
                createShaped(RecipeCategory.TOOLS, ModItems.CONTAINER_CHARM_I)
                        .input('!', Blocks.CHEST)
                        .input('#', ModItems.CHARM_I)
                        .pattern(" ! ")
                        .pattern("!#!")
                        .pattern(" ! ")
                        .criterion(hasItem(ModItems.CHARM_I), conditionsFromItem(ModItems.CHARM_I))
                        .offerTo(exporter);
                createShaped(RecipeCategory.TOOLS, ModItems.STASIS_CHARM_I)
                        .input('!', Items.ENDER_PEARL)
                        .input('@', Items.CLOCK)
                        .input('?', Items.COMPASS)
                        .input('#', ModItems.CHARM_I)
                        .pattern(" @ ")
                        .pattern("!#!")
                        .pattern(" ? ")
                        .criterion(hasItem(ModItems.CHARM_I), conditionsFromItem(ModItems.CHARM_I))
                        .offerTo(exporter);
                createShaped(RecipeCategory.TOOLS, ModItems.REGENERATION_CHARM_I)
                        .input('!', Items.COOKED_BEEF)
                        .input('@', Items.GHAST_TEAR)
                        .input('?', Items.PUFFERFISH)
                        .input('#', ModItems.CHARM_I)
                        .pattern(" @ ")
                        .pattern("!#!")
                        .pattern(" ? ")
                        .criterion(hasItem(ModItems.CHARM_I), conditionsFromItem(ModItems.CHARM_I))
                        .offerTo(exporter);
                createShapeless(RecipeCategory.TOOLS, ModItems.POSTMORTAL_CHARM_I)
                        .input(Items.TOTEM_OF_UNDYING)
                        .input(ModItems.CHARM_I)
                        .criterion(hasItem(ModItems.CHARM_I), conditionsFromItem(ModItems.CHARM_I))
                        .offerTo(exporter);
                createShaped(RecipeCategory.TOOLS, ModItems.STOPWATCH_CHARM_I)
                        .input('!', Items.CLOCK)
                        .input('#', ModItems.CHARM_I)
                        .pattern(" ! ")
                        .pattern("!#!")
                        .pattern(" ! ")
                        .criterion(hasItem(ModItems.CHARM_I), conditionsFromItem(ModItems.CHARM_I))
                        .offerTo(exporter, ModItems.STOPWATCH_CHARM_I + "_default");
                createShaped(RecipeCategory.TOOLS, ModItems.IMMUNITY_CHARM_I)
                        .input('!', Items.TURTLE_HELMET)
                        .input('#', ModItems.CHARM_I)
                        .pattern(" ! ")
                        .pattern("!#!")
                        .pattern(" ! ")
                        .criterion(hasItem(ModItems.CHARM_I), conditionsFromItem(ModItems.CHARM_I))
                        .offerTo(exporter, ModItems.IMMUNITY_CHARM_I + "_default");
                createShaped(RecipeCategory.TOOLS, ModItems.SONIC_BOOM_CHARM_I)
                        .input('!', Blocks.SCULK_SHRIEKER)
                        .input('?', Blocks.SCULK_CATALYST)
                        .input('@', Items.ECHO_SHARD)
                        .input('#', ModItems.CHARM_I)
                        .pattern(" @ ")
                        .pattern("@#@")
                        .pattern("?!?")
                        .criterion(hasItem(ModItems.CHARM_I), conditionsFromItem(ModItems.CHARM_I))
                        .offerTo(exporter, ModItems.SONIC_BOOM_CHARM_I + "_default");
                createShaped(RecipeCategory.TOOLS, ModItems.WITHER_CHARM_I)
                        .input('?', Items.WITHER_SKELETON_SKULL)
                        .input('!', Items.WITHER_ROSE)
                        .input('ì', Blocks.SOUL_SAND)
                        .input('#', ModItems.CHARM_III)
                        .pattern(" ? ")
                        .pattern("!#!")
                        .pattern("ììì")
                        .criterion(hasItem(ModItems.CHARM_I), conditionsFromItem(ModItems.CHARM_I))
                        .offerTo(exporter, ModItems.WITHER_CHARM_I + "_default_soul_sand");
                createShaped(RecipeCategory.TOOLS, ModItems.WITHER_CHARM_I)
                        .input('?', Items.WITHER_SKELETON_SKULL)
                        .input('!', Items.WITHER_ROSE)
                        .input('ì', Blocks.SOUL_SOIL)
                        .input('#', ModItems.CHARM_III)
                        .pattern(" ? ")
                        .pattern("!#!")
                        .pattern("ììì")
                        .criterion(hasItem(ModItems.CHARM_I), conditionsFromItem(ModItems.CHARM_I))
                        .offerTo(exporter, ModItems.WITHER_CHARM_I + "_default_soul_soil");
                //endregion

                //region [Tier II]
                createShaped(RecipeCategory.TOOLS, ModItems.CONTAINER_CHARM_II)
                        .input('!', Blocks.CHEST)
                        .input('#', ModItems.CHARM_II)
                        .pattern(" ! ")
                        .pattern("!#!")
                        .pattern(" ! ")
                        .criterion(hasItem(ModItems.CHARM_II), conditionsFromItem(ModItems.CHARM_II))
                        .offerTo(exporter, ModItems.CONTAINER_CHARM_II + "_default");
                createShaped(RecipeCategory.TOOLS, ModItems.STASIS_CHARM_II)
                        .input('!', Items.ENDER_PEARL)
                        .input('@', Items.CLOCK)
                        .input('?', Items.COMPASS)
                        .input('#', ModItems.CHARM_II)
                        .pattern(" @ ")
                        .pattern("!#!")
                        .pattern(" ? ")
                        .criterion(hasItem(ModItems.CHARM_II), conditionsFromItem(ModItems.CHARM_II))
                        .offerTo(exporter, ModItems.STASIS_CHARM_II + "_default");
                createShaped(RecipeCategory.TOOLS, ModItems.REGENERATION_CHARM_II)
                        .input('!', Items.COOKED_BEEF)
                        .input('@', Items.GHAST_TEAR)
                        .input('?', Items.PUFFERFISH)
                        .input('#', ModItems.CHARM_II)
                        .pattern(" @ ")
                        .pattern("!#!")
                        .pattern(" ? ")
                        .criterion(hasItem(ModItems.CHARM_II), conditionsFromItem(ModItems.CHARM_II))
                        .offerTo(exporter, ModItems.REGENERATION_CHARM_II + "_default");
                createShapeless(RecipeCategory.TOOLS, ModItems.POSTMORTAL_CHARM_II)
                        .input(Items.TOTEM_OF_UNDYING)
                        .input(ModItems.CHARM_II)
                        .criterion(hasItem(ModItems.CHARM_II), conditionsFromItem(ModItems.CHARM_II))
                        .offerTo(exporter, ModItems.POSTMORTAL_CHARM_II + "_default");
                createShaped(RecipeCategory.TOOLS, ModItems.STOPWATCH_CHARM_II)
                        .input('!', Items.CLOCK)
                        .input('#', ModItems.CHARM_II)
                        .pattern(" ! ")
                        .pattern("!#!")
                        .pattern(" ! ")
                        .criterion(hasItem(ModItems.CHARM_II), conditionsFromItem(ModItems.CHARM_II))
                        .offerTo(exporter, ModItems.STOPWATCH_CHARM_II + "_default");
                createShaped(RecipeCategory.TOOLS, ModItems.IMMUNITY_CHARM_II)
                        .input('!', Items.TURTLE_HELMET)
                        .input('#', ModItems.CHARM_II)
                        .pattern(" ! ")
                        .pattern("!#!")
                        .pattern(" ! ")
                        .criterion(hasItem(ModItems.CHARM_II), conditionsFromItem(ModItems.CHARM_II))
                        .offerTo(exporter, ModItems.IMMUNITY_CHARM_II + "_default");
                createShaped(RecipeCategory.TOOLS, ModItems.SONIC_BOOM_CHARM_II)
                        .input('!', Blocks.SCULK_SHRIEKER)
                        .input('?', Blocks.SCULK_CATALYST)
                        .input('@', Items.ECHO_SHARD)
                        .input('#', ModItems.CHARM_II)
                        .pattern(" @ ")
                        .pattern("@#@")
                        .pattern("?!?")
                        .criterion(hasItem(ModItems.CHARM_II), conditionsFromItem(ModItems.CHARM_II))
                        .offerTo(exporter, ModItems.SONIC_BOOM_CHARM_II + "_default");
                createShaped(RecipeCategory.TOOLS, ModItems.WITHER_CHARM_II)
                        .input('?', Items.WITHER_SKELETON_SKULL)
                        .input('!', Items.WITHER_ROSE)
                        .input('ì', Blocks.SOUL_SAND)
                        .input('#', ModItems.CHARM_III)
                        .pattern(" ? ")
                        .pattern("!#!")
                        .pattern("ììì")
                        .criterion(hasItem(ModItems.CHARM_II), conditionsFromItem(ModItems.CHARM_II))
                        .offerTo(exporter, ModItems.WITHER_CHARM_II + "_default_soul_sand");
                createShaped(RecipeCategory.TOOLS, ModItems.WITHER_CHARM_II)
                        .input('?', Items.WITHER_SKELETON_SKULL)
                        .input('!', Items.WITHER_ROSE)
                        .input('ì', Blocks.SOUL_SOIL)
                        .input('#', ModItems.CHARM_III)
                        .pattern(" ? ")
                        .pattern("!#!")
                        .pattern("ììì")
                        .criterion(hasItem(ModItems.CHARM_II), conditionsFromItem(ModItems.CHARM_II))
                        .offerTo(exporter, ModItems.WITHER_CHARM_II + "_default_soul_soil");
                //endregion

                //region [Tier III]
                createShaped(RecipeCategory.TOOLS, ModItems.CONTAINER_CHARM_III)
                        .input('!', Blocks.CHEST)
                        .input('#', ModItems.CHARM_III)
                        .pattern(" ! ")
                        .pattern("!#!")
                        .pattern(" ! ")
                        .criterion(hasItem(ModItems.CHARM_III), conditionsFromItem(ModItems.CHARM_III))
                        .offerTo(exporter, ModItems.CONTAINER_CHARM_III + "_default");
                createShaped(RecipeCategory.TOOLS, ModItems.STASIS_CHARM_III)
                        .input('!', Items.ENDER_PEARL)
                        .input('@', Items.CLOCK)
                        .input('?', Items.COMPASS)
                        .input('#', ModItems.CHARM_III)
                        .pattern(" @ ")
                        .pattern("!#!")
                        .pattern(" ? ")
                        .criterion(hasItem(ModItems.CHARM_III), conditionsFromItem(ModItems.CHARM_III))
                        .offerTo(exporter, ModItems.STASIS_CHARM_III + "_default");
                createShaped(RecipeCategory.TOOLS, ModItems.REGENERATION_CHARM_III)
                        .input('!', Items.COOKED_BEEF)
                        .input('@', Items.GHAST_TEAR)
                        .input('?', Items.PUFFERFISH)
                        .input('#', ModItems.CHARM_III)
                        .pattern(" @ ")
                        .pattern("!#!")
                        .pattern(" ? ")
                        .criterion(hasItem(ModItems.CHARM_III), conditionsFromItem(ModItems.CHARM_III))
                        .offerTo(exporter, ModItems.REGENERATION_CHARM_III + "_default");
                createShapeless(RecipeCategory.TOOLS, ModItems.POSTMORTAL_CHARM_III)
                        .input(Items.TOTEM_OF_UNDYING)
                        .input(ModItems.CHARM_III)
                        .criterion(hasItem(ModItems.CHARM_III), conditionsFromItem(ModItems.CHARM_III))
                        .offerTo(exporter, ModItems.POSTMORTAL_CHARM_III + "_default");
                createShaped(RecipeCategory.TOOLS, ModItems.STOPWATCH_CHARM_III)
                        .input('!', Items.CLOCK)
                        .input('#', ModItems.CHARM_III)
                        .pattern(" ! ")
                        .pattern("!#!")
                        .pattern(" ! ")
                        .criterion(hasItem(ModItems.CHARM_III), conditionsFromItem(ModItems.CHARM_III))
                        .offerTo(exporter, ModItems.STOPWATCH_CHARM_III + "_default");
                createShaped(RecipeCategory.TOOLS, ModItems.IMMUNITY_CHARM_III)
                        .input('!', Items.TURTLE_HELMET)
                        .input('#', ModItems.CHARM_I)
                        .pattern(" ! ")
                        .pattern("!#!")
                        .pattern(" ! ")
                        .criterion(hasItem(ModItems.CHARM_I), conditionsFromItem(ModItems.CHARM_I))
                        .offerTo(exporter, ModItems.IMMUNITY_CHARM_III + "_default");
                createShaped(RecipeCategory.TOOLS, ModItems.SONIC_BOOM_CHARM_III)
                        .input('!', Blocks.SCULK_SHRIEKER)
                        .input('?', Blocks.SCULK_CATALYST)
                        .input('@', Items.ECHO_SHARD)
                        .input('#', ModItems.CHARM_III)
                        .pattern(" @ ")
                        .pattern("@#@")
                        .pattern("?!?")
                        .criterion(hasItem(ModItems.CHARM_III), conditionsFromItem(ModItems.CHARM_III))
                        .offerTo(exporter, ModItems.SONIC_BOOM_CHARM_III + "_default");
                createShaped(RecipeCategory.TOOLS, ModItems.WITHER_CHARM_III)
                        .input('?', Items.WITHER_SKELETON_SKULL)
                        .input('!', Items.WITHER_ROSE)
                        .input('ì', Blocks.SOUL_SAND)
                        .input('#', ModItems.CHARM_III)
                        .pattern(" ? ")
                        .pattern("!#!")
                        .pattern("ììì")
                        .criterion(hasItem(ModItems.CHARM_III), conditionsFromItem(ModItems.CHARM_III))
                        .offerTo(exporter, ModItems.WITHER_CHARM_III + "_default_soul_sand");
                createShaped(RecipeCategory.TOOLS, ModItems.WITHER_CHARM_III)
                        .input('?', Items.WITHER_SKELETON_SKULL)
                        .input('!', Items.WITHER_ROSE)
                        .input('ì', Blocks.SOUL_SOIL)
                        .input('#', ModItems.CHARM_III)
                        .pattern(" ? ")
                        .pattern("!#!")
                        .pattern("ììì")
                        .criterion(hasItem(ModItems.CHARM_III), conditionsFromItem(ModItems.CHARM_III))
                        .offerTo(exporter, ModItems.WITHER_CHARM_III + "_default_soul_soil");
                //endregion

                charmUpgrade(exporter, ModItems.CHARM_I);
                charmUpgrade(exporter, ModItems.CONTAINER_CHARM_I);
                charmUpgrade(exporter, ModItems.STASIS_CHARM_I);
                charmUpgrade(exporter, ModItems.REGENERATION_CHARM_I);
                charmUpgrade(exporter, ModItems.POSTMORTAL_CHARM_I);
                charmUpgrade(exporter, ModItems.STOPWATCH_CHARM_I);
                charmUpgrade(exporter, ModItems.IMMUNITY_CHARM_I);
                charmUpgrade(exporter, ModItems.SONIC_BOOM_CHARM_I);
                charmUpgrade(exporter, ModItems.WITHER_CHARM_I);

                //endregion

                //region [Tools]

                //region [wood]
                prixiliumUpgrade(exporter, Items.WOODEN_SWORD, RecipeCategory.COMBAT);
                prixiliumUpgrade(exporter, Items.WOODEN_PICKAXE, RecipeCategory.TOOLS);
                prixiliumUpgrade(exporter, Items.WOODEN_AXE, RecipeCategory.TOOLS);
                prixiliumUpgrade(exporter, Items.WOODEN_SHOVEL, RecipeCategory.TOOLS);
                prixiliumUpgrade(exporter, Items.WOODEN_HOE, RecipeCategory.TOOLS);
                //endregion

                //region [stone]
                prixiliumUpgrade(exporter, Items.STONE_SWORD, RecipeCategory.COMBAT);
                prixiliumUpgrade(exporter, Items.STONE_PICKAXE, RecipeCategory.TOOLS);
                prixiliumUpgrade(exporter, Items.STONE_AXE, RecipeCategory.TOOLS);
                prixiliumUpgrade(exporter, Items.STONE_SHOVEL, RecipeCategory.TOOLS);
                prixiliumUpgrade(exporter, Items.STONE_HOE, RecipeCategory.TOOLS);
                //endregion

                //region [copper]
                prixiliumUpgrade(exporter, Items.COPPER_SWORD, RecipeCategory.COMBAT);
                prixiliumUpgrade(exporter, Items.COPPER_PICKAXE, RecipeCategory.TOOLS);
                prixiliumUpgrade(exporter, Items.COPPER_AXE, RecipeCategory.TOOLS);
                prixiliumUpgrade(exporter, Items.COPPER_SHOVEL, RecipeCategory.TOOLS);
                prixiliumUpgrade(exporter, Items.COPPER_HOE, RecipeCategory.TOOLS);
                //endregion

                //region [iron]
                prixiliumUpgrade(exporter, Items.IRON_SWORD, RecipeCategory.COMBAT);
                prixiliumUpgrade(exporter, Items.IRON_PICKAXE, RecipeCategory.TOOLS);
                prixiliumUpgrade(exporter, Items.IRON_AXE, RecipeCategory.TOOLS);
                prixiliumUpgrade(exporter, Items.IRON_SHOVEL, RecipeCategory.TOOLS);
                prixiliumUpgrade(exporter, Items.IRON_HOE, RecipeCategory.TOOLS);
                //endregion

                //region [gold]
                prixiliumUpgrade(exporter, Items.GOLDEN_SWORD, RecipeCategory.COMBAT);
                prixiliumUpgrade(exporter, Items.GOLDEN_PICKAXE, RecipeCategory.TOOLS);
                prixiliumUpgrade(exporter, Items.GOLDEN_AXE, RecipeCategory.TOOLS);
                prixiliumUpgrade(exporter, Items.GOLDEN_SHOVEL, RecipeCategory.TOOLS);
                prixiliumUpgrade(exporter, Items.GOLDEN_HOE, RecipeCategory.TOOLS);
                //endregion

                //region [diamond]
                prixiliumUpgrade(exporter, Items.DIAMOND_SWORD, RecipeCategory.COMBAT);
                prixiliumUpgrade(exporter, Items.DIAMOND_PICKAXE, RecipeCategory.TOOLS);
                prixiliumUpgrade(exporter, Items.DIAMOND_AXE, RecipeCategory.TOOLS);
                prixiliumUpgrade(exporter, Items.DIAMOND_SHOVEL, RecipeCategory.TOOLS);
                prixiliumUpgrade(exporter, Items.DIAMOND_HOE, RecipeCategory.TOOLS);
                //endregion

                //region [netherite]
                prixiliumUpgrade(exporter, Items.NETHERITE_SWORD, RecipeCategory.COMBAT);
                prixiliumUpgrade(exporter, Items.NETHERITE_PICKAXE, RecipeCategory.TOOLS);
                prixiliumUpgrade(exporter, Items.NETHERITE_AXE, RecipeCategory.TOOLS);
                prixiliumUpgrade(exporter, Items.NETHERITE_SHOVEL, RecipeCategory.TOOLS);
                prixiliumUpgrade(exporter, Items.NETHERITE_HOE, RecipeCategory.TOOLS);
                //endregion

                prixiliumUpgrade(exporter, Items.BOW, RecipeCategory.COMBAT);
                prixiliumUpgrade(exporter, Items.MACE, RecipeCategory.COMBAT);

                //endregion

                //region [Armors]

                //region [leather]
                prixiliumUpgrade(exporter, Items.LEATHER_HELMET, RecipeCategory.COMBAT);
                prixiliumUpgrade(exporter, Items.LEATHER_CHESTPLATE, RecipeCategory.COMBAT);
                prixiliumUpgrade(exporter, Items.LEATHER_LEGGINGS, RecipeCategory.COMBAT);
                prixiliumUpgrade(exporter, Items.LEATHER_BOOTS, RecipeCategory.COMBAT);
                //endregion

                //region [chainmail]
                prixiliumUpgrade(exporter, Items.CHAINMAIL_HELMET, RecipeCategory.COMBAT);
                prixiliumUpgrade(exporter, Items.CHAINMAIL_CHESTPLATE, RecipeCategory.COMBAT);
                prixiliumUpgrade(exporter, Items.CHAINMAIL_LEGGINGS, RecipeCategory.COMBAT);
                prixiliumUpgrade(exporter, Items.CHAINMAIL_BOOTS, RecipeCategory.COMBAT);
                //endregion

                //region [copper]
                prixiliumUpgrade(exporter, Items.COPPER_HELMET, RecipeCategory.COMBAT);
                prixiliumUpgrade(exporter, Items.COPPER_CHESTPLATE, RecipeCategory.COMBAT);
                prixiliumUpgrade(exporter, Items.COPPER_LEGGINGS, RecipeCategory.COMBAT);
                prixiliumUpgrade(exporter, Items.COPPER_BOOTS, RecipeCategory.COMBAT);
                //endregion

                //region [iron]
                prixiliumUpgrade(exporter, Items.IRON_HELMET, RecipeCategory.COMBAT);
                prixiliumUpgrade(exporter, Items.IRON_CHESTPLATE, RecipeCategory.COMBAT);
                prixiliumUpgrade(exporter, Items.IRON_LEGGINGS, RecipeCategory.COMBAT);
                prixiliumUpgrade(exporter, Items.IRON_BOOTS, RecipeCategory.COMBAT);
                //endregion

                //region [golden]
                prixiliumUpgrade(exporter, Items.GOLDEN_HELMET, RecipeCategory.COMBAT);
                prixiliumUpgrade(exporter, Items.GOLDEN_CHESTPLATE, RecipeCategory.COMBAT);
                prixiliumUpgrade(exporter, Items.GOLDEN_LEGGINGS, RecipeCategory.COMBAT);
                prixiliumUpgrade(exporter, Items.GOLDEN_BOOTS, RecipeCategory.COMBAT);
                //endregion

                //region [diamond]
                prixiliumUpgrade(exporter, Items.DIAMOND_HELMET, RecipeCategory.COMBAT);
                prixiliumUpgrade(exporter, Items.DIAMOND_CHESTPLATE, RecipeCategory.COMBAT);
                prixiliumUpgrade(exporter, Items.DIAMOND_LEGGINGS, RecipeCategory.COMBAT);
                prixiliumUpgrade(exporter, Items.DIAMOND_BOOTS, RecipeCategory.COMBAT);
                //endregion

                //region [netherite]
                prixiliumUpgrade(exporter, Items.NETHERITE_HELMET, RecipeCategory.COMBAT);
                prixiliumUpgrade(exporter, Items.NETHERITE_CHESTPLATE, RecipeCategory.COMBAT);
                prixiliumUpgrade(exporter, Items.NETHERITE_LEGGINGS, RecipeCategory.COMBAT);
                prixiliumUpgrade(exporter, Items.NETHERITE_BOOTS, RecipeCategory.COMBAT);
                //endregion

                //region [turtle]
                prixiliumUpgrade(exporter, Items.TURTLE_HELMET, RecipeCategory.COMBAT);
                //endregion

                //region [horse]
                prixiliumUpgrade(exporter, Items.LEATHER_HORSE_ARMOR, RecipeCategory.COMBAT);
                prixiliumUpgrade(exporter, Items.COPPER_HORSE_ARMOR, RecipeCategory.COMBAT);
                prixiliumUpgrade(exporter, Items.IRON_HORSE_ARMOR, RecipeCategory.COMBAT);
                prixiliumUpgrade(exporter, Items.GOLDEN_HORSE_ARMOR, RecipeCategory.COMBAT);
                prixiliumUpgrade(exporter, Items.DIAMOND_HORSE_ARMOR, RecipeCategory.COMBAT);
                prixiliumUpgrade(exporter, Items.NETHERITE_HORSE_ARMOR, RecipeCategory.COMBAT);
                //endregion

                //endregion

                //endregion

                //region[Blocks]

                //region [Planks]
                offerShapelessRecipe(ModBlocks.PRIXILIUM_PLANKS, ModBlocks.PRIXILIUM_LOG, "prixilium", 4);
                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.PRIXILIUM_WOOD, 3)
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

                //endregion

                //region [Burned Planks]
                offerShapelessRecipe(ModBlocks.BURNED_PRIXILIUM_PLANKS, ModBlocks.BURNED_PRIXILIUM_LOG, "burned_prixilium", 4);
                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.BURNED_PRIXILIUM_WOOD, 3)
                        .input('#', ModBlocks.BURNED_PRIXILIUM_LOG)
                        .pattern("##")
                        .pattern("##")
                        .criterion(hasItem(ModBlocks.BURNED_PRIXILIUM_LOG), conditionsFromItem(ModBlocks.BURNED_PRIXILIUM_LOG))
                        .offerTo(exporter);

                createStairsRecipe(ModBlocks.BURNED_PRIXILIUM_STAIRS, Ingredient.ofItems(ModBlocks.BURNED_PRIXILIUM_PLANKS))
                        .criterion(hasItem(ModBlocks.BURNED_PRIXILIUM_PLANKS), conditionsFromItem(ModBlocks.BURNED_PRIXILIUM_PLANKS))
                        .offerTo(exporter);

                createSlabRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.BURNED_PRIXILIUM_SLAB, Ingredient.ofItems(ModBlocks.BURNED_PRIXILIUM_PLANKS))
                        .criterion(hasItem(ModBlocks.BURNED_PRIXILIUM_PLANKS), conditionsFromItem(ModBlocks.BURNED_PRIXILIUM_PLANKS))
                        .offerTo(exporter);

                createDoorRecipe(ModBlocks.BURNED_PRIXILIUM_DOOR, Ingredient.ofItems(ModBlocks.BURNED_PRIXILIUM_PLANKS))
                        .criterion(hasItem(ModBlocks.BURNED_PRIXILIUM_PLANKS), conditionsFromItem(ModBlocks.BURNED_PRIXILIUM_PLANKS))
                        .offerTo(exporter);

                createTrapdoorRecipe(ModBlocks.BURNED_PRIXILIUM_TRAPDOOR, Ingredient.ofItems(ModBlocks.BURNED_PRIXILIUM_PLANKS))
                        .criterion(hasItem(ModBlocks.BURNED_PRIXILIUM_PLANKS), conditionsFromItem(ModBlocks.BURNED_PRIXILIUM_PLANKS))
                        .offerTo(exporter);

                createFenceRecipe(ModBlocks.BURNED_PRIXILIUM_FENCE, Ingredient.ofItems(ModBlocks.BURNED_PRIXILIUM_PLANKS))
                        .criterion(hasItem(ModBlocks.BURNED_PRIXILIUM_PLANKS), conditionsFromItem(ModBlocks.BURNED_PRIXILIUM_PLANKS))
                        .offerTo(exporter);

                createFenceGateRecipe(ModBlocks.BURNED_PRIXILIUM_FENCE_GATE, Ingredient.ofItems(ModBlocks.BURNED_PRIXILIUM_PLANKS))
                        .criterion(hasItem(ModBlocks.BURNED_PRIXILIUM_PLANKS), conditionsFromItem(ModBlocks.BURNED_PRIXILIUM_PLANKS))
                        .offerTo(exporter);

                //endregion

                //region [Bricks]
                offer2x2CompactingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.PRIXILIUM_BRICKS, ModBlocks.PRIXILIUM);

                offerSmelting(List.of(ModBlocks.PRIXILIUM_BRICKS), RecipeCategory.BUILDING_BLOCKS, ModBlocks.CRACKED_PRIXILIUM_BRICKS, 0.1f, 200, "cracked_prixilium_bricks");

                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CHISELED_PRIXILIUM_BRICKS, ModBlocks.PRIXILIUM_BRICKS);
                createChiseledBlockRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CHISELED_PRIXILIUM_BRICKS, Ingredient.ofItem(ModBlocks.PRIXILIUM_BRICK_SLAB))
                        .criterion(hasItem(ModBlocks.PRIXILIUM_BRICK_SLAB), conditionsFromItem(ModBlocks.PRIXILIUM_BRICK_SLAB))
                        .offerTo(exporter);

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.PRIXILIUM_GRATE, 4)
                        .input('!', ModBlocks.PRIXILIUM_BRICKS)
                        .pattern(" ! ")
                        .pattern("! !")
                        .pattern(" ! ")
                        .criterion(hasItem(ModBlocks.PRIXILIUM_BRICKS), conditionsFromItem(ModBlocks.PRIXILIUM_BRICKS))
                        .offerTo(exporter);

                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.PRIXILIUM_BRICK_STAIRS, ModBlocks.PRIXILIUM_BRICKS);
                createStairsRecipe(ModBlocks.PRIXILIUM_BRICK_STAIRS, Ingredient.ofItems(ModBlocks.PRIXILIUM_BRICKS))
                        .criterion(hasItem(ModBlocks.PRIXILIUM_BRICKS), conditionsFromItem(ModBlocks.PRIXILIUM_BRICKS))
                        .offerTo(exporter);

                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.PRIXILIUM_BRICK_SLAB, ModBlocks.PRIXILIUM_BRICKS, 2);
                createSlabRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.PRIXILIUM_BRICK_SLAB, Ingredient.ofItems(ModBlocks.PRIXILIUM_BRICKS))
                        .criterion(hasItem(ModBlocks.PRIXILIUM_BRICKS), conditionsFromItem(ModBlocks.PRIXILIUM_BRICKS))
                        .offerTo(exporter);

                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.PRIXILIUM_BRICKS_WALL, ModBlocks.PRIXILIUM_BRICKS);
                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.PRIXILIUM_BRICKS_WALL, 6)
                        .input('#', ModBlocks.PRIXILIUM_BRICKS)
                        .pattern("###")
                        .pattern("###")
                        .criterion(hasItem(ModBlocks.PRIXILIUM_BRICKS), conditionsFromItem(ModBlocks.PRIXILIUM_BRICKS))
                        .offerTo(exporter);

                //endregion

                //region [Dark Bricks]
                offer2x2CompactingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.DARK_PRIXILIUM_BRICKS, ModBlocks.PRIXILIUM_BRICKS);

                offerSmelting(List.of(ModBlocks.DARK_PRIXILIUM_BRICKS), RecipeCategory.BUILDING_BLOCKS, ModBlocks.CRACKED_DARK_PRIXILIUM_BRICKS, 0.1f, 200, "cracked_prixilium_bricks");

                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CHISELED_DARK_PRIXILIUM_BRICKS, ModBlocks.DARK_PRIXILIUM_BRICKS);
                createChiseledBlockRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CHISELED_DARK_PRIXILIUM_BRICKS, Ingredient.ofItem(ModBlocks.DARK_PRIXILIUM_BRICK_SLAB))
                        .criterion(hasItem(ModBlocks.DARK_PRIXILIUM_BRICK_SLAB), conditionsFromItem(ModBlocks.DARK_PRIXILIUM_BRICK_SLAB))
                        .offerTo(exporter);

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.DARK_PRIXILIUM_GRATE, 4)
                        .input('!', ModBlocks.DARK_PRIXILIUM_BRICKS)
                        .pattern(" ! ")
                        .pattern("! !")
                        .pattern(" ! ")
                        .criterion(hasItem(ModBlocks.DARK_PRIXILIUM_BRICKS), conditionsFromItem(ModBlocks.DARK_PRIXILIUM_BRICKS))
                        .offerTo(exporter);

                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.DARK_PRIXILIUM_BRICK_STAIRS, ModBlocks.DARK_PRIXILIUM_BRICKS);
                createStairsRecipe(ModBlocks.DARK_PRIXILIUM_BRICK_STAIRS, Ingredient.ofItems(ModBlocks.DARK_PRIXILIUM_BRICKS))
                        .criterion(hasItem(ModBlocks.DARK_PRIXILIUM_BRICKS), conditionsFromItem(ModBlocks.DARK_PRIXILIUM_BRICKS))
                        .offerTo(exporter);

                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.DARK_PRIXILIUM_BRICK_SLAB, ModBlocks.DARK_PRIXILIUM_BRICKS, 2);
                createSlabRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.DARK_PRIXILIUM_BRICK_SLAB, Ingredient.ofItems(ModBlocks.DARK_PRIXILIUM_BRICKS))
                        .criterion(hasItem(ModBlocks.DARK_PRIXILIUM_BRICKS), conditionsFromItem(ModBlocks.DARK_PRIXILIUM_BRICKS))
                        .offerTo(exporter);

                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.DARK_PRIXILIUM_BRICKS_WALL, ModBlocks.DARK_PRIXILIUM_BRICKS);
                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.DARK_PRIXILIUM_BRICKS_WALL, 6)
                        .input('#', ModBlocks.DARK_PRIXILIUM_BRICKS)
                        .pattern("###")
                        .pattern("###")
                        .criterion(hasItem(ModBlocks.DARK_PRIXILIUM_BRICKS), conditionsFromItem(ModBlocks.DARK_PRIXILIUM_BRICKS))
                        .offerTo(exporter);

                //endregion

                //region [Other]
                createShapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.PRIXILIUM_GRASS)
                        .input(Items.GRASS_BLOCK)
                        .input(ModBlocks.PRIXILIUM)
                        .criterion(hasItem(ModBlocks.PRIXILIUM), conditionsFromItem(ModBlocks.PRIXILIUM))
                        .offerTo(exporter);

                createShaped(RecipeCategory.REDSTONE, ModBlocks.PRIXILIUM_LAMP)
                        .input('#', ModBlocks.PRIXILIUM)
                        .input('!', Items.REDSTONE)
                        .input('%', Blocks.GLOWSTONE)
                        .pattern("#!#")
                        .pattern("!%!")
                        .pattern("#!#")
                        .criterion(hasItem(ModBlocks.PRIXILIUM_LAMP), conditionsFromItem(ModBlocks.PRIXILIUM_LAMP))
                        .offerTo(exporter, String.valueOf(Identifier.of(Prixilium.MOD_ID, "prixilium_lamp_from_glowstone")));
                createShaped(RecipeCategory.REDSTONE, ModBlocks.PRIXILIUM_LAMP)
                        .input('#', ModBlocks.PRIXILIUM)
                        .input('!', Blocks.REDSTONE_LAMP)
                        .pattern(" # ")
                        .pattern("#!#")
                        .pattern(" # ")
                        .criterion(hasItem(ModBlocks.PRIXILIUM_LAMP), conditionsFromItem(ModBlocks.PRIXILIUM_LAMP))
                        .offerTo(exporter, String.valueOf(Identifier.of(Prixilium.MOD_ID, "prixilium_lamp_from_redstone_lamp")));

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.PRIXILIUM_EXHAUST)
                        .input('#', ModBlocks.PRIXILIUM_BRICKS)
                        .input('!', ModBlocks.PRIXILIUM)
                        .input('@', Items.GUNPOWDER)
                        .pattern("#!#")
                        .pattern("#@#")
                        .pattern("###")
                        .criterion(hasItem(ModBlocks.PRIXILIUM_BRICKS), conditionsFromItem(ModBlocks.PRIXILIUM_BRICKS))
                        .offerTo(exporter);

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.STAND)
                        .input('!', Blocks.DEEPSLATE_BRICK_WALL)
                        .input('#', Blocks.DEEPSLATE_BRICKS)
                        .pattern(" ! ")
                        .pattern("###")
                        .criterion(hasItem(Blocks.DEEPSLATE_BRICK_WALL), conditionsFromItem(Blocks.DEEPSLATE_BRICK_WALL))
                        .criterion(hasItem(Blocks.DEEPSLATE_BRICKS), conditionsFromItem(Blocks.DEEPSLATE_BRICKS))
                        .offerTo(exporter);
                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.REACTOR_CORE)
                        .input('!', Blocks.GLASS_PANE)
                        .input('#', Blocks.DEEPSLATE_BRICKS)
                        .pattern(" ! ")
                        .pattern("! !")
                        .pattern("###")
                        .criterion(hasItem(Blocks.GLASS_PANE), conditionsFromItem(Blocks.GLASS_PANE))
                        .criterion(hasItem(Blocks.DEEPSLATE_BRICKS), conditionsFromItem(Blocks.DEEPSLATE_BRICKS))
                        .offerTo(exporter);
                createShapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.VIRUS_REACTOR)
                        .input(ModBlocks.REACTOR_CORE)
                        .input(ModBlocks.STAND)
                        .criterion(hasItem(ModBlocks.REACTOR_CORE), conditionsFromItem(ModBlocks.REACTOR_CORE))
                        .criterion(hasItem(ModBlocks.STAND), conditionsFromItem(ModBlocks.STAND))
                        .offerTo(exporter);

                //endregion

                //endregion

            }

            private void prixiliumUpgrade(RecipeExporter exporter, Item input, RecipeCategory category) {
                Identifier inputId = Registries.ITEM.getId(input);

                Identifier resultId = Identifier.of(Prixilium.MOD_ID, "prixiled_" + inputId.getPath());

                Item result = Registries.ITEM.get(resultId);

                SmithingTransformRecipeJsonBuilder.create(
                                Ingredient.ofItems(ModItems.PRIXILIUM_UPGRADE_SMITHING_TEMPLATE),
                                Ingredient.ofItems(input),
                                Ingredient.ofItems(ModBlocks.PRIXILIUM),
                                category,
                                result
                        )
                        .criterion(hasItem(ModBlocks.PRIXILIUM), conditionsFromItem(ModBlocks.PRIXILIUM))
                        .offerTo(exporter, String.valueOf(resultId));
            }

            private void charmUpgrade(RecipeExporter exporter, Item  inputCharm) {
                Identifier inputId = Registries.ITEM.getId(inputCharm);
                Item  output = Registries.ITEM.get(Identifier.of(inputId.getNamespace(), inputId.getPath() + "i"));

                createShaped(RecipeCategory.TOOLS, output)
                        .input('!', inputCharm)
                        .input('#', Items.AMETHYST_SHARD)
                        .pattern("###")
                        .pattern("#!#")
                        .pattern("###")
                        .criterion(hasItem(ModItems.CHARM_II), conditionsFromItem(ModItems.CHARM_II))
                        .criterion(hasItem(inputCharm), conditionsFromItem(inputCharm))
                        .offerTo(exporter, String.valueOf(Identifier.of(Prixilium.MOD_ID, inputId.getPath() + "_upgraded_to_tear_ii")));

                createShaped(RecipeCategory.TOOLS, output)
                        .input('!', inputCharm)
                        .input('#', Items.NETHERITE_INGOT)
                        .pattern(" # ")
                        .pattern("#!#")
                        .pattern(" # ")
                        .criterion(hasItem(ModItems.CHARM_III), conditionsFromItem(ModItems.CHARM_III))
                        .criterion(hasItem(inputCharm), conditionsFromItem(inputCharm))
                        .offerTo(exporter, String.valueOf(Identifier.of(Prixilium.MOD_ID, inputId.getPath() + "i_upgraded_to_tear_iii")));
            }
        };
    }

    @Override
    public String getName() {
        return "Prixilium recipes.";
    }
}
