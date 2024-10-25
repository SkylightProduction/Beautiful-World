package com.skylightmodding.worldgen.tree.placers;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import com.skylightmodding.worldgen.tree.BWTreesHell;

import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.floatprovider.FloatProvider;
import net.minecraft.util.math.intprovider.IntProvider;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.TestableWorld;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.foliage.FoliagePlacer;
import net.minecraft.world.gen.trunk.TrunkPlacer;
import net.minecraft.world.gen.trunk.TrunkPlacerType;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;

public class PitahayaTreeTrunkPlacer extends TrunkPlacer {
    public static final MapCodec<PitahayaTreeTrunkPlacer> CODEC = RecordCodecBuilder.mapCodec(instance -> instance.group(
            IntProvider.VALUE_CODEC.fieldOf("max_branch_range").forGetter(placer -> placer.maxBranchRange),
            IntProvider.VALUE_CODEC.fieldOf("branch_count").forGetter(placer -> placer.branchCount),
            FloatProvider.VALUE_CODEC.fieldOf("branch_range").forGetter(placer -> placer.branchRange),
            FloatProvider.VALUE_CODEC.fieldOf("branch_height").forGetter(placer -> placer.branchHeight),
            Codec.INT.fieldOf("base_height").forGetter(placer -> placer.baseHeight),
            Codec.INT.fieldOf("height_rand_a").forGetter(placer -> placer.firstRandomHeight),
            Codec.INT.fieldOf("height_rand_b").forGetter(placer -> placer.secondRandomHeight)
    ).apply(instance, PitahayaTreeTrunkPlacer::new));
    private static final Direction[] directions = new Direction[] {Direction.NORTH, Direction.EAST, Direction.SOUTH, Direction.WEST};
    private final IntProvider maxBranchRange, branchCount;
    private final FloatProvider branchHeight, branchRange;

    public PitahayaTreeTrunkPlacer(IntProvider maxBranchRange, IntProvider branchCount, FloatProvider branchRange, FloatProvider branchHeight, int baseHeight, int firstRandomHeight, int secondRandomHeight) {
        super(baseHeight, firstRandomHeight, secondRandomHeight);
        this.maxBranchRange = maxBranchRange; // Furthest a branch can go from the tree
        this.branchCount = branchCount; // Amount of branches to generate
        this.branchHeight = branchHeight; // Variable height of the branches
        this.branchRange = branchRange; // Variable range of branches
    }

    @Override
    protected TrunkPlacerType<?> getType() {
        return BWTreesHell.PITAHAYA_TREE_TRUNK;
    }

    @Override
    public List<FoliagePlacer.TreeNode> generate(TestableWorld world, BiConsumer<BlockPos, BlockState> replacer, Random random, int height, BlockPos startPos, TreeFeatureConfig config) {
        List<FoliagePlacer.TreeNode> nodes = new ArrayList<>();

        int firstHeight = random.nextInt(baseHeight) + baseHeight / 2 + 1;
        for (int i = 0; i <= firstHeight + 1; i++) {
            getAndSetState(world, replacer, random, startPos.up(i), config);
        }

        BlockPos trunkTop = startPos.up(firstHeight - 2);
        nodes.add(new FoliagePlacer.TreeNode(trunkTop.up(3), 0, false));

        int offset, previous;
        float a, b;
        Direction dir, dir2;
        int yOffset = 0;
        for (int i = 0; i < branchCount.get(random); i++) {
            offset = 1;
            previous = 0;
            a = branchHeight.get(random);
            b = branchRange.get(random);
            dir = randomDirection(random);
            dir2 = random.nextBoolean() ? dir.rotateYClockwise() : dir.rotateYCounterclockwise();
            while (offset <= maxBranchRange.getMax()) {
                yOffset = trunkFunc(offset, a, b);
                if (yOffset < 1) {
                    break;
                }
                if (previous == yOffset) {
                    getAndSetState(world, replacer, random, trunkTop.up(yOffset).offset(dir, offset).offset(dir2, offset / 2), config);
                } else {
                    for (int y = previous + 1; y <= yOffset; y++) {
                        getAndSetState(world, replacer, random, trunkTop.up(y).offset(dir, offset).offset(dir2, offset / 2), config);
                    }
                }
                offset++;
                previous = yOffset;
            }
            trunkTop = trunkTop.up();
            nodes.add(new FoliagePlacer.TreeNode(trunkTop.up(previous - 1).offset(dir, offset - 2).offset(dir2, offset / 4), 0, false));
        }

        return nodes;
    }

    private int trunkFunc(float x, float a, float b) {
        return (int) Math.ceil(-Math.log((2 * a / x) - b) + 3);
    }

    private Direction randomDirection(Random random) {
        return directions[random.nextInt(directions.length)];
    }
}
