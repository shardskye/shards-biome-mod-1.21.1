package net.shardskye.shardsbiomemod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.minecraft.data.client.TexturedModel;
import net.shardskye.shardsbiomemod.block.ModBlocks;
import net.shardskye.shardsbiomemod.block.custom.CottonCropBlock;
import net.shardskye.shardsbiomemod.item.ModItems;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        BlockStateModelGenerator.BlockTexturePool chestnutPlankPool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.CHESTNUT_PLANKS);

        // STAIRS
        chestnutPlankPool.stairs(ModBlocks.CHESTNUT_STAIRS);

        // SLAB
        chestnutPlankPool.slab(ModBlocks.CHESTNUT_SLAB);

        // FENCE
        chestnutPlankPool.fence(ModBlocks.CHESTNUT_FENCE);

        // FENCE GATE
        chestnutPlankPool.fenceGate(ModBlocks.CHESTNUT_FENCE_GATE);

        // PRESSURE PLATE
        chestnutPlankPool.pressurePlate(ModBlocks.CHESTNUT_PRESSURE_PLATE);

        // BUTTON
        chestnutPlankPool.button(ModBlocks.CHESTNUT_BUTTON);

        // DOOR
        blockStateModelGenerator.registerDoor(ModBlocks.CHESTNUT_DOOR);

        // TRAPDOOR
        blockStateModelGenerator.registerTrapdoor(ModBlocks.CHESTNUT_TRAPDOOR);

        // LOGS
        blockStateModelGenerator.registerLog(ModBlocks.CHESTNUT_LOG).log(ModBlocks.CHESTNUT_LOG).wood(ModBlocks.CHESTNUT_WOOD);
        blockStateModelGenerator.registerLog(ModBlocks.STRIPPED_CHESTNUT_LOG).log(ModBlocks.STRIPPED_CHESTNUT_LOG).wood(ModBlocks.STRIPPED_CHESTNUT_WOOD);

        // SINGLETON
        blockStateModelGenerator.registerSingleton(ModBlocks.CHESTNUT_LEAVES, TexturedModel.LEAVES);

        // FLOWER & FLOWER POT
        blockStateModelGenerator.registerFlowerPotPlant(ModBlocks.CHESTNUT_SAPLING, ModBlocks.POTTED_CHESTNUT_SAPLING, BlockStateModelGenerator.TintType.NOT_TINTED);

        // CROP
        blockStateModelGenerator.registerCrop(ModBlocks.COTTON_CROP, CottonCropBlock.AGE, 0, 1, 2, 3, 4, 5, 6);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.COTTON, Models.GENERATED);
        itemModelGenerator.register(ModItems.DRAGON_FRUIT, Models.GENERATED);
    }
}
