package net.cathienova.havencobblegens.block.cobblegen;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public abstract class BaseCobbleGen extends BaseEntityBlock {
    protected final int cobbleGenSpeed;
    protected final int cobbleGenOutput;
    protected final String configPrefix;

    protected BaseCobbleGen(Properties properties, int cobbleGenSpeed, int cobbleGenOutput, String configPrefix) {
        super(properties);
        this.cobbleGenSpeed = cobbleGenSpeed;
        this.cobbleGenOutput = cobbleGenOutput;
        this.configPrefix = configPrefix;
    }

    @Override
    public RenderShape getRenderShape(BlockState state) {
        return RenderShape.MODEL;
    }

    @Override
    protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hitResult) {
        if (level.isClientSide()) {
            return InteractionResult.SUCCESS;
        }

        BlockEntity tile = level.getBlockEntity(pos);

        if (tile instanceof BaseCobbleGenEntity cobblegen) {
            if (!player.isCrouching()) {
                ItemStack stack = cobblegen.getInventory().removeItem(0, cobblegen.getMaxStackSize());

                if (!stack.isEmpty()) {
                    if (!player.getInventory().add(stack)) {
                        player.drop(stack, false);
                    }
                }
            } else {
                ItemStack stack = cobblegen.getInventory().getItem(0);
                Component message = Component.translatable("Cobblestone x " + (stack.isEmpty() ? 0 : stack.getCount()));
                player.sendSystemMessage(message);
            }
        }

        return InteractionResult.SUCCESS;
    }

    @Override
    public void onRemove(BlockState oldState, Level world, BlockPos pos, BlockState newState, boolean isMoving) {
        if (oldState.getBlock() != newState.getBlock()) {
            BlockEntity tile = world.getBlockEntity(pos);

            if (tile instanceof BaseCobbleGenEntity cobblegen) {
                cobblegen.getInventory().dropInventory(world, pos);
            }
        }
        super.onRemove(oldState, world, pos, newState, isMoving);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<net.minecraft.world.level.block.Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(BlockStateProperties.HORIZONTAL_FACING);
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return this.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, context.getHorizontalDirection().getOpposite());
    }

    @Override
    public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> tooltip, TooltipFlag tooltipFlag) {
        tooltip.add(Component.translatable("tooltip.cobblegen_1", cobbleGenOutput));

        float cobblestonesPerSecond = 20.0f / (float) cobbleGenSpeed;
        tooltip.add(Component.translatable("tooltip.cobblegen_2", String.format("%.2f", cobblestonesPerSecond)));
        tooltip.add(Component.translatable("tooltip.cobblegen_3"));
        tooltip.add(Component.translatable("tooltip.cobblegen_4"));
    }

    @Nullable
    protected static <T extends BlockEntity> BlockEntityTicker<T> createTicker(Level level, BlockEntityType<T> type, BlockEntityTicker<? super BaseCobbleGenEntity> ticker) {
        return level.isClientSide() ? null : createTickerHelper(type, (BlockEntityType<BaseCobbleGenEntity>) ticker, (lvl, pos, state, blockEntity) -> blockEntity.tick());
    }
}
