package net.cass.blahaj;

import net.cass.blahaj.block.ModBlocks;
import net.cass.blahaj.item.ModItems;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Blahaj implements ModInitializer {
	public static final String MOD_ID = "cassblahaj";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();

		LOGGER.info("Hello Fabric world!");
	}
}