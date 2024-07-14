package com.skylightmodding.misc;

import net.minecraft.block.Block;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.TagKey;

import com.skylightmodding.init.BWItems;

import java.util.function.Supplier;

public enum BWToolMaterials implements ToolMaterial {
    OVERLOUD(BlockTags.INCORRECT_FOR_NETHERITE_TOOL, 2314, 20.0f, 2.0f, 18, () -> BWItems.OVERLOUD_INGOT),
    RHODIUM(BlockTags.INCORRECT_FOR_NETHERITE_TOOL, 1583, 8.0f, 2.0f, 16, () -> BWItems.RHODIUM_INGOT);

    private final TagKey<Block> inverseTag;
    private final int itemDurability;
    private final float miningSpeed;
    private final float attackDamage;
    private final int enchantability;
    private final Supplier<Ingredient> repairIngredient;

    private BWToolMaterials(TagKey inverseTag, int itemDurability, float miningSpeed, float attackDamage, int enchantability, Supplier repairIngredient) {
        this.inverseTag = inverseTag;
        this.itemDurability = itemDurability;
        this.miningSpeed = miningSpeed;
        this.attackDamage = attackDamage;
        this.enchantability = enchantability;
        this.repairIngredient = repairIngredient;
    }

    public int getDurability() { return this.itemDurability; }
    public float getMiningSpeedMultiplier() { return this.miningSpeed; }
    public float getAttackDamage() { return this.attackDamage; }
    public TagKey<Block> getInverseTag() { return this.inverseTag; }
    public int getEnchantability() { return this.enchantability; }
    public Ingredient getRepairIngredient() { return this.repairIngredient.get(); }
}
