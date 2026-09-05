package net.napsternpt.prixilium.entity.client.renderers;

import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.napsternpt.prixilium.Prixilium;
import net.napsternpt.prixilium.entity.client.models.BlikoModel;
import net.napsternpt.prixilium.entity.client.renderstates.BlikoRenderState;
import net.napsternpt.prixilium.entity.custom.BlikoEntity;

public class BlikoRenderer extends MobEntityRenderer<BlikoEntity, BlikoRenderState, BlikoModel> {
    private static final Identifier TEXTURE = Identifier.of(Prixilium.MOD_ID, "textures/entity/bliko/bliko.png");

    public BlikoRenderer(EntityRendererFactory.Context context) {
        super(context, new BlikoModel(context.getPart(BlikoModel.BLIKO)), 0.5F);
    }

    @Override
    public BlikoRenderState createRenderState() {return new BlikoRenderState();}

    @Override
    public void updateRenderState(BlikoEntity entity, BlikoRenderState state, float tickDelta) {
        super.updateRenderState(entity, state, tickDelta);
        state.walkAnimationState.copyFrom(entity.walkAnimationState);
        state.idleAnimationState.copyFrom(entity.idleAnimationState);
        state.sitAnimationState.copyFrom(entity.sitAnimationState);
        state.isBaby = entity.isBaby();
    }

    @Override
    public Identifier getTexture(BlikoRenderState state) {
        return TEXTURE;
    }

    @Override
    protected void scale(BlikoRenderState state, MatrixStack matrices) {
        if (state.isBaby) {
            matrices.scale(0.5F, 0.5F, 0.5F);
        }
        super.scale(state, matrices);
    }
}