package net.cathienova.havencobblegens.compat;

import net.cathienova.havencobblegens.block.cobblegen.CobbleGenBlock;
import net.cathienova.havencobblegens.block.cobblegen.CobbleGenEntity;
import net.cathienova.havencobblegens.compat.jade.CobbleGenComponentProvider;
import net.cathienova.havencobblegens.compat.jade.CobbleGenDataProvider;
import snownee.jade.api.IWailaClientRegistration;
import snownee.jade.api.IWailaCommonRegistration;
import snownee.jade.api.IWailaPlugin;
import snownee.jade.api.WailaPlugin;

@WailaPlugin
public class JadePlugin implements IWailaPlugin
{
    @Override
    public void register(IWailaCommonRegistration registration)
    {
        registration.registerBlockDataProvider(CobbleGenDataProvider.INSTANCE, CobbleGenEntity.class);
    }

    @Override
    public void registerClient(IWailaClientRegistration registration)
    {
        registration.registerBlockComponent(CobbleGenComponentProvider.INSTANCE, CobbleGenBlock.class);
    }
}