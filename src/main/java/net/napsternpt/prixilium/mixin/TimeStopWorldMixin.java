package net.napsternpt.prixilium.mixin;

import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.World;
import net.napsternpt.prixilium.util.TimeStopState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(World.class)
public class TimeStopWorldMixin {
    @Inject(method = "tickBlockEntities", at = @At("HEAD"), cancellable = true)
    private void onTickBlockEntities(CallbackInfo ci) {
        World world = (World) (Object) this;
        if (world instanceof ServerWorld serverWorld && TimeStopState.isTimeStopped(serverWorld)) {
            ci.cancel();
        }
    }
}
