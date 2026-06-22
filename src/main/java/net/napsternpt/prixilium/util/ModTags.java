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
        public static final TagKey<Item> PREVENT_PRIXILIUM_SLOWNESS = createTag("prevent_prixilium_slowness");
        public static final TagKey<Item> TEMPERATURE_TOOLS = createTag("temperature_tools");
        public static final TagKey<Item> CHARMS = createTag("charms");
        public static final TagKey<Item> CONTAINER_CHARM_UNHOLDABLE = createTag("container_charm_unholdable");

        private static TagKey<Item> createTag(String name) {
            return TagKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, name));
        }
    }

    public static class Entities {
        public static final TagKey<EntityType<?>> IMMUNE_TO_PRIXILIUM_SLOWNESS = createTag("immune_to_prixilium_slowness");

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
