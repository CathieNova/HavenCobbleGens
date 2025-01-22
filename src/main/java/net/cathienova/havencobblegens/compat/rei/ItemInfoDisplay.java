package net.cathienova.havencobblegens.compat.rei;

import me.shedaniel.rei.api.common.category.CategoryIdentifier;
import me.shedaniel.rei.api.common.display.Display;
import me.shedaniel.rei.api.common.entry.EntryIngredient;
import me.shedaniel.rei.api.common.entry.EntryStack;
import me.shedaniel.rei.api.common.entry.type.VanillaEntryTypes;
import net.cathienova.havencobblegens.HavenCobbleGens;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

import java.util.Collections;
import java.util.List;

public class ItemInfoDisplay implements Display {
    private final ItemStack itemStack;
    private final Component[] infoLines;

    public ItemInfoDisplay(Item item, Component[] infoLines) {
        this.itemStack = new ItemStack(item);
        this.infoLines = infoLines;
    }

    public Component[] getInfo() {
        return infoLines;
    }

    @Override
    public List<EntryIngredient> getInputEntries() {
        return Collections.emptyList();
    }

    @Override
    public List<EntryIngredient> getOutputEntries() {
        return List.of(EntryIngredient.of(EntryStack.of(VanillaEntryTypes.ITEM, itemStack)));
    }

    @Override
    public CategoryIdentifier<?> getCategoryIdentifier() {
        return CategoryIdentifier.of(HavenCobbleGens.MOD_ID, "item_info");
    }
}
