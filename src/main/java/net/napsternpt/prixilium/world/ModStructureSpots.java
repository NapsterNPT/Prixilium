package net.napsternpt.prixilium.world;

import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.gen.noise.NoiseConfig;
import net.napsternpt.prixilium.Prixilium;

import java.util.ArrayList;
import java.util.List;

public final class ModStructureSpots {
    private static final Identifier SPOTS_DERIVER = Identifier.of(Prixilium.MOD_ID, "structure_spots");
    private static final int MAX_COPIES = 3;
    private static final List<String> RANDOM_STRUCTURES = List.of("single_tower", "double_tower", "quadruple_tower", "blockito", "blockito_fake");

    public record Spot(String name, BlockPos center, int halfExtent) {

    }

    private static int halfExtent(String structureName) {
        return switch (structureName) {
            case "quadruple_tower", "double_tower" -> 10;
            case "single_tower", "blockito", "blockito_fake" -> 4;
            default -> 5;
        };
    }

    public static List<Spot> computeSpots(NoiseConfig noiseConfig, int islandRadius) {
        Random random = noiseConfig.getOrCreateRandomDeriver(SPOTS_DERIVER).split("positions");
        List<Spot> spots = new ArrayList<>();
        List<BlockPos> placed = new ArrayList<>();
        for (String structureName : RANDOM_STRUCTURES) {
            int copies = random.nextBetween(1, MAX_COPIES);
            for (int copyIndex = 0; copyIndex < copies; copyIndex++) {
                BlockPos candidate = pickSpot(random, islandRadius, placed);
                if (candidate != null) {
                    placed.add(candidate);
                    spots.add(new Spot(structureName, candidate, halfExtent(structureName)));
                }
            }
        }
        return spots;
    }

    private static BlockPos pickSpot(Random random, int islandRadius, List<BlockPos> placed) {
        for (int attempt = 0; attempt < 256; attempt++) {
            double angle = random.nextDouble() * Math.PI * 2;
            int distanceFromCenter = Math.max(ModPath.STRUCTURE_HALF + 1, (int) Math.round(islandRadius * (0.35 + 0.45 * random.nextDouble())));
            if (distanceFromCenter >= islandRadius - 30) {
                continue;
            }
            int x = (int) Math.round(Math.cos(angle) * distanceFromCenter);
            int z = (int) Math.round(Math.sin(angle) * distanceFromCenter);
            BlockPos test = new BlockPos(x, 0, z);
            if (ModPath.squaredDistanceToSegment(x, z, BlockPos.ORIGIN, Prixilium.SPAWN_POS) < 256
                    || squareDistanceBetween(test, Prixilium.SPAWN_POS) < 30 * 30
                    || squareDistanceBetween(test, BlockPos.ORIGIN) < 30 * 30) {
                continue;
            }
            boolean tooClose = false;
            for (BlockPos other : placed) {
                if (squareDistanceBetween(test, other) < 400) {
                    tooClose = true;
                    break;
                }
            }
            if (!tooClose) {
                return test;
            }
        }
        return null;
    }

    private static long squareDistanceBetween(BlockPos a, BlockPos b) {
        long dX = (long) a.getX() - b.getX();
        long dZ = (long) a.getZ() - b.getZ();
        return dX * dX + dZ * dZ;
    }
}