package net.napsternpt.prixilium.effect;

import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.napsternpt.prixilium.Prixilium;

public class ModEffects {

    public static final RegistryEntry<StatusEffect> PRIXILIUM_SLOWNESS = registerStatusEffect("prixilium_slowness",
            new PrixiliumSlownessEffect(StatusEffectCategory.HARMFUL, 0xffcb00)
                    .addAttributeModifier(EntityAttributes.MOVEMENT_SPEED,
                            Identifier.of(Prixilium.MOD_ID, "prixilium_slowness_speed"), -0.25f,
                            EntityAttributeModifier.Operation.ADD_MULTIPLIED_TOTAL)
                    .addAttributeModifier(EntityAttributes.JUMP_STRENGTH,
                            Identifier.of(Prixilium.MOD_ID, "prixilium_slowness_jump"), -0.5f,
                            EntityAttributeModifier.Operation.ADD_MULTIPLIED_TOTAL));

    public static RegistryEntry<StatusEffect> registerStatusEffect(String name, StatusEffect statusEffect) {
        return Registry.registerReference(Registries.STATUS_EFFECT, Identifier.of(Prixilium.MOD_ID, name), statusEffect);
    }

    public static void registerEffects() {
        Prixilium.LOGGER.info("Registering Prixilium Effects");
    }
}
