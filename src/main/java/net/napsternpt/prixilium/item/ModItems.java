package net.napsternpt.prixilium.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ItemGroups;
import net.napsternpt.prixilium.Prixilium;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.registry.Registry;
import net.minecraft.registry.Registries;

public class ModItems {
    public static final Item PRIXILIUM_INGOT = registerItem("prixilium_ingot", new Item(new Item.Settings()));
    public static final Item RAW_PRIXILIUM_INGOT = registerItem("raw_prixilium_ingot", new Item(new Item.Settings()));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(Prixilium.MOD_ID, name), item);
    }

    public static void registerModItems() {
        Prixilium.LOGGER.info("Registering Prixilium Items");

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(PRIXILIUM_INGOT);
            entries.add(RAW_PRIXILIUM_INGOT);
        });
    }
}
