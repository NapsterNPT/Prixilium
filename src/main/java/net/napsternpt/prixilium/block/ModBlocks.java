package net.napsternpt.prixilium.block;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.napsternpt.prixilium.Prixilium;

public class ModBlocks {

    public static final Block PRIXILIUM_GRASS = registerBlock("prixilium_grass",
            new Block(AbstractBlock.Settings.create().strength(0.6f)
                    .sounds(BlockSoundGroup.GRASS)));

    public static final Block PRIXILIUM_LOG = registerBlock("prixilium_log",
            new Block(AbstractBlock.Settings.create().strength(2.0F)
                    .sounds(BlockSoundGroup.WOOD)));

    public static final Block PRIXILIUM_PLANKS = registerBlock("prixilium_planks",
            new Block(AbstractBlock.Settings.create().strength(2.0F)
                    .sounds(BlockSoundGroup.WOOD)));

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(Prixilium.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(Prixilium.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }

    public static void registerModBlocks() {
        Prixilium.LOGGER.info("Registering Prixilium Blocks");

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(entries -> {
            entries.add(ModBlocks.PRIXILIUM_GRASS);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {
            entries.add(ModBlocks.PRIXILIUM_LOG);
            entries.add(ModBlocks.PRIXILIUM_PLANKS);
        });
    }
}
