package com.nesterofffl.utilities.item;

import com.nesterofffl.utilities.Utilities;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class ModItems {

    public static final Item Dried_Leather = registerItem("dried_leather", new Item(new Item.Settings().
            registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Utilities.MOD_ID,"dried_leather")))));

    public static final Item Art_Leather = registerItem("art_leather", new Item(new Item.Settings().
            registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Utilities.MOD_ID,"art_leather")))));

    private static Item registerItem(String name, Item item)
    {
        return Registry.register(Registries.ITEM, Identifier.of(Utilities.MOD_ID, name), item);
    }

    public static void registerModItems()
    {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS)
                .register((itemGroup) ->
                {
                    itemGroup.add(ModItems.Dried_Leather);
                    itemGroup.add(ModItems.Art_Leather);
                });
    }

}
