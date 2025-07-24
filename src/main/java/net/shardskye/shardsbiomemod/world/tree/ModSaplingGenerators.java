package net.shardskye.shardsbiomemod.world.tree;

import net.minecraft.block.SaplingGenerator;
import net.shardskye.shardsbiomemod.ShardsBiomeMod;
import net.shardskye.shardsbiomemod.world.ModConfiguredFeatures;

import java.util.Optional;

public class ModSaplingGenerators {
    public static final SaplingGenerator CHESTNUT = new SaplingGenerator(ShardsBiomeMod.MOD_ID + ":chestnut",
            Optional.empty(), Optional.of(ModConfiguredFeatures.CHESTNUT_KEY), Optional.empty());
}
