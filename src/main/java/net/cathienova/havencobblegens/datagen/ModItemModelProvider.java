package net.cathienova.havencobblegens.datagen;

import net.cathienova.havencobblegens.HavenCobbleGens;
import net.cathienova.havencobblegens.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, HavenCobbleGens.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels()
    {
        simpleItem(ModItems.cobble_gen_upgrade_wooden);
        simpleItem(ModItems.cobble_gen_upgrade_stone);
        simpleItem(ModItems.cobble_gen_upgrade_iron);
        simpleItem(ModItems.cobble_gen_upgrade_gold);
        simpleItem(ModItems.cobble_gen_upgrade_diamond);
        simpleItem(ModItems.cobble_gen_upgrade_emerald);
        simpleItem(ModItems.cobble_gen_upgrade_netherite);
    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(HavenCobbleGens.MOD_ID,"item/" + item.getId().getPath()));
    }
}
