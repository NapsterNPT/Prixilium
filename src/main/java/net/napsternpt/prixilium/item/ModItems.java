package net.napsternpt.prixilium.item;

import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.*;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.*;
import net.minecraft.item.consume.ApplyEffectsConsumeEffect;
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
import net.napsternpt.prixilium.effect.ModEffects;
import net.napsternpt.prixilium.entity.ModEntities;
import net.napsternpt.prixilium.item.custom.CharmItem;
import net.napsternpt.prixilium.item.custom.PrixiliumHookItem;
import net.napsternpt.prixilium.item.custom.ThermometerItem;
import net.napsternpt.prixilium.item.custom.VirusAliveItem;
import net.napsternpt.prixilium.item.custom.charm.*;

import java.util.function.Consumer;
import java.util.stream.Stream;

public class ModItems {
    private static String name;

    //region [Other]
    public static final Item VIRUS_ALIVE = registerItem(name = "virus_alive", new VirusAliveItem(new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, name)))
            .maxCount(1)
            .maxDamage(100)
            .rarity(Rarity.RARE)
            .component(DataComponentTypes.TOOLTIP_DISPLAY, TooltipDisplayComponent.DEFAULT.with(DataComponentTypes.DAMAGE, true))
    ));
    public static final Item VIRUS_DEAD = registerItem(name = "virus_dead", new Item(new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, name)))
    ));

    public static final Item THERMOMETER = registerItem(name = "thermometer", new ThermometerItem(new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, name)))
            .maxCount(1)
    ));

    public static final Item PRIXILIUM_UPGRADE_SMITHING_TEMPLATE = registerItem(name = "prixilium_upgrade_smithing_template", new Item(new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, name)))
    ));

    public static final Item PRIXILIUM_HOOK = registerItem(name = "prixilium_hook", new PrixiliumHookItem(new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, name)))
            .maxDamage(32)
    ));

    public static final Item NAPSTERNPT_PLUSHY = registerItem(name = "napsternpt_plushy", new Item(new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, name)))
            .component(DataComponentTypes.DEATH_PROTECTION, DeathProtectionComponent.TOTEM_OF_UNDYING)
            .maxCount(1)
            .fireproof()
            .rarity(Rarity.EPIC)
    ){
        @Override
        public void appendTooltip(ItemStack stack, Item.TooltipContext context, TooltipDisplayComponent displayComponent, Consumer<Text> textConsumer, TooltipType type) {
            textConsumer.accept(Text.translatable("thank_you"));
            super.appendTooltip(stack, context, displayComponent, textConsumer, type);
        }
    });

    public static final Item BLIKO_SPAWN_EGG = registerItem(name = "bliko_spawn_egg", new SpawnEggItem(new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, name)))
            .spawnEgg(ModEntities.BLIKO)
    ));
    public static final Item BLOKITO_SPAWN_EGG = registerItem(name = "blokito_spawn_egg", new SpawnEggItem(new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, name)))
            .spawnEgg(ModEntities.BLOKITO)
    ));
    public static final Item AIRIS_SPAWN_EGG = registerItem(name = "airis_spawn_egg", new SpawnEggItem(new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, name)))
            .spawnEgg(ModEntities.AIRIS)
    ));
    //endregion


    //region [Charms]
    //region [Tier I]
    public static final Item CHARM_I = registerItem(name = "charm_i", new CharmItem((CharmSettings) new CharmSettings()
            .upgradable().specializable()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, name)))
            .maxCount(1)
    ){
        @Override
        public void appendTooltip(ItemStack stack, TooltipContext context, TooltipDisplayComponent displayComponent, Consumer<Text> textConsumer, TooltipType type) {
            textConsumer.accept(Text.translatable("tooltip.prixilium.charm"));
            super.appendTooltip(stack, context, displayComponent, textConsumer, type);
        }
    });
    public static final Item CONTAINER_CHARM_I = registerItem(name = "container_charm_i", new ContainerCharmItem(1, (CharmSettings) new CharmSettings()
            .upgradable()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, name)))
            .maxCount(1)
            .rarity(Rarity.UNCOMMON)
    ));
    public static final Item STASIS_CHARM_I = registerItem(name = "stasis_charm_i", new StasisCharmItem((CharmSettings) new CharmSettings()
            .upgradable()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, name)))
            .maxCount(1)
            .maxDamage(4)
            .rarity(Rarity.UNCOMMON)
    ));
    public static final Item REGENERATION_CHARM_I = registerItem(name = "regeneration_charm_i", new RegenerationCharmItem((CharmSettings) new CharmSettings()
            .upgradable()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, name)))
            .maxCount(1)
            .maxDamage(4)
            .rarity(Rarity.UNCOMMON)
    ));
    public static final Item POSTMORTAL_CHARM_I = registerItem(name = "postmortal_charm_i", new PostmortalCharmItem((CharmSettings) new CharmSettings()
            .upgradable()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, name)))
            .maxCount(1)
            .maxDamage(1)
            .rarity(Rarity.UNCOMMON)
    ));
    public static final Item STOPWATCH_CHARM_I = registerItem(name = "stopwatch_charm_i", new StopwatchCharmItem(5, (CharmSettings) new CharmSettings()
            .upgradable()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, name)))
            .maxCount(1)
            .maxDamage(4)
            .rarity(Rarity.UNCOMMON)
    ));
    public static final Item IMMUNITY_CHARM_I = registerItem(name = "immunity_charm_i", new ImmunityCharmItem(5, (CharmSettings) new CharmSettings()
            .upgradable()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, name)))
            .maxCount(1)
            .maxDamage(4)
            .rarity(Rarity.UNCOMMON)
    ));
    public static final Item SONIC_BOOM_CHARM_I = registerItem(name = "sonic_boom_charm_i", new SonicBoomCharmItem(5.0F, (CharmSettings) new CharmSettings()
            .upgradable()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, name)))
            .maxCount(1)
            .maxDamage(4)
            .rarity(Rarity.UNCOMMON)
    ));
    public static final Item WITHER_CHARM_I = registerItem(name = "wither_charm_i", new WitherCharmItem(200, (CharmSettings) new CharmSettings()
            .upgradable()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, name)))
            .maxCount(1)
            .maxDamage(4)
            .rarity(Rarity.UNCOMMON)
    ));
    //endregion

    //region [Tier II]
    public static final Item CHARM_II = registerItem(name = "charm_ii", new CharmItem((CharmSettings) new CharmSettings()
            .upgradable().specializable()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, name)))
            .maxCount(1)
            .rarity(Rarity.UNCOMMON)
    ){
        @Override
        public void appendTooltip(ItemStack stack, TooltipContext context, TooltipDisplayComponent displayComponent, Consumer<Text> textConsumer, TooltipType type) {
            textConsumer.accept(Text.translatable("tooltip.prixilium.charm"));
            super.appendTooltip(stack, context, displayComponent, textConsumer, type);
        }
    });
    public static final Item CONTAINER_CHARM_II = registerItem(name = "container_charm_ii", new ContainerCharmItem(3, (CharmSettings) new CharmSettings()
            .upgradable()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, name)))
            .maxCount(1)
            .rarity(Rarity.RARE)
    ));
    public static final Item STASIS_CHARM_II = registerItem(name = "stasis_charm_ii", new StasisCharmItem((CharmSettings) new CharmSettings()
            .upgradable()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, name)))
            .maxCount(1)
            .maxDamage(16)
            .rarity(Rarity.RARE)
    ));
    public static final Item REGENERATION_CHARM_II = registerItem(name = "regeneration_charm_ii", new RegenerationCharmItem((CharmSettings) new CharmSettings()
            .upgradable()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, name)))
            .maxCount(1)
            .maxDamage(16)
            .rarity(Rarity.RARE)
    ));
    public static final Item POSTMORTAL_CHARM_II = registerItem(name = "postmortal_charm_ii", new PostmortalCharmItem((CharmSettings) new CharmSettings()
            .upgradable()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, name)))
            .maxCount(1)
            .maxDamage(4)
            .rarity(Rarity.RARE)
    ));
    public static final Item STOPWATCH_CHARM_II = registerItem(name = "stopwatch_charm_ii", new StopwatchCharmItem(15, (CharmSettings) new CharmSettings()
            .upgradable()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, name)))
            .maxCount(1)
            .maxDamage(16)
            .rarity(Rarity.RARE)
    ));
    public static final Item IMMUNITY_CHARM_II = registerItem(name = "immunity_charm_ii", new ImmunityCharmItem(15, (CharmSettings) new CharmSettings()
            .upgradable()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, name)))
            .maxCount(1)
            .maxDamage(16)
            .rarity(Rarity.RARE)
    ));
    public static final Item SONIC_BOOM_CHARM_II = registerItem(name = "sonic_boom_charm_ii", new SonicBoomCharmItem(10.0F, (CharmSettings) new CharmSettings()
            .upgradable()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, name)))
            .maxCount(1)
            .maxDamage(16)
            .rarity(Rarity.RARE)
    ));
    public static final Item WITHER_CHARM_II = registerItem(name = "wither_charm_ii", new WitherCharmItem(300, (CharmSettings) new CharmSettings()
            .upgradable()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, name)))
            .maxCount(1)
            .maxDamage(16)
            .rarity(Rarity.RARE)
    ));
    //endregion

    //region [Tier III]
    public static final Item CHARM_III = registerItem(name = "charm_iii", new CharmItem((CharmSettings) new CharmSettings()
            .specializable()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, name)))
            .maxCount(1)
            .fireproof()
            .rarity(Rarity.RARE)
    ){
        @Override
        public void appendTooltip(ItemStack stack, TooltipContext context, TooltipDisplayComponent displayComponent, Consumer<Text> textConsumer, TooltipType type) {
            textConsumer.accept(Text.translatable("tooltip.prixilium.charm"));
            super.appendTooltip(stack, context, displayComponent, textConsumer, type);
        }
    });
    public static final Item CONTAINER_CHARM_III = registerItem(name = "container_charm_iii", new ContainerCharmItem(6, (CharmSettings) new CharmSettings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, name)))
            .maxCount(1)
            .fireproof()
            .rarity(Rarity.EPIC)
    ));
    public static final Item STASIS_CHARM_III = registerItem(name = "stasis_charm_iii", new StasisCharmItem((CharmSettings) new CharmSettings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, name)))
            .maxCount(1)
            .maxDamage(32)
            .fireproof()
            .rarity(Rarity.EPIC)
    ));
    public static final Item REGENERATION_CHARM_III = registerItem(name = "regeneration_charm_iii", new RegenerationCharmItem((CharmSettings) new CharmSettings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, name)))
            .maxCount(1)
            .maxDamage(32)
            .fireproof()
            .rarity(Rarity.EPIC)
    ));
    public static final Item POSTMORTAL_CHARM_III = registerItem(name = "postmortal_charm_iii", new PostmortalCharmItem((CharmSettings) new CharmSettings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, name)))
            .maxCount(1)
            .maxDamage(8)
            .fireproof()
            .rarity(Rarity.EPIC)
    ));
    public static final Item STOPWATCH_CHARM_III = registerItem(name = "stopwatch_charm_iii", new StopwatchCharmItem(30, (CharmSettings) new CharmSettings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, name)))
            .maxCount(1)
            .maxDamage(32)
            .fireproof()
            .rarity(Rarity.EPIC)
    ));
    public static final Item IMMUNITY_CHARM_III = registerItem(name = "immunity_charm_iii", new ImmunityCharmItem(30, (CharmSettings) new CharmSettings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, name)))
            .maxCount(1)
            .maxDamage(32)
            .fireproof()
            .rarity(Rarity.EPIC)
    ));
    public static final Item SONIC_BOOM_CHARM_III = registerItem(name = "sonic_boom_charm_iii", new SonicBoomCharmItem(15.0F, (CharmSettings) new CharmSettings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, name)))
            .maxCount(1)
            .maxDamage(32)
            .fireproof()
            .rarity(Rarity.EPIC)
    ));
    public static final Item WITHER_CHARM_III = registerItem(name = "wither_charm_iii", new WitherCharmItem(400, (CharmSettings) new CharmSettings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, name)))
            .maxCount(1)
            .maxDamage(32)
            .fireproof()
            .rarity(Rarity.EPIC)
    ));
    //endregion
    //endregion


    //region [Tools]

    //region [wood]
    public static final Item PRIXILED_WOODEN_SHOVEL = registerItem(name = "prixiled_wooden_shovel", new ShovelItem(ToolMaterial.WOOD, 1.5F, -3, new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, name)))
            .component(DataComponentTypes.UNBREAKABLE, Unit.INSTANCE)
    ));
    public static final Item PRIXILED_WOODEN_PICKAXE = registerItem(name = "prixiled_wooden_pickaxe", new Item(new Item.Settings().pickaxe(ToolMaterial.WOOD, 1, -2.8F)
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, name)))
            .component(DataComponentTypes.UNBREAKABLE, Unit.INSTANCE)
    ));
    public static final Item PRIXILED_WOODEN_AXE = registerItem(name = "prixiled_wooden_axe", new AxeItem(ToolMaterial.WOOD, 6, -3.2F, new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, name)))
            .component(DataComponentTypes.UNBREAKABLE, Unit.INSTANCE)
    ));
    public static final Item PRIXILED_WOODEN_HOE = registerItem(name = "prixiled_wooden_hoe", new HoeItem(ToolMaterial.WOOD, 0, -3, new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, name)))
            .component(DataComponentTypes.UNBREAKABLE, Unit.INSTANCE)
    ));
    public static final Item PRIXILED_WOODEN_SWORD = registerItem(name = "prixiled_wooden_sword", new Item(new Item.Settings().sword(ToolMaterial.WOOD, 3, -2.4F)
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, name)))
            .component(DataComponentTypes.UNBREAKABLE, Unit.INSTANCE)
    ));
    public static final Item PRIXILED_WOODEN_SPEAR = registerItem(name = "prixiled_wooden_spear", new Item(new Item.Settings().spear(ToolMaterial.WOOD, 0.65F, 0.7F, 0.75F, 5.0F, 14.0F, 10.0F, 5.1F, 15.0F, 4.6F)
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, name)))
            .component(DataComponentTypes.UNBREAKABLE, Unit.INSTANCE)
    ));
    //endregion

    //region [stone]
    public static final Item PRIXILED_STONE_SHOVEL = registerItem(name = "prixiled_stone_shovel", new ShovelItem(ToolMaterial.STONE, 1.5F, -3, new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, name)))
            .component(DataComponentTypes.UNBREAKABLE, Unit.INSTANCE)
    ));
    public static final Item PRIXILED_STONE_PICKAXE = registerItem(name = "prixiled_stone_pickaxe", new Item(new Item.Settings().pickaxe(ToolMaterial.STONE, 1, -2.8F)
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, name)))
            .component(DataComponentTypes.UNBREAKABLE, Unit.INSTANCE)
    ));
    public static final Item PRIXILED_STONE_AXE = registerItem(name = "prixiled_stone_axe", new AxeItem(ToolMaterial.STONE, 7, -3.2F, new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, name)))
            .component(DataComponentTypes.UNBREAKABLE, Unit.INSTANCE)
    ));
    public static final Item PRIXILED_STONE_HOE = registerItem(name = "prixiled_stone_hoe", new HoeItem(ToolMaterial.STONE, -1, -2, new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, name)))
            .component(DataComponentTypes.UNBREAKABLE, Unit.INSTANCE)
    ));
    public static final Item PRIXILED_STONE_SWORD = registerItem(name = "prixiled_stone_sword", new Item(new Item.Settings().sword(ToolMaterial.STONE, 3, -2.4F)
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, name)))
            .component(DataComponentTypes.UNBREAKABLE, Unit.INSTANCE)
    ));
    public static final Item PRIXILED_STONE_SPEAR = registerItem(name = "prixiled_stone_spear", new Item(new Item.Settings().spear(ToolMaterial.STONE, 0.75F, 0.82F, 0.7F, 4.5F, 10.0F, 9.0F, 5.1F, 13.75F, 4.6F)
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, name)))
            .component(DataComponentTypes.UNBREAKABLE, Unit.INSTANCE)
    ));
    //endregion

    //region [copper]
    public static final Item PRIXILED_COPPER_SHOVEL = registerItem(name = "prixiled_copper_shovel", new ShovelItem(ToolMaterial.COPPER , 1.5F, -3.0F, new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, name)))
            .component(DataComponentTypes.UNBREAKABLE, Unit.INSTANCE)
    ));
    public static final Item PRIXILED_COPPER_PICKAXE = registerItem(name = "prixiled_copper_pickaxe", new Item(new Item.Settings().pickaxe(ToolMaterial.COPPER, 1.0F, -2.8F)
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, name)))
            .component(DataComponentTypes.UNBREAKABLE, Unit.INSTANCE)
    ));
    public static final Item PRIXILED_COPPER_AXE = registerItem(name = "prixiled_copper_axe", new AxeItem(ToolMaterial.COPPER, 7.0F, -3.2F, new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, name)))
            .component(DataComponentTypes.UNBREAKABLE, Unit.INSTANCE)
    ));
    public static final Item PRIXILED_COPPER_HOE = registerItem(name = "prixiled_copper_hoe", new HoeItem(ToolMaterial.COPPER, -1.0F, -2.0F, new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, name)))
            .component(DataComponentTypes.UNBREAKABLE, Unit.INSTANCE)
    ));
    public static final Item PRIXILED_COPPER_SWORD = registerItem(name = "prixiled_copper_sword", new Item(new Item.Settings().sword(ToolMaterial.COPPER, 3.0F, -2.4F)
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, name)))
            .component(DataComponentTypes.UNBREAKABLE, Unit.INSTANCE)
    ));
    public static final Item PRIXILED_COPPER_SPEAR = registerItem(name = "prixiled_copper_spear", new Item(new Item.Settings().spear(ToolMaterial.COPPER, 0.85F, 0.82F, 0.65F, 4.0F, 9.0F, 8.25F, 5.1F, 12.5F, 4.6F)
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, name)))
            .component(DataComponentTypes.UNBREAKABLE, Unit.INSTANCE)
    ));
    //endregion

    //region [iron]
    public static final Item PRIXILED_IRON_SHOVEL = registerItem(name = "prixiled_iron_shovel", new ShovelItem(ToolMaterial.IRON, 1.5F, -3, new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, name)))
            .component(DataComponentTypes.UNBREAKABLE, Unit.INSTANCE)
    ));
    public static final Item PRIXILED_IRON_PICKAXE = registerItem(name = "prixiled_iron_pickaxe", new Item(new Item.Settings().pickaxe(ToolMaterial.IRON, 1, -2.8F)
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, name)))
            .component(DataComponentTypes.UNBREAKABLE, Unit.INSTANCE)
    ));
    public static final Item PRIXILED_IRON_AXE = registerItem(name = "prixiled_iron_axe", new AxeItem(ToolMaterial.IRON, 6, -3.1F, new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, name)))
            .component(DataComponentTypes.UNBREAKABLE, Unit.INSTANCE)
    ));
    public static final Item PRIXILED_IRON_HOE = registerItem(name = "prixiled_iron_hoe", new HoeItem(ToolMaterial.IRON, -2, -1, new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, name)))
            .component(DataComponentTypes.UNBREAKABLE, Unit.INSTANCE)
    ));
    public static final Item PRIXILED_IRON_SWORD = registerItem(name = "prixiled_iron_sword", new Item(new Item.Settings().sword(ToolMaterial.IRON, 3, -2.4F)
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, name)))
            .component(DataComponentTypes.UNBREAKABLE, Unit.INSTANCE)
    ));
    public static final Item PRIXILED_IRON_SPEAR = registerItem(name = "prixiled_iron_spear", new Item(new Item.Settings().spear(ToolMaterial.IRON, 0.95F, 0.95F, 0.6F, 2.5F, 8.0F, 6.75F, 5.1F, 11.25F, 4.6F)
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, name)))
            .component(DataComponentTypes.UNBREAKABLE, Unit.INSTANCE)
    ));
    //endregion

    //region [gold]
    public static final Item PRIXILED_GOLDEN_SHOVEL = registerItem(name = "prixiled_golden_shovel", new ShovelItem(ToolMaterial.GOLD, 1.5F, -3, new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, name)))
            .component(DataComponentTypes.UNBREAKABLE, Unit.INSTANCE)
    ));
    public static final Item PRIXILED_GOLDEN_PICKAXE = registerItem(name = "prixiled_golden_pickaxe", new Item(new Item.Settings().pickaxe(ToolMaterial.GOLD, 1, -2.8F)
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, name)))
            .component(DataComponentTypes.UNBREAKABLE, Unit.INSTANCE)
    ));
    public static final Item PRIXILED_GOLDEN_AXE = registerItem(name = "prixiled_golden_axe", new AxeItem(ToolMaterial.GOLD, 6, -3, new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, name)))
            .component(DataComponentTypes.UNBREAKABLE, Unit.INSTANCE)
    ));
    public static final Item PRIXILED_GOLDEN_HOE = registerItem(name = "prixiled_golden_hoe", new HoeItem(ToolMaterial.GOLD, 0, -3, new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, name)))
            .component(DataComponentTypes.UNBREAKABLE, Unit.INSTANCE)
    ));
    public static final Item PRIXILED_GOLDEN_SWORD = registerItem(name = "prixiled_golden_sword", new Item(new Item.Settings().sword(ToolMaterial.GOLD, 3, -2.4F)
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, name)))
            .component(DataComponentTypes.UNBREAKABLE, Unit.INSTANCE)
    ));
    public static final Item PRIXILED_GOLDEN_SPEAR = registerItem(name = "prixiled_golden_spear", new Item(new Item.Settings().spear(ToolMaterial.GOLD, 0.95F, 0.7F, 0.7F, 3.5F, 10.0F, 8.5F, 5.1F, 13.75F, 4.6F)
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, name)))
            .component(DataComponentTypes.UNBREAKABLE, Unit.INSTANCE)
    ));
    //endregion

    //region [diamond]
    public static final Item PRIXILED_DIAMOND_SHOVEL = registerItem(name = "prixiled_diamond_shovel", new ShovelItem(ToolMaterial.DIAMOND, 1.5F, -3, new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, name)))
            .component(DataComponentTypes.UNBREAKABLE, Unit.INSTANCE)
    ));
    public static final Item PRIXILED_DIAMOND_PICKAXE = registerItem(name = "prixiled_diamond_pickaxe", new Item(new Item.Settings().pickaxe(ToolMaterial.DIAMOND, 1, -2.8F)
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, name)))
            .component(DataComponentTypes.UNBREAKABLE, Unit.INSTANCE)
    ));
    public static final Item PRIXILED_DIAMOND_AXE = registerItem(name = "prixiled_diamond_axe", new AxeItem(ToolMaterial.DIAMOND, 5, -3, new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, name)))
            .component(DataComponentTypes.UNBREAKABLE, Unit.INSTANCE)
    ));
    public static final Item PRIXILED_DIAMOND_HOE = registerItem(name = "prixiled_diamond_hoe", new HoeItem(ToolMaterial.DIAMOND, -3, 0, new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, name)))
            .component(DataComponentTypes.UNBREAKABLE, Unit.INSTANCE)
    ));
    public static final Item PRIXILED_DIAMOND_SWORD = registerItem(name = "prixiled_diamond_sword", new Item(new Item.Settings().sword(ToolMaterial.DIAMOND, 3, -2.4F)
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, name)))
            .component(DataComponentTypes.UNBREAKABLE, Unit.INSTANCE)
    ));
    public static final Item PRIXILED_DIAMOND_SPEAR = registerItem(name = "prixiled_diamond_spear", new Item(new Item.Settings().spear(ToolMaterial.DIAMOND, 1.05F, 1.075F, 0.5F, 3.0F, 7.5F, 6.5F, 5.1F, 10.0F, 4.6F)
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, name)))
            .component(DataComponentTypes.UNBREAKABLE, Unit.INSTANCE)
    ));
    //endregion

    //region [netherite]
    public static final Item PRIXILED_NETHERITE_SHOVEL = registerItem(name = "prixiled_netherite_shovel", new ShovelItem(ToolMaterial.NETHERITE, 1.5F, -3, new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, name)))
            .component(DataComponentTypes.UNBREAKABLE, Unit.INSTANCE)
            .fireproof()
    ));
    public static final Item PRIXILED_NETHERITE_PICKAXE = registerItem(name = "prixiled_netherite_pickaxe", new Item(new Item.Settings().pickaxe(ToolMaterial.NETHERITE, 1, -2.8F)
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, name)))
            .component(DataComponentTypes.UNBREAKABLE, Unit.INSTANCE)
            .fireproof()
    ));
    public static final Item PRIXILED_NETHERITE_AXE = registerItem(name = "prixiled_netherite_axe", new AxeItem(ToolMaterial.NETHERITE, 5, -3, new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, name)))
            .component(DataComponentTypes.UNBREAKABLE, Unit.INSTANCE)
            .fireproof()
    ));
    public static final Item PRIXILED_NETHERITE_HOE = registerItem(name = "prixiled_netherite_hoe", new HoeItem(ToolMaterial.NETHERITE, -4, 0, new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, name)))
            .component(DataComponentTypes.UNBREAKABLE, Unit.INSTANCE)
            .fireproof()
    ));
    public static final Item PRIXILED_NETHERITE_SWORD = registerItem(name = "prixiled_netherite_sword", new Item(new Item.Settings().sword(ToolMaterial.NETHERITE, 3, -2.4F)
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, name)))
            .component(DataComponentTypes.UNBREAKABLE, Unit.INSTANCE)
            .fireproof()
    ));
    public static final Item PRIXILED_NETHERITE_SPEAR = registerItem(name = "prixiled_netherite_spear", new Item(new Item.Settings().spear(ToolMaterial.NETHERITE, 1.15F, 1.2F, 0.4F, 2.5F, 7.0F, 5.5F, 5.1F, 8.75F, 4.6F)
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, name)))
            .component(DataComponentTypes.UNBREAKABLE, Unit.INSTANCE)
            .fireproof()
    ));
    //endregion

    public static final Item PRIXILED_BOW = registerItem(name = "prixiled_bow", new BowItem(new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, name)))
            .maxCount(1)
            .maxDamage(384)
            .component(DataComponentTypes.UNBREAKABLE, Unit.INSTANCE)
    ));

    public static final Item PRIXILED_MACE = registerItem(name = "prixiled_mace", new MaceItem(new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, name)))
            .maxCount(1)
            .rarity(Rarity.EPIC)
            .attributeModifiers(MaceItem.createAttributeModifiers())
            .component(DataComponentTypes.UNBREAKABLE, Unit.INSTANCE)
    ));

    //endregion


    //region [Armors]

    //region [leather]
    public static final Item PRIXILED_LEATHER_HELMET = registerItem(name = "prixiled_leather_helmet", new Item(new Item.Settings().armor(ModArmorMaterials.PRIXILIUM_LEATHER, EquipmentType.HELMET)
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, name)))
            .maxCount(1)
            .component(DataComponentTypes.UNBREAKABLE, Unit.INSTANCE)
            .component(DataComponentTypes.DYED_COLOR, new DyedColorComponent(0xA06540))
    ));

    public static final Item PRIXILED_LEATHER_CHESTPLATE = registerItem(name = "prixiled_leather_chestplate", new Item(new Item.Settings().armor(ModArmorMaterials.PRIXILIUM_LEATHER, EquipmentType.CHESTPLATE)
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, name)))
            .maxCount(1)
            .component(DataComponentTypes.UNBREAKABLE, Unit.INSTANCE)
            .component(DataComponentTypes.DYED_COLOR, new DyedColorComponent(0xA06540))
    ));

    public static final Item PRIXILED_LEATHER_LEGGINGS = registerItem(name = "prixiled_leather_leggings", new Item(new Item.Settings().armor(ModArmorMaterials.PRIXILIUM_LEATHER, EquipmentType.LEGGINGS)
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, name)))
            .maxCount(1)
            .component(DataComponentTypes.UNBREAKABLE, Unit.INSTANCE)
            .component(DataComponentTypes.DYED_COLOR, new DyedColorComponent(0xA06540))
    ));

    public static final Item PRIXILED_LEATHER_BOOTS = registerItem(name = "prixiled_leather_boots", new Item(new Item.Settings().armor(ModArmorMaterials.PRIXILIUM_LEATHER, EquipmentType.BOOTS)
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, name)))
            .maxCount(1)
            .component(DataComponentTypes.UNBREAKABLE, Unit.INSTANCE)
            .component(DataComponentTypes.DYED_COLOR, new DyedColorComponent(0xA06540))
    ));
    //endregion

    //region [chainmail]
    public static final Item PRIXILED_CHAINMAIL_HELMET = registerItem(name = "prixiled_chainmail_helmet", new Item(new Item.Settings().armor(ModArmorMaterials.PRIXILIUM_CHAIN, EquipmentType.HELMET)
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, name)))
            .maxCount(1)
            .component(DataComponentTypes.UNBREAKABLE, Unit.INSTANCE)
    ));

    public static final Item PRIXILED_CHAINMAIL_CHESTPLATE = registerItem(name = "prixiled_chainmail_chestplate", new Item(new Item.Settings().armor(ModArmorMaterials.PRIXILIUM_CHAIN, EquipmentType.CHESTPLATE)
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, name)))
            .maxCount(1)
            .component(DataComponentTypes.UNBREAKABLE, Unit.INSTANCE)
    ));

    public static final Item PRIXILED_CHAINMAIL_LEGGINGS = registerItem(name = "prixiled_chainmail_leggings", new Item(new Item.Settings().armor(ModArmorMaterials.PRIXILIUM_CHAIN, EquipmentType.LEGGINGS)
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, name)))
            .maxCount(1)
            .component(DataComponentTypes.UNBREAKABLE, Unit.INSTANCE)
    ));

    public static final Item PRIXILED_CHAINMAIL_BOOTS = registerItem(name = "prixiled_chainmail_boots", new Item(new Item.Settings().armor(ModArmorMaterials.PRIXILIUM_CHAIN, EquipmentType.BOOTS)
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, name)))
            .maxCount(1)
            .component(DataComponentTypes.UNBREAKABLE, Unit.INSTANCE)
    ));
    //endregion

    //region [copper]
    public static final Item PRIXILED_COPPER_HELMET = registerItem(name = "prixiled_copper_helmet", new Item(new Item.Settings().armor(ModArmorMaterials.PRIXILIUM_COPPER, EquipmentType.HELMET)
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, name)))
            .maxCount(1)
            .component(DataComponentTypes.UNBREAKABLE, Unit.INSTANCE)
    ));

    public static final Item PRIXILED_COPPER_CHESTPLATE = registerItem(name = "prixiled_copper_chestplate", new Item(new Item.Settings().armor(ModArmorMaterials.PRIXILIUM_COPPER, EquipmentType.CHESTPLATE)
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, name)))
            .maxCount(1)
            .component(DataComponentTypes.UNBREAKABLE, Unit.INSTANCE)
    ));

    public static final Item PRIXILED_COPPER_LEGGINGS = registerItem(name = "prixiled_copper_leggings", new Item(new Item.Settings().armor(ModArmorMaterials.PRIXILIUM_COPPER, EquipmentType.LEGGINGS)
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, name)))
            .maxCount(1)
            .component(DataComponentTypes.UNBREAKABLE, Unit.INSTANCE)
    ));

    public static final Item PRIXILED_COPPER_BOOTS = registerItem(name = "prixiled_copper_boots", new Item(new Item.Settings().armor(ModArmorMaterials.PRIXILIUM_COPPER, EquipmentType.BOOTS)
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, name)))
            .maxCount(1)
            .component(DataComponentTypes.UNBREAKABLE, Unit.INSTANCE)
    ));
    //endregion

    //region [iron]
    public static final Item PRIXILED_IRON_HELMET = registerItem(name = "prixiled_iron_helmet", new Item(new Item.Settings().armor(ModArmorMaterials.PRIXILIUM_IRON, EquipmentType.HELMET)
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, name)))
            .maxCount(1)
            .component(DataComponentTypes.UNBREAKABLE, Unit.INSTANCE)
    ));

    public static final Item PRIXILED_IRON_CHESTPLATE = registerItem(name = "prixiled_iron_chestplate", new Item(new Item.Settings().armor(ModArmorMaterials.PRIXILIUM_IRON, EquipmentType.CHESTPLATE)
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, name)))
            .maxCount(1)
            .component(DataComponentTypes.UNBREAKABLE, Unit.INSTANCE)
    ));

    public static final Item PRIXILED_IRON_LEGGINGS = registerItem(name = "prixiled_iron_leggings", new Item(new Item.Settings().armor(ModArmorMaterials.PRIXILIUM_IRON, EquipmentType.LEGGINGS)
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, name)))
            .maxCount(1)
            .component(DataComponentTypes.UNBREAKABLE, Unit.INSTANCE)
    ));

    public static final Item PRIXILED_IRON_BOOTS = registerItem(name = "prixiled_iron_boots", new Item(new Item.Settings().armor(ModArmorMaterials.PRIXILIUM_IRON, EquipmentType.BOOTS)
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, name)))
            .maxCount(1)
            .component(DataComponentTypes.UNBREAKABLE, Unit.INSTANCE)
    ));
    //endregion

    //region [gold]
    public static final Item PRIXILED_GOLDEN_HELMET = registerItem(name = "prixiled_golden_helmet", new Item(new Item.Settings().armor(ModArmorMaterials.PRIXILIUM_GOLD, EquipmentType.HELMET)
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, name)))
            .maxCount(1)
            .component(DataComponentTypes.UNBREAKABLE, Unit.INSTANCE)
    ));

    public static final Item PRIXILED_GOLDEN_CHESTPLATE = registerItem(name = "prixiled_golden_chestplate", new Item(new Item.Settings().armor(ModArmorMaterials.PRIXILIUM_GOLD, EquipmentType.CHESTPLATE)
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, name)))
            .maxCount(1)
            .component(DataComponentTypes.UNBREAKABLE, Unit.INSTANCE)
    ));

    public static final Item PRIXILED_GOLDEN_LEGGINGS = registerItem(name = "prixiled_golden_leggings", new Item(new Item.Settings().armor(ModArmorMaterials.PRIXILIUM_GOLD, EquipmentType.LEGGINGS)
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, name)))
            .maxCount(1)
            .component(DataComponentTypes.UNBREAKABLE, Unit.INSTANCE)
    ));

    public static final Item PRIXILED_GOLDEN_BOOTS = registerItem(name = "prixiled_golden_boots", new Item(new Item.Settings().armor(ModArmorMaterials.PRIXILIUM_GOLD, EquipmentType.BOOTS)
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, name)))
            .maxCount(1)
            .component(DataComponentTypes.UNBREAKABLE, Unit.INSTANCE)
    ));
    //endregion

    //region [diamond]
    public static final Item PRIXILED_DIAMOND_HELMET = registerItem(name = "prixiled_diamond_helmet", new Item(new Item.Settings().armor(ModArmorMaterials.PRIXILIUM_DIAMOND, EquipmentType.HELMET)
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, name)))
            .maxCount(1)
            .component(DataComponentTypes.UNBREAKABLE, Unit.INSTANCE)
    ));

    public static final Item PRIXILED_DIAMOND_CHESTPLATE = registerItem(name = "prixiled_diamond_chestplate", new Item(new Item.Settings().armor(ModArmorMaterials.PRIXILIUM_DIAMOND, EquipmentType.CHESTPLATE)
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, name)))
            .maxCount(1)
            .component(DataComponentTypes.UNBREAKABLE, Unit.INSTANCE)
    ));

    public static final Item PRIXILED_DIAMOND_LEGGINGS = registerItem(name = "prixiled_diamond_leggings", new Item(new Item.Settings().armor(ModArmorMaterials.PRIXILIUM_DIAMOND, EquipmentType.LEGGINGS)
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, name)))
            .maxCount(1)
            .component(DataComponentTypes.UNBREAKABLE, Unit.INSTANCE)
    ));

    public static final Item PRIXILED_DIAMOND_BOOTS = registerItem(name = "prixiled_diamond_boots", new Item(new Item.Settings().armor(ModArmorMaterials.PRIXILIUM_DIAMOND, EquipmentType.BOOTS)
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, name)))
            .maxCount(1)
            .component(DataComponentTypes.UNBREAKABLE, Unit.INSTANCE)
    ));
    //endregion

    //region [netherite]
    public static final Item PRIXILED_NETHERITE_HELMET = registerItem(name = "prixiled_netherite_helmet", new Item(new Item.Settings().armor(ModArmorMaterials.PRIXILIUM_NETHERITE, EquipmentType.HELMET)
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, name)))
            .maxCount(1)
            .component(DataComponentTypes.UNBREAKABLE, Unit.INSTANCE)
            .fireproof()
    ));

    public static final Item PRIXILED_NETHERITE_CHESTPLATE = registerItem(name = "prixiled_netherite_chestplate", new Item(new Item.Settings().armor(ModArmorMaterials.PRIXILIUM_NETHERITE, EquipmentType.CHESTPLATE)
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, name)))
            .maxCount(1)
            .component(DataComponentTypes.UNBREAKABLE, Unit.INSTANCE)
            .fireproof()
    ));

    public static final Item PRIXILED_NETHERITE_LEGGINGS = registerItem(name = "prixiled_netherite_leggings", new Item(new Item.Settings().armor(ModArmorMaterials.PRIXILIUM_NETHERITE, EquipmentType.LEGGINGS)
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, name)))
            .maxCount(1)
            .component(DataComponentTypes.UNBREAKABLE, Unit.INSTANCE)
            .fireproof()
    ));

    public static final Item PRIXILED_NETHERITE_BOOTS = registerItem(name = "prixiled_netherite_boots", new Item(new Item.Settings().armor(ModArmorMaterials.PRIXILIUM_NETHERITE, EquipmentType.BOOTS)
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, name)))
            .maxCount(1)
            .component(DataComponentTypes.UNBREAKABLE, Unit.INSTANCE)
            .fireproof()
    ));
    //endregion

    //region [turtle]
    public static final Item PRIXILED_TURTLE_HELMET = registerItem(name = "prixiled_turtle_helmet", new Item(new Item.Settings().armor(ModArmorMaterials.PRIXILIUM_TURTLE, EquipmentType.HELMET)
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, name)))
            .maxCount(1)
            .component(DataComponentTypes.UNBREAKABLE, Unit.INSTANCE)
    ));
    //endregion

    //region [horse]
    public static final Item PRIXILED_LEATHER_HORSE_ARMOR = registerItem(name = "prixiled_leather_horse_armor", new Item(new Item.Settings().horseArmor(ModArmorMaterials.PRIXILIUM_LEATHER)
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, name)))
            .maxCount(1)
            .component(DataComponentTypes.UNBREAKABLE, Unit.INSTANCE)
            .component(DataComponentTypes.DYED_COLOR, new DyedColorComponent(0xA06540))
    ));
    public static final Item PRIXILED_COPPER_HORSE_ARMOR = registerItem(name = "prixiled_copper_horse_armor", new Item(new Item.Settings().horseArmor(ModArmorMaterials.PRIXILIUM_COPPER)
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, name)))
            .maxCount(1)
            .component(DataComponentTypes.UNBREAKABLE, Unit.INSTANCE)
            ));
    public static final Item PRIXILED_IRON_HORSE_ARMOR = registerItem(name = "prixiled_iron_horse_armor", new Item(new Item.Settings().horseArmor(ModArmorMaterials.PRIXILIUM_IRON)
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, name)))
            .maxCount(1)
            .component(DataComponentTypes.UNBREAKABLE, Unit.INSTANCE)
    ));
    public static final Item PRIXILED_GOLDEN_HORSE_ARMOR = registerItem(name = "prixiled_golden_horse_armor", new Item(new Item.Settings().horseArmor(ModArmorMaterials.PRIXILIUM_GOLD)
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, name)))
            .maxCount(1)
            .component(DataComponentTypes.UNBREAKABLE, Unit.INSTANCE)
    ));
    public static final Item PRIXILED_DIAMOND_HORSE_ARMOR = registerItem(name = "prixiled_diamond_horse_armor", new Item(new Item.Settings().horseArmor(ModArmorMaterials.PRIXILIUM_DIAMOND)
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, name)))
            .maxCount(1)
            .component(DataComponentTypes.UNBREAKABLE, Unit.INSTANCE)
    ));
    public static final Item PRIXILED_NETHERITE_HORSE_ARMOR = registerItem(name = "prixiled_netherite_horse_armor", new Item(new Item.Settings().horseArmor(ModArmorMaterials.PRIXILIUM_NETHERITE)
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, name)))
            .maxCount(1)
            .component(DataComponentTypes.UNBREAKABLE, Unit.INSTANCE)
    ));
    //endregion


    //endregion

    //region [Food]
    private static ConsumableComponent addPrixiliumImmunity(ConsumableComponent base) {
        return new ConsumableComponent(base.consumeSeconds(), base.useAction(), base.sound(), base.hasConsumeParticles(),
                Stream.concat(base.onConsumeEffects().stream(),
                        Stream.of(new ApplyEffectsConsumeEffect(new StatusEffectInstance(ModEffects.PRIXILIUM_IMMUNITY, 200, 0), 1.0F))
                ).toList()
        );
    }

    public static final Item PRIXILIUM_OIL = registerItem(name = "prixilium_oil", new Item(new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, name)))
            .food(FoodComponents.SPIDER_EYE, addPrixiliumImmunity(ConsumableComponents.SPIDER_EYE))
    ));

    public static final Item PRIXILED_APPLE = registerItem(name = "prixiled_apple", new Item(new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, name)))
            .food(FoodComponents.APPLE, addPrixiliumImmunity(ConsumableComponents.FOOD))
    ));

    public static final Item PRIXILED_GOLDEN_APPLE = registerItem(name = "prixiled_golden_apple", new Item(new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, name)))
            .food(FoodComponents.GOLDEN_APPLE, addPrixiliumImmunity(ConsumableComponents.GOLDEN_APPLE))
    ));

    public static final Item PRIXILED_ENCHANTED_GOLDEN_APPLE = registerItem(name = "prixiled_enchanted_golden_apple", new Item(new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, name)))
            .food(FoodComponents.ENCHANTED_GOLDEN_APPLE, addPrixiliumImmunity(ConsumableComponents.ENCHANTED_GOLDEN_APPLE))
    ));

    public static final Item PRIXILED_MELON_SLICE = registerItem(name = "prixiled_melon_slice", new Item(new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, name)))
            .food(FoodComponents.MELON_SLICE, addPrixiliumImmunity(ConsumableComponents.FOOD))
    ));

    public static final Item PRIXILED_SWEET_BERRIES = registerItem(name = "prixiled_sweet_berries", new Item(new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, name)))
            .food(FoodComponents.SWEET_BERRIES, addPrixiliumImmunity(ConsumableComponents.FOOD))
    ));

    public static final Item PRIXILED_GLOW_BERRIES = registerItem(name = "prixiled_glow_berries", new Item(new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, name)))
            .food(FoodComponents.GLOW_BERRIES, addPrixiliumImmunity(ConsumableComponents.FOOD))
    ));

    public static final Item PRIXILED_CHORUS_FRUIT = registerItem(name = "prixiled_chorus_fruit", new Item(new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, name)))
            .food(FoodComponents.CHORUS_FRUIT, addPrixiliumImmunity(ConsumableComponents.CHORUS_FRUIT))
    ));

    public static final Item PRIXILED_CARROT = registerItem(name = "prixiled_carrot", new Item(new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, name)))
            .food(FoodComponents.CARROT, addPrixiliumImmunity(ConsumableComponents.FOOD))
    ));

    public static final Item PRIXILED_GOLDEN_CARROT = registerItem(name = "prixiled_golden_carrot", new Item(new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, name)))
            .food(FoodComponents.GOLDEN_CARROT, addPrixiliumImmunity(ConsumableComponents.FOOD))
    ));

    public static final Item PRIXILED_POTATO = registerItem(name = "prixiled_potato", new Item(new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, name)))
            .food(FoodComponents.POTATO, addPrixiliumImmunity(ConsumableComponents.FOOD))
    ));

    public static final Item PRIXILED_BAKED_POTATO = registerItem(name = "prixiled_baked_potato", new Item(new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, name)))
            .food(FoodComponents.BAKED_POTATO, addPrixiliumImmunity(ConsumableComponents.FOOD))
    ));

    public static final Item PRIXILED_POISONOUS_POTATO = registerItem(name = "prixiled_poisonous_potato", new Item(new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, name)))
            .food(FoodComponents.POISONOUS_POTATO, addPrixiliumImmunity(ConsumableComponents.POISONOUS_POTATO))
    ));

    public static final Item PRIXILED_BEETROOT = registerItem(name = "prixiled_beetroot", new Item(new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, name)))
            .food(FoodComponents.BEETROOT, addPrixiliumImmunity(ConsumableComponents.FOOD))
    ));

    public static final Item PRIXILED_DRIED_KELP = registerItem(name = "prixiled_dried_kelp", new Item(new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, name)))
            .food(FoodComponents.DRIED_KELP, addPrixiliumImmunity(ConsumableComponents.DRIED_KELP))
    ));

    public static final Item PRIXILED_BEEF = registerItem(name = "prixiled_beef", new Item(new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, name)))
            .food(FoodComponents.BEEF, addPrixiliumImmunity(ConsumableComponents.FOOD))
    ));

    public static final Item PRIXILED_COOKED_BEEF = registerItem(name = "prixiled_cooked_beef", new Item(new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, name)))
            .food(FoodComponents.COOKED_BEEF, addPrixiliumImmunity(ConsumableComponents.FOOD))
    ));

    public static final Item PRIXILED_PORKCHOP = registerItem(name = "prixiled_porkchop", new Item(new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, name)))
            .food(FoodComponents.PORKCHOP, addPrixiliumImmunity(ConsumableComponents.FOOD))
    ));

    public static final Item PRIXILED_COOKED_PORKCHOP = registerItem(name = "prixiled_cooked_porkchop", new Item(new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, name)))
            .food(FoodComponents.COOKED_PORKCHOP, addPrixiliumImmunity(ConsumableComponents.FOOD))
    ));

    public static final Item PRIXILED_MUTTON = registerItem(name = "prixiled_mutton", new Item(new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, name)))
            .food(FoodComponents.MUTTON, addPrixiliumImmunity(ConsumableComponents.FOOD))
    ));

    public static final Item PRIXILED_COOKED_MUTTON = registerItem(name = "prixiled_cooked_mutton", new Item(new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, name)))
            .food(FoodComponents.COOKED_MUTTON, addPrixiliumImmunity(ConsumableComponents.FOOD))
    ));

    public static final Item PRIXILED_CHICKEN = registerItem(name = "prixiled_chicken", new Item(new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, name)))
            .food(FoodComponents.CHICKEN, addPrixiliumImmunity(ConsumableComponents.RAW_CHICKEN))
    ));

    public static final Item PRIXILED_COOKED_CHICKEN = registerItem(name = "prixiled_cooked_chicken", new Item(new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, name)))
            .food(FoodComponents.COOKED_CHICKEN, addPrixiliumImmunity(ConsumableComponents.FOOD))
    ));

    public static final Item PRIXILED_RABBIT = registerItem(name = "prixiled_rabbit", new Item(new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, name)))
            .food(FoodComponents.RABBIT, addPrixiliumImmunity(ConsumableComponents.FOOD))
    ));

    public static final Item PRIXILED_COOKED_RABBIT = registerItem(name = "prixiled_cooked_rabbit", new Item(new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, name)))
            .food(FoodComponents.COOKED_RABBIT, addPrixiliumImmunity(ConsumableComponents.FOOD))
    ));

    public static final Item PRIXILED_COD = registerItem(name = "prixiled_cod", new Item(new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, name)))
            .food(FoodComponents.COD, addPrixiliumImmunity(ConsumableComponents.FOOD))
    ));

    public static final Item PRIXILED_COOKED_COD = registerItem(name = "prixiled_cooked_cod", new Item(new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, name)))
            .food(FoodComponents.COOKED_COD, addPrixiliumImmunity(ConsumableComponents.FOOD))
    ));

    public static final Item PRIXILED_SALMON = registerItem(name = "prixiled_salmon", new Item(new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, name)))
            .food(FoodComponents.SALMON, addPrixiliumImmunity(ConsumableComponents.FOOD))
    ));

    public static final Item PRIXILED_COOKED_SALMON = registerItem(name = "prixiled_cooked_salmon", new Item(new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, name)))
            .food(FoodComponents.COOKED_SALMON, addPrixiliumImmunity(ConsumableComponents.FOOD))
    ));

    public static final Item PRIXILED_TROPICAL_FISH = registerItem(name = "prixiled_tropical_fish", new Item(new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, name)))
            .food(FoodComponents.TROPICAL_FISH, addPrixiliumImmunity(ConsumableComponents.FOOD))
    ));

    public static final Item PRIXILED_PUFFERFISH = registerItem(name = "prixiled_pufferfish", new Item(new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, name)))
            .food(FoodComponents.PUFFERFISH, addPrixiliumImmunity(ConsumableComponents.PUFFERFISH))
    ));

    public static final Item PRIXILED_BREAD = registerItem(name = "prixiled_bread", new Item(new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, name)))
            .food(FoodComponents.BREAD, addPrixiliumImmunity(ConsumableComponents.FOOD))
    ));

    public static final Item PRIXILED_COOKIE = registerItem(name = "prixiled_cookie", new Item(new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, name)))
            .food(FoodComponents.COOKIE, addPrixiliumImmunity(ConsumableComponents.FOOD))
    ));

    public static final Item PRIXILED_PUMPKIN_PIE = registerItem(name = "prixiled_pumpkin_pie", new Item(new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, name)))
            .food(FoodComponents.PUMPKIN_PIE, addPrixiliumImmunity(ConsumableComponents.FOOD))
    ));

    public static final Item PRIXILED_ROTTEN_FLESH = registerItem(name = "prixiled_rotten_flesh", new Item(new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, name)))
            .food(FoodComponents.ROTTEN_FLESH, addPrixiliumImmunity(ConsumableComponents.ROTTEN_FLESH))
    ));

    public static final Item PRIXILED_SPIDER_EYE = registerItem(name = "prixiled_spider_eye", new Item(new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, name)))
            .food(FoodComponents.SPIDER_EYE, addPrixiliumImmunity(ConsumableComponents.SPIDER_EYE))
    ));

    public static final Item PRIXILED_MUSHROOM_STEW = registerItem(name = "prixiled_mushroom_stew", new Item(new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, name)))
            .food(FoodComponents.MUSHROOM_STEW, addPrixiliumImmunity(ConsumableComponents.FOOD))
    ));

    public static final Item PRIXILED_BEETROOT_SOUP = registerItem(name = "prixiled_beetroot_soup", new Item(new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, name)))
            .food(FoodComponents.BEETROOT_SOUP, addPrixiliumImmunity(ConsumableComponents.FOOD))
    ));

    public static final Item PRIXILED_RABBIT_STEW = registerItem(name = "prixiled_rabbit_stew", new Item(new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, name)))
            .food(FoodComponents.RABBIT_STEW, addPrixiliumImmunity(ConsumableComponents.FOOD))
    ));

    public static final Item PRIXILED_HONEY_BOTTLE = registerItem(name = "prixiled_honey_bottle", new Item(new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, name)))
            .food(FoodComponents.HONEY_BOTTLE, addPrixiliumImmunity(ConsumableComponents.HONEY_BOTTLE))
    ));

    //endregion

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(Prixilium.MOD_ID, name), item);
    }

    public static void registerItems() {Prixilium.LOGGER.info("Registering Prixilium Items.");}
}
