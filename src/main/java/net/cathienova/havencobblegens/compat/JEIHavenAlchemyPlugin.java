package net.cathienova.havencobblegens.compat;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.registration.IGuiHandlerRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.cathienova.havencobblegens.HavenCobbleGens;
import net.cathienova.havencobblegens.block.ModBlocks;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;

@JeiPlugin
public class JEIHavenAlchemyPlugin implements IModPlugin
{
    @Override
    public ResourceLocation getPluginUid()
    {
        return ResourceLocation.fromNamespaceAndPath(HavenCobbleGens.MOD_ID, "jei_plugin");
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration)
    {
        ItemStack wooden_cobble_gen = new ItemStack(ModBlocks.wooden_cobble_gen.get());
        Component[] description = new Component[] {
                Component.translatable("jei.havencobblegens.cobble_gen.desc.line1"),
                Component.translatable("jei.havencobblegens.cobble_gen.desc.line2")
        };
        registration.addIngredientInfo(wooden_cobble_gen, VanillaTypes.ITEM_STACK, description);

        ItemStack stone_cobble_gen = new ItemStack(ModBlocks.stone_cobble_gen.get());
        description = new Component[] {
                Component.translatable("jei.havencobblegens.cobble_gen.desc.line1"),
                Component.translatable("jei.havencobblegens.cobble_gen.desc.line2")
        };
        registration.addIngredientInfo(stone_cobble_gen, VanillaTypes.ITEM_STACK, description);

        ItemStack iron_cobble_gen = new ItemStack(ModBlocks.iron_cobble_gen.get());
        description = new Component[] {
                Component.translatable("jei.havencobblegens.cobble_gen.desc.line1"),
                Component.translatable("jei.havencobblegens.cobble_gen.desc.line2")
        };
        registration.addIngredientInfo(iron_cobble_gen, VanillaTypes.ITEM_STACK, description);

        ItemStack gold_cobble_gen = new ItemStack(ModBlocks.gold_cobble_gen.get());
        description = new Component[] {
                Component.translatable("jei.havencobblegens.cobble_gen.desc.line1"),
                Component.translatable("jei.havencobblegens.cobble_gen.desc.line2")
        };
        registration.addIngredientInfo(gold_cobble_gen, VanillaTypes.ITEM_STACK, description);

        ItemStack diamond_cobble_gen = new ItemStack(ModBlocks.diamond_cobble_gen.get());
        description = new Component[] {
                Component.translatable("jei.havencobblegens.cobble_gen.desc.line1"),
                Component.translatable("jei.havencobblegens.cobble_gen.desc.line2")
        };
        registration.addIngredientInfo(diamond_cobble_gen, VanillaTypes.ITEM_STACK, description);

        ItemStack emerald_cobble_gen = new ItemStack(ModBlocks.emerald_cobble_gen.get());
        description = new Component[] {
                Component.translatable("jei.havencobblegens.cobble_gen.desc.line1"),
                Component.translatable("jei.havencobblegens.cobble_gen.desc.line2")
        };
        registration.addIngredientInfo(emerald_cobble_gen, VanillaTypes.ITEM_STACK, description);

        ItemStack netherite_cobble_gen = new ItemStack(ModBlocks.netherite_cobble_gen.get());
        description = new Component[] {
                Component.translatable("jei.havencobblegens.cobble_gen.desc.line1"),
                Component.translatable("jei.havencobblegens.cobble_gen.desc.line2")
        };
        registration.addIngredientInfo(netherite_cobble_gen, VanillaTypes.ITEM_STACK, description);

        ItemStack creative_cobble_gen = new ItemStack(ModBlocks.creative_cobble_gen.get());
        description = new Component[] {
                Component.translatable("jei.havencobblegens.cobble_gen.desc.line1"),
                Component.translatable("jei.havencobblegens.cobble_gen.desc.line2")
        };
        registration.addIngredientInfo(creative_cobble_gen, VanillaTypes.ITEM_STACK, description);
    }
}
