package com.nesterofffl.utilities.datagen;

import com.nesterofffl.utilities.block.ModBlocks;
import com.nesterofffl.utilities.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.recipe.RecipeExporter;
import net.minecraft.data.recipe.RecipeGenerator;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {


    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected RecipeGenerator getRecipeGenerator(RegistryWrapper.WrapperLookup registryLookup, RecipeExporter exporter) {
        return new RecipeGenerator(registryLookup, exporter) {
            @Override
            public void generate() {
                RegistryWrapper.Impl<Item> itemLookup = registries.getOrThrow(RegistryKeys.ITEM);

                List<ItemConvertible> Dried_Leather_Smeltables = List.of(Items.ROTTEN_FLESH);
                offerSmelting(Dried_Leather_Smeltables, RecipeCategory.MISC, ModItems.Dried_Leather,0.1f, 200, "art_leather");



                offerShapelessRecipe(ModBlocks.Coconut_Planks, ModBlocks.Coconut_Log, "BUILDING_BLOCKS", 4 );
                //List<ItemConvertible> Dried_Leather_craft = List.of(Items.STRING, ModItems.Dried_Leather);
                //offerShapelessRecipe(ModItems.Art_Leather, Dried_Leather_craft, "BUILDING_BLOCKS", 4 );
                //createShapeless(RecipeCategory.MISC, ModItems.Art_Leather).input(Items.STRING).offerTo(exporter);
                createShapeless(RecipeCategory.MISC, ModItems.Art_Leather)
                        .input(Items.STRING).input(ModItems.Dried_Leather) // You can also specify an int to require more than one, or a tag to accept multiple things
                        // Create an advancement that gives you the recipe
                        .criterion(hasItem(ModItems.Dried_Leather), conditionsFromItem(ModItems.Dried_Leather))
                        .offerTo(exporter);

            }
        };
    }

    @Override
    public String getName() {
        return "FabricDocsReferenceRecipeProvider";
    }
}
