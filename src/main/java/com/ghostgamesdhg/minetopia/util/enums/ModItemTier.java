package com.ghostgamesdhg.minetopia.util.enums;

import com.ghostgamesdhg.minetopia.init.ModItems;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.item.IItemTier;
import net.minecraft.item.crafting.Ingredient;

import java.util.function.Supplier;

public enum ModItemTier implements IItemTier {

    BLUE_CRYSTAL(3, 900, 9.0F, 1.0F, 12, () -> {
        return Ingredient.fromItems(ModItems.BLUE_CRYSTAL_SWORD.get());
    }),

    WAPENSTOK(0, 1200, 2.0F, 0.0F, 15, () -> {
        return Ingredient.fromItems(ModItems.WAPENSTOK.get());
    }),

    TASER(0, 140, 2.0F, 0.0F, 15, () -> {
        return Ingredient.fromItems(ModItems.TASER.get());

    }),

    MES(0, 40, 4.0F, 20.0F, 14, () -> {
        return Ingredient.fromItems(ModItems.MES.get());
    }),

    KNUPPEL(0, 40, 4.0F, 20.0F, 14, () -> {
        return Ingredient.fromItems(ModItems.KNUPPEL.get());
    });

    private final int harvestlevel;
    private final int maxUses;
    private final float efficiency;
    private final float attackDamage;
    private final int enchantability;
    private final Supplier<Ingredient> repairMaterial;

    ModItemTier(int harvestlevel, int maxUses, float efficiency, float attackDamage, int enchantability, Supplier<Ingredient> repairMaterial) {
        this.harvestlevel = harvestlevel;
        this.maxUses = maxUses;
        this.efficiency = efficiency;
        this.attackDamage = attackDamage;
        this.enchantability = enchantability;
        this.repairMaterial = repairMaterial;
    }

    @Override
    public int getMaxUses() {
        return maxUses;
    }

    @Override
    public float getEfficiency() {
        return efficiency;
    }

    @Override
    public float getAttackDamage() {
        return attackDamage;
    }

    @Override
    public int getHarvestLevel() {
        return harvestlevel;
    }

    @Override
    public int getEnchantability() {
        return enchantability;
    }

    @Override
    public Ingredient getRepairMaterial() {
        return repairMaterial.get();
    }
}
