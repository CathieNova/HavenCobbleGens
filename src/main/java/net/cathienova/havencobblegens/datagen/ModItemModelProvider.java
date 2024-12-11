package net.cathienova.havencobblegens.datagen;

import net.cathienova.havencobblegens.HavenCobbleGens;
import net.cathienova.havencobblegens.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.client.model.generators.ItemModelBuilder;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class ModItemModelProvider extends ItemModelProvider
{
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, HavenCobbleGens.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels()
    {
        basicItem(ModItems.cobble_gen_upgrade_wooden.get());
        basicItem(ModItems.cobble_gen_upgrade_stone.get());
        basicItem(ModItems.cobble_gen_upgrade_iron.get());
        basicItem(ModItems.cobble_gen_upgrade_gold.get());
        basicItem(ModItems.cobble_gen_upgrade_diamond.get());
        basicItem(ModItems.cobble_gen_upgrade_emerald.get());
        basicItem(ModItems.cobble_gen_upgrade_netherite.get());
    }
}
