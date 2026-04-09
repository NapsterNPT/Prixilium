package net.napsternpt.prixilium.util;

import net.minecraft.client.item.ModelPredicateProviderRegistry;
import net.minecraft.util.Identifier;
import net.napsternpt.prixilium.Prixilium;
import net.napsternpt.prixilium.item.ModItems;
import net.napsternpt.prixilium.item.custom.PrixiliumHookItem;

public class ModModelPredicates {
    public static void registerModelPredicates() {
        ModelPredicateProviderRegistry.register(ModItems.PRIXILED_BOW, Identifier.ofVanilla("pull"), (stack, world, entity, seed) -> {
            if (entity == null) {
                return 0.0F;
            } else {
                return entity.getActiveItem() != stack ? 0.0F : (float)(stack.getMaxUseTime(entity) - entity.getItemUseTimeLeft()) / 20.0F;
            }
        });
        ModelPredicateProviderRegistry.register(
                ModItems.PRIXILED_BOW,
                Identifier.ofVanilla("pulling"),
                (stack, world, entity, seed) -> entity != null && entity.isUsingItem() && entity.getActiveItem() == stack ? 1.0F : 0.0F
        );

        ModelPredicateProviderRegistry.register(
                ModItems.PRIXILIUM_HOOK,
                Identifier.of(Prixilium.MOD_ID, "hook_active"),
                (stack, world, entity, seed) -> {
                    if (entity == null) return 0.0F;
                    return PrixiliumHookItem.hasActiveHook(entity) ? 1.0F : 0.0F;
                }
        );
    }
}
