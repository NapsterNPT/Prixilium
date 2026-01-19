package net.napsternpt.prexilium;

import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Prexilium implements ModInitializer {
	public static final String MOD_ID = "prexilium";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("Loading Prexilium");
	}
}