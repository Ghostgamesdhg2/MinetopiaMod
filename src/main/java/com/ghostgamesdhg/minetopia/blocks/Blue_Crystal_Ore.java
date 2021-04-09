package com.ghostgamesdhg.minetopia.blocks;

import net.minecraft.block.BlockState;
import net.minecraft.block.Block;
import net.minecraft.block.OreBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorldReader;
import net.minecraftforge.common.ToolType;

public class Blue_Crystal_Ore extends OreBlock {
    public Blue_Crystal_Ore() {
        super(Block.Properties.create(Material.IRON)
                .hardnessAndResistance(4.0f, 2.0f)
                .sound(SoundType.STONE)
                .harvestLevel(3) //1 = wood - 2 = stone - 3 = iron - 4 = diamond.
                .harvestTool(ToolType.PICKAXE));

    }

    @Override
    public int getExpDrop(BlockState state, IWorldReader reader, BlockPos pos, int fortune, int silktouch) {
        return 1;
    }
}
