package net.cathienova.havencobblegens.block;

import net.cathienova.havencobblegens.HavenCobbleGens;
import net.cathienova.havencobblegens.block.cobblegen.CobbleGenEntity;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModBlockEntities
{
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(BuiltInRegistries.BLOCK_ENTITY_TYPE, HavenCobbleGens.MOD_ID);

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<CobbleGenEntity>> wooden_cobble_gen_tile = BLOCK_ENTITIES.register("wooden_cobble_gen_tile",
            () -> new BlockEntityType<>(CobbleGenEntity::new, ModBlocks.wooden_cobble_gen.get()));
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<CobbleGenEntity>> stone_cobble_gen_tile = BLOCK_ENTITIES.register("stone_cobble_gen_tile",
            () -> new BlockEntityType<>(CobbleGenEntity::new, ModBlocks.stone_cobble_gen.get()));
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<CobbleGenEntity>> copper_cobble_gen_tile = BLOCK_ENTITIES.register("copper_cobble_gen_tile",
            () -> new BlockEntityType<>(CobbleGenEntity::new, ModBlocks.copper_cobble_gen.get()));
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<CobbleGenEntity>> iron_cobble_gen_tile = BLOCK_ENTITIES.register("iron_cobble_gen_tile",
            () -> new BlockEntityType<>(CobbleGenEntity::new, ModBlocks.iron_cobble_gen.get()));
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<CobbleGenEntity>> gold_cobble_gen_tile = BLOCK_ENTITIES.register("gold_cobble_gen_tile",
            () -> new BlockEntityType<>(CobbleGenEntity::new, ModBlocks.gold_cobble_gen.get()));
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<CobbleGenEntity>> diamond_cobble_gen_tile = BLOCK_ENTITIES.register("diamond_cobble_gen_tile",
            () -> new BlockEntityType<>(CobbleGenEntity::new, ModBlocks.diamond_cobble_gen.get()));
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<CobbleGenEntity>> emerald_cobble_gen_tile = BLOCK_ENTITIES.register("emerald_cobble_gen_tile",
            () -> new BlockEntityType<>(CobbleGenEntity::new, ModBlocks.emerald_cobble_gen.get()));
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<CobbleGenEntity>> netherite_cobble_gen_tile = BLOCK_ENTITIES.register("netherite_cobble_gen_tile",
            () -> new BlockEntityType<>(CobbleGenEntity::new, ModBlocks.netherite_cobble_gen.get()));
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<CobbleGenEntity>> creative_cobble_gen_tile = BLOCK_ENTITIES.register("creative_cobble_gen_tile",
            () -> new BlockEntityType<>(CobbleGenEntity::new, ModBlocks.creative_cobble_gen.get()));

    public static void registerCapabilities(RegisterCapabilitiesEvent event)
    {
        event.registerBlockEntity(Capabilities.Item.BLOCK, wooden_cobble_gen_tile.get(), (entity, side) -> entity.getInventory().getHandler());
        event.registerBlockEntity(Capabilities.Item.BLOCK, stone_cobble_gen_tile.get(), (entity, side) -> entity.getInventory().getHandler());
        event.registerBlockEntity(Capabilities.Item.BLOCK, copper_cobble_gen_tile.get(), (entity, side) -> entity.getInventory().getHandler());
        event.registerBlockEntity(Capabilities.Item.BLOCK, iron_cobble_gen_tile.get(), (entity, side) -> entity.getInventory().getHandler());
        event.registerBlockEntity(Capabilities.Item.BLOCK, gold_cobble_gen_tile.get(), (entity, side) -> entity.getInventory().getHandler());
        event.registerBlockEntity(Capabilities.Item.BLOCK, diamond_cobble_gen_tile.get(), (entity, side) -> entity.getInventory().getHandler());
        event.registerBlockEntity(Capabilities.Item.BLOCK, emerald_cobble_gen_tile.get(), (entity, side) -> entity.getInventory().getHandler());
        event.registerBlockEntity(Capabilities.Item.BLOCK, netherite_cobble_gen_tile.get(), (entity, side) -> entity.getInventory().getHandler());
        event.registerBlockEntity(Capabilities.Item.BLOCK, creative_cobble_gen_tile.get(), (entity, side) -> entity.getInventory().getHandler());
    }

    public static void register(IEventBus eventBus)
    {
        BLOCK_ENTITIES.register(eventBus);
    }
}