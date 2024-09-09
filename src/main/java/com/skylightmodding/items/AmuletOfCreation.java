package com.skylightmodding.items;

import com.skylightmodding.BeautifulWorld;
import com.skylightmodding.init.BWDataComponents;
import com.skylightmodding.worldgen.dimensions.BeautifulWorldDim;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.StackReference;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.screen.slot.Slot;
import net.minecraft.text.Text;
import net.minecraft.util.ClickType;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeKeys;

import java.util.List;

public class AmuletOfCreation extends Item {
    public AmuletOfCreation(Item.Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);

        if (world.isClient()) {return TypedActionResult.success(itemStack);}

        int stage = itemStack.getOrDefault(BWDataComponents.AMULET_OF_CREATION_STAGE, 0);
        itemStack.set(BWDataComponents.AMULET_OF_CREATION_STAGE, stage == 4 ? stage : ++stage);

        return TypedActionResult.success(itemStack);
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        tooltip.add(Text.translatable("tooltip.beautifulworld.amulet_of_creation", stageConv(stack.getOrDefault(BWDataComponents.AMULET_OF_CREATION_STAGE, 0))).formatted(Formatting.GOLD));
    }

    private String stageConv(int stage) {
        if (stage == 0) { return "\"Null\""; }
        else if (stage == 1) { return "\"Nether\""; }
        else if (stage == 2) { return "\"End\""; }
        else if (stage == 3) { return "\"Overworld\""; }
        else if (stage == 4) { return "\"Sculk\""; }
        return "ERROR";
    }
}
