package net.napsternpt.prixilium.mixin;

import net.minecraft.entity.LivingEntity;
import net.minecraft.world.World;
import net.napsternpt.prixilium.client.TimeStopClientEffects;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LivingEntity.class)
public class TimeStopClientLivingEntityMixin {
    @Inject(method = "tick", at = @At("HEAD"), cancellable = true)
    private void onTick(CallbackInfo ci) {
        LivingEntity entity = (LivingEntity) (Object) this;
        World world = entity.getWorld();
        if (world.isClient) {
            if (TimeStopClientEffects.isTimeStopped() && TimeStopClientEffects.isActivator(entity.getUuid())) {
                ci.cancel();
            }
        }
    }
}
