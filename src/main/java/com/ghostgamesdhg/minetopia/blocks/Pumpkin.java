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

public class Pumpkin extends Block {

    private static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;
    private static final VoxelShape SHAPE_N = Stream.of(
            Block.makeCuboidShape(6, 18, 10, 7, 20, 11),
            Block.makeCuboidShape(2, 0, 3, 3, 2, 13),
            Block.makeCuboidShape(3, 0, 2, 13, 2, 3),
            Block.makeCuboidShape(13, 0, 3, 14, 2, 13),
            Block.makeCuboidShape(3, 0, 13, 13, 14, 14),
            Block.makeCuboidShape(3, 0, 3, 13, 1, 13),
            Block.makeCuboidShape(12, 2, 2, 14, 4, 3),
            Block.makeCuboidShape(7, 2, 2, 8, 3, 3),
            Block.makeCuboidShape(6, 2, 2, 7, 4, 3),
            Block.makeCuboidShape(5, 2, 2, 6, 3, 3),
            Block.makeCuboidShape(2, 1, 2, 4, 5, 3),
            Block.makeCuboidShape(9, 2, 2, 10, 5, 3),
            Block.makeCuboidShape(10, 2, 2, 11, 3, 3),
            Block.makeCuboidShape(13, 4, 2, 14, 7, 3),
            Block.makeCuboidShape(12, 6, 2, 13, 7, 3),
            Block.makeCuboidShape(10, 6, 2, 11, 7, 3),
            Block.makeCuboidShape(6, 6, 2, 9, 7, 3),
            Block.makeCuboidShape(7, 5, 2, 8, 6, 3),
            Block.makeCuboidShape(3, 5, 2, 5, 7, 3),
            Block.makeCuboidShape(2, 5, 2, 3, 7, 3),
            Block.makeCuboidShape(2, 7, 2, 14, 8, 3),
            Block.makeCuboidShape(6, 8, 2, 10, 9, 3),
            Block.makeCuboidShape(7, 9, 2, 9, 13, 3),
            Block.makeCuboidShape(12, 8, 2, 13, 9, 3),
            Block.makeCuboidShape(13, 8, 2, 14, 9, 3),
            Block.makeCuboidShape(12, 9, 2, 14, 12, 3),
            Block.makeCuboidShape(11, 11, 2, 12, 12, 3),
            Block.makeCuboidShape(9, 12, 2, 10, 13, 3),
            Block.makeCuboidShape(10, 12, 2, 14, 13, 3),
            Block.makeCuboidShape(2, 8, 2, 3, 9, 3),
            Block.makeCuboidShape(2, 9, 2, 3, 10, 3),
            Block.makeCuboidShape(3, 9, 2, 4, 10, 3),
            Block.makeCuboidShape(4, 12, 2, 7, 13, 3),
            Block.makeCuboidShape(2, 10, 2, 4, 13, 3),
            Block.makeCuboidShape(6, 11, 2, 7, 12, 3),
            Block.makeCuboidShape(4, 11, 2, 5, 12, 3),
            Block.makeCuboidShape(3, 13, 2, 13, 14, 3),
            Block.makeCuboidShape(2, 1, 3, 3, 14, 14),
            Block.makeCuboidShape(13, 1, 3, 14, 14, 14),
            Block.makeCuboidShape(3, 1, 3, 13, 12, 4),
            Block.makeCuboidShape(3, 13, 3, 13, 14, 13),
            Block.makeCuboidShape(1, 1, 3, 2, 13, 13),
            Block.makeCuboidShape(14, 1, 3, 15, 13, 13),
            Block.makeCuboidShape(13, 1, 2, 14, 2, 3),
            Block.makeCuboidShape(3, 1, 14, 13, 13, 15),
            Block.makeCuboidShape(4, 13, 14, 12, 14, 15),
            Block.makeCuboidShape(4, 0, 14, 12, 1, 15),
            Block.makeCuboidShape(3, 14, 4, 13, 15, 13),
            Block.makeCuboidShape(2, 14, 5, 3, 15, 12),
            Block.makeCuboidShape(13, 14, 5, 14, 15, 12),
            Block.makeCuboidShape(4, 14, 13, 12, 15, 14),
            Block.makeCuboidShape(4, 14, 3, 12, 15, 4),
            Block.makeCuboidShape(7, 15, 8, 9, 17, 10),
            Block.makeCuboidShape(6, 17, 9, 8, 20, 10),
            Block.makeCuboidShape(6, 17, 10, 8, 18, 11),
            Block.makeCuboidShape(5, 20, 8, 6, 22, 9)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

    public static final VoxelShape SHAPE_E = Stream.of(
            Block.makeCuboidShape(5, 18, 6, 6, 20, 7),
            Block.makeCuboidShape(3, 0, 2, 13, 2, 3),
            Block.makeCuboidShape(13, 0, 3, 14, 2, 13),
            Block.makeCuboidShape(3, 0, 13, 13, 2, 14),
            Block.makeCuboidShape(2, 0, 3, 3, 14, 13),
            Block.makeCuboidShape(3, 0, 3, 13, 1, 13),
            Block.makeCuboidShape(13, 2, 12, 14, 4, 14),
            Block.makeCuboidShape(13, 2, 7, 14, 3, 8),
            Block.makeCuboidShape(13, 2, 6, 14, 4, 7),
            Block.makeCuboidShape(13, 2, 5, 14, 3, 6),
            Block.makeCuboidShape(13, 1, 2, 14, 5, 4),
            Block.makeCuboidShape(13, 2, 9, 14, 5, 10),
            Block.makeCuboidShape(13, 2, 10, 14, 3, 11),
            Block.makeCuboidShape(13, 4, 13, 14, 7, 14),
            Block.makeCuboidShape(13, 6, 12, 14, 7, 13),
            Block.makeCuboidShape(13, 6, 10, 14, 7, 11),
            Block.makeCuboidShape(13, 6, 6, 14, 7, 9),
            Block.makeCuboidShape(13, 5, 7, 14, 6, 8),
            Block.makeCuboidShape(13, 5, 3, 14, 7, 5),
            Block.makeCuboidShape(13, 5, 2, 14, 7, 3),
            Block.makeCuboidShape(13, 7, 2, 14, 8, 14),
            Block.makeCuboidShape(13, 8, 6, 14, 9, 10),
            Block.makeCuboidShape(13, 9, 7, 14, 13, 9),
            Block.makeCuboidShape(13, 8, 12, 14, 9, 13),
            Block.makeCuboidShape(13, 8, 13, 14, 9, 14),
            Block.makeCuboidShape(13, 9, 12, 14, 12, 14),
            Block.makeCuboidShape(13, 11, 11, 14, 12, 12),
            Block.makeCuboidShape(13, 12, 9, 14, 13, 10),
            Block.makeCuboidShape(13, 12, 10, 14, 13, 14),
            Block.makeCuboidShape(13, 8, 2, 14, 9, 3),
            Block.makeCuboidShape(13, 9, 2, 14, 10, 3),
            Block.makeCuboidShape(13, 9, 3, 14, 10, 4),
            Block.makeCuboidShape(13, 12, 4, 14, 13, 7),
            Block.makeCuboidShape(13, 10, 2, 14, 13, 4),
            Block.makeCuboidShape(13, 11, 6, 14, 12, 7),
            Block.makeCuboidShape(13, 11, 4, 14, 12, 5),
            Block.makeCuboidShape(13, 13, 3, 14, 14, 13),
            Block.makeCuboidShape(2, 1, 2, 13, 14, 3),
            Block.makeCuboidShape(2, 1, 13, 13, 14, 14),
            Block.makeCuboidShape(12, 1, 3, 13, 12, 13),
            Block.makeCuboidShape(3, 13, 3, 13, 14, 13),
            Block.makeCuboidShape(3, 1, 1, 13, 13, 2),
            Block.makeCuboidShape(3, 1, 14, 13, 13, 15),
            Block.makeCuboidShape(13, 1, 13, 14, 2, 14),
            Block.makeCuboidShape(1, 1, 3, 2, 13, 13),
            Block.makeCuboidShape(1, 13, 4, 2, 14, 12),
            Block.makeCuboidShape(1, 0, 4, 2, 1, 12),
            Block.makeCuboidShape(3, 14, 3, 12, 15, 13),
            Block.makeCuboidShape(4, 14, 2, 11, 15, 3),
            Block.makeCuboidShape(4, 14, 13, 11, 15, 14),
            Block.makeCuboidShape(2, 14, 4, 3, 15, 12),
            Block.makeCuboidShape(12, 14, 4, 13, 15, 12),
            Block.makeCuboidShape(6, 15, 7, 8, 17, 9),
            Block.makeCuboidShape(6, 17, 6, 7, 20, 8),
            Block.makeCuboidShape(5, 17, 6, 6, 18, 8),
            Block.makeCuboidShape(7, 20, 5, 8, 22, 6)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

    public static final VoxelShape SHAPE_S = Stream.of(
            Block.makeCuboidShape(9, 18, 5, 10, 20, 6),
            Block.makeCuboidShape(13, 0, 3, 14, 2, 13),
            Block.makeCuboidShape(3, 0, 13, 13, 2, 14),
            Block.makeCuboidShape(2, 0, 3, 3, 2, 13),
            Block.makeCuboidShape(3, 0, 2, 13, 14, 3),
            Block.makeCuboidShape(3, 0, 3, 13, 1, 13),
            Block.makeCuboidShape(2, 2, 13, 4, 4, 14),
            Block.makeCuboidShape(8, 2, 13, 9, 3, 14),
            Block.makeCuboidShape(9, 2, 13, 10, 4, 14),
            Block.makeCuboidShape(10, 2, 13, 11, 3, 14),
            Block.makeCuboidShape(12, 1, 13, 14, 5, 14),
            Block.makeCuboidShape(6, 2, 13, 7, 5, 14),
            Block.makeCuboidShape(5, 2, 13, 6, 3, 14),
            Block.makeCuboidShape(2, 4, 13, 3, 7, 14),
            Block.makeCuboidShape(3, 6, 13, 4, 7, 14),
            Block.makeCuboidShape(5, 6, 13, 6, 7, 14),
            Block.makeCuboidShape(7, 6, 13, 10, 7, 14),
            Block.makeCuboidShape(8, 5, 13, 9, 6, 14),
            Block.makeCuboidShape(11, 5, 13, 13, 7, 14),
            Block.makeCuboidShape(13, 5, 13, 14, 7, 14),
            Block.makeCuboidShape(2, 7, 13, 14, 8, 14),
            Block.makeCuboidShape(6, 8, 13, 10, 9, 14),
            Block.makeCuboidShape(7, 9, 13, 9, 13, 14),
            Block.makeCuboidShape(3, 8, 13, 4, 9, 14),
            Block.makeCuboidShape(2, 8, 13, 3, 9, 14),
            Block.makeCuboidShape(2, 9, 13, 4, 12, 14),
            Block.makeCuboidShape(4, 11, 13, 5, 12, 14),
            Block.makeCuboidShape(6, 12, 13, 7, 13, 14),
            Block.makeCuboidShape(2, 12, 13, 6, 13, 14),
            Block.makeCuboidShape(13, 8, 13, 14, 9, 14),
            Block.makeCuboidShape(13, 9, 13, 14, 10, 14),
            Block.makeCuboidShape(12, 9, 13, 13, 10, 14),
            Block.makeCuboidShape(9, 12, 13, 12, 13, 14),
            Block.makeCuboidShape(12, 10, 13, 14, 13, 14),
            Block.makeCuboidShape(9, 11, 13, 10, 12, 14),
            Block.makeCuboidShape(11, 11, 13, 12, 12, 14),
            Block.makeCuboidShape(3, 13, 13, 13, 14, 14),
            Block.makeCuboidShape(13, 1, 2, 14, 14, 13),
            Block.makeCuboidShape(2, 1, 2, 3, 14, 13),
            Block.makeCuboidShape(3, 1, 12, 13, 12, 13),
            Block.makeCuboidShape(3, 13, 3, 13, 14, 13),
            Block.makeCuboidShape(14, 1, 3, 15, 13, 13),
            Block.makeCuboidShape(1, 1, 3, 2, 13, 13),
            Block.makeCuboidShape(2, 1, 13, 3, 2, 14),
            Block.makeCuboidShape(3, 1, 1, 13, 13, 2),
            Block.makeCuboidShape(4, 13, 1, 12, 14, 2),
            Block.makeCuboidShape(4, 0, 1, 12, 1, 2),
            Block.makeCuboidShape(3, 14, 3, 13, 15, 12),
            Block.makeCuboidShape(13, 14, 4, 14, 15, 11),
            Block.makeCuboidShape(2, 14, 4, 3, 15, 11),
            Block.makeCuboidShape(4, 14, 2, 12, 15, 3),
            Block.makeCuboidShape(4, 14, 12, 12, 15, 13),
            Block.makeCuboidShape(7, 15, 6, 9, 17, 8),
            Block.makeCuboidShape(8, 17, 6, 10, 20, 7),
            Block.makeCuboidShape(8, 17, 5, 10, 18, 6),
            Block.makeCuboidShape(10, 20, 7, 11, 22, 8)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

    public static final VoxelShape SHAPE_W = Stream.of(
            Block.makeCuboidShape(10, 18, 9, 11, 20, 10),
            Block.makeCuboidShape(3, 0, 13, 13, 2, 14),
            Block.makeCuboidShape(2, 0, 3, 3, 2, 13),
            Block.makeCuboidShape(3, 0, 2, 13, 2, 3),
            Block.makeCuboidShape(13, 0, 3, 14, 14, 13),
            Block.makeCuboidShape(3, 0, 3, 13, 1, 13),
            Block.makeCuboidShape(2, 2, 2, 3, 4, 4),
            Block.makeCuboidShape(2, 2, 8, 3, 3, 9),
            Block.makeCuboidShape(2, 2, 9, 3, 4, 10),
            Block.makeCuboidShape(2, 2, 10, 3, 3, 11),
            Block.makeCuboidShape(2, 1, 12, 3, 5, 14),
            Block.makeCuboidShape(2, 2, 6, 3, 5, 7),
            Block.makeCuboidShape(2, 2, 5, 3, 3, 6),
            Block.makeCuboidShape(2, 4, 2, 3, 7, 3),
            Block.makeCuboidShape(2, 6, 3, 3, 7, 4),
            Block.makeCuboidShape(2, 6, 5, 3, 7, 6),
            Block.makeCuboidShape(2, 6, 7, 3, 7, 10),
            Block.makeCuboidShape(2, 5, 8, 3, 6, 9),
            Block.makeCuboidShape(2, 5, 11, 3, 7, 13),
            Block.makeCuboidShape(2, 5, 13, 3, 7, 14),
            Block.makeCuboidShape(2, 7, 2, 3, 8, 14),
            Block.makeCuboidShape(2, 8, 6, 3, 9, 10),
            Block.makeCuboidShape(2, 9, 7, 3, 13, 9),
            Block.makeCuboidShape(2, 8, 3, 3, 9, 4),
            Block.makeCuboidShape(2, 8, 2, 3, 9, 3),
            Block.makeCuboidShape(2, 9, 2, 3, 12, 4),
            Block.makeCuboidShape(2, 11, 4, 3, 12, 5),
            Block.makeCuboidShape(2, 12, 6, 3, 13, 7),
            Block.makeCuboidShape(2, 12, 2, 3, 13, 6),
            Block.makeCuboidShape(2, 8, 13, 3, 9, 14),
            Block.makeCuboidShape(2, 9, 13, 3, 10, 14),
            Block.makeCuboidShape(2, 9, 12, 3, 10, 13),
            Block.makeCuboidShape(2, 12, 9, 3, 13, 12),
            Block.makeCuboidShape(2, 10, 12, 3, 13, 14),
            Block.makeCuboidShape(2, 11, 9, 3, 12, 10),
            Block.makeCuboidShape(2, 11, 11, 3, 12, 12),
            Block.makeCuboidShape(2, 13, 3, 3, 14, 13),
            Block.makeCuboidShape(3, 1, 13, 14, 14, 14),
            Block.makeCuboidShape(3, 1, 2, 14, 14, 3),
            Block.makeCuboidShape(3, 1, 3, 4, 12, 13),
            Block.makeCuboidShape(3, 13, 3, 13, 14, 13),
            Block.makeCuboidShape(3, 1, 14, 13, 13, 15),
            Block.makeCuboidShape(3, 1, 1, 13, 13, 2),
            Block.makeCuboidShape(2, 1, 2, 3, 2, 3),
            Block.makeCuboidShape(14, 1, 3, 15, 13, 13),
            Block.makeCuboidShape(14, 13, 4, 15, 14, 12),
            Block.makeCuboidShape(14, 0, 4, 15, 1, 12),
            Block.makeCuboidShape(4, 14, 3, 13, 15, 13),
            Block.makeCuboidShape(5, 14, 13, 12, 15, 14),
            Block.makeCuboidShape(5, 14, 2, 12, 15, 3),
            Block.makeCuboidShape(13, 14, 4, 14, 15, 12),
            Block.makeCuboidShape(3, 14, 4, 4, 15, 12),
            Block.makeCuboidShape(8, 15, 7, 10, 17, 9),
            Block.makeCuboidShape(9, 17, 8, 10, 20, 10),
            Block.makeCuboidShape(10, 17, 8, 11, 18, 10),
            Block.makeCuboidShape(8, 20, 10, 9, 22, 11)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

    public Pumpkin() {
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
