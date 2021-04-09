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

public class kerst_slingers extends Block {

    private static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;

    private static final VoxelShape SHAPE_N = Stream.of(
            Block.makeCuboidShape(15.09493505848156, 7.378492776721924, 6, 21.09493505848156, 11.378492776721924, 10),
            Block.makeCuboidShape(-0.9301511225760315, 7.378492740197359, 6, 5.0698488774239685, 11.378492740197359, 10),
            Block.makeCuboidShape(-15.955238097201612, 7.378492691012129, 6, -10.955238097201612, 11.378492691012129, 10),
            Block.makeCuboidShape(26.955237987291678, 7.378492524936335, 6, 32, 11.378492524936334, 10),
            Block.makeCuboidShape(-5.094935016525884, 7.378492676449984, 6, 0.9050649834741158, 11.378492676449984, 10),
            Block.makeCuboidShape(10.930151164531708, 7.378492712974548, 6, 16.930151164531708, 11.378492712974548, 10),
            Block.makeCuboidShape(4, 6, 6, 12, 10, 10),
            Block.makeCuboidShape(-12.02508666484119, 5.9999999554965235, 6, -4.02508666484119, 9.999999955496524, 10),
            Block.makeCuboidShape(20.025086338976372, 5.999999803982875, 6, 28.025086338976372, 9.999999803982874, 10)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

    public static final VoxelShape SHAPE_E = Stream.of(
            Block.makeCuboidShape(6.0000000000000036, 7.378492776721924, 15.092448319093698, 10.000000000000004, 11.378492776721924, 21.092448319093698),
            Block.makeCuboidShape(6.0000000000000036, 7.378492740197359, -0.9326378619638938, 10.000000000000004, 11.378492740197359, 5.067362138036106),
            Block.makeCuboidShape(6.0000000000000036, 7.378492691012129, -15.95772483658947, 10.000000000000004, 11.378492691012129, -10.957724836589474),
            Block.makeCuboidShape(6.0000000000000036, 7.378492524936335, 26.952751247903816, 10.000000000000004, 11.378492524936334, 31.997513260612138),
            Block.makeCuboidShape(6.0000000000000036, 7.378492676449984, -5.0974217559137465, 10.000000000000004, 11.378492676449984, 0.9025782440862535),
            Block.makeCuboidShape(6.0000000000000036, 7.378492712974548, 10.927664425143846, 10.000000000000004, 11.378492712974548, 16.927664425143846),
            Block.makeCuboidShape(6.0000000000000036, 6, 3.9975132606121377, 10.000000000000004, 10, 11.997513260612138),
            Block.makeCuboidShape(6.0000000000000036, 5.9999999554965235, -12.027573404229052, 10.000000000000004, 9.999999955496524, -4.027573404229052),
            Block.makeCuboidShape(6.0000000000000036, 5.999999803982875, 20.02259959958851, 10.000000000000004, 9.999999803982874, 28.02259959958851)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

    public static final VoxelShape SHAPE_S = Stream.of(
            Block.makeCuboidShape(15.09493505848156, 7.378492776721924, 6, 21.09493505848156, 11.378492776721924, 10),
            Block.makeCuboidShape(-0.9301511225760315, 7.378492740197359, 6, 5.0698488774239685, 11.378492740197359, 10),
            Block.makeCuboidShape(-15.955238097201612, 7.378492691012129, 6, -10.955238097201612, 11.378492691012129, 10),
            Block.makeCuboidShape(26.955237987291678, 7.378492524936335, 6, 32, 11.378492524936334, 10),
            Block.makeCuboidShape(-5.094935016525884, 7.378492676449984, 6, 0.9050649834741158, 11.378492676449984, 10),
            Block.makeCuboidShape(10.930151164531708, 7.378492712974548, 6, 16.930151164531708, 11.378492712974548, 10),
            Block.makeCuboidShape(4, 6, 6, 12, 10, 10),
            Block.makeCuboidShape(-12.02508666484119, 5.9999999554965235, 6, -4.02508666484119, 9.999999955496524, 10),
            Block.makeCuboidShape(20.025086338976372, 5.999999803982875, 6, 28.025086338976372, 9.999999803982874, 10)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

    public static final VoxelShape SHAPE_W = Stream.of(
            Block.makeCuboidShape(6.0000000000000036, 7.378492776721924, 15.092448319093698, 10.000000000000004, 11.378492776721924, 21.092448319093698),
            Block.makeCuboidShape(6.0000000000000036, 7.378492740197359, -0.9326378619638938, 10.000000000000004, 11.378492740197359, 5.067362138036106),
            Block.makeCuboidShape(6.0000000000000036, 7.378492691012129, -15.95772483658947, 10.000000000000004, 11.378492691012129, -10.957724836589474),
            Block.makeCuboidShape(6.0000000000000036, 7.378492524936335, 26.952751247903816, 10.000000000000004, 11.378492524936334, 31.997513260612138),
            Block.makeCuboidShape(6.0000000000000036, 7.378492676449984, -5.0974217559137465, 10.000000000000004, 11.378492676449984, 0.9025782440862535),
            Block.makeCuboidShape(6.0000000000000036, 7.378492712974548, 10.927664425143846, 10.000000000000004, 11.378492712974548, 16.927664425143846),
            Block.makeCuboidShape(6.0000000000000036, 6, 3.9975132606121377, 10.000000000000004, 10, 11.997513260612138),
            Block.makeCuboidShape(6.0000000000000036, 5.9999999554965235, -12.027573404229052, 10.000000000000004, 9.999999955496524, -4.027573404229052),
            Block.makeCuboidShape(6.0000000000000036, 5.999999803982875, 20.02259959958851, 10.000000000000004, 9.999999803982874, 28.02259959958851)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

    public kerst_slingers() {
        super(Properties.create(Material.LEAVES)
                .hardnessAndResistance(3.5f, 4.0f)
                .harvestLevel(0)
                .sound(SoundType.PLANT));
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
