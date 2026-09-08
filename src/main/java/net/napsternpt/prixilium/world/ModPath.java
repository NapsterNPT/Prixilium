package net.napsternpt.prixilium.world;

import net.minecraft.util.math.BlockPos;
import net.napsternpt.prixilium.Prixilium;

import java.util.List;

public final class ModPath {
    public static final int PATH_HALF_WIDTH = 1;
    public static final int STRUCTURE_HALF = 5;

    public record PathTarget(BlockPos center, int halfExtent) {
    }

    private ModPath() {
    }

    public static boolean isOnPath(int x, int z, List<PathTarget> branchTargets, BlockPos from, BlockPos to) {
        if (withinStructure(x, z, from, STRUCTURE_HALF) || withinStructure(x, z, to, STRUCTURE_HALF)) {
            return false;
        }
        long halfSquared = (long) PATH_HALF_WIDTH * PATH_HALF_WIDTH;
        if (squaredDistanceToSegment(x, z, from, to) <= halfSquared) {
            return true;
        }
        for (PathTarget target : branchTargets) {
            if (withinStructure(x, z, target.center(), target.halfExtent())) {
                return false;
            }
        }
        for (PathTarget target : branchTargets) {
            if (squaredDistanceToSegment(x, z, to, target.center()) <= halfSquared) {
                return true;
            }
        }
        return false;
    }

    public static boolean withinStructure(int x, int z, BlockPos center, int halfExtent) {
        return Math.abs(x - center.getX()) <= halfExtent && Math.abs(z - center.getZ()) <= halfExtent;
    }

    public static long squaredDistanceToSegment(int x, int z, BlockPos a, BlockPos b) {
        long dX = b.getX() - a.getX();
        long dZ = b.getZ() - a.getZ();
        long lengthSquared = dX * dX + dZ * dZ;
        if (lengthSquared == 0) {
            return (long) (x - a.getX()) * (x - a.getX()) + (long) (z - a.getZ()) * (z - a.getZ());
        }
        double t = ((double) (x - a.getX()) * dX + (double) (z - a.getZ()) * dZ) / lengthSquared;
        t = Math.max(0.0, Math.min(1.0, t));
        double nearestX = a.getX() + t * dX;
        double nearestZ = a.getZ() + t * dZ;
        double offsetX = x - nearestX;
        double offsetZ = z - nearestZ;
        return (long) (offsetX * offsetX + offsetZ * offsetZ);
    }
}