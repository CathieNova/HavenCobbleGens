package net.cathienova.havencobblegens.block.cobblegen;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.function.IntSupplier;
import java.util.function.Supplier;

public class CobbleGenBlock extends BaseEntityBlock
{
    private final MapCodec<CobbleGenBlock> codec = MapCodec.unit(this);
    private final Supplier<BlockEntityType<CobbleGenEntity>> blockEntityType;
    private final IntSupplier cobbleGenSpeed;
    private final IntSupplier cobbleGenOutput;
    private final IntSupplier cobbleGenMultiplier;
    private final Supplier<List<? extends String>> validBlocks;

    public CobbleGenBlock(Properties properties, Supplier<BlockEntityType<CobbleGenEntity>> blockEntityType,
                          IntSupplier cobbleGenSpeed, IntSupplier cobbleGenOutput,
                          Supplier<List<? extends String>> validBlocks)
    {
        this(properties, blockEntityType, cobbleGenSpeed, cobbleGenOutput, () -> 1, validBlocks);
    }

    public CobbleGenBlock(Properties properties, Supplier<BlockEntityType<CobbleGenEntity>> blockEntityType,
                          IntSupplier cobbleGenSpeed, IntSupplier cobbleGenOutput,
                          IntSupplier cobbleGenMultiplier, Supplier<List<? extends String>> validBlocks)
    {
        super(properties);
        this.blockEntityType = blockEntityType;
        this.cobbleGenSpeed = cobbleGenSpeed;
        this.cobbleGenOutput = cobbleGenOutput;
        this.cobbleGenMultiplier = cobbleGenMultiplier;
        this.validBlocks = validBlocks;
    }

    @Override
    protected MapCodec<? extends BaseEntityBlock> codec()
    {
        return codec;
    }

    @Override
    public RenderShape getRenderShape(BlockState state)
    {
        return RenderShape.MODEL;
    }

    @Override
    protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hitResult)
    {
        if (level.isClientSide())
        {
            return InteractionResult.SUCCESS;
        }

        BlockEntity blockEntity = level.getBlockEntity(pos);
        if (blockEntity instanceof CobbleGenEntity cobbleGen)
        {
            if (!player.isCrouching())
            {
                ItemStack stack = cobbleGen.getInventory().removeItem(0, cobbleGen.getMaxStackSize());
                if (!stack.isEmpty() && !player.getInventory().add(stack))
                {
                    player.drop(stack, false);
                }
            }
            else
            {
                ItemStack stack = cobbleGen.getInventory().getItem(0);
                player.sendSystemMessage(Component.literal("Cobblestone x " + stack.getCount()));
            }
        }

        return InteractionResult.SUCCESS;
    }

    @Override
    protected List<ItemStack> getDrops(BlockState state, LootParams.Builder builder)
    {
        List<ItemStack> drops = super.getDrops(state, builder);
        BlockEntity blockEntity = builder.getOptionalParameter(LootContextParams.BLOCK_ENTITY);

        if (blockEntity instanceof CobbleGenEntity cobbleGen)
        {
            for (ItemStack drop : drops)
            {
                if (drop.is(state.getBlock().asItem()))
                {
                    cobbleGen.saveToItem(drop);
                    break;
                }
            }
        }

        return drops;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder)
    {
        super.createBlockStateDefinition(builder);
        builder.add(BlockStateProperties.HORIZONTAL_FACING);
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context)
    {
        return defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, context.getHorizontalDirection().getOpposite());
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state)
    {
        return new CobbleGenEntity(pos, state);
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> type)
    {
        if (level.isClientSide())
        {
            return null;
        }

        return createTickerHelper(type, blockEntityType.get(),
                (tickLevel, tickPos, tickState, blockEntity) -> blockEntity.tick());
    }

    public BlockEntityType<CobbleGenEntity> getBlockEntityType()
    {
        return blockEntityType.get();
    }

    public int getCobbleGenSpeed()
    {
        return cobbleGenSpeed.getAsInt();
    }

    public int getCobbleGenOutput()
    {
        return cobbleGenOutput.getAsInt();
    }

    public int getCobbleGenMultiplier()
    {
        return cobbleGenMultiplier.getAsInt();
    }

    public List<? extends String> getValidBlocks()
    {
        return validBlocks.get();
    }
}