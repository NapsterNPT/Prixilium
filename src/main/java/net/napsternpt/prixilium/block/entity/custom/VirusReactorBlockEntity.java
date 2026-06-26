package net.napsternpt.prixilium.block.entity.custom;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.inventory.Inventories;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.s2c.play.BlockEntityUpdateS2CPacket;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.storage.ReadView;
import net.minecraft.storage.WriteView;
import net.minecraft.util.ItemScatterer;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.napsternpt.prixilium.block.ModBlocks;
import net.napsternpt.prixilium.block.entity.ImplementedInventory;
import net.napsternpt.prixilium.block.entity.ModBlockEntities;
import net.napsternpt.prixilium.item.ModItems;
import net.napsternpt.prixilium.particle.ModParticles;
import net.napsternpt.prixilium.sound.ModSounds;
import net.napsternpt.prixilium.util.ModTags;
import org.jetbrains.annotations.Nullable;

public class VirusReactorBlockEntity extends BlockEntity implements ImplementedInventory {

    private final DefaultedList<ItemStack> inventory = DefaultedList.ofSize(1, ItemStack.EMPTY);
    private float rotation = 0;
    private static final int MAX_RADIUS = 5;
    private static final int SPREAD_DELAY = 5;
    private boolean spreading = false;
    private int currentRadius = 0;
    private int tickCounter = 0;


    public VirusReactorBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.VIRUS_REACTOR_BE, pos, state);
    }

    @Override
    public DefaultedList<ItemStack> getItems() {
        return inventory;
    }

    public float getRenderingRotation() {
        rotation += 0.5F;
        if (rotation >= 360) rotation = 0;
        return rotation;
    }

    private void convertCenterBlock() {
        if(world == null) return;
        BlockPos center = pos.down();
        BlockState targetState = world.getBlockState(center);
        if(targetState.isIn(ModTags.Blocks.PRIXILIUM_GRASS_CONVERTIBLE)) world.setBlockState(center, ModBlocks.PRIXILIUM_GRASS.getDefaultState());
    }

    public void startSpread() {
        if (world == null || world.isClient()) return;
        this.spreading = true;
        this.currentRadius = 0;
        this.tickCounter = 0;
        convertCenterBlock();
        markDirty();
    }

    public static void tick(net.minecraft.world.World world, BlockPos pos, BlockState state, VirusReactorBlockEntity entity) {
        if (world.isClient()) return;
        if (!entity.spreading) return;
        entity.tickCounter++;

        if (entity.tickCounter >= SPREAD_DELAY) {
            entity.tickCounter = 0;
            entity.currentRadius++;
            spreadCircle(world, pos.down(), entity.currentRadius);

            world.playSound(null, pos, ModSounds.PRIXILIUM_EXPAND, SoundCategory.BLOCKS);

            if (entity.currentRadius >= MAX_RADIUS) {
                entity.spreading = false;
                if (entity.getStack(0).isOf(ModItems.VIRUS_ALIVE)) entity.clear();
            }
            entity.markDirty();
            world.updateListeners(pos, state, state, 3);
        }
    }

    private static void spreadCircle(net.minecraft.world.World world, BlockPos center, int radius) {
        for (int x = -radius; x <= radius; x++) {
            for (int z = -radius; z <= radius; z++) {
                double distance = Math.sqrt(x * x + z * z);
                if (distance <= radius - 0.3 && distance > radius - 1.3) {
                    BlockPos targetPos = center.add(x, 0, z);
                    BlockState targetState = world.getBlockState(targetPos);
                    if (targetState.isIn(ModTags.Blocks.PRIXILIUM_GRASS_CONVERTIBLE)) {
                        world.setBlockState(targetPos, ModBlocks.PRIXILIUM_GRASS.getDefaultState());
                        if (world instanceof ServerWorld serverWorld) serverWorld.spawnParticles(
                                ModParticles.PRIXILIUM_EXPAND, targetPos.getX() + 0.5, targetPos.getY() + 1, targetPos.getZ() + 0.5,
                                    3, 0.2, 0.2, 0.2, 0);
                    }
                }
            }
        }
    }

    @Override
    public void onBlockReplaced(BlockPos pos, BlockState oldState) {
        ItemScatterer.spawn(world, pos, (this));
        super.onBlockReplaced(pos, oldState);
    }

    @Override
    protected void writeData(WriteView view) {
        super.writeData(view);
        Inventories.writeData(view, inventory);
        view.putBoolean("spreading", spreading);
        view.putInt("currentRadius", currentRadius);
        view.putInt("tickCounter", tickCounter);
    }

    @Override
    protected void readData(ReadView view) {
        super.readData(view);
        Inventories.readData(view, inventory);
        spreading = view.getBoolean("spreading", false);
        currentRadius = view.getInt("currentRadius", 0);
        tickCounter = view.getInt("tickCounter", 0);
    }

    @Override
    public @Nullable Packet<ClientPlayPacketListener> toUpdatePacket() {
        return BlockEntityUpdateS2CPacket.create(this);
    }

    @Override
    public NbtCompound toInitialChunkDataNbt(RegistryWrapper.WrapperLookup registryLookup) {
        return createNbt(registryLookup);
    }
}