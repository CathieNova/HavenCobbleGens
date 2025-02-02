package net.cathienova.havencobblegens.block.cobblegen;

import net.cathienova.havencobblegens.HavenCobbleGens;
import net.cathienova.havencobblegens.block.ModBlockEntities;
import net.cathienova.havencobblegens.config.HavenConfig;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.Connection;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.Nullable;

public class CreativeCobbleGenEntity extends BlockEntity implements BlockEntityTicker<CreativeCobbleGenEntity> {

    private int cycle = 0;
    private CobbleGenInventory cobbleGenContents;

    public CreativeCobbleGenEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.creative_cobble_gen_tile.get(), pos, state);
        this.createInventory();
    }

    public CreativeCobbleGenEntity setGenStats() {
        if (this.level != null) {
            this.level.setBlock(this.worldPosition, this.getBlockState(), 3);
        }
        this.createInventory();
        return this;
    }

    private void createInventory() {
        this.cobbleGenContents = CobbleGenInventory.createForTileEntity(1, HavenConfig.creative_cobble_gen_output);
    }

    private boolean canPlayerAccessInventory(Player player) {
        if (this.level.getBlockEntity(this.worldPosition) != this) return false;
        return player.distanceToSqr(this.worldPosition.getX() + 0.5, this.worldPosition.getY() + 0.5, this.worldPosition.getZ() + 0.5) < 64.0;
    }

    @Override
    public void load(CompoundTag tag) {
        super.load(tag);

        if (this.cobbleGenContents == null) {
            this.createInventory();
        }

        if (tag.contains("inventory")) {
            this.cobbleGenContents.deserializeNBT(tag.getCompound("inventory"));
        }
        this.setChanged();
    }

    @Override
    protected void saveAdditional(CompoundTag tag) {
        super.saveAdditional(tag);

        if (this.cobbleGenContents != null) {
            tag.put("inventory", this.cobbleGenContents.serializeNBT());
        }
    }

    @Nullable
    @Override
    public ClientboundBlockEntityDataPacket getUpdatePacket() {
        CompoundTag tag = new CompoundTag();
        this.saveAdditional(tag);
        return ClientboundBlockEntityDataPacket.create(this);
    }

    @Override
    public void onDataPacket(Connection net, ClientboundBlockEntityDataPacket pkt) {
        this.load(pkt.getTag());
    }

    @Override
    public CompoundTag getUpdateTag() {
        CompoundTag tag = new CompoundTag();
        this.saveAdditional(tag);
        return tag;
    }

    @Override
    public void handleUpdateTag(CompoundTag tag) {
        this.load(tag);
    }

    public void tick(Level level, BlockPos pos, BlockState state, CreativeCobbleGenEntity blockEntity) {
        if (level.isClientSide()) return;

        if (cycle++ >= HavenConfig.creative_cobble_gen_speed) {
            cycle = 0;

            // ADD THIS CODE TO THE OTHER ENTITIES AS WELL

            Block blockToGenerate = cobbleGenContents.getBlockToGenerate(this.level, this.worldPosition);
            Item itemToGenerate = cobbleGenContents.getItemToGenerate(this.level, this.worldPosition);
            ItemStack stack = cobbleGenContents.getItem(0);
            if (stack.isEmpty()) {
                if (blockToGenerate != Blocks.AIR)
                {
                    cobbleGenContents.setItem(0, new ItemStack(blockToGenerate));
                }
                else if (itemToGenerate != null)
                {
                    cobbleGenContents.setItem(0, new ItemStack(itemToGenerate));
                }
                this.setChanged();
            } else if (stack.getItem() == blockToGenerate.asItem() && stack.getCount() < HavenConfig.creative_cobble_gen_output) {
                stack.grow(HavenConfig.creative_cobble_gen_yield);
                cobbleGenContents.setItem(0, stack);
                this.setChanged();
            }

            BlockEntity tileAbove = level.getBlockEntity(pos.above());
            if (tileAbove != null) {
                tileAbove.getCapability(ForgeCapabilities.ITEM_HANDLER, Direction.DOWN).ifPresent(handler -> {
                    for (int slot = 0; slot < handler.getSlots(); slot++) {
                        ItemStack singleItemStack = cobbleGenContents.removeItem(0, 2);
                        if (!singleItemStack.isEmpty()) {
                            ItemStack leftoverStack = handler.insertItem(slot, singleItemStack, false);
                            if (!leftoverStack.isEmpty()) {
                                cobbleGenContents.setItem(0, leftoverStack);
                            } else {
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                });
            }

            this.setChanged();
        }
    }

    @Override
    public <T> LazyOptional<T> getCapability(Capability<T> cap, Direction side) {
        if (cap == ForgeCapabilities.ITEM_HANDLER) {
            return LazyOptional.of(() -> this.cobbleGenContents.getHandler()).cast();
        }
        return super.getCapability(cap, side);
    }

    public CobbleGenInventory getInventory() {
        return this.cobbleGenContents;
    }

    public int getMaxStackSize() {
        return HavenConfig.creative_cobble_gen_output;
    }
}
