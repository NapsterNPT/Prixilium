package net.napsternpt.prixilium.util;

import net.minecraft.block.DispenserBlock;
import net.minecraft.block.dispenser.ProjectileDispenserBehavior;
import net.napsternpt.prixilium.item.ModItems;

public class ModDispenserBehaviors {

    public static void register() {
        DispenserBlock.registerBehavior(ModItems.SHARD_STAR, new ProjectileDispenserBehavior(ModItems.SHARD_STAR));
    }
}