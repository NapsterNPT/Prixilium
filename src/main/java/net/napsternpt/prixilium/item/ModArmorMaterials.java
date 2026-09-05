package net.napsternpt.prixilium.item;

import net.minecraft.item.equipment.ArmorMaterial;
import net.minecraft.item.equipment.EquipmentAsset;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;
import net.napsternpt.prixilium.Prixilium;
import net.napsternpt.prixilium.util.ModTags;

import java.util.EnumMap;

public class ModArmorMaterials {
    static RegistryKey<? extends Registry<EquipmentAsset>> REGISTRY_KEY = RegistryKey.ofRegistry(Identifier.ofVanilla("equipment_asset"));

    public static final RegistryKey<EquipmentAsset> PRIXILIUM_LEATHER_KEY = RegistryKey.of(REGISTRY_KEY, Identifier.of(Prixilium.MOD_ID, "prixilium_leather"));
    public static final ArmorMaterial PRIXILIUM_LEATHER = new ArmorMaterial(5, Util.make(new EnumMap<>(EquipmentType.class), map -> {
                map.put(EquipmentType.BOOTS, 1);
                map.put(EquipmentType.LEGGINGS, 2);
                map.put(EquipmentType.CHESTPLATE, 3);
                map.put(EquipmentType.HELMET, 1);
                map.put(EquipmentType.BODY, 3);
            }), 15, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0, 0, ItemTags.REPAIRS_LEATHER_ARMOR, PRIXILIUM_LEATHER_KEY);

    public static final RegistryKey<EquipmentAsset> PRIXILIUM_COPPER_KEY = RegistryKey.of(REGISTRY_KEY, Identifier.of(Prixilium.MOD_ID, "prixilium_copper"));
    public static final ArmorMaterial PRIXILIUM_COPPER = new ArmorMaterial(11, Util.make(new EnumMap<>(EquipmentType.class), map -> {
        map.put(EquipmentType.BOOTS, 1);
        map.put(EquipmentType.LEGGINGS, 3);
        map.put(EquipmentType.CHESTPLATE, 4);
        map.put(EquipmentType.HELMET, 2);
        map.put(EquipmentType.BODY, 4);
    }), 8, SoundEvents.ITEM_ARMOR_EQUIP_COPPER, 0, 0, ItemTags.REPAIRS_COPPER_ARMOR, PRIXILIUM_COPPER_KEY);

    public static final RegistryKey<EquipmentAsset> PRIXILIUM_CHAIN_KEY = RegistryKey.of(REGISTRY_KEY, Identifier.of(Prixilium.MOD_ID, "prixilium_chainmail"));
    public static final ArmorMaterial PRIXILIUM_CHAIN = new ArmorMaterial(15, Util.make(new EnumMap<>(EquipmentType.class), map -> {
                map.put(EquipmentType.BOOTS, 1);
                map.put(EquipmentType.LEGGINGS, 4);
                map.put(EquipmentType.CHESTPLATE, 5);
                map.put(EquipmentType.HELMET, 2);
                map.put(EquipmentType.BODY, 4);
            }), 12, SoundEvents.ITEM_ARMOR_EQUIP_CHAIN, 0, 0, ItemTags.REPAIRS_CHAIN_ARMOR, PRIXILIUM_CHAIN_KEY);

    public static final RegistryKey<EquipmentAsset> PRIXILIUM_IRON_KEY = RegistryKey.of(REGISTRY_KEY, Identifier.of(Prixilium.MOD_ID, "prixilium_iron"));
    public static final ArmorMaterial PRIXILIUM_IRON = new ArmorMaterial(15, Util.make(new EnumMap<>(EquipmentType.class), map -> {
                map.put(EquipmentType.BOOTS, 2);
                map.put(EquipmentType.LEGGINGS, 5);
                map.put(EquipmentType.CHESTPLATE, 6);
                map.put(EquipmentType.HELMET, 2);
                map.put(EquipmentType.BODY, 5);
            }), 9, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0, 0, ItemTags.REPAIRS_IRON_ARMOR, PRIXILIUM_IRON_KEY);

