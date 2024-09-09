package com.skylightmodding.items;

import com.skylightmodding.items.type.Tool3x3;

import net.minecraft.block.BlockState;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class CrystallitePickaxeItem extends PickaxeItem {
    public CrystallitePickaxeItem(ToolMaterial toolMaterial, Item.Settings settings) {
        super(toolMaterial, settings);
    }

    @Override public boolean postMine(ItemStack stack, World world, BlockState state, BlockPos pos, LivingEntity miner) {
        super.postMine(stack, world, state, pos, miner);
        Tool3x3.mine3x3(world, pos, miner, BlockTags.PICKAXE_MINEABLE);
        return true;
    }
}
