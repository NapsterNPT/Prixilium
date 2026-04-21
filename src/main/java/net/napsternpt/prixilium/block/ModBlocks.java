package net.napsternpt.prixilium.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.*;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.napsternpt.prixilium.Prixilium;
import net.napsternpt.prixilium.block.custom.*;
import net.napsternpt.prixilium.world.tree.ModSaplingGenerators;

public class ModBlocks {

    public static final Block PRIXILIUM_GRASS = registerBlock("prixilium_grass",
            new PrixiliumGrassBlock(AbstractBlock.Settings.create()
                    .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Prixilium.MOD_ID, "prixilium_grass")))
                    .strength(0.6f)
                    .sounds(BlockSoundGroup.GRASS)
                    .mapColor(MapColor.DARK_AQUA)
                    .allowsSpawning((state, world, pos, type) -> false)
            ));

    public static final Block PRIXILIUM = registerBlock("prixilium",
            new PrixiliumBlock(
                    ModSaplingGenerators.PRIXILIUM,
                    AbstractBlock.Settings.create()
                            .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Prixilium.MOD_ID, "prixilium")))
                            .mapColor(MapColor.GOLD)
                            .replaceable()
                            .noCollision()
                            .breakInstantly()
                            .sounds(BlockSoundGroup.GRASS)
                            .offset(AbstractBlock.OffsetType.XYZ)
                            .pistonBehavior(PistonBehavior.DESTROY)
                            .luminance(state -> 7)
            )
    );

    public static final Block PRIXILIUM_LOG = registerBlock("prixilium_log",
            new PrixiliumLogsBlock(AbstractBlock.Settings.create()
                    .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Prixilium.MOD_ID, "prixilium_log")))
                    .strength(2.0F)
                    .sounds(BlockSoundGroup.WOOD)
                    .mapColor(MapColor.TEAL)
            ));
    public static final Block PRIXILIUM_WOOD = registerBlock("prixilium_wood",
            new PrixiliumWoodBlock(AbstractBlock.Settings.create()
                    .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Prixilium.MOD_ID, "prixilium_wood")))
                    .strength(2.0F)
                    .sounds(BlockSoundGroup.WOOD)
                    .mapColor(MapColor.TEAL)
            ));

    public static final Block PRIXILIUM_LEAVES = registerBlock("prixilium_leaves",
            new PrixiliumLeavesBlock(AbstractBlock.Settings.create()
                    .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Prixilium.MOD_ID, "prixilium_leaves")))
                    .strength(0.2F)
                    .sounds(BlockSoundGroup.GRASS)
                    .mapColor(MapColor.GOLD)
                    .ticksRandomly()
                    .nonOpaque()
                    .luminance(state -> 7)
            ));

    public static final Block PRIXILIUM_PLANKS = registerBlock("prixilium_planks",
            new Block(AbstractBlock.Settings.create()
                    .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Prixilium.MOD_ID, "prixilium_planks")))
                    .strength(2.0F)
                    .sounds(BlockSoundGroup.WOOD)
                    .mapColor(MapColor.CYAN)
            ));
    public static final Block PRIXILIUM_STAIRS = registerBlock("prixilium_stairs",
            new StairsBlock(ModBlocks.PRIXILIUM_PLANKS.getDefaultState(), AbstractBlock.Settings.create()
                    .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Prixilium.MOD_ID, "prixilium_stairs")))
                    .strength(2.0F)
                    .sounds(BlockSoundGroup.WOOD)
                    .mapColor(MapColor.CYAN)
            ));
    public static final Block PRIXILIUM_SLAB = registerBlock("prixilium_slab",
            new SlabBlock(AbstractBlock.Settings.create()
                    .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Prixilium.MOD_ID, "prixilium_slab")))
                    .strength(2.0F)
                    .sounds(BlockSoundGroup.WOOD)
                    .mapColor(MapColor.CYAN)
            ));
    public static final Block PRIXILIUM_FENCE = registerBlock("prixilium_fence",
            new FenceBlock(AbstractBlock.Settings.create()
                    .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Prixilium.MOD_ID, "prixilium_fence")))
                    .strength(2.0F)
                    .sounds(BlockSoundGroup.WOOD)
                    .mapColor(MapColor.CYAN)
            ));
    public static final Block PRIXILIUM_FENCE_GATE = registerBlock("prixilium_fence_gate",
            new FenceGateBlock(WoodType.SPRUCE, AbstractBlock.Settings.create()
                    .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Prixilium.MOD_ID, "prixilium_fence_gate")))
                    .strength(2.0F)
                    .sounds(BlockSoundGroup.WOOD)
                    .mapColor(MapColor.CYAN)
            ));
    public static final Block PRIXILIUM_DOOR = registerBlock("prixilium_door",
            new DoorBlock(BlockSetType.SPRUCE, AbstractBlock.Settings.create()
                    .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Prixilium.MOD_ID, "prixilium_door")))
                    .strength(2.0F)
                    .sounds(BlockSoundGroup.WOOD)
                    .mapColor(MapColor.CYAN)
                    .nonOpaque()
            ));
    public static final Block PRIXILIUM_TRAPDOOR = registerBlock("prixilium_trapdoor",
            new TrapdoorBlock(BlockSetType.SPRUCE, AbstractBlock.Settings.create()
                    .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Prixilium.MOD_ID, "prixilium_trapdoor")))
                    .strength(2.0F)
                    .sounds(BlockSoundGroup.WOOD)
                    .mapColor(MapColor.CYAN)
                    .nonOpaque()
            ));

    public static final Block PRIXILIUM_BRICKS = registerBlock("prixilium_bricks",
            new Block(AbstractBlock.Settings.create()
                    .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Prixilium.MOD_ID, "prixilium_bricks")))
                    .requiresTool()
                    .strength(1.5F, 6.0F)
                    .mapColor(MapColor.CYAN)
            ));
    public static final Block PRIXILIUM_BRICKS_WALL = registerBlock("prixilium_bricks_wall",
            new PrixiliumBricksWallBlock(AbstractBlock.Settings.create()
                    .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Prixilium.MOD_ID, "prixilium_bricks_wall")))
                    .requiresTool()
                    .strength(1.5F, 6.0F)
                    .mapColor(MapColor.CYAN)
            ));

    public static final Block PRIXILIUM_LAMP = registerBlock("prixilium_lamp",
            new PrixiliumLampBlock(AbstractBlock.Settings.create()
                    .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Prixilium.MOD_ID, "prixilium_lamp")))
                    .strength(0.5F)
                    .sounds(BlockSoundGroup.GLASS)
                    .mapColor(MapColor.LIGHT_GRAY)
                    .nonOpaque()
                    .luminance(state -> state.get(PrixiliumLampBlock.LIGHT))
            ));

    public static final Block STAND = registerBlock("stand",
            new StandBlock(AbstractBlock.Settings.create()
                    .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Prixilium.MOD_ID, "stand")))
                    .strength(3.5F, 6.0F)
                    .mapColor(MapColor.LIGHT_GRAY)
                    .nonOpaque()
            ));
    public static final Block REACTOR_CORE = registerBlock("reactor_core",
            new ReactorCoreBlock(AbstractBlock.Settings.create()
                    .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Prixilium.MOD_ID, "reactor_core")))
                    .strength(4.0F, 6.5F)
                    .mapColor(MapColor.LIGHT_GRAY)
                    .nonOpaque()
            ));
    public static final Block VIRUS_REACTOR = registerBlock("virus_reactor",
            new VirusReactorBlock(AbstractBlock.Settings.create()
                    .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Prixilium.MOD_ID, "virus_reactor")))
                    .strength(5.0F, 7.0F)
                    .mapColor(MapColor.LIGHT_GRAY)
                    .nonOpaque()
            ));

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(Prixilium.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(Prixilium.MOD_ID, name),
                new BlockItem(block, new Item.Settings()
                        .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, name))).useBlockPrefixedTranslationKey()));
    }

    public static void registerModBlocks() {Prixilium.LOGGER.info("Registering Prixilium Blocks.");}
}
