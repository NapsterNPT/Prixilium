package net.napsternpt.prixilium.entity.client;

import net.minecraft.client.model.*;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;
import net.napsternpt.prixilium.Prixilium;

public class BlikoModel extends EntityModel<BlikoRenderState> {
    public static final EntityModelLayer BLIKO = new EntityModelLayer(
            Identifier.of(Prixilium.MOD_ID, "bliko"), "main");

    public BlikoModel(ModelPart root) {
        super(root);
        ModelPart body = root.getChild("Body");
        ModelPart main = body.getChild("Main");
        ModelPart arms = main.getChild("Arms");
        ModelPart leftArm = arms.getChild("LeftArm");
        ModelPart rightArm = arms.getChild("RightArm");
        ModelPart top = body.getChild("Top");
        ModelPart legs = root.getChild("Legs");
        ModelPart leftLeg = legs.getChild("LeftLeg");
        ModelPart rightLeg = legs.getChild("RightLeg");
    }

    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData Body = modelPartData.addChild("Body", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 24.0F, 0.0F));
        ModelPartData Main = Body.addChild("Main", ModelPartBuilder.create().uv(0, 0).cuboid(-5.0F, -11.0F, -4.0F, 10.0F, 10.0F, 8.0F, new Dilation(0.0F))
                .uv(0, 18).cuboid(-4.0F, -10.0F, -3.0F, 8.0F, 8.0F, 6.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));
        ModelPartData Arms = Main.addChild("Arms", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));
        ModelPartData LeftArm = Arms.addChild("LeftArm", ModelPartBuilder.create().uv(10, 32).cuboid(-1.9979F, -0.2908F, -1.5F, 2.0F, 4.0F, 3.0F, new Dilation(0.0F)), ModelTransform.pivot(4.0F, -8.0F, 0.0F));
        ModelPartData RightArm = Arms.addChild("RightArm", ModelPartBuilder.create().uv(0, 32).cuboid(-0.0021F, -0.2908F, -1.5F, 2.0F, 4.0F, 3.0F, new Dilation(0.0F)), ModelTransform.pivot(-4.0F, -8.0F, 0.0F));
        ModelPartData Top = Body.addChild("Top", ModelPartBuilder.create().uv(28, 18).cuboid(-3.5F, -9.0F, 0.0F, 7.0F, 9.0F, 0.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -10.0F, 0.0F));
        ModelPartData Legs = modelPartData.addChild("Legs", ModelPartBuilder.create(), ModelTransform.pivot(-2.0F, 28.0F, 0.0F));
        ModelPartData LeftLeg = Legs.addChild("LeftLeg", ModelPartBuilder.create().uv(28, 27).cuboid(-1.5F, 0.0F, -1.0F, 3.0F, 3.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(4.3F, -7.0F, 0.0F));
        ModelPartData RightLeg = Legs.addChild("RightLeg", ModelPartBuilder.create().uv(28, 32).cuboid(-1.5F, 0.0F, -1.0F, 3.0F, 3.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(-0.3F, -7.0F, 0.0F));
        return TexturedModelData.of(modelData, 64, 64);
    }

    @Override
    public void setAngles(BlikoRenderState state) {
        super.setAngles(state);
        this.animate(state.walkAnimationState, BlikoAnimations.WALK, state.age);
        this.animate(state.idleAnimationState, BlikoAnimations.IDLE, state.age);
        this.animate(state.holdingFoodAnimationState, BlikoAnimations.HOLDING_FOOD, state.age);
    }
}