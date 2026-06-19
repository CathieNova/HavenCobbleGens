package net.cathienova.havencobblegens.compat.rei;

import me.shedaniel.rei.api.common.category.CategoryIdentifier;
import me.shedaniel.rei.api.common.display.Display;
import me.shedaniel.rei.api.common.display.DisplaySerializer;
import me.shedaniel.rei.api.common.entry.EntryIngredient;
import me.shedaniel.rei.api.common.entry.EntryStack;
import me.shedaniel.rei.api.common.entry.type.VanillaEntryTypes;
import net.cathienova.havencobblegens.HavenCobbleGens;
import net.cathienova.havencobblegens.compat.cobblegen.CobbleGenRecipe;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.ItemStack;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ItemInfoDisplay implements Display
{
    private static final CategoryIdentifier<ItemInfoDisplay> CATEGORY = CategoryIdentifier.of(HavenCobbleGens.MOD_ID, "item_info");

    private final List<EntryIngredient> inputEntries;
    private final List<EntryIngredient> outputEntries;

    public ItemInfoDisplay(CobbleGenRecipe recipe)
    {
        inputEntries = List.of(entry(recipe.getInfluencingBlock()), entry(recipe.getCobbleGen()));

        outputEntries = new ArrayList<>();
        for (ItemStack output : recipe.getOutputBlocks())
        {
            outputEntries.add(entry(output));
        }
    }

    @Override
    public List<EntryIngredient> getInputEntries()
    {
        return inputEntries;
    }

    @Override
    public List<EntryIngredient> getOutputEntries()
    {
        return outputEntries;
    }

    @Override
    public CategoryIdentifier<?> getCategoryIdentifier()
    {
        return CATEGORY;
    }

    @Override
    public Optional<Identifier> getDisplayLocation()
    {
        return Optional.empty();
    }

    @Override
    public DisplaySerializer<? extends Display> getSerializer()
    {
        return null;
    }

    private static EntryIngredient entry(ItemStack itemStack)
    {
        return EntryIngredient.of(EntryStack.of(VanillaEntryTypes.ITEM, itemStack));
    }
}