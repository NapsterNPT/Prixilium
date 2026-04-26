package net.napsternpt.prixilium.mixin;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.registry.RegistryKey;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.TeleportTarget;
import net.minecraft.world.World;
import net.napsternpt.prixilium.effect.ModEffects;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Objects;

@Mixin(PlayerEntity.class)
public class PlayerSleepMixin {

	@Inject(method = "wakeUp", at = @At("TAIL"))
	private void onWakeUp(CallbackInfo ci) {
		PlayerEntity player = (PlayerEntity)(Object)this;

		if (!player.getWorld().isClient && player.hasStatusEffect(ModEffects.ILLNESS)) {
			if (player instanceof ServerPlayerEntity serverPlayer) {
				MinecraftServer server = serverPlayer.getServer();

                assert server != null;
                RegistryKey<World> dimensionKey = Objects.requireNonNull(server.getWorld(World.NETHER)).getRegistryKey(); //RegistryKey.of(RegistryKeys.WORLD, Identifier.of(Prixilium.MOD_ID, "prixiverse"));

                ServerWorld destination = server.getWorld(dimensionKey);

				if (destination != null) {
					serverPlayer.teleportTo(new TeleportTarget(destination, serverPlayer.getPos(), serverPlayer.getVelocity(), serverPlayer.getYaw(), serverPlayer.getPitch(), TeleportTarget.NO_OP));
				}
			}
		}
	}
}