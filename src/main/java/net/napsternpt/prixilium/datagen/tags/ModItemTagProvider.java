package net.napsternpt.prixilium.datagen.tags;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.Blocks;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;
import net.napsternpt.prixilium.block.ModBlocks;
import net.napsternpt.prixilium.item.ModItems;
import net.napsternpt.prixilium.util.ModTags;
import org.jspecify.annotations.NonNull;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.@NonNull WrapperLookup wrapperLookup) {
        //region [Item]

        //region [Tools/Weapons]
        valueLookupBuilder(ItemTags.SHOVELS)
                .add(ModItems.PRIXILED_WOODEN_SHOVEL)
                .add(ModItems.PRIXILED_STONE_SHOVEL)
                .add(ModItems.PRIXILED_COPPER_SHOVEL)
                .add(ModItems.PRIXILED_IRON_SHOVEL)
                .add(ModItems.PRIXILED_GOLDEN_SHOVEL)
                .add(ModItems.PRIXILED_DIAMOND_SHOVEL)
                .add(ModItems.PRIXILED_NETHERITE_SHOVEL);

        valueLookupBuilder(ItemTags.PICKAXES)
                .add(ModItems.PRIXILED_WOODEN_PICKAXE)
                .add(ModItems.PRIXILED_STONE_PICKAXE)
                .add(ModItems.PRIXILED_COPPER_PICKAXE)
                .add(ModItems.PRIXILED_IRON_PICKAXE)
                .add(ModItems.PRIXILED_GOLDEN_PICKAXE)
                .add(ModItems.PRIXILED_DIAMOND_PICKAXE)
                .add(ModItems.PRIXILED_NETHERITE_PICKAXE);

        valueLookupBuilder(ItemTags.AXES)
                .add(ModItems.PRIXILED_WOODEN_AXE)
                .add(ModItems.PRIXILED_STONE_AXE)
                .add(ModItems.PRIXILED_COPPER_AXE)
                .add(ModItems.PRIXILED_IRON_AXE)
                .add(ModItems.PRIXILED_GOLDEN_AXE)
                .add(ModItems.PRIXILED_DIAMOND_AXE)
                .add(ModItems.PRIXILED_NETHERITE_AXE);

        valueLookupBuilder(ItemTags.HOES)
                .add(ModItems.PRIXILED_WOODEN_HOE)
                .add(ModItems.PRIXILED_STONE_HOE)
                .add(ModItems.PRIXILED_COPPER_HOE)
                .add(ModItems.PRIXILED_IRON_HOE)
                .add(ModItems.PRIXILED_GOLDEN_HOE)
                .add(ModItems.PRIXILED_DIAMOND_HOE)
                .add(ModItems.PRIXILED_NETHERITE_HOE);

        valueLookupBuilder(ItemTags.SWORDS)
                .add(ModItems.PRIXILED_WOODEN_SWORD)
                .add(ModItems.PRIXILED_STONE_SWORD)
                .add(ModItems.PRIXILED_COPPER_SWORD)
                .add(ModItems.PRIXILED_IRON_SWORD)
                .add(ModItems.PRIXILED_GOLDEN_SWORD)
                .add(ModItems.PRIXILED_DIAMOND_SWORD)
                .add(ModItems.PRIXILED_NETHERITE_SWORD);

        valueLookupBuilder(ItemTags.SPEARS)
                .add(ModItems.PRIXILED_WOODEN_SPEAR)
                .add(ModItems.PRIXILED_STONE_SPEAR)
                .add(ModItems.PRIXILED_COPPER_SPEAR)
                .add(ModItems.PRIXILED_IRON_SPEAR)
                .add(ModItems.PRIXILED_GOLDEN_SPEAR)
                .add(ModItems.PRIXILED_DIAMOND_SPEAR)
                .add(ModItems.PRIXILED_NETHERITE_SPEAR);

        valueLookupBuilder(ItemTags.BOW_ENCHANTABLE)
                .add(ModItems.PRIXILED_BOW);

        valueLookupBuilder(ItemTags.MACE_ENCHANTABLE)
                .add(ModItems.PRIXILED_MACE);

        //endregion

        //region [Armor]

        valueLookupBuilder(ItemTags.TRIMMABLE_ARMOR)
                .add(ModItems.PRIXILED_LEATHER_HELMET)
                .add(ModItems.PRIXILED_LEATHER_CHESTPLATE)
                .add(ModItems.PRIXILED_LEATHER_LEGGINGS)
                .add(ModItems.PRIXILED_LEATHER_BOOTS)
                .add(ModItems.PRIXILED_CHAINMAIL_HELMET)
                .add(ModItems.PRIXILED_CHAINMAIL_CHESTPLATE)
                .add(ModItems.PRIXILED_CHAINMAIL_LEGGINGS)
                .add(ModItems.PRIXILED_CHAINMAIL_BOOTS)
                .add(ModItems.PRIXILED_COPPER_HELMET)
                .add(ModItems.PRIXILED_COPPER_CHESTPLATE)
                .add(ModItems.PRIXILED_COPPER_LEGGINGS)
                .add(ModItems.PRIXILED_COPPER_BOOTS)
                .add(ModItems.PRIXILED_IRON_HELMET)
                .add(ModItems.PRIXILED_IRON_CHESTPLATE)
                .add(ModItems.PRIXILED_IRON_LEGGINGS)
                .add(ModItems.PRIXILED_IRON_BOOTS)
                .add(ModItems.PRIXILED_GOLDEN_HELMET)
                .add(ModItems.PRIXILED_GOLDEN_CHESTPLATE)
                .add(ModItems.PRIXILED_GOLDEN_LEGGINGS)
                .add(ModItems.PRIXILED_GOLDEN_BOOTS)
                .add(ModItems.PRIXILED_DIAMOND_HELMET)
                .add(ModItems.PRIXILED_DIAMOND_CHESTPLATE)
                .add(ModItems.PRIXILED_DIAMOND_LEGGINGS)
                .add(ModItems.PRIXILED_DIAMOND_BOOTS)
                .add(ModItems.PRIXILED_NETHERITE_HELMET)
                .add(ModItems.PRIXILED_NETHERITE_CHESTPLATE)
                .add(ModItems.PRIXILED_NETHERITE_LEGGINGS)
                .add(ModItems.PRIXILED_NETHERITE_BOOTS)
                .add(ModItems.PRIXILED_TURTLE_HELMET);

        valueLookupBuilder(ItemTags.DYEABLE)
                .add(ModItems.PRIXILED_LEATHER_HELMET)
                .add(ModItems.PRIXILED_LEATHER_CHESTPLATE)
                .add(ModItems.PRIXILED_LEATHER_LEGGINGS)
                .add(ModItems.PRIXILED_LEATHER_BOOTS)
                .add(ModItems.PRIXILED_LEATHER_HORSE_ARMOR);

        //endregion

        //region [Food]
        valueLookupBuilder(ItemTags.MEAT)
                .add(ModItems.PRIXILED_BEEF)
                .add(ModItems.PRIXILED_COOKED_BEEF)
                .add(ModItems.PRIXILED_PORKCHOP)
                .add(ModItems.PRIXILED_COOKED_PORKCHOP)
                .add(ModItems.PRIXILED_MUTTON)
                .add(ModItems.PRIXILED_COOKED_MUTTON)
                .add(ModItems.PRIXILED_CHICKEN)
                .add(ModItems.PRIXILED_COOKED_CHICKEN)
                .add(ModItems.PRIXILED_RABBIT)
                .add(ModItems.PRIXILED_COOKED_RABBIT)
                .add(ModItems.PRIXILED_ROTTEN_FLESH);

        valueLookupBuilder(ItemTags.FISHES)
                .add(ModItems.PRIXILED_COD)
                .add(ModItems.PRIXILED_COOKED_COD)
                .add(ModItems.PRIXILED_SALMON)
                .add(ModItems.PRIXILED_COOKED_SALMON)
                .add(ModItems.PRIXILED_TROPICAL_FISH)
                .add(ModItems.PRIXILED_PUFFERFISH);

        valueLookupBuilder(ItemTags.ARMADILLO_FOOD)
                .add(ModItems.PRIXILED_SPIDER_EYE);

        valueLookupBuilder(ItemTags.CAT_FOOD)
                .add(ModItems.PRIXILED_COD)
                .add(ModItems.PRIXILED_SALMON);

        valueLookupBuilder(ItemTags.FOX_FOOD)
                .add(ModItems.PRIXILED_SWEET_BERRIES)
                .add(ModItems.PRIXILED_GLOW_BERRIES);

        valueLookupBuilder(ItemTags.HORSE_FOOD)
                .add(ModItems.PRIXILED_APPLE)
                .add(ModItems.PRIXILED_GOLDEN_APPLE)
                .add(ModItems.PRIXILED_ENCHANTED_GOLDEN_APPLE)
                .add(ModItems.PRIXILED_CARROT)
                .add(ModItems.PRIXILED_GOLDEN_CARROT);

        valueLookupBuilder(ItemTags.HORSE_TEMPT_ITEMS)
                .add(ModItems.PRIXILED_GOLDEN_APPLE)
                .add(ModItems.PRIXILED_ENCHANTED_GOLDEN_APPLE)
                .add(ModItems.PRIXILED_GOLDEN_CARROT);

        valueLookupBuilder(ItemTags.NAUTILUS_TAMING_ITEMS)
                .add(ModItems.PRIXILED_PUFFERFISH);

        valueLookupBuilder(ItemTags.OCELOT_FOOD)
                .add(ModItems.PRIXILED_COD)
                .add(ModItems.PRIXILED_SALMON);

        valueLookupBuilder(ItemTags.PARROT_POISONOUS_FOOD)
                .add(ModItems.PRIXILED_COOKIE);

        valueLookupBuilder(ItemTags.PIG_FOOD)
                .add(ModItems.PRIXILED_CARROT)
                .add(ModItems.PRIXILED_POTATO)
                .add(ModItems.PRIXILED_BEETROOT);

        valueLookupBuilder(ItemTags.PIGLIN_FOOD)
                .add(ModItems.PRIXILED_PORKCHOP)
                .add(ModItems.PRIXILED_COOKED_PORKCHOP);

        valueLookupBuilder(ItemTags.PIGLIN_LOVED)
                .add(ModItems.PRIXILED_GOLDEN_APPLE)
                .add(ModItems.PRIXILED_ENCHANTED_GOLDEN_APPLE)
                .add(ModItems.PRIXILED_GOLDEN_CARROT);

        valueLookupBuilder(ItemTags.RABBIT_FOOD)
                .add(ModItems.PRIXILED_CARROT)
                .add(ModItems.PRIXILED_GOLDEN_CARROT);

        valueLookupBuilder(ItemTags.VILLAGER_PICKS_UP)
                .add(ModItems.PRIXILED_CARROT)
                .add(ModItems.PRIXILED_POTATO)
                .add(ModItems.PRIXILED_BEETROOT)
                .add(ModItems.PRIXILED_BREAD);

        valueLookupBuilder(ItemTags.WOLF_FOOD)
                .add(ModItems.PRIXILED_COD)
                .add(ModItems.PRIXILED_COOKED_COD)
                .add(ModItems.PRIXILED_SALMON)
                .add(ModItems.PRIXILED_TROPICAL_FISH)
                .add(ModItems.PRIXILED_PUFFERFISH)
                .add(ModItems.PRIXILED_RABBIT_STEW);

        //endregion

        //endregion

        //region [Blocks]
        valueLookupBuilder(ItemTags.LEAVES)
                .add(ModBlocks.PRIXILIUM_LEAVES.asItem());

        valueLookupBuilder(ItemTags.LOGS)
                .add(ModBlocks.PRIXILIUM_LOG.asItem())
                .add(ModBlocks.PRIXILIUM_WOOD.asItem())
                .add(ModBlocks.BURNED_PRIXILIUM_LOG.asItem())
                .add(ModBlocks.BURNED_PRIXILIUM_WOOD.asItem());

        valueLookupBuilder(ItemTags.PLANKS)
                .add(ModBlocks.PRIXILIUM_PLANKS.asItem())
                .add(ModBlocks.BURNED_PRIXILIUM_PLANKS.asItem());

        // Mod Tags
        valueLookupBuilder(ModTags.Items.TEMPERATURE_TOOLS)
                .add(ModItems.THERMOMETER);

        valueLookupBuilder(ModTags.Items.REPAIRS_RIFT_ARMOR)
                .add(ModItems.RIFTS_SHELL);

        valueLookupBuilder(ModTags.Items.PRIXILED_FOOD)
                .add(ModItems.PRIXILIUM_OIL)
                .add(ModItems.PRIXILED_APPLE)
                .add(ModItems.PRIXILED_GOLDEN_APPLE)
                .add(ModItems.PRIXILED_ENCHANTED_GOLDEN_APPLE)
                .add(ModItems.PRIXILED_MELON_SLICE)
                .add(ModItems.PRIXILED_SWEET_BERRIES)
                .add(ModItems.PRIXILED_GLOW_BERRIES)
                .add(ModItems.PRIXILED_CHORUS_FRUIT)
                .add(ModItems.PRIXILED_CARROT)
                .add(ModItems.PRIXILED_GOLDEN_CARROT)
                .add(ModItems.PRIXILED_POTATO)
                .add(ModItems.PRIXILED_BAKED_POTATO)
                .add(ModItems.PRIXILED_POISONOUS_POTATO)
                .add(ModItems.PRIXILED_BEETROOT)
                .add(ModItems.PRIXILED_DRIED_KELP)
                .add(ModItems.PRIXILED_BEEF)
                .add(ModItems.PRIXILED_COOKED_BEEF)
                .add(ModItems.PRIXILED_PORKCHOP)
                .add(ModItems.PRIXILED_COOKED_PORKCHOP)
                .add(ModItems.PRIXILED_MUTTON)
                .add(ModItems.PRIXILED_COOKED_MUTTON)
                .add(ModItems.PRIXILED_CHICKEN)
                .add(ModItems.PRIXILED_COOKED_CHICKEN)
                .add(ModItems.PRIXILED_RABBIT)
                .add(ModItems.PRIXILED_COOKED_RABBIT)
                .add(ModItems.PRIXILED_COD)
                .add(ModItems.PRIXILED_COOKED_COD)
                .add(ModItems.PRIXILED_SALMON)
                .add(ModItems.PRIXILED_COOKED_SALMON)
                .add(ModItems.PRIXILED_TROPICAL_FISH)
                .add(ModItems.PRIXILED_PUFFERFISH)
                .add(ModItems.PRIXILED_BREAD)
                .add(ModItems.PRIXILED_COOKIE)
                .add(ModItems.PRIXILED_PUMPKIN_PIE)
                .add(ModItems.PRIXILED_ROTTEN_FLESH)
                .add(ModItems.PRIXILED_SPIDER_EYE)
                .add(ModItems.PRIXILED_MUSHROOM_STEW)
                .add(ModItems.PRIXILED_BEETROOT_SOUP)
                .add(ModItems.PRIXILED_RABBIT_STEW)
                .add(ModItems.PRIXILED_HONEY_BOTTLE);

        valueLookupBuilder(ModTags.Items.CHARMS)
                .addTag(ModTags.Items.TIER_I_CHARMS)
                .addTag(ModTags.Items.TIER_II_CHARMS)
                .addTag(ModTags.Items.TIER_III_CHARMS);

        valueLookupBuilder(ModTags.Items.TIER_I_CHARMS)
                .add(ModItems.CONTAINER_CHARM_I)
                .add(ModItems.STASIS_CHARM_I)
                .add(ModItems.REGENERATION_CHARM_I)
                .add(ModItems.POSTMORTAL_CHARM_I)
                .add(ModItems.STOPWATCH_CHARM_I)
                .add(ModItems.IMMUNITY_CHARM_I)
                .add(ModItems.SONIC_BOOM_CHARM_I)
                .add(ModItems.WITHER_CHARM_I);

        valueLookupBuilder(ModTags.Items.TIER_II_CHARMS)
                .add(ModItems.CONTAINER_CHARM_II)
                .add(ModItems.STASIS_CHARM_II)
                .add(ModItems.REGENERATION_CHARM_II)
                .add(ModItems.POSTMORTAL_CHARM_II)
                .add(ModItems.STOPWATCH_CHARM_II)
                .add(ModItems.IMMUNITY_CHARM_II)
                .add(ModItems.SONIC_BOOM_CHARM_II)
                .add(ModItems.WITHER_CHARM_II);

        valueLookupBuilder(ModTags.Items.TIER_III_CHARMS)
                .add(ModItems.CONTAINER_CHARM_III)
                .add(ModItems.STASIS_CHARM_III)
                .add(ModItems.REGENERATION_CHARM_III)
                .add(ModItems.POSTMORTAL_CHARM_III)
                .add(ModItems.STOPWATCH_CHARM_III)
                .add(ModItems.IMMUNITY_CHARM_III)
                .add(ModItems.SONIC_BOOM_CHARM_III)
                .add(ModItems.WITHER_CHARM_III);

        valueLookupBuilder(ModTags.Items.REPARABLE_CHARMS)
                .add(ModItems.STASIS_CHARM_I)
                .add(ModItems.REGENERATION_CHARM_I)
                .add(ModItems.POSTMORTAL_CHARM_I)
                .add(ModItems.STOPWATCH_CHARM_I)
                .add(ModItems.IMMUNITY_CHARM_I)
                .add(ModItems.SONIC_BOOM_CHARM_I)
                .add(ModItems.WITHER_CHARM_I)
                .add(ModItems.STASIS_CHARM_II)
                .add(ModItems.REGENERATION_CHARM_II)
                .add(ModItems.POSTMORTAL_CHARM_II)
                .add(ModItems.STOPWATCH_CHARM_II)
                .add(ModItems.IMMUNITY_CHARM_II)
                .add(ModItems.SONIC_BOOM_CHARM_II)
                .add(ModItems.WITHER_CHARM_II)
                .add(ModItems.STASIS_CHARM_III)
                .add(ModItems.REGENERATION_CHARM_III)
                .add(ModItems.POSTMORTAL_CHARM_III)
                .add(ModItems.STOPWATCH_CHARM_III)
                .add(ModItems.IMMUNITY_CHARM_III)
                .add(ModItems.SONIC_BOOM_CHARM_III)
                .add(ModItems.WITHER_CHARM_III);

        valueLookupBuilder(ModTags.Items.OBELISK_OF_CHARMS_FUEL)
                .add(Items.EXPERIENCE_BOTTLE);

        valueLookupBuilder(ModTags.Items.OBELISK_OF_CHARMS_FUEL_LONG);

        valueLookupBuilder(ModTags.Items.CONTAINER_CHARM_UNHOLDABLE)
                .addTag(ModTags.Items.CHARMS)
                .add(Blocks.SHULKER_BOX.asItem());

        //endregion
    }
}
