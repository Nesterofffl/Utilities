package com.nesterofffl.utilities.block;

import com.nesterofffl.utilities.Utilities;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ModBlocks {


    public static final Block Coconut_Log = registerBlock("coconut_log", new Block(AbstractBlock.Settings.create()
            .strength(2f).requiresTool().sounds(BlockSoundGroup.WOOD).registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Utilities.MOD_ID,"coconut_log")))));

    public static final Block Coconut_Planks = registerBlock("coconut_planks", new Block(AbstractBlock.Settings.create()
            .strength(2f).requiresTool().sounds(BlockSoundGroup.WOOD).registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Utilities.MOD_ID,"coconut_planks")))));

    public static final Block Coconut_Leaves = registerBlock("coconut_leaves", new Block(AbstractBlock.Settings.create()
            .strength(1f).sounds(BlockSoundGroup.CHERRY_LEAVES).registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Utilities.MOD_ID,"coconut_leaves")))));


    private static Block registerBlock(String name, Block block)
    {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(Utilities.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block)
    {
        Registry.register(Registries.ITEM, Identifier.of(Utilities.MOD_ID, name),
                new BlockItem(block, new Item.Settings().registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Utilities.MOD_ID, name))).useBlockPrefixedTranslationKey()));
    }

    public static void registerModBlocks() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {
            entries.add(ModBlocks.Coconut_Log);
            entries.add(ModBlocks.Coconut_Planks);
            entries.add(ModBlocks.Coconut_Leaves);
        });
    }
}
