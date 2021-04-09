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

public class Prullenbak extends Block {

    private static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;

    private static final VoxelShape SHAPE_N = Stream.of(
            Block.makeCuboidShape(0, 0, 0, 16, 1, 16),
            Block.makeCuboidShape(0, 18, 1, 1, 19, 15),
            Block.makeCuboidShape(15, 18, 1, 16, 19, 15),
            Block.makeCuboidShape(1, 18, 15, 15, 19, 16),
            Block.makeCuboidShape(1, 18, 0, 15, 19, 1),
            Block.makeCuboidShape(0, 23, 0, 16, 24, 16),
            Block.makeCuboidShape(0, 1, 0, 1, 23, 1),
            Block.makeCuboidShape(0, 1, 15, 1, 23, 16),
            Block.makeCuboidShape(15, 1, 15, 16, 23, 16),
            Block.makeCuboidShape(15, 1, 0, 16, 23, 1),
            Block.makeCuboidShape(1, 1, 0.5, 15, 18, 1),
            Block.makeCuboidShape(1, 1, 15, 15, 18, 15.5),
            Block.makeCuboidShape(0.5, 1, 1, 1, 18, 15),
            Block.makeCuboidShape(15, 1, 1, 15.5, 18, 15),
            Block.makeCuboidShape(0.5, 19, 1, 1, 23, 15),
            Block.makeCuboidShape(15, 19, 1, 15.5, 23, 15)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();
    private static final VoxelShape SHAPE_E = Stream.of(
            Block.makeCuboidShape(0, 0, 0, 16, 1, 16),
            Block.makeCuboidShape(0, 18, 1, 1, 19, 15),
            Block.makeCuboidShape(15, 18, 1, 16, 19, 15),
            Block.makeCuboidShape(1, 18, 15, 15, 19, 16),
            Block.makeCuboidShape(1, 18, 0, 15, 19, 1),
            Block.makeCuboidShape(0, 23, 0, 16, 24, 16),
            Block.makeCuboidShape(0, 1, 0, 1, 23, 1),
            Block.makeCuboidShape(0, 1, 15, 1, 23, 16),
            Block.makeCuboidShape(15, 1, 15, 16, 23, 16),
            Block.makeCuboidShape(15, 1, 0, 16, 23, 1),
            Block.makeCuboidShape(1, 1, 0.5, 15, 18, 1),
            Block.makeCuboidShape(1, 1, 15, 15, 18, 15.5),
            Block.makeCuboidShape(0.5, 1, 1, 1, 18, 15),
            Block.makeCuboidShape(15, 1, 1, 15.5, 18, 15),
            Block.makeCuboidShape(0.5, 19, 1, 1, 23, 15),
            Block.makeCuboidShape(15, 19, 1, 15.5, 23, 15)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();
    private static final VoxelShape SHAPE_S = Stream.of(
            Block.makeCuboidShape(0, 0, 0, 16, 1, 16),
            Block.makeCuboidShape(0, 18, 1, 1, 19, 15),
            Block.makeCuboidShape(15, 18, 1, 16, 19, 15),
            Block.makeCuboidShape(1, 18, 15, 15, 19, 16),
            Block.makeCuboidShape(1, 18, 0, 15, 19, 1),
            Block.makeCuboidShape(0, 23, 0, 16, 24, 16),
            Block.makeCuboidShape(0, 1, 0, 1, 23, 1),
            Block.makeCuboidShape(0, 1, 15, 1, 23, 16),
            Block.makeCuboidShape(15, 1, 15, 16, 23, 16),
            Block.makeCuboidShape(15, 1, 0, 16, 23, 1),
            Block.makeCuboidShape(1, 1, 0.5, 15, 18, 1),
            Block.makeCuboidShape(1, 1, 15, 15, 18, 15.5),
            Block.makeCuboidShape(0.5, 1, 1, 1, 18, 15),
            Block.makeCuboidShape(15, 1, 1, 15.5, 18, 15),
            Block.makeCuboidShape(0.5, 19, 1, 1, 23, 15),
            Block.makeCuboidShape(15, 19, 1, 15.5, 23, 15)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();
    private static final VoxelShape SHAPE_W = Stream.of(
            Block.makeCuboidShape(0, 0, 0, 16, 1, 16),
            Block.makeCuboidShape(0, 18, 1, 1, 19, 15),
            Block.makeCuboidShape(15, 18, 1, 16, 19, 15),
            Block.makeCuboidShape(1, 18, 15, 15, 19, 16),
            Block.makeCuboidShape(1, 18, 0, 15, 19, 1),
            Block.makeCuboidShape(0, 23, 0, 16, 24, 16),
            Block.makeCuboidShape(0, 1, 0, 1, 23, 1),
            Block.makeCuboidShape(0, 1, 15, 1, 23, 16),
            Block.makeCuboidShape(15, 1, 15, 16, 23, 16),
            Block.makeCuboidShape(15, 1, 0, 16, 23, 1),
            Block.makeCuboidShape(1, 1, 0.5, 15, 18, 1),
            Block.makeCuboidShape(1, 1, 15, 15, 18, 15.5),
            Block.makeCuboidShape(0.5, 1, 1, 1, 18, 15),
            Block.makeCuboidShape(15, 1, 1, 15.5, 18, 15),
            Block.makeCuboidShape(0.5, 19, 1, 1, 23, 15),
            Block.makeCuboidShape(15, 19, 1, 15.5, 23, 15)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

    public Prullenbak() {
        super(Properties.create(Material.IRON)
                .hardnessAndResistance(3.5f, 4.0f)
                .harvestLevel(0)
                .sound(SoundType.STONE)
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
