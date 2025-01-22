package net.cathienova.havencobblegens.events;

import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.cathienova.havencobblegens.HavenCobbleGens;
import net.cathienova.havencobblegens.util.ModVillagers;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.ItemCost;
import net.minecraft.world.item.trading.MerchantOffer;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.village.VillagerTradesEvent;
import net.neoforged.neoforge.event.village.WandererTradesEvent;

import java.util.List;

@EventBusSubscriber(modid = HavenCobbleGens.MOD_ID, bus = EventBusSubscriber.Bus.GAME)
public class CustomTradesEvent
{
    @SubscribeEvent
    public static void addCustomTrades(VillagerTradesEvent event)
    {
        if (event.getType() == ModVillagers.COBBLEMASTER.value())
        {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();

            // Check if the list at the key exists, if not, create a new list
            trades.get(1).add((entity, randomSource) -> new MerchantOffer(
                    new ItemCost(Items.STONE, 16), // item paid
                    new ItemStack(Items.EMERALD, 1),
                    12, 2, 0.02f));

            trades.get(1).add((entity, randomSource) -> new MerchantOffer(
                    new ItemCost(Items.GRAVEL, 8), // item paid
                    new ItemStack(Items.EMERALD, 1),
                    12, 2, 0.02f));

            trades.get(2).add((entity, randomSource) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD, 2), // item paid
                    new ItemStack(Items.STONE, 4),
                    12, 3, 0.02f));

            trades.get(2).add((entity, randomSource) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD, 2), // item paid
                    new ItemStack(Items.COBBLED_DEEPSLATE, 4),
                    12, 3, 0.02f));

            trades.get(3).add((entity, randomSource) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD, 2), // item paid
                    new ItemStack(Items.GRANITE, 4),
                    12, 4, 0.02f));

            trades.get(3).add((entity, randomSource) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD, 2), // item paid
                    new ItemStack(Items.DRIPSTONE_BLOCK, 4),
                    12, 4, 0.02f));

            trades.get(3).add((entity, randomSource) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD, 2), // item paid
                    new ItemStack(Items.DIORITE, 4),
                    12, 4, 0.02f));

            trades.get(4).add((entity, randomSource) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD, 2), // item paid
                    new ItemStack(Items.TUFF, 4),
                    12, 4, 0.02f));

            trades.get(4).add((entity, randomSource) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD, 2), // item paid
                    new ItemStack(Items.CALCITE, 4),
                    12, 4, 0.02f));

            trades.get(4).add((entity, randomSource) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD, 2), // item paid
                    new ItemStack(Items.BASALT, 4),
                    12, 4, 0.02f));

            trades.get(4).add((entity, randomSource) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD, 3), // item paid
                    new ItemStack(Items.ANDESITE, 4),
                    12, 4, 0.02f));

            trades.get(5).add((entity, randomSource) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD, 2), // item paid
                    new ItemStack(Items.DEEPSLATE, 4),
                    12, 8, 0.02f));
        }
    }

    @SubscribeEvent
    public static void addCustomWanderingTrades(WandererTradesEvent event) {
        List<VillagerTrades.ItemListing> genericTrades = event.getGenericTrades();
        List<VillagerTrades.ItemListing> rareTrades = event.getRareTrades();
    }
}
