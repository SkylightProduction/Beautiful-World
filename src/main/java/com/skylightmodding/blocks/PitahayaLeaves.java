package com.skylightmodding.blocks;

import com.skylightmodding.init.BWItems;
import com.skylightmodding.blocks.components.BWProperties;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.LeavesBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.state.property.Property;
import net.minecraft.util.ActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;

public class PitahayaLeaves extends LeavesBlock {
    private static final IntProperty DISTANCE = Properties.DISTANCE_1_7;
    private static final BooleanProperty PERSISTENT = Properties.PERSISTENT;
    private static final BooleanProperty WATERLOGGED = Properties.WATERLOGGED;
    private static final BooleanProperty WITH_PITAHAYA = BWProperties.WITH_PITAHAYA;

    public PitahayaLeaves(Block.Settings settings) {
        super(settings);
        this.setDefaultState(getDefaultState()
                .with(WITH_PITAHAYA, false)
                .with(DISTANCE, 7)
                .with(PERSISTENT, false)
                .with(WATERLOGGED, false)
        );
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(DISTANCE, PERSISTENT, WATERLOGGED, WITH_PITAHAYA);
    }

    @Override
    protected boolean hasRandomTicks(BlockState state) {
        return !state.get(WITH_PITAHAYA) || state.get(DISTANCE) == 7 && !state.get(PERSISTENT);
    }

    @Override
    protected void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        super.randomTick(state, world, pos, random);

        boolean hasPitahaya = state.get(WITH_PITAHAYA);
        if (!hasPitahaya && random.nextInt(60) == 0 && world.getBaseLightLevel(pos.up(), 0) >= 9) {
            BlockState blockState = state.with(WITH_PITAHAYA, true);
            world.setBlockState(pos, blockState, 2);
            world.emitGameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Emitter.of(blockState));
        }
    }

    @Override
    protected ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
        boolean hasPitahaya = state.get(WITH_PITAHAYA);
        if (hasPitahaya) {
            dropStack(world, pos, new ItemStack(BWItems.PITAHAYA, world.random.nextBetween(1, 2)));
            world.playSound(null, pos, SoundEvents.BLOCK_CAVE_VINES_PICK_BERRIES, SoundCategory.BLOCKS, 1.0F, 0.8F + world.random.nextFloat() * 0.4F);
            BlockState blockState = state.with(WITH_PITAHAYA, false);
            world.setBlockState(pos, blockState, 2);
            world.emitGameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Emitter.of(player, blockState));
            return ActionResult.success(world.isClient);
        } else {
            return super.onUse(state, world, pos, player, hit);
        }
    }

}
