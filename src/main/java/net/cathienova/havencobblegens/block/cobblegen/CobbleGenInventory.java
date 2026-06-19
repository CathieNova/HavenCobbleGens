package net.cathienova.havencobblegens.block.cobblegen;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;
import net.neoforged.neoforge.transfer.ResourceHandler;
import net.neoforged.neoforge.transfer.item.ItemResource;
import net.neoforged.neoforge.transfer.item.ItemStacksResourceHandler;
import net.neoforged.neoforge.transfer.transaction.Transaction;
import net.neoforged.neoforge.transfer.transaction.TransactionContext;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.IntSupplier;

public class CobbleGenInventory
{
    private final IntSupplier stackSize;
    private final ItemStacksResourceHandler inventory;

    public static CobbleGenInventory createForTileEntity(int size, IntSupplier stackSize, Runnable changed)
    {
        return new CobbleGenInventory(size, stackSize, changed);
    }

    private CobbleGenInventory(int size, IntSupplier stackSize, Runnable changed)
    {
        this.stackSize = stackSize;
        this.inventory = new ItemStacksResourceHandler(size)
        {
            @Override
            protected int getCapacity(int index, ItemResource resource)
            {
                return Math.min(stackSize.getAsInt(), super.getCapacity(index, resource));
            }

            @Override
            public int insert(int index, ItemResource resource, int amount, TransactionContext transaction)
            {
                return 0;
            }

            @Override
            protected void onContentsChanged(int index, ItemStack previousContents)
            {
                changed.run();
            }
        };
    }

    public void serialize(ValueOutput output)
    {
        inventory.serialize(output);
    }

    public void deserialize(ValueInput input)
    {
        inventory.deserialize(input);
    }

    public ResourceHandler<ItemResource> getHandler()
    {
        return inventory;
    }

    public int getContainerSize()
    {
        return inventory.size();
    }

    public ItemStack getItem(int index)
    {
        ItemResource resource = inventory.getResource(index);
        return resource.isEmpty() ? ItemStack.EMPTY : resource.toStack(inventory.getAmountAsInt(index));
    }

    public boolean isEmpty()
    {
        for (int i = 0; i < inventory.size(); i++)
        {
            if (!inventory.getResource(i).isEmpty())
            {
                return false;
            }
        }
        return true;
    }

    public ItemStack removeItem(int index, int count)
    {
        ItemResource resource = inventory.getResource(index);
        if (resource.isEmpty())
        {
            return ItemStack.EMPTY;
        }

        try (Transaction transaction = Transaction.openRoot())
        {
            int removed = inventory.extract(index, resource, count, transaction);
            if (removed > 0)
            {
                transaction.commit();
                return resource.toStack(removed);
            }
        }

        return ItemStack.EMPTY;
    }

    public void setItem(int index, ItemStack stack)
    {
        if (stack.isEmpty())
        {
            inventory.set(index, ItemResource.EMPTY, 0);
            return;
        }

        int amount = Math.min(stack.getCount(), Math.min(stack.getMaxStackSize(), stackSize.getAsInt()));
        inventory.set(index, ItemResource.of(stack), amount);
    }

    public int getMaxStackSize()
    {
        return stackSize.getAsInt();
    }

    public void clearContent()
    {
        for (int i = 0; i < inventory.size(); i++)
        {
            inventory.set(i, ItemResource.EMPTY, 0);
        }
    }

    public Block getBlockToGenerate(Level level, BlockPos pos)
    {
        List<? extends String> validBlocks = getValidBlocks(level, pos);
        if (validBlocks.isEmpty())
        {
            return Blocks.COBBLESTONE;
        }

        for (Direction direction : Direction.values())
        {
            Block blockAtSide = level.getBlockState(pos.relative(direction)).getBlock();
            String blockAtSideName = BuiltInRegistries.BLOCK.getKey(blockAtSide).toString();

            for (String entry : validBlocks)
            {
                String[] parts = entry.split(";", 2);
                if (parts.length != 2 || !blockAtSideName.equals(parts[0]))
                {
                    continue;
                }

                String[] outputBlocks = parts[1].split(",");
                String outputBlock = outputBlocks[ThreadLocalRandom.current().nextInt(outputBlocks.length)];
                return BuiltInRegistries.BLOCK.getValue(Identifier.parse(outputBlock));
            }
        }

        return Blocks.COBBLESTONE;
    }

    public List<? extends String> getValidBlocks(Level level, BlockPos pos)
    {
        BlockEntity entity = level.getBlockEntity(pos);
        if (entity instanceof CobbleGenEntity cobbleGen)
        {
            return cobbleGen.getValidBlocks();
        }
        return List.of();
    }
}