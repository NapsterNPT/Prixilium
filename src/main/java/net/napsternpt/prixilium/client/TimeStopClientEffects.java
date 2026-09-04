package net.napsternpt.prixilium.client;

import java.util.UUID;

public class TimeStopClientEffects {
    private static boolean timeStopped = false;
    private static UUID activatorUuid = null;
    private static long endTimeMs = 0;

    public static boolean isTimeStopped() {
        if (timeStopped && endTimeMs > 0 && System.currentTimeMillis() >= endTimeMs) {
            stopTimeStop();
        }
        return timeStopped;
    }

    public static boolean shouldFreeze(UUID uuid) {
        return uuid == null || !uuid.equals(activatorUuid);
    }

    public static void startTimeStop(UUID activator, long durationTicks) {
        timeStopped = true;
        activatorUuid = activator;
        endTimeMs = System.currentTimeMillis() + (durationTicks * 50);
    }

    public static void stopTimeStop() {
        timeStopped = false;
        activatorUuid = null;
        endTimeMs = 0;
    }
}
