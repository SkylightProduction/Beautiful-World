package com.skylightmodding.items.type;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.*;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;

public class Tool3x3 extends MiningToolItem {
    private TagKey<Block> MINEABLE;

    public Tool3x3(ToolMaterial toolMaterial, TagKey<Block> tag, Item.Settings settings) {
        super(toolMaterial, tag, settings);
        this.MINEABLE = tag;
    }

    @Override
    public boolean postMine(ItemStack stack, World world, BlockState state, BlockPos pos, LivingEntity miner) {
        super.postMine(stack, world, state, pos, miner);
        mine3x3(world, pos, miner, MINEABLE);
        return true;
    }

    private static void breakBlock(World world, BlockPos position, TagKey<Block> tag) {
        if (world.getBlockState(position).isIn(tag)) { world.breakBlock(position, true); }
    }

    public static void mine3x3(World world, BlockPos pos, LivingEntity miner, TagKey<Block> tag) {
        Direction facing = miner.getFacing();

        if (facing == Direction.NORTH || facing == Direction.SOUTH) {
            breakBlock(world, pos.down(1), tag);
            breakBlock(world, pos.up(1), tag);
            breakBlock(world, pos.west(1), tag);
            breakBlock(world, pos.east(1), tag);
            breakBlock(world, pos.west(1).up(1), tag);
            breakBlock(world, pos.west(1).down(1), tag);
            breakBlock(world, pos.east(1).up(1), tag);
            breakBlock(world, pos.east(1).down(1), tag);
        } else if (facing == Direction.EAST || facing == Direction.WEST) {
            breakBlock(world, pos.down(1), tag);
            breakBlock(world, pos.up(1), tag);
            breakBlock(world, pos.south(1), tag);
            breakBlock(world, pos.north(1), tag);
            breakBlock(world, pos.south(1).up(1), tag);
            breakBlock(world, pos.south(1).down(1), tag);
            breakBlock(world, pos.north(1).up(1), tag);
            breakBlock(world, pos.north(1).down(1), tag);
        } else if (facing == Direction.UP || facing == Direction.DOWN) {
            breakBlock(world, pos.west(1), tag);
            breakBlock(world, pos.east(1), tag);
            breakBlock(world, pos.south(1), tag);
            breakBlock(world, pos.north(1), tag);
            breakBlock(world, pos.south(1).west(1), tag);
            breakBlock(world, pos.south(1).east(1), tag);
            breakBlock(world, pos.north(1).west(1), tag);
            breakBlock(world, pos.north(1).east(1), tag);
        }
    }
}
