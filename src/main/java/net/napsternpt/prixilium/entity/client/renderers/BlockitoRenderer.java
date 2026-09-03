package net.napsternpt.prixilium.entity.client.renderers;

import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;
import net.napsternpt.prixilium.Prixilium;
import net.napsternpt.prixilium.entity.client.models.BlockitoModel;
import net.napsternpt.prixilium.entity.client.renderstates.BlockitoRenderState;
import net.napsternpt.prixilium.entity.custom.BlockitoEntity;

public class BlockitoRenderer extends MobEntityRenderer<BlockitoEntity, BlockitoRenderState, BlockitoModel> {

    private static final Identifier TEXTURE = Identifier.of(Prixilium.MOD_ID, "textures/entity/blockito/blockito.png");

    public BlockitoRenderer(EntityRendererFactory.Context context) {
        super(context, new BlockitoModel(context.getPart(BlockitoModel.BLOCKITO)), 0.5F);
    }

    @Override
    public BlockitoRenderState createRenderState() {return new BlockitoRenderState();}

    @Override
    public void updateRenderState(BlockitoEntity entity, BlockitoRenderState state, float tickDelta) {
        super.updateRenderState(entity, state, tickDelta);
        state.walkAnimationState.copyFrom(entity.walkAnimationState);
        state.idleAnimationState.copyFrom(entity.idleAnimationState);
    }

    @Override
    public Identifier getTexture(BlockitoRenderState state) {return TEXTURE;}
}