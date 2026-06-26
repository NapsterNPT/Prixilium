package net.napsternpt.prixilium;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.BlockRenderLayer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactories;
import net.napsternpt.prixilium.block.ModBlocks;
import net.napsternpt.prixilium.block.entity.ModBlockEntities;
import net.napsternpt.prixilium.block.entity.renderer.VirusReactorBlockEntityRenderer;
import net.napsternpt.prixilium.entity.ModEntities;
import net.napsternpt.prixilium.entity.client.models.*;
import net.napsternpt.prixilium.entity.client.renderers.*;
import net.napsternpt.prixilium.network.ModPackets;
import net.napsternpt.prixilium.particle.*;

public class PrixiliumClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		BlockRenderLayerMap.putBlock(ModBlocks.PRIXILIUM, BlockRenderLayer.CUTOUT);
		BlockRenderLayerMap.putBlock(ModBlocks.PRIXILIUM_DOOR, BlockRenderLayer.CUTOUT);
		BlockRenderLayerMap.putBlock(ModBlocks.PRIXILIUM_TRAPDOOR, BlockRenderLayer.CUTOUT);
		BlockRenderLayerMap.putBlock(ModBlocks.REACTOR_CORE, BlockRenderLayer.CUTOUT);
		BlockRenderLayerMap.putBlock(ModBlocks.VIRUS_REACTOR, BlockRenderLayer.CUTOUT);
		BlockRenderLayerMap.putBlock(ModBlocks.PRIXILIUM_GRATE, BlockRenderLayer.CUTOUT);
		BlockRenderLayerMap.putBlock(ModBlocks.DARK_PRIXILIUM_GRATE, BlockRenderLayer.CUTOUT);

		BlockEntityRendererFactories.register(ModBlockEntities.VIRUS_REACTOR_BE, VirusReactorBlockEntityRenderer::new);

		EntityModelLayerRegistry.registerModelLayer(BlikoModel.BLIKO, BlikoModel::getTexturedModelData);
		EntityRendererRegistry.register(ModEntities.BLIKO, BlikoRenderer::new);
		EntityModelLayerRegistry.registerModelLayer(BlokitoModel.BLOKITO, BlokitoModel::getTexturedModelData);
		EntityRendererRegistry.register(ModEntities.BLOKITO, BlokitoRenderer::new);
		EntityModelLayerRegistry.registerModelLayer(AirisModel.AIRIS, AirisModel::getTexturedModelData);
		EntityRendererRegistry.register(ModEntities.AIRIS, AirisRenderer::new);
		EntityRendererRegistry.register(ModEntities.PRIXILIUM_HOOK, PrixiliumHookRenderer::new);

		ParticleFactoryRegistry.getInstance().register(ModParticles.PRIXILIUM_AMBIENT, PrixiliumAmbientParticles.Factory::new);
		ParticleFactoryRegistry.getInstance().register(ModParticles.PRIXILIUM_LEAVES, PrixiliumLeavesParticles.Factory::new);
		ParticleFactoryRegistry.getInstance().register(ModParticles.PRIXILIUM_HOOK, PrixiliumHookParticles.Factory::new);
		ParticleFactoryRegistry.getInstance().register(ModParticles.PRIXILIUM_SMOKE, PrixiliumSmokeParticles.Factory::new);
		ParticleFactoryRegistry.getInstance().register(ModParticles.PRIXILIUM_EXPAND, PrixiliumExpandParticles.Factory::new);

		ModPackets.registerClient();
    }
}
