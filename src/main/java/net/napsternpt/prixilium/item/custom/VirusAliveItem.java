package net.napsternpt.prixilium.item.custom;

import net.minecraft.component.type.TooltipDisplayComponent;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.napsternpt.prixilium.effect.ModEffects;
import net.napsternpt.prixilium.item.ModItems;
import net.napsternpt.prixilium.util.ModGameRules;
import org.jetbrains.annotations.Nullable;

import java.util.function.Consumer;

public class VirusAliveItem extends Item {
    private static final int DAMAGE_INTERVAL = 50;

    public VirusAliveItem(Settings settings) {super(settings);}

    @Override
    public void inventoryTick(ItemStack stack, ServerWorld world, Entity entity, @Nullable EquipmentSlot slot) {
        if (!world.isClient()) {
            if (entity instanceof net.minecraft.entity.player.PlayerEntity player) {
                if (player.isCreative() || player.isSpectator()) {
                    return;
                }
            }

            if (world.getTime() % DAMAGE_INTERVAL == 0) {
                stack.setDamage(stack.getDamage() + 1);

                if (stack.getDamage() >= stack.getMaxDamage()) {
                    if (entity instanceof LivingEntity livingEntity && world.getGameRules().getValue(ModGameRules.ALLOW_ILLNESS)) {
                        int duration = 1000 + livingEntity.getRandom().nextInt(23001);
                        livingEntity.addStatusEffect(new StatusEffectInstance(ModEffects.ILLNESS, duration, 0, true, false, false));
                    }
                    ItemStack newStack = new ItemStack(ModItems.VIRUS_DEAD);

                    if (entity instanceof PlayerEntity player && slot != null) {
                        player.getInventory().setStack(slot.getEntitySlotId(), newStack);
                    }
                }
            }
        }

        super.inventoryTick(stack, world, entity, slot);
    }

    @Override
    public Text getName(ItemStack stack) {
        String color = getColorFromDamage(stack);
        return Text.translatable(this.translationKey)
                .copy()
                .append(Text.literal(" §7(§" + color + "Alive§7)"));
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, TooltipDisplayComponent displayComponent, Consumer<Text> textConsumer, TooltipType type) {
        int hp = stack.getMaxDamage() - stack.getDamage();
        String color = getColorFromDamage(stack);
        Text line = Text.translatable("tooltip.prixilium.virus_alive.1")
                .append(" §" + color + (hp) + " / 100 HP.");
        textConsumer.accept(line);
        textConsumer.accept(Text.translatable("tooltip.prixilium.virus_alive.2"));
        super.appendTooltip(stack, context, displayComponent, textConsumer, type);
    }

    private String getColorFromDamage(ItemStack stack) {
        int hp = stack.getMaxDamage() - stack.getDamage();
        String color = "c";
        if (hp >= 75) color = "a";
        else if (hp >= 50) color = "e";
        else if (hp >= 25) color = "6";
        return color;
    }
}