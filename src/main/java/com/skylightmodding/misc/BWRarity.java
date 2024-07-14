package com.skylightmodding.misc;

import net.minecraft.util.Formatting;
import net.minecraft.util.StringIdentifiable;

public enum BWRarity implements StringIdentifiable {
    INFECTION(0, "infection", Formatting.BLACK);

    private final int index;
    private final String name;
    private final Formatting formatting;

    private BWRarity(final int index, final String name, final Formatting formatting) {
        this.index = index;
        this.name = name;
        this.formatting = formatting;
    }

    public Formatting getFormatting() {
        return this.formatting;
    }

    public String asString() {
        return this.name;
    }
}
