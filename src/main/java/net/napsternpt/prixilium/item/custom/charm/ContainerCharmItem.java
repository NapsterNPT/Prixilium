package net.napsternpt.prixilium.item.custom.charm;

import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.ContainerComponent;
import net.minecraft.component.type.TooltipDisplayComponent;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.screen.SimpleNamedScreenHandlerFactory;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import net.napsternpt.prixilium.item.custom.CharmItem;
import net.napsternpt.prixilium.screen.SavedContainerScreenHandler;

import java.util.function.Consumer;

public class ContainerCharmItem extends CharmItem {
    private final int raw;

    public ContainerCharmItem(int raw, CharmSettings settings) {
        super(settings);
        this.raw = raw;
    }

    @Override
    public ActionResult use(World world, PlayerEntity user, Hand hand) {
        ItemStack stack = user.getStackInHand(hand);
        if (!world.isClient()) {
            RegistryWrapper.WrapperLookup lookup = world.getRegistryManager();
            user.openHandledScreen(new SimpleNamedScreenHandlerFactory((syncId, inv, player) -> {
                SimpleInventory inventory = new SimpleInventory(raw * 9);
                stack.getOrDefault(DataComponentTypes.CONTAINER, ContainerComponent.DEFAULT).copyTo(inventory.getHeldStacks());
                return new SavedContainerScreenHandler(syncId, inv, inventory, stack, raw, lookup);
                }, Text.translatable("hud.prixilium.container_charm.title")));
        }
        return ActionResult.SUCCESS;
    }

    public static void saveInventory(ItemStack stack, SimpleInventory inventory) {
        if (stack.isEmpty() || inventory == null) return;
        try {
            stack.set(DataComponentTypes.CONTAINER, ContainerComponent.fromStacks(inventory.getHeldStacks()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean hasGlint(ItemStack stack) {
        ContainerComponent container = stack.getOrDefault(DataComponentTypes.CONTAINER, ContainerComponent.DEFAULT);
        return !container.copyFirstStack().isEmpty();
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, TooltipDisplayComponent displayComponent, Consumer<Text> textConsumer, TooltipType type) {
        textConsumer.accept(Text.translatable("tooltip.prixilium.container_charm"));
        super.appendTooltip(stack, context, displayComponent, textConsumer, type);
    }
}