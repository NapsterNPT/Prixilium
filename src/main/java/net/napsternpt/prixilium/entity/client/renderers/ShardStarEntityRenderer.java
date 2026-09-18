package net.napsternpt.prixilium.entity.client.renderers;

import net.minecraft.client.item.ItemModelManager;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.command.OrderedRenderCommandQueue;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.state.FlyingItemEntityRenderState;
import net.minecraft.client.render.state.CameraRenderState;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemDisplayContext;
import net.minecraft.util.math.RotationAxis;
import net.napsternpt.prixilium.entity.projectile.ShardStarEntity;

public class ShardStarEntityRenderer extends EntityRenderer<ShardStarEntity, ShardStarEntityRenderer.ShardStarRenderState> {
    private final ItemModelManager itemModelManager;

    public ShardStarEntityRenderer(EntityRendererFactory.Context context) {
        super(context);
        this.itemModelManager = context.getItemModelManager();
    }

    @Override
    public ShardStarRenderState createRenderState() {
        return new ShardStarRenderState();
    }

    @Override
    public void updateRenderState(ShardStarEntity entity, ShardStarRenderState state, float tickDelta) {
        super.updateRenderState(entity, state, tickDelta);
        this.itemModelManager.updateForNonLivingEntity(state.itemRenderState, entity.getStack(), ItemDisplayContext.NONE, entity);
        state.yaw = entity.getLerpedYaw(tickDelta);
        state.spin = entity.getSpin();
        state.yawOffset = entity.getYawOffset();
    }

    @Override
    public void render(ShardStarRenderState state, MatrixStack matrices, OrderedRenderCommandQueue queue, CameraRenderState cameraState) {
        matrices.push();
        matrices.scale(0.35F, 0.35F, 0.35F);
        matrices.translate(0.0F, 0.5F, 0.0F);
        matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(state.yaw + state.yawOffset + 90));
        matrices.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(state.spin));
        state.itemRenderState.render(matrices, queue, state.light, OverlayTexture.DEFAULT_UV, state.outlineColor);
        matrices.pop();

        super.render(state, matrices, queue, cameraState);
    }

    public static class ShardStarRenderState extends FlyingItemEntityRenderState {
        public float yaw;
        public float yawOffset;
        public float spin;
    }
}
