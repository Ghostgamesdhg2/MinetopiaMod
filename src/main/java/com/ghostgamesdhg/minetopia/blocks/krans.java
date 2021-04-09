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

public class krans extends Block {

    private static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;

    private static final VoxelShape SHAPE_N = Stream.of(
            Block.makeCuboidShape(0, 8.5, 10.5, 2, 10.5, 12.5),
            Block.makeCuboidShape(12.82843, 12.82843, 12, 16.82843, 17.82843, 16),
            Block.makeCuboidShape(-0.82843, 12.82843, 12, 3.17157, 17.82843, 16),
            Block.makeCuboidShape(9.29289, 0.70711, 12, 13.29289, 5.70711, 16),
            Block.makeCuboidShape(0.17157, 3.24264, 12, 5.17157, 7.24264, 16),
            Block.makeCuboidShape(-0.53553, 3.53553, 12.001, 3.46447, 13.53553, 16.001),
            Block.makeCuboidShape(12.53553, 3.53553, 12.001, 16.53553, 13.53553, 16.001),
            Block.makeCuboidShape(3, 0, 12.001, 13, 4, 16.001),
            Block.makeCuboidShape(3, 13.07107, 12.001, 13, 17.07107, 16.001),
            Block.makeCuboidShape(9.22581, 9.59554, 10.9985, 11.22581, 14.84554, 11.9985),
            Block.makeCuboidShape(5.15619, 8.52064, 11.00124, 7.15619, 14.77064, 12.00124),
            Block.makeCuboidShape(3.53503, 14.68931, 10.99983, 6.53503, 16.68931, 11.99983),
            Block.makeCuboidShape(6, 14, 11, 10, 16, 12),
            Block.makeCuboidShape(9.46518, 14.68919, 10.99995, 12.46518, 16.68919, 11.99995),
            Block.makeCuboidShape(3.25, 1.5, 10.5, 5.25, 3.5, 12.5),
            Block.makeCuboidShape(11.75, 2.75, 10.5, 13.75, 4.75, 12.5),
            Block.makeCuboidShape(13, 7, 10.5, 15, 9, 12.5)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

    public static final VoxelShape SHAPE_E = Stream.of(
            Block.makeCuboidShape(3, 8.5, 0.5, 5, 10.5, 2.5),
            Block.makeCuboidShape(-0.5, 12.82843, 13.32843, 3.5, 17.82843, 17.32843),
            Block.makeCuboidShape(-0.5, 12.82843, -0.3284300000000009, 3.5, 17.82843, 3.671569999999999),
            Block.makeCuboidShape(-0.5, 0.70711, 9.79289, 3.5, 5.70711, 13.79289),
            Block.makeCuboidShape(-0.5, 3.24264, 0.6715699999999991, 3.5, 7.24264, 5.671569999999999),
            Block.makeCuboidShape(-0.5010000000000012, 3.53553, -0.03552999999999962, 3.4990000000000006, 13.53553, 3.9644700000000004),
            Block.makeCuboidShape(-0.5010000000000012, 3.53553, 13.035530000000001, 3.4990000000000006, 13.53553, 17.03553),
            Block.makeCuboidShape(-0.5010000000000012, 0, 3.5, 3.4990000000000006, 4, 13.5),
            Block.makeCuboidShape(-0.5010000000000012, 13.07107, 3.5, 3.4990000000000006, 17.07107, 13.5),
            Block.makeCuboidShape(3.5015, 9.59554, 9.72581, 4.5015, 14.84554, 11.72581),
            Block.makeCuboidShape(3.4987600000000008, 8.52064, 5.656189999999999, 4.498760000000001, 14.77064, 7.656189999999999),
            Block.makeCuboidShape(3.5001700000000007, 14.68931, 4.035029999999999, 4.500170000000001, 16.68931, 7.035029999999999),
            Block.makeCuboidShape(3.5, 14, 6.5, 4.5, 16, 10.5),
            Block.makeCuboidShape(3.50005, 14.68919, 9.96518, 4.50005, 16.68919, 12.96518),
            Block.makeCuboidShape(3, 1.5, 3.75, 5, 3.5, 5.75),
            Block.makeCuboidShape(3, 2.75, 12.25, 5, 4.75, 14.25),
            Block.makeCuboidShape(3, 7, 13.5, 5, 9, 15.5)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

    public static final VoxelShape SHAPE_S = Stream.of(
            Block.makeCuboidShape(14.22731, 8.5, 3.724309999999999, 16.22731, 10.5, 5.724309999999999),
            Block.makeCuboidShape(-0.6011200000000017, 12.82843, 0.22430999999999912, 3.3988799999999983, 17.82843, 4.224309999999999),
            Block.makeCuboidShape(13.05574, 12.82843, 0.22430999999999912, 17.05574, 17.82843, 4.224309999999999),
            Block.makeCuboidShape(2.9344199999999994, 0.70711, 0.22430999999999912, 6.934419999999999, 5.70711, 4.224309999999999),
            Block.makeCuboidShape(11.05574, 3.24264, 0.22430999999999912, 16.05574, 7.24264, 4.224309999999999),
            Block.makeCuboidShape(12.762839999999999, 3.53553, 0.2233099999999979, 16.762839999999997, 13.53553, 4.22331),
            Block.makeCuboidShape(-0.30822000000000216, 3.53553, 0.2233099999999979, 3.691779999999998, 13.53553, 4.22331),
            Block.makeCuboidShape(3.2273099999999992, 0, 0.2233099999999979, 13.22731, 4, 4.22331),
            Block.makeCuboidShape(3.2273099999999992, 13.07107, 0.2233099999999979, 13.22731, 17.07107, 4.22331),
            Block.makeCuboidShape(5.0015, 9.59554, 4.225809999999999, 7.0015, 14.84554, 5.225809999999999),
            Block.makeCuboidShape(9.07112, 8.52064, 4.22307, 11.07112, 14.77064, 5.22307),
            Block.makeCuboidShape(9.69228, 14.68931, 4.22448, 12.69228, 16.68931, 5.22448),
            Block.makeCuboidShape(6.227309999999999, 14, 4.224309999999999, 10.22731, 16, 5.224309999999999),
            Block.makeCuboidShape(3.762129999999999, 14.68919, 4.224359999999999, 6.762129999999999, 16.68919, 5.224359999999999),
            Block.makeCuboidShape(10.97731, 1.5, 3.724309999999999, 12.97731, 3.5, 5.724309999999999),
            Block.makeCuboidShape(2.4773099999999992, 2.75, 3.724309999999999, 4.477309999999999, 4.75, 5.724309999999999),
            Block.makeCuboidShape(1.2273099999999992, 7, 3.724309999999999, 3.2273099999999992, 9, 5.724309999999999)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

    public static final VoxelShape SHAPE_W = Stream.of(
            Block.makeCuboidShape(11.003, 8.5, 12.951619999999998, 13.003, 10.5, 14.951619999999998),
            Block.makeCuboidShape(12.503, 12.82843, -1.8768100000000025, 16.503, 17.82843, 2.1231899999999975),
            Block.makeCuboidShape(12.503, 12.82843, 11.78005, 16.503, 17.82843, 15.78005),
            Block.makeCuboidShape(12.503, 0.70711, 1.6587299999999985, 16.503, 5.70711, 5.6587299999999985),
            Block.makeCuboidShape(12.503, 3.24264, 9.78005, 16.503, 7.24264, 14.78005),
            Block.makeCuboidShape(12.504, 3.53553, 11.487149999999998, 16.504, 13.53553, 15.487149999999996),
            Block.makeCuboidShape(12.504, 3.53553, -1.583910000000003, 16.504, 13.53553, 2.416089999999997),
            Block.makeCuboidShape(12.504, 0, 1.9516199999999984, 16.504, 4, 11.951619999999998),
            Block.makeCuboidShape(12.504, 13.07107, 1.9516199999999984, 16.504, 17.07107, 11.951619999999998),
            Block.makeCuboidShape(11.5015, 9.59554, 3.725809999999999, 12.5015, 14.84554, 5.725809999999999),
            Block.makeCuboidShape(11.50424, 8.52064, 7.79543, 12.50424, 14.77064, 9.79543),
            Block.makeCuboidShape(11.50283, 14.68931, 8.41659, 12.50283, 16.68931, 11.41659),
            Block.makeCuboidShape(11.503, 14, 4.951619999999998, 12.503, 16, 8.951619999999998),
            Block.makeCuboidShape(11.50295, 14.68919, 2.486439999999998, 12.50295, 16.68919, 5.486439999999998),
            Block.makeCuboidShape(11.003, 1.5, 9.701619999999998, 13.003, 3.5, 11.701619999999998),
            Block.makeCuboidShape(11.003, 2.75, 1.2016199999999984, 13.003, 4.75, 3.2016199999999984),
            Block.makeCuboidShape(11.003, 7, -0.048380000000001644, 13.003, 9, 1.9516199999999984)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

    public krans() {
        super(Properties.create(Material.LEAVES)
                .hardnessAndResistance(3.5f, 4.0f)
                .harvestLevel(0)
                .sound(SoundType.LILY_PADS));
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
