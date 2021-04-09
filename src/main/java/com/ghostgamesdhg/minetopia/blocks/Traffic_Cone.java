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

public class Traffic_Cone extends Block {

    private static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;

    private static final VoxelShape SHAPE_N = Stream.of(
            Block.makeCuboidShape(2, 0, 3, 14, 2, 13),
            Block.makeCuboidShape(4, 1, 4, 12, 4, 12),
            Block.makeCuboidShape(6, 10, 6, 10, 12, 10),
            Block.makeCuboidShape(4.5, 4, 4.5, 11.5, 6, 11.5),
            Block.makeCuboidShape(5, 6, 5, 11, 8, 11),
            Block.makeCuboidShape(5.5, 8, 5.5, 10.5, 10, 10.5),
            Block.makeCuboidShape(6.5, 12, 6.5, 9.5, 14, 9.5),
            Block.makeCuboidShape(3, 0, 2, 13, 2, 14)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

    public static final VoxelShape SHAPE_E = Stream.of(
            Block.makeCuboidShape(2, 0, 3, 14, 2, 13),
            Block.makeCuboidShape(4, 1, 4, 12, 4, 12),
            Block.makeCuboidShape(6, 10, 6, 10, 12, 10),
            Block.makeCuboidShape(4.5, 4, 4.5, 11.5, 6, 11.5),
            Block.makeCuboidShape(5, 6, 5, 11, 8, 11),
            Block.makeCuboidShape(5.5, 8, 5.5, 10.5, 10, 10.5),
            Block.makeCuboidShape(6.5, 12, 6.5, 9.5, 14, 9.5),
            Block.makeCuboidShape(3, 0, 2, 13, 2, 14)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

    public static final VoxelShape SHAPE_S = Stream.of(
            Block.makeCuboidShape(2, 0, 3, 14, 2, 13),
            Block.makeCuboidShape(4, 1, 4, 12, 4, 12),
            Block.makeCuboidShape(6, 10, 6, 10, 12, 10),
            Block.makeCuboidShape(4.5, 4, 4.5, 11.5, 6, 11.5),
            Block.makeCuboidShape(5, 6, 5, 11, 8, 11),
            Block.makeCuboidShape(5.5, 8, 5.5, 10.5, 10, 10.5),
            Block.makeCuboidShape(6.5, 12, 6.5, 9.5, 14, 9.5),
            Block.makeCuboidShape(3, 0, 2, 13, 2, 14)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

    public static final VoxelShape SHAPE_W = Stream.of(
            Block.makeCuboidShape(2, 0, 3, 14, 2, 13),
            Block.makeCuboidShape(4, 1, 4, 12, 4, 12),
            Block.makeCuboidShape(6, 10, 6, 10, 12, 10),
            Block.makeCuboidShape(4.5, 4, 4.5, 11.5, 6, 11.5),
            Block.makeCuboidShape(5, 6, 5, 11, 8, 11),
            Block.makeCuboidShape(5.5, 8, 5.5, 10.5, 10, 10.5),
            Block.makeCuboidShape(6.5, 12, 6.5, 9.5, 14, 9.5),
            Block.makeCuboidShape(3, 0, 2, 13, 2, 14)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

    public Traffic_Cone() {
        super(Properties.create(Material.WOOL)
                .hardnessAndResistance(3.5f, 4.0f)
                .harvestLevel(0)
                .sound(SoundType.WOOD)
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
