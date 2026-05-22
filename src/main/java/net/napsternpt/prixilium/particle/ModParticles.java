package net.napsternpt.prixilium.particle;

import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.particle.SimpleParticleType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.napsternpt.prixilium.Prixilium;

public class ModParticles {
    public static final SimpleParticleType PRIXILIUM_AMBIENT = registerParticle("prixilium_ambient", FabricParticleTypes.simple());
    public static final SimpleParticleType PRIXILIUM_LEAVES = registerParticle("prixilium_leaves", FabricParticleTypes.simple());
    public static final SimpleParticleType PRIXILIUM_HOOK = registerParticle("prixilium_hook", FabricParticleTypes.simple());
    public static final SimpleParticleType PRIXILIUM_SMOKE = registerParticle("prixilium_smoke", FabricParticleTypes.simple());
    public static final SimpleParticleType PRIXILIUM_EXPAND = registerParticle("prixilium_expand", FabricParticleTypes.simple());

    private static SimpleParticleType registerParticle(String name, SimpleParticleType particleType) {
        return Registry.register(Registries.PARTICLE_TYPE, Identifier.of(Prixilium.MOD_ID, name), particleType);
    }

    public static void registerParticles() {Prixilium.LOGGER.info("Registering Prixilium Particles.");}
}
