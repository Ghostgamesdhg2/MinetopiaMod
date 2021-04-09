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

public class luckybag extends Block {

    private static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;

    private static final VoxelShape SHAPE_N = Stream.of(
            Block.makeCuboidShape(11.8, 0, 5, 12.8, 1, 7.6),
            Block.makeCuboidShape(4, 0, 6.8, 4.5, 1, 9.7),
            Block.makeCuboidShape(3.5, 0, 6.8, 4, 9, 9.7),
            Block.makeCuboidShape(12.7, 0, 5, 13.1, 9, 7.6),
            Block.makeCuboidShape(11.2, 0, 9.2, 12.2, 1, 11.6),
            Block.makeCuboidShape(4.2, 0, 7.2, 4.7, 9, 9.6),
            Block.makeCuboidShape(4.4, 0, 7.2, 4.9, 0.9, 9.6),
            Block.makeCuboidShape(12.1, 0, 9.2, 12.6, 9, 11.4),
            Block.makeCuboidShape(3.2, 0, 10.2, 13.2, 9, 11.2),
            Block.makeCuboidShape(7, 11.5, 10.6, 9.5, 11.8, 10.9),
            Block.makeCuboidShape(7, 11.5, 5.6, 9.5, 11.8, 5.9),
            Block.makeCuboidShape(8.5, 12.5, 10.6, 9.5, 12.8, 10.9),
            Block.makeCuboidShape(8.5, 12.5, 5.6, 9.5, 12.8, 5.9),
            Block.makeCuboidShape(7.4, 10.6, 10.6, 8.4, 10.9, 10.9),
            Block.makeCuboidShape(7.4, 10.6, 5.6, 8.4, 10.9, 5.9),
            Block.makeCuboidShape(3.2, 9.2, 10.6, 3.5, 10.2, 10.9),
            Block.makeCuboidShape(3.2, 9.2, 5.6, 3.5, 10.2, 5.9),
            Block.makeCuboidShape(11.4, 13.3, 10.6, 11.7, 14.3, 10.9),
            Block.makeCuboidShape(11.4, 13.3, 5.6, 11.7, 14.3, 5.9),
            Block.makeCuboidShape(11.7, 11.1, 10.6, 12, 12.1, 10.9),
            Block.makeCuboidShape(11.7, 11.1, 5.6, 12, 12.1, 5.9),
            Block.makeCuboidShape(4.2, 8.9, 10.6, 4.5, 9.9, 10.9),
            Block.makeCuboidShape(4.2, 8.9, 5.6, 4.5, 9.9, 5.9),
            Block.makeCuboidShape(5.2, 9, 10.6, 5.5, 10, 10.9),
            Block.makeCuboidShape(5.2, 9, 5.6, 5.5, 10, 5.9),
            Block.makeCuboidShape(11.1, 9, 10.6, 11.4, 10, 10.9),
            Block.makeCuboidShape(11.1, 9, 5.6, 11.4, 10, 5.9),
            Block.makeCuboidShape(3.1, 0, 5.2, 13.2, 9, 6.2),
            Block.makeCuboidShape(5.8, 7, 7.2, 8.5, 8.2, 10.1),
            Block.makeCuboidShape(4.5, 7, 8.2, 5.5, 8.6, 10.1),
            Block.makeCuboidShape(5.5, 7, 6.2, 6.4, 8.5, 7.2),
            Block.makeCuboidShape(9.5, 7, 9.2, 10.2, 8.2, 10.1),
            Block.makeCuboidShape(8.5, 7, 6.2, 11.2, 8.2, 9.1),
            Block.makeCuboidShape(4.1, 6, 6.2, 12.2, 7, 10.2),
            Block.makeCuboidShape(4.1, 0, 6.2, 12.2, 1, 10.2)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

    public static final VoxelShape SHAPE_E = Stream.of(
            Block.makeCuboidShape(7.6000000000000005, 0, 11, 10.2, 1, 12),
            Block.makeCuboidShape(5.500000000000001, 0, 3.2, 8.4, 1, 3.7),
            Block.makeCuboidShape(5.500000000000001, 0, 2.7, 8.4, 9, 3.2),
            Block.makeCuboidShape(7.6000000000000005, 0, 11.899999999999999, 10.2, 9, 12.3),
            Block.makeCuboidShape(3.6000000000000005, 0, 10.399999999999999, 6.000000000000001, 1, 11.399999999999999),
            Block.makeCuboidShape(5.6000000000000005, 0, 3.4000000000000004, 8, 9, 3.9000000000000004),
            Block.makeCuboidShape(5.6000000000000005, 0, 3.6000000000000005, 8, 0.9, 4.1000000000000005),
            Block.makeCuboidShape(3.8, 0, 11.3, 6.000000000000001, 9, 11.8),
            Block.makeCuboidShape(4.000000000000001, 0, 2.4000000000000004, 5.000000000000001, 9, 12.399999999999999),
            Block.makeCuboidShape(4.3, 11.5, 6.199999999999999, 4.6000000000000005, 11.8, 8.7),
            Block.makeCuboidShape(9.3, 11.5, 6.199999999999999, 9.600000000000001, 11.8, 8.7),
            Block.makeCuboidShape(4.3, 12.5, 7.699999999999999, 4.6000000000000005, 12.8, 8.7),
            Block.makeCuboidShape(9.3, 12.5, 7.699999999999999, 9.600000000000001, 12.8, 8.7),
            Block.makeCuboidShape(4.3, 10.6, 6.600000000000001, 4.6000000000000005, 10.9, 7.600000000000001),
            Block.makeCuboidShape(9.3, 10.6, 6.600000000000001, 9.600000000000001, 10.9, 7.600000000000001),
            Block.makeCuboidShape(4.3, 9.2, 2.4000000000000004, 4.6000000000000005, 10.2, 2.7),
            Block.makeCuboidShape(9.3, 9.2, 2.4000000000000004, 9.600000000000001, 10.2, 2.7),
            Block.makeCuboidShape(4.3, 13.3, 10.600000000000001, 4.6000000000000005, 14.3, 10.899999999999999),
            Block.makeCuboidShape(9.3, 13.3, 10.600000000000001, 9.600000000000001, 14.3, 10.899999999999999),
            Block.makeCuboidShape(4.3, 11.1, 10.899999999999999, 4.6000000000000005, 12.1, 11.2),
            Block.makeCuboidShape(9.3, 11.1, 10.899999999999999, 9.600000000000001, 12.1, 11.2),
            Block.makeCuboidShape(4.3, 8.9, 3.4000000000000004, 4.6000000000000005, 9.9, 3.7),
            Block.makeCuboidShape(9.3, 8.9, 3.4000000000000004, 9.600000000000001, 9.9, 3.7),
            Block.makeCuboidShape(4.3, 9, 4.4, 4.6000000000000005, 10, 4.7),
            Block.makeCuboidShape(9.3, 9, 4.4, 9.600000000000001, 10, 4.7),
            Block.makeCuboidShape(4.3, 9, 10.3, 4.6000000000000005, 10, 10.600000000000001),
            Block.makeCuboidShape(9.3, 9, 10.3, 9.600000000000001, 10, 10.600000000000001),
            Block.makeCuboidShape(9, 0, 2.3, 10, 9, 12.399999999999999),
            Block.makeCuboidShape(5.1000000000000005, 7, 5, 8, 8.2, 7.699999999999999),
            Block.makeCuboidShape(5.1000000000000005, 7, 3.7, 7.000000000000001, 8.6, 4.7),
            Block.makeCuboidShape(8, 7, 4.7, 9, 8.5, 5.6000000000000005),
            Block.makeCuboidShape(5.1000000000000005, 7, 8.7, 6.000000000000001, 8.2, 9.399999999999999),
            Block.makeCuboidShape(6.1000000000000005, 7, 7.699999999999999, 9, 8.2, 10.399999999999999),
            Block.makeCuboidShape(5.000000000000001, 6, 3.3, 9, 7, 11.399999999999999),
            Block.makeCuboidShape(5.000000000000001, 0, 3.3, 9, 1, 11.399999999999999)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

    public static final VoxelShape SHAPE_S = Stream.of(
            Block.makeCuboidShape(11.8, 0, 5, 12.8, 1, 7.6),
            Block.makeCuboidShape(4, 0, 6.8, 4.5, 1, 9.7),
            Block.makeCuboidShape(3.5, 0, 6.8, 4, 9, 9.7),
            Block.makeCuboidShape(12.7, 0, 5, 13.1, 9, 7.6),
            Block.makeCuboidShape(11.2, 0, 9.2, 12.2, 1, 11.6),
            Block.makeCuboidShape(4.2, 0, 7.2, 4.7, 9, 9.6),
            Block.makeCuboidShape(4.4, 0, 7.2, 4.9, 0.9, 9.6),
            Block.makeCuboidShape(12.1, 0, 9.2, 12.6, 9, 11.4),
            Block.makeCuboidShape(3.2, 0, 10.2, 13.2, 9, 11.2),
            Block.makeCuboidShape(7, 11.5, 10.6, 9.5, 11.8, 10.9),
            Block.makeCuboidShape(7, 11.5, 5.6, 9.5, 11.8, 5.9),
            Block.makeCuboidShape(8.5, 12.5, 10.6, 9.5, 12.8, 10.9),
            Block.makeCuboidShape(8.5, 12.5, 5.6, 9.5, 12.8, 5.9),
            Block.makeCuboidShape(7.4, 10.6, 10.6, 8.4, 10.9, 10.9),
            Block.makeCuboidShape(7.4, 10.6, 5.6, 8.4, 10.9, 5.9),
            Block.makeCuboidShape(3.2, 9.2, 10.6, 3.5, 10.2, 10.9),
            Block.makeCuboidShape(3.2, 9.2, 5.6, 3.5, 10.2, 5.9),
            Block.makeCuboidShape(11.4, 13.3, 10.6, 11.7, 14.3, 10.9),
            Block.makeCuboidShape(11.4, 13.3, 5.6, 11.7, 14.3, 5.9),
            Block.makeCuboidShape(11.7, 11.1, 10.6, 12, 12.1, 10.9),
            Block.makeCuboidShape(11.7, 11.1, 5.6, 12, 12.1, 5.9),
            Block.makeCuboidShape(4.2, 8.9, 10.6, 4.5, 9.9, 10.9),
            Block.makeCuboidShape(4.2, 8.9, 5.6, 4.5, 9.9, 5.9),
            Block.makeCuboidShape(5.2, 9, 10.6, 5.5, 10, 10.9),
            Block.makeCuboidShape(5.2, 9, 5.6, 5.5, 10, 5.9),
            Block.makeCuboidShape(11.1, 9, 10.6, 11.4, 10, 10.9),
            Block.makeCuboidShape(11.1, 9, 5.6, 11.4, 10, 5.9),
            Block.makeCuboidShape(3.1, 0, 5.2, 13.2, 9, 6.2),
            Block.makeCuboidShape(5.8, 7, 7.2, 8.5, 8.2, 10.1),
            Block.makeCuboidShape(4.5, 7, 8.2, 5.5, 8.6, 10.1),
            Block.makeCuboidShape(5.5, 7, 6.2, 6.4, 8.5, 7.2),
            Block.makeCuboidShape(9.5, 7, 9.2, 10.2, 8.2, 10.1),
            Block.makeCuboidShape(8.5, 7, 6.2, 11.2, 8.2, 9.1),
            Block.makeCuboidShape(4.1, 6, 6.2, 12.2, 7, 10.2),
            Block.makeCuboidShape(4.1, 0, 6.2, 12.2, 1, 10.2)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

    public static final VoxelShape SHAPE_W = Stream.of(
            Block.makeCuboidShape(7.6000000000000005, 0, 11, 10.2, 1, 12),
            Block.makeCuboidShape(5.500000000000001, 0, 3.2, 8.4, 1, 3.7),
            Block.makeCuboidShape(5.500000000000001, 0, 2.7, 8.4, 9, 3.2),
            Block.makeCuboidShape(7.6000000000000005, 0, 11.899999999999999, 10.2, 9, 12.3),
            Block.makeCuboidShape(3.6000000000000005, 0, 10.399999999999999, 6.000000000000001, 1, 11.399999999999999),
            Block.makeCuboidShape(5.6000000000000005, 0, 3.4000000000000004, 8, 9, 3.9000000000000004),
            Block.makeCuboidShape(5.6000000000000005, 0, 3.6000000000000005, 8, 0.9, 4.1000000000000005),
            Block.makeCuboidShape(3.8, 0, 11.3, 6.000000000000001, 9, 11.8),
            Block.makeCuboidShape(4.000000000000001, 0, 2.4000000000000004, 5.000000000000001, 9, 12.399999999999999),
            Block.makeCuboidShape(4.3, 11.5, 6.199999999999999, 4.6000000000000005, 11.8, 8.7),
            Block.makeCuboidShape(9.3, 11.5, 6.199999999999999, 9.600000000000001, 11.8, 8.7),
            Block.makeCuboidShape(4.3, 12.5, 7.699999999999999, 4.6000000000000005, 12.8, 8.7),
            Block.makeCuboidShape(9.3, 12.5, 7.699999999999999, 9.600000000000001, 12.8, 8.7),
            Block.makeCuboidShape(4.3, 10.6, 6.600000000000001, 4.6000000000000005, 10.9, 7.600000000000001),
            Block.makeCuboidShape(9.3, 10.6, 6.600000000000001, 9.600000000000001, 10.9, 7.600000000000001),
            Block.makeCuboidShape(4.3, 9.2, 2.4000000000000004, 4.6000000000000005, 10.2, 2.7),
            Block.makeCuboidShape(9.3, 9.2, 2.4000000000000004, 9.600000000000001, 10.2, 2.7),
            Block.makeCuboidShape(4.3, 13.3, 10.600000000000001, 4.6000000000000005, 14.3, 10.899999999999999),
            Block.makeCuboidShape(9.3, 13.3, 10.600000000000001, 9.600000000000001, 14.3, 10.899999999999999),
            Block.makeCuboidShape(4.3, 11.1, 10.899999999999999, 4.6000000000000005, 12.1, 11.2),
            Block.makeCuboidShape(9.3, 11.1, 10.899999999999999, 9.600000000000001, 12.1, 11.2),
            Block.makeCuboidShape(4.3, 8.9, 3.4000000000000004, 4.6000000000000005, 9.9, 3.7),
            Block.makeCuboidShape(9.3, 8.9, 3.4000000000000004, 9.600000000000001, 9.9, 3.7),
            Block.makeCuboidShape(4.3, 9, 4.4, 4.6000000000000005, 10, 4.7),
            Block.makeCuboidShape(9.3, 9, 4.4, 9.600000000000001, 10, 4.7),
            Block.makeCuboidShape(4.3, 9, 10.3, 4.6000000000000005, 10, 10.600000000000001),
            Block.makeCuboidShape(9.3, 9, 10.3, 9.600000000000001, 10, 10.600000000000001),
            Block.makeCuboidShape(9, 0, 2.3, 10, 9, 12.399999999999999),
            Block.makeCuboidShape(5.1000000000000005, 7, 5, 8, 8.2, 7.699999999999999),
            Block.makeCuboidShape(5.1000000000000005, 7, 3.7, 7.000000000000001, 8.6, 4.7),
            Block.makeCuboidShape(8, 7, 4.7, 9, 8.5, 5.6000000000000005),
            Block.makeCuboidShape(5.1000000000000005, 7, 8.7, 6.000000000000001, 8.2, 9.399999999999999),
            Block.makeCuboidShape(6.1000000000000005, 7, 7.699999999999999, 9, 8.2, 10.399999999999999),
            Block.makeCuboidShape(5.000000000000001, 6, 3.3, 9, 7, 11.399999999999999),
            Block.makeCuboidShape(5.000000000000001, 0, 3.3, 9, 1, 11.399999999999999)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

    public luckybag() {
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
