package net.cathienova.havencobblegens.config;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.config.ModConfigEvent;
import net.neoforged.neoforge.common.ModConfigSpec;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@EventBusSubscriber(modid = "havencobblegens", bus = EventBusSubscriber.Bus.MOD)
public class HavenConfig {

    private static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();

    public static final ModConfigSpec.ConfigValue<List<? extends String>> COBBLEGENVALIDBLOCKS = BUILDER
            .comment("Valid blocks for cobblestone generators at any side. Format: \"checkforblock;outputblock\", it also supports multiple outputblock with comma, if it does not match any then it will return Cobblestone.")
            .defineList("cobbleGenValidBlocks",
                    List.of(
                            "minecraft:stone;minecraft:cobblestone",
                            "minecraft:cobblestone;minecraft:cobblestone",
                            "minecraft:deepslate;minecraft:cobbled_deepslate",
                            "minecraft:cobbled_deepslate;minecraft:cobbled_deepslate",
                            "minecraft:tuff;minecraft:tuff",
                            "minecraft:netherrack;minecraft:netherrack",
                            "minecraft:basalt;minecraft:basalt",
                            "minecraft:blackstone;minecraft:blackstone",
                            "minecraft:andesite;minecraft:andesite",
                            "minecraft:diorite;minecraft:diorite",
                            "minecraft:granite;minecraft:granite",
                            "minecraft:end_stone;minecraft:end_stone",
                            "minecraft:beacon;minecraft:coal_ore,minecraft:iron_ore,minecraft:gold_ore,minecraft:diamond_ore,minecraft:emerald_ore"
                    ),
                    obj -> obj instanceof String && ((String) obj).contains(";"));
    public static final ModConfigSpec.IntValue WOODEN_COBBLE_GEN_SPEED = BUILDER.defineInRange("woodenCobbleGenSpeed", 100, 1, Integer.MAX_VALUE);
    public static final ModConfigSpec.IntValue WOODEN_COBBLE_GEN_OUTPUT = BUILDER.defineInRange("woodenCobbleGenOutput", 8, 1, Integer.MAX_VALUE);
    public static final ModConfigSpec.IntValue STONE_COBBLE_GEN_SPEED = BUILDER.defineInRange("stoneCobbleGenSpeed", 80, 1, Integer.MAX_VALUE);
    public static final ModConfigSpec.IntValue STONE_COBBLE_GEN_OUTPUT = BUILDER.defineInRange("stoneCobbleGenOutput", 16, 1, Integer.MAX_VALUE);
    public static final ModConfigSpec.IntValue IRON_COBBLE_GEN_SPEED = BUILDER.defineInRange("ironCobbleGenSpeed", 60, 1, Integer.MAX_VALUE);
    public static final ModConfigSpec.IntValue IRON_COBBLE_GEN_OUTPUT = BUILDER.defineInRange("ironCobbleGenOutput", 32, 1, Integer.MAX_VALUE);
    public static final ModConfigSpec.IntValue GOLD_COBBLE_GEN_SPEED = BUILDER.defineInRange("goldCobbleGenSpeed", 40, 1, Integer.MAX_VALUE);
    public static final ModConfigSpec.IntValue GOLD_COBBLE_GEN_OUTPUT = BUILDER.defineInRange("goldCobbleGenOutput", 64, 1, Integer.MAX_VALUE);
    public static final ModConfigSpec.IntValue DIAMOND_COBBLE_GEN_SPEED = BUILDER.defineInRange("diamondCobbleGenSpeed", 20, 1, Integer.MAX_VALUE);
    public static final ModConfigSpec.IntValue DIAMOND_COBBLE_GEN_OUTPUT = BUILDER.defineInRange("diamondCobbleGenOutput", 128, 1, Integer.MAX_VALUE);
    public static final ModConfigSpec.IntValue EMERALD_COBBLE_GEN_SPEED = BUILDER.defineInRange("emeraldCobbleGenSpeed", 10, 1, Integer.MAX_VALUE);
    public static final ModConfigSpec.IntValue EMERALD_COBBLE_GEN_OUTPUT = BUILDER.defineInRange("emeraldCobbleGenOutput", 256, 1, Integer.MAX_VALUE);
    public static final ModConfigSpec.IntValue NETHERITE_COBBLE_GEN_SPEED = BUILDER.defineInRange("netheriteCobbleGenSpeed", 5, 1, Integer.MAX_VALUE);
    public static final ModConfigSpec.IntValue NETHERITE_COBBLE_GEN_OUTPUT = BUILDER.defineInRange("netheriteCobbleGenOutput", 512, 1, Integer.MAX_VALUE);
    public static final ModConfigSpec.IntValue CREATIVE_COBBLE_GEN_SPEED = BUILDER.defineInRange("creativeCobbleGenSpeed", 1, 1, Integer.MAX_VALUE);
    public static final ModConfigSpec.IntValue CREATIVE_COBBLE_GEN_OUTPUT = BUILDER.defineInRange("creativeCobbleGenOutput", 10240, 1, Integer.MAX_VALUE);

