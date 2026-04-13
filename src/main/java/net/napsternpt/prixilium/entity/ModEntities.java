package net.napsternpt.prixilium.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;
import net.napsternpt.prixilium.Prixilium;
import net.napsternpt.prixilium.entity.custom.*;
import net.napsternpt.prixilium.entity.projectile.PrixiliumHookEntity;

public class ModEntities {

    public static final EntityType<PrixiliumHookEntity> PRIXILIUM_HOOK = Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(Prixilium.MOD_ID, "prixilium_hook"),
            EntityType.Builder.<PrixiliumHookEntity>create(PrixiliumHookEntity::new, SpawnGroup.MISC)
                    .build(RegistryKey.of(Registries.ENTITY_TYPE.getKey(), Identifier.of(Prixilium.MOD_ID, "prixilium_hook")))
    );

    public static final EntityType<BlikoEntity> BLIKO = Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(Prixilium.MOD_ID, "bliko"),
            EntityType.Builder.create(BlikoEntity::new, SpawnGroup.CREATURE)
                    .dimensions(0.65F, 0.7F)
                    .build(RegistryKey.of(Registries.ENTITY_TYPE.getKey(), Identifier.of(Prixilium.MOD_ID, "bliko")))
    );

    public static final EntityType<BlokitoEntity> BLOKITO = Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(Prixilium.MOD_ID, "blokito"),
            EntityType.Builder.create(BlokitoEntity::new, SpawnGroup.CREATURE)
                    .dimensions(0.99F, 0.99F)
                    .build(RegistryKey.of(Registries.ENTITY_TYPE.getKey(), Identifier.of(Prixilium.MOD_ID, "blokito")))
    );

    public static void registerModEntities() {
        Prixilium.LOGGER.info("Registering Prixilium Entities.");
    }
}
