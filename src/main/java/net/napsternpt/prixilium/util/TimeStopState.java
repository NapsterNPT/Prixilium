package net.napsternpt.prixilium.util;

import net.minecraft.registry.RegistryKey;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.World;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.function.Consumer;

public class TimeStopState {
    private static final Map<RegistryKey<World>, TimeStopInstance> activeStops = new HashMap<>();
    private static final Map<RegistryKey<World>, Boolean> wasActive = new HashMap<>();
    private static Consumer<ServerWorld> onExpiryCallback;

    public static void setOnExpiryCallback(Consumer<ServerWorld> callback) {
        onExpiryCallback = callback;
    }

    public static boolean isTimeStopped(ServerWorld world) {
        RegistryKey<World> key = world.getRegistryKey();
        TimeStopInstance inst = activeStops.get(key);
        if (inst == null) return false;
        if (world.getTime() >= inst.endTick) {
            activeStops.remove(key);
            return false;
        }
        return true;
    }

    public static void tick(ServerWorld world) {
        RegistryKey<World> key = world.getRegistryKey();
        boolean nowActive = isTimeStopped(world);
        boolean was = wasActive.getOrDefault(key, false);
        wasActive.put(key, nowActive);

        if (was && !nowActive && onExpiryCallback != null) {
            onExpiryCallback.accept(world);
        }
    }

    public static UUID getActivator(ServerWorld world) {
        TimeStopInstance inst = activeStops.get(world.getRegistryKey());
        return inst != null ? inst.activatorUuid : null;
    }

    public static boolean isActivator(ServerWorld world, UUID entityUuid) {
        UUID activator = getActivator(world);
        return activator == null || !activator.equals(entityUuid);
    }

    public static void startStop(ServerWorld world, long durationTicks, UUID activatorUuid) {
        activeStops.put(world.getRegistryKey(), new TimeStopInstance(world.getTime() + durationTicks, activatorUuid));
        wasActive.put(world.getRegistryKey(), true);
    }

    private record TimeStopInstance(long endTick, UUID activatorUuid) {}
}
