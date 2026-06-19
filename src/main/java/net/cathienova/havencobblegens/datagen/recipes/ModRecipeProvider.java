package net.cathienova.havencobblegens.datagen.recipes;

import net.cathienova.havencobblegens.HavenCobbleGens;
import net.cathienova.havencobblegens.block.ModBlocks;
import net.cathienova.havencobblegens.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider
{
    public ModRecipeProvider(HolderLookup.Provider registries, RecipeOutput output)
    {
        super(registries, output);
    }

    @Override
    protected void buildRecipes()
    {
        baseCobbleGenRecipe(ModBlocks.wooden_cobble_gen.get());
        upgradeCobbleGenRecipe(ModBlocks.stone_cobble_gen.get(), Blocks.COBBLESTONE, ModBlocks.wooden_cobble_gen.get());
        upgradeCobbleGenRecipe(ModBlocks.copper_cobble_gen.get(), Items.COPPER_INGOT, ModBlocks.stone_cobble_gen.get());
        upgradeCobbleGenRecipe(ModBlocks.iron_cobble_gen.get(), Items.IRON_INGOT, ModBlocks.copper_cobble_gen.get());
        upgradeCobbleGenRecipe(ModBlocks.gold_cobble_gen.get(), Items.GOLD_INGOT, ModBlocks.iron_cobble_gen.get());
        upgradeCobbleGenRecipe(ModBlocks.diamond_cobble_gen.get(), Items.DIAMOND, ModBlocks.gold_cobble_gen.get());
        upgradeCobbleGenRecipe(ModBlocks.emerald_cobble_gen.get(), Items.EMERALD, ModBlocks.diamond_cobble_gen.get());
        upgradeCobbleGenRecipe(ModBlocks.netherite_cobble_gen.get(), Items.NETHERITE_INGOT, ModBlocks.emerald_cobble_gen.get());
        upgradeCobbleGenRecipe(ModBlocks.creative_cobble_gen.get(), Items.NETHER_STAR, ModBlocks.netherite_cobble_gen.get());

        upgradeCobbleGenRecipe(ModItems.cobble_gen_upgrade_wooden.get(), Blocks.COBBLESTONE, Items.GLASS);
        upgradeCobbleGenRecipe(ModItems.cobble_gen_upgrade_stone.get(), Items.COPPER_INGOT, Items.GLASS);
        upgradeCobbleGenRecipe(ModItems.cobble_gen_upgrade_copper.get(), Items.IRON_INGOT, Items.GLASS);
        upgradeCobbleGenRecipe(ModItems.cobble_gen_upgrade_iron.get(), Items.GOLD_INGOT, Items.GLASS);
        upgradeCobbleGenRecipe(ModItems.cobble_gen_upgrade_gold.get(), Items.DIAMOND, Items.GLASS);
        upgradeCobbleGenRecipe(ModItems.cobble_gen_upgrade_diamond.get(), Items.EMERALD, Items.GLASS);
        upgradeCobbleGenRecipe(ModItems.cobble_gen_upgrade_emerald.get(), Items.NETHERITE_INGOT, Items.GLASS);
        upgradeCobbleGenRecipe(ModItems.cobble_gen_upgrade_netherite.get(), Items.NETHER_STAR, Items.GLASS);

        upgradeCobbleGenRecipe(ModItems.cobble_gen_upgrade_stone.get(), Items.COPPER_INGOT, ModItems.cobble_gen_upgrade_wooden.get(), "_from_wooden_upgrade");
        upgradeCobbleGenRecipe(ModItems.cobble_gen_upgrade_copper.get(), Items.IRON_INGOT, ModItems.cobble_gen_upgrade_stone.get(), "_from_stone_upgrade");
        upgradeCobbleGenRecipe(ModItems.cobble_gen_upgrade_iron.get(), Items.GOLD_INGOT, ModItems.cobble_gen_upgrade_copper.get(), "_from_copper_upgrade");
        upgradeCobbleGenRecipe(ModItems.cobble_gen_upgrade_gold.get(), Items.DIAMOND, ModItems.cobble_gen_upgrade_iron.get(), "_from_iron_upgrade");
        upgradeCobbleGenRecipe(ModItems.cobble_gen_upgrade_diamond.get(), Items.EMERALD, ModItems.cobble_gen_upgrade_gold.get(), "_from_gold_upgrade");
        upgradeCobbleGenRecipe(ModItems.cobble_gen_upgrade_emerald.get(), Items.NETHERITE_INGOT, ModItems.cobble_gen_upgrade_diamond.get(), "_from_diamond_upgrade");
        upgradeCobbleGenRecipe(ModItems.cobble_gen_upgrade_netherite.get(), Items.NETHER_STAR, ModItems.cobble_gen_upgrade_emerald.get(), "_from_emerald_upgrade");
    }

    protected void baseCobbleGenRecipe(ItemLike result)
    {
        shaped(RecipeCategory.MISC, result, 1)
                .pattern("III")
                .pattern("WGL")
                .pattern("III")
                .define('I', Blocks.OAK_LOG)
                .define('G', Blocks.GLASS)
                .define('L', Items.LAVA_BUCKET)
                .define('W', Items.WATER_BUCKET)
                .unlockedBy("has_" + getItemName(Blocks.OAK_LOG), has(Blocks.OAK_LOG))
                .save(output, recipeKey("craft/" + getItemName(result)));
    }

    protected void upgradeCobbleGenRecipe(ItemLike result, ItemLike ingredient, ItemLike cobbleGen)
    {
        upgradeCobbleGenRecipe(result, ingredient, cobbleGen, "");
    }

    protected void upgradeCobbleGenRecipe(ItemLike result, ItemLike ingredient, ItemLike cobbleGen, String recipeSuffix)
    {
        shaped(RecipeCategory.MISC, result, 1)
                .pattern("III")
                .pattern("WCL")
                .pattern("III")
                .define('I', ingredient)
                .define('L', Items.LAVA_BUCKET)
                .define('W', Items.WATER_BUCKET)
                .define('C', cobbleGen)
                .unlockedBy("has_" + getItemName(cobbleGen), has(cobbleGen))
                .save(output, recipeKey("craft/" + getItemName(result) + recipeSuffix));
    }

    private static ResourceKey<Recipe<?>> recipeKey(String path)
    {
        return ResourceKey.create(Registries.RECIPE, Identifier.fromNamespaceAndPath(HavenCobbleGens.MOD_ID, path));
    }

    public static class Runner extends RecipeProvider.Runner
    {
        public Runner(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider)
        {
            super(output, lookupProvider);
        }

        @Override
        protected RecipeProvider createRecipeProvider(HolderLookup.Provider lookupProvider, RecipeOutput output)
        {
            return new ModRecipeProvider(lookupProvider, output);
        }

        @Override
        public String getName()
        {
            return "Haven Cobble Generators recipes";
        }
    }
}