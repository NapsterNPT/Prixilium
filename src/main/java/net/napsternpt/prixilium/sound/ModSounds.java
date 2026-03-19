package net.napsternpt.prixilium.sound;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.napsternpt.prixilium.Prixilium;

public class ModSounds {
    public static final SoundEvent PRIXILIUM_EXPAND = registerSoundEvent("prixilium_expand");

    private static SoundEvent registerSoundEvent(String name) {
        Identifier id = Identifier.of(Prixilium.MOD_ID, name);
        return Registry.register(Registries.SOUND_EVENT, id, SoundEvent.of(id));
    }

    public static void registerSounds() {
        Prixilium.LOGGER.info("Registering Prixilium Sounds");
    }
}
