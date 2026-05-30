package net.napsternpt.prixilium.screen;

import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.resource.Resource;
import net.minecraft.text.OrderedText;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.napsternpt.prixilium.Prixilium;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class PrixiverseCreditsScreen extends Screen {
    private final Runnable onFinish;
    private final String playerName;

    private float scroll = 0;
    private static final float SCROLL_SPEED = 0.5f;

    private final List<OrderedText> wrappedLines = new ArrayList<>();

    public PrixiverseCreditsScreen(String playerName, Runnable onFinish) {
        super(Text.empty());
        this.playerName = playerName;
        this.onFinish = onFinish;
    }

    @Override
    protected void init() {
        wrappedLines.clear();

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
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        context.fill(0, 0, width, height, 0xFF000000);
        scroll += SCROLL_SPEED * delta;
        int lineHeight = 14;
        int yOffset = height - (int) scroll;

        for (int i = 0; i < wrappedLines.size(); i++) {
            int y = yOffset + i * lineHeight;
            context.drawTextWithShadow(textRenderer, wrappedLines.get(i), width / 3, y, 0xFFFFFFFF);
        }

        if (yOffset + wrappedLines.size() * lineHeight < 0) {
            onFinish.run();
            close();
        }

        super.render(context, mouseX, mouseY, delta);
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
    protected void applyBlur() {}
}