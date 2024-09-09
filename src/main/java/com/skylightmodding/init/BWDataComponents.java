package com.skylightmodding.init;

import com.mojang.serialization.Codec;

import net.minecraft.component.ComponentType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import com.skylightmodding.BeautifulWorld;

public class BWDataComponents {
    public static final ComponentType<Integer> AMULET_OF_CREATION_STAGE = registerIntComponent("amulet_of_creation_stage");

    private static ComponentType<Integer> registerIntComponent(String name) {
        return Registry.register(Registries.DATA_COMPONENT_TYPE, Identifier.of(BeautifulWorld.MOD_ID, name), ComponentType.<Integer>builder().codec(Codec.INT).build());
    }

    public static void registerModDC() {
        BeautifulWorld.LOGGER.info("Registering data components from "+BeautifulWorld.MOD_ID);
    }
}
