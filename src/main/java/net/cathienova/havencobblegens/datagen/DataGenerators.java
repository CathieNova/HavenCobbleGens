package net.cathienova.havencobblegens.datagen;

import net.cathienova.havencobblegens.HavenCobbleGens;
import net.cathienova.havencobblegens.datagen.loot.ModBlockLootTables;
import net.cathienova.havencobblegens.datagen.recipes.ModRecipeProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.data.event.GatherDataEvent;

import java.util.Collections;
import java.util.List;

@EventBusSubscriber(modid = HavenCobbleGens.MOD_ID)
public class DataGenerators
{
    @SubscribeEvent
    public static void gatherData(GatherDataEvent.Client event)
    {
        DataGenerator generator = event.getGenerator();
        PackOutput output = generator.getPackOutput();
        var lookupProvider = event.getLookupProvider();

        event.addProvider(new ModEngLangProvider(output));
        event.addProvider(new ModItemModelProvider(output));
        event.addProvider(new ModRecipeProvider.Runner(output, lookupProvider));
        event.addProvider(new LootTableProvider(output, Collections.emptySet(),
                List.of(new LootTableProvider.SubProviderEntry(ModBlockLootTables::new, LootContextParamSets.BLOCK)), lookupProvider));
        event.addProvider(new ModBlockTagGenerator(output, lookupProvider));
        event.addProvider(new ModItemTagGenerator(output, lookupProvider));
        event.addProvider(new ModAdvancementProvider(output, lookupProvider));
        event.addProvider(new ModPoiTypeTagsProvider(output, lookupProvider));
        event.addProvider(new ModVillagerTrades(output));
    }
}