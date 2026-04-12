package net.napsternpt.prixilium.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.*;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.equipment.EquipmentModel;
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
        blockStateModelGenerator.registerSingleton(ModBlocks.PRIXILIUM_LEAVES, TexturedModel.LEAVES);

        blockStateModelGenerator.registerLog(ModBlocks.PRIXILIUM_LOG).log(ModBlocks.PRIXILIUM_LOG).wood(ModBlocks.PRIXILIUM_WOOD);
        BlockStateModelGenerator.BlockTexturePool prixiliumPlanksPool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.PRIXILIUM_PLANKS);
        prixiliumPlanksPool.stairs(ModBlocks.PRIXILIUM_STAIRS);
        prixiliumPlanksPool.slab(ModBlocks.PRIXILIUM_SLAB);
        prixiliumPlanksPool.fence(ModBlocks.PRIXILIUM_FENCE);
        prixiliumPlanksPool.fenceGate(ModBlocks.PRIXILIUM_FENCE_GATE);
        blockStateModelGenerator.registerDoor(ModBlocks.PRIXILIUM_DOOR);
        blockStateModelGenerator.registerTrapdoor(ModBlocks.PRIXILIUM_TRAPDOOR);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.PRIXILIUM_BRICKS);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.PRIXILIUM_BRICKS_WALL);

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

        blockStateModelGenerator.blockStateCollector.accept(
                BlockStateModelGenerator.createSingletonBlockState(
                        ModBlocks.VIRUS_REACTOR,
                        Identifier.of(Prixilium.MOD_ID, "block/virus_reactor")
                )
        );
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        //hook and bow made by hand
        itemModelGenerator.register(ModItems.PRIXILIUM_VIRUS_ALIVE, Models.GENERATED);
        itemModelGenerator.register(ModItems.PRIXILIUM_VIRUS_DEAD, Models.GENERATED);
        itemModelGenerator.register(ModItems.PRIXILIUM_UPGRADE_SMITHING_TEMPLATE, Models.GENERATED);
        itemModelGenerator.register(ModItems.BLIKO_SPAWN_EGG, new Model(Optional.of(Identifier.of("item/template_spawn_egg")), Optional.empty()));

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
        itemModelGenerator.registerArmor(ModItems.PRIXILED_LEATHER_HELMET, Identifier.of(Prixilium.MOD_ID, "prixiled_leather"),
                EquipmentModel.builder().addHumanoidLayers(Identifier.of(Prixilium.MOD_ID, "prixiled_leather")).build(), EquipmentSlot.HEAD);
        itemModelGenerator.registerArmor(ModItems.PRIXILED_LEATHER_CHESTPLATE, Identifier.of(Prixilium.MOD_ID, "prixiled_leather"),
                EquipmentModel.builder().addHumanoidLayers(Identifier.of(Prixilium.MOD_ID, "prixiled_leather")).build(), EquipmentSlot.CHEST);
        itemModelGenerator.registerArmor(ModItems.PRIXILED_LEATHER_LEGGINGS, Identifier.of(Prixilium.MOD_ID, "prixiled_leather"),
                EquipmentModel.builder().addHumanoidLayers(Identifier.of(Prixilium.MOD_ID, "prixiled_leather")).build(), EquipmentSlot.LEGS);
        itemModelGenerator.registerArmor(ModItems.PRIXILED_LEATHER_BOOTS, Identifier.of(Prixilium.MOD_ID, "prixiled_leather"),
                EquipmentModel.builder().addHumanoidLayers(Identifier.of(Prixilium.MOD_ID, "prixiled_leather")).build(), EquipmentSlot.FEET);
        //endregion

        //region [chainmail]
        itemModelGenerator.registerArmor(ModItems.PRIXILED_CHAINMAIL_HELMET, Identifier.of(Prixilium.MOD_ID, "prixiled_chainmail"),
                EquipmentModel.builder().addHumanoidLayers(Identifier.of(Prixilium.MOD_ID, "prixiled_chainmail")).build(), EquipmentSlot.HEAD);
        itemModelGenerator.registerArmor(ModItems.PRIXILED_CHAINMAIL_CHESTPLATE, Identifier.of(Prixilium.MOD_ID, "prixiled_chainmail"),
                EquipmentModel.builder().addHumanoidLayers(Identifier.of(Prixilium.MOD_ID, "prixiled_chainmail")).build(), EquipmentSlot.CHEST);
        itemModelGenerator.registerArmor(ModItems.PRIXILED_CHAINMAIL_LEGGINGS, Identifier.of(Prixilium.MOD_ID, "prixiled_chainmail"),
                EquipmentModel.builder().addHumanoidLayers(Identifier.of(Prixilium.MOD_ID, "prixiled_chainmail")).build(), EquipmentSlot.LEGS);
        itemModelGenerator.registerArmor(ModItems.PRIXILED_CHAINMAIL_BOOTS, Identifier.of(Prixilium.MOD_ID, "prixiled_chainmail"),
                EquipmentModel.builder().addHumanoidLayers(Identifier.of(Prixilium.MOD_ID, "prixiled_chainmail")).build(), EquipmentSlot.FEET);
        //endregion

        //region [copper]
        /* 1.21.9+
        itemModelGenerator.registerArmor(ModItems.PRIXILED_COPPER_HELMET, Identifier.of(Prixilium.MOD_ID, "prixiled_copper"),
                EquipmentModel.builder().addHumanoidLayers(Identifier.of(Prixilium.MOD_ID, "prixiled_copper")).build(), EquipmentSlot.HEAD);
        itemModelGenerator.registerArmor(ModItems.PRIXILED_COPPER_CHESTPLATE, Identifier.of(Prixilium.MOD_ID, "prixiled_copper"),
                EquipmentModel.builder().addHumanoidLayers(Identifier.of(Prixilium.MOD_ID, "prixiled_copper")).build(), EquipmentSlot.CHEST);
        itemModelGenerator.registerArmor(ModItems.PRIXILED_COPPER_LEGGINGS, Identifier.of(Prixilium.MOD_ID, "prixiled_copper"),
                EquipmentModel.builder().addHumanoidLayers(Identifier.of(Prixilium.MOD_ID, "prixiled_copper")).build(), EquipmentSlot.LEGS);
        itemModelGenerator.registerArmor(ModItems.PRIXILED_COPPER_BOOTS, Identifier.of(Prixilium.MOD_ID, "prixiled_copper"),
                EquipmentModel.builder().addHumanoidLayers(Identifier.of(Prixilium.MOD_ID, "prixiled_copper")).build(), EquipmentSlot.FEET);
         */
        //endregion

        //region [iron]
        itemModelGenerator.registerArmor(ModItems.PRIXILED_IRON_HELMET, Identifier.of(Prixilium.MOD_ID, "prixiled_iron"),
                EquipmentModel.builder().addHumanoidLayers(Identifier.of(Prixilium.MOD_ID, "prixiled_iron")).build(), EquipmentSlot.HEAD);
        itemModelGenerator.registerArmor(ModItems.PRIXILED_IRON_CHESTPLATE, Identifier.of(Prixilium.MOD_ID, "prixiled_iron"),
                EquipmentModel.builder().addHumanoidLayers(Identifier.of(Prixilium.MOD_ID, "prixiled_iron")).build(), EquipmentSlot.CHEST);
        itemModelGenerator.registerArmor(ModItems.PRIXILED_IRON_LEGGINGS, Identifier.of(Prixilium.MOD_ID, "prixiled_iron"),
                EquipmentModel.builder().addHumanoidLayers(Identifier.of(Prixilium.MOD_ID, "prixiled_iron")).build(), EquipmentSlot.LEGS);
        itemModelGenerator.registerArmor(ModItems.PRIXILED_IRON_BOOTS, Identifier.of(Prixilium.MOD_ID, "prixiled_iron"),
                EquipmentModel.builder().addHumanoidLayers(Identifier.of(Prixilium.MOD_ID, "prixiled_iron")).build(), EquipmentSlot.FEET);
        //endregion

        //region [golden]
        itemModelGenerator.registerArmor(ModItems.PRIXILED_GOLDEN_HELMET, Identifier.of(Prixilium.MOD_ID, "prixiled_golden"),
                EquipmentModel.builder().addHumanoidLayers(Identifier.of(Prixilium.MOD_ID, "prixiled_golden")).build(), EquipmentSlot.HEAD);
        itemModelGenerator.registerArmor(ModItems.PRIXILED_GOLDEN_CHESTPLATE, Identifier.of(Prixilium.MOD_ID, "prixiled_golden"),
                EquipmentModel.builder().addHumanoidLayers(Identifier.of(Prixilium.MOD_ID, "prixiled_golden")).build(), EquipmentSlot.CHEST);
        itemModelGenerator.registerArmor(ModItems.PRIXILED_GOLDEN_LEGGINGS, Identifier.of(Prixilium.MOD_ID, "prixiled_golden"),
                EquipmentModel.builder().addHumanoidLayers(Identifier.of(Prixilium.MOD_ID, "prixiled_golden")).build(), EquipmentSlot.LEGS);
        itemModelGenerator.registerArmor(ModItems.PRIXILED_GOLDEN_BOOTS, Identifier.of(Prixilium.MOD_ID, "prixiled_golden"),
                EquipmentModel.builder().addHumanoidLayers(Identifier.of(Prixilium.MOD_ID, "prixiled_golden")).build(), EquipmentSlot.FEET);
        //endregion

        //region [diamond]
        itemModelGenerator.registerArmor(ModItems.PRIXILED_DIAMOND_HELMET, Identifier.of(Prixilium.MOD_ID, "prixiled_diamond"),
                EquipmentModel.builder().addHumanoidLayers(Identifier.of(Prixilium.MOD_ID, "prixiled_diamond")).build(), EquipmentSlot.HEAD);
        itemModelGenerator.registerArmor(ModItems.PRIXILED_DIAMOND_CHESTPLATE, Identifier.of(Prixilium.MOD_ID, "prixiled_diamond"),
                EquipmentModel.builder().addHumanoidLayers(Identifier.of(Prixilium.MOD_ID, "prixiled_diamond")).build(), EquipmentSlot.CHEST);
        itemModelGenerator.registerArmor(ModItems.PRIXILED_DIAMOND_LEGGINGS, Identifier.of(Prixilium.MOD_ID, "prixiled_diamond"),
                EquipmentModel.builder().addHumanoidLayers(Identifier.of(Prixilium.MOD_ID, "prixiled_diamond")).build(), EquipmentSlot.LEGS);
        itemModelGenerator.registerArmor(ModItems.PRIXILED_DIAMOND_BOOTS, Identifier.of(Prixilium.MOD_ID, "prixiled_diamond"),
                EquipmentModel.builder().addHumanoidLayers(Identifier.of(Prixilium.MOD_ID, "prixiled_diamond")).build(), EquipmentSlot.FEET);
        //endregion

        //region [netherite]
        itemModelGenerator.registerArmor(ModItems.PRIXILED_NETHERITE_HELMET, Identifier.of(Prixilium.MOD_ID, "prixiled_netherite"),
                EquipmentModel.builder().addHumanoidLayers(Identifier.of(Prixilium.MOD_ID, "prixiled_netherite")).build(), EquipmentSlot.HEAD);
        itemModelGenerator.registerArmor(ModItems.PRIXILED_NETHERITE_CHESTPLATE, Identifier.of(Prixilium.MOD_ID, "prixiled_netherite"),
                EquipmentModel.builder().addHumanoidLayers(Identifier.of(Prixilium.MOD_ID, "prixiled_netherite")).build(), EquipmentSlot.CHEST);
        itemModelGenerator.registerArmor(ModItems.PRIXILED_NETHERITE_LEGGINGS, Identifier.of(Prixilium.MOD_ID, "prixiled_netherite"),
                EquipmentModel.builder().addHumanoidLayers(Identifier.of(Prixilium.MOD_ID, "prixiled_netherite")).build(), EquipmentSlot.LEGS);
        itemModelGenerator.registerArmor(ModItems.PRIXILED_NETHERITE_BOOTS, Identifier.of(Prixilium.MOD_ID, "prixiled_netherite"),
                EquipmentModel.builder().addHumanoidLayers(Identifier.of(Prixilium.MOD_ID, "prixiled_netherite")).build(), EquipmentSlot.FEET);
        //endregion

        //region [turtle]
        itemModelGenerator.registerArmor(ModItems.PRIXILED_TURTLE_HELMET, Identifier.of(Prixilium.MOD_ID, "prixiled_turtle"),
                EquipmentModel.builder().addHumanoidLayers(Identifier.of(Prixilium.MOD_ID, "prixiled_turtle")).build(), EquipmentSlot.HEAD);
        //endregion
        //endregion

        //region [horse]
        itemModelGenerator.register(ModItems.PRIXILED_LEATHER_HORSE_ARMOR, Models.GENERATED);
        // 1.21.9+ itemModelGenerator.register(ModItems.PRIXILED_COPPER_HORSE_ARMOR, Models.GENERATED);
        itemModelGenerator.register(ModItems.PRIXILED_IRON_HORSE_ARMOR, Models.GENERATED);
        itemModelGenerator.register(ModItems.PRIXILED_GOLDEN_HORSE_ARMOR, Models.GENERATED);
        itemModelGenerator.register(ModItems.PRIXILED_DIAMOND_HORSE_ARMOR, Models.GENERATED);
        // 1.21.11+ itemModelGenerator.register(ModItems.PRIXILED_NETHERITE_HORSE_ARMOR, Models.GENERATED);
        //endregion
    }
}
