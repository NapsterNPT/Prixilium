package net.napsternpt.prixilium.datagen.tags;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.Blocks;
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
        valueLookupBuilder(ItemTags.SWORDS)
                .add(ModItems.PRIXILED_WOODEN_SWORD)
                .add(ModItems.PRIXILED_STONE_SWORD)
                .add(ModItems.PRIXILED_COPPER_SWORD)
                .add(ModItems.PRIXILED_IRON_SWORD)
                .add(ModItems.PRIXILED_GOLDEN_SWORD)
                .add(ModItems.PRIXILED_DIAMOND_SWORD)
                .add(ModItems.PRIXILED_NETHERITE_SWORD);

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

        valueLookupBuilder(ItemTags.SHOVELS)
                .add(ModItems.PRIXILED_WOODEN_SHOVEL)
                .add(ModItems.PRIXILED_STONE_SHOVEL)
                .add(ModItems.PRIXILED_COPPER_SHOVEL)
                .add(ModItems.PRIXILED_IRON_SHOVEL)
                .add(ModItems.PRIXILED_GOLDEN_SHOVEL)
                .add(ModItems.PRIXILED_DIAMOND_SHOVEL)
                .add(ModItems.PRIXILED_NETHERITE_SHOVEL);

        valueLookupBuilder(ItemTags.HOES)
                .add(ModItems.PRIXILED_WOODEN_HOE)
                .add(ModItems.PRIXILED_STONE_HOE)
                .add(ModItems.PRIXILED_COPPER_HOE)
                .add(ModItems.PRIXILED_IRON_HOE)
                .add(ModItems.PRIXILED_GOLDEN_HOE)
                .add(ModItems.PRIXILED_DIAMOND_HOE)
                .add(ModItems.PRIXILED_NETHERITE_HOE);

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

        valueLookupBuilder(ItemTags.BOW_ENCHANTABLE)
                .add(ModItems.PRIXILED_BOW);

        valueLookupBuilder(ItemTags.MACE_ENCHANTABLE)
                .add(ModItems.PRIXILED_MACE);

        // Blocks
        valueLookupBuilder(ItemTags.LOGS)
                .add(ModBlocks.PRIXILIUM_LOG.asItem())
                .add(ModBlocks.PRIXILIUM_WOOD.asItem())
                .add(ModBlocks.BURNED_PRIXILIUM_LOG.asItem())
                .add(ModBlocks.BURNED_PRIXILIUM_WOOD.asItem());

        valueLookupBuilder(ItemTags.PLANKS)
                .add(ModBlocks.PRIXILIUM_PLANKS.asItem())
                .add(ModBlocks.BURNED_PRIXILIUM_PLANKS.asItem());

        // Mod Tags
        valueLookupBuilder(ModTags.Items.PREVENT_PRIXILIUM_SLOWNESS)
                .add(ModItems.PRIXILED_LEATHER_BOOTS)
                .add(ModItems.PRIXILED_CHAINMAIL_BOOTS)
                .add(ModItems.PRIXILED_COPPER_BOOTS)
                .add(ModItems.PRIXILED_IRON_BOOTS)
                .add(ModItems.PRIXILED_GOLDEN_BOOTS)
                .add(ModItems.PRIXILED_DIAMOND_BOOTS)
                .add(ModItems.PRIXILED_NETHERITE_BOOTS);

        valueLookupBuilder(ModTags.Items.TEMPERATURE_TOOLS)
                .add(ModItems.THERMOMETER);

        valueLookupBuilder(ModTags.Items.CHARMS)
                .add(ModItems.CHARM_I)
                .add(ModItems.CONTAINER_CHARM_I)
                .add(ModItems.STASIS_CHARM_I)
                .add(ModItems.REGENERATION_CHARM_I)
                .add(ModItems.POSTMORTAL_CHARM_I)
                .add(ModItems.STOPWATCH_CHARM_I)
                .add(ModItems.IMMUNITY_CHARM_I)
                .add(ModItems.SONIC_BOOM_CHARM_I)
                .add(ModItems.WITHER_CHARM_I)
                .add(ModItems.CHARM_II)
                .add(ModItems.CONTAINER_CHARM_II)
                .add(ModItems.STASIS_CHARM_II)
                .add(ModItems.REGENERATION_CHARM_II)
                .add(ModItems.POSTMORTAL_CHARM_II)
                .add(ModItems.STOPWATCH_CHARM_II)
                .add(ModItems.IMMUNITY_CHARM_II)
                .add(ModItems.SONIC_BOOM_CHARM_II)
                .add(ModItems.WITHER_CHARM_II)
                .add(ModItems.CHARM_III)
                .add(ModItems.CONTAINER_CHARM_III)
                .add(ModItems.STASIS_CHARM_III)
                .add(ModItems.REGENERATION_CHARM_III)
                .add(ModItems.POSTMORTAL_CHARM_III)
                .add(ModItems.STOPWATCH_CHARM_III)
                .add(ModItems.IMMUNITY_CHARM_III)
                .add(ModItems.SONIC_BOOM_CHARM_III)
                .add(ModItems.WITHER_CHARM_III);

        valueLookupBuilder(ModTags.Items.CONTAINER_CHARM_UNHOLDABLE)
                .addTag(ModTags.Items.CHARMS)
                .add(Blocks.SHULKER_BOX.asItem());
    }
}
