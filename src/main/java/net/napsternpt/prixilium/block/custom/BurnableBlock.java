package net.napsternpt.prixilium.block.custom;

import net.minecraft.advancement.AdvancementEntry;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.napsternpt.prixilium.Prixilium;

import java.util.Objects;
import java.util.function.Supplier;

public class BurnableBlock {
    public static ActionResult convert(ItemStack stack, BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, Block output, Supplier<ActionResult> fallback) {
        if (stack.isOf(Items.FLINT_AND_STEEL)) {
            if (!world.isClient()) {
                world.setBlockState(pos, output.getStateWithProperties(state));
                stack.damage(1, player, hand);

                Vec3d center = Vec3d.ofCenter(pos);
                world.playSound(null, pos, SoundEvents.BLOCK_LAVA_EXTINGUISH, SoundCategory.BLOCKS);
                if (world instanceof ServerWorld serverWorld) {
                    serverWorld.spawnParticles(
                            ParticleTypes.SMOKE, center.x, center.y, center.z,
                            12, 0.3, 0.3, 0.3, 0.02
                    );
                    serverWorld.spawnParticles(ParticleTypes.LAVA,
                            center.x, center.y, center.z,
                            3, 0.2, 0.2, 0.2, 0.0);
                }
                if (player instanceof ServerPlayerEntity serverPlayer) {
                    AdvancementEntry advancement = Objects.requireNonNull(world.getServer()).getAdvancementLoader().get(Identifier.of(Prixilium.MOD_ID, "dark_mode"));
                    serverPlayer.getAdvancementTracker().grantCriterion(advancement, "dark_mode");
                }
            }
            return ActionResult.SUCCESS;
        }
        return fallback.get();
    }
}