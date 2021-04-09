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

public class Computer extends Block {

    private static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;

    private static final VoxelShape SHAPE_N = Stream.of(
            Block.makeCuboidShape(14.5, 0.375, 6.5, 14.8125, 0.875, 7.5),
            Block.makeCuboidShape(-1, 4, 11, 17, 15.5, 11.5),
            Block.makeCuboidShape(7, 0, 10.5, 10, 0.5, 15),
            Block.makeCuboidShape(0.5, 5.5, 11.5, 15.5, 14.5, 12.5),
            Block.makeCuboidShape(7.8125, 0.5, 12.5, 9.3125, 3.5, 14),
            Block.makeCuboidShape(7.8125, 3, 12, 9.3125, 5.5, 13.5),
            Block.makeCuboidShape(7.8125, 4.5, 11.5, 9.3125, 6, 13),
            Block.makeCuboidShape(-1, 15, 10.9375, 17, 15.5, 11),
            Block.makeCuboidShape(-1, 4, 10.9375, 17, 5, 11),
            Block.makeCuboidShape(16.5, 5, 10.9375, 17, 15, 11),
            Block.makeCuboidShape(-1, 5, 10.9375, -0.5, 15, 11),
            Block.makeCuboidShape(-0.5, 5, 10.9375, 16.5, 15, 11),
            Block.makeCuboidShape(15.5, 4.25, 10.8125, 16.5, 4.75, 11.3125),
            Block.makeCuboidShape(0, 0, 4, 13, 0.5, 8.5),
            Block.makeCuboidShape(0.5, 0.5, 4.5, 8.5, 0.5625, 8),
            Block.makeCuboidShape(11, 0.5, 4.5, 12.5, 0.5625, 7.5),
            Block.makeCuboidShape(9, 0.5, 6, 10.5, 0.5625, 8),
            Block.makeCuboidShape(9, 0.5, 4.5, 10.5, 0.5625, 5),
            Block.makeCuboidShape(9.5, 0.5, 5, 10, 0.5625, 5.5),
            Block.makeCuboidShape(13.5, 0, 4.0625, 16, 0.0625, 8.0625),
            Block.makeCuboidShape(13.75, -0.0625, 4.4375, 15.75, 0.75, 7.5625)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

    public static final VoxelShape SHAPE_E = Stream.of(
            Block.makeCuboidShape(8.5, 0.375, 14.5, 9.5, 0.875, 14.8125),
            Block.makeCuboidShape(4.5, 4, -1, 5, 15.5, 17),
            Block.makeCuboidShape(1, 0, 7, 5.5, 0.5, 10),
            Block.makeCuboidShape(3.5, 5.5, 0.5, 4.5, 14.5, 15.5),
            Block.makeCuboidShape(2, 0.5, 7.8125, 3.5, 3.5, 9.3125),
            Block.makeCuboidShape(2.5, 3, 7.8125, 4, 5.5, 9.3125),
            Block.makeCuboidShape(3, 4.5, 7.8125, 4.5, 6, 9.3125),
            Block.makeCuboidShape(5, 15, -1, 5.0625, 15.5, 17),
            Block.makeCuboidShape(5, 4, -1, 5.0625, 5, 17),
            Block.makeCuboidShape(5, 5, 16.5, 5.0625, 15, 17),
            Block.makeCuboidShape(5, 5, -1, 5.0625, 15, -0.5),
            Block.makeCuboidShape(5, 5, -0.5, 5.0625, 15, 16.5),
            Block.makeCuboidShape(4.6875, 4.25, 15.5, 5.1875, 4.75, 16.5),
            Block.makeCuboidShape(7.5, 0, 0, 12, 0.5, 13),
            Block.makeCuboidShape(8, 0.5, 0.5, 11.5, 0.5625, 8.5),
            Block.makeCuboidShape(8.5, 0.5, 11, 11.5, 0.5625, 12.5),
            Block.makeCuboidShape(8, 0.5, 9, 10, 0.5625, 10.5),
            Block.makeCuboidShape(11, 0.5, 9, 11.5, 0.5625, 10.5),
            Block.makeCuboidShape(10.5, 0.5, 9.5, 11, 0.5625, 10),
            Block.makeCuboidShape(7.9375, 0, 13.5, 11.9375, 0.0625, 16),
            Block.makeCuboidShape(8.4375, -0.0625, 13.75, 11.5625, 0.75, 15.75)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

    public static final VoxelShape SHAPE_S = Stream.of(
            Block.makeCuboidShape(1.1875, 0.375, 9.5, 1.5, 0.875, 10.5),
            Block.makeCuboidShape(-1, 4, 5.5, 17, 15.5, 6),
            Block.makeCuboidShape(6, 0, 2, 9, 0.5, 6.5),
            Block.makeCuboidShape(0.5, 5.5, 4.5, 15.5, 14.5, 5.5),
            Block.makeCuboidShape(6.6875, 0.5, 3, 8.1875, 3.5, 4.5),
            Block.makeCuboidShape(6.6875, 3, 3.5, 8.1875, 5.5, 5),
            Block.makeCuboidShape(6.6875, 4.5, 4, 8.1875, 6, 5.5),
            Block.makeCuboidShape(-1, 15, 6, 17, 15.5, 6.0625),
            Block.makeCuboidShape(-1, 4, 6, 17, 5, 6.0625),
            Block.makeCuboidShape(-1, 5, 6, -0.5, 15, 6.0625),
            Block.makeCuboidShape(16.5, 5, 6, 17, 15, 6.0625),
            Block.makeCuboidShape(-0.5, 5, 6, 16.5, 15, 6.0625),
            Block.makeCuboidShape(-0.5, 4.25, 5.6875, 0.5, 4.75, 6.1875),
            Block.makeCuboidShape(3, 0, 8.5, 16, 0.5, 13),
            Block.makeCuboidShape(7.5, 0.5, 9, 15.5, 0.5625, 12.5),
            Block.makeCuboidShape(3.5, 0.5, 9.5, 5, 0.5625, 12.5),
            Block.makeCuboidShape(5.5, 0.5, 9, 7, 0.5625, 11),
            Block.makeCuboidShape(5.5, 0.5, 12, 7, 0.5625, 12.5),
            Block.makeCuboidShape(6, 0.5, 11.5, 6.5, 0.5625, 12),
            Block.makeCuboidShape(0, 0, 8.9375, 2.5, 0.0625, 12.9375),
            Block.makeCuboidShape(0.25, -0.0625, 9.4375, 2.25, 0.75, 12.5625)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

    public static final VoxelShape SHAPE_W = Stream.of(
            Block.makeCuboidShape(5.5, 0.375, 1.1875, 6.5, 0.875, 1.5),
            Block.makeCuboidShape(10, 4, -1, 10.5, 15.5, 17),
            Block.makeCuboidShape(9.5, 0, 6, 14, 0.5, 9),
            Block.makeCuboidShape(10.5, 5.5, 0.5, 11.5, 14.5, 15.5),
            Block.makeCuboidShape(11.5, 0.5, 6.6875, 13, 3.5, 8.1875),
            Block.makeCuboidShape(11, 3, 6.6875, 12.5, 5.5, 8.1875),
            Block.makeCuboidShape(10.5, 4.5, 6.6875, 12, 6, 8.1875),
            Block.makeCuboidShape(9.9375, 15, -1, 10, 15.5, 17),
            Block.makeCuboidShape(9.9375, 4, -1, 10, 5, 17),
            Block.makeCuboidShape(9.9375, 5, -1, 10, 15, -0.5),
            Block.makeCuboidShape(9.9375, 5, 16.5, 10, 15, 17),
            Block.makeCuboidShape(9.9375, 5, -0.5, 10, 15, 16.5),
            Block.makeCuboidShape(9.8125, 4.25, -0.5, 10.3125, 4.75, 0.5),
            Block.makeCuboidShape(3, 0, 3, 7.5, 0.5, 16),
            Block.makeCuboidShape(3.5, 0.5, 7.5, 7, 0.5625, 15.5),
            Block.makeCuboidShape(3.5, 0.5, 3.5, 6.5, 0.5625, 5),
            Block.makeCuboidShape(5, 0.5, 5.5, 7, 0.5625, 7),
            Block.makeCuboidShape(3.5, 0.5, 5.5, 4, 0.5625, 7),
            Block.makeCuboidShape(4, 0.5, 6, 4.5, 0.5625, 6.5),
            Block.makeCuboidShape(3.0625, 0, 0, 7.0625, 0.0625, 2.5),
            Block.makeCuboidShape(3.4375, -0.0625, 0.25, 6.5625, 0.75, 2.25)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

    public Computer() {
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
