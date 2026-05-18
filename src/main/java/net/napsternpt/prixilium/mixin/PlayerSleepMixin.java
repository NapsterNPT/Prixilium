package net.napsternpt.prixilium.mixin;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Identifier;
import net.minecraft.world.TeleportTarget;
import net.napsternpt.prixilium.Prixilium;
import net.napsternpt.prixilium.effect.ModEffects;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlayerEntity.class)
public class PlayerSleepMixin {

	@Inject(method = "wakeUp", at = @At("TAIL"))
	private void onWakeUp(CallbackInfo ci) {
		PlayerEntity player = (PlayerEntity)(Object)this;

		if (!player.getWorld().isClient && player.hasStatusEffect(ModEffects.ILLNESS)) {
			if (player instanceof ServerPlayerEntity serverPlayer) {
				MinecraftServer server = serverPlayer.getServer();

                assert server != null;
                ServerWorld destination = server.getWorld(RegistryKey.of(RegistryKeys.WORLD, Identifier.of(Prixilium.MOD_ID, "prixiverse")));

				if (destination != null) {
					serverPlayer.teleportTo(new TeleportTarget(destination, serverPlayer.getPos(), serverPlayer.getVelocity(), serverPlayer.getYaw(), serverPlayer.getPitch(), TeleportTarget.NO_OP));
				}
			}
		}
	}
}