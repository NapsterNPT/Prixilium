package net.napsternpt.prixilium.hud;

import net.fabricmc.fabric.api.client.rendering.v1.HudLayerRegistrationCallback;
import net.fabricmc.fabric.api.client.rendering.v1.IdentifiedLayer;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.RenderTickCounter;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.napsternpt.prixilium.Prixilium;
import net.napsternpt.prixilium.effect.ModEffects;

public class ThermometerHud {

    private static final Identifier BAR = Identifier.of(Prixilium.MOD_ID, "textures/gui/thermometer/bar.png");
    private static final Identifier BAR_BACKGROUND = Identifier.of(Prixilium.MOD_ID, "textures/gui/thermometer/bar_background.png");

    private static int value = 0;
    private static boolean active = false;

    private static final TagKey<Item> TEMPERATURE_TOOLS = TagKey.of(RegistryKeys.ITEM, Identifier.of(Prixilium.MOD_ID, "temperature_tools"));

    public static void increment() {
        active = true;
        value = Math.min(value + 1, 100);
    }

    public static void reset() {
        value = 0;
        active = false;
    }

    public static boolean isActive() {return active;}

    public static void register() {
        HudLayerRegistrationCallback.EVENT.register(layeredDrawer -> layeredDrawer.attachLayerAfter(IdentifiedLayer.MISC_OVERLAYS,
                        Identifier.of(Prixilium.MOD_ID, "thermometer_hud"),
                        ThermometerHud::render
        ));
    }

    private static void render(DrawContext drawContext, RenderTickCounter tickCounter) {
        MinecraftClient client = MinecraftClient.getInstance();
        if (!active || client.player == null) return;

        boolean holdingCorrectItem = client.player.getMainHandStack().isIn(TEMPERATURE_TOOLS) || client.player.getOffHandStack().isIn(TEMPERATURE_TOOLS);
        if (!holdingCorrectItem) {
            reset();
            return;
        }

        int screenWidth = client.getWindow().getScaledWidth();
        int screenHeight = client.getWindow().getScaledHeight();
        int guiWidth = 256;
        int guiHeight = 75;
        int centerX = screenWidth / 2;
        int x = (screenWidth - guiWidth) / 2;
        int y = (screenHeight - guiHeight) / 2;
        int barWidth = 256;
        int barHeight = 64;

        int filledWidth = (int) (barWidth * (value / 100.0f));
        drawContext.drawTexture(RenderLayer::getGuiTextured, BAR_BACKGROUND, x, y, 0, 0, barWidth, barHeight, barWidth, barHeight);
        drawContext.drawTexture(RenderLayer::getGuiTextured, BAR, x, y, 0, 0, filledWidth, barHeight, barWidth, barHeight);

        if (value != 100) {
            assert client.world != null;
            long ticks = client.world.getTime() % 40;
            String dot = "";
            if (ticks >= 10) dot += ".";
            if (ticks >= 20) dot += ".";
            if (ticks >= 30) dot += ".";
            drawContext.drawCenteredTextWithShadow(client.textRenderer,
                    Text.translatable("hud.thermometer.player_measuring").getString() + dot,
                    centerX, y + guiHeight - 10, 0xFFFFFFFF);
        } else {
            if (client.player.hasStatusEffect(ModEffects.ILLNESS)){
                drawContext.drawCenteredTextWithShadow(client.textRenderer,
                        Text.translatable("hud.thermometer.player_ill"),
                        centerX, y + guiHeight - 10, 0xFFFFFFFF);
            } else {
                drawContext.drawCenteredTextWithShadow(client.textRenderer,
                        Text.translatable("hud.thermometer.player_not_ill"),
                        centerX, y + guiHeight - 10, 0xFFFFFFFF);
            }
        }
    }
}