package net.cathienova.havencobblegens.util;

import com.google.common.collect.ImmutableSet;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import net.cathienova.havencobblegens.HavenCobbleGens;
import net.cathienova.havencobblegens.block.ModBlocks;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.npc.villager.VillagerProfession;
import net.minecraft.world.item.trading.TradeSet;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModVillagers
{
    public static final DeferredRegister<PoiType> POI_TYPES =
            DeferredRegister.create(BuiltInRegistries.POINT_OF_INTEREST_TYPE, HavenCobbleGens.MOD_ID);

    public static final DeferredRegister<VillagerProfession> VILLAGER_PROFESSIONS =
            DeferredRegister.create(BuiltInRegistries.VILLAGER_PROFESSION, HavenCobbleGens.MOD_ID);

    public static final DeferredHolder<PoiType, PoiType> COBBLEMASTER_POI = POI_TYPES.register("cobblemaster_poi",
            () -> new PoiType(getCobbleGenStates(), 1, 1));

    public static final DeferredHolder<VillagerProfession, VillagerProfession> COBBLEMASTER = VILLAGER_PROFESSIONS.register("cobblemaster",
            () -> new VillagerProfession(Component.translatable("entity.minecraft.villager.havencobblegens.cobblemaster"),
                    holder -> holder.is(COBBLEMASTER_POI.getKey()),
                    holder -> holder.is(COBBLEMASTER_POI.getKey()),
                    ImmutableSet.of(), ImmutableSet.of(), SoundEvents.VILLAGER_WORK_MASON, createCobblemasterTrades()));

    private static ImmutableSet<BlockState> getCobbleGenStates()
    {
        return ImmutableSet.copyOf(ModBlocks.wooden_cobble_gen.get().getStateDefinition().getPossibleStates());
    }

    private static Int2ObjectMap<ResourceKey<TradeSet>> createCobblemasterTrades()
    {
        Int2ObjectMap<ResourceKey<TradeSet>> trades = new Int2ObjectOpenHashMap<>();
        for (int level = 1; level <= 5; level++)
        {
            trades.put(level, ResourceKey.create(Registries.TRADE_SET,
                    Identifier.fromNamespaceAndPath(HavenCobbleGens.MOD_ID, "cobblemaster/level_" + level)));
        }
        return trades;
    }

    public static void register(IEventBus eventBus)
    {
        POI_TYPES.register(eventBus);
        VILLAGER_PROFESSIONS.register(eventBus);
    }
}