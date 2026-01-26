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

    public static final ItemGroup PRIXILIUM_ITEMS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(Prixilium.MOD_ID, "prixilium_items"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.PRIXILIUM))
                    .displayName(Text.translatable("itemgroup.prixilium.prixilium_items"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.PRIXILIUM);
                        entries.add(ModItems.PACKED_PRIXILIUM);
                        entries.add(ModItems.PRIXILIUM_UPGRADE_SMITHING_TEMPLATE);
                    }).build());

    public static final ItemGroup PRIXILIUM_COMBAT_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(Prixilium.MOD_ID, "prixilium_combat"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.PRIXILED_NETHERITE_SWORD))
                    .displayName(Text.translatable("itemgroup.prixilium.prixilium_combat"))
                    .entries((displayContext, entries) -> {


                        //region [Tools]
                        entries.add(ModItems.PRIXILED_WOODEN_SWORD);
                        entries.add(ModItems.PRIXILED_STONE_SWORD);
                        /* 1.21.9+
                        entries.add(ModItems.PRIXILED_COPPER_SWORD);
                         */
                        entries.add(ModItems.PRIXILED_IRON_SWORD);
                        entries.add(ModItems.PRIXILED_GOLDEN_SWORD);
                        entries.add(ModItems.PRIXILED_DIAMOND_SWORD);
                        entries.add(ModItems.PRIXILED_NETHERITE_SWORD);
                        //endregion
                    }).build());

    public static final ItemGroup PRIXILIUM_TOOLS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(Prixilium.MOD_ID, "prixilium_tools"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.PRIXILED_DIAMOND_PICKAXE))
                    .displayName(Text.translatable("itemgroup.prixilium.prixilium_tools"))
                    .entries((displayContext, entries) -> {


                        //region [Tools]
                        //region [wood]
                        entries.add(ModItems.PRIXILED_WOODEN_PICKAXE);
                        entries.add(ModItems.PRIXILED_WOODEN_AXE);
                        entries.add(ModItems.PRIXILED_WOODEN_SHOVEL);
                        entries.add(ModItems.PRIXILED_WOODEN_HOE);
                        //endregion
                        //region [stone]
                        entries.add(ModItems.PRIXILED_STONE_PICKAXE);
                        entries.add(ModItems.PRIXILED_STONE_AXE);
                        entries.add(ModItems.PRIXILED_STONE_SHOVEL);
                        entries.add(ModItems.PRIXILED_STONE_HOE);
                        //endregion
                        //region [copper]
                        /* 1.21.9+
                        entries.add(ModItems.PRIXILED_COPPER_PICKAXE);
                        entries.add(ModItems.PRIXILED_COPPER_AXE);
                        entries.add(ModItems.PRIXILED_COPPER_SHOVEL);
                        entries.add(ModItems.PRIXILED_COPPER_HOE);
                         */
                        //endregion
                        //region [iron]
                        entries.add(ModItems.PRIXILED_IRON_PICKAXE);
                        entries.add(ModItems.PRIXILED_IRON_AXE);
                        entries.add(ModItems.PRIXILED_IRON_SHOVEL);
                        entries.add(ModItems.PRIXILED_IRON_HOE);
                        //endregion
                        //region [gold]
                        entries.add(ModItems.PRIXILED_GOLDEN_PICKAXE);
                        entries.add(ModItems.PRIXILED_GOLDEN_AXE);
                        entries.add(ModItems.PRIXILED_GOLDEN_SHOVEL);
                        entries.add(ModItems.PRIXILED_GOLDEN_HOE);
                        //endregion
                        //region [diamond]
                        entries.add(ModItems.PRIXILED_DIAMOND_PICKAXE);
                        entries.add(ModItems.PRIXILED_DIAMOND_AXE);
                        entries.add(ModItems.PRIXILED_DIAMOND_SHOVEL);
                        entries.add(ModItems.PRIXILED_DIAMOND_HOE);
                        //endregion
                        //region [netherite]
                        entries.add(ModItems.PRIXILED_NETHERITE_PICKAXE);
                        entries.add(ModItems.PRIXILED_NETHERITE_AXE);
                        entries.add(ModItems.PRIXILED_NETHERITE_SHOVEL);
                        entries.add(ModItems.PRIXILED_NETHERITE_HOE);
                        //endregion
                        //endregion
                    }).build());

    public static final ItemGroup PRIXILIUM_BLOCKS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(Prixilium.MOD_ID, "prixilium_blocks"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModBlocks.PRIXILIUM_GRASS))
                    .displayName(Text.translatable("itemgroup.prixilium.prixilium_blocks"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModBlocks.PRIXILIUM_GRASS);
                        entries.add(ModBlocks.PRIXILIUM_LOG);
                        entries.add(ModBlocks.PRIXILIUM_PLANKS);
                        entries.add(ModBlocks.PRIXILIUM_LEAVES);
                    }).build());

    public static void registerItemGroups() {
        Prixilium.LOGGER.info("Registering Prixilium Item Groups");
    }
}
