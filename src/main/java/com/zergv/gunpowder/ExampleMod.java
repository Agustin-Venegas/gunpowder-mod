package com.zergv.gunpowder;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.*;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExampleMod implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger("gunpowder");
	public static final Item SULFUR = registerItem("sulfur", new Sulfur(new FabricItemSettings()));

	//public static final ItemGroup MISC = FabricItemGroup.builder(new Identifier("gunpowder", "my_item_group_id"))
    //        .icon(() -> new ItemStack(ModItems.ITEM_NAME))
    //        .build();

	public static final Item registerItem(String name, Item item)
	{
		return Registry.register(Registries.ITEM, new Identifier("gunpowder", name), item);
	}

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		LOGGER.info("Hello Fabric world!");
		//registerItem("Sulfur", new Item(new FabricItemSettings()));

		ItemGroup ITEM_GROUP = FabricItemGroup.builder(
			new Identifier("gunpowder", "ingredients"))
			.displayName(Text.literal("Ingredients"))
			.icon(() -> new ItemStack(Items.DIAMOND))
			.entries((enabledFeatures, entries, operatorEnabled) -> { entries.add(SULFUR); })
			.build();

		//ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> entries.add(SULFUR));
	}
}
