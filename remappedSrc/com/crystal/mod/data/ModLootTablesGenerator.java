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
        addDrop(ModBlocks.crystal_block);
        oreDrops(ModBlocks.crystal_block, ModItems.crystal);
        oreDrops(ModBlocks.crystal_ore, ModItems.raw_crystal);
        oreDrops(ModBlocks.deepslate_crystal_ore, ModItems.raw_crystal);
    }
}
