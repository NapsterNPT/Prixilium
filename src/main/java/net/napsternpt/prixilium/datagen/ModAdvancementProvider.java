package net.napsternpt.prixilium.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricAdvancementProvider;
import net.minecraft.advancement.Advancement;
import net.minecraft.advancement.AdvancementCriterion;
import net.minecraft.advancement.AdvancementEntry;
import net.minecraft.advancement.AdvancementFrame;
import net.minecraft.advancement.criterion.Criteria;
import net.minecraft.advancement.criterion.EffectsChangedCriterion;
import net.minecraft.advancement.criterion.ImpossibleCriterion;
import net.minecraft.advancement.criterion.InventoryChangedCriterion;
import net.minecraft.predicate.entity.EntityEffectPredicate;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.napsternpt.prixilium.Prixilium;
import net.napsternpt.prixilium.block.ModBlocks;
import net.napsternpt.prixilium.effect.ModEffects;
import net.napsternpt.prixilium.item.ModItems;

import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

public class ModAdvancementProvider extends FabricAdvancementProvider {

    public  ModAdvancementProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(output, registryLookup);
    }

    @Override
    public void generateAdvancement(RegistryWrapper.WrapperLookup registryLookup, Consumer<AdvancementEntry> consumer) {
        AdvancementCriterion<ImpossibleCriterion.Conditions> impossibleCriterion = Criteria.IMPOSSIBLE.create(new ImpossibleCriterion.Conditions());

        // Root
        AdvancementEntry root = Advancement.Builder.create()
                .display(ModBlocks.PRIXILIUM,
                        Text.translatable("advancements.prixilium.root.title"),
                        Text.translatable("advancements.prixilium.root.description"),
                        Identifier.of(Prixilium.MOD_ID, "gui/advancements/backgrounds/prixilium"),
                        AdvancementFrame.TASK, false, false, false
                )
                .criterion("got_virus", InventoryChangedCriterion.Conditions.items(ModItems.VIRUS_ALIVE))
                .build(consumer, Prixilium.MOD_ID + ":root");

        //region [Normal Advancement]
        Advancement.Builder.create()
                .parent(root)
                .display(ModItems.VIRUS_DEAD,
                        Text.translatable("advancements.prixilium.virus_dead.title"),
                        Text.translatable("advancements.prixilium.virus_dead.description"), null, AdvancementFrame.TASK, true, true, false
                )
                .criterion("got_dead_virus", InventoryChangedCriterion.Conditions.items(ModItems.VIRUS_DEAD))
                .build(consumer, Prixilium.MOD_ID + ":virus_dead");

        Advancement.Builder.create()
                .parent(root)
                .display(ModItems.PRIXILIUM_HOOK,
                        Text.translatable("advancements.prixilium.prixilium_hook.title"),
                        Text.translatable("advancements.prixilium.prixilium_hook.description"), null, AdvancementFrame.TASK, true, true, false
                )
                .criterion("use_prixilium_hook", impossibleCriterion)
                .build(consumer, Prixilium.MOD_ID + ":prixilium_hook");

        Advancement.Builder.create()
                .parent(root)
                .display(ModItems.BLIKO_SPAWN_EGG,
                        Text.translatable("advancements.prixilium.team_bliko.title"),
                        Text.translatable("advancements.prixilium.team_bliko.description"), null, AdvancementFrame.TASK, true, true, false
                )
                .criterion("team_bliko", impossibleCriterion)
                .build(consumer, Prixilium.MOD_ID + ":team_bliko");

        Advancement.Builder.create()
                .parent(root)
                .display(ModItems.BLIKO_SPAWN_EGG,
                        Text.translatable("advancements.prixilium.kill_bliko.title"),
                        Text.translatable("advancements.prixilium.kill_bliko.description"), null, AdvancementFrame.TASK, true, true, true
                )
                .criterion("kill_bliko", impossibleCriterion)
                .build(consumer, Prixilium.MOD_ID + ":kill_bliko");

        Advancement.Builder.create()
                .parent(root)
                .display(ModBlocks.PRIXILIUM,
                        Text.translatable("advancements.prixilium.step_on_prixilium.title"),
                        Text.translatable("advancements.prixilium.step_on_prixilium.description"), null, AdvancementFrame.TASK, true, true, false
                )
                .criterion("step_on_prixilium", EffectsChangedCriterion.Conditions.create(EntityEffectPredicate.Builder.create().addEffect(ModEffects.PRIXILIUM_SLOWNESS)))
                .build(consumer, Prixilium.MOD_ID + ":step_on_prixilium");

        //endregion

        //region [Dimension Advancement]
        AdvancementEntry dimension = Advancement.Builder.create()
                .parent(root)
                .display(ModBlocks.PRIXILIUM_GRASS,
                        Text.translatable("advancements.prixilium.tp_to_dimension.title"),
                        Text.translatable("advancements.prixilium.tp_to_dimension.description"), null, AdvancementFrame.TASK, true, true, true
                )
                .criterion("tp_to_dimension", impossibleCriterion)
                .build(consumer, Prixilium.MOD_ID + ":tp_to_dimension");

        //endregion
    }
}
