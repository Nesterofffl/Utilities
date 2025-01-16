package com.nesterofffl.utilities.mixin;

import com.nesterofffl.utilities.Utilities;
import com.nesterofffl.utilities.block.ModBlocks;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.block.WireOrientation;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value = AbstractBlock.AbstractBlockState.class)
public class AbstractBlockMixin {
    @Shadow
    private Block getBlock() { return null; };

    @Shadow
    private BlockState asBlockState() { return null; }

    @Inject(method = "randomTick", at = @At(value = "HEAD"))
    protected void randomTick(ServerWorld serverWorld, BlockPos blockPos, Random random, CallbackInfo ci) {
        if (Blocks.SAND.equals(this.getBlock())) {

            serverWorld.setBlockState(blockPos.add(1,0,0), ModBlocks.Sanded_Stone.getDefaultState());

        }

    }



    @Inject(method = "hasRandomTicks", at = @At(value = "HEAD"), cancellable = true)
    protected void hasRandomTicks(CallbackInfoReturnable<Boolean> cir) {
        if (Blocks.SAND.equals(this.getBlock())) {
            cir.setReturnValue(true);
        }
    }
}
