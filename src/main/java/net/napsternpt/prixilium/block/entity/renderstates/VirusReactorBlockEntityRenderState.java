package net.napsternpt.prixilium.block.entity.renderstates;

import net.minecraft.client.render.block.entity.state.BlockEntityRenderState;
import net.minecraft.client.render.item.ItemRenderState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class VirusReactorBlockEntityRenderState extends BlockEntityRenderState {
    public boolean isActive;

    public BlockPos lightPosition;
    public World blockEntityWorld;
    public float rotation;

    public final ItemRenderState itemRenderState = new ItemRenderState();
}
