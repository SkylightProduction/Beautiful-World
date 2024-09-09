package com.skylightmodding;

import com.skylightmodding.misc.BWModelPredicateProviders;

import net.fabricmc.api.ClientModInitializer;

public class BeautifulWorldClient implements ClientModInitializer {

	@Override
	public void onInitializeClient() {
		BWModelPredicateProviders.register();
	}
}