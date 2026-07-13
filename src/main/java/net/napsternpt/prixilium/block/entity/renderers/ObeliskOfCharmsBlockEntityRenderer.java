package net.napsternpt.prixilium.block.entity.renderers;

import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.render.command.OrderedRenderCommandQueue;
import net.minecraft.client.render.state.CameraRenderState;
import net.minecraft.client.util.math.MatrixStack;
import net.napsternpt.prixilium.block.entity.custom.ObeliskOfCharmsBlockEntity;
import net.napsternpt.prixilium.block.entity.renderstates.ObeliskOfCharmsBlockEntityRenderState;

public class ObeliskOfCharmsBlockEntityRenderer implements BlockEntityRenderer<ObeliskOfCharmsBlockEntity, ObeliskOfCharmsBlockEntityRenderState> {
    public ObeliskOfCharmsBlockEntityRenderer(BlockEntityRendererFactory.Context context) {
    }

    @Override
    public ObeliskOfCharmsBlockEntityRenderState createRenderState() {
        return new ObeliskOfCharmsBlockEntityRenderState();
    }

    @Override
    public void render(ObeliskOfCharmsBlockEntityRenderState state, MatrixStack matrices, OrderedRenderCommandQueue queue, CameraRenderState cameraState) {
    }
}
