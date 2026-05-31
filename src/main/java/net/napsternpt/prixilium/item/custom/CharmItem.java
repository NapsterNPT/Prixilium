package net.napsternpt.prixilium.item.custom;

import com.google.common.base.Suppliers;
import net.minecraft.component.type.TooltipDisplayComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;
import net.napsternpt.prixilium.client.CharmItemRenderer;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.GeoItem;
import software.bernie.geckolib.animatable.client.GeoRenderProvider;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animatable.manager.AnimatableManager;
import software.bernie.geckolib.animatable.processing.AnimationController;
import software.bernie.geckolib.animation.RawAnimation;
import software.bernie.geckolib.renderer.GeoItemRenderer;
import software.bernie.geckolib.util.GeckoLibUtil;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class CharmItem extends Item implements GeoItem {
    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);

    private final boolean upgradable;
    private final boolean specializable;

    public CharmItem(CharmSettings settings) {
        super(settings);
        this.upgradable = settings.isUpgradable();
        this.specializable = settings.isSpecializable();
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
        controllers.add(new AnimationController<>(event ->
                event.setAndContinue(RawAnimation.begin().thenLoop("idle"))));
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return cache;
    }

    @Override
    public void createGeoRenderer(Consumer<GeoRenderProvider> consumer) {
        consumer.accept(new GeoRenderProvider() {
            private final Supplier<GeoItemRenderer<CharmItem>> renderer = Suppliers.memoize(CharmItemRenderer::new);
            @Override
            public @Nullable GeoItemRenderer<CharmItem> getGeoItemRenderer() {
                return this.renderer.get();
            }
        });
    }

    @Override
    public void appendTooltip(ItemStack stack, Item.TooltipContext context, TooltipDisplayComponent displayComponent, Consumer<Text> textConsumer, TooltipType type) {
        if (upgradable && specializable) textConsumer.accept(Text.translatable("tooltip.prixilium.general_charm.specialize_and_update"));
        else if (upgradable) textConsumer.accept(Text.translatable("tooltip.prixilium.general_charm.update"));
        else if (specializable) textConsumer.accept(Text.translatable("tooltip.prixilium.general_charm.specialize"));
        super.appendTooltip(stack, context, displayComponent, textConsumer, type);
    }
}