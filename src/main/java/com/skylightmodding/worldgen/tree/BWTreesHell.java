package com.skylightmodding.worldgen.tree;

import com.mojang.serialization.MapCodec;

import com.skylightmodding.BeautifulWorld;
import com.skylightmodding.worldgen.tree.placers.PitahayaTreeFoliagePlacer;
import com.skylightmodding.worldgen.tree.placers.PitahayaTreeTrunkPlacer;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.foliage.FoliagePlacer;
import net.minecraft.world.gen.foliage.FoliagePlacerType;
import net.minecraft.world.gen.trunk.TrunkPlacer;
import net.minecraft.world.gen.trunk.TrunkPlacerType;

public class BWTreesHell {
    public static FoliagePlacerType<PitahayaTreeFoliagePlacer> PITAHAYA_TREE_FOLIAGE = registerFoliage("pitahaya_tree_foliage_placer", PitahayaTreeFoliagePlacer.CODEC);
    public static TrunkPlacerType<PitahayaTreeTrunkPlacer> PITAHAYA_TREE_TRUNK = registerTrunk("pitahaya_tree_trunk_placer", PitahayaTreeTrunkPlacer.CODEC);


    private static <P extends FoliagePlacer> FoliagePlacerType<P> registerFoliage(String name, MapCodec<P> codec) {
        return Registry.register(Registries.FOLIAGE_PLACER_TYPE, Identifier.of(BeautifulWorld.MOD_ID, name), new FoliagePlacerType(codec));
    }

    private static <P extends TrunkPlacer> TrunkPlacerType<P> registerTrunk(String name, MapCodec<P> codec) {
        return Registry.register(Registries.TRUNK_PLACER_TYPE, Identifier.of(BeautifulWorld.MOD_ID, name), new TrunkPlacerType(codec));
    }

    public static void registerTreesHell() {
        BeautifulWorld.LOGGER.info("Registering Trees Hell from " + BeautifulWorld.MOD_ID);
    }
}
