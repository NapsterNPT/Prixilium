package net.napsternpt.prixilium.entity.client.renderers;

import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;
import net.napsternpt.prixilium.Prixilium;
import net.napsternpt.prixilium.entity.client.renderstates.BlokitoRenderState;
import net.napsternpt.prixilium.entity.client.models.BlokitoModel;
import net.napsternpt.prixilium.entity.custom.BlokitoEntity;

public class BlokitoRenderer extends MobEntityRenderer<BlokitoEntity, BlokitoRenderState, BlokitoModel> {

    private static final Identifier TEXTURE = Identifier.of(Prixilium.MOD_ID, "textures/entity/blokito/blokito.png");

    public BlokitoRenderer(EntityRendererFactory.Context context) {
        super(context, new BlokitoModel(context.getPart(BlokitoModel.BLOKITO)), 0.5F);
    }

    @Override
    public BlokitoRenderState createRenderState() {return new BlokitoRenderState();}

    @Override
    public void updateRenderState(BlokitoEntity entity, BlokitoRenderState state, float tickDelta) {
        super.updateRenderState(entity, state, tickDelta);
        state.walkAnimationState.copyFrom(entity.walkAnimationState);
        state.idleAnimationState.copyFrom(entity.idleAnimationState);
    }

    @Override
    public Identifier getTexture(BlokitoRenderState state) {return TEXTURE;}
}