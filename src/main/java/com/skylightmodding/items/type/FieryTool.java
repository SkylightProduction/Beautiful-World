package com.skylightmodding.items.type;

import com.skylightmodding.misc.BWTags;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.MiningToolItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.recipe.RecipeEntry;
import net.minecraft.recipe.RecipeType;
import net.minecraft.recipe.SmeltingRecipe;
import net.minecraft.recipe.input.SingleStackRecipeInput;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.List;

public class FieryTool extends MiningToolItem {
    public FieryTool(ToolMaterial toolMaterial, TagKey<Block> tag, Item.Settings settings) {
        super(toolMaterial, tag, settings);
    }

    @Override
    public boolean postMine(ItemStack stack, World world, BlockState state, BlockPos pos, LivingEntity miner) {
        super.postMine(stack, world, state, pos, miner);
        blockSmelting(world, state, pos, stack, miner);
        return true;
    }

    public static void blockSmelting(World world, BlockState state, BlockPos pos, ItemStack stack, LivingEntity miner) {
        boolean isSmelting = false;
        ServerWorld serverWorld = (ServerWorld)world;
        ItemStack input = state.getBlock().getPickStack(world, pos, state);
        List<ItemStack> inputList = Block.getDroppedStacks(state, serverWorld, pos, null, miner, stack);

        List<RecipeEntry<SmeltingRecipe>> recipes = world.getRecipeManager().getAllMatches(RecipeType.SMELTING, new SingleStackRecipeInput(input), world);
        for (RecipeEntry<SmeltingRecipe> recipe : recipes) {
            ItemStack result = recipe.value().getResult(world.getRegistryManager()).copy();
            if (result != null && !result.isEmpty() && !input.isIn(BWTags.Items.AUTO_SMELTING_BLACKLIST)) {
                isSmelting = true;
                serverWorld.spawnParticles(ParticleTypes.FLAME, (double) pos.getX() + 0.5D, (double) pos.getY() + 0.5D, (double) pos.getZ() + 0.5D, 20, 0.15D, 0.25D, 0.15D, 0.035f);
                serverWorld.playSound(null, (double) pos.getX() + 0.5D, (double) pos.getY() + 0.5D, (double) pos.getZ() + 0.5D, SoundEvents.BLOCK_FIRE_EXTINGUISH, SoundCategory.BLOCKS, 0.4F, 2.6F);
                for (int i = 0; i < inputList.getFirst().getCount(); i++) {
                    Block.dropStack(world, pos, result);
                }
            }
        }

        if (!isSmelting) {
            Block.dropStacks(state, world, pos);
        }
    }
}
