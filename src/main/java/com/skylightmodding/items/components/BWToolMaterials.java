package com.skylightmodding.items.components;

import net.minecraft.block.Block;
import net.minecraft.item.Items;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.TagKey;

import com.skylightmodding.init.BWItems;

import java.util.function.Supplier;

public enum BWToolMaterials implements ToolMaterial {
    OVERLOUD(BlockTags.INCORRECT_FOR_NETHERITE_TOOL, 2314, 20.0f, 2.0f, 19, () -> {return Ingredient.ofItems(BWItems.OVERLOUD_INGOT);}),
    RHODIUM(BlockTags.INCORRECT_FOR_NETHERITE_TOOL, 1583, 8.0f, 2.0f, 16, () -> {return Ingredient.ofItems(BWItems.RHODIUM_INGOT);}),
    CRYSTALLITE(BlockTags.INCORRECT_FOR_DIAMOND_TOOL, 864, 7.35f, 2.0f, 10, () -> {return Ingredient.ofItems(BWItems.CRYSTALLITE);}),
    BEGLOV(BlockTags.INCORRECT_FOR_WOODEN_TOOL, 232, 0.1f, 2.0f, 1, () -> {return Ingredient.ofItems(Items.STICK);});
    // () -> {return Ingredient.ofItems(new ItemConvertible[]{Items.STICK});});

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
        this.repairIngredient = repairIngredient; // во тут баг был, из-за которого игра крашилась, ну я его пофиксил крч. Можете спать спокойно.
    }

    public int getDurability() { return this.itemDurability; }
    public float getMiningSpeedMultiplier() { return this.miningSpeed; }
    public float getAttackDamage() { return this.attackDamage; }
    public TagKey<Block> getInverseTag() { return this.inverseTag; }
    public int getEnchantability() { return this.enchantability; }
    public Ingredient getRepairIngredient() { return this.repairIngredient.get(); }
}
