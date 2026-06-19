package net.cathienova.havencobblegens.compat.jei;

import mezz.jei.api.ingredients.IIngredientRenderer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;

import java.util.List;

public class SmallItemRenderer implements IIngredientRenderer<ItemStack>
{
    @Override
    public void render(GuiGraphicsExtractor guiGraphics, ItemStack ingredient)
    {
        var poseStack = guiGraphics.pose();
        poseStack.pushMatrix();
        poseStack.scale(0.5f, 0.5f);
        guiGraphics.fakeItem(ingredient, 0, 0);
        poseStack.popMatrix();
    }

    @Override
    public List<Component> getTooltip(ItemStack ingredient, TooltipFlag tooltipFlag)
    {
        Minecraft minecraft = Minecraft.getInstance();
        Player player = minecraft.player;
        Item.TooltipContext tooltipContext = Item.TooltipContext.of(minecraft.level);
        return ingredient.getTooltipLines(tooltipContext, player, tooltipFlag);
    }

    @Override
    public int getWidth()
    {
        return 8;
    }

    @Override
    public int getHeight()
    {
        return 8;
    }
}