package net.napsternpt.prixilium.entity.client;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.particle.ParticleTypes;
import net.napsternpt.prixilium.entity.projectile.PrixiliumHookEntity;

public class PrixiliumHookRenderer extends EntityRenderer<PrixiliumHookEntity, PrixiliumHookRenderState> {

    public PrixiliumHookRenderer(EntityRendererFactory.Context context) {
        super(context);
    }

    public PrixiliumHookRenderState createRenderState() {
        return new PrixiliumHookRenderState();
    }

    public void render(PrixiliumHookEntity entity, float yaw, float tickDelta, MatrixStack matrices, 
                      net.minecraft.client.render.VertexConsumerProvider vertexConsumers, int light) {
        if (!entity.getWorld().isClient()) return;
        
        net.minecraft.entity.player.PlayerEntity owner = entity.getPlayerOwner();
        if (owner == null) return;
        
        spawnBeamParticles(entity, owner, tickDelta);
    }
    
    private void spawnBeamParticles(PrixiliumHookEntity entity, PlayerEntity owner, float tickDelta) {
        MinecraftClient client = MinecraftClient.getInstance();
        if (client.world == null) return;
        
        net.minecraft.util.math.Vec3d hookPos = entity.getPos();
        net.minecraft.util.math.Vec3d playerPos = owner.getEyePos();
        
        net.minecraft.util.math.Vec3d diff = playerPos.subtract(hookPos);
        double dist = diff.length();
        if (dist < 0.5) return;
        
        int particleCount = (int) (dist / 3.0);
        particleCount = Math.clamp(particleCount, 3, 15);
        
        net.minecraft.world.World world = client.world;
        
        for (int i = 0; i < particleCount; i++) {
            double t = (double) i / (particleCount - 1);
            
            double x = hookPos.x + diff.x * t;
            double y = hookPos.y + diff.y * t;
            double z = hookPos.z + diff.z * t;
            
            x += (Math.random() - 0.5) * 0.2;
            y += (Math.random() - 0.5) * 0.2;
            z += (Math.random() - 0.5) * 0.2;
            
            world.addParticleClient(ParticleTypes.WAX_ON, x, y, z, 0.0, 0.0, 0.0);
        }
    }
}