package com.skylightmodding.worldgen.dimensions;

import com.skylightmodding.BeautifulWorld;
import com.skylightmodding.init.BWBlocks;
import com.skylightmodding.init.BWItems;

import net.kyrptonaught.customportalapi.api.CustomPortalBuilder;

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

public class BeautifulWorldDimension {
    public static final RegistryKey<DimensionOptions> BW_OPTIONS = RegistryKey.of(RegistryKeys.DIMENSION, Identifier.of(BeautifulWorld.MOD_ID, "beautiful_world"));
    public static final RegistryKey<World> BW_WORLD = RegistryKey.of(RegistryKeys.WORLD, Identifier.of(BeautifulWorld.MOD_ID, "beautiful_world"));
    public static final RegistryKey<DimensionType> BW_DIM_TYPE = RegistryKey.of(RegistryKeys.DIMENSION_TYPE, Identifier.of(BeautifulWorld.MOD_ID, "beautiful_world_type"));

    public static void BWType(Registerable<DimensionType> context) {
        context.register(BW_DIM_TYPE, new DimensionType(
                OptionalLong.empty() /* fixed time */    /*OptionalLong.of(12000)*/,
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

    public static void registerPortal() {
        CustomPortalBuilder.beginPortal()
                .frameBlock(BWBlocks.FORTIFIED_CRYING_OBSIDIAN.getBlock())
                .destDimID(Identifier.of(BeautifulWorld.MOD_ID, "beautiful_world"))
                .customPortalBlock(BWBlocks.BW_PORTAL_BLOCK)
                .lightWithItem(BWItems.AMULET_OF_CREATION)  // todo: сделать так, чтобы для активации использовался AMULET_OF_CREATION с AMULET_OF_CREATION_STAGE == 2.
                /*
                Ооо бля, я придумал как эту проблему (из to_do выше) решить можно. Надо сделать миксин метода `lightWithItem`, туда просто запихать проверку: является ли
                предмет AMULET_OF_CREATION и == ли его дата компонент `amulet_of_creation_stage` двум, если да, то активировать портал, иначе fuck you leather man.
                Только я ваще хз будет ли это работать. Если нет, то наверно придется самому с нуля переписывать CustomPortalAPI. Кароч, попробую как-нибудь.

                upd. Мне кажется идея полная дичь.
                */
                .registerPortal();
    }
}
