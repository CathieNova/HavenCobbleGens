package net.cathienova.havencobblegens.compat.top;

import mcjty.theoneprobe.api.*;
import net.cathienova.havencobblegens.HavenCobbleGens;
import net.cathienova.havencobblegens.block.cobblegen.*;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;

import java.util.function.Function;

public class CobbleGenTOPProvider implements IProbeInfoProvider, Function<ITheOneProbe, Void> {

    @Override
    public Void apply(ITheOneProbe theOneProbe) {
        theOneProbe.registerProvider(this);
        return null;
    }

    @Override
    public ResourceLocation getID() {
        return ResourceLocation.fromNamespaceAndPath(HavenCobbleGens.MOD_ID, "cobblegen_top");
    }

    @Override
    public void addProbeInfo(ProbeMode mode, IProbeInfo probeInfo, Player player, Level level, BlockState blockState, IProbeHitData data) {
        BlockEntity blockEntity = level.getBlockEntity(data.getPos());
        if (blockEntity instanceof BaseCobbleGenEntity cobbleGen) {
            int cobbleAmount = cobbleGen.getInventory().getItem(0).getCount();
            int maxCapacity = cobbleGen.getMaxStackSize();
            String blockGenerating = BuiltInRegistries.BLOCK.getKey(cobbleGen.getBlockToGenerate()).toString();

            probeInfo.horizontal()
                    .text(Component.translatable("tooltip.cobblegen.amount", cobbleAmount, maxCapacity));

            if (cobbleAmount >= maxCapacity) {
                probeInfo.horizontal()
                        .text(Component.translatable("tooltip.cobblegen.full", maxCapacity).withStyle(style -> style.withColor(0xFF5555)));
            } else {
                probeInfo.horizontal()
                        .text(Component.translatable("tooltip.cobblegen.generating", blockGenerating).withStyle(style -> style.withColor(0x55FF55)));
            }
        }
    }
}
