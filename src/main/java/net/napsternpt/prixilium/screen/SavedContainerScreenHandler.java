package net.napsternpt.prixilium.screen;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.screen.slot.Slot;
import net.napsternpt.prixilium.item.custom.CharmItem;
import net.napsternpt.prixilium.item.custom.charm.ContainerCharmItem;
import net.napsternpt.prixilium.util.ModTags;

public class SavedContainerScreenHandler extends ScreenHandler {
    private final RegistryWrapper.WrapperLookup lookup;
    private final ItemStack stack;
    private final SimpleInventory inventory;
    private final int rows;

    public SavedContainerScreenHandler(int syncId, PlayerInventory playerInventory, SimpleInventory inventory, ItemStack stack, int rows, RegistryWrapper.WrapperLookup lookup) {
        super(getType(rows), syncId);
        this.stack = stack;
        this.inventory = inventory;
        this.lookup = lookup;
        this.rows = rows;

        int i = (rows - 4) * 18;
        for (int row = 0; row < rows; ++row) {
            for (int col = 0; col < 9; ++col) {
                int index = col + row * 9;
                this.addSlot(new Slot(inventory, index, 8 + col * 18, 18 + row * 18) {
                    @Override
                    public boolean canInsert(ItemStack stack) {
                        return !stack.isIn(ModTags.Items.CONTAINER_CHARM_UNHOLDABLE) && !(stack.getItem() instanceof CharmItem);
                    }
                });
            }
        }
        for (int row = 0; row < 3; ++row) {
            for (int col = 0; col < 9; ++col) this.addSlot(new Slot(playerInventory, col + row * 9 + 9, 8 + col * 18, 103 + row * 18 + i));
        }
        for (int col = 0; col < 9; ++col) this.addSlot(new Slot(playerInventory, col, 8 + col * 18, 161 + i));
    }

    @Override
    public ItemStack quickMove(PlayerEntity player, int slot) {
        ItemStack itemStack = ItemStack.EMPTY;
        Slot slot2 = this.slots.get(slot);
        if (slot2.hasStack()) {
            ItemStack itemStack2 = slot2.getStack();
            if (slot >= this.rows * 9 && (itemStack2.isIn(ModTags.Items.CONTAINER_CHARM_UNHOLDABLE) || itemStack2.getItem() instanceof CharmItem)) {
                return ItemStack.EMPTY;
            }
            itemStack = itemStack2.copy();
            if (slot < this.rows * 9)
                if (!this.insertItem(itemStack2, this.rows * 9, this.slots.size(), true)) return ItemStack.EMPTY;
            else if (!this.insertItem(itemStack2, 0, this.rows * 9, false)) return ItemStack.EMPTY;
            if (itemStack2.isEmpty()) slot2.setStack(ItemStack.EMPTY, itemStack);
            else slot2.markDirty();
        }
        return itemStack;
    }

    private static ScreenHandlerType<?> getType(int rows) {
        return switch (rows) {
            case 1 -> ScreenHandlerType.GENERIC_9X1;
            case 2 -> ScreenHandlerType.GENERIC_9X2;
            case 3 -> ScreenHandlerType.GENERIC_9X3;
            case 4 -> ScreenHandlerType.GENERIC_9X4;
            case 5 -> ScreenHandlerType.GENERIC_9X5;
            default -> ScreenHandlerType.GENERIC_9X6;
        };
    }

    @Override
    public void onClosed(PlayerEntity player) {
        super.onClosed(player);
        if (!player.getWorld().isClient) ContainerCharmItem.saveInventory(inventory, lookup);
    }

    @Override
    public boolean canUse(PlayerEntity player) {
        return this.inventory.canPlayerUse(player);
    }
}