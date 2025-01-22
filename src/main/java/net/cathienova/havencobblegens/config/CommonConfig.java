package net.cathienova.havencobblegens.config;

import net.neoforged.neoforge.common.ModConfigSpec;

import java.util.ArrayList;
import java.util.List;

public class CommonConfig {
    public final ModConfigSpec.IntValue wooden_cobble_gen_speed;
    public final ModConfigSpec.IntValue wooden_cobble_gen_output;
    public final ModConfigSpec.ConfigValue<List<? extends String>> wooden_cobble_genValidBlocks;
    public final ModConfigSpec.IntValue stone_cobble_gen_speed;
    public final ModConfigSpec.IntValue stone_cobble_gen_output;
    public final ModConfigSpec.ConfigValue<List<? extends String>> stone_cobble_genValidBlocks;
    public final ModConfigSpec.IntValue iron_cobble_gen_speed;
    public final ModConfigSpec.IntValue iron_cobble_gen_output;
    public final ModConfigSpec.ConfigValue<List<? extends String>> iron_cobble_genValidBlocks;
    public final ModConfigSpec.IntValue gold_cobble_gen_speed;
    public final ModConfigSpec.IntValue gold_cobble_gen_output;
    public final ModConfigSpec.ConfigValue<List<? extends String>> gold_cobble_genValidBlocks;
    public final ModConfigSpec.IntValue diamond_cobble_gen_speed;
    public final ModConfigSpec.IntValue diamond_cobble_gen_output;
    public final ModConfigSpec.ConfigValue<List<? extends String>> diamond_cobble_genValidBlocks;
    public final ModConfigSpec.IntValue emerald_cobble_gen_speed;
    public final ModConfigSpec.IntValue emerald_cobble_gen_output;
    public final ModConfigSpec.ConfigValue<List<? extends String>> emerald_cobble_genValidBlocks;
    public final ModConfigSpec.IntValue netherite_cobble_gen_speed;
    public final ModConfigSpec.IntValue netherite_cobble_gen_output;
    public final ModConfigSpec.ConfigValue<List<? extends String>> netherite_cobble_genValidBlocks;
    public final ModConfigSpec.IntValue creative_cobble_gen_speed;
    public final ModConfigSpec.IntValue creative_cobble_gen_output;
    public final ModConfigSpec.IntValue creative_cobble_gen_multiplier;
    public final ModConfigSpec.ConfigValue<List<? extends String>> creative_cobble_genValidBlocks;

