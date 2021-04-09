package com.ghostgamesdhg.minetopia.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.common.ToolType;

import javax.annotation.Nullable;
import java.util.stream.Stream;

public class Vending_Machine extends Block {

    private static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;

    private static final VoxelShape SHAPE_N = Stream.of(
            Block.makeCuboidShape(1.75, 8, 0.5, 3, 8.25, 0.75),
            Block.makeCuboidShape(0, 0, 15, 1, 6, 16),
            Block.makeCuboidShape(15, 0, 15, 16, 6, 16),
            Block.makeCuboidShape(15, 0, 0, 16, 6, 1),
            Block.makeCuboidShape(0, 0, 0, 1, 6, 1),
            Block.makeCuboidShape(0, 0, 1, 16, 6, 15),
            Block.makeCuboidShape(1, 0, 15, 15, 2, 16),
            Block.makeCuboidShape(15, 6, 0, 16, 29, 16),
            Block.makeCuboidShape(1, 2, 15, 15, 29, 16),
            Block.makeCuboidShape(0, 6, 0, 1, 29, 16),
            Block.makeCuboidShape(0, 29, 0, 16, 30, 16),
            Block.makeCuboidShape(1, 1, 0, 15, 2, 1),
            Block.makeCuboidShape(1, 6, 0, 15, 7, 2),
            Block.makeCuboidShape(6, 4, 0, 14, 4.5, 1),
            Block.makeCuboidShape(6, 2.5, 0, 14, 3, 1),
            Block.makeCuboidShape(13.5, 3, 0, 14, 4, 1),
            Block.makeCuboidShape(6, 3, 0, 6.5, 4, 1),
            Block.makeCuboidShape(6, 6, 1.25, 15, 9, 14),
            Block.makeCuboidShape(1, 7, 0.75, 6, 29, 15),
            Block.makeCuboidShape(6, 18, 0.75, 15, 18.5, 14.75),
            Block.makeCuboidShape(1.5, 21.25, 0.5, 1.75, 22.25, 0.75),
            Block.makeCuboidShape(2.2, 17.05, 0.5, 2.45, 17.65, 0.75),
            Block.makeCuboidShape(4, 21.25, 0.5, 4.25, 22.25, 0.75),
            Block.makeCuboidShape(4, 17.05, 0.5, 4.25, 17.65, 0.75),
            Block.makeCuboidShape(1.5, 22.25, 0.5, 4.25, 22.5, 0.75),
            Block.makeCuboidShape(2.2, 17.65, 0.5, 4.25, 17.9, 0.75),
            Block.makeCuboidShape(1.5, 21, 0.5, 4.25, 21.25, 0.75),
            Block.makeCuboidShape(2.2, 17, 0.5, 4.25, 17.25, 0.75),
            Block.makeCuboidShape(3.75, 20.25, 0.5, 4.25, 20.75, 1.5),
            Block.makeCuboidShape(3, 20.25, 0.5, 3.5, 20.75, 1.5),
            Block.makeCuboidShape(2.25, 20.25, 0.5, 2.75, 20.75, 1.5),
            Block.makeCuboidShape(3, 19.5, 0.5, 3.5, 20, 1.5),
            Block.makeCuboidShape(3.75, 19.5, 0.5, 4.25, 20, 1.5),
            Block.makeCuboidShape(2.25, 19.5, 0.5, 2.75, 20, 1.5),
            Block.makeCuboidShape(3, 18.75, 0.5, 3.5, 19.25, 1.5),
            Block.makeCuboidShape(3.75, 18.75, 0.5, 4.25, 19.25, 1.5),
            Block.makeCuboidShape(2.25, 18.75, 0.5, 2.75, 19.25, 1.5),
            Block.makeCuboidShape(2.25, 18.1, 0.5, 2.75, 18.6, 1.5),
            Block.makeCuboidShape(3, 18.1, 0.5, 3.5, 18.6, 1.5),
            Block.makeCuboidShape(3.75, 18.1, 0.5, 4.25, 18.6, 1.5),
            Block.makeCuboidShape(1.75, 21.25, 0.65, 4, 22.25, 1.4),
            Block.makeCuboidShape(1.75, 8.25, 0.5, 2, 9, 0.75),
            Block.makeCuboidShape(2.75, 8.25, 0.5, 3, 9, 0.75),
            Block.makeCuboidShape(1.75, 9, 0.5, 3, 9.25, 0.75),
            Block.makeCuboidShape(7.25, 12, 2.75, 13.75, 13.5, 9.25),
            Block.makeCuboidShape(9.5, 13.5, 5, 11.5, 15, 7),
            Block.makeCuboidShape(9.5, 13.825, 4.875, 11.5, 14.325, 6.875),
            Block.makeCuboidShape(9.5, 12.875, 5, 11.5, 13.375, 7),
            Block.makeCuboidShape(9.325, 13.825, 5, 11.325, 14.325, 7),
            Block.makeCuboidShape(9.5, 12.875, 5, 11.5, 13.375, 7),
            Block.makeCuboidShape(7.5, 9, 3, 13.5, 12, 9),
            Block.makeCuboidShape(7.25, 21.5, 2.75, 13.75, 23, 13.25),
            Block.makeCuboidShape(9.5, 23, 7, 11.5, 24.5, 9),
            Block.makeCuboidShape(9.625, 23.325, 7, 11.625, 23.825, 9),
            Block.makeCuboidShape(9.5, 22.375, 7, 11.5, 22.875, 9),
            Block.makeCuboidShape(9.5, 23.325, 6.825, 11.5, 23.825, 8.825),
            Block.makeCuboidShape(9.5, 22.375, 7, 11.5, 22.875, 9),
            Block.makeCuboidShape(7.5, 18.5, 3, 13.5, 21.5, 13)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

    public static final VoxelShape SHAPE_E = Stream.of(
            Block.makeCuboidShape(15.25, 8, 1.75, 15.5, 8.25, 3),
            Block.makeCuboidShape(0, 0, 0, 1, 6, 1),
            Block.makeCuboidShape(0, 0, 15, 1, 6, 16),
            Block.makeCuboidShape(15, 0, 15, 16, 6, 16),
            Block.makeCuboidShape(15, 0, 0, 16, 6, 1),
            Block.makeCuboidShape(1, 0, 0, 15, 6, 16),
            Block.makeCuboidShape(0, 0, 1, 1, 2, 15),
            Block.makeCuboidShape(0, 6, 15, 16, 29, 16),
            Block.makeCuboidShape(0, 2, 1, 1, 29, 15),
            Block.makeCuboidShape(0, 6, 0, 16, 29, 1),
            Block.makeCuboidShape(0, 29, 0, 16, 30, 16),
            Block.makeCuboidShape(15, 1, 1, 16, 2, 15),
            Block.makeCuboidShape(14, 6, 1, 16, 7, 15),
            Block.makeCuboidShape(15, 4, 6, 16, 4.5, 14),
            Block.makeCuboidShape(15, 2.5, 6, 16, 3, 14),
            Block.makeCuboidShape(15, 3, 13.5, 16, 4, 14),
            Block.makeCuboidShape(15, 3, 6, 16, 4, 6.5),
            Block.makeCuboidShape(2, 6, 6, 14.75, 9, 15),
            Block.makeCuboidShape(1, 7, 1, 15.25, 29, 6),
            Block.makeCuboidShape(1.25, 18, 6, 15.25, 18.5, 15),
            Block.makeCuboidShape(15.25, 21.25, 1.5, 15.5, 22.25, 1.75),
            Block.makeCuboidShape(15.25, 17.05, 2.2, 15.5, 17.65, 2.45),
            Block.makeCuboidShape(15.25, 21.25, 4, 15.5, 22.25, 4.25),
            Block.makeCuboidShape(15.25, 17.05, 4, 15.5, 17.65, 4.25),
            Block.makeCuboidShape(15.25, 22.25, 1.5, 15.5, 22.5, 4.25),
            Block.makeCuboidShape(15.25, 17.65, 2.2, 15.5, 17.9, 4.25),
            Block.makeCuboidShape(15.25, 21, 1.5, 15.5, 21.25, 4.25),
            Block.makeCuboidShape(15.25, 17, 2.2, 15.5, 17.25, 4.25),
            Block.makeCuboidShape(14.5, 20.25, 3.75, 15.5, 20.75, 4.25),
            Block.makeCuboidShape(14.5, 20.25, 3, 15.5, 20.75, 3.5),
            Block.makeCuboidShape(14.5, 20.25, 2.25, 15.5, 20.75, 2.75),
            Block.makeCuboidShape(14.5, 19.5, 3, 15.5, 20, 3.5),
            Block.makeCuboidShape(14.5, 19.5, 3.75, 15.5, 20, 4.25),
            Block.makeCuboidShape(14.5, 19.5, 2.25, 15.5, 20, 2.75),
            Block.makeCuboidShape(14.5, 18.75, 3, 15.5, 19.25, 3.5),
            Block.makeCuboidShape(14.5, 18.75, 3.75, 15.5, 19.25, 4.25),
            Block.makeCuboidShape(14.5, 18.75, 2.25, 15.5, 19.25, 2.75),
            Block.makeCuboidShape(14.5, 18.1, 2.25, 15.5, 18.6, 2.75),
            Block.makeCuboidShape(14.5, 18.1, 3, 15.5, 18.6, 3.5),
            Block.makeCuboidShape(14.5, 18.1, 3.75, 15.5, 18.6, 4.25),
            Block.makeCuboidShape(14.6, 21.25, 1.75, 15.35, 22.25, 4),
            Block.makeCuboidShape(15.25, 8.25, 1.75, 15.5, 9, 2),
            Block.makeCuboidShape(15.25, 8.25, 2.75, 15.5, 9, 3),
            Block.makeCuboidShape(15.25, 9, 1.75, 15.5, 9.25, 3),
            Block.makeCuboidShape(6.75, 12, 7.25, 13.25, 13.5, 13.75),
            Block.makeCuboidShape(9, 13.5, 9.5, 11, 15, 11.5),
            Block.makeCuboidShape(9.125, 13.825, 9.5, 11.125, 14.325, 11.5),
            Block.makeCuboidShape(9, 12.875, 9.5, 11, 13.375, 11.5),
            Block.makeCuboidShape(9, 13.825, 9.325, 11, 14.325, 11.325),
            Block.makeCuboidShape(9, 12.875, 9.5, 11, 13.375, 11.5),
            Block.makeCuboidShape(7, 9, 7.5, 13, 12, 13.5),
            Block.makeCuboidShape(2.75, 21.5, 7.25, 13.25, 23, 13.75),
            Block.makeCuboidShape(7, 23, 9.5, 9, 24.5, 11.5),
            Block.makeCuboidShape(7, 23.325, 9.625, 9, 23.825, 11.625),
            Block.makeCuboidShape(7, 22.375, 9.5, 9, 22.875, 11.5),
            Block.makeCuboidShape(7.175000000000001, 23.325, 9.5, 9.175, 23.825, 11.5),
            Block.makeCuboidShape(7, 22.375, 9.5, 9, 22.875, 11.5),
            Block.makeCuboidShape(3, 18.5, 7.5, 13, 21.5, 13.5)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

    public static final VoxelShape SHAPE_S = Stream.of(
            Block.makeCuboidShape(13, 8, 15.25, 14.25, 8.25, 15.5),
            Block.makeCuboidShape(15, 0, 0, 16, 6, 1),
            Block.makeCuboidShape(0, 0, 0, 1, 6, 1),
            Block.makeCuboidShape(0, 0, 15, 1, 6, 16),
            Block.makeCuboidShape(15, 0, 15, 16, 6, 16),
            Block.makeCuboidShape(0, 0, 1, 16, 6, 15),
            Block.makeCuboidShape(1, 0, 0, 15, 2, 1),
            Block.makeCuboidShape(0, 6, 0, 1, 29, 16),
            Block.makeCuboidShape(1, 2, 0, 15, 29, 1),
            Block.makeCuboidShape(15, 6, 0, 16, 29, 16),
            Block.makeCuboidShape(0, 29, 0, 16, 30, 16),
            Block.makeCuboidShape(1, 1, 15, 15, 2, 16),
            Block.makeCuboidShape(1, 6, 14, 15, 7, 16),
            Block.makeCuboidShape(2, 4, 15, 10, 4.5, 16),
            Block.makeCuboidShape(2, 2.5, 15, 10, 3, 16),
            Block.makeCuboidShape(2, 3, 15, 2.5, 4, 16),
            Block.makeCuboidShape(9.5, 3, 15, 10, 4, 16),
            Block.makeCuboidShape(1, 6, 2, 10, 9, 14.75),
            Block.makeCuboidShape(10, 7, 1, 15, 29, 15.25),
            Block.makeCuboidShape(1, 18, 1.25, 10, 18.5, 15.25),
            Block.makeCuboidShape(14.25, 21.25, 15.25, 14.5, 22.25, 15.5),
            Block.makeCuboidShape(13.55, 17.05, 15.25, 13.8, 17.65, 15.5),
            Block.makeCuboidShape(11.75, 21.25, 15.25, 12, 22.25, 15.5),
            Block.makeCuboidShape(11.75, 17.05, 15.25, 12, 17.65, 15.5),
            Block.makeCuboidShape(11.75, 22.25, 15.25, 14.5, 22.5, 15.5),
            Block.makeCuboidShape(11.75, 17.65, 15.25, 13.8, 17.9, 15.5),
            Block.makeCuboidShape(11.75, 21, 15.25, 14.5, 21.25, 15.5),
            Block.makeCuboidShape(11.75, 17, 15.25, 13.8, 17.25, 15.5),
            Block.makeCuboidShape(11.75, 20.25, 14.5, 12.25, 20.75, 15.5),
            Block.makeCuboidShape(12.5, 20.25, 14.5, 13, 20.75, 15.5),
            Block.makeCuboidShape(13.25, 20.25, 14.5, 13.75, 20.75, 15.5),
            Block.makeCuboidShape(12.5, 19.5, 14.5, 13, 20, 15.5),
            Block.makeCuboidShape(11.75, 19.5, 14.5, 12.25, 20, 15.5),
            Block.makeCuboidShape(13.25, 19.5, 14.5, 13.75, 20, 15.5),
            Block.makeCuboidShape(12.5, 18.75, 14.5, 13, 19.25, 15.5),
            Block.makeCuboidShape(11.75, 18.75, 14.5, 12.25, 19.25, 15.5),
            Block.makeCuboidShape(13.25, 18.75, 14.5, 13.75, 19.25, 15.5),
            Block.makeCuboidShape(13.25, 18.1, 14.5, 13.75, 18.6, 15.5),
            Block.makeCuboidShape(12.5, 18.1, 14.5, 13, 18.6, 15.5),
            Block.makeCuboidShape(11.75, 18.1, 14.5, 12.25, 18.6, 15.5),
            Block.makeCuboidShape(12, 21.25, 14.6, 14.25, 22.25, 15.35),
            Block.makeCuboidShape(14, 8.25, 15.25, 14.25, 9, 15.5),
            Block.makeCuboidShape(13, 8.25, 15.25, 13.25, 9, 15.5),
            Block.makeCuboidShape(13, 9, 15.25, 14.25, 9.25, 15.5),
            Block.makeCuboidShape(2.25, 12, 6.75, 8.75, 13.5, 13.25),
            Block.makeCuboidShape(4.5, 13.5, 9, 6.5, 15, 11),
            Block.makeCuboidShape(4.5, 13.825, 9.125, 6.5, 14.325, 11.125),
            Block.makeCuboidShape(4.5, 12.875, 9, 6.5, 13.375, 11),
            Block.makeCuboidShape(4.675000000000001, 13.825, 9, 6.675000000000001, 14.325, 11),
            Block.makeCuboidShape(4.5, 12.875, 9, 6.5, 13.375, 11),
            Block.makeCuboidShape(2.5, 9, 7, 8.5, 12, 13),
            Block.makeCuboidShape(2.25, 21.5, 2.75, 8.75, 23, 13.25),
            Block.makeCuboidShape(4.5, 23, 7, 6.5, 24.5, 9),
            Block.makeCuboidShape(4.375, 23.325, 7, 6.375, 23.825, 9),
            Block.makeCuboidShape(4.5, 22.375, 7, 6.5, 22.875, 9),
            Block.makeCuboidShape(4.5, 23.325, 7.175000000000001, 6.5, 23.825, 9.175),
            Block.makeCuboidShape(4.5, 22.375, 7, 6.5, 22.875, 9),
            Block.makeCuboidShape(2.5, 18.5, 3, 8.5, 21.5, 13)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

    public static final VoxelShape SHAPE_W = Stream.of(
            Block.makeCuboidShape(0.5, 8, 13, 0.75, 8.25, 14.25),
            Block.makeCuboidShape(15, 0, 15, 16, 6, 16),
            Block.makeCuboidShape(15, 0, 0, 16, 6, 1),
            Block.makeCuboidShape(0, 0, 0, 1, 6, 1),
            Block.makeCuboidShape(0, 0, 15, 1, 6, 16),
            Block.makeCuboidShape(1, 0, 0, 15, 6, 16),
            Block.makeCuboidShape(15, 0, 1, 16, 2, 15),
            Block.makeCuboidShape(0, 6, 0, 16, 29, 1),
            Block.makeCuboidShape(15, 2, 1, 16, 29, 15),
            Block.makeCuboidShape(0, 6, 15, 16, 29, 16),
            Block.makeCuboidShape(0, 29, 0, 16, 30, 16),
            Block.makeCuboidShape(0, 1, 1, 1, 2, 15),
            Block.makeCuboidShape(0, 6, 1, 2, 7, 15),
            Block.makeCuboidShape(0, 4, 2, 1, 4.5, 10),
            Block.makeCuboidShape(0, 2.5, 2, 1, 3, 10),
            Block.makeCuboidShape(0, 3, 2, 1, 4, 2.5),
            Block.makeCuboidShape(0, 3, 9.5, 1, 4, 10),
            Block.makeCuboidShape(1.25, 6, 1, 14, 9, 10),
            Block.makeCuboidShape(0.75, 7, 10, 15, 29, 15),
            Block.makeCuboidShape(0.75, 18, 1, 14.75, 18.5, 10),
            Block.makeCuboidShape(0.5, 21.25, 14.25, 0.75, 22.25, 14.5),
            Block.makeCuboidShape(0.5, 17.05, 13.55, 0.75, 17.65, 13.8),
            Block.makeCuboidShape(0.5, 21.25, 11.75, 0.75, 22.25, 12),
            Block.makeCuboidShape(0.5, 17.05, 11.75, 0.75, 17.65, 12),
            Block.makeCuboidShape(0.5, 22.25, 11.75, 0.75, 22.5, 14.5),
            Block.makeCuboidShape(0.5, 17.65, 11.75, 0.75, 17.9, 13.8),
            Block.makeCuboidShape(0.5, 21, 11.75, 0.75, 21.25, 14.5),
            Block.makeCuboidShape(0.5, 17, 11.75, 0.75, 17.25, 13.8),
            Block.makeCuboidShape(0.5, 20.25, 11.75, 1.5, 20.75, 12.25),
            Block.makeCuboidShape(0.5, 20.25, 12.5, 1.5, 20.75, 13),
            Block.makeCuboidShape(0.5, 20.25, 13.25, 1.5, 20.75, 13.75),
            Block.makeCuboidShape(0.5, 19.5, 12.5, 1.5, 20, 13),
            Block.makeCuboidShape(0.5, 19.5, 11.75, 1.5, 20, 12.25),
            Block.makeCuboidShape(0.5, 19.5, 13.25, 1.5, 20, 13.75),
            Block.makeCuboidShape(0.5, 18.75, 12.5, 1.5, 19.25, 13),
            Block.makeCuboidShape(0.5, 18.75, 11.75, 1.5, 19.25, 12.25),
            Block.makeCuboidShape(0.5, 18.75, 13.25, 1.5, 19.25, 13.75),
            Block.makeCuboidShape(0.5, 18.1, 13.25, 1.5, 18.6, 13.75),
            Block.makeCuboidShape(0.5, 18.1, 12.5, 1.5, 18.6, 13),
            Block.makeCuboidShape(0.5, 18.1, 11.75, 1.5, 18.6, 12.25),
            Block.makeCuboidShape(0.6499999999999986, 21.25, 12, 1.3999999999999986, 22.25, 14.25),
            Block.makeCuboidShape(0.5, 8.25, 14, 0.75, 9, 14.25),
            Block.makeCuboidShape(0.5, 8.25, 13, 0.75, 9, 13.25),
            Block.makeCuboidShape(0.5, 9, 13, 0.75, 9.25, 14.25),
            Block.makeCuboidShape(2.75, 12, 2.25, 9.25, 13.5, 8.75),
            Block.makeCuboidShape(5, 13.5, 4.5, 7, 15, 6.5),
            Block.makeCuboidShape(4.875, 13.825, 4.5, 6.875, 14.325, 6.5),
            Block.makeCuboidShape(5, 12.875, 4.5, 7, 13.375, 6.5),
            Block.makeCuboidShape(5, 13.825, 4.675000000000001, 7, 14.325, 6.675000000000001),
            Block.makeCuboidShape(5, 12.875, 4.5, 7, 13.375, 6.5),
            Block.makeCuboidShape(3, 9, 2.5, 9, 12, 8.5),
            Block.makeCuboidShape(2.75, 21.5, 2.25, 13.25, 23, 8.75),
            Block.makeCuboidShape(7, 23, 4.5, 9, 24.5, 6.5),
            Block.makeCuboidShape(7, 23.325, 4.375, 9, 23.825, 6.375),
            Block.makeCuboidShape(7, 22.375, 4.5, 9, 22.875, 6.5),
            Block.makeCuboidShape(6.824999999999999, 23.325, 4.5, 8.825, 23.825, 6.5),
            Block.makeCuboidShape(7, 22.375, 4.5, 9, 22.875, 6.5),
            Block.makeCuboidShape(3, 18.5, 2.5, 13, 21.5, 8.5)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();


    public Vending_Machine() {
        super(Properties.create(Material.IRON)
                .hardnessAndResistance(3.5f, 4.0f)
                .harvestLevel(0)
                .sound(SoundType.ANVIL)
                .harvestTool(ToolType.PICKAXE)
                .setRequiresTool());
    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        switch (state.get(FACING)) {
            case NORTH:
                return SHAPE_N;
            case EAST:
                return  SHAPE_E;
            case SOUTH:
                return SHAPE_S;
            case WEST:
                return SHAPE_W;
            default:
                return SHAPE_N;
        }
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        return this .getDefaultState().with(FACING, context.getPlacementHorizontalFacing().getOpposite());
    }

    @Override
    public BlockState rotate(BlockState state, Rotation rot) {
        return state.with(FACING, rot.rotate(state.get(FACING)));
    }

    @Override
    public BlockState mirror(BlockState state, Mirror mirrorIn) {
        return state.rotate(mirrorIn.toRotation(state.get(FACING)));
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }
}
