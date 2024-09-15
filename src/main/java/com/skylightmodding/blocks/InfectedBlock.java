package com.skylightmodding.blocks;

import com.skylightmodding.init.BWStatusEffects;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.world.BlockView;

public class InfectedBlock extends Block {
    public InfectedBlock(Block.Settings settings) {
        super(settings);
    }

    @Override
    public void onEntityLand(BlockView world, Entity entity) {
        super.onEntityLand(world, entity);
        LivingEntity living = (LivingEntity) entity;
        if (!living.hasStatusEffect(BWStatusEffects.IMMUNITY)) {
            living.addStatusEffect(new StatusEffectInstance(BWStatusEffects.INFECTION, 1200, 0));
        }
    }

    // TODO: Сделать возможность распространения
}
