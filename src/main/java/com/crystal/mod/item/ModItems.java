package com.crystal.mod.item;

import com.crystal.mod.CrystalMod;
import com.crystal.mod.materials.CrystalToolMaterial;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

public class ModItems {
    public static final Item crystal = registerItem("crystal", new Item(new FabricItemSettings()));
    public static final Item crystal_handle = registerItem("crystal-handle", new Item(new FabricItemSettings()));
    public static final Item raw_crystal = registerItem("raw-crystal", new Item(new FabricItemSettings()));
    public static final Item enchanted_crystal_apple = registerItem("enchanted-crystal-apple", new EnchantedGoldenAppleItem(new FabricItemSettings().rarity(Rarity.EPIC).food(new FoodComponent.Builder().hunger(7).saturationModifier(10f).alwaysEdible()
            .statusEffect(new StatusEffectInstance(StatusEffects.HEALTH_BOOST, 18000, 9), 1)
            .statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 18000, 2), 1)
            .statusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 18000, 2), 1)
            .statusEffect(new StatusEffectInstance(StatusEffects.GLOWING, 18000, 0), 1)
            .statusEffect(new StatusEffectInstance(StatusEffects.SPEED, 18000, 4), 1)
            .statusEffect(new StatusEffectInstance(StatusEffects.JUMP_BOOST, 18000, 4), 1)
            .statusEffect(new StatusEffectInstance(StatusEffects.HASTE, 18000, 4), 1)
            .statusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 18000, 0), 1)
            .statusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 18000, 4), 1)
            .statusEffect(new StatusEffectInstance(StatusEffects.NIGHT_VISION, 18000, 0), 1)
            .statusEffect(new StatusEffectInstance(StatusEffects.LUCK, 18000, 9), 1)
            .statusEffect(new StatusEffectInstance(StatusEffects.INSTANT_HEALTH, 60, 100), 1).build())));
    public static final Item crystal_apple = registerItem("crystal-apple", new Item(new FabricItemSettings().rarity(Rarity.RARE).food(new FoodComponent.Builder().hunger(7).saturationModifier(10f).alwaysEdible()
            .statusEffect(new StatusEffectInstance(StatusEffects.HEALTH_BOOST, 6000, 4), 1)
            .statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 6000, 2), 1)
            .statusEffect(new StatusEffectInstance(StatusEffects.GLOWING, 6000, 0), 1)
            .statusEffect(new StatusEffectInstance(StatusEffects.SPEED, 6000, 2), 1)
            .statusEffect(new StatusEffectInstance(StatusEffects.JUMP_BOOST, 6000, 2), 1)
            .statusEffect(new StatusEffectInstance(StatusEffects.HASTE, 6000, 2), 1)
            .statusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 6000, 0), 1)
            .statusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 6000, 4), 1)
            .statusEffect(new StatusEffectInstance(StatusEffects.NIGHT_VISION, 6000, 0), 1)
            .statusEffect(new StatusEffectInstance(StatusEffects.INSTANT_HEALTH, 60, 100), 1).build())));
    public static final ToolItem crystal_pickaxe = new PickaxeItem(new CrystalToolMaterial(), 0, 0.8f, new Item.Settings());
    public static final ToolItem crystal_sword = new SwordItem(new CrystalToolMaterial(), 3, 0.8f, new Item.Settings());
    public static final ToolItem crystal_axe = new AxeItem(new CrystalToolMaterial(), 5, 0.8f, new Item.Settings());
    public static final ToolItem crystal_shovel = new ShovelItem(new CrystalToolMaterial(), -2, 0.8f, new Item.Settings());
    public static final ToolItem crystal_hoe = new HoeItem(new CrystalToolMaterial(), -1, 0.8f, new Item.Settings());
    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(CrystalMod.MOD_ID, name), item);
    }

    public static void registerModItems() {
        CrystalMod.LOGGER.info("Registering mod items for " + CrystalMod.MOD_ID);
        Registry.register(Registries.ITEM, new Identifier(CrystalMod.MOD_ID, "crystal-pickaxe"), crystal_pickaxe);
        Registry.register(Registries.ITEM, new Identifier(CrystalMod.MOD_ID, "crystal-sword"), crystal_sword);
        Registry.register(Registries.ITEM, new Identifier(CrystalMod.MOD_ID, "crystal-axe"), crystal_axe);
        Registry.register(Registries.ITEM, new Identifier(CrystalMod.MOD_ID, "crystal-shovel"), crystal_shovel);
        Registry.register(Registries.ITEM, new Identifier(CrystalMod.MOD_ID, "crystal-hoe"), crystal_hoe);
        addItemsToItemGroup();
    }

    public static void addItemsToItemGroup() {
        addToItemGroup(ItemGroups.INGREDIENTS, crystal);
        addToItemGroup(ItemGroups.INGREDIENTS, raw_crystal);

        addToItemGroup(ModItemGroups.CrystalItemGroup, crystal);
        addToItemGroup(ModItemGroups.CrystalItemGroup, raw_crystal);

        addToItemGroup(ModItemGroups.CrystalItemGroup, crystal_pickaxe);
        addToItemGroup(ItemGroups.TOOLS, crystal_pickaxe);

        addToItemGroup(ModItemGroups.CrystalItemGroup, crystal_axe);
        addToItemGroup(ItemGroups.TOOLS, crystal_axe);

        addToItemGroup(ModItemGroups.CrystalItemGroup, crystal_sword);
        addToItemGroup(ItemGroups.TOOLS, crystal_sword);

        addToItemGroup(ModItemGroups.CrystalItemGroup, crystal_shovel);
        addToItemGroup(ItemGroups.TOOLS, crystal_shovel);

        addToItemGroup(ModItemGroups.CrystalItemGroup, crystal_hoe);
        addToItemGroup(ItemGroups.TOOLS, crystal_hoe);

        addToItemGroup(ModItemGroups.CrystalItemGroup, enchanted_crystal_apple);
        addToItemGroup(ItemGroups.FOOD_AND_DRINK, enchanted_crystal_apple);

        addToItemGroup(ModItemGroups.CrystalItemGroup, crystal_apple);
        addToItemGroup(ItemGroups.FOOD_AND_DRINK, crystal_apple);

        addToItemGroup(ModItemGroups.CrystalItemGroup, crystal_handle);
        addToItemGroup(ItemGroups.INGREDIENTS, crystal_handle);
    }

    public static void addToItemGroup(ItemGroup group, Item item) {
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(item));
    }
}
