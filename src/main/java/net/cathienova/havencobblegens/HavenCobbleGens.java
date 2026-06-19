package net.cathienova.havencobblegens;

import com.mojang.logging.LogUtils;
import net.cathienova.havencobblegens.block.ModBlockEntities;
import net.cathienova.havencobblegens.block.ModBlocks;
// import net.cathienova.havencobblegens.compat.REIHavenCobbleGenPlugin;
// import net.cathienova.havencobblegens.compat.top.CobbleGenTOPProvider;
import net.cathienova.havencobblegens.config.ServerConfig;
import net.cathienova.havencobblegens.item.ModCreativeModTabs;
import net.cathienova.havencobblegens.item.ModItems;
import net.cathienova.havencobblegens.util.ModVillagers;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
// import net.neoforged.fml.ModList;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.ModConfigSpec;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import org.apache.commons.lang3.tuple.Pair;

@Mod(HavenCobbleGens.MOD_ID)
public class HavenCobbleGens
{
    public static final String MOD_ID = "havencobblegens";
    public static final String MOD_NAME = "HavenCobbleGenerators";
    static final ModConfigSpec serverSpec;
    public static final ServerConfig s_config;

    static
    {
        final Pair<ServerConfig, ModConfigSpec> specPair = new ModConfigSpec.Builder().configure(ServerConfig::new);
        serverSpec = specPair.getRight();
        s_config = specPair.getLeft();
    }

    public HavenCobbleGens(IEventBus bus, ModContainer modContainer)
    {
        bus.addListener(ModBlockEntities::registerCapabilities);
        modContainer.registerConfig(ModConfig.Type.SERVER, serverSpec);

        NeoForge.EVENT_BUS.register(this);
        ModBlocks.register(bus);
        ModItems.register(bus);
        ModVillagers.register(bus);
        ModBlockEntities.register(bus);
        ModCreativeModTabs.register(bus);
    }

    public static void Log(String message)
    {
        LogUtils.getLogger().info("[" + MOD_NAME + "] " + message);
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {
    }
}