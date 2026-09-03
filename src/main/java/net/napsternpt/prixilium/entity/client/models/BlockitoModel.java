package net.napsternpt.prixilium.entity.client.models;

import net.minecraft.client.model.*;
import net.minecraft.client.render.entity.animation.Animation;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;
import net.napsternpt.prixilium.Prixilium;
import net.napsternpt.prixilium.entity.client.animations.BlockitoAnimations;
import net.napsternpt.prixilium.entity.client.renderstates.BlockitoRenderState;

public class BlockitoModel extends EntityModel<BlockitoRenderState> {
    public static final EntityModelLayer BLOCKITO = new EntityModelLayer(
            Identifier.of(Prixilium.MOD_ID, "blockito"), "main");

    private final Animation idleingAnimation;
    private final Animation walkingAnimation;

    public BlockitoModel(ModelPart root) {
        super(root);
        root.getChild("Body");
        this.idleingAnimation = BlockitoAnimations.IDLE.createAnimation(root);
        this.walkingAnimation = BlockitoAnimations.WALK.createAnimation(root);
    }

    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData Body = modelPartData.addChild("Body", ModelPartBuilder.create().uv(0, 0).cuboid(-8.0F, -16.0F, -8.0F, 16.0F, 16.0F, 16.0F, new Dilation(0.0F))
                .uv(0, 32).cuboid(-4.0F, -12.0F, -4.0F, 8.0F, 8.0F, 8.0F, new Dilation(0.0F)), ModelTransform.rotation(0.0F, 24.0F, 0.0F));
        return TexturedModelData.of(modelData, 64, 64);
    }

    public void setAngles(BlockitoRenderState state) {
        super.setAngles(state);
        this.walkingAnimation.applyWalking(state.limbSwingAnimationProgress, state.limbSwingAmplitude, 2f, 2.5f);
        this.idleingAnimation.apply(state.idleAnimationState, state.age, 1f);
    }
}