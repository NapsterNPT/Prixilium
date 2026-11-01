package net.napsternpt.prixilium.screen.custom;

import net.minecraft.client.gl.RenderPipelines;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.texture.NativeImage;
import net.minecraft.resource.Resource;
import net.minecraft.text.OrderedText;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.napsternpt.prixilium.Prixilium;
import org.jspecify.annotations.NonNull;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UncheckedIOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class LetterScreen extends Screen {
    private record LetterTexture(int width, int height, float centerX, float centerY) {}

    private static final Identifier TEXTURE = Identifier.of(Prixilium.MOD_ID, "textures/gui/letter.png");
    private static final Identifier COMPLETIONIST = Identifier.of(Prixilium.MOD_ID, "completionist");
    private static final Identifier DEFAULT_LETTER_TEXT = Identifier.of(Prixilium.MOD_ID, "texts/letter.txt");
    private static final Identifier COMPLETIONIST_LETTER_TEXT = Identifier.of(Prixilium.MOD_ID, "texts/letter_completionist.txt");

    private int textureWidth;
    private int textureHeight;
    private int drawWidth;
    private int drawHeight;
    private int drawX;
    private int drawY;
    private int textCenterX;
    private int textCenterY;

    private final List<OrderedText> wrappedLines = new ArrayList<>();

    public LetterScreen() {
        super(Text.empty());
    }

    @Override
    protected void init() {
        textureWidth = 0;
        textureHeight = 0;
        drawWidth = 0;
        drawHeight = 0;
        wrappedLines.clear();

        assert client != null;
        String playerName = client.player != null ? client.player.getName().getString() : "";

        Resource textureResource = client.getResourceManager().getResource(TEXTURE).orElseThrow();
        LetterTexture texture = readTexture(textureResource);
        textureWidth = texture.width();
        textureHeight = texture.height();

        drawWidth = textureWidth;
        drawHeight = textureHeight;
        drawX = (width - drawWidth) / 2;
        drawY = (height - drawHeight) / 2;
        textCenterX = Math.round(drawX + texture.centerX());
        textCenterY = Math.round(drawY + texture.centerY());

        Identifier textId = hasCompletionistAdvancement() ? COMPLETIONIST_LETTER_TEXT : DEFAULT_LETTER_TEXT;
        Resource resource = client.getResourceManager().getResource(textId).orElseThrow();
        List<String> lines = createLines(resource, playerName);

        int wrapWidth = Math.max(1, (int) (drawWidth * 0.925f));
        for (String line : lines) {
            if (line.isBlank()) wrappedLines.add(OrderedText.EMPTY);
            else wrappedLines.addAll(textRenderer.wrapLines(Text.literal(line), wrapWidth));
        }
    }

    private boolean hasCompletionistAdvancement() {
        if (client == null || client.getNetworkHandler() == null) return false;
        return client.getNetworkHandler().getAdvancementHandler().get(COMPLETIONIST) != null;
    }

    private static @NonNull List<String> createLines(Resource resource, String playerName) {
        List<String> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(resource.getInputStream(), StandardCharsets.UTF_8))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line.replace("%player_name%", playerName).replace("%Player_Name%", playerName));
            }
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }

        while (!lines.isEmpty() && lines.getFirst().isBlank()) lines.removeFirst();
        while (!lines.isEmpty() && lines.getLast().isBlank()) lines.removeLast();
        return lines;
    }

    private static @NonNull LetterTexture readTexture(Resource resource) {
        try (InputStream in = resource.getInputStream(); NativeImage image = NativeImage.read(in)) {
            int width = image.getWidth();
            int height = image.getHeight();

            int minX = width;
            int minY = height;
            int maxX = -1;
            int maxY = -1;
            for (int py = 0; py < height; py++) {
                for (int px = 0; px < width; px++) {
                    if ((image.getColorArgb(px, py) >>> 24) > 8) {
                        minX = Math.min(minX, px);
                        minY = Math.min(minY, py);
                        maxX = Math.max(maxX, px);
                        maxY = Math.max(maxY, py);
                    }
                }
            }

            float centerX = maxX >= minX ? (minX + maxX) / 2.0f : width / 2.0f;
            float centerY = maxY >= minY ? (minY + maxY) / 2.0f : height / 2.0f;
            return new LetterTexture(width, height, centerX, centerY);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }
    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        if (drawWidth > 0 && drawHeight > 0) {
            context.drawTexture(RenderPipelines.GUI_TEXTURED, TEXTURE, drawX, drawY, 0f, 0f, drawWidth, drawHeight, textureWidth, textureHeight, textureWidth, textureHeight);

            int textHeight = wrappedLines.size() * 14;
            int startY = textCenterY - textHeight / 2 - 25;

            for (int i = 0; i < wrappedLines.size(); i++) {
                int y = startY + i * 14;
                OrderedText line = wrappedLines.get(i);
                int x = textCenterX - textRenderer.getWidth(line) / 2;
                context.drawText(textRenderer, line, x, y, 0xFFCFB062, false);
            }
        }

        super.render(context, mouseX, mouseY, delta);
    }

    @Override
    protected void applyBlur(DrawContext context) {
        // No
    }

    @Override
    public boolean shouldPause() {
        return false;
    }
}
