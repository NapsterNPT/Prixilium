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

    public static void bootstrap(Registerable<StructurePool> context) {
        RegistryEntry.Reference<StructurePool> empty = context.getRegistryLookup(RegistryKeys.TEMPLATE_POOL).getOrThrow(StructurePools.EMPTY);

        context.register(SPAWN_START_POOL, new StructurePool(empty,
                List.of(Pair.of(StructurePoolElement.ofSingle(String.valueOf(Identifier.of(Prixilium.MOD_ID, "spawn"))), 1)),
                StructurePool.Projection.RIGID));

        context.register(PORTAL_START_POOL, new StructurePool(empty,
                List.of(Pair.of(StructurePoolElement.ofSingle(String.valueOf(Identifier.of(Prixilium.MOD_ID, "portal"))), 1)),
                StructurePool.Projection.RIGID));

        context.register(EXHAUST_TOWER_START_POOL, new StructurePool(empty,
                List.of(Pair.of(StructurePoolElement.ofSingle(String.valueOf(Identifier.of(Prixilium.MOD_ID, "exhaust_tower"))), 1)),
                StructurePool.Projection.RIGID));
    }
}
