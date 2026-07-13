package net.napsternpt.prixilium.block.entity;

import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.napsternpt.prixilium.Prixilium;
import net.napsternpt.prixilium.block.ModBlocks;
import net.napsternpt.prixilium.block.entity.custom.ObeliskOfCharmsBlockEntity;
import net.napsternpt.prixilium.block.entity.custom.VirusReactorBlockEntity;

public class ModBlockEntities {
    public static final BlockEntityType<VirusReactorBlockEntity> VIRUS_REACTOR_BE =
            Registry.register(Registries.BLOCK_ENTITY_TYPE, Identifier.of(Prixilium.MOD_ID, "virus_reactor_be"),
                    FabricBlockEntityTypeBuilder.create(VirusReactorBlockEntity::new, ModBlocks.VIRUS_REACTOR).build());

    public static final BlockEntityType<ObeliskOfCharmsBlockEntity> OBELISK_OF_CHARMS_BE =
            Registry.register(Registries.BLOCK_ENTITY_TYPE, Identifier.of(Prixilium.MOD_ID, "obelisk_of_charms_be"),
                    FabricBlockEntityTypeBuilder.create(ObeliskOfCharmsBlockEntity::new, ModBlocks.OBELISK_OF_CHARMS).build());

    public static void registerBlockEntities() {
        Prixilium.LOGGER.info("Registering Prixilium Block Entities.");
    }
}
