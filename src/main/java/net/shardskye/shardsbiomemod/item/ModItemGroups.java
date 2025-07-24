package net.shardskye.shardsbiomemod.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.shardskye.shardsbiomemod.ShardsBiomeMod;
import net.shardskye.shardsbiomemod.block.ModBlocks;

public class ModItemGroups {
    public static final ItemGroup SHARDS_BIOME_MOD_ITEMS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(ShardsBiomeMod.MOD_ID, "shards_biome_mod_items"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModBlocks.CHESTNUT_PLANKS))
                    .displayName(Text.translatable("itemgroup.shardsbiomemod.shards_biome_mod_items"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModBlocks.CHESTNUT_LOG);
                        entries.add(ModBlocks.STRIPPED_CHESTNUT_LOG);
                        entries.add(ModBlocks.CHESTNUT_WOOD);
                        entries.add(ModBlocks.STRIPPED_CHESTNUT_WOOD);
                        entries.add(ModBlocks.CHESTNUT_LEAVES);
                        entries.add(ModBlocks.CHESTNUT_SAPLING);
                        entries.add(ModBlocks.CHESTNUT_PLANKS);
                        entries.add(ModBlocks.CHESTNUT_STAIRS);
                        entries.add(ModBlocks.CHESTNUT_SLAB);
                        entries.add(ModBlocks.CHESTNUT_FENCE);
                        entries.add(ModBlocks.CHESTNUT_FENCE_GATE);
                        entries.add(ModBlocks.CHESTNUT_DOOR);
                        entries.add(ModBlocks.CHESTNUT_TRAPDOOR);
                        entries.add(ModBlocks.CHESTNUT_PRESSURE_PLATE);
                        entries.add(ModBlocks.CHESTNUT_BUTTON);
                        entries.add(ModItems.DRAGON_FRUIT);
                        entries.add(ModItems.COTTON);
                        entries.add(ModItems.COTTON_SEEDS);
                    }).build());



    public static void registerItemGroups(){
        ShardsBiomeMod.LOGGER.info("Registering Item Groups for " + ShardsBiomeMod.MOD_ID);
    }
}
