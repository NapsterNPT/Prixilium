package net.napsternpt.prixilium.entity.client.renderers;

import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.state.EntityRenderState;
import net.napsternpt.prixilium.entity.projectile.PrixiliumHookEntity;

public class PrixiliumHookRenderer extends EntityRenderer<PrixiliumHookEntity, EntityRenderState> {

    public PrixiliumHookRenderer(EntityRendererFactory.Context context) {
        super(context);
    }

    public EntityRenderState createRenderState() {
        return new EntityRenderState();
    }
}