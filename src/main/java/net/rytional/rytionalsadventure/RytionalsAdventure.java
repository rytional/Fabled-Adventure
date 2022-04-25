package net.rytional.rytionalsadventure;

import net.fabricmc.api.ModInitializer;
import net.rytional.rytionalsadventure.block.ModBlocks;
import net.rytional.rytionalsadventure.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RytionalsAdventure implements ModInitializer {
	public static final String MOD_ID = "rytionalsadventure";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();

	}
}
