package com.skylightmodding.init;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;

import java.util.Map;

public class BWHashMaps {
    /* данный хеш мап нельзя перенести в класс InfectedBlock потому что будет происходить цикл импорта и игра вообще не будет запускаться */
    public static final Map<Block, BlockState> INFECTED_BLOCKS = Maps.newHashMap(
            new ImmutableMap.Builder()
                    .put(Blocks.DIRT, BWBlocks.INFECTED_DIRT.getBlock().getDefaultState())
                    .put(Blocks.GRASS_BLOCK, BWBlocks.INFECTED_GRASS.getBlock().getDefaultState())
                    .put(Blocks.SAND, BWBlocks.INFECTED_SAND.getBlock().getDefaultState())
                    .put(Blocks.SANDSTONE, BWBlocks.INFECTED_SANDSTONE.getBlock().getDefaultState())
                    .put(Blocks.CLAY, BWBlocks.INFECTED_CLAY.getBlock().getDefaultState())
                    .put(Blocks.STONE, BWBlocks.INFECTED_STONE.getBlock().getDefaultState())
                    .put(Blocks.COBBLESTONE, BWBlocks.INFECTED_COBBLESTONE.getBlock().getDefaultState())
                    .build()
    );
}
