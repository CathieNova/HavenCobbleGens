package net.cathienova.havencobblegens.block.cobblegen;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraftforge.items.ItemStackHandler;

public class CobbleGenInventory
{
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
        };
        this.stackSize = stackSize;
    }

    public CompoundTag serializeNBT() {
        CompoundTag tag = new CompoundTag();
        CompoundTag itemsTag = inventory.serializeNBT();
        tag.put("Items", itemsTag);
        tag.putInt("TotalCount", inventory.getStackInSlot(0).getCount());
        return tag;
    }

    public void deserializeNBT(CompoundTag nbt) {
        inventory.deserializeNBT(nbt.getCompound("Items"));
        int totalCount = nbt.getInt("TotalCount");
        if (totalCount > 0) {
            ItemStack stack = inventory.getStackInSlot(0);
            stack.setCount(totalCount);
            inventory.setStackInSlot(0, stack);
        }
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
            ItemStack stack = this.getItem(i);
            if (!stack.isEmpty()) {
                while (!stack.isEmpty()) {
                    int dropAmount = Math.min(stack.getCount(), 64);
                    ItemStack dropStack = stack.split(dropAmount);
                    world.addFreshEntity(new net.minecraft.world.entity.item.ItemEntity(world, pos.getX(), pos.getY() + 1, pos.getZ(), dropStack));
                }
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