    public static final RegistryKey<EquipmentAsset> PRIXILIUM_GOLD_KEY = RegistryKey.of(REGISTRY_KEY, Identifier.of(Prixilium.MOD_ID, "prixilium_gold"));
    public static final ArmorMaterial PRIXILIUM_GOLD = new ArmorMaterial(7, Util.make(new EnumMap<>(EquipmentType.class), map -> {
                map.put(EquipmentType.BOOTS, 1);
                map.put(EquipmentType.LEGGINGS, 3);
                map.put(EquipmentType.CHESTPLATE, 5);
                map.put(EquipmentType.HELMET, 2);
                map.put(EquipmentType.BODY, 7);
            }), 25, SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 0, 0, ItemTags.REPAIRS_GOLD_ARMOR, PRIXILIUM_GOLD_KEY);

    public static final RegistryKey<EquipmentAsset> PRIXILIUM_DIAMOND_KEY = RegistryKey.of(REGISTRY_KEY, Identifier.of(Prixilium.MOD_ID, "prixilium_diamond"));
    public static final ArmorMaterial PRIXILIUM_DIAMOND = new ArmorMaterial(33, Util.make(new EnumMap<>(EquipmentType.class), map -> {
                map.put(EquipmentType.BOOTS, 3);
                map.put(EquipmentType.LEGGINGS, 6);
                map.put(EquipmentType.CHESTPLATE, 8);
                map.put(EquipmentType.HELMET, 3);
                map.put(EquipmentType.BODY, 11);
            }), 10, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 2.0F, 0, ItemTags.REPAIRS_DIAMOND_ARMOR, PRIXILIUM_DIAMOND_KEY);

    public static final RegistryKey<EquipmentAsset> PRIXILIUM_TURTLE_KEY = RegistryKey.of(REGISTRY_KEY, Identifier.of(Prixilium.MOD_ID, "prixilium_turtle_scute"));
    public static final ArmorMaterial PRIXILIUM_TURTLE = new ArmorMaterial(25, Util.make(new EnumMap<>(EquipmentType.class), map -> {
        map.put(EquipmentType.BOOTS, 2);
        map.put(EquipmentType.LEGGINGS, 5);
        map.put(EquipmentType.CHESTPLATE, 6);
        map.put(EquipmentType.HELMET, 2);
        map.put(EquipmentType.BODY, 5);
    }), 9, SoundEvents.ITEM_ARMOR_EQUIP_TURTLE, 0, 0, ItemTags.REPAIRS_TURTLE_HELMET, PRIXILIUM_TURTLE_KEY);

    public static final RegistryKey<EquipmentAsset> PRIXILIUM_NETHERITE_KEY = RegistryKey.of(REGISTRY_KEY, Identifier.of(Prixilium.MOD_ID, "prixilium_netherite"));
    public static final ArmorMaterial PRIXILIUM_NETHERITE = new ArmorMaterial(37, Util.make(new EnumMap<>(EquipmentType.class), map -> {
                map.put(EquipmentType.BOOTS, 3);
                map.put(EquipmentType.LEGGINGS, 6);
                map.put(EquipmentType.CHESTPLATE, 8);
                map.put(EquipmentType.HELMET, 3);
                map.put(EquipmentType.BODY, 11);
            }), 10, SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE, 3.0F, 0.1F, ItemTags.REPAIRS_NETHERITE_ARMOR, PRIXILIUM_NETHERITE_KEY);

    public static final RegistryKey<EquipmentAsset> RIFT_KEY = RegistryKey.of(REGISTRY_KEY, Identifier.of(Prixilium.MOD_ID, "rift"));
    public static final ArmorMaterial RIFT = new ArmorMaterial(37,
            Util.make(new EnumMap<>(EquipmentType.class), map -> map.put(EquipmentType.CHESTPLATE, 8)), 10, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 2.0F, 1.0F, ModTags.Items.REPAIRS_RIFT_ARMOR, RIFT_KEY);
}
