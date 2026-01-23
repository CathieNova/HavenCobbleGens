package net.cathienova.havencobblegens.block.cobblegen;

import net.cathienova.havencobblegens.block.ModBlockEntities;
import net.cathienova.havencobblegens.config.HavenConfig;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;

import java.util.List;

public class StoneCobbleGenEntity extends BaseCobbleGenEntity {

    public StoneCobbleGenEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.stone_cobble_gen_tile.get(), pos, state, 
              HavenConfig.stone_cobble_gen_speed, 
              HavenConfig.stone_cobble_gen_output);
    }
    
    @Override
    public void tick() {
        super.tick();
    }

    @Override
    public List<? extends String> getValidBlocks() {
        return HavenConfig.stone_cobble_gen_valid_blocks;
    }
}
