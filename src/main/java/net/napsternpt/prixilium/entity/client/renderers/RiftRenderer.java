package net.napsternpt.prixilium.entity.client.renderers;

import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;
import net.napsternpt.prixilium.entity.client.models.RiftModel;
import net.napsternpt.prixilium.entity.client.renderstates.RiftRenderState;
import net.napsternpt.prixilium.entity.custom.RiftEntity;

public class RiftRenderer extends MobEntityRenderer<RiftEntity, RiftRenderState, RiftModel> {
    public RiftRenderer(EntityRendererFactory.Context context, RiftModel entityModel, float f) {
        super(context, entityModel, f);
    }

    @Override
    public Identifier getTexture(RiftRenderState state) {
        return null;
    }

    @Override
    public RiftRenderState createRenderState() {
        return null;
    }
}
