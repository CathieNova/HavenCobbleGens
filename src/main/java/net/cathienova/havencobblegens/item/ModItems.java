package net.cathienova.havencobblegens.item;

import net.cathienova.havencobblegens.HavenCobbleGens;
import net.cathienova.havencobblegens.block.ModBlocks;
import net.cathienova.havencobblegens.item.cobblegen.CobbleGenUpgradeCopper;
import net.cathienova.havencobblegens.item.cobblegen.CobbleGenUpgradeDiamond;
import net.cathienova.havencobblegens.item.cobblegen.CobbleGenUpgradeEmerald;
import net.cathienova.havencobblegens.item.cobblegen.CobbleGenUpgradeGold;
import net.cathienova.havencobblegens.item.cobblegen.CobbleGenUpgradeIron;
import net.cathienova.havencobblegens.item.cobblegen.CobbleGenUpgradeNetherite;
import net.cathienova.havencobblegens.item.cobblegen.CobbleGenUpgradeStone;
import net.cathienova.havencobblegens.item.cobblegen.CobbleGenUpgradeWooden;
import net.minecraft.world.item.BlockItem;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems
{
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(HavenCobbleGens.MOD_ID);

    public static final DeferredItem<BlockItem> wooden_cobble_gen = ITEMS.registerSimpleBlockItem(ModBlocks.wooden_cobble_gen);
    public static final DeferredItem<BlockItem> stone_cobble_gen = ITEMS.registerSimpleBlockItem(ModBlocks.stone_cobble_gen);
    public static final DeferredItem<BlockItem> copper_cobble_gen = ITEMS.registerSimpleBlockItem(ModBlocks.copper_cobble_gen);
    public static final DeferredItem<BlockItem> iron_cobble_gen = ITEMS.registerSimpleBlockItem(ModBlocks.iron_cobble_gen);
    public static final DeferredItem<BlockItem> gold_cobble_gen = ITEMS.registerSimpleBlockItem(ModBlocks.gold_cobble_gen);
    public static final DeferredItem<BlockItem> diamond_cobble_gen = ITEMS.registerSimpleBlockItem(ModBlocks.diamond_cobble_gen);
    public static final DeferredItem<BlockItem> emerald_cobble_gen = ITEMS.registerSimpleBlockItem(ModBlocks.emerald_cobble_gen);
    public static final DeferredItem<BlockItem> netherite_cobble_gen = ITEMS.registerSimpleBlockItem(ModBlocks.netherite_cobble_gen);
    public static final DeferredItem<BlockItem> creative_cobble_gen = ITEMS.registerSimpleBlockItem(ModBlocks.creative_cobble_gen);

    public static final DeferredItem<CobbleGenUpgradeWooden> cobble_gen_upgrade_wooden = ITEMS.registerItem("cobble_gen_upgrade_wooden", CobbleGenUpgradeWooden::new);
    public static final DeferredItem<CobbleGenUpgradeStone> cobble_gen_upgrade_stone = ITEMS.registerItem("cobble_gen_upgrade_stone", CobbleGenUpgradeStone::new);
    public static final DeferredItem<CobbleGenUpgradeCopper> cobble_gen_upgrade_copper = ITEMS.registerItem("cobble_gen_upgrade_copper", CobbleGenUpgradeCopper::new);
    public static final DeferredItem<CobbleGenUpgradeIron> cobble_gen_upgrade_iron = ITEMS.registerItem("cobble_gen_upgrade_iron", CobbleGenUpgradeIron::new);
    public static final DeferredItem<CobbleGenUpgradeGold> cobble_gen_upgrade_gold = ITEMS.registerItem("cobble_gen_upgrade_gold", CobbleGenUpgradeGold::new);
    public static final DeferredItem<CobbleGenUpgradeDiamond> cobble_gen_upgrade_diamond = ITEMS.registerItem("cobble_gen_upgrade_diamond", CobbleGenUpgradeDiamond::new);
    public static final DeferredItem<CobbleGenUpgradeEmerald> cobble_gen_upgrade_emerald = ITEMS.registerItem("cobble_gen_upgrade_emerald", CobbleGenUpgradeEmerald::new);
    public static final DeferredItem<CobbleGenUpgradeNetherite> cobble_gen_upgrade_netherite = ITEMS.registerItem("cobble_gen_upgrade_netherite", CobbleGenUpgradeNetherite::new);

    public static void register(IEventBus eventBus)
    {
        ITEMS.register(eventBus);
    }
}