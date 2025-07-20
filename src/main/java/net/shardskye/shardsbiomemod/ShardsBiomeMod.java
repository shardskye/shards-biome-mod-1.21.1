package net.shardskye.shardsbiomemod;

import net.fabricmc.api.ModInitializer;

import net.shardskye.shardsbiomemod.block.ModBlocks;
import net.shardskye.shardsbiomemod.item.ModItemGroups;
import net.shardskye.shardsbiomemod.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ShardsBiomeMod implements ModInitializer {
	public static final String MOD_ID = "shardsbiomemod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItemGroups.registerItemGroups();

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
	}
}