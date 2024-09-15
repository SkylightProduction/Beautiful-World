package com.skylightmodding.init;

import com.skylightmodding.BeautifulWorld;
import com.skylightmodding.blocks.FallingInfectedBlock;
import com.skylightmodding.blocks.InfectedBlock;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

import net.kyrptonaught.customportalapi.CustomPortalBlock;

import net.minecraft.block.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;

public class BWBlocks {
    /* settings */
    public static final Block.Settings INFECTED_BLOCK_SETTINGS = Block.Settings.create().sounds(BlockSoundGroup.MUD);

    // Korg blocks
    public static final BlockItem INFECTED_DIRT = registerBlockItem(
            "infected_dirt",
            new InfectedBlock(INFECTED_BLOCK_SETTINGS.strength(2.000f)),
            new Item.Settings().rarity(Rarity.EPIC)
    );
    public static final BlockItem INFECTED_CLAY = registerBlockItem(
            "infected_clay",
            new InfectedBlock(INFECTED_BLOCK_SETTINGS.strength(2.000f)),
            new Item.Settings().rarity(Rarity.EPIC)
    );
    public static final BlockItem INFECTED_SAND = registerBlockItem(
            "infected_sand",
            new FallingInfectedBlock(INFECTED_BLOCK_SETTINGS.strength(2.000f)),
            new Item.Settings().rarity(Rarity.EPIC)
    );
    public static final BlockItem INFECTED_STONE = registerBlockItem(
            "infected_stone",
            new InfectedBlock(INFECTED_BLOCK_SETTINGS.strength(2.000f)),
            new Item.Settings().rarity(Rarity.EPIC)
    );
    public static final BlockItem INFECTED_COBBLESTONE = registerBlockItem(
            "infected_cobblestone",
            new InfectedBlock(INFECTED_BLOCK_SETTINGS.strength(2.000f)),
            new Item.Settings().rarity(Rarity.EPIC)
    );

    // rhodium blocks
    public static final BlockItem RHODIUM_ORE = registerBlockItem(
            "rhodium_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(4, 9), Block.Settings.copy(Blocks.NETHER_QUARTZ_ORE).strength(32.0F, 1200.0F))
    );
    public static final BlockItem RHODIUM_BLOCK = registerBlockItem(
            "rhodium_block",
            new Block(Block.Settings.copy(Blocks.NETHERITE_BLOCK))
    );

    // overloud blocks
    public static final BlockItem OVERLOUD_ORE = registerBlockItem(
            "overloud_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(4, 9), Block.Settings.copy(Blocks.END_STONE))
    );
    public static final BlockItem OVERLOUD_BLOCK = registerBlockItem(
            "overloud_block",
            new Block(Block.Settings.copy(Blocks.END_STONE))
    );
    public static final BlockItem RAW_OVERLOUD_BLOCK = registerBlockItem(
            "raw_overloud_block",
            new Block(Block.Settings.copy(Blocks.END_STONE))
    );

