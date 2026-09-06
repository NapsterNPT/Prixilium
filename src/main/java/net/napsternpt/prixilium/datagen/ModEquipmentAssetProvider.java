package net.napsternpt.prixilium.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.client.render.entity.equipment.EquipmentModel;
import net.minecraft.data.DataOutput;
import net.minecraft.data.DataProvider;
import net.minecraft.data.DataWriter;
import net.minecraft.item.equipment.EquipmentAsset;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;
import net.napsternpt.prixilium.Prixilium;
import net.napsternpt.prixilium.item.ModArmorMaterials;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

public class ModEquipmentAssetProvider implements DataProvider {
    private final DataOutput.PathResolver pathResolver;

    public ModEquipmentAssetProvider(FabricDataOutput output) {
        this.pathResolver = output.getResolver(DataOutput.OutputType.RESOURCE_PACK, "equipment");
    }

    @Override
    public CompletableFuture<?> run(DataWriter writer) {
        Map<Identifier, EquipmentModel> models = new HashMap<>();
        register(models, ModArmorMaterials.PRIXILIUM_LEATHER_KEY, "prixiled_leather", true, true, true);
        register(models, ModArmorMaterials.PRIXILIUM_CHAIN_KEY, "prixiled_chainmail", false, false, true);
        register(models, ModArmorMaterials.PRIXILIUM_COPPER_KEY, "prixiled_copper", true, false, true);
        register(models, ModArmorMaterials.PRIXILIUM_IRON_KEY, "prixiled_iron", true, false, true);
        register(models, ModArmorMaterials.PRIXILIUM_GOLD_KEY, "prixiled_gold", true, false, true);
        register(models, ModArmorMaterials.PRIXILIUM_DIAMOND_KEY, "prixiled_diamond", true, false, true);
        register(models, ModArmorMaterials.PRIXILIUM_NETHERITE_KEY, "prixiled_netherite", true, false, true);
        register(models, ModArmorMaterials.PRIXILIUM_TURTLE_KEY, "prixiled_turtle_scute", false, false, false);
        register(models, ModArmorMaterials.RIFT_KEY, "rifts_shell", false, false, false);
        return DataProvider.writeAllToPath(writer, EquipmentModel.CODEC, this.pathResolver, models);
    }

    private static void register(Map<Identifier, EquipmentModel> models, RegistryKey<EquipmentAsset> key, String texture, boolean horse, boolean leather, boolean leggings) {
        EquipmentModel.Builder builder = EquipmentModel.builder();
        if (leather) {
            builder.addHumanoidLayers(Identifier.of(Prixilium.MOD_ID, texture), true)
                    .addHumanoidLayers(Identifier.of(Prixilium.MOD_ID, texture + "_overlay"), false)
                    .addLayers(EquipmentModel.LayerType.HORSE_BODY,
                            EquipmentModel.Layer.createWithLeatherColor(Identifier.of(Prixilium.MOD_ID, texture), true),
                            EquipmentModel.Layer.createWithLeatherColor(Identifier.of(Prixilium.MOD_ID, texture + "_overlay"), false));
        } else if (leggings) {
            builder.addHumanoidLayers(Identifier.of(Prixilium.MOD_ID, texture));
            if (horse) builder.addLayers(EquipmentModel.LayerType.HORSE_BODY, EquipmentModel.Layer.create(Identifier.of(Prixilium.MOD_ID, texture), false));
        } else {
            builder.addMainHumanoidLayer(Identifier.of(Prixilium.MOD_ID, texture), false);
        }
        models.put(key.getValue(), builder.build());
    }

    @Override
    public String getName() {
        return "Equipment Asset Definitions";
    }
}