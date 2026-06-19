package net.cathienova.havencobblegens.datagen;

import net.cathienova.havencobblegens.HavenCobbleGens;
import net.cathienova.havencobblegens.util.ModVillagers;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.PoiTypeTagsProvider;
import net.minecraft.tags.PoiTypeTags;

import java.util.concurrent.CompletableFuture;

public class ModPoiTypeTagsProvider extends PoiTypeTagsProvider
{
    public ModPoiTypeTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider)
    {
        super(output, lookupProvider, HavenCobbleGens.MOD_ID);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider)
    {
        tag(PoiTypeTags.ACQUIRABLE_JOB_SITE)
                .add(ModVillagers.COBBLEMASTER_POI.getKey());
    }
}