package net.napsternpt.prixilium.mixin;

import net.minecraft.entity.LivingEntity;
import net.napsternpt.prixilium.effect.ModEffects;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(LivingEntity.class)
public class PlayerCureMixin {

	@Inject(method = "clearStatusEffects", at = @At("HEAD"), cancellable = true)
	private void preventIllnessRemoval(CallbackInfoReturnable<Boolean> cir) {
		LivingEntity entity = (LivingEntity)(Object)this;

		StackTraceElement[] stack = Thread.currentThread().getStackTrace();
		for (StackTraceElement element : stack) {
			if (element.getClassName().contains("MilkBucketItem")) {
				if (entity.hasStatusEffect(ModEffects.ILLNESS)) {
					entity.getStatusEffects().removeIf(effect -> !effect.getEffectType().equals(ModEffects.ILLNESS));
					cir.setReturnValue(true);
					cir.cancel();
				}
				return;
			}
		}
	}
}