package net.napsternpt.prixilium.entity.client.renderers;

import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;
import net.napsternpt.prixilium.entity.client.models.RiftCoreModel;
import net.napsternpt.prixilium.entity.client.renderstates.RiftCoreRenderState;
import net.napsternpt.prixilium.entity.custom.RiftCoreEntity;

public class RiftCoreRenderer extends MobEntityRenderer<RiftCoreEntity, RiftCoreRenderState, RiftCoreModel> {
    public RiftCoreRenderer(EntityRendererFactory.Context context, RiftCoreModel entityModel, float f) {
        super(context, entityModel, f);
    }

    @Override
    public Identifier getTexture(RiftCoreRenderState state) {
        return null;
    }

    @Override
    public RiftCoreRenderState createRenderState() {
        return null;
    }
}
