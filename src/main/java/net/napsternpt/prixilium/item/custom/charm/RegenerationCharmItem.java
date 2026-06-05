package net.napsternpt.prixilium.item.custom.charm;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import net.napsternpt.prixilium.item.custom.CharmItem;

public class RegenerationCharmItem extends CharmItem {
    public RegenerationCharmItem(CharmSettings settings) {
        super(settings);
    }

    @Override
    public ActionResult use(World world, PlayerEntity player, Hand hand) {
        if (!world.isClient) {
            boolean healed = false;

            if (player.getHealth() < player.getMaxHealth()) {
                player.heal(6.0F);
                healed = true;
            }
            if (player.getHungerManager().isNotFull()) {
                player.getHungerManager().add(6, 0.6F);
                healed = true;
            }
            if (player.getAir() < player.getMaxAir()) {
                player.setAir(Math.min(player.getAir() + 90, player.getMaxAir()));
                healed = true;
            }
            if (healed && !player.isInCreativeMode()) {
                ItemStack stack = player.getStackInHand(hand);
                EquipmentSlot slot = hand == Hand.MAIN_HAND ? EquipmentSlot.MAINHAND : EquipmentSlot.OFFHAND;
                stack.damage(1, player, slot);
            }
        }
        return ActionResult.SUCCESS;
    }
}
