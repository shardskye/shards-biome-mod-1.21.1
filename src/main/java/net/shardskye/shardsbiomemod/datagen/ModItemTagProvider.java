package net.shardskye.shardsbiomemod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;
import net.shardskye.shardsbiomemod.block.ModBlocks;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(ItemTags.LOGS_THAT_BURN)
                .add(ModBlocks.CHESTNUT_LOG.asItem())
                .add(ModBlocks.CHESTNUT_WOOD.asItem())
                .add(ModBlocks.STRIPPED_CHESTNUT_LOG.asItem())
                .add(ModBlocks.STRIPPED_CHESTNUT_WOOD.asItem());

        getOrCreateTagBuilder(ItemTags.PLANKS)
                .add(ModBlocks.CHESTNUT_PLANKS.asItem());

        getOrCreateTagBuilder(ItemTags.WOODEN_FENCES)
                .add(ModBlocks.CHESTNUT_FENCE.asItem());

        getOrCreateTagBuilder(ItemTags.FENCE_GATES)
                .add(ModBlocks.CHESTNUT_FENCE_GATE.asItem());

        getOrCreateTagBuilder(ItemTags.WOODEN_DOORS)
                .add(ModBlocks.CHESTNUT_DOOR.asItem());

        getOrCreateTagBuilder(ItemTags.WOODEN_TRAPDOORS)
                .add(ModBlocks.CHESTNUT_TRAPDOOR.asItem());

        getOrCreateTagBuilder(ItemTags.PLANKS)
                .add(ModBlocks.CHESTNUT_PLANKS.asItem());

        getOrCreateTagBuilder(ItemTags.WOODEN_STAIRS)
                .add(ModBlocks.CHESTNUT_STAIRS.asItem());

        getOrCreateTagBuilder(ItemTags.WOODEN_SLABS)
                .add(ModBlocks.CHESTNUT_SLAB.asItem());

        getOrCreateTagBuilder(ItemTags.WOODEN_BUTTONS)
                .add(ModBlocks.CHESTNUT_BUTTON.asItem());

        getOrCreateTagBuilder(ItemTags.WOODEN_PRESSURE_PLATES)
                .add(ModBlocks.CHESTNUT_PRESSURE_PLATE.asItem());
    }
}
