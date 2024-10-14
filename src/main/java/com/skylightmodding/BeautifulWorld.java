package com.skylightmodding;

import com.skylightmodding.init.*;
import com.skylightmodding.worldgen.BWFeatures;

import net.fabricmc.api.ModInitializer;

import net.kyrptonaught.customportalapi.api.CustomPortalBuilder;

import net.minecraft.util.Identifier;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BeautifulWorld implements ModInitializer {
	public static final String MOD_ID = "beautifulworld";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		/* reg init */
		BWItems.registerModItems();
		BWBlocks.registerModBlocks();
		BWStatusEffects.registerModEffects();
		BWFeatures.registerPlacedFeature();
		BWDataComponents.registerModDC();
		BWItemGroups.registerItemsGroups();

		/* Portals reg */
		CustomPortalBuilder.beginPortal()
				.frameBlock(BWBlocks.FORTIFIED_CRYING_OBSIDIAN.getBlock())
				.destDimID(Identifier.of(MOD_ID, "beautiful_world"))
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
