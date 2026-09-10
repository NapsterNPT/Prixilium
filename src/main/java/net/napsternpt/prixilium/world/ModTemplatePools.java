package net.napsternpt.prixilium.world;

import com.mojang.datafixers.util.Pair;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.structure.pool.StructurePool;
import net.minecraft.structure.pool.StructurePoolElement;
import net.minecraft.structure.pool.StructurePools;
import net.minecraft.util.Identifier;
import net.napsternpt.prixilium.Prixilium;

import java.util.List;

public class ModTemplatePools {
    public static final RegistryKey<StructurePool> SPAWN_START_POOL = RegistryKey.of(RegistryKeys.TEMPLATE_POOL, Identifier.of(Prixilium.MOD_ID, "spawn/start_pool"));
    public static final RegistryKey<StructurePool> PORTAL_START_POOL = RegistryKey.of(RegistryKeys.TEMPLATE_POOL, Identifier.of(Prixilium.MOD_ID, "portal/start_pool"));
    public static final RegistryKey<StructurePool> EXHAUST_TOWER_START_POOL = RegistryKey.of(RegistryKeys.TEMPLATE_POOL, Identifier.of(Prixilium.MOD_ID, "exhaust_tower/start_pool"));
    public static final RegistryKey<StructurePool> FOUNTAIN_START_POOL = RegistryKey.of(RegistryKeys.TEMPLATE_POOL, Identifier.of(Prixilium.MOD_ID, "fountain/start_pool"));
    public static final RegistryKey<StructurePool> SINGLE_TOWER_START_POOL = RegistryKey.of(RegistryKeys.TEMPLATE_POOL, Identifier.of(Prixilium.MOD_ID, "single_tower/start_pool"));
    public static final RegistryKey<StructurePool> DOUBLE_TOWER_START_POOL = RegistryKey.of(RegistryKeys.TEMPLATE_POOL, Identifier.of(Prixilium.MOD_ID, "double_tower/start_pool"));
    public static final RegistryKey<StructurePool> QUADRUPLE_TOWER_START_POOL = RegistryKey.of(RegistryKeys.TEMPLATE_POOL, Identifier.of(Prixilium.MOD_ID, "quadruple_tower/start_pool"));
    public static final RegistryKey<StructurePool> BLOCKITO_START_POOL = RegistryKey.of(RegistryKeys.TEMPLATE_POOL, Identifier.of(Prixilium.MOD_ID, "blockito/start_pool"));
    public static final RegistryKey<StructurePool> BLOCKITO_FAKE_START_POOL = RegistryKey.of(RegistryKeys.TEMPLATE_POOL, Identifier.of(Prixilium.MOD_ID, "blockito_fake/start_pool"));
    public static final RegistryKey<StructurePool> RIFT_TEMPLE_START_POOL = RegistryKey.of(RegistryKeys.TEMPLATE_POOL, Identifier.of(Prixilium.MOD_ID, "rift_temple/start_pool"));

    private static void registerSingle(Registerable<StructurePool> context, RegistryKey<StructurePool> key, RegistryEntry.Reference<StructurePool> empty, String templateName) {
        context.register(key, new StructurePool(empty,
                List.of(Pair.of(StructurePoolElement.ofSingle(String.valueOf(Identifier.of(Prixilium.MOD_ID, templateName))), 1)),
                StructurePool.Projection.RIGID));
    }

    public static void bootstrap(Registerable<StructurePool> context) {
        RegistryEntry.Reference<StructurePool> empty = context.getRegistryLookup(RegistryKeys.TEMPLATE_POOL).getOrThrow(StructurePools.EMPTY);

        registerSingle(context, SPAWN_START_POOL, empty, "spawn");
        registerSingle(context, PORTAL_START_POOL, empty, "portal");
        registerSingle(context, EXHAUST_TOWER_START_POOL, empty, "exhaust_tower");
        registerSingle(context, FOUNTAIN_START_POOL, empty, "fountain");
        registerSingle(context, SINGLE_TOWER_START_POOL, empty, "single_tower");
        registerSingle(context, DOUBLE_TOWER_START_POOL, empty, "double_tower");
        registerSingle(context, QUADRUPLE_TOWER_START_POOL, empty, "quadruple_tower");
        registerSingle(context, BLOCKITO_START_POOL, empty, "blockito");
        registerSingle(context, BLOCKITO_FAKE_START_POOL, empty, "blockito_fake");
        registerSingle(context, RIFT_TEMPLE_START_POOL, empty, "rift_temple");
    }
}
