package net.cathienova.havencobblegens.block.cobblegen;

import net.cathienova.havencobblegens.config.HavenConfig;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.items.ItemStackHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
                        Block generateBlock = BuiltInRegistries.BLOCK.get(ResourceLocation.parse(randomBlockToGenerate));
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

    public List<? extends String> getValidBlocks(Level level, BlockPos pos)
    {
        BlockEntity entity = level.getBlockEntity(pos);

        if (entity instanceof WoodenCobbleGenEntity)
            return HavenConfig.wooden_cobble_gen_valid_blocks;
        else if (entity instanceof StoneCobbleGenEntity)
            return HavenConfig.stone_cobble_gen_valid_blocks;
        else if (entity instanceof IronCobbleGenEntity)
            return HavenConfig.iron_cobble_gen_valid_blocks;
        else if (entity instanceof GoldCobbleGenEntity)
            return HavenConfig.gold_cobble_gen_valid_blocks;
        else if (entity instanceof DiamondCobbleGenEntity)
            return HavenConfig.diamond_cobble_gen_valid_blocks;
        else if (entity instanceof EmeraldCobbleGenEntity)
            return HavenConfig.emerald_cobble_gen_valid_blocks;
        else if (entity instanceof NetheriteCobbleGenEntity)
            return HavenConfig.netherite_cobble_gen_valid_blocks;
        else if (entity instanceof CreativeCobbleGenEntity)
            return HavenConfig.creative_cobble_gen_valid_blocks;
        else
            return new ArrayList<>();
    }
}
