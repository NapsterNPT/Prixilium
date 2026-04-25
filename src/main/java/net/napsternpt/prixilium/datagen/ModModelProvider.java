package net.napsternpt.prixilium.datagen;

import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.client.data.*;
import net.minecraft.client.item.ItemAsset;
import net.minecraft.client.render.item.model.ConditionItemModel;
import net.minecraft.client.render.item.model.ItemModel;
import net.minecraft.client.render.item.property.bool.HasComponentProperty;
import net.minecraft.util.Identifier;
import net.napsternpt.prixilium.Prixilium;
import net.napsternpt.prixilium.block.ModBlocks;
import net.napsternpt.prixilium.block.custom.PrixiliumLampBlock;
import net.napsternpt.prixilium.component.ModDataComponentTypes;
import net.napsternpt.prixilium.item.ModArmorMaterials;
import net.napsternpt.prixilium.item.ModItems;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerTintableCross(ModBlocks.PRIXILIUM, BlockStateModelGenerator.CrossType.NOT_TINTED);

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
                        ModBlocks.STAND,
                        Identifier.of(Prixilium.MOD_ID, "block/stand")
                )
        );
        blockStateModelGenerator.blockStateCollector.accept(
                BlockStateModelGenerator.createSingletonBlockState(
                        ModBlocks.REACTOR_CORE,
                        Identifier.of(Prixilium.MOD_ID, "block/reactor_core")
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
        itemModelGenerator.register(ModItems.VIRUS_ALIVE, Models.GENERATED);
        itemModelGenerator.register(ModItems.VIRUS_DEAD, Models.GENERATED);
        itemModelGenerator.register(ModItems.THERMOMETER, Models.HANDHELD);
        itemModelGenerator.register(ModItems.PRIXILIUM_UPGRADE_SMITHING_TEMPLATE, Models.GENERATED);
        itemModelGenerator.register(ModItems.PRIXILIUM_CHARM_I, Models.GENERATED);
        itemModelGenerator.register(ModItems.PRIXILIUM_TRANSFER_CHARM_I, Models.GENERATED);
        itemModelGenerator.register(ModItems.PRIXILIUM_CONTAINER_CHARM_I, Models.GENERATED);
        itemModelGenerator.register(ModItems.PRIXILIUM_ROLLBACK_CHARM_I, Models.GENERATED);
        itemModelGenerator.register(ModItems.PRIXILIUM_REGENERATION_CHARM_I, Models.GENERATED);
        itemModelGenerator.register(ModItems.PRIXILIUM_CHARM_II, Models.GENERATED);
        itemModelGenerator.register(ModItems.PRIXILIUM_TRANSFER_CHARM_II, Models.GENERATED);
        itemModelGenerator.register(ModItems.PRIXILIUM_CONTAINER_CHARM_II, Models.GENERATED);
        itemModelGenerator.register(ModItems.PRIXILIUM_ROLLBACK_CHARM_II, Models.GENERATED);
        itemModelGenerator.register(ModItems.PRIXILIUM_REGENERATION_CHARM_II, Models.GENERATED);
        itemModelGenerator.register(ModItems.PRIXILIUM_CHARM_III, Models.GENERATED);
        itemModelGenerator.register(ModItems.PRIXILIUM_TRANSFER_CHARM_III, Models.GENERATED);
        itemModelGenerator.register(ModItems.PRIXILIUM_CONTAINER_CHARM_III, Models.GENERATED);
        itemModelGenerator.register(ModItems.PRIXILIUM_ROLLBACK_CHARM_III, Models.GENERATED);
        itemModelGenerator.register(ModItems.PRIXILIUM_REGENERATION_CHARM_III, Models.GENERATED);
        itemModelGenerator.registerSpawnEgg(ModItems.BLIKO_SPAWN_EGG, 0xffe995, 0xffcb00);
        itemModelGenerator.registerSpawnEgg(ModItems.BLOKITO_SPAWN_EGG, 0xffcb00, 0x8f7200);
        itemModelGenerator.registerSpawnEgg(ModItems.AIRIS_SPAWN_EGG, 0x7afff3, 0xffcb00);

        //region [Tools]

        //region [Prixiled]
        itemModelGenerator.register(ModItems.PRIXILED_WOODEN_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.PRIXILED_WOODEN_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.PRIXILED_WOODEN_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.PRIXILED_WOODEN_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.PRIXILED_WOODEN_HOE, Models.HANDHELD);

        itemModelGenerator.register(ModItems.PRIXILED_STONE_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.PRIXILED_STONE_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.PRIXILED_STONE_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.PRIXILED_STONE_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.PRIXILED_STONE_HOE, Models.HANDHELD);

        /* 1.21.9+
        itemModelGenerator.register(ModItems.PRIXILED_COPPER_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.PRIXILED_COPPER_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.PRIXILED_COPPER_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.PRIXILED_COPPER_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.PRIXILED_COPPER_HOE, Models.HANDHELD);
        */

        itemModelGenerator.register(ModItems.PRIXILED_IRON_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.PRIXILED_IRON_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.PRIXILED_IRON_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.PRIXILED_IRON_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.PRIXILED_IRON_HOE, Models.HANDHELD);

        itemModelGenerator.register(ModItems.PRIXILED_GOLDEN_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.PRIXILED_GOLDEN_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.PRIXILED_GOLDEN_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.PRIXILED_GOLDEN_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.PRIXILED_GOLDEN_HOE, Models.HANDHELD);

        itemModelGenerator.register(ModItems.PRIXILED_DIAMOND_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.PRIXILED_DIAMOND_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.PRIXILED_DIAMOND_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.PRIXILED_DIAMOND_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.PRIXILED_DIAMOND_HOE, Models.HANDHELD);

        itemModelGenerator.register(ModItems.PRIXILED_NETHERITE_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.PRIXILED_NETHERITE_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.PRIXILED_NETHERITE_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.PRIXILED_NETHERITE_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.PRIXILED_NETHERITE_HOE, Models.HANDHELD);
        //endregion

        itemModelGenerator.register(ModItems.PRIXILED_MACE, Models.HANDHELD_MACE);
        itemModelGenerator.upload(ModItems.PRIXILED_BOW, Models.BOW);
        itemModelGenerator.registerBow(ModItems.PRIXILED_BOW);

        ItemModel.Unbaked unbakedPrixiliumHook = ItemModels.basic(itemModelGenerator.upload(ModItems.PRIXILIUM_HOOK, Models.HANDHELD));
        ItemModel.Unbaked unbakedExtendedPrixiliumHook = ItemModels.basic(itemModelGenerator.registerSubModel(ModItems.PRIXILIUM_HOOK, "_extended", Models.HANDHELD));
        itemModelGenerator.output.accept(ModItems.PRIXILIUM_HOOK,
                new ItemAsset(new ConditionItemModel.Unbaked(new HasComponentProperty(ModDataComponentTypes.HOOK_ACTIVE, false),
                        unbakedExtendedPrixiliumHook, unbakedPrixiliumHook),
                        new ItemAsset.Properties(false)).model());

        //endregion

        //region [Armors]

        itemModelGenerator.registerArmor(ModItems.PRIXILED_LEATHER_HELMET, ModArmorMaterials.PRIXILIUM_LEATHER_KEY, "helmet", true);
        itemModelGenerator.registerArmor(ModItems.PRIXILED_LEATHER_CHESTPLATE, ModArmorMaterials.PRIXILIUM_LEATHER_KEY, "chestplate", true);
        itemModelGenerator.registerArmor(ModItems.PRIXILED_LEATHER_LEGGINGS, ModArmorMaterials.PRIXILIUM_LEATHER_KEY, "leggings", true);
        itemModelGenerator.registerArmor(ModItems.PRIXILED_LEATHER_BOOTS, ModArmorMaterials.PRIXILIUM_LEATHER_KEY, "boots", true);

        itemModelGenerator.registerArmor(ModItems.PRIXILED_CHAINMAIL_HELMET, ModArmorMaterials.PRIXILIUM_CHAIN_KEY, "helmet", false);
        itemModelGenerator.registerArmor(ModItems.PRIXILED_CHAINMAIL_CHESTPLATE, ModArmorMaterials.PRIXILIUM_CHAIN_KEY, "chestplate", false);
        itemModelGenerator.registerArmor(ModItems.PRIXILED_CHAINMAIL_LEGGINGS, ModArmorMaterials.PRIXILIUM_CHAIN_KEY, "leggings", false);
        itemModelGenerator.registerArmor(ModItems.PRIXILED_CHAINMAIL_BOOTS, ModArmorMaterials.PRIXILIUM_CHAIN_KEY, "boots", false);

        /* 1.21.9+

        itemModelGenerator.registerArmor(ModItems.PRIXILED_COPPER_HELMET, ModArmorMaterials.PRIXILIUM_COPPER_KEY, "helmet", false);
        itemModelGenerator.registerArmor(ModItems.PRIXILED_COPPER_CHESTPLATE, ModArmorMaterials.PRIXILIUM_COPPER_KEY, "chestplate", false);
        itemModelGenerator.registerArmor(ModItems.PRIXILED_COPPER_LEGGINGS, ModArmorMaterials.PRIXILIUM_COPPER_KEY, "leggings", false);
        itemModelGenerator.registerArmor(ModItems.PRIXILED_COPPER_BOOTS, ModArmorMaterials.PRIXILIUM_COPPER_KEY, "boots", false);
         */

        itemModelGenerator.registerArmor(ModItems.PRIXILED_IRON_HELMET, ModArmorMaterials.PRIXILIUM_IRON_KEY, "helmet", false);
        itemModelGenerator.registerArmor(ModItems.PRIXILED_IRON_CHESTPLATE, ModArmorMaterials.PRIXILIUM_IRON_KEY, "chestplate", false);
        itemModelGenerator.registerArmor(ModItems.PRIXILED_IRON_LEGGINGS, ModArmorMaterials.PRIXILIUM_IRON_KEY, "leggings", false);
        itemModelGenerator.registerArmor(ModItems.PRIXILED_IRON_BOOTS, ModArmorMaterials.PRIXILIUM_IRON_KEY, "boots", false);

        itemModelGenerator.registerArmor(ModItems.PRIXILED_GOLDEN_HELMET, ModArmorMaterials.PRIXILIUM_GOLD_KEY, "helmet", false);
        itemModelGenerator.registerArmor(ModItems.PRIXILED_GOLDEN_CHESTPLATE, ModArmorMaterials.PRIXILIUM_GOLD_KEY, "chestplate", false);
        itemModelGenerator.registerArmor(ModItems.PRIXILED_GOLDEN_LEGGINGS, ModArmorMaterials.PRIXILIUM_GOLD_KEY, "leggings", false);
        itemModelGenerator.registerArmor(ModItems.PRIXILED_GOLDEN_BOOTS, ModArmorMaterials.PRIXILIUM_GOLD_KEY, "boots", false);

        itemModelGenerator.registerArmor(ModItems.PRIXILED_DIAMOND_HELMET, ModArmorMaterials.PRIXILIUM_DIAMOND_KEY, "helmet", false);
        itemModelGenerator.registerArmor(ModItems.PRIXILED_DIAMOND_CHESTPLATE, ModArmorMaterials.PRIXILIUM_DIAMOND_KEY, "chestplate", false);
        itemModelGenerator.registerArmor(ModItems.PRIXILED_DIAMOND_LEGGINGS, ModArmorMaterials.PRIXILIUM_DIAMOND_KEY, "leggings", false);
        itemModelGenerator.registerArmor(ModItems.PRIXILED_DIAMOND_BOOTS, ModArmorMaterials.PRIXILIUM_DIAMOND_KEY, "boots", false);

        itemModelGenerator.registerArmor(ModItems.PRIXILED_NETHERITE_HELMET, ModArmorMaterials.PRIXILIUM_NETHERITE_KEY, "helmet", false);
        itemModelGenerator.registerArmor(ModItems.PRIXILED_NETHERITE_CHESTPLATE, ModArmorMaterials.PRIXILIUM_NETHERITE_KEY, "chestplate", false);
        itemModelGenerator.registerArmor(ModItems.PRIXILED_NETHERITE_LEGGINGS, ModArmorMaterials.PRIXILIUM_NETHERITE_KEY, "leggings", false);
        itemModelGenerator.registerArmor(ModItems.PRIXILED_NETHERITE_BOOTS, ModArmorMaterials.PRIXILIUM_NETHERITE_KEY, "boots", false);

        itemModelGenerator.registerArmor(ModItems.PRIXILED_TURTLE_HELMET, ModArmorMaterials.PRIXILIUM_TURTLE_KEY, "helmet", false);


        itemModelGenerator.register(ModItems.PRIXILED_LEATHER_HORSE_ARMOR, Models.GENERATED);
        // 1.21.9+ itemModelGenerator.register(ModItems.PRIXILED_COPPER_HORSE_ARMOR, Models.GENERATED);
        itemModelGenerator.register(ModItems.PRIXILED_IRON_HORSE_ARMOR, Models.GENERATED);
        itemModelGenerator.register(ModItems.PRIXILED_GOLDEN_HORSE_ARMOR, Models.GENERATED);
        itemModelGenerator.register(ModItems.PRIXILED_DIAMOND_HORSE_ARMOR, Models.GENERATED);
        // 1.21.11+ itemModelGenerator.register(ModItems.PRIXILED_NETHERITE_HORSE_ARMOR, Models.GENERATED);

        //endregion
    }
}
