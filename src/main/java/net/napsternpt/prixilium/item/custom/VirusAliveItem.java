package net.napsternpt.prixilium.item.custom;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;
import net.minecraft.world.World;
import net.napsternpt.prixilium.effect.ModEffects;
import net.napsternpt.prixilium.item.ModItems;

import java.util.List;

public class VirusAliveItem extends Item {
    private static final int DAMAGE_INTERVAL = 50;

    public VirusAliveItem(Settings settings) {super(settings);}

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
                    if (entity instanceof LivingEntity livingEntity) {
                        int duration = 1000 + livingEntity.getRandom().nextInt(23001);
                        livingEntity.addStatusEffect(new StatusEffectInstance(ModEffects.ILLNESS, duration, 0, true, false, false));
                    }
                    ItemStack newStack = new ItemStack(ModItems.VIRUS_DEAD);

                    if (entity instanceof net.minecraft.entity.player.PlayerEntity player) {
                        player.getInventory().setStack(slot, newStack);
                    }
                }
            }
        }

        super.inventoryTick(stack, world, entity, slot, selected);
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        int hp = 100 - stack.getDamage();
        String color = "4";
        if (hp >= 75) {
            color = "a";
        } else if (hp >= 50) {
            color = "e";
        } else if (hp >= 25) {
            color = "6";
        }
        Text line = Text.translatable("tooltip.prixilium.virus_alive.1")
                .append(" §" + color + (hp) + " / 100 HP.");

        tooltip.add(line);
        tooltip.add(Text.translatable("tooltip.prixilium.virus_alive.2"));
        super.appendTooltip(stack, context, tooltip, type);
    }
}