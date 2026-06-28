package net.napsternpt.prixilium.item.custom.charm;

import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.NbtComponent;
import net.minecraft.component.type.TooltipDisplayComponent;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.Inventories;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.screen.SimpleNamedScreenHandlerFactory;
import net.minecraft.storage.NbtReadView;
import net.minecraft.storage.NbtWriteView;
import net.minecraft.storage.ReadView;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ErrorReporter;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import net.napsternpt.prixilium.item.custom.CharmItem;
import net.napsternpt.prixilium.screen.SavedContainerScreenHandler;

import java.util.function.Consumer;

public class ContainerCharmItem extends CharmItem {
    private final int raw;
    private static final String ITEMS_KEY = "Items";

    public ContainerCharmItem(int raw, CharmSettings settings) {
        super(settings);
        this.raw = raw;
    }

    @Override
    public ActionResult use(World world, PlayerEntity user, Hand hand) {
        ItemStack stack = user.getStackInHand(hand);
        if (!world.isClient) {
            RegistryWrapper.WrapperLookup lookup = world.getRegistryManager();
            user.openHandledScreen(new SimpleNamedScreenHandlerFactory((syncId, inv, player) -> {
                SimpleInventory inventory = new SimpleInventory(raw * 9);
                loadInventory(stack, inventory, lookup);
                return new SavedContainerScreenHandler(syncId, inv, inventory, stack, raw, lookup);
                }, Text.translatable("hud.prixilium.container_charm.title")));
        }
        return ActionResult.SUCCESS;
    }

    @Override
    public boolean hasGlint(ItemStack stack) {
        return !stack.getOrDefault(DataComponentTypes.CUSTOM_DATA, NbtComponent.DEFAULT)
                .copyNbt().getListOrEmpty(ITEMS_KEY).isEmpty();
    }

    private void loadInventory(ItemStack stack, SimpleInventory inventory, RegistryWrapper.WrapperLookup lookup) {
        NbtCompound nbt = stack.getOrDefault(DataComponentTypes.CUSTOM_DATA, NbtComponent.DEFAULT).copyNbt();
        if (nbt.contains(ITEMS_KEY)) {
            ReadView view = NbtReadView.create(ErrorReporter.EMPTY, lookup, nbt);
            Inventories.readData(view, inventory.getHeldStacks());
        }
    }

    public static void saveInventory(SimpleInventory inventory, RegistryWrapper.WrapperLookup lookup) {
        NbtWriteView writeView = NbtWriteView.create(ErrorReporter.EMPTY, lookup);
        Inventories.writeData(writeView, inventory.getHeldStacks());
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, TooltipDisplayComponent displayComponent, Consumer<Text> textConsumer, TooltipType type) {
        textConsumer.accept(Text.translatable("tooltip.prixilium.container_charm"));
        super.appendTooltip(stack, context, displayComponent, textConsumer, type);
    }
}