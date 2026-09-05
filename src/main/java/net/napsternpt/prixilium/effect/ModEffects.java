package net.napsternpt.prixilium.effect;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.napsternpt.prixilium.Prixilium;
import net.napsternpt.prixilium.effect.custom.*;

public class ModEffects {

    public static final RegistryEntry<StatusEffect> PRIXILIUM_SLOWNESS = registerStatusEffect("prixilium_slowness",
            new PrixiliumSlownessEffect(StatusEffectCategory.HARMFUL, 0xffcb00));

    public static final RegistryEntry<StatusEffect> ILLNESS = registerStatusEffect("illness",
            new IllnessEffect(StatusEffectCategory.NEUTRAL, 0x6baf00));

    public static final RegistryEntry<StatusEffect> PRIXILIUM_IMMUNITY = registerStatusEffect("prixilium_immunity",
            new PrixiliumImmunityEffect(StatusEffectCategory.BENEFICIAL, 0xf7f1d8));

    public static final RegistryEntry<StatusEffect> STUNNED = registerStatusEffect("stunned",
            new StunnedEffect(StatusEffectCategory.HARMFUL, 0xFF4444));

    public static RegistryEntry<StatusEffect> registerStatusEffect(String name, StatusEffect statusEffect) {
        return Registry.registerReference(Registries.STATUS_EFFECT, Identifier.of(Prixilium.MOD_ID, name), statusEffect);
    }

    public static void registerEffects() {
        Prixilium.LOGGER.info("Registering Prixilium Effects.");
    }
}
