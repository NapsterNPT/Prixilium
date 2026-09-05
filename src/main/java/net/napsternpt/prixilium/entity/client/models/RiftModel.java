package net.napsternpt.prixilium.entity.client.models;

import net.minecraft.client.model.*;
import net.minecraft.client.render.entity.animation.Animation;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;
import net.napsternpt.prixilium.Prixilium;
import net.napsternpt.prixilium.entity.client.animations.RiftAnimations;
import net.napsternpt.prixilium.entity.client.renderstates.RiftRenderState;

public class RiftModel extends EntityModel<RiftRenderState> {
	public static final EntityModelLayer RIFT = new EntityModelLayer(
			Identifier.of(Prixilium.MOD_ID, "rift"), "main");

	private final Animation spawnAnimation;
	private final Animation idleAnimation;
	private final Animation walkAnimation;
	private final Animation slamAnimation;
	private final Animation spinAnimation;

	public RiftModel(ModelPart root) {
		super(root);
		ModelPart main = root.getChild("Main");
		ModelPart body = main.getChild("Body");
		ModelPart rightArm = main.getChild("RightArm");
		rightArm.getChild("FirstR");
		rightArm.getChild("SecondR");
		rightArm.getChild("ThirdR");
		rightArm.getChild("FourthR");
		rightArm.getChild("FifthR");
		ModelPart leftArm = main.getChild("LeftArm");
		leftArm.getChild("FirstL");
		leftArm.getChild("SecondL");
		leftArm.getChild("ThirdL");
		leftArm.getChild("FourthL");
		leftArm.getChild("FifthL");
		ModelPart rightEye = body.getChild("RightEye");
		rightEye.getChild("RightPupil");
		ModelPart leftEye = body.getChild("LeftEye");
		leftEye.getChild("LeftPupil");

		this.spawnAnimation = RiftAnimations.SPAWN.createAnimation(root);
		this.idleAnimation = RiftAnimations.IDLE.createAnimation(root);
		this.walkAnimation = RiftAnimations.WALK.createAnimation(root);
		this.slamAnimation = RiftAnimations.SLAM.createAnimation(root);
		this.spinAnimation = RiftAnimations.SPIN.createAnimation(root);
	}

	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData Main = modelPartData.addChild("Main", ModelPartBuilder.create(), ModelTransform.origin(0.0F, 24.0F, 0.0F));
		ModelPartData Body = Main.addChild("Body", ModelPartBuilder.create().uv(0, 0).cuboid(-16.0F, -16.0F, -16.0F, 32.0F, 32.0F, 32.0F, new Dilation(0.0F))
		.uv(0, 64).cuboid(-8.0F, -8.0F, -8.0F, 16.0F, 16.0F, 16.0F, new Dilation(0.0F)), ModelTransform.origin(0.0F, -16.0F, 0.0F));
		ModelPartData RightEye = Body.addChild("RightEye", ModelPartBuilder.create().uv(88, 95).cuboid(-2.0F, -4.0F, 0.0F, 5.0F, 5.0F, 1.0F, new Dilation(0.0F)), ModelTransform.origin(7.0F, -7.0F, -17.0F));
		ModelPartData cube_r1 = RightEye.addChild("cube_r1", ModelPartBuilder.create().uv(86, 79).cuboid(-3.5F, -1.0F, -1.0F, 7.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.25F, -4.25F, 0.5F, 0.0F, 0.0F, -0.2182F));
		ModelPartData RightPupil = RightEye.addChild("RightPupil", ModelPartBuilder.create().uv(76, 94).cuboid(-0.8F, -1.2F, -1.1F, 1.0F, 1.0F, 0.0F, new Dilation(0.0F))
		.uv(22, 100).cuboid(-1.0F, -2.0F, -1.0F, 2.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.origin(0.0F, 0.0F, 0.5F));
		ModelPartData LeftEye = Body.addChild("LeftEye", ModelPartBuilder.create().uv(76, 95).cuboid(-3.0F, -4.0F, 0.0F, 5.0F, 5.0F, 1.0F, new Dilation(0.0F)), ModelTransform.origin(-7.0F, -7.0F, -17.0F));
		ModelPartData cube_r2 = LeftEye.addChild("cube_r2", ModelPartBuilder.create().uv(86, 76).cuboid(-3.5F, -1.0F, -1.0F, 7.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-0.25F, -4.25F, 0.5F, 0.0F, 0.0F, 0.2182F));
		ModelPartData LeftPupil = LeftEye.addChild("LeftPupil", ModelPartBuilder.create().uv(78, 94).cuboid(-0.2F, -1.2F, -1.1F, 1.0F, 1.0F, 0.0F, new Dilation(0.0F))
		.uv(16, 100).cuboid(-1.0F, -2.0F, -1.0F, 2.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.origin(0.0F, 0.0F, 0.5F));
		ModelPartData RightArm = Main.addChild("RightArm", ModelPartBuilder.create().uv(64, 64).cuboid(1.0F, -5.0F, -2.0F, 7.0F, 11.0F, 4.0F, new Dilation(0.0F))
		.uv(86, 82).cuboid(8.0F, -5.0F, -1.0F, 1.0F, 11.0F, 2.0F, new Dilation(0.0F))
		.uv(92, 82).cuboid(0.0F, -5.0F, -1.0F, 1.0F, 11.0F, 2.0F, new Dilation(0.0F))
		.uv(86, 64).cuboid(1.0F, -6.0F, -1.0F, 7.0F, 1.0F, 2.0F, new Dilation(0.0F))
		.uv(86, 73).cuboid(1.0F, 6.0F, -1.0F, 7.0F, 1.0F, 2.0F, new Dilation(0.0F)), ModelTransform.origin(17.0F, -16.0F, 0.0F));
		ModelPartData FirstR = RightArm.addChild("FirstR", ModelPartBuilder.create().uv(0, 100).cuboid(-1.0F, -3.5F, -1.0F, 2.0F, 4.0F, 2.0F, new Dilation(0.0F)), ModelTransform.origin(7.0F, -7.5F, 0.0F));
		ModelPartData SecondR = RightArm.addChild("SecondR", ModelPartBuilder.create().uv(0, 96).cuboid(0.5F, -1.0F, -1.0F, 4.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.origin(9.5F, -4.0F, 0.0F));
		ModelPartData ThirdR = RightArm.addChild("ThirdR", ModelPartBuilder.create().uv(12, 96).cuboid(0.5F, -1.0F, -1.0F, 4.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.origin(9.5F, -1.0F, 0.0F));
		ModelPartData FourthR = RightArm.addChild("FourthR", ModelPartBuilder.create().uv(24, 96).cuboid(0.5F, -1.0F, -1.0F, 4.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.origin(9.5F, 2.0F, 0.0F));
		ModelPartData FifthR = RightArm.addChild("FifthR", ModelPartBuilder.create().uv(36, 96).cuboid(0.5F, -1.0F, -1.0F, 4.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.origin(9.5F, 5.0F, 0.0F));
		ModelPartData LeftArm = Main.addChild("LeftArm", ModelPartBuilder.create().uv(64, 79).cuboid(-8.0F, -5.0F, -2.0F, 7.0F, 11.0F, 4.0F, new Dilation(0.0F))
		.uv(64, 94).cuboid(-1.0F, -5.0F, -1.0F, 1.0F, 11.0F, 2.0F, new Dilation(0.0F))
		.uv(86, 67).cuboid(-8.0F, 6.0F, -1.0F, 7.0F, 1.0F, 2.0F, new Dilation(0.0F))
		.uv(70, 94).cuboid(-9.0F, -5.0F, -1.0F, 1.0F, 11.0F, 2.0F, new Dilation(0.0F))
		.uv(86, 70).cuboid(-8.0F, -6.0F, -1.0F, 7.0F, 1.0F, 2.0F, new Dilation(0.0F)), ModelTransform.origin(-17.0F, -16.0F, 0.0F));
		ModelPartData FirstL = LeftArm.addChild("FirstL", ModelPartBuilder.create().uv(8, 100).cuboid(-1.0F, -3.5F, -1.0F, 2.0F, 4.0F, 2.0F, new Dilation(0.0F)), ModelTransform.origin(-7.0F, -7.5F, 0.0F));
		ModelPartData SecondL = LeftArm.addChild("SecondL", ModelPartBuilder.create().uv(48, 96).cuboid(-4.5F, -0.5F, -1.0F, 4.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.origin(-9.5F, -4.5F, 0.0F));
		ModelPartData ThirdL = LeftArm.addChild("ThirdL", ModelPartBuilder.create().uv(98, 82).cuboid(-4.5F, -0.5F, -1.0F, 4.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.origin(-9.5F, -1.5F, 0.0F));
		ModelPartData FourthL = LeftArm.addChild("FourthL", ModelPartBuilder.create().uv(98, 86).cuboid(-4.5F, -0.5F, -1.0F, 4.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.origin(-9.5F, 1.5F, 0.0F));
		ModelPartData FifthL = LeftArm.addChild("FifthL", ModelPartBuilder.create().uv(98, 90).cuboid(-4.5F, -0.5F, -1.0F, 4.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.origin(-9.5F, 4.5F, 0.0F));
		return TexturedModelData.of(modelData, 128, 128);
	}

	@Override
	public void setAngles(RiftRenderState state) {
		super.setAngles(state);
		this.spawnAnimation.apply(state.spawnAnimationState, state.age, 1.0F);
		this.idleAnimation.apply(state.idleAnimationState, state.age, 1.0F);
		this.walkAnimation.apply(state.walkAnimationState, state.age, 1.0F);
		this.slamAnimation.apply(state.slamAnimationState, state.age, 1.0F);
		this.spinAnimation.apply(state.spinAnimationState, state.age, 1.0F);
	}
}