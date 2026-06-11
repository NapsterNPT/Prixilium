package net.napsternpt.prixilium.mixin;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gl.PostEffectProcessor;
import net.minecraft.client.render.DefaultFramebufferSet;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.client.render.RenderTickCounter;
import net.minecraft.client.util.Pool;
import net.minecraft.util.Identifier;
import net.napsternpt.prixilium.Prixilium;
import net.napsternpt.prixilium.client.TimeStopClientEffects;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(GameRenderer.class)
public abstract class GameRendererDesaturateMixin {
    @Shadow @Final private MinecraftClient client;
    @Shadow @Final private Pool pool;

    @Unique
    private PostEffectProcessor desaturateEffect = null;

    @Unique
    private static final Identifier DESATURATE_ID = Identifier.of(Prixilium.MOD_ID, "desaturate");

    @Inject(method = "render", at = @At("TAIL"))
    private void onRenderEnd(RenderTickCounter tickCounter, boolean tick, CallbackInfo ci) {
        boolean isStopped = TimeStopClientEffects.isTimeStopped();

        if (isStopped) {
            if (desaturateEffect == null) {
                try {
                    RenderSystem.assertOnRenderThread();
                    desaturateEffect = client.getShaderLoader().loadPostEffect(
                        DESATURATE_ID,
                        DefaultFramebufferSet.MAIN_ONLY
                    );
                } catch (Exception e) {
                    Prixilium.LOGGER.error("Failed to load desaturate post effect", e);
                }
            }
            if (desaturateEffect != null) {
                desaturateEffect.render(client.getFramebuffer(), pool, op -> {});
            }
        } else {
            desaturateEffect = null;
        }
    }
}
