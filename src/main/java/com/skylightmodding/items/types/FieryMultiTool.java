package com.skylightmodding.items.types;

import com.skylightmodding.items.components.ToolModifications;
import net.minecraft.block.BlockState;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class FieryMultiTool extends MultiToolItem {
    public FieryMultiTool(ToolMaterial toolMaterial, Settings settings) {
        super(toolMaterial, settings);
    }

    @Override
    public boolean postMine(ItemStack stack, World world, BlockState state, BlockPos pos, LivingEntity miner) {
        super.postMine(stack, world, state, pos, miner);
        ToolModifications.blockSmelting(world, state, pos, stack, miner);
        return true;
    }
}
