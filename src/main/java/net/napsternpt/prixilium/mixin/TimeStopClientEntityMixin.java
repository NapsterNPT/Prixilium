package net.napsternpt.prixilium.mixin;

import net.minecraft.entity.Entity;
import net.minecraft.world.World;
import net.napsternpt.prixilium.client.TimeStopClientEffects;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Entity.class)
public class TimeStopClientEntityMixin {
    @Inject(method = "tick", at = @At("HEAD"), cancellable = true)
    private void onTick(CallbackInfo ci) {
        Entity entity = (Entity) (Object) this;
        World world = entity.getWorld();
        if (world.isClient) {
            if (TimeStopClientEffects.isTimeStopped() && TimeStopClientEffects.isActivator(entity.getUuid())) {
                ci.cancel();
            }
        }
    }
}
