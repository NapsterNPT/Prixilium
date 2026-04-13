package net.napsternpt.prixilium.item;

import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.DyedColorComponent;
import net.minecraft.component.type.UnbreakableComponent;
import net.minecraft.item.*;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.napsternpt.prixilium.Prixilium;
import net.napsternpt.prixilium.entity.ModEntities;
import net.napsternpt.prixilium.item.custom.PrixiliumHookItem;
import net.napsternpt.prixilium.item.custom.PrixiliumVirusAliveItem;

public class ModItems {
    public static final Item PRIXILIUM_VIRUS_ALIVE = registerItem("prixilium_virus_alive", new PrixiliumVirusAliveItem(new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, "prixilium_virus_alive")))
            .maxCount(1)
            .maxDamage(100)
    ));
    public static final Item PRIXILIUM_VIRUS_DEAD = registerItem("prixilium_virus_dead", new Item(new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, "prixilium_virus_dead")))
    ));

    public static final Item PRIXILIUM_UPGRADE_SMITHING_TEMPLATE = registerItem("prixilium_upgrade_smithing_template", new Item(new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, "prixilium_upgrade_smithing_template")))
    ));

    public static final Item PRIXILIUM_HOOK = registerItem("prixilium_hook", new PrixiliumHookItem(new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, "prixilium_hook")))
            .maxDamage(32)
    ));

    public static final Item BLIKO_SPAWN_EGG = registerItem("bliko_spawn_egg", new SpawnEggItem(
            ModEntities.BLIKO, 0x1e1e1e, 0x1e1e1e, new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, "bliko_spawn_egg")))
    ));
    public static final Item BLOKITO_SPAWN_EGG = registerItem("blokito_spawn_egg", new SpawnEggItem(
            ModEntities.BLOKITO, 0x1e1e1e, 0x1e1e1e, new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, "blokito_spawn_egg")))
    ));

    //region [Tools]

    //region [wood]
    public static final Item PRIXILED_WOODEN_SWORD = registerItem("prixiled_wooden_sword", new SwordItem(ToolMaterial.WOOD, 3, -2.4F, new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, "prixiled_wooden_sword")))
            .component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(true))
    ));
    public static final Item PRIXILED_WOODEN_PICKAXE = registerItem("prixiled_wooden_pickaxe", new PickaxeItem(ToolMaterial.WOOD, 1, -2.8F, new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, "prixiled_wooden_pickaxe")))
            .component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(true))
    ));
    public static final Item PRIXILED_WOODEN_AXE = registerItem("prixiled_wooden_axe", new AxeItem(ToolMaterial.WOOD, 6, -3.2F, new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, "prixiled_wooden_axe")))
            .component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(true))
    ));
    public static final Item PRIXILED_WOODEN_SHOVEL = registerItem("prixiled_wooden_shovel", new ShovelItem(ToolMaterial.WOOD, 1.5F, -3, new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, "prixiled_wooden_shovel")))
            .component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(true))
    ));
    public static final Item PRIXILED_WOODEN_HOE = registerItem("prixiled_wooden_hoe", new HoeItem(ToolMaterial.WOOD, 0, -3, new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, "prixiled_stone_sword")))
            .component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(true))
    ));
    //endregion

    //region [stone]
    public static final Item PRIXILED_STONE_SWORD = registerItem("prixiled_stone_sword", new SwordItem(ToolMaterial.STONE, 3, -2.4F, new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, "prixiled_stone_sword")))
            .component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(true))
    ));
    public static final Item PRIXILED_STONE_PICKAXE = registerItem("prixiled_stone_pickaxe", new PickaxeItem(ToolMaterial.STONE, 1, -2.8F, new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, "prixiled_stone_pickaxe")))
            .component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(true))
    ));
    public static final Item PRIXILED_STONE_AXE = registerItem("prixiled_stone_axe", new AxeItem(ToolMaterial.STONE, 7, -3.2F, new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, "prixiled_stone_axe")))
            .component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(true))
    ));
    public static final Item PRIXILED_STONE_SHOVEL = registerItem("prixiled_stone_shovel", new ShovelItem(ToolMaterial.STONE, 1.5F, -3, new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, "prixiled_stone_shovel")))
            .component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(true))
    ));
    public static final Item PRIXILED_STONE_HOE = registerItem("prixiled_stone_hoe", new HoeItem(ToolMaterial.STONE, -1, -2, new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, "prixiled_stone_hoe")))
            .component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(true))
    ));
    //endregion

    //region [copper]
    /* 1.21.9+
    public static final Item PRIXILED_COPPER_SWORD = registerItem("prixiled_copper_sword", new SwordItem(ToolMaterial.COPPER, idk, idk, new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, "prixiled_copper_sword")))
            .component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(true))
    ));
    public static final Item PRIXILED_COPPER_PICKAXE = registerItem("prixiled_copper_pickaxe", new PickaxeItem(ToolMaterial.COPPER, idk, idk, new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, "prixiled_copper_pickaxe")))
            .component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(true))
    ));
    public static final Item PRIXILED_COPPER_AXE = registerItem("prixiled_copper_axe", new AxeItem(ToolMaterial.COPPER, idk, idk, new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, "prixiled_copper_axe")))
            .component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(true))
    ));
    public static final Item PRIXILED_COPPER_SHOVEL = registerItem("prixiled_copper_shovel", new ShovelItem(ToolMaterial.COPPER , idk, idk, new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, "prixiled_copper_shovel")))
            .component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(true))
    ));
    public static final Item PRIXILED_COPPER_HOE = registerItem("prixiled_copper_hoe", new HoeItem(ToolMaterial.COPPER, idk, idk, new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, "prixiled_copper_hoe")))
            .component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(true))
    ));
     */
    //endregion

    //region [iron]
    public static final Item PRIXILED_IRON_SWORD = registerItem("prixiled_iron_sword", new SwordItem(ToolMaterial.IRON, 3, -2.4F, new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, "prixiled_iron_sword")))
            .component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(true))
    ));
    public static final Item PRIXILED_IRON_PICKAXE = registerItem("prixiled_iron_pickaxe", new PickaxeItem(ToolMaterial.IRON, 1, -2.8F, new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, "prixiled_iron_pickaxe")))
            .component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(true))
    ));
    public static final Item PRIXILED_IRON_AXE = registerItem("prixiled_iron_axe", new AxeItem(ToolMaterial.IRON, 6, -3.1F, new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, "prixiled_iron_axe")))
            .component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(true))
    ));
    public static final Item PRIXILED_IRON_SHOVEL = registerItem("prixiled_iron_shovel", new ShovelItem(ToolMaterial.IRON, 1.5F, -3, new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, "prixiled_iron_shovel")))
            .component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(true))
    ));
    public static final Item PRIXILED_IRON_HOE = registerItem("prixiled_iron_hoe", new HoeItem(ToolMaterial.IRON, -2, -1, new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, "prixiled_iron_hoe")))
            .component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(true))
    ));
    //endregion

    //region [gold]
    public static final Item PRIXILED_GOLDEN_SWORD = registerItem("prixiled_golden_sword", new SwordItem(ToolMaterial.GOLD, 3, -2.4F, new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, "prixiled_golden_sword")))
            .component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(true))
    ));
    public static final Item PRIXILED_GOLDEN_PICKAXE = registerItem("prixiled_golden_pickaxe", new PickaxeItem(ToolMaterial.GOLD, 1, -2.8F, new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, "prixiled_golden_pickaxe")))
            .component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(true))
    ));
    public static final Item PRIXILED_GOLDEN_AXE = registerItem("prixiled_golden_axe", new AxeItem(ToolMaterial.GOLD, 6, -3, new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, "prixiled_golden_axe")))
            .component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(true))
    ));
    public static final Item PRIXILED_GOLDEN_SHOVEL = registerItem("prixiled_golden_shovel", new ShovelItem(ToolMaterial.GOLD, 1.5F, -3, new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, "prixiled_golden_shovel")))
            .component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(true))
    ));
    public static final Item PRIXILED_GOLDEN_HOE = registerItem("prixiled_golden_hoe", new HoeItem(ToolMaterial.GOLD, 0, -3, new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, "prixiled_golden_hoe")))
            .component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(true))
    ));
    //endregion

    //region [diamond]
    public static final Item PRIXILED_DIAMOND_SWORD = registerItem("prixiled_diamond_sword", new SwordItem(ToolMaterial.DIAMOND, 3, -2.4F, new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, "prixiled_diamond_sword")))
            .component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(true))
    ));
    public static final Item PRIXILED_DIAMOND_PICKAXE = registerItem("prixiled_diamond_pickaxe", new PickaxeItem(ToolMaterial.DIAMOND, 1, -2.8F, new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, "prixiled_diamond_pickaxe")))
            .component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(true))
    ));
    public static final Item PRIXILED_DIAMOND_AXE = registerItem("prixiled_diamond_axe", new AxeItem(ToolMaterial.DIAMOND, 5, -3, new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, "prixiled_diamond_axe")))
            .component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(true))
    ));
    public static final Item PRIXILED_DIAMOND_SHOVEL = registerItem("prixiled_diamond_shovel", new ShovelItem(ToolMaterial.DIAMOND, 1.5F, -3, new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, "prixiled_diamond_shovel")))
            .component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(true))
    ));
    public static final Item PRIXILED_DIAMOND_HOE = registerItem("prixiled_diamond_hoe", new HoeItem(ToolMaterial.DIAMOND, -3, 0, new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, "prixiled_diamond_hoe")))
            .component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(true))
    ));
    //endregion

    //region [netherite]
    public static final Item PRIXILED_NETHERITE_SWORD = registerItem("prixiled_netherite_sword", new SwordItem(ToolMaterial.NETHERITE, 3, -2.4F, new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, "prixiled_netherite_sword")))
            .component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(true))
            .fireproof()
    ));
    public static final Item PRIXILED_NETHERITE_PICKAXE = registerItem("prixiled_netherite_pickaxe", new PickaxeItem(ToolMaterial.NETHERITE, 1, -2.8F, new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, "prixiled_netherite_pickaxe")))
            .component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(true))
            .fireproof()
    ));
    public static final Item PRIXILED_NETHERITE_AXE = registerItem("prixiled_netherite_axe", new AxeItem(ToolMaterial.NETHERITE, 5, -3, new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, "prixiled_netherite_axe")))
            .component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(true))
            .fireproof()
    ));
    public static final Item PRIXILED_NETHERITE_SHOVEL = registerItem("prixiled_netherite_shovel", new ShovelItem(ToolMaterial.NETHERITE, 1.5F, -3, new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, "prixiled_netherite_shovel")))
            .component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(true))
            .fireproof()
    ));
    public static final Item PRIXILED_NETHERITE_HOE = registerItem("prixiled_netherite_hoe", new HoeItem(ToolMaterial.NETHERITE, -4, 0, new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, "prixiled_netherite_hoe")))
            .component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(true))
            .fireproof()
    ));
    //endregion

    public static final Item PRIXILED_BOW = registerItem("prixiled_bow", new BowItem(new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, "prixiled_bow")))
            .maxCount(1)
            .maxDamage(384)
            .component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(true))
    ));

    public static final Item PRIXILED_MACE = registerItem("prixiled_mace", new MaceItem(new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, "prixiled_mace")))
            .maxCount(1)
            .rarity(Rarity.EPIC)
            .attributeModifiers(MaceItem.createAttributeModifiers())
            .component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(true))
    ));

    //endregion


    //region [Armors]

    //region [leather]
    public static final Item PRIXILED_LEATHER_HELMET = registerItem("prixiled_leather_helmet", new ArmorItem(ModArmorMaterials.PRIXILIUM_LEATHER, EquipmentType.HELMET, new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, "prixiled_leather_helmet")))
            .maxCount(1)
            .component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(true))
            .component(DataComponentTypes.DYED_COLOR, new DyedColorComponent(0xA06540, false))
    ));

    public static final Item PRIXILED_LEATHER_CHESTPLATE = registerItem("prixiled_leather_chestplate", new ArmorItem(ModArmorMaterials.PRIXILIUM_LEATHER, EquipmentType.CHESTPLATE, new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, "prixiled_leather_chestplate")))
            .maxCount(1)
            .component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(true))
            .component(DataComponentTypes.DYED_COLOR, new DyedColorComponent(0xA06540, false))
    ));

    public static final Item PRIXILED_LEATHER_LEGGINGS = registerItem("prixiled_leather_leggings", new ArmorItem(ModArmorMaterials.PRIXILIUM_LEATHER, EquipmentType.LEGGINGS, new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, "prixiled_leather_leggings")))
            .maxCount(1)
            .component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(true))
            .component(DataComponentTypes.DYED_COLOR, new DyedColorComponent(0xA06540, false))
    ));

    public static final Item PRIXILED_LEATHER_BOOTS = registerItem("prixiled_leather_boots", new ArmorItem(ModArmorMaterials.PRIXILIUM_LEATHER, EquipmentType.BOOTS, new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, "prixiled_leather_boots")))
            .maxCount(1)
            .component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(true))
            .component(DataComponentTypes.DYED_COLOR, new DyedColorComponent(0xA06540, false))
    ));
    //endregion

    //region [chainmail]
    public static final Item PRIXILED_CHAINMAIL_HELMET = registerItem("prixiled_chainmail_helmet", new ArmorItem(ModArmorMaterials.PRIXILIUM_CHAIN, EquipmentType.HELMET, new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, "prixiled_chainmail_helmet")))
            .maxCount(1)
            .component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(true))
    ));

    public static final Item PRIXILED_CHAINMAIL_CHESTPLATE = registerItem("prixiled_chainmail_chestplate", new ArmorItem(ModArmorMaterials.PRIXILIUM_CHAIN, EquipmentType.CHESTPLATE, new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, "prixiled_chainmail_chestplate")))
            .maxCount(1)
            .component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(true))
    ));

    public static final Item PRIXILED_CHAINMAIL_LEGGINGS = registerItem("prixiled_chainmail_leggings", new ArmorItem(ModArmorMaterials.PRIXILIUM_CHAIN, EquipmentType.LEGGINGS, new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, "prixiled_chainmail_leggings")))
            .maxCount(1)
            .component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(true))
    ));

    public static final Item PRIXILED_CHAINMAIL_BOOTS = registerItem("prixiled_chainmail_boots", new ArmorItem(ModArmorMaterials.PRIXILIUM_CHAIN, EquipmentType.BOOTS, new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, "prixiled_chainmail_boots")))
            .maxCount(1)
            .component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(true))
    ));
    //endregion

    //region [copper]
    /* 1.21.9+
    public static final Item PRIXILED_COPPER_HELMET = registerItem("prixiled_copper_helmet", new ArmorItem(ModArmorMaterials.PRIXILIUM_COPPER, EquipmentType.HELMET, new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, "prixiled_copper_helmet")))
            .maxCount(1)
            .component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(true))
    ));

    public static final Item PRIXILED_COPPER_CHESTPLATE = registerItem("prixiled_copper_chestplate", new ArmorItem(ModArmorMaterials.PRIXILIUM_COPPER, EquipmentType.CHESTPLATE, new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, "prixiled_copper_chestplate")))
            .maxCount(1)
            .component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(true))
    ));

    public static final Item PRIXILED_COPPER_LEGGINGS = registerItem("prixiled_copper_leggings", new ArmorItem(ModArmorMaterials.PRIXILIUM_COPPER, EquipmentType.LEGGINGS, new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, "prixiled_copper_leggings")))
            .maxCount(1)
            .component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(true))
    ));

    public static final Item PRIXILED_COPPER_BOOTS = registerItem("prixiled_copper_boots", new ArmorItem(ModArmorMaterials.PRIXILIUM_COPPER, EquipmentType.BOOTS, new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, "prixiled_copper_boots")))
            .maxCount(1)
            .component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(true))
    ));
     */
    //endregion

    //region [iron]
    public static final Item PRIXILED_IRON_HELMET = registerItem("prixiled_iron_helmet", new ArmorItem(ModArmorMaterials.PRIXILIUM_IRON, EquipmentType.HELMET, new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, "prixiled_iron_helmet")))
            .maxCount(1)
            .component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(true))));

    public static final Item PRIXILED_IRON_CHESTPLATE = registerItem("prixiled_iron_chestplate", new ArmorItem(ModArmorMaterials.PRIXILIUM_IRON, EquipmentType.CHESTPLATE, new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, "prixiled_iron_chestplate")))
            .maxCount(1)
            .component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(true))));

    public static final Item PRIXILED_IRON_LEGGINGS = registerItem("prixiled_iron_leggings", new ArmorItem(ModArmorMaterials.PRIXILIUM_IRON, EquipmentType.LEGGINGS, new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, "prixiled_iron_leggings")))
            .maxCount(1)
            .component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(true))));

    public static final Item PRIXILED_IRON_BOOTS = registerItem("prixiled_iron_boots", new ArmorItem(ModArmorMaterials.PRIXILIUM_IRON, EquipmentType.BOOTS, new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, "prixiled_iron_boots")))
            .maxCount(1)
            .component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(true))));
    //endregion

    //region [gold]
    public static final Item PRIXILED_GOLDEN_HELMET = registerItem("prixiled_golden_helmet", new ArmorItem(ModArmorMaterials.PRIXILIUM_GOLD, EquipmentType.HELMET, new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, "prixiled_golden_helmet")))
            .maxCount(1)
            .component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(true))));

    public static final Item PRIXILED_GOLDEN_CHESTPLATE = registerItem("prixiled_golden_chestplate", new ArmorItem(ModArmorMaterials.PRIXILIUM_GOLD, EquipmentType.CHESTPLATE, new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, "prixiled_golden_chestplate")))
            .maxCount(1)
            .component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(true))));

    public static final Item PRIXILED_GOLDEN_LEGGINGS = registerItem("prixiled_golden_leggings", new ArmorItem(ModArmorMaterials.PRIXILIUM_GOLD, EquipmentType.LEGGINGS, new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, "prixiled_golden_leggings")))
            .maxCount(1)
            .component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(true))));

    public static final Item PRIXILED_GOLDEN_BOOTS = registerItem("prixiled_golden_boots", new ArmorItem(ModArmorMaterials.PRIXILIUM_GOLD, EquipmentType.BOOTS, new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, "prixiled_golden_boots")))
            .maxCount(1)
            .component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(true))));
    //endregion

    //region [diamond]
    public static final Item PRIXILED_DIAMOND_HELMET = registerItem("prixiled_diamond_helmet", new ArmorItem(ModArmorMaterials.PRIXILIUM_DIAMOND, EquipmentType.HELMET, new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, "prixiled_diamond_helmet")))
            .maxCount(1)
            .component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(true))));

    public static final Item PRIXILED_DIAMOND_CHESTPLATE = registerItem("prixiled_diamond_chestplate", new ArmorItem(ModArmorMaterials.PRIXILIUM_DIAMOND, EquipmentType.CHESTPLATE, new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, "prixiled_diamond_chestplate")))
            .maxCount(1)
            .component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(true))));

    public static final Item PRIXILED_DIAMOND_LEGGINGS = registerItem("prixiled_diamond_leggings", new ArmorItem(ModArmorMaterials.PRIXILIUM_DIAMOND, EquipmentType.LEGGINGS, new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, "prixiled_diamond_leggings")))
            .maxCount(1)
            .component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(true))));

    public static final Item PRIXILED_DIAMOND_BOOTS = registerItem("prixiled_diamond_boots", new ArmorItem(ModArmorMaterials.PRIXILIUM_DIAMOND, EquipmentType.BOOTS, new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, "prixiled_diamond_boots")))
            .maxCount(1)
            .component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(true))));
    //endregion

    //region [netherite]
    public static final Item PRIXILED_NETHERITE_HELMET = registerItem("prixiled_netherite_helmet", new ArmorItem(ModArmorMaterials.PRIXILIUM_NETHERITE, EquipmentType.HELMET, new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, "prixiled_netherite_helmet")))
            .maxCount(1)
            .component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(true))
            .fireproof()
    ));

    public static final Item PRIXILED_NETHERITE_CHESTPLATE = registerItem("prixiled_netherite_chestplate", new ArmorItem(ModArmorMaterials.PRIXILIUM_NETHERITE, EquipmentType.CHESTPLATE, new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, "prixiled_netherite_chestplate")))
            .maxCount(1)
            .component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(true))
            .fireproof()
    ));

    public static final Item PRIXILED_NETHERITE_LEGGINGS = registerItem("prixiled_netherite_leggings", new ArmorItem(ModArmorMaterials.PRIXILIUM_NETHERITE, EquipmentType.LEGGINGS, new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, "prixiled_netherite_leggings")))
            .maxCount(1)
            .component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(true))
            .fireproof()
    ));

    public static final Item PRIXILED_NETHERITE_BOOTS = registerItem("prixiled_netherite_boots", new ArmorItem(ModArmorMaterials.PRIXILIUM_NETHERITE, EquipmentType.BOOTS, new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, "prixiled_netherite_boots")))
            .maxCount(1)
            .component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(true))
            .fireproof()
    ));
    //endregion

    //region [turtle]
    public static final Item PRIXILED_TURTLE_HELMET = registerItem("prixiled_turtle_helmet", new ArmorItem(ModArmorMaterials.PRIXILIUM_TURTLE, EquipmentType.HELMET, new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, "prixiled_turtle_helmet")))
            .maxCount(1)
            .component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(true))
    ));
    //endregion

    //region [horse]
    public static final Item PRIXILED_LEATHER_HORSE_ARMOR = registerItem("prixiled_leather_horse_armor", new AnimalArmorItem(ModArmorMaterials.PRIXILIUM_LEATHER, AnimalArmorItem.Type.EQUESTRIAN, new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, "prixiled_leather_horse_armor")))
            .maxCount(1)
            .component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(true))
            .component(DataComponentTypes.DYED_COLOR, new DyedColorComponent(0xA06540, false))
    ));
    /* 1.21.9+
    public static final Item PRIXILED_COPPER_HORSE_ARMOR = registerItem("prixiled_copper_horse_armor", new AnimalArmorItem(ModArmorMaterials.PRIXILIUM_COPPER, AnimalArmorItem.Type.EQUESTRIAN, new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, "prixiled_copper_horse_armor")))
            .maxCount(1)
            .component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(true))
            ));
    */
    public static final Item PRIXILED_IRON_HORSE_ARMOR = registerItem("prixiled_iron_horse_armor", new AnimalArmorItem(ModArmorMaterials.PRIXILIUM_IRON, AnimalArmorItem.Type.EQUESTRIAN, new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, "prixiled_iron_horse_armor")))
            .maxCount(1)
            .component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(true))
    ));
    public static final Item PRIXILED_GOLDEN_HORSE_ARMOR = registerItem("prixiled_golden_horse_armor", new AnimalArmorItem(ModArmorMaterials.PRIXILIUM_GOLD, AnimalArmorItem.Type.EQUESTRIAN, new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, "prixiled_golden_horse_armor")))
            .maxCount(1)
            .component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(true))
    ));
    public static final Item PRIXILED_DIAMOND_HORSE_ARMOR = registerItem("prixiled_diamond_horse_armor", new AnimalArmorItem(ModArmorMaterials.PRIXILIUM_DIAMOND, AnimalArmorItem.Type.EQUESTRIAN, new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, "prixiled_diamond_horse_armor")))
            .maxCount(1)
            .component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(true))
    ));
    /* 1.21.11+
    public static final Item PRIXILED_NETHERITE_HORSE_ARMOR = registerItem("prixiled_netherite_horse_armor", new AnimalArmorItem(ModArmorMaterials.PRIXILIUM_NETHERITE, AnimalArmorItem.Type.EQUESTRIAN, new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, "prixiled_netherite_horse_armor")))
            .maxCount(1)
            .component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(true))));
    */
    //endregion


    //endregion

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(Prixilium.MOD_ID, name), item);
    }

    public static void registerModItems() {
        Prixilium.LOGGER.info("Registering Prixilium Items.");
    }
}
