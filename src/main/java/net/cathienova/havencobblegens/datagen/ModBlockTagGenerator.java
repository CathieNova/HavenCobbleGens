package net.cathienova.havencobblegens.datagen;

import net.cathienova.havencobblegens.HavenCobbleGens;
import net.cathienova.havencobblegens.block.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider
{
    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, HavenCobbleGens.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.@NotNull Provider pProvider) {
        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.wooden_cobble_gen.get())
                .add(ModBlocks.stone_cobble_gen.get())
                .add(ModBlocks.iron_cobble_gen.get())
                .add(ModBlocks.gold_cobble_gen.get())
                .add(ModBlocks.diamond_cobble_gen.get())
                .add(ModBlocks.emerald_cobble_gen.get())
                .add(ModBlocks.netherite_cobble_gen.get())
                .add(ModBlocks.creative_cobble_gen.get())
            ;

        this.tag(BlockTags.NEEDS_STONE_TOOL)
                .add(ModBlocks.stone_cobble_gen.get())
            ;

        this.tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.iron_cobble_gen.get())
                .add(ModBlocks.gold_cobble_gen.get())
            ;

        this.tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.diamond_cobble_gen.get())
                .add(ModBlocks.emerald_cobble_gen.get())
            ;

        this.tag(Tags.Blocks.NEEDS_NETHERITE_TOOL)
                .add(ModBlocks.netherite_cobble_gen.get())
                .add(ModBlocks.creative_cobble_gen.get())
            ;
    }
}