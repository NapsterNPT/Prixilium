package net.napsternpt.prixilium.world;

import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.gen.noise.NoiseConfig;
import net.napsternpt.prixilium.Prixilium;
import net.napsternpt.prixilium.world.gen.chunk.PrixiliumChunkGenerator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class PrixiliumWorldgenAnchors {

    public static final int BRIDGE_SPAN_MINUS_ONE = 21;

    private static final Direction[] CARDINALS = {Direction.NORTH, Direction.SOUTH, Direction.EAST, Direction.WEST};

    private static final Map<NoiseConfig, AnchorSet> CACHE = new HashMap<>();

    public record BridgeTarget(Direction direction, int ring, int innerDistance, BlockPos baseAnchor) {

    }

    private record AnchorSet(Map<String, Set<Long>> anchorChunks, List<BridgeTarget> bridgeTargets) {

    }

    public static boolean isAnchorChunk(String kind, NoiseConfig noiseConfig, int chunkX, int chunkZ) {
        Set<Long> chunks = getAnchorSet(noiseConfig).anchorChunks().get(kind);
        return chunks != null && chunks.contains(ChunkPos.toLong(chunkX, chunkZ));
    }

    public static List<BridgeTarget> bridgeTargets(NoiseConfig noiseConfig) {
        return getAnchorSet(noiseConfig).bridgeTargets();
    }

    private static AnchorSet getAnchorSet(NoiseConfig noiseConfig) {
        synchronized (CACHE) {
            return CACHE.computeIfAbsent(noiseConfig, PrixiliumWorldgenAnchors::computeAnchorSet);
        }
    }

    private static AnchorSet computeAnchorSet(NoiseConfig noiseConfig) {
        int radius = PrixiliumChunkGenerator.getRadiusBlocks(noiseConfig);
        int ringCount = PrixiliumChunkGenerator.getRingCount(noiseConfig);

        Map<String, Set<Long>> anchorChunks = new HashMap<>();
        anchorChunks.computeIfAbsent("fountain", ignored -> new HashSet<>()).add(ChunkPos.toLong(0, 0));
        anchorChunks.computeIfAbsent("shaft", ignored -> new HashSet<>()).add(ChunkPos.toLong(0, 0));
        anchorChunks.computeIfAbsent("spawn", ignored -> new HashSet<>())
                .add(ChunkPos.toLong(Math.floorDiv(Prixilium.SPAWN_POS.getX(), 16), Math.floorDiv(Prixilium.SPAWN_POS.getZ(), 16)));

        for (ModStructureSpots.Spot spot : ModStructureSpots.computeSpots(noiseConfig, radius)) {
            anchorChunks.computeIfAbsent(spot.name(), ignored -> new HashSet<>())
                    .add(ChunkPos.toLong(Math.floorDiv(spot.center().getX(), 16), Math.floorDiv(spot.center().getZ(), 16)));
        }

        List<BridgeTarget> bridgeTargets = new ArrayList<>();
        Set<Long> bridgeChunks = new HashSet<>();
        for (int gap = 0; gap < ringCount; gap++) {
            int innerDistance = Math.max(16, PrixiliumChunkGenerator.ringInnerEdge(radius, gap) - BRIDGE_SPAN_MINUS_ONE);
            for (Direction direction : CARDINALS) {
                BlockPos baseAnchor = new BlockPos(direction.getOffsetX() * innerDistance, 0, direction.getOffsetZ() * innerDistance);
                bridgeTargets.add(new BridgeTarget(direction, gap, innerDistance, baseAnchor));
                bridgeChunks.add(ChunkPos.toLong(Math.floorDiv(baseAnchor.getX(), 16), Math.floorDiv(baseAnchor.getZ(), 16)));
            }
        }
        anchorChunks.put("bridge", bridgeChunks);

        return new AnchorSet(anchorChunks, List.copyOf(bridgeTargets));
    }

    private PrixiliumWorldgenAnchors() {
    }
}