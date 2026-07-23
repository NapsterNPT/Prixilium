package net.napsternpt.prixilium.screen;

import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.napsternpt.prixilium.Prixilium;
import net.napsternpt.prixilium.screen.custom.ObeliskOfCharmsScreenHandler;


public class ModScreenHandlers {
    public static final ScreenHandlerType<ObeliskOfCharmsScreenHandler> OBELISK_OF_CHARMS_SCREEN_HANDLER =
            Registry.register(Registries.SCREEN_HANDLER, Identifier.of(Prixilium.MOD_ID, "obelisk_of_charms_screen_handler"),
                    new ExtendedScreenHandlerType<>(ObeliskOfCharmsScreenHandler::new, BlockPos.PACKET_CODEC));

    public static void registerScreenHandlers() {
        Prixilium.LOGGER.info("Registering Prixilium Screen Handlers.");
    }
}
