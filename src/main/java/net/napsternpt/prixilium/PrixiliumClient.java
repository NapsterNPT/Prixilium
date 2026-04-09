package net.napsternpt.prixilium;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.RenderLayer;
import net.napsternpt.prixilium.block.ModBlocks;
import net.napsternpt.prixilium.entity.ModEntities;
import net.napsternpt.prixilium.entity.client.BlikoModel;
import net.napsternpt.prixilium.entity.client.BlikoRenderer;
import net.napsternpt.prixilium.entity.client.PrixiliumHookRenderer;
import net.napsternpt.prixilium.util.ModModelPredicates;

public class PrixiliumClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.PRIXILIUM, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.PRIXILIUM_DOOR, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.PRIXILIUM_TRAPDOOR, RenderLayer.getCutout());

		ModModelPredicates.registerModelPredicates();

		EntityModelLayerRegistry.registerModelLayer(BlikoModel.BLIKO, BlikoModel::getTexturedModelData);
		EntityRendererRegistry.register(ModEntities.BLIKO, BlikoRenderer::new);
		EntityRendererRegistry.register(ModEntities.PRIXILIUM_HOOK, PrixiliumHookRenderer::new);
    }
}
