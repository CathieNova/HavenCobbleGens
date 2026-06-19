package net.cathienova.havencobblegens.datagen;

import net.cathienova.havencobblegens.HavenCobbleGens;
import net.cathienova.havencobblegens.block.ModBlocks;
import net.cathienova.havencobblegens.item.ModItems;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.ModelProvider;
import net.minecraft.client.data.models.model.ModelLocationUtils;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.core.Holder;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;

import java.util.stream.Stream;

public class ModItemModelProvider extends ModelProvider
{
    public ModItemModelProvider(PackOutput output)
    {
        super(output, HavenCobbleGens.MOD_ID);
    }


    @Override
    protected Stream<? extends Holder<Block>> getKnownBlocks()
    {
        return Stream.empty();
    }

    @Override
    protected void registerModels(BlockModelGenerators blockModels, ItemModelGenerators itemModels)
    {
        blockModels.registerSimpleItemModel(ModBlocks.wooden_cobble_gen.get(), ModelLocationUtils.getModelLocation(ModBlocks.wooden_cobble_gen.get()));
        blockModels.registerSimpleItemModel(ModBlocks.stone_cobble_gen.get(), ModelLocationUtils.getModelLocation(ModBlocks.stone_cobble_gen.get()));
        blockModels.registerSimpleItemModel(ModBlocks.copper_cobble_gen.get(), ModelLocationUtils.getModelLocation(ModBlocks.copper_cobble_gen.get()));
        blockModels.registerSimpleItemModel(ModBlocks.iron_cobble_gen.get(), ModelLocationUtils.getModelLocation(ModBlocks.iron_cobble_gen.get()));
        blockModels.registerSimpleItemModel(ModBlocks.gold_cobble_gen.get(), ModelLocationUtils.getModelLocation(ModBlocks.gold_cobble_gen.get()));
        blockModels.registerSimpleItemModel(ModBlocks.diamond_cobble_gen.get(), ModelLocationUtils.getModelLocation(ModBlocks.diamond_cobble_gen.get()));
        blockModels.registerSimpleItemModel(ModBlocks.emerald_cobble_gen.get(), ModelLocationUtils.getModelLocation(ModBlocks.emerald_cobble_gen.get()));
        blockModels.registerSimpleItemModel(ModBlocks.netherite_cobble_gen.get(), ModelLocationUtils.getModelLocation(ModBlocks.netherite_cobble_gen.get()));
        blockModels.registerSimpleItemModel(ModBlocks.creative_cobble_gen.get(), ModelLocationUtils.getModelLocation(ModBlocks.creative_cobble_gen.get()));

        itemModels.generateFlatItem(ModItems.cobble_gen_upgrade_wooden.get(), ModelTemplates.FLAT_ITEM.extend().build());
        itemModels.generateFlatItem(ModItems.cobble_gen_upgrade_stone.get(), ModelTemplates.FLAT_ITEM.extend().build());
        itemModels.generateFlatItem(ModItems.cobble_gen_upgrade_copper.get(), ModelTemplates.FLAT_ITEM.extend().build());
        itemModels.generateFlatItem(ModItems.cobble_gen_upgrade_iron.get(), ModelTemplates.FLAT_ITEM.extend().build());
        itemModels.generateFlatItem(ModItems.cobble_gen_upgrade_gold.get(), ModelTemplates.FLAT_ITEM.extend().build());
        itemModels.generateFlatItem(ModItems.cobble_gen_upgrade_diamond.get(), ModelTemplates.FLAT_ITEM.extend().build());
        itemModels.generateFlatItem(ModItems.cobble_gen_upgrade_emerald.get(), ModelTemplates.FLAT_ITEM.extend().build());
        itemModels.generateFlatItem(ModItems.cobble_gen_upgrade_netherite.get(), ModelTemplates.FLAT_ITEM.extend().build());
    }
}