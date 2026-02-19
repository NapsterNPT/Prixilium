package net.napsternpt.prixilium.item;

import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.DyedColorComponent;
import net.minecraft.component.type.UnbreakableComponent;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.registry.Registry;
import net.minecraft.registry.Registries;
import net.napsternpt.prixilium.Prixilium;
import net.napsternpt.prixilium.item.custom.*;

public class ModItems {
    public static final Item PRIXILIUM_VIRUS_ALIVE = registerItem("prixilium_virus_alive", new PrixiliumVirusAliveItem(new Item.Settings()
            .maxCount(1)
            .maxDamage(100)
    ));
    public static final Item PRIXILIUM_VIRUS_DEAD = registerItem("prixilium_virus_dead", new Item(new Item.Settings()));

    public static final Item PRIXILIUM_UPGRADE_SMITHING_TEMPLATE = registerItem("prixilium_upgrade_smithing_template", new Item(new Item.Settings()));
    public static final Item PRIXILIUM_HOOK = registerItem("prixilium_hook", new PrixiliumHookItem(new Item.Settings()
            .maxDamage(32)
    ));

    //region [Tools]

    //region [wood]
    public static final Item PRIXILED_WOODEN_SWORD = registerItem("prixiled_wooden_sword", new SwordItem(ToolMaterials.WOOD, new Item.Settings()
            .component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(true))
            .attributeModifiers(SwordItem.createAttributeModifiers(ToolMaterials.WOOD, 3, -2.4F))
    ));
    public static final Item PRIXILED_WOODEN_PICKAXE = registerItem("prixiled_wooden_pickaxe", new PickaxeItem(ToolMaterials.WOOD, new Item.Settings()
            .component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(true))
            .attributeModifiers(PickaxeItem.createAttributeModifiers(ToolMaterials.WOOD, 1, -2.8F))
    ));
    public static final Item PRIXILED_WOODEN_AXE = registerItem("prixiled_wooden_axe", new AxeItem(ToolMaterials.WOOD, new Item.Settings()
            .component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(true))
            .attributeModifiers(AxeItem.createAttributeModifiers(ToolMaterials.WOOD, 6, -3.2F))
    ));
    public static final Item PRIXILED_WOODEN_SHOVEL = registerItem("prixiled_wooden_shovel", new ShovelItem(ToolMaterials.WOOD, new Item.Settings()
            .component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(true))
            .attributeModifiers(ShovelItem.createAttributeModifiers(ToolMaterials.WOOD, 1.5F, -3))
    ));
    public static final Item PRIXILED_WOODEN_HOE = registerItem("prixiled_wooden_hoe", new HoeItem(ToolMaterials.WOOD, new Item.Settings()
            .component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(true))
            .attributeModifiers(HoeItem.createAttributeModifiers(ToolMaterials.WOOD, 0, -3))
    ));
    //endregion

    //region [stone]
    public static final Item PRIXILED_STONE_SWORD = registerItem("prixiled_stone_sword", new SwordItem(ToolMaterials.STONE, new Item.Settings()
            .component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(true))
            .attributeModifiers(SwordItem.createAttributeModifiers(ToolMaterials.STONE, 3, -2.4F))
    ));
    public static final Item PRIXILED_STONE_PICKAXE = registerItem("prixiled_stone_pickaxe", new PickaxeItem(ToolMaterials.STONE, new Item.Settings()
            .component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(true))
            .attributeModifiers(PickaxeItem.createAttributeModifiers(ToolMaterials.STONE, 1, -2.8F))
    ));
    public static final Item PRIXILED_STONE_AXE = registerItem("prixiled_stone_axe", new AxeItem(ToolMaterials.STONE, new Item.Settings()
            .component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(true))
            .attributeModifiers(AxeItem.createAttributeModifiers(ToolMaterials.STONE, 7, -3.2F))
    ));
    public static final Item PRIXILED_STONE_SHOVEL = registerItem("prixiled_stone_shovel", new ShovelItem(ToolMaterials.STONE, new Item.Settings()
            .component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(true))
            .attributeModifiers(ShovelItem.createAttributeModifiers(ToolMaterials.STONE, 1.5F, -3))
    ));
    public static final Item PRIXILED_STONE_HOE = registerItem("prixiled_stone_hoe", new HoeItem(ToolMaterials.STONE, new Item.Settings()
            .component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(true))
            .attributeModifiers(HoeItem.createAttributeModifiers(ToolMaterials.STONE, -1, -2))
    ));
    //endregion

    //region [copper]
    /* 1.21.9+
    public static final Item PRIXILED_COPPER_SWORD = registerItem("prixiled_copper_sword", new SwordItem(ToolMaterials.COPPER, new Item.Settings()
            .component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(true))
            .attributeModifiers(SwordItem.createAttributeModifiers(ToolMaterials.COPPER, idk, idk))
    ));
    public static final Item PRIXILED_COPPER_PICKAXE = registerItem("prixiled_copper_pickaxe", new PickaxeItem(ToolMaterials.COPPER, new Item.Settings()
            .component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(true))
            .attributeModifiers(PickaxeItem.createAttributeModifiers(ToolMaterials.COPPER, idk, idk))
    ));
    public static final Item PRIXILED_COPPER_AXE = registerItem("prixiled_copper_axe", new AxeItem(ToolMaterials.COPPER, new Item.Settings()
            .component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(true))
            .attributeModifiers(AxeItem.createAttributeModifiers(ToolMaterials.COPPER, idk, idk))
    ));
    public static final Item PRIXILED_COPPER_SHOVEL = registerItem("prixiled_copper_shovel", new ShovelItem(ToolMaterials.COPPER, new Item.Settings()
            .component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(true))
            .attributeModifiers(ShovelItem.createAttributeModifiers(ToolMaterials.COPPER, idk, idk))
    ));
    public static final Item PRIXILED_COPPER_HOE = registerItem("prixiled_copper_hoe", new HoeItem(ToolMaterials.COPPER, new Item.Settings()
            .component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(true))
            .attributeModifiers(HoeItem.createAttributeModifiers(ToolMaterials.COPPER, idk, idk))
    ));
     */
    //endregion

    //region [iron]
    public static final Item PRIXILED_IRON_SWORD = registerItem("prixiled_iron_sword", new SwordItem(ToolMaterials.IRON, new Item.Settings()
            .component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(true))
            .attributeModifiers(SwordItem.createAttributeModifiers(ToolMaterials.IRON, 3, -2.4F))
    ));
    public static final Item PRIXILED_IRON_PICKAXE = registerItem("prixiled_iron_pickaxe", new PickaxeItem(ToolMaterials.IRON, new Item.Settings()
            .component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(true))
            .attributeModifiers(PickaxeItem.createAttributeModifiers(ToolMaterials.IRON, 1, -2.8F))
    ));
    public static final Item PRIXILED_IRON_AXE = registerItem("prixiled_iron_axe", new AxeItem(ToolMaterials.IRON, new Item.Settings()
            .component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(true))
            .attributeModifiers(AxeItem.createAttributeModifiers(ToolMaterials.IRON, 6, -3.1F))
    ));
    public static final Item PRIXILED_IRON_SHOVEL = registerItem("prixiled_iron_shovel", new ShovelItem(ToolMaterials.IRON, new Item.Settings()
            .component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(true))
            .attributeModifiers(ShovelItem.createAttributeModifiers(ToolMaterials.IRON, 1.5F, -3))
    ));
    public static final Item PRIXILED_IRON_HOE = registerItem("prixiled_iron_hoe", new HoeItem(ToolMaterials.IRON, new Item.Settings()
            .component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(true))
            .attributeModifiers(HoeItem.createAttributeModifiers(ToolMaterials.IRON,-2, -1))
    ));
    //endregion

    //region [gold]
    public static final Item PRIXILED_GOLDEN_SWORD = registerItem("prixiled_golden_sword", new SwordItem(ToolMaterials.GOLD, new Item.Settings()
            .component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(true))
            .attributeModifiers(SwordItem.createAttributeModifiers(ToolMaterials.GOLD, 3, -2.4F))
    ));
    public static final Item PRIXILED_GOLDEN_PICKAXE = registerItem("prixiled_golden_pickaxe", new PickaxeItem(ToolMaterials.GOLD, new Item.Settings()
            .component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(true))
            .attributeModifiers(PickaxeItem.createAttributeModifiers(ToolMaterials.GOLD, 1, -2.8F))
    ));
    public static final Item PRIXILED_GOLDEN_AXE = registerItem("prixiled_golden_axe", new AxeItem(ToolMaterials.GOLD, new Item.Settings()
            .component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(true))
            .attributeModifiers(AxeItem.createAttributeModifiers(ToolMaterials.GOLD, 6, -3))
    ));
    public static final Item PRIXILED_GOLDEN_SHOVEL = registerItem("prixiled_golden_shovel", new ShovelItem(ToolMaterials.GOLD, new Item.Settings()
            .component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(true))
            .attributeModifiers(ShovelItem.createAttributeModifiers(ToolMaterials.GOLD, 1.5F, -3))
    ));
    public static final Item PRIXILED_GOLDEN_HOE = registerItem("prixiled_golden_hoe", new HoeItem(ToolMaterials.GOLD, new Item.Settings()
            .component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(true))
            .attributeModifiers(HoeItem.createAttributeModifiers(ToolMaterials.GOLD,0, -3))
    ));
    //endregion

    //region [diamond]
    public static final Item PRIXILED_DIAMOND_SWORD = registerItem("prixiled_diamond_sword", new SwordItem(ToolMaterials.DIAMOND, new Item.Settings()
            .component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(true))
            .attributeModifiers(SwordItem.createAttributeModifiers(ToolMaterials.DIAMOND, 3, -2.4F))
    ));
    public static final Item PRIXILED_DIAMOND_PICKAXE = registerItem("prixiled_diamond_pickaxe", new PickaxeItem(ToolMaterials.DIAMOND, new Item.Settings()
            .component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(true))
            .attributeModifiers(PickaxeItem.createAttributeModifiers(ToolMaterials.DIAMOND, 1, -2.8F))
    ));
    public static final Item PRIXILED_DIAMOND_AXE = registerItem("prixiled_diamond_axe", new AxeItem(ToolMaterials.DIAMOND, new Item.Settings()
            .component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(true))
            .attributeModifiers(AxeItem.createAttributeModifiers(ToolMaterials.DIAMOND, 5, -3))
    ));
    public static final Item PRIXILED_DIAMOND_SHOVEL = registerItem("prixiled_diamond_shovel", new ShovelItem(ToolMaterials.DIAMOND, new Item.Settings()
            .component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(true))
            .attributeModifiers(ShovelItem.createAttributeModifiers(ToolMaterials.DIAMOND, 1.5F, -3))
    ));
    public static final Item PRIXILED_DIAMOND_HOE = registerItem("prixiled_diamond_hoe", new HoeItem(ToolMaterials.DIAMOND, new Item.Settings()
            .component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(true))
            .attributeModifiers(HoeItem.createAttributeModifiers(ToolMaterials.DIAMOND,-3, 0))
    ));
    //endregion

    //region [netherite]
    public static final Item PRIXILED_NETHERITE_SWORD = registerItem("prixiled_netherite_sword", new SwordItem(ToolMaterials.NETHERITE, new Item.Settings()
            .component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(true))
            .attributeModifiers(SwordItem.createAttributeModifiers(ToolMaterials.NETHERITE, 3, -2.4F))
            .fireproof()
    ));
    public static final Item PRIXILED_NETHERITE_PICKAXE = registerItem("prixiled_netherite_pickaxe", new PickaxeItem(ToolMaterials.NETHERITE, new Item.Settings()
            .component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(true))
            .attributeModifiers(PickaxeItem.createAttributeModifiers(ToolMaterials.NETHERITE, 1, -2.8F))
            .fireproof()
    ));
    public static final Item PRIXILED_NETHERITE_AXE = registerItem("prixiled_netherite_axe", new AxeItem(ToolMaterials.NETHERITE, new Item.Settings()
            .component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(true))
            .attributeModifiers(AxeItem.createAttributeModifiers(ToolMaterials.NETHERITE, 5, -3))
            .fireproof()
    ));
    public static final Item PRIXILED_NETHERITE_SHOVEL = registerItem("prixiled_netherite_shovel", new ShovelItem(ToolMaterials.NETHERITE, new Item.Settings()
            .component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(true))
            .attributeModifiers(ShovelItem.createAttributeModifiers(ToolMaterials.NETHERITE, 1.5F, -3))
            .fireproof()
    ));
    public static final Item PRIXILED_NETHERITE_HOE = registerItem("prixiled_netherite_hoe", new HoeItem(ToolMaterials.NETHERITE, new Item.Settings()
            .component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(true))
            .attributeModifiers(HoeItem.createAttributeModifiers(ToolMaterials.NETHERITE,-4, 0))
            .fireproof()
    ));
    //endregion

    //endregion


    //region [Armors]

    //region [leather]
    public static final Item PRIXILED_LEATHER_HELMET = registerItem("prixiled_leather_helmet", new ArmorItem(ModArmorMaterials.PRIXILIUM_LEATHER, ArmorItem.Type.HELMET, new Item.Settings()
            .maxCount(1)
            .component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(true))
            .component(DataComponentTypes.DYED_COLOR, new DyedColorComponent(0xA06540, false))
    ));

    public static final Item PRIXILED_LEATHER_CHESTPLATE = registerItem("prixiled_leather_chestplate", new ArmorItem(ModArmorMaterials.PRIXILIUM_LEATHER, ArmorItem.Type.CHESTPLATE, new Item.Settings()
            .maxCount(1)
            .component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(true))
            .component(DataComponentTypes.DYED_COLOR, new DyedColorComponent(0xA06540, false))
    ));

    public static final Item PRIXILED_LEATHER_LEGGINGS = registerItem("prixiled_leather_leggings", new ArmorItem(ModArmorMaterials.PRIXILIUM_LEATHER, ArmorItem.Type.LEGGINGS, new Item.Settings()
            .maxCount(1)
            .component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(true))
            .component(DataComponentTypes.DYED_COLOR, new DyedColorComponent(0xA06540, false))
    ));

    public static final Item PRIXILED_LEATHER_BOOTS = registerItem("prixiled_leather_boots", new ArmorItem(ModArmorMaterials.PRIXILIUM_LEATHER, ArmorItem.Type.BOOTS, new Item.Settings()
            .maxCount(1)
            .component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(true))
            .component(DataComponentTypes.DYED_COLOR, new DyedColorComponent(0xA06540, false))
    ));
    //endregion

    //region [chainmail]
    public static final Item PRIXILED_CHAINMAIL_HELMET = registerItem("prixiled_chainmail_helmet", new ArmorItem(ModArmorMaterials.PRIXILIUM_CHAIN, ArmorItem.Type.HELMET, new Item.Settings()
            .maxCount(1)
            .component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(true))
    ));

    public static final Item PRIXILED_CHAINMAIL_CHESTPLATE = registerItem("prixiled_chainmail_chestplate", new ArmorItem(ModArmorMaterials.PRIXILIUM_CHAIN, ArmorItem.Type.CHESTPLATE, new Item.Settings()
            .maxCount(1)
            .component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(true))
    ));

    public static final Item PRIXILED_CHAINMAIL_LEGGINGS = registerItem("prixiled_chainmail_leggings", new ArmorItem(ModArmorMaterials.PRIXILIUM_CHAIN, ArmorItem.Type.LEGGINGS, new Item.Settings()
            .maxCount(1)
            .component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(true))
    ));

    public static final Item PRIXILED_CHAINMAIL_BOOTS = registerItem("prixiled_chainmail_boots", new ArmorItem(ModArmorMaterials.PRIXILIUM_CHAIN, ArmorItem.Type.BOOTS, new Item.Settings()
            .maxCount(1)
            .component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(true))
    ));
    //endregion

    //region [copper]
    /* 1.21.9+
    public static final Item PRIXILED_COPPER_HELMET = registerItem("prixiled_copper_helmet", new ArmorItem(ModArmorMaterials.PRIXILIUM_COPPER, ArmorItem.Type.HELMET, new Item.Settings()
            .maxCount(1)
            .component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(true))
    ));

    public static final Item PRIXILED_COPPER_CHESTPLATE = registerItem("prixiled_copper_chestplate", new ArmorItem(ModArmorMaterials.PRIXILIUM_COPPER, ArmorItem.Type.CHESTPLATE, new Item.Settings()
            .maxCount(1)
            .component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(true))
    ));

    public static final Item PRIXILED_COPPER_LEGGINGS = registerItem("prixiled_copper_leggings", new ArmorItem(ModArmorMaterials.PRIXILIUM_COPPER, ArmorItem.Type.LEGGINGS, new Item.Settings()
            .maxCount(1)
            .component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(true))
    ));

    public static final Item PRIXILED_COPPER_BOOTS = registerItem("prixiled_copper_boots", new ArmorItem(ModArmorMaterials.PRIXILIUM_COPPER, ArmorItem.Type.BOOTS, new Item.Settings()
            .maxCount(1)
            .component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(true))
    ));
     */
    //endregion

    //region [iron]
    public static final Item PRIXILED_IRON_HELMET = registerItem("prixiled_iron_helmet", new ArmorItem(ModArmorMaterials.PRIXILIUM_IRON, ArmorItem.Type.HELMET, new Item.Settings()
            .maxCount(1)
            .component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(true))));

    public static final Item PRIXILED_IRON_CHESTPLATE = registerItem("prixiled_iron_chestplate", new ArmorItem(ModArmorMaterials.PRIXILIUM_IRON, ArmorItem.Type.CHESTPLATE, new Item.Settings()
            .maxCount(1)
            .component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(true))));

    public static final Item PRIXILED_IRON_LEGGINGS = registerItem("prixiled_iron_leggings", new ArmorItem(ModArmorMaterials.PRIXILIUM_IRON, ArmorItem.Type.LEGGINGS, new Item.Settings()
            .maxCount(1)
            .component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(true))));

    public static final Item PRIXILED_IRON_BOOTS = registerItem("prixiled_iron_boots", new ArmorItem(ModArmorMaterials.PRIXILIUM_IRON, ArmorItem.Type.BOOTS, new Item.Settings()
            .maxCount(1)
            .component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(true))));
    //endregion

    //region [gold]
    public static final Item PRIXILED_GOLDEN_HELMET = registerItem("prixiled_golden_helmet", new ArmorItem(ModArmorMaterials.PRIXILIUM_GOLD, ArmorItem.Type.HELMET, new Item.Settings()
            .maxCount(1)
            .component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(true))));

    public static final Item PRIXILED_GOLDEN_CHESTPLATE = registerItem("prixiled_golden_chestplate", new ArmorItem(ModArmorMaterials.PRIXILIUM_GOLD, ArmorItem.Type.CHESTPLATE, new Item.Settings()
            .maxCount(1)
            .component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(true))));

    public static final Item PRIXILED_GOLDEN_LEGGINGS = registerItem("prixiled_golden_leggings", new ArmorItem(ModArmorMaterials.PRIXILIUM_GOLD, ArmorItem.Type.LEGGINGS, new Item.Settings()
            .maxCount(1)
            .component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(true))));

    public static final Item PRIXILED_GOLDEN_BOOTS = registerItem("prixiled_golden_boots", new ArmorItem(ModArmorMaterials.PRIXILIUM_GOLD, ArmorItem.Type.BOOTS, new Item.Settings()
            .maxCount(1)
            .component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(true))));
    //endregion

    //region [diamond]
    public static final Item PRIXILED_DIAMOND_HELMET = registerItem("prixiled_diamond_helmet", new ArmorItem(ModArmorMaterials.PRIXILIUM_DIAMOND, ArmorItem.Type.HELMET, new Item.Settings()
            .maxCount(1)
            .component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(true))));

    public static final Item PRIXILED_DIAMOND_CHESTPLATE = registerItem("prixiled_diamond_chestplate", new ArmorItem(ModArmorMaterials.PRIXILIUM_DIAMOND, ArmorItem.Type.CHESTPLATE, new Item.Settings()
            .maxCount(1)
            .component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(true))));

    public static final Item PRIXILED_DIAMOND_LEGGINGS = registerItem("prixiled_diamond_leggings", new ArmorItem(ModArmorMaterials.PRIXILIUM_DIAMOND, ArmorItem.Type.LEGGINGS, new Item.Settings()
            .maxCount(1)
            .component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(true))));

    public static final Item PRIXILED_DIAMOND_BOOTS = registerItem("prixiled_diamond_boots", new ArmorItem(ModArmorMaterials.PRIXILIUM_DIAMOND, ArmorItem.Type.BOOTS, new Item.Settings()
            .maxCount(1)
            .component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(true))));
    //endregion

    //region [netherite]
    public static final Item PRIXILED_NETHERITE_HELMET = registerItem("prixiled_netherite_helmet", new ArmorItem(ModArmorMaterials.PRIXILIUM_NETHERITE, ArmorItem.Type.HELMET, new Item.Settings()
            .maxCount(1)
            .component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(true))
            .fireproof()
    ));

    public static final Item PRIXILED_NETHERITE_CHESTPLATE = registerItem("prixiled_netherite_chestplate", new ArmorItem(ModArmorMaterials.PRIXILIUM_NETHERITE, ArmorItem.Type.CHESTPLATE, new Item.Settings()
            .maxCount(1)
            .component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(true))
            .fireproof()
    ));

    public static final Item PRIXILED_NETHERITE_LEGGINGS = registerItem("prixiled_netherite_leggings", new ArmorItem(ModArmorMaterials.PRIXILIUM_NETHERITE, ArmorItem.Type.LEGGINGS, new Item.Settings()
            .maxCount(1)
            .component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(true))
            .fireproof()
    ));

    public static final Item PRIXILED_NETHERITE_BOOTS = registerItem("prixiled_netherite_boots", new ArmorItem(ModArmorMaterials.PRIXILIUM_NETHERITE, ArmorItem.Type.BOOTS, new Item.Settings()
            .maxCount(1)
            .component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(true))
            .fireproof()
    ));
    //endregion

    //region [turtle]
    public static final Item PRIXILED_TURTLE_HELMET = registerItem("prixiled_turtle_helmet", new ArmorItem(ModArmorMaterials.PRIXILIUM_TURTLE, ArmorItem.Type.HELMET, new Item.Settings()
            .maxCount(1)
            .component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(true))));
    //endregion

    //endregion

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(Prixilium.MOD_ID, name), item);
    }

    public static void registerModItems() {
        Prixilium.LOGGER.info("Registering Prixilium Items");
    }
}
