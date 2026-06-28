package net.napsternpt.prixilium.mixin;

import net.minecraft.entity.Entity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.World;
import net.napsternpt.prixilium.util.TimeStopState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Entity.class)
public class TimeStopEntityMixin {
    @Inject(method = "tick", at = @At("HEAD"), cancellable = true)
    private void onTick(CallbackInfo ci) {
        Entity entity = (Entity) (Object) this;
        World world = entity.getEntityWorld();
        if (!world.isClient() && world instanceof ServerWorld serverWorld) {
            if (TimeStopState.isTimeStopped(serverWorld) && TimeStopState.isActivator(serverWorld, entity.getUuid())) {
                ci.cancel();
            }
        }
    }
}
