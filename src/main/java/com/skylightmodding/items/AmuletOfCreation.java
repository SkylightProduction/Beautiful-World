package com.skylightmodding.items;

import com.skylightmodding.worldgen.dimensions.BeautifulWorldDim;

import net.minecraft.client.item.TooltipType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.StackReference;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.screen.slot.Slot;
import net.minecraft.text.Text;
import net.minecraft.util.ClickType;
import net.minecraft.util.Formatting;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeKeys;

import java.util.List;

public class AmuletOfCreation extends Item {
    private static int /*IntProperty*/ STAGE_LVL;
    // todo: fix this
    public AmuletOfCreation(Item.Settings settings) {
        super(settings);
    }

    @Override
    public ItemStack getDefaultStack() {
        ItemStack itemStack = super.getDefaultStack();
//        itemStack.apply();
        return itemStack;
    }

    @Override
    public boolean onClicked(ItemStack stack, ItemStack otherStack, Slot slot, ClickType clickType, PlayerEntity player, StackReference cursorStackReference) {
        RegistryEntry<Biome> thisBiome = player.getEntityWorld().getBiome(player.getBlockPos());

        switch (STAGE_LVL) {
            case 0: {
                if (thisBiome == BiomeKeys.SOUL_SAND_VALLEY || thisBiome == BiomeKeys.CRIMSON_FOREST || thisBiome == BiomeKeys.NETHER_WASTES) {
                    STAGE_LVL++;
                }
            }
            case 1: {
                if (thisBiome == BiomeKeys.END_HIGHLANDS || thisBiome == BiomeKeys.END_MIDLANDS || thisBiome == BiomeKeys.END_BARRENS) {
                    STAGE_LVL++;
                }
            }
            case 2: {
                if (thisBiome == BiomeKeys.FOREST || thisBiome == BiomeKeys.GROVE || thisBiome == BiomeKeys.FLOWER_FOREST) {
                    STAGE_LVL++;
                }
            }
            case 3: {
                if (thisBiome == BiomeKeys.DEEP_DARK && player.getEntityWorld().getDimensionEntry() == BeautifulWorldDim.BW_WORLD) {
                    STAGE_LVL++;
                }
            }

//            case 4: {
//                Text.translatable("message.beautifulworld.amulet_of_creation");
//            }
        }

        return true;
    }

//    @Override
//    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
//        return super.use(world, user, hand);
//    }

    @Override
    public void appendTooltip(ItemStack itemStack, Item.TooltipContext context, List<Text> tooltip, TooltipType options) {
        tooltip.add(Text.translatable("tooltip.beautifulworld.amulet_of_creation", stageConv(STAGE_LVL)).formatted(Formatting.GRAY));
    }

    private void updateItem(ItemStack itemStack, Item.TooltipContext context, List<Text> tooltip, TooltipType options) {
        STAGE_LVL++;
        this.appendTooltip(itemStack, context, tooltip, options);
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
