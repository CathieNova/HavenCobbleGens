package net.cathienova.havencobblegens.compat.rei;

import me.shedaniel.math.Point;
import me.shedaniel.math.Rectangle;
import me.shedaniel.rei.api.client.gui.widgets.Widget;
import me.shedaniel.rei.api.client.gui.widgets.Widgets;
import me.shedaniel.rei.api.client.registry.display.DisplayCategory;
import me.shedaniel.rei.api.common.category.CategoryIdentifier;
import me.shedaniel.rei.api.common.entry.EntryStack;
import me.shedaniel.rei.api.common.entry.type.VanillaEntryTypes;
import net.cathienova.havencobblegens.HavenCobbleGens;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import org.apache.commons.compress.utils.Lists;

import java.util.ArrayList;
import java.util.List;

public class ItemInfoCategory implements DisplayCategory<ItemInfoDisplay> {
    private static final Component TITLE = Component.translatable("rei.category." + HavenCobbleGens.MOD_ID + ".item_info");

    @Override
    public CategoryIdentifier<? extends ItemInfoDisplay> getCategoryIdentifier() {
        return CategoryIdentifier.of(HavenCobbleGens.MOD_ID, "item_info");
    }

    @Override
    public Component getTitle() {
        return TITLE;
    }

    @Override
    public EntryStack<?> getIcon() {
        return EntryStack.of(VanillaEntryTypes.ITEM, new ItemStack(Items.BOOK));
    }

    @Override
    public int getMaximumDisplaysPerPage() {
        return 1; // Show only one entry per page
    }

    @Override
    public List<Widget> setupDisplay(ItemInfoDisplay display, Rectangle bounds) {
        List<Widget> widgets = Lists.newArrayList();

        int maxWidth = bounds.getWidth() - 40; // Adjust the width for text wrapping
        Font font = Minecraft.getInstance().font;

        // Add the item icon
        if (!display.getOutputEntries().isEmpty()) {
            widgets.add(Widgets.createSlot(new Point(bounds.x + 5, bounds.y - 60))
                    .entries(display.getOutputEntries().getFirst()));
        }

        int yOffset = -60; // Start offset for the first line
        for (Component line : display.getInfo()) {
            if (line.getString().isBlank()) {
                yOffset += 10; // Adjust line spacing for empty lines
                continue;
            }
            List<Component> wrappedLines = splitTextToWidth(line, font, maxWidth);

            for (Component wrappedLine : wrappedLines) {
                widgets.add(Widgets.createLabel(new Point(bounds.x + 30, bounds.y + yOffset), wrappedLine)
                        .leftAligned());
                yOffset += 10; // Adjust line spacing as needed
            }
        }

        return widgets;
    }

    /**
     * Splits a `Component` into multiple lines that fit within a specified width.
     *
     * @param text The `Component` to wrap.
     * @param font The Minecraft font renderer.
     * @param maxWidth The maximum width for each line.
     * @return A list of `Component` objects, one for each wrapped line.
     */
    private List<Component> splitTextToWidth(Component text, Font font, int maxWidth) {
        String rawText = text.getString();
        List<Component> lines = new ArrayList<>();
        StringBuilder currentLine = new StringBuilder();

        for (String word : rawText.split(" ")) {
            if (font.width(currentLine + word) > maxWidth) {
                // Add the current line as a Component and start a new one
                lines.add(Component.literal(currentLine.toString().trim()));
                currentLine = new StringBuilder();
            }
            currentLine.append(word).append(" ");
        }

        // Add the final line
        if (!currentLine.isEmpty()) {
            lines.add(Component.literal(currentLine.toString().trim()));
        }

        return lines;
    }
}
