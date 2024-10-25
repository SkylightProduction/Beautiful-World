package com.skylightmodding.init;

import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffectInstance;

public class BWFoodComponents {
    public static final FoodComponent PITAHAYA = new FoodComponent.Builder().nutrition(4).saturationModifier(4.5f).statusEffect(new StatusEffectInstance(BWStatusEffects.IMMUNITY, 2400, 0, true, true), 1.0f).alwaysEdible().build();
}
