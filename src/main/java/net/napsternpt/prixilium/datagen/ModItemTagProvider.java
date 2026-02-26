package net.napsternpt.prixilium.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;
import net.napsternpt.prixilium.item.ModItems;
import net.napsternpt.prixilium.util.ModTags;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(ItemTags.SWORDS)
                .add(ModItems.PRIXILED_WOODEN_SWORD)
                .add(ModItems.PRIXILED_STONE_SWORD)
                //1.12.9+ .add(ModItems.PRIXILED_COPPER_SWORD)
                .add(ModItems.PRIXILED_IRON_SWORD)
                .add(ModItems.PRIXILED_GOLDEN_SWORD)
                .add(ModItems.PRIXILED_DIAMOND_SWORD)
                .add(ModItems.PRIXILED_NETHERITE_SWORD);

        getOrCreateTagBuilder(ItemTags.PICKAXES)
                .add(ModItems.PRIXILED_WOODEN_PICKAXE)
                .add(ModItems.PRIXILED_STONE_PICKAXE)
                //1.12.9+ .add(ModItems.PRIXILED_COPPER_PICKAXE)
                .add(ModItems.PRIXILED_IRON_PICKAXE)
                .add(ModItems.PRIXILED_GOLDEN_PICKAXE)
                .add(ModItems.PRIXILED_DIAMOND_PICKAXE)
                .add(ModItems.PRIXILED_NETHERITE_PICKAXE);

        getOrCreateTagBuilder(ItemTags.AXES)
                .add(ModItems.PRIXILED_WOODEN_AXE)
                .add(ModItems.PRIXILED_STONE_AXE)
                //1.12.9+ .add(ModItems.PRIXILED_COPPER_AXE)
                .add(ModItems.PRIXILED_IRON_AXE)
                .add(ModItems.PRIXILED_GOLDEN_AXE)
                .add(ModItems.PRIXILED_DIAMOND_AXE)
                .add(ModItems.PRIXILED_NETHERITE_AXE);

        getOrCreateTagBuilder(ItemTags.SHOVELS)
                .add(ModItems.PRIXILED_WOODEN_SHOVEL)
                .add(ModItems.PRIXILED_STONE_SHOVEL)
                //1.12.9+ .add(ModItems.PRIXILED_COPPER_SHOVEL)
                .add(ModItems.PRIXILED_IRON_SHOVEL)
                .add(ModItems.PRIXILED_GOLDEN_SHOVEL)
                .add(ModItems.PRIXILED_DIAMOND_SHOVEL)
                .add(ModItems.PRIXILED_NETHERITE_SHOVEL);

        getOrCreateTagBuilder(ItemTags.HOES)
                .add(ModItems.PRIXILED_WOODEN_HOE)
                .add(ModItems.PRIXILED_STONE_HOE)
                //1.12.9+ .add(ModItems.PRIXILED_COPPER_HOE)
                .add(ModItems.PRIXILED_IRON_HOE)
                .add(ModItems.PRIXILED_GOLDEN_HOE)
                .add(ModItems.PRIXILED_DIAMOND_HOE)
                .add(ModItems.PRIXILED_NETHERITE_HOE);

        getOrCreateTagBuilder(ItemTags.TRIMMABLE_ARMOR)
                .add(ModItems.PRIXILED_LEATHER_HELMET)
                .add(ModItems.PRIXILED_LEATHER_CHESTPLATE)
                .add(ModItems.PRIXILED_LEATHER_LEGGINGS)
                .add(ModItems.PRIXILED_LEATHER_BOOTS)
                .add(ModItems.PRIXILED_CHAINMAIL_HELMET)
                .add(ModItems.PRIXILED_CHAINMAIL_CHESTPLATE)
                .add(ModItems.PRIXILED_CHAINMAIL_LEGGINGS)
                .add(ModItems.PRIXILED_CHAINMAIL_BOOTS)
                /* 1.21.9+
                .add(ModItems.PRIXILED_COPPER_HELMET)
                .add(ModItems.PRIXILED_COPPER_CHESTPLATE)
                .add(ModItems.PRIXILED_COPPER_LEGGINGS)
                .add(ModItems.PRIXILED_COPPER_BOOTS)
                 */
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

        getOrCreateTagBuilder(ItemTags.DYEABLE)
                .add(ModItems.PRIXILED_LEATHER_HELMET)
                .add(ModItems.PRIXILED_LEATHER_CHESTPLATE)
                .add(ModItems.PRIXILED_LEATHER_LEGGINGS)
                .add(ModItems.PRIXILED_LEATHER_BOOTS);

                // Mod Tags
        getOrCreateTagBuilder(ModTags.Items.PREVENT_PRIXILIUM_SLOWNESS)
                .add(ModItems.PRIXILED_LEATHER_BOOTS)
                .add(ModItems.PRIXILED_CHAINMAIL_BOOTS)
                //1.21.9+ .add(ModItems.PRIXILED_COPPER_BOOTS)
                .add(ModItems.PRIXILED_IRON_BOOTS)
                .add(ModItems.PRIXILED_GOLDEN_BOOTS)
                .add(ModItems.PRIXILED_DIAMOND_BOOTS)
                .add(ModItems.PRIXILED_NETHERITE_BOOTS);
    }
}
