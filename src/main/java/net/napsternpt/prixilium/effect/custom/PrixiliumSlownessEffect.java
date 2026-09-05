package net.napsternpt.prixilium.effect.custom;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Identifier;
import net.napsternpt.prixilium.Prixilium;

public class PrixiliumSlownessEffect extends StatusEffect {

    public PrixiliumSlownessEffect(StatusEffectCategory category, int color) {
        super(category, color);
        addAttributeModifier(EntityAttributes.MOVEMENT_SPEED,
                Identifier.of(Prixilium.MOD_ID, "prixilium_slowness_speed"), -0.25f,
                EntityAttributeModifier.Operation.ADD_MULTIPLIED_TOTAL);
        addAttributeModifier(EntityAttributes.JUMP_STRENGTH,
                        Identifier.of(Prixilium.MOD_ID, "prixilium_slowness_jump"), -0.5f,
                        EntityAttributeModifier.Operation.ADD_MULTIPLIED_TOTAL);
    }

    @Override
    public boolean applyUpdateEffect(ServerWorld world, LivingEntity entity, int amplifier) {
        return super.applyUpdateEffect(world, entity, amplifier);
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }
}
