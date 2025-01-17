package com.nesterofffl.utilities.datagen;

import com.nesterofffl.utilities.block.ModBlocks;
import com.nesterofffl.utilities.item.ModItems;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.client.data.BlockStateModelGenerator;
import net.minecraft.client.data.ItemModelGenerator;
import net.minecraft.client.data.Models;
import net.minecraft.client.data.TexturedModel;

public class ModModelProvider extends FabricModelProvider
{

    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator)
    {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.Sandstone_Bricks);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.Sanded_Stone);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.Sanded_Cobblestone);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.Coconut_Planks);
        blockStateModelGenerator.registerLog(ModBlocks.Coconut_Log).log(ModBlocks.Coconut_Log).wood(ModBlocks.Coconut_Wood);
        blockStateModelGenerator.registerLog(ModBlocks.Stripped_Coconut_Log).log(ModBlocks.Stripped_Coconut_Log);
        blockStateModelGenerator.registerSingleton(ModBlocks.Coconut_Leaves, TexturedModel.LEAVES);
        //blockStateModelGenerator.registerGrassTinted(ModBlocks.Oasis_Grass);

    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator)
    {
        itemModelGenerator.register(ModItems.Dried_Leather, Models.GENERATED);
        itemModelGenerator.register(ModItems.Art_Leather, Models.GENERATED);
    }
}
