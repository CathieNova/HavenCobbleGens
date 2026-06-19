package net.cathienova.havencobblegens.compat.rei;

import me.shedaniel.math.Point;
import me.shedaniel.math.Rectangle;
import me.shedaniel.rei.api.client.gui.widgets.Widget;
import me.shedaniel.rei.api.client.gui.widgets.Widgets;
import me.shedaniel.rei.api.client.registry.display.DisplayCategory;
import me.shedaniel.rei.api.common.category.CategoryIdentifier;
import me.shedaniel.rei.api.common.entry.EntryIngredient;
import me.shedaniel.rei.api.common.entry.EntryStack;
import me.shedaniel.rei.api.common.entry.type.VanillaEntryTypes;
import net.cathienova.havencobblegens.HavenCobbleGens;
import net.cathienova.havencobblegens.block.ModBlocks;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class ItemInfoCategory implements DisplayCategory<ItemInfoDisplay>
{
    private static final CategoryIdentifier<ItemInfoDisplay> CATEGORY =
            CategoryIdentifier.of(HavenCobbleGens.MOD_ID, "item_info");
    private static final Component TITLE =
            Component.translatable("rei.category." + HavenCobbleGens.MOD_ID + ".item_info");
    private static final Identifier GUI_TEXTURE =
            Identifier.fromNamespaceAndPath(HavenCobbleGens.MOD_ID, "textures/gui/jei_cobblegen.png");
    private static final int WIDTH = 167;
    private static final int HEIGHT = 68;

    @Override
    public CategoryIdentifier<? extends ItemInfoDisplay> getCategoryIdentifier()
    {
        return CATEGORY;
    }

    @Override
    public Component getTitle()
    {
        return TITLE;
    }

    @Override
    public EntryStack<?> getIcon()
    {
        return EntryStack.of(VanillaEntryTypes.ITEM, new ItemStack(ModBlocks.creative_cobble_gen.get()));
    }

    @Override
    public List<Widget> setupDisplay(ItemInfoDisplay display, Rectangle bounds)
    {
        List<Widget> widgets = new ArrayList<>();

        widgets.add(Widgets.createTexturedWidget(GUI_TEXTURE, new Rectangle(bounds.x, bounds.y, WIDTH, HEIGHT),
                0, 0, 256, 256));

        widgets.add(Widgets.createTexturedWidget(GUI_TEXTURE, new Rectangle(bounds.x + 56, bounds.y + 5, 24, 24),
                167, 0, 256, 256));

        widgets.add(Widgets.createTexturedWidget(GUI_TEXTURE, new Rectangle(bounds.x + 86, bounds.y + 5, 24, 24),
                167, 24, 256, 256));

        widgets.add(Widgets.createSlot(new Point(bounds.x + 60, bounds.y + 9))
                .disableBackground()
                .entries(display.getInputEntries().get(0))
                .markInput());

        widgets.add(Widgets.createSlot(new Point(bounds.x + 90, bounds.y + 9))
                .disableBackground()
                .entries(display.getInputEntries().get(1))
                .markInput());

        int x = 12;
        int y = 36;
        int count = 0;

        for (EntryIngredient output : display.getOutputEntries())
        {
            if (count >= 20)
            {
                break;
            }

            widgets.add(Widgets.createTexturedWidget(GUI_TEXTURE, new Rectangle(bounds.x + x - 3, bounds.y + y - 3, 14, 14),
                    167, 48, 256, 256));

            widgets.add(Widgets.createSlot(new Rectangle(bounds.x + x - 1, bounds.y + y - 1, 10, 10))
                    .disableBackground()
                    .entries(output)
                    .markOutput());

            count++;
            x += 15;

            if (count % 10 == 0)
            {
                x = 12;
                y += 15;
            }
        }

        return widgets;
    }

    @Override
    public int getDisplayWidth(ItemInfoDisplay display)
    {
        return WIDTH;
    }

    @Override
    public int getDisplayHeight()
    {
        return HEIGHT;
    }
}