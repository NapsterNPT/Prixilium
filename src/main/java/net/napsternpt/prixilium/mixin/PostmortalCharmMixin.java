package net.napsternpt.prixilium.mixin;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.server.network.ServerPlayerEntity;
import net.napsternpt.prixilium.item.custom.charm.PostmortalCharmItem;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(LivingEntity.class)
public class PostmortalCharmMixin {

    @Inject(method = "tryUseDeathProtector", at = @At("HEAD"), cancellable = true)
    private void onTryUseDeathProtector(DamageSource source, CallbackInfoReturnable<Boolean> cir) {
        LivingEntity entity = (LivingEntity) (Object) this;
        if (entity instanceof ServerPlayerEntity player) {
            if (PostmortalCharmItem.tryUse(player, source)) {
                cir.setReturnValue(true);
                cir.cancel();
            }
        }
    }
}
