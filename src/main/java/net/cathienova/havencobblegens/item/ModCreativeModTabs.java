package net.cathienova.havencobblegens.item;

import net.cathienova.havencobblegens.HavenCobbleGens;
import net.cathienova.havencobblegens.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeModTabs
{
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, HavenCobbleGens.MOD_ID);

    public static String HavenCobbleGens_tab_title = "itemgroup.havencobblegens.havencobblegens_tab";
    public static final Supplier<CreativeModeTab> Haven_TAB = CREATIVE_MODE_TABS.register("havencobblegens_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.creative_cobble_gen.get()))
                    .title(Component.translatable(HavenCobbleGens_tab_title))
                    .displayItems((pParameters, add) -> {

                        add.accept(new ItemStack(ModBlocks.wooden_cobble_gen.get().asItem()));
                        add.accept(new ItemStack(ModBlocks.stone_cobble_gen.get().asItem()));
                        add.accept(new ItemStack(ModBlocks.iron_cobble_gen.get().asItem()));
                        add.accept(new ItemStack(ModBlocks.gold_cobble_gen.get().asItem()));
                        add.accept(new ItemStack(ModBlocks.diamond_cobble_gen.get().asItem()));
                        add.accept(new ItemStack(ModBlocks.emerald_cobble_gen.get().asItem()));
                        add.accept(new ItemStack(ModBlocks.netherite_cobble_gen.get().asItem()));
                        add.accept(new ItemStack(ModBlocks.creative_cobble_gen.get().asItem()));

                        add.accept(new ItemStack(ModItems.cobble_gen_upgrade_wooden.get()));
                        add.accept(new ItemStack(ModItems.cobble_gen_upgrade_stone.get()));
                        add.accept(new ItemStack(ModItems.cobble_gen_upgrade_iron.get()));
                        add.accept(new ItemStack(ModItems.cobble_gen_upgrade_gold.get()));
                        add.accept(new ItemStack(ModItems.cobble_gen_upgrade_diamond.get()));
                        add.accept(new ItemStack(ModItems.cobble_gen_upgrade_emerald.get()));
                        add.accept(new ItemStack(ModItems.cobble_gen_upgrade_netherite.get()));

                    }).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
