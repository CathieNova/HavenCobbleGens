package net.cathienova.havencobblegens.compat.jei;

import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.cathienova.havencobblegens.HavenCobbleGens;
import net.cathienova.havencobblegens.block.ModBlocks;
import net.cathienova.havencobblegens.compat.JEIHavenCobbleGenPlugin;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;

public class CobbleGenRecipeCategory implements IRecipeCategory<CobbleGenRecipe>
{
    public static final ResourceLocation UID = new ResourceLocation(HavenCobbleGens.MOD_ID, "cobblegen");
    private static final ResourceLocation GUI_TEXTURE =
            new ResourceLocation(HavenCobbleGens.MOD_ID, "textures/gui/jei_cobblegen.png");
    private final IDrawable background;
    private final IDrawable icon;
    private final IGuiHelper guiHelper;

    public CobbleGenRecipeCategory(IGuiHelper guiHelper)
    {
        this.guiHelper = guiHelper;
        this.background = guiHelper.createDrawable(GUI_TEXTURE, 0, 0, 167, 68);
        this.icon = guiHelper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(ModBlocks.creative_cobble_gen.get()));
    }

    @Override
    public RecipeType<CobbleGenRecipe> getRecipeType()
    {
        return JEIHavenCobbleGenPlugin.COBBLEGEN_TYPE;
    }

    @Override
    public Component getTitle()
    {
        return Component.translatable("jei.havencobblegens.cobblegen.title");
    }

    @Override
    public IDrawable getBackground()
    {
        return background;
    }

    @Override
    public IDrawable getIcon()
    {
        return icon;
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, CobbleGenRecipe recipe, IFocusGroup focuses) {
        // Input - Block to check
        builder.addSlot(RecipeIngredientRole.INPUT, 60, 9)
                .setSlotName("Block to Check")
                .setBackground(getInputSlotDrawable(), -4, -4)
                .addItemStack(recipe.getInfluencingBlock());

        // Generator as Catalyst
        builder.addSlot(RecipeIngredientRole.CATALYST, 90, 9)
                .setSlotName("Generator")
                .setBackground(getCatalystSlotDrawable(), -4, -4)
                .addItemStack(recipe.getCobbleGen());

        // Outputs
        final int maxColumns = 10;
        final int maxItemsPerPage = 20;
        int x = 12;
        int y = 36;
        int count = 0;

        for (ItemStack output : recipe.getOutputBlocks()) {
            if (count >= maxItemsPerPage) break;

            builder.addSlot(RecipeIngredientRole.OUTPUT, x, y)
                    .setSlotName("Output")
                    .setBackground(getOutputSlotDrawable(), -3, -3)
                    .setCustomRenderer(VanillaTypes.ITEM_STACK, new SmallItemRenderer())
                    .addItemStack(output);

            count++;
            x += 15;

            if (count % maxColumns == 0) {
                x = 12;
                y += 15;
            }
        }
    }

    private IDrawable getInputSlotDrawable() {
        return guiHelper.createDrawable(GUI_TEXTURE, 167, 0, 24, 24); // Input slot (168, 0)
    }

    private IDrawable getCatalystSlotDrawable() {
        return guiHelper.createDrawable(GUI_TEXTURE, 167, 24, 24, 24); // Catalyst slot (168, 25)
    }

    private IDrawable getOutputSlotDrawable() {
        return guiHelper.createDrawable(GUI_TEXTURE, 167, 48, 14, 14); // Output slot (168, 50)
    }
}