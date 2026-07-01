package net.napsternpt.prixilium.mixin;

import net.minecraft.advancement.AdvancementEntry;
import net.minecraft.advancement.AdvancementManager;
import net.minecraft.advancement.AdvancementProgress;
import net.minecraft.advancement.PlayerAdvancementTracker;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.Identifier;
import net.napsternpt.prixilium.Prixilium;
import net.napsternpt.prixilium.item.ModItems;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Map;

@Mixin(PlayerAdvancementTracker.class)
public class AdvancementTrackerMixin {
    @Shadow
    private ServerPlayerEntity owner;
    @Shadow
    private Map<AdvancementEntry, AdvancementProgress> progress;
    @Shadow
    private AdvancementManager advancementManager;
    @Unique
    private boolean prixilium$checkingCompletionist = false;

    @Inject(method = "grantCriterion", at = @At("RETURN"))
    private void onGrantCriterion(AdvancementEntry advancement, String criterionName, CallbackInfoReturnable<Boolean> cir) {
        if (!cir.getReturnValue() || prixilium$checkingCompletionist) return;
        Identifier masterId = Identifier.of(Prixilium.MOD_ID, "completionist");
        if (advancement.id().equals(masterId)) return;
        var placed = advancementManager.get(masterId);
        if (placed == null) return;
        AdvancementEntry master = placed.getAdvancementEntry();
        AdvancementProgress masterProg = progress.get(master);
        if (masterProg != null && masterProg.isDone()) return;
        for (Map.Entry<AdvancementEntry, AdvancementProgress> entry : progress.entrySet()) {
            AdvancementEntry adv = entry.getKey();
            if (!adv.id().getNamespace().equals(Prixilium.MOD_ID)) continue;
            if (adv.id().equals(masterId)) continue;
            if (!entry.getValue().isDone()) return;
        }

        prixilium$checkingCompletionist = true;
        ((PlayerAdvancementTracker)(Object)this).grantCriterion(master, "completionist");
        owner.getInventory().offerOrDrop(new ItemStack(ModItems.NAPSTERNPT_PLUSHY));
        prixilium$checkingCompletionist = false;
    }
}
