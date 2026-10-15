package net.napsternpt.prixilium.world;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.datafixer.DataFixTypes;
import net.minecraft.world.PersistentState;
import net.minecraft.world.PersistentStateType;

public class PrixiverseStructuresState extends PersistentState {

    public static final Codec<PrixiverseStructuresState> CODEC = RecordCodecBuilder.create(instance -> instance.group(
            Codec.BOOL.fieldOf("generated").forGetter(PrixiverseStructuresState::isGenerated)
    ).apply(instance, PrixiverseStructuresState::new));

    public static final PersistentStateType<PrixiverseStructuresState> TYPE = new PersistentStateType<>(
            "prixiverse_structures", PrixiverseStructuresState::new, CODEC, DataFixTypes.LEVEL);

    private boolean generated;

    public PrixiverseStructuresState(boolean generated) {
        this.generated = generated;
    }

    public PrixiverseStructuresState() {
        this(false);
    }

    public boolean isGenerated() {
        return generated;
    }

    public void setGenerated(boolean generated) {
        this.generated = generated;
        markDirty();
    }
}