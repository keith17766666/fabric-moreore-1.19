package com.keith.moreore;

import com.keith.moreore.block.ModBlocks;
import com.keith.moreore.item.ModItemGroup;
import com.keith.moreore.item.ModItems;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MoreOre implements ModInitializer {
	public static final String MOD_ID = "moreore";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItemGroup.registerItemGroups();
		ModItems.RegisterModItems();

		ModBlocks.registerModBlocks();
	}
}
