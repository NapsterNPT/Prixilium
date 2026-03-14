package net.napsternpt.prixilium.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.*;
import net.minecraft.item.ArmorItem;
import net.minecraft.util.Identifier;
import net.napsternpt.prixilium.Prixilium;
import net.napsternpt.prixilium.block.ModBlocks;
import net.napsternpt.prixilium.block.custom.PrixiliumLampBlock;
import net.napsternpt.prixilium.item.ModItems;

import java.util.Optional;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerTintableCross(ModBlocks.PRIXILIUM, BlockStateModelGenerator.TintType.NOT_TINTED);

        TextureMap prixiliumGrassBaseModel = new TextureMap()
                .put(TextureKey.SIDE, TextureMap.getSubId(ModBlocks.PRIXILIUM_GRASS, "_side"))
                .put(TextureKey.BOTTOM, TextureMap.getSubId(ModBlocks.PRIXILIUM_GRASS, "_bottom"));

        Identifier prixiliumGrassModel1 = Models.CUBE_BOTTOM_TOP.upload(ModBlocks.PRIXILIUM_GRASS, "_1",
                prixiliumGrassBaseModel.copyAndAdd(TextureKey.TOP, TextureMap.getSubId(ModBlocks.PRIXILIUM_GRASS, "_top_1")),
                blockStateModelGenerator.modelCollector);

        Identifier prixiliumGrassModel2 = Models.CUBE_BOTTOM_TOP.upload(ModBlocks.PRIXILIUM_GRASS, "_2",
                prixiliumGrassBaseModel.copyAndAdd(TextureKey.TOP, TextureMap.getSubId(ModBlocks.PRIXILIUM_GRASS, "_top_2")),
                blockStateModelGenerator.modelCollector);

        Identifier prixiliumGrassModel3 = Models.CUBE_BOTTOM_TOP.upload(ModBlocks.PRIXILIUM_GRASS, "_3",
                prixiliumGrassBaseModel.copyAndAdd(TextureKey.TOP, TextureMap.getSubId(ModBlocks.PRIXILIUM_GRASS, "_top_3")),
                blockStateModelGenerator.modelCollector);

        Identifier prixiliumGrassModel4 = Models.CUBE_BOTTOM_TOP.upload(ModBlocks.PRIXILIUM_GRASS, "_4",
                prixiliumGrassBaseModel.copyAndAdd(TextureKey.TOP, TextureMap.getSubId(ModBlocks.PRIXILIUM_GRASS, "_top_4")),
                blockStateModelGenerator.modelCollector);

        blockStateModelGenerator.blockStateCollector.accept(
                VariantsBlockStateSupplier.create(ModBlocks.PRIXILIUM_GRASS,
                        BlockStateVariant.create().put(VariantSettings.MODEL, prixiliumGrassModel1),
                        BlockStateVariant.create().put(VariantSettings.MODEL, prixiliumGrassModel2),
                        BlockStateVariant.create().put(VariantSettings.MODEL, prixiliumGrassModel3),
                        BlockStateVariant.create().put(VariantSettings.MODEL, prixiliumGrassModel4)
                )
        );

        blockStateModelGenerator.registerParentedItemModel(ModBlocks.PRIXILIUM_GRASS, prixiliumGrassModel1);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.PRIXILIUM_LEAVES);

        blockStateModelGenerator.registerLog(ModBlocks.PRIXILIUM_LOG).log(ModBlocks.PRIXILIUM_LOG).wood(ModBlocks.PRIXILIUM_WOOD);
        BlockStateModelGenerator.BlockTexturePool prixiliumPlanksPool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.PRIXILIUM_PLANKS);
        prixiliumPlanksPool.stairs(ModBlocks.PRIXILIUM_STAIRS);
        prixiliumPlanksPool.slab(ModBlocks.PRIXILIUM_SLAB);
        prixiliumPlanksPool.fence(ModBlocks.PRIXILIUM_FENCE);
        prixiliumPlanksPool.fenceGate(ModBlocks.PRIXILIUM_FENCE_GATE);
        blockStateModelGenerator.registerDoor(ModBlocks.PRIXILIUM_DOOR);
        blockStateModelGenerator.registerTrapdoor(ModBlocks.PRIXILIUM_TRAPDOOR);

        BlockStateModelGenerator.BlockTexturePool prixiliumBricksPool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.PRIXILIUM_BRICKS);
        prixiliumBricksPool.wall(ModBlocks.PRIXILIUM_BRICKS_WALL);

        Identifier lamp0Identifier = TexturedModel.CUBE_ALL.upload(ModBlocks.PRIXILIUM_LAMP, blockStateModelGenerator.modelCollector);
        Identifier lamp1Identifier = blockStateModelGenerator.createSubModel(ModBlocks.PRIXILIUM_LAMP, "_1", Models.CUBE_ALL, TextureMap::all);
        Identifier lamp2Identifier = blockStateModelGenerator.createSubModel(ModBlocks.PRIXILIUM_LAMP, "_2", Models.CUBE_ALL, TextureMap::all);
        Identifier lamp3Identifier = blockStateModelGenerator.createSubModel(ModBlocks.PRIXILIUM_LAMP, "_3", Models.CUBE_ALL, TextureMap::all);
        Identifier lamp4Identifier = blockStateModelGenerator.createSubModel(ModBlocks.PRIXILIUM_LAMP, "_4", Models.CUBE_ALL, TextureMap::all);
        Identifier lamp5Identifier = blockStateModelGenerator.createSubModel(ModBlocks.PRIXILIUM_LAMP, "_5", Models.CUBE_ALL, TextureMap::all);
        Identifier lamp6Identifier = blockStateModelGenerator.createSubModel(ModBlocks.PRIXILIUM_LAMP, "_6", Models.CUBE_ALL, TextureMap::all);
        Identifier lamp7Identifier = blockStateModelGenerator.createSubModel(ModBlocks.PRIXILIUM_LAMP, "_7", Models.CUBE_ALL, TextureMap::all);
        Identifier lamp8Identifier = blockStateModelGenerator.createSubModel(ModBlocks.PRIXILIUM_LAMP, "_8", Models.CUBE_ALL, TextureMap::all);
        Identifier lamp9Identifier = blockStateModelGenerator.createSubModel(ModBlocks.PRIXILIUM_LAMP, "_9", Models.CUBE_ALL, TextureMap::all);
        Identifier lamp10Identifier = blockStateModelGenerator.createSubModel(ModBlocks.PRIXILIUM_LAMP, "_10", Models.CUBE_ALL, TextureMap::all);
        Identifier lamp11Identifier = blockStateModelGenerator.createSubModel(ModBlocks.PRIXILIUM_LAMP, "_11", Models.CUBE_ALL, TextureMap::all);
        Identifier lamp12Identifier = blockStateModelGenerator.createSubModel(ModBlocks.PRIXILIUM_LAMP, "_12", Models.CUBE_ALL, TextureMap::all);
        Identifier lamp13Identifier = blockStateModelGenerator.createSubModel(ModBlocks.PRIXILIUM_LAMP, "_13", Models.CUBE_ALL, TextureMap::all);
        Identifier lamp14Identifier = blockStateModelGenerator.createSubModel(ModBlocks.PRIXILIUM_LAMP, "_14", Models.CUBE_ALL, TextureMap::all);
        Identifier lamp15Identifier = blockStateModelGenerator.createSubModel(ModBlocks.PRIXILIUM_LAMP, "_15", Models.CUBE_ALL, TextureMap::all);

        blockStateModelGenerator.blockStateCollector.accept(VariantsBlockStateSupplier.create(ModBlocks.PRIXILIUM_LAMP)
                .coordinate(BlockStateVariantMap.create(PrixiliumLampBlock.LIGHT)
                        .register(0, BlockStateVariant.create().put(VariantSettings.MODEL, lamp0Identifier))
                        .register(1, BlockStateVariant.create().put(VariantSettings.MODEL, lamp1Identifier))
                        .register(2, BlockStateVariant.create().put(VariantSettings.MODEL, lamp2Identifier))
                        .register(3, BlockStateVariant.create().put(VariantSettings.MODEL, lamp3Identifier))
                        .register(4, BlockStateVariant.create().put(VariantSettings.MODEL, lamp4Identifier))
                        .register(5, BlockStateVariant.create().put(VariantSettings.MODEL, lamp5Identifier))
                        .register(6, BlockStateVariant.create().put(VariantSettings.MODEL, lamp6Identifier))
                        .register(7, BlockStateVariant.create().put(VariantSettings.MODEL, lamp7Identifier))
                        .register(8, BlockStateVariant.create().put(VariantSettings.MODEL, lamp8Identifier))
                        .register(9, BlockStateVariant.create().put(VariantSettings.MODEL, lamp9Identifier))
                        .register(10, BlockStateVariant.create().put(VariantSettings.MODEL, lamp10Identifier))
                        .register(11, BlockStateVariant.create().put(VariantSettings.MODEL, lamp11Identifier))
                        .register(12, BlockStateVariant.create().put(VariantSettings.MODEL, lamp12Identifier))
                        .register(13, BlockStateVariant.create().put(VariantSettings.MODEL, lamp13Identifier))
                        .register(14, BlockStateVariant.create().put(VariantSettings.MODEL, lamp14Identifier))
                        .register(15, BlockStateVariant.create().put(VariantSettings.MODEL, lamp15Identifier))
                )
        );
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.PRIXILIUM_VIRUS_ALIVE, Models.GENERATED);
        itemModelGenerator.register(ModItems.PRIXILIUM_VIRUS_DEAD, Models.GENERATED);
        itemModelGenerator.register(ModItems.PRIXILIUM_UPGRADE_SMITHING_TEMPLATE, Models.GENERATED);
        itemModelGenerator.register(ModItems.PRIXILIUM_HOOK, Models.HANDHELD);

        //region [Tools]

        //region [wood]
        itemModelGenerator.register(ModItems.PRIXILED_WOODEN_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.PRIXILED_WOODEN_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.PRIXILED_WOODEN_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.PRIXILED_WOODEN_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.PRIXILED_WOODEN_HOE, Models.HANDHELD);
        //endregion

        //region [stone]
        itemModelGenerator.register(ModItems.PRIXILED_STONE_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.PRIXILED_STONE_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.PRIXILED_STONE_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.PRIXILED_STONE_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.PRIXILED_STONE_HOE, Models.HANDHELD);
        //endregion

        //region [copper]
        /* 1.21.9+
        itemModelGenerator.register(ModItems.PRIXILED_COPPER_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.PRIXILED_COPPER_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.PRIXILED_COPPER_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.PRIXILED_COPPER_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.PRIXILED_COPPER_HOE, Models.HANDHELD);
        */
        //endregion

        //region [iron]
        itemModelGenerator.register(ModItems.PRIXILED_IRON_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.PRIXILED_IRON_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.PRIXILED_IRON_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.PRIXILED_IRON_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.PRIXILED_IRON_HOE, Models.HANDHELD);
        //endregion

        //region [gold]
        itemModelGenerator.register(ModItems.PRIXILED_GOLDEN_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.PRIXILED_GOLDEN_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.PRIXILED_GOLDEN_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.PRIXILED_GOLDEN_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.PRIXILED_GOLDEN_HOE, Models.HANDHELD);
        //endregion

        //region [diamond]
        itemModelGenerator.register(ModItems.PRIXILED_DIAMOND_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.PRIXILED_DIAMOND_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.PRIXILED_DIAMOND_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.PRIXILED_DIAMOND_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.PRIXILED_DIAMOND_HOE, Models.HANDHELD);
        //endregion

        //region [netherite]
        itemModelGenerator.register(ModItems.PRIXILED_NETHERITE_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.PRIXILED_NETHERITE_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.PRIXILED_NETHERITE_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.PRIXILED_NETHERITE_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.PRIXILED_NETHERITE_HOE, Models.HANDHELD);
        //endregion

        itemModelGenerator.register(ModItems.PRIXILED_MACE, Models.HANDHELD);

        //endregion

        //region [Armors]

        //region [leather]
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.PRIXILED_LEATHER_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.PRIXILED_LEATHER_CHESTPLATE));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.PRIXILED_LEATHER_LEGGINGS));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.PRIXILED_LEATHER_BOOTS));
        //endregion

        //region [chainmail]
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.PRIXILED_CHAINMAIL_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.PRIXILED_CHAINMAIL_CHESTPLATE));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.PRIXILED_CHAINMAIL_LEGGINGS));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.PRIXILED_CHAINMAIL_BOOTS));
        //endregion

        //region [copper]
        /* 1.21.9+
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.PRIXILED_COPPER_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.PRIXILED_COPPER_CHESTPLATE));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.PRIXILED_COPPER_LEGGINGS));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.PRIXILED_COPPER_BOOTS));
         */
        //endregion

        //region [iron]
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.PRIXILED_IRON_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.PRIXILED_IRON_CHESTPLATE));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.PRIXILED_IRON_LEGGINGS));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.PRIXILED_IRON_BOOTS));
        //endregion

        //region [golden]
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.PRIXILED_GOLDEN_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.PRIXILED_GOLDEN_CHESTPLATE));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.PRIXILED_GOLDEN_LEGGINGS));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.PRIXILED_GOLDEN_BOOTS));
        //endregion

        //region [diamond]
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.PRIXILED_DIAMOND_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.PRIXILED_DIAMOND_CHESTPLATE));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.PRIXILED_DIAMOND_LEGGINGS));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.PRIXILED_DIAMOND_BOOTS));
        //endregion

        //region [netherite]
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.PRIXILED_NETHERITE_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.PRIXILED_NETHERITE_CHESTPLATE));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.PRIXILED_NETHERITE_LEGGINGS));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.PRIXILED_NETHERITE_BOOTS));
        //endregion

        //region [turtle]
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.PRIXILED_TURTLE_HELMET));
        //endregion

        //region [horse]
        itemModelGenerator.register(ModItems.PRIXILED_LEATHER_HORSE_ARMOR, Models.GENERATED);
        // 1.21.9+ itemModelGenerator.register(ModItems.PRIXILED_COPPER_HORSE_ARMOR, Models.GENERATED);
        itemModelGenerator.register(ModItems.PRIXILED_IRON_HORSE_ARMOR, Models.GENERATED);
        itemModelGenerator.register(ModItems.PRIXILED_GOLDEN_HORSE_ARMOR, Models.GENERATED);
        itemModelGenerator.register(ModItems.PRIXILED_DIAMOND_HORSE_ARMOR, Models.GENERATED);
        // 1.21.11+ itemModelGenerator.register(ModItems.PRIXILED_NETHERITE_HORSE_ARMOR, Models.GENERATED);
        //endregion

        //endregion
    }
}
