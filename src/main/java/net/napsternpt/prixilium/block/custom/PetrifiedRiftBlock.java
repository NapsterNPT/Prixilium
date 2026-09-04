package net.napsternpt.prixilium.block.custom;

import net.minecraft.block.Block;
import net.minecraft.state.property.BooleanProperty;

public class PetrifiedRiftBlock extends Block {
    public static final BooleanProperty SPAWNED = BooleanProperty.of("spawned");

    public PetrifiedRiftBlock(Settings settings) {
        super(settings);
    }
}
