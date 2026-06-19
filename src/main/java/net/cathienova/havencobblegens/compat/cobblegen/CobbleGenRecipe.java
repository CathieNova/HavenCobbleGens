package net.cathienova.havencobblegens.compat.cobblegen;

import net.cathienova.havencobblegens.HavenCobbleGens;
import net.cathienova.havencobblegens.block.ModBlocks;
import net.cathienova.havencobblegens.config.HavenConfig;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

import java.util.ArrayList;
import java.util.List;

public class CobbleGenRecipe
{
    private static final int MAX_OUTPUTS_PER_RECIPE = 20;

    private final ItemStack cobbleGen;
    private final ItemStack influencingBlock;
    private final List<ItemStack> outputBlocks;

    public CobbleGenRecipe(ItemStack cobbleGen, ItemStack influencingBlock, List<ItemStack> outputBlocks)
    {
        this.cobbleGen = cobbleGen;
        this.influencingBlock = influencingBlock;
        this.outputBlocks = outputBlocks;
    }

    public ItemStack getCobbleGen()
    {
        return cobbleGen;
    }

    public ItemStack getInfluencingBlock()
    {
        return influencingBlock;
    }

    public List<ItemStack> getOutputBlocks()
    {
        return outputBlocks;
    }

    public static List<CobbleGenRecipe> createRecipes()
    {
        List<CobbleGenRecipe> recipes = new ArrayList<>();

        addGeneratorRecipes(recipes, ModBlocks.wooden_cobble_gen.get(), HavenConfig.wooden_cobble_gen_valid_blocks);
        addGeneratorRecipes(recipes, ModBlocks.stone_cobble_gen.get(), HavenConfig.stone_cobble_gen_valid_blocks);
        addGeneratorRecipes(recipes, ModBlocks.copper_cobble_gen.get(), HavenConfig.copper_cobble_gen_valid_blocks);
        addGeneratorRecipes(recipes, ModBlocks.iron_cobble_gen.get(), HavenConfig.iron_cobble_gen_valid_blocks);
        addGeneratorRecipes(recipes, ModBlocks.gold_cobble_gen.get(), HavenConfig.gold_cobble_gen_valid_blocks);
        addGeneratorRecipes(recipes, ModBlocks.diamond_cobble_gen.get(), HavenConfig.diamond_cobble_gen_valid_blocks);
        addGeneratorRecipes(recipes, ModBlocks.emerald_cobble_gen.get(), HavenConfig.emerald_cobble_gen_valid_blocks);
        addGeneratorRecipes(recipes, ModBlocks.netherite_cobble_gen.get(), HavenConfig.netherite_cobble_gen_valid_blocks);
        addGeneratorRecipes(recipes, ModBlocks.creative_cobble_gen.get(), HavenConfig.creative_cobble_gen_valid_blocks);

        return recipes;
    }

    private static void addGeneratorRecipes(List<CobbleGenRecipe> recipes, Block cobbleGen, List<? extends String> configuredBlocks)
    {
        for (String configuredBlock : configuredBlocks)
        {
            String[] parts = configuredBlock.split(";", 2);
            if (parts.length != 2)
            {
                HavenCobbleGens.Log("Invalid cobblegen config entry: " + configuredBlock);
                continue;
            }

            Identifier influencingId = parseIdentifier(parts[0].trim());
            if (influencingId == null)
            {
                continue;
            }

            Block influencingBlock = BuiltInRegistries.BLOCK.getValue(influencingId);
            if (influencingBlock == null || influencingBlock == Blocks.AIR)
            {
                HavenCobbleGens.Log("Invalid influencing block ID in cobblegen config: " + parts[0].trim());
                continue;
            }

            List<ItemStack> outputs = new ArrayList<>();
            for (String outputName : parts[1].split(","))
            {
                Identifier outputId = parseIdentifier(outputName.trim());
                if (outputId == null)
                {
                    continue;
                }

                Block outputBlock = BuiltInRegistries.BLOCK.getValue(outputId);
                if (outputBlock != null && outputBlock != Blocks.AIR)
                {
                    outputs.add(new ItemStack(outputBlock));
                    continue;
                }

                Item outputItem = BuiltInRegistries.ITEM.getValue(outputId);
                if (outputItem != null && outputItem != Items.AIR)
                {
                    outputs.add(new ItemStack(outputItem));
                    continue;
                }

                HavenCobbleGens.Log("Invalid block/item ID in cobblegen config: " + outputName.trim());
            }

            for (int start = 0; start < outputs.size(); start += MAX_OUTPUTS_PER_RECIPE)
            {
                int end = Math.min(start + MAX_OUTPUTS_PER_RECIPE, outputs.size());
                recipes.add(new CobbleGenRecipe(
                        new ItemStack(cobbleGen),
                        new ItemStack(influencingBlock),
                        new ArrayList<>(outputs.subList(start, end))));
            }
        }
    }

    private static Identifier parseIdentifier(String name)
    {
        try
        {
            return Identifier.parse(name);
        }
        catch (RuntimeException exception)
        {
            HavenCobbleGens.Log("Invalid identifier in cobblegen config: " + name);
            return null;
        }
    }
}