package net.napsternpt.prixilium.util;

import com.mojang.serialization.Codec;
import net.minecraft.component.ComponentType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.napsternpt.prixilium.Prixilium;

public class ModDataComponentTypes {
    public static final ComponentType<Boolean> HOOK_ACTIVE = Registry.register(
            Registries.DATA_COMPONENT_TYPE,
            Identifier.of(Prixilium.MOD_ID, "hook_active"),
            ComponentType.<Boolean>builder()
                    .codec(Codec.BOOL)
                    .build()
    );

    public static void registerDataComponentTypes() {Prixilium.LOGGER.info("Registering Data Component Types.");}
}
