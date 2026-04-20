package net.napsternpt.prixilium.mixin;

import net.minecraft.entity.LivingEntity;
import net.napsternpt.prixilium.effect.ModEffects;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(LivingEntity.class)
public class MilkBucketMixin {

	@Inject(method = "clearStatusEffects", at = @At("HEAD"), cancellable = true)
	private void preventIllnessRemoval(CallbackInfoReturnable<Boolean> cir) {
		LivingEntity entity = (LivingEntity)(Object)this;

		if (entity.hasStatusEffect(ModEffects.ILLNESS)) {
			entity.getActiveStatusEffects().entrySet().removeIf(e -> !e.getKey().equals(ModEffects.ILLNESS));
			cir.setReturnValue(true);
			cir.cancel();
		}
	}
}