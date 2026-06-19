package net.cathienova.havencobblegens.config;

import net.cathienova.havencobblegens.HavenCobbleGens;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.config.ModConfigEvent;

@EventBusSubscriber(modid = HavenCobbleGens.MOD_ID)
public class ConfigSubscriber
{
    @SubscribeEvent
    public static void onModConfigEvent(final ModConfigEvent event)
    {
        if (event instanceof ModConfigEvent.Unloading)
        {
            return;
        }

        if (event.getConfig().getType() == ModConfig.Type.SERVER)
        {
            HavenConfig.bake(event.getConfig());
        }
    }
}