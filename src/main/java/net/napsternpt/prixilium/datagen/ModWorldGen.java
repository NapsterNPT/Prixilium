package net.napsternpt.prixilium.datagen;

import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.gen.chunk.ChunkGeneratorSettings;
import net.napsternpt.prixilium.Prixilium;

public class ModWorldGen {
    public static final RegistryKey<World> PRIXILIUM_WORLD = RegistryKey.of(
            RegistryKeys.WORLD,
            Identifier.of(Prixilium.MOD_ID, "prixiverse")
    );

    public static final RegistryKey<DimensionType> PRIXILIUM_DIMENSION_TYPE = RegistryKey.of(
            RegistryKeys.DIMENSION_TYPE,
            Identifier.of(Prixilium.MOD_ID, "prixilium_dimension_type")
    );

    public static final RegistryKey<Biome> PRIXILIUM_BIOME = RegistryKey.of(
            RegistryKeys.BIOME,
            Identifier.of(Prixilium.MOD_ID, "prixilium_biome")
    );

    public static final RegistryKey<ChunkGeneratorSettings> PRIXILIUM_NOISE = RegistryKey.of(
            RegistryKeys.CHUNK_GENERATOR_SETTINGS,
            Identifier.of(Prixilium.MOD_ID, "prixilium_noise")
    );
}