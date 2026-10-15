package net.napsternpt.prixilium.mixin;

import net.minecraft.client.resource.SplashTextResourceSupplier;
import net.minecraft.resource.ResourceManager;
import net.minecraft.text.Style;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.profiler.Profiler;
import net.napsternpt.prixilium.Prixilium;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Mixin(SplashTextResourceSupplier.class)
public abstract class SplashTextResourceSupplierMixin {

	@Shadow
	private List<Text> splashTexts;

	@Inject(method = "apply(Ljava/util/List;Lnet/minecraft/resource/ResourceManager;Lnet/minecraft/util/profiler/Profiler;)V", at = @At("TAIL"))
	private void prixilium$appendCustomSplashes(List<Text> texts, ResourceManager resourceManager, Profiler profiler, CallbackInfo ci) {
		Identifier id = Identifier.of(Prixilium.MOD_ID, "texts/splashes.txt");
		if (resourceManager.getResource(id).isEmpty()) return;

		try (BufferedReader reader = resourceManager.openAsReader(id)) {
			List<Text> custom = reader.lines()
					.map(String::trim)
					.filter(line -> !line.isBlank())
					.<Text>map(line -> Text.literal(line).setStyle(Style.EMPTY.withColor(0xFFFF00)))
					.toList();

			if (custom.isEmpty()) return;

			List<Text> combined = new ArrayList<>(splashTexts);
			combined.addAll(custom);
			splashTexts = List.copyOf(combined);
		} catch (IOException e) {
			Prixilium.LOGGER.error("Failed to load custom splash texts", e);
		}
	}
}
