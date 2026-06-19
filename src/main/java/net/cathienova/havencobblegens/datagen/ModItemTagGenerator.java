package net.cathienova.havencobblegens.datagen;

import net.cathienova.havencobblegens.HavenCobbleGens;
import net.cathienova.havencobblegens.block.ModBlocks;
import net.cathienova.havencobblegens.item.ModItems;
import net.cathienova.havencobblegens.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.ItemTagsProvider;

import java.util.concurrent.CompletableFuture;

public class ModItemTagGenerator extends ItemTagsProvider
{
    public ModItemTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider)
    {
        super(output, lookupProvider, HavenCobbleGens.MOD_ID);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider)
    {
        tag(ModTags.Items.cobbleGens)
                .add(ModBlocks.wooden_cobble_gen.get().asItem())
                .add(ModBlocks.stone_cobble_gen.get().asItem())
                .add(ModBlocks.copper_cobble_gen.get().asItem())
                .add(ModBlocks.iron_cobble_gen.get().asItem())
                .add(ModBlocks.gold_cobble_gen.get().asItem())
                .add(ModBlocks.diamond_cobble_gen.get().asItem())
                .add(ModBlocks.emerald_cobble_gen.get().asItem())
                .add(ModBlocks.netherite_cobble_gen.get().asItem())
                .add(ModBlocks.creative_cobble_gen.get().asItem());

        tag(ModTags.Items.cobbleGenUpgrades)
                .add(ModItems.cobble_gen_upgrade_wooden.get())
                .add(ModItems.cobble_gen_upgrade_stone.get())
                .add(ModItems.cobble_gen_upgrade_copper.get())
                .add(ModItems.cobble_gen_upgrade_iron.get())
                .add(ModItems.cobble_gen_upgrade_gold.get())
                .add(ModItems.cobble_gen_upgrade_diamond.get())
                .add(ModItems.cobble_gen_upgrade_emerald.get())
                .add(ModItems.cobble_gen_upgrade_netherite.get());
    }
}