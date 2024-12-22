package net.cathienova.havencobblegens.compat.jade;

import net.cathienova.havencobblegens.block.cobblegen.*;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import snownee.jade.api.BlockAccessor;
import snownee.jade.api.IServerDataProvider;

public enum CobbleGenDataProvider implements IServerDataProvider<BlockAccessor> {
    INSTANCE;

    @Override
    public void appendServerData(CompoundTag data, BlockAccessor accessor) {
        if (accessor.getBlockEntity() instanceof WoodenCobbleGenEntity cobbleGenEntity) {
            data.putInt("CobbleAmount", cobbleGenEntity.getInventory().getItem(0).getCount());
            data.putInt("MaxCapacity", cobbleGenEntity.getMaxStackSize());
            data.putString("BlockGenerating", BuiltInRegistries.BLOCK.getKey(cobbleGenEntity.getBlockToGenerate()).toString());
        } else if (accessor.getBlockEntity() instanceof StoneCobbleGenEntity cobbleGenEntity) {
            data.putInt("CobbleAmount", cobbleGenEntity.getInventory().getItem(0).getCount());
            data.putInt("MaxCapacity", cobbleGenEntity.getMaxStackSize());
            data.putString("BlockGenerating", BuiltInRegistries.BLOCK.getKey(cobbleGenEntity.getBlockToGenerate()).toString());
        } else if (accessor.getBlockEntity() instanceof IronCobbleGenEntity cobbleGenEntity) {
            data.putInt("CobbleAmount", cobbleGenEntity.getInventory().getItem(0).getCount());
            data.putInt("MaxCapacity", cobbleGenEntity.getMaxStackSize());
            data.putString("BlockGenerating", BuiltInRegistries.BLOCK.getKey(cobbleGenEntity.getBlockToGenerate()).toString());
        } else if (accessor.getBlockEntity() instanceof GoldCobbleGenEntity cobbleGenEntity) {
            data.putInt("CobbleAmount", cobbleGenEntity.getInventory().getItem(0).getCount());
            data.putInt("MaxCapacity", cobbleGenEntity.getMaxStackSize());
            data.putString("BlockGenerating", BuiltInRegistries.BLOCK.getKey(cobbleGenEntity.getBlockToGenerate()).toString());
        } else if (accessor.getBlockEntity() instanceof DiamondCobbleGenEntity cobbleGenEntity) {
            data.putInt("CobbleAmount", cobbleGenEntity.getInventory().getItem(0).getCount());
            data.putInt("MaxCapacity", cobbleGenEntity.getMaxStackSize());
            data.putString("BlockGenerating", BuiltInRegistries.BLOCK.getKey(cobbleGenEntity.getBlockToGenerate()).toString());
        } else if (accessor.getBlockEntity() instanceof EmeraldCobbleGenEntity cobbleGenEntity) {
            data.putInt("CobbleAmount", cobbleGenEntity.getInventory().getItem(0).getCount());
            data.putInt("MaxCapacity", cobbleGenEntity.getMaxStackSize());
            data.putString("BlockGenerating", BuiltInRegistries.BLOCK.getKey(cobbleGenEntity.getBlockToGenerate()).toString());
        } else if (accessor.getBlockEntity() instanceof NetheriteCobbleGenEntity cobbleGenEntity) {
            data.putInt("CobbleAmount", cobbleGenEntity.getInventory().getItem(0).getCount());
            data.putInt("MaxCapacity", cobbleGenEntity.getMaxStackSize());
            data.putString("BlockGenerating", BuiltInRegistries.BLOCK.getKey(cobbleGenEntity.getBlockToGenerate()).toString());
        } else if (accessor.getBlockEntity() instanceof CreativeCobbleGenEntity cobbleGenEntity) {
            data.putInt("CobbleAmount", cobbleGenEntity.getInventory().getItem(0).getCount());
            data.putInt("MaxCapacity", cobbleGenEntity.getMaxStackSize());
            data.putString("BlockGenerating", BuiltInRegistries.BLOCK.getKey(cobbleGenEntity.getBlockToGenerate()).toString());
        }
    }

    @Override
    public ResourceLocation getUid() {
        return ResourceLocation.fromNamespaceAndPath("havencobblegens", "cobblegen_data");
    }
}
