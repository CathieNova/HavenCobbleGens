package net.cathienova.havencobblegens.item.cobblegen;

import net.cathienova.havencobblegens.block.ModBlocks;
import net.cathienova.havencobblegens.block.cobblegen.CobbleGenEntity;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;

public class CobbleGenUpgradeIron extends Item
{
    public CobbleGenUpgradeIron(Properties properties)
    {
        super(properties);
    }

    @Override
    public InteractionResult useOn(UseOnContext context)
    {
        if (context.getLevel().isClientSide())
        {
            return InteractionResult.PASS;
        }

        if (context.getPlayer() == null || !context.getPlayer().isCrouching())
        {
            return InteractionResult.PASS;
        }

        if (context.getLevel().getBlockState(context.getClickedPos()).getBlock() == ModBlocks.iron_cobble_gen.get()
                && context.getLevel().getBlockEntity(context.getClickedPos()) instanceof CobbleGenEntity cobbleGen
                && cobbleGen.upgradeTo(ModBlocks.gold_cobble_gen.get()))
        {
            context.getItemInHand().shrink(1);
            return InteractionResult.SUCCESS;
        }

        return InteractionResult.PASS;
    }
}