package net.napsternpt.prixilium.client;

import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.Item;
import net.minecraft.item.ItemDisplayContext;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;
import net.napsternpt.prixilium.Prixilium;
import net.napsternpt.prixilium.item.custom.CharmItem;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.renderer.GeoItemRenderer;
import software.bernie.geckolib.renderer.base.GeoRenderState;

public class CharmItemRenderer extends GeoItemRenderer<CharmItem> {
    public CharmItemRenderer() {
        super(new CharmItemModel());
    }
    @Override
    public void render(GeoRenderState renderState, MatrixStack matrices, VertexConsumerProvider vertexConsumers) {
        ItemDisplayContext perspective = renderState.getOrDefaultGeckolibData(DataTickets.ITEM_RENDER_PERSPECTIVE, ItemDisplayContext.NONE);
        if (perspective == ItemDisplayContext.GUI) {
            Item item = renderState.getGeckolibData(DataTickets.ITEM);
            if (item != null) {
                String path = Registries.ITEM.getId(item).getPath();
                if (path.endsWith("_i")) {
                    setupLightingForGuiRender();
                    Identifier texture = Identifier.of(Prixilium.MOD_ID, "textures/item/" + path + ".png");
                    renderFlat2D(matrices, vertexConsumers, texture);
                    return;
                }
            }
        }
        super.render(renderState, matrices, vertexConsumers);
    }
    private void renderFlat2D(MatrixStack matrices, VertexConsumerProvider vertexConsumers, Identifier texture) {
        matrices.push();
        matrices.translate(0.5f, 0.5f, 0.5f);
        RenderLayer renderLayer = RenderLayer.getEntityCutoutNoCull(texture);
        VertexConsumer consumer = vertexConsumers.getBuffer(renderLayer);
        MatrixStack.Entry entry = matrices.peek();
        float s = 0.5f;
        int light = 0xF000F0;
        consumer.vertex(entry, -s, -s, 0f).color(255, 255, 255, 255).texture(0f, 1f).overlay(OverlayTexture.DEFAULT_UV).light(light).normal(entry, 0f, 0f, 1f);
        consumer.vertex(entry,  s, -s, 0f).color(255, 255, 255, 255).texture(1f, 1f).overlay(OverlayTexture.DEFAULT_UV).light(light).normal(entry, 0f, 0f, 1f);
        consumer.vertex(entry,  s,  s, 0f).color(255, 255, 255, 255).texture(1f, 0f).overlay(OverlayTexture.DEFAULT_UV).light(light).normal(entry, 0f, 0f, 1f);
        consumer.vertex(entry, -s,  s, 0f).color(255, 255, 255, 255).texture(0f, 0f).overlay(OverlayTexture.DEFAULT_UV).light(light).normal(entry, 0f, 0f, 1f);
        matrices.pop();
    }
}