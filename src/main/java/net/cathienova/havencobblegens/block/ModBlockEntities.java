package net.cathienova.havencobblegens.block;

import net.cathienova.havencobblegens.HavenCobbleGens;
import net.cathienova.havencobblegens.block.cobblegen.*;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockEntities
{

    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, HavenCobbleGens.MOD_ID);

    public static final RegistryObject<BlockEntityType<WoodenCobbleGenEntity>> wooden_cobble_gen_tile = BLOCK_ENTITIES.register("wooden_cobble_gen_tile",
            () -> BlockEntityType.Builder.of(WoodenCobbleGenEntity::new, ModBlocks.wooden_cobble_gen.get()).build(null));

    public static final RegistryObject<BlockEntityType<StoneCobbleGenEntity>> stone_cobble_gen_tile = BLOCK_ENTITIES.register("stone_cobble_gen_tile",
            () -> BlockEntityType.Builder.of(StoneCobbleGenEntity::new, ModBlocks.stone_cobble_gen.get()).build(null));

    public static final RegistryObject<BlockEntityType<IronCobbleGenEntity>> iron_cobble_gen_tile = BLOCK_ENTITIES.register("iron_cobble_gen_tile",
            () -> BlockEntityType.Builder.of(IronCobbleGenEntity::new, ModBlocks.iron_cobble_gen.get()).build(null));

    public static final RegistryObject<BlockEntityType<GoldCobbleGenEntity>> gold_cobble_gen_tile = BLOCK_ENTITIES.register("gold_cobble_gen_tile",
            () -> BlockEntityType.Builder.of(GoldCobbleGenEntity::new, ModBlocks.gold_cobble_gen.get()).build(null));

    public static final RegistryObject<BlockEntityType<DiamondCobbleGenEntity>> diamond_cobble_gen_tile = BLOCK_ENTITIES.register("diamond_cobble_gen_tile",
            () -> BlockEntityType.Builder.of(DiamondCobbleGenEntity::new, ModBlocks.diamond_cobble_gen.get()).build(null));

    public static final RegistryObject<BlockEntityType<EmeraldCobbleGenEntity>> emerald_cobble_gen_tile = BLOCK_ENTITIES.register("emerald_cobble_gen_tile",
            () -> BlockEntityType.Builder.of(EmeraldCobbleGenEntity::new, ModBlocks.emerald_cobble_gen.get()).build(null));

    public static final RegistryObject<BlockEntityType<NetheriteCobbleGenEntity>> netherite_cobble_gen_tile = BLOCK_ENTITIES.register("netherite_cobble_gen_tile",
            () -> BlockEntityType.Builder.of(NetheriteCobbleGenEntity::new, ModBlocks.netherite_cobble_gen.get()).build(null));

    public static final RegistryObject<BlockEntityType<CreativeCobbleGenEntity>> creative_cobble_gen_tile = BLOCK_ENTITIES.register("creative_cobble_gen_tile",
            () -> BlockEntityType.Builder.of(CreativeCobbleGenEntity::new, ModBlocks.creative_cobble_gen.get()).build(null));

    public static void register(IEventBus eventBus)
    {
        BLOCK_ENTITIES.register(eventBus);
    }
}
