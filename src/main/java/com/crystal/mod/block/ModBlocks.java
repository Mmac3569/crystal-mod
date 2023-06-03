package com.crystal.mod.block;

import com.crystal.mod.CrystalMod;
import com.crystal.mod.item.ModItemGroups;
import com.crystal.mod.materials.CrystalBlockMaterial;
import com.crystal.mod.world.tree.CrystalTreeSaplingGenerator;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;

public class ModBlocks {

    public static final Block crystal_block = registerBlock("crystal-block",
            new Block(FabricBlockSettings.of(CrystalBlockMaterial.CRYSTAL).strength(10f).requiresTool().luminance(12)),
            ModItemGroups.CrystalItemGroup);
    public static final Block crystal_ore = registerBlock("crystal-ore",
            new ExperienceDroppingBlock(FabricBlockSettings.of(Material.STONE).strength(10f).requiresTool().luminance(8),
                    UniformIntProvider.create(32, 64)), ModItemGroups.CrystalItemGroup);
    public static final Block deepslate_crystal_ore = registerBlock("deepslate-crystal-ore",
            new ExperienceDroppingBlock(FabricBlockSettings.of(Material.STONE).strength(10f).requiresTool().luminance(8),
                    UniformIntProvider.create(32, 64)), ModItemGroups.CrystalItemGroup);

    //Tree blocks definition
    public static final Block crystal_log = registerBlock("crystal-log",
            new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_LOG)), ModItemGroups.CrystalItemGroup);
    public static final Block stripped_crystal_log = registerBlock("stripped-crystal-log",
            new PillarBlock(FabricBlockSettings.copyOf(Blocks.STRIPPED_OAK_LOG)), ModItemGroups.CrystalItemGroup);
    public static final Block crystal_wood = registerBlock("crystal-wood",
            new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_WOOD)), ModItemGroups.CrystalItemGroup);
    public static final Block stripped_crystal_wood = registerBlock("stripped-crystal-wood",
            new PillarBlock(FabricBlockSettings.copyOf(Blocks.STRIPPED_OAK_WOOD)), ModItemGroups.CrystalItemGroup);
    public static final Block crystal_planks = registerBlock("crystal-planks",
            new Block(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS)), ModItemGroups.CrystalItemGroup);
    public static final Block crystal_leaves = registerBlock("crystal-leaves",
            new LeavesBlock(FabricBlockSettings.copyOf(Blocks.OAK_LEAVES)), ModItemGroups.CrystalItemGroup);
    public static final Block crystal_tree_sapling = registerBlock("crystal-tree-sapling",
            new SaplingBlock(new CrystalTreeSaplingGenerator(), FabricBlockSettings.copyOf(Blocks.OAK_SAPLING)), ModItemGroups.CrystalItemGroup);

    //End of tree blocks definition
    public static void registerModBlocks() {
        CrystalMod.LOGGER.info("Registering mod blocks for " + CrystalMod.MOD_ID);
    }

    private static Item registerBlockItem(String name, Block block, ItemGroup group) {
        Item item = Registry.register(Registries.ITEM, new Identifier(CrystalMod.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(item));
        return item;
    }

    private static Item registerBlockItem(String name, Block block, ItemGroup[] groups) {
        Item item = Registry.register(Registries.ITEM, new Identifier(CrystalMod.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
        for(int i = 0; i < groups.length;) {
            ItemGroupEvents.modifyEntriesEvent(groups[i]).register(entries -> entries.add(item)); i++;
        }
        return item;
    }

    private static Block registerBlock(String name, Block block, ItemGroup group) {
        registerBlockItem(name, block, group);
        return Registry.register(Registries.BLOCK, new Identifier(CrystalMod.MOD_ID, name), block);
    }

    private static Block registerBlock(String name, Block block, ItemGroup[] groups) {
        registerBlockItem(name, block, groups);
        return Registry.register(Registries.BLOCK, new Identifier(CrystalMod.MOD_ID, name), block);
    }
}
