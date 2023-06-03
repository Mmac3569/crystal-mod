package com.crystal.mod.item;

import com.crystal.mod.CrystalMod;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {

    public static ItemGroup CrystalItemGroup;
    public static void registerModItemGroups() {
        CrystalItemGroup = FabricItemGroup.builder(new Identifier(CrystalMod.MOD_ID, "crystal-group"))
                .displayName(Text.literal("Crystal items"))
                .icon(() -> new ItemStack(ModItems.crystal)).build();
    }
}
