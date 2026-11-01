package net.napsternpt.prixilium.item.custom;

import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import net.napsternpt.prixilium.screen.custom.LetterScreen;

public class LetterItem extends Item {
    public LetterItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult use(World world, PlayerEntity user, Hand hand) {
        if (world.isClient()) {
            MinecraftClient.getInstance().setScreen(new LetterScreen());
        }
        return ActionResult.SUCCESS;
    }
}
