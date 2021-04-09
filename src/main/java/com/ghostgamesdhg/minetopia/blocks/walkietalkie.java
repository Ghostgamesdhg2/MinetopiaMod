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

import javax.annotation.Nullable;
import java.util.stream.Stream;

public class walkietalkie extends Block {

    private static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;

    private static final VoxelShape SHAPE_N = Stream.of(
            Block.makeCuboidShape(7.4, 2.1, 6.8, 8.6, 2.9, 7.1),
            Block.makeCuboidShape(6.4, 1.9, 6.8, 7.2, 2.3, 7.1),
            Block.makeCuboidShape(8.8, 1.9, 6.8, 9.6, 2.3, 7.1),
            Block.makeCuboidShape(6.6, 0.9, 6.8, 7.4, 1.3, 7.1),
            Block.makeCuboidShape(7.6, 0.9, 6.8, 8.4, 1.3, 7.1),
            Block.makeCuboidShape(8.6, 0.9, 6.8, 9.4, 1.3, 7.1),
            Block.makeCuboidShape(7.6, 1.9, 6.8, 8.4, 3.1, 7.1),
            Block.makeCuboidShape(7.5, 2, 6.8, 8.5, 3, 7.1),
            Block.makeCuboidShape(6.1, 3.9, 6.9, 9.9, 6.5, 7.2),
            Block.makeCuboidShape(6.5, 3.4, 6.9, 9.5, 3.7, 7.2),
            Block.makeCuboidShape(6.3, 0.6, 7.9, 9.7, 3.6, 8.2),
            Block.makeCuboidShape(6.3, 0.6, 6.9, 9.7, 3.6, 7.2),
            Block.makeCuboidShape(6.3, 3.7, 6.9, 9.7, 6.7, 7.2),
            Block.makeCuboidShape(6.2, 0.7, 6.9, 9.8, 3.5, 7.2),
            Block.makeCuboidShape(6.2, 0.7, 6.9, 9.8, 3.5, 7.2),
            Block.makeCuboidShape(6.2, 3.8, 6.9, 9.8, 6.6, 7.2),
            Block.makeCuboidShape(6.1, 0.2, 9.9, 9.9, 6.8, 10.2),
            Block.makeCuboidShape(5.8, 0.2, 7.2, 6.1, 6.8, 9.8),
            Block.makeCuboidShape(9.9, 0.2, 7.2, 10.2, 6.8, 9.8),
            Block.makeCuboidShape(6.4, 7.2, 8.2, 7.4, 11.7, 8.8),
            Block.makeCuboidShape(8.6, 7.2, 8.2, 9.6, 8.1, 8.8),
            Block.makeCuboidShape(6.6, 7.3, 8.2, 7.2, 11.8, 8.8),
            Block.makeCuboidShape(8.8, 8.1, 8.2, 9.4, 8.2, 8.8),
            Block.makeCuboidShape(6.5, 7.2, 8.1, 7.3, 11.7, 8.9),
            Block.makeCuboidShape(8.7, 7.2, 8.1, 9.5, 8.1, 8.9),
            Block.makeCuboidShape(6.2, 6.9, 7.2, 9.8, 7.2, 9.8),
            Block.makeCuboidShape(6.8, 6.2, 6.8, 9.3, 6.4, 7),
            Block.makeCuboidShape(6.8, 4.3, 6.8, 9.3, 4.5, 7),
            Block.makeCuboidShape(6.4, 4.6, 6.8, 6.6, 6.1, 7),
            Block.makeCuboidShape(9.5, 4.6, 6.8, 9.7, 6.1, 7),
            Block.makeCuboidShape(6.6, 4.5, 6.8, 9.5, 6.2, 7),
            Block.makeCuboidShape(6, 0, 7, 10, 7, 10)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

    public static final VoxelShape SHAPE_E = Stream.of(
            Block.makeCuboidShape(9.700000000000001, 2.1, 7.4, 10, 2.9, 8.6),
            Block.makeCuboidShape(9.700000000000001, 1.9, 6.4, 10, 2.3, 7.199999999999999),
            Block.makeCuboidShape(9.700000000000001, 1.9, 8.8, 10, 2.3, 9.6),
            Block.makeCuboidShape(9.700000000000001, 0.9, 6.6, 10, 1.3, 7.4),
            Block.makeCuboidShape(9.700000000000001, 0.9, 7.6, 10, 1.3, 8.4),
            Block.makeCuboidShape(9.700000000000001, 0.9, 8.6, 10, 1.3, 9.4),
            Block.makeCuboidShape(9.700000000000001, 1.9, 7.6, 10, 3.1, 8.4),
            Block.makeCuboidShape(9.700000000000001, 2, 7.5, 10, 3, 8.5),
            Block.makeCuboidShape(9.600000000000001, 3.9, 6.1, 9.9, 6.5, 9.9),
            Block.makeCuboidShape(9.600000000000001, 3.4, 6.5, 9.9, 3.7, 9.5),
            Block.makeCuboidShape(8.600000000000001, 0.6, 6.3, 8.9, 3.6, 9.7),
            Block.makeCuboidShape(9.600000000000001, 0.6, 6.3, 9.9, 3.6, 9.7),
            Block.makeCuboidShape(9.600000000000001, 3.7, 6.3, 9.9, 6.7, 9.7),
            Block.makeCuboidShape(9.600000000000001, 0.7, 6.2, 9.9, 3.5, 9.8),
            Block.makeCuboidShape(9.600000000000001, 0.7, 6.2, 9.9, 3.5, 9.8),
            Block.makeCuboidShape(9.600000000000001, 3.8, 6.2, 9.9, 6.6, 9.8),
            Block.makeCuboidShape(6.600000000000001, 0.2, 6.1, 6.9, 6.8, 9.9),
            Block.makeCuboidShape(7, 0.2, 5.8, 9.600000000000001, 6.8, 6.1),
            Block.makeCuboidShape(7, 0.2, 9.9, 9.600000000000001, 6.8, 10.2),
            Block.makeCuboidShape(8, 7.2, 6.4, 8.600000000000001, 11.7, 7.4),
            Block.makeCuboidShape(8, 7.2, 8.6, 8.600000000000001, 8.1, 9.6),
            Block.makeCuboidShape(8, 7.3, 6.6, 8.600000000000001, 11.8, 7.199999999999999),
            Block.makeCuboidShape(8, 8.1, 8.8, 8.600000000000001, 8.2, 9.4),
            Block.makeCuboidShape(7.9, 7.2, 6.5, 8.700000000000001, 11.7, 7.300000000000001),
            Block.makeCuboidShape(7.9, 7.2, 8.7, 8.700000000000001, 8.1, 9.5),
            Block.makeCuboidShape(7, 6.9, 6.2, 9.600000000000001, 7.2, 9.8),
            Block.makeCuboidShape(9.8, 6.2, 6.8, 10, 6.4, 9.3),
            Block.makeCuboidShape(9.8, 4.3, 6.8, 10, 4.5, 9.3),
            Block.makeCuboidShape(9.8, 4.6, 6.4, 10, 6.1, 6.6),
            Block.makeCuboidShape(9.8, 4.6, 9.5, 10, 6.1, 9.7),
            Block.makeCuboidShape(9.8, 4.5, 6.6, 10, 6.2, 9.5),
            Block.makeCuboidShape(6.800000000000001, 0, 6, 9.8, 7, 10)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

    public static final VoxelShape SHAPE_S = Stream.of(
            Block.makeCuboidShape(7.200000000000001, 2.1, 9.700000000000001, 8.4, 2.9, 10),
            Block.makeCuboidShape(8.600000000000001, 1.9, 9.700000000000001, 9.4, 2.3, 10),
            Block.makeCuboidShape(6.200000000000001, 1.9, 9.700000000000001, 7, 2.3, 10),
            Block.makeCuboidShape(8.4, 0.9, 9.700000000000001, 9.200000000000001, 1.3, 10),
            Block.makeCuboidShape(7.4, 0.9, 9.700000000000001, 8.200000000000001, 1.3, 10),
            Block.makeCuboidShape(6.4, 0.9, 9.700000000000001, 7.200000000000001, 1.3, 10),
            Block.makeCuboidShape(7.4, 1.9, 9.700000000000001, 8.200000000000001, 3.1, 10),
            Block.makeCuboidShape(7.300000000000001, 2, 9.700000000000001, 8.3, 3, 10),
            Block.makeCuboidShape(5.9, 3.9, 9.600000000000001, 9.700000000000001, 6.5, 9.9),
            Block.makeCuboidShape(6.300000000000001, 3.4, 9.600000000000001, 9.3, 3.7, 9.9),
            Block.makeCuboidShape(6.100000000000001, 0.6, 8.600000000000001, 9.5, 3.6, 8.9),
            Block.makeCuboidShape(6.100000000000001, 0.6, 9.600000000000001, 9.5, 3.6, 9.9),
            Block.makeCuboidShape(6.100000000000001, 3.7, 9.600000000000001, 9.5, 6.7, 9.9),
            Block.makeCuboidShape(6, 0.7, 9.600000000000001, 9.600000000000001, 3.5, 9.9),
            Block.makeCuboidShape(6, 0.7, 9.600000000000001, 9.600000000000001, 3.5, 9.9),
            Block.makeCuboidShape(6, 3.8, 9.600000000000001, 9.600000000000001, 6.6, 9.9),
            Block.makeCuboidShape(5.9, 0.2, 6.600000000000001, 9.700000000000001, 6.8, 6.9),
            Block.makeCuboidShape(9.700000000000001, 0.2, 7, 10, 6.8, 9.600000000000001),
            Block.makeCuboidShape(5.600000000000001, 0.2, 7, 5.9, 6.8, 9.600000000000001),
            Block.makeCuboidShape(8.4, 7.2, 8, 9.4, 11.7, 8.600000000000001),
            Block.makeCuboidShape(6.200000000000001, 7.2, 8, 7.200000000000001, 8.1, 8.600000000000001),
            Block.makeCuboidShape(8.600000000000001, 7.3, 8, 9.200000000000001, 11.8, 8.600000000000001),
            Block.makeCuboidShape(6.4, 8.1, 8, 7, 8.2, 8.600000000000001),
            Block.makeCuboidShape(8.5, 7.2, 7.9, 9.3, 11.7, 8.700000000000001),
            Block.makeCuboidShape(6.300000000000001, 7.2, 7.9, 7.100000000000001, 8.1, 8.700000000000001),
            Block.makeCuboidShape(6, 6.9, 7, 9.600000000000001, 7.2, 9.600000000000001),
            Block.makeCuboidShape(6.5, 6.2, 9.8, 9, 6.4, 10),
            Block.makeCuboidShape(6.5, 4.3, 9.8, 9, 4.5, 10),
            Block.makeCuboidShape(9.200000000000001, 4.6, 9.8, 9.4, 6.1, 10),
            Block.makeCuboidShape(6.100000000000001, 4.6, 9.8, 6.300000000000001, 6.1, 10),
            Block.makeCuboidShape(6.300000000000001, 4.5, 9.8, 9.200000000000001, 6.2, 10),
            Block.makeCuboidShape(5.800000000000001, 0, 6.800000000000001, 9.8, 7, 9.8)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

    public static final VoxelShape SHAPE_W = Stream.of(
            Block.makeCuboidShape(6.800000000000001, 2.1, 8.200000000000001, 7.1, 2.9, 9.4),
            Block.makeCuboidShape(6.800000000000001, 1.9, 9.600000000000001, 7.1, 2.3, 10.4),
            Block.makeCuboidShape(6.800000000000001, 1.9, 7.200000000000001, 7.1, 2.3, 8),
            Block.makeCuboidShape(6.800000000000001, 0.9, 9.4, 7.1, 1.3, 10.200000000000001),
            Block.makeCuboidShape(6.800000000000001, 0.9, 8.4, 7.1, 1.3, 9.200000000000001),
            Block.makeCuboidShape(6.800000000000001, 0.9, 7.4, 7.1, 1.3, 8.200000000000001),
            Block.makeCuboidShape(6.800000000000001, 1.9, 8.4, 7.1, 3.1, 9.200000000000001),
            Block.makeCuboidShape(6.800000000000001, 2, 8.3, 7.1, 3, 9.3),
            Block.makeCuboidShape(6.9, 3.9, 6.9, 7.199999999999999, 6.5, 10.700000000000001),
            Block.makeCuboidShape(6.9, 3.4, 7.300000000000001, 7.199999999999999, 3.7, 10.3),
            Block.makeCuboidShape(7.9, 0.6, 7.100000000000001, 8.2, 3.6, 10.5),
            Block.makeCuboidShape(6.9, 0.6, 7.100000000000001, 7.199999999999999, 3.6, 10.5),
            Block.makeCuboidShape(6.9, 3.7, 7.100000000000001, 7.199999999999999, 6.7, 10.5),
            Block.makeCuboidShape(6.9, 0.7, 7, 7.199999999999999, 3.5, 10.600000000000001),
            Block.makeCuboidShape(6.9, 0.7, 7, 7.199999999999999, 3.5, 10.600000000000001),
            Block.makeCuboidShape(6.9, 3.8, 7, 7.199999999999999, 6.6, 10.600000000000001),
            Block.makeCuboidShape(9.9, 0.2, 6.9, 10.2, 6.8, 10.700000000000001),
            Block.makeCuboidShape(7.199999999999999, 0.2, 10.700000000000001, 9.8, 6.8, 11),
            Block.makeCuboidShape(7.199999999999999, 0.2, 6.600000000000001, 9.8, 6.8, 6.9),
            Block.makeCuboidShape(8.2, 7.2, 9.4, 8.8, 11.7, 10.4),
            Block.makeCuboidShape(8.2, 7.2, 7.200000000000001, 8.8, 8.1, 8.200000000000001),
            Block.makeCuboidShape(8.2, 7.3, 9.600000000000001, 8.8, 11.8, 10.200000000000001),
            Block.makeCuboidShape(8.2, 8.1, 7.4, 8.8, 8.2, 8),
            Block.makeCuboidShape(8.1, 7.2, 9.5, 8.9, 11.7, 10.3),
            Block.makeCuboidShape(8.1, 7.2, 7.300000000000001, 8.9, 8.1, 8.100000000000001),
            Block.makeCuboidShape(7.199999999999999, 6.9, 7, 9.8, 7.2, 10.600000000000001),
            Block.makeCuboidShape(6.800000000000001, 6.2, 7.5, 7, 6.4, 10),
            Block.makeCuboidShape(6.800000000000001, 4.3, 7.5, 7, 4.5, 10),
            Block.makeCuboidShape(6.800000000000001, 4.6, 10.200000000000001, 7, 6.1, 10.4),
            Block.makeCuboidShape(6.800000000000001, 4.6, 7.100000000000001, 7, 6.1, 7.300000000000001),
            Block.makeCuboidShape(6.800000000000001, 4.5, 7.300000000000001, 7, 6.2, 10.200000000000001),
            Block.makeCuboidShape(7, 0, 6.800000000000001, 10, 7, 10.8)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

    public walkietalkie() {
        super(Properties.create(Material.IRON)
                .hardnessAndResistance(3.5f, 4.0f)
                .harvestLevel(0)
                .sound(SoundType.STONE));
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
