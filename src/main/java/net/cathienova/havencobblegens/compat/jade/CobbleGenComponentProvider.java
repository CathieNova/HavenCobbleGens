package net.cathienova.havencobblegens.compat.jade;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import snownee.jade.api.BlockAccessor;
import snownee.jade.api.IBlockComponentProvider;
import snownee.jade.api.ITooltip;
import snownee.jade.api.config.IPluginConfig;

public enum CobbleGenComponentProvider implements IBlockComponentProvider {
    INSTANCE;

    @Override
    public void appendTooltip(ITooltip tooltip, BlockAccessor accessor, IPluginConfig config) {
        if (accessor.getServerData().contains("CobbleAmount")) {
            int cobbleAmount = accessor.getServerData().getInt("CobbleAmount");
            int maxCapacity = accessor.getServerData().getInt("MaxCapacity");
            String blockGenerating = accessor.getServerData().getString("BlockGenerating");

            tooltip.add(Component.translatable("tooltip.cobblegen.amount", cobbleAmount, maxCapacity));
            if (cobbleAmount >= maxCapacity) {
                tooltip.add(Component.translatable("tooltip.cobblegen.full", maxCapacity).withStyle(ChatFormatting.RED));
            } else {
                tooltip.add(Component.translatable("tooltip.cobblegen.generating", blockGenerating).withStyle(ChatFormatting.GREEN));
            }
        }
    }

    @Override
    public ResourceLocation getUid() {
        return ResourceLocation.fromNamespaceAndPath("havencobblegens", "cobblegen_data");
    }
}
