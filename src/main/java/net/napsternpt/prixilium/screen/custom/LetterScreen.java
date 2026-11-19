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
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class LetterScreen extends Screen {
    private record LetterTexture(int width, int height, float centerX, float centerY) {}

    private static final Identifier TEXTURE = Identifier.of(Prixilium.MOD_ID, "textures/gui/letter.png");
    private static final Identifier DEFAULT_LETTER_TEXT = Identifier.of(Prixilium.MOD_ID, "texts/letter.txt");
    private static final Identifier COMPLETIONIST_LETTER_TEXT = Identifier.of(Prixilium.MOD_ID, "texts/letter_completionist.txt");

    private static CompletableFuture<String> codeFuture;
    private static volatile String cachedCode = "loading...";
    private int textureWidth;
    private int textureHeight;
    private int drawWidth;
    private int drawHeight;
    private int drawX;
    private int drawY;
    private int textCenterX;
    private int textCenterY;

    private final List<OrderedText> wrappedLines = new ArrayList<>();
    private List<String> sourceLines = List.of();
    private String playerName = "";

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
        sourceLines = List.of();

        assert client != null;
        playerName = client.player != null ? client.player.getName().getString() : "";

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
        sourceLines = readLines(resource);
        rebuildWrappedLines();

        getCodeFuture().thenAccept(code -> client.execute(() -> {
            if (client.currentScreen != this || code.equals(cachedCode)) return;
            cachedCode = code;
            rebuildWrappedLines();
        }));
    }

    private boolean hasCompletionistAdvancement() {
        if (client == null || client.getNetworkHandler() == null) return false;
        return client.getNetworkHandler().getAdvancementHandler().get(Identifier.of(Prixilium.MOD_ID, "completionist")) != null;
    }

    private static @NonNull List<String> readLines(Resource resource) {
        List<String> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(resource.getInputStream(), StandardCharsets.UTF_8))) {
            String line;
            while ((line = reader.readLine()) != null) lines.add(line);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }

        while (!lines.isEmpty() && lines.getFirst().isBlank()) lines.removeFirst();
        while (!lines.isEmpty() && lines.getLast().isBlank()) lines.removeLast();
        return lines;
    }

    private static @NonNull List<String> substitute(List<String> sourceLines, String playerName, String code) {
        List<String> lines = new ArrayList<>(sourceLines.size());
        for (String line : sourceLines) {
            lines.add(line.replace("%player_name%", playerName)
                    .replace("%Player_Name%", playerName)
                    .replace("%code%", code));
        }
        return lines;
    }

    private void rebuildWrappedLines() {
        wrappedLines.clear();
        int wrapWidth = Math.max(1, (int) (drawWidth * 0.925f));
        for (String line : substitute(sourceLines, playerName, cachedCode)) {
            if (line.isBlank()) wrappedLines.add(OrderedText.EMPTY);
            else wrappedLines.addAll(textRenderer.wrapLines(Text.literal(line), wrapWidth));
        }
    }

    private static CompletableFuture<String> getCodeFuture() {
        if (codeFuture == null) {
            HttpRequest request = HttpRequest.newBuilder(URI.create("https://napsternpt.github.io/prixilium_text.txt"))
                    .timeout(Duration.ofSeconds(5))
                    .GET()
                    .build();
            codeFuture = HttpClient.newBuilder().connectTimeout(Duration.ofSeconds(5)).build()
                    .sendAsync(request, HttpResponse.BodyHandlers.ofString(StandardCharsets.UTF_8))
                    .handle(LetterScreen::readRemoteCode);
        }
        return codeFuture;
    }

    private static String readRemoteCode(HttpResponse<String> response, Throwable throwable) {
        if (throwable != null || response == null) return "loading...";
        if (response.statusCode() < 200 || response.statusCode() >= 300) return "loading...";

        String body = response.body();
        if (body == null) return "loading...";
        String code = body.strip();
        int lineEnd = -1;
        for (int i = 0; i < code.length(); i++) {
            char c = code.charAt(i);
            if (c == '\n' || c == '\r') {
                lineEnd = i;
                break;
            }
        }
        if (lineEnd >= 0) code = code.substring(0, lineEnd).strip();
        if (code.isEmpty() || code.length() > 128) return "loading...";
        return code;
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
