package net.shardskye.shardsbiomemod;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.registry.CompostingChanceRegistry;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import net.shardskye.shardsbiomemod.block.ModBlocks;
import net.shardskye.shardsbiomemod.item.ModItemGroups;
import net.shardskye.shardsbiomemod.item.ModItems;
import net.shardskye.shardsbiomemod.world.gen.ModWorldGeneration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import terrablender.api.TerraBlenderApi;

public class ShardsBiomeMod implements ModInitializer, TerraBlenderApi
{
	public static final String MOD_ID = "shardsbiomemod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItemGroups.registerItemGroups();

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();

		ModWorldGeneration.generateModWorldGen();

		StrippableBlockRegistry.register(ModBlocks.CHESTNUT_LOG, ModBlocks.STRIPPED_CHESTNUT_LOG);
		StrippableBlockRegistry.register(ModBlocks.CHESTNUT_WOOD, ModBlocks.STRIPPED_CHESTNUT_WOOD);

		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.CHESTNUT_LOG, 5, 5);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.CHESTNUT_WOOD, 5, 5);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.STRIPPED_CHESTNUT_LOG, 5, 5);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.STRIPPED_CHESTNUT_WOOD, 5, 20);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.CHESTNUT_LEAVES, 30, 60);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.CHESTNUT_STAIRS, 5, 5);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.CHESTNUT_SLAB, 5, 5);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.CHESTNUT_DOOR, 5, 5);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.CHESTNUT_TRAPDOOR, 5, 5);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.CHESTNUT_PRESSURE_PLATE, 5, 5);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.CHESTNUT_BUTTON, 5, 5);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.CHESTNUT_FENCE, 5, 5);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.CHESTNUT_FENCE_GATE, 5, 5);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.CHESTNUT_SAPLING, 5, 5);

		CompostingChanceRegistry.INSTANCE.add(ModItems.COTTON, 0.2f);
		CompostingChanceRegistry.INSTANCE.add(ModItems.COTTON_SEEDS, 0.3f);
		CompostingChanceRegistry.INSTANCE.add(ModItems.DRAGON_FRUIT, 0.6f);
	}
}