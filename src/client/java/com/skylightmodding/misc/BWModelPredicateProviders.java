package com.skylightmodding.misc;

import com.skylightmodding.BeautifulWorld;
import com.skylightmodding.init.BWDataComponents;
import com.skylightmodding.init.BWItems;

import net.minecraft.client.item.ModelPredicateProviderRegistry;
import net.minecraft.util.Identifier;

public class BWModelPredicateProviders {
    public static void register() {
        ModelPredicateProviderRegistry.register(BWItems.AMULET_OF_CREATION, Identifier.of(BeautifulWorld.MOD_ID, "aoc_stage"), (itemStack, clientWorld, livingEntity, seed) -> {
            if (livingEntity == null || livingEntity.getActiveItem() != itemStack) {
                return 0.0F;
            }
            return livingEntity.getActiveItem().getOrDefault(BWDataComponents.AMULET_OF_CREATION_STAGE, 0) / 4.0f;
        });
    }
}
