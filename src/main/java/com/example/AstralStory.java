package com.example;

import com.example.block.ModBlocks;
import com.example.item.ModItemGroups;
import com.example.item.ModItems;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AstralStory implements ModInitializer {
	public static final String MOD_ID = "astralstory";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.registerModItems();
		ModBlocks.registerBlocks();

		ModItemGroups.registerItemGroups();
	}
}