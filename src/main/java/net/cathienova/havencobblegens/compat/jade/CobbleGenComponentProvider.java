package net.cathienova.havencobblegens.compat.jade;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import snownee.jade.api.BlockAccessor;
import snownee.jade.api.IBlockComponentProvider;
import snownee.jade.api.ITooltip;
import snownee.jade.api.config.IPluginConfig;

public enum CobbleGenComponentProvider implements IBlockComponentProvider
{
    INSTANCE;

    @Override
    public void appendTooltip(ITooltip tooltip, BlockAccessor accessor, IPluginConfig config)
    {
        if (accessor.getServerData().contains("CobbleAmount"))
        {
            int cobbleAmount = accessor.getServerData().getIntOr("CobbleAmount", 0);
            int maxCapacity = accessor.getServerData().getIntOr("MaxCapacity", 0);
            String blockGenerating = accessor.getServerData().getStringOr("BlockGenerating", "minecraft:cobblestone");

            tooltip.add(Component.translatable("tooltip.cobblegen.amount", cobbleAmount, maxCapacity));
            if (cobbleAmount >= maxCapacity)
            {
                tooltip.add(Component.translatable("tooltip.cobblegen.full", maxCapacity).withStyle(ChatFormatting.RED));
            }
            else
            {
                tooltip.add(Component.translatable("tooltip.cobblegen.generating", blockGenerating).withStyle(ChatFormatting.GREEN));
            }
        }
    }

    @Override
    public Identifier getUid()
    {
        return Identifier.fromNamespaceAndPath("havencobblegens", "cobblegen_data");
    }
}