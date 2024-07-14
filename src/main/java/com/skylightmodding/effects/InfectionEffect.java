package com.skylightmodding.effects;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;

public class InfectionEffect extends StatusEffect {
    public InfectionEffect(StatusEffectCategory effectCategory, int color) {
        super(effectCategory, color);
    }

    public boolean applyUpdateEffect(LivingEntity entity, int amplifier) {
        entity.damage(entity.getDamageSources().wither(), 0.5F);
        return true;
    }

    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        int i = 40 >> amplifier;
        if (i > 0) {
            return duration % i == 0;
        } else {
            return true;
        }
    }
}
