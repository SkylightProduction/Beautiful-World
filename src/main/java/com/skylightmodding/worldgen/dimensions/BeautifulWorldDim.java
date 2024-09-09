package com.skylightmodding.worldgen.dimensions;

import com.skylightmodding.BeautifulWorld;

import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionOptions;
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.dimension.DimensionTypes;

import java.util.OptionalLong;

public class BeautifulWorldDim {
    public static final RegistryKey<DimensionOptions> BW_OPTIONS = RegistryKey.of(RegistryKeys.DIMENSION, Identifier.of(BeautifulWorld.MOD_ID, "beautiful_world"));
    public static final RegistryKey<World> BW_WORLD = RegistryKey.of(RegistryKeys.WORLD, Identifier.of(BeautifulWorld.MOD_ID, "beautiful_world"));
    public static final RegistryKey<DimensionType> BW_DIM_TYPE = RegistryKey.of(RegistryKeys.DIMENSION_TYPE, Identifier.of(BeautifulWorld.MOD_ID, "beautiful_world_type"));

    public static void BWType(Registerable<DimensionType> context) {
        context.register(BW_DIM_TYPE, new DimensionType(
                OptionalLong.empty() /*OptionalLong.of(12000)*/ /* fixed time */,
                true,
                false,
                false,
                true,
                1.0,
                false,
                false,
                -64,
                256,
                256,
                BlockTags.INFINIBURN_OVERWORLD /* infinity burn */,
                DimensionTypes.OVERWORLD_ID /* world effect */,
                0.0f,
                new DimensionType.MonsterSettings(false, false, UniformIntProvider.create(0, 7), 0)
        ));
    }
}
