package net.napsternpt.prixilium.entity.client;

import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.napsternpt.prixilium.entity.projectile.PrixiliumHookEntity;

public class PrixiliumHookRenderer extends EntityRenderer<PrixiliumHookEntity, PrixiliumHookRenderState> {

    public PrixiliumHookRenderer(EntityRendererFactory.Context context) {
        super(context);
    }

    public PrixiliumHookRenderState createRenderState() {
        return new PrixiliumHookRenderState();
    }
}