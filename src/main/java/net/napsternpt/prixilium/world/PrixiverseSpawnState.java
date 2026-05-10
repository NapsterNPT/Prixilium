package net.napsternpt.prixilium.world;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.world.PersistentState;
import net.minecraft.world.PersistentStateType;

public class PrixiverseSpawnState extends PersistentState {

    public static final Codec<PrixiverseSpawnState> CODEC = RecordCodecBuilder.create(instance ->
            instance.group(
                    Codec.BOOL.fieldOf("spawn_placed").forGetter(s -> s.spawnPlaced)
            ).apply(instance, spawnPlaced -> {
                PrixiverseSpawnState state = new PrixiverseSpawnState();
                state.spawnPlaced = spawnPlaced;
                return state;
            })
    );

    public static final PersistentStateType<PrixiverseSpawnState> TYPE = new PersistentStateType<>(
            "prixiverse_spawn",
            PrixiverseSpawnState::new,
            CODEC,
            null
    );

    private boolean spawnPlaced = false;

    public PrixiverseSpawnState() {}

    public boolean isSpawnPlaced() {
        return spawnPlaced;
    }

    public void markSpawnPlaced() {
        this.spawnPlaced = true;
        markDirty();
    }
}
