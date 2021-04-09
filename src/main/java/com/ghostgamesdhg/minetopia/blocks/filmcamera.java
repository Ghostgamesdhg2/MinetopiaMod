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

public class filmcamera extends Block {

    private static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;

    private static final VoxelShape SHAPE_N = Stream.of(
            Block.makeCuboidShape(7, 0.5, 1.5, 9, 2.5, 2),
            Block.makeCuboidShape(6.5, 0.5, 1, 7, 2.5, 3),
            Block.makeCuboidShape(9, 0.5, 1, 9.5, 2.5, 3),
            Block.makeCuboidShape(6.5, 2.5, 1, 9.5, 3, 3),
            Block.makeCuboidShape(6.5, 0, 1, 9.5, 0.5, 3),
            Block.makeCuboidShape(7, 0.5, 3, 9, 2.5, 4),
            Block.makeCuboidShape(6.5, 0, 4, 9.5, 3, 4.5),
            Block.makeCuboidShape(6, -0.5, 4.5, 10, 3.5, 12.5),
            Block.makeCuboidShape(10, 0, 10, 10.5, 3, 12),
            Block.makeCuboidShape(10, -0.0439, 5.6061, 10.5, 1.4561, 8.6061),
            Block.makeCuboidShape(10.5, 0.8975, 6.2475, 11, 1.3975, 8.2475),
            Block.makeCuboidShape(10.5, 0.3975, 6.2475, 11, 0.8975, 8.2475),
            Block.makeCuboidShape(5, 0.5, 5, 6, 2, 6.5),
            Block.makeCuboidShape(1.5, 0, 5.5, 5.5, 2.5, 6),
            Block.makeCuboidShape(2, 0.5, 5.499, 4.5, 2, 5.5),
            Block.makeCuboidShape(2, 0.5, 6, 4.5, 2, 6.001),
            Block.makeCuboidShape(5.999, 0.5, 7, 6, 2.5, 11.5),
            Block.makeCuboidShape(6.5, 0, 12.5, 9.5, 3, 13),
            Block.makeCuboidShape(7, 3.5, 7.5, 8.5, 4, 11.5),
            Block.makeCuboidShape(7.5, 3.5, 7.5, 8, 5.5, 8),
            Block.makeCuboidShape(7.5, 3.5, 10.5, 8, 5.5, 11),
            Block.makeCuboidShape(7.5, 5, 6.5, 8, 5.5, 11),
            Block.makeCuboidShape(7.5, 5, 5, 8.5, 6, 6.5),
            Block.makeCuboidShape(7, 5, 1, 8.5, 6.5, 5),
            Block.makeCuboidShape(7, 4.5, 11, 8.5, 6, 13.5),
            Block.makeCuboidShape(6.5, 4, 13.5, 9, 6.5, 14),
            Block.makeCuboidShape(7, 4.5, 14, 8.5, 6, 14.001),
            Block.makeCuboidShape(6.5, 4, 14, 7, 6.5, 14.5),
            Block.makeCuboidShape(8.5, 4, 14, 9, 6.5, 14.5),
            Block.makeCuboidShape(7, 6, 14, 8.5, 6.5, 14.5),
            Block.makeCuboidShape(7, 4, 14, 8.5, 4.5, 14.5)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

    public static final VoxelShape SHAPE_E = Stream.of(
            Block.makeCuboidShape(14, 0.5, 7, 14.5, 2.5, 9),
            Block.makeCuboidShape(13, 0.5, 6.5, 15, 2.5, 7),
            Block.makeCuboidShape(13, 0.5, 9, 15, 2.5, 9.5),
            Block.makeCuboidShape(13, 2.5, 6.5, 15, 3, 9.5),
            Block.makeCuboidShape(13, 0, 6.5, 15, 0.5, 9.5),
            Block.makeCuboidShape(12, 0.5, 7, 13, 2.5, 9),
            Block.makeCuboidShape(11.5, 0, 6.5, 12, 3, 9.5),
            Block.makeCuboidShape(3.5, -0.5, 6, 11.5, 3.5, 10),
            Block.makeCuboidShape(4, 0, 10, 6, 3, 10.5),
            Block.makeCuboidShape(7.3939, -0.0439, 10, 10.3939, 1.4561, 10.5),
            Block.makeCuboidShape(7.7524999999999995, 0.8975, 10.5, 9.752500000000001, 1.3975, 11),
            Block.makeCuboidShape(7.7524999999999995, 0.3975, 10.5, 9.752500000000001, 0.8975, 11),
            Block.makeCuboidShape(9.5, 0.5, 5, 11, 2, 6),
            Block.makeCuboidShape(10, 0, 1.5, 10.5, 2.5, 5.5),
            Block.makeCuboidShape(10.5, 0.5, 2, 10.501000000000001, 2, 4.5),
            Block.makeCuboidShape(9.998999999999999, 0.5, 2, 10, 2, 4.5),
            Block.makeCuboidShape(4.5, 0.5, 5.999, 9, 2.5, 6),
            Block.makeCuboidShape(3, 0, 6.5, 3.5, 3, 9.5),
            Block.makeCuboidShape(4.5, 3.5, 7, 8.5, 4, 8.5),
            Block.makeCuboidShape(8, 3.5, 7.5, 8.5, 5.5, 8),
            Block.makeCuboidShape(5, 3.5, 7.5, 5.5, 5.5, 8),
            Block.makeCuboidShape(5, 5, 7.5, 9.5, 5.5, 8),
            Block.makeCuboidShape(9.5, 5, 7.5, 11, 6, 8.5),
            Block.makeCuboidShape(11, 5, 7, 15, 6.5, 8.5),
            Block.makeCuboidShape(2.5, 4.5, 7, 5, 6, 8.5),
            Block.makeCuboidShape(2, 4, 6.5, 2.5, 6.5, 9),
            Block.makeCuboidShape(1.9990000000000006, 4.5, 7, 2, 6, 8.5),
            Block.makeCuboidShape(1.5, 4, 6.5, 2, 6.5, 7),
            Block.makeCuboidShape(1.5, 4, 8.5, 2, 6.5, 9),
            Block.makeCuboidShape(1.5, 6, 7, 2, 6.5, 8.5),
            Block.makeCuboidShape(1.5, 4, 7, 2, 4.5, 8.5)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

    public static final VoxelShape SHAPE_S = Stream.of(
            Block.makeCuboidShape(7, 0.5, 14, 9, 2.5, 14.5),
            Block.makeCuboidShape(9, 0.5, 13, 9.5, 2.5, 15),
            Block.makeCuboidShape(6.5, 0.5, 13, 7, 2.5, 15),
            Block.makeCuboidShape(6.5, 2.5, 13, 9.5, 3, 15),
            Block.makeCuboidShape(6.5, 0, 13, 9.5, 0.5, 15),
            Block.makeCuboidShape(7, 0.5, 12, 9, 2.5, 13),
            Block.makeCuboidShape(6.5, 0, 11.5, 9.5, 3, 12),
            Block.makeCuboidShape(6, -0.5, 3.5, 10, 3.5, 11.5),
            Block.makeCuboidShape(5.5, 0, 4, 6, 3, 6),
            Block.makeCuboidShape(5.5, -0.0439, 7.3939, 6, 1.4561, 10.3939),
            Block.makeCuboidShape(5, 0.8975, 7.7524999999999995, 5.5, 1.3975, 9.752500000000001),
            Block.makeCuboidShape(5, 0.3975, 7.7524999999999995, 5.5, 0.8975, 9.752500000000001),
            Block.makeCuboidShape(10, 0.5, 9.5, 11, 2, 11),
            Block.makeCuboidShape(10.5, 0, 10, 14.5, 2.5, 10.5),
            Block.makeCuboidShape(11.5, 0.5, 10.5, 14, 2, 10.501000000000001),
            Block.makeCuboidShape(11.5, 0.5, 9.998999999999999, 14, 2, 10),
            Block.makeCuboidShape(10, 0.5, 4.5, 10.001000000000001, 2.5, 9),
            Block.makeCuboidShape(6.5, 0, 3, 9.5, 3, 3.5),
            Block.makeCuboidShape(7.5, 3.5, 4.5, 9, 4, 8.5),
            Block.makeCuboidShape(8, 3.5, 8, 8.5, 5.5, 8.5),
            Block.makeCuboidShape(8, 3.5, 5, 8.5, 5.5, 5.5),
            Block.makeCuboidShape(8, 5, 5, 8.5, 5.5, 9.5),
            Block.makeCuboidShape(7.5, 5, 9.5, 8.5, 6, 11),
            Block.makeCuboidShape(7.5, 5, 11, 9, 6.5, 15),
            Block.makeCuboidShape(7.5, 4.5, 2.5, 9, 6, 5),
            Block.makeCuboidShape(7, 4, 2, 9.5, 6.5, 2.5),
            Block.makeCuboidShape(7.5, 4.5, 1.9990000000000006, 9, 6, 2),
            Block.makeCuboidShape(9, 4, 1.5, 9.5, 6.5, 2),
            Block.makeCuboidShape(7, 4, 1.5, 7.5, 6.5, 2),
            Block.makeCuboidShape(7.5, 6, 1.5, 9, 6.5, 2),
            Block.makeCuboidShape(7.5, 4, 1.5, 9, 4.5, 2)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

    public static final VoxelShape SHAPE_W = Stream.of(
            Block.makeCuboidShape(1.5, 0.5, 7, 2, 2.5, 9),
            Block.makeCuboidShape(1, 0.5, 9, 3, 2.5, 9.5),
            Block.makeCuboidShape(1, 0.5, 6.5, 3, 2.5, 7),
            Block.makeCuboidShape(1, 2.5, 6.5, 3, 3, 9.5),
            Block.makeCuboidShape(1, 0, 6.5, 3, 0.5, 9.5),
            Block.makeCuboidShape(3, 0.5, 7, 4, 2.5, 9),
            Block.makeCuboidShape(4, 0, 6.5, 4.5, 3, 9.5),
            Block.makeCuboidShape(4.5, -0.5, 6, 12.5, 3.5, 10),
            Block.makeCuboidShape(10, 0, 5.5, 12, 3, 6),
            Block.makeCuboidShape(5.606099999999998, -0.0439, 5.5, 8.606099999999998, 1.4561, 6),
            Block.makeCuboidShape(6.247499999999999, 0.8975, 5, 8.247500000000002, 1.3975, 5.5),
            Block.makeCuboidShape(6.247499999999999, 0.3975, 5, 8.247500000000002, 0.8975, 5.5),
            Block.makeCuboidShape(5, 0.5, 10, 6.5, 2, 11),
            Block.makeCuboidShape(5.5, 0, 10.5, 6, 2.5, 14.5),
            Block.makeCuboidShape(5.498999999999999, 0.5, 11.5, 5.5, 2, 14),
            Block.makeCuboidShape(6, 0.5, 11.5, 6.001000000000001, 2, 14),
            Block.makeCuboidShape(7, 0.5, 10, 11.5, 2.5, 10.001000000000001),
            Block.makeCuboidShape(12.5, 0, 6.5, 13, 3, 9.5),
            Block.makeCuboidShape(7.5, 3.5, 7.5, 11.5, 4, 9),
            Block.makeCuboidShape(7.5, 3.5, 8, 8, 5.5, 8.5),
            Block.makeCuboidShape(10.5, 3.5, 8, 11, 5.5, 8.5),
            Block.makeCuboidShape(6.5, 5, 8, 11, 5.5, 8.5),
            Block.makeCuboidShape(5, 5, 7.5, 6.5, 6, 8.5),
            Block.makeCuboidShape(1, 5, 7.5, 5, 6.5, 9),
            Block.makeCuboidShape(11, 4.5, 7.5, 13.5, 6, 9),
            Block.makeCuboidShape(13.5, 4, 7, 14, 6.5, 9.5),
            Block.makeCuboidShape(14, 4.5, 7.5, 14.000999999999998, 6, 9),
            Block.makeCuboidShape(14, 4, 9, 14.5, 6.5, 9.5),
            Block.makeCuboidShape(14, 4, 7, 14.5, 6.5, 7.5),
            Block.makeCuboidShape(14, 6, 7.5, 14.5, 6.5, 9),
            Block.makeCuboidShape(14, 4, 7.5, 14.5, 4.5, 9)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

    public filmcamera() {
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
