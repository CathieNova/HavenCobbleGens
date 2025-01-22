package net.cathienova.havencobblegens.config;

import net.cathienova.havencobblegens.HavenCobbleGens;
import net.neoforged.fml.config.ModConfig;

import java.util.List;

public class HavenConfig
{
    public static int wooden_cobble_gen_speed;
    public static int wooden_cobble_gen_output;
    public static List<? extends String> wooden_cobble_gen_valid_blocks;
    public static int stone_cobble_gen_speed;
    public static int stone_cobble_gen_output;
    public static List<? extends String> stone_cobble_gen_valid_blocks;
    public static int iron_cobble_gen_speed;
    public static int iron_cobble_gen_output;
    public static List<? extends String> iron_cobble_gen_valid_blocks;
    public static int gold_cobble_gen_speed;
    public static int gold_cobble_gen_output;
    public static List<? extends String> gold_cobble_gen_valid_blocks;
    public static int diamond_cobble_gen_speed;
    public static int diamond_cobble_gen_output;
    public static List<? extends String> diamond_cobble_gen_valid_blocks;
    public static int emerald_cobble_gen_speed;
    public static int emerald_cobble_gen_output;
    public static List<? extends String> emerald_cobble_gen_valid_blocks;
    public static int netherite_cobble_gen_speed;
    public static int netherite_cobble_gen_output;
    public static List<? extends String> netherite_cobble_gen_valid_blocks;
    public static int creative_cobble_gen_speed;
    public static int creative_cobble_gen_output;
    public static int creative_cobble_gen_multiplier;
    public static List<? extends String> creative_cobble_gen_valid_blocks;

    public static void bake(ModConfig config)
    {
        wooden_cobble_gen_speed = HavenCobbleGens.c_config.wooden_cobble_gen_speed.get();
        wooden_cobble_gen_output = HavenCobbleGens.c_config.wooden_cobble_gen_output.get();
        wooden_cobble_gen_valid_blocks = HavenCobbleGens.c_config.wooden_cobble_genValidBlocks.get();
        stone_cobble_gen_speed = HavenCobbleGens.c_config.stone_cobble_gen_speed.get();
        stone_cobble_gen_output = HavenCobbleGens.c_config.stone_cobble_gen_output.get();
        stone_cobble_gen_valid_blocks = HavenCobbleGens.c_config.stone_cobble_genValidBlocks.get();
        iron_cobble_gen_speed = HavenCobbleGens.c_config.iron_cobble_gen_speed.get();
        iron_cobble_gen_output = HavenCobbleGens.c_config.iron_cobble_gen_output.get();
        iron_cobble_gen_valid_blocks = HavenCobbleGens.c_config.iron_cobble_genValidBlocks.get();
        gold_cobble_gen_speed = HavenCobbleGens.c_config.gold_cobble_gen_speed.get();
        gold_cobble_gen_output = HavenCobbleGens.c_config.gold_cobble_gen_output.get();
        gold_cobble_gen_valid_blocks = HavenCobbleGens.c_config.gold_cobble_genValidBlocks.get();
        diamond_cobble_gen_speed = HavenCobbleGens.c_config.diamond_cobble_gen_speed.get();
        diamond_cobble_gen_output = HavenCobbleGens.c_config.diamond_cobble_gen_output.get();
        diamond_cobble_gen_valid_blocks = HavenCobbleGens.c_config.diamond_cobble_genValidBlocks.get();
        emerald_cobble_gen_speed = HavenCobbleGens.c_config.emerald_cobble_gen_speed.get();
        emerald_cobble_gen_output = HavenCobbleGens.c_config.emerald_cobble_gen_output.get();
        emerald_cobble_gen_valid_blocks = HavenCobbleGens.c_config.emerald_cobble_genValidBlocks.get();
        netherite_cobble_gen_speed = HavenCobbleGens.c_config.netherite_cobble_gen_speed.get();
        netherite_cobble_gen_output = HavenCobbleGens.c_config.netherite_cobble_gen_output.get();
        netherite_cobble_gen_valid_blocks = HavenCobbleGens.c_config.netherite_cobble_genValidBlocks.get();
        creative_cobble_gen_speed = HavenCobbleGens.c_config.creative_cobble_gen_speed.get();
        creative_cobble_gen_output = HavenCobbleGens.c_config.creative_cobble_gen_output.get();
        creative_cobble_gen_multiplier = HavenCobbleGens.c_config.creative_cobble_gen_multiplier.get();
        creative_cobble_gen_valid_blocks = HavenCobbleGens.c_config.creative_cobble_genValidBlocks.get();
    }
}