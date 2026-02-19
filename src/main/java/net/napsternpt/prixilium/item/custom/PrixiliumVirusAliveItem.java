package net.napsternpt.prixilium.item.custom;

import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.napsternpt.prixilium.item.ModItems;

public class PrixiliumVirusAliveItem extends Item {
    private static final int DAMAGE_INTERVAL = 50;

    public PrixiliumVirusAliveItem (Settings settings) {
        super(settings);
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if (!world.isClient) {
            if (entity instanceof net.minecraft.entity.player.PlayerEntity player) {
                if (player.isCreative() || player.isSpectator()) {
                    return;
                }
            }

            if (world.getTime() % DAMAGE_INTERVAL == 0) {
                stack.setDamage(stack.getDamage() + 1);

                if (stack.getDamage() >= stack.getMaxDamage()) {
                    ItemStack newStack = new ItemStack(ModItems.PRIXILIUM_VIRUS_DEAD);

                    if (entity instanceof net.minecraft.entity.player.PlayerEntity player) {
                        player.getInventory().setStack(slot, newStack);
                    }
                }
            }
        }

        super.inventoryTick(stack, world, entity, slot, selected);
    }
}