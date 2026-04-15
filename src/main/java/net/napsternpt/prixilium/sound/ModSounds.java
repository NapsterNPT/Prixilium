package net.napsternpt.prixilium.sound;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.napsternpt.prixilium.Prixilium;

public class ModSounds {
    public static final SoundEvent PRIXILIUM_EXPAND = registerSoundEvent("prixilium_expand");

    //Entities
    public static final SoundEvent BLIKO_AMBIENT = registerSoundEvent("bliko_ambient");
    public static final SoundEvent BLIKO_HURT = registerSoundEvent("bliko_hurt");
    public static final SoundEvent BLIKO_DEATH = registerSoundEvent("bliko_death");

    public static final SoundEvent BLOKITO_HURT = registerSoundEvent("blokito_hurt");
    public static final SoundEvent BLOKITO_DEATH = registerSoundEvent("blokito_death");
    public static final SoundEvent BLOKITO_WALK = registerSoundEvent("blokito_walk");

    private static SoundEvent registerSoundEvent(String name) {
        Identifier id = Identifier.of(Prixilium.MOD_ID, name);
        return Registry.register(Registries.SOUND_EVENT, id, SoundEvent.of(id));
    }

    public static void registerSounds() {Prixilium.LOGGER.info("Registering Prixilium Sounds.");}
}
