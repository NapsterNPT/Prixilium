package net.napsternpt.prixilium.block.entity.renderers;

import net.minecraft.client.item.ItemModelManager;
import net.minecraft.client.render.LightmapTextureManager;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.block.entity.BeaconBlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.render.command.ModelCommandRenderer;
import net.minecraft.client.render.command.OrderedRenderCommandQueue;
import net.minecraft.client.render.state.CameraRenderState;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemDisplayContext;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RotationAxis;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.LightType;
import net.minecraft.world.World;
import net.napsternpt.prixilium.block.entity.custom.ObeliskOfCharmsBlockEntity;
import net.napsternpt.prixilium.block.entity.renderstates.ObeliskOfCharmsBlockEntityRenderState;
import org.jspecify.annotations.Nullable;

public class ObeliskOfCharmsBlockEntityRenderer implements BlockEntityRenderer<ObeliskOfCharmsBlockEntity, ObeliskOfCharmsBlockEntityRenderState> {
    private final ItemModelManager itemModelManager;

    public ObeliskOfCharmsBlockEntityRenderer(BlockEntityRendererFactory.Context context) {
        itemModelManager = context.itemModelManager();
    }

    @Override
    public ObeliskOfCharmsBlockEntityRenderState createRenderState() {
        return new ObeliskOfCharmsBlockEntityRenderState();
    }

    @Override
    public void updateRenderState(ObeliskOfCharmsBlockEntity blockEntity, ObeliskOfCharmsBlockEntityRenderState state, float tickProgress, Vec3d cameraPos, ModelCommandRenderer.@Nullable CrumblingOverlayCommand crumblingOverlay) {
        BlockEntityRenderer.super.updateRenderState(blockEntity, state, tickProgress, cameraPos, crumblingOverlay);

        state.isActive = blockEntity.isBurning();

        state.lightPosition = blockEntity.getPos();
        state.blockEntityWorld = blockEntity.getWorld();
        state.rotation = blockEntity.getRenderingRotation();

        ItemStack displayStack = blockEntity.getStack(0).isEmpty() ? blockEntity.getStack(2) : blockEntity.getStack(0);
        itemModelManager.clearAndUpdate(state.itemRenderState,
                displayStack, ItemDisplayContext.FIXED, blockEntity.getWorld(), null, 0);
    }

    public void render(ObeliskOfCharmsBlockEntityRenderState state, MatrixStack matrices, OrderedRenderCommandQueue queue, CameraRenderState cameraState) {
        if (state.isActive) {
            matrices.push();

            matrices.translate(0.5f, 0.75f, 0.5f);
            matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees((System.currentTimeMillis() % 3600) / 10.0f));
            matrices.translate(-0.5f, 0.0f, -0.5f);

            BeaconBlockEntityRenderer.renderBeam(matrices, queue, BeaconBlockEntityRenderer.BEAM_TEXTURE,
                    1.0f, 1.0f, 0, 5,
                    0x00FF00, 0.2f, 0.25f
            );

            matrices.pop();
        }

        if (state.itemRenderState.isEmpty()) return;

        matrices.push();
        matrices.translate(0.5f, 0.75f, 0.5f);
        matrices.scale(0.5f, 0.5f, 0.5f);
        matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(90));
        matrices.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(state.rotation));

        state.itemRenderState.render(matrices, queue, getLightLevel(state.blockEntityWorld, state.pos), OverlayTexture.DEFAULT_UV, 0);

        matrices.pop();
    }

    private int getLightLevel(World world, BlockPos pos) {
        int bLight = world.getLightLevel(LightType.BLOCK, pos);
        int sLight = world.getLightLevel(LightType.SKY, pos);
        return LightmapTextureManager.pack(bLight, sLight);
    }
}
