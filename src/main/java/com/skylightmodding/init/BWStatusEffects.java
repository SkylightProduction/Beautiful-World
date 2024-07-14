package com.skylightmodding.init;

import com.skylightmodding.BeautifulWorld;
import com.skylightmodding.effects.ImmunityEffect;
import com.skylightmodding.effects.InfectionEffect;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;

public class BWStatusEffects {
    public static final RegistryEntry<StatusEffect> INFECTION = registerEffect("infection", new InfectionEffect(StatusEffectCategory.HARMFUL, 7561558));
    public static final RegistryEntry<StatusEffect> IMMUNITY = registerEffect("immunity", new ImmunityEffect(StatusEffectCategory.HARMFUL, 13458603));



    private static RegistryEntry<StatusEffect> registerEffect(String name, StatusEffect effect) {
        return Registry.registerReference(Registries.STATUS_EFFECT, new Identifier(BeautifulWorld.MOD_ID, name), effect);
    }

    public static void registerModEffects() {
        BeautifulWorld.LOGGER.info("Registering status effects from " + BeautifulWorld.MOD_ID);
    }
}
