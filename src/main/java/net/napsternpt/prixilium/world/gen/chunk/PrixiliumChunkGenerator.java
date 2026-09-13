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
import net.napsternpt.prixilium.world.ModPath;
import net.napsternpt.prixilium.world.ModStructureSpots;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class PrixiliumChunkGenerator extends ChunkGenerator {
	private static final int MIN_RADIUS_CHUNKS = 8;
	private static final int MAX_RADIUS_CHUNKS = 16;
	private static final int BLOCKS_PER_CHUNK = 16;
	private static final int RIM_SMOOTH = 64;
	private static final int TOP_CENTER = 64;
	private static final int TOP_EDGE = 54;
	private static final int THICK_CENTER = 44;
	private static final int HEIGHT_NOISE_AMP = 6;
	private static final int NOISE_CELL = 32;
	private static final double MIN_EDGE = 0.06;
	private static final double MIN_TOP = 2.0;
	private static final BlockState AIR = Blocks.AIR.getDefaultState();
	private static final BlockState DIAMOND_BLOCK = Blocks.DIAMOND_BLOCK.getDefaultState();
	private static final Identifier RADIUS_DERIVER = Identifier.of(Prixilium.MOD_ID, "island_radius");

	private List<ModPath.PathTarget> structureTargets;

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
		Random random = noiseConfig.getOrCreateRandomDeriver(RADIUS_DERIVER).split("island_radius");
		return random.nextBetween(MIN_RADIUS_CHUNKS, MAX_RADIUS_CHUNKS) * BLOCKS_PER_CHUNK;
	}

	private List<ModPath.PathTarget> getStructureTargets(NoiseConfig noiseConfig) {
		if (structureTargets == null) {
			List<ModPath.PathTarget> targets = new ArrayList<>();
			targets.add(new ModPath.PathTarget(Prixilium.SPAWN_POS, ModPath.STRUCTURE_HALF));
			targets.addAll(ModStructureSpots.computeSpots(noiseConfig, getRadiusBlocks(noiseConfig)).stream()
					.map(spot -> new ModPath.PathTarget(spot.center(), spot.halfExtent())).toList());
			structureTargets = targets;
		}
		return structureTargets;
	}

	public void setPathTargets(List<ModPath.PathTarget> targets) {
		structureTargets = targets;
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
		int radius = getRadiusBlocks(noiseConfig);
		List<ModPath.PathTarget> targets = getStructureTargets(noiseConfig);
		ChunkPos chunkPos = chunk.getPos();
		int chunkX = chunkPos.x * BLOCKS_PER_CHUNK;
		int chunkZ = chunkPos.z * BLOCKS_PER_CHUNK;
		for (int dz = 0; dz < BLOCKS_PER_CHUNK; dz++) {
			int z = chunkZ + dz;
			for (int dx = 0; dx < BLOCKS_PER_CHUNK; dx++) {
				int x = chunkX + dx;
				if (!ModPath.isOnPath(x, z, BlockPos.ORIGIN, targets) || Math.floorMod(x * 31 + z * 17, 2) != 0) {
					continue;
				}
				RadialProfile profile = RadialProfile.of(x, z, radius);
				if (profile == null) {
					continue;
				}
				int topY = profile.top;
				if (topY - 1 >= chunk.getBottomY() && topY <= chunk.getBottomY() + chunk.getHeight()) {
					chunk.setBlockState(new BlockPos(x, topY - 1, z), DIAMOND_BLOCK);
				}
			}
		}
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
		RadialProfile profile = RadialProfile.of(x, z, getRadiusBlocks(noiseConfig));
		if (profile == null) {
			return world.getBottomY();
		}
		return profile.top;
	}

	@Override
	public VerticalBlockSample getColumnSample(int x, int z, HeightLimitView world, NoiseConfig noiseConfig) {
		RadialProfile profile = RadialProfile.of(x, z, getRadiusBlocks(noiseConfig));
		if (profile == null) {
			BlockState[] states = new BlockState[world.getHeight()];
			Arrays.fill(states, AIR);
			return new VerticalBlockSample(world.getBottomY(), states);
		}
		BlockState[] states = new BlockState[world.getHeight()];
		Arrays.fill(states, AIR);
		int topIndex = profile.top - world.getBottomY();
		int bottomIndex = profile.bottom - world.getBottomY();
		BlockState islandBlock = delegate.getSettings().value().defaultBlock();
		for (int i = Math.max(0, bottomIndex); i < Math.min(states.length, topIndex); i++) {
			states[i] = islandBlock;
		}
		if (ModPath.isOnPath(x, z, BlockPos.ORIGIN, getStructureTargets(noiseConfig)) && Math.floorMod(x * 31 + z * 17, 2) == 0) {
			states[topIndex - 1] = DIAMOND_BLOCK;
		}
		return new VerticalBlockSample(world.getBottomY(), states);
	}

	@Override
	public void appendDebugHudText(List<String> texts, NoiseConfig noiseConfig, BlockPos pos) {
		delegate.appendDebugHudText(texts, noiseConfig, pos);
	}

	private Chunk sculptIsland(Chunk chunk, NoiseConfig noiseConfig) {
		int radius = getRadiusBlocks(noiseConfig);
		List<ModPath.PathTarget> targets = getStructureTargets(noiseConfig);
		int minY = chunk.getBottomY();
		int maxY = minY + chunk.getHeight();
		BlockState islandBlock = delegate.getSettings().value().defaultBlock();
		ChunkPos chunkPos = chunk.getPos();
		int chunkX = chunkPos.x * BLOCKS_PER_CHUNK;
		int chunkZ = chunkPos.z * BLOCKS_PER_CHUNK;

		for (int dz = 0; dz < BLOCKS_PER_CHUNK; dz++) {
			int z = chunkZ + dz;
			for (int dx = 0; dx < BLOCKS_PER_CHUNK; dx++) {
				int x = chunkX + dx;
				RadialProfile profile = RadialProfile.of(x, z, radius);
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
					BlockState target = solid ? islandBlock : AIR;
					BlockPos pos = new BlockPos(x, y, z);
					if (!chunk.getBlockState(pos).equals(target)) {
						chunk.setBlockState(pos, target);
					}
				}
				if (ModPath.isOnPath(x, z, BlockPos.ORIGIN, targets) && Math.floorMod(x * 31 + z * 17, 2) == 0) {
					chunk.setBlockState(new BlockPos(x, top - 1, z), DIAMOND_BLOCK);
				}
			}
		}
		return chunk;
	}

	private static void clearColumn(Chunk chunk, int minY, int maxY, int x, int z) {
		for (int y = minY; y < maxY; y++) {
			chunk.setBlockState(new BlockPos(x, y, z), AIR);
		}
	}

	private record RadialProfile(int top, int bottom) {
		static RadialProfile of(int x, int z, int radius) {
			long distanceSquared = (long) x * x + (long) z * z;
			long radiusSquared = (long) radius * radius;
			if (distanceSquared > radiusSquared) {
				return null;
			}
			double distance = Math.sqrt(distanceSquared);
			double edge = Math.clamp((radius - distance) / RIM_SMOOTH, 0.0, 1.0);
			double smooth = smootherStep(edge);
			if (smooth < MIN_EDGE) {
				return null;
			}
			double base = TOP_EDGE + (TOP_CENTER - TOP_EDGE) * smooth;
			double noise = surfaceNoise(x, z) * HEIGHT_NOISE_AMP * smooth;
			double top = Math.max(MIN_TOP, Math.round(base + noise));
			int thickness = (int) Math.round(THICK_CENTER * smooth);
			return new RadialProfile((int) top, (int) top - thickness);
		}

		private static double surfaceNoise(int x, int z) {
			int gx = Math.floorDiv(x, NOISE_CELL);
			int gz = Math.floorDiv(z, NOISE_CELL);
			double fx = (double) (x - gx * NOISE_CELL) / NOISE_CELL;
			double fz = (double) (z - gz * NOISE_CELL) / NOISE_CELL;
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