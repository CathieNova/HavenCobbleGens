package net.cathienova.havencobblegens.item.cobblegen;

import net.cathienova.havencobblegens.HavenCobbleGens;
import net.cathienova.havencobblegens.block.cobblegen.CobbleGenBlock;
import net.cathienova.havencobblegens.item.ModItems;
import net.minecraft.ChatFormatting;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.component.CustomData;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.player.ItemTooltipEvent;

@EventBusSubscriber(modid = HavenCobbleGens.MOD_ID)
public class CobbleGenTooltips
{
    @SubscribeEvent
    public static void onItemTooltip(ItemTooltipEvent event)
    {
        if (event.getItemStack().getItem() instanceof BlockItem blockItem && blockItem.getBlock() instanceof CobbleGenBlock cobbleGen)
        {
            int output = cobbleGen.getCobbleGenOutput();
            int speed = cobbleGen.getCobbleGenSpeed();
            event.getToolTip().add(Component.translatable("tooltip.cobblegen_1", output));
            event.getToolTip().add(Component.translatable("tooltip.cobblegen_2", String.format("%.2f", 20.0F / speed)));
            addStoredContentsTooltip(event.getItemStack(), event);
            return;
        }

        String tooltipKey = getUpgradeTooltipKey(event.getItemStack().getItem());
        if (tooltipKey != null)
        {
            event.getToolTip().add(Component.translatable(tooltipKey).withStyle(ChatFormatting.GOLD));
        }
    }

    private static void addStoredContentsTooltip(ItemStack stack, ItemTooltipEvent event)
    {
        CustomData customData = stack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY);
        CompoundTag tag = customData.copyTag();

        tag.getCompound("HavenCobbleGenContents").ifPresent(storedContents ->
        {
            String itemId = storedContents.getStringOr("item", "");
            int count = storedContents.getIntOr("count", 0);
            if (itemId.isEmpty() || count <= 0)
            {
                return;
            }

            Item item = BuiltInRegistries.ITEM.getValue(Identifier.parse(itemId));
            if (item == Items.AIR)
            {
                return;
            }

            event.getToolTip().add(Component.translatable("tooltip.cobblegen.contents", count, new ItemStack(item).getHoverName()));
        });
    }

    private static String getUpgradeTooltipKey(Item item)
    {
        if (item == ModItems.cobble_gen_upgrade_wooden.get())
        {
            return "item.havencobblegens.cobble_gen_upgrade_wooden.tooltip";
        }
        if (item == ModItems.cobble_gen_upgrade_stone.get())
        {
            return "item.havencobblegens.cobble_gen_upgrade_stone.tooltip";
        }
        if (item == ModItems.cobble_gen_upgrade_copper.get())
        {
            return "item.havencobblegens.cobble_gen_upgrade_copper.tooltip";
        }
        if (item == ModItems.cobble_gen_upgrade_iron.get())
        {
            return "item.havencobblegens.cobble_gen_upgrade_iron.tooltip";
        }
        if (item == ModItems.cobble_gen_upgrade_gold.get())
        {
            return "item.havencobblegens.cobble_gen_upgrade_gold.tooltip";
        }
        if (item == ModItems.cobble_gen_upgrade_diamond.get())
        {
            return "item.havencobblegens.cobble_gen_upgrade_diamond.tooltip";
        }
        if (item == ModItems.cobble_gen_upgrade_emerald.get())
        {
            return "item.havencobblegens.cobble_gen_upgrade_emerald.tooltip";
        }
        if (item == ModItems.cobble_gen_upgrade_netherite.get())
        {
            return "item.havencobblegens.cobble_gen_upgrade_netherite.tooltip";
        }
        return null;
    }
}