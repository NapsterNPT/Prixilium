package software.bernie.geckolib.renderer.base;

import com.mojang.serialization.MapCodec;
import net.minecraft.class_10515;
import net.minecraft.class_1792;
import net.minecraft.class_1799;
import net.minecraft.class_310;
import net.minecraft.class_4587;
import net.minecraft.class_4597;
import net.minecraft.class_5599;
import net.minecraft.class_811;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.GeoAnimatable;
import software.bernie.geckolib.animatable.client.GeoRenderProvider;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.renderer.GeoItemRenderer;

public class GeckolibItemSpecialRenderer<T extends class_1792 & GeoAnimatable> implements class_10515<GeckolibItemSpecialRenderer.RenderData<T>> {
    @Override
    public void render(@Nullable GeckolibItemSpecialRenderer.RenderData<T> renderData, class_811 itemDisplayContext, class_4587 poseStack, class_4597 bufferSource, int packedLight, int packedOverlay, boolean hasGlint) {
        if (renderData == null)
            return;

        renderData.renderState.addGeckolibData(DataTickets.ITEM_RENDER_PERSPECTIVE, itemDisplayContext);
        renderData.renderState.addGeckolibData(DataTickets.HAS_GLINT, hasGlint);
        renderData.renderState.addGeckolibData(DataTickets.PACKED_OVERLAY, packedOverlay);
        renderData.renderState.addGeckolibData(DataTickets.PACKED_LIGHT, packedLight);

        renderData.renderer.render(renderData.renderState, poseStack, bufferSource);
    }

    @Nullable
    @Override
    public GeckolibItemSpecialRenderer.RenderData<T> method_65695(class_1799 itemStack) {
        var item = makeCovariantItem(itemStack.method_7909());
        GeoItemRenderer<T> renderer = (GeoItemRenderer)GeoRenderProvider.of(item).getGeoItemRenderer();

        if (renderer == null)
            return null;

        return new RenderData<>(item, buildRenderState(item, itemStack, renderer), renderer);
    }

    private T makeCovariantItem(class_1792 item) {
        return item instanceof GeoAnimatable ? (T)item : null;
    }

    private GeoRenderState buildRenderState(T animatable, class_1799 itemStack, GeoItemRenderer<T> renderer) {
        return renderer.fillRenderState(animatable, itemStack, new GeoRenderState.Impl(), class_310.method_1551().method_61966().method_60637(true));
    }

    public static class Unbaked implements class_10515.class_10516 {
        public static final MapCodec<GeckolibItemSpecialRenderer.Unbaked> MAP_CODEC = MapCodec.unit(Unbaked::new);

        @Nullable
        @Override
        public class_10515<?> method_65698(class_5599 entityModelSet) {
            return new GeckolibItemSpecialRenderer<>();
        }

        @Override
        public MapCodec<? extends class_10515.class_10516> method_65696() {
            return MAP_CODEC;
        }
    }

    public record RenderData<T extends class_1792 & GeoAnimatable>(T item, GeoRenderState renderState, GeoItemRenderer<T> renderer) {}
}