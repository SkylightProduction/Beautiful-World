package com.skylightmodding.blocks.components;

import net.minecraft.block.WoodType;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundEvents;

public class BWWoodType {
    public static final WoodType PITAHAYA = new WoodType(
            "pitahaya",
            BWBlockSetType.PITAHAYA,
            BlockSoundGroup.CHERRY_WOOD,
            BlockSoundGroup.CHERRY_WOOD_HANGING_SIGN,
            SoundEvents.BLOCK_CHERRY_WOOD_FENCE_GATE_CLOSE,
            SoundEvents.BLOCK_CHERRY_WOOD_FENCE_GATE_OPEN
    );
}
