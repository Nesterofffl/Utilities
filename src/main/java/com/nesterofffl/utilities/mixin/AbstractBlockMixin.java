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
            var dirs = new BlockPos[] {
                    blockPos.north(),
                    blockPos.south(),
                    blockPos.west(),
                    blockPos.east(),
                    blockPos.up(),
                    blockPos.down()
            };

            for (var dir : dirs) {
                // Тут можешь отрегулировать шанс.
                var roll = random.nextFloat();

                // Если в этом рандом-тике выпало 0-0.75, пропуск (25% шанс стать твоей хуйнёй хз)
                if (roll <= 0.5f) continue;

                var block = serverWorld.getBlockState(dir);
                if (block.isOf(Blocks.STONE)) {
                    serverWorld.setBlockState(dir, ModBlocks.Sanded_Stone.getDefaultState());
                }
            }
        }

    }



    @Inject(method = "hasRandomTicks", at = @At(value = "HEAD"), cancellable = true)
    protected void hasRandomTicks(CallbackInfoReturnable<Boolean> cir) {
        if (Blocks.SAND.equals(this.getBlock())) {
            cir.setReturnValue(true);
        }
    }
}
