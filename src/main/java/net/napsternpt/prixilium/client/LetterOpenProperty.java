package net.napsternpt.prixilium.client;

import com.mojang.serialization.MapCodec;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.item.property.bool.BooleanProperties;
import net.minecraft.client.render.item.property.bool.BooleanProperty;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemDisplayContext;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.napsternpt.prixilium.Prixilium;
import net.napsternpt.prixilium.screen.custom.LetterScreen;

public final class LetterOpenProperty implements BooleanProperty {
    public static final Identifier ID = Identifier.of(Prixilium.MOD_ID, "letter_open");
    public static final LetterOpenProperty INSTANCE = new LetterOpenProperty();
    public static final MapCodec<LetterOpenProperty> CODEC = MapCodec.unit(INSTANCE);

    private LetterOpenProperty() {
    }

    public static void register() {
        BooleanProperties.ID_MAPPER.put(ID, CODEC);
    }

    @Override
    public boolean test(ItemStack stack, ClientWorld world, LivingEntity entity, int seed, ItemDisplayContext context) {
        return MinecraftClient.getInstance().currentScreen instanceof LetterScreen;
    }

    @Override
    public MapCodec<? extends BooleanProperty> getCodec() {
        return CODEC;
    }
}
