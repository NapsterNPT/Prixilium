package net.napsternpt.prixilium.client;

import net.napsternpt.prixilium.item.custom.CharmItem;
import software.bernie.geckolib.renderer.GeoItemRenderer;

public class CharmItemRenderer extends GeoItemRenderer<CharmItem> {
    public CharmItemRenderer() {
        super(new CharmItemModel());
    }
}