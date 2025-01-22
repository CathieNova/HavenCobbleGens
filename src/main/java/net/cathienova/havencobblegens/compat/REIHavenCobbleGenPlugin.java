package net.cathienova.havencobblegens.compat;

import me.shedaniel.rei.api.client.plugins.REIClientPlugin;
import me.shedaniel.rei.api.client.registry.category.CategoryRegistry;
import me.shedaniel.rei.api.client.registry.display.DisplayRegistry;
import me.shedaniel.rei.forge.REIPluginClient;
import net.cathienova.havencobblegens.block.ModBlocks;
import net.cathienova.havencobblegens.compat.rei.ItemInfoCategory;
import net.cathienova.havencobblegens.compat.rei.ItemInfoDisplay;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;

import java.util.HashMap;
import java.util.Map;

@REIPluginClient
public class REIHavenCobbleGenPlugin implements REIClientPlugin {
    private static final Map<Item, Component[]> ITEM_DESCRIPTIONS = new HashMap<>();

    @Override
    public void registerCategories(CategoryRegistry registry) {
        registry.add(new ItemInfoCategory());
    }


    static Component[] cobble_gen_descriptions = new Component[] {
            Component.translatable("jei.havencobblegens.cobble_gen.desc.line1"),
            Component.literal(" "),
            Component.translatable("jei.havencobblegens.cobble_gen.desc.line2")
    };

    public static void populateItemDescriptions() {
        // Cobblestone Generators
        ITEM_DESCRIPTIONS.put(ModBlocks.wooden_cobble_gen.asItem(), cobble_gen_descriptions);
        ITEM_DESCRIPTIONS.put(ModBlocks.stone_cobble_gen.asItem(), cobble_gen_descriptions);
        ITEM_DESCRIPTIONS.put(ModBlocks.iron_cobble_gen.asItem(), cobble_gen_descriptions);
        ITEM_DESCRIPTIONS.put(ModBlocks.gold_cobble_gen.asItem(), cobble_gen_descriptions);
        ITEM_DESCRIPTIONS.put(ModBlocks.diamond_cobble_gen.asItem(), cobble_gen_descriptions);
        ITEM_DESCRIPTIONS.put(ModBlocks.emerald_cobble_gen.asItem(), cobble_gen_descriptions);
        ITEM_DESCRIPTIONS.put(ModBlocks.netherite_cobble_gen.asItem(), cobble_gen_descriptions);
        ITEM_DESCRIPTIONS.put(ModBlocks.creative_cobble_gen.asItem(), cobble_gen_descriptions);
    }

    @Override
    public void registerDisplays(DisplayRegistry registry) {
        ITEM_DESCRIPTIONS.forEach((item, description) -> {
            registry.add(new ItemInfoDisplay(item, description));
        });
    }
}
