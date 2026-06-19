package net.cathienova.havencobblegens.block.cobblegen;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.util.ProblemReporter;
import net.minecraft.world.level.storage.TagValueOutput;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.transfer.ResourceHandler;
import net.neoforged.neoforge.transfer.item.ItemResource;
import net.neoforged.neoforge.transfer.transaction.Transaction;

import java.util.List;

public class CobbleGenEntity extends BlockEntity
{
    private int cycle = 0;
    private final CobbleGenInventory cobbleGenContents;

    public CobbleGenEntity(BlockPos pos, BlockState state)
    {
        this(getCobbleGenBlock(state).getBlockEntityType(), pos, state);
    }

    public CobbleGenEntity(BlockEntityType<?> type, BlockPos pos, BlockState state)
    {
        super(type, pos, state);
        cobbleGenContents = CobbleGenInventory.createForTileEntity(1, this::getMaxStackSize, this::setChanged);
    }

    private static CobbleGenBlock getCobbleGenBlock(BlockState state)
    {
        if (state.getBlock() instanceof CobbleGenBlock cobbleGenBlock)
        {
            return cobbleGenBlock;
        }
        throw new IllegalStateException("CobbleGenEntity requires a CobbleGenBlock");
    }

    private CobbleGenBlock getCobbleGenBlock()
    {
        return getCobbleGenBlock(getBlockState());
    }

    @Override
    protected void loadAdditional(ValueInput input)
    {
        super.loadAdditional(input);
        input.child("inventory").ifPresent(cobbleGenContents::deserialize);
        cycle = input.getIntOr("cycle", 0);
    }

    @Override
    protected void saveAdditional(ValueOutput output)
    {
        super.saveAdditional(output);
        cobbleGenContents.serialize(output.child("inventory"));
        output.putInt("cycle", cycle);
    }

    public void tick()
    {
        if (level == null || level.isClientSide())
        {
            return;
        }

        if (cycle++ >= getCobbleGenBlock().getCobbleGenSpeed())
        {
            cycle = 0;
            generateCobblestone();
        }

        pushIntoContainerAbove();
    }

    private void generateCobblestone()
    {
        if (level == null)
        {
            return;
        }

        Block blockToGenerate = cobbleGenContents.getBlockToGenerate(level, worldPosition);
        ItemStack stack = cobbleGenContents.getItem(0);
        int capacity = getMaxStackSize();
        int amount = Math.min(getCobbleGenBlock().getCobbleGenMultiplier(), capacity - stack.getCount());

        if (amount > 0)
        {
            if (stack.isEmpty())
            {
                cobbleGenContents.setItem(0, new ItemStack(blockToGenerate, amount));
            }
            else if (stack.getItem() == blockToGenerate.asItem())
            {
                stack.grow(amount);
                cobbleGenContents.setItem(0, stack);
            }
        }
    }

    private void pushIntoContainerAbove()
    {
        if (level == null)
        {
            return;
        }

        ResourceHandler<ItemResource> target = level.getCapability(Capabilities.Item.BLOCK, worldPosition.above(), Direction.DOWN);
        if (target == null)
        {
            return;
        }

        ResourceHandler<ItemResource> source = cobbleGenContents.getHandler();
        ItemResource resource = source.getResource(0);
        int amount = source.getAmountAsInt(0);
        if (resource.isEmpty() || amount <= 0)
        {
            return;
        }

        try (Transaction transaction = Transaction.openRoot())
        {
            int inserted = target.insert(resource, amount, transaction);
            if (inserted <= 0)
            {
                return;
            }

            int extracted = source.extract(0, resource, inserted, transaction);
            if (extracted == inserted)
            {
                transaction.commit();
            }
        }
    }

    public boolean upgradeTo(Block block)
    {
        if (level == null || level.isClientSide() || !(block instanceof CobbleGenBlock))
        {
            return false;
        }

        ItemStack contents = cobbleGenContents.getItem(0).copy();
        int savedCycle = cycle;
        BlockState currentState = getBlockState();
        BlockState upgradedState = block.defaultBlockState();

        if (currentState.hasProperty(BlockStateProperties.HORIZONTAL_FACING) && upgradedState.hasProperty(BlockStateProperties.HORIZONTAL_FACING))
        {
            upgradedState = upgradedState.setValue(BlockStateProperties.HORIZONTAL_FACING, currentState.getValue(BlockStateProperties.HORIZONTAL_FACING));
        }

        if (!level.setBlock(worldPosition, upgradedState, 3))
        {
            return false;
        }

        BlockEntity blockEntity = level.getBlockEntity(worldPosition);
        if (blockEntity instanceof CobbleGenEntity cobbleGen)
        {
            cobbleGen.cobbleGenContents.setItem(0, contents);
            cobbleGen.cycle = savedCycle;
            cobbleGen.setChanged();
            return true;
        }

        return false;
    }

    public void saveToItem(ItemStack stack)
    {
        if (level == null)
        {
            return;
        }

        TagValueOutput output = TagValueOutput.createWithContext(ProblemReporter.DISCARDING, level.registryAccess());
        saveCustomOnly(output);
        BlockItem.setBlockEntityData(stack, getType(), output);

        ItemStack contents = cobbleGenContents.getItem(0);
        if (!contents.isEmpty())
        {
            CustomData.update(DataComponents.CUSTOM_DATA, stack, tag ->
            {
                CompoundTag storedContents = new CompoundTag();
                storedContents.putString("item", BuiltInRegistries.ITEM.getKey(contents.getItem()).toString());
                storedContents.putInt("count", contents.getCount());
                tag.put("HavenCobbleGenContents", storedContents);
            });
        }
    }

    public CobbleGenInventory getInventory()
    {
        return cobbleGenContents;
    }

    public int getMaxStackSize()
    {
        return getCobbleGenBlock().getCobbleGenOutput();
    }

    public Block getBlockToGenerate()
    {
        return level == null ? Blocks.COBBLESTONE : cobbleGenContents.getBlockToGenerate(level, worldPosition);
    }

    public List<? extends String> getValidBlocks()
    {
        return getCobbleGenBlock().getValidBlocks();
    }
}