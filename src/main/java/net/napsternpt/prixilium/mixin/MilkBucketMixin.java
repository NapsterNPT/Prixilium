package net.napsternpt.prixilium.mixin;

import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.consume.ClearAllEffectsConsumeEffect;
import net.minecraft.world.World;
import net.napsternpt.prixilium.effect.ModEffects;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ClearAllEffectsConsumeEffect.class)
public class MilkBucketMixin {

	@Inject(method = "onConsume", at = @At("HEAD"), cancellable = true)
	private void preventIllnessRemoval(World world, ItemStack stack, LivingEntity entity, CallbackInfoReturnable<Boolean> cir) {
		if (entity.hasStatusEffect(ModEffects.ILLNESS)) {
			entity.getActiveStatusEffects().entrySet().removeIf(e -> !e.getKey().equals(ModEffects.ILLNESS));
			cir.setReturnValue(false);
			cir.cancel();
		}
	}
}