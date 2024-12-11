package net.cathienova.havencobblegens.block.cobblegen;

import net.cathienova.havencobblegens.block.ModBlockEntities;
import net.cathienova.havencobblegens.config.HavenConfig;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.state.BlockState;

import java.util.List;
import java.util.Random;
import java.util.Set;

public class NetheriteCobbleGenEntity extends BlockEntity implements BlockEntityTicker<NetheriteCobbleGenEntity> {

    private int cycle = 0;
    private CobbleGenInventory cobbleGenContents;

    public NetheriteCobbleGenEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.netherite_cobble_gen_tile.get(), pos, state);
        this.createInventory();
    }

    private void createInventory() {
        cobbleGenContents = CobbleGenInventory.createForTileEntity(1, HavenConfig.netheriteCobbleGenOutput);
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

    public NetheriteCobbleGenEntity setGenStats() {
        if (this.level != null) {
            this.level.setBlock(this.worldPosition, this.getBlockState(), 3);
        }
        this.createInventory();
        return this;
    }

    @Override
    public void tick(Level level, BlockPos pos, BlockState state, NetheriteCobbleGenEntity blockEntity) {
        if (level.isClientSide()) return;

        if (cycle++ >= HavenConfig.netheriteCobbleGenSpeed) {
            cycle = 0;

            Block blockToGenerate = getBlockToGenerate();
            ItemStack stack = cobbleGenContents.getItem(0);
            if (stack.isEmpty()) {
                cobbleGenContents.setItem(0, new ItemStack(blockToGenerate));
            } else if (stack.getItem() == blockToGenerate.asItem()) {
                int newSize = Math.min(stack.getCount() + 1, HavenConfig.diamondCobbleGenOutput);
                stack.setCount(newSize);
                cobbleGenContents.setItem(0, stack);
            } else {
                return;
            }

            BlockEntity tileAbove = level.getBlockEntity(pos.above());
            if (tileAbove instanceof BlockEntityTicker<?> ticker) {
                for (int slot = 0; slot < cobbleGenContents.getContainerSize(); slot++) {
                    ItemStack singleItemStack = cobbleGenContents.removeItem(slot, 1);
                    if (!singleItemStack.isEmpty()) {
                        cobbleGenContents.setItem(slot, singleItemStack);
                        break;
                    }
                }
            }

            this.setChanged();
        }
    }

    public CobbleGenInventory getInventory() {
        return this.cobbleGenContents;
    }

    public int getMaxStackSize() {
        return HavenConfig.netheriteCobbleGenOutput;
    }

    private Block getBlockToGenerate() {
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
