package net.cathienova.havencobblegens.block;

import net.cathienova.havencobblegens.HavenCobbleGens;
import net.cathienova.havencobblegens.block.cobblegen.*;
import net.cathienova.havencobblegens.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS =
            DeferredRegister.createBlocks(HavenCobbleGens.MOD_ID);

    public static final DeferredBlock<Block> wooden_cobble_gen = registerBlock("wooden_cobble_gen",
            () -> new WoodenCobbleGen(BlockBehaviour.Properties.of().strength(2.0f)));

    public static final DeferredBlock<Block> stone_cobble_gen = registerBlock("stone_cobble_gen",
            () -> new StoneCobbleGen(BlockBehaviour.Properties.of().strength(2.0f)));

    public static final DeferredBlock<Block> iron_cobble_gen = registerBlock("iron_cobble_gen",
            () -> new IronCobbleGen(BlockBehaviour.Properties.of().strength(2.0f)));

    public static final DeferredBlock<Block> gold_cobble_gen = registerBlock("gold_cobble_gen",
            () -> new GoldCobbleGen(BlockBehaviour.Properties.of().strength(2.0f)));

    public static final DeferredBlock<Block> diamond_cobble_gen = registerBlock("diamond_cobble_gen",
            () -> new DiamondCobbleGen(BlockBehaviour.Properties.of().strength(2.0f)));

    public static final DeferredBlock<Block> emerald_cobble_gen = registerBlock("emerald_cobble_gen",
            () -> new EmeraldCobbleGen(BlockBehaviour.Properties.of().strength(2.0f)));

    public static final DeferredBlock<Block> netherite_cobble_gen = registerBlock("netherite_cobble_gen",
            () -> new NetheriteCobbleGen(BlockBehaviour.Properties.of().strength(2.0f)));

    public static final DeferredBlock<Block> creative_cobble_gen = registerBlock("creative_cobble_gen",
            () -> new CreativeCobbleGen(BlockBehaviour.Properties.of().strength(2.0f)));

    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block) {
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
