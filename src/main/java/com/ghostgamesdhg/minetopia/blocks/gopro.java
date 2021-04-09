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

public class gopro extends Block {

    private static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;

    private static final VoxelShape SHAPE_N =Stream.of(
            Block.makeCuboidShape(4.41, 5.85, 6.8, 12.61, 6.35, 10),
            Block.makeCuboidShape(4.41, -0.15, 6.8, 12.61, 0.35, 9.7),
            Block.makeCuboidShape(3.81, 0.75, 6.9, 13.21, 5.25, 9.8),
            Block.makeCuboidShape(4.01, 0.25, 6.35, 13.01, 5.75, 10.1),
            Block.makeCuboidShape(4.26, 0, 6.6, 12.76, 6, 10.55),
            Block.makeCuboidShape(7.76, 3.5, 6, 7.96, 4.1, 7),
            Block.makeCuboidShape(5.26, 3.6, 6, 5.46, 4.2, 7),
            Block.makeCuboidShape(8.16, 6.1, 6, 8.36, 6.7, 7),
            Block.makeCuboidShape(5.86, 5.1, 6, 6.06, 5.8, 7),
            Block.makeCuboidShape(7.56, 8.6, 6, 7.76, 9.2, 7),
            Block.makeCuboidShape(1.36, 4.8, 6, 1.86, 5, 7),
            Block.makeCuboidShape(3.06, 3, 6, 3.56, 3.2, 7),
            Block.makeCuboidShape(6.56, 5.8, 6, 6.76, 6.4, 7),
            Block.makeCuboidShape(8.86, 4.8, 6, 9.06, 5.3, 7),
            Block.makeCuboidShape(3.76, 5.4, 6, 4.36, 5.6, 7),
            Block.makeCuboidShape(4.76, 3.1, 6, 5.36, 3.3, 7),
            Block.makeCuboidShape(5.76, 6.9, 6, 5.96, 7.4, 7),
            Block.makeCuboidShape(8.46, 3.7, 6, 9.06, 3.9, 7),
            Block.makeCuboidShape(7.56, 1.4, 6, 8.16, 1.6, 7),
            Block.makeCuboidShape(4.76, 2.5, 6.2, 8.36, 5.2, 7.2),
            Block.makeCuboidShape(9.96, 3.3, 6.3, 11.76, 5.2, 7.3),
            Block.makeCuboidShape(6.36, 5, 6, 6.86, 5.2, 7),
            Block.makeCuboidShape(4.56, 2.5, 6, 4.76, 5.2, 7),
            Block.makeCuboidShape(4.56, 1.1, 9.7, 4.76, 5.2, 10.7),
            Block.makeCuboidShape(9.86, 3.3, 6, 10.06, 5.2, 7),
            Block.makeCuboidShape(11.66, 3.3, 6, 11.86, 5.2, 7),
            Block.makeCuboidShape(8.36, 2.5, 6, 8.56, 5.2, 7),
            Block.makeCuboidShape(10.56, 1.1, 9.7, 10.76, 5.2, 10.7),
            Block.makeCuboidShape(4.76, 6.3, 7.1, 5.96, 6.5, 7.9),
            Block.makeCuboidShape(4.96, 6.5, 7.2, 5.76, 6.7, 7.8),
            Block.makeCuboidShape(4.96, 6.3, 6.9, 5.76, 6.5, 8.1),
            Block.makeCuboidShape(4.86, 6.3, 7, 5.86, 6.6, 8),
            Block.makeCuboidShape(11.66, 1.8, 6.1, 12.16, 2.2, 6.7),
            Block.makeCuboidShape(11.66, 4.9, 10, 12.16, 5.3, 10.6),
            Block.makeCuboidShape(13.56, 1.5, 10, 13.66, 2, 10.6),
            Block.makeCuboidShape(11.96, 2.1, 10, 12.46, 2.2, 10.6),
            Block.makeCuboidShape(10.96, 2.1, 10, 11.46, 2.2, 10.6),
            Block.makeCuboidShape(11.16, 1.9, 10, 11.26, 2.4, 10.6),
            Block.makeCuboidShape(11.66, 2.9, 10, 12.16, 3.3, 10.6),
            Block.makeCuboidShape(11.66, 3.9, 10, 12.16, 4.3, 10.6),
            Block.makeCuboidShape(11.36, 6.2, 7, 11.46, 6.5, 7.7),
            Block.makeCuboidShape(7.36, 6.2, 7.4, 8.06, 6.5, 7.5),
            Block.makeCuboidShape(8.66, 6.2, 7.4, 9.36, 6.5, 7.5),
            Block.makeCuboidShape(8.96, 6.2, 7.1, 9.06, 6.5, 7.8),
            Block.makeCuboidShape(9.86, 6.3, 7, 11.86, 6.6, 8),
            Block.makeCuboidShape(9.86, 5.2, 6, 11.86, 5.4, 7),
            Block.makeCuboidShape(9.86, 3.1, 6, 11.86, 3.3, 7),
            Block.makeCuboidShape(4.56, 0.9, 9.7, 10.76, 1.1, 10.7),
            Block.makeCuboidShape(4.56, 2.3, 6, 8.56, 2.5, 7),
            Block.makeCuboidShape(4.56, 5.2, 6, 8.56, 5.4, 7),
            Block.makeCuboidShape(4.76, 1.1, 9.6, 10.56, 5.2, 10.6),
            Block.makeCuboidShape(4.56, 5.2, 9.7, 10.76, 5.4, 10.7),
            Block.makeCuboidShape(6.16, 4.9, 6.1, 7.06, 5.1, 7),
            Block.makeCuboidShape(5.76, 4.6, 6.1, 7.46, 4.9, 7),
            Block.makeCuboidShape(5.46, 4.3, 6.1, 7.66, 4.6, 7),
            Block.makeCuboidShape(5.96, 2.7, 6.1, 7.26, 2.9, 7),
            Block.makeCuboidShape(5.66, 2.9, 6.1, 7.56, 3.2, 7),
            Block.makeCuboidShape(5.46, 3.2, 6.1, 7.76, 3.4, 7),
            Block.makeCuboidShape(5.46, 3.4, 6.1, 7.76, 4.3, 7),
            Block.makeCuboidShape(6.36, 2.5, 6, 6.96, 2.7, 7)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

    public static final VoxelShape SHAPE_E = Stream.of(
            Block.makeCuboidShape(5.5624999999999964, 5.85, 4.41, 8.762499999999996, 6.35, 12.61),
            Block.makeCuboidShape(5.862499999999997, -0.15, 4.41, 8.762499999999996, 0.35, 12.61),
            Block.makeCuboidShape(5.762499999999996, 0.75, 3.8100000000000005, 8.662499999999994, 5.25, 13.21),
            Block.makeCuboidShape(5.462499999999999, 0.25, 4.01, 9.212499999999999, 5.75, 13.01),
            Block.makeCuboidShape(5.012499999999996, 0, 4.26, 8.962499999999999, 6, 12.76),
            Block.makeCuboidShape(8.562499999999996, 3.5, 7.76, 9.562499999999996, 4.1, 7.960000000000001),
            Block.makeCuboidShape(8.562499999999996, 3.6, 5.26, 9.562499999999996, 4.2, 5.460000000000001),
            Block.makeCuboidShape(8.562499999999996, 6.1, 8.16, 9.562499999999996, 6.7, 8.36),
            Block.makeCuboidShape(8.562499999999996, 5.1, 5.859999999999999, 9.562499999999996, 5.8, 6.059999999999999),
            Block.makeCuboidShape(8.562499999999996, 8.6, 7.559999999999999, 9.562499999999996, 9.2, 7.76),
            Block.makeCuboidShape(8.562499999999996, 4.8, 1.3599999999999994, 9.562499999999996, 5, 1.8599999999999994),
            Block.makeCuboidShape(8.562499999999996, 3, 3.0599999999999987, 9.562499999999996, 3.2, 3.5600000000000005),
            Block.makeCuboidShape(8.562499999999996, 5.8, 6.559999999999999, 9.562499999999996, 6.4, 6.76),
            Block.makeCuboidShape(8.562499999999996, 4.8, 8.86, 9.562499999999996, 5.3, 9.06),
            Block.makeCuboidShape(8.562499999999996, 5.4, 3.76, 9.562499999999996, 5.6, 4.359999999999999),
            Block.makeCuboidShape(8.562499999999996, 3.1, 4.76, 9.562499999999996, 3.3, 5.359999999999999),
            Block.makeCuboidShape(8.562499999999996, 6.9, 5.76, 9.562499999999996, 7.4, 5.960000000000001),
            Block.makeCuboidShape(8.562499999999996, 3.7, 8.46, 9.562499999999996, 3.9, 9.06),
            Block.makeCuboidShape(8.562499999999996, 1.4, 7.559999999999999, 9.562499999999996, 1.6, 8.16),
            Block.makeCuboidShape(8.362499999999997, 2.5, 4.76, 9.362499999999997, 5.2, 8.36),
            Block.makeCuboidShape(8.262499999999996, 3.3, 9.96, 9.262499999999996, 5.2, 11.76),
            Block.makeCuboidShape(8.562499999999996, 5, 6.359999999999999, 9.562499999999996, 5.2, 6.859999999999999),
            Block.makeCuboidShape(8.562499999999996, 2.5, 4.559999999999999, 9.562499999999996, 5.2, 4.76),
            Block.makeCuboidShape(4.862499999999997, 1.1, 4.559999999999999, 5.862499999999997, 5.2, 4.76),
            Block.makeCuboidShape(8.562499999999996, 3.3, 9.86, 9.562499999999996, 5.2, 10.06),
            Block.makeCuboidShape(8.562499999999996, 3.3, 11.66, 9.562499999999996, 5.2, 11.86),
            Block.makeCuboidShape(8.562499999999996, 2.5, 8.36, 9.562499999999996, 5.2, 8.56),
            Block.makeCuboidShape(4.862499999999997, 1.1, 10.56, 5.862499999999997, 5.2, 10.76),
            Block.makeCuboidShape(7.662499999999994, 6.3, 4.76, 8.462499999999999, 6.5, 5.960000000000001),
            Block.makeCuboidShape(7.762499999999996, 6.5, 4.960000000000001, 8.362499999999997, 6.7, 5.76),
            Block.makeCuboidShape(7.462499999999999, 6.3, 4.960000000000001, 8.662499999999994, 6.5, 5.76),
            Block.makeCuboidShape(7.5624999999999964, 6.3, 4.859999999999999, 8.562499999999996, 6.6, 5.859999999999999),
            Block.makeCuboidShape(8.862499999999997, 1.8, 11.66, 9.462499999999999, 2.2, 12.16),
            Block.makeCuboidShape(4.962499999999997, 4.9, 11.66, 5.5624999999999964, 5.3, 12.16),
            Block.makeCuboidShape(4.962499999999997, 1.5, 13.56, 5.5624999999999964, 2, 13.66),
            Block.makeCuboidShape(4.962499999999997, 2.1, 11.96, 5.5624999999999964, 2.2, 12.46),
            Block.makeCuboidShape(4.962499999999997, 2.1, 10.96, 5.5624999999999964, 2.2, 11.46),
            Block.makeCuboidShape(4.962499999999997, 1.9, 11.16, 5.5624999999999964, 2.4, 11.26),
            Block.makeCuboidShape(4.962499999999997, 2.9, 11.66, 5.5624999999999964, 3.3, 12.16),
            Block.makeCuboidShape(4.962499999999997, 3.9, 11.66, 5.5624999999999964, 4.3, 12.16),
            Block.makeCuboidShape(7.862499999999997, 6.2, 11.36, 8.562499999999996, 6.5, 11.46),
            Block.makeCuboidShape(8.062499999999996, 6.2, 7.359999999999999, 8.162499999999994, 6.5, 8.06),
            Block.makeCuboidShape(8.062499999999996, 6.2, 8.66, 8.162499999999994, 6.5, 9.36),
            Block.makeCuboidShape(7.762499999999996, 6.2, 8.96, 8.462499999999999, 6.5, 9.06),
            Block.makeCuboidShape(7.5624999999999964, 6.3, 9.86, 8.562499999999996, 6.6, 11.86),
            Block.makeCuboidShape(8.562499999999996, 5.2, 9.86, 9.562499999999996, 5.4, 11.86),
            Block.makeCuboidShape(8.562499999999996, 3.1, 9.86, 9.562499999999996, 3.3, 11.86),
            Block.makeCuboidShape(4.862499999999997, 0.9, 4.559999999999999, 5.862499999999997, 1.1, 10.76),
            Block.makeCuboidShape(8.562499999999996, 2.3, 4.559999999999999, 9.562499999999996, 2.5, 8.56),
            Block.makeCuboidShape(8.562499999999996, 5.2, 4.559999999999999, 9.562499999999996, 5.4, 8.56),
            Block.makeCuboidShape(4.962499999999997, 1.1, 4.76, 5.962499999999999, 5.2, 10.56),
            Block.makeCuboidShape(4.862499999999997, 5.2, 4.559999999999999, 5.862499999999997, 5.4, 10.76),
            Block.makeCuboidShape(8.562499999999996, 4.9, 6.16, 9.462499999999999, 5.1, 7.059999999999999),
            Block.makeCuboidShape(8.562499999999996, 4.6, 5.76, 9.462499999999999, 4.9, 7.460000000000001),
            Block.makeCuboidShape(8.562499999999996, 4.3, 5.460000000000001, 9.462499999999999, 4.6, 7.66),
            Block.makeCuboidShape(8.562499999999996, 2.7, 5.960000000000001, 9.462499999999999, 2.9, 7.26),
            Block.makeCuboidShape(8.562499999999996, 2.9, 5.66, 9.462499999999999, 3.2, 7.559999999999999),
            Block.makeCuboidShape(8.562499999999996, 3.2, 5.460000000000001, 9.462499999999999, 3.4, 7.76),
            Block.makeCuboidShape(8.562499999999996, 3.4, 5.460000000000001, 9.462499999999999, 4.3, 7.76),
            Block.makeCuboidShape(8.562499999999996, 2.5, 6.359999999999999, 9.562499999999996, 2.7, 6.960000000000001)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

    public static final VoxelShape SHAPE_S = Stream.of(
            Block.makeCuboidShape(3.3899999999999935, 5.85, 5.5624999999999964, 11.589999999999993, 6.35, 8.762499999999996),
            Block.makeCuboidShape(3.3899999999999935, -0.15, 5.862499999999997, 11.589999999999993, 0.35, 8.762499999999996),
            Block.makeCuboidShape(2.789999999999992, 0.75, 5.762499999999996, 12.18999999999999, 5.25, 8.662499999999994),
            Block.makeCuboidShape(2.989999999999993, 0.25, 5.462499999999999, 11.989999999999995, 5.75, 9.212499999999999),
            Block.makeCuboidShape(3.239999999999993, 0, 5.012499999999996, 11.739999999999995, 6, 8.962499999999999),
            Block.makeCuboidShape(8.039999999999992, 3.5, 8.562499999999996, 8.239999999999995, 4.1, 9.562499999999996),
            Block.makeCuboidShape(10.539999999999992, 3.6, 8.562499999999996, 10.739999999999995, 4.2, 9.562499999999996),
            Block.makeCuboidShape(7.6399999999999935, 6.1, 8.562499999999996, 7.839999999999993, 6.7, 9.562499999999996),
            Block.makeCuboidShape(9.939999999999994, 5.1, 8.562499999999996, 10.139999999999993, 5.8, 9.562499999999996),
            Block.makeCuboidShape(8.239999999999995, 8.6, 8.562499999999996, 8.439999999999994, 9.2, 9.562499999999996),
            Block.makeCuboidShape(14.139999999999993, 4.8, 8.562499999999996, 14.639999999999993, 5, 9.562499999999996),
            Block.makeCuboidShape(12.43999999999999, 3, 8.562499999999996, 12.939999999999994, 3.2, 9.562499999999996),
            Block.makeCuboidShape(9.239999999999995, 5.8, 8.562499999999996, 9.439999999999994, 6.4, 9.562499999999996),
            Block.makeCuboidShape(6.939999999999991, 4.8, 8.562499999999996, 7.1399999999999935, 5.3, 9.562499999999996),
            Block.makeCuboidShape(11.639999999999993, 5.4, 8.562499999999996, 12.239999999999995, 5.6, 9.562499999999996),
            Block.makeCuboidShape(10.639999999999993, 3.1, 8.562499999999996, 11.239999999999995, 3.3, 9.562499999999996),
            Block.makeCuboidShape(10.039999999999992, 6.9, 8.562499999999996, 10.239999999999995, 7.4, 9.562499999999996),
            Block.makeCuboidShape(6.939999999999991, 3.7, 8.562499999999996, 7.539999999999992, 3.9, 9.562499999999996),
            Block.makeCuboidShape(7.839999999999993, 1.4, 8.562499999999996, 8.439999999999994, 1.6, 9.562499999999996),
            Block.makeCuboidShape(7.6399999999999935, 2.5, 8.362499999999997, 11.239999999999995, 5.2, 9.362499999999997),
            Block.makeCuboidShape(4.239999999999995, 3.3, 8.262499999999996, 6.039999999999992, 5.2, 9.262499999999996),
            Block.makeCuboidShape(9.139999999999993, 5, 8.562499999999996, 9.639999999999993, 5.2, 9.562499999999996),
            Block.makeCuboidShape(11.239999999999995, 2.5, 8.562499999999996, 11.439999999999994, 5.2, 9.562499999999996),
            Block.makeCuboidShape(11.239999999999995, 1.1, 4.862499999999997, 11.439999999999994, 5.2, 5.862499999999997),
            Block.makeCuboidShape(5.939999999999991, 3.3, 8.562499999999996, 6.1399999999999935, 5.2, 9.562499999999996),
            Block.makeCuboidShape(4.1399999999999935, 3.3, 8.562499999999996, 4.339999999999993, 5.2, 9.562499999999996),
            Block.makeCuboidShape(7.439999999999991, 2.5, 8.562499999999996, 7.6399999999999935, 5.2, 9.562499999999996),
            Block.makeCuboidShape(5.239999999999995, 1.1, 4.862499999999997, 5.439999999999991, 5.2, 5.862499999999997),
            Block.makeCuboidShape(10.039999999999992, 6.3, 7.662499999999994, 11.239999999999995, 6.5, 8.462499999999999),
            Block.makeCuboidShape(10.239999999999995, 6.5, 7.762499999999996, 11.039999999999992, 6.7, 8.362499999999997),
            Block.makeCuboidShape(10.239999999999995, 6.3, 7.462499999999999, 11.039999999999992, 6.5, 8.662499999999994),
            Block.makeCuboidShape(10.139999999999993, 6.3, 7.5624999999999964, 11.139999999999993, 6.6, 8.562499999999996),
            Block.makeCuboidShape(3.8399999999999928, 1.8, 8.862499999999997, 4.339999999999993, 2.2, 9.462499999999999),
            Block.makeCuboidShape(3.8399999999999928, 4.9, 4.962499999999997, 4.339999999999993, 5.3, 5.5624999999999964),
            Block.makeCuboidShape(2.3399999999999928, 1.5, 4.962499999999997, 2.4399999999999924, 2, 5.5624999999999964),
            Block.makeCuboidShape(3.539999999999992, 2.1, 4.962499999999997, 4.039999999999992, 2.2, 5.5624999999999964),
            Block.makeCuboidShape(4.539999999999992, 2.1, 4.962499999999997, 5.039999999999992, 2.2, 5.5624999999999964),
            Block.makeCuboidShape(4.739999999999995, 1.9, 4.962499999999997, 4.839999999999993, 2.4, 5.5624999999999964),
            Block.makeCuboidShape(3.8399999999999928, 2.9, 4.962499999999997, 4.339999999999993, 3.3, 5.5624999999999964),
            Block.makeCuboidShape(3.8399999999999928, 3.9, 4.962499999999997, 4.339999999999993, 4.3, 5.5624999999999964),
            Block.makeCuboidShape(4.539999999999992, 6.2, 7.862499999999997, 4.6399999999999935, 6.5, 8.562499999999996),
            Block.makeCuboidShape(7.939999999999991, 6.2, 8.062499999999996, 8.639999999999993, 6.5, 8.162499999999994),
            Block.makeCuboidShape(6.6399999999999935, 6.2, 8.062499999999996, 7.339999999999993, 6.5, 8.162499999999994),
            Block.makeCuboidShape(6.939999999999991, 6.2, 7.762499999999996, 7.039999999999992, 6.5, 8.462499999999999),
            Block.makeCuboidShape(4.1399999999999935, 6.3, 7.5624999999999964, 6.1399999999999935, 6.6, 8.562499999999996),
            Block.makeCuboidShape(4.1399999999999935, 5.2, 8.562499999999996, 6.1399999999999935, 5.4, 9.562499999999996),
            Block.makeCuboidShape(4.1399999999999935, 3.1, 8.562499999999996, 6.1399999999999935, 3.3, 9.562499999999996),
            Block.makeCuboidShape(5.239999999999995, 0.9, 4.862499999999997, 11.439999999999994, 1.1, 5.862499999999997),
            Block.makeCuboidShape(7.439999999999991, 2.3, 8.562499999999996, 11.439999999999994, 2.5, 9.562499999999996),
            Block.makeCuboidShape(7.439999999999991, 5.2, 8.562499999999996, 11.439999999999994, 5.4, 9.562499999999996),
            Block.makeCuboidShape(5.439999999999991, 1.1, 4.962499999999997, 11.239999999999995, 5.2, 5.962499999999999),
            Block.makeCuboidShape(5.239999999999995, 5.2, 4.862499999999997, 11.439999999999994, 5.4, 5.862499999999997),
            Block.makeCuboidShape(8.939999999999994, 4.9, 8.562499999999996, 9.839999999999993, 5.1, 9.462499999999999),
            Block.makeCuboidShape(8.539999999999992, 4.6, 8.562499999999996, 10.239999999999995, 4.9, 9.462499999999999),
            Block.makeCuboidShape(8.339999999999993, 4.3, 8.562499999999996, 10.539999999999992, 4.6, 9.462499999999999),
            Block.makeCuboidShape(8.739999999999995, 2.7, 8.562499999999996, 10.039999999999992, 2.9, 9.462499999999999),
            Block.makeCuboidShape(8.439999999999994, 2.9, 8.562499999999996, 10.339999999999993, 3.2, 9.462499999999999),
            Block.makeCuboidShape(8.239999999999995, 3.2, 8.562499999999996, 10.539999999999992, 3.4, 9.462499999999999),
            Block.makeCuboidShape(8.239999999999995, 3.4, 8.562499999999996, 10.539999999999992, 4.3, 9.462499999999999),
            Block.makeCuboidShape(9.039999999999992, 2.5, 8.562499999999996, 9.639999999999993, 2.7, 9.562499999999996)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

    public static final VoxelShape SHAPE_W = Stream.of(
            Block.makeCuboidShape(7.237500000000001, 5.85, 3.3899999999999935, 10.4375, 6.35, 11.589999999999993),
            Block.makeCuboidShape(7.237500000000001, -0.15, 3.3899999999999935, 10.1375, 0.35, 11.589999999999993),
            Block.makeCuboidShape(7.337500000000002, 0.75, 2.789999999999992, 10.2375, 5.25, 12.18999999999999),
            Block.makeCuboidShape(6.787499999999998, 0.25, 2.989999999999993, 10.537499999999998, 5.75, 11.989999999999995),
            Block.makeCuboidShape(7.037499999999998, 0, 3.239999999999993, 10.9875, 6, 11.739999999999995),
            Block.makeCuboidShape(6.4375, 3.5, 8.039999999999992, 7.4375, 4.1, 8.239999999999995),
            Block.makeCuboidShape(6.4375, 3.6, 10.539999999999992, 7.4375, 4.2, 10.739999999999995),
            Block.makeCuboidShape(6.4375, 6.1, 7.6399999999999935, 7.4375, 6.7, 7.839999999999993),
            Block.makeCuboidShape(6.4375, 5.1, 9.939999999999994, 7.4375, 5.8, 10.139999999999993),
            Block.makeCuboidShape(6.4375, 8.6, 8.239999999999995, 7.4375, 9.2, 8.439999999999994),
            Block.makeCuboidShape(6.4375, 4.8, 14.139999999999993, 7.4375, 5, 14.639999999999993),
            Block.makeCuboidShape(6.4375, 3, 12.43999999999999, 7.4375, 3.2, 12.939999999999994),
            Block.makeCuboidShape(6.4375, 5.8, 9.239999999999995, 7.4375, 6.4, 9.439999999999994),
            Block.makeCuboidShape(6.4375, 4.8, 6.939999999999991, 7.4375, 5.3, 7.1399999999999935),
            Block.makeCuboidShape(6.4375, 5.4, 11.639999999999993, 7.4375, 5.6, 12.239999999999995),
            Block.makeCuboidShape(6.4375, 3.1, 10.639999999999993, 7.4375, 3.3, 11.239999999999995),
            Block.makeCuboidShape(6.4375, 6.9, 10.039999999999992, 7.4375, 7.4, 10.239999999999995),
            Block.makeCuboidShape(6.4375, 3.7, 6.939999999999991, 7.4375, 3.9, 7.539999999999992),
            Block.makeCuboidShape(6.4375, 1.4, 7.839999999999993, 7.4375, 1.6, 8.439999999999994),
            Block.makeCuboidShape(6.637499999999999, 2.5, 7.6399999999999935, 7.637499999999999, 5.2, 11.239999999999995),
            Block.makeCuboidShape(6.737500000000001, 3.3, 4.239999999999995, 7.737500000000001, 5.2, 6.039999999999992),
            Block.makeCuboidShape(6.4375, 5, 9.139999999999993, 7.4375, 5.2, 9.639999999999993),
            Block.makeCuboidShape(6.4375, 2.5, 11.239999999999995, 7.4375, 5.2, 11.439999999999994),
            Block.makeCuboidShape(10.1375, 1.1, 11.239999999999995, 11.1375, 5.2, 11.439999999999994),
            Block.makeCuboidShape(6.4375, 3.3, 5.939999999999991, 7.4375, 5.2, 6.1399999999999935),
            Block.makeCuboidShape(6.4375, 3.3, 4.1399999999999935, 7.4375, 5.2, 4.339999999999993),
            Block.makeCuboidShape(6.4375, 2.5, 7.439999999999991, 7.4375, 5.2, 7.6399999999999935),
            Block.makeCuboidShape(10.1375, 1.1, 5.239999999999995, 11.1375, 5.2, 5.439999999999991),
            Block.makeCuboidShape(7.537499999999998, 6.3, 10.039999999999992, 8.337500000000002, 6.5, 11.239999999999995),
            Block.makeCuboidShape(7.637499999999999, 6.5, 10.239999999999995, 8.2375, 6.7, 11.039999999999992),
            Block.makeCuboidShape(7.337500000000002, 6.3, 10.239999999999995, 8.537499999999998, 6.5, 11.039999999999992),
            Block.makeCuboidShape(7.4375, 6.3, 10.139999999999993, 8.4375, 6.6, 11.139999999999993),
            Block.makeCuboidShape(6.537499999999998, 1.8, 3.8399999999999928, 7.137499999999999, 2.2, 4.339999999999993),
            Block.makeCuboidShape(10.4375, 4.9, 3.8399999999999928, 11.0375, 5.3, 4.339999999999993),
            Block.makeCuboidShape(10.4375, 1.5, 2.3399999999999928, 11.0375, 2, 2.4399999999999924),
            Block.makeCuboidShape(10.4375, 2.1, 3.539999999999992, 11.0375, 2.2, 4.039999999999992),
            Block.makeCuboidShape(10.4375, 2.1, 4.539999999999992, 11.0375, 2.2, 5.039999999999992),
            Block.makeCuboidShape(10.4375, 1.9, 4.739999999999995, 11.0375, 2.4, 4.839999999999993),
            Block.makeCuboidShape(10.4375, 2.9, 3.8399999999999928, 11.0375, 3.3, 4.339999999999993),
            Block.makeCuboidShape(10.4375, 3.9, 3.8399999999999928, 11.0375, 4.3, 4.339999999999993),
            Block.makeCuboidShape(7.4375, 6.2, 4.539999999999992, 8.1375, 6.5, 4.6399999999999935),
            Block.makeCuboidShape(7.837500000000002, 6.2, 7.939999999999991, 7.9375, 6.5, 8.639999999999993),
            Block.makeCuboidShape(7.837500000000002, 6.2, 6.6399999999999935, 7.9375, 6.5, 7.339999999999993),
            Block.makeCuboidShape(7.537499999999998, 6.2, 6.939999999999991, 8.2375, 6.5, 7.039999999999992),
            Block.makeCuboidShape(7.4375, 6.3, 4.1399999999999935, 8.4375, 6.6, 6.1399999999999935),
            Block.makeCuboidShape(6.4375, 5.2, 4.1399999999999935, 7.4375, 5.4, 6.1399999999999935),
            Block.makeCuboidShape(6.4375, 3.1, 4.1399999999999935, 7.4375, 3.3, 6.1399999999999935),
            Block.makeCuboidShape(10.1375, 0.9, 5.239999999999995, 11.1375, 1.1, 11.439999999999994),
            Block.makeCuboidShape(6.4375, 2.3, 7.439999999999991, 7.4375, 2.5, 11.439999999999994),
            Block.makeCuboidShape(6.4375, 5.2, 7.439999999999991, 7.4375, 5.4, 11.439999999999994),
            Block.makeCuboidShape(10.037499999999998, 1.1, 5.439999999999991, 11.0375, 5.2, 11.239999999999995),
            Block.makeCuboidShape(10.1375, 5.2, 5.239999999999995, 11.1375, 5.4, 11.439999999999994),
            Block.makeCuboidShape(6.537499999999998, 4.9, 8.939999999999994, 7.4375, 5.1, 9.839999999999993),
            Block.makeCuboidShape(6.537499999999998, 4.6, 8.539999999999992, 7.4375, 4.9, 10.239999999999995),
            Block.makeCuboidShape(6.537499999999998, 4.3, 8.339999999999993, 7.4375, 4.6, 10.539999999999992),
            Block.makeCuboidShape(6.537499999999998, 2.7, 8.739999999999995, 7.4375, 2.9, 10.039999999999992),
            Block.makeCuboidShape(6.537499999999998, 2.9, 8.439999999999994, 7.4375, 3.2, 10.339999999999993),
            Block.makeCuboidShape(6.537499999999998, 3.2, 8.239999999999995, 7.4375, 3.4, 10.539999999999992),
            Block.makeCuboidShape(6.537499999999998, 3.4, 8.239999999999995, 7.4375, 4.3, 10.539999999999992),
            Block.makeCuboidShape(6.4375, 2.5, 9.039999999999992, 7.4375, 2.7, 9.639999999999993)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

    public gopro() {
        super(Properties.create(Material.IRON)
                .hardnessAndResistance(3.5f, 4.0f)
                .harvestLevel(0)
                .sound(SoundType.ANVIL));
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
