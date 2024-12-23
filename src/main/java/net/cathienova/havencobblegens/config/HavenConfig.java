package net.cathienova.havencobblegens.config;

import net.cathienova.havencobblegens.HavenCobbleGens;
import net.minecraftforge.fml.config.ModConfig;

import java.util.List;

public class HavenConfig
{
    public static List<? extends String> cobbleGenValidBlocks;
    public static int wooden_cobble_gen_speed;
    public static int wooden_cobble_gen_output;
    public static int stone_cobble_gen_speed;
    public static int stone_cobble_gen_output;
    public static int iron_cobble_gen_speed;
    public static int iron_cobble_gen_output;
    public static int gold_cobble_gen_speed;
    public static int gold_cobble_gen_output;
    public static int diamond_cobble_gen_speed;
    public static int diamond_cobble_gen_output;
    public static int emerald_cobble_gen_speed;
    public static int emerald_cobble_gen_output;
    public static int netherite_cobble_gen_speed;
    public static int netherite_cobble_gen_output;
    public static int creative_cobble_gen_speed;
    public static int creative_cobble_gen_output;
    public static int creative_cobble_gen_yield;

    public static void bake(ModConfig config) {
        cobbleGenValidBlocks = HavenCobbleGens.c_config.cobbleGenValidBlocks.get();
        wooden_cobble_gen_speed = HavenCobbleGens.c_config.wooden_cobble_gen_speed.get();
        wooden_cobble_gen_output = HavenCobbleGens.c_config.wooden_cobble_gen_output.get();
        stone_cobble_gen_speed = HavenCobbleGens.c_config.stone_cobble_gen_speed.get();
        stone_cobble_gen_output = HavenCobbleGens.c_config.stone_cobble_gen_output.get();
        iron_cobble_gen_speed = HavenCobbleGens.c_config.iron_cobble_gen_speed.get();
        iron_cobble_gen_output = HavenCobbleGens.c_config.iron_cobble_gen_output.get();
        gold_cobble_gen_speed = HavenCobbleGens.c_config.gold_cobble_gen_speed.get();
        gold_cobble_gen_output = HavenCobbleGens.c_config.gold_cobble_gen_output.get();
        diamond_cobble_gen_speed = HavenCobbleGens.c_config.diamond_cobble_gen_speed.get();
        diamond_cobble_gen_output = HavenCobbleGens.c_config.diamond_cobble_gen_output.get();
        emerald_cobble_gen_speed = HavenCobbleGens.c_config.emerald_cobble_gen_speed.get();
        emerald_cobble_gen_output = HavenCobbleGens.c_config.emerald_cobble_gen_output.get();
        netherite_cobble_gen_speed = HavenCobbleGens.c_config.netherite_cobble_gen_speed.get();
        netherite_cobble_gen_output = HavenCobbleGens.c_config.netherite_cobble_gen_output.get();
        creative_cobble_gen_speed = HavenCobbleGens.c_config.creative_cobble_gen_speed.get();
        creative_cobble_gen_output = HavenCobbleGens.c_config.creative_cobble_gen_output.get();
        creative_cobble_gen_yield = HavenCobbleGens.c_config.creative_cobble_gen_yield.get();
    }
}
