package net.napsternpt.prixilium.screen;

import net.napsternpt.prixilium.Prixilium;
import net.napsternpt.prixilium.screen.custom.ThermometerScreen;

public class ModScreens {

    static {
        ThermometerScreen.register();
    }

    public static void registerScreens() {
        Prixilium.LOGGER.info("Registering Prixilium Screens.");
    }
}