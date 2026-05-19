package net.napsternpt.prixilium.hud;

import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.text.Text;
import net.napsternpt.prixilium.effect.ModEffects;

public class ThermometerHud {

    private static int value = 0;
    private static boolean active = false;

    public static void increment() {
        active = true;
        value = Math.min(value + 1, 100);
    }

    public static void reset() {
        value = 0;
        active = false;
    }

    public static void register() {
        HudRenderCallback.EVENT.register((drawContext, tickDelta) -> {

            MinecraftClient client = MinecraftClient.getInstance();

            if (!active || client.player == null) return;

            int screenWidth = client.getWindow().getScaledWidth();
            int screenHeight = client.getWindow().getScaledHeight();
            int guiWidth = 240;
            int guiHeight = 60;
            int x = (screenWidth - guiWidth) / 2;
            int y = (screenHeight - guiHeight) / 2;

            drawContext.fill(x, y, x + guiWidth, y + guiHeight, 0xAA000000);
            drawContext.drawBorder(x, y, guiWidth, guiHeight, 0xFFFFCB00);
            drawContext.drawCenteredTextWithShadow(client.textRenderer, Text.literal("Thermometer"), screenWidth / 2, y + 8, 0xFFFFCB00);

            int barWidth = guiWidth - 20;
            int filledWidth = (int)(barWidth * (value / 100.0f));

            drawContext.fill(x + 10, y + 25, x + 10 + barWidth, y + 35, 0xFF333333);
            drawContext.fill(x + 10, y + 25, x + 10 + filledWidth, y + 35, 0xFFFF4444);

            if (value != 100) {
                assert client.world != null;
                long ticks = client.world.getTime() % 40;
                String dot = "";
                if (ticks >= 10) dot += ".";
                if (ticks >= 20) dot += ".";
                if (ticks >= 30) dot += ".";
                drawContext.drawCenteredTextWithShadow(client.textRenderer, Text.translatable("hud.termometer.player_scanning").getString() + dot, screenWidth / 2, y + 42, 0xFFFFFFFF);
            } else {
                if (client.player != null && client.player.hasStatusEffect(ModEffects.ILLNESS) && value == 100) {
                    drawContext.drawCenteredTextWithShadow(client.textRenderer, Text.translatable("hud.termometer.player_ill"), screenWidth / 2, y + 42, 0xFFFFFFFF);
                } else if (client.player != null && !client.player.hasStatusEffect(ModEffects.ILLNESS) && value == 100) {
                    drawContext.drawCenteredTextWithShadow(client.textRenderer, Text.translatable("hud.termometer.player_not_ill"), screenWidth / 2, y + 42, 0xFFFFFFFF);
                } else {
                    drawContext.drawCenteredTextWithShadow(client.textRenderer, Text.translatable("hud.termometer.player_not_found"), screenWidth / 2, y + 42, 0xFFFFFFFF);
                }
            }
        });
    }
}
