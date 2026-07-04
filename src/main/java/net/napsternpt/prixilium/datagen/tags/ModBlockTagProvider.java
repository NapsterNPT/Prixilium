package net.napsternpt.prixilium.datagen.tags;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.Blocks;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.napsternpt.prixilium.block.ModBlocks;
import net.napsternpt.prixilium.util.ModTags;
import org.jspecify.annotations.NonNull;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.@NonNull WrapperLookup wrapperLookup) {
        valueLookupBuilder(BlockTags.SHOVEL_MINEABLE)
                .add(ModBlocks.PRIXILIUM_GRASS);

        valueLookupBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(ModBlocks.STAND)
                .add(ModBlocks.REACTOR_CORE)
                .add(ModBlocks.VIRUS_REACTOR)
                .add(ModBlocks.PRIXILIUM_BRICKS)
                .add(ModBlocks.CRACKED_PRIXILIUM_BRICKS)
                .add(ModBlocks.CHISELED_PRIXILIUM_BRICKS)
                .add(ModBlocks.PRIXILIUM_GRATE)
                .add(ModBlocks.PRIXILIUM_BRICK_STAIRS)
                .add(ModBlocks.PRIXILIUM_BRICK_SLAB)
                .add(ModBlocks.DARK_PRIXILIUM_BRICKS)
                .add(ModBlocks.CRACKED_DARK_PRIXILIUM_BRICKS)
                .add(ModBlocks.CHISELED_DARK_PRIXILIUM_BRICKS)
                .add(ModBlocks.DARK_PRIXILIUM_GRATE)
                .add(ModBlocks.DARK_PRIXILIUM_BRICK_STAIRS)
                .add(ModBlocks.DARK_PRIXILIUM_BRICK_SLAB)
                .add(ModBlocks.PRIXILIUM_EXHAUST);

        valueLookupBuilder(BlockTags.AXE_MINEABLE)
                .add(ModBlocks.PRIXILIUM_LOG)
                .add(ModBlocks.PRIXILIUM_WOOD)
                .add(ModBlocks.PRIXILIUM_PLANKS)
                .add(ModBlocks.PRIXILIUM_STAIRS)
                .add(ModBlocks.PRIXILIUM_SLAB)
                .add(ModBlocks.PRIXILIUM_FENCE)
                .add(ModBlocks.PRIXILIUM_FENCE_GATE)
                .add(ModBlocks.PRIXILIUM_DOOR)
                .add(ModBlocks.PRIXILIUM_TRAPDOOR)

                .add(ModBlocks.BURNED_PRIXILIUM_LOG)
                .add(ModBlocks.BURNED_PRIXILIUM_WOOD)
                .add(ModBlocks.BURNED_PRIXILIUM_PLANKS)
                .add(ModBlocks.BURNED_PRIXILIUM_STAIRS)
                .add(ModBlocks.BURNED_PRIXILIUM_SLAB)
                .add(ModBlocks.BURNED_PRIXILIUM_FENCE)
                .add(ModBlocks.BURNED_PRIXILIUM_FENCE_GATE)
                .add(ModBlocks.BURNED_PRIXILIUM_DOOR)
                .add(ModBlocks.BURNED_PRIXILIUM_TRAPDOOR);

        valueLookupBuilder(BlockTags.HOE_MINEABLE)
                .add(ModBlocks.PRIXILIUM_LEAVES);

        valueLookupBuilder(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.REACTOR_CORE)
                .add(ModBlocks.VIRUS_REACTOR);

        valueLookupBuilder(BlockTags.NEEDS_STONE_TOOL)
                .add(ModBlocks.PRIXILIUM_BRICKS)
                .add(ModBlocks.CRACKED_PRIXILIUM_BRICKS)
                .add(ModBlocks.CHISELED_PRIXILIUM_BRICKS)
                .add(ModBlocks.PRIXILIUM_GRATE)
                .add(ModBlocks.PRIXILIUM_BRICK_STAIRS)
                .add(ModBlocks.PRIXILIUM_BRICK_SLAB)

                .add(ModBlocks.DARK_PRIXILIUM_BRICKS)
                .add(ModBlocks.CRACKED_DARK_PRIXILIUM_BRICKS)
                .add(ModBlocks.CHISELED_DARK_PRIXILIUM_BRICKS)
                .add(ModBlocks.DARK_PRIXILIUM_GRATE)
                .add(ModBlocks.DARK_PRIXILIUM_BRICK_STAIRS)
                .add(ModBlocks.DARK_PRIXILIUM_BRICK_SLAB)

                .add(ModBlocks.PRIXILIUM_EXHAUST);

        valueLookupBuilder(BlockTags.SAPLINGS)
                .add(ModBlocks.PRIXILIUM);

        valueLookupBuilder(BlockTags.DIRT)
                .add(ModBlocks.PRIXILIUM_GRASS);

        valueLookupBuilder(BlockTags.ENDERMAN_HOLDABLE)
                .add(ModBlocks.PRIXILIUM_GRASS);

        valueLookupBuilder(BlockTags.LEAVES)
                .add(ModBlocks.PRIXILIUM_LEAVES);

        valueLookupBuilder(BlockTags.COMPLETES_FIND_TREE_TUTORIAL)
                .add(ModBlocks.PRIXILIUM_LOG)
                .add(ModBlocks.BURNED_PRIXILIUM_LOG);

        valueLookupBuilder(BlockTags.LOGS)
                .add(ModBlocks.PRIXILIUM_LOG)
                .add(ModBlocks.PRIXILIUM_WOOD)
                .add(ModBlocks.BURNED_PRIXILIUM_LOG)
                .add(ModBlocks.BURNED_PRIXILIUM_WOOD);

        valueLookupBuilder(BlockTags.PLANKS)
                .add(ModBlocks.PRIXILIUM_PLANKS)
                .add(ModBlocks.BURNED_PRIXILIUM_PLANKS);

        valueLookupBuilder(BlockTags.SNAPS_GOAT_HORN)
                .add(ModBlocks.PRIXILIUM_LOG)
                .add(ModBlocks.PRIXILIUM_WOOD)
                .add(ModBlocks.BURNED_PRIXILIUM_LOG)
                .add(ModBlocks.BURNED_PRIXILIUM_WOOD);

        valueLookupBuilder(BlockTags.WOODEN_STAIRS)
                .add(ModBlocks.PRIXILIUM_STAIRS)
                .add(ModBlocks.BURNED_PRIXILIUM_STAIRS);

        valueLookupBuilder(BlockTags.STAIRS)
                .add(ModBlocks.PRIXILIUM_STAIRS)
                .add(ModBlocks.BURNED_PRIXILIUM_STAIRS)

                .add(ModBlocks.PRIXILIUM_BRICK_STAIRS)
                .add(ModBlocks.DARK_PRIXILIUM_BRICK_STAIRS);

        valueLookupBuilder(BlockTags.WOODEN_SLABS)
                .add(ModBlocks.PRIXILIUM_SLAB)
                .add(ModBlocks.BURNED_PRIXILIUM_SLAB);

        valueLookupBuilder(BlockTags.SLABS)
                .add(ModBlocks.PRIXILIUM_SLAB)
                .add(ModBlocks.BURNED_PRIXILIUM_SLAB)

                .add(ModBlocks.PRIXILIUM_BRICK_SLAB)
                .add(ModBlocks.DARK_PRIXILIUM_BRICK_SLAB);

        valueLookupBuilder(BlockTags.WOODEN_FENCES)
                .add(ModBlocks.PRIXILIUM_FENCE)
                .add(ModBlocks.BURNED_PRIXILIUM_FENCE);

        valueLookupBuilder(BlockTags.FENCES)
                .add(ModBlocks.PRIXILIUM_FENCE)
                .add(ModBlocks.BURNED_PRIXILIUM_FENCE);


        valueLookupBuilder(BlockTags.FENCE_GATES)
                .add(ModBlocks.PRIXILIUM_FENCE_GATE)
                .add(ModBlocks.BURNED_PRIXILIUM_FENCE_GATE);

        valueLookupBuilder(BlockTags.DOORS)
                .add(ModBlocks.PRIXILIUM_DOOR)
                .add(ModBlocks.BURNED_PRIXILIUM_DOOR);

        valueLookupBuilder(BlockTags.WOODEN_TRAPDOORS)
                .add(ModBlocks.PRIXILIUM_TRAPDOOR)
                .add(ModBlocks.BURNED_PRIXILIUM_TRAPDOOR);

        valueLookupBuilder(BlockTags.TRAPDOORS)
                .add(ModBlocks.PRIXILIUM_TRAPDOOR)
                .add(ModBlocks.BURNED_PRIXILIUM_TRAPDOOR);

        valueLookupBuilder(BlockTags.WALLS)
                .add(ModBlocks.PRIXILIUM_BRICKS_WALL)
                .add(ModBlocks.DARK_PRIXILIUM_BRICKS_WALL);
        
        valueLookupBuilder(BlockTags.INVALID_SPAWN_INSIDE)
                .add(ModBlocks.PRIXIVERSE_PORTAL);

        valueLookupBuilder(BlockTags.PORTALS)
                .add(ModBlocks.PRIXIVERSE_PORTAL);

        valueLookupBuilder(BlockTags.DRAGON_IMMUNE)
                .add(ModBlocks.PRIXIVERSE_PORTAL);

        valueLookupBuilder(BlockTags.WITHER_IMMUNE)
                .add(ModBlocks.PRIXIVERSE_PORTAL);

        // Mod Tags
        valueLookupBuilder(ModTags.Blocks.PRIXILIUM_CONVERTIBLE)
                .add(Blocks.SHORT_GRASS)
                .add(Blocks.FERN)
                .add(Blocks.BUSH)
                .add(Blocks.FIREFLY_BUSH)
                .add(Blocks.DEAD_BUSH)
                .add(Blocks.DANDELION)
                .add(Blocks.TORCHFLOWER)
                .add(Blocks.POPPY)
                .add(Blocks.BLUE_ORCHID)
                .add(Blocks.ALLIUM)
                .add(Blocks.RED_TULIP)
                .add(Blocks.ORANGE_TULIP)
                .add(Blocks.WHITE_TULIP)
                .add(Blocks.PINK_TULIP)
                .add(Blocks.OXEYE_DAISY)
                .add(Blocks.CORNFLOWER)
                .add(Blocks.AZURE_BLUET)
                .add(Blocks.LILY_OF_THE_VALLEY)
                .add(Blocks.SUNFLOWER)
                .add(Blocks.LILAC)
                .add(Blocks.ROSE_BUSH)
                .add(Blocks.PEONY)
                .add(Blocks.TALL_GRASS)
                .add(Blocks.LARGE_FERN)
                .add(Blocks.PITCHER_PLANT);

        valueLookupBuilder(ModTags.Blocks.PRIXILIUM_GRASS_CONVERTIBLE)
                .add(Blocks.DIRT)
                .add(Blocks.GRASS_BLOCK)
                .add(Blocks.PODZOL)
                .add(Blocks.MYCELIUM)
                .add(Blocks.COARSE_DIRT);

        valueLookupBuilder(ModTags.Blocks.PRIXILIUM_LOG_CONVERTIBLE)
                .add(Blocks.OAK_LOG)
                .add(Blocks.SPRUCE_LOG)
                .add(Blocks.BIRCH_LOG)
                .add(Blocks.JUNGLE_LOG)
                .add(Blocks.ACACIA_LOG)
                .add(Blocks.DARK_OAK_LOG)
                .add(Blocks.MANGROVE_LOG)
                .add(Blocks.CHERRY_LOG)
                .add(Blocks.CRIMSON_STEM)
                .add(Blocks.WARPED_STEM);

        valueLookupBuilder(ModTags.Blocks.PRIXILIUM_WOOD_CONVERTIBLE)
                .add(Blocks.OAK_WOOD)
                .add(Blocks.SPRUCE_WOOD)
                .add(Blocks.BIRCH_WOOD)
                .add(Blocks.JUNGLE_WOOD)
                .add(Blocks.ACACIA_WOOD)
                .add(Blocks.DARK_OAK_WOOD)
                .add(Blocks.MANGROVE_WOOD)
                .add(Blocks.CHERRY_WOOD);

        valueLookupBuilder(ModTags.Blocks.PRIXILIUM_LEAVES_CONVERTIBLE)
                .add(Blocks.OAK_LEAVES)
                .add(Blocks.SPRUCE_LEAVES)
                .add(Blocks.BIRCH_LEAVES)
                .add(Blocks.JUNGLE_LEAVES)
                .add(Blocks.ACACIA_LEAVES)
                .add(Blocks.DARK_OAK_LEAVES)
                .add(Blocks.MANGROVE_LEAVES)
                .add(Blocks.CHERRY_LEAVES)
                .add(Blocks.AZALEA_LEAVES)
                .add(Blocks.FLOWERING_AZALEA_LEAVES)
                .add(Blocks.NETHER_WART_BLOCK)
                .add(Blocks.WARPED_WART_BLOCK);
    }
}
