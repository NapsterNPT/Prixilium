package net.napsternpt.prixilium.entity.client.renderers;

import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;
import net.napsternpt.prixilium.Prixilium;
import net.napsternpt.prixilium.entity.client.models.RiftCoreModel;
import net.napsternpt.prixilium.entity.client.renderstates.RiftCoreRenderState;
import net.napsternpt.prixilium.entity.custom.RiftCoreEntity;

public class RiftCoreRenderer extends MobEntityRenderer<RiftCoreEntity, RiftCoreRenderState, RiftCoreModel> {

	private static final Identifier TEXTURE = Identifier.of(Prixilium.MOD_ID, "textures/block/rift_core.png");

	public RiftCoreRenderer(EntityRendererFactory.Context context) {
		super(context, new RiftCoreModel(context.getPart(RiftCoreModel.RIFT_CORE)), 0.5F);
	}

	@Override
	public RiftCoreRenderState createRenderState() {
		return new RiftCoreRenderState();
	}

	@Override
	public Identifier getTexture(RiftCoreRenderState state) {
		return TEXTURE;
	}
}