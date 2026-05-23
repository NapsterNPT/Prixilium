package net.napsternpt.prixilium.item.custom;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;
import java.util.function.Consumer;

public class GeneralCharmItem extends Item {
    private final boolean upgradable;
    private final boolean specializable;
    public GeneralCharmItem(boolean upgradable, boolean specializable, Settings settings) {
        super(settings);
        this.upgradable = upgradable;
        this.specializable = specializable;
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, net.minecraft.component.type.TooltipDisplayComponent displayComponent, Consumer<Text> textConsumer, TooltipType type) {
        if (upgradable && specializable) textConsumer.accept(Text.translatable("tooltip.prixilium.general_charm.specialize_and_update"));
        else if (upgradable) textConsumer.accept(Text.translatable("tooltip.prixilium.general_charm.update"));
        else if (specializable) textConsumer.accept(Text.translatable("tooltip.prixilium.general_charm.specialize"));
        super.appendTooltip(stack, context, displayComponent, textConsumer, type);
    }
}