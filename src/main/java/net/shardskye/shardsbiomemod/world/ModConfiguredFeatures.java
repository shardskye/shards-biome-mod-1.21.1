package net.shardskye.shardsbiomemod.world;

import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.LargeOakFoliagePlacer;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.trunk.LargeOakTrunkPlacer;
import net.shardskye.shardsbiomemod.ShardsBiomeMod;
import net.shardskye.shardsbiomemod.block.ModBlocks;

public class ModConfiguredFeatures {

    public static final RegistryKey<ConfiguredFeature<?, ?>> CHESTNUT_KEY = registerKey("chestnut");

    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context) {

        register(context, CHESTNUT_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(ModBlocks.CHESTNUT_LOG),
                new LargeOakTrunkPlacer(3, 11, 0),

                BlockStateProvider.of(ModBlocks.CHESTNUT_LEAVES),
                new LargeOakFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(4), 4),
                new TwoLayersFeatureSize(1, 1, 3))
                .ignoreVines().build());
    }

    public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, Identifier.of(ShardsBiomeMod.MOD_ID, name));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?, ?>> context,
                                                                                   RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
