package com.zergv.gunpowder;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.*;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GunpowderInit implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger("gunpowder");
	public static final Item SULFUR = registerItem("sulfur", new Sulfur(new FabricItemSettings()));

	public static final Item registerItem(String name, Item item)
	{
		return Registry.register(Registries.ITEM, new Identifier("gunpowder", name), item);
	}

	public static final RegistryKey<ItemGroup> ITEM_GROUP = RegistryKey.of(
			RegistryKeys.ITEM_GROUP,
			new Identifier("gunpowder", "ingredients")
	);

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		LOGGER.info("Loading Gunpowder Mod Items");

		Registry.register(Registries.ITEM_GROUP, ITEM_GROUP,
				FabricItemGroup.builder()
				.displayName(Text.literal("Ingredients"))
				.icon(() -> new ItemStack(Items.DIAMOND))
				.entries((enabledFeatures, entries) -> { entries.add(SULFUR); })
				.build());
	}
}
