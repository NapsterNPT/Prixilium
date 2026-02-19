package net.napsternpt.prixilium.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.napsternpt.prixilium.Prixilium;
import net.napsternpt.prixilium.block.ModBlocks;

public class ModItemGroups {

    public static final ItemGroup PRIXILIUM_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(Prixilium.MOD_ID, "prixilium"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModBlocks.PRIXILIUM))
                    .displayName(Text.translatable("itemgroup.prixilium.prixilium"))
                    .entries((displayContext, entries) -> {

                        //region [Items]

                        entries.add(ModItems.PRIXILIUM_VIRUS_ALIVE);
                        entries.add(ModItems.PRIXILIUM_VIRUS_DEAD);
                        entries.add(ModItems.PRIXILIUM_UPGRADE_SMITHING_TEMPLATE);
                        entries.add(ModItems.PRIXILIUM_HOOK);

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

                        //endregion

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
                        entries.add(ModBlocks.PRIXILIUM_BRICKS_WALL);
                        //endregion

                    }).build());

    public static void registerItemGroups() {
        Prixilium.LOGGER.info("Registering Prixilium Item Groups");
    }
}
