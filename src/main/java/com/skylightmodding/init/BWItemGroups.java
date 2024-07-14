package com.skylightmodding.init;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;

public class BWItemGroups {
    public static final ItemGroup ITEMS_TAB = FabricItemGroup.builder()
            .icon(() -> new ItemStack(BWItems.RAW_OVERLOUD))
            .displayName(Text.translatable("itemGroup.beautifulworld.items"))
            .entries((context, entries) -> {
                entries.add(BWItems.CRYSTALLITE);
                entries.add(BWItems.RHODIUM_INGOT);
                entries.add(BWItems.OVERLOUD_INGOT);
                entries.add(BWItems.RAW_OVERLOUD);
                entries.add(BWItems.KORG_FRAGMENT);
                entries.add(BWItems.BAIKAL_WATER);
                entries.add(BWItems.PITAHAYA);
                entries.add(BWItems.AMULET_OF_CREATION);
            }).build();


    public static final ItemGroup BLOCKS_TAB = FabricItemGroup.builder()
            .icon(() -> new ItemStack(BWBlocks.INFECTED_DIRT))
            .displayName(Text.translatable("itemGroup.beautifulworld.blocks"))
            .entries((context, entries) -> {
                entries.add(BWBlocks.INFECTED_DIRT);
                entries.add(BWBlocks.INFECTED_CLAY);
                entries.add(BWBlocks.INFECTED_SAND);
                entries.add(BWBlocks.INFECTED_STONE);
                entries.add(BWBlocks.INFECTED_COBBLESTONE);
                entries.add(BWBlocks.OVERLOUD_ORE);
                entries.add(BWBlocks.OVERLOUD_BLOCK);
                entries.add(BWBlocks.RAW_OVERLOUD_BLOCK);
                entries.add(BWBlocks.RHODIUM_ORE);
                entries.add(BWBlocks.RHODIUM_BLOCK);
                entries.add(BWBlocks.PITAHAYA_TREE_PLANKS);
                entries.add(BWBlocks.PITAHAYA_TREE_STAIRS);
                entries.add(BWBlocks.PITAHAYA_TREE_SLAB);
                entries.add(BWBlocks.PITAHAYA_TREE_DOOR);
                entries.add(BWBlocks.PITAHAYA_TREE_TRAPDOOR);
                entries.add(BWBlocks.PITAHAYA_TREE_PRESSURE_PLATE);
                entries.add(BWBlocks.PITAHAYA_TREE_FENCE);
                entries.add(BWBlocks.PITAHAYA_TREE_FENCE_GATE);
                entries.add(BWBlocks.PITAHAYA_TREE_BUTTON);
                entries.add(BWBlocks.PITAHAYA_TREE_LOG);
                entries.add(BWBlocks.STRIPPED_PITAHAYA_TREE_LOG);
                entries.add(BWBlocks.PITAHAYA_TREE_WOOD);
                entries.add(BWBlocks.STRIPPED_PITAHAYA_TREE_WOOD);
                entries.add(BWBlocks.PITAHAYA_TREE_LEAVES);
                entries.add(BWBlocks.FRUITFUL_PITAHAYA_TREE_LEAVES);
                entries.add(BWBlocks.FORTIFIED_CRYING_OBSIDIAN);
            }).build();


    public static final ItemGroup EQUIPMENT_TAB = FabricItemGroup.builder()
            .icon(() -> new ItemStack(BWItems.RHODIUM_SWORD))
            .displayName(Text.translatable("itemGroup.beautifulworld.equipment"))
            .entries((context, entries) -> {
                entries.add(BWItems.OVERLOUD_HELMET);
                entries.add(BWItems.OVERLOUD_CHESTPLATE);
                entries.add(BWItems.OVERLOUD_LEGGINGS);
                entries.add(BWItems.OVERLOUD_BOOTS);
                entries.add(BWItems.OVERLOUD_SWORD);
                entries.add(BWItems.OVERLOUD_PICKAXE);
                entries.add(BWItems.OVERLOUD_AXE);
                entries.add(BWItems.OVERLOUD_SHOVEL);
                entries.add(BWItems.OVERLOUD_HOE);
                entries.add(BWItems.RHODIUM_SWORD);
                entries.add(BWItems.RHODIUM_MULTITOOL);
                entries.add(BWItems.NETHERITE_MULTI_TOOL);
            }).build();
}
