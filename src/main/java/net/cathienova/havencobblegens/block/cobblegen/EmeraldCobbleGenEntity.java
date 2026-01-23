package net.cathienova.havencobblegens.block.cobblegen;

import net.cathienova.havencobblegens.block.ModBlockEntities;
import net.cathienova.havencobblegens.config.HavenConfig;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;

import java.util.List;

public class EmeraldCobbleGenEntity extends BaseCobbleGenEntity {
    public EmeraldCobbleGenEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.emerald_cobble_gen_tile.get(), pos, state, 
              HavenConfig.emerald_cobble_gen_speed, 
              HavenConfig.emerald_cobble_gen_output);
    }
    
    @Override
    public void tick() {
        super.tick();
    }

    @Override
    public List<? extends String> getValidBlocks() {
        return HavenConfig.emerald_cobble_gen_valid_blocks;
    }
}
