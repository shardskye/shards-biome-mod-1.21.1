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
import net.shardskye.shardsbiomemod.ShardsBiomeMod;
import net.shardskye.shardsbiomemod.block.custom.CottonCropBlock;
import net.shardskye.shardsbiomemod.world.tree.ModSaplingGenerators;

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

    public static final Block CHESTNUT_LOG = registerBlock("chestnut_log",
            new PillarBlock(AbstractBlock.Settings.copy(Blocks.DARK_OAK_LOG)));
    public static final Block CHESTNUT_WOOD = registerBlock("chestnut_wood",
            new PillarBlock(AbstractBlock.Settings.copy(Blocks.DARK_OAK_WOOD)));
    public static final Block STRIPPED_CHESTNUT_LOG = registerBlock("stripped_chestnut_log",
            new PillarBlock(AbstractBlock.Settings.copy(Blocks.STRIPPED_DARK_OAK_LOG)));
    public static final Block STRIPPED_CHESTNUT_WOOD = registerBlock("stripped_chestnut_wood",
            new PillarBlock(AbstractBlock.Settings.copy(Blocks.STRIPPED_DARK_OAK_WOOD)));

    public static final Block CHESTNUT_LEAVES = registerBlock("chestnut_leaves",
        new LeavesBlock(AbstractBlock.Settings.copy(Blocks.OAK_LEAVES)));

    public static final Block CHESTNUT_SAPLING = registerBlock("chestnut_sapling",
            new SaplingBlock(ModSaplingGenerators.CHESTNUT, AbstractBlock.Settings.copy(Blocks.DARK_OAK_SAPLING)));

    public static final Block POTTED_CHESTNUT_SAPLING = registerBlock("potted_chestnut_sapling",
            new FlowerPotBlock(CHESTNUT_SAPLING, AbstractBlock.Settings.copy(Blocks.POTTED_DARK_OAK_SAPLING).nonOpaque()));

    public static final Block CHESTNUT_SLAB = registerBlock("chestnut_slab",
            new SlabBlock(
                    AbstractBlock.Settings.create()
                            .mapColor(MapColor.BROWN)
                            .instrument(NoteBlockInstrument.BASS)
                            .strength(2.0f, 3.0f)
                            .sounds(BlockSoundGroup.WOOD)
                            .burnable()
            ));

    public static final Block CHESTNUT_STAIRS = registerBlock("chestnut_stairs",
            new StairsBlock(ModBlocks.CHESTNUT_PLANKS.getDefaultState(),
                    AbstractBlock.Settings.create()
                            .strength(2.0F, 3.0F)
                            .instrument(NoteBlockInstrument.BASS)
                            .mapColor(CHESTNUT_PLANKS.getDefaultMapColor())
                            .burnable()
                            .sounds(BlockSoundGroup.WOOD)
            ));

    public static final Block CHESTNUT_FENCE = registerBlock("chestnut_fence",
            new FenceBlock(
                    AbstractBlock.Settings.create()
                        .mapColor(CHESTNUT_PLANKS.getDefaultMapColor())
                        .instrument(NoteBlockInstrument.BASS)
                        .strength(2.0F, 3.0F)
                        .burnable()
                        .sounds(BlockSoundGroup.WOOD)
    ));

    public static final Block CHESTNUT_FENCE_GATE = registerBlock("chestnut_fence_gate",
            new FenceGateBlock(WoodType.OAK,
                    AbstractBlock.Settings.create()
                            .mapColor(CHESTNUT_PLANKS.getDefaultMapColor())
                            .instrument(NoteBlockInstrument.BASS)
                            .strength(2.0F, 3.0F)
                            .burnable()
                            .sounds(BlockSoundGroup.WOOD)
            ));

    public static final Block CHESTNUT_DOOR = registerBlock("chestnut_door",
            new DoorBlock(BlockSetType.OAK,
                    AbstractBlock.Settings.create()
                            .mapColor(CHESTNUT_PLANKS.getDefaultMapColor())
                            .instrument(NoteBlockInstrument.BASS)
                            .strength(2.0F, 3.0F)
                            .burnable()
                            .sounds(BlockSoundGroup.WOOD)
                            .nonOpaque()
            ));

    public static final Block CHESTNUT_TRAPDOOR = registerBlock("chestnut_trapdoor",
            new TrapdoorBlock(BlockSetType.OAK,
                    AbstractBlock.Settings.create()
                            .mapColor(CHESTNUT_PLANKS.getDefaultMapColor())
                            .instrument(NoteBlockInstrument.BASS)
                            .strength(2.0F, 3.0F)
                            .burnable()
                            .sounds(BlockSoundGroup.WOOD)
                            .nonOpaque()
            ));

    public static final Block CHESTNUT_BUTTON = registerBlock("chestnut_button",
            new ButtonBlock(BlockSetType.OAK, 30,
                    AbstractBlock.Settings.create()
                            .strength(2.0F, 3.0F)
                            .burnable()
                            .sounds(BlockSoundGroup.WOOD)
                            .noCollision()
            ));

    public static final Block CHESTNUT_PRESSURE_PLATE = registerBlock("chestnut_pressure_plate",
            new PressurePlateBlock(BlockSetType.OAK,
                    AbstractBlock.Settings.create()
                            .strength(2.0F, 3.0F)
                            .burnable()
                            .sounds(BlockSoundGroup.WOOD)
                            .noCollision()
            ));

    public static Block COTTON_CROP = registerBlockWithoutBlockItem("cotton_crop",
            new CottonCropBlock(AbstractBlock.Settings.create()
                    .nonOpaque()
                    .noCollision()
                    .ticksRandomly()
                    .breakInstantly()
                    .sounds(BlockSoundGroup.CROP)
                    .pistonBehavior(PistonBehavior.DESTROY)
                    .mapColor(MapColor.DARK_GREEN)));

    private static Block registerBlockWithoutBlockItem(String name, Block block) {
        return Registry.register(Registries.BLOCK, Identifier.of(ShardsBiomeMod.MOD_ID, name), block);
    }

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
            fabricItemGroupEntries.add(ModBlocks.CHESTNUT_FENCE_GATE);
            fabricItemGroupEntries.add(ModBlocks.CHESTNUT_DOOR);
            fabricItemGroupEntries.add(ModBlocks.CHESTNUT_TRAPDOOR);
            fabricItemGroupEntries.add(ModBlocks.CHESTNUT_PRESSURE_PLATE);
            fabricItemGroupEntries.add(ModBlocks.CHESTNUT_BUTTON);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COLORED_BLOCKS).register(fabricItemGroupEntries -> {
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(fabricItemGroupEntries -> {
            fabricItemGroupEntries.add(ModBlocks.CHESTNUT_LOG);
            fabricItemGroupEntries.add(ModBlocks.CHESTNUT_LEAVES);
            fabricItemGroupEntries.add(ModBlocks.CHESTNUT_SAPLING);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register(fabricItemGroupEntries -> {
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.REDSTONE).register(fabricItemGroupEntries -> {
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(fabricItemGroupEntries -> {
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(fabricItemGroupEntries -> {
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(fabricItemGroupEntries -> {
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(fabricItemGroupEntries -> {
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.SPAWN_EGGS).register(fabricItemGroupEntries -> {
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.SEARCH).register(fabricItemGroupEntries -> {
        });
    }
}
