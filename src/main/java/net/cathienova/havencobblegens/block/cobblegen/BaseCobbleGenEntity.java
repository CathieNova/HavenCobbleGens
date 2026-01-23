package net.cathienova.havencobblegens.block.cobblegen;

import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.items.IItemHandler;

import java.util.List;

public abstract class BaseCobbleGenEntity extends BlockEntity implements ICobbleGenEntity {
    protected int cycle = 0;
    protected CobbleGenInventory cobbleGenContents;
    protected final int cobbleGenSpeed;
    protected final int cobbleGenOutput;

    public BaseCobbleGenEntity(BlockEntityType<?> type, BlockPos pos, BlockState state, int cobbleGenSpeed, int cobbleGenOutput) {
        super(type, pos, state);
        this.cobbleGenSpeed = cobbleGenSpeed;
        this.cobbleGenOutput = cobbleGenOutput;
        this.createInventory();
    }

    protected void createInventory() {
        cobbleGenContents = CobbleGenInventory.createForTileEntity(1, cobbleGenOutput);
    }

    protected boolean canPlayerAccessInventory(Player player) {
        if (this.level == null || this.level.getBlockEntity(this.worldPosition) != this) return false;
        return player.distanceToSqr(this.worldPosition.getX() + 0.5, this.worldPosition.getY() + 0.5, this.worldPosition.getZ() + 0.5) < 64.0;
    }

    @Override
    protected void loadAdditional(CompoundTag tag, HolderLookup.Provider registries) {
        if (this.cobbleGenContents == null) this.createInventory();
        if (tag.contains("inventory")) {
            this.cobbleGenContents.deserializeNBT(registries, tag.getCompound("inventory"));
        }
    }

    @Override
    protected void saveAdditional(CompoundTag tag, HolderLookup.Provider registries) {
        tag.put("inventory", this.cobbleGenContents.serializeNBT(registries));
    }

    public void tick() {
        if (level == null || level.isClientSide()) return;

        if (cycle++ >= cobbleGenSpeed) {
            cycle = 0;
            generateCobblestone();
        }
    }

    protected void generateCobblestone() {
        Block blockToGenerate = cobbleGenContents.getBlockToGenerate(this.level, this.worldPosition);
        ItemStack stack = cobbleGenContents.getItem(0);
        
        if (stack.isEmpty()) {
            cobbleGenContents.setItem(0, new ItemStack(blockToGenerate));
            this.setChanged();
        } else if (stack.getItem() == blockToGenerate.asItem() && stack.getCount() < cobbleGenOutput) {
            stack.grow(1);
            cobbleGenContents.setItem(0, stack);
            this.setChanged();
        }

        if (handleInsertion(level.getBlockEntity(worldPosition.below()), worldPosition.below())) {
            this.setChanged();
            return;
        }
        if (handleInsertion(level.getBlockEntity(worldPosition.above()), worldPosition.above())) {
            this.setChanged();
            return;
        }
        this.setChanged();
    }

    protected boolean handleInsertion(BlockEntity tile, BlockPos pos) {
        if (tile != null) {
            assert level != null;
            IItemHandler cap = level.getCapability(Capabilities.ItemHandler.BLOCK, pos, null);
            if (cap != null && isCapAvailable(cap)) {
                insertItemToContainer(cap);
                this.setChanged();
                return true;
            }
        }
        return false;
    }

    protected boolean isCapAvailable(IItemHandler cap) {
        ItemStack toInsert = cobbleGenContents.getItem(0);
        if (toInsert.isEmpty()) return false;

        for (int slot = 0; slot < cap.getSlots(); slot++) {
            ItemStack remaining = cap.insertItem(slot, toInsert.copy(), true);
            if (remaining.getCount() < toInsert.getCount()) {
                return true;
            }
        }
        return false;
    }

    protected void insertItemToContainer(IItemHandler cap) {
        ItemStack toInsert = cobbleGenContents.getItem(0);
        if (toInsert.isEmpty()) return;

        for (int slot = 0; slot < cap.getSlots(); slot++) {
            ItemStack remaining = cap.insertItem(slot, toInsert.copy(), false);
            if (remaining.getCount() != toInsert.getCount()) {
                cobbleGenContents.setItem(0, remaining);
                this.setChanged();
                break;
            }
        }
    }

    public CobbleGenInventory getInventory() {
        return this.cobbleGenContents;
    }

    public int getMaxStackSize() {
        return cobbleGenOutput;
    }

    public Block getBlockToGenerate() {
        return cobbleGenContents.getBlockToGenerate(this.level, this.worldPosition);
    }
    
    @Override
    public List<? extends String> getValidBlocks() {
        // Default implementation returns an empty list
        // Individual implementations should override this
        return List.of();
    }
}
