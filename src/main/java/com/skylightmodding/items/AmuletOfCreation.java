package com.skylightmodding.items;

import com.skylightmodding.init.BWDataComponents;
import com.skylightmodding.misc.BWTags;

import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.CustomModelDataComponent;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;

import java.util.List;

public class AmuletOfCreation extends Item {
    public AmuletOfCreation(Item.Settings settings) {
        super(settings);
    }

    @Override
    public ItemStack getDefaultStack() {
        ItemStack stack = super.getDefaultStack();
        stack.set(BWDataComponents.AMULET_OF_CREATION_STAGE, 0);
        stack.set(DataComponentTypes.CUSTOM_MODEL_DATA, CustomModelDataComponent.DEFAULT);
        return stack;
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);
        RegistryEntry<Biome> biome = world.getBiome(user.getBlockPos());

        if (world.isClient()) { return TypedActionResult.success(itemStack); }

        int stage = itemStack.getOrDefault(BWDataComponents.AMULET_OF_CREATION_STAGE, 0);

        if (stage == 4) { return TypedActionResult.success(itemStack); }

        if (stage == 0 && biome.isIn(BWTags.Biomes.AMULET_OF_CREATION_NETHER_STAGE_BIOMES)) {
            ++stage;
        } else if (stage == 1 && biome.isIn(BWTags.Biomes.AMULET_OF_CREATION_END_STAGE_BIOMES)) {
            ++stage;
        } else if (stage == 2 && biome.isIn(BWTags.Biomes.AMULET_OF_CREATION_OVERWORLD_STAGE_BIOMES)) {
            ++stage;
        } else if (stage == 3 && biome.isIn(BWTags.Biomes.AMULET_OF_CREATION_FINAL_STAGE_BIOMES)) {
            ++stage;
        }

        itemStack.set(BWDataComponents.AMULET_OF_CREATION_STAGE, stage);
        itemStack.set(DataComponentTypes.CUSTOM_MODEL_DATA, new CustomModelDataComponent(stage));

        return TypedActionResult.success(itemStack);
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        tooltip.add(Text.translatable("tooltip.beautifulworld.amulet_of_creation", stageConv(stack.getOrDefault(BWDataComponents.AMULET_OF_CREATION_STAGE, 0))).formatted(Formatting.GOLD));
    }

    private Text stageConv(int stage) {
        return switch (stage) {
            case 0 -> Text.translatable("item.beautifulworld.amulet_of_creation.stage.void");
            case 1 -> Text.translatable("item.beautifulworld.amulet_of_creation.stage.nether");
            case 2 -> Text.translatable("item.beautifulworld.amulet_of_creation.stage.end");
            case 3 -> Text.translatable("item.beautifulworld.amulet_of_creation.stage.overworld");
            case 4 -> Text.translatable("item.beautifulworld.amulet_of_creation.stage.korg");
            default -> Text.translatable("item.beautifulworld.amulet_of_creation.stage.error");
        };
    }
}
