package com.skylightmodding.worldgen.tree.placers;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.intprovider.IntProvider;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.TestableWorld;
import net.minecraft.world.gen.feature.TreeFeature;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.foliage.FoliagePlacer;
import net.minecraft.world.gen.foliage.FoliagePlacerType;

import com.google.common.collect.Sets;

import com.mojang.datafixers.Products;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import com.skylightmodding.worldgen.tree.BWTreesHell;

import java.util.Set;

public class PitahayaTreeFoliagePlacer extends FoliagePlacer {
    public static final MapCodec<PitahayaTreeFoliagePlacer> CODEC = RecordCodecBuilder.mapCodec((instance) -> createCodec(instance).apply(instance, PitahayaTreeFoliagePlacer::new));
    protected static <P extends PitahayaTreeFoliagePlacer> Products.P2<RecordCodecBuilder.Mu<P>, IntProvider, IntProvider> createCodec(RecordCodecBuilder.Instance<P> builder) {
        return fillFoliagePlacerFields(builder);
    }

    public PitahayaTreeFoliagePlacer(IntProvider radius, IntProvider offset) {
        super(radius, offset);
    }

    @Override
    protected FoliagePlacerType<?> getType() {
        return BWTreesHell.PITAHAYA_TREE_FOLIAGE;
    }

    @Override
    protected void generate(TestableWorld world, BlockPlacer placer, Random random, TreeFeatureConfig config, int trunkHeight, TreeNode treeNode, int foliageHeight, int radius, int offset) {
        Set<BlockPos> leaves = Sets.newHashSet();
        BlockPos nodePos = treeNode.getCenter();
        BlockPos altNodePos = nodePos.up(offset);
        BlockState leafBlock = config.foliageProvider.get(random, nodePos);

        for (int i = -radius; i <= radius; i++) {
            for (int j = -radius; j <= radius; j++) {
                for (int k = 0; k < radius; k++) {
                    BlockPos offPos = nodePos.add(i - k, k, j - k);
                    if ((world.testBlockState(offPos, AbstractBlock.AbstractBlockState::isAir) || TreeFeature.canReplace(world, offPos)) && offPos.isWithinDistance(random.nextBoolean() ? nodePos : altNodePos, radius)) {
                        placer.placeBlock(offPos, leafBlock);
                        leaves.add(offPos);
                    }
                }
            }
        }
    }

    @Override
    public int getRandomHeight(Random random, int trunkHeight, TreeFeatureConfig config) {
        return 0;
    }

    @Override
    protected boolean isInvalidForLeaves(Random random, int baseHeight, int dx, int y, int dz, boolean giantTrunk) {
        return false;
    }
}
