package net.napsternpt.prixilium;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactories;
import net.napsternpt.prixilium.block.ModBlocks;
import net.napsternpt.prixilium.block.entity.ModBlockEntities;
import net.napsternpt.prixilium.block.entity.renderer.VirusReactorBlockEntityRenderer;
import net.napsternpt.prixilium.entity.ModEntities;
import net.napsternpt.prixilium.entity.client.*;
import net.napsternpt.prixilium.particle.ModParticles;
import net.napsternpt.prixilium.particle.PrixiliumAmbientParticles;
import net.napsternpt.prixilium.particle.PrixiliumLeavesParticles;

public class PrixiliumClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.PRIXILIUM, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.PRIXILIUM_DOOR, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.PRIXILIUM_TRAPDOOR, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.REACTOR_CORE, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.VIRUS_REACTOR, RenderLayer.getCutout());

		BlockEntityRendererFactories.register(ModBlockEntities.VIRUS_REACTOR_BE, VirusReactorBlockEntityRenderer::new);

		EntityModelLayerRegistry.registerModelLayer(BlikoModel.BLIKO, BlikoModel::getTexturedModelData);
		EntityRendererRegistry.register(ModEntities.BLIKO, BlikoRenderer::new);
		EntityModelLayerRegistry.registerModelLayer(BlokitoModel.BLOKITO, BlokitoModel::getTexturedModelData);
		EntityRendererRegistry.register(ModEntities.BLOKITO, BlokitoRenderer::new);
		EntityModelLayerRegistry.registerModelLayer(AirisModel.AIRIS, AirisModel::getTexturedModelData);
		EntityRendererRegistry.register(ModEntities.AIRIS, AirisRenderer::new);
		EntityRendererRegistry.register(ModEntities.PRIXILIUM_HOOK, PrixiliumHookRenderer::new);

		ParticleFactoryRegistry.getInstance().register(ModParticles.PRIXILIUM_AMBIENT, PrixiliumAmbientParticles.Factory::new);
		ParticleFactoryRegistry.getInstance().register(ModParticles.PRIXILIUM_LEAVES_PARTICLE, PrixiliumLeavesParticles.Factory::new);
    }
}
