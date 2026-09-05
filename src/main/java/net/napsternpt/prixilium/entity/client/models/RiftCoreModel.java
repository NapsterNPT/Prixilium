package net.napsternpt.prixilium.entity.client.models;

import net.minecraft.client.model.*;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;
import net.napsternpt.prixilium.Prixilium;
import net.napsternpt.prixilium.entity.client.renderstates.RiftCoreRenderState;

public class RiftCoreModel extends EntityModel<RiftCoreRenderState> {
	public static final EntityModelLayer RIFT_CORE = new EntityModelLayer(
			Identifier.of(Prixilium.MOD_ID, "rift_core"), "main");

	public RiftCoreModel(ModelPart root) {
		super(root);
	}

	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();

		modelPartData.addChild("Core", ModelPartBuilder.create()
				.uv(0, 0).cuboid(-8.0F, -8.0F, -8.0F, 16.0F, 16.0F, 16.0F, new Dilation(0.0F)),
				ModelTransform.origin(0.0F, 24.0F, 0.0F));

		return TexturedModelData.of(modelData, 16, 16);
	}
}