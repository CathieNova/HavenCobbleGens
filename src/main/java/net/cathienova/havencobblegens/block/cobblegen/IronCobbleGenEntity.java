package net.cathienova.havencobblegens.block.cobblegen;

import net.cathienova.havencobblegens.block.ModBlockEntities;
import net.cathienova.havencobblegens.config.HavenConfig;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;

import java.util.List;

public class IronCobbleGenEntity extends BaseCobbleGenEntity {
    public IronCobbleGenEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.iron_cobble_gen_tile.get(), pos, state, 
              HavenConfig.iron_cobble_gen_speed, 
              HavenConfig.iron_cobble_gen_output);
    }
    
    @Override
    public void tick() {
        super.tick();
    }

    @Override
    public List<? extends String> getValidBlocks() {
        return HavenConfig.iron_cobble_gen_valid_blocks;
    }
}
