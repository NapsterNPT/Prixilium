package net.napsternpt.prixilium.item;

import net.minecraft.component.DataComponentTypes;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.napsternpt.prixilium.Prixilium;

public class PrixiliumItemSettings extends Item.Settings {
    @Override
    public Item.Settings rarity(Rarity rarity) {
        super.rarity(rarity);
        if (rarity != Rarity.COMMON) {
            super.component(DataComponentTypes.TOOLTIP_STYLE, Identifier.of(Prixilium.MOD_ID, rarity.asString()));
        }
        return this;
    }
}
