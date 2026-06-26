package net.napsternpt.prixilium.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricDynamicRegistryProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.dimension.DimensionTypes;

import java.util.Optional;
import java.util.OptionalLong;
import java.util.concurrent.CompletableFuture;

public class ModDimensionTypeProvider extends FabricDynamicRegistryProvider {

    public ModDimensionTypeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> lookup) {
        super(output, lookup);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup lookup, Entries entries) {
        entries.add(ModWorldGen.PRIXILIUM_DIMENSION_TYPE, new DimensionType(
                OptionalLong.of(18000L), false, true, false, false,
                1.0, false, false, 0, 256, 256,
                BlockTags.INFINIBURN_END, DimensionTypes.THE_END_ID, 0.1f,
                Optional.empty(),
                new DimensionType.MonsterSettings(false, false, UniformIntProvider.create(0, 7), 0)
        ));
    }

    @Override
    public String getName() {
        return "Prixilium Dimension Types";
    }
}