package net.napsternpt.prixilium.item;

import net.minecraft.item.equipment.ArmorMaterial;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;
import net.napsternpt.prixilium.Prixilium;

import java.util.EnumMap;

public class ModArmorMaterials {

    public static final ArmorMaterial PRIXILIUM_LEATHER = new ArmorMaterial(5, Util.make(new EnumMap<>(EquipmentType.class), map -> {
                map.put(EquipmentType.BOOTS, 1);
                map.put(EquipmentType.LEGGINGS, 2);
                map.put(EquipmentType.CHESTPLATE, 3);
                map.put(EquipmentType.HELMET, 1);
                map.put(EquipmentType.BODY, 3);
            }), 15, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0, 0, ItemTags.REPAIRS_LEATHER_ARMOR,
            Identifier.of(Prixilium.MOD_ID, "prixiled_leather"));

    public static final ArmorMaterial PRIXILIUM_CHAIN = new ArmorMaterial(15, Util.make(new EnumMap<>(EquipmentType.class), map -> {
                map.put(EquipmentType.BOOTS, 1);
                map.put(EquipmentType.LEGGINGS, 4);
                map.put(EquipmentType.CHESTPLATE, 5);
                map.put(EquipmentType.HELMET, 2);
                map.put(EquipmentType.BODY, 4);
            }), 12, SoundEvents.ITEM_ARMOR_EQUIP_CHAIN, 0, 0, ItemTags.REPAIRS_CHAIN_ARMOR,
            Identifier.of(Prixilium.MOD_ID, "prixiled_chainmail"));

    /* 1.21.9+
    public static final ArmorMaterial PRIXILIUM_COPPER = new ArmorMaterial(durability, Util.make(new EnumMap<>(EquipmentType.class), map -> {
                map.put(EquipmentType.BOOTS, idk);
                map.put(EquipmentType.LEGGINGS, idk);
                map.put(EquipmentType.CHESTPLATE, idk);
                map.put(EquipmentType.HELMET, idk);
                map.put(EquipmentType.BODY, idk);
            }), idk, SoundEvents.ITEM_ARMOR_EQUIP_COPPER, 0, 0, ItemTags.REPAIRS_COPPER_ARMOR),
            Identifier.of(Prixilium.MOD_ID, "prixiled_copper"));

     */

    public static final ArmorMaterial PRIXILIUM_IRON = new ArmorMaterial(15, Util.make(new EnumMap<>(EquipmentType.class), map -> {
                map.put(EquipmentType.BOOTS, 2);
                map.put(EquipmentType.LEGGINGS, 5);
                map.put(EquipmentType.CHESTPLATE, 6);
                map.put(EquipmentType.HELMET, 2);
                map.put(EquipmentType.BODY, 5);
            }), 9, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0, 0, ItemTags.REPAIRS_IRON_ARMOR,
            Identifier.of(Prixilium.MOD_ID, "prixiled_iron"));

    public static final ArmorMaterial PRIXILIUM_GOLD = new ArmorMaterial(7, Util.make(new EnumMap<>(EquipmentType.class), map -> {
                map.put(EquipmentType.BOOTS, 1);
                map.put(EquipmentType.LEGGINGS, 3);
                map.put(EquipmentType.CHESTPLATE, 5);
                map.put(EquipmentType.HELMET, 2);
                map.put(EquipmentType.BODY, 7);
            }), 25, SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 0, 0, ItemTags.REPAIRS_GOLD_ARMOR,
            Identifier.of(Prixilium.MOD_ID, "prixiled_gold"));

    public static final ArmorMaterial PRIXILIUM_DIAMOND = new ArmorMaterial(33, Util.make(new EnumMap<>(EquipmentType.class), map -> {
                map.put(EquipmentType.BOOTS, 3);
                map.put(EquipmentType.LEGGINGS, 6);
                map.put(EquipmentType.CHESTPLATE, 8);
                map.put(EquipmentType.HELMET, 3);
                map.put(EquipmentType.BODY, 11);
            }), 10, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 2.0F, 0, ItemTags.REPAIRS_DIAMOND_ARMOR,
            Identifier.of(Prixilium.MOD_ID, "prixiled_diamond"));

    public static final ArmorMaterial PRIXILIUM_NETHERITE = new ArmorMaterial(37, Util.make(new EnumMap<>(EquipmentType.class), map -> {
                map.put(EquipmentType.BOOTS, 3);
                map.put(EquipmentType.LEGGINGS, 6);
                map.put(EquipmentType.CHESTPLATE, 8);
                map.put(EquipmentType.HELMET, 3);
                map.put(EquipmentType.BODY, 11);
            }), 10, SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE, 3.0F, 0.1F, ItemTags.REPAIRS_NETHERITE_ARMOR,
            Identifier.of(Prixilium.MOD_ID, "prixiled_netherite"));

    public static final ArmorMaterial PRIXILIUM_TURTLE = new ArmorMaterial(25, Util.make(new EnumMap<>(EquipmentType.class), map -> {
                map.put(EquipmentType.BOOTS, 2);
                map.put(EquipmentType.LEGGINGS, 5);
                map.put(EquipmentType.CHESTPLATE, 6);
                map.put(EquipmentType.HELMET, 2);
                map.put(EquipmentType.BODY, 5);
            }), 9, SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE, 0, 0, ItemTags.REPAIRS_TURTLE_HELMET,
            Identifier.of(Prixilium.MOD_ID, "prixiled_turtle_scute"));
}
