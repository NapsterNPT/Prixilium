package net.napsternpt.prixilium.client;

import net.minecraft.util.Identifier;
import net.napsternpt.prixilium.Prixilium;
import net.napsternpt.prixilium.item.custom.CharmItem;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.base.GeoRenderState;

public class CharmItemModel extends GeoModel<CharmItem> {
    @Override
    public Identifier getModelResource(GeoRenderState renderState) {
        return Identifier.of(Prixilium.MOD_ID, "charm_i");
    }

    @Override
    public Identifier getTextureResource(GeoRenderState renderState) {
        return Identifier.of(Prixilium.MOD_ID, "textures/item/charm_i_3d.png");
    }

    @Override
    public Identifier getAnimationResource(CharmItem animatable) {
        return Identifier.of(Prixilium.MOD_ID, "charm_i");
    }
}
