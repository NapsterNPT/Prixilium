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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UncheckedIOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class PrixiverseCreditsScreen extends Screen {
    private record CreditImage(Identifier id, int width, int height, float rotation) {}

    private final Runnable onFinish;
    private final String playerName;
    private final long randomSeed = new Random().nextLong();

    private float scroll = 0;

    private final List<OrderedText> wrappedLines = new ArrayList<>();
    private final List<CreditImage> creditImages = new ArrayList<>();

    public PrixiverseCreditsScreen(String playerName, Runnable onFinish) {
        super(Text.empty());
        this.playerName = playerName;
        this.onFinish = onFinish;
    }

    @Override
    protected void init() {
        wrappedLines.clear();
        creditImages.clear();

        Identifier id = Identifier.of(Prixilium.MOD_ID, "texts/prixiverse.txt");
        assert client != null;
        Resource resource = client.getResourceManager().getResource(id).orElseThrow();

        for (String line : readLines(resource)) {
            line = line.replace("%player_name%", playerName);
            if (line.isBlank()) wrappedLines.add(OrderedText.EMPTY);
            else wrappedLines.addAll(textRenderer.wrapLines(Text.literal(line), width / 3));
        }

        Map<Identifier, Resource> found = client.getResourceManager().findResources("textures/credits", id2 -> id2.getPath().endsWith(".png"));

        found.keySet().stream()
                .sorted(Comparator.comparing(Identifier::getPath))
                .forEach(id2 -> creditImages.add(readCreditImage(id2, found.get(id2))));
    }

    private static List<String> readLines(Resource resource) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(resource.getInputStream(), StandardCharsets.UTF_8))) {
            return reader.lines().toList();
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    private CreditImage readCreditImage(Identifier id, Resource resource) {
        try (InputStream in = resource.getInputStream(); NativeImage image = NativeImage.read(in)) {
            Random random = new Random(randomSeed + id.toString().hashCode());
            float rotation = (float) Math.toRadians(random.nextFloat() * 16f - 8f);
            return new CreditImage(id, image.getWidth(), image.getHeight(), rotation);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        context.fill(0, 0, width, height, 0xFF000000);
        scroll += 0.5f * delta;
        int yOffset = height - (int) scroll;
        int textHeight = wrappedLines.size() * 14;

        renderSideImages(context, yOffset, textHeight);

        for (int i = 0; i < wrappedLines.size(); i++) {
            int y = yOffset + i * 14;
            context.drawTextWithShadow(textRenderer, wrappedLines.get(i), width / 3, y, 0xFFFFFFFF);
        }

        if (yOffset + textHeight < 0) {
            onFinish.run();
            close();
        }

        super.render(context, mouseX, mouseY, delta);
    }

    private void renderSideImages(DrawContext context, int yOffset, int textHeight) {
        if (creditImages.isEmpty() || textHeight <= 0) return;

        int maxW = Math.max(1, width / 3 - 64);
        int maxH = Math.max(1, height / 3);

        for (int i = 0; i < creditImages.size(); i++) {
            CreditImage image = creditImages.get(i);

            float scale = Math.min((float) maxW / image.width(), (float) maxH / image.height());
            int drawW = Math.max(1, Math.round(image.width() * scale));
            int drawH = Math.max(1, Math.round(image.height() * scale));

            int docY = (int) ((i + 0.5) * textHeight / creditImages.size()) - drawH / 2;
            docY = Math.clamp(docY, 0, textHeight - drawH);

            int y = yOffset + docY;
            if (y + drawH + drawW < 0 || y - drawW > height) continue;
            int x = i % 2 == 0
                    ? width / 3 - 32 - drawW
                    : width * 2 / 3 + 32;

            float centerX = x + drawW / 2.0f;
            float centerY = y + drawH / 2.0f;

            context.getMatrices().pushMatrix();
            context.getMatrices().translate(centerX, centerY);
            context.getMatrices().rotate(image.rotation());
            context.getMatrices().translate(-centerX, -centerY);

            context.fill(x - 2, y - 2, x + drawW + 2, y + drawH + 2, 0xFFFFFFFF);
            context.drawTexture(RenderPipelines.GUI_TEXTURED, image.id(), x, y, 0f, 0f, drawW, drawH, image.width(), image.height(), image.width(), image.height());

            context.getMatrices().popMatrix();
        }
    }

    @Override
    public boolean shouldPause() {
        return false;
    }

    @Override
    public boolean shouldCloseOnEsc() {
        onFinish.run();
        return true;
    }

    @Override
    protected void applyBlur(DrawContext context) {
        // No
    }
}