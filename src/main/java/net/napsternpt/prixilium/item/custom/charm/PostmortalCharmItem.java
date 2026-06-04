package net.napsternpt.prixilium.item.custom.charm;

import net.minecraft.component.type.TooltipDisplayComponent;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;
import net.napsternpt.prixilium.item.custom.CharmItem;

import java.util.function.Consumer;

public class PostmortalCharmItem extends CharmItem {

    public PostmortalCharmItem(CharmSettings settings) {
        super(settings);
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, TooltipDisplayComponent displayComponent, Consumer<Text> textConsumer, TooltipType type) {
        textConsumer.accept(Text.translatable("tooltip.prixilium.postmortal_charm"));
        super.appendTooltip(stack, context, displayComponent, textConsumer, type);
    }
}