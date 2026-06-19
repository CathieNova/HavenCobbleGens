package net.cathienova.havencobblegens.block;

import net.cathienova.havencobblegens.HavenCobbleGens;
import net.cathienova.havencobblegens.block.cobblegen.CobbleGenBlock;
import net.cathienova.havencobblegens.config.HavenConfig;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModBlocks
{
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(HavenCobbleGens.MOD_ID);

    public static final DeferredBlock<CobbleGenBlock> wooden_cobble_gen = BLOCKS.registerBlock("wooden_cobble_gen",
            properties -> new CobbleGenBlock(properties, ModBlockEntities.wooden_cobble_gen_tile,
                    () -> HavenConfig.wooden_cobble_gen_speed,
                    () -> HavenConfig.wooden_cobble_gen_output,
                    () -> HavenConfig.wooden_cobble_gen_valid_blocks),
            properties -> properties.strength(2.0f).requiresCorrectToolForDrops());

    public static final DeferredBlock<CobbleGenBlock> stone_cobble_gen = BLOCKS.registerBlock("stone_cobble_gen",
            properties -> new CobbleGenBlock(properties, ModBlockEntities.stone_cobble_gen_tile,
                    () -> HavenConfig.stone_cobble_gen_speed,
                    () -> HavenConfig.stone_cobble_gen_output,
                    () -> HavenConfig.stone_cobble_gen_valid_blocks),
            properties -> properties.strength(2.0f).requiresCorrectToolForDrops());

    public static final DeferredBlock<CobbleGenBlock> copper_cobble_gen = BLOCKS.registerBlock("copper_cobble_gen",
            properties -> new CobbleGenBlock(properties, ModBlockEntities.copper_cobble_gen_tile,
                    () -> HavenConfig.copper_cobble_gen_speed,
                    () -> HavenConfig.copper_cobble_gen_output,
                    () -> HavenConfig.copper_cobble_gen_valid_blocks),
            properties -> properties.strength(2.0f).requiresCorrectToolForDrops());

    public static final DeferredBlock<CobbleGenBlock> iron_cobble_gen = BLOCKS.registerBlock("iron_cobble_gen",
            properties -> new CobbleGenBlock(properties, ModBlockEntities.iron_cobble_gen_tile,
                    () -> HavenConfig.iron_cobble_gen_speed,
                    () -> HavenConfig.iron_cobble_gen_output,
                    () -> HavenConfig.iron_cobble_gen_valid_blocks),
            properties -> properties.strength(2.0f).requiresCorrectToolForDrops());

    public static final DeferredBlock<CobbleGenBlock> gold_cobble_gen = BLOCKS.registerBlock("gold_cobble_gen",
            properties -> new CobbleGenBlock(properties, ModBlockEntities.gold_cobble_gen_tile,
                    () -> HavenConfig.gold_cobble_gen_speed,
                    () -> HavenConfig.gold_cobble_gen_output,
                    () -> HavenConfig.gold_cobble_gen_valid_blocks),
            properties -> properties.strength(2.0f).requiresCorrectToolForDrops());

    public static final DeferredBlock<CobbleGenBlock> diamond_cobble_gen = BLOCKS.registerBlock("diamond_cobble_gen",
            properties -> new CobbleGenBlock(properties, ModBlockEntities.diamond_cobble_gen_tile,
                    () -> HavenConfig.diamond_cobble_gen_speed,
                    () -> HavenConfig.diamond_cobble_gen_output,
                    () -> HavenConfig.diamond_cobble_gen_valid_blocks),
            properties -> properties.strength(2.0f).requiresCorrectToolForDrops());

    public static final DeferredBlock<CobbleGenBlock> emerald_cobble_gen = BLOCKS.registerBlock("emerald_cobble_gen",
            properties -> new CobbleGenBlock(properties, ModBlockEntities.emerald_cobble_gen_tile,
                    () -> HavenConfig.emerald_cobble_gen_speed,
                    () -> HavenConfig.emerald_cobble_gen_output,
                    () -> HavenConfig.emerald_cobble_gen_valid_blocks),
            properties -> properties.strength(2.0f).requiresCorrectToolForDrops());

    public static final DeferredBlock<CobbleGenBlock> netherite_cobble_gen = BLOCKS.registerBlock("netherite_cobble_gen",
            properties -> new CobbleGenBlock(properties, ModBlockEntities.netherite_cobble_gen_tile,
                    () -> HavenConfig.netherite_cobble_gen_speed,
                    () -> HavenConfig.netherite_cobble_gen_output,
                    () -> HavenConfig.netherite_cobble_gen_valid_blocks),
            properties -> properties.strength(2.0f).requiresCorrectToolForDrops());

    public static final DeferredBlock<CobbleGenBlock> creative_cobble_gen = BLOCKS.registerBlock("creative_cobble_gen",
            properties -> new CobbleGenBlock(properties, ModBlockEntities.creative_cobble_gen_tile,
                    () -> HavenConfig.creative_cobble_gen_speed,
                    () -> HavenConfig.creative_cobble_gen_output,
                    () -> HavenConfig.creative_cobble_gen_multiplier,
                    () -> HavenConfig.creative_cobble_gen_valid_blocks),
            properties -> properties.strength(2.0f).requiresCorrectToolForDrops());

    public static void register(IEventBus eventBus)
    {
        BLOCKS.register(eventBus);
    }
}