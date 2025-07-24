package net.shardskye.shardsbiomemod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Items;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.condition.BlockStatePropertyLootCondition;
import net.minecraft.loot.condition.TableBonusLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LeafEntry;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.predicate.StatePredicate;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.shardskye.shardsbiomemod.block.ModBlocks;
import net.shardskye.shardsbiomemod.block.custom.CottonCropBlock;
import net.shardskye.shardsbiomemod.item.ModItems;

import java.util.concurrent.CompletableFuture;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.CHESTNUT_FENCE);
        addDrop(ModBlocks.CHESTNUT_SLAB, slabDrops(ModBlocks.CHESTNUT_SLAB));
        addDrop(ModBlocks.CHESTNUT_STAIRS);
        addDrop(ModBlocks.CHESTNUT_PLANKS);
        addDrop(ModBlocks.CHESTNUT_LOG);
        addDrop(ModBlocks.STRIPPED_CHESTNUT_LOG);
        addDrop(ModBlocks.STRIPPED_CHESTNUT_WOOD);
        addDrop(ModBlocks.CHESTNUT_WOOD);
        addDrop(ModBlocks.CHESTNUT_DOOR, doorDrops(ModBlocks.CHESTNUT_DOOR));
        addDrop(ModBlocks.CHESTNUT_TRAPDOOR);
        addDrop(ModBlocks.CHESTNUT_PRESSURE_PLATE);
        addDrop(ModBlocks.CHESTNUT_BUTTON);
        addDrop(ModBlocks.CHESTNUT_SAPLING);

        addPottedPlantDrops(ModBlocks.POTTED_CHESTNUT_SAPLING);

        addDrop(ModBlocks.CHESTNUT_LEAVES, chestnutLeavesDrops(ModBlocks.CHESTNUT_LEAVES, Blocks.SPRUCE_SAPLING, 0.0625f));

        BlockStatePropertyLootCondition.Builder builder2 = BlockStatePropertyLootCondition.builder(ModBlocks.COTTON_CROP)
                .properties(StatePredicate.Builder.create().exactMatch(CottonCropBlock.AGE, 6));
        this.addDrop(ModBlocks.COTTON_CROP, this.cropDrops(ModBlocks.COTTON_CROP, ModItems.COTTON, ModItems.COTTON_SEEDS, builder2));
    }

    public LootTable.Builder chestnutLeavesDrops(Block leaves, Block sapling, float... saplingChance) {
        RegistryWrapper.Impl<Enchantment> impl = this.registryLookup.getWrapperOrThrow(RegistryKeys.ENCHANTMENT);
        return this.leavesDrops(leaves, sapling, saplingChance)
                .pool(
                        LootPool.builder()
                                .rolls(ConstantLootNumberProvider.create(1.0F))
                                .conditionally(this.createWithoutShearsOrSilkTouchCondition())
                                .with(
                                        ((LeafEntry.Builder)this.addSurvivesExplosionCondition(leaves, ItemEntry.builder(ModItems.DRAGON_FRUIT)))
                                                .conditionally(TableBonusLootCondition.builder(impl.getOrThrow(Enchantments.FORTUNE), 0.005F, 0.0055555557F, 0.00625F, 0.008333334F, 0.025F))
                                )
                );
    }

}
