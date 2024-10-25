package com.skylightmodding.items;

import com.skylightmodding.init.BWDataComponents;

import net.minecraft.block.BlockState;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.CustomModelDataComponent;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.text.Text;
import net.minecraft.util.*;
import net.minecraft.world.World;

public class OverloudAxe extends AxeItem {
    public OverloudAxe(ToolMaterial toolMaterial, Item.Settings settings) {
        super(toolMaterial, settings);
    }

    @Override
    public ItemStack getDefaultStack() {
        ItemStack stack = super.getDefaultStack();
        stack.set(BWDataComponents.OVERLOUD_AXE_STIPULATION, 0);
        stack.set(DataComponentTypes.CUSTOM_MODEL_DATA, new CustomModelDataComponent(0));
        return stack;
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        CustomModelDataComponent customModelData;
        ItemStack stack = user.getStackInHand(user.getActiveHand());
        int stipulation = stack.getOrDefault(BWDataComponents.OVERLOUD_AXE_STIPULATION, 0);

        if (stipulation == 0) {
            stipulation = 1;
            customModelData = new CustomModelDataComponent(1);
        } else {
            stipulation = 0;
            customModelData = new CustomModelDataComponent(0);
        }

        stack.set(BWDataComponents.OVERLOUD_AXE_STIPULATION, stipulation);
        stack.set(DataComponentTypes.CUSTOM_MODEL_DATA, customModelData);

        user.sendMessage(Text.translatable("overlay_message.beautifulworld.overloud_axe.change"), true);

        return TypedActionResult.success(stack);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        int stipulation = context.getPlayer().getStackInHand(context.getHand()).getOrDefault(BWDataComponents.OVERLOUD_AXE_STIPULATION, 0);
        if (stipulation == 0) {
            return super.useOnBlock(context);
        }

        context.getPlayer().sendMessage(Text.translatable("overlay_message.beautifulworld.overloud_axe.fail").formatted(Formatting.RED), true);

        return ActionResult.FAIL;
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        int stipulation = stack.getOrDefault(BWDataComponents.OVERLOUD_AXE_STIPULATION, 0);
        float damage = this.getMaterial().getAttackDamage();

        if (stipulation == 1) {
            damage += 12.5f;
        }

        target.damage(target.getDamageSources().generic(), damage);
        System.out.println(damage);

        return true;
    }

    @Override
    public float getMiningSpeed(ItemStack stack, BlockState state) {
        int stipulation = stack.getOrDefault(BWDataComponents.OVERLOUD_AXE_STIPULATION, 0);
        float speed;

        if (stipulation == 0) {
            speed = super.getMiningSpeed(stack, state);
        } else {
            speed = 0.5f;
        }

        return speed;
    }
}
