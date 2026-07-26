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
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RotationAxis;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.LightType;
import net.minecraft.world.World;
import net.napsternpt.prixilium.block.entity.custom.VirusReactorBlockEntity;
import net.napsternpt.prixilium.block.entity.renderstates.VirusReactorBlockEntityRenderState;
import org.jetbrains.annotations.Nullable;

public class VirusReactorBlockEntityRenderer implements BlockEntityRenderer<VirusReactorBlockEntity, VirusReactorBlockEntityRenderState> {
    private final ItemModelManager itemModelManager;

    public VirusReactorBlockEntityRenderer(BlockEntityRendererFactory.Context context) {
        itemModelManager = context.itemModelManager();
    }

    @Override
    public VirusReactorBlockEntityRenderState createRenderState() {
        return new VirusReactorBlockEntityRenderState();
    }

    @Override
    public void updateRenderState(VirusReactorBlockEntity blockEntity, VirusReactorBlockEntityRenderState state, float tickProgress, Vec3d cameraPos, @Nullable ModelCommandRenderer.CrumblingOverlayCommand crumblingOverlay) {
        BlockEntityRenderer.super.updateRenderState(blockEntity, state, tickProgress, cameraPos, crumblingOverlay);

        state.isActive = blockEntity.isSpreading();

        state.lightPosition = blockEntity.getPos();
        state.blockEntityWorld = blockEntity.getWorld();
        state.rotation = blockEntity.getRenderingRotation();

        itemModelManager.clearAndUpdate(state.itemRenderState,
                blockEntity.getStack(0), ItemDisplayContext.FIXED, blockEntity.getWorld(), null, 0);
    }

    @Override
    public void render(VirusReactorBlockEntityRenderState state, MatrixStack matrices, OrderedRenderCommandQueue queue, CameraRenderState cameraState) {
        if (state.isActive) {

            float time = (System.currentTimeMillis() % 3600) / 10.0f;
            float orbitRadius = 1.125f + 0.375f * (float) Math.sin(System.currentTimeMillis() / 500.0);

            for (int i = 0; i < 4; i++) {
                matrices.push();

                matrices.translate(0.5f, 0.0f, 0.5f);
                matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(time + i * 90));
                matrices.translate(orbitRadius, 0.0f, 0.0f);
                matrices.translate(-0.5f, 0.0f, -0.5f);

                BeaconBlockEntityRenderer.renderBeam(matrices, queue, BeaconBlockEntityRenderer.BEAM_TEXTURE,
                        1.0f, 1.0f, 0, 5,
                        0x8CB3FF, 0.2f, 0.25f
                );

                matrices.pop();
            }
        }

        matrices.push();

        matrices.translate(0.5f, 1.0f, 0.5f);
        matrices.scale(0.5f, 0.5f, 0.5f);
        matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(state.rotation));

        state.itemRenderState.render(matrices, queue, getLightLevel(state.blockEntityWorld, state.pos), OverlayTexture.DEFAULT_UV, 0);

        matrices.pop();
    }

    private int getLightLevel(World world, BlockPos pos) {
        int bLight = world.getLightLevel(LightType.BLOCK, pos);
        int sLight = world.getLightLevel(LightType.SKY, pos);
        return LightmapTextureManager.pack(bLight, sLight);
    }
}
