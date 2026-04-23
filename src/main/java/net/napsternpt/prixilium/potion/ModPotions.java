package net.napsternpt.prixilium.potion;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.potion.Potion;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.napsternpt.prixilium.Prixilium;
import net.napsternpt.prixilium.effect.ModEffects;

public class ModPotions {
    public static final RegistryEntry<Potion> PRIXILIUM_SLOWNESS_POTION = registerPotion(
            new Potion("prixilium_slowness_potion", new StatusEffectInstance(ModEffects.PRIXILIUM_SLOWNESS, 1200, 0)));

    private static RegistryEntry<Potion> registerPotion(Potion potion) {
        return Registry.registerReference(Registries.POTION, Identifier.of(Prixilium.MOD_ID, potion.getBaseName()), potion);
    };

    public static void registerPotions() {Prixilium.LOGGER.info("Registering Prixilium Potions.");}
}
