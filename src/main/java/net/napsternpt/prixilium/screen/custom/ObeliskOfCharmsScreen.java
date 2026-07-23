package net.napsternpt.prixilium.screen.custom;

import net.minecraft.client.gl.RenderPipelines;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.napsternpt.prixilium.Prixilium;

public class ObeliskOfCharmsScreen extends HandledScreen<ObeliskOfCharmsScreenHandler> {
    private static final Identifier GUI = Identifier.of(Prixilium.MOD_ID, "textures/gui/obelisk_of_charms/obelisk_of_charms_gui.png");
    private static final Identifier FLUID = Identifier.of(Prixilium.MOD_ID, "textures/gui/obelisk_of_charms/fluid_progress.png");
    private static final Identifier ARROW = Identifier.of(Prixilium.MOD_ID, "textures/gui/obelisk_of_charms/repair_progress.png");

    public ObeliskOfCharmsScreen(ObeliskOfCharmsScreenHandler handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title);
    }

    @Override
    protected void drawBackground(DrawContext context, float deltaTicks, int mouseX, int mouseY) {
        int x = (width - backgroundWidth) / 2;
        int y = (height - backgroundHeight) / 2;

        context.drawTexture(RenderPipelines.GUI_TEXTURED, GUI, x, y, 0, 0, backgroundWidth, backgroundHeight, 256, 256);

        renderProgressArrow(context, x, y);
        renderFuelFlame(context, x, y);
    }

    private void renderProgressArrow(DrawContext context, int x, int y) {
        if(handler.isCrafting()) {
            context.drawTexture(RenderPipelines.GUI_TEXTURED, ARROW, x + 79, y + 35, 0, 0, handler.getScaledArrowProgress(), 16, 24, 16);
        }
    }

    private void renderFuelFlame(DrawContext context, int x, int y) {
        if (handler.isBurning()) {
            int fuelHeight = handler.getScaledFuelProgress();
            context.drawTexture(RenderPipelines.GUI_TEXTURED, FLUID, x + 56, y + 36 + 14 - fuelHeight, 0, 14 - fuelHeight, 16, fuelHeight, 16, 14);
        }
    }

    @Override
    protected void drawForeground(DrawContext context, int mouseX, int mouseY) {
        int titleWidth = this.textRenderer.getWidth(this.title);
        context.drawText(this.textRenderer, this.title, (this.backgroundWidth - titleWidth) / 2, this.titleY, 0xFF555555, false);
        context.drawText(this.textRenderer, this.playerInventoryTitle, this.playerInventoryTitleX, this.playerInventoryTitleY, 0xFF555555, false);
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float deltaTicks) {
        super.render(context, mouseX, mouseY, deltaTicks);
        drawMouseoverTooltip(context, mouseX, mouseY);
    }
}
