package net.napsternpt.prixilium.util;

import net.minecraft.block.Block;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.damage.DamageType;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.napsternpt.prixilium.Prixilium;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> PRIXILIUM_CONVERTIBLE = createTag("prixilium_convertable");
        public static final TagKey<Block> PRIXILIUM_GRASS_CONVERTIBLE = createTag("prixilium_grass_convertable");
        public static final TagKey<Block> PRIXILIUM_LOG_CONVERTIBLE = createTag("prixilium_log_convertable");
        public static final TagKey<Block> PRIXILIUM_WOOD_CONVERTIBLE = createTag("prixilium_wood_convertable");
        public static final TagKey<Block> PRIXILIUM_LEAVES_CONVERTIBLE = createTag("prixilium_leaves_convertable");

        private static TagKey<Block> createTag(String name) {
            return TagKey.of(RegistryKeys.BLOCK, Identifier.of(Prixilium.MOD_ID, name));
        }
    }

    public static class Items {
        public static final TagKey<Item> TEMPERATURE_TOOLS = createTag("temperature_tools");
        public static final TagKey<Item> REPAIRS_RIFT_ARMOR = createTag("repairs_rift_armor");
        public static final TagKey<Item> PRIXILED_FOOD = createTag("prixiled_food");
        public static final TagKey<Item> CHARMS = createTag("charms");
        public static final TagKey<Item> TIER_I_CHARMS = createTag("tier_i_charms");
        public static final TagKey<Item> TIER_II_CHARMS = createTag("tier_ii_charms");
        public static final TagKey<Item> TIER_III_CHARMS = createTag("tier_iii_charms");
        public static final TagKey<Item> REPARABLE_CHARMS = createTag("reparable_charms");
        public static final TagKey<Item> OBELISK_OF_CHARMS_FUEL = createTag("obelisk_of_charms_fuel");
        public static final TagKey<Item> OBELISK_OF_CHARMS_FUEL_LONG = createTag("obelisk_of_charms_fuel_long");
        public static final TagKey<Item> CONTAINER_CHARM_UNHOLDABLE = createTag("container_charm_unholdable");

        private static TagKey<Item> createTag(String name) {
            return TagKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, name));
        }
    }

    public static class Entities {
        public static final TagKey<EntityType<?>> IMMUNE_TO_PRIXILIUM = createTag("immune_to_prixilium");

        private static TagKey<EntityType<?>> createTag(String name) {
            return TagKey.of(RegistryKeys.ENTITY_TYPE, Identifier.of(Prixilium.MOD_ID, name));
        }
    }

    public static class DamageTypes {
        public static final TagKey<DamageType> SONIC_BOOM = createTag("sonic_boom");

        private static TagKey<DamageType> createTag(String name) {
            return TagKey.of(RegistryKeys.DAMAGE_TYPE, Identifier.of(Prixilium.MOD_ID, name));
        }
    }
}
