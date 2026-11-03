package net.napsternpt.prixilium.entity.client.renderers;

import net.minecraft.block.BlockState;
import net.minecraft.client.render.MapRenderer;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.RenderLayers;
import net.minecraft.client.render.block.BlockRenderManager;
import net.minecraft.client.render.command.OrderedRenderCommandQueue;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.ItemFrameEntityRenderer;
import net.minecraft.client.render.entity.state.ItemFrameEntityRenderState;
import net.minecraft.client.render.model.BlockStateModel;
import net.minecraft.client.render.state.CameraRenderState;
import net.minecraft.client.texture.SpriteAtlasTexture;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.RotationAxis;
import net.minecraft.util.math.Vec3d;
import net.napsternpt.prixilium.block.ModBlocks;
import net.napsternpt.prixilium.entity.custom.CharmFrameEntity;

public class CharmFrameEntityRenderer extends ItemFrameEntityRenderer<CharmFrameEntity> {
    private final BlockRenderManager blockRenderManager;
    private final MapRenderer mapRenderer;

    public CharmFrameEntityRenderer(EntityRendererFactory.Context context) {
        super(context);
        this.blockRenderManager = context.getBlockRenderManager();
        this.mapRenderer = context.getMapRenderer();
    }

    @Override
    public void render(ItemFrameEntityRenderState state, MatrixStack matrices, OrderedRenderCommandQueue queue, CameraRenderState cameraState) {
        Direction facing = state.facing;
        Vec3d offset = this.getPositionOffset(state);
        matrices.translate(-offset.x, -offset.y, -offset.z);
        matrices.translate(facing.getOffsetX() * 0.46875, facing.getOffsetY() * 0.46875, facing.getOffsetZ() * 0.46875);

        if (facing.getAxis().isHorizontal()) {
            matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(180.0F - facing.getPositiveHorizontalDegrees()));
        } else {
            matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(-90.0F * facing.getDirection().offset()));
            matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(180.0F));
        }

        if (!state.invisible) {
            BlockState frameState = ModBlocks.CHARM_FRAME_DISPLAY.getDefaultState();
            BlockStateModel model = this.blockRenderManager.getModel(frameState);
            matrices.push();
            matrices.translate(-0.5F, -0.5F, -0.5F);
            queue.submitBlockStateModel(matrices, RenderLayers.entitySolidZOffsetForward(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE),
                    model, 1.0F, 1.0F, 1.0F, state.light, OverlayTexture.DEFAULT_UV, state.outlineColor);
            matrices.pop();
        }

        matrices.translate(0.0F, 0.0F, state.invisible ? 0.5F : 0.4375F);

        if (state.mapId != null) {
            int rotation = state.rotation % 4 * 2;
            matrices.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(rotation * 360.0F / 8.0F));
            matrices.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(180.0F));
            float scale = 0.0078125F;
            matrices.scale(scale, scale, scale);
            matrices.translate(-64.0F, -64.0F, 0.0F);
            matrices.translate(0.0F, 0.0F, -1.0F);
            int light = state.glow ? 15728850 : state.light;
            this.mapRenderer.draw(state.mapRenderState, matrices, queue, true, light);
        } else if (!state.itemRenderState.isEmpty()) {
            matrices.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(state.rotation * 360.0F / 8.0F));
            int light = state.glow ? 15728880 : state.light;
            matrices.scale(0.5F, 0.5F, 0.5F);
            state.itemRenderState.render(matrices, queue, light, OverlayTexture.DEFAULT_UV, state.outlineColor);
        }
    }
}
