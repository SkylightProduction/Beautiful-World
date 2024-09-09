package com.skylightmodding.datagen;

import com.skylightmodding.init.BWBlocks;
import com.skylightmodding.init.BWItems;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;

import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.minecraft.item.ArmorItem;

public class BWModelsProvider extends FabricModelProvider {
    public BWModelsProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        // pitahaya
        BlockStateModelGenerator.BlockTexturePool pitahayaTree = blockStateModelGenerator.registerCubeAllModelTexturePool(BWBlocks.PITAHAYA_TREE_PLANKS.getBlock());
        pitahayaTree.slab(BWBlocks.PITAHAYA_TREE_SLAB.getBlock());
        pitahayaTree.fence(BWBlocks.PITAHAYA_TREE_FENCE.getBlock());
        pitahayaTree.button(BWBlocks.PITAHAYA_TREE_BUTTON.getBlock());
        pitahayaTree.stairs(BWBlocks.PITAHAYA_TREE_STAIRS.getBlock());
        pitahayaTree.fenceGate(BWBlocks.PITAHAYA_TREE_FENCE_GATE.getBlock());
        pitahayaTree.pressurePlate(BWBlocks.PITAHAYA_TREE_PRESSURE_PLATE.getBlock());
        blockStateModelGenerator.registerDoor(BWBlocks.PITAHAYA_TREE_DOOR.getBlock());
        blockStateModelGenerator.registerTrapdoor(BWBlocks.PITAHAYA_TREE_TRAPDOOR.getBlock());
        blockStateModelGenerator.registerLog(BWBlocks.PITAHAYA_TREE_LOG.getBlock())
                .log(BWBlocks.PITAHAYA_TREE_LOG.getBlock())
                .wood(BWBlocks.PITAHAYA_TREE_WOOD.getBlock());
        blockStateModelGenerator.registerLog(BWBlocks.STRIPPED_PITAHAYA_TREE_LOG.getBlock())
                .log(BWBlocks.STRIPPED_PITAHAYA_TREE_LOG.getBlock())
                .wood(BWBlocks.STRIPPED_PITAHAYA_TREE_WOOD.getBlock());
        blockStateModelGenerator.registerSimpleCubeAll(BWBlocks.PITAHAYA_TREE_LEAVES.getBlock());
        blockStateModelGenerator.registerSimpleCubeAll(BWBlocks.FRUITFUL_PITAHAYA_TREE_LEAVES.getBlock());

        // overloud
        blockStateModelGenerator.registerCubeAllModelTexturePool(BWBlocks.OVERLOUD_BLOCK.getBlock());
        blockStateModelGenerator.registerCubeAllModelTexturePool(BWBlocks.OVERLOUD_ORE.getBlock());
        blockStateModelGenerator.registerCubeAllModelTexturePool(BWBlocks.RAW_OVERLOUD_BLOCK.getBlock());

        // rhodium
        blockStateModelGenerator.registerCubeAllModelTexturePool(BWBlocks.RHODIUM_BLOCK.getBlock());
        blockStateModelGenerator.registerCubeAllModelTexturePool(BWBlocks.RHODIUM_ORE.getBlock());
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        // overloud
        itemModelGenerator.register(BWItems.OVERLOUD_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(BWItems.OVERLOUD_AXE, Models.HANDHELD);
        itemModelGenerator.register(BWItems.OVERLOUD_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(BWItems.OVERLOUD_SWORD, Models.HANDHELD);
        itemModelGenerator.register(BWItems.OVERLOUD_HOE, Models.HANDHELD);
        itemModelGenerator.register(BWItems.OVERLOUD_INGOT, Models.GENERATED);
        itemModelGenerator.register(BWItems.RAW_OVERLOUD, Models.GENERATED);
        itemModelGenerator.register(BWItems.OVERLOUD_UPGRADE_SMITHING_TEMPLATE, Models.GENERATED);
        itemModelGenerator.registerArmor((ArmorItem) BWItems.OVERLOUD_HELMET);
        itemModelGenerator.registerArmor((ArmorItem) BWItems.OVERLOUD_CHESTPLATE);
        itemModelGenerator.registerArmor((ArmorItem) BWItems.OVERLOUD_LEGGINGS);
        itemModelGenerator.registerArmor((ArmorItem) BWItems.OVERLOUD_BOOTS);

        // rhodium
        itemModelGenerator.register(BWItems.RHODIUM_SWORD, Models.HANDHELD);
        itemModelGenerator.register(BWItems.RHODIUM_MULTITOOL, Models.HANDHELD);
        itemModelGenerator.register(BWItems.RHODIUM_INGOT, Models.GENERATED);

        // crystallite
        itemModelGenerator.register(BWItems.CRYSTALLITE_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(BWItems.CRYSTALLITE_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(BWItems.CRYSTALLITE_AXE, Models.HANDHELD);

        // korg
        itemModelGenerator.register(BWItems.KORG_FRAGMENT, Models.GENERATED);

        // other
        itemModelGenerator.register(BWItems.NETHERITE_MULTI_TOOL, Models.HANDHELD);
        itemModelGenerator.register(BWItems.PITAHAYA, Models.GENERATED);
        itemModelGenerator.register(BWItems.CRYSTALLITE, Models.GENERATED);
        itemModelGenerator.register(BWItems.BAIKAL_WATER, Models.GENERATED);
    }
}
