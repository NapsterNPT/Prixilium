package net.napsternpt.prixilium.mixin;

import net.minecraft.entity.LivingEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.World;
import net.napsternpt.prixilium.util.TimeStopState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LivingEntity.class)
public class TimeStopLivingEntityMixin {
    @Inject(method = "tick", at = @At("HEAD"), cancellable = true)
    private void onTick(CallbackInfo ci) {
        LivingEntity entity = (LivingEntity) (Object) this;
        World world = entity.getEntityWorld();
        if (!world.isClient() && world instanceof ServerWorld serverWorld) {
            if (TimeStopState.isTimeStopped(serverWorld) && TimeStopState.isActivator(serverWorld, entity.getUuid())) {
                ci.cancel();
            }
        }
    }
}
