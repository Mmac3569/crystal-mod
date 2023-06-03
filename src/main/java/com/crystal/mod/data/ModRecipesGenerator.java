package com.crystal.mod.data;

import com.crystal.mod.block.ModBlocks;
import com.crystal.mod.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipesGenerator extends FabricRecipeProvider {
    public ModRecipesGenerator(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(Consumer<RecipeJsonProvider> exporter) {
        offerSmelting(exporter, List.of(ModItems.raw_crystal), RecipeCategory.MISC, ModItems.crystal, 16, 500, "crystal");
        offerCompactingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.crystal_block, ModItems.crystal);
        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModItems.raw_crystal)
                .pattern("SSS")
                .pattern("SCS")
                .pattern("SSS")
                .input('S', Items.STONE)
                .input('C', ModItems.crystal)
                .criterion(FabricRecipeProvider.hasItem(ModItems.crystal),
                        FabricRecipeProvider.conditionsFromItem(ModItems.crystal))
                .criterion(FabricRecipeProvider.hasItem(Items.STONE),
                FabricRecipeProvider.conditionsFromItem(Items.STONE))
                .offerTo(exporter, new Identifier(FabricRecipeProvider.getRecipeName(ModItems.raw_crystal)));
    }
}
