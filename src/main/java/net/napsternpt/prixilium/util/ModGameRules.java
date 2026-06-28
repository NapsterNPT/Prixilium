package net.napsternpt.prixilium.util;

import net.fabricmc.fabric.api.gamerule.v1.GameRuleBuilder;
import net.minecraft.util.Identifier;
import net.minecraft.world.rule.GameRule;
import net.minecraft.world.rule.GameRuleCategory;
import net.napsternpt.prixilium.Prixilium;

public class ModGameRules {
    public static final GameRule<Boolean> ALLOW_ILLNESS = GameRuleBuilder.forBoolean(true)
            .category(GameRuleCategory.PLAYER)
            .buildAndRegister(Identifier.of(Prixilium.MOD_ID, "allow_illness"));

    public static final GameRule<Boolean> PRIXILIUM_EXPANDS = GameRuleBuilder.forBoolean(true)
            .category(GameRuleCategory.UPDATES)
            .buildAndRegister(Identifier.of(Prixilium.MOD_ID, "prixilium_expands"));

    public static void registerGameRules() {
        Prixilium.LOGGER.info("Registering Prixilium GameRules.");
    }
}
