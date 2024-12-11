package net.cathienova.havencobblegens.datagen.recipes;

import net.cathienova.havencobblegens.HavenCobbleGens;
import net.cathienova.havencobblegens.block.ModBlocks;
import net.cathienova.havencobblegens.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder
{
    public ModRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(RecipeOutput output)
    {
        BaseCobbleGenRecipe(output, ModBlocks.wooden_cobble_gen.get());
        UpgradeCobbleGenRecipe(output, ModBlocks.stone_cobble_gen.get(), Blocks.COBBLESTONE, ModBlocks.wooden_cobble_gen.get());
        UpgradeCobbleGenRecipe(output, ModBlocks.iron_cobble_gen.get(), Items.IRON_INGOT, ModBlocks.stone_cobble_gen.get());
        UpgradeCobbleGenRecipe(output, ModBlocks.gold_cobble_gen.get(), Items.GOLD_INGOT, ModBlocks.iron_cobble_gen.get());
        UpgradeCobbleGenRecipe(output, ModBlocks.diamond_cobble_gen.get(), Items.DIAMOND, ModBlocks.gold_cobble_gen.get());
        UpgradeCobbleGenRecipe(output, ModBlocks.emerald_cobble_gen.get(), Items.EMERALD, ModBlocks.diamond_cobble_gen.get());
        UpgradeCobbleGenRecipe(output, ModBlocks.netherite_cobble_gen.get(), Items.NETHERITE_INGOT, ModBlocks.emerald_cobble_gen.get());
        UpgradeCobbleGenRecipe(output, ModBlocks.creative_cobble_gen.get(), Items.NETHER_STAR, ModBlocks.netherite_cobble_gen.get());

        UpgradeCobbleGenRecipe(output, ModItems.cobble_gen_upgrade_wooden.get(), Blocks.COBBLESTONE, Items.GLASS);
        UpgradeCobbleGenRecipe(output, ModItems.cobble_gen_upgrade_stone.get(), Items.IRON_INGOT, Items.GLASS);
        UpgradeCobbleGenRecipe(output, ModItems.cobble_gen_upgrade_iron.get(), Items.GOLD_INGOT, Items.GLASS);
        UpgradeCobbleGenRecipe(output, ModItems.cobble_gen_upgrade_gold.get(), Items.DIAMOND, Items.GLASS);
        UpgradeCobbleGenRecipe(output, ModItems.cobble_gen_upgrade_diamond.get(), Items.EMERALD, Items.GLASS);
        UpgradeCobbleGenRecipe(output, ModItems.cobble_gen_upgrade_emerald.get(), Items.NETHERITE_INGOT, Items.GLASS);
        UpgradeCobbleGenRecipe(output, ModItems.cobble_gen_upgrade_netherite.get(), Items.NETHER_STAR, Items.GLASS);
    }

    protected static void BaseCobbleGenRecipe(RecipeOutput recipe, ItemLike result)
    {
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, result, 1)
                .pattern("III")
                .pattern("WGL")
                .pattern("III")
                .define('I', Blocks.OAK_LOG)
                .define('G', Blocks.GLASS)
                .define('L', Items.LAVA_BUCKET)
                .define('W', Items.WATER_BUCKET)
                .unlockedBy("has_" + getItemName(Blocks.OAK_LOG), has(Blocks.OAK_LOG))
                .save(recipe, HavenCobbleGens.MOD_ID + ":craft/" + getItemName(result));
    }

    protected static void UpgradeCobbleGenRecipe(RecipeOutput recipe, ItemLike result, ItemLike ingredient, ItemLike cobblegen)
    {
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, result, 1)
                .pattern("III")
                .pattern("WCL")
                .pattern("III")
                .define('I', ingredient)
                .define('L', Items.LAVA_BUCKET)
                .define('W', Items.WATER_BUCKET)
                .define('C', cobblegen)
                .unlockedBy("has_" + getItemName(cobblegen), has(cobblegen))
                .save(recipe, HavenCobbleGens.MOD_ID + ":craft/" + getItemName(result));
    }
}
