package net.napsternpt.prixilium.util;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.napsternpt.prixilium.Prixilium;
import net.napsternpt.prixilium.block.ModBlocks;
import net.napsternpt.prixilium.item.ModItems;

public class ModItemGroups {

    public static final ItemGroup PRIXILIUM_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(Prixilium.MOD_ID, "prixilium"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModBlocks.PRIXILIUM))
                    .displayName(Text.translatable("itemgroup.prixilium.prixilium"))
                    .entries((displayContext, entries) -> {

                        //region [Items]

                        entries.add(ModItems.VIRUS_ALIVE);
                        entries.add(ModItems.VIRUS_DEAD);
                        entries.add(ModItems.THERMOMETER);
                        entries.add(ModItems.PRIXILIUM_UPGRADE_SMITHING_TEMPLATE);
                        entries.add(ModItems.PRIXILIUM_HOOK);
                        entries.add(ModItems.BLIKO_SPAWN_EGG);
                        entries.add(ModItems.BLOKITO_SPAWN_EGG);
                        entries.add(ModItems.AIRIS_SPAWN_EGG);

                        entries.add(ModItems.CHARM_I);
                        entries.add(ModItems.CONTAINER_CHARM_I);
                        entries.add(ModItems.STASIS_CHARM_I);
                        entries.add(ModItems.REGENERATION_CHARM_I);
                        entries.add(ModItems.POSTMORTAL_CHARM_I);
                        entries.add(ModItems.STOPWATCH_CHARM_I);
                        entries.add(ModItems.IMMUNITY_CHARM_I);
                        entries.add(ModItems.SONIC_BOOM_CHARM_I);
                        entries.add(ModItems.WITHER_CHARM_I);
                        entries.add(ModItems.CHARM_II);
                        entries.add(ModItems.CONTAINER_CHARM_II);
                        entries.add(ModItems.STASIS_CHARM_II);
                        entries.add(ModItems.REGENERATION_CHARM_II);
                        entries.add(ModItems.POSTMORTAL_CHARM_II);
                        entries.add(ModItems.STOPWATCH_CHARM_II);
                        entries.add(ModItems.IMMUNITY_CHARM_II);
                        entries.add(ModItems.SONIC_BOOM_CHARM_II);
                        entries.add(ModItems.WITHER_CHARM_II);
                        entries.add(ModItems.CHARM_III);
                        entries.add(ModItems.CONTAINER_CHARM_III);
                        entries.add(ModItems.STASIS_CHARM_III);
                        entries.add(ModItems.REGENERATION_CHARM_III);
                        entries.add(ModItems.POSTMORTAL_CHARM_III);
                        entries.add(ModItems.STOPWATCH_CHARM_III);
                        entries.add(ModItems.IMMUNITY_CHARM_III);
                        entries.add(ModItems.SONIC_BOOM_CHARM_III);
                        entries.add(ModItems.WITHER_CHARM_III);

                        //endregion

                        //region [Blocks]

                        entries.add(ModBlocks.PRIXILIUM);
                        entries.add(ModBlocks.PRIXILIUM_GRASS);
                        entries.add(ModBlocks.PRIXILIUM_LEAVES);
                        entries.add(ModBlocks.PRIXILIUM_LOG);
                        entries.add(ModBlocks.PRIXILIUM_WOOD);
                        entries.add(ModBlocks.PRIXILIUM_PLANKS);
                        entries.add(ModBlocks.PRIXILIUM_STAIRS);
                        entries.add(ModBlocks.PRIXILIUM_SLAB);
                        entries.add(ModBlocks.PRIXILIUM_FENCE);
                        entries.add(ModBlocks.PRIXILIUM_FENCE_GATE);
                        entries.add(ModBlocks.PRIXILIUM_DOOR);
                        entries.add(ModBlocks.PRIXILIUM_TRAPDOOR);
                        entries.add(ModBlocks.PRIXILIUM_BRICKS);
                        entries.add(ModBlocks.CRACKED_PRIXILIUM_BRICKS);
                        entries.add(ModBlocks.CHISELED_PRIXILIUM_BRICKS);
                        entries.add(ModBlocks.PRIXILIUM_GRATE);
                        entries.add(ModBlocks.PRIXILIUM_BRICK_STAIRS);
                        entries.add(ModBlocks.PRIXILIUM_BRICK_SLAB);
                        entries.add(ModBlocks.PRIXILIUM_BRICKS_WALL);
                        entries.add(ModBlocks.DARK_PRIXILIUM_BRICKS);
                        entries.add(ModBlocks.CRACKED_DARK_PRIXILIUM_BRICKS);
                        entries.add(ModBlocks.CHISELED_DARK_PRIXILIUM_BRICKS);
                        entries.add(ModBlocks.DARK_PRIXILIUM_GRATE);
                        entries.add(ModBlocks.DARK_PRIXILIUM_BRICK_STAIRS);
                        entries.add(ModBlocks.DARK_PRIXILIUM_BRICK_SLAB);
                        entries.add(ModBlocks.DARK_PRIXILIUM_BRICKS_WALL);
                        entries.add(ModBlocks.PRIXILIUM_EXHAUST);
                        entries.add(ModBlocks.PRIXILIUM_LAMP);
                        entries.add(ModBlocks.STAND);
                        entries.add(ModBlocks.REACTOR_CORE);
                        entries.add(ModBlocks.VIRUS_REACTOR);
                        //endregion

                    }).build());

    public static final ItemGroup PRIXILED_ITEMS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(Prixilium.MOD_ID, "prixiled_items"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.PRIXILED_DIAMOND_SWORD))
                    .displayName(Text.translatable("itemgroup.prixilium.prixiled_items"))
                    .entries((displayContext, entries) -> {

                        //region [Tools]

                        //region [wood]
                        entries.add(ModItems.PRIXILED_WOODEN_SWORD);
                        entries.add(ModItems.PRIXILED_WOODEN_PICKAXE);
                        entries.add(ModItems.PRIXILED_WOODEN_AXE);
                        entries.add(ModItems.PRIXILED_WOODEN_SHOVEL);
                        entries.add(ModItems.PRIXILED_WOODEN_HOE);
                        //endregion

                        //region [stone]
                        entries.add(ModItems.PRIXILED_STONE_SWORD);
                        entries.add(ModItems.PRIXILED_STONE_PICKAXE);
                        entries.add(ModItems.PRIXILED_STONE_AXE);
                        entries.add(ModItems.PRIXILED_STONE_SHOVEL);
                        entries.add(ModItems.PRIXILED_STONE_HOE);
                        //endregion

                        //region [copper]
                        /* 1.21.9+
                        entries.add(ModItems.PRIXILED_COPPER_SWORD);
                        entries.add(ModItems.PRIXILED_COPPER_PICKAXE);
                        entries.add(ModItems.PRIXILED_COPPER_AXE);
                        entries.add(ModItems.PRIXILED_COPPER_SHOVEL);
                        entries.add(ModItems.PRIXILED_COPPER_HOE);
                         */
                        //endregion

                        //region [iron]
                        entries.add(ModItems.PRIXILED_IRON_SWORD);
                        entries.add(ModItems.PRIXILED_IRON_PICKAXE);
                        entries.add(ModItems.PRIXILED_IRON_AXE);
                        entries.add(ModItems.PRIXILED_IRON_SHOVEL);
                        entries.add(ModItems.PRIXILED_IRON_HOE);
                        //endregion

                        //region [gold]
                        entries.add(ModItems.PRIXILED_GOLDEN_SWORD);
                        entries.add(ModItems.PRIXILED_GOLDEN_PICKAXE);
                        entries.add(ModItems.PRIXILED_GOLDEN_AXE);
                        entries.add(ModItems.PRIXILED_GOLDEN_SHOVEL);
                        entries.add(ModItems.PRIXILED_GOLDEN_HOE);
                        //endregion

                        //region [diamond]
                        entries.add(ModItems.PRIXILED_DIAMOND_SWORD);
                        entries.add(ModItems.PRIXILED_DIAMOND_PICKAXE);
                        entries.add(ModItems.PRIXILED_DIAMOND_AXE);
                        entries.add(ModItems.PRIXILED_DIAMOND_SHOVEL);
                        entries.add(ModItems.PRIXILED_DIAMOND_HOE);
                        //endregion

                        //region [netherite]
                        entries.add(ModItems.PRIXILED_NETHERITE_SWORD);
                        entries.add(ModItems.PRIXILED_NETHERITE_PICKAXE);
                        entries.add(ModItems.PRIXILED_NETHERITE_AXE);
                        entries.add(ModItems.PRIXILED_NETHERITE_SHOVEL);
                        entries.add(ModItems.PRIXILED_NETHERITE_HOE);
                        //endregion

                        entries.add(ModItems.PRIXILED_BOW);
                        entries.add(ModItems.PRIXILED_MACE);

                        //endregion

                        //region [Armors]

                        //region [leather]
                        entries.add(ModItems.PRIXILED_LEATHER_HELMET);
                        entries.add(ModItems.PRIXILED_LEATHER_CHESTPLATE);
                        entries.add(ModItems.PRIXILED_LEATHER_LEGGINGS);
                        entries.add(ModItems.PRIXILED_LEATHER_BOOTS);
                        //endregion

                        //region [chainmail]
                        entries.add(ModItems.PRIXILED_CHAINMAIL_HELMET);
                        entries.add(ModItems.PRIXILED_CHAINMAIL_CHESTPLATE);
                        entries.add(ModItems.PRIXILED_CHAINMAIL_LEGGINGS);
                        entries.add(ModItems.PRIXILED_CHAINMAIL_BOOTS);
                        //endregion

                        //region [copper]
                        /* 1.21.9+
                        entries.add(ModItems.PRIXILED_COPPER_HELMET);
                        entries.add(ModItems.PRIXILED_COPPER_CHESTPLATE);
                        entries.add(ModItems.PRIXILED_COPPER_LEGGINGS);
                        entries.add(ModItems.PRIXILED_COPPER_BOOTS);
                         */
                        //endregion

                        //region [iron]
                        entries.add(ModItems.PRIXILED_IRON_HELMET);
                        entries.add(ModItems.PRIXILED_IRON_CHESTPLATE);
                        entries.add(ModItems.PRIXILED_IRON_LEGGINGS);
                        entries.add(ModItems.PRIXILED_IRON_BOOTS);
                        //endregion

                        //region [golden]
                        entries.add(ModItems.PRIXILED_GOLDEN_HELMET);
                        entries.add(ModItems.PRIXILED_GOLDEN_CHESTPLATE);
                        entries.add(ModItems.PRIXILED_GOLDEN_LEGGINGS);
                        entries.add(ModItems.PRIXILED_GOLDEN_BOOTS);
                        //endregion

                        //region [diamond]
                        entries.add(ModItems.PRIXILED_DIAMOND_HELMET);
                        entries.add(ModItems.PRIXILED_DIAMOND_CHESTPLATE);
                        entries.add(ModItems.PRIXILED_DIAMOND_LEGGINGS);
                        entries.add(ModItems.PRIXILED_DIAMOND_BOOTS);
                        //endregion

                        //region [netherite]
                        entries.add(ModItems.PRIXILED_NETHERITE_HELMET);
                        entries.add(ModItems.PRIXILED_NETHERITE_CHESTPLATE);
                        entries.add(ModItems.PRIXILED_NETHERITE_LEGGINGS);
                        entries.add(ModItems.PRIXILED_NETHERITE_BOOTS);
                        //endregion

                        //region [turtle]
                        entries.add(ModItems.PRIXILED_TURTLE_HELMET);
                        //endregion

                        //region [horse]
                        entries.add(ModItems.PRIXILED_LEATHER_HORSE_ARMOR);
                        // 1.21.9+ entries.add(ModItems.PRIXILED_COPPER_HORSE_ARMOR);
                        entries.add(ModItems.PRIXILED_IRON_HORSE_ARMOR);
                        entries.add(ModItems.PRIXILED_GOLDEN_HORSE_ARMOR);
                        entries.add(ModItems.PRIXILED_DIAMOND_HORSE_ARMOR);
                        // 1.21.11+ entries.add(ModItems.PRIXILED_NETHERITE_HORSE_ARMOR);
                        //endregion

                        //endregion

                    }).build());

    public static void registerItemGroups() {Prixilium.LOGGER.info("Registering Prixilium Item Groups.");}
}
