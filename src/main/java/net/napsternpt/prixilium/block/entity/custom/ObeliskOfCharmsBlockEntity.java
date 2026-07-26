package net.napsternpt.prixilium.block.entity.custom;

import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerFactory;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.s2c.play.BlockEntityUpdateS2CPacket;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.storage.ReadView;
import net.minecraft.storage.WriteView;
import net.minecraft.text.Text;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.napsternpt.prixilium.block.entity.ImplementedInventory;
import net.napsternpt.prixilium.block.entity.ModBlockEntities;
import net.napsternpt.prixilium.screen.custom.ObeliskOfCharmsScreenHandler;
import net.napsternpt.prixilium.util.ModTags;
import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;

public class ObeliskOfCharmsBlockEntity extends BlockEntity implements ExtendedScreenHandlerFactory<BlockPos>, ImplementedInventory {
    private final DefaultedList<ItemStack> inventory = DefaultedList.ofSize(3, ItemStack.EMPTY);

    private static final int INPUT_SLOT = 0;
    private static final int FUEL_SLOT = 1;
    private static final int OUTPUT_SLOT = 2;

    protected final PropertyDelegate propertyDelegate;
    private int progress = 0;
    private int maxProgress = 200;
    private int fuelBurnTime = 0;
    private int maxFuelBurnTime = 0;

    private final float rotation = (float)(Math.random() * 360);

