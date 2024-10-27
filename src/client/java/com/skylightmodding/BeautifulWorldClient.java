package com.skylightmodding;

import com.skylightmodding.init.BWBlocks;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;

import net.minecraft.client.render.RenderLayer;

public class BeautifulWorldClient implements ClientModInitializer {

	@Override
	public void onInitializeClient() {
		registerBlockRender();
	}

	private static void registerBlockRender() {
		BlockRenderLayerMap.INSTANCE.putBlock(BWBlocks.PITAHAYA_TREE_SAPLING.getBlock(), RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(BWBlocks.PITAHAYA_TREE_DOOR.getBlock(), RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(BWBlocks.PITAHAYA_TREE_TRAPDOOR.getBlock(), RenderLayer.getCutout());
	}
}