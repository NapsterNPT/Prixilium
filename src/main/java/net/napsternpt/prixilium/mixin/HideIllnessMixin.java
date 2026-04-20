package net.napsternpt.prixilium.mixin;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.napsternpt.prixilium.effect.ModEffects;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Collection;

import static java.util.stream.Collectors.toList;

@Mixin(LivingEntity.class)
public class HideIllnessMixin {

    @Inject(method = "getStatusEffects", at = @At("RETURN"), cancellable = true)
    private void filterIllness(CallbackInfoReturnable<Collection<StatusEffectInstance>> cir) {
        LivingEntity entity = (LivingEntity)(Object)this;

        if (entity instanceof PlayerEntity player && player.isCreative()) return;

        Collection<StatusEffectInstance> filtered = cir.getReturnValue().stream()
                .filter(e -> !e.getEffectType().equals(ModEffects.ILLNESS))
                .collect(toList());
        cir.setReturnValue(filtered);
    }
}