package com.skylightmodding.mixin;

import com.skylightmodding.blocks.InfectedBlock;
import com.skylightmodding.blocks.components.BWProperties;

import net.minecraft.block.BlockState;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.LavaFluid;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.WorldAccess;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

//@Mixin(LavaFluid.class)
//public class LavaFluidMixin {
//    @Inject(
//            at = @At("HEAD"),
//            cancellable = true,
//            method = "flow(Lnet/minecraft/world/WorldAccess;Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/block/BlockState;Lnet/minecraft/util/math/Direction;Lnet/minecraft/fluid/FluidState;)V"
//    )
//    private void init(WorldAccess world, BlockPos pos, BlockState state, Direction direction, FluidState fluidState, CallbackInfo info) {
//        BlockState stateWest = world.getBlockState(pos.west());
//        BlockState stateEast = world.getBlockState(pos.east());
//        BlockState stateNorth = world.getBlockState(pos.north());
//        BlockState stateSouth = world.getBlockState(pos.south());
//        BlockState stateUp = world.getBlockState(pos.up());
//        BlockState stateDown = world.getBlockState(pos.down());
//
//        if (stateWest.getBlock() instanceof InfectedBlock) {
//            world.setBlockState(pos.west(), stateWest.getBlock().getDefaultState().with(BWProperties.PROTECTED, true), 3);
//        }
//        if (stateSouth.getBlock() instanceof InfectedBlock) {
//            world.setBlockState(pos.south(), stateSouth.getBlock().getDefaultState().with(BWProperties.PROTECTED, true), 3);
//        }
//        if (stateDown.getBlock() instanceof InfectedBlock) {
//            world.setBlockState(pos.down(), stateDown.getBlock().getDefaultState().with(BWProperties.PROTECTED, true), 3);
//        }
//        if (stateUp.getBlock() instanceof InfectedBlock) {
//            world.setBlockState(pos.up(), stateUp.getBlock().getDefaultState().with(BWProperties.PROTECTED, true), 3);
//        }
//        if (stateNorth.getBlock() instanceof InfectedBlock) {
//            world.setBlockState(pos.north(), stateNorth.getBlock().getDefaultState().with(BWProperties.PROTECTED, true), 3);
//        }
//        if (stateEast.getBlock() instanceof InfectedBlock) {
//            world.setBlockState(pos.east(), stateEast.getBlock().getDefaultState().with(BWProperties.PROTECTED, true), 3);
//        }
//    }
//}
