package net.napsternpt.prixilium.util;

import net.fabricmc.fabric.api.gamerule.v1.GameRuleFactory;
import net.fabricmc.fabric.api.gamerule.v1.GameRuleRegistry;
import net.minecraft.world.GameRules;
import net.napsternpt.prixilium.Prixilium;

public class ModGameRules {
    public static final GameRules.Key<GameRules.BooleanRule> ALLOW_ILLNESS = GameRuleRegistry.register("allowIllness",
            GameRules.Category.PLAYER,
            GameRuleFactory.createBooleanRule(true));

    public static final GameRules.Key<GameRules.BooleanRule> PRIXILIUM_EXPANDS = GameRuleRegistry.register("prixiliumExpands",
            GameRules.Category.UPDATES,
            GameRuleFactory.createBooleanRule(true));

    public static void registerGameRules() {
        Prixilium.LOGGER.info("Registering Prixilium GameRules.");
    }
}
