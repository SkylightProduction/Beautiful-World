package com.skylightmodding.items;

import com.skylightmodding.items.type.Tool3x3;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.CampfireBlock;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;

import java.util.ArrayList;
import java.util.Map;

public class CrystalliteShovelItem extends Tool3x3 {
    protected static final Map<Block, BlockState> PATH_STATES;

    public CrystalliteShovelItem(ToolMaterial toolMaterial, TagKey<Block> mineable, Item.Settings settings) {
        super(toolMaterial, mineable, settings);
    }

    @Override public ActionResult useOnBlock(ItemUsageContext context) {
        // TODO Я сам не совсем понимаю как это работает. Лучше это переписать.

        boolean blockReplaced = false;
        World world = context.getWorld();
        BlockPos blockPos = context.getBlockPos();

        BlockPos[] blockPosList = {
                context.getBlockPos(), context.getBlockPos().west(1),
                context.getBlockPos().east(1), context.getBlockPos().south(1),
                context.getBlockPos().north(1), context.getBlockPos().south(1).west(1),
                context.getBlockPos().south(1).east(1), context.getBlockPos().north(1).west(1),
                context.getBlockPos().north(1).east(1)
        };
        BlockState[] blockStates = {
                world.getBlockState(blockPos), world.getBlockState(blockPos.west(1)),
                world.getBlockState(blockPos.east(1)), world.getBlockState(blockPos.south(1)),
                world.getBlockState(blockPos.north(1)), world.getBlockState(blockPos.south(1).west(1)),
                world.getBlockState(blockPos.south(1).east(1)), world.getBlockState(blockPos.north(1).west(1)),
                world.getBlockState(blockPos.north(1).east(1))
        };
        ArrayList<BlockState> blockStateArrayList = new ArrayList<>();

        if (context.getSide() == Direction.DOWN) {
            return ActionResult.PASS;
        } else {
            PlayerEntity playerEntity = context.getPlayer();

            for (BlockState bs : blockStates) {
                for (BlockPos bp : blockPosList) {
                    if (bs != null) {
                        blockStateArrayList.add(PATH_STATES.get(bs.getBlock()));
                    }
                }
            }

            for (BlockState bs : blockStateArrayList) {
                for (BlockPos bp : blockPosList) {
                    if (bs != null) {
                        if (bs.getBlock() instanceof CampfireBlock && (Boolean)bs.get(CampfireBlock.LIT)) {
                            if (!world.isClient()) {
                                world.syncWorldEvent((PlayerEntity) null, 1009, bp, 0);
                            }

                            CampfireBlock.extinguish(context.getPlayer(), world, bp, bs);
                            bs = (BlockState)bs.with(CampfireBlock.LIT, false);
                        }

                        if (!world.isClient && world.getBlockState(bp.up(1)).isAir() && !world.getBlockState(bp).isAir() && PATH_STATES.containsKey(world.getBlockState(bp).getBlock())) {
                            world.setBlockState(bp, bs, 11);
                            world.emitGameEvent(GameEvent.BLOCK_CHANGE, bp, GameEvent.Emitter.of(playerEntity, bs));
                        }

                        blockReplaced = true;
                    }
                }
            }

            if (playerEntity != null) {
                context.getStack().damage(1, playerEntity, LivingEntity.getSlotForHand(context.getHand()));
            }
            world.playSound(playerEntity, blockPos, SoundEvents.ITEM_SHOVEL_FLATTEN, SoundCategory.BLOCKS, 1.0F, 1.0F);

            return blockReplaced ? ActionResult.success(world.isClient) : ActionResult.PASS;
        }
    }

    static {
        PATH_STATES = Maps.newHashMap((new ImmutableMap.Builder()).put(Blocks.GRASS_BLOCK, Blocks.DIRT_PATH.getDefaultState()).put(Blocks.DIRT, Blocks.DIRT_PATH.getDefaultState()).put(Blocks.PODZOL, Blocks.DIRT_PATH.getDefaultState()).put(Blocks.COARSE_DIRT, Blocks.DIRT_PATH.getDefaultState()).put(Blocks.MYCELIUM, Blocks.DIRT_PATH.getDefaultState()).put(Blocks.ROOTED_DIRT, Blocks.DIRT_PATH.getDefaultState()).build());
    }
}
