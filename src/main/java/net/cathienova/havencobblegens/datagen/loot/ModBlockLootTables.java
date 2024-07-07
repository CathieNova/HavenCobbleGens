package net.cathienova.havencobblegens.datagen.loot;

import net.cathienova.havencobblegens.block.ModBlocks;
import net.cathienova.havencobblegens.item.ModItems;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
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
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
