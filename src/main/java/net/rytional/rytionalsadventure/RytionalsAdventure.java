package net.rytional.rytionalsadventure;

import net.fabricmc.api.ModInitializer;
import net.rytional.rytionalsadventure.block.ModBlocks;
import net.rytional.rytionalsadventure.effect.ModEffects;
import net.rytional.rytionalsadventure.enchantment.ModEnchantments;
import net.rytional.rytionalsadventure.item.ModItems;
import net.rytional.rytionalsadventure.potion.ModPotions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import software.bernie.geckolib3.GeckoLib;

public class RytionalsAdventure implements ModInitializer {
	public static final String MOD_ID = "rytionalsadventure";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		ModEnchantments.registerModEnchantments();
		ModEffects.registerEffects();
		ModPotions.registerPotions();

		GeckoLib.initialize();
	}

}
