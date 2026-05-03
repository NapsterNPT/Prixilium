package net.napsternpt.prixilium.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import net.napsternpt.prixilium.particle.ModParticles;

public class PrixiliumExhaustBlock extends Block {
    public PrixiliumExhaustBlock(Settings settings) {super(settings);}

    public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {
        if (random.nextInt(5) == 0 && world.getBlockState(pos.up()).isAir() && !world.isReceivingRedstonePower(pos)) {
            for (int i = 0; i < 100; i++) {
                double x = pos.getX() + 0.5;
                double y = pos.getY() + 1;
                double z = pos.getZ() + 0.5;

                double vS = -0.75 + random.nextDouble() * 1.5;
                double vY = random.nextDouble() * 100;

                world.addParticleClient(ModParticles.PRIXILIUM_SMOKE, x, y, z, vS, vY, vS);
            }
        }
    }
}
