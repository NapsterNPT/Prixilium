package net.napsternpt.prixilium.item.custom;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.screen.GenericContainerScreenHandler;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

import java.util.function.Consumer;

public class ContainerCharmItem extends GeneralCharmItem {
    private final int raw;

    public ContainerCharmItem(int raw, boolean upgradable, boolean specializable, Settings settings) {
        super(upgradable, specializable, settings);
        this.raw = raw;
    }

    @Override
    public ActionResult use(World world, PlayerEntity user, Hand hand) {
        if (!world.isClient) {
            NamedScreenHandlerFactory factory = new NamedScreenHandlerFactory() {
                @Override
                public Text getDisplayName() {
                    return Text.translatable("hud.prixilium.container_charm.title");
                }

                @Override
                public ScreenHandler createMenu(int syncId, PlayerInventory playerInventory, PlayerEntity player) {
                    return switch (raw) {
                        case 1 -> GenericContainerScreenHandler.createGeneric9x1(syncId, playerInventory);
                        case 2 -> GenericContainerScreenHandler.createGeneric9x2(syncId, playerInventory);
                        case 3 -> GenericContainerScreenHandler.createGeneric9x3(syncId, playerInventory);
                        case 4 -> GenericContainerScreenHandler.createGeneric9x4(syncId, playerInventory);
                        case 5 -> GenericContainerScreenHandler.createGeneric9x5(syncId, playerInventory);
                        default -> GenericContainerScreenHandler.createGeneric9x6(syncId, playerInventory);
                    };
                }
            };

            user.openHandledScreen(factory);
        }
        return ActionResult.CONSUME;
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, net.minecraft.component.type.TooltipDisplayComponent displayComponent, Consumer<Text> textConsumer, TooltipType type) {
        textConsumer.accept(Text.translatable("tooltip.prixilium.container_charm"));
        super.appendTooltip(stack, context, displayComponent, textConsumer, type);
    }
}