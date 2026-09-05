package net.napsternpt.prixilium.mixin;

import net.minecraft.client.render.entity.LivingEntityRenderer;
import net.minecraft.client.render.entity.state.LivingEntityRenderState;
import net.minecraft.entity.LivingEntity;
import net.napsternpt.prixilium.effect.ModEffects;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LivingEntityRenderer.class)
public abstract class StunnedRigidBodyMixin {
    @Inject(
            method = "updateRenderState(Lnet/minecraft/entity/LivingEntity;Lnet/minecraft/client/render/entity/state/LivingEntityRenderState;F)V",
            at = @At("TAIL")
    )
    private void prixilium$stunnedRigidBody(LivingEntity entity, LivingEntityRenderState renderState, float tickDelta, CallbackInfo ci) {
        if (entity.hasStatusEffect(ModEffects.STUNNED)) {
            renderState.limbSwingAnimationProgress = 0.0F;
            renderState.limbSwingAmplitude = 0.0F;
        }
    }
}
