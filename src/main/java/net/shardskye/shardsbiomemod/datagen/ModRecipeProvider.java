package net.shardskye.shardsbiomemod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.ShapedRecipe;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.shardskye.shardsbiomemod.ShardsBiomeMod;
import net.shardskye.shardsbiomemod.block.ModBlocks;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter recipeExporter) {
        offerBarkBlockRecipe(recipeExporter, ModBlocks.CHESTNUT_WOOD, ModBlocks.CHESTNUT_LOG);
        offerBarkBlockRecipe(recipeExporter, ModBlocks.STRIPPED_CHESTNUT_WOOD, ModBlocks.STRIPPED_CHESTNUT_LOG);

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModBlocks.CHESTNUT_SLAB, 1)
                .pattern("CCC")
                .input('C', ModBlocks.CHESTNUT_PLANKS)
                .criterion(hasItem(ModBlocks.CHESTNUT_PLANKS), conditionsFromItem(ModBlocks.CHESTNUT_PLANKS))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModBlocks.CHESTNUT_STAIRS, 1)
                .pattern("C  ")
                .pattern("CC ")
                .pattern("CCC")
                .input('C', ModBlocks.CHESTNUT_PLANKS)
                .criterion(hasItem(ModBlocks.CHESTNUT_PLANKS), conditionsFromItem(ModBlocks.CHESTNUT_PLANKS))
                .offerTo(recipeExporter);


        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModBlocks.CHESTNUT_FENCE, 1)
                .pattern("CSC")
                .pattern("CSC")
                .input('C', ModBlocks.CHESTNUT_PLANKS)
                .input('S', Items.STICK)
                .criterion(hasItem(ModBlocks.CHESTNUT_PLANKS), conditionsFromItem(ModBlocks.CHESTNUT_PLANKS))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.REDSTONE, ModBlocks.CHESTNUT_FENCE_GATE, 1)
                .pattern("SCS")
                .pattern("SCS")
                .input('C', ModBlocks.CHESTNUT_PLANKS)
                .input('S', Items.STICK)
                .criterion(hasItem(ModBlocks.CHESTNUT_PLANKS), conditionsFromItem(ModBlocks.CHESTNUT_PLANKS))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CHESTNUT_PRESSURE_PLATE, 1)
                .pattern(" CC")
                .input('C', ModBlocks.CHESTNUT_PLANKS)
                .criterion(hasItem(ModBlocks.CHESTNUT_PLANKS), conditionsFromItem(ModBlocks.CHESTNUT_PLANKS))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.REDSTONE, ModBlocks.CHESTNUT_DOOR, 1)
                .pattern(" CC")
                .pattern(" CC")
                .pattern(" CC")
                .input('C', ModBlocks.CHESTNUT_PLANKS)
                .criterion(hasItem(ModBlocks.CHESTNUT_PLANKS), conditionsFromItem(ModBlocks.CHESTNUT_PLANKS))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.REDSTONE, ModBlocks.CHESTNUT_TRAPDOOR, 1)
                .pattern("CCC")
                .pattern("CCC")
                .input('C', ModBlocks.CHESTNUT_PLANKS)
                .criterion(hasItem(ModBlocks.CHESTNUT_PLANKS), conditionsFromItem(ModBlocks.CHESTNUT_PLANKS))
                .offerTo(recipeExporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.REDSTONE, ModBlocks.CHESTNUT_BUTTON, 1)
                .input(ModBlocks.CHESTNUT_PLANKS)
                .criterion(hasItem(ModBlocks.CHESTNUT_PLANKS), conditionsFromItem(ModBlocks.CHESTNUT_PLANKS))
                .offerTo(recipeExporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CHESTNUT_PLANKS, 4)
                .input(ModBlocks.CHESTNUT_LOG)
                .criterion(hasItem(ModBlocks.CHESTNUT_LOG), conditionsFromItem(ModBlocks.CHESTNUT_LOG))
                .offerTo(recipeExporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CHESTNUT_PLANKS, 4)
                .input(ModBlocks.STRIPPED_CHESTNUT_WOOD)
                .criterion(hasItem(ModBlocks.STRIPPED_CHESTNUT_WOOD), conditionsFromItem(ModBlocks.STRIPPED_CHESTNUT_LOG))
                .offerTo(recipeExporter, Identifier.of(ShardsBiomeMod.MOD_ID, "chestnut_planks_from_stripped_chestnut_log"));


    }
}
