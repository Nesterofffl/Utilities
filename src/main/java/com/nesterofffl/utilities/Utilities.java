package com.nesterofffl.utilities;

import com.nesterofffl.utilities.block.ModBlocks;
import com.nesterofffl.utilities.item.ModItemGroups;
import com.nesterofffl.utilities.item.ModItems;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.server.world.BlockEvent;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Utilities implements ModInitializer {
	public static final String MOD_ID = "utilities";

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		ModItemGroups.registerItemGroups();

		StrippableBlockRegistry.register(ModBlocks.Coconut_Log, ModBlocks.Stripped_Coconut_Log);
		StrippableBlockRegistry.register(ModBlocks.Coconut_Wood, ModBlocks.Stripped_Coconut_Wood);
	}
}