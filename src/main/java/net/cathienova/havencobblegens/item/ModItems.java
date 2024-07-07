package net.cathienova.havencobblegens.item;

import net.cathienova.havencobblegens.HavenCobbleGens;
import net.cathienova.havencobblegens.item.cobblegen.*;
import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, HavenCobbleGens.MOD_ID);


    public static final RegistryObject<Item> cobble_gen_upgrade_wooden = ITEMS.register("cobble_gen_upgrade_wooden",
            () -> new CobbleGenUpgradeWooden(new Item.Properties()));

    public static final RegistryObject<Item> cobble_gen_upgrade_stone = ITEMS.register("cobble_gen_upgrade_stone",
            () -> new CobbleGenUpgradeStone(new Item.Properties()));

    public static final RegistryObject<Item> cobble_gen_upgrade_iron = ITEMS.register("cobble_gen_upgrade_iron",
            () -> new CobbleGenUpgradeIron(new Item.Properties()));

    public static final RegistryObject<Item> cobble_gen_upgrade_gold = ITEMS.register("cobble_gen_upgrade_gold",
            () -> new CobbleGenUpgradeGold(new Item.Properties()));

    public static final RegistryObject<Item> cobble_gen_upgrade_diamond = ITEMS.register("cobble_gen_upgrade_diamond",
            () -> new CobbleGenUpgradeDiamond(new Item.Properties()));

    public static final RegistryObject<Item> cobble_gen_upgrade_emerald = ITEMS.register("cobble_gen_upgrade_emerald",
            () -> new CobbleGenUpgradeEmerald(new Item.Properties()));

    public static final RegistryObject<Item> cobble_gen_upgrade_netherite = ITEMS.register("cobble_gen_upgrade_netherite",
            () -> new CobbleGenUpgradeNetherite(new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
