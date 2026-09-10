package net.napsternpt.prixilium.world.gen.chunk;

import com.mojang.serialization.MapCodec;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.napsternpt.prixilium.Prixilium;

public class ModChunkGenerators {
	public static final MapCodec<PrixiliumChunkGenerator> PRIXILIUM = register(
			"prixilium_dimension_generator",
			PrixiliumChunkGenerator.CODEC
	);

	private static <T extends ChunkGenerator> MapCodec<T> register(String name, MapCodec<T> codec) {
		return Registry.register(Registries.CHUNK_GENERATOR, Identifier.of(Prixilium.MOD_ID, name), codec);
	}

	public static void registerChunkGenerators() {
		Prixilium.LOGGER.info("Registering Prixilium Chunk Generators.");
	}
}