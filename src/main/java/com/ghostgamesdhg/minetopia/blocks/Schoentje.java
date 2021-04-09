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

public class Schoentje extends Block {

    private static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;
    private static final VoxelShape SHAPE_N = Stream.of(
            Block.makeCuboidShape(5.00059523809524, 0.75, 12, 6.25059523809524, 2.5, 13.25),
            Block.makeCuboidShape(7.00059523809524, 2.5, 5.75, 7.25059523809524, 2.75, 6.25),
            Block.makeCuboidShape(6.25059523809524, 0.75, 3.25, 10.25059523809524, 1.75, 14.25),
            Block.makeCuboidShape(6.75059523809524, 1.75, 3.75, 9.75059523809524, 2.5, 6.25),
            Block.makeCuboidShape(6.50059523809524, 1.75, 6.25, 10.00059523809524, 2.75, 8.75),
            Block.makeCuboidShape(6.25059523809524, 1.75, 8.75, 10.25059523809524, 3.5, 14.25),
            Block.makeCuboidShape(6.50059523809524, 3.5, 9.25, 10.00059523809524, 4.5, 14.25),
            Block.makeCuboidShape(6.50059523809524, 4.5, 9.75, 10.00059523809524, 5, 10.5),
            Block.makeCuboidShape(6.50059523809524, 4.5, 10.75, 10.00059523809524, 4.75, 14),
            Block.makeCuboidShape(6.50059523809524, 4.5, 10.475000000000001, 10.00059523809524, 6, 10.75),
            Block.makeCuboidShape(6.50059523809524, 4.5, 13.75, 10.00059523809524, 5.75, 14.25),
            Block.makeCuboidShape(10.25059523809524, 0.75, 4.75, 10.75059523809524, 1.5, 9.75),
            Block.makeCuboidShape(5.75059523809524, 1.5, 7.5, 7.25059523809524, 2.25, 9.75),
            Block.makeCuboidShape(9.25059523809524, 1.5, 7.5, 10.75059523809524, 2.25, 9.75),
            Block.makeCuboidShape(10.25059523809524, 0.75, 9.75, 11.00059523809524, 3.5, 14.25),
            Block.makeCuboidShape(9.975595238095242, 3.5, 10.75, 10.550595238095237, 5.75, 14),
            Block.makeCuboidShape(5.925595238095241, 3.5, 10.75, 6.50059523809524, 5.75, 14),
            Block.makeCuboidShape(6.25059523809524, 3.5, 10, 6.50059523809524, 4.25, 10.75),
            Block.makeCuboidShape(6.75059523809524, 2.75, 6.5, 7.00059523809524, 3, 8.75),
            Block.makeCuboidShape(6.75059523809524, 3, 8.5, 7.00059523809524, 3.5, 8.75),
            Block.makeCuboidShape(9.50059523809524, 3.5, 9, 9.75059523809524, 4.25, 9.25),
            Block.makeCuboidShape(6.75059523809524, 3.5, 9, 7.00059523809524, 4.25, 9.25),
            Block.makeCuboidShape(6.75059523809524, 4.5, 9.5, 7.00059523809524, 4.925, 9.75),
            Block.makeCuboidShape(6.75059523809524, 5, 10.25, 7.00059523809524, 5.425, 10.5),
            Block.makeCuboidShape(9.50059523809524, 5, 10.25, 9.75059523809524, 5.425, 10.5),
            Block.makeCuboidShape(9.50059523809524, 5, 9.899999999999999, 9.75059523809524, 5.175, 10.25),
            Block.makeCuboidShape(6.75059523809524, 5, 9.899999999999999, 7.00059523809524, 5.175, 10.25),
            Block.makeCuboidShape(9.50059523809524, 4.5, 9.5, 9.75059523809524, 4.925, 9.75),
            Block.makeCuboidShape(9.50059523809524, 3, 8.5, 9.75059523809524, 3.5, 8.75),
            Block.makeCuboidShape(9.50059523809524, 2.75, 6.5, 9.75059523809524, 3, 8.75),
            Block.makeCuboidShape(9.25059523809524, 2.5, 5.75, 9.50059523809524, 2.75, 6.25),
            Block.makeCuboidShape(5.75059523809524, 0.75, 4.75, 6.25059523809524, 1.5, 9.75),
            Block.makeCuboidShape(5.50059523809524, 0.75, 9.75, 6.25059523809524, 3.5, 14.25),
            Block.makeCuboidShape(6.25059523809524, 0.75, 14, 10.25059523809524, 4, 14.75),
            Block.makeCuboidShape(3.3255952380952394, 3.4000000000000004, 11.7, 5.150595238095239, 4.4, 13.5),
            Block.makeCuboidShape(3.925595238095241, 2.15, 11.8, 5.575595238095239, 4.9, 13.399999999999999),
            Block.makeCuboidShape(6.325595238095239, 4.1, 9.5, 6.650595238095239, 5.15, 9.75),
            Block.makeCuboidShape(5.950595238095239, 11.35, 21, 6.275595238095239, 12.15, 21.25),
            Block.makeCuboidShape(5.700595238095239, 11.85, 21, 6.025595238095239, 12.65, 21.25),
            Block.makeCuboidShape(9.950595238095243, 9.85, 12.5, 10.275595238095239, 11.15, 12.75),
            Block.makeCuboidShape(10.25059523809524, 0, 4.625, 10.900595238095239, 0.75, 9.75),
            Block.makeCuboidShape(5.575595238095239, 0, 4.574999999999999, 6.25059523809524, 0.75, 9.75),
            Block.makeCuboidShape(5.300595238095241, 0, 9.575, 6.25059523809524, 0.75, 14.425),
            Block.makeCuboidShape(10.25059523809524, 0, 9.575, 11.175595238095237, 0.75, 14.425),
            Block.makeCuboidShape(6.050595238095241, 0, 4.574999999999999, 10.400595238095239, 0.75, 14.925),
            Block.makeCuboidShape(6.050595238095241, 0, 3.0749999999999993, 10.400595238095239, 0.75, 4.574999999999999),
            Block.makeCuboidShape(5.190495238095242, 1.3963099999999997, 10.8625, 5.2904952380952395, 1.8963099999999997, 10.962499999999999),
            Block.makeCuboidShape(5.471905238095243, 5.12263, 10.850000000000001, 6.471905238095243, 5.24763, 10.975000000000001),
            Block.makeCuboidShape(11.310695238095239, 1.7463100000000003, 10.8625, 11.41069523809524, 2.24631, 10.962499999999999),
            Block.makeCuboidShape(10.129285238095239, 5.47263, 10.850000000000001, 11.129285238095239, 5.59763, 10.975000000000001),
            Block.makeCuboidShape(10.998225238095241, 3.72131, 10.850000000000001, 11.123225238095241, 4.99631, 10.975000000000001),
            Block.makeCuboidShape(11.298225238095238, 2.24631, 10.850000000000001, 11.423225238095238, 3.8213100000000004, 10.975000000000001),
            Block.makeCuboidShape(5.477965238095241, 3.3713099999999994, 10.850000000000001, 5.602965238095241, 4.64631, 10.975000000000001),
            Block.makeCuboidShape(5.17796523809524, 1.8963099999999997, 10.850000000000001, 5.30296523809524, 3.47131, 10.975000000000001),
            Block.makeCuboidShape(9.950595238095243, 11.1, 12.5, 10.275595238095239, 11.65, 12.75),
            Block.makeCuboidShape(6.575595238095239, 4.925, 9, 6.900595238095239, 5.325, 9.25),
            Block.makeCuboidShape(7.00059523809524, 4.6, 9.600000000000001, 9.50059523809524, 4.725, 9.725000000000001),
            Block.makeCuboidShape(7.00059523809524, 3.9749999999999996, 9.100000000000001, 9.50059523809524, 4.1, 9.225000000000001),
            Block.makeCuboidShape(7.00059523809524, 3.2249999999999996, 8.575, 9.50059523809524, 3.3499999999999996, 8.7),
            Block.makeCuboidShape(7.00059523809524, 2.75, 8.075, 9.50059523809524, 2.875, 8.2),
            Block.makeCuboidShape(7.00059523809524, 2.75, 7.324999999999999, 9.50059523809524, 2.875, 7.449999999999999),
            Block.makeCuboidShape(7.00059523809524, 2.75, 6.574999999999999, 9.50059523809524, 2.875, 6.699999999999999),
            Block.makeCuboidShape(7.00059523809524, 5.025, 10.100000000000001, 9.50059523809524, 5.15, 10.225000000000001)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

    public static final VoxelShape SHAPE_E = Stream.of(
            Block.makeCuboidShape(2.9539682539682666, 0.75, 5.00059523809524, 4.203968253968267, 2.5, 6.25059523809524),
            Block.makeCuboidShape(9.953968253968267, 2.5, 7.00059523809524, 10.453968253968267, 2.75, 7.25059523809524),
            Block.makeCuboidShape(1.9539682539682666, 0.75, 6.25059523809524, 12.953968253968267, 1.75, 10.25059523809524),
            Block.makeCuboidShape(9.953968253968267, 1.75, 6.75059523809524, 12.453968253968267, 2.5, 9.75059523809524),
            Block.makeCuboidShape(7.453968253968267, 1.75, 6.50059523809524, 9.953968253968267, 2.75, 10.00059523809524),
            Block.makeCuboidShape(1.9539682539682666, 1.75, 6.25059523809524, 7.453968253968267, 3.5, 10.25059523809524),
            Block.makeCuboidShape(1.9539682539682666, 3.5, 6.50059523809524, 6.953968253968267, 4.5, 10.00059523809524),
            Block.makeCuboidShape(5.703968253968267, 4.5, 6.50059523809524, 6.453968253968267, 5, 10.00059523809524),
            Block.makeCuboidShape(2.2039682539682666, 4.5, 6.50059523809524, 5.453968253968267, 4.75, 10.00059523809524),
            Block.makeCuboidShape(5.453968253968267, 4.5, 6.50059523809524, 5.728968253968265, 6, 10.00059523809524),
            Block.makeCuboidShape(1.9539682539682666, 4.5, 6.50059523809524, 2.4539682539682666, 5.75, 10.00059523809524),
            Block.makeCuboidShape(6.453968253968267, 0.75, 10.25059523809524, 11.453968253968267, 1.5, 10.75059523809524),
            Block.makeCuboidShape(6.453968253968267, 1.5, 5.75059523809524, 8.703968253968267, 2.25, 7.25059523809524),
            Block.makeCuboidShape(6.453968253968267, 1.5, 9.25059523809524, 8.703968253968267, 2.25, 10.75059523809524),
            Block.makeCuboidShape(1.9539682539682666, 0.75, 10.25059523809524, 6.453968253968267, 3.5, 11.00059523809524),
            Block.makeCuboidShape(2.2039682539682666, 3.5, 9.975595238095242, 5.453968253968267, 5.75, 10.550595238095237),
            Block.makeCuboidShape(2.2039682539682666, 3.5, 5.925595238095241, 5.453968253968267, 5.75, 6.50059523809524),
            Block.makeCuboidShape(5.453968253968267, 3.5, 6.25059523809524, 6.203968253968267, 4.25, 6.50059523809524),
            Block.makeCuboidShape(7.453968253968267, 2.75, 6.75059523809524, 9.703968253968267, 3, 7.00059523809524),
            Block.makeCuboidShape(7.453968253968267, 3, 6.75059523809524, 7.703968253968267, 3.5, 7.00059523809524),
            Block.makeCuboidShape(6.953968253968267, 3.5, 9.50059523809524, 7.203968253968267, 4.25, 9.75059523809524),
            Block.makeCuboidShape(6.953968253968267, 3.5, 6.75059523809524, 7.203968253968267, 4.25, 7.00059523809524),
            Block.makeCuboidShape(6.453968253968267, 4.5, 6.75059523809524, 6.703968253968267, 4.925, 7.00059523809524),
            Block.makeCuboidShape(5.703968253968267, 5, 6.75059523809524, 5.953968253968267, 5.425, 7.00059523809524),
            Block.makeCuboidShape(5.703968253968267, 5, 9.50059523809524, 5.953968253968267, 5.425, 9.75059523809524),
            Block.makeCuboidShape(5.953968253968267, 5, 9.50059523809524, 6.303968253968268, 5.175, 9.75059523809524),
            Block.makeCuboidShape(5.953968253968267, 5, 6.75059523809524, 6.303968253968268, 5.175, 7.00059523809524),
            Block.makeCuboidShape(6.453968253968267, 4.5, 9.50059523809524, 6.703968253968267, 4.925, 9.75059523809524),
            Block.makeCuboidShape(7.453968253968267, 3, 9.50059523809524, 7.703968253968267, 3.5, 9.75059523809524),
            Block.makeCuboidShape(7.453968253968267, 2.75, 9.50059523809524, 9.703968253968267, 3, 9.75059523809524),
            Block.makeCuboidShape(9.953968253968267, 2.5, 9.25059523809524, 10.453968253968267, 2.75, 9.50059523809524),
            Block.makeCuboidShape(6.453968253968267, 0.75, 5.75059523809524, 11.453968253968267, 1.5, 6.25059523809524),
            Block.makeCuboidShape(1.9539682539682666, 0.75, 5.50059523809524, 6.453968253968267, 3.5, 6.25059523809524),
            Block.makeCuboidShape(1.4539682539682666, 0.75, 6.25059523809524, 2.2039682539682666, 4, 10.25059523809524),
            Block.makeCuboidShape(2.7039682539682666, 3.4000000000000004, 3.3255952380952394, 4.503968253968267, 4.4, 5.150595238095239),
            Block.makeCuboidShape(2.803968253968268, 2.15, 3.925595238095241, 4.403968253968266, 4.9, 5.575595238095239),
            Block.makeCuboidShape(6.453968253968267, 4.1, 6.325595238095239, 6.703968253968267, 5.15, 6.650595238095239),
            Block.makeCuboidShape(-5.046031746031733, 11.35, 5.950595238095239, -4.796031746031733, 12.15, 6.275595238095239),
            Block.makeCuboidShape(-5.046031746031733, 11.85, 5.700595238095239, -4.796031746031733, 12.65, 6.025595238095239),
            Block.makeCuboidShape(3.4539682539682666, 9.85, 9.950595238095243, 3.7039682539682666, 11.15, 10.275595238095239),
            Block.makeCuboidShape(6.453968253968267, 0, 10.25059523809524, 11.578968253968267, 0.75, 10.900595238095239),
            Block.makeCuboidShape(6.453968253968267, 0, 5.575595238095239, 11.628968253968267, 0.75, 6.25059523809524),
            Block.makeCuboidShape(1.7789682539682659, 0, 5.300595238095241, 6.628968253968267, 0.75, 6.25059523809524),
            Block.makeCuboidShape(1.7789682539682659, 0, 10.25059523809524, 6.628968253968267, 0.75, 11.175595238095237),
            Block.makeCuboidShape(1.2789682539682659, 0, 6.050595238095241, 11.628968253968267, 0.75, 10.400595238095239),
            Block.makeCuboidShape(11.628968253968267, 0, 6.050595238095241, 13.128968253968267, 0.75, 10.400595238095239),
            Block.makeCuboidShape(5.241468253968268, 1.3963099999999997, 5.190495238095242, 5.341468253968266, 1.8963099999999997, 5.2904952380952395),
            Block.makeCuboidShape(5.228968253968265, 5.12263, 5.471905238095243, 5.353968253968265, 5.24763, 6.471905238095243),
            Block.makeCuboidShape(5.241468253968268, 1.7463100000000003, 11.310695238095239, 5.341468253968266, 2.24631, 11.41069523809524),
            Block.makeCuboidShape(5.228968253968265, 5.47263, 10.129285238095239, 5.353968253968265, 5.59763, 11.129285238095239),
            Block.makeCuboidShape(5.228968253968265, 3.72131, 10.998225238095241, 5.353968253968265, 4.99631, 11.123225238095241),
            Block.makeCuboidShape(5.228968253968265, 2.24631, 11.298225238095238, 5.353968253968265, 3.8213100000000004, 11.423225238095238),
            Block.makeCuboidShape(5.228968253968265, 3.3713099999999994, 5.477965238095241, 5.353968253968265, 4.64631, 5.602965238095241),
            Block.makeCuboidShape(5.228968253968265, 1.8963099999999997, 5.17796523809524, 5.353968253968265, 3.47131, 5.30296523809524),
            Block.makeCuboidShape(3.4539682539682666, 11.1, 9.950595238095243, 3.7039682539682666, 11.65, 10.275595238095239),
            Block.makeCuboidShape(6.953968253968267, 4.925, 6.575595238095239, 7.203968253968267, 5.325, 6.900595238095239),
            Block.makeCuboidShape(6.478968253968265, 4.6, 7.00059523809524, 6.603968253968265, 4.725, 9.50059523809524),
            Block.makeCuboidShape(6.978968253968265, 3.9749999999999996, 7.00059523809524, 7.103968253968265, 4.1, 9.50059523809524),
            Block.makeCuboidShape(7.503968253968267, 3.2249999999999996, 7.00059523809524, 7.628968253968267, 3.3499999999999996, 9.50059523809524),
            Block.makeCuboidShape(8.003968253968267, 2.75, 7.00059523809524, 8.128968253968267, 2.875, 9.50059523809524),
            Block.makeCuboidShape(8.753968253968267, 2.75, 7.00059523809524, 8.878968253968267, 2.875, 9.50059523809524),
            Block.makeCuboidShape(9.503968253968267, 2.75, 7.00059523809524, 9.628968253968267, 2.875, 9.50059523809524),
            Block.makeCuboidShape(5.978968253968265, 5.025, 7.00059523809524, 6.103968253968265, 5.15, 9.50059523809524)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

    public static final VoxelShape SHAPE_S = Stream.of(
            Block.makeCuboidShape(9.749404761904774, 0.75, 3.00059523809524, 10.999404761904774, 2.5, 4.25059523809524),
            Block.makeCuboidShape(8.749404761904774, 2.5, 10.00059523809524, 8.999404761904774, 2.75, 10.50059523809524),
            Block.makeCuboidShape(5.749404761904774, 0.75, 2.00059523809524, 9.749404761904774, 1.75, 13.00059523809524),
            Block.makeCuboidShape(6.249404761904774, 1.75, 10.00059523809524, 9.249404761904774, 2.5, 12.50059523809524),
            Block.makeCuboidShape(5.999404761904774, 1.75, 7.50059523809524, 9.499404761904774, 2.75, 10.00059523809524),
            Block.makeCuboidShape(5.749404761904774, 1.75, 2.00059523809524, 9.749404761904774, 3.5, 7.50059523809524),
            Block.makeCuboidShape(5.999404761904774, 3.5, 2.00059523809524, 9.499404761904774, 4.5, 7.00059523809524),
            Block.makeCuboidShape(5.999404761904774, 4.5, 5.75059523809524, 9.499404761904774, 5, 6.50059523809524),
            Block.makeCuboidShape(5.999404761904774, 4.5, 2.25059523809524, 9.499404761904774, 4.75, 5.50059523809524),
            Block.makeCuboidShape(5.999404761904774, 4.5, 5.50059523809524, 9.499404761904774, 6, 5.775595238095239),
            Block.makeCuboidShape(5.999404761904774, 4.5, 2.00059523809524, 9.499404761904774, 5.75, 2.50059523809524),
            Block.makeCuboidShape(5.249404761904774, 0.75, 6.50059523809524, 5.749404761904774, 1.5, 11.50059523809524),
            Block.makeCuboidShape(8.749404761904774, 1.5, 6.50059523809524, 10.249404761904774, 2.25, 8.75059523809524),
            Block.makeCuboidShape(5.249404761904774, 1.5, 6.50059523809524, 6.749404761904774, 2.25, 8.75059523809524),
            Block.makeCuboidShape(4.999404761904774, 0.75, 2.00059523809524, 5.749404761904774, 3.5, 6.50059523809524),
            Block.makeCuboidShape(5.449404761904777, 3.5, 2.25059523809524, 6.024404761904773, 5.75, 5.50059523809524),
            Block.makeCuboidShape(9.499404761904774, 3.5, 2.25059523809524, 10.074404761904773, 5.75, 5.50059523809524),
            Block.makeCuboidShape(9.499404761904774, 3.5, 5.50059523809524, 9.749404761904774, 4.25, 6.25059523809524),
            Block.makeCuboidShape(8.999404761904774, 2.75, 7.50059523809524, 9.249404761904774, 3, 9.75059523809524),
            Block.makeCuboidShape(8.999404761904774, 3, 7.50059523809524, 9.249404761904774, 3.5, 7.75059523809524),
            Block.makeCuboidShape(6.249404761904774, 3.5, 7.00059523809524, 6.499404761904774, 4.25, 7.25059523809524),
            Block.makeCuboidShape(8.999404761904774, 3.5, 7.00059523809524, 9.249404761904774, 4.25, 7.25059523809524),
            Block.makeCuboidShape(8.999404761904774, 4.5, 6.50059523809524, 9.249404761904774, 4.925, 6.75059523809524),
            Block.makeCuboidShape(8.999404761904774, 5, 5.75059523809524, 9.249404761904774, 5.425, 6.00059523809524),
            Block.makeCuboidShape(6.249404761904774, 5, 5.75059523809524, 6.499404761904774, 5.425, 6.00059523809524),
            Block.makeCuboidShape(6.249404761904774, 5, 6.00059523809524, 6.499404761904774, 5.175, 6.3505952380952415),
            Block.makeCuboidShape(8.999404761904774, 5, 6.00059523809524, 9.249404761904774, 5.175, 6.3505952380952415),
            Block.makeCuboidShape(6.249404761904774, 4.5, 6.50059523809524, 6.499404761904774, 4.925, 6.75059523809524),
            Block.makeCuboidShape(6.249404761904774, 3, 7.50059523809524, 6.499404761904774, 3.5, 7.75059523809524),
            Block.makeCuboidShape(6.249404761904774, 2.75, 7.50059523809524, 6.499404761904774, 3, 9.75059523809524),
            Block.makeCuboidShape(6.499404761904774, 2.5, 10.00059523809524, 6.749404761904774, 2.75, 10.50059523809524),
            Block.makeCuboidShape(9.749404761904774, 0.75, 6.50059523809524, 10.249404761904774, 1.5, 11.50059523809524),
            Block.makeCuboidShape(9.749404761904774, 0.75, 2.00059523809524, 10.499404761904774, 3.5, 6.50059523809524),
            Block.makeCuboidShape(5.749404761904774, 0.75, 1.50059523809524, 9.749404761904774, 4, 2.25059523809524),
            Block.makeCuboidShape(10.849404761904776, 3.4000000000000004, 2.75059523809524, 12.674404761904775, 4.4, 4.550595238095241),
            Block.makeCuboidShape(10.424404761904775, 2.15, 2.8505952380952415, 12.074404761904773, 4.9, 4.450595238095239),
            Block.makeCuboidShape(9.349404761904776, 4.1, 6.50059523809524, 9.674404761904775, 5.15, 6.75059523809524),
            Block.makeCuboidShape(9.724404761904776, 11.35, -4.99940476190476, 10.049404761904775, 12.15, -4.74940476190476),
            Block.makeCuboidShape(9.974404761904776, 11.85, -4.99940476190476, 10.299404761904775, 12.65, -4.74940476190476),
            Block.makeCuboidShape(5.7244047619047755, 9.85, 3.50059523809524, 6.049404761904771, 11.15, 3.75059523809524),
            Block.makeCuboidShape(5.0994047619047755, 0, 6.50059523809524, 5.749404761904774, 0.75, 11.62559523809524),
            Block.makeCuboidShape(9.749404761904774, 0, 6.50059523809524, 10.424404761904775, 0.75, 11.67559523809524),
            Block.makeCuboidShape(9.749404761904774, 0, 1.8255952380952394, 10.699404761904773, 0.75, 6.675595238095241),
            Block.makeCuboidShape(4.824404761904777, 0, 1.8255952380952394, 5.749404761904774, 0.75, 6.675595238095241),
            Block.makeCuboidShape(5.5994047619047755, 0, 1.3255952380952394, 9.949404761904773, 0.75, 11.67559523809524),
            Block.makeCuboidShape(5.5994047619047755, 0, 11.67559523809524, 9.949404761904773, 0.75, 13.17559523809524),
            Block.makeCuboidShape(10.709504761904775, 1.3963099999999997, 5.2880952380952415, 10.809504761904773, 1.8963099999999997, 5.388095238095239),
            Block.makeCuboidShape(9.528094761904772, 5.12263, 5.275595238095239, 10.528094761904772, 5.24763, 5.400595238095239),
            Block.makeCuboidShape(4.589304761904774, 1.7463100000000003, 5.2880952380952415, 4.689304761904776, 2.24631, 5.388095238095239),
            Block.makeCuboidShape(4.870714761904775, 5.47263, 5.275595238095239, 5.870714761904775, 5.59763, 5.400595238095239),
            Block.makeCuboidShape(4.876774761904773, 3.72131, 5.275595238095239, 5.001774761904773, 4.99631, 5.400595238095239),
            Block.makeCuboidShape(4.576774761904776, 2.24631, 5.275595238095239, 4.701774761904776, 3.8213100000000004, 5.400595238095239),
            Block.makeCuboidShape(10.397034761904774, 3.3713099999999994, 5.275595238095239, 10.522034761904774, 4.64631, 5.400595238095239),
            Block.makeCuboidShape(10.697034761904774, 1.8963099999999997, 5.275595238095239, 10.822034761904774, 3.47131, 5.400595238095239),
            Block.makeCuboidShape(5.7244047619047755, 11.1, 3.50059523809524, 6.049404761904771, 11.65, 3.75059523809524),
            Block.makeCuboidShape(9.099404761904776, 4.925, 7.00059523809524, 9.424404761904775, 5.325, 7.25059523809524),
            Block.makeCuboidShape(6.499404761904774, 4.6, 6.525595238095239, 8.999404761904774, 4.725, 6.650595238095239),
            Block.makeCuboidShape(6.499404761904774, 3.9749999999999996, 7.025595238095239, 8.999404761904774, 4.1, 7.150595238095239),
            Block.makeCuboidShape(6.499404761904774, 3.2249999999999996, 7.550595238095241, 8.999404761904774, 3.3499999999999996, 7.675595238095241),
            Block.makeCuboidShape(6.499404761904774, 2.75, 8.05059523809524, 8.999404761904774, 2.875, 8.17559523809524),
            Block.makeCuboidShape(6.499404761904774, 2.75, 8.80059523809524, 8.999404761904774, 2.875, 8.92559523809524),
            Block.makeCuboidShape(6.499404761904774, 2.75, 9.55059523809524, 8.999404761904774, 2.875, 9.67559523809524),
            Block.makeCuboidShape(6.499404761904774, 5.025, 6.025595238095239, 8.999404761904774, 5.15, 6.150595238095239)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

    public static final VoxelShape SHAPE_W = Stream.of(
            Block.makeCuboidShape(11.749404761904774, 0.75, 9.749404761904774, 12.999404761904774, 2.5, 10.999404761904774),
            Block.makeCuboidShape(5.499404761904774, 2.5, 8.749404761904774, 5.999404761904774, 2.75, 8.999404761904774),
            Block.makeCuboidShape(2.999404761904774, 0.75, 5.749404761904774, 13.999404761904774, 1.75, 9.749404761904774),
            Block.makeCuboidShape(3.499404761904774, 1.75, 6.249404761904774, 5.999404761904774, 2.5, 9.249404761904774),
            Block.makeCuboidShape(5.999404761904774, 1.75, 5.999404761904774, 8.499404761904774, 2.75, 9.499404761904774),
            Block.makeCuboidShape(8.499404761904774, 1.75, 5.749404761904774, 13.999404761904774, 3.5, 9.749404761904774),
            Block.makeCuboidShape(8.999404761904774, 3.5, 5.999404761904774, 13.999404761904774, 4.5, 9.499404761904774),
            Block.makeCuboidShape(9.499404761904774, 4.5, 5.999404761904774, 10.249404761904774, 5, 9.499404761904774),
            Block.makeCuboidShape(10.499404761904774, 4.5, 5.999404761904774, 13.749404761904774, 4.75, 9.499404761904774),
            Block.makeCuboidShape(10.224404761904776, 4.5, 5.999404761904774, 10.499404761904774, 6, 9.499404761904774),
            Block.makeCuboidShape(13.499404761904774, 4.5, 5.999404761904774, 13.999404761904774, 5.75, 9.499404761904774),
            Block.makeCuboidShape(4.499404761904774, 0.75, 5.249404761904774, 9.499404761904774, 1.5, 5.749404761904774),
            Block.makeCuboidShape(7.249404761904774, 1.5, 8.749404761904774, 9.499404761904774, 2.25, 10.249404761904774),
            Block.makeCuboidShape(7.249404761904774, 1.5, 5.249404761904774, 9.499404761904774, 2.25, 6.749404761904774),
            Block.makeCuboidShape(9.499404761904774, 0.75, 4.999404761904774, 13.999404761904774, 3.5, 5.749404761904774),
            Block.makeCuboidShape(10.499404761904774, 3.5, 5.449404761904777, 13.749404761904774, 5.75, 6.024404761904773),
            Block.makeCuboidShape(10.499404761904774, 3.5, 9.499404761904774, 13.749404761904774, 5.75, 10.074404761904773),
            Block.makeCuboidShape(9.749404761904774, 3.5, 9.499404761904774, 10.499404761904774, 4.25, 9.749404761904774),
            Block.makeCuboidShape(6.249404761904774, 2.75, 8.999404761904774, 8.499404761904774, 3, 9.249404761904774),
            Block.makeCuboidShape(8.249404761904774, 3, 8.999404761904774, 8.499404761904774, 3.5, 9.249404761904774),
            Block.makeCuboidShape(8.749404761904774, 3.5, 6.249404761904774, 8.999404761904774, 4.25, 6.499404761904774),
            Block.makeCuboidShape(8.749404761904774, 3.5, 8.999404761904774, 8.999404761904774, 4.25, 9.249404761904774),
            Block.makeCuboidShape(9.249404761904774, 4.5, 8.999404761904774, 9.499404761904774, 4.925, 9.249404761904774),
            Block.makeCuboidShape(9.999404761904774, 5, 8.999404761904774, 10.249404761904774, 5.425, 9.249404761904774),
            Block.makeCuboidShape(9.999404761904774, 5, 6.249404761904774, 10.249404761904774, 5.425, 6.499404761904774),
            Block.makeCuboidShape(9.649404761904773, 5, 6.249404761904774, 9.999404761904774, 5.175, 6.499404761904774),
            Block.makeCuboidShape(9.649404761904773, 5, 8.999404761904774, 9.999404761904774, 5.175, 9.249404761904774),
            Block.makeCuboidShape(9.249404761904774, 4.5, 6.249404761904774, 9.499404761904774, 4.925, 6.499404761904774),
            Block.makeCuboidShape(8.249404761904774, 3, 6.249404761904774, 8.499404761904774, 3.5, 6.499404761904774),
            Block.makeCuboidShape(6.249404761904774, 2.75, 6.249404761904774, 8.499404761904774, 3, 6.499404761904774),
            Block.makeCuboidShape(5.499404761904774, 2.5, 6.499404761904774, 5.999404761904774, 2.75, 6.749404761904774),
            Block.makeCuboidShape(4.499404761904774, 0.75, 9.749404761904774, 9.499404761904774, 1.5, 10.249404761904774),
            Block.makeCuboidShape(9.499404761904774, 0.75, 9.749404761904774, 13.999404761904774, 3.5, 10.499404761904774),
            Block.makeCuboidShape(13.749404761904774, 0.75, 5.749404761904774, 14.499404761904774, 4, 9.749404761904774),
            Block.makeCuboidShape(11.449404761904773, 3.4000000000000004, 10.849404761904776, 13.249404761904774, 4.4, 12.674404761904775),
            Block.makeCuboidShape(11.549404761904775, 2.15, 10.424404761904775, 13.149404761904773, 4.9, 12.074404761904773),
            Block.makeCuboidShape(9.249404761904774, 4.1, 9.349404761904776, 9.499404761904774, 5.15, 9.674404761904775),
            Block.makeCuboidShape(20.749404761904774, 11.35, 9.724404761904776, 20.999404761904774, 12.15, 10.049404761904775),
            Block.makeCuboidShape(20.749404761904774, 11.85, 9.974404761904776, 20.999404761904774, 12.65, 10.299404761904775),
            Block.makeCuboidShape(12.249404761904774, 9.85, 5.7244047619047755, 12.499404761904774, 11.15, 6.049404761904771),
            Block.makeCuboidShape(4.374404761904774, 0, 5.0994047619047755, 9.499404761904774, 0.75, 5.749404761904774),
            Block.makeCuboidShape(4.324404761904773, 0, 9.749404761904774, 9.499404761904774, 0.75, 10.424404761904775),
            Block.makeCuboidShape(9.324404761904773, 0, 9.749404761904774, 14.174404761904775, 0.75, 10.699404761904773),
            Block.makeCuboidShape(9.324404761904773, 0, 4.824404761904777, 14.174404761904775, 0.75, 5.749404761904774),
            Block.makeCuboidShape(4.324404761904773, 0, 5.5994047619047755, 14.674404761904775, 0.75, 9.949404761904773),
            Block.makeCuboidShape(2.8244047619047734, 0, 5.5994047619047755, 4.324404761904773, 0.75, 9.949404761904773),
            Block.makeCuboidShape(10.611904761904775, 1.3963099999999997, 10.709504761904775, 10.711904761904773, 1.8963099999999997, 10.809504761904773),
            Block.makeCuboidShape(10.599404761904776, 5.12263, 9.528094761904772, 10.724404761904776, 5.24763, 10.528094761904772),
            Block.makeCuboidShape(10.611904761904775, 1.7463100000000003, 4.589304761904774, 10.711904761904773, 2.24631, 4.689304761904776),
            Block.makeCuboidShape(10.599404761904776, 5.47263, 4.870714761904775, 10.724404761904776, 5.59763, 5.870714761904775),
            Block.makeCuboidShape(10.599404761904776, 3.72131, 4.876774761904773, 10.724404761904776, 4.99631, 5.001774761904773),
            Block.makeCuboidShape(10.599404761904776, 2.24631, 4.576774761904776, 10.724404761904776, 3.8213100000000004, 4.701774761904776),
            Block.makeCuboidShape(10.599404761904776, 3.3713099999999994, 10.397034761904774, 10.724404761904776, 4.64631, 10.522034761904774),
            Block.makeCuboidShape(10.599404761904776, 1.8963099999999997, 10.697034761904774, 10.724404761904776, 3.47131, 10.822034761904774),
            Block.makeCuboidShape(12.249404761904774, 11.1, 5.7244047619047755, 12.499404761904774, 11.65, 6.049404761904771),
            Block.makeCuboidShape(8.749404761904774, 4.925, 9.099404761904776, 8.999404761904774, 5.325, 9.424404761904775),
            Block.makeCuboidShape(9.349404761904776, 4.6, 6.499404761904774, 9.474404761904776, 4.725, 8.999404761904774),
            Block.makeCuboidShape(8.849404761904776, 3.9749999999999996, 6.499404761904774, 8.974404761904776, 4.1, 8.999404761904774),
            Block.makeCuboidShape(8.324404761904773, 3.2249999999999996, 6.499404761904774, 8.449404761904773, 3.3499999999999996, 8.999404761904774),
            Block.makeCuboidShape(7.824404761904773, 2.75, 6.499404761904774, 7.949404761904773, 2.875, 8.999404761904774),
            Block.makeCuboidShape(7.074404761904773, 2.75, 6.499404761904774, 7.199404761904773, 2.875, 8.999404761904774),
            Block.makeCuboidShape(6.324404761904773, 2.75, 6.499404761904774, 6.449404761904773, 2.875, 8.999404761904774),
            Block.makeCuboidShape(9.849404761904776, 5.025, 6.499404761904774, 9.974404761904776, 5.15, 8.999404761904774)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

    public Schoentje() {
        super(Properties.create(Material.WOOD)
                .hardnessAndResistance(3.5f, 4.0f)
                .harvestLevel(0)
                .sound(SoundType.WOOD));
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