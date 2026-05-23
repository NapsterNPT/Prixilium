package net.napsternpt.prixilium.item.custom;

import net.minecraft.item.Item;

public class CharmSettings extends Item.Settings {
    private boolean upgradable = false;
    private boolean specializable = false;

    public CharmSettings() {
        super();
    }

    public CharmSettings upgradable() {
        this.upgradable = true;
        return this;
    }

    public CharmSettings specializable() {
        this.specializable = true;
        return this;
    }

    public boolean isUpgradable() {
        return this.upgradable;
    }

    public boolean isSpecializable() {
        return this.specializable;
    }
}