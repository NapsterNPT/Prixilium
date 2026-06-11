package net.napsternpt.prixilium.mixin;

import net.minecraft.server.world.ServerWorld;
import net.napsternpt.prixilium.util.TimeStopState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ServerWorld.class)
public class TimeStopServerWorldMixin {
    @Inject(method = "tick", at = @At("HEAD"))
    private void onTickStart(CallbackInfo ci) {
        ServerWorld world = (ServerWorld) (Object) this;
        TimeStopState.tick(world);
    }
}
