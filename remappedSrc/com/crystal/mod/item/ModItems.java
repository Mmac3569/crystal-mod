package com.crystal.mod.item;

import com.crystal.mod.CrystalMod;
import com.crystal.mod.materials.CrystalToolMaterial;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item crystal = registerItem("crystal", new Item(new FabricItemSettings()));
    public static final Item crystal_handle = registerItem("crystal-handle", new Item(new FabricItemSettings()));
    public static final Item raw_crystal = registerItem("raw-crystal", new Item(new FabricItemSettings()));
    public static final ToolItem crystal_pickaxe = new PickaxeItem(new CrystalToolMaterial(), 0, 0.8f, new Item.Settings());
    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(CrystalMod.MOD_ID, name), item);
    }

    public static void registerModItems() {
        CrystalMod.LOGGER.info("Registering mod items for " + CrystalMod.MOD_ID);
        Registry.register(Registries.ITEM, new Identifier(CrystalMod.MOD_ID, "crystal-pickaxe"), crystal_pickaxe);
        addItemsToItemGroup();
    }

    public static void addItemsToItemGroup() {
        addToItemGroup(ItemGroups.INGREDIENTS, crystal);
        addToItemGroup(ItemGroups.INGREDIENTS, raw_crystal);

        addToItemGroup(ModItemGroups.CrystalItemGroup, crystal);
        addToItemGroup(ModItemGroups.CrystalItemGroup, raw_crystal);

        addToItemGroup(ModItemGroups.CrystalItemGroup, crystal_pickaxe);
        addToItemGroup(ItemGroups.TOOLS, crystal_pickaxe);

        addToItemGroup(ModItemGroups.CrystalItemGroup, crystal_handle);
        addToItemGroup(ItemGroups.INGREDIENTS, crystal_handle);
    }

    public static void addToItemGroup(ItemGroup group, Item item) {
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(item));
    }
}
