package net.cathienova.havencobblegens.compat.jei;

import net.minecraft.world.item.ItemStack;

import java.util.List;

public class CobbleGenRecipe {
    private final ItemStack cobbleGen;
    private final ItemStack influencingBlock;
    private final List<ItemStack> outputBlocks;

    public CobbleGenRecipe(ItemStack cobbleGen, ItemStack influencingBlock, List<ItemStack> outputBlocks) {
        this.cobbleGen = cobbleGen;
        this.influencingBlock = influencingBlock;
        this.outputBlocks = outputBlocks;
    }

    public ItemStack getCobbleGen() {
        return cobbleGen;
    }

    public ItemStack getInfluencingBlock() {
        return influencingBlock;
    }

    public List<ItemStack> getOutputBlocks() {
        return outputBlocks;
    }
}
