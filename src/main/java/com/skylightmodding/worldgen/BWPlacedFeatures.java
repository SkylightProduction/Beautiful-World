package com.skylightmodding.worldgen;

import com.skylightmodding.BeautifulWorld;
import com.skylightmodding.misc.BWTags;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;

import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.PlacedFeature;

public class BWPlacedFeatures {
    public static final RegistryKey<PlacedFeature> RHODIUM_ORE_FEATURE = registerPlacedFeature("rhodium_ore");
    public static final RegistryKey<PlacedFeature> OVERLOUD_ORE_FEATURE = registerPlacedFeature("overloud_ore");
    public static final RegistryKey<PlacedFeature> PITAHAYA_TREE_PLACED_FEATURE = registerPlacedFeature("pitahaya_tree");
    public static final RegistryKey<PlacedFeature> INFECTED_OAK_PLACED_FEATURE = registerPlacedFeature("infected_oak");
    public static final RegistryKey<PlacedFeature> PLACE_INFECTED_OAK = registerPlacedFeature("place_infected_oak");


    private static RegistryKey<PlacedFeature> registerPlacedFeature(String name) {
        return RegistryKey.of(RegistryKeys.PLACED_FEATURE, Identifier.of(BeautifulWorld.MOD_ID, name));
    }

    private static void addPlacedFeatureToBiome() {
        BiomeModifications.addFeature(BiomeSelectors.tag(BWTags.Biomes.RHODIUM_ORE_GEN_BIOMES), GenerationStep.Feature.UNDERGROUND_ORES, RHODIUM_ORE_FEATURE);
        BiomeModifications.addFeature(BiomeSelectors.tag(BWTags.Biomes.OVERLOUD_ORE_GEN_BIOMES), GenerationStep.Feature.UNDERGROUND_ORES, OVERLOUD_ORE_FEATURE);
    }

    public static void registerModPlacedFeatures() {
        addPlacedFeatureToBiome();
        BeautifulWorld.LOGGER.info("Registering Placed Features from " + BeautifulWorld.MOD_ID);
    }
}
