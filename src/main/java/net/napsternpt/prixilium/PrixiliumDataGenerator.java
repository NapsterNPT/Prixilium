package net.napsternpt.prixilium;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.napsternpt.prixilium.datagen.ModBlockTagProvider;
import net.napsternpt.prixilium.datagen.ModItemTagProvider;
import net.napsternpt.prixilium.datagen.ModLootTableProvider;

public class PrixiliumDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

		pack.addProvider(ModBlockTagProvider::new);
		pack.addProvider(ModItemTagProvider::new);
		pack.addProvider(ModLootTableProvider::new);
	}
}
