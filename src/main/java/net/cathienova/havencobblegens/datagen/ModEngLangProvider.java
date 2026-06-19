package net.cathienova.havencobblegens.datagen;

import net.cathienova.havencobblegens.HavenCobbleGens;
import net.cathienova.havencobblegens.block.ModBlocks;
import net.cathienova.havencobblegens.item.ModCreativeModTabs;
import net.cathienova.havencobblegens.item.ModItems;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;

public class ModEngLangProvider extends LanguageProvider
{
    public ModEngLangProvider(PackOutput output)
    {
        super(output, HavenCobbleGens.MOD_ID, "en_us");
    }

    @Override
    protected void addTranslations()
    {
        add(ModCreativeModTabs.HavenCobbleGens_tab_title, "§5Haven: §7Cobble Generators");

        add(ModBlocks.wooden_cobble_gen.get(), "Wooden Cobble Gen");
        add(ModBlocks.stone_cobble_gen.get(), "Stone Cobble Gen");
        add(ModBlocks.copper_cobble_gen.get(), "Copper Cobble Gen");
        add(ModBlocks.iron_cobble_gen.get(), "Iron Cobble Gen");
        add(ModBlocks.gold_cobble_gen.get(), "Gold Cobble Gen");
        add(ModBlocks.diamond_cobble_gen.get(), "Diamond Cobble Gen");
        add(ModBlocks.emerald_cobble_gen.get(), "Emerald Cobble Gen");
        add(ModBlocks.netherite_cobble_gen.get(), "Netherite Cobble Gen");
        add(ModBlocks.creative_cobble_gen.get(), "Creative Cobble Gen");

        add(ModItems.cobble_gen_upgrade_wooden.get(), "Wooden Cobble Gen Upgrade");
        add("item.havencobblegens.cobble_gen_upgrade_wooden.tooltip", "§bCrouch+Right Click§r to upgrade a §2Wooden§r to §5Stone§r");

        add(ModItems.cobble_gen_upgrade_stone.get(), "Stone Cobble Gen Upgrade");
        add("item.havencobblegens.cobble_gen_upgrade_stone.tooltip", "§bCrouch+Right Click§r to upgrade a §2Stone§r to §5Copper§r.");

        add(ModItems.cobble_gen_upgrade_copper.get(), "Copper Cobble Gen Upgrade");
        add("item.havencobblegens.cobble_gen_upgrade_copper.tooltip", "§bCrouch+Right Click§r to upgrade a §2Copper§r to §5Iron§r.");

        add(ModItems.cobble_gen_upgrade_iron.get(), "Iron Cobble Gen Upgrade");
        add("item.havencobblegens.cobble_gen_upgrade_iron.tooltip", "§bCrouch+Right Click§r to upgrade a §2Iron§r to §5Gold§r.");

        add(ModItems.cobble_gen_upgrade_gold.get(), "Gold Cobble Gen Upgrade");
        add("item.havencobblegens.cobble_gen_upgrade_gold.tooltip", "§bCrouch+Right Click§r to upgrade a §2Gold§r to §5Diamond§r.");

        add(ModItems.cobble_gen_upgrade_diamond.get(), "Diamond Cobble Gen Upgrade");
        add("item.havencobblegens.cobble_gen_upgrade_diamond.tooltip", "§bCrouch+Right Click§r to upgrade a §2Diamond§r to §5Emerald§r.");

        add(ModItems.cobble_gen_upgrade_emerald.get(), "Emerald Cobble Gen Upgrade");
        add("item.havencobblegens.cobble_gen_upgrade_emerald.tooltip", "§bCrouch+Right Click§r to upgrade a §2Emerald§r to §5Netherite§r.");

        add(ModItems.cobble_gen_upgrade_netherite.get(), "Netherite Cobble Gen Upgrade");
        add("item.havencobblegens.cobble_gen_upgrade_netherite.tooltip", "§bCrouch+Right Click§r to upgrade a §2Netherite§r to §5Creative§r.");

        add("rei.category.havencobblegens.item_info", "Cobble Gen Outputs");
        add("tooltip.cobblegen_1", "§7Holds §6%d §7Blocks!");
        add("tooltip.cobblegen_2", "§7Generates §6%.2f §7Cobblestone per second!");
        add("tooltip.cobblegen.contents", "§7Contains: §6%x %s");

        add("tooltip.cobblegen.amount", "%d / %d");
        add("tooltip.cobblegen.full", "Generator is Full: %d");
        add("tooltip.cobblegen.generating", "Generating %s");

        add("entity.minecraft.villager.havencobblegens.cobblemaster", "Cobble Master");

        add("config.jade.plugin_havencobblegens.cobblegen_data", "Cobble Gen Info");

        add("jei.havencobblegens.cobble_gen.desc.line1", "Cobble Gens are a stable source for your needs. The higher the tier, the faster it generates blocks.");
        add("jei.havencobblegens.cobble_gen.desc.line2", "It automatically outputs to an inventory above and manually to a hopper below.");
        add("jei.havencobblegens.cobblegen.title", "Cobble Gen Outputs");

        add("advancements.havencobblegens.root.title", "Haven: Cobble Generators");
        add("advancements.havencobblegens.root.description", "Automate cobble so you can finally stop mining... forever!");

        add("advancements.havencobblegens.cobble_gen_upgrade_wooden.title", "Wooden Generator Upgrade");
        add("advancements.havencobblegens.cobble_gen_upgrade_wooden.description", "Craft the first upgrade and turn a Wooden Generator into Stone.");

        add("advancements.havencobblegens.cobble_gen_upgrade_stone.title", "Stone Generator Upgrade");
        add("advancements.havencobblegens.cobble_gen_upgrade_stone.description", "Upgrade the Wooden Upgrade into a Stone Upgrade.");

        add("advancements.havencobblegens.cobble_gen_upgrade_copper.title", "Copper Generator Upgrade");
        add("advancements.havencobblegens.cobble_gen_upgrade_copper.description", "Upgrade the Stone Upgrade into a Copper Upgrade.");

        add("advancements.havencobblegens.cobble_gen_upgrade_iron.title", "Iron Generator Upgrade");
        add("advancements.havencobblegens.cobble_gen_upgrade_iron.description", "Upgrade the Copper Upgrade into an Iron Upgrade.");

        add("advancements.havencobblegens.cobble_gen_upgrade_gold.title", "Gold Generator Upgrade");
        add("advancements.havencobblegens.cobble_gen_upgrade_gold.description", "Upgrade the Iron Upgrade into a Gold Upgrade.");

        add("advancements.havencobblegens.cobble_gen_upgrade_diamond.title", "Diamond Generator Upgrade");
        add("advancements.havencobblegens.cobble_gen_upgrade_diamond.description", "Upgrade the Gold Upgrade into a Diamond Upgrade.");

        add("advancements.havencobblegens.cobble_gen_upgrade_emerald.title", "Emerald Generator Upgrade");
        add("advancements.havencobblegens.cobble_gen_upgrade_emerald.description", "Upgrade the Diamond Upgrade into an Emerald Upgrade.");

        add("advancements.havencobblegens.cobble_gen_upgrade_netherite.title", "Netherite Generator Upgrade");
        add("advancements.havencobblegens.cobble_gen_upgrade_netherite.description", "Complete the upgrades with Netherite.");

        add("advancements.havencobblegens.wooden_cobble_gen.title", "Wooden Cobble Generator");
        add("advancements.havencobblegens.wooden_cobble_gen.description", "Starting small: a wooden wonder for all your cobblestone dreams.");

        add("advancements.havencobblegens.stone_cobble_gen.title", "Stone Cobble Generator");
        add("advancements.havencobblegens.stone_cobble_gen.description", "Upgrading to stone, because wood just wasn't rock solid enough.");

        add("advancements.havencobblegens.copper_cobble_gen.title", "Copper Cobble Generator");
        add("advancements.havencobblegens.copper_cobble_gen.description", "Copper-powered cobblestone production, right between stone and iron.");

        add("advancements.havencobblegens.iron_cobble_gen.title", "Iron Cobble Generator");
        add("advancements.havencobblegens.iron_cobble_gen.description", "Stronger than stone, shinier than wood. Iron: now you're serious.");

        add("advancements.havencobblegens.gold_cobble_gen.title", "Gold Cobble Generator");
        add("advancements.havencobblegens.gold_cobble_gen.description", "Golden cobbles, for when you want your rocks to have bling.");

        add("advancements.havencobblegens.diamond_cobble_gen.title", "Diamond Cobble Generator");
        add("advancements.havencobblegens.diamond_cobble_gen.description", "Diamonds are forever, just like your endless supply of cobblestone.");

        add("advancements.havencobblegens.emerald_cobble_gen.title", "Emerald Cobble Generator");
        add("advancements.havencobblegens.emerald_cobble_gen.description", "Green with envy? Get your emerald cobble generator now!");

        add("advancements.havencobblegens.netherite_cobble_gen.title", "Netherite Cobble Generator");
        add("advancements.havencobblegens.netherite_cobble_gen.description", "From the depths of the nether, cobble that's tougher than tough.");

        add("advancements.havencobblegens.creative_cobble_gen.title", "Creative Cobble Generator");
        add("advancements.havencobblegens.creative_cobble_gen.description", "Unlimited cobblestone. Your pickaxe can finally retire.");
    }
}