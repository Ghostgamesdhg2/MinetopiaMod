package com.ghostgamesdhg.minetopia.blocks;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class Blue_Crystal_Block extends Block {
    public Blue_Crystal_Block() {
        super(AbstractBlock.Properties.create(Material.IRON)
                .hardnessAndResistance(5.0f, 10.0f)
                .sound(SoundType.METAL)
                .harvestLevel(3) //1 = wood - 2 = stone - 3 = iron - 4 = diamond.
                .setRequiresTool()
                .harvestTool(ToolType.PICKAXE));

    }
}
