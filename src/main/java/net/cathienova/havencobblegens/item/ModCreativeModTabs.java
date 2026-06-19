package net.cathienova.havencobblegens.item;

import net.cathienova.havencobblegens.HavenCobbleGens;
import net.cathienova.havencobblegens.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeModTabs
{
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, HavenCobbleGens.MOD_ID);

    public static String HavenCobbleGens_tab_title = "itemgroup.havencobblegens.havencobblegens_tab";
    public static final Supplier<CreativeModeTab> Haven_TAB = CREATIVE_MODE_TABS.register("havencobblegens_tab",
            () -> CreativeModeTab.builder().icon(() -> ModItems.creative_cobble_gen.get().getDefaultInstance())
                    .title(Component.translatable(HavenCobbleGens_tab_title))
                    .displayItems((parameters, add) -> {
                        add.accept(ModItems.wooden_cobble_gen.get());
                        add.accept(ModItems.stone_cobble_gen.get());
                        add.accept(ModItems.copper_cobble_gen.get());
                        add.accept(ModItems.iron_cobble_gen.get());
                        add.accept(ModItems.gold_cobble_gen.get());
                        add.accept(ModItems.diamond_cobble_gen.get());
                        add.accept(ModItems.emerald_cobble_gen.get());
                        add.accept(ModItems.netherite_cobble_gen.get());
                        add.accept(ModItems.creative_cobble_gen.get());

                        add.accept(ModItems.cobble_gen_upgrade_wooden.get());
                        add.accept(ModItems.cobble_gen_upgrade_stone.get());
                        add.accept(ModItems.cobble_gen_upgrade_copper.get());
                        add.accept(ModItems.cobble_gen_upgrade_iron.get());
                        add.accept(ModItems.cobble_gen_upgrade_gold.get());
                        add.accept(ModItems.cobble_gen_upgrade_diamond.get());
                        add.accept(ModItems.cobble_gen_upgrade_emerald.get());
                        add.accept(ModItems.cobble_gen_upgrade_netherite.get());
                    }).build());

    public static void register(IEventBus eventBus)
    {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}