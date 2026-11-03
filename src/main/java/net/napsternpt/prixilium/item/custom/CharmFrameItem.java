package net.napsternpt.prixilium.item.custom;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemFrameItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;
import net.napsternpt.prixilium.entity.ModEntities;
import net.napsternpt.prixilium.entity.custom.CharmFrameEntity;

public class CharmFrameItem extends ItemFrameItem {
    public CharmFrameItem(Settings settings) {
        super(ModEntities.CHARM_FRAME, settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        BlockPos clickedPos = context.getBlockPos();
        Direction side = context.getSide();
        BlockPos pos = clickedPos.offset(side);
        PlayerEntity player = context.getPlayer();
        World world = context.getWorld();
        ItemStack stack = context.getStack();

        if (player == null || !this.canPlaceOn(player, side, stack, pos)) {
            return ActionResult.FAIL;
        }

        CharmFrameEntity frame = new CharmFrameEntity(ModEntities.CHARM_FRAME, world, pos, side);
        EntityType.copier(world, stack, player).accept(frame);

        if (!frame.canStayAttached()) {
            return ActionResult.CONSUME;
        }

        if (!world.isClient()) {
            frame.onPlace();
            world.emitGameEvent(player, GameEvent.ENTITY_PLACE, frame.getEntityPos());
            world.spawnEntity(frame);
        }

        stack.decrement(1);
        return ActionResult.SUCCESS;
    }
}
