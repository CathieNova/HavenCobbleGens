package net.cathienova.havencobblegens.compat.jade;

import net.cathienova.havencobblegens.block.cobblegen.CobbleGenEntity;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.Identifier;
import snownee.jade.api.BlockAccessor;
import snownee.jade.api.IServerDataProvider;

public enum CobbleGenDataProvider implements IServerDataProvider<BlockAccessor>
{
    INSTANCE;

    @Override
    public void appendServerData(CompoundTag data, BlockAccessor accessor)
    {
        if (accessor.getBlockEntity() instanceof CobbleGenEntity cobbleGen)
        {
            data.putInt("CobbleAmount", cobbleGen.getInventory().getItem(0).getCount());
            data.putInt("MaxCapacity", cobbleGen.getMaxStackSize());
            data.putString("BlockGenerating", BuiltInRegistries.BLOCK.getKey(cobbleGen.getBlockToGenerate()).toString());
        }
    }

    @Override
    public Identifier getUid()
    {
        return Identifier.fromNamespaceAndPath("havencobblegens", "cobblegen_data");
    }
}