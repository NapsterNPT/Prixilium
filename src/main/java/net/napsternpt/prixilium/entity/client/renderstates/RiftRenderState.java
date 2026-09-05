package net.napsternpt.prixilium.entity.client.renderstates;

import net.minecraft.client.render.entity.state.LivingEntityRenderState;
import net.minecraft.entity.AnimationState;

public class RiftRenderState extends LivingEntityRenderState {
	public final AnimationState spawnAnimationState = new AnimationState();
	public final AnimationState idleAnimationState = new AnimationState();
	public final AnimationState walkAnimationState = new AnimationState();
	public final AnimationState slamAnimationState = new AnimationState();
	public final AnimationState spinAnimationState = new AnimationState();
}