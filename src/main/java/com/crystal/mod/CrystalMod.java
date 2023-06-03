package com.crystal.mod;

import com.crystal.mod.block.FlammableBlocksRegistry;
import com.crystal.mod.block.ModBlocks;
import com.crystal.mod.item.ModItemGroups;
import com.crystal.mod.item.ModItems;
import com.crystal.mod.world.gen.ModWorldGeneration;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CrystalMod implements ModInitializer {
	public static final String MOD_ID = "crystal-mod";
	public static final Logger LOGGER = LoggerFactory.getLogger("crystal-mod");

	@Override
	public void onInitialize() {
		ModItemGroups.registerModItemGroups();
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		ModWorldGeneration.generateModWorldGen();

		FlammableBlocksRegistry.registerFlammableBlocks();
		StrippableBlockRegistry.register(ModBlocks.crystal_log, ModBlocks.stripped_crystal_log);
		StrippableBlockRegistry.register(ModBlocks.crystal_wood, ModBlocks.stripped_crystal_wood);
	}
}