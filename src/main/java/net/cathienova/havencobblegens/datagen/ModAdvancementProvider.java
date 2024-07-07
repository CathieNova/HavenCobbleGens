package net.cathienova.havencobblegens.datagen;

import net.cathienova.havencobblegens.HavenCobbleGens;
import net.cathienova.havencobblegens.block.ModBlocks;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.FrameType;
import net.minecraft.advancements.critereon.ImpossibleTrigger;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.data.ForgeAdvancementProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

public class ModAdvancementProvider extends ForgeAdvancementProvider {

    public ModAdvancementProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries, ExistingFileHelper fileHelper) {
        super(output, registries, fileHelper, List.of(new ModAdvancements()));
    }

    public static class ModAdvancements implements AdvancementGenerator {
        @Override
        public void generate(HolderLookup.Provider registries, Consumer<Advancement> consumer, ExistingFileHelper fileHelper) {
            Advancement root = Advancement.Builder.advancement()
                    .display(ModBlocks.creative_cobble_gen.get(),
                            Component.translatable("advancements.havencobblegens.root.title"),
                            Component.translatable("advancements.havencobblegens.root.description"),
                            new ResourceLocation("textures/block/stone.png"),
                            FrameType.TASK, true, true, false)
                    .addCriterion("tick", new ImpossibleTrigger.TriggerInstance())
                    .save(consumer, new ResourceLocation(HavenCobbleGens.MOD_ID, "root").toString());

            Advancement woodenCobbleGen = Advancement.Builder.advancement()
                    .parent(root)
                    .display(ModBlocks.wooden_cobble_gen.get(),
                            Component.translatable("advancements.havencobblegens.wooden_cobble_gen.title"),
                            Component.translatable("advancements.havencobblegens.wooden_cobble_gen.description"),
                            null,
                            FrameType.TASK, true, true, false)
                    .addCriterion("wooden_cobble_gen", InventoryChangeTrigger.TriggerInstance.hasItems(
                            ItemPredicate.Builder.item().of(ModBlocks.wooden_cobble_gen.get()).build()))
                    .save(consumer, new ResourceLocation(HavenCobbleGens.MOD_ID, "wooden_cobble_gen").toString());

            Advancement woodenCobbleGen2 = Advancement.Builder.advancement()
                    .parent(woodenCobbleGen)
                    .display(ModBlocks.stone_cobble_gen.get(),
                            Component.translatable("advancements.havencobblegens.stone_cobble_gen.title"),
                            Component.translatable("advancements.havencobblegens.stone_cobble_gen.description"),
                            null,
                            FrameType.TASK, true, true, false)
                    .addCriterion("stone_cobble_gen", InventoryChangeTrigger.TriggerInstance.hasItems(
                            ItemPredicate.Builder.item().of(ModBlocks.stone_cobble_gen.get()).build()))
                    .save(consumer, new ResourceLocation(HavenCobbleGens.MOD_ID, "stone_cobble_gen").toString());

            Advancement woodenCobbleGen3 = Advancement.Builder.advancement()
                    .parent(woodenCobbleGen2)
                    .display(ModBlocks.iron_cobble_gen.get(),
                            Component.translatable("advancements.havencobblegens.iron_cobble_gen.title"),
                            Component.translatable("advancements.havencobblegens.iron_cobble_gen.description"),
                            null,
                            FrameType.TASK, true, true, false)
                    .addCriterion("iron_cobble_gen", InventoryChangeTrigger.TriggerInstance.hasItems(
                            ItemPredicate.Builder.item().of(ModBlocks.iron_cobble_gen.get()).build()))
                    .save(consumer, new ResourceLocation(HavenCobbleGens.MOD_ID, "iron_cobble_gen").toString());

            Advancement woodenCobbleGen4 = Advancement.Builder.advancement()
                    .parent(woodenCobbleGen3)
                    .display(ModBlocks.gold_cobble_gen.get(),
                            Component.translatable("advancements.havencobblegens.gold_cobble_gen.title"),
                            Component.translatable("advancements.havencobblegens.gold_cobble_gen.description"),
                            null,
                            FrameType.TASK, true, true, false)
                    .addCriterion("gold_cobble_gen", InventoryChangeTrigger.TriggerInstance.hasItems(
                            ItemPredicate.Builder.item().of(ModBlocks.gold_cobble_gen.get()).build()))
                    .save(consumer, new ResourceLocation(HavenCobbleGens.MOD_ID, "gold_cobble_gen").toString());

            Advancement woodenCobbleGen5 = Advancement.Builder.advancement()
                    .parent(woodenCobbleGen4)
                    .display(ModBlocks.diamond_cobble_gen.get(),
                            Component.translatable("advancements.havencobblegens.diamond_cobble_gen.title"),
                            Component.translatable("advancements.havencobblegens.diamond_cobble_gen.description"),
                            null,
                            FrameType.TASK, true, true, false)
                    .addCriterion("diamond_cobble_gen", InventoryChangeTrigger.TriggerInstance.hasItems(
                            ItemPredicate.Builder.item().of(ModBlocks.diamond_cobble_gen.get()).build()))
                    .save(consumer, new ResourceLocation(HavenCobbleGens.MOD_ID, "diamond_cobble_gen").toString());

            Advancement woodenCobbleGen6 = Advancement.Builder.advancement()
                    .parent(woodenCobbleGen5)
                    .display(ModBlocks.emerald_cobble_gen.get(),
                            Component.translatable("advancements.havencobblegens.emerald_cobble_gen.title"),
                            Component.translatable("advancements.havencobblegens.emerald_cobble_gen.description"),
                            null,
                            FrameType.TASK, true, true, false)
                    .addCriterion("emerald_cobble_gen", InventoryChangeTrigger.TriggerInstance.hasItems(
                            ItemPredicate.Builder.item().of(ModBlocks.emerald_cobble_gen.get()).build()))
                    .save(consumer, new ResourceLocation(HavenCobbleGens.MOD_ID, "emerald_cobble_gen").toString());

            Advancement woodenCobbleGen7 = Advancement.Builder.advancement()
                    .parent(woodenCobbleGen6)
                    .display(ModBlocks.netherite_cobble_gen.get(),
                            Component.translatable("advancements.havencobblegens.netherite_cobble_gen.title"),
                            Component.translatable("advancements.havencobblegens.netherite_cobble_gen.description"),
                            null,
                            FrameType.TASK, true, true, false)
                    .addCriterion("netherite_cobble_gen", InventoryChangeTrigger.TriggerInstance.hasItems(
                            ItemPredicate.Builder.item().of(ModBlocks.netherite_cobble_gen.get()).build()))
                    .save(consumer, new ResourceLocation(HavenCobbleGens.MOD_ID, "netherite_cobble_gen").toString());

            Advancement woodenCobbleGen8 = Advancement.Builder.advancement()
                    .parent(woodenCobbleGen7)
                    .display(ModBlocks.creative_cobble_gen.get(),
                            Component.translatable("advancements.havencobblegens.creative_cobble_gen.title"),
                            Component.translatable("advancements.havencobblegens.creative_cobble_gen.description"),
                            null,
                            FrameType.TASK, true, true, false)
                    .addCriterion("creative_cobble_gen", InventoryChangeTrigger.TriggerInstance.hasItems(
                            ItemPredicate.Builder.item().of(ModBlocks.creative_cobble_gen.get()).build()))
                    .save(consumer, new ResourceLocation(HavenCobbleGens.MOD_ID, "creative_cobble_gen").toString());
        }
    }
}
