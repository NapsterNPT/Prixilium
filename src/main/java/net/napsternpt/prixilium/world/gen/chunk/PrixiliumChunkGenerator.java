package net.napsternpt.prixilium.world.gen.chunk;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.ChunkRegion;
import net.minecraft.world.HeightLimitView;
import net.minecraft.world.Heightmap;
import net.minecraft.world.biome.source.BiomeAccess;
import net.minecraft.world.biome.source.BiomeSource;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.gen.StructureAccessor;
import net.minecraft.world.gen.chunk.Blender;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.chunk.ChunkGeneratorSettings;
import net.minecraft.world.gen.chunk.NoiseChunkGenerator;
import net.minecraft.world.gen.chunk.VerticalBlockSample;
import net.minecraft.world.gen.noise.NoiseConfig;
import net.napsternpt.prixilium.Prixilium;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class PrixiliumChunkGenerator extends ChunkGenerator {

	public static final MapCodec<PrixiliumChunkGenerator> CODEC = RecordCodecBuilder.mapCodec(instance ->
			instance.group(
					BiomeSource.CODEC.fieldOf("biome_source").forGetter(ChunkGenerator::getBiomeSource),
					ChunkGeneratorSettings.REGISTRY_CODEC.fieldOf("settings").forGetter(PrixiliumChunkGenerator::getSettings)
			).apply(instance, PrixiliumChunkGenerator::new));

	private final NoiseChunkGenerator delegate;

	public PrixiliumChunkGenerator(BiomeSource biomeSource, RegistryEntry<ChunkGeneratorSettings> settings) {
		super(biomeSource);
		this.delegate = new NoiseChunkGenerator(biomeSource, settings);
	}

	public RegistryEntry<ChunkGeneratorSettings> getSettings() {
		return delegate.getSettings();
	}

	@Override
	protected MapCodec<? extends ChunkGenerator> getCodec() {
		return CODEC;
	}

	public static int getRadiusBlocks(NoiseConfig noiseConfig) {
		Random random = noiseConfig.getOrCreateRandomDeriver(Identifier.of(Prixilium.MOD_ID, "island_radius")).split("island_radius");
		return random.nextBetween(8, 16) * 16;
	}

	public static int getRingCount(NoiseConfig noiseConfig) {
		Random random = noiseConfig.getOrCreateRandomDeriver(Identifier.of(Prixilium.MOD_ID, "ring_mode")).split("count");
		return random.nextBetween(0, 5);
	}

	@Override
	public CompletableFuture<Chunk> populateNoise(Blender blender, NoiseConfig noiseConfig, StructureAccessor structureAccessor, Chunk chunk) {
		return delegate.populateNoise(blender, noiseConfig, structureAccessor, chunk)
				.thenApply(generated -> sculptIsland(generated, noiseConfig));
	}

	@Override
	public void carve(ChunkRegion chunkRegion, long seed, NoiseConfig noiseConfig, BiomeAccess biomeAccess, StructureAccessor structureAccessor, Chunk chunk) {
		delegate.carve(chunkRegion, seed, noiseConfig, biomeAccess, structureAccessor, chunk);
	}

	@Override
	public void buildSurface(ChunkRegion chunkRegion, StructureAccessor structureAccessor, NoiseConfig noiseConfig, Chunk chunk) {
		delegate.buildSurface(chunkRegion, structureAccessor, noiseConfig, chunk);
	}

	@Override
	public void populateEntities(ChunkRegion chunkRegion) {
		delegate.populateEntities(chunkRegion);
	}

	@Override
	public int getWorldHeight() {
		return delegate.getWorldHeight();
	}

	@Override
	public int getSeaLevel() {
		return delegate.getSeaLevel();
	}

	@Override
	public int getMinimumY() {
		return delegate.getMinimumY();
	}

	@Override
	public int getHeight(int x, int z, Heightmap.Type type, HeightLimitView world, NoiseConfig noiseConfig) {
		RadialProfile profile = RadialProfile.of(x, z, getRadiusBlocks(noiseConfig), getRingCount(noiseConfig));
		if (profile == null) {
			return world.getBottomY();
		}
		return profile.top;
	}

	@Override
	public VerticalBlockSample getColumnSample(int x, int z, HeightLimitView world, NoiseConfig noiseConfig) {
		RadialProfile profile = RadialProfile.of(x, z, getRadiusBlocks(noiseConfig), getRingCount(noiseConfig));
		if (profile == null) {
			BlockState[] states = new BlockState[world.getHeight()];
			Arrays.fill(states, Blocks.AIR.getDefaultState());
			return new VerticalBlockSample(world.getBottomY(), states);
		}
		BlockState[] states = new BlockState[world.getHeight()];
		Arrays.fill(states, Blocks.AIR.getDefaultState());
		int topIndex = profile.top - world.getBottomY();
		int bottomIndex = profile.bottom - world.getBottomY();
		BlockState islandBlock = delegate.getSettings().value().defaultBlock();
		for (int i = Math.max(0, bottomIndex); i < Math.min(states.length, topIndex); i++) {
			states[i] = islandBlock;
		}
		return new VerticalBlockSample(world.getBottomY(), states);
	}

	@Override
	public void appendDebugHudText(List<String> texts, NoiseConfig noiseConfig, BlockPos pos) {
		delegate.appendDebugHudText(texts, noiseConfig, pos);
	}

	private Chunk sculptIsland(Chunk chunk, NoiseConfig noiseConfig) {
		int radius = getRadiusBlocks(noiseConfig);
		int minY = chunk.getBottomY();
		int maxY = minY + chunk.getHeight();
		BlockState islandBlock = delegate.getSettings().value().defaultBlock();
		ChunkPos chunkPos = chunk.getPos();
		int chunkX = chunkPos.x * 16;
		int chunkZ = chunkPos.z * 16;

		for (int dz = 0; dz < 16; dz++) {
			int z = chunkZ + dz;
			for (int dx = 0; dx < 16; dx++) {
				int x = chunkX + dx;
				RadialProfile profile = RadialProfile.of(x, z, radius, getRingCount(noiseConfig));
				if (profile == null) {
					clearColumn(chunk, minY, maxY, x, z);
					continue;
				}
				int top = profile.top;
				int bottom = profile.bottom;
				int fillStart = Math.max(minY, bottom);
				int fillEnd = Math.min(maxY, top);
				for (int y = minY; y < maxY; y++) {
					boolean solid = y >= fillStart && y < fillEnd;
					BlockState target = solid ? islandBlock : Blocks.AIR.getDefaultState();
					BlockPos pos = new BlockPos(x, y, z);
					if (!chunk.getBlockState(pos).equals(target)) {
						chunk.setBlockState(pos, target);
					}
				}
			}
		}
		return chunk;
	}

	private static void clearColumn(Chunk chunk, int minY, int maxY, int x, int z) {
		for (int y = minY; y < maxY; y++) {
			chunk.setBlockState(new BlockPos(x, y, z), Blocks.AIR.getDefaultState());
		}
	}

	private record RadialProfile(int top, int bottom) {
		static RadialProfile of(int x, int z, int radius, int ringCount) {
			long distanceSquared = (long) x * x + (long) z * z;
			long radiusSquared = (long) radius * radius;
			if (distanceSquared > radiusSquared) {
				return ringProfile(x, z, radius, distanceSquared, ringCount);
			}
			double distance = Math.sqrt(distanceSquared);
			double edge = Math.clamp((radius - distance) / 64, 0.0, 1.0);
			double smooth = smootherStep(edge);
			if (smooth < 0.06) {
				return null;
			}
			double base = 54 + 10 * smooth;
			double noise = surfaceNoise(x, z) * 6 * smooth;
			double top = Math.max(2.0, Math.round(base + noise));
			int thickness = (int) Math.round(45 * smooth);
			return new RadialProfile((int) top, (int) top - thickness);
		}

		private static RadialProfile ringProfile(int x, int z, int radius, long distanceSquared, int ringCount) {
			if (ringCount <= 0) {
				return null;
			}
			double distance = Math.sqrt(distanceSquared);
			double outerLimit = ringCenter(radius, ringCount - 1) + 16;
			if (distance > outerLimit) {
				return null;
			}
			for (int ring = 0; ring < ringCount; ring++) {
				RadialProfile candidate = singleRingProfile(x, z, radius, distance, ring);
				if (candidate != null) {
					return candidate;
				}
			}
			return null;
		}

		private static double ringCenter(int radius, int ring) {
			return radius + 20 + (double) ring * 40;
		}

		private static RadialProfile singleRingProfile(int x, int z, int radius, double distance, int ring) {
			double center = ringCenter(radius, ring);
			double inner = center - 10;
			double outer = center + 10;
			if (distance < inner - 6 || distance > outer + 6) {
				return null;
			}
			double innerEdge = Math.clamp((distance - inner) / 6, 0.0, 1.0);
			double outerEdge = Math.clamp((outer - distance) / 6, 0.0, 1.0);
			double smooth = Math.min(innerEdge, outerEdge);
			double noise = surfaceNoise(x, z) * 6 * smooth;
			double top = Math.max(2.0, Math.round(54 + noise));
			int thickness = (int) Math.round(5 * smooth);
			if (thickness <= 0) {
				return null;
			}
			return new RadialProfile((int) top, (int) top - thickness);
		}

		private static double surfaceNoise(int x, int z) {
			int gx = Math.floorDiv(x, 32);
			int gz = Math.floorDiv(z, 32);
			double fx = (double) (x - gx * 32) / 32;
			double fz = (double) (z - gz * 32) / 32;
			double sx = smootherStep(fx);
			double sz = smootherStep(fz);
			double h00 = gridValue(gx, gz);
			double h10 = gridValue(gx + 1, gz);
			double h01 = gridValue(gx, gz + 1);
			double h11 = gridValue(gx + 1, gz + 1);
			return lerp(lerp(h00, h10, sx), lerp(h01, h11, sx), sz);
		}

		private static double gridValue(int gx, int gz) {
			long h = hash(gx, gz);
			double value = ((h >>> 1) & 0x3FF) / 1023.0;
			return (h & 1) == 0 ? value : -value;
		}

		private static double lerp(double a, double b, double t) {
			return a + (b - a) * t;
		}

		private static double smootherStep(double t) {
			return t * t * t * (t * (t * 6.0 - 15.0) + 10.0);
		}

		private static long hash(int x, int z) {
			long h = 0x9E3779B97F4A7C15L ^ ((long) x * 0xBF58476D1CE4E5B9L);
			h = (h ^ (h >>> 30)) * 0xBF58476D1CE4E5B9L + 0x94D049BB133111EBL;
			h ^= (long) z * 0x94D049BB133111EBL;
			h = (h ^ (h >>> 27)) * 0xBF58476D1CE4E5B9L;
			h ^= h >>> 31;
			return h;
		}
	}
}