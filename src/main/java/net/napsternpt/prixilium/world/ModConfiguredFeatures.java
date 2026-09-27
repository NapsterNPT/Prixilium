package net.napsternpt.prixilium.world;

import net.minecraft.block.BlockState;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.util.collection.WeightedPool;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.feature.SimpleBlockFeatureConfig;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.LargeOakFoliagePlacer;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.stateprovider.WeightedBlockStateProvider;
import net.minecraft.world.gen.trunk.StraightTrunkPlacer;
import net.napsternpt.prixilium.Prixilium;
import net.napsternpt.prixilium.block.ModBlocks;

public class ModConfiguredFeatures {
    public static RegistryKey<ConfiguredFeature<?, ?>> PRIXILIUM_KEY = registerKey("prixilium_key");
    public static RegistryKey<ConfiguredFeature<?, ?>> PRIXILIUM_PERL = registerKey("prixilium_perl");
    public static RegistryKey<ConfiguredFeature<?, ?>> PRIXILIUM_SAPLING = registerKey("prixilium_sapling");

    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context) {
        register(context, PRIXILIUM_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(ModBlocks.PRIXILIUM_LOG),
                new StraightTrunkPlacer(5, 3, 0),
                BlockStateProvider.of(ModBlocks.PRIXILIUM_LEAVES),
                new LargeOakFoliagePlacer(
                        ConstantIntProvider.create(2),
                        ConstantIntProvider.create(1),
                        4),
                new TwoLayersFeatureSize(1, 0, 2))
                .ignoreVines()
                .build()
        );

        register(context, PRIXILIUM_PERL, Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(
                new WeightedBlockStateProvider(
                        WeightedPool.<BlockState>builder()
                                .add(ModBlocks.OPEN_PRIXILIUM_PERL.getDefaultState(), 1)
                                .add(ModBlocks.CLOSED_PRIXILIUM_PERL.getDefaultState(), 1)
                                .build()
                )
        ));

        register(context, PRIXILIUM_SAPLING, Feature.SIMPLE_BLOCK,
                new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.PRIXILIUM))
        );
    }

    public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, Identifier.of(Prixilium.MOD_ID, name));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?, ?>> context,
                                                                                   RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
