package net.napsternpt.prixilium.item.custom;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.RaycastContext;
import net.minecraft.world.World;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class PrixiliumHookItem extends Item {
    private static final double MAX_DISTANCE = 50.0;
    private static final double PULL_FORCE = 0.15;
    private static final double MIN_DISTANCE = 1.5;

    private static final Map<UUID, GrappleData> activeGrapples = new HashMap<>();

    public PrixiliumHookItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
        ItemStack stack = player.getStackInHand(hand);
        UUID playerId = player.getUuid();

        if (!world.isClient) {
            if (activeGrapples.containsKey(playerId)) {
                activeGrapples.remove(playerId);
                world.playSound(null, player.getX(), player.getY(), player.getZ(),
                        SoundEvents.ITEM_CROSSBOW_LOADING_END,
                        SoundCategory.PLAYERS, 0.5f, 1.2f);
                return TypedActionResult.success(stack, false);
            }

            Vec3d start = player.getEyePos();
            Vec3d direction = player.getRotationVector();
            Vec3d end = start.add(direction.multiply(MAX_DISTANCE));

            BlockHitResult hitResult = world.raycast(new RaycastContext(
                    start,
                    end,
                    RaycastContext.ShapeType.OUTLINE,
                    RaycastContext.FluidHandling.NONE,
                    player
            ));

            if (hitResult.getType() == HitResult.Type.BLOCK) {
                Vec3d targetPos = hitResult.getPos();
                activeGrapples.put(playerId, new GrappleData(targetPos, world.getTime()));

                world.playSound(null, player.getX(), player.getY(), player.getZ(),
                        SoundEvents.ITEM_CROSSBOW_SHOOT,
                        SoundCategory.PLAYERS, 1.0f, 1.2f);

                if (player instanceof ServerPlayerEntity serverPlayer) {
                    stack.damage(1, serverPlayer,
                            hand == Hand.MAIN_HAND
                                    ? net.minecraft.entity.EquipmentSlot.MAINHAND
                                    : net.minecraft.entity.EquipmentSlot.OFFHAND);
                }
            } else {
                world.playSound(null, player.getX(), player.getY(), player.getZ(),
                        SoundEvents.BLOCK_LEVER_CLICK,
                        SoundCategory.PLAYERS, 0.5f, 0.8f);
            }
        }

        return TypedActionResult.success(stack, world.isClient());
    }

    public static void tickGrapples(World world) {
        if (world.isClient) return;

        activeGrapples.entrySet().removeIf(entry -> {
            UUID playerId = entry.getKey();
            GrappleData data = entry.getValue();

            PlayerEntity player = world.getPlayerByUuid(playerId);
            if (player == null || !player.isAlive()) {
                return true;
            }

            Vec3d playerPos = player.getPos().add(0, player.getHeight() / 2, 0);
            Vec3d targetPos = data.targetPos;
            double distance = playerPos.distanceTo(targetPos);

            if (distance < MIN_DISTANCE) {
                player.setVelocity(player.getVelocity().multiply(0.5, 0.5, 0.5));
                player.velocityModified = true;
                return true;
            }

            Vec3d direction = targetPos.subtract(playerPos).normalize();
            double forceFactor = Math.min(distance / 10.0, 2.0);
            Vec3d pullForce = direction.multiply(PULL_FORCE * forceFactor);

            Vec3d currentVelocity = player.getVelocity();
            Vec3d newVelocity = currentVelocity.add(pullForce);

            double maxSpeed = 2.0;
            if (newVelocity.length() > maxSpeed) {
                newVelocity = newVelocity.normalize().multiply(maxSpeed);
            }

            player.setVelocity(newVelocity);
            player.velocityModified = true;
            player.fallDistance = 0;

            return world.getTime() - data.startTime > 200;
        });
    }

    private record GrappleData(Vec3d targetPos, long startTime) {
    }
}