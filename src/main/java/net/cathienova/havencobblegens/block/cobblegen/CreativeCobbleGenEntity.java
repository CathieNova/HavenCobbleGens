package net.cathienova.havencobblegens.block.cobblegen;

import net.cathienova.havencobblegens.HavenCobbleGens;
import net.cathienova.havencobblegens.block.ModBlockEntities;
import net.cathienova.havencobblegens.config.HavenConfig;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.component.DataComponentMap;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.items.IItemHandler;

import java.util.List;
import java.util.Random;

public class CreativeCobbleGenEntity extends BlockEntity implements BlockEntityTicker<CreativeCobbleGenEntity> {

    private int cycle = 0;
    private CobbleGenInventory cobbleGenContents;

    public CreativeCobbleGenEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.creative_cobble_gen_tile.get(), pos, state);
        this.createInventory();
    }

    private void createInventory() {
        cobbleGenContents = CobbleGenInventory.createForTileEntity(1, HavenConfig.creative_cobble_gen_output);
    }

    private boolean canPlayerAccessInventory(Player player) {
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

    public CreativeCobbleGenEntity setGenStats() {
        if (this.level != null) {
            this.level.setBlock(this.worldPosition, this.getBlockState(), 3);
        }
        this.createInventory();
        return this;
    }

    @Override
    public void tick(Level level, BlockPos pos, BlockState state, CreativeCobbleGenEntity blockEntity) {
        if (level.isClientSide()) return;

        if (cycle++ >= HavenConfig.creative_cobble_gen_speed) {
            cycle = 0;

            Block blockToGenerate = getBlockToGenerate();
            ItemStack stack = cobbleGenContents.getItem(0);
            if (stack.isEmpty()) {
                cobbleGenContents.setItem(0, new ItemStack(blockToGenerate));
                this.setChanged();
            } else if (stack.getItem() == blockToGenerate.asItem()) {
                int newSize = Math.min(stack.getCount(), HavenConfig.creative_cobble_gen_output);
                stack.setCount(newSize * HavenConfig.creative_cobble_gen_multiplier);
                cobbleGenContents.setItem(0, stack);
                this.setChanged();
            }

            if (handleInsertion(level.getBlockEntity(pos.below()), pos.below())) {
                this.setChanged();
                return;
            }
            if (handleInsertion(level.getBlockEntity(pos.above()), pos.above())) {
                this.setChanged();
                return;
            }
            this.setChanged();
        }
    }

    private boolean handleInsertion(BlockEntity tile, BlockPos pos) {
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

    private boolean isCapAvailable(IItemHandler cap) {
        for (int slot = 0; slot < cap.getSlots(); slot++) {
            ItemStack targetStack = cap.getStackInSlot(slot);
            if (targetStack.isEmpty() || (targetStack.getItem() == cobbleGenContents.getItem(0).getItem() && targetStack.getCount() < targetStack.getMaxStackSize())) {
                return true;
            }
        }
        return false;
    }

    private void insertItemToContainer(IItemHandler cap) {
        for (int slot = 0; slot < cap.getSlots(); slot++) {
            ItemStack singleItemStack = cobbleGenContents.getItem(0);
            if (singleItemStack.isEmpty()) {
                break;
            }

            ItemStack targetStack = cap.getStackInSlot(slot);
            if (targetStack.isEmpty() || (targetStack.getItem() == singleItemStack.getItem() && targetStack.getCount() < targetStack.getMaxStackSize())) {
                ItemStack remainingStack = cap.insertItem(slot, singleItemStack, false);
                cobbleGenContents.setItem(0, remainingStack);
                if (remainingStack.isEmpty()) {
                    break;
                }
            }
        }
        this.setChanged();
    }

    public CobbleGenInventory getInventory() {
        return this.cobbleGenContents;
    }

    public int getMaxStackSize() {
        return HavenConfig.creative_cobble_gen_output;
    }

    public Block getBlockToGenerate() {
        List<? extends String> validBlocks = HavenConfig.cobbleGenValidBlocks;
        Random random = new Random();

        // Loop through all six directions (up, down, north, south, east, west)
        for (Direction direction : Direction.values()) {
            assert this.level != null;
            Block blockAtSide = this.level.getBlockState(this.worldPosition.relative(direction)).getBlock();
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
}
