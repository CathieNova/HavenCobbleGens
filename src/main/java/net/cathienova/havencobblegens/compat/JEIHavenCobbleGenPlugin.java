package net.cathienova.havencobblegens.compat;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.cathienova.havencobblegens.HavenCobbleGens;
import net.cathienova.havencobblegens.block.ModBlocks;
import net.cathienova.havencobblegens.compat.jei.CobbleGenRecipe;
import net.cathienova.havencobblegens.compat.jei.CobbleGenRecipeCategory;
import net.cathienova.havencobblegens.config.HavenConfig;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@JeiPlugin
public class JEIHavenCobbleGenPlugin implements IModPlugin
{
    public static final RecipeType<CobbleGenRecipe> COBBLEGEN_TYPE =
            RecipeType.create(HavenCobbleGens.MOD_ID, "cobblegen", CobbleGenRecipe.class);

    @Override
    public ResourceLocation getPluginUid()
    {
        return new ResourceLocation(HavenCobbleGens.MOD_ID, "jei_plugin");
    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration registration) {
        registration.addRecipeCategories(new CobbleGenRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration)
    {
        ItemStack wooden_cobble_gen = new ItemStack(ModBlocks.wooden_cobble_gen.get());
        Component[] description = new Component[]{
                Component.translatable("jei.havencobblegens.cobble_gen.desc.line1"),
                Component.translatable("jei.havencobblegens.cobble_gen.desc.line2")
        };
        registration.addIngredientInfo(wooden_cobble_gen, VanillaTypes.ITEM_STACK, description);

        ItemStack stone_cobble_gen = new ItemStack(ModBlocks.stone_cobble_gen.get());
        description = new Component[]{
                Component.translatable("jei.havencobblegens.cobble_gen.desc.line1"),
                Component.translatable("jei.havencobblegens.cobble_gen.desc.line2")
        };
        registration.addIngredientInfo(stone_cobble_gen, VanillaTypes.ITEM_STACK, description);

        ItemStack iron_cobble_gen = new ItemStack(ModBlocks.iron_cobble_gen.get());
        description = new Component[]{
                Component.translatable("jei.havencobblegens.cobble_gen.desc.line1"),
                Component.translatable("jei.havencobblegens.cobble_gen.desc.line2")
        };
        registration.addIngredientInfo(iron_cobble_gen, VanillaTypes.ITEM_STACK, description);

        ItemStack gold_cobble_gen = new ItemStack(ModBlocks.gold_cobble_gen.get());
        description = new Component[]{
                Component.translatable("jei.havencobblegens.cobble_gen.desc.line1"),
                Component.translatable("jei.havencobblegens.cobble_gen.desc.line2")
        };
        registration.addIngredientInfo(gold_cobble_gen, VanillaTypes.ITEM_STACK, description);

        ItemStack diamond_cobble_gen = new ItemStack(ModBlocks.diamond_cobble_gen.get());
        description = new Component[]{
                Component.translatable("jei.havencobblegens.cobble_gen.desc.line1"),
                Component.translatable("jei.havencobblegens.cobble_gen.desc.line2")
        };
        registration.addIngredientInfo(diamond_cobble_gen, VanillaTypes.ITEM_STACK, description);

        ItemStack emerald_cobble_gen = new ItemStack(ModBlocks.emerald_cobble_gen.get());
        description = new Component[]{
                Component.translatable("jei.havencobblegens.cobble_gen.desc.line1"),
                Component.translatable("jei.havencobblegens.cobble_gen.desc.line2")
        };
        registration.addIngredientInfo(emerald_cobble_gen, VanillaTypes.ITEM_STACK, description);

        ItemStack netherite_cobble_gen = new ItemStack(ModBlocks.netherite_cobble_gen.get());
        description = new Component[]{
                Component.translatable("jei.havencobblegens.cobble_gen.desc.line1"),
                Component.translatable("jei.havencobblegens.cobble_gen.desc.line2")
        };
        registration.addIngredientInfo(netherite_cobble_gen, VanillaTypes.ITEM_STACK, description);

        ItemStack creative_cobble_gen = new ItemStack(ModBlocks.creative_cobble_gen.get());
        description = new Component[]{
                Component.translatable("jei.havencobblegens.cobble_gen.desc.line1"),
                Component.translatable("jei.havencobblegens.cobble_gen.desc.line2")
        };
        registration.addIngredientInfo(creative_cobble_gen, VanillaTypes.ITEM_STACK, description);


        List<CobbleGenRecipe> recipes = new ArrayList<>();
        final int MAX_OUTPUTS_PER_RECIPE = 20;

        Map<RegistryObject<Block>, List<? extends String>> cobbleGenConfigs = Map.of(
                ModBlocks.wooden_cobble_gen, HavenConfig.wooden_cobble_genValidBlocks,
                ModBlocks.stone_cobble_gen, HavenConfig.stone_cobble_genValidBlocks,
                ModBlocks.iron_cobble_gen, HavenConfig.iron_cobble_genValidBlocks,
                ModBlocks.gold_cobble_gen, HavenConfig.gold_cobble_genValidBlocks,
                ModBlocks.diamond_cobble_gen, HavenConfig.diamond_cobble_genValidBlocks,
                ModBlocks.emerald_cobble_gen, HavenConfig.emerald_cobble_genValidBlocks,
                ModBlocks.netherite_cobble_gen, HavenConfig.netherite_cobble_genValidBlocks,
                ModBlocks.creative_cobble_gen, HavenConfig.creative_cobble_genValidBlocks
        );

        for (Map.Entry<RegistryObject<Block>, List<? extends String>> entry : cobbleGenConfigs.entrySet())
        {
            RegistryObject<Block> cobbleGen = entry.getKey();
            List<? extends String> validBlocks = entry.getValue();

            for (String blockEntry : validBlocks)
            {
                String[] parts = blockEntry.split(";");
                if (parts.length != 2) continue;

                // Check if influencing block exists
                Block influencingBlockRaw = ForgeRegistries.BLOCKS.getValue(new ResourceLocation(parts[0]));
                if (influencingBlockRaw == null) continue;
                ItemStack influencingBlock = new ItemStack(influencingBlockRaw);

                // Process outputs and filter invalid ones
                List<ItemStack> allOutputs = Arrays.stream(parts[1].split(","))
                        .map(id ->
                        {
                            Block block = ForgeRegistries.BLOCKS.getValue(new ResourceLocation(id));
                            if (block != null && block != Blocks.AIR) return new ItemStack(block);

                            Item item = ForgeRegistries.ITEMS.getValue(new ResourceLocation(id));
                            if (item != null) return new ItemStack(item);

                            HavenCobbleGens.Log("Invalid block/item ID in cobblegen config: " + id);
                            return null;
                        })
                        .filter(stack -> stack != null) // Remove null items
                        .collect(Collectors.toList());

                if (allOutputs.isEmpty()) continue;

                // Split into multiple recipes if necessary
                for (int i = 0; i < allOutputs.size(); i += MAX_OUTPUTS_PER_RECIPE)
                {
                    int end = Math.min(i + MAX_OUTPUTS_PER_RECIPE, allOutputs.size());
                    List<ItemStack> recipeOutputs = new ArrayList<>(allOutputs.subList(i, end));

                    recipes.add(new CobbleGenRecipe(new ItemStack(cobbleGen.get()), influencingBlock, recipeOutputs));
                }
            }
        }

        if (!recipes.isEmpty())
        {
            registration.addRecipes(JEIHavenCobbleGenPlugin.COBBLEGEN_TYPE, recipes);
        }
    }
}
