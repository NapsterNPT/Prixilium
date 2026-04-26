package net.napsternpt.prixilium.entity.client;

import net.minecraft.client.model.*;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;
import net.napsternpt.prixilium.Prixilium;

public class BlokitoModel extends EntityModel<BlokitoRenderState> {
    public static final EntityModelLayer BLOKITO = new EntityModelLayer(
            Identifier.of(Prixilium.MOD_ID, "blokito"), "main");

    protected BlokitoModel(ModelPart root) {
        super(root);
        ModelPart body = root.getChild("Body");
    }

    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData Body = modelPartData.addChild("Body", ModelPartBuilder.create().uv(0, 0).cuboid(-8.0F, -16.0F, -8.0F, 16.0F, 16.0F, 16.0F, new Dilation(0.0F))
                .uv(0, 32).cuboid(-4.0F, -12.0F, -4.0F, 8.0F, 8.0F, 8.0F, new Dilation(0.0F)), ModelTransform.rotation(0.0F, 24.0F, 0.0F));
        return TexturedModelData.of(modelData, 64, 64);
    }

    public void setAngles(BlokitoRenderState state) {
        super.setAngles(state);
        this.animate(state.walkAnimationState, BlokitoAnimations.WALK, state.age);
        this.animate(state.idleAnimationState, BlokitoAnimations.IDLE, state.age);
    }
}