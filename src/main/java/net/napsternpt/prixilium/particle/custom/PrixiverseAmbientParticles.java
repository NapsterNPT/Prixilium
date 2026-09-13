package net.napsternpt.prixilium.particle.custom;

import net.minecraft.client.particle.BillboardParticle;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleFactory;
import net.minecraft.client.particle.SpriteProvider;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.particle.SimpleParticleType;
import net.minecraft.util.math.random.Random;
import org.jspecify.annotations.Nullable;

public class PrixiverseAmbientParticles extends BillboardParticle {
    private final SpriteProvider spriteProvider;

    public PrixiverseAmbientParticles(ClientWorld clientWorld, double x, double y, double z, SpriteProvider spriteProvider, double xSpeed, double ySpeed, double zSpeed) {
        super(clientWorld, x, y, z, xSpeed, ySpeed, zSpeed, spriteProvider.getFirst());

        this.spriteProvider = spriteProvider;
        this.maxAge = 100;
        this.gravityStrength = 0.0F;
    }

    @Override
    public void tick() {
        super.tick();
        this.setSprite(this.spriteProvider.getSprite(this.age, this.maxAge));
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
            return new PrixiverseAmbientParticles(world, x, y, z, spriteProvider, velocityX, velocityY, velocityZ);
        }
    }
}
