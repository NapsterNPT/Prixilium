package net.napsternpt.prixilium.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricDynamicRegistryProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.entry.RegistryEntryList;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.world.attribute.EnvironmentAttributeMap;
import net.minecraft.world.dimension.DimensionType;
import org.jspecify.annotations.NonNull;

import java.util.concurrent.CompletableFuture;

public class ModDimensionTypeProvider extends FabricDynamicRegistryProvider {

    public ModDimensionTypeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> lookup) {
        super(output, lookup);
    }

    @Override
    protected void configure(RegistryWrapper.@NonNull WrapperLookup lookup, Entries entries) {
        entries.add(ModWorldGen.PRIXILIUM_DIMENSION_TYPE, new DimensionType(
                true, false, true, 1.0, 0, 256, 256,
                BlockTags.INFINIBURN_END, 0.1f,
                new DimensionType.MonsterSettings(UniformIntProvider.create(0, 7), 0),
                DimensionType.Skybox.NONE,
                DimensionType.CardinalLightType.DEFAULT,
                EnvironmentAttributeMap.builder().build(),
                RegistryEntryList.empty()
        ));
    }

    @Override
    public String getName() {
        return "Prixilium Dimension Types";
    }
}