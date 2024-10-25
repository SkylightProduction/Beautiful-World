package com.skylightmodding;

import com.skylightmodding.init.*;
import com.skylightmodding.worldgen.BWConfiguredFeatures;
import com.skylightmodding.worldgen.BWPlacedFeatures;
import com.skylightmodding.worldgen.tree.BWTreesHell;
import com.skylightmodding.worldgen.dimensions.BeautifulWorldDimension;

import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BeautifulWorld implements ModInitializer {
	public static final String MOD_ID = "beautifulworld";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		BWItems.registerModItems();
		BWBlocks.registerModBlocks();
		BWStatusEffects.registerModEffects();
		BWPlacedFeatures.registerModPlacedFeatures();
		BWConfiguredFeatures.registerModConfiguredFeatures();
		BWTreesHell.registerTreesHell();
		BWDataComponents.registerModDC();
		BWItemGroups.registerItemsGroups();
		BWBiomes.registerModBiomes();
		BeautifulWorldDimension.registerPortal();
	}
}
