package com.skylightmodding.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.registry.tag.FluidTags;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Property;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.event.GameEvent;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

import com.skylightmodding.misc.BWTags;
import com.skylightmodding.init.BWStatusEffects;
import com.skylightmodding.blocks.components.BWProperties;
import static com.skylightmodding.init.BWHashMaps.INFECTED_BLOCKS;

public class InfectedBlock extends Block {
    protected static final BooleanProperty PROTECTED = BWProperties.PROTECTED;

    public InfectedBlock(Block.Settings settings) {
        super(settings);
        this.setDefaultState(getDefaultState()
                .with(PROTECTED, false)
        );
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(PROTECTED);
    }

    @Override
    protected boolean hasRandomTicks(BlockState state) {
        return !state.get(PROTECTED);
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

    @Override
    public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {
        // тестовый набросок системы заражения
        BlockPos[] posList = { pos.west(), pos.east(), pos.north(), pos.south(), pos.up(), pos.down() };
        for (BlockPos ps : posList) {
            checkLava(ps, pos, world);
        }

        int randomNum = random.nextBetween(1, 225);

        if (randomNum == 27) {
            replaceBlock(world, pos.down());
        } else if (randomNum == 64) {
            replaceBlock(world, pos.east());
        } else if (randomNum == 45) {
            replaceBlock(world, pos.west());
        } else if (randomNum == 86) {
            replaceBlock(world, pos.up());
        } else if (randomNum == 142) {
            replaceBlock(world, pos.south());
        } else if (randomNum == 189) {
            replaceBlock(world, pos.north());
        }

        System.out.println("test");
    }

    private static void replaceBlock(World world, BlockPos position) {
        try {
            Block block = world.getBlockState(position).getBlock();
            if (!block.getDefaultState().isIn(BWTags.Blocks.NOT_INFECTIBLE_BLOCKS)) {
                BlockState infectedState = INFECTED_BLOCKS.get(block);
                world.setBlockState(position, infectedState);
                world.emitGameEvent(GameEvent.BLOCK_CHANGE, position, GameEvent.Emitter.of(infectedState));
            }
        } catch (NullPointerException e) {;}
    }

    private static void checkLava(BlockPos lavaPos, BlockPos infBlockPos, World world) {
        if (world.getFluidState(lavaPos).isIn(FluidTags.LAVA)) {
            world.setBlockState(infBlockPos, world.getBlockState(infBlockPos).with(BWProperties.PROTECTED, true));
        }
    }
}
