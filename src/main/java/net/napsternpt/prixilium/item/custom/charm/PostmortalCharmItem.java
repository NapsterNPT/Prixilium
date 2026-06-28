package net.napsternpt.prixilium.item.custom.charm;

import net.minecraft.advancement.AdvancementEntry;
import net.minecraft.component.type.TooltipDisplayComponent;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.registry.tag.DamageTypeTags;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.napsternpt.prixilium.Prixilium;
import net.napsternpt.prixilium.item.custom.CharmItem;

import java.util.Objects;
import java.util.function.Consumer;

public class PostmortalCharmItem extends CharmItem {

    public PostmortalCharmItem(CharmSettings settings) {
        super(settings);
    }

    public static boolean tryUse(ServerPlayerEntity player, DamageSource source) {
        if (source.isIn(DamageTypeTags.BYPASSES_INVULNERABILITY)) return false;

        ItemStack charmStack = ItemStack.EMPTY;
        for (int i = 0; i < player.getInventory().size(); i++) {
            ItemStack stack = player.getInventory().getStack(i);
            if (stack.getItem() instanceof PostmortalCharmItem && stack.getDamage() < stack.getMaxDamage()) {
                charmStack = stack;
                break;
            }
        }

        if (charmStack.isEmpty()) return false;
        int maxDamage = charmStack.getMaxDamage();
        int tier;
        if (maxDamage <= 1) tier = 1;
        else if (maxDamage <= 4) tier = 2;
        else tier = 3;

        player.clearStatusEffects();
        player.setHealth(1.0F);

        switch (tier) {
            case 1 -> {
                player.addStatusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 200, 1, false, true, true));
                player.addStatusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 100, 1, false, true, true));
            }
            case 2 -> {
                player.addStatusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 200, 2, false, true, true));
                player.addStatusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 200, 2, false, true, true));
                player.addStatusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 100, 0, false, true, true));
            }
            case 3 -> {
                player.addStatusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 200, 3, false, true, true));
                player.addStatusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 300, 3, false, true, true));
                player.addStatusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 200, 1, false, true, true));
                player.addStatusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 400, 0, false, true, true));

                if (charmStack.getDamage() == 7) {
                    AdvancementEntry advancement = player.getEntityWorld().getServer().getAdvancementLoader().get(Identifier.of(Prixilium.MOD_ID, "postmortal_final"));
                    player.getAdvancementTracker().grantCriterion(advancement, "postmortal_final");
                }
            }
        }

        if (!player.isInCreativeMode()) {
            charmStack.damage(1, player, EquipmentSlot.MAINHAND);
        }

        ServerWorld serverWorld = player.getEntityWorld();
        serverWorld.spawnParticles(ParticleTypes.TOTEM_OF_UNDYING,
                player.getX(), player.getY() + 1.0, player.getZ(),
                64, player.getWidth() / 2.0, player.getHeight() / 2.0, player.getWidth() / 2.0, 0.1);
        serverWorld.playSound(null, player.getX(), player.getY(), player.getZ(),
                SoundEvents.ITEM_TOTEM_USE, SoundCategory.PLAYERS, 1.0F, 1.0F);
        serverWorld.spawnParticles(ParticleTypes.TOTEM_OF_UNDYING,
                player.getX(), player.getY() + 1.0, player.getZ(),
                64, player.getWidth() / 2.0, player.getHeight() / 2.0, player.getWidth() / 2.0, 0.1);

        AdvancementEntry advancement = serverWorld.getServer().getAdvancementLoader().get(Identifier.of(Prixilium.MOD_ID, "postmortal"));
        player.getAdvancementTracker().grantCriterion(advancement, "postmortal");

        return true;
    }

    @Override
    public void appendTooltip(ItemStack stack, Item.TooltipContext context, TooltipDisplayComponent displayComponent, Consumer<Text> textConsumer, TooltipType type) {
        textConsumer.accept(Text.translatable("tooltip.prixilium.postmortal_charm"));
        super.appendTooltip(stack, context, displayComponent, textConsumer, type);
    }
}