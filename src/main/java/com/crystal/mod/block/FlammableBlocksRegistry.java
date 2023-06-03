package com.crystal.mod.block;

import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;

public class FlammableBlocksRegistry {

    public static void registerFlammableBlocks() {
        FlammableBlockRegistry flammable = FlammableBlockRegistry.getDefaultInstance();
        flammable.add(ModBlocks.crystal_leaves, 10, 100);
        flammable.add(ModBlocks.crystal_planks, 5, 75);
        flammable.add(ModBlocks.crystal_log, 5, 75);
        flammable.add(ModBlocks.stripped_crystal_log, 5, 75);
        flammable.add(ModBlocks.crystal_wood, 5, 75);
        flammable.add(ModBlocks.stripped_crystal_wood, 5, 75);
    }
}
