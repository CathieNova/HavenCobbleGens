package net.cathienova.havencobblegens.block.cobblegen;

import net.cathienova.havencobblegens.config.HavenConfig;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.items.ItemStackHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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

    public Block getBlockToGenerate(Level level, BlockPos pos) {
        List<? extends String> validBlocks = getValidBlocks(level, pos);
        if (validBlocks.isEmpty()) {
            return Blocks.COBBLESTONE;
        }

        Random random = new Random();

        // Loop through all six directions (up, down, north, south, east, west)
        for (Direction direction : Direction.values()) {
            assert level != null;
            Block blockAtSide = level.getBlockState(pos.relative(direction)).getBlock();
            String blockAtSideName = BuiltInRegistries.BLOCK.getKey(blockAtSide).toString();

            // Iterate over each config entry (formatted as blockToCheck;blockToGenerate1,blockToGenerate2,...)
            for (String entry : validBlocks) {
                String[] parts = entry.split(";");
                if (parts.length == 2) {
                    String blockToCheck = parts[0];  // The block to check on the side
                    String[] blockToGenerateList = parts[1].split(",");  // Blocks to randomly choose from

                    // If the blockAtSide matches blockToCheck, randomly select a block from blockToGenerateList
                    if (blockAtSideName.equals(blockToCheck)) {
                        String randomBlockToGenerate = blockToGenerateList[random.nextInt(blockToGenerateList.length)];
                        Block generateBlock = BuiltInRegistries.BLOCK.get(new ResourceLocation(randomBlockToGenerate));
                        if (generateBlock != null) {
                            return generateBlock;
                        }
                    }
                }
            }
        }
        // Default to cobblestone if no match
        return Blocks.COBBLESTONE;
    }

    public Item getItemToGenerate(Level level, BlockPos pos)
    {
        List<? extends String> validBlocks = getValidBlocks(level, pos);
        if (validBlocks.isEmpty()) {
            return Items.COBBLESTONE;
        }

        Random random = new Random();

        // Loop through all six directions (up, down, north, south, east, west)
        for (Direction direction : Direction.values()) {
            assert level != null;
            Block blockAtSide = level.getBlockState(pos.relative(direction)).getBlock();
            String blockAtSideName = BuiltInRegistries.BLOCK.getKey(blockAtSide).toString();

            // Iterate over each config entry (formatted as blockToCheck;itemToGenerate1,itemToGenerate2,...)
            for (String entry : validBlocks) {
                String[] parts = entry.split(";");
                if (parts.length == 2) {
                    String blockToCheck = parts[0];  // The block to check on the side
                    String[] itemToGenerateList = parts[1].split(",");  // Items to randomly choose from

                    // If the blockAtSide matches blockToCheck, randomly select an item from itemToGenerateList
                    if (blockAtSideName.equals(blockToCheck)) {
                        String randomItemToGenerate = itemToGenerateList[random.nextInt(itemToGenerateList.length)];
                        Item generateItem = BuiltInRegistries.ITEM.get(new ResourceLocation(randomItemToGenerate));
                        if (generateItem != null) {
                            return generateItem;
                        }
                    }
                }
            }
        }
        // Default to cobblestone if no match
        return Items.COBBLESTONE;
    }

    public List<? extends String> getValidBlocks(Level level, BlockPos pos)
    {
        BlockEntity entity = level.getBlockEntity(pos);

        if (entity instanceof WoodenCobbleGenEntity)
            return HavenConfig.wooden_cobble_genValidBlocks;
        else if (entity instanceof StoneCobbleGenEntity)
            return HavenConfig.stone_cobble_genValidBlocks;
        else if (entity instanceof IronCobbleGenEntity)
            return HavenConfig.iron_cobble_genValidBlocks;
        else if (entity instanceof GoldCobbleGenEntity)
            return HavenConfig.gold_cobble_genValidBlocks;
        else if (entity instanceof DiamondCobbleGenEntity)
            return HavenConfig.diamond_cobble_genValidBlocks;
        else if (entity instanceof EmeraldCobbleGenEntity)
            return HavenConfig.emerald_cobble_genValidBlocks;
        else if (entity instanceof NetheriteCobbleGenEntity)
            return HavenConfig.netherite_cobble_genValidBlocks;
        else if (entity instanceof CreativeCobbleGenEntity)
            return HavenConfig.creative_cobble_genValidBlocks;
        else
            return new ArrayList<>();
    }
}