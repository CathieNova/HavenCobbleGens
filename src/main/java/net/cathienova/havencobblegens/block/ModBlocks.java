package net.cathienova.havencobblegens.block;

import net.cathienova.havencobblegens.HavenCobbleGens;
import net.cathienova.havencobblegens.block.cobblegen.*;
import net.cathienova.havencobblegens.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, HavenCobbleGens.MOD_ID);

    public static final RegistryObject<Block> wooden_cobble_gen = registerBlock("wooden_cobble_gen",
            WoodenCobbleGen::new);

    public static final RegistryObject<Block> stone_cobble_gen = registerBlock("stone_cobble_gen",
            StoneCobbleGen::new);

    public static final RegistryObject<Block> iron_cobble_gen = registerBlock("iron_cobble_gen",
            IronCobbleGen::new);

    public static final RegistryObject<Block> gold_cobble_gen = registerBlock("gold_cobble_gen",
            GoldCobbleGen::new);

    public static final RegistryObject<Block> diamond_cobble_gen = registerBlock("diamond_cobble_gen",
            DiamondCobbleGen::new);

    public static final RegistryObject<Block> emerald_cobble_gen = registerBlock("emerald_cobble_gen",
            EmeraldCobbleGen::new);

    public static final RegistryObject<Block> netherite_cobble_gen = registerBlock("netherite_cobble_gen",
            NetheriteCobbleGen::new);

    public static final RegistryObject<Block> creative_cobble_gen = registerBlock("creative_cobble_gen",
            CreativeCobbleGen::new);

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
