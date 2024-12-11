package net.cathienova.havencobblegens.datagen.loot;

import net.cathienova.havencobblegens.block.ModBlocks;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    protected ModBlockLootTables(HolderLookup.Provider registries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), registries);
    }

    @Override
    protected void generate()
    {
        this.dropSelf(ModBlocks.wooden_cobble_gen.get());
        this.dropSelf(ModBlocks.stone_cobble_gen.get());
        this.dropSelf(ModBlocks.iron_cobble_gen.get());
        this.dropSelf(ModBlocks.gold_cobble_gen.get());
        this.dropSelf(ModBlocks.diamond_cobble_gen.get());
        this.dropSelf(ModBlocks.emerald_cobble_gen.get());
        this.dropSelf(ModBlocks.netherite_cobble_gen.get());
        this.dropSelf(ModBlocks.creative_cobble_gen.get());
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(Holder::value)::iterator;
    }
}
