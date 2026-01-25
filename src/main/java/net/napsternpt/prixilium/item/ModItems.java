package net.napsternpt.prixilium.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.registry.Registry;
import net.minecraft.registry.Registries;
import net.napsternpt.prixilium.Prixilium;

public class ModItems {
    public static final Item PRIXILIUM = registerItem("prixilium", new Item(new Item.Settings()));
    public static final Item PACKED_PRIXILIUM = registerItem("packed_prixilium", new Item(new Item.Settings()));

    //Tools
    // wood
    public static final Item PRIXILED_WOODEN_SWORD = registerItem("prixiled_wooden_sword", new Item(new Item.Settings()));
    public static final Item PRIXILED_WOODEN_PICKAXE = registerItem("prixiled_wooden_pickaxe", new Item(new Item.Settings()));
    public static final Item PRIXILED_WOODEN_AXE = registerItem("prixiled_wooden_axe", new Item(new Item.Settings()));
    public static final Item PRIXILED_WOODEN_SHOVEL = registerItem("prixiled_wooden_shovel", new Item(new Item.Settings()));
    public static final Item PRIXILED_WOODEN_HOE = registerItem("prixiled_wooden_hoe", new Item(new Item.Settings()));
    // stone
    public static final Item PRIXILED_STONE_SWORD = registerItem("prixiled_stone_sword", new Item(new Item.Settings()));
    public static final Item PRIXILED_STONE_PICKAXE = registerItem("prixiled_stone_pickaxe", new Item(new Item.Settings()));
    public static final Item PRIXILED_STONE_AXE = registerItem("prixiled_stone_axe", new Item(new Item.Settings()));
    public static final Item PRIXILED_STONE_SHOVEL = registerItem("prixiled_stone_shovel", new Item(new Item.Settings()));
    public static final Item PRIXILED_STONE_HOE = registerItem("prixiled_stone_hoe", new Item(new Item.Settings()));
    // copper
    /* 1.21.9+
    public static final Item PRIXILED_COPPER_SWORD = registerItem("prixiled_copper_sword", new Item(new Item.Settings()));
    public static final Item PRIXILED_COPPER_PICKAXE = registerItem("prixiled_copper_pickaxe", new Item(new Item.Settings()));
    public static final Item PRIXILED_COPPER_AXE = registerItem("prixiled_copper_axe", new Item(new Item.Settings()));
    public static final Item PRIXILED_COPPER_SHOVEL = registerItem("prixiled_copper_shovel", new Item(new Item.Settings()));
    public static final Item PRIXILED_COPPER_HOE = registerItem("prixiled_copper_hoe", new Item(new Item.Settings()));
     */
    // iron
    public static final Item PRIXILED_IRON_SWORD = registerItem("prixiled_iron_sword", new Item(new Item.Settings()));
    public static final Item PRIXILED_IRON_PICKAXE = registerItem("prixiled_iron_pickaxe", new Item(new Item.Settings()));
    public static final Item PRIXILED_IRON_AXE = registerItem("prixiled_iron_axe", new Item(new Item.Settings()));
    public static final Item PRIXILED_IRON_SHOVEL = registerItem("prixiled_iron_shovel", new Item(new Item.Settings()));
    public static final Item PRIXILED_IRON_HOE = registerItem("prixiled_iron_hoe", new Item(new Item.Settings()));
    // gold
    public static final Item PRIXILED_GOLDEN_SWORD = registerItem("prixiled_golden_sword", new Item(new Item.Settings()));
    public static final Item PRIXILED_GOLDEN_PICKAXE = registerItem("prixiled_golden_pickaxe", new Item(new Item.Settings()));
    public static final Item PRIXILED_GOLDEN_AXE = registerItem("prixiled_golden_axe", new Item(new Item.Settings()));
    public static final Item PRIXILED_GOLDEN_SHOVEL = registerItem("prixiled_golden_shovel", new Item(new Item.Settings()));
    public static final Item PRIXILED_GOLDEN_HOE = registerItem("prixiled_golden_hoe", new Item(new Item.Settings()));
    // diamond
    public static final Item PRIXILED_DIAMOND_SWORD = registerItem("prixiled_diamond_sword", new Item(new Item.Settings()));
    public static final Item PRIXILED_DIAMOND_PICKAXE = registerItem("prixiled_diamond_pickaxe", new Item(new Item.Settings()));
    public static final Item PRIXILED_DIAMOND_AXE = registerItem("prixiled_diamond_axe", new Item(new Item.Settings()));
    public static final Item PRIXILED_DIAMOND_SHOVEL = registerItem("prixiled_diamond_shovel", new Item(new Item.Settings()));
    public static final Item PRIXILED_DIAMOND_HOE = registerItem("prixiled_diamond_hoe", new Item(new Item.Settings()));
    // netherite
    public static final Item PRIXILED_NETHERITE_SWORD = registerItem("prixiled_netherite_sword", new Item(new Item.Settings()));
    public static final Item PRIXILED_NETHERITE_PICKAXE = registerItem("prixiled_netherite_pickaxe", new Item(new Item.Settings()));
    public static final Item PRIXILED_NETHERITE_AXE = registerItem("prixiled_netherite_axe", new Item(new Item.Settings()));
    public static final Item PRIXILED_NETHERITE_SHOVEL = registerItem("prixiled_netherite_shovel", new Item(new Item.Settings()));
    public static final Item PRIXILED_NETHERITE_HOE = registerItem("prixiled_netherite_hoe", new Item(new Item.Settings()));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(Prixilium.MOD_ID, name), item);
    }

    public static void registerModItems() {
        Prixilium.LOGGER.info("Registering Prixilium Items");

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(PRIXILIUM);
            entries.add(PACKED_PRIXILIUM);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(entries -> {
            entries.add(PRIXILED_WOODEN_SWORD);
            entries.add(PRIXILED_STONE_SWORD);
            /* 1.21.9+
            entries.add(PRIXILED_COPPER_SWORD);
             */
            entries.add(PRIXILED_IRON_SWORD);
            entries.add(PRIXILED_GOLDEN_SWORD);
            entries.add(PRIXILED_DIAMOND_SWORD);
            entries.add(PRIXILED_NETHERITE_SWORD);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(entries -> {
            // wooden
            entries.add(PRIXILED_WOODEN_PICKAXE);
            entries.add(PRIXILED_WOODEN_AXE);
            entries.add(PRIXILED_WOODEN_SHOVEL);
            entries.add(PRIXILED_WOODEN_HOE);
            // stone
            entries.add(PRIXILED_STONE_PICKAXE);
            entries.add(PRIXILED_STONE_AXE);
            entries.add(PRIXILED_STONE_SHOVEL);
            entries.add(PRIXILED_STONE_HOE);
            // copper
            /* 1.21.9+
            entries.add(PRIXILED_COPPER_PICKAXE);
            entries.add(PRIXILED_COPPER_AXE);
            entries.add(PRIXILED_COPPER_SHOVEL);
            entries.add(PRIXILED_COPPER_HOE);
             */
            // iron
            entries.add(PRIXILED_IRON_PICKAXE);
            entries.add(PRIXILED_IRON_AXE);
            entries.add(PRIXILED_IRON_SHOVEL);
            entries.add(PRIXILED_IRON_HOE);
            // gold
            entries.add(PRIXILED_GOLDEN_PICKAXE);
            entries.add(PRIXILED_GOLDEN_AXE);
            entries.add(PRIXILED_GOLDEN_SHOVEL);
            entries.add(PRIXILED_GOLDEN_HOE);
            // diamond
            entries.add(PRIXILED_DIAMOND_PICKAXE);
            entries.add(PRIXILED_DIAMOND_AXE);
            entries.add(PRIXILED_DIAMOND_SHOVEL);
            entries.add(PRIXILED_DIAMOND_HOE);
            // netherite
            entries.add(PRIXILED_NETHERITE_PICKAXE);
            entries.add(PRIXILED_NETHERITE_AXE);
            entries.add(PRIXILED_NETHERITE_SHOVEL);
            entries.add(PRIXILED_NETHERITE_HOE);
        });
    }
}
