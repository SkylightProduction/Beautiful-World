package com.skylightmodding.worldgen.tree;

import com.skylightmodding.worldgen.BWConfiguredFeatures;

import net.minecraft.block.SaplingGenerator;

import java.util.Optional;

public class BWSaplingGenerator {
    public static final SaplingGenerator PITAHAYA_TREE_SAPLING_GEN =
            new SaplingGenerator(
                    "pitahaya_tree_sapling_gen",
                    0.1F,
                    Optional.empty(),
                    Optional.empty(),
                    Optional.of(BWConfiguredFeatures.PITAHAYA_TREE),
                    Optional.empty(),
                    Optional.empty(),
                    Optional.empty()
            );
    public static final SaplingGenerator INFECTED_OAK_SAPLING_GEN =
            new SaplingGenerator(
                    "infected_oak_sapling_gen",
                    0.1F,
                    Optional.empty(),
                    Optional.empty(),
                    Optional.of(BWConfiguredFeatures.INFECTED_OAK),
                    Optional.empty(),
                    Optional.empty(),
                    Optional.empty()
            );

}

