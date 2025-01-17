package com.nesterofffl.utilities.datagen;

import com.nesterofffl.utilities.block.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLootTableProvider;
import net.minecraft.data.DataWriter;
import net.minecraft.loot.LootTable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;
import java.util.function.BiConsumer;

public class ModLootTableProvider extends FabricBlockLootTableProvider {

    public ModLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate()
    {
        addDrop(ModBlocks.Sanded_Cobblestone);
        addDrop(ModBlocks.Sanded_Stone);
        addDrop(ModBlocks.Coconut_Log);
        addDrop(ModBlocks.Coconut_Planks);
        addDrop(ModBlocks.Sandstone_Bricks);

    }
}
