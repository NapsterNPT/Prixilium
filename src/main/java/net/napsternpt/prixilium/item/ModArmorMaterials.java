package net.napsternpt.prixilium.item;

import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;
import net.napsternpt.prixilium.Prixilium;
import net.napsternpt.prixilium.block.ModBlocks;

import java.util.EnumMap;
import java.util.List;
import java.util.function.Supplier;

public class ModArmorMaterials {

    public static final RegistryEntry<ArmorMaterial> PRIXILIUM_LEATHER = registerArmorMaterial("prixiled_leather",
            () -> new ArmorMaterial(Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
                map.put(ArmorItem.Type.BOOTS, 1);
                map.put(ArmorItem.Type.LEGGINGS, 2);
                map.put(ArmorItem.Type.CHESTPLATE, 3);
                map.put(ArmorItem.Type.HELMET, 1);
                map.put(ArmorItem.Type.BODY, 3);
            }), 15, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, () -> Ingredient.ofItems(ModBlocks.PRIXILIUM),
                    List.of(new ArmorMaterial.Layer(Identifier.of(Prixilium.MOD_ID, "prixiled_leather"), "", true),
                            new ArmorMaterial.Layer(Identifier.of(Prixilium.MOD_ID, "prixiled_leather"), "_overlay", false)), 0, 0));

    public static final RegistryEntry<ArmorMaterial> PRIXILIUM_CHAIN = registerArmorMaterial("prixiled_chainmail",
            () -> new ArmorMaterial(Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
                map.put(ArmorItem.Type.BOOTS, 1);
                map.put(ArmorItem.Type.LEGGINGS, 4);
                map.put(ArmorItem.Type.CHESTPLATE, 5);
                map.put(ArmorItem.Type.HELMET, 2);
                map.put(ArmorItem.Type.BODY, 4);
            }), 12, SoundEvents.ITEM_ARMOR_EQUIP_CHAIN, () -> Ingredient.ofItems(ModBlocks.PRIXILIUM),
                    List.of(new ArmorMaterial.Layer(Identifier.of(Prixilium.MOD_ID, "prixiled_chainmail"))), 0, 0));

    /* 1.21.9+
        public static final RegistryEntry<ArmorMaterial> PRIXILIUM_COPPER = registerArmorMaterial("prixiled_copper",
            () -> new ArmorMaterial(Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
                map.put(ArmorItem.Type.BOOTS, idk);
                map.put(ArmorItem.Type.LEGGINGS, idk);
                map.put(ArmorItem.Type.CHESTPLATE, idk);
                map.put(ArmorItem.Type.HELMET, idk);
                map.put(ArmorItem.Type.BODY, idk);
            }), idk, SoundEvents.ITEM_ARMOR_EQUIP_COPPER, () -> Ingredient.ofItems(ModBlocks.PRIXILIUM),
                    List.of(new ArmorMaterial.Layer(Identifier.of(Prixilium.MOD_ID, "prixiled_copper"))), idk, idk));

     */

    public static final RegistryEntry<ArmorMaterial> PRIXILIUM_IRON = registerArmorMaterial("prixiled_iron",
            () -> new ArmorMaterial(Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
                map.put(ArmorItem.Type.BOOTS, 2);
                map.put(ArmorItem.Type.LEGGINGS, 5);
                map.put(ArmorItem.Type.CHESTPLATE, 6);
                map.put(ArmorItem.Type.HELMET, 2);
                map.put(ArmorItem.Type.BODY, 5);
            }), 9, SoundEvents.ITEM_ARMOR_EQUIP_IRON, () -> Ingredient.ofItems(ModBlocks.PRIXILIUM),
                    List.of(new ArmorMaterial.Layer(Identifier.of(Prixilium.MOD_ID, "prixiled_iron"))), 0, 0));

    public static final RegistryEntry<ArmorMaterial> PRIXILIUM_GOLD = registerArmorMaterial("prixiled_gold",
            () -> new ArmorMaterial(Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
                map.put(ArmorItem.Type.BOOTS, 1);
                map.put(ArmorItem.Type.LEGGINGS, 3);
                map.put(ArmorItem.Type.CHESTPLATE, 5);
                map.put(ArmorItem.Type.HELMET, 2);
                map.put(ArmorItem.Type.BODY, 7);
            }), 25, SoundEvents.ITEM_ARMOR_EQUIP_GOLD, () -> Ingredient.ofItems(ModBlocks.PRIXILIUM),
                    List.of(new ArmorMaterial.Layer(Identifier.of(Prixilium.MOD_ID, "prixiled_gold"))), 0, 0));

    public static final RegistryEntry<ArmorMaterial> PRIXILIUM_DIAMOND = registerArmorMaterial("prixiled_diamond",
            () -> new ArmorMaterial(Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
                map.put(ArmorItem.Type.BOOTS, 3);
                map.put(ArmorItem.Type.LEGGINGS, 6);
                map.put(ArmorItem.Type.CHESTPLATE, 8);
                map.put(ArmorItem.Type.HELMET, 3);
                map.put(ArmorItem.Type.BODY, 11);
            }), 10, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, () -> Ingredient.ofItems(ModBlocks.PRIXILIUM),
                    List.of(new ArmorMaterial.Layer(Identifier.of(Prixilium.MOD_ID, "prixiled_diamond"))), 2.0F, 0));

    public static final RegistryEntry<ArmorMaterial> PRIXILIUM_NETHERITE = registerArmorMaterial("prixiled_netherite",
            () -> new ArmorMaterial(Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
                map.put(ArmorItem.Type.BOOTS, 3);
                map.put(ArmorItem.Type.LEGGINGS, 6);
                map.put(ArmorItem.Type.CHESTPLATE, 8);
                map.put(ArmorItem.Type.HELMET, 3);
                map.put(ArmorItem.Type.BODY, 11);
            }), 10, SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE, () -> Ingredient.ofItems(ModBlocks.PRIXILIUM),
                    List.of(new ArmorMaterial.Layer(Identifier.of(Prixilium.MOD_ID, "prixiled_netherite"))), 3.0F, 0.1F));

    public static final RegistryEntry<ArmorMaterial> PRIXILIUM_TURTLE = registerArmorMaterial("prixiled_turtle_scute",
            () -> new ArmorMaterial(Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
                map.put(ArmorItem.Type.BOOTS, 2);
                map.put(ArmorItem.Type.LEGGINGS, 5);
                map.put(ArmorItem.Type.CHESTPLATE, 6);
                map.put(ArmorItem.Type.HELMET, 2);
                map.put(ArmorItem.Type.BODY, 5);
            }), 9, SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE, () -> Ingredient.ofItems(ModBlocks.PRIXILIUM),
                    List.of(new ArmorMaterial.Layer(Identifier.of(Prixilium.MOD_ID, "prixiled_turtle_scute"))), 0, 0));

// Overlay
// List.of(new ArmorMaterial.Layer(Identifier.ofVanilla("meterial")),
//         new ArmorMaterial.Layer(Identifier.of(Prixilium.MOD_ID, "prixilium"))), 0, 0));

    public static RegistryEntry<ArmorMaterial> registerArmorMaterial(String name, Supplier<ArmorMaterial> material) {
        return Registry.registerReference(Registries.ARMOR_MATERIAL, Identifier.of(Prixilium.MOD_ID, name), material.get());
    }
}
