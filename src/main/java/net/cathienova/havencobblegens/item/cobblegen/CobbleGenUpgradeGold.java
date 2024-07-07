package net.cathienova.havencobblegens.item.cobblegen;

import net.cathienova.havencobblegens.block.ModBlocks;
import net.cathienova.havencobblegens.block.cobblegen.*;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Objects;

public class CobbleGenUpgradeGold extends Item
{
    public CobbleGenUpgradeGold(Properties pProperties)
    {
        super(pProperties);
    }

    @Override
    public InteractionResult useOn(UseOnContext context)
    {
        if (context.getLevel().isClientSide)
            return InteractionResult.PASS;
        if (!Objects.requireNonNull(context.getPlayer()).isCrouching())
            return InteractionResult.PASS;

        if (context.getLevel().getBlockState(context.getClickedPos()).getBlock() instanceof GoldCobbleGen)
        {
            context.getLevel().setBlock(context.getClickedPos(), ModBlocks.diamond_cobble_gen.get().defaultBlockState(), 3);

            context.getItemInHand().shrink(1);
            return InteractionResult.SUCCESS;
        }

        return InteractionResult.PASS;
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced)
    {
        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);

        pTooltipComponents.add(Component.translatable("item.havenksh.cobble_gen_upgrade_gold.tooltip").withStyle(net.minecraft.ChatFormatting.GOLD));
    }
}
