package net.napsternpt.prixilium.particle;

import net.minecraft.client.particle.*;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.particle.SimpleParticleType;
import net.minecraft.util.math.random.Random;
import org.jetbrains.annotations.Nullable;

public class PrixiliumAmbientParticles extends BillboardParticle {
    public PrixiliumAmbientParticles(ClientWorld clientWorld, double x, double y, double z, SpriteProvider spriteProvider, double xSpeed, double ySpeed, double zSpeed) {
        super(clientWorld, x, y, z, xSpeed, ySpeed, zSpeed, spriteProvider.getFirst());

        this.maxAge = 100;
    }

    @Override
    public void tick() {
        super.tick();
        this.alpha = (float) Math.pow(1.0f - ((float) this.age / (float) this.maxAge), 0.1);
    }

    @Override
    protected RenderType getRenderType() {
        return RenderType.PARTICLE_ATLAS_TRANSLUCENT;
    }

    public static class Factory implements ParticleFactory<SimpleParticleType> {
        private final SpriteProvider spriteProvider;

        public Factory(SpriteProvider spriteProvider) {
            this.spriteProvider = spriteProvider;
        }

        @Override
        public @Nullable Particle createParticle(SimpleParticleType parameters, ClientWorld world, double x, double y, double z, double velocityX, double velocityY, double velocityZ, Random random) {
            return new PrixiliumAmbientParticles(world, x, y, z, spriteProvider, velocityX, velocityY, velocityZ);
        }
    }
}
