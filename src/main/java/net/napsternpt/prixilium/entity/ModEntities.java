package net.napsternpt.prixilium.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;
import net.napsternpt.prixilium.Prixilium;
import net.napsternpt.prixilium.entity.custom.BlikoEntity;

public class ModEntities {

    public static final EntityType<BlikoEntity> BLIKO = Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(Prixilium.MOD_ID, "bliko"),
            EntityType.Builder.create(BlikoEntity::new, SpawnGroup.CREATURE)
                    .dimensions(0.65F, 0.7F)
                    .build(RegistryKey.of(Registries.ENTITY_TYPE.getKey(), Identifier.of(Prixilium.MOD_ID, "bliko")))
    );

    public static void registerModEntities() {
        Prixilium.LOGGER.info("Registering Prixilium Entities");
    }
}
