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
import net.minecraft.advancement.criterion.OnKilledCriterion;
import net.minecraft.entity.EntityType;
import net.minecraft.predicate.TagPredicate;
import net.minecraft.predicate.entity.DamageSourcePredicate;
import net.minecraft.predicate.entity.EntityEffectPredicate;
import net.minecraft.predicate.entity.EntityPredicate;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.napsternpt.prixilium.Prixilium;
import net.napsternpt.prixilium.block.ModBlocks;
import net.napsternpt.prixilium.effect.ModEffects;
import net.napsternpt.prixilium.item.ModItems;
import net.napsternpt.prixilium.util.ModTags;
import org.jspecify.annotations.NonNull;

import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

public class ModAdvancementProvider extends FabricAdvancementProvider {

    public  ModAdvancementProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(output, registryLookup);
    }

    @Override
    public void generateAdvancement(RegistryWrapper.WrapperLookup registryLookup, @NonNull Consumer<AdvancementEntry> consumer) {
        AdvancementCriterion<ImpossibleCriterion.Conditions> impossibleCriterion = Criteria.IMPOSSIBLE.create(new ImpossibleCriterion.Conditions());

        // Root
        AdvancementEntry root = Advancement.Builder.create()
                .display(ModBlocks.PRIXILIUM,
                        Text.translatable("advancements.prixilium.root.title"),
                        Text.translatable("advancements.prixilium.root.description"),
                        Identifier.of(Prixilium.MOD_ID, "gui/advancements/backgrounds/prixilium"),
                        AdvancementFrame.TASK, false, false, false
                )
                .criterion("get_virus", InventoryChangedCriterion.Conditions.items(ModItems.VIRUS_ALIVE))
                .build(consumer, Prixilium.MOD_ID + ":root");

        Advancement.Builder.create()
                .parent(root)
                .display(ModItems.NAPSTERNPT_PLUSHY,
                        Text.translatable("advancements.prixilium.completionist.title"),
                        Text.translatable("advancements.prixilium.completionist.description").append(". 764251675739346c544a67"), null, AdvancementFrame.CHALLENGE, true, true, true
                )
                .criterion("completionist", impossibleCriterion)
                .build(consumer, Prixilium.MOD_ID + ":completionist");

        //region [Prixiverse]
        AdvancementEntry dimension = Advancement.Builder.create()
                .parent(root)
                .display(ModBlocks.PRIXILIUM_GRASS,
                        Text.translatable("advancements.prixilium.enter_prixiverse.title"),
                        Text.translatable("advancements.prixilium.enter_prixiverse.description"), null, AdvancementFrame.TASK, true, true, true
                )
                .criterion("enter_prixiverse", impossibleCriterion)
                .build(consumer, Prixilium.MOD_ID + ":enter_prixiverse");

        Advancement.Builder.create()
                .parent(dimension)
                .display(ModItems.VIRUS_DEAD,
                        Text.translatable("advancements.prixilium.the_end.title"),
                        Text.translatable("advancements.prixilium.the_end.description"), null, AdvancementFrame.CHALLENGE, true, true, false
                )
                .criterion("the_end", impossibleCriterion)
                .build(consumer, Prixilium.MOD_ID + ":the_end");

        //endregion

        //region [Items]
        Advancement.Builder.create()
                .parent(root)
                .display(ModItems.VIRUS_DEAD,
                        Text.translatable("advancements.prixilium.virus_dead.title"),
                        Text.translatable("advancements.prixilium.virus_dead.description"), null, AdvancementFrame.TASK, true, true, false
                )
                .criterion("get_dead_virus", InventoryChangedCriterion.Conditions.items(ModItems.VIRUS_DEAD))
                .build(consumer, Prixilium.MOD_ID + ":virus_dead");

        Advancement.Builder.create()
                .parent(root)
                .display(ModItems.PRIXILIUM_UPGRADE_SMITHING_TEMPLATE,
                        Text.translatable("advancements.prixilium.smith.title"),
                        Text.translatable("advancements.prixilium.smith.description"), null, AdvancementFrame.TASK, true, true, false
                )
                .criterion("smith", InventoryChangedCriterion.Conditions.items(ModItems.PRIXILIUM_UPGRADE_SMITHING_TEMPLATE))
                .build(consumer, Prixilium.MOD_ID + ":smith");

        Advancement.Builder.create()
                .parent(root)
                .display(ModItems.PRIXILIUM_HOOK,
                        Text.translatable("advancements.prixilium.prixilium_hook.title"),
                        Text.translatable("advancements.prixilium.prixilium_hook.description"), null, AdvancementFrame.TASK, true, true, false
                )
                .criterion("use_prixilium_hook", impossibleCriterion)
                .build(consumer, Prixilium.MOD_ID + ":prixilium_hook");

        //region [Charms]
        AdvancementEntry charm = Advancement.Builder.create()
                .parent(root)
                .display(ModItems.CHARM_I,
                        Text.translatable("advancements.prixilium.charm_i.title"),
                        Text.translatable("advancements.prixilium.charm_i.description"), null, AdvancementFrame.TASK, true, true, false
                )
                .criterion("get_charm_i", InventoryChangedCriterion.Conditions.items(ModItems.CHARM_I))
                .build(consumer, Prixilium.MOD_ID + ":charm_i");

        Advancement.Builder.create()
                .parent(charm)
                .display(ModItems.CHARM_III,
                        Text.translatable("advancements.prixilium.charm_iii.title"),
                        Text.translatable("advancements.prixilium.charm_iii.description"), null, AdvancementFrame.TASK, true, true, false
                )
                .criterion("get_charm_iii", InventoryChangedCriterion.Conditions.items(ModItems.CHARM_III))
                .build(consumer, Prixilium.MOD_ID + ":charm_iii");

        Advancement.Builder.create()
                .parent(charm)
                .display(ModItems.STOPWATCH_CHARM_III,
                        Text.translatable("advancements.prixilium.time_stopper.title"),
                        Text.translatable("advancements.prixilium.time_stopper.description"), null, AdvancementFrame.TASK, true, true, false
                )
                .criterion("time_stopper", impossibleCriterion)
                .build(consumer, Prixilium.MOD_ID + ":time_stopper");

        Advancement.Builder.create()
                .parent(charm)
                .display(ModItems.IMMUNITY_CHARM_III,
                        Text.translatable("advancements.prixilium.indestructible.title"),
                        Text.translatable("advancements.prixilium.indestructible.description"), null, AdvancementFrame.TASK, true, true, false
                )
                .criterion("indestructible", impossibleCriterion)
                .build(consumer, Prixilium.MOD_ID + ":indestructible");

        Advancement.Builder.create()
                .parent(charm)
                .display(ModItems.STASIS_CHARM_III,
                        Text.translatable("advancements.prixilium.warp_traveler.title"),
                        Text.translatable("advancements.prixilium.warp_traveler.description"), null, AdvancementFrame.TASK, true, true, false
                )
                .criterion("warp_traveler", impossibleCriterion)
                .build(consumer, Prixilium.MOD_ID + ":warp_traveler");

        Advancement.Builder.create()
                .parent(charm)
                .display(ModItems.POSTMORTAL_CHARM_I,
                        Text.translatable("advancements.prixilium.postmortal.title"),
                        Text.translatable("advancements.prixilium.postmortal.description"), null, AdvancementFrame.TASK, true, true, false
                )
                .criterion("postmortal", impossibleCriterion)
                .build(consumer, Prixilium.MOD_ID + ":postmortal");

        Advancement.Builder.create()
                .parent(charm)
                .display(ModItems.POSTMORTAL_CHARM_III,
                        Text.translatable("advancements.prixilium.postmortal_final.title"),
                        Text.translatable("advancements.prixilium.postmortal_final.description"), null, AdvancementFrame.TASK, true, true, true
                )
                .criterion("postmortal_final", impossibleCriterion)
                .build(consumer, Prixilium.MOD_ID + ":postmortal_final");

        Advancement.Builder.create()
                .parent(charm)
                .display(ModItems.SONIC_BOOM_CHARM_III,
                        Text.translatable("advancements.prixilium.sonic_boom.title"),
                        Text.translatable("advancements.prixilium.sonic_boom.description"), null, AdvancementFrame.CHALLENGE, true, true, true
                )
                .criterion("kill_warden", OnKilledCriterion.Conditions.createPlayerKilledEntity(
                        EntityPredicate.Builder.create().type(registryLookup.getOrThrow(RegistryKeys.ENTITY_TYPE), EntityType.WARDEN),
                        DamageSourcePredicate.Builder.create().tag(TagPredicate.expected(ModTags.DamageTypes.SONIC_BOOM))))
                .build(consumer, Prixilium.MOD_ID + ":sonic_boom");
        //endregion

        //endregion

        //region [Blocks]
        Advancement.Builder.create()
                .parent(root)
                .display(ModBlocks.VIRUS_REACTOR,
                        Text.translatable("advancements.prixilium.square_zero.title"),
                        Text.translatable("advancements.prixilium.square_zero.description"), null, AdvancementFrame.TASK, true, true, false
                )
                .criterion("square_zero", impossibleCriterion)
                .build(consumer, Prixilium.MOD_ID + ":square_zero");

        Advancement.Builder.create()
                .parent(root)
                .display(ModBlocks.PRIXILIUM_GRASS,
                        Text.translatable("advancements.prixilium.its_spreading.title"),
                        Text.translatable("advancements.prixilium.its_spreading.description"), null, AdvancementFrame.TASK, true, true, false
                )
                .criterion("its_spreading", impossibleCriterion)
                .build(consumer, Prixilium.MOD_ID + ":its_spreading");

        Advancement.Builder.create()
                .parent(root)
                .display(ModBlocks.PRIXILIUM,
                        Text.translatable("advancements.prixilium.step_on_prixilium.title"),
                        Text.translatable("advancements.prixilium.step_on_prixilium.description"), null, AdvancementFrame.TASK, true, true, false
                )
                .criterion("step_on_prixilium", EffectsChangedCriterion.Conditions.create(EntityEffectPredicate.Builder.create().addEffect(ModEffects.PRIXILIUM_SLOWNESS)))
                .build(consumer, Prixilium.MOD_ID + ":step_on_prixilium");

        Advancement.Builder.create()
                .parent(root)
                .display(ModBlocks.PRIXILIUM_LOG,
                        Text.translatable("advancements.prixilium.tree.title"),
                        Text.translatable("advancements.prixilium.tree.description"), null, AdvancementFrame.TASK, true, true, false
                )
                .criterion("tree", InventoryChangedCriterion.Conditions.items(ModBlocks.PRIXILIUM_LOG))
                .build(consumer, Prixilium.MOD_ID + ":tree");

        //endregion

        //region [Entities]
        Advancement.Builder.create()
                .parent(dimension)
                .display(ModItems.BLIKO_SPAWN_EGG,
                        Text.translatable("advancements.prixilium.tame_bliko.title"),
                        Text.translatable("advancements.prixilium.tame_bliko.description"), null, AdvancementFrame.TASK, true, true, false
                )
                .criterion("tame_bliko", impossibleCriterion)
                .build(consumer, Prixilium.MOD_ID + ":tame_bliko");

        Advancement.Builder.create()
                .parent(dimension)
                .display(ModItems.BLIKO_SPAWN_EGG,
                        Text.translatable("advancements.prixilium.kill_bliko.title"),
                        Text.translatable("advancements.prixilium.kill_bliko.description"), null, AdvancementFrame.TASK, true, true, true
                )
                .criterion("kill_bliko", impossibleCriterion)
                .build(consumer, Prixilium.MOD_ID + ":kill_bliko");

        Advancement.Builder.create()
                .parent(dimension)
                .display(ModItems.BLOKITO_SPAWN_EGG,
                        Text.translatable("advancements.prixilium.block_entity.title"),
                        Text.translatable("advancements.prixilium.block_entity.description"), null, AdvancementFrame.TASK, true, true, true
                )
                .criterion("block_entity", impossibleCriterion)
                .build(consumer, Prixilium.MOD_ID + ":block_entity");

        //endregion
    }
}
