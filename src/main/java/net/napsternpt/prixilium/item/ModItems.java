package net.napsternpt.prixilium.item;

import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.DyedColorComponent;
import net.minecraft.item.*;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.Unit;
import net.napsternpt.prixilium.Prixilium;
import net.napsternpt.prixilium.entity.ModEntities;
import net.napsternpt.prixilium.item.custom.*;

import java.util.function.Consumer;

public class ModItems {
    public static final Item VIRUS_ALIVE = registerItem("virus_alive", new VirusAliveItem(new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, "virus_alive")))
            .maxCount(1)
            .maxDamage(100)
            .rarity(Rarity.RARE)
    ));
    public static final Item VIRUS_DEAD = registerItem("virus_dead", new Item(new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, "virus_dead")))
    ));

    public static final Item THERMOMETER = registerItem("thermometer", new ThermometerItem(new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, "thermometer")))
            .maxCount(1)
    ));

    public static final Item PRIXILIUM_UPGRADE_SMITHING_TEMPLATE = registerItem("prixilium_upgrade_smithing_template", new Item(new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, "prixilium_upgrade_smithing_template")))
    ));

    public static final Item PRIXILIUM_HOOK = registerItem("prixilium_hook", new PrixiliumHookItem(new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, "prixilium_hook")))
            .maxDamage(32)
    ));

    public static final Item BLIKO_SPAWN_EGG = registerItem("bliko_spawn_egg", new SpawnEggItem(
            ModEntities.BLIKO, new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, "bliko_spawn_egg")))
    ));
    public static final Item BLOKITO_SPAWN_EGG = registerItem("blokito_spawn_egg", new SpawnEggItem(
            ModEntities.BLOKITO, new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, "blokito_spawn_egg")))
    ));
    public static final Item AIRIS_SPAWN_EGG = registerItem("airis_spawn_egg", new SpawnEggItem(
            ModEntities.AIRIS, new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, "airis_spawn_egg")))
    ));

    //region [charms]
    // Tier I
    public static final Item CHARM_I = registerItem("charm_i", new GeneralCharmItem(true, true, new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, "charm_i")))
            .maxCount(1)
    ){
        @Override
        public void appendTooltip(ItemStack stack, TooltipContext context, net.minecraft.component.type.TooltipDisplayComponent displayComponent, Consumer<Text> textConsumer, TooltipType type) {
            textConsumer.accept(Text.translatable("tooltip.prixilium.charm"));
            super.appendTooltip(stack, context, displayComponent, textConsumer, type);
        }
    });
    public static final Item TRANSFER_CHARM_I = registerItem("transfer_charm_i", new GeneralCharmItem(true, false, new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, "transfer_charm_i")))
            .maxCount(1)
            .maxDamage(4)
            .rarity(Rarity.UNCOMMON)
    ));
    public static final Item CONTAINER_CHARM_I = registerItem("container_charm_i", new ContainerCharmItem(1, true, false, new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, "container_charm_i")))
            .maxCount(1)
            .rarity(Rarity.UNCOMMON)
    ));
    public static final Item ROLLBACK_CHARM_I = registerItem("rollback_charm_i", new GeneralCharmItem(true, false, new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, "rollback_charm_i")))
            .maxCount(1)
            .maxDamage(4)
            .rarity(Rarity.UNCOMMON)
    ));
    public static final Item REGENERATION_CHARM_I = registerItem("regeneration_charm_i", new GeneralCharmItem(true, false, new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, "regeneration_charm_i")))
            .maxCount(1)
            .maxDamage(4)
            .rarity(Rarity.UNCOMMON)
    ));
    public static final Item POSTMORTAL_CHARM_I = registerItem("postmortal_charm_i", new PostmortalCharmItem(true, false, new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, "postmortal_charm_i")))
            .maxCount(1)
            .maxDamage(4)
            .rarity(Rarity.UNCOMMON)
    ));

    // Tier II
    public static final Item CHARM_II = registerItem("charm_ii", new GeneralCharmItem(true, true, new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, "charm_ii")))
            .maxCount(1)
            .rarity(Rarity.UNCOMMON)
    ){
        @Override
        public void appendTooltip(ItemStack stack, TooltipContext context, net.minecraft.component.type.TooltipDisplayComponent displayComponent, Consumer<Text> textConsumer, TooltipType type) {
            textConsumer.accept(Text.translatable("tooltip.prixilium.charm"));
            super.appendTooltip(stack, context, displayComponent, textConsumer, type);
        }
    });
    public static final Item TRANSFER_CHARM_II = registerItem("transfer_charm_ii", new GeneralCharmItem(true, false, new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, "transfer_charm_ii")))
            .maxCount(1)
            .maxDamage(16)
            .rarity(Rarity.RARE)
    ));
    public static final Item CONTAINER_CHARM_II = registerItem("container_charm_ii", new ContainerCharmItem(3, true, false, new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, "container_charm_ii")))
            .maxCount(1)
            .rarity(Rarity.RARE)
    ));
    public static final Item ROLLBACK_CHARM_II = registerItem("rollback_charm_ii", new GeneralCharmItem(true, false, new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, "rollback_charm_ii")))
            .maxCount(1)
            .maxDamage(16)
            .rarity(Rarity.RARE)
    ));
    public static final Item REGENERATION_CHARM_II = registerItem("regeneration_charm_ii", new GeneralCharmItem(true, false, new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, "regeneration_charm_ii")))
            .maxCount(1)
            .maxDamage(16)
            .rarity(Rarity.RARE)
    ));
    public static final Item POSTMORTAL_CHARM_II = registerItem("postmortal_charm_ii", new PostmortalCharmItem(true, false, new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, "postmortal_charm_ii")))
            .maxCount(1)
            .maxDamage(16)
            .rarity(Rarity.RARE)
    ));

    // Tier III
    public static final Item CHARM_III = registerItem("charm_iii", new GeneralCharmItem(false, true, new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, "charm_iii")))
            .maxCount(1)
            .rarity(Rarity.RARE)
    ){
        @Override
        public void appendTooltip(ItemStack stack, TooltipContext context, net.minecraft.component.type.TooltipDisplayComponent displayComponent, Consumer<Text> textConsumer, TooltipType type) {
            textConsumer.accept(Text.translatable("tooltip.prixilium.charm"));
            super.appendTooltip(stack, context, displayComponent, textConsumer, type);
        }
    });
    public static final Item TRANSFER_CHARM_III = registerItem("transfer_charm_iii", new GeneralCharmItem(false, false, new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, "transfer_charm_iii")))
            .maxCount(1)
            .maxDamage(32)
            .rarity(Rarity.EPIC)
    ));
    public static final Item CONTAINER_CHARM_III = registerItem("container_charm_iii", new ContainerCharmItem(6, false, false, new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, "container_charm_iii")))
            .maxCount(1)
            .rarity(Rarity.EPIC)
    ));
    public static final Item ROLLBACK_CHARM_III = registerItem("rollback_charm_iii", new GeneralCharmItem(false, false, new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, "rollback_charm_iii")))
            .maxCount(1)
            .maxDamage(32)
            .rarity(Rarity.EPIC)
    ));
    public static final Item REGENERATION_CHARM_III = registerItem("regeneration_charm_iii", new GeneralCharmItem(false, false, new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, "regeneration_charm_iii")))
            .maxCount(1)
            .maxDamage(32)
            .rarity(Rarity.EPIC)
    ));
    public static final Item POSTMORTAL_CHARM_III = registerItem("postmortal_charm_iii", new PostmortalCharmItem(false, false, new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, "postmortal_charm_iii")))
            .maxCount(1)
            .maxDamage(32)
            .rarity(Rarity.EPIC)
    ));

    //endregion

    //region [Tools]

    //region [wood]
    public static final Item PRIXILED_WOODEN_SWORD = registerItem("prixiled_wooden_sword", new Item(new Item.Settings().sword(ToolMaterial.WOOD, 3, -2.4F)
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, "prixiled_wooden_sword")))
            .component(DataComponentTypes.UNBREAKABLE, Unit.INSTANCE)
    ));
    public static final Item PRIXILED_WOODEN_PICKAXE = registerItem("prixiled_wooden_pickaxe", new Item(new Item.Settings().pickaxe(ToolMaterial.WOOD, 1, -2.8F)
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, "prixiled_wooden_pickaxe")))
            .component(DataComponentTypes.UNBREAKABLE, Unit.INSTANCE)
    ));
    public static final Item PRIXILED_WOODEN_AXE = registerItem("prixiled_wooden_axe", new AxeItem(ToolMaterial.WOOD, 6, -3.2F, new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, "prixiled_wooden_axe")))
            .component(DataComponentTypes.UNBREAKABLE, Unit.INSTANCE)
    ));
    public static final Item PRIXILED_WOODEN_SHOVEL = registerItem("prixiled_wooden_shovel", new ShovelItem(ToolMaterial.WOOD, 1.5F, -3, new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, "prixiled_wooden_shovel")))
            .component(DataComponentTypes.UNBREAKABLE, Unit.INSTANCE)
    ));
    public static final Item PRIXILED_WOODEN_HOE = registerItem("prixiled_wooden_hoe", new HoeItem(ToolMaterial.WOOD, 0, -3, new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, "prixiled_wooden_hoe")))
            .component(DataComponentTypes.UNBREAKABLE, Unit.INSTANCE)
    ));
    //endregion

    //region [stone]
    public static final Item PRIXILED_STONE_SWORD = registerItem("prixiled_stone_sword", new Item(new Item.Settings().sword(ToolMaterial.STONE, 3, -2.4F)
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, "prixiled_stone_sword")))
            .component(DataComponentTypes.UNBREAKABLE, Unit.INSTANCE)
    ));
    public static final Item PRIXILED_STONE_PICKAXE = registerItem("prixiled_stone_pickaxe", new Item(new Item.Settings().pickaxe(ToolMaterial.STONE, 1, -2.8F)
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, "prixiled_stone_pickaxe")))
            .component(DataComponentTypes.UNBREAKABLE, Unit.INSTANCE)
    ));
    public static final Item PRIXILED_STONE_AXE = registerItem("prixiled_stone_axe", new AxeItem(ToolMaterial.STONE, 7, -3.2F, new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, "prixiled_stone_axe")))
            .component(DataComponentTypes.UNBREAKABLE, Unit.INSTANCE)
    ));
    public static final Item PRIXILED_STONE_SHOVEL = registerItem("prixiled_stone_shovel", new ShovelItem(ToolMaterial.STONE, 1.5F, -3, new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, "prixiled_stone_shovel")))
            .component(DataComponentTypes.UNBREAKABLE, Unit.INSTANCE)
    ));
    public static final Item PRIXILED_STONE_HOE = registerItem("prixiled_stone_hoe", new HoeItem(ToolMaterial.STONE, -1, -2, new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, "prixiled_stone_hoe")))
            .component(DataComponentTypes.UNBREAKABLE, Unit.INSTANCE)
    ));
    //endregion

    //region [copper]
    /* 1.21.9+
    public static final Item PRIXILED_COPPER_SWORD = registerItem("prixiled_copper_sword", new Item(new Item.Settings().sword(ToolMaterial.COPPER, idk, idk)
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, "prixiled_copper_sword")))
            .component(DataComponentTypes.UNBREAKABLE, Unit.INSTANCE)
    ));
    public static final Item PRIXILED_COPPER_PICKAXE = registerItem("prixiled_copper_pickaxe", new Item(new Item.Settings().pickaxe(ToolMaterial.COPPER, idk, idk)
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, "prixiled_copper_pickaxe")))
            .component(DataComponentTypes.UNBREAKABLE, Unit.INSTANCE)
    ));
    public static final Item PRIXILED_COPPER_AXE = registerItem("prixiled_copper_axe", new AxeItem(ToolMaterial.COPPER, idk, idk, new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, "prixiled_copper_axe")))
            .component(DataComponentTypes.UNBREAKABLE, Unit.INSTANCE)
    ));
    public static final Item PRIXILED_COPPER_SHOVEL = registerItem("prixiled_copper_shovel", new ShovelItem(ToolMaterial.COPPER , idk, idk, new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, "prixiled_copper_shovel")))
            .component(DataComponentTypes.UNBREAKABLE, Unit.INSTANCE)
    ));
    public static final Item PRIXILED_COPPER_HOE = registerItem("prixiled_copper_hoe", new HoeItem(ToolMaterial.COPPER, idk, idk, new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, "prixiled_copper_hoe")))
            .component(DataComponentTypes.UNBREAKABLE, Unit.INSTANCE)
    ));
     */
    //endregion

    //region [iron]
    public static final Item PRIXILED_IRON_SWORD = registerItem("prixiled_iron_sword", new Item(new Item.Settings().sword(ToolMaterial.IRON, 3, -2.4F)
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, "prixiled_iron_sword")))
            .component(DataComponentTypes.UNBREAKABLE, Unit.INSTANCE)
    ));
    public static final Item PRIXILED_IRON_PICKAXE = registerItem("prixiled_iron_pickaxe", new Item(new Item.Settings().pickaxe(ToolMaterial.IRON, 1, -2.8F)
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, "prixiled_iron_pickaxe")))
            .component(DataComponentTypes.UNBREAKABLE, Unit.INSTANCE)
    ));
    public static final Item PRIXILED_IRON_AXE = registerItem("prixiled_iron_axe", new AxeItem(ToolMaterial.IRON, 6, -3.1F, new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, "prixiled_iron_axe")))
            .component(DataComponentTypes.UNBREAKABLE, Unit.INSTANCE)
    ));
    public static final Item PRIXILED_IRON_SHOVEL = registerItem("prixiled_iron_shovel", new ShovelItem(ToolMaterial.IRON, 1.5F, -3, new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, "prixiled_iron_shovel")))
            .component(DataComponentTypes.UNBREAKABLE, Unit.INSTANCE)
    ));
    public static final Item PRIXILED_IRON_HOE = registerItem("prixiled_iron_hoe", new HoeItem(ToolMaterial.IRON, -2, -1, new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, "prixiled_iron_hoe")))
            .component(DataComponentTypes.UNBREAKABLE, Unit.INSTANCE)
    ));
    //endregion

    //region [gold]
    public static final Item PRIXILED_GOLDEN_SWORD = registerItem("prixiled_golden_sword", new Item(new Item.Settings().sword(ToolMaterial.GOLD, 3, -2.4F)
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, "prixiled_golden_sword")))
            .component(DataComponentTypes.UNBREAKABLE, Unit.INSTANCE)
    ));
    public static final Item PRIXILED_GOLDEN_PICKAXE = registerItem("prixiled_golden_pickaxe", new Item(new Item.Settings().pickaxe(ToolMaterial.GOLD, 1, -2.8F)
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, "prixiled_golden_pickaxe")))
            .component(DataComponentTypes.UNBREAKABLE, Unit.INSTANCE)
    ));
    public static final Item PRIXILED_GOLDEN_AXE = registerItem("prixiled_golden_axe", new AxeItem(ToolMaterial.GOLD, 6, -3, new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, "prixiled_golden_axe")))
            .component(DataComponentTypes.UNBREAKABLE, Unit.INSTANCE)
    ));
    public static final Item PRIXILED_GOLDEN_SHOVEL = registerItem("prixiled_golden_shovel", new ShovelItem(ToolMaterial.GOLD, 1.5F, -3, new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, "prixiled_golden_shovel")))
            .component(DataComponentTypes.UNBREAKABLE, Unit.INSTANCE)
    ));
    public static final Item PRIXILED_GOLDEN_HOE = registerItem("prixiled_golden_hoe", new HoeItem(ToolMaterial.GOLD, 0, -3, new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, "prixiled_golden_hoe")))
            .component(DataComponentTypes.UNBREAKABLE, Unit.INSTANCE)
    ));
    //endregion

    //region [diamond]
    public static final Item PRIXILED_DIAMOND_SWORD = registerItem("prixiled_diamond_sword", new Item(new Item.Settings().sword(ToolMaterial.DIAMOND, 3, -2.4F)
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, "prixiled_diamond_sword")))
            .component(DataComponentTypes.UNBREAKABLE, Unit.INSTANCE)
    ));
    public static final Item PRIXILED_DIAMOND_PICKAXE = registerItem("prixiled_diamond_pickaxe", new Item(new Item.Settings().pickaxe(ToolMaterial.DIAMOND, 1, -2.8F)
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, "prixiled_diamond_pickaxe")))
            .component(DataComponentTypes.UNBREAKABLE, Unit.INSTANCE)
    ));
    public static final Item PRIXILED_DIAMOND_AXE = registerItem("prixiled_diamond_axe", new AxeItem(ToolMaterial.DIAMOND, 5, -3, new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, "prixiled_diamond_axe")))
            .component(DataComponentTypes.UNBREAKABLE, Unit.INSTANCE)
    ));
    public static final Item PRIXILED_DIAMOND_SHOVEL = registerItem("prixiled_diamond_shovel", new ShovelItem(ToolMaterial.DIAMOND, 1.5F, -3, new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, "prixiled_diamond_shovel")))
            .component(DataComponentTypes.UNBREAKABLE, Unit.INSTANCE)
    ));
    public static final Item PRIXILED_DIAMOND_HOE = registerItem("prixiled_diamond_hoe", new HoeItem(ToolMaterial.DIAMOND, -3, 0, new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, "prixiled_diamond_hoe")))
            .component(DataComponentTypes.UNBREAKABLE, Unit.INSTANCE)
    ));
    //endregion

    //region [netherite]
    public static final Item PRIXILED_NETHERITE_SWORD = registerItem("prixiled_netherite_sword", new Item(new Item.Settings().sword(ToolMaterial.NETHERITE, 3, -2.4F)
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, "prixiled_netherite_sword")))
            .component(DataComponentTypes.UNBREAKABLE, Unit.INSTANCE)
            .fireproof()
    ));
    public static final Item PRIXILED_NETHERITE_PICKAXE = registerItem("prixiled_netherite_pickaxe", new Item(new Item.Settings().pickaxe(ToolMaterial.NETHERITE, 1, -2.8F)
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, "prixiled_netherite_pickaxe")))
            .component(DataComponentTypes.UNBREAKABLE, Unit.INSTANCE)
            .fireproof()
    ));
    public static final Item PRIXILED_NETHERITE_AXE = registerItem("prixiled_netherite_axe", new AxeItem(ToolMaterial.NETHERITE, 5, -3, new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, "prixiled_netherite_axe")))
            .component(DataComponentTypes.UNBREAKABLE, Unit.INSTANCE)
            .fireproof()
    ));
    public static final Item PRIXILED_NETHERITE_SHOVEL = registerItem("prixiled_netherite_shovel", new ShovelItem(ToolMaterial.NETHERITE, 1.5F, -3, new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, "prixiled_netherite_shovel")))
            .component(DataComponentTypes.UNBREAKABLE, Unit.INSTANCE)
            .fireproof()
    ));
    public static final Item PRIXILED_NETHERITE_HOE = registerItem("prixiled_netherite_hoe", new HoeItem(ToolMaterial.NETHERITE, -4, 0, new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, "prixiled_netherite_hoe")))
            .component(DataComponentTypes.UNBREAKABLE, Unit.INSTANCE)
            .fireproof()
    ));
    //endregion

    public static final Item PRIXILED_BOW = registerItem("prixiled_bow", new BowItem(new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, "prixiled_bow")))
            .maxCount(1)
            .maxDamage(384)
            .component(DataComponentTypes.UNBREAKABLE, Unit.INSTANCE)
    ));

    public static final Item PRIXILED_MACE = registerItem("prixiled_mace", new MaceItem(new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, "prixiled_mace")))
            .maxCount(1)
            .rarity(Rarity.EPIC)
            .attributeModifiers(MaceItem.createAttributeModifiers())
            .component(DataComponentTypes.UNBREAKABLE, Unit.INSTANCE)
    ));

    //endregion


    //region [Armors]

    //region [leather]
    public static final Item PRIXILED_LEATHER_HELMET = registerItem("prixiled_leather_helmet", new Item(new Item.Settings().armor(ModArmorMaterials.PRIXILIUM_LEATHER, EquipmentType.HELMET)
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, "prixiled_leather_helmet")))
            .maxCount(1)
            .component(DataComponentTypes.UNBREAKABLE, Unit.INSTANCE)
            .component(DataComponentTypes.DYED_COLOR, new DyedColorComponent(0xA06540))
    ));

    public static final Item PRIXILED_LEATHER_CHESTPLATE = registerItem("prixiled_leather_chestplate", new Item(new Item.Settings().armor(ModArmorMaterials.PRIXILIUM_LEATHER, EquipmentType.CHESTPLATE)
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, "prixiled_leather_chestplate")))
            .maxCount(1)
            .component(DataComponentTypes.UNBREAKABLE, Unit.INSTANCE)
            .component(DataComponentTypes.DYED_COLOR, new DyedColorComponent(0xA06540))
    ));

    public static final Item PRIXILED_LEATHER_LEGGINGS = registerItem("prixiled_leather_leggings", new Item(new Item.Settings().armor(ModArmorMaterials.PRIXILIUM_LEATHER, EquipmentType.LEGGINGS)
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, "prixiled_leather_leggings")))
            .maxCount(1)
            .component(DataComponentTypes.UNBREAKABLE, Unit.INSTANCE)
            .component(DataComponentTypes.DYED_COLOR, new DyedColorComponent(0xA06540))
    ));

    public static final Item PRIXILED_LEATHER_BOOTS = registerItem("prixiled_leather_boots", new Item(new Item.Settings().armor(ModArmorMaterials.PRIXILIUM_LEATHER, EquipmentType.BOOTS)
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, "prixiled_leather_boots")))
            .maxCount(1)
            .component(DataComponentTypes.UNBREAKABLE, Unit.INSTANCE)
            .component(DataComponentTypes.DYED_COLOR, new DyedColorComponent(0xA06540))
    ));
    //endregion

    //region [chainmail]
    public static final Item PRIXILED_CHAINMAIL_HELMET = registerItem("prixiled_chainmail_helmet", new Item(new Item.Settings().armor(ModArmorMaterials.PRIXILIUM_CHAIN, EquipmentType.HELMET)
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, "prixiled_chainmail_helmet")))
            .maxCount(1)
            .component(DataComponentTypes.UNBREAKABLE, Unit.INSTANCE)
    ));

    public static final Item PRIXILED_CHAINMAIL_CHESTPLATE = registerItem("prixiled_chainmail_chestplate", new Item(new Item.Settings().armor(ModArmorMaterials.PRIXILIUM_CHAIN, EquipmentType.CHESTPLATE)
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, "prixiled_chainmail_chestplate")))
            .maxCount(1)
            .component(DataComponentTypes.UNBREAKABLE, Unit.INSTANCE)
    ));

    public static final Item PRIXILED_CHAINMAIL_LEGGINGS = registerItem("prixiled_chainmail_leggings", new Item(new Item.Settings().armor(ModArmorMaterials.PRIXILIUM_CHAIN, EquipmentType.LEGGINGS)
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, "prixiled_chainmail_leggings")))
            .maxCount(1)
            .component(DataComponentTypes.UNBREAKABLE, Unit.INSTANCE)
    ));

    public static final Item PRIXILED_CHAINMAIL_BOOTS = registerItem("prixiled_chainmail_boots", new Item(new Item.Settings().armor(ModArmorMaterials.PRIXILIUM_CHAIN, EquipmentType.BOOTS)
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, "prixiled_chainmail_boots")))
            .maxCount(1)
            .component(DataComponentTypes.UNBREAKABLE, Unit.INSTANCE)
    ));
    //endregion

    //region [copper]
    /* 1.21.9+
    public static final Item PRIXILED_COPPER_HELMET = registerItem("prixiled_copper_helmet", new Item(new Item.Settings().armor(ModArmorMaterials.PRIXILIUM_COPPER, EquipmentType.HELMET)
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, "prixiled_copper_helmet")))
            .maxCount(1)
            .component(DataComponentTypes.UNBREAKABLE, Unit.INSTANCE)
    ));

    public static final Item PRIXILED_COPPER_CHESTPLATE = registerItem("prixiled_copper_chestplate", new Item(new Item.Settings().armor(ModArmorMaterials.PRIXILIUM_COPPER, EquipmentType.CHESTPLATE)
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, "prixiled_copper_chestplate")))
            .maxCount(1)
            .component(DataComponentTypes.UNBREAKABLE, Unit.INSTANCE)
    ));

    public static final Item PRIXILED_COPPER_LEGGINGS = registerItem("prixiled_copper_leggings", new Item(new Item.Settings().armor(ModArmorMaterials.PRIXILIUM_COPPER, EquipmentType.LEGGINGS)
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, "prixiled_copper_leggings")))
            .maxCount(1)
            .component(DataComponentTypes.UNBREAKABLE, Unit.INSTANCE)
    ));

    public static final Item PRIXILED_COPPER_BOOTS = registerItem("prixiled_copper_boots", new Item(new Item.Settings().armor(ModArmorMaterials.PRIXILIUM_COPPER, EquipmentType.BOOTS)
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, "prixiled_copper_boots")))
            .maxCount(1)
            .component(DataComponentTypes.UNBREAKABLE, Unit.INSTANCE)
    ));
     */
    //endregion

    //region [iron]
    public static final Item PRIXILED_IRON_HELMET = registerItem("prixiled_iron_helmet", new Item(new Item.Settings().armor(ModArmorMaterials.PRIXILIUM_IRON, EquipmentType.HELMET)
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, "prixiled_iron_helmet")))
            .maxCount(1)
            .component(DataComponentTypes.UNBREAKABLE, Unit.INSTANCE)));

    public static final Item PRIXILED_IRON_CHESTPLATE = registerItem("prixiled_iron_chestplate", new Item(new Item.Settings().armor(ModArmorMaterials.PRIXILIUM_IRON, EquipmentType.CHESTPLATE)
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, "prixiled_iron_chestplate")))
            .maxCount(1)
            .component(DataComponentTypes.UNBREAKABLE, Unit.INSTANCE)));

    public static final Item PRIXILED_IRON_LEGGINGS = registerItem("prixiled_iron_leggings", new Item(new Item.Settings().armor(ModArmorMaterials.PRIXILIUM_IRON, EquipmentType.LEGGINGS)
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, "prixiled_iron_leggings")))
            .maxCount(1)
            .component(DataComponentTypes.UNBREAKABLE, Unit.INSTANCE)));

    public static final Item PRIXILED_IRON_BOOTS = registerItem("prixiled_iron_boots", new Item(new Item.Settings().armor(ModArmorMaterials.PRIXILIUM_IRON, EquipmentType.BOOTS)
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, "prixiled_iron_boots")))
            .maxCount(1)
            .component(DataComponentTypes.UNBREAKABLE, Unit.INSTANCE)));
    //endregion

    //region [gold]
    public static final Item PRIXILED_GOLDEN_HELMET = registerItem("prixiled_golden_helmet", new Item(new Item.Settings().armor(ModArmorMaterials.PRIXILIUM_GOLD, EquipmentType.HELMET)
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, "prixiled_golden_helmet")))
            .maxCount(1)
            .component(DataComponentTypes.UNBREAKABLE, Unit.INSTANCE)));

    public static final Item PRIXILED_GOLDEN_CHESTPLATE = registerItem("prixiled_golden_chestplate", new Item(new Item.Settings().armor(ModArmorMaterials.PRIXILIUM_GOLD, EquipmentType.CHESTPLATE)
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, "prixiled_golden_chestplate")))
            .maxCount(1)
            .component(DataComponentTypes.UNBREAKABLE, Unit.INSTANCE)));

    public static final Item PRIXILED_GOLDEN_LEGGINGS = registerItem("prixiled_golden_leggings", new Item(new Item.Settings().armor(ModArmorMaterials.PRIXILIUM_GOLD, EquipmentType.LEGGINGS)
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, "prixiled_golden_leggings")))
            .maxCount(1)
            .component(DataComponentTypes.UNBREAKABLE, Unit.INSTANCE)));

    public static final Item PRIXILED_GOLDEN_BOOTS = registerItem("prixiled_golden_boots", new Item(new Item.Settings().armor(ModArmorMaterials.PRIXILIUM_GOLD, EquipmentType.BOOTS)
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, "prixiled_golden_boots")))
            .maxCount(1)
            .component(DataComponentTypes.UNBREAKABLE, Unit.INSTANCE)));
    //endregion

    //region [diamond]
    public static final Item PRIXILED_DIAMOND_HELMET = registerItem("prixiled_diamond_helmet", new Item(new Item.Settings().armor(ModArmorMaterials.PRIXILIUM_DIAMOND, EquipmentType.HELMET)
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, "prixiled_diamond_helmet")))
            .maxCount(1)
            .component(DataComponentTypes.UNBREAKABLE, Unit.INSTANCE)));

    public static final Item PRIXILED_DIAMOND_CHESTPLATE = registerItem("prixiled_diamond_chestplate", new Item(new Item.Settings().armor(ModArmorMaterials.PRIXILIUM_DIAMOND, EquipmentType.CHESTPLATE)
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, "prixiled_diamond_chestplate")))
            .maxCount(1)
            .component(DataComponentTypes.UNBREAKABLE, Unit.INSTANCE)));

    public static final Item PRIXILED_DIAMOND_LEGGINGS = registerItem("prixiled_diamond_leggings", new Item(new Item.Settings().armor(ModArmorMaterials.PRIXILIUM_DIAMOND, EquipmentType.LEGGINGS)
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, "prixiled_diamond_leggings")))
            .maxCount(1)
            .component(DataComponentTypes.UNBREAKABLE, Unit.INSTANCE)));

    public static final Item PRIXILED_DIAMOND_BOOTS = registerItem("prixiled_diamond_boots", new Item(new Item.Settings().armor(ModArmorMaterials.PRIXILIUM_DIAMOND, EquipmentType.BOOTS)
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, "prixiled_diamond_boots")))
            .maxCount(1)
            .component(DataComponentTypes.UNBREAKABLE, Unit.INSTANCE)));
    //endregion

    //region [netherite]
    public static final Item PRIXILED_NETHERITE_HELMET = registerItem("prixiled_netherite_helmet", new Item(new Item.Settings().armor(ModArmorMaterials.PRIXILIUM_NETHERITE, EquipmentType.HELMET)
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, "prixiled_netherite_helmet")))
            .maxCount(1)
            .component(DataComponentTypes.UNBREAKABLE, Unit.INSTANCE)
            .fireproof()
    ));

    public static final Item PRIXILED_NETHERITE_CHESTPLATE = registerItem("prixiled_netherite_chestplate", new Item(new Item.Settings().armor(ModArmorMaterials.PRIXILIUM_NETHERITE, EquipmentType.CHESTPLATE)
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, "prixiled_netherite_chestplate")))
            .maxCount(1)
            .component(DataComponentTypes.UNBREAKABLE, Unit.INSTANCE)
            .fireproof()
    ));

    public static final Item PRIXILED_NETHERITE_LEGGINGS = registerItem("prixiled_netherite_leggings", new Item(new Item.Settings().armor(ModArmorMaterials.PRIXILIUM_NETHERITE, EquipmentType.LEGGINGS)
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, "prixiled_netherite_leggings")))
            .maxCount(1)
            .component(DataComponentTypes.UNBREAKABLE, Unit.INSTANCE)
            .fireproof()
    ));

    public static final Item PRIXILED_NETHERITE_BOOTS = registerItem("prixiled_netherite_boots", new Item(new Item.Settings().armor(ModArmorMaterials.PRIXILIUM_NETHERITE, EquipmentType.BOOTS)
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, "prixiled_netherite_boots")))
            .maxCount(1)
            .component(DataComponentTypes.UNBREAKABLE, Unit.INSTANCE)
            .fireproof()
    ));
    //endregion

    //region [turtle]
    public static final Item PRIXILED_TURTLE_HELMET = registerItem("prixiled_turtle_helmet", new Item(new Item.Settings().armor(ModArmorMaterials.PRIXILIUM_TURTLE, EquipmentType.HELMET)
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, "prixiled_turtle_helmet")))
            .maxCount(1)
            .component(DataComponentTypes.UNBREAKABLE, Unit.INSTANCE)
    ));
    //endregion

    //region [horse]
    public static final Item PRIXILED_LEATHER_HORSE_ARMOR = registerItem("prixiled_leather_horse_armor", new Item(new Item.Settings().horseArmor(ModArmorMaterials.PRIXILIUM_LEATHER)
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, "prixiled_leather_horse_armor")))
            .maxCount(1)
            .component(DataComponentTypes.UNBREAKABLE, Unit.INSTANCE)
            .component(DataComponentTypes.DYED_COLOR, new DyedColorComponent(0xA06540))
    ));
    /* 1.21.9+
    public static final Item PRIXILED_COPPER_HORSE_ARMOR = registerItem("prixiled_copper_horse_armor", new Item(new Item.Settings().horseArmor(ModArmorMaterials.PRIXILIUM_COPPER)
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, "prixiled_copper_horse_armor")))
            .maxCount(1)
            .component(DataComponentTypes.UNBREAKABLE, Unit.INSTANCE)
            ));
    */
    public static final Item PRIXILED_IRON_HORSE_ARMOR = registerItem("prixiled_iron_horse_armor", new Item(new Item.Settings().horseArmor(ModArmorMaterials.PRIXILIUM_IRON)
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, "prixiled_iron_horse_armor")))
            .maxCount(1)
            .component(DataComponentTypes.UNBREAKABLE, Unit.INSTANCE)
    ));
    public static final Item PRIXILED_GOLDEN_HORSE_ARMOR = registerItem("prixiled_golden_horse_armor", new Item(new Item.Settings().horseArmor(ModArmorMaterials.PRIXILIUM_GOLD)
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, "prixiled_golden_horse_armor")))
            .maxCount(1)
            .component(DataComponentTypes.UNBREAKABLE, Unit.INSTANCE)
    ));
    public static final Item PRIXILED_DIAMOND_HORSE_ARMOR = registerItem("prixiled_diamond_horse_armor", new Item(new Item.Settings().horseArmor(ModArmorMaterials.PRIXILIUM_DIAMOND)
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, "prixiled_diamond_horse_armor")))
            .maxCount(1)
            .component(DataComponentTypes.UNBREAKABLE, Unit.INSTANCE)
    ));
    /* 1.21.11+
    public static final Item PRIXILED_NETHERITE_HORSE_ARMOR = registerItem("prixiled_netherite_horse_armor", new Item(new Item.Settings().horseArmor(ModArmorMaterials.PRIXILIUM_NETHERITE)
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, "prixiled_netherite_horse_armor")))
            .maxCount(1)
            .component(DataComponentTypes.UNBREAKABLE, Unit.INSTANCE)));
    */
    //endregion


    //endregion

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(Prixilium.MOD_ID, name), item);
    }

    public static void registerItems() {Prixilium.LOGGER.info("Registering Prixilium Items.");}
}
