package net.napsternpt.prixilium.entity.client.renderers;

import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;
import net.napsternpt.prixilium.Prixilium;
import net.napsternpt.prixilium.entity.client.models.AirisModel;
import net.napsternpt.prixilium.entity.client.renderstates.AirisRenderState;
import net.napsternpt.prixilium.entity.custom.AirisEntity;

public class AirisRenderer extends MobEntityRenderer<AirisEntity, AirisRenderState, AirisModel> {

    private static final Identifier TEXTURE = Identifier.of(Prixilium.MOD_ID, "textures/entity/airis/airis.png");

    public AirisRenderer(EntityRendererFactory.Context context) {
        super(context, new AirisModel(context.getPart(AirisModel.AIRIS)), 0.5F);
    }

    @Override
    public AirisRenderState createRenderState() {return new AirisRenderState();}

    @Override
    public void updateRenderState(AirisEntity entity, AirisRenderState state, float tickDelta) {
        super.updateRenderState(entity, state, tickDelta);
        state.walkAnimationState.copyFrom(entity.walkAnimationState);
        state.idleAnimationState.copyFrom(entity.idleAnimationState);
    }

    @Override
    public Identifier getTexture(AirisRenderState state) {return TEXTURE;}
}