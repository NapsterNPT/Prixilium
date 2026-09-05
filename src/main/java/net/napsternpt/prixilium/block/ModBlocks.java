package net.napsternpt.prixilium.block;

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
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.napsternpt.prixilium.Prixilium;
import net.napsternpt.prixilium.block.custom.*;
import net.napsternpt.prixilium.block.custom.woodSet.*;
import net.napsternpt.prixilium.particle.ModParticles;
import net.napsternpt.prixilium.world.tree.ModSaplingGenerators;

public class ModBlocks {
    private static String name;

    //region [Virus]
    public static final Block PRIXILIUM = registerBlock(name = "prixilium",
            new PrixiliumBlock(ModSaplingGenerators.PRIXILIUM, AbstractBlock.Settings.create()
                    .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Prixilium.MOD_ID, name)))
                    .mapColor(MapColor.GOLD)
                    .replaceable()
                    .noCollision()
                    .burnable()
                    .breakInstantly()
                    .sounds(BlockSoundGroup.GRASS)
                    .offset(AbstractBlock.OffsetType.XYZ)
                    .pistonBehavior(PistonBehavior.DESTROY)
                    .luminance(state -> 7)
            )
    );

    public static final Block PRIXILIUM_GRASS = registerBlock(name = "prixilium_grass",
            new PrixiliumGrassBlock(AbstractBlock.Settings.create()
                    .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Prixilium.MOD_ID, name)))
                    .strength(0.6f)
                    .sounds(BlockSoundGroup.GRASS)
                    .mapColor(MapColor.DARK_AQUA)
                    .allowsSpawning((state, world, pos, type) -> false)
            ));
    //endregion

    //region [Planks]
    public static final Block PRIXILIUM_LEAVES = registerBlock(name = "prixilium_leaves",
            new PrixiliumLeavesBlock(0.1F, ModParticles.PRIXILIUM_LEAVES,AbstractBlock.Settings.create()
                    .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Prixilium.MOD_ID, name)))
                    .strength(0.2F)
                    .sounds(BlockSoundGroup.GRASS)
                    .mapColor(MapColor.GOLD)
                    .ticksRandomly()
                    .burnable()
                    .nonOpaque()
                    .luminance(state -> 7)
            ));

    public static final Block PRIXILIUM_LOG = registerBlock(name = "prixilium_log",
            new PrixiliumLogBlock(AbstractBlock.Settings.create()
                    .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Prixilium.MOD_ID, name)))
                    .strength(2.0F)
                    .sounds(BlockSoundGroup.WOOD)
                    .mapColor(MapColor.TEAL)
            ));

    public static final Block PRIXILIUM_WOOD = registerBlock(name = "prixilium_wood",
            new PrixiliumWoodBlock(AbstractBlock.Settings.create()
                    .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Prixilium.MOD_ID, name)))
                    .strength(2.0F)
                    .sounds(BlockSoundGroup.WOOD)
                    .mapColor(MapColor.TEAL)
            ));

    public static final Block PRIXILIUM_PLANKS = registerBlock(name = "prixilium_planks",
            new PrixiliumPlanksBlock(AbstractBlock.Settings.create()
                    .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Prixilium.MOD_ID, name)))
                    .strength(2.0F)
                    .sounds(BlockSoundGroup.WOOD)
                    .mapColor(MapColor.CYAN)
            ));

    public static final Block PRIXILIUM_STAIRS = registerBlock(name = "prixilium_stairs",
            new PrixiliumStairsBlock(ModBlocks.PRIXILIUM_PLANKS.getDefaultState(), AbstractBlock.Settings.create()
                    .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Prixilium.MOD_ID, name)))
                    .strength(2.0F)
                    .sounds(BlockSoundGroup.WOOD)
                    .mapColor(MapColor.CYAN)
            ));

    public static final Block PRIXILIUM_SLAB = registerBlock(name = "prixilium_slab",
            new PrixiliumSlabBlock(AbstractBlock.Settings.create()
                    .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Prixilium.MOD_ID, name)))
                    .strength(2.0F)
                    .sounds(BlockSoundGroup.WOOD)
                    .mapColor(MapColor.CYAN)
            ));

    public static final Block PRIXILIUM_FENCE = registerBlock(name = "prixilium_fence",
            new PrixiliumFenceBlock(AbstractBlock.Settings.create()
                    .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Prixilium.MOD_ID, name)))
                    .strength(2.0F)
                    .sounds(BlockSoundGroup.WOOD)
                    .mapColor(MapColor.CYAN)
            ));

    public static final Block PRIXILIUM_FENCE_GATE = registerBlock(name = "prixilium_fence_gate",
            new PrixiliumFenceGateBlock(WoodType.OAK, AbstractBlock.Settings.create()
                    .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Prixilium.MOD_ID, name)))
                    .strength(2.0F)
                    .sounds(BlockSoundGroup.WOOD)
                    .mapColor(MapColor.CYAN)
            ));

    public static final Block PRIXILIUM_DOOR = registerBlock(name = "prixilium_door",
            new PrixiliumDoorBlock(BlockSetType.OAK, AbstractBlock.Settings.create()
                    .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Prixilium.MOD_ID, name)))
                    .strength(2.0F)
                    .sounds(BlockSoundGroup.WOOD)
                    .mapColor(MapColor.CYAN)
                    .nonOpaque()
            ));

    public static final Block PRIXILIUM_TRAPDOOR = registerBlock(name = "prixilium_trapdoor",
            new PrixiliumTrapdoorBlock(BlockSetType.OAK, AbstractBlock.Settings.create()
                    .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Prixilium.MOD_ID, name)))
                    .strength(2.0F)
                    .sounds(BlockSoundGroup.WOOD)
                    .mapColor(MapColor.CYAN)
                    .nonOpaque()
            ));

    //endregion

    //region [Burned Planks]
    public static final Block BURNED_PRIXILIUM_LOG = registerBlock(name = "burned_prixilium_log",
            new PillarBlock(AbstractBlock.Settings.create()
                    .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Prixilium.MOD_ID, name)))
                    .strength(2.0F)
                    .sounds(BlockSoundGroup.WOOD)
                    .mapColor(MapColor.LIGHT_GRAY)
            ));

    public static final Block BURNED_PRIXILIUM_WOOD = registerBlock(name = "burned_prixilium_wood",
            new PillarBlock(AbstractBlock.Settings.create()
                    .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Prixilium.MOD_ID, name)))
                    .strength(2.0F)
                    .sounds(BlockSoundGroup.WOOD)
                    .mapColor(MapColor.LIGHT_GRAY)
            ));

    public static final Block BURNED_PRIXILIUM_PLANKS = registerBlock(name = "burned_prixilium_planks",
            new Block(AbstractBlock.Settings.create()
                    .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Prixilium.MOD_ID, name)))
                    .strength(2.0F)
                    .sounds(BlockSoundGroup.WOOD)
                    .mapColor(MapColor.GRAY)
            ));

    public static final Block BURNED_PRIXILIUM_STAIRS = registerBlock(name = "burned_prixilium_stairs",
            new StairsBlock(ModBlocks.PRIXILIUM_PLANKS.getDefaultState(), AbstractBlock.Settings.create()
                    .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Prixilium.MOD_ID, name)))
                    .strength(2.0F)
                    .sounds(BlockSoundGroup.WOOD)
                    .mapColor(MapColor.GRAY)
            ));

    public static final Block BURNED_PRIXILIUM_SLAB = registerBlock(name = "burned_prixilium_slab",
            new SlabBlock(AbstractBlock.Settings.create()
                    .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Prixilium.MOD_ID, name)))
                    .strength(2.0F)
                    .sounds(BlockSoundGroup.WOOD)
                    .mapColor(MapColor.GRAY)
            ));

    public static final Block BURNED_PRIXILIUM_FENCE = registerBlock(name = "burned_prixilium_fence",
            new FenceBlock(AbstractBlock.Settings.create()
                    .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Prixilium.MOD_ID, name)))
                    .strength(2.0F)
                    .sounds(BlockSoundGroup.WOOD)
                    .mapColor(MapColor.GRAY)
            ));

    public static final Block BURNED_PRIXILIUM_FENCE_GATE = registerBlock(name = "burned_prixilium_fence_gate",
            new FenceGateBlock(WoodType.SPRUCE, AbstractBlock.Settings.create()
                    .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Prixilium.MOD_ID, name)))
                    .strength(2.0F)
                    .sounds(BlockSoundGroup.WOOD)
                    .mapColor(MapColor.GRAY)
            ));

    public static final Block BURNED_PRIXILIUM_DOOR = registerBlock(name = "burned_prixilium_door",
            new DoorBlock(BlockSetType.SPRUCE, AbstractBlock.Settings.create()
                    .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Prixilium.MOD_ID, name)))
                    .strength(2.0F)
                    .sounds(BlockSoundGroup.WOOD)
                    .mapColor(MapColor.GRAY)
                    .nonOpaque()
            ));

    public static final Block BURNED_PRIXILIUM_TRAPDOOR = registerBlock(name = "burned_prixilium_trapdoor",
            new TrapdoorBlock(BlockSetType.SPRUCE, AbstractBlock.Settings.create()
                    .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Prixilium.MOD_ID, name)))
                    .strength(2.0F)
                    .sounds(BlockSoundGroup.WOOD)
                    .mapColor(MapColor.GRAY)
                    .nonOpaque()
            ));

    //endregion

    //region [Bricks]
    public static final Block PRIXILIUM_BRICKS = registerBlock(name = "prixilium_bricks",
            new Block(AbstractBlock.Settings.create()
                    .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Prixilium.MOD_ID, name)))
                    .requiresTool()
                    .strength(1.5F, 6.0F)
                    .mapColor(MapColor.CYAN)
            ));

    public static final Block CRACKED_PRIXILIUM_BRICKS = registerBlock(name = "cracked_prixilium_bricks",
            new Block(AbstractBlock.Settings.create()
                    .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Prixilium.MOD_ID, name)))
                    .requiresTool()
                    .strength(1.5F, 6.0F)
                    .mapColor(MapColor.CYAN)
            ));

    public static final Block CHISELED_PRIXILIUM_BRICKS = registerBlock(name = "chiseled_prixilium_bricks",
            new Block(AbstractBlock.Settings.create()
                    .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Prixilium.MOD_ID, name)))
                    .requiresTool()
                    .strength(1.5F, 6.0F)
                    .mapColor(MapColor.CYAN)
            ));

    public static final Block PRIXILIUM_GRATE = registerBlock(name = "prixilium_grate",
            new GrateBlock(AbstractBlock.Settings.create()
                    .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Prixilium.MOD_ID, name)))
                    .requiresTool()
                    .strength(3.0F)
                    .sounds(BlockSoundGroup.COPPER_GRATE)
                    .mapColor(MapColor.GOLD)
                    .nonOpaque()
            ));

    public static final Block PRIXILIUM_BRICK_STAIRS = registerBlock(name = "prixilium_brick_stairs",
            new StairsBlock(ModBlocks.PRIXILIUM_PLANKS.getDefaultState(), AbstractBlock.Settings.create()
                    .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Prixilium.MOD_ID, name)))
                    .requiresTool()
                    .strength(1.5F, 6.0F)
                    .mapColor(MapColor.CYAN)
            ));

    public static final Block PRIXILIUM_BRICK_SLAB = registerBlock(name = "prixilium_brick_slab",
            new SlabBlock(AbstractBlock.Settings.create()
                    .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Prixilium.MOD_ID, name)))
                    .requiresTool()
                    .strength(1.5F, 6.0F)
                    .mapColor(MapColor.CYAN)
            ));

    public static final Block PRIXILIUM_BRICKS_WALL = registerBlock(name = "prixilium_bricks_wall",
            new WallBlock(AbstractBlock.Settings.create()
                    .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Prixilium.MOD_ID, name)))
                    .requiresTool()
                    .strength(1.5F, 6.0F)
                    .mapColor(MapColor.CYAN)
            ));

    //endregion

    //region [Dark Bricks]
    public static final Block DARK_PRIXILIUM_BRICKS = registerBlock(name = "dark_prixilium_bricks",
            new Block(AbstractBlock.Settings.create()
                    .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Prixilium.MOD_ID, name)))
                    .requiresTool()
                    .strength(1.5F, 6.0F)
                    .mapColor(MapColor.CYAN)
            ));

    public static final Block CRACKED_DARK_PRIXILIUM_BRICKS = registerBlock(name = "cracked_dark_prixilium_bricks",
            new Block(AbstractBlock.Settings.create()
                    .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Prixilium.MOD_ID, name)))
                    .requiresTool()
                    .strength(1.5F, 6.0F)
                    .mapColor(MapColor.CYAN)
            ));

    public static final Block CHISELED_DARK_PRIXILIUM_BRICKS = registerBlock(name = "chiseled_dark_prixilium_bricks",
            new Block(AbstractBlock.Settings.create()
                    .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Prixilium.MOD_ID, name)))
                    .requiresTool()
                    .strength(1.5F, 6.0F)
                    .mapColor(MapColor.CYAN)
            ));

    public static final Block DARK_PRIXILIUM_GRATE = registerBlock(name = "dark_prixilium_grate",
            new GrateBlock(AbstractBlock.Settings.create()
                    .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Prixilium.MOD_ID, name)))
                    .requiresTool()
                    .strength(3.0F)
                    .sounds(BlockSoundGroup.COPPER_GRATE)
                    .mapColor(MapColor.GOLD)
                    .nonOpaque()
            ));

    public static final Block DARK_PRIXILIUM_BRICK_STAIRS = registerBlock(name = "dark_prixilium_brick_stairs",
            new StairsBlock(ModBlocks.PRIXILIUM_PLANKS.getDefaultState(), AbstractBlock.Settings.create()
                    .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Prixilium.MOD_ID, name)))
                    .requiresTool()
                    .strength(1.5F, 6.0F)
                    .mapColor(MapColor.CYAN)
            ));

    public static final Block DARK_PRIXILIUM_BRICK_SLAB = registerBlock(name = "dark_prixilium_brick_slab",
            new SlabBlock(AbstractBlock.Settings.create()
                    .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Prixilium.MOD_ID, name)))
                    .requiresTool()
                    .strength(1.5F, 6.0F)
                    .mapColor(MapColor.CYAN)
            ));

    public static final Block DARK_PRIXILIUM_BRICKS_WALL = registerBlock(name = "dark_prixilium_bricks_wall",
            new WallBlock(AbstractBlock.Settings.create()
                    .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Prixilium.MOD_ID, name)))
                    .requiresTool()
                    .strength(1.5F, 6.0F)
                    .mapColor(MapColor.CYAN)
            ));

    //endregion

    public static final Block RIFT = registerBlock(name = "rift",
            new RiftBlock(AbstractBlock.Settings.create()
                    .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Prixilium.MOD_ID, name)))
                    .strength(0.1F)
                    .sounds(BlockSoundGroup.MOSS_BLOCK)
                    .mapColor(MapColor.LIGHT_GRAY)
            ));

    public static final Block RIFT_CORE = registerBlock(name = "rift_core",
            new Block(AbstractBlock.Settings.create()
                    .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Prixilium.MOD_ID, name)))
                    .strength(0.1F)
                    .sounds(BlockSoundGroup.MOSS_BLOCK)
                    .mapColor(MapColor.LIGHT_GRAY)
            ){
                @Override
                protected VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
                    return Block.createCuboidShape(4.0, 4.0, 4.0, 12.0, 12.0, 12.0);
                }
            });

    public static final Block PRIXILIUM_EXHAUST = registerBlock(name = "prixilium_exhaust",
            new PrixiliumExhaustBlock(AbstractBlock.Settings.create()
                    .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Prixilium.MOD_ID, name)))
                    .requiresTool()
                    .strength(1.5F, 6.0F)
                    .mapColor(MapColor.CYAN)
            ));

    public static final Block PRIXILIUM_LAMP = registerBlock(name = "prixilium_lamp",
            new PrixiliumLampBlock(AbstractBlock.Settings.create()
                    .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Prixilium.MOD_ID, name)))
                    .strength(0.5F)
                    .sounds(BlockSoundGroup.GLASS)
                    .mapColor(MapColor.LIGHT_GRAY)
                    .nonOpaque()
                    .luminance(state -> state.get(PrixiliumLampBlock.LIGHT))
            ));

    public static final Block STAND = registerBlock(name = "stand",
            new StandBlock(AbstractBlock.Settings.create()
                    .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Prixilium.MOD_ID, name)))
                    .strength(3.5F, 6.0F)
                    .mapColor(MapColor.LIGHT_GRAY)
                    .nonOpaque()
                    .pistonBehavior(PistonBehavior.BLOCK)
            ));

    public static final Block REACTOR_CORE = registerBlock(name = "reactor_core",
            new ReactorCoreBlock(AbstractBlock.Settings.create()
                    .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Prixilium.MOD_ID, name)))
                    .strength(4.0F, 6.5F)
                    .mapColor(MapColor.LIGHT_GRAY)
                    .nonOpaque()
                    .pistonBehavior(PistonBehavior.BLOCK)
            ));

    public static final Block VIRUS_REACTOR = registerBlock(name = "virus_reactor",
            new VirusReactorBlock(AbstractBlock.Settings.create()
                    .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Prixilium.MOD_ID, name)))
                    .strength(5.0F, 7.0F)
                    .mapColor(MapColor.LIGHT_GRAY)
                    .nonOpaque()
            ));

    public static final Block OBELISK_OF_CHARMS = registerBlock(name = "obelisk_of_charms",
            new ObeliskOfCharmsBlock(AbstractBlock.Settings.create()
                    .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Prixilium.MOD_ID, name)))
                    .strength(5.0F, 7.0F)
                    .mapColor(MapColor.LIGHT_GRAY)
                    .nonOpaque()
            ));

    public static final Block PRIXIVERSE_PORTAL = registerBlock(name = "prixiverse_portal",
            new PrixiversePortalBlock(AbstractBlock.Settings.create()
                    .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Prixilium.MOD_ID, name)))
                    .noCollision()
                    .luminance(state -> 15)
                    .strength(-1.0F, 3600000.0F)
                    .dropsNothing()
                    .pistonBehavior(PistonBehavior.BLOCK)
            ), false);

    private static Block registerBlock(String name, Block block) {
        return registerBlock(name, block, true);
    }

    private static Block registerBlock(String name, Block block, boolean item) {
        if (item) registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(Prixilium.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(Prixilium.MOD_ID, name),
                new BlockItem(block, new Item.Settings()
                        .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, name))).useBlockPrefixedTranslationKey()));
    }

    public static void registerBlocks() {
        Prixilium.LOGGER.info("Registering Prixilium Blocks.");
    }
}
