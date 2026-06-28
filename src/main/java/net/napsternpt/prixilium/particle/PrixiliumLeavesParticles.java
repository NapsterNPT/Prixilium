package net.napsternpt.prixilium.particle;

import net.minecraft.client.particle.*;
import net.minecraft.client.texture.Sprite;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.particle.SimpleParticleType;
import net.minecraft.util.math.random.Random;
import org.jetbrains.annotations.Nullable;

public class PrixiliumLeavesParticles extends LeavesParticle {
    protected PrixiliumLeavesParticles(ClientWorld world, double x, double y, double z, Sprite sprite, float gravity, float f, boolean bl, boolean bl2, float size, float initialYVelocity) {
        super(world, x, y, z, sprite, gravity, f, bl, bl2, size, initialYVelocity);
        this.maxAge = 300;
    }

    public static class Factory implements ParticleFactory<SimpleParticleType> {
        private final SpriteProvider spriteProvider;

        public Factory(SpriteProvider spriteProvider) {
            this.spriteProvider = spriteProvider;
        }

        @Override
        public @Nullable Particle createParticle(SimpleParticleType parameters, ClientWorld world, double x, double y, double z, double velocityX, double velocityY, double velocityZ, Random random) {
            return new PrixiliumLeavesParticles(world, x, y, z, spriteProvider.getFirst(), 0.25F, 2.0F, false, true, 1.0F, 0.0F);
        }
    }
}
