package com.skylightmodding.items;

import com.google.common.collect.BiMap;

import com.skylightmodding.items.components.ToolModifications;

import net.minecraft.advancement.criterion.Criteria;
import net.minecraft.block.*;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;

import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Optional;

public class CrystalliteAxeItem extends AxeItem {
    private final TagKey<Block> MINEABLE;

    public CrystalliteAxeItem(ToolMaterial toolMaterial, TagKey<Block> mineable, Item.Settings settings) {
        super(toolMaterial, settings);
        this.MINEABLE = mineable;
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        PlayerEntity playerEntity = context.getPlayer();
        ArrayList<BlockPos> blockPosList = this.getBlockStateList(context, playerEntity);
        ItemStack itemStack = null;
        boolean blockReplaced = false;

        for (BlockPos bp : blockPosList) {
            Optional<BlockState> optional = this.tryStrip(world, bp, playerEntity, world.getBlockState(bp));

            if (optional.isEmpty()) {
                blockReplaced = false;
            } else {
                itemStack = context.getStack();
                if (playerEntity instanceof ServerPlayerEntity) {
                    Criteria.ITEM_USED_ON_BLOCK.trigger((ServerPlayerEntity) playerEntity, bp, itemStack);
                }

                world.setBlockState(bp, (BlockState) optional.get(), 11);
                world.emitGameEvent(GameEvent.BLOCK_CHANGE, bp, GameEvent.Emitter.of(playerEntity, (BlockState) optional.get()));

                blockReplaced = true;
            }
        }

        if (playerEntity != null && itemStack != null) {
            itemStack.damage(1, playerEntity, LivingEntity.getSlotForHand(context.getHand()));
        }

        return blockReplaced ? ActionResult.success(world.isClient) : ActionResult.PASS;
    }

    @Override
    public boolean postMine(ItemStack stack, World world, BlockState state, BlockPos pos, LivingEntity miner) {
        super.postMine(stack, world, state, pos, miner);
        ToolModifications.mine3x3(world, pos, miner, MINEABLE);
        return true;
    }

    private Optional<BlockState> tryStrip(World world, BlockPos pos, @Nullable PlayerEntity player, BlockState state) {
        Optional<BlockState> optional = this.getStrippedState(state);
        if (optional.isPresent()) {
            world.playSound(player, pos, SoundEvents.ITEM_AXE_STRIP, SoundCategory.BLOCKS, 1.0F, 1.0F);
            return optional;
        } else {
            Optional<BlockState> optional2 = Oxidizable.getDecreasedOxidationState(state);
            if (optional2.isPresent()) {
                world.playSound(player, pos, SoundEvents.ITEM_AXE_SCRAPE, SoundCategory.BLOCKS, 1.0F, 1.0F);
                world.syncWorldEvent(player, 3005, pos, 0);
                return optional2;
            } else {
                Optional<BlockState> optional3 = Optional.ofNullable((Block)((BiMap)HoneycombItem.WAXED_TO_UNWAXED_BLOCKS.get()).get(state.getBlock())).map((block) -> {
                    return block.getStateWithProperties(state);
                });
                if (optional3.isPresent()) {
                    world.playSound(player, pos, SoundEvents.ITEM_AXE_WAX_OFF, SoundCategory.BLOCKS, 1.0F, 1.0F);
                    world.syncWorldEvent(player, 3004, pos, 0);
                    return optional3;
                } else {
                    return Optional.empty();
                }
            }
        }
    }

    private Optional<BlockState> getStrippedState(BlockState state) {
        return Optional.ofNullable((Block)STRIPPED_BLOCKS.get(state.getBlock())).map((block) -> {
            return (BlockState)block.getDefaultState().with(PillarBlock.AXIS, (Direction.Axis)state.get(PillarBlock.AXIS));
        });
    }

    private ArrayList<BlockPos> getBlockStateList(ItemUsageContext context, PlayerEntity entity) {
        ArrayList<BlockPos> blockStateList = new ArrayList<>();
        if (entity.getFacing() == Direction.NORTH || entity.getFacing() == Direction.SOUTH) {
            blockStateList.add(context.getBlockPos());
            blockStateList.add(context.getBlockPos().down(1));
            blockStateList.add(context.getBlockPos().up(1));
            blockStateList.add(context.getBlockPos().west(1));
            blockStateList.add(context.getBlockPos().east(1));
            blockStateList.add(context.getBlockPos().west(1).up(1));
            blockStateList.add(context.getBlockPos().west(1).down(1));
            blockStateList.add(context.getBlockPos().east(1).up(1));
            blockStateList.add(context.getBlockPos().east(1).down(1));
        } else if (entity.getFacing() == Direction.EAST || entity.getFacing() == Direction.WEST) {
            blockStateList.add(context.getBlockPos());
            blockStateList.add(context.getBlockPos().down(1));
            blockStateList.add(context.getBlockPos().up(1));
            blockStateList.add(context.getBlockPos().south(1));
            blockStateList.add(context.getBlockPos().north(1));
            blockStateList.add(context.getBlockPos().south(1).up(1));
            blockStateList.add(context.getBlockPos().south(1).down(1));
            blockStateList.add(context.getBlockPos().north(1).up(1));
            blockStateList.add(context.getBlockPos().north(1).down(1));
        } else if (entity.getFacing() == Direction.UP || entity.getFacing() == Direction.DOWN) {
            blockStateList.add(context.getBlockPos());
            blockStateList.add(context.getBlockPos().west(1));
            blockStateList.add(context.getBlockPos().east(1));
            blockStateList.add(context.getBlockPos().south(1));
            blockStateList.add(context.getBlockPos().north(1));
            blockStateList.add(context.getBlockPos().south(1).west(1));
            blockStateList.add(context.getBlockPos().south(1).east(1));
            blockStateList.add(context.getBlockPos().north(1).west(1));
            blockStateList.add(context.getBlockPos().north(1).east(1));
        }

        return blockStateList;
    }
}
