package net.napsternpt.prixilium.entity.client;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.util.Identifier;
import net.napsternpt.prixilium.Prixilium;
import net.napsternpt.prixilium.entity.projectile.PrixiliumHookEntity;

public class PrixiliumHookRenderer extends EntityRenderer<PrixiliumHookEntity, PrixiliumHookRenderState> {
    
    private static final Identifier TEXTURE = Identifier.of(Prixilium.MOD_ID, "textures/entity/prixilium_hook.png");

    public PrixiliumHookRenderer(EntityRendererFactory.Context context) {
        super(context);
    }

    public Identifier getTexture(PrixiliumHookEntity entity) {
        return TEXTURE;
    }

    public PrixiliumHookRenderState createRenderState() {
        return new PrixiliumHookRenderState();
    }

    public void render(PrixiliumHookEntity entity, float yaw, float tickDelta, MatrixStack matrices, 
                      net.minecraft.client.render.VertexConsumerProvider vertexConsumers, int light) {
        if (!entity.getWorld().isClient()) return;
        
        net.minecraft.entity.player.PlayerEntity owner = entity.getPlayerOwner();
        if (owner == null) return;
        
        if (entity.inBlock()) {
            spawnBeamParticles(entity, owner, tickDelta);
        }
    }
    
    private void spawnBeamParticles(PrixiliumHookEntity entity, net.minecraft.entity.player.PlayerEntity owner, float tickDelta) {
        MinecraftClient client = MinecraftClient.getInstance();
        if (client.world == null) return;
        
        net.minecraft.util.math.Vec3d hookPos = entity.getPos();
        net.minecraft.util.math.Vec3d playerPos = owner.getEyePos();
        
        net.minecraft.util.math.Vec3d diff = playerPos.subtract(hookPos);
        double dist = diff.length();
        if (dist < 0.1) return;
        
        net.minecraft.util.math.Vec3d dir = diff.normalize();
        
        int particleCount = (int) (dist / 2.0);
        for (int i = 0; i < particleCount; i++) {
            double t = (double) i / particleCount;
            
            net.minecraft.util.math.Vec3d particlePos = hookPos.add(diff.multiply(t));
            
            particlePos = particlePos.add(
                (Math.random() - 0.5) * 0.2,
                (Math.random() - 0.5) * 0.2,
                (Math.random() - 0.5) * 0.2
            );
            
            client.world.addParticle(
                ParticleTypes.GLOW,
                particlePos.x, particlePos.y, particlePos.z,
                0.0, 0.0, 0.0
            );
        }
    }
}