package net.shardskye.shardsbiomemod.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.AliasedBlockItem;
import net.shardskye.shardsbiomemod.ShardsBiomeMod;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.shardskye.shardsbiomemod.block.ModBlocks;


public class ModItems {
    public static final Item COTTON = registerItem("cotton", new Item(new Item.Settings()));
    public static final Item DRAGON_FRUIT = registerItem("dragon_fruit", new Item(new Item.Settings()));
    public static final Item COTTON_SEEDS = registerItem("cotton_seeds", new AliasedBlockItem(ModBlocks.COTTON_CROP, new Item.Settings()));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(ShardsBiomeMod.MOD_ID, name), item);
    }

    public static void registerModItems() {
        ShardsBiomeMod.LOGGER.info("Registering Mod Items for " + ShardsBiomeMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(fabricItemGroupEntries -> {
            fabricItemGroupEntries.add(DRAGON_FRUIT);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(fabricItemGroupEntries -> {
            fabricItemGroupEntries.add(COTTON);
            fabricItemGroupEntries.add(COTTON_SEEDS);
        });
    }
}
