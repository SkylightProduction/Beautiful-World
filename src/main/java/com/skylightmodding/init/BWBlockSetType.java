package com.skylightmodding.init;

import net.minecraft.block.BlockSetType;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundEvents;

public class BWBlockSetType  {
    public static final BlockSetType PITAHAYA = new BlockSetType(
            "pitahaya",
            true,
            true,
            true,
            BlockSetType.ActivationRule.EVERYTHING,
            BlockSoundGroup.CHERRY_WOOD,
            SoundEvents.BLOCK_CHERRY_WOOD_DOOR_CLOSE,
            SoundEvents.BLOCK_CHERRY_WOOD_DOOR_OPEN,
            SoundEvents.BLOCK_CHERRY_WOOD_TRAPDOOR_CLOSE,
            SoundEvents.BLOCK_CHERRY_WOOD_TRAPDOOR_OPEN,
            SoundEvents.BLOCK_CHERRY_WOOD_PRESSURE_PLATE_CLICK_OFF,
            SoundEvents.BLOCK_CHERRY_WOOD_PRESSURE_PLATE_CLICK_ON,
            SoundEvents.BLOCK_CHERRY_WOOD_BUTTON_CLICK_OFF,
            SoundEvents.BLOCK_CHERRY_WOOD_BUTTON_CLICK_ON
    );
}
