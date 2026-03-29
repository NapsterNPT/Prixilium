package net.napsternpt.prixilium.world.tree;

import net.minecraft.block.SaplingGenerator;
import net.minecraft.util.Identifier;
import net.napsternpt.prixilium.Prixilium;
import net.napsternpt.prixilium.world.ModConfiguredFeatures;

import java.util.Optional;

public class ModSaplingGenerators {
    public static final SaplingGenerator PRIXILIUM = new SaplingGenerator(Prixilium.MOD_ID + ":prixilium",
            Optional.empty(), Optional.of(ModConfiguredFeatures.PRIXILIUM_KEY), Optional.empty());
}
