package com.skylightmodding.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.event.GameEvent;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

import com.skylightmodding.misc.BWTags;
import com.skylightmodding.init.BWStatusEffects;

import static com.skylightmodding.init.BWHashMaps.INFECTED_BLOCKS;

public class InfectedBlock extends Block {
    public InfectedBlock(Block.Settings settings) {
        super(settings);
    }

    @Override
    public void onEntityLand(BlockView world, Entity entity) {
        super.onEntityLand(world, entity);
        if (entity instanceof LivingEntity) {
            LivingEntity living = (LivingEntity)entity;
            if (!living.hasStatusEffect(BWStatusEffects.IMMUNITY)) {
                living.addStatusEffect(new StatusEffectInstance(BWStatusEffects.INFECTION, 1200, 0));
            }
        }
    }

   /*@Override
    public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {
        // тестовый набросок системы заражения

        int randomNum = random.nextBetween(1, 225);

        if (randomNum == 27) {
            this.replaceBlock(world, pos.down(1));
        } else if (randomNum == 64) {
            this.replaceBlock(world, pos.east(1));
        } else if (randomNum == 45) {
            this.replaceBlock(world, pos.west(1));
        } else if (randomNum == 86) {
            this.replaceBlock(world, pos.up(1));
        } else if (randomNum == 142) {
            this.replaceBlock(world, pos.south(1));
        } else if (randomNum == 189) {
            this.replaceBlock(world, pos.north(1));
        }
    }*/

    private void replaceBlock(World world, BlockPos position) {
        try {
            Block block = world.getBlockState(position).getBlock();
            if (!block.getDefaultState().isIn(BWTags.Blocks.NOT_INFECTIBLE_BLOCKS)) {
                BlockState infectedState = INFECTED_BLOCKS.get(block);
                world.setBlockState(position, infectedState);
                world.emitGameEvent(GameEvent.BLOCK_CHANGE, position, GameEvent.Emitter.of(infectedState));
            }
        } catch (NullPointerException e) {;}
    }
}
