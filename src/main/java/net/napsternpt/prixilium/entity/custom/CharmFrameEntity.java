package net.napsternpt.prixilium.entity.custom;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.decoration.ItemFrameEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;
import net.napsternpt.prixilium.item.ModItems;
import net.napsternpt.prixilium.item.custom.CharmItem;
import net.napsternpt.prixilium.util.ModTags;

public class CharmFrameEntity extends ItemFrameEntity {

    public CharmFrameEntity(EntityType<? extends ItemFrameEntity> entityType, World world) {
        super(entityType, world);
    }

    public CharmFrameEntity(EntityType<? extends ItemFrameEntity> entityType, World world, BlockPos pos, Direction facing) {
        super(entityType, world, pos, facing);
    }

    @Override
    protected Box calculateBoundingBox(BlockPos pos, Direction facing) {
        return createFrameBox(pos, facing);
    }

    @Override
    protected Box calculatePopOffCheckBoundingBox() {
        return createFrameBox(this.getBlockPos(), this.getHorizontalFacing());
    }

    private static Box createFrameBox(BlockPos pos, Direction facing) {
        Vec3d center = Vec3d.ofCenter(pos).offset(facing, -0.46875);
        Direction.Axis axis = facing.getAxis();

        double x = axis == Direction.Axis.X ? 0.0625 : 0.875;
        double y = axis == Direction.Axis.Y ? 0.0625 : 0.875;
        double z = axis == Direction.Axis.Z ? 0.0625 : 0.875;

        return Box.of(center, x, y, z);
    }

    @Override
    public boolean canStayAttached() {
        return !this.shouldPopOff(this.calculatePopOffCheckBoundingBox()) && this.hasNoIntersectingDecoration(false);
    }

    @Override
    protected ItemStack getAsItemStack() {
        return new ItemStack(ModItems.CHARM_FRAME);
    }

    @Override
    public void setHeldItemStack(ItemStack stack, boolean update) {
        if (!stack.isEmpty() && !isCharm(stack)) {
            return;
        }
        super.setHeldItemStack(stack, update);
    }

    private static boolean isCharm(ItemStack stack) {
        return stack.isIn(ModTags.Items.CHARMS) || stack.getItem() instanceof CharmItem;
    }

    @Override
    public ActionResult interact(PlayerEntity player, Hand hand) {
        ItemStack handStack = player.getStackInHand(hand);
        ItemStack heldStack = this.getHeldItemStack();

        if (!heldStack.isEmpty()) {
            if (this.getEntityWorld().isClient()) {
                return ActionResult.SUCCESS;
            }
            this.playSound(this.getRotateItemSound(), 1.0F, 1.0F);
            this.setRotation(this.getRotation() + 1);
            this.emitGameEvent(GameEvent.BLOCK_CHANGE, player);
            return ActionResult.SUCCESS;
        }

        if (handStack.isEmpty() || !isCharm(handStack)) {
            return ActionResult.PASS;
        }

        if (this.getEntityWorld().isClient()) {
            return ActionResult.SUCCESS;
        }

        this.setHeldItemStack(handStack);
        handStack.decrementUnlessCreative(1, player);
        this.emitGameEvent(GameEvent.BLOCK_CHANGE, player);
        return ActionResult.SUCCESS;
    }
}
