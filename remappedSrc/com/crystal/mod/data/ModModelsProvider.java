package com.crystal.mod.data;

import com.crystal.mod.block.ModBlocks;
import com.crystal.mod.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;

public class ModModelsProvider extends FabricModelProvider {
    public ModModelsProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerLog(ModBlocks.crystal_log);
        blockStateModelGenerator.registerLog(ModBlocks.stripped_crystal_log);
        blockStateModelGenerator.registerLog(ModBlocks.crystal_wood);
        blockStateModelGenerator.registerLog(ModBlocks.stripped_crystal_wood);

        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.crystal_leaves);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.crystal_planks);

        blockStateModelGenerator.registerTintableCross(ModBlocks.crystal_tree_sapling, BlockStateModelGenerator.TintType.NOT_TINTED);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {

    }
}
