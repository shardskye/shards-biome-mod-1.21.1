package net.shardskye.shardsbiomemod.world.biome;

import net.shardskye.shardsbiomemod.ShardsBiomeMod;
import net.shardskye.shardsbiomemod.world.biome.overworld.ModMaterialRules;
import terrablender.api.Regions;
import terrablender.api.SurfaceRuleManager;
import terrablender.api.TerraBlenderApi;
import net.minecraft.util.Identifier;

public class ModTerrablenderAPI implements TerraBlenderApi {

    @Override
    public void onTerraBlenderInitialized() {
        Regions.register(new ModOverworldRegion(Identifier.of(ShardsBiomeMod.MOD_ID, "overworld"), 4));

        SurfaceRuleManager.addSurfaceRules(SurfaceRuleManager.RuleCategory.OVERWORLD, ShardsBiomeMod.MOD_ID, ModMaterialRules.makeRules());
    }
}
