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
import java.util.function.ToIntFunction;
import java.util.stream.Stream;

public class lantaarn extends Block {

    private static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;

    private static final VoxelShape SHAPE_N = Stream.of(
            Block.makeCuboidShape(5.55, 6.558, 5.378, 10.61, 7.248, 10.438),
            Block.makeCuboidShape(6.28, 7.018, 7.448, 6.74, 9.778, 8.368),
            Block.makeCuboidShape(6.28, 9.778, 7.448, 9.92, 10.698, 8.368),
            Block.makeCuboidShape(8.01, 4.608, 7.588, 8.4, 5.558, 7.978),
            Block.makeCuboidShape(7.76, 4.608, 7.588, 8.15, 5.308, 8.228),
            Block.makeCuboidShape(7.51, 3.108, 7.338, 8.65, 4.808, 8.478),
            Block.makeCuboidShape(6.01, 3.108, 5.838, 10.15, 6.558, 9.978),
            Block.makeCuboidShape(9.46, 7.018, 7.448, 9.92, 9.778, 8.368),
            Block.makeCuboidShape(5.55, 2.418, 5.378, 10.61, 3.108, 10.438),
            Block.makeCuboidShape(5.78, 0.808, 5.608, 10.38, 2.418, 10.208),
            Block.makeCuboidShape(5.55, -0.342, 5.378, 10.61, 0.808, 10.438)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

    public static final VoxelShape SHAPE_E = Stream.of(
            Block.makeCuboidShape(5.561999999999999, 6.558, 5.55, 10.622, 7.248, 10.61),
            Block.makeCuboidShape(7.632, 7.018, 6.28, 8.552, 9.778, 6.74),
            Block.makeCuboidShape(7.632, 9.778, 6.28, 8.552, 10.698, 9.92),
            Block.makeCuboidShape(8.022, 4.608, 8.01, 8.411999999999999, 5.558, 8.4),
            Block.makeCuboidShape(7.772, 4.608, 7.76, 8.411999999999999, 5.308, 8.15),
            Block.makeCuboidShape(7.522, 3.108, 7.51, 8.661999999999999, 4.808, 8.65),
            Block.makeCuboidShape(6.022, 3.108, 6.01, 10.161999999999999, 6.558, 10.15),
            Block.makeCuboidShape(7.632, 7.018, 9.46, 8.552, 9.778, 9.92),
            Block.makeCuboidShape(5.561999999999999, 2.418, 5.55, 10.622, 3.108, 10.61),
            Block.makeCuboidShape(5.792, 0.808, 5.78, 10.392, 2.418, 10.38),
            Block.makeCuboidShape(5.561999999999999, -0.342, 5.55, 10.622, 0.808, 10.61)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

    public static final VoxelShape SHAPE_S = Stream.of(
            Block.makeCuboidShape(5.55, 6.558, 5.378, 10.61, 7.248, 10.438),
            Block.makeCuboidShape(6.28, 7.018, 7.448, 6.74, 9.778, 8.368),
            Block.makeCuboidShape(6.28, 9.778, 7.448, 9.92, 10.698, 8.368),
            Block.makeCuboidShape(8.01, 4.608, 7.588, 8.4, 5.558, 7.978),
            Block.makeCuboidShape(7.76, 4.608, 7.588, 8.15, 5.308, 8.228),
            Block.makeCuboidShape(7.51, 3.108, 7.338, 8.65, 4.808, 8.478),
            Block.makeCuboidShape(6.01, 3.108, 5.838, 10.15, 6.558, 9.978),
            Block.makeCuboidShape(9.46, 7.018, 7.448, 9.92, 9.778, 8.368),
            Block.makeCuboidShape(5.55, 2.418, 5.378, 10.61, 3.108, 10.438),
            Block.makeCuboidShape(5.78, 0.808, 5.608, 10.38, 2.418, 10.208),
            Block.makeCuboidShape(5.55, -0.342, 5.378, 10.61, 0.808, 10.438)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

    public static final VoxelShape SHAPE_W = Stream.of(
            Block.makeCuboidShape(5.561999999999999, 6.558, 5.55, 10.622, 7.248, 10.61),
            Block.makeCuboidShape(7.632, 7.018, 6.28, 8.552, 9.778, 6.74),
            Block.makeCuboidShape(7.632, 9.778, 6.28, 8.552, 10.698, 9.92),
            Block.makeCuboidShape(8.022, 4.608, 8.01, 8.411999999999999, 5.558, 8.4),
            Block.makeCuboidShape(7.772, 4.608, 7.76, 8.411999999999999, 5.308, 8.15),
            Block.makeCuboidShape(7.522, 3.108, 7.51, 8.661999999999999, 4.808, 8.65),
            Block.makeCuboidShape(6.022, 3.108, 6.01, 10.161999999999999, 6.558, 10.15),
            Block.makeCuboidShape(7.632, 7.018, 9.46, 8.552, 9.778, 9.92),
            Block.makeCuboidShape(5.561999999999999, 2.418, 5.55, 10.622, 3.108, 10.61),
            Block.makeCuboidShape(5.792, 0.808, 5.78, 10.392, 2.418, 10.38),
            Block.makeCuboidShape(5.561999999999999, -0.342, 5.55, 10.622, 0.808, 10.61)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

    public lantaarn() {
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
