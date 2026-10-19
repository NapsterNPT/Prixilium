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
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class PrixiverseCreditsScreen extends Screen {
    private record CreditImage(Identifier id, int width, int height) {}

    private final Runnable onFinish;
    private final String playerName;

    private float scroll = 0;
    private static final int OUTLINE = 2;

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

        try {
            Identifier id = Identifier.of(Prixilium.MOD_ID, "texts/prixiverse.txt");
            assert client != null;
            Resource resource = client.getResourceManager().getResource(id).orElseThrow();
            BufferedReader reader = new BufferedReader(new InputStreamReader(resource.getInputStream(), StandardCharsets.UTF_8));

            String line;
            while ((line = reader.readLine()) != null) {
                line = line.replace("%Player_Name%", playerName);
                if (line.isBlank()) wrappedLines.add(OrderedText.EMPTY);
                else wrappedLines.addAll(textRenderer.wrapLines(Text.literal(line), width / 3));
            }

            reader.close();

        } catch (Exception e) {
            Prixilium.LOGGER.error("Couldn't load credits from file.");
        }

        try {
            assert client != null;
            Map<Identifier, Resource> found = client.getResourceManager().findResources("textures/credits", id -> id.getPath().endsWith(".png"));

            found.keySet().stream()
                    .sorted(Comparator.comparing(Identifier::getPath))
                    .forEach(id -> {
                        try (InputStream in = found.get(id).getInputStream()) {
                            NativeImage image = NativeImage.read(in);
                            creditImages.add(new CreditImage(id, image.getWidth(), image.getHeight()));
                            image.close();
                        } catch (Exception e) {
                            Prixilium.LOGGER.error("Couldn't read credits image {}", id, e);
                        }
                    });
        } catch (Exception e) {
            Prixilium.LOGGER.error("Couldn't load credits images.");
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
            if (y + drawH < 0 || y > height) continue;
            int x = i % 2 == 0
                    ? width / 3 - 32 - drawW
                    : width * 2 / 3 + 32;

            context.fill(x - OUTLINE, y - OUTLINE, x + drawW + OUTLINE, y + drawH + OUTLINE, 0xFFFFFFFF);
            context.drawTexture(RenderPipelines.GUI_TEXTURED, image.id(), x, y, 0f, 0f,
                    drawW, drawH, image.width(), image.height(), image.width(), image.height());
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