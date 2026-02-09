package net.napsternpt.prixilium.block;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.*;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.napsternpt.prixilium.Prixilium;
import net.napsternpt.prixilium.block.custom.*;

public class ModBlocks {

    public static final Block PRIXILIUM_GRASS = registerBlock("prixilium_grass",
            new PrixiliumGrassBlock(AbstractBlock.Settings.create()
                    .strength(0.6f)
                    .sounds(BlockSoundGroup.GRASS)
                    .mapColor(MapColor.DARK_AQUA)
            ));

    public static final Block PRIXILIUM = registerBlock("prixilium",
            new ShortPlantBlock(AbstractBlock.Settings.create()
                    .mapColor(MapColor.GOLD)
                    .replaceable()
                    .noCollision()
                    .breakInstantly()
                    .sounds(BlockSoundGroup.GRASS)
                    .offset(AbstractBlock.OffsetType.XYZ)
                    .pistonBehavior(PistonBehavior.DESTROY)
            ));

    public static final Block PRIXILIUM_LOG = registerBlock("prixilium_log",
            new PrixiliumLogsBlock(AbstractBlock.Settings.create()
                    .strength(2.0F)
                    .sounds(BlockSoundGroup.WOOD)
                    .mapColor(MapColor.TEAL)
            ));

    public static final Block PRIXILIUM_WOOD = registerBlock("prixilium_wood",
            new PrixiliumLogsBlock(AbstractBlock.Settings.create()
                    .strength(2.0F)
                    .sounds(BlockSoundGroup.WOOD)
                    .mapColor(MapColor.TEAL)
            ));

    public static final Block PRIXILIUM_LEAVES = registerBlock("prixilium_leaves",
            new PrixiliumLeavesBlock(AbstractBlock.Settings.create()
                    .strength(0.2F)
                    .sounds(BlockSoundGroup.GRASS)
                    .mapColor(MapColor.GOLD)
                    .ticksRandomly()
                    .nonOpaque()
            ));

    public static final Block PRIXILIUM_PLANKS = registerBlock("prixilium_planks",
            new Block(AbstractBlock.Settings.create()
                    .strength(2.0F)
                    .sounds(BlockSoundGroup.WOOD)
                    .mapColor(MapColor.CYAN)
            ));

    public static final Block PRIXILIUM_BRICKS = registerBlock("prixilium_bricks",
            new Block(AbstractBlock.Settings.create()
                    .requiresTool()
                    .strength(1.5F, 6.0F)
                    .mapColor(MapColor.CYAN)
            ));

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
            entries.add(ModBlocks.PRIXILIUM);
            entries.add(ModBlocks.PRIXILIUM_LEAVES);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {
            entries.add(ModBlocks.PRIXILIUM_LOG);
            entries.add(ModBlocks.PRIXILIUM_WOOD);
            entries.add(ModBlocks.PRIXILIUM_PLANKS);
            entries.add(ModBlocks.PRIXILIUM_BRICKS);
        });
    }
}
