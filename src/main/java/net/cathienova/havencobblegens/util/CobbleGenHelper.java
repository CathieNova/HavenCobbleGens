package net.cathienova.havencobblegens.util;

import net.cathienova.havencobblegens.config.HavenConfig;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.List;
import java.util.Objects;
import java.util.Random;

public class CobbleGenHelper
{
    public static Block getBlockToGenerate(Level level, BlockPos worldPosition)
    {
        List<? extends String> validBlocks = HavenConfig.cobbleGenValidBlocks;
        Random random = new Random();

        // Loop through all six directions (up, down, north, south, east, west)
        for (Direction direction : Direction.values())
        {
            assert level != null;
            Block blockAtSide = level.getBlockState(worldPosition.relative(direction)).getBlock();
            String blockAtSideName = Objects.requireNonNull(ForgeRegistries.BLOCKS.getKey(blockAtSide)).toString();

            // Iterate over each config entry (formatted as blockToCheck;blockToGenerate1,blockToGenerate2,...)
            for (String entry : validBlocks)
            {
                String[] parts = entry.split(";");
                if (parts.length == 2)
                {
                    String blockToCheck = parts[0];  // The block to check on the side
                    String[] blockToGenerateList = parts[1].split(",");  // Blocks to randomly choose from

                    // If the blockAtSide matches blockToCheck, randomly select a block from blockToGenerateList
                    if (blockAtSideName.equals(blockToCheck))
                    {
                        String randomBlockToGenerate = blockToGenerateList[random.nextInt(blockToGenerateList.length)];
                        return ForgeRegistries.BLOCKS.getValue(new ResourceLocation(randomBlockToGenerate));
                    }
                }
            }
        }
        // Default to cobblestone if no match
        return Blocks.COBBLESTONE;
    }

    public static Item getItemToGenerate(Level level, BlockPos worldPosition)
    {
        List<? extends String> validBlocks = HavenConfig.cobbleGenValidBlocks;
        Random random = new Random();

        // Loop through all six directions (up, down, north, south, east, west)
        for (Direction direction : Direction.values())
        {
            assert level != null;
            Block blockAtSide = level.getBlockState(worldPosition.relative(direction)).getBlock();
            String blockAtSideName = Objects.requireNonNull(ForgeRegistries.BLOCKS.getKey(blockAtSide)).toString();

            // Iterate over each config entry (formatted as blockToCheck;blockToGenerate1,blockToGenerate2,...)
            for (String entry : validBlocks)
            {
                String[] parts = entry.split(";");
                if (parts.length == 2)
                {
                    String blockToCheck = parts[0];  // The item to check on the side
                    String[] itemToGenerateList = parts[1].split(",");  // Items to randomly choose from

                    // If the blockAtSide matches blockToCheck, randomly select an item from itemToGenerateList
                    if (blockAtSideName.equals(blockToCheck))
                    {
                        String randomItemToGenerate = itemToGenerateList[random.nextInt(itemToGenerateList.length)];
                        return ForgeRegistries.ITEMS.getValue(new ResourceLocation(randomItemToGenerate));
                    }
                }
            }
        }
        // Default to cobblestone if no match
        return Items.COBBLESTONE;
    }
}
