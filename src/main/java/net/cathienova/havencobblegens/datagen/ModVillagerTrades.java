package net.cathienova.havencobblegens.datagen;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import net.cathienova.havencobblegens.HavenCobbleGens;
import net.minecraft.data.CachedOutput;
import net.minecraft.data.DataProvider;
import net.minecraft.data.PackOutput;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModVillagerTrades implements DataProvider
{
    private final Path dataFolder;

    public ModVillagerTrades(PackOutput output)
    {
        dataFolder = output.getOutputFolder(PackOutput.Target.DATA_PACK).resolve(HavenCobbleGens.MOD_ID);
    }

    @Override
    public CompletableFuture<?> run(CachedOutput output)
    {
        List<CompletableFuture<?>> files = new ArrayList<>();

        addLevel(output, files, 1, 2,
                trade("stone_emerald", "minecraft:stone", 16, "minecraft:emerald", 1, 12, 2),
                trade("gravel_emerald", "minecraft:gravel", 8, "minecraft:emerald", 1, 12, 2));

        addLevel(output, files, 2, 2,
                trade("emerald_stone", "minecraft:emerald", 2, "minecraft:stone", 4, 12, 3),
                trade("emerald_cobbled_deepslate", "minecraft:emerald", 2, "minecraft:cobbled_deepslate", 4, 12, 3));

        addLevel(output, files, 3, 2,
                trade("emerald_granite", "minecraft:emerald", 2, "minecraft:granite", 4, 12, 4),
                trade("emerald_dripstone_block", "minecraft:emerald", 2, "minecraft:dripstone_block", 4, 12, 4),
                trade("emerald_diorite", "minecraft:emerald", 2, "minecraft:diorite", 4, 12, 4));

        addLevel(output, files, 4, 2,
                trade("emerald_tuff", "minecraft:emerald", 2, "minecraft:tuff", 4, 12, 4),
                trade("emerald_calcite", "minecraft:emerald", 2, "minecraft:calcite", 4, 12, 4),
                trade("emerald_basalt", "minecraft:emerald", 2, "minecraft:basalt", 4, 12, 4),
                trade("emerald_andesite", "minecraft:emerald", 3, "minecraft:andesite", 4, 12, 4));

        addLevel(output, files, 5, 1,
                trade("emerald_deepslate", "minecraft:emerald", 2, "minecraft:deepslate", 4, 12, 8));

        return CompletableFuture.allOf(files.toArray(CompletableFuture[]::new));
    }

    private void addLevel(CachedOutput output, List<CompletableFuture<?>> files, int level, int amount, Trade... trades)
    {
        JsonArray tradeIds = new JsonArray();

        for (Trade trade : trades)
        {
            String tradePath = "cobblemaster/" + level + "/" + trade.name();
            tradeIds.add(HavenCobbleGens.MOD_ID + ":" + tradePath);
            files.add(DataProvider.saveStable(output, createTradeJson(trade),
                    dataFolder.resolve("villager_trade").resolve(tradePath + ".json")));
        }

        JsonObject tag = new JsonObject();
        tag.add("values", tradeIds);
        files.add(DataProvider.saveStable(output, tag,
                dataFolder.resolve("tags/villager_trade/cobblemaster/level_" + level + ".json")));

        JsonObject tradeSet = new JsonObject();
        tradeSet.addProperty("amount", amount);
        tradeSet.addProperty("random_sequence", HavenCobbleGens.MOD_ID + ":trade_set/cobblemaster/level_" + level);
        tradeSet.addProperty("trades", "#" + HavenCobbleGens.MOD_ID + ":cobblemaster/level_" + level);
        files.add(DataProvider.saveStable(output, tradeSet,
                dataFolder.resolve("trade_set/cobblemaster/level_" + level + ".json")));
    }

    private JsonObject createTradeJson(Trade trade)
    {
        JsonObject json = new JsonObject();
        json.add("gives", itemStack(trade.gives(), trade.givesCount()));
        json.addProperty("max_uses", trade.maxUses());
        json.addProperty("reputation_discount", 0.02F);
        json.add("wants", itemStack(trade.wants(), trade.wantsCount()));
        json.addProperty("xp", trade.xp());
        return json;
    }

    private JsonObject itemStack(String item, int count)
    {
        JsonObject json = new JsonObject();
        if (count > 1)
        {
            json.addProperty("count", count);
        }
        json.addProperty("id", item);
        return json;
    }

    private Trade trade(String name, String wants, int wantsCount, String gives, int givesCount, int maxUses, int xp)
    {
        return new Trade(name, wants, wantsCount, gives, givesCount, maxUses, xp);
    }

    @Override
    public String getName()
    {
        return "Haven Cobble Generators villager trades";
    }

    private record Trade(String name, String wants, int wantsCount, String gives, int givesCount, int maxUses, int xp)
    {
    }
}