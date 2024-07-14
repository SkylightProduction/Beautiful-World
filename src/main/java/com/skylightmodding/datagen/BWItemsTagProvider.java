package com.skylightmodding.datagen;

import com.skylightmodding.init.BWBlocks;
import com.skylightmodding.init.BWItems;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;

import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;

import java.util.concurrent.CompletableFuture;

public class BWItemsTagProvider extends FabricTagProvider.ItemTagProvider {
    public BWItemsTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        getOrCreateTagBuilder(ItemTags.PLANKS)
                .add(BWBlocks.PITAHAYA_TREE_PLANKS)
        ;

        getOrCreateTagBuilder(ItemTags.BUTTONS)
                .add(BWBlocks.PITAHAYA_TREE_BUTTON)
        ;

        getOrCreateTagBuilder(ItemTags.LOGS)
                .add(BWBlocks.PITAHAYA_TREE_LOG)
                .add(BWBlocks.STRIPPED_PITAHAYA_TREE_LOG)
                .add(BWBlocks.PITAHAYA_TREE_WOOD)
                .add(BWBlocks.STRIPPED_PITAHAYA_TREE_WOOD)
        ;

        getOrCreateTagBuilder(ItemTags.LEAVES)
                .add(BWBlocks.PITAHAYA_TREE_LEAVES)
                .add(BWBlocks.FRUITFUL_PITAHAYA_TREE_LEAVES)
        ;

        getOrCreateTagBuilder(ItemTags.FOOT_ARMOR)
                .add(BWItems.OVERLOUD_BOOTS)
        ;

        getOrCreateTagBuilder(ItemTags.HEAD_ARMOR)
                .add(BWItems.OVERLOUD_HELMET)
        ;

        getOrCreateTagBuilder(ItemTags.LEG_ARMOR)
                .add(BWItems.OVERLOUD_LEGGINGS)
        ;

        getOrCreateTagBuilder(ItemTags.CHEST_ARMOR)
                .add(BWItems.OVERLOUD_CHESTPLATE)
        ;
    }
}
