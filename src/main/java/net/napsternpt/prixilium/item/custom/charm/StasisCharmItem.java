package net.napsternpt.prixilium.item.custom.charm;

import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.NbtComponent;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.napsternpt.prixilium.item.custom.CharmItem;

import java.util.Objects;
import java.util.Set;

public class StasisCharmItem extends CharmItem {

    private static final String POS_X = "x";
    private static final String POS_Y = "y";
    private static final String POS_Z = "z";
    private static final String DIM = "dim";

    public StasisCharmItem(CharmSettings settings) {
        super(settings);
    }

    @Override
    public ActionResult use(World world, PlayerEntity player, Hand hand) {
        if (player instanceof ServerPlayerEntity serverPlayer) {
            ItemStack stack = player.getStackInHand(hand);
            if (stack.getOrDefault(DataComponentTypes.CUSTOM_DATA, NbtComponent.DEFAULT).copyNbt().contains(POS_X)) {
                var nbt = Objects.requireNonNull(stack.get(DataComponentTypes.CUSTOM_DATA)).copyNbt();
                double x = nbt.getDouble(POS_X).orElseThrow();
                double y = nbt.getDouble(POS_Y).orElseThrow();
                double z = nbt.getDouble(POS_Z).orElseThrow();
                String dimId = nbt.getString(DIM).orElseThrow();

                ServerWorld targetWorld = Objects.requireNonNull(serverPlayer.getServer()).getWorld(RegistryKey.of(RegistryKeys.WORLD, Identifier.of(dimId)));
                if (targetWorld == null) targetWorld = serverPlayer.getServerWorld();
                serverPlayer.teleport(targetWorld, x + 0.5, y,z + 0.5, Set.of(), serverPlayer.getYaw(), serverPlayer.getPitch(), false);

                nbt.remove(POS_X);
                nbt.remove(POS_Y);
                nbt.remove(POS_Z);
                nbt.remove(DIM);
                stack.set(DataComponentTypes.CUSTOM_DATA, NbtComponent.of(nbt));
                stack.remove(DataComponentTypes.ENCHANTMENT_GLINT_OVERRIDE);
                if (!player.isInCreativeMode()) {
                    EquipmentSlot slot = hand == Hand.MAIN_HAND ? EquipmentSlot.MAINHAND : EquipmentSlot.OFFHAND;
                    stack.damage(1, player, slot);
                }
                for (int i = 0; i < 64; ++i) ((ServerWorld) world).spawnParticles(ParticleTypes.PORTAL,
                        x + 0.5, y + world.random.nextDouble() * 2.0, z + 0.5,
                        1, world.random.nextGaussian(), 0.0, world.random.nextGaussian(), 0.1);
            } else {
                BlockPos pos = player.getBlockPos();
                NbtCompound nbt = new NbtCompound();
                nbt.putDouble(POS_X, pos.getX());
                nbt.putDouble(POS_Y, pos.getY());
                nbt.putDouble(POS_Z, pos.getZ());
                nbt.putString(DIM, world.getRegistryKey().getValue().toString());
                stack.set(DataComponentTypes.CUSTOM_DATA, NbtComponent.of(nbt));
                stack.set(DataComponentTypes.ENCHANTMENT_GLINT_OVERRIDE, true);
            }
        }
        return ActionResult.SUCCESS;
    }
}