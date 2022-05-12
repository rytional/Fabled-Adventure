package net.rytional.fabledadventure;

import net.fabricmc.api.ModInitializer;
import net.rytional.fabledadventure.block.ModBlocks;
import net.rytional.fabledadventure.effect.ModEffects;
import net.rytional.fabledadventure.enchantment.ModEnchantments;
import net.rytional.fabledadventure.item.ModItems;
import net.rytional.fabledadventure.potion.ModPotions;
import net.rytional.fabledadventure.util.ModRegistries;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import software.bernie.geckolib3.GeckoLib;

public class FabledAdventure implements ModInitializer {
	public static final String MOD_ID = "fabledadventure";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		ModEnchantments.registerModEnchantments();
		ModEffects.registerEffects();
		ModPotions.registerPotions();
		ModRegistries.registerModStuffs();

		GeckoLib.initialize();
	}

}
