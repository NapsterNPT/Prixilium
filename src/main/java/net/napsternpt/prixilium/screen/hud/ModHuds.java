package net.napsternpt.prixilium.screen.hud;

import net.napsternpt.prixilium.Prixilium;

public class ModHuds {

    static {ThermometerHud.register();}

    public static void registerHuds() {
        Prixilium.LOGGER.info("Registering Prixilium HUDs.");
    }
}