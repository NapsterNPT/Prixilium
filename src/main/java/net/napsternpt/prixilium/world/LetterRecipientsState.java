package net.napsternpt.prixilium.world;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.datafixer.DataFixTypes;
import net.minecraft.util.Uuids;
import net.minecraft.world.PersistentState;
import net.minecraft.world.PersistentStateType;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class LetterRecipientsState extends PersistentState {

    public static final Codec<LetterRecipientsState> CODEC = RecordCodecBuilder.create(instance -> instance.group(
            Uuids.LINKED_SET_CODEC.fieldOf("received").forGetter(LetterRecipientsState::getReceived)
    ).apply(instance, LetterRecipientsState::new));

    public static final PersistentStateType<LetterRecipientsState> TYPE = new PersistentStateType<>("letter_recipients", LetterRecipientsState::new, CODEC, DataFixTypes.LEVEL);

    private final Set<UUID> received;

    public LetterRecipientsState(Set<UUID> received) {
        this.received = new HashSet<>(received);
    }

    public LetterRecipientsState() {
        this(Set.of());
    }

    public Set<UUID> getReceived() {
        return received;
    }

    public boolean hasReceived(UUID playerUuid) {
        return received.contains(playerUuid);
    }

    public void markReceived(UUID playerUuid) {
        if (received.add(playerUuid)) {
            markDirty();
        }
    }
}
