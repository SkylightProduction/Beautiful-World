package com.skylightmodding.misc;

import com.skylightmodding.BeautifulWorld;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.Biome;

public class BWTags {
    public static class Blocks {
        public static final TagKey<Block> PITAHAYA_TREE_LOGS = createTag("pitahaya_tree_logs_blocks");
        public static final TagKey<Block> MULTITOOL_MINEABLE = createTag("multitool_mineable");
        public static final TagKey<Block> BASE_STOE_END = createTag("base_stone_end");


        private static TagKey<Block> createTag(String name) {
            return TagKey.of(RegistryKeys.BLOCK, new Identifier(BeautifulWorld.MOD_ID, name));
        }
    }

    public static class Items {
        public static final TagKey<Item> PITAHAYA_TREE_LOGS = createTag("pitahaya_tree_logs_items");


        private static TagKey<Item> createTag(String name) {
            return TagKey.of(RegistryKeys.ITEM, new Identifier(BeautifulWorld.MOD_ID, name));
        }
    }

    public static class Biomes {
        public static final TagKey<Biome> OVERLOUD_ORE_GEN_BIOMES = createTag("overloud_ore_gen_biomes");

        private static TagKey<Biome> createTag(String name) {
            return TagKey.of(RegistryKeys.BIOME, new Identifier(BeautifulWorld.MOD_ID, name));
        }
    }
}
