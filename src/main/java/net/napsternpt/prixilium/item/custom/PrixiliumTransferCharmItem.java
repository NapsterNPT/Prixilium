package net.napsternpt.prixilium.item.custom;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

import java.util.function.Consumer;

public class PrixiliumTransferCharmItem extends Item {
    public PrixiliumTransferCharmItem(Settings settings) {
        super(settings);
    }

    public boolean isDamageable() {
        return true;
    }

    public <T extends LivingEntity> int damage(ItemStack stack, int amount, T entity, Consumer<T> breakCallback) {
        int currentDamage = stack.getDamage();
        int maxDamage = stack.getMaxDamage();

        if (currentDamage + amount >= maxDamage) {
            stack.setDamage(maxDamage - 1);
            return 0;
        }

        return damage(stack, amount, entity, breakCallback);
    }

    public ActionResult use(World world, PlayerEntity user, Hand hand) {
        ItemStack stack = user.getStackInHand(hand);

        int currentDamage = stack.getDamage();
        int maxDamage = stack.getMaxDamage();

        if (currentDamage >= maxDamage - 1) {
            return ActionResult.FAIL;
        }

        if (!world.isClient) {
            stack.setDamage(currentDamage + 1);
        }

        return ActionResult.SUCCESS;
    }
}
