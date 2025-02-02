package net.cathienova.havencobblegens.datagen;

import net.cathienova.havencobblegens.HavenCobbleGens;
import net.cathienova.havencobblegens.block.ModBlocks;
import net.cathienova.havencobblegens.item.ModCreativeModTabs;
import net.cathienova.havencobblegens.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.LanguageProvider;

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
        add("tooltip.cobblegen_1", "§7Holds §6%d §7Blocks!");
        add("tooltip.cobblegen_2", "§7Generates §6%.2f §7Cobblestone per second!");
        add("tooltip.cobblegen_3", "§7Outputs to an Inventory Above!");
        add("tooltip.cobblegen_4", "§7Outputs to Hopper Below!");

        add("jei.havencobblegens.cobble_gen.desc.line1", "Cobble Generators is a stable source of items for your needs. The higher the tier, the faster it generates.");
        add("jei.havencobblegens.cobble_gen.desc.line2", "It automatically outputs to an inventory above and manually to a hopper below.");
        add("jei.havencobblegens.cobblegen.title", "Cobblestone Generator Outputs");
        add("jei.havencobblegens.cobblegen.input", "§6>> §2Block placed on any side except Top/Bottom §6<<");
        add("jei.havencobblegens.cobblegen.catalyst", "§6>> §2Main Generator §6<<");
        add("jei.havencobblegens.cobblegen.output", "§6>> §2Output §6<<");

        add(ModBlocks.wooden_cobble_gen.get(), "Wooden Cobblestone Generator");
        add(ModBlocks.stone_cobble_gen.get(), "Stone Cobblestone Generator");
        add(ModBlocks.iron_cobble_gen.get(), "Iron Cobblestone Generator");
        add(ModBlocks.gold_cobble_gen.get(), "Gold Cobblestone Generator");
        add(ModBlocks.diamond_cobble_gen.get(), "Diamond Cobblestone Generator");
        add(ModBlocks.emerald_cobble_gen.get(), "Emerald Cobblestone Generator");
        add(ModBlocks.netherite_cobble_gen.get(), "Netherite Cobblestone Generator");
        add(ModBlocks.creative_cobble_gen.get(), "Creative Cobblestone Generator");

        add(ModItems.cobble_gen_upgrade_wooden.get(), "Wooden Cobblestone Generator Upgrade");
        add("item.havenksh.cobble_gen_upgrade_wooden.tooltip", "§bCrouch+Right Click§r to upgrade a §2Wooden§r to §5Stone§r");

        add(ModItems.cobble_gen_upgrade_stone.get(), "Stone Cobblestone Generator Upgrade");
        add("item.havenksh.cobble_gen_upgrade_stone.tooltip", "§bCrouch+Right Click§r to upgrade a §2Stone§r to §5Iron§r.");

        add(ModItems.cobble_gen_upgrade_iron.get(), "Iron Cobblestone Generator Upgrade");
        add("item.havenksh.cobble_gen_upgrade_iron.tooltip", "§bCrouch+Right Click§r to upgrade a §2Iron§r to §5Gold§r.");

        add(ModItems.cobble_gen_upgrade_gold.get(), "Gold Cobblestone Generator Upgrade");
        add("item.havenksh.cobble_gen_upgrade_gold.tooltip", "§bCrouch+Right Click§r to upgrade a §2Gold§r to §5Diamond§r.");

        add(ModItems.cobble_gen_upgrade_diamond.get(), "Diamond Cobblestone Generator Upgrade");
        add("item.havenksh.cobble_gen_upgrade_diamond.tooltip", "§bCrouch+Right Click§r to upgrade a §2Diamond§r to §5Emerald§r.");

        add(ModItems.cobble_gen_upgrade_emerald.get(), "Emerald Cobblestone Generator Upgrade");
        add("item.havenksh.cobble_gen_upgrade_emerald.tooltip", "§bCrouch+Right Click§r to upgrade a §2Emerald§r to §5Netherite§r.");

        add(ModItems.cobble_gen_upgrade_netherite.get(), "Netherite Cobblestone Generator Upgrade");
        add("item.havenksh.cobble_gen_upgrade_netherite.tooltip", "§bCrouch+Right Click§r to upgrade a §2Netherite§r to §5Creative§r.");

        add("advancements.havencobblegens.root.title", "Haven: Cobble Generators");
        add("advancements.havencobblegens.root.description", "Automate cobblestones so you can finally stop mining... forever!");

        add("advancements.havencobblegens.wooden_cobble_gen.title", "Wooden Cobble Generator");
        add("advancements.havencobblegens.wooden_cobble_gen.description", "Starting small: a wooden wonder for all your cobblestone dreams.");

        add("advancements.havencobblegens.stone_cobble_gen.title", "Stone Cobble Generator");
        add("advancements.havencobblegens.stone_cobble_gen.description", "Upgrading to stone, because wood just wasn't rock solid enough.");

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
