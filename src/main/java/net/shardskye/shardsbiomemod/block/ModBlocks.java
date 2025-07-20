package net.shardskye.shardsbiomemod.block;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.*;
import net.minecraft.block.enums.NoteBlockInstrument;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Direction;
import net.shardskye.shardsbiomemod.ShardsBiomeMod;

public class ModBlocks {

    public static final Block CHESTNUT_PLANKS = registerBlock("chestnut_planks",
            new Block(
                    AbstractBlock.Settings.create()
                            .mapColor(MapColor.BROWN)
                            .instrument(NoteBlockInstrument.BASS)
                            .strength(2.0f, 3.0f)
                            .sounds(BlockSoundGroup.WOOD)
                            .burnable()
            )
    );

    public static final Block CHESTNUT_LOG = registerBlock("chestnut_log", createLogBlock(MapColor.BROWN, MapColor.BROWN));
    public static final Block STRIPPED_CHESTNUT_LOG = registerBlock("stripped_chestnut_log", createLogBlock(MapColor.BROWN, MapColor.BROWN));

    public static final Block CHESTNUT_WOOD = registerBlock("chestnut_wood",
            new PillarBlock(
                    AbstractBlock.Settings.create()
                            .mapColor(MapColor.BROWN)
                            .instrument(NoteBlockInstrument.BASS)
                            .strength(2.0f, 3.0f)
                            .sounds(BlockSoundGroup.WOOD)
                            .burnable()
            )
    );

    public static final Block STRIPPED_CHESTNUT_WOOD = registerBlock("stripped_chestnut_wood",
            new PillarBlock(
                    AbstractBlock.Settings.create()
                            .mapColor(MapColor.BROWN)
                            .instrument(NoteBlockInstrument.BASS)
                            .strength(2.0f, 3.0f)
                            .sounds(BlockSoundGroup.WOOD)
                            .burnable()
            )
    );

    public static final Block CHESTNUT_LEAVES = registerBlock("chestnut_leaves", createLeavesBlock(BlockSoundGroup.GRASS, MapColor.BROWN));

    public static final Block CHESTNUT_SLAB = registerBlock("chestnut_slab",
            new SlabBlock(
                    AbstractBlock.Settings.create()
                            .mapColor(MapColor.BROWN)
                            .instrument(NoteBlockInstrument.BASS)
                            .strength(2.0f, 3.0f)
                            .sounds(BlockSoundGroup.WOOD)
                            .burnable()
            ));

    public static final Block CHESTNUT_STAIRS = registerBlock("chestnut_stairs", createStairsBlock(CHESTNUT_PLANKS));

    public static final Block CHESTNUT_FENCE = registerBlock("chestnut_fence",
            new FenceBlock(
                    AbstractBlock.Settings.create()
                        .mapColor(CHESTNUT_PLANKS.getDefaultMapColor())
                        .instrument(NoteBlockInstrument.BASS)
                        .strength(2.0F, 3.0F)
                        .burnable()
                        .sounds(BlockSoundGroup.WOOD)
    ));


    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(ShardsBiomeMod.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(ShardsBiomeMod.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }

    public static void registerModBlocks() {
        ShardsBiomeMod.LOGGER.info("Registering Mod Blocks for " + ShardsBiomeMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(fabricItemGroupEntries -> {
            fabricItemGroupEntries.add(ModBlocks.CHESTNUT_LOG);
            fabricItemGroupEntries.add(ModBlocks.CHESTNUT_WOOD);
            fabricItemGroupEntries.add(ModBlocks.STRIPPED_CHESTNUT_LOG);
            fabricItemGroupEntries.add(ModBlocks.STRIPPED_CHESTNUT_WOOD);
            fabricItemGroupEntries.add(ModBlocks.CHESTNUT_PLANKS);
            fabricItemGroupEntries.add(ModBlocks.CHESTNUT_STAIRS);
            fabricItemGroupEntries.add(ModBlocks.CHESTNUT_SLAB);
            fabricItemGroupEntries.add(ModBlocks.CHESTNUT_FENCE);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(fabricItemGroupEntries -> {
            fabricItemGroupEntries.add(ModBlocks.CHESTNUT_LEAVES);
            fabricItemGroupEntries.add(ModBlocks.CHESTNUT_LOG);
            fabricItemGroupEntries.add(ModBlocks.CHESTNUT_WOOD);
        });
    }

    public static Block createLogBlock(MapColor topMapColor, MapColor sideMapColor) {
        return new PillarBlock(
                AbstractBlock.Settings.create()
                        .mapColor(state -> state.get(PillarBlock.AXIS) == Direction.Axis.Y ? topMapColor : sideMapColor)
                        .instrument(NoteBlockInstrument.BASS)
                        .strength(2.0F)
                        .sounds(BlockSoundGroup.WOOD)
                        .burnable()
        );
    }

    public static Block createLeavesBlock(BlockSoundGroup soundGroup, MapColor mapColor) {
        return new LeavesBlock(
                AbstractBlock.Settings.create()
                        .mapColor(MapColor.DARK_GREEN)
                        .strength(0.2F)
                        .ticksRandomly()
                        .sounds(soundGroup)
                        .nonOpaque()
                        .allowsSpawning(Blocks::canSpawnOnLeaves)
                        .suffocates(Blocks::never)
                        .blockVision(Blocks::never)
                        .burnable()
                        .pistonBehavior(PistonBehavior.DESTROY)
                        .solidBlock(Blocks::never)
        );
    }

    private static Block createStairsBlock(Block base) {
        return new StairsBlock(base.getDefaultState(), AbstractBlock.Settings.copy(base));
    }
}
