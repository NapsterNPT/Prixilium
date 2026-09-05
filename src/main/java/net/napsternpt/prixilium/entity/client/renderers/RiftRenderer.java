package net.napsternpt.prixilium.entity.client.renderers;

import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;
import net.napsternpt.prixilium.Prixilium;
import net.napsternpt.prixilium.entity.client.models.RiftModel;
import net.napsternpt.prixilium.entity.client.renderstates.RiftRenderState;
import net.napsternpt.prixilium.entity.custom.RiftEntity;

public class RiftRenderer extends MobEntityRenderer<RiftEntity, RiftRenderState, RiftModel> {

	private static final Identifier TEXTURE = Identifier.of(Prixilium.MOD_ID, "textures/entity/rift/rift.png");

	public RiftRenderer(EntityRendererFactory.Context context) {
		super(context, new RiftModel(context.getPart(RiftModel.RIFT)), 0.5F);
	}

	@Override
	public RiftRenderState createRenderState() {
		return new RiftRenderState();
	}

	@Override
	public void updateRenderState(RiftEntity entity, RiftRenderState state, float tickDelta) {
		super.updateRenderState(entity, state, tickDelta);
		state.spawnAnimationState.copyFrom(entity.spawnAnimationState);
		state.idleAnimationState.copyFrom(entity.idleAnimationState);
		state.walkAnimationState.copyFrom(entity.walkAnimationState);
		state.slamAnimationState.copyFrom(entity.slamAnimationState);
		state.spinAnimationState.copyFrom(entity.spinAnimationState);
	}

	@Override
	public Identifier getTexture(RiftRenderState state) {
		return TEXTURE;
	}
}