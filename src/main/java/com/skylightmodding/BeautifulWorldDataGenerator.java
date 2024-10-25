package com.skylightmodding;

import com.skylightmodding.datagen.*;
import com.skylightmodding.worldgen.dimensions.BeautifulWorldDimension;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

import net.minecraft.registry.RegistryBuilder;
import net.minecraft.registry.RegistryKeys;

public class BeautifulWorldDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

		pack.addProvider(BWModelsProvider::new);
		pack.addProvider(BWWorldGen::new);
		pack.addProvider(BWRecipeProvider::new);
		pack.addProvider(BWItemsTagProvider::new);
		pack.addProvider(BWBlocksTagProvider::new);
	}

	@Override
	public void buildRegistry(RegistryBuilder registryBuilder) {
		registryBuilder.addRegistry(RegistryKeys.DIMENSION_TYPE, BeautifulWorldDimension::BWType);
	}
}
