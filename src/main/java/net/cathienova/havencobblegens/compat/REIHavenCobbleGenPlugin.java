package net.cathienova.havencobblegens.compat;

import me.shedaniel.rei.api.client.plugins.REIClientPlugin;
import me.shedaniel.rei.api.client.registry.category.CategoryRegistry;
import me.shedaniel.rei.api.client.registry.display.DisplayRegistry;
import me.shedaniel.rei.forge.REIPluginClient;
import net.cathienova.havencobblegens.compat.cobblegen.CobbleGenRecipe;
import net.cathienova.havencobblegens.compat.rei.ItemInfoCategory;
import net.cathienova.havencobblegens.compat.rei.ItemInfoDisplay;

@REIPluginClient
public class REIHavenCobbleGenPlugin implements REIClientPlugin
{
    @Override
    public void registerCategories(CategoryRegistry registry)
    {
        registry.add(new ItemInfoCategory());
    }

    @Override
    public void registerDisplays(DisplayRegistry registry)
    {
        for (CobbleGenRecipe recipe : CobbleGenRecipe.createRecipes())
        {
            registry.add(new ItemInfoDisplay(recipe));
        }
    }
}