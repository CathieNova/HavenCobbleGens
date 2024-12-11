package net.cathienova.havencobblegens.block;

import net.cathienova.havencobblegens.HavenCobbleGens;
import net.cathienova.havencobblegens.block.cobblegen.*;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModBlockEntities
{

    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(BuiltInRegistries.BLOCK_ENTITY_TYPE, HavenCobbleGens.MOD_ID);

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<WoodenCobbleGenEntity>> wooden_cobble_gen_tile = BLOCK_ENTITIES.register("wooden_cobble_gen_tile",
            () -> BlockEntityType.Builder.of(WoodenCobbleGenEntity::new, ModBlocks.wooden_cobble_gen.get()).build(null));

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<StoneCobbleGenEntity>> stone_cobble_gen_tile = BLOCK_ENTITIES.register("stone_cobble_gen_tile",
            () -> BlockEntityType.Builder.of(StoneCobbleGenEntity::new, ModBlocks.stone_cobble_gen.get()).build(null));

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<IronCobbleGenEntity>> iron_cobble_gen_tile = BLOCK_ENTITIES.register("iron_cobble_gen_tile",
            () -> BlockEntityType.Builder.of(IronCobbleGenEntity::new, ModBlocks.iron_cobble_gen.get()).build(null));

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<GoldCobbleGenEntity>> gold_cobble_gen_tile = BLOCK_ENTITIES.register("gold_cobble_gen_tile",
            () -> BlockEntityType.Builder.of(GoldCobbleGenEntity::new, ModBlocks.gold_cobble_gen.get()).build(null));

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<DiamondCobbleGenEntity>> diamond_cobble_gen_tile = BLOCK_ENTITIES.register("diamond_cobble_gen_tile",
            () -> BlockEntityType.Builder.of(DiamondCobbleGenEntity::new, ModBlocks.diamond_cobble_gen.get()).build(null));

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<EmeraldCobbleGenEntity>> emerald_cobble_gen_tile = BLOCK_ENTITIES.register("emerald_cobble_gen_tile",
            () -> BlockEntityType.Builder.of(EmeraldCobbleGenEntity::new, ModBlocks.emerald_cobble_gen.get()).build(null));

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<NetheriteCobbleGenEntity>> netherite_cobble_gen_tile = BLOCK_ENTITIES.register("netherite_cobble_gen_tile",
            () -> BlockEntityType.Builder.of(NetheriteCobbleGenEntity::new, ModBlocks.netherite_cobble_gen.get()).build(null));

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<CreativeCobbleGenEntity>> creative_cobble_gen_tile = BLOCK_ENTITIES.register("creative_cobble_gen_tile",
            () -> BlockEntityType.Builder.of(CreativeCobbleGenEntity::new, ModBlocks.creative_cobble_gen.get()).build(null));

    public static void register(IEventBus eventBus)
    {
        BLOCK_ENTITIES.register(eventBus);
    }
}
