package net.napsternpt.prixilium.mixin;

import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.hud.InGameHud;
import net.minecraft.client.render.RenderTickCounter;
import net.napsternpt.prixilium.hud.ThermometerHud;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(InGameHud.class)
public class InGameHudMixin {

	@Inject(
			method = "renderCrosshair",
			at = @At("HEAD"),
			cancellable = true
	)
	private void hideCrosshair(DrawContext context, RenderTickCounter tickCounter, CallbackInfo ci) {

		if (ThermometerHud.isActive()) {
			ci.cancel();
		}
	}
}