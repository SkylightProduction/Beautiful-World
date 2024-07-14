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

public class BWFeatures {
    public static final RegistryKey<PlacedFeature> RHODIUM_ORE_FEATURE = RegistryKey.of(RegistryKeys.PLACED_FEATURE, new Identifier(BeautifulWorld.MOD_ID, "rhodium_ore"));
    public static final RegistryKey<PlacedFeature> OVERLOUD_ORE_FEATURE = RegistryKey.of(RegistryKeys.PLACED_FEATURE, new Identifier(BeautifulWorld.MOD_ID, "overloud_ore"));

    public static void placedFeatureReg() {
        BiomeModifications.addFeature(BiomeSelectors.foundInTheNether(), GenerationStep.Feature.UNDERGROUND_ORES, RHODIUM_ORE_FEATURE);
        BiomeModifications.addFeature(BiomeSelectors.tag(BWTags.Biomes.OVERLOUD_ORE_GEN_BIOMES), GenerationStep.Feature.UNDERGROUND_ORES, OVERLOUD_ORE_FEATURE);
    }
}
