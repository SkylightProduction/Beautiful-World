package com.skylightmodding.items;

import com.skylightmodding.init.BWStatusEffects;
import com.skylightmodding.misc.TooltipTemplates;

import net.minecraft.advancement.criterion.Criteria;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsage;
import net.minecraft.item.Items;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.UseAction;
import net.minecraft.world.World;

import java.util.List;

public class BaikalWaterItem extends Item {
    public BaikalWaterItem(Item.Settings settings) {
        super(settings);
    }

    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
        super.finishUsing(stack, world, user);
        if (user instanceof ServerPlayerEntity serverPlayerEntity) {
            Criteria.CONSUME_ITEM.trigger(serverPlayerEntity, stack);
            serverPlayerEntity.incrementStat(Stats.USED.getOrCreateStat(this));
        }

        if (!world.isClient) {
            user.removeStatusEffect(StatusEffects.POISON);
            user.removeStatusEffect(StatusEffects.RAID_OMEN);
            user.removeStatusEffect(StatusEffects.HUNGER);
            user.removeStatusEffect(StatusEffects.WITHER);
            user.removeStatusEffect(BWStatusEffects.INFECTION);
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.HEALTH_BOOST, 2400, 10));
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 2400, 10));
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.INSTANT_HEALTH, 2, 10));
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 2400, 10));
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, 2400, 3));
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 2400, 10));
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.LUCK, 2400, 10));
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.HASTE, 2400, 10));
        }

        if (stack.isEmpty()) {
            return new ItemStack(Items.GLASS_BOTTLE);
        } else {
            if (user instanceof PlayerEntity) {
                PlayerEntity playerEntity = (PlayerEntity)user;
                if (!playerEntity.isInCreativeMode()) {
                    ItemStack itemStack = new ItemStack(Items.GLASS_BOTTLE);
                    if (!playerEntity.getInventory().insertStack(itemStack)) {
                        playerEntity.dropItem(itemStack, false);
                    }
                }
            }

            return stack;
        }
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        tooltip.add(TooltipTemplates.ONLY_FOR_CREATIVE);
    }

    public int getMaxUseTime(ItemStack stack) {
        return 40;
    }

    public UseAction getUseAction(ItemStack stack) {
        return UseAction.DRINK;
    }

    public SoundEvent getDrinkSound() {
        return SoundEvents.ITEM_HONEY_BOTTLE_DRINK;
    }

    public SoundEvent getEatSound() {
        return SoundEvents.ITEM_HONEY_BOTTLE_DRINK;
    }

    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        return ItemUsage.consumeHeldItem(world, user, hand);
    }
}
