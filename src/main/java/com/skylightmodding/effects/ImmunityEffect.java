package com.skylightmodding.effects;

import com.skylightmodding.init.BWStatusEffects;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;

public class ImmunityEffect extends StatusEffect {
    public ImmunityEffect(StatusEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public boolean applyUpdateEffect(LivingEntity entity, int amplifier) {
        if (entity.hasStatusEffect(BWStatusEffects.INFECTION)) {
            entity.removeStatusEffect(BWStatusEffects.INFECTION);
        }

        return true;
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }
}
