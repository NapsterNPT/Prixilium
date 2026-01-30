package net.napsternpt.prixilium.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.world.World;
import net.napsternpt.prixilium.Prixilium;

public class PrixiliumHookItem extends Item {

    public PrixiliumHookItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        Block clickedBlock = world.getBlockState(context.getBlockPos()).getBlock();

        if (clickedBlock != Blocks.AIR) {
            if (!world.isClient()){
                Prixilium.LOGGER.info("A block got clicked, it is: " + clickedBlock.toString());

                context.getStack().damage(1, ((ServerWorld) world), ((ServerPlayerEntity) context.getPlayer()),
                        item -> context.getPlayer().sendEquipmentBreakStatus(item, EquipmentSlot.MAINHAND));

                world.playSound(null, context.getBlockPos(), SoundEvents.BLOCK_CAMPFIRE_CRACKLE, SoundCategory.NEUTRAL);
            }
        }

        return ActionResult.SUCCESS;
    }
}