    public CommonConfig(ModConfigSpec.Builder builder) {
        builder.comment("Wooden Cobblestone Generator").push("wooden_cobble_gen").build();
        wooden_cobble_gen_speed = builder
                .comment("Speed of the Wooden Cobblestone Generator (ticks per cobblestone)")
                .defineInRange("wooden_cobble_gen_speed", 100, 1, Integer.MAX_VALUE);
        wooden_cobble_gen_output = builder
                .comment("The storage capacity of the Wooden Cobblestone Generator")
                .defineInRange("wooden_cobble_gen_output", 8, 1, 64);
        wooden_cobble_genValidBlocks = builder
                .comment("Valid blocks for cobblestone generators at any side. Format: \"checkforblock;outputblock\", it also supports multiple outputblock with comma, if it does not match any then it will return Cobblestone.")
                .defineList("cobbleGenValidBlocks",
                        List.of(
                                "minecraft:stone;minecraft:stone,minecraft:cobblestone",
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
                                "minecraft:end_stone;minecraft:end_stone"
                        ),
                        obj -> obj instanceof String && ((String) obj).contains(";"));
        builder.pop();

        builder.comment("Stone Cobblestone Generator").push("stone_cobble_gen").build();
        stone_cobble_gen_speed = builder
                .comment("Speed of the Stone Cobblestone Generator (ticks per cobblestone)")
                .defineInRange("stone_cobble_gen_speed", 80, 1, Integer.MAX_VALUE);
        stone_cobble_gen_output = builder
                .comment("The storage capacity of the Stone Cobblestone Generator")
                .defineInRange("stone_cobble_gen_output", 16, 1, 64);
        stone_cobble_genValidBlocks = builder
                .comment("Valid blocks for cobblestone generators at any side. Format: \"checkforblock;outputblock\", it also supports multiple outputblock with comma, if it does not match any then it will return Cobblestone.")
                .defineList("cobbleGenValidBlocks",
                        List.of(
                                "minecraft:stone;minecraft:stone,minecraft:cobblestone",
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
                                "minecraft:end_stone;minecraft:end_stone"
                        ),
                        obj -> obj instanceof String && ((String) obj).contains(";"));
        builder.pop();

        builder.comment("Iron Cobblestone Generator").push("iron_cobble_gen").build();
        iron_cobble_gen_speed = builder
                .comment("Speed of the Iron Cobblestone Generator (ticks per cobblestone)")
                .defineInRange("iron_cobble_gen_speed", 60, 1, Integer.MAX_VALUE);
        iron_cobble_gen_output = builder
                .comment("The storage capacity of the Iron Cobblestone Generator")
                .defineInRange("iron_cobble_gen_output", 32, 1, 64);
        iron_cobble_genValidBlocks = builder
                .comment("Valid blocks for cobblestone generators at any side. Format: \"checkforblock;outputblock\", it also supports multiple outputblock with comma, if it does not match any then it will return Cobblestone.")
                .defineList("cobbleGenValidBlocks",
                        List.of(
                                "minecraft:stone;minecraft:stone,minecraft:cobblestone",
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
                                "minecraft:end_stone;minecraft:end_stone"
                        ),
                        obj -> obj instanceof String && ((String) obj).contains(";"));
        builder.pop();

        builder.comment("Gold Cobblestone Generator").push("gold_cobble_gen").build();
        gold_cobble_gen_speed = builder
                .comment("Speed of the Gold Cobblestone Generator (ticks per cobblestone)")
                .defineInRange("gold_cobble_gen_speed", 40, 1, Integer.MAX_VALUE);
        gold_cobble_gen_output = builder
                .comment("The storage capacity of the Gold Cobblestone Generator")
                .defineInRange("gold_cobble_gen_output", 64, 1, 64);
        gold_cobble_genValidBlocks = builder
                .comment("Valid blocks for cobblestone generators at any side. Format: \"checkforblock;outputblock\", it also supports multiple outputblock with comma, if it does not match any then it will return Cobblestone.")
                .defineList("cobbleGenValidBlocks",
                        List.of(
                                "minecraft:stone;minecraft:stone,minecraft:cobblestone",
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
                                "minecraft:end_stone;minecraft:end_stone"
                        ),
                        obj -> obj instanceof String && ((String) obj).contains(";"));
        builder.pop();

        builder.comment("Diamond Cobblestone Generator").push("diamond_cobble_gen").build();
        diamond_cobble_gen_speed = builder
                .comment("Speed of the Diamond Cobblestone Generator (ticks per cobblestone)")
                .defineInRange("diamond_cobble_gen_speed", 20, 1, Integer.MAX_VALUE);
        diamond_cobble_gen_output = builder
                .comment("The storage capacity of the Diamond Cobblestone Generator")
                .defineInRange("diamond_cobble_gen_output", 64, 1, 64);
        diamond_cobble_genValidBlocks = builder
                .comment("Valid blocks for cobblestone generators at any side. Format: \"checkforblock;outputblock\", it also supports multiple outputblock with comma, if it does not match any then it will return Cobblestone.")
                .defineList("cobbleGenValidBlocks",
                        List.of(
                                "minecraft:stone;minecraft:stone,minecraft:cobblestone",
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
                                "minecraft:end_stone;minecraft:end_stone"
                        ),
                        obj -> obj instanceof String && ((String) obj).contains(";"));
        builder.pop();

        builder.comment("Emerald Cobblestone Generator").push("emerald_cobble_gen").build();
        emerald_cobble_gen_speed = builder
                .comment("Speed of the Emerald Cobblestone Generator (ticks per cobblestone)")
                .defineInRange("emerald_cobble_gen_speed", 10, 1, Integer.MAX_VALUE);
        emerald_cobble_gen_output = builder
                .comment("The storage capacity of the Emerald Cobblestone Generator")
                .defineInRange("emerald_cobble_gen_output", 64, 1, 64);
        emerald_cobble_genValidBlocks = builder
                .comment("Valid blocks for cobblestone generators at any side. Format: \"checkforblock;outputblock\", it also supports multiple outputblock with comma, if it does not match any then it will return Cobblestone.")
                .defineList("cobbleGenValidBlocks",
                        List.of(
                                "minecraft:stone;minecraft:stone,minecraft:cobblestone",
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
                                "minecraft:end_stone;minecraft:end_stone"
                        ),
                        obj -> obj instanceof String && ((String) obj).contains(";"));
        builder.pop();

        builder.comment("Netherite Cobblestone Generator").push("netherite_cobble_gen").build();
        netherite_cobble_gen_speed = builder
                .comment("Speed of the Netherite Cobblestone Generator (ticks per cobblestone)")
                .defineInRange("netherite_cobble_gen_speed", 5, 1, Integer.MAX_VALUE);
        netherite_cobble_gen_output = builder
                .comment("The storage capacity of the Netherite Cobblestone Generator")
                .defineInRange("netherite_cobble_gen_output", 64, 1, 64);
        netherite_cobble_genValidBlocks = builder
                .comment("Valid blocks for cobblestone generators at any side. Format: \"checkforblock;outputblock\", it also supports multiple outputblock with comma, if it does not match any then it will return Cobblestone.")
                .defineList("cobbleGenValidBlocks",
                        List.of(
                                "minecraft:stone;minecraft:stone,minecraft:cobblestone",
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
                                "minecraft:end_stone;minecraft:end_stone"
                        ),
                        obj -> obj instanceof String && ((String) obj).contains(";"));
        builder.pop();

        builder.comment("Creative Cobblestone Generator").push("creative_cobble_gen").build();
        creative_cobble_gen_speed = builder
                .comment("Speed of the Creative Cobblestone Generator (ticks per 2 cobblestone)")
                .defineInRange("creative_cobble_gen_speed", 1, 1, Integer.MAX_VALUE);
        creative_cobble_gen_output = builder
                .comment("The storage capacity of the Creative Cobblestone Generator")
                .defineInRange("creative_cobble_gen_output", 64, 1, 64);
        creative_cobble_gen_multiplier = builder
                .comment("The multiplier for the Creative Cobblestone Generator, this will multiply the output by this value")
                .defineInRange("creative_cobble_gen_multiplier", 2, 1, 32);
        creative_cobble_genValidBlocks = builder
                .comment("Valid blocks for cobblestone generators at any side. Format: \"checkforblock;outputblock\", it also supports multiple outputblock with comma, if it does not match any then it will return Cobblestone.")
                .defineList("cobbleGenValidBlocks",
                        List.of(
                                "minecraft:stone;minecraft:stone,minecraft:cobblestone",
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
                                "minecraft:end_stone;minecraft:end_stone"
                        ),
                        obj -> obj instanceof String && ((String) obj).contains(";"));
        builder.pop();
    }
}