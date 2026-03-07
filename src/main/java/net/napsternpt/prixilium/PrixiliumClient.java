package net.napsternpt.prixilium;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;
import net.napsternpt.prixilium.block.ModBlocks;
import net.napsternpt.prixilium.util.ModModelPredicates;

public class PrixiliumClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.PRIXILIUM, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.PRIXILIUM_DOOR, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.PRIXILIUM_TRAPDOOR, RenderLayer.getCutout());

		ModModelPredicates.registerModelPredicates();
    }
}
