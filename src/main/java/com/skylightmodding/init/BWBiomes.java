package com.skylightmodding.init;

import com.skylightmodding.BeautifulWorld;

import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.Biome;

public class BWBiomes {
    public static final RegistryKey<Biome> INFECTED_FOREST = registerBiome("infected_forest");


    private static RegistryKey<Biome> registerBiome(String name) {
        return RegistryKey.of(RegistryKeys.BIOME,  Identifier.of(BeautifulWorld.MOD_ID, name));
    }

    public static void registerModBiomes() {
        BeautifulWorld.LOGGER.info("Registering Biomes from " + BeautifulWorld.MOD_ID);
    }
}
