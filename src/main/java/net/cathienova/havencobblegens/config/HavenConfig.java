package net.cathienova.havencobblegens.config;

import net.cathienova.havencobblegens.HavenCobbleGens;
import net.neoforged.fml.config.ModConfig;

import java.util.List;

public class HavenConfig
{
    public static int wooden_cobble_gen_speed = 100;
    public static int wooden_cobble_gen_output = 8;
    public static List<? extends String> wooden_cobble_gen_valid_blocks = List.of();
    public static int stone_cobble_gen_speed = 80;
    public static int stone_cobble_gen_output = 16;
    public static List<? extends String> stone_cobble_gen_valid_blocks = List.of();
    public static int copper_cobble_gen_speed = 70;
    public static int copper_cobble_gen_output = 24;
    public static List<? extends String> copper_cobble_gen_valid_blocks = List.of();
    public static int iron_cobble_gen_speed = 60;
    public static int iron_cobble_gen_output = 32;
    public static List<? extends String> iron_cobble_gen_valid_blocks = List.of();
    public static int gold_cobble_gen_speed = 40;
    public static int gold_cobble_gen_output = 64;
    public static List<? extends String> gold_cobble_gen_valid_blocks = List.of();
    public static int diamond_cobble_gen_speed = 20;
    public static int diamond_cobble_gen_output = 64;
    public static List<? extends String> diamond_cobble_gen_valid_blocks = List.of();
    public static int emerald_cobble_gen_speed = 10;
    public static int emerald_cobble_gen_output = 64;
    public static List<? extends String> emerald_cobble_gen_valid_blocks = List.of();
    public static int netherite_cobble_gen_speed = 5;
    public static int netherite_cobble_gen_output = 64;
    public static List<? extends String> netherite_cobble_gen_valid_blocks = List.of();
    public static int creative_cobble_gen_speed = 1;
    public static int creative_cobble_gen_output = 64;
    public static int creative_cobble_gen_multiplier = 2;
    public static List<? extends String> creative_cobble_gen_valid_blocks = List.of();

    public static void bake(ModConfig config)
    {
        wooden_cobble_gen_speed = HavenCobbleGens.s_config.wooden_cobble_gen_speed.get();
        wooden_cobble_gen_output = HavenCobbleGens.s_config.wooden_cobble_gen_output.get();
        wooden_cobble_gen_valid_blocks = HavenCobbleGens.s_config.wooden_cobble_genValidBlocks.get();
        stone_cobble_gen_speed = HavenCobbleGens.s_config.stone_cobble_gen_speed.get();
        stone_cobble_gen_output = HavenCobbleGens.s_config.stone_cobble_gen_output.get();
        stone_cobble_gen_valid_blocks = HavenCobbleGens.s_config.stone_cobble_genValidBlocks.get();
        copper_cobble_gen_speed = HavenCobbleGens.s_config.copper_cobble_gen_speed.get();
        copper_cobble_gen_output = HavenCobbleGens.s_config.copper_cobble_gen_output.get();
        copper_cobble_gen_valid_blocks = HavenCobbleGens.s_config.copper_cobble_genValidBlocks.get();
        iron_cobble_gen_speed = HavenCobbleGens.s_config.iron_cobble_gen_speed.get();
        iron_cobble_gen_output = HavenCobbleGens.s_config.iron_cobble_gen_output.get();
        iron_cobble_gen_valid_blocks = HavenCobbleGens.s_config.iron_cobble_genValidBlocks.get();
        gold_cobble_gen_speed = HavenCobbleGens.s_config.gold_cobble_gen_speed.get();
        gold_cobble_gen_output = HavenCobbleGens.s_config.gold_cobble_gen_output.get();
        gold_cobble_gen_valid_blocks = HavenCobbleGens.s_config.gold_cobble_genValidBlocks.get();
        diamond_cobble_gen_speed = HavenCobbleGens.s_config.diamond_cobble_gen_speed.get();
        diamond_cobble_gen_output = HavenCobbleGens.s_config.diamond_cobble_gen_output.get();
        diamond_cobble_gen_valid_blocks = HavenCobbleGens.s_config.diamond_cobble_genValidBlocks.get();
        emerald_cobble_gen_speed = HavenCobbleGens.s_config.emerald_cobble_gen_speed.get();
        emerald_cobble_gen_output = HavenCobbleGens.s_config.emerald_cobble_gen_output.get();
        emerald_cobble_gen_valid_blocks = HavenCobbleGens.s_config.emerald_cobble_genValidBlocks.get();
        netherite_cobble_gen_speed = HavenCobbleGens.s_config.netherite_cobble_gen_speed.get();
        netherite_cobble_gen_output = HavenCobbleGens.s_config.netherite_cobble_gen_output.get();
        netherite_cobble_gen_valid_blocks = HavenCobbleGens.s_config.netherite_cobble_genValidBlocks.get();
        creative_cobble_gen_speed = HavenCobbleGens.s_config.creative_cobble_gen_speed.get();
        creative_cobble_gen_output = HavenCobbleGens.s_config.creative_cobble_gen_output.get();
        creative_cobble_gen_multiplier = HavenCobbleGens.s_config.creative_cobble_gen_multiplier.get();
        creative_cobble_gen_valid_blocks = HavenCobbleGens.s_config.creative_cobble_genValidBlocks.get();
    }
}