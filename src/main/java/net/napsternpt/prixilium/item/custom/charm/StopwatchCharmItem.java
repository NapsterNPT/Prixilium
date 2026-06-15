package net.napsternpt.prixilium.item.custom.charm;

import net.minecraft.advancement.AdvancementEntry;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.NbtComponent;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;
import net.napsternpt.prixilium.Prixilium;
import net.napsternpt.prixilium.item.custom.CharmItem;
import net.napsternpt.prixilium.network.ModPackets;
import net.napsternpt.prixilium.util.TimeStopState;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;

public class StopwatchCharmItem extends CharmItem {
    private final int duration;
    private static final String ACTIVE_KEY = "Active";

    public StopwatchCharmItem(int duration, CharmSettings settings) {
        super(settings);
        this.duration = duration;
    }

    @Override
    public ActionResult use(World world, PlayerEntity player, Hand hand) {
        ItemStack stack = player.getStackInHand(hand);
        if (!world.isClient) {
            ServerWorld serverWorld = (ServerWorld) world;
            NbtCompound nbt = stack.getOrDefault(DataComponentTypes.CUSTOM_DATA, NbtComponent.DEFAULT).copyNbt();
            if (nbt.getBoolean(ACTIVE_KEY).orElse(false)) return ActionResult.FAIL;
            if (TimeStopState.isTimeStopped(serverWorld)) return ActionResult.FAIL;

            long durationTicks = duration * 20L;
            TimeStopState.startStop(serverWorld, durationTicks, player.getUuid());

            nbt.putBoolean(ACTIVE_KEY, true);
            stack.set(DataComponentTypes.CUSTOM_DATA, NbtComponent.of(nbt));
            stack.set(DataComponentTypes.ENCHANTMENT_GLINT_OVERRIDE, true);

            ModPackets.sendTimeStopStart(serverWorld, durationTicks, player.getUuid());

            if (player instanceof ServerPlayerEntity serverPlayer) {
                AdvancementEntry advancement = Objects.requireNonNull(serverPlayer.getServer()).getAdvancementLoader().get(Identifier.of(Prixilium.MOD_ID, "time_stopper"));
                serverPlayer.getAdvancementTracker().grantCriterion(advancement, "time_stopper");
            }

            if (!player.isInCreativeMode()) {
                EquipmentSlot slot = hand == Hand.MAIN_HAND ? EquipmentSlot.MAINHAND : EquipmentSlot.OFFHAND;
                stack.damage(1, player, slot);
            }
        }
        return ActionResult.SUCCESS;
    }

    @Override
    public void inventoryTick(ItemStack stack, ServerWorld world, Entity entity, @Nullable EquipmentSlot slot) {
        if (!world.isClient && entity instanceof PlayerEntity) {
            if (stack.contains(DataComponentTypes.ENCHANTMENT_GLINT_OVERRIDE)) {
                NbtCompound nbt = stack.getOrDefault(DataComponentTypes.CUSTOM_DATA, NbtComponent.DEFAULT).copyNbt();
                if (nbt.getBoolean(ACTIVE_KEY).orElse(false) && !TimeStopState.isTimeStopped(world)) {
                    nbt.remove(ACTIVE_KEY);
                    stack.set(DataComponentTypes.CUSTOM_DATA, NbtComponent.of(nbt));
                    stack.remove(DataComponentTypes.ENCHANTMENT_GLINT_OVERRIDE);
                }
            }
        }
        super.inventoryTick(stack, world, entity, slot);
    }
}
