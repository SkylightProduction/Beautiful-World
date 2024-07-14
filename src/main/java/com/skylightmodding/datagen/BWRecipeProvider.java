package com.skylightmodding.datagen;

import com.skylightmodding.init.BWBlocks;
import com.skylightmodding.init.BWItems;
import com.skylightmodding.misc.BWTags;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;

import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class BWRecipeProvider extends FabricRecipeProvider {
    public BWRecipeProvider(FabricDataOutput generator, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(generator, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter exporter) {
        // overloud
        axeItemRecipe(exporter, "overloud_axe", BWItems.OVERLOUD_AXE, Items.NETHERITE_INGOT, BWItems.OVERLOUD_INGOT);
        swordItemRecipe(exporter, "overloud_sword", BWItems.OVERLOUD_SWORD, Items.NETHERITE_INGOT, BWItems.OVERLOUD_INGOT);
        pickaxeItemRecipe(exporter, "overloud_pickaxe", BWItems.OVERLOUD_PICKAXE, Items.NETHERITE_INGOT, BWItems.OVERLOUD_INGOT);
        hoeItemRecipe(exporter, "overloud_hoe", BWItems.OVERLOUD_HOE, Items.NETHERITE_INGOT, BWItems.OVERLOUD_INGOT);
        shovelItemRecipe(exporter, "overloud_showel", BWItems.OVERLOUD_SHOVEL, Items.NETHERITE_INGOT, BWItems.OVERLOUD_INGOT);
        block3x3Recipe(exporter, "overloud_block", RecipeCategory.MISC, BWBlocks.OVERLOUD_BLOCK, BWItems.OVERLOUD_INGOT);
        itemFromBlock(exporter, "overloud_from_block", RecipeCategory.MISC, BWItems.OVERLOUD_INGOT, BWBlocks.OVERLOUD_BLOCK);
        offerBlasting(exporter, List.of(BWItems.RAW_OVERLOUD, BWBlocks.OVERLOUD_ORE), RecipeCategory.MISC, BWItems.OVERLOUD_INGOT, 0.7f, 150, "overloud_ingot");
        offerSmelting(exporter, List.of(BWItems.RAW_OVERLOUD, BWBlocks.OVERLOUD_ORE), RecipeCategory.MISC, BWItems.OVERLOUD_INGOT, 0.7f, 300, "overloud_ingot");
        block3x3Recipe(exporter, "raw_overloud_block", RecipeCategory.MISC, BWBlocks.RAW_OVERLOUD_BLOCK, BWItems.RAW_OVERLOUD);
        itemFromBlock(exporter, "raw_overloud_from_block", RecipeCategory.MISC, BWItems.RAW_OVERLOUD, BWBlocks.RAW_OVERLOUD_BLOCK);

        // pitahaya
        offerPlanksRecipe(exporter, BWBlocks.PITAHAYA_TREE_PLANKS, BWTags.Items.PITAHAYA_TREE_LOGS, 4);
        offerSlabRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BWBlocks.PITAHAYA_TREE_SLAB, BWBlocks.PITAHAYA_TREE_PLANKS);
        offerPressurePlateRecipe(exporter, BWBlocks.PITAHAYA_TREE_PRESSURE_PLATE, BWBlocks.PITAHAYA_TREE_PLANKS);
        fenceGateBlockRecipe(exporter, "pitahaya_tree_fance_gate", RecipeCategory.BUILDING_BLOCKS, BWBlocks.PITAHAYA_TREE_FENCE_GATE, Items.STICK, BWBlocks.PITAHAYA_TREE_PLANKS);
        fenceBlockRecipe(exporter, "pitahaya_tree_fance", RecipeCategory.BUILDING_BLOCKS, BWBlocks.PITAHAYA_TREE_FENCE, Items.STICK, BWBlocks.PITAHAYA_TREE_PLANKS);
        stairsBlockRecipe(exporter, "pitahaya_tree_stairs", RecipeCategory.BUILDING_BLOCKS, BWBlocks.PITAHAYA_TREE_STAIRS, BWBlocks.PITAHAYA_TREE_PLANKS);
        itemFromBlock(exporter, "pitahaya_tree_button", RecipeCategory.REDSTONE, BWBlocks.PITAHAYA_TREE_BUTTON, BWBlocks.PITAHAYA_TREE_PLANKS);
        doorRecipe(exporter, "pitahaya_tree_door", RecipeCategory.BUILDING_BLOCKS, BWBlocks.PITAHAYA_TREE_DOOR, BWBlocks.PITAHAYA_TREE_PLANKS);
        trapdoorRecipe(exporter, "pitahaya_tree_trapdoor", RecipeCategory.BUILDING_BLOCKS, BWBlocks.PITAHAYA_TREE_TRAPDOOR, BWBlocks.PITAHAYA_TREE_PLANKS);

        // rhodium
        block3x3Recipe(exporter, "rhodium_block", RecipeCategory.MISC, BWBlocks.RHODIUM_BLOCK, BWItems.RHODIUM_INGOT);
        itemFromBlock(exporter, "rhodium_ingot_from_block", RecipeCategory.MISC, BWItems.RHODIUM_INGOT, BWBlocks.RHODIUM_BLOCK);
        offerBlasting(exporter, List.of(BWBlocks.RHODIUM_ORE), RecipeCategory.MISC, BWItems.RHODIUM_INGOT, 0.7f, 150, "rhodium_ingot");
        offerSmelting(exporter, List.of(BWBlocks.RHODIUM_ORE), RecipeCategory.MISC, BWItems.RHODIUM_INGOT, 0.7f, 300, "rhodium_ingot");
    }


    private void trapdoorRecipe(RecipeExporter exporter, String recipeName, RecipeCategory recipeCategory, Item result, Item material) {
        ShapedRecipeJsonBuilder.create(recipeCategory, result, 2)
                .pattern("@@@")
                .pattern("@@@")
                .input('@', material)
                .criterion(FabricRecipeProvider.hasItem(material), FabricRecipeProvider.conditionsFromItem(material))
                .offerTo(exporter, recipeName);
    }

    private void doorRecipe(RecipeExporter exporter, String recipeName, RecipeCategory recipeCategory, Item result, Item material) {
        ShapedRecipeJsonBuilder.create(recipeCategory, result, 3)
                .pattern("@@ ")
                .pattern("@@ ")
                .pattern("@@ ")
                .input('@', material)
                .criterion(FabricRecipeProvider.hasItem(material), FabricRecipeProvider.conditionsFromItem(material))
                .offerTo(exporter, recipeName);
    }

    private void fenceGateBlockRecipe(RecipeExporter exporter, String recipeName, RecipeCategory recipeCategory, Item result, Item stick, Item material) {
        ShapedRecipeJsonBuilder.create(recipeCategory, result, 1)
                .pattern("@#@")
                .pattern("@#@")
                .input('#', material)
                .input('@', stick)
                .criterion(FabricRecipeProvider.hasItem(stick), FabricRecipeProvider.conditionsFromItem(stick))
                .criterion(FabricRecipeProvider.hasItem(material), FabricRecipeProvider.conditionsFromItem(material))
                .offerTo(exporter, recipeName);
    }

    private void fenceBlockRecipe(RecipeExporter exporter, String recipeName, RecipeCategory recipeCategory, Item result, Item stick, Item material) {
        ShapedRecipeJsonBuilder.create(recipeCategory, result, 3)
                .pattern("#@#")
                .pattern("#@#")
                .input('#', material)
                .input('@', stick)
                .criterion(FabricRecipeProvider.hasItem(stick), FabricRecipeProvider.conditionsFromItem(stick))
                .criterion(FabricRecipeProvider.hasItem(material), FabricRecipeProvider.conditionsFromItem(material))
                .offerTo(exporter, recipeName);
    }

    private void stairsBlockRecipe(RecipeExporter exporter, String recipeName, RecipeCategory recipeCategory, Item result, Item material) {
        ShapedRecipeJsonBuilder.create(recipeCategory, result, 3)
                .pattern("#  ")
                .pattern("## ")
                .pattern("###")
                .input('#', material)
                .criterion(FabricRecipeProvider.hasItem(material), FabricRecipeProvider.conditionsFromItem(material))
                .offerTo(exporter, recipeName);
    }

    private void axeItemRecipe(RecipeExporter exporter, String recipeName, Item result, Item stickItem, Item material) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, result, 1)
                .pattern(" @@")
                .pattern(" #@")
                .pattern(" # ")
                .input('#', stickItem)
                .input('@', material)
                .criterion(FabricRecipeProvider.hasItem(stickItem), FabricRecipeProvider.conditionsFromItem(stickItem))
                .criterion(FabricRecipeProvider.hasItem(material), FabricRecipeProvider.conditionsFromItem(material))
                .offerTo(exporter, recipeName);
    }

    private void swordItemRecipe(RecipeExporter exporter, String recipeName, Item result, Item stickItem, Item material) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, result, 1)
                .pattern(" @ ")
                .pattern(" @ ")
                .pattern(" # ")
                .input('#', stickItem)
                .input('@', material)
                .criterion(FabricRecipeProvider.hasItem(stickItem), FabricRecipeProvider.conditionsFromItem(stickItem))
                .criterion(FabricRecipeProvider.hasItem(material), FabricRecipeProvider.conditionsFromItem(material))
                .offerTo(exporter, recipeName);
    }

    private void pickaxeItemRecipe(RecipeExporter exporter, String recipeName, Item result, Item stickItem, Item material) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, result, 1)
                .pattern("@@@")
                .pattern(" # ")
                .pattern(" # ")
                .input('#', stickItem)
                .input('@', material)
                .criterion(FabricRecipeProvider.hasItem(stickItem), FabricRecipeProvider.conditionsFromItem(stickItem))
                .criterion(FabricRecipeProvider.hasItem(material), FabricRecipeProvider.conditionsFromItem(material))
                .offerTo(exporter, recipeName);
    }

    private void hoeItemRecipe(RecipeExporter exporter, String recipeName, Item result, Item stickItem, Item material) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, result, 1)
                .pattern(" @@")
                .pattern(" # ")
                .pattern(" # ")
                .input('#', stickItem)
                .input('@', material)
                .criterion(FabricRecipeProvider.hasItem(stickItem), FabricRecipeProvider.conditionsFromItem(stickItem))
                .criterion(FabricRecipeProvider.hasItem(material), FabricRecipeProvider.conditionsFromItem(material))
                .offerTo(exporter, recipeName);
    }

    private void shovelItemRecipe(RecipeExporter exporter, String recipeName, Item result, Item stickItem, Item material) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, result, 1)
                .pattern(" @ ")
                .pattern(" # ")
                .pattern(" # ")
                .input('#', stickItem)
                .input('@', material)
                .criterion(FabricRecipeProvider.hasItem(stickItem), FabricRecipeProvider.conditionsFromItem(stickItem))
                .criterion(FabricRecipeProvider.hasItem(material), FabricRecipeProvider.conditionsFromItem(material))
                .offerTo(exporter, recipeName);
    }

    private void block3x3Recipe(RecipeExporter exporter, String recipeName, RecipeCategory recipeCategory, Item result, Item material) {
        ShapedRecipeJsonBuilder.create(recipeCategory, result, 1)
                .pattern("@@@")
                .pattern("@@@")
                .pattern("@@@")
                .input('@', material)
                .criterion(FabricRecipeProvider.hasItem(material), FabricRecipeProvider.conditionsFromItem(material))
                .offerTo(exporter, recipeName);
    }

    private void itemFromBlock(RecipeExporter exporter, String recipeName, RecipeCategory recipeCategory, Item result, Item material) {
        ShapelessRecipeJsonBuilder.create(recipeCategory, result, 9)
                .input(material)
                .criterion(FabricRecipeProvider.hasItem(material), FabricRecipeProvider.conditionsFromItem(material))
                .offerTo(exporter, recipeName);
    }
}
