package net.napsternpt.prixilium.item.custom;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.screen.GenericContainerScreenHandler;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

import java.util.function.Consumer;

public class PostmortalCharmItem extends GeneralCharmItem {

    public PostmortalCharmItem(boolean upgradable, boolean specializable, Settings settings) {
        super(upgradable, specializable, settings);
    }

    @Override
    public ActionResult use(World world, PlayerEntity user, Hand hand) {
        return ActionResult.CONSUME;
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, net.minecraft.component.type.TooltipDisplayComponent displayComponent, Consumer<Text> textConsumer, TooltipType type) {
        textConsumer.accept(Text.translatable("tooltip.prixilium.postmortal_charm"));
        super.appendTooltip(stack, context, displayComponent, textConsumer, type);
    }
}