package net.napsternpt.prixilium.effect.custom;

import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.util.Identifier;
import net.napsternpt.prixilium.Prixilium;

public class StunnedEffect extends StatusEffect {
    public StunnedEffect(StatusEffectCategory category, int color) {
        super(category, color);
        addAttributeModifier(
                EntityAttributes.MOVEMENT_SPEED,
                Identifier.of(Prixilium.MOD_ID, "effect.stunned.movement_speed"),
                -1.0,
                EntityAttributeModifier.Operation.ADD_MULTIPLIED_TOTAL
        );
        addAttributeModifier(
                EntityAttributes.JUMP_STRENGTH,
                Identifier.of(Prixilium.MOD_ID, "effect.stunned.jump_strength"),
                -1.0,
                EntityAttributeModifier.Operation.ADD_MULTIPLIED_TOTAL
        );
    }
}