    public ObeliskOfCharmsBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.OBELISK_OF_CHARMS_BE, pos, state);

        this.propertyDelegate = new PropertyDelegate() {
            @Override
            public int get(int index) {
                return switch (index) {
                    case 0 -> ObeliskOfCharmsBlockEntity.this.progress;
                    case 1 -> ObeliskOfCharmsBlockEntity.this.maxProgress;
                    case 2 -> ObeliskOfCharmsBlockEntity.this.fuelBurnTime;
                    case 3 -> ObeliskOfCharmsBlockEntity.this.maxFuelBurnTime;
                    default -> 0;
                };
            }

            @Override
            public void set(int index, int value) {
                switch (index) {
                    case 0 -> ObeliskOfCharmsBlockEntity.this.progress = value;
                    case 1 -> ObeliskOfCharmsBlockEntity.this.maxProgress = value;
                    case 2 -> ObeliskOfCharmsBlockEntity.this.fuelBurnTime = value;
                    case 3 -> ObeliskOfCharmsBlockEntity.this.maxFuelBurnTime = value;
                }
            }

            @Override
            public int size() {
                return 4;
            }
        };
    }

    public float getRenderingRotation() {
        return rotation;
    }

    @Override
    public @NonNull BlockPos getScreenOpeningData(@NonNull ServerPlayerEntity player) {
        return this.pos;
    }

    @Override
    public Text getDisplayName() {
        return Text.translatable("block.prixilium.obelisk_of_charms");
    }

    @Override
    public DefaultedList<ItemStack> getItems() {
        return inventory;
    }

    @Override
    public @Nullable ScreenHandler createMenu(int syncId, PlayerInventory playerInventory, PlayerEntity player) {
        return new ObeliskOfCharmsScreenHandler(syncId, playerInventory, this, this.propertyDelegate);
    }

    @Override
    protected void writeData(WriteView view) {
        super.writeData(view);
        Inventories.writeData(view, inventory);
        view.putInt("progress", this.progress);
        view.putInt("maxProgress", this.maxProgress);
        view.putInt("fuelBurnTime", this.fuelBurnTime);
        view.putInt("maxFuelBurnTime", this.maxFuelBurnTime);
    }

    @Override
    protected void readData(ReadView view) {
        Inventories.readData(view, inventory);
        progress = view.getInt("progress", 0);
        maxProgress = view.getInt("maxProgress", 200);
        fuelBurnTime = view.getInt("fuelBurnTime", 0);
        maxFuelBurnTime = view.getInt("maxFuelBurnTime", 0);
        super.readData(view);
    }

    public static void tick(World world, BlockPos pos, BlockState state, ObeliskOfCharmsBlockEntity entity) {
        if (entity.fuelBurnTime > 0) {
            entity.fuelBurnTime--;
        } else if (entity.hasRecipe() && entity.canConsumeFuel()) {
            entity.consumeFuel();
        }
        if (entity.hasRecipe() && entity.fuelBurnTime > 0) {
            if (entity.progress == 0) {
                entity.maxProgress = entity.getCraftingDuration();
            }
            entity.increaseCraftingProgress();
            if (entity.hasCraftingFinished()) {
                entity.craftItem();
                entity.resetProgress();
            }
        } else if (!entity.hasRecipe()) {
            entity.resetProgress();
        }
        markDirty(world, pos, state);
    }

    private int getCraftingDuration() {
        ItemStack input = this.getStack(INPUT_SLOT);
        if (input.isIn(ModTags.Items.TIER_I_CHARMS)) return 200;
        if (input.isIn(ModTags.Items.TIER_II_CHARMS)) return 300;
        if (input.isIn(ModTags.Items.TIER_III_CHARMS)) return 400;
        return 200;
    }

    private int getBurnTime(ItemStack fuel) {
        if (fuel.isIn(ModTags.Items.OBELISK_OF_CHARMS_FUEL)) return 200;
        if (fuel.isIn(ModTags.Items.OBELISK_OF_CHARMS_FUEL_LONG)) return 400;
        return 0;
    }

    private boolean canConsumeFuel() {
        return !this.getStack(FUEL_SLOT).isEmpty() && getBurnTime(this.getStack(FUEL_SLOT)) > 0;
    }

    private void consumeFuel() {
        this.maxFuelBurnTime = getBurnTime(this.getStack(FUEL_SLOT));
        this.fuelBurnTime = this.maxFuelBurnTime;
        this.removeStack(FUEL_SLOT, 1);
    }

    private void resetProgress() {
        this.progress = 0;
        this.maxProgress = getCraftingDuration();
    }

    private void craftItem() {
        ItemStack input = this.getStack(INPUT_SLOT);
        ItemStack output = input.copy();
        output.setDamage(Math.max(0, output.getDamage() - 1));

        this.removeStack(INPUT_SLOT, 1);
        if (output.isDamaged()) {
            this.setStack(INPUT_SLOT, output);
        } else {
            this.setStack(OUTPUT_SLOT, output.copyWithCount(this.getStack(OUTPUT_SLOT).getCount() + output.getCount()));
        }
    }

    private boolean hasCraftingFinished() {
        return this.progress >= this.maxProgress;
    }

    private void increaseCraftingProgress() {
        this.progress++;
    }

    private boolean hasRecipe() {
        TagKey<Item> inputTag = ModTags.Items.REPARABLE_CHARMS;
        ItemStack input = this.getStack(INPUT_SLOT);

        ItemStack output = input.copy();
        output.setDamage(output.getDamage() - 1);

        return input.isIn(inputTag) && input.isDamaged() &&
                canInsertAmountIntoOutputSlot(output.getCount()) && canInsertItemIntoOutputSlot(output);
    }
    private boolean canInsertItemIntoOutputSlot(ItemStack output) {
        return this.getStack(OUTPUT_SLOT).isEmpty() || this.getStack(OUTPUT_SLOT).getItem() == output.getItem();
    }

    private boolean canInsertAmountIntoOutputSlot(int count) {
        int maxCount = this.getStack(OUTPUT_SLOT).isEmpty() ? 64 : this.getStack(OUTPUT_SLOT).getMaxCount();
        int currentCount = this.getStack(OUTPUT_SLOT).getCount();

        return maxCount >= currentCount + count;
    }

    public boolean isBurning() {
        return fuelBurnTime > 0;
    }

    @Override
    public @Nullable Packet<ClientPlayPacketListener> toUpdatePacket() {
        return BlockEntityUpdateS2CPacket.create(this);
    }

    @Override
    public NbtCompound toInitialChunkDataNbt(RegistryWrapper.WrapperLookup registries) {
        return createNbt(registries);
    }
}
