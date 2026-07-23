package net.napsternpt.prixilium.screen.custom;

import net.minecraft.block.entity.BlockEntity;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.ArrayPropertyDelegate;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.slot.Slot;
import net.minecraft.util.math.BlockPos;
import net.napsternpt.prixilium.block.entity.custom.ObeliskOfCharmsBlockEntity;
import net.napsternpt.prixilium.screen.ModScreenHandlers;
import net.napsternpt.prixilium.util.ModTags;

public class ObeliskOfCharmsScreenHandler extends ScreenHandler {
    private final Inventory inventory;
    private final PropertyDelegate propertyDelegate;
    public final ObeliskOfCharmsBlockEntity blockEntity;

    public ObeliskOfCharmsScreenHandler(int syncId, PlayerInventory inventory, BlockPos pos) {
        this(syncId, inventory, MinecraftClient.getInstance().world != null ? MinecraftClient.getInstance().world.getBlockEntity(pos) : null, new ArrayPropertyDelegate(4));
    }

    public ObeliskOfCharmsScreenHandler(int syncId, PlayerInventory playerInventory, BlockEntity blockEntity,  PropertyDelegate arrayPropertyDelegate) {
        super(ModScreenHandlers.OBELISK_OF_CHARMS_SCREEN_HANDLER, syncId);
        this.inventory = ((Inventory) blockEntity);
        this.blockEntity = (ObeliskOfCharmsBlockEntity) blockEntity;
        this.propertyDelegate = arrayPropertyDelegate;

        this.addSlot(new Slot(inventory, 0, 56, 17) {
            @Override
            public boolean canInsert(ItemStack stack) {
                return stack.isIn(ModTags.Items.REPARABLE_CHARMS);
            }
        });
        this.addSlot(new Slot(inventory, 1, 56, 53) {
            @Override
            public boolean canInsert(ItemStack stack) {
                return stack.isIn(ModTags.Items.OBELISK_OF_CHARMS_FUEL);
            }
        });
        this.addSlot(new Slot(inventory, 2, 116, 35) {
            @Override
            public boolean canInsert(ItemStack stack) {
                return false;
            }
        });

        addPlayerInventory(playerInventory);
        addPlayerHotbar(playerInventory);

        addProperties(arrayPropertyDelegate);
    }

    public boolean isCrafting() {
        return propertyDelegate.get(0) > 0;
    }

    public int getScaledArrowProgress() {
        int progress = this.propertyDelegate.get(0);
        int maxProgress = this.propertyDelegate.get(1);
        int arrowPixelSize = 24;

        return maxProgress != 0 && progress != 0 ? progress * arrowPixelSize / maxProgress : 0;
    }

    public boolean isBurning() {
        return propertyDelegate.get(2) > 0;
    }
    public int getScaledFuelProgress() {
        int fuelBurnTime = propertyDelegate.get(2);
        int maxFuelBurnTime = propertyDelegate.get(3);
        if (fuelBurnTime == 0 || maxFuelBurnTime == 0) return 0;
        int fuelPixelHeight = 14;
        return fuelBurnTime * fuelPixelHeight / maxFuelBurnTime;
    }

    @Override
    public ItemStack quickMove(PlayerEntity player, int invSlot) {
        ItemStack newStack = ItemStack.EMPTY;
        Slot slot = this.slots.get(invSlot);
        if (slot != null && slot.hasStack()) {
            ItemStack originalStack = slot.getStack();
            newStack = originalStack.copy();
            if (invSlot < this.inventory.size()) {
                if (!this.insertItem(originalStack, this.inventory.size(), this.slots.size(), true)) {
                    return ItemStack.EMPTY;
                }
            } else if (!this.insertItem(originalStack, 0, this.inventory.size(), false)) {
                return ItemStack.EMPTY;
            }

            if (originalStack.isEmpty()) {
                slot.setStack(ItemStack.EMPTY);
            } else {
                slot.markDirty();
            }
        }
        return newStack;
    }

    @Override
    public boolean canUse(PlayerEntity player) {
        return this.inventory.canPlayerUse(player);
    }

    private void addPlayerInventory(PlayerInventory playerInventory) {
        for (int i = 0; i < 3; ++i) {
            for (int l = 0; l < 9; ++l) {
                this.addSlot(new Slot(playerInventory, l + i * 9 + 9, 8 + l * 18, 84 + i * 18));
            }
        }
    }

    private void addPlayerHotbar(PlayerInventory playerInventory) {
        for (int i = 0; i < 9; ++i) {
            this.addSlot(new Slot(playerInventory, i, 8 + i * 18, 142));
        }
    }
}
