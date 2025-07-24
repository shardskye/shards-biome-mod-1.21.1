package net.shardskye.shardsbiomemod.world.gen;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.gen.GenerationStep;
import net.shardskye.shardsbiomemod.world.ModPlacedFeatures;
import net.shardskye.shardsbiomemod.world.biome.ModBiomes;

public class ModVegetationGeneration {
    public static void generateTrees() {
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(ModBiomes.CHESTNUT_GROVE),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.CHESTNUT_PLACED_KEY);
    }

    //public static void generateBushes() {
        //BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.PLAINS),
                //GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.WILD_COTTON_PLACED_KEY);
    }
