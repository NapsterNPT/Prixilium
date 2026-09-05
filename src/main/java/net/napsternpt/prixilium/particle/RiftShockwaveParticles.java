package net.napsternpt.prixilium.particle;

import net.minecraft.client.particle.BillboardParticle;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleFactory;
import net.minecraft.client.particle.SpriteProvider;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.particle.SimpleParticleType;
import net.minecraft.util.math.random.Random;
import org.jetbrains.annotations.Nullable;

public class RiftShockwaveParticles extends BillboardParticle {
    private final SpriteProvider spriteProvider;
    private final float baseScale;

    public RiftShockwaveParticles(ClientWorld clientWorld, double x, double y, double z, SpriteProvider spriteProvider, double xSpeed, double ySpeed, double zSpeed) {
        super(clientWorld, x, y, z, xSpeed, ySpeed, zSpeed, spriteProvider.getFirst());

        this.maxAge = 40;
        float g = 0.45F + random.nextFloat() * 0.15F;
        this.baseScale = g;
        this.scale = g;
        this.setBoundingBoxSpacing(g, g);
        this.spriteProvider = spriteProvider;
        this.collidesWithWorld = false;
    }

    @Override
    public void tick() {
        super.tick();
        float progress = (float) this.age / (float) this.maxAge;
        this.setSprite(this.spriteProvider.getSprite(this.age, this.maxAge));
        this.scale = this.baseScale * (1.0F + progress * 12.0F);
        this.alpha = (float) Math.pow(1.0f - progress, 0.7);
        this.velocityX *= 1.0;
        this.velocityZ *= 1.0;
        this.velocityY *= 0.0;
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
            return new RiftShockwaveParticles(world, x, y, z, spriteProvider, velocityX, velocityY, velocityZ);
        }
    }
}
