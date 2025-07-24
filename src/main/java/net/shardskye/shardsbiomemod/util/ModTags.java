package net.shardskye.shardsbiomemod.util;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.shardskye.shardsbiomemod.ShardsBiomeMod;

public class ModTags {

    public static class Blocks{


        private static TagKey<Block> createTag(String name) {
            return TagKey.of(RegistryKeys.BLOCK, Identifier.of(ShardsBiomeMod.MOD_ID, name));
        }
    }

    public static class Items {


        private static TagKey<Item> createTag(String name) {
            return TagKey.of(RegistryKeys.ITEM, Identifier.of(ShardsBiomeMod.MOD_ID, name));
        }
    }
}