    // pitahaya blocks
    public static final BlockItem PITAHAYA_TREE_PLANKS = registerBlockItem(
            "pitahaya_tree_planks",
            new Block(Block.Settings.copy(Blocks.CHERRY_PLANKS))
    );
    public static final BlockItem PITAHAYA_TREE_SLAB = registerBlockItem(
            "pitahaya_tree_slab",
            new SlabBlock(Block.Settings.copy(Blocks.CHERRY_SLAB))
    );
    public static final BlockItem PITAHAYA_TREE_BUTTON = registerBlockItem(
            "pitahaya_tree_button",
            new ButtonBlock(BlockSetType.CHERRY, 30, Block.Settings.copy(Blocks.CHERRY_BUTTON))
    );
    public static final BlockItem PITAHAYA_TREE_DOOR = registerBlockItem(
            "pitahaya_tree_door",
            new DoorBlock(BlockSetType.CHERRY, Block.Settings.copy(Blocks.CHERRY_DOOR))
    );
    public static final BlockItem PITAHAYA_TREE_TRAPDOOR = registerBlockItem(
            "pitahaya_tree_trapdoor",
            new TrapdoorBlock(BlockSetType.CHERRY, Block.Settings.copy(Blocks.CHERRY_TRAPDOOR))
    );
    public static final BlockItem PITAHAYA_TREE_STAIRS = registerBlockItem(
            "pitahaya_tree_stairs",
            new StairsBlock(PITAHAYA_TREE_PLANKS.getBlock().getDefaultState(), Block.Settings.copy(Blocks.CHERRY_STAIRS))
    );
    public static final BlockItem PITAHAYA_TREE_PRESSURE_PLATE = registerBlockItem(
            "pitahaya_tree_pressure_plate",
            new PressurePlateBlock(BlockSetType.CHERRY, Block.Settings.copy(Blocks.OAK_PRESSURE_PLATE))
    );
    public static final BlockItem PITAHAYA_TREE_FENCE = registerBlockItem(
            "pitahaya_tree_fence",
            new FenceBlock(Block.Settings.copy(Blocks.CHERRY_FENCE))
    );
    public static final BlockItem PITAHAYA_TREE_FENCE_GATE = registerBlockItem(
            "pitahaya_tree_fence_gate",
            new FenceGateBlock(WoodType.CHERRY, Block.Settings.copy(Blocks.CHERRY_FENCE_GATE))
    );
    public static final BlockItem PITAHAYA_TREE_LOG = registerBlockItem(
            "pitahaya_log",
            new PillarBlock(Block.Settings.copy(Blocks.CHERRY_LOG))
    );
    public static final BlockItem PITAHAYA_TREE_WOOD = registerBlockItem(
            "pitahaya_wood",
            new PillarBlock(Block.Settings.copy(Blocks.CHERRY_WOOD))
    );
    public static final BlockItem STRIPPED_PITAHAYA_TREE_LOG = registerBlockItem(
            "stripped_pitahaya_log",
            new PillarBlock(Block.Settings.copy(Blocks.STRIPPED_CHERRY_LOG))
    );
    public static final BlockItem STRIPPED_PITAHAYA_TREE_WOOD = registerBlockItem(
            "stripped_pitahaya_wood",
            new PillarBlock(Block.Settings.copy(Blocks.STRIPPED_CHERRY_WOOD))
    );
    public static final BlockItem PITAHAYA_TREE_LEAVES = registerBlockItem(
            "pitahaya_leaves",
            new LeavesBlock(Block.Settings.copy(Blocks.CHERRY_LEAVES))
    );
    public static final BlockItem FRUITFUL_PITAHAYA_TREE_LEAVES = registerBlockItem(
        "fruitful_pitahaya_leaves",
        new LeavesBlock(Block.Settings.copy(Blocks.CHERRY_LEAVES)) {
            @Override
            public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
                dropStack(world, pos, new ItemStack(BWItems.PITAHAYA, world.random.nextBetween(1, 2)));
                world.playSound(player, pos, SoundEvents.BLOCK_CAVE_VINES_PICK_BERRIES, SoundCategory.BLOCKS, 1.0F, 0.8F + world.random.nextFloat() * 0.4F);
                world.setBlockState(pos, PITAHAYA_TREE_LEAVES.getBlock().getDefaultState(), 2);

                return ActionResult.success(world.isClient);
            }
        }
    );

    // other
    public static final BlockItem FORTIFIED_CRYING_OBSIDIAN = registerBlockItem(
            "fortified_crying_obsidian",
            new Block(Block.Settings.create().sounds(BlockSoundGroup.ANCIENT_DEBRIS).strength(65.0F, 2400.0F))
    );
    public static final CustomPortalBlock BW_PORTAL_BLOCK = registerPortalBlock(
        "beautiful_world_portal",
        new CustomPortalBlock(Block.Settings.copy(Blocks.NETHER_PORTAL)) {
            @Override
            @Environment(EnvType.CLIENT)
            public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {
                if (random.nextInt(99) == 0) {
                    world.playSound((double) pos.getX() + 0.5D, (double) pos.getY() + 0.5D, (double) pos.getZ() + 0.5D, SoundEvents.BLOCK_PORTAL_AMBIENT, SoundCategory.BLOCKS, 0.5F, random.nextFloat() * 0.4F + 0.8F, false);
                }
            }
        }
    );



    private static BlockItem registerBlockItem(String name, Block block) {
        registerBlock(name, block);
        return Registry.register(Registries.ITEM, Identifier.of(BeautifulWorld.MOD_ID, name), new BlockItem(block, new Item.Settings()));
    }

    private static BlockItem registerBlockItem(String name, Block block, Item.Settings settings) {
        registerBlock(name, block);
        return Registry.register(Registries.ITEM, Identifier.of(BeautifulWorld.MOD_ID, name), new BlockItem(block, settings));
    }

    private static Block registerBlock(String name, Block block) {
        return Registry.register(Registries.BLOCK, Identifier.of(BeautifulWorld.MOD_ID, name), block);
    }

    private static CustomPortalBlock registerPortalBlock(String name, CustomPortalBlock block) {
        return Registry.register(Registries.BLOCK, Identifier.of(BeautifulWorld.MOD_ID, name), block);
    }

    public static void registerModBlocks() {
        BeautifulWorld.LOGGER.info("Registering Blocks from " + BeautifulWorld.MOD_ID);
    }
}
