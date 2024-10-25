package com.skylightmodding.items;

import com.skylightmodding.items.components.ToolModifications;
import com.skylightmodding.misc.TooltipTemplates;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.List;

public class CrystallitePickaxeItem extends PickaxeItem {
    private final TagKey<Block> MINEABLE;

    public CrystallitePickaxeItem(ToolMaterial toolMaterial, TagKey<Block> mineable, Item.Settings settings) {
        super(toolMaterial, settings);
        this.MINEABLE = mineable;
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        tooltip.add(TooltipTemplates.CAN_MINE_3x3);
    }

    @Override
    public boolean postMine(ItemStack stack, World world, BlockState state, BlockPos pos, LivingEntity miner) {
        super.postMine(stack, world, state, pos, miner);
        ToolModifications.mine3x3(world, pos, miner, this.MINEABLE);
        return true;
    }
}
