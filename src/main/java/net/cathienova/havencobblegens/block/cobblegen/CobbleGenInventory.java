package net.cathienova.havencobblegens.block.cobblegen;

import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.items.ItemStackHandler;

public class CobbleGenInventory {
    private final ItemStackHandler inventory;
    private final int stackSize;

    public static CobbleGenInventory createForTileEntity(int size, int stackSize) {
        return new CobbleGenInventory(size, stackSize);
    }

    private CobbleGenInventory(int size, int stackSize) {
        this.inventory = new ItemStackHandler(size) {
            @Override
            public int getSlotLimit(int slot) {
                return stackSize;
            }

            @Override
            public void setStackInSlot(int slot, ItemStack stack) {
                if (stack.getCount() > stack.getMaxStackSize()) {
                    stack.setCount(stack.getMaxStackSize());
                }
                super.setStackInSlot(slot, stack);
            }

            @Override
            public ItemStack insertItem(int slot, ItemStack stack, boolean simulate) {
                if (stack.getCount() > stack.getMaxStackSize()) {
                    stack.setCount(stack.getMaxStackSize());
                }
                return super.insertItem(slot, stack, simulate);
            }
        };
        this.stackSize = stackSize;
    }

    public CompoundTag serializeNBT(HolderLookup.Provider provider) {
        return inventory.serializeNBT(provider);
    }

    public void deserializeNBT(HolderLookup.Provider provider, CompoundTag nbt) {
        inventory.deserializeNBT(provider, nbt);
    }

    public ItemStackHandler getHandler() {
        return this.inventory;
    }

    public boolean canPlaceItem(int index, ItemStack stack) {
        return inventory.isItemValid(index, stack);
    }

    public int getContainerSize() {
        return inventory.getSlots();
    }

    public ItemStack getItem(int index) {
        return inventory.getStackInSlot(index);
    }

    public boolean isEmpty() {
        for (int i = 0; i < inventory.getSlots(); ++i) {
            if (!inventory.getStackInSlot(i).isEmpty()) {
                return false;
            }
        }
        return true;
    }

    public ItemStack removeItem(int index, int count) {
        return inventory.extractItem(index, count, false);
    }

    public void setItem(int index, ItemStack stack) {
        inventory.setStackInSlot(index, stack);
    }

    public ItemStack increaseStackSize(int index, ItemStack itemStackToInsert) {
        ItemStack leftoverItemStack = inventory.insertItem(index, itemStackToInsert, false);
        return leftoverItemStack;
    }

    public boolean doesItemStackFit(int index, ItemStack itemStackToInsert) {
        ItemStack leftoverItemStack = inventory.insertItem(index, itemStackToInsert, true);
        return leftoverItemStack.isEmpty();
    }

    public void dropInventory(Level world, BlockPos pos) {
        for (int i = 0; i < this.getContainerSize(); ++i) {
            ItemStack stack = removeItem(i, this.getMaxStackSize());
            if (!stack.isEmpty()) {
                world.addFreshEntity(new net.minecraft.world.entity.item.ItemEntity(world, pos.getX(), pos.getY() + 1, pos.getZ(), stack));
            }
        }
    }

    public int getMaxStackSize() {
        return this.stackSize;
    }

    public void clearContent() {
        for (int i = 0; i < inventory.getSlots(); ++i) {
            inventory.setStackInSlot(i, ItemStack.EMPTY);
        }
    }
}
