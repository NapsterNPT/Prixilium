package net.napsternpt.prixilium.item.custom.charm;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.napsternpt.prixilium.item.custom.CharmItem;

import java.util.List;

public class SonicBoomCharmItem extends CharmItem {
    private final float damage;

    public SonicBoomCharmItem(float damage, CharmSettings settings) {
        super(settings);
        this.damage = damage;
    }

    @Override
    public ActionResult use(World world, PlayerEntity player, Hand hand) {
        ItemStack stack = player.getStackInHand(hand);
        if (!world.isClient) {
            ServerWorld serverWorld = (ServerWorld) world;

            Vec3d start = player.getEyePos();
            Vec3d direction = player.getRotationVec(1.0F);
            double range = 30.0;
            Vec3d end = start.add(direction.multiply(range));

            for (double i = 0; i < range; i += 1.0) {
                Vec3d pos = start.add(direction.multiply(i));
                serverWorld.spawnParticles(ParticleTypes.SONIC_BOOM, pos.x, pos.y, pos.z, 1, 0, 0, 0, 0);
            }

            Box box = new Box(start, end).expand(3.0);
            List<LivingEntity> targets = serverWorld.getEntitiesByClass(LivingEntity.class, box,
                    entity -> entity != player && entity.isAlive());

            for (LivingEntity target : targets) {
                Vec3d toTarget = target.getPos().subtract(start);
                double projection = toTarget.dotProduct(direction);
                if (projection < 0) continue;
                Vec3d closest = start.add(direction.multiply(projection));
                if (target.getPos().distanceTo(closest) > 2.5) continue;

                target.damage(serverWorld, serverWorld.getDamageSources().sonicBoom(player), damage);
                Vec3d knockback = direction.multiply(2.5);
                target.setVelocity(target.getVelocity().add(knockback));
                target.velocityModified = true;
            }

            serverWorld.playSound(null, player.getX(), player.getY(), player.getZ(),
                    SoundEvents.ENTITY_WARDEN_SONIC_BOOM, SoundCategory.PLAYERS, 3.0F, 1.0F);

            player.getItemCooldownManager().set(stack, 100);

            if (!player.isInCreativeMode()) {
                EquipmentSlot slot = hand == Hand.MAIN_HAND ? EquipmentSlot.MAINHAND : EquipmentSlot.OFFHAND;
                stack.damage(1, player, slot);
            }
        }
        return ActionResult.SUCCESS;
    }
}
