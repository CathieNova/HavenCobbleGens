package net.cathienova.havencobblegens.compat.jei;

import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.builder.ITooltipBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.gui.ingredient.IRecipeSlotView;
import mezz.jei.api.gui.ingredient.IRecipeSlotsView;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.helpers.IJeiHelpers;
import mezz.jei.api.helpers.IModIdHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.category.IRecipeCategory;
import mezz.jei.api.recipe.types.IRecipeType;
import net.cathienova.havencobblegens.HavenCobbleGens;
import net.cathienova.havencobblegens.block.ModBlocks;
import net.cathienova.havencobblegens.compat.JEIHavenCobbleGenPlugin;
import net.cathienova.havencobblegens.compat.cobblegen.CobbleGenRecipe;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.ItemStack;
import net.neoforged.fml.ModList;

public class CobbleGenRecipeCategory implements IRecipeCategory<CobbleGenRecipe>
{
    private static final Identifier GUI_TEXTURE =
            Identifier.fromNamespaceAndPath(HavenCobbleGens.MOD_ID, "textures/gui/jei_cobblegen.png");
    private static final int WIDTH = 167;
    private static final int HEIGHT = 68;

    private final IDrawable background;
    private final IDrawable inputSlot;
    private final IDrawable craftingStationSlot;
    private final IDrawable outputSlot;
    private final IDrawable icon;
    private final SmallItemRenderer smallItemRenderer;

    public CobbleGenRecipeCategory(IJeiHelpers jeiHelpers)
    {
        IGuiHelper guiHelper = jeiHelpers.getGuiHelper();
        background = guiHelper.createDrawable(GUI_TEXTURE, 0, 0, WIDTH, HEIGHT);
        inputSlot = guiHelper.createDrawable(GUI_TEXTURE, 167, 0, 24, 24);
        craftingStationSlot = guiHelper.createDrawable(GUI_TEXTURE, 167, 24, 24, 24);
        outputSlot = guiHelper.createDrawable(GUI_TEXTURE, 167, 48, 14, 14);
        icon = guiHelper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(ModBlocks.creative_cobble_gen.get()));
        smallItemRenderer = new SmallItemRenderer();
    }

    @Override
    public IRecipeType<CobbleGenRecipe> getRecipeType()
    {
        return JEIHavenCobbleGenPlugin.COBBLEGEN_TYPE;
    }

    @Override
    public Component getTitle()
    {
        return Component.translatable("jei.havencobblegens.cobblegen.title");
    }

    @Override
    public int getWidth()
    {
        return WIDTH;
    }

    @Override
    public int getHeight()
    {
        return HEIGHT;
    }

    @Override
    public IDrawable getIcon()
    {
        return icon;
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, CobbleGenRecipe recipe, IFocusGroup focuses)
    {
        builder.addSlot(RecipeIngredientRole.INPUT, 60, 9)
                .setSlotName("Block to Check")
                .setBackground(inputSlot, -4, -4)
                .add(recipe.getInfluencingBlock());

        builder.addSlot(RecipeIngredientRole.CRAFTING_STATION, 90, 9)
                .setSlotName("Generator")
                .setBackground(craftingStationSlot, -4, -4)
                .add(recipe.getCobbleGen());

        int x = 12;
        int y = 36;
        int count = 0;

        for (ItemStack output : recipe.getOutputBlocks())
        {
            if (count >= 20)
            {
                break;
            }

            builder.addSlot(RecipeIngredientRole.OUTPUT, x, y)
                    .setSlotName("Output")
                    .setBackground(outputSlot, -3, -3)
                    .setCustomRenderer(VanillaTypes.ITEM_STACK, smallItemRenderer)
                    .add(output);

            count++;
            x += 15;

            if (count % 10 == 0)
            {
                x = 12;
                y += 15;
            }
        }
    }

    @Override
    public void draw(CobbleGenRecipe recipe, IRecipeSlotsView recipeSlotsView, GuiGraphicsExtractor guiGraphics, double mouseX, double mouseY)
    {
        background.draw(guiGraphics);
    }
}