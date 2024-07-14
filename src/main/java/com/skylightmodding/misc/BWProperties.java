package com.skylightmodding.misc;

import net.minecraft.state.property.IntProperty;

public class BWProperties {
    public static final IntProperty STAGE_LVL;

    static {
        STAGE_LVL = IntProperty.of("stage_lvl", 0, 4);
    }
}
