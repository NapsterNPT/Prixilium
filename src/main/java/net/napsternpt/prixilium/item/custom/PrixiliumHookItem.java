package net.napsternpt.prixilium.item.custom;

import net.minecraft.advancement.AdvancementEntry;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;
import net.napsternpt.prixilium.Prixilium;
import net.napsternpt.prixilium.component.ModDataComponentTypes;
import net.napsternpt.prixilium.entity.projectile.PrixiliumHookEntity;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

public class PrixiliumHookItem extends Item {

    private static final Map<UUID, PrixiliumHookEntity> activeHooks = new HashMap<>();

    public PrixiliumHookItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult use(World world, PlayerEntity player, Hand hand) {
        ItemStack stack = player.getStackInHand(hand);
        UUID playerId = player.getUuid();

        if (world.isClient) {
            return ActionResult.SUCCESS;
        }

        if (activeHooks.containsKey(playerId)) {
            PrixiliumHookEntity hook = activeHooks.remove(playerId);

            if (hook != null && !hook.isRemoved()) {
                hook.discard();
            }

            stack.remove(ModDataComponentTypes.HOOK_ACTIVE);

            world.playSound(null, player.getX(), player.getY(), player.getZ(),
                    SoundEvents.ITEM_CROSSBOW_LOADING_END,
                    SoundCategory.PLAYERS, 0.5f, 1.2f);

            return ActionResult.SUCCESS;
        }

        PrixiliumHookEntity hook = new PrixiliumHookEntity(world, player);
        world.spawnEntity(hook);
        activeHooks.put(playerId, hook);

        stack.set(ModDataComponentTypes.HOOK_ACTIVE, true);

        world.playSound(null, player.getX(), player.getY(), player.getZ(),
                SoundEvents.ITEM_CROSSBOW_SHOOT,
                SoundCategory.PLAYERS, 1.0f, 1.2f);

        if (player instanceof ServerPlayerEntity serverPlayer) {
            stack.damage(1, serverPlayer, hand == Hand.MAIN_HAND
                            ? EquipmentSlot.MAINHAND
                            : EquipmentSlot.OFFHAND);

            AdvancementEntry advancement = Objects.requireNonNull(serverPlayer.getServer()).getAdvancementLoader().get(Identifier.of(Prixilium.MOD_ID, "prixilium_hook"));
            serverPlayer.getAdvancementTracker().grantCriterion(advancement, "use_prixilium_hook");
        }

        return ActionResult.SUCCESS;
    }

    public static void clearHook(PlayerEntity player) {
        PrixiliumHookEntity hook = activeHooks.remove(player.getUuid());
        if (hook != null && !hook.isRemoved()) hook.discard();

        ItemStack main = player.getMainHandStack();
        ItemStack off = player.getOffHandStack();

        if (main.getItem() instanceof PrixiliumHookItem) main.remove(ModDataComponentTypes.HOOK_ACTIVE);
        if (off.getItem() instanceof PrixiliumHookItem) off.remove(ModDataComponentTypes.HOOK_ACTIVE);
    }
}