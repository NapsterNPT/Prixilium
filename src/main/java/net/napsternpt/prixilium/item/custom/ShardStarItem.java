package net.napsternpt.prixilium.item.custom;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.item.BowItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ProjectileItem;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Position;
import net.minecraft.world.World;
import net.napsternpt.prixilium.entity.projectile.ShardStarEntity;

public class ShardStarItem extends BowItem implements ProjectileItem {
    public ShardStarItem(Item.Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult use(World world, PlayerEntity user, Hand hand) {
        user.setCurrentHand(hand);
        return ActionResult.CONSUME;
    }

    @Override
    public boolean onStoppedUsing(ItemStack stack, World world, LivingEntity user, int remainingUseTicks) {
        if (world.isClient() || !(user instanceof PlayerEntity player)) return false;

        int useTicks = this.getMaxUseTime(stack, user) - remainingUseTicks;
        float power = BowItem.getPullProgress(useTicks);
        if (power < 0.1F) return false;

        ShardStarEntity shard = new ShardStarEntity(world, player, power);
        world.spawnEntity(shard);

        world.playSound(null, player.getX(), player.getY(), player.getZ(), SoundEvents.ITEM_TRIDENT_THROW, SoundCategory.PLAYERS, 1.0F, 0.8F + power * 0.2F);

        if (!player.isCreative()) {
            stack.decrement(1);
        }
        return true;
    }

    @Override
    public ProjectileEntity createEntity(World world, Position position, ItemStack stack, Direction direction) {
        return new ShardStarEntity(world, position.getX(), position.getY(), position.getZ(), stack.copyWithCount(1), null);
    }
}
