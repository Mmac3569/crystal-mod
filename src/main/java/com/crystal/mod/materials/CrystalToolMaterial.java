package com.crystal.mod.materials;

import com.crystal.mod.item.ModItems;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class CrystalToolMaterial implements ToolMaterial {

    @Override
    public int getDurability() {
        return 3200;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return 32;
    }

    @Override
    public float getAttackDamage() {
        return 7;
    }

    @Override
    public int getMiningLevel() {
        return 5;
    }

    @Override
    public int getEnchantability() {
        return 77;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(ModItems.crystal);
    }
}
