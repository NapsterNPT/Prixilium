package net.napsternpt.prixilium.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.UnbreakableComponent;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.registry.Registry;
import net.minecraft.registry.Registries;
import net.napsternpt.prixilium.Prixilium;

public class ModItems {
    public static final Item PRIXILIUM = registerItem("prixilium", new Item(new Item.Settings()));
    public static final Item PACKED_PRIXILIUM = registerItem("packed_prixilium", new Item(new Item.Settings()));
    public static final Item PRIXILIUM_UPGRADE_SMITHING_TEMPLATE = registerItem("prixilium_upgrade_smithing_template", new Item(new Item.Settings()));

    //region [Tools]

    //region [wood]
    public static final Item PRIXILED_WOODEN_SWORD = registerItem("prixiled_wooden_sword", new SwordItem(ToolMaterials.WOOD, new Item.Settings()
            .component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(true))
            .attributeModifiers(SwordItem.createAttributeModifiers(ToolMaterials.WOOD, 3, -2.4F))
    ));
    public static final Item PRIXILED_WOODEN_PICKAXE = registerItem("prixiled_wooden_pickaxe", new Item(new Item.Settings()
    ));
    public static final Item PRIXILED_WOODEN_AXE = registerItem("prixiled_wooden_axe", new AxeItem(ToolMaterials.WOOD, new Item.Settings()
            .component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(true))
            .attributeModifiers(AxeItem.createAttributeModifiers(ToolMaterials.WOOD, 6, -3.2F))
    ));
    public static final Item PRIXILED_WOODEN_SHOVEL = registerItem("prixiled_wooden_shovel", new Item(new Item.Settings()
    ));
    public static final Item PRIXILED_WOODEN_HOE = registerItem("prixiled_wooden_hoe", new Item(new Item.Settings()
    ));
    //endregion

    //region [stone]
    public static final Item PRIXILED_STONE_SWORD = registerItem("prixiled_stone_sword", new SwordItem(ToolMaterials.STONE, new Item.Settings()
            .component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(true))
            .attributeModifiers(SwordItem.createAttributeModifiers(ToolMaterials.STONE, 3, -2.4F))
    ));
    public static final Item PRIXILED_STONE_PICKAXE = registerItem("prixiled_stone_pickaxe", new Item(new Item.Settings()
    ));
    public static final Item PRIXILED_STONE_AXE = registerItem("prixiled_stone_axe", new AxeItem(ToolMaterials.STONE, new Item.Settings()
            .component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(true))
            .attributeModifiers(AxeItem.createAttributeModifiers(ToolMaterials.STONE, 7, -3.2F))
    ));
    public static final Item PRIXILED_STONE_SHOVEL = registerItem("prixiled_stone_shovel", new Item(new Item.Settings()
    ));
    public static final Item PRIXILED_STONE_HOE = registerItem("prixiled_stone_hoe", new Item(new Item.Settings()
    ));
    //endregion

    //region [copper]
    /* 1.21.9+
    public static final Item PRIXILED_COPPER_SWORD = registerItem("prixiled_copper_sword", new SwordItem(ToolMaterials.COPPER, new Item.Settings()
            .component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(true))
            .attributeModifiers(SwordItem.createAttributeModifiers(ToolMaterials.COPPER, idk, idkF))
    ));
    public static final Item PRIXILED_COPPER_PICKAXE = registerItem("prixiled_copper_pickaxe", new Item(new Item.Settings()
    ));
    public static final Item PRIXILED_COPPER_AXE = registerItem("prixiled_copper_axe", new AxeItem(ToolMaterials.COPPER, new Item.Settings()
            .component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(true))
            .attributeModifiers(AxeItem.createAttributeModifiers(ToolMaterials.COPPER, idk, idkF))
    ));
    public static final Item PRIXILED_COPPER_SHOVEL = registerItem("prixiled_copper_shovel", new Item(new Item.Settings()
    ));
    public static final Item PRIXILED_COPPER_HOE = registerItem("prixiled_copper_hoe", new Item(new Item.Settings()
    ));
     */
    //endregion

    //region [iron]
    public static final Item PRIXILED_IRON_SWORD = registerItem("prixiled_iron_sword", new SwordItem(ToolMaterials.IRON, new Item.Settings()
            .component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(true))
            .attributeModifiers(SwordItem.createAttributeModifiers(ToolMaterials.IRON, 3, -2.4F))
    ));
    public static final Item PRIXILED_IRON_PICKAXE = registerItem("prixiled_iron_pickaxe", new Item(new Item.Settings()
    ));
    public static final Item PRIXILED_IRON_AXE = registerItem("prixiled_iron_axe", new AxeItem(ToolMaterials.IRON, new Item.Settings()
            .component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(true))
            .attributeModifiers(AxeItem.createAttributeModifiers(ToolMaterials.IRON, 6, -3.1F))
    ));
    public static final Item PRIXILED_IRON_SHOVEL = registerItem("prixiled_iron_shovel", new Item(new Item.Settings()
    ));
    public static final Item PRIXILED_IRON_HOE = registerItem("prixiled_iron_hoe", new Item(new Item.Settings()
    ));
    //endregion

    //region [gold]
    public static final Item PRIXILED_GOLDEN_SWORD = registerItem("prixiled_golden_sword", new SwordItem(ToolMaterials.GOLD, new Item.Settings()
            .component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(true))
            .attributeModifiers(SwordItem.createAttributeModifiers(ToolMaterials.GOLD, 3, -2.4F))
    ));
    public static final Item PRIXILED_GOLDEN_PICKAXE = registerItem("prixiled_golden_pickaxe", new Item(new Item.Settings()
    ));
    public static final Item PRIXILED_GOLDEN_AXE = registerItem("prixiled_golden_axe", new AxeItem(ToolMaterials.GOLD, new Item.Settings()
            .component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(true))
            .attributeModifiers(AxeItem.createAttributeModifiers(ToolMaterials.GOLD, 6, -3.0F))
    ));
    public static final Item PRIXILED_GOLDEN_SHOVEL = registerItem("prixiled_golden_shovel", new Item(new Item.Settings()
    ));
    public static final Item PRIXILED_GOLDEN_HOE = registerItem("prixiled_golden_hoe", new Item(new Item.Settings()
    ));
    //endregion

    //region [diamond]
    public static final Item PRIXILED_DIAMOND_SWORD = registerItem("prixiled_diamond_sword", new SwordItem(ToolMaterials.DIAMOND, new Item.Settings()
            .component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(true))
            .attributeModifiers(SwordItem.createAttributeModifiers(ToolMaterials.DIAMOND, 3, -2.4F))
    ));
    public static final Item PRIXILED_DIAMOND_PICKAXE = registerItem("prixiled_diamond_pickaxe", new Item(new Item.Settings()
    ));
    public static final Item PRIXILED_DIAMOND_AXE = registerItem("prixiled_diamond_axe", new AxeItem(ToolMaterials.DIAMOND, new Item.Settings()
            .component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(true))
            .attributeModifiers(AxeItem.createAttributeModifiers(ToolMaterials.DIAMOND, 5, -3.0F))
    ));
    public static final Item PRIXILED_DIAMOND_SHOVEL = registerItem("prixiled_diamond_shovel", new Item(new Item.Settings()
    ));
    public static final Item PRIXILED_DIAMOND_HOE = registerItem("prixiled_diamond_hoe", new Item(new Item.Settings()
    ));
    //endregion

    //region [netherite]
    public static final Item PRIXILED_NETHERITE_SWORD = registerItem("prixiled_netherite_sword", new SwordItem(ToolMaterials.NETHERITE, new Item.Settings()
            .component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(true))
            .attributeModifiers(SwordItem.createAttributeModifiers(ToolMaterials.NETHERITE, 3, -2.4F))
            .fireproof()
    ));
    public static final Item PRIXILED_NETHERITE_PICKAXE = registerItem("prixiled_netherite_pickaxe", new Item(new Item.Settings()
            .fireproof()
    ));
    public static final Item PRIXILED_NETHERITE_AXE = registerItem("prixiled_netherite_axe", new AxeItem(ToolMaterials.NETHERITE, new Item.Settings()
            .component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(true))
            .attributeModifiers(AxeItem.createAttributeModifiers(ToolMaterials.NETHERITE, 5, -3.0F))
            .fireproof()
    ));
    public static final Item PRIXILED_NETHERITE_SHOVEL = registerItem("prixiled_netherite_shovel", new Item(new Item.Settings()
            .fireproof()
    ));
    public static final Item PRIXILED_NETHERITE_HOE = registerItem("prixiled_netherite_hoe", new Item(new Item.Settings()
            .fireproof()
    ));
    //endregion

    //endregion

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(Prixilium.MOD_ID, name), item);
    }

    public static void registerModItems() {
        Prixilium.LOGGER.info("Registering Prixilium Items");

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(PRIXILIUM);
            entries.add(PACKED_PRIXILIUM);
            entries.add(PRIXILIUM_UPGRADE_SMITHING_TEMPLATE);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(entries -> {


            //region [Tools]
            entries.add(PRIXILED_WOODEN_SWORD);
            entries.add(PRIXILED_STONE_SWORD);
            /* 1.21.9+
            entries.add(PRIXILED_COPPER_SWORD);
             */
            entries.add(PRIXILED_IRON_SWORD);
            entries.add(PRIXILED_GOLDEN_SWORD);
            entries.add(PRIXILED_DIAMOND_SWORD);
            entries.add(PRIXILED_NETHERITE_SWORD);
            //endregion
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(entries -> {


            //region [Tools]
            //region [wood]
            entries.add(PRIXILED_WOODEN_PICKAXE);
            entries.add(PRIXILED_WOODEN_AXE);
            entries.add(PRIXILED_WOODEN_SHOVEL);
            entries.add(PRIXILED_WOODEN_HOE);
            //endregion
            //region [stone]
            entries.add(PRIXILED_STONE_PICKAXE);
            entries.add(PRIXILED_STONE_AXE);
            entries.add(PRIXILED_STONE_SHOVEL);
            entries.add(PRIXILED_STONE_HOE);
            //endregion
            //region [copper]
            /* 1.21.9+
            entries.add(PRIXILED_COPPER_PICKAXE);
            entries.add(PRIXILED_COPPER_AXE);
            entries.add(PRIXILED_COPPER_SHOVEL);
            entries.add(PRIXILED_COPPER_HOE);
             */
            //endregion
            //region [iron]
            entries.add(PRIXILED_IRON_PICKAXE);
            entries.add(PRIXILED_IRON_AXE);
            entries.add(PRIXILED_IRON_SHOVEL);
            entries.add(PRIXILED_IRON_HOE);
            //endregion
            //region [gold]
            entries.add(PRIXILED_GOLDEN_PICKAXE);
            entries.add(PRIXILED_GOLDEN_AXE);
            entries.add(PRIXILED_GOLDEN_SHOVEL);
            entries.add(PRIXILED_GOLDEN_HOE);
            //endregion
            //region [diamond]
            entries.add(PRIXILED_DIAMOND_PICKAXE);
            entries.add(PRIXILED_DIAMOND_AXE);
            entries.add(PRIXILED_DIAMOND_SHOVEL);
            entries.add(PRIXILED_DIAMOND_HOE);
            //endregion
            //region [netherite]
            entries.add(PRIXILED_NETHERITE_PICKAXE);
            entries.add(PRIXILED_NETHERITE_AXE);
            entries.add(PRIXILED_NETHERITE_SHOVEL);
            entries.add(PRIXILED_NETHERITE_HOE);
            //endregion
            //endregion
        });
    }
}
