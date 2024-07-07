package net.cathienova.havencobblegens.block.cobblegen;

import net.cathienova.havencobblegens.block.ModBlockEntities;
import net.cathienova.havencobblegens.config.HavenConfig;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
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

public class GoldCobbleGen extends BaseEntityBlock {

    public GoldCobbleGen() {
        super(Properties.copy(Blocks.STONE).strength(2.0f));
    }

    @Override
    public RenderShape getRenderShape(BlockState state) {
        return RenderShape.MODEL;
    }

    @Override
    public InteractionResult use(BlockState state, Level world, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        if (world.isClientSide()) {
            return InteractionResult.SUCCESS;
        }

        BlockEntity tile = world.getBlockEntity(pos);

        if (tile instanceof GoldCobbleGenEntity) {
            GoldCobbleGenEntity cobblegen = (GoldCobbleGenEntity) tile;

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

            if (tile instanceof GoldCobbleGenEntity) {
                ((GoldCobbleGenEntity) tile).getInventory().dropInventory(world, pos);
            }
        }
        super.onRemove(oldState, world, pos, newState, isMoving);
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new GoldCobbleGenEntity(pos, state).setGenStats();
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> type) {
        if (level.isClientSide()) {
            return null;
        }

        return createTickerHelper(type, ModBlockEntities.gold_cobble_gen_tile.get(),
                (pLevel1, pPos, pState1, pBlockEntity) -> pBlockEntity.tick(pLevel1, pPos, pState1, pBlockEntity));
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable BlockGetter world, List<Component> tooltip, TooltipFlag flag) {
        tooltip.add(Component.translatable("tooltip.cobblegen_1", HavenConfig.gold_cobble_gen_output));

        float cobblestonesPerSecond = 20.0f / (float) HavenConfig.gold_cobble_gen_speed;
        tooltip.add(Component.translatable("tooltip.cobblegen_2", String.format("%.2f", cobblestonesPerSecond)));
        tooltip.add(Component.translatable("tooltip.cobblegen_3"));
        tooltip.add(Component.translatable("tooltip.cobblegen_4"));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(BlockStateProperties.HORIZONTAL_FACING);
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return this.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, context.getHorizontalDirection().getOpposite());
    }
}
