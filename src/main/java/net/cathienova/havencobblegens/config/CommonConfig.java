package net.cathienova.havencobblegens.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class CommonConfig {

    public final ForgeConfigSpec.IntValue wooden_cobble_gen_speed;
    public final ForgeConfigSpec.IntValue wooden_cobble_gen_output;
    public final ForgeConfigSpec.IntValue stone_cobble_gen_speed;
    public final ForgeConfigSpec.IntValue stone_cobble_gen_output;
    public final ForgeConfigSpec.IntValue iron_cobble_gen_speed;
    public final ForgeConfigSpec.IntValue iron_cobble_gen_output;
    public final ForgeConfigSpec.IntValue gold_cobble_gen_speed;
    public final ForgeConfigSpec.IntValue gold_cobble_gen_output;
    public final ForgeConfigSpec.IntValue diamond_cobble_gen_speed;
    public final ForgeConfigSpec.IntValue diamond_cobble_gen_output;
    public final ForgeConfigSpec.IntValue emerald_cobble_gen_speed;
    public final ForgeConfigSpec.IntValue emerald_cobble_gen_output;
    public final ForgeConfigSpec.IntValue netherite_cobble_gen_speed;
    public final ForgeConfigSpec.IntValue netherite_cobble_gen_output;
    public final ForgeConfigSpec.IntValue creative_cobble_gen_speed;
    public final ForgeConfigSpec.IntValue creative_cobble_gen_output;

    public CommonConfig(ForgeConfigSpec.Builder builder) {
        builder.comment("Wooden Cobblestone Generator").push("wooden_cobble_gen").build();
        wooden_cobble_gen_speed = builder
                .comment("Speed of the Wooden Cobblestone Generator (ticks per cobblestone)")
                .defineInRange("wooden_cobble_gen_speed", 100, 1, Integer.MAX_VALUE);
        wooden_cobble_gen_output = builder
                .comment("The storage capacity of the Wooden Cobblestone Generator")
                .defineInRange("wooden_cobble_gen_output", 8, 1, Integer.MAX_VALUE);
        builder.pop();

        builder.comment("Stone Cobblestone Generator").push("stone_cobble_gen").build();
        stone_cobble_gen_speed = builder
                .comment("Speed of the Stone Cobblestone Generator (ticks per cobblestone)")
                .defineInRange("stone_cobble_gen_speed", 80, 1, Integer.MAX_VALUE);
        stone_cobble_gen_output = builder
                .comment("The storage capacity of the Stone Cobblestone Generator")
                .defineInRange("stone_cobble_gen_output", 16, 1, Integer.MAX_VALUE);
        builder.pop();

        builder.comment("Iron Cobblestone Generator").push("iron_cobble_gen").build();
        iron_cobble_gen_speed = builder
                .comment("Speed of the Iron Cobblestone Generator (ticks per cobblestone)")
                .defineInRange("iron_cobble_gen_speed", 60, 1, Integer.MAX_VALUE);
        iron_cobble_gen_output = builder
                .comment("The storage capacity of the Iron Cobblestone Generator")
                .defineInRange("iron_cobble_gen_output", 32, 1, Integer.MAX_VALUE);
        builder.pop();

        builder.comment("Gold Cobblestone Generator").push("gold_cobble_gen").build();
        gold_cobble_gen_speed = builder
                .comment("Speed of the Gold Cobblestone Generator (ticks per cobblestone)")
                .defineInRange("gold_cobble_gen_speed", 40, 1, Integer.MAX_VALUE);
        gold_cobble_gen_output = builder
                .comment("The storage capacity of the Gold Cobblestone Generator")
                .defineInRange("gold_cobble_gen_output", 64, 1, Integer.MAX_VALUE);
        builder.pop();

        builder.comment("Diamond Cobblestone Generator").push("diamond_cobble_gen").build();
        diamond_cobble_gen_speed = builder
                .comment("Speed of the Diamond Cobblestone Generator (ticks per cobblestone)")
                .defineInRange("diamond_cobble_gen_speed", 20, 1, Integer.MAX_VALUE);
        diamond_cobble_gen_output = builder
                .comment("The storage capacity of the Diamond Cobblestone Generator")
                .defineInRange("diamond_cobble_gen_output", 128, 1, Integer.MAX_VALUE);
        builder.pop();

        builder.comment("Emerald Cobblestone Generator").push("emerald_cobble_gen").build();
        emerald_cobble_gen_speed = builder
                .comment("Speed of the Emerald Cobblestone Generator (ticks per cobblestone)")
                .defineInRange("emerald_cobble_gen_speed", 10, 1, Integer.MAX_VALUE);
        emerald_cobble_gen_output = builder
                .comment("The storage capacity of the Emerald Cobblestone Generator")
                .defineInRange("emerald_cobble_gen_output", 256, 1, Integer.MAX_VALUE);
        builder.pop();

        builder.comment("Netherite Cobblestone Generator").push("netherite_cobble_gen").build();
        netherite_cobble_gen_speed = builder
                .comment("Speed of the Netherite Cobblestone Generator (ticks per cobblestone)")
                .defineInRange("netherite_cobble_gen_speed", 5, 1, Integer.MAX_VALUE);
        netherite_cobble_gen_output = builder
                .comment("The storage capacity of the Netherite Cobblestone Generator")
                .defineInRange("netherite_cobble_gen_output", 512, 1, Integer.MAX_VALUE);
        builder.pop();

        builder.comment("Creative Cobblestone Generator").push("creative_cobble_gen").build();
        creative_cobble_gen_speed = builder
                .comment("Speed of the Creative Cobblestone Generator (ticks per cobblestone)")
                .defineInRange("creative_cobble_gen_speed", 1, 1, Integer.MAX_VALUE);
        creative_cobble_gen_output = builder
                .comment("The storage capacity of the Creative Cobblestone Generator")
                .defineInRange("creative_cobble_gen_output", 10240, 1, Integer.MAX_VALUE);
        builder.pop();
    }
}
