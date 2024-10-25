package com.skylightmodding.worldgen;

import com.skylightmodding.BeautifulWorld;

import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.ConfiguredFeature;

public class BWConfiguredFeatures {
    public static final RegistryKey<ConfiguredFeature<?, ?>> PITAHAYA_TREE = registerConfiguredFeature("pitahaya_tree");
    public static final RegistryKey<ConfiguredFeature<?, ?>> INFECTED_OAK = registerConfiguredFeature("infected_oak");
    public static final RegistryKey<ConfiguredFeature<?, ?>> PLACE_INFECTED_OAK = registerConfiguredFeature("place_infected_oak");


    private static RegistryKey<ConfiguredFeature<?, ?>> registerConfiguredFeature(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, Identifier.of(BeautifulWorld.MOD_ID, name));
    }

    public static void registerModConfiguredFeatures() {
        BeautifulWorld.LOGGER.info("Registering Configured Features from " + BeautifulWorld.MOD_ID);
    }
}
