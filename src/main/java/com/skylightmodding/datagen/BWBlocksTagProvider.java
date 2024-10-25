package com.skylightmodding.datagen;

import com.skylightmodding.init.BWBlocks;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;

import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.ItemTags;

import java.util.concurrent.CompletableFuture;

public class BWBlocksTagProvider extends FabricTagProvider.BlockTagProvider {
    public BWBlocksTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        getOrCreateTagBuilder(BlockTags.LEAVES)
                .add(BWBlocks.PITAHAYA_TREE_LEAVES.getBlock())
        ;

        getOrCreateTagBuilder(BlockTags.PLANKS)
                .add(BWBlocks.PITAHAYA_TREE_PLANKS.getBlock())
        ;

        getOrCreateTagBuilder(BlockTags.BUTTONS)
                .add(BWBlocks.PITAHAYA_TREE_BUTTON.getBlock())
        ;

        getOrCreateTagBuilder(BlockTags.LOGS)
                .add(BWBlocks.PITAHAYA_TREE_LOG.getBlock())
                .add(BWBlocks.STRIPPED_PITAHAYA_TREE_LOG.getBlock())
                .add(BWBlocks.PITAHAYA_TREE_WOOD.getBlock())
                .add(BWBlocks.STRIPPED_PITAHAYA_TREE_WOOD.getBlock())
        ;

        getOrCreateTagBuilder(BlockTags.LOGS_THAT_BURN)
                .add(BWBlocks.PITAHAYA_TREE_LOG.getBlock())
                .add(BWBlocks.STRIPPED_PITAHAYA_TREE_LOG.getBlock())
                .add(BWBlocks.PITAHAYA_TREE_WOOD.getBlock())
                .add(BWBlocks.STRIPPED_PITAHAYA_TREE_WOOD.getBlock())
        ;

        getOrCreateTagBuilder(BlockTags.FENCES)
                .add(BWBlocks.PITAHAYA_TREE_FENCE.getBlock())
        ;

        getOrCreateTagBuilder(BlockTags.FENCE_GATES)
                .add(BWBlocks.PITAHAYA_TREE_FENCE_GATE.getBlock())
        ;

        getOrCreateTagBuilder(BlockTags.WOODEN_FENCES)
                .add(BWBlocks.PITAHAYA_TREE_FENCE.getBlock())
        ;

        getOrCreateTagBuilder(BlockTags.WOODEN_DOORS)
                .add(BWBlocks.PITAHAYA_TREE_DOOR.getBlock())
        ;

        getOrCreateTagBuilder(BlockTags.DOORS)
                .add(BWBlocks.PITAHAYA_TREE_DOOR.getBlock())
        ;

        getOrCreateTagBuilder(BlockTags.WOODEN_STAIRS)
                .add(BWBlocks.PITAHAYA_TREE_STAIRS.getBlock())
        ;

        getOrCreateTagBuilder(BlockTags.STAIRS)
                .add(BWBlocks.PITAHAYA_TREE_STAIRS.getBlock())
        ;

        getOrCreateTagBuilder(BlockTags.WOODEN_TRAPDOORS)
                .add(BWBlocks.PITAHAYA_TREE_TRAPDOOR.getBlock())
        ;

        getOrCreateTagBuilder(BlockTags.TRAPDOORS)
                .add(BWBlocks.PITAHAYA_TREE_TRAPDOOR.getBlock())
        ;

        getOrCreateTagBuilder(BlockTags.NEEDS_DIAMOND_TOOL)
        ;

        getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL)
        ;

        getOrCreateTagBuilder(BlockTags.NEEDS_STONE_TOOL)
        ;

        getOrCreateTagBuilder(BlockTags.AXE_MINEABLE)
                .add(BWBlocks.PITAHAYA_TREE_PLANKS.getBlock())
                .add(BWBlocks.PITAHAYA_TREE_BUTTON.getBlock())
                .add(BWBlocks.PITAHAYA_TREE_DOOR.getBlock())
                .add(BWBlocks.PITAHAYA_TREE_TRAPDOOR.getBlock())
                .add(BWBlocks.PITAHAYA_TREE_SLAB.getBlock())
                .add(BWBlocks.PITAHAYA_TREE_PRESSURE_PLATE.getBlock())
                .add(BWBlocks.PITAHAYA_TREE_STAIRS.getBlock())
                .add(BWBlocks.PITAHAYA_TREE_FENCE.getBlock())
                .add(BWBlocks.PITAHAYA_TREE_FENCE_GATE.getBlock())
                .add(BWBlocks.PITAHAYA_TREE_WOOD.getBlock())
                .add(BWBlocks.STRIPPED_PITAHAYA_TREE_WOOD.getBlock())
                .add(BWBlocks.PITAHAYA_TREE_LOG.getBlock())
                .add(BWBlocks.STRIPPED_PITAHAYA_TREE_LOG.getBlock())
        ;

        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(BWBlocks.OVERLOUD_BLOCK.getBlock())
                .add(BWBlocks.OVERLOUD_ORE.getBlock())
                .add(BWBlocks.RAW_OVERLOUD_BLOCK.getBlock())
                .add(BWBlocks.RHODIUM_BLOCK.getBlock())
                .add(BWBlocks.RHODIUM_ORE.getBlock())
        ;

        getOrCreateTagBuilder(BlockTags.SHOVEL_MINEABLE)
        ;

        getOrCreateTagBuilder(BlockTags.HOE_MINEABLE)
                .add(BWBlocks.PITAHAYA_TREE_LEAVES.getBlock())
        ;

        getOrCreateTagBuilder(BlockTags.DIRT)
                .add(BWBlocks.INFECTED_DIRT.getBlock())
                .add(BWBlocks.INFECTED_GRASS.getBlock())
        ;
    }
}
