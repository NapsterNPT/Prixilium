package net.napsternpt.prixilium.item.custom;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.napsternpt.prixilium.entity.custom.RiftCoreEntity;
import net.napsternpt.prixilium.sound.ModSounds;

import java.util.List;

public class RiftsPawItem extends Item {
    private static final double SHOCKWAVE_RADIUS = 10.0;

    public RiftsPawItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult use(World world, PlayerEntity player, Hand hand) {
        ItemStack mainHand = player.getMainHandStack();
        ItemStack offHand = player.getOffHandStack();

        if (!(mainHand.getItem() instanceof RiftsPawItem) || !(offHand.getItem() instanceof RiftsPawItem)) {
            return ActionResult.PASS;
        }

        if (!world.isClient()) {
            ServerWorld serverWorld = (ServerWorld) world;
            Vec3d pos = player.getEntityPos();
            double y = pos.getY() + 0.2;
            int count = 48;
            for (int i = 0; i < count; i++) {
                double angle = (2.0 * Math.PI * i) / count;
                serverWorld.spawnParticles(ParticleTypes.ELECTRIC_SPARK,
                        pos.getX() + Math.cos(angle) * SHOCKWAVE_RADIUS, y,
                        pos.getZ() + Math.sin(angle) * SHOCKWAVE_RADIUS,
                        1, 0.0, 0.0, 0.0, 0.0);
            }
            Box box = new Box(pos, pos).expand(SHOCKWAVE_RADIUS);
            List<RiftCoreEntity> cores = serverWorld.getEntitiesByClass(RiftCoreEntity.class, box, LivingEntity::isAlive);

            for (RiftCoreEntity core : cores) {
                core.setStunned(true);
            }

            serverWorld.playSound(null, pos.x, pos.y, pos.z,
                    ModSounds.RIFT_SLAM, SoundCategory.PLAYERS, 1.0F, 1.0F);
        }

        return ActionResult.SUCCESS;
    }
}
