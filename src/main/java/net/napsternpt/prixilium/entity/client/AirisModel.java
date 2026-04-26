package net.napsternpt.prixilium.entity.client;

import net.minecraft.client.model.*;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;
import net.napsternpt.prixilium.Prixilium;

public class AirisModel extends EntityModel<AirisRenderState> {
    public static final EntityModelLayer AIRIS = new EntityModelLayer(
            Identifier.of(Prixilium.MOD_ID, "airis"), "main");

    public AirisModel(ModelPart root) {
        super(root);
        ModelPart body = root.getChild("Body");
        ModelPart eyes = body.getChild("Eyes");
        ModelPart c1 = body.getChild("c1");
        ModelPart c2 = body.getChild("c2");
        ModelPart c3 = body.getChild("c3");
        ModelPart c4 = body.getChild("c4");
        ModelPart c5 = body.getChild("c5");
        ModelPart c6 = body.getChild("c6");
        ModelPart c7 = body.getChild("c7");
        ModelPart bottom = body.getChild("Bottom");
    }

    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData Body = modelPartData.addChild("Body", ModelPartBuilder.create(), ModelTransform.rotation(0.0F, 19.0F, -6.0F));

        ModelPartData Eyes = Body.addChild("Eyes", ModelPartBuilder.create().uv(32, 14).cuboid(-4.5F, -5.0F, -0.975F, 3.0F, 4.0F, 2.0F, new Dilation(0.0F))
                .uv(32, 8).cuboid(1.5F, -5.0F, -0.975F, 3.0F, 4.0F, 2.0F, new Dilation(0.0F)), ModelTransform.rotation(0.0F, 0.0F, 6.0F));

        ModelPartData c1 = Body.addChild("c1", ModelPartBuilder.create().uv(0, 4).cuboid(-7.0F, -1.0F, -7.0F, 14.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.rotation(0.0F, 0.0F, 6.0F));

        ModelPartData c2 = Body.addChild("c2", ModelPartBuilder.create().uv(0, 0).cuboid(-7.0F, -1.0F, 1.0F, 14.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.rotation(0.0F, 0.0F, 0.0F));

        ModelPartData c3 = Body.addChild("c3", ModelPartBuilder.create().uv(0, 8).cuboid(-7.0F, -1.0F, 1.0F, 14.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.rotation(0.0F, 0.0F, 2.0F));

        ModelPartData c4 = Body.addChild("c4", ModelPartBuilder.create().uv(0, 12).cuboid(-7.0F, -1.0F, -1.0F, 14.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.rotation(0.0F, 0.0F, 6.0F));

        ModelPartData c5 = Body.addChild("c5", ModelPartBuilder.create().uv(0, 16).cuboid(-7.0F, -1.0F, 1.0F, 14.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.rotation(0.0F, 0.0F, 6.0F));

        ModelPartData c6 = Body.addChild("c6", ModelPartBuilder.create().uv(0, 20).cuboid(-7.0F, -1.0F, 3.0F, 14.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.rotation(0.0F, 0.0F, 6.0F));

        ModelPartData c7 = Body.addChild("c7", ModelPartBuilder.create().uv(0, 24).cuboid(-7.0F, -1.0F, 1.0F, 14.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.rotation(0.0F, 0.0F, 10.0F));

        ModelPartData Bottom = Body.addChild("Bottom", ModelPartBuilder.create().uv(32, 0).cuboid(-4.0F, 1.0F, -4.0F, 8.0F, 4.0F, 0.0F, new Dilation(0.0F))
                .uv(32, 4).cuboid(-4.0F, 1.0F, 4.0F, 8.0F, 4.0F, 0.0F, new Dilation(0.0F))
                .uv(0, 28).cuboid(4.0F, 1.0F, -4.0F, 0.0F, 4.0F, 8.0F, new Dilation(0.0F))
                .uv(16, 28).cuboid(-4.0F, 1.0F, -4.0F, 0.0F, 4.0F, 8.0F, new Dilation(0.0F)), ModelTransform.rotation(0.0F, 0.0F, 6.0F));
        return TexturedModelData.of(modelData, 64, 64);
    }

    @Override
    public void setAngles(AirisRenderState state) {
        super.setAngles(state);
        this.animate(state.walkAnimationState, AirisAnimations.WALK, state.age);
        this.animate(state.idleAnimationState, AirisAnimations.IDLE, state.age);
    }
}