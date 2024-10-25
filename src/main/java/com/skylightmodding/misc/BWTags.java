package com.skylightmodding.misc;

import com.skylightmodding.BeautifulWorld;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.dimension.DimensionType;

public class BWTags {
    public static class Blocks {
        public static final TagKey<Block> PITAHAYA_TREE_LOGS = createTag("pitahaya_tree_log_blocks");
        public static final TagKey<Block> MULTITOOL_MINEABLE = createTag("multitool_mineable");
        public static final TagKey<Block> BASE_STONE_END = createTag("base_stone_end");
        public static final TagKey<Block> NOT_INFECTIBLE_BLOCKS = createTag("not_infectible_blocks");

        private static TagKey<Block> createTag(String name) {
            return TagKey.of(RegistryKeys.BLOCK, Identifier.of(BeautifulWorld.MOD_ID, name));
        }
    }

    public static class Items {
        public static final TagKey<Item> PITAHAYA_TREE_LOGS = createTag("pitahaya_tree_logs_items");
        public static final TagKey<Item> AUTO_SMELTING_BLACKLIST = createTag("auto_smelting_blacklist"); // todo: в будущем вывести в конфиг файл

        private static TagKey<Item> createTag(String name) {
            return TagKey.of(RegistryKeys.ITEM, Identifier.of(BeautifulWorld.MOD_ID, name));
        }
    }

    public static class Biomes {
        public static final TagKey<Biome> OVERLOUD_ORE_GEN_BIOMES = createTag("overloud_ore_gen_biomes");
        public static final TagKey<Biome> RHODIUM_ORE_GEN_BIOMES = createTag("rhodium_ore_gen_biomes");
        public static final TagKey<Biome> AMULET_OF_CREATION_NETHER_STAGE_BIOMES = createTag("amulet_of_creation_nether_stage_biomes");
        public static final TagKey<Biome> AMULET_OF_CREATION_END_STAGE_BIOMES = createTag("amulet_of_creation_end_stage_biomes");
        public static final TagKey<Biome> AMULET_OF_CREATION_OVERWORLD_STAGE_BIOMES = createTag("amulet_of_creation_overworld_stage_biomes");
        public static final TagKey<Biome> AMULET_OF_CREATION_FINAL_STAGE_BIOMES = createTag("amulet_of_creation_final_stage_biomes");

        private static TagKey<Biome> createTag(String name) {
            return TagKey.of(RegistryKeys.BIOME, Identifier.of(BeautifulWorld.MOD_ID, name));
        }
    }

    public static class DimensionTypes {

        private static TagKey<DimensionType> createTag(String name) {
            return TagKey.of(RegistryKeys.DIMENSION_TYPE, Identifier.of(BeautifulWorld.MOD_ID, name));
        }
    }
}
