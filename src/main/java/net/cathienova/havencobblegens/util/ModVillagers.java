package net.cathienova.havencobblegens.util;

import com.google.common.collect.ImmutableSet;
import net.cathienova.havencobblegens.HavenCobbleGens;
import net.cathienova.havencobblegens.block.ModBlocks;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModVillagers
{
    public static final DeferredRegister<PoiType> POI_TYPES =
            DeferredRegister.create(BuiltInRegistries.POINT_OF_INTEREST_TYPE, HavenCobbleGens.MOD_ID);

    public static final DeferredRegister<VillagerProfession> VILLAGER_PROFESSIONS =
            DeferredRegister.create(BuiltInRegistries.VILLAGER_PROFESSION, HavenCobbleGens.MOD_ID);

    public static final Holder<PoiType> COBBLEMASTER_POI = POI_TYPES.register("cobblemaster_poi",
            () -> new PoiType(ImmutableSet.copyOf(ModBlocks.wooden_cobble_gen.get().getStateDefinition().getPossibleStates()),
                    1, 1));

    public static final Holder<VillagerProfession> COBBLEMASTER = VILLAGER_PROFESSIONS.register("cobblemaster",
            () -> new VillagerProfession("cobblemaster", holder -> holder.value() == COBBLEMASTER_POI.value(),
                    poiTypeHolder -> poiTypeHolder.value() == COBBLEMASTER_POI.value(), ImmutableSet.of(), ImmutableSet.of(),
                    SoundEvents.VILLAGER_WORK_MASON));

    public static void register(IEventBus eventBus)
    {
        POI_TYPES.register(eventBus);
        VILLAGER_PROFESSIONS.register(eventBus);
    }
}
