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

public class microfoon extends Block {

    private static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;

    private static final VoxelShape SHAPE_N = Stream.of(
            Block.makeCuboidShape(7, 0, 7, 9, 10, 9),
            Block.makeCuboidShape(6.5, 3.5, 7, 7, 10, 9),
            Block.makeCuboidShape(9, 3.5, 7, 9.5, 10, 9),
            Block.makeCuboidShape(7, 3.5, 9, 9, 10, 9.5),
            Block.makeCuboidShape(7, 3.5, 6.5, 9, 10, 7),
            Block.makeCuboidShape(6.5, 10, 6.5, 9.5, 10.5, 9.5),
            Block.makeCuboidShape(6, 10.5, 6.5, 6.5, 12, 9.5),
            Block.makeCuboidShape(9.5, 10.5, 6.5, 10, 12, 9.5),
            Block.makeCuboidShape(6.5, 10.5, 9.5, 9.5, 12, 10),
            Block.makeCuboidShape(6.5, 10.5, 6, 9.5, 12, 6.5),
            Block.makeCuboidShape(6.5, 13, 6, 9.5, 14, 6.5),
            Block.makeCuboidShape(6, 13, 6.5, 6.5, 14, 9.5),
            Block.makeCuboidShape(9.5, 13, 6.5, 10, 14, 9.5),
            Block.makeCuboidShape(6.5, 13, 9.5, 9.5, 14, 10),
            Block.makeCuboidShape(6.5, 10.5, 6.5, 9.5, 14, 9.5),
            Block.makeCuboidShape(6.5, 14, 6.5, 9.5, 14.5, 9.5),
            Block.makeCuboidShape(6, 12, 6, 10, 13, 10)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

    public static final VoxelShape SHAPE_E = Stream.of(
            Block.makeCuboidShape(7, 0, 7, 9, 10, 9),
            Block.makeCuboidShape(6.5, 3.5, 7, 7, 10, 9),
            Block.makeCuboidShape(9, 3.5, 7, 9.5, 10, 9),
            Block.makeCuboidShape(7, 3.5, 9, 9, 10, 9.5),
            Block.makeCuboidShape(7, 3.5, 6.5, 9, 10, 7),
            Block.makeCuboidShape(6.5, 10, 6.5, 9.5, 10.5, 9.5),
            Block.makeCuboidShape(6, 10.5, 6.5, 6.5, 12, 9.5),
            Block.makeCuboidShape(9.5, 10.5, 6.5, 10, 12, 9.5),
            Block.makeCuboidShape(6.5, 10.5, 9.5, 9.5, 12, 10),
            Block.makeCuboidShape(6.5, 10.5, 6, 9.5, 12, 6.5),
            Block.makeCuboidShape(6.5, 13, 6, 9.5, 14, 6.5),
            Block.makeCuboidShape(6, 13, 6.5, 6.5, 14, 9.5),
            Block.makeCuboidShape(9.5, 13, 6.5, 10, 14, 9.5),
            Block.makeCuboidShape(6.5, 13, 9.5, 9.5, 14, 10),
            Block.makeCuboidShape(6.5, 10.5, 6.5, 9.5, 14, 9.5),
            Block.makeCuboidShape(6.5, 14, 6.5, 9.5, 14.5, 9.5),
            Block.makeCuboidShape(6, 12, 6, 10, 13, 10)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

    public static final VoxelShape SHAPE_S = Stream.of(
            Block.makeCuboidShape(7, 0, 7, 9, 10, 9),
            Block.makeCuboidShape(6.5, 3.5, 7, 7, 10, 9),
            Block.makeCuboidShape(9, 3.5, 7, 9.5, 10, 9),
            Block.makeCuboidShape(7, 3.5, 9, 9, 10, 9.5),
            Block.makeCuboidShape(7, 3.5, 6.5, 9, 10, 7),
            Block.makeCuboidShape(6.5, 10, 6.5, 9.5, 10.5, 9.5),
            Block.makeCuboidShape(6, 10.5, 6.5, 6.5, 12, 9.5),
            Block.makeCuboidShape(9.5, 10.5, 6.5, 10, 12, 9.5),
            Block.makeCuboidShape(6.5, 10.5, 9.5, 9.5, 12, 10),
            Block.makeCuboidShape(6.5, 10.5, 6, 9.5, 12, 6.5),
            Block.makeCuboidShape(6.5, 13, 6, 9.5, 14, 6.5),
            Block.makeCuboidShape(6, 13, 6.5, 6.5, 14, 9.5),
            Block.makeCuboidShape(9.5, 13, 6.5, 10, 14, 9.5),
            Block.makeCuboidShape(6.5, 13, 9.5, 9.5, 14, 10),
            Block.makeCuboidShape(6.5, 10.5, 6.5, 9.5, 14, 9.5),
            Block.makeCuboidShape(6.5, 14, 6.5, 9.5, 14.5, 9.5),
            Block.makeCuboidShape(6, 12, 6, 10, 13, 10)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

    public static final VoxelShape SHAPE_W = Stream.of(
            Block.makeCuboidShape(7, 0, 7, 9, 10, 9),
            Block.makeCuboidShape(6.5, 3.5, 7, 7, 10, 9),
            Block.makeCuboidShape(9, 3.5, 7, 9.5, 10, 9),
            Block.makeCuboidShape(7, 3.5, 9, 9, 10, 9.5),
            Block.makeCuboidShape(7, 3.5, 6.5, 9, 10, 7),
            Block.makeCuboidShape(6.5, 10, 6.5, 9.5, 10.5, 9.5),
            Block.makeCuboidShape(6, 10.5, 6.5, 6.5, 12, 9.5),
            Block.makeCuboidShape(9.5, 10.5, 6.5, 10, 12, 9.5),
            Block.makeCuboidShape(6.5, 10.5, 9.5, 9.5, 12, 10),
            Block.makeCuboidShape(6.5, 10.5, 6, 9.5, 12, 6.5),
            Block.makeCuboidShape(6.5, 13, 6, 9.5, 14, 6.5),
            Block.makeCuboidShape(6, 13, 6.5, 6.5, 14, 9.5),
            Block.makeCuboidShape(9.5, 13, 6.5, 10, 14, 9.5),
            Block.makeCuboidShape(6.5, 13, 9.5, 9.5, 14, 10),
            Block.makeCuboidShape(6.5, 10.5, 6.5, 9.5, 14, 9.5),
            Block.makeCuboidShape(6.5, 14, 6.5, 9.5, 14.5, 9.5),
            Block.makeCuboidShape(6, 12, 6, 10, 13, 10)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

    public microfoon() {
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
