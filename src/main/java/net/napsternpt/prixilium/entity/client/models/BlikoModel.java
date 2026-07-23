package net.napsternpt.prixilium.entity.client.models;

import net.minecraft.client.model.*;
import net.minecraft.client.render.entity.animation.Animation;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;
import net.napsternpt.prixilium.Prixilium;
import net.napsternpt.prixilium.entity.client.animations.BlikoAnimations;
import net.napsternpt.prixilium.entity.client.renderstates.BlikoRenderState;

public class BlikoModel extends EntityModel<BlikoRenderState> {
    public static final EntityModelLayer BLIKO = new EntityModelLayer(
            Identifier.of(Prixilium.MOD_ID, "bliko"), "main");

    private final Animation idleingAnimation;
    private final Animation walkingAnimation;
    private final Animation sitingAnimation;

    public BlikoModel(ModelPart root) {
        super(root);
        ModelPart body = root.getChild("Body");
        ModelPart main = body.getChild("Main");
        ModelPart arms = main.getChild("Arms");
        arms.getChild("LeftArm");
        arms.getChild("RightArm");
        body.getChild("Top");
        ModelPart legs = root.getChild("Legs");
        legs.getChild("LeftLeg");
        legs.getChild("RightLeg");

        this.idleingAnimation = BlikoAnimations.IDLE.createAnimation(root);
        this.walkingAnimation = BlikoAnimations.WALK.createAnimation(root);
        this.sitingAnimation = BlikoAnimations.SIT.createAnimation(root);
    }

    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData Body = modelPartData.addChild("Body", ModelPartBuilder.create(), ModelTransform.rotation(0.0F, 24.0F, 0.0F));
        ModelPartData Main = Body.addChild("Main", ModelPartBuilder.create().uv(0, 0).cuboid(-5.0F, -11.0F, -4.0F, 10.0F, 10.0F, 8.0F,
                new Dilation(0.0F)).uv(0, 18).cuboid(-4.0F, -10.0F, -3.0F, 8.0F, 8.0F, 6.0F,
                new Dilation(0.0F)), ModelTransform.rotation(0.0F, 0.0F, 0.0F));
        ModelPartData Arms = Main.addChild("Arms", ModelPartBuilder.create(), ModelTransform.rotation(0.0F, 0.0F, 0.0F));
        ModelPartData LeftArm = Arms.addChild("LeftArm", ModelPartBuilder.create(), ModelTransform.rotation(4.0F, -8.0F, 0.0F));
        ModelPartData Base_r1 = LeftArm.addChild("Base_r1", ModelPartBuilder.create().uv(10, 32).cuboid(-1.9979F, -0.2908F, -1.5F, 2.0F, 4.0F, 3.0F,
                new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.7854F));
        ModelPartData RightArm = Arms.addChild("RightArm", ModelPartBuilder.create(), ModelTransform.rotation(-4.0F, -8.0F, 0.0F));
        ModelPartData Base_r2 = RightArm.addChild("Base_r2", ModelPartBuilder.create().uv(0, 32).cuboid(-0.0021F, -0.2908F, -1.5F, 2.0F, 4.0F, 3.0F,
                new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.7854F));
        ModelPartData Top = Body.addChild("Top", ModelPartBuilder.create().uv(28, 18).cuboid(-3.5F, -9.0F, 0.0F, 7.0F, 9.0F, 0.0F,
                new Dilation(0.0F)), ModelTransform.rotation(0.0F, -10.0F, 0.0F));
        ModelPartData Legs = modelPartData.addChild("Legs", ModelPartBuilder.create(), ModelTransform.rotation(-2.0F, 28.0F, 0.0F));
        ModelPartData LeftLeg = Legs.addChild("LeftLeg", ModelPartBuilder.create().uv(28, 32).cuboid(-1.5F, 0.0F, -1.0F, 3.0F, 3.0F, 2.0F,
                new Dilation(0.0F)), ModelTransform.rotation(4.3F, -7.0F, 0.0F));
        ModelPartData RightLeg = Legs.addChild("RightLeg", ModelPartBuilder.create().uv(28, 27).cuboid(-1.5F, 0.0F, -1.0F, 3.0F, 3.0F, 2.0F,
                new Dilation(0.0F)), ModelTransform.rotation(-0.3F, -7.0F, 0.0F));
        return TexturedModelData.of(modelData, 64, 64);
    }

    @Override
    public void setAngles(BlikoRenderState state) {
        super.setAngles(state);
        this.walkingAnimation.applyWalking(state.limbSwingAnimationProgress, state.limbSwingAmplitude, 2f, 2.5f);
        this.idleingAnimation.apply(state.idleAnimationState, state.age, 1f);
        this.sitingAnimation.apply(state.sitAnimationState, state.age, 1f);
    }
}