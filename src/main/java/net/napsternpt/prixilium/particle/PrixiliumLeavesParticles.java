package net.napsternpt.prixilium.particle;

import net.minecraft.client.particle.*;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.particle.SimpleParticleType;
import org.jetbrains.annotations.Nullable;

public class PrixiliumLeavesParticles extends SpriteBillboardParticle {
    private float angularVelocity;
    private final float angularAcceleration;
    private final float field_55127;
    private final boolean field_55128;
    private final boolean field_55129;
    private final double field_55130;
    private final double field_55131;
    private final double field_55132;

    public PrixiliumLeavesParticles(ClientWorld world, double x, double y, double z, SpriteProvider spriteProvider, float gravity, float f, boolean bl, boolean bl2, float size, float initialYVelocity) {
        super(world, x, y, z);
        this.setSprite(spriteProvider.getSprite(this.random.nextInt(12), 12));
        this.angularVelocity = (float)Math.toRadians(this.random.nextBoolean() ? (double)-30.0F : (double)30.0F);
        float field_43370 = this.random.nextFloat();
        this.angularAcceleration = (float)Math.toRadians(this.random.nextBoolean() ? (double)-5.0F : (double)5.0F);
        this.field_55127 = f;
        this.field_55128 = bl;
        this.field_55129 = bl2;
        this.maxAge = 300;
        this.gravityStrength = gravity * 1.2F * 0.0025F;
        float g = size * (this.random.nextBoolean() ? 0.05F : 0.075F);
        this.scale = g;
        this.setBoundingBoxSpacing(g, g);
        this.velocityMultiplier = 1.0F;
        this.velocityY = -initialYVelocity;
        this.field_55130 = Math.cos(Math.toRadians(field_43370 * 60.0F)) * (double)this.field_55127;
        this.field_55131 = Math.sin(Math.toRadians(field_43370 * 60.0F)) * (double)this.field_55127;
        this.field_55132 = Math.toRadians(1000.0F + field_43370 * 3000.0F);
    }

    @Override
    public ParticleTextureSheet getType() {
        return ParticleTextureSheet.PARTICLE_SHEET_TRANSLUCENT;
    }

    public void tick() {
        this.lastX = this.x;
        this.lastY = this.y;
        this.lastZ = this.z;
        if (this.maxAge-- <= 0) {
            this.markDead();
        }

        if (!this.dead) {
            float f = (float)(300 - this.maxAge);
            float g = Math.min(f / 300.0F, 1.0F);
            double d = 0.0F;
            double e = 0.0F;
            if (this.field_55129) {
                d += this.field_55130 * Math.pow(g, 1.25F);
                e += this.field_55131 * Math.pow(g, 1.25F);
            }

            if (this.field_55128) {
                d += (double)g * Math.cos((double)g * this.field_55132) * (double)this.field_55127;
                e += (double)g * Math.sin((double)g * this.field_55132) * (double)this.field_55127;
            }

            this.velocityX += d * (double)0.0025F;
            this.velocityZ += e * (double)0.0025F;
            this.velocityY -= this.gravityStrength;
            this.angularVelocity += this.angularAcceleration / 20.0F;
            this.lastAngle = this.angle;
            this.angle += this.angularVelocity / 20.0F;
            this.move(this.velocityX, this.velocityY, this.velocityZ);
            if (this.onGround || this.maxAge < 299 && (this.velocityX == (double)0.0F || this.velocityZ == (double)0.0F)) {
                this.markDead();
            }

            if (!this.dead) {
                this.velocityX *= this.velocityMultiplier;
                this.velocityY *= this.velocityMultiplier;
                this.velocityZ *= this.velocityMultiplier;
            }
        }
    }

    public static class Factory implements ParticleFactory<SimpleParticleType> {
        private final SpriteProvider spriteProvider;

        public Factory(SpriteProvider spriteProvider) {
            this.spriteProvider = spriteProvider;
        }

        @Override
        public @Nullable Particle createParticle(SimpleParticleType simpleParticleType, ClientWorld clientWorld, double d, double e, double f, double g, double h, double i) {
            return new PrixiliumLeavesParticles(clientWorld, d, e, f, this.spriteProvider, 0.25F, 2.0F, false, true, 1.0F, 0.0F);
        }
    }
}
