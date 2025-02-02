package net.cathienova.havencobblegens.compat.jei;

import mezz.jei.api.ingredients.IIngredientRenderer;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;

import java.util.List;

public class SmallItemRenderer implements IIngredientRenderer<ItemStack>
{
    @Override
    public void render(GuiGraphics graphics, ItemStack stack) {
        graphics.pose().pushPose();
        graphics.pose().scale(0.5f, 0.5f, 1.0f);
        graphics.renderItem(stack, 0, 0);
        graphics.pose().popPose();
    }

    @Override
    public List<Component> getTooltip(ItemStack stack, TooltipFlag flag) {
        return stack.getTooltipLines(null, flag);
    }

    @Override
    public int getWidth() {
        return 8; // Reduce width from default 16
    }

    @Override
    public int getHeight() {
        return 8; // Reduce height from default 16
    }
}