    public static final ModConfigSpec SPEC = BUILDER.build();

    public static List<? extends String> cobbleGenValidBlocks;
    public static int woodenCobbleGenSpeed;
    public static int woodenCobbleGenOutput;
    public static int stoneCobbleGenSpeed;
    public static int stoneCobbleGenOutput;
    public static int ironCobbleGenSpeed;
    public static int ironCobbleGenOutput;
    public static int goldCobbleGenSpeed;
    public static int goldCobbleGenOutput;
    public static int diamondCobbleGenSpeed;
    public static int diamondCobbleGenOutput;
    public static int emeraldCobbleGenSpeed;
    public static int emeraldCobbleGenOutput;
    public static int netheriteCobbleGenSpeed;
    public static int netheriteCobbleGenOutput;
    public static int creativeCobbleGenSpeed;
    public static int creativeCobbleGenOutput;


    private static boolean validateItemName(final Object obj)
    {
        return obj instanceof String itemName && BuiltInRegistries.ITEM.containsKey(ResourceLocation.parse(itemName));
    }

    @SubscribeEvent
    static void onLoad(ModConfigEvent event) {
        if (event.getConfig().getSpec() == SPEC) {
            cobbleGenValidBlocks = COBBLEGENVALIDBLOCKS.get();
            woodenCobbleGenSpeed = WOODEN_COBBLE_GEN_SPEED.get();
            woodenCobbleGenOutput = WOODEN_COBBLE_GEN_OUTPUT.get();
            stoneCobbleGenSpeed = STONE_COBBLE_GEN_SPEED.get();
            stoneCobbleGenOutput = STONE_COBBLE_GEN_OUTPUT.get();
            ironCobbleGenSpeed = IRON_COBBLE_GEN_SPEED.get();
            ironCobbleGenOutput = IRON_COBBLE_GEN_OUTPUT.get();
            goldCobbleGenSpeed = GOLD_COBBLE_GEN_SPEED.get();
            goldCobbleGenOutput = GOLD_COBBLE_GEN_OUTPUT.get();
            diamondCobbleGenSpeed = DIAMOND_COBBLE_GEN_SPEED.get();
            diamondCobbleGenOutput = DIAMOND_COBBLE_GEN_OUTPUT.get();
            emeraldCobbleGenSpeed = EMERALD_COBBLE_GEN_SPEED.get();
            emeraldCobbleGenOutput = EMERALD_COBBLE_GEN_OUTPUT.get();
            netheriteCobbleGenSpeed = NETHERITE_COBBLE_GEN_SPEED.get();
            netheriteCobbleGenOutput = NETHERITE_COBBLE_GEN_OUTPUT.get();
            creativeCobbleGenSpeed = CREATIVE_COBBLE_GEN_SPEED.get();
            creativeCobbleGenOutput = CREATIVE_COBBLE_GEN_OUTPUT.get();
        }
    }
}
