package net.cathienova.havencobblegens.datagen;

import net.cathienova.havencobblegens.HavenCobbleGens;
import net.cathienova.havencobblegens.block.ModBlocks;
import net.cathienova.havencobblegens.item.ModItems;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementHolder;
import net.minecraft.advancements.AdvancementType;
import net.minecraft.advancements.criterion.InventoryChangeTrigger;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.advancements.AdvancementProvider;
import net.minecraft.data.advancements.AdvancementSubProvider;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

public class ModAdvancementProvider extends AdvancementProvider
{
    public ModAdvancementProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries)
    {
        super(output, registries, List.of(new ModAdvancements()));
    }

    public static class ModAdvancements implements AdvancementSubProvider
    {
        @Override
        public void generate(HolderLookup.Provider provider, Consumer<AdvancementHolder> consumer)
        {
            AdvancementHolder root = Advancement.Builder.advancement()
                    .display(ModBlocks.creative_cobble_gen.get(),
                            Component.translatable("advancements.havencobblegens.root.title"),
                            Component.translatable("advancements.havencobblegens.root.description"),
                            Identifier.fromNamespaceAndPath(HavenCobbleGens.MOD_ID, "block/cobblegens/panel"),
                            AdvancementType.TASK, true, true, false)
                    .addCriterion("wooden_cobble_gen", InventoryChangeTrigger.TriggerInstance.hasItems(ModBlocks.wooden_cobble_gen.get()))
                    .save(consumer, Identifier.fromNamespaceAndPath(HavenCobbleGens.MOD_ID, "root"));


            AdvancementHolder woodenUpgrade = Advancement.Builder.advancement()
                    .parent(root)
                    .display(ModItems.cobble_gen_upgrade_wooden.get(),
                            Component.translatable("advancements.havencobblegens.cobble_gen_upgrade_wooden.title"),
                            Component.translatable("advancements.havencobblegens.cobble_gen_upgrade_wooden.description"),
                            null,
                            AdvancementType.TASK, true, true, false)
                    .addCriterion("cobble_gen_upgrade_wooden", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.cobble_gen_upgrade_wooden.get()))
                    .save(consumer, Identifier.fromNamespaceAndPath(HavenCobbleGens.MOD_ID, "cobble_gen_upgrade_wooden"));

            AdvancementHolder stoneUpgrade = Advancement.Builder.advancement()
                    .parent(woodenUpgrade)
                    .display(ModItems.cobble_gen_upgrade_stone.get(),
                            Component.translatable("advancements.havencobblegens.cobble_gen_upgrade_stone.title"),
                            Component.translatable("advancements.havencobblegens.cobble_gen_upgrade_stone.description"),
                            null,
                            AdvancementType.TASK, true, true, false)
                    .addCriterion("cobble_gen_upgrade_stone", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.cobble_gen_upgrade_stone.get()))
                    .save(consumer, Identifier.fromNamespaceAndPath(HavenCobbleGens.MOD_ID, "cobble_gen_upgrade_stone"));

            AdvancementHolder copperUpgrade = Advancement.Builder.advancement()
                    .parent(stoneUpgrade)
                    .display(ModItems.cobble_gen_upgrade_copper.get(),
                            Component.translatable("advancements.havencobblegens.cobble_gen_upgrade_copper.title"),
                            Component.translatable("advancements.havencobblegens.cobble_gen_upgrade_copper.description"),
                            null,
                            AdvancementType.TASK, true, true, false)
                    .addCriterion("cobble_gen_upgrade_copper", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.cobble_gen_upgrade_copper.get()))
                    .save(consumer, Identifier.fromNamespaceAndPath(HavenCobbleGens.MOD_ID, "cobble_gen_upgrade_copper"));

            AdvancementHolder ironUpgrade = Advancement.Builder.advancement()
                    .parent(copperUpgrade)
                    .display(ModItems.cobble_gen_upgrade_iron.get(),
                            Component.translatable("advancements.havencobblegens.cobble_gen_upgrade_iron.title"),
                            Component.translatable("advancements.havencobblegens.cobble_gen_upgrade_iron.description"),
                            null,
                            AdvancementType.TASK, true, true, false)
                    .addCriterion("cobble_gen_upgrade_iron", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.cobble_gen_upgrade_iron.get()))
                    .save(consumer, Identifier.fromNamespaceAndPath(HavenCobbleGens.MOD_ID, "cobble_gen_upgrade_iron"));

            AdvancementHolder goldUpgrade = Advancement.Builder.advancement()
                    .parent(ironUpgrade)
                    .display(ModItems.cobble_gen_upgrade_gold.get(),
                            Component.translatable("advancements.havencobblegens.cobble_gen_upgrade_gold.title"),
                            Component.translatable("advancements.havencobblegens.cobble_gen_upgrade_gold.description"),
                            null,
                            AdvancementType.TASK, true, true, false)
                    .addCriterion("cobble_gen_upgrade_gold", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.cobble_gen_upgrade_gold.get()))
                    .save(consumer, Identifier.fromNamespaceAndPath(HavenCobbleGens.MOD_ID, "cobble_gen_upgrade_gold"));

            AdvancementHolder diamondUpgrade = Advancement.Builder.advancement()
                    .parent(goldUpgrade)
                    .display(ModItems.cobble_gen_upgrade_diamond.get(),
                            Component.translatable("advancements.havencobblegens.cobble_gen_upgrade_diamond.title"),
                            Component.translatable("advancements.havencobblegens.cobble_gen_upgrade_diamond.description"),
                            null,
                            AdvancementType.TASK, true, true, false)
                    .addCriterion("cobble_gen_upgrade_diamond", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.cobble_gen_upgrade_diamond.get()))
                    .save(consumer, Identifier.fromNamespaceAndPath(HavenCobbleGens.MOD_ID, "cobble_gen_upgrade_diamond"));

            AdvancementHolder emeraldUpgrade = Advancement.Builder.advancement()
                    .parent(diamondUpgrade)
                    .display(ModItems.cobble_gen_upgrade_emerald.get(),
                            Component.translatable("advancements.havencobblegens.cobble_gen_upgrade_emerald.title"),
                            Component.translatable("advancements.havencobblegens.cobble_gen_upgrade_emerald.description"),
                            null,
                            AdvancementType.TASK, true, true, false)
                    .addCriterion("cobble_gen_upgrade_emerald", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.cobble_gen_upgrade_emerald.get()))
                    .save(consumer, Identifier.fromNamespaceAndPath(HavenCobbleGens.MOD_ID, "cobble_gen_upgrade_emerald"));

            AdvancementHolder netheriteUpgrade = Advancement.Builder.advancement()
                    .parent(emeraldUpgrade)
                    .display(ModItems.cobble_gen_upgrade_netherite.get(),
                            Component.translatable("advancements.havencobblegens.cobble_gen_upgrade_netherite.title"),
                            Component.translatable("advancements.havencobblegens.cobble_gen_upgrade_netherite.description"),
                            null,
                            AdvancementType.GOAL, true, true, false)
                    .addCriterion("cobble_gen_upgrade_netherite", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.cobble_gen_upgrade_netherite.get()))
                    .save(consumer, Identifier.fromNamespaceAndPath(HavenCobbleGens.MOD_ID, "cobble_gen_upgrade_netherite"));

            AdvancementHolder woodenCobbleGen = Advancement.Builder.advancement()
                    .parent(root)
                    .display(ModBlocks.wooden_cobble_gen.get(),
                            Component.translatable("advancements.havencobblegens.wooden_cobble_gen.title"),
                            Component.translatable("advancements.havencobblegens.wooden_cobble_gen.description"),
                            null,
                            AdvancementType.TASK, true, true, false)
                    .addCriterion("wooden_cobble_gen", InventoryChangeTrigger.TriggerInstance.hasItems(ModBlocks.wooden_cobble_gen.get()))
                    .save(consumer, Identifier.fromNamespaceAndPath(HavenCobbleGens.MOD_ID, "wooden_cobble_gen"));

            AdvancementHolder stoneCobbleGen = Advancement.Builder.advancement()
                    .parent(woodenCobbleGen)
                    .display(ModBlocks.stone_cobble_gen.get(),
                            Component.translatable("advancements.havencobblegens.stone_cobble_gen.title"),
                            Component.translatable("advancements.havencobblegens.stone_cobble_gen.description"),
                            null,
                            AdvancementType.TASK, true, true, false)
                    .addCriterion("stone_cobble_gen", InventoryChangeTrigger.TriggerInstance.hasItems(ModBlocks.stone_cobble_gen.get()))
                    .save(consumer, Identifier.fromNamespaceAndPath(HavenCobbleGens.MOD_ID, "stone_cobble_gen"));

            AdvancementHolder copperCobbleGen = Advancement.Builder.advancement()
                    .parent(stoneCobbleGen)
                    .display(ModBlocks.copper_cobble_gen.get(),
                            Component.translatable("advancements.havencobblegens.copper_cobble_gen.title"),
                            Component.translatable("advancements.havencobblegens.copper_cobble_gen.description"),
                            null,
                            AdvancementType.TASK, true, true, false)
                    .addCriterion("copper_cobble_gen", InventoryChangeTrigger.TriggerInstance.hasItems(ModBlocks.copper_cobble_gen.get()))
                    .save(consumer, Identifier.fromNamespaceAndPath(HavenCobbleGens.MOD_ID, "copper_cobble_gen"));

            AdvancementHolder ironCobbleGen = Advancement.Builder.advancement()
                    .parent(copperCobbleGen)
                    .display(ModBlocks.iron_cobble_gen.get(),
                            Component.translatable("advancements.havencobblegens.iron_cobble_gen.title"),
                            Component.translatable("advancements.havencobblegens.iron_cobble_gen.description"),
                            null,
                            AdvancementType.TASK, true, true, false)
                    .addCriterion("iron_cobble_gen", InventoryChangeTrigger.TriggerInstance.hasItems(ModBlocks.iron_cobble_gen.get()))
                    .save(consumer, Identifier.fromNamespaceAndPath(HavenCobbleGens.MOD_ID, "iron_cobble_gen"));

            AdvancementHolder goldCobbleGen = Advancement.Builder.advancement()
                    .parent(ironCobbleGen)
                    .display(ModBlocks.gold_cobble_gen.get(),
                            Component.translatable("advancements.havencobblegens.gold_cobble_gen.title"),
                            Component.translatable("advancements.havencobblegens.gold_cobble_gen.description"),
                            null,
                            AdvancementType.TASK, true, true, false)
                    .addCriterion("gold_cobble_gen", InventoryChangeTrigger.TriggerInstance.hasItems(ModBlocks.gold_cobble_gen.get()))
                    .save(consumer, Identifier.fromNamespaceAndPath(HavenCobbleGens.MOD_ID, "gold_cobble_gen"));

            AdvancementHolder diamondCobbleGen = Advancement.Builder.advancement()
                    .parent(goldCobbleGen)
                    .display(ModBlocks.diamond_cobble_gen.get(),
                            Component.translatable("advancements.havencobblegens.diamond_cobble_gen.title"),
                            Component.translatable("advancements.havencobblegens.diamond_cobble_gen.description"),
                            null,
                            AdvancementType.TASK, true, true, false)
                    .addCriterion("diamond_cobble_gen", InventoryChangeTrigger.TriggerInstance.hasItems(ModBlocks.diamond_cobble_gen.get()))
                    .save(consumer, Identifier.fromNamespaceAndPath(HavenCobbleGens.MOD_ID, "diamond_cobble_gen"));

            AdvancementHolder emeraldCobbleGen = Advancement.Builder.advancement()
                    .parent(diamondCobbleGen)
                    .display(ModBlocks.emerald_cobble_gen.get(),
                            Component.translatable("advancements.havencobblegens.emerald_cobble_gen.title"),
                            Component.translatable("advancements.havencobblegens.emerald_cobble_gen.description"),
                            null,
                            AdvancementType.TASK, true, true, false)
                    .addCriterion("emerald_cobble_gen", InventoryChangeTrigger.TriggerInstance.hasItems(ModBlocks.emerald_cobble_gen.get()))
                    .save(consumer, Identifier.fromNamespaceAndPath(HavenCobbleGens.MOD_ID, "emerald_cobble_gen"));

            AdvancementHolder netheriteCobbleGen = Advancement.Builder.advancement()
                    .parent(emeraldCobbleGen)
                    .display(ModBlocks.netherite_cobble_gen.get(),
                            Component.translatable("advancements.havencobblegens.netherite_cobble_gen.title"),
                            Component.translatable("advancements.havencobblegens.netherite_cobble_gen.description"),
                            null,
                            AdvancementType.TASK, true, true, false)
                    .addCriterion("netherite_cobble_gen", InventoryChangeTrigger.TriggerInstance.hasItems(ModBlocks.netherite_cobble_gen.get()))
                    .save(consumer, Identifier.fromNamespaceAndPath(HavenCobbleGens.MOD_ID, "netherite_cobble_gen"));

            AdvancementHolder creativeCobbleGen = Advancement.Builder.advancement()
                    .parent(netheriteCobbleGen)
                    .display(ModBlocks.creative_cobble_gen.get(),
                            Component.translatable("advancements.havencobblegens.creative_cobble_gen.title"),
                            Component.translatable("advancements.havencobblegens.creative_cobble_gen.description"),
                            null,
                            AdvancementType.TASK, true, true, false)
                    .addCriterion("creative_cobble_gen", InventoryChangeTrigger.TriggerInstance.hasItems(ModBlocks.creative_cobble_gen.get()))
                    .save(consumer, Identifier.fromNamespaceAndPath(HavenCobbleGens.MOD_ID, "creative_cobble_gen"));
        }
    }
}