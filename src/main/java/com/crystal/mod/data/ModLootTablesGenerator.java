package com.crystal.mod.data;

import com.crystal.mod.block.ModBlocks;
import com.crystal.mod.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.loot.LootTable;

public class ModLootTablesGenerator extends FabricBlockLootTableProvider {
    public ModLootTablesGenerator(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.crystal_log);
        addDrop(ModBlocks.stripped_crystal_log);
        addDrop(ModBlocks.crystal_wood);
        addDrop(ModBlocks.stripped_crystal_wood);
        addDrop(ModBlocks.crystal_planks);
        addDrop(ModBlocks.crystal_tree_sapling);
    }
}
