package net.napsternpt.prixilium.item.custom;

import net.minecraft.component.type.TooltipDisplayComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;
import net.napsternpt.prixilium.item.custom.charm.CharmSettings;

import java.util.function.Consumer;

public class CharmItem extends Item {

    private final boolean upgradable;
    private final boolean specializable;

    public CharmItem(CharmSettings settings) {
        super(settings);
        this.upgradable = settings.isUpgradable();
        this.specializable = settings.isSpecializable();
    }

    @Override
    public void appendTooltip(ItemStack stack, Item.TooltipContext context, TooltipDisplayComponent displayComponent, Consumer<Text> textConsumer, TooltipType type) {
        if (upgradable && specializable) textConsumer.accept(Text.translatable("tooltip.prixilium.general_charm.specialize_and_update"));
        else if (upgradable) textConsumer.accept(Text.translatable("tooltip.prixilium.general_charm.update"));
        else if (specializable) textConsumer.accept(Text.translatable("tooltip.prixilium.general_charm.specialize"));
        super.appendTooltip(stack, context, displayComponent, textConsumer, type);
    }
}