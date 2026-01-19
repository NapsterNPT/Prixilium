package net.napsternpt.prixilium;

import net.fabricmc.api.ModInitializer;

import net.napsternpt.prixilium.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Prixilium implements ModInitializer {
	public static final String MOD_ID = "prixilium";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.registerModItems();
	}
}