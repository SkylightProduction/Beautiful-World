package com.skylightmodding.items.components;

import com.skylightmodding.init.BWStatusEffects;

import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffectInstance;

public class BWFoodComponents {
    public static final FoodComponent PITAHAYA = new FoodComponent.Builder().nutrition(4).saturationModifier(4.5f).statusEffect(new StatusEffectInstance(BWStatusEffects.IMMUNITY, 2400, 0), 1.0f).alwaysEdible().build();
}
