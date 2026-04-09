package net.napsternpt.prixilium.item.custom;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import net.napsternpt.prixilium.entity.projectile.PrixiliumHookEntity;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

public class PrixiliumHookItem extends Item {
    private static final Map<UUID, PrixiliumHookEntity> activeHooks = new HashMap<>();
    private static final Set<UUID> clientActiveHooks = new java.util.HashSet<>();

    public PrixiliumHookItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult use(World world, PlayerEntity player, Hand hand) {
        ItemStack stack = player.getStackInHand(hand);
        UUID playerId = player.getUuid();

        if (world.isClient) {
            if (clientActiveHooks.contains(playerId)) {
                clientActiveHooks.remove(playerId);
            }
            return ActionResult.SUCCESS;
        }

        if (activeHooks.containsKey(playerId)) {
            PrixiliumHookEntity hook = activeHooks.remove(playerId);
            clientActiveHooks.remove(playerId);
            if (hook != null && !hook.isRemoved()) {
                hook.discard();
            }
            world.playSound(null, player.getX(), player.getY(), player.getZ(),
                    SoundEvents.ITEM_CROSSBOW_LOADING_END,
                    SoundCategory.PLAYERS, 0.5f, 1.2f);
            return ActionResult.SUCCESS;
        }

        PrixiliumHookEntity hook = new PrixiliumHookEntity(world, player);
        world.spawnEntity(hook);
        activeHooks.put(playerId, hook);
        clientActiveHooks.add(playerId);

        world.playSound(null, player.getX(), player.getY(), player.getZ(),
                SoundEvents.ITEM_CROSSBOW_SHOOT,
                SoundCategory.PLAYERS, 1.0f, 1.2f);

        if (player instanceof ServerPlayerEntity serverPlayer) {
            stack.damage(1, serverPlayer,
                    hand == Hand.MAIN_HAND
                            ? net.minecraft.entity.EquipmentSlot.MAINHAND
                            : net.minecraft.entity.EquipmentSlot.OFFHAND);
        }

        return ActionResult.SUCCESS;
    }

    public static void clearHook(UUID playerId) {
        activeHooks.remove(playerId);
        clientActiveHooks.remove(playerId);
    }

    public static void clearClientHook(UUID playerId) {
        clientActiveHooks.remove(playerId);
    }

    public static boolean hasActiveHook(LivingEntity entity) {
        if (entity instanceof PlayerEntity player) {
            return clientActiveHooks.contains(player.getUuid());
        }
        return false;
    }
}