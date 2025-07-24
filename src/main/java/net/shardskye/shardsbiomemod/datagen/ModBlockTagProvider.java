package net.shardskye.shardsbiomemod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.shardskye.shardsbiomemod.block.ModBlocks;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(BlockTags.AXE_MINEABLE)
                .add(ModBlocks.CHESTNUT_FENCE)
                .add(ModBlocks.CHESTNUT_LOG)
                .add(ModBlocks.CHESTNUT_PLANKS)
                .add(ModBlocks.CHESTNUT_SLAB)
                .add(ModBlocks.CHESTNUT_STAIRS)
                .add(ModBlocks.STRIPPED_CHESTNUT_LOG)
                .add(ModBlocks.STRIPPED_CHESTNUT_WOOD)
                .add(ModBlocks.CHESTNUT_WOOD)
                .add(ModBlocks.CHESTNUT_TRAPDOOR)
                .add(ModBlocks.CHESTNUT_DOOR)
                .add(ModBlocks.CHESTNUT_FENCE_GATE)
                .add(ModBlocks.CHESTNUT_PRESSURE_PLATE)
                .add(ModBlocks.CHESTNUT_BUTTON);

        getOrCreateTagBuilder(BlockTags.HOE_MINEABLE)
                .add(ModBlocks.CHESTNUT_LEAVES);

        getOrCreateTagBuilder(BlockTags.WOODEN_FENCES)
                .add(ModBlocks.CHESTNUT_FENCE);

        getOrCreateTagBuilder(BlockTags.FENCE_GATES)
                .add(ModBlocks.CHESTNUT_FENCE_GATE);

        getOrCreateTagBuilder(BlockTags.WOODEN_DOORS)
                .add(ModBlocks.CHESTNUT_DOOR);

        getOrCreateTagBuilder(BlockTags.WOODEN_TRAPDOORS)
                .add(ModBlocks.CHESTNUT_TRAPDOOR);

        getOrCreateTagBuilder(BlockTags.WOODEN_BUTTONS)
                .add(ModBlocks.CHESTNUT_BUTTON);

        getOrCreateTagBuilder(BlockTags.WOODEN_PRESSURE_PLATES)
                .add(ModBlocks.CHESTNUT_PRESSURE_PLATE);

        getOrCreateTagBuilder(BlockTags.WOODEN_SLABS)
                .add(ModBlocks.CHESTNUT_SLAB);

        getOrCreateTagBuilder(BlockTags.WOODEN_STAIRS)
                .add(ModBlocks.CHESTNUT_STAIRS);

        getOrCreateTagBuilder(BlockTags.LOGS_THAT_BURN)
                .add(ModBlocks.CHESTNUT_LOG)
                .add(ModBlocks.CHESTNUT_WOOD)
                .add(ModBlocks.STRIPPED_CHESTNUT_LOG)
                .add(ModBlocks.STRIPPED_CHESTNUT_WOOD);

        getOrCreateTagBuilder(BlockTags.PLANKS)
                .add(ModBlocks.CHESTNUT_PLANKS);

        getOrCreateTagBuilder(BlockTags.LEAVES)
                .add(ModBlocks.CHESTNUT_LEAVES);

        getOrCreateTagBuilder(BlockTags.FLOWER_POTS)
                .add(ModBlocks.POTTED_CHESTNUT_SAPLING);
    }
}
