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

public class Honden_Bedje extends Block {

    private static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;
    private static final VoxelShape SHAPE_N = Stream.of(
            Block.makeCuboidShape(14, 3, 0, 22, 13, 1),
            Block.makeCuboidShape(-6, 3, 1, -5, 13, 15),
            Block.makeCuboidShape(21, 3, 1, 22, 13, 15),
            Block.makeCuboidShape(-6, 3, 15, 22, 13, 16),
            Block.makeCuboidShape(-6, 3, 0, 2, 13, 1),
            Block.makeCuboidShape(11.39942, 4.92599, 0.009999999999999787, 19.39942, 11.92599, 1.0099999999999998),
            Block.makeCuboidShape(-3.39942, 4.92599, 0.009999999999999787, 4.60058, 11.92599, 1.0099999999999998),
            Block.makeCuboidShape(2, 3, 0, 14, 7, 1),
            Block.makeCuboidShape(-5, 3, 1, 21, 4, 15),
            Block.makeCuboidShape(-4.75, 4, 1.5, 20.5, 8, 14.75),
            Block.makeCuboidShape(-6, 0, 0, -4, 3, 2),
            Block.makeCuboidShape(-6, 0, 14, -4, 3, 16),
            Block.makeCuboidShape(20, 0, 0, 22, 3, 2),
            Block.makeCuboidShape(20, 0, 14, 22, 3, 16),
            Block.makeCuboidShape(-6.25, 2.5, -0.25, 22.25, 4.5, 16.25),
            Block.makeCuboidShape(-6.25, 13, 14.75, 22.25, 13.5, 16.25),
            Block.makeCuboidShape(-6.25, 13, -0.25, 2.25, 13.5, 1.25),
            Block.makeCuboidShape(13.75, 13, -0.25, 22.25, 13.5, 1.25),
            Block.makeCuboidShape(-6.25, 13, 1.25, -4.75, 13.5, 14.75),
            Block.makeCuboidShape(20.75, 13, 1.25, 22.25, 13.5, 14.75),
            Block.makeCuboidShape(16, 8, 9, 18, 10, 11),
            Block.makeCuboidShape(10, 8, 9, 12, 10, 11),
            Block.makeCuboidShape(11, 8.5, 9.5, 17, 9.5, 10.5),
            Block.makeCuboidShape(-5, 6, 4, 5, 8.25, 15),
            Block.makeCuboidShape(4.94554, 6.001, 7.97268, 6.64554, 8.251, 14.97268),
            Block.makeCuboidShape(2.5412, 5.999, 3.6934400000000007, 4.5412, 8.249, 7.99344)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

    public static final VoxelShape SHAPE_E = Stream.of(
            Block.makeCuboidShape(14.90235076923077, 3, 13.876471538461544, 15.90235076923077, 13, 21.876471538461544),
            Block.makeCuboidShape(0.90235076923077, 3, -6.123528461538456, 14.90235076923077, 13, -5.123528461538456),
            Block.makeCuboidShape(0.90235076923077, 3, 20.876471538461544, 14.90235076923077, 13, 21.876471538461544),
            Block.makeCuboidShape(-0.09764923076923004, 3, -6.123528461538456, 0.90235076923077, 13, 21.876471538461544),
            Block.makeCuboidShape(14.90235076923077, 3, -6.123528461538456, 15.90235076923077, 13, 1.8764715384615442),
            Block.makeCuboidShape(14.89235076923077, 4.92599, 11.275891538461543, 15.89235076923077, 11.92599, 19.275891538461543),
            Block.makeCuboidShape(14.89235076923077, 4.92599, -3.522948461538455, 15.89235076923077, 11.92599, 4.477051538461545),
            Block.makeCuboidShape(14.90235076923077, 3, 1.8764715384615442, 15.90235076923077, 7, 13.876471538461544),
            Block.makeCuboidShape(0.90235076923077, 3, -5.123528461538456, 14.90235076923077, 4, 20.876471538461544),
            Block.makeCuboidShape(1.15235076923077, 4, -4.873528461538456, 14.40235076923077, 8, 20.376471538461544),
            Block.makeCuboidShape(13.90235076923077, 0, -6.123528461538456, 15.90235076923077, 3, -4.123528461538456),
            Block.makeCuboidShape(-0.09764923076923004, 0, -6.123528461538456, 1.90235076923077, 3, -4.123528461538456),
            Block.makeCuboidShape(13.90235076923077, 0, 19.876471538461544, 15.90235076923077, 3, 21.876471538461544),
            Block.makeCuboidShape(-0.09764923076923004, 0, 19.876471538461544, 1.90235076923077, 3, 21.876471538461544),
            Block.makeCuboidShape(-0.34764923076923004, 2.5, -6.373528461538456, 16.15235076923077, 4.5, 22.126471538461544),
            Block.makeCuboidShape(-0.34764923076923004, 13, -6.373528461538456, 1.15235076923077, 13.5, 22.126471538461544),
            Block.makeCuboidShape(14.65235076923077, 13, -6.373528461538456, 16.15235076923077, 13.5, 2.1264715384615442),
            Block.makeCuboidShape(14.65235076923077, 13, 13.626471538461544, 16.15235076923077, 13.5, 22.126471538461544),
            Block.makeCuboidShape(1.15235076923077, 13, -6.373528461538456, 14.65235076923077, 13.5, -4.873528461538456),
            Block.makeCuboidShape(1.15235076923077, 13, 20.626471538461544, 14.65235076923077, 13.5, 22.126471538461544),
            Block.makeCuboidShape(4.90235076923077, 8, 15.876471538461544, 6.90235076923077, 10, 17.876471538461544),
            Block.makeCuboidShape(4.90235076923077, 8, 9.876471538461544, 6.90235076923077, 10, 11.876471538461544),
            Block.makeCuboidShape(5.40235076923077, 8.5, 10.876471538461544, 6.40235076923077, 9.5, 16.876471538461544),
            Block.makeCuboidShape(0.90235076923077, 6, -5.123528461538456, 11.90235076923077, 8.25, 4.876471538461544),
            Block.makeCuboidShape(0.9296707692307695, 6.001, 4.822011538461545, 7.9296707692307695, 8.251, 6.522011538461545),
            Block.makeCuboidShape(7.90891076923077, 5.999, 2.417671538461544, 12.20891076923077, 8.249, 4.417671538461544)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

    public static final VoxelShape SHAPE_S = Stream.of(
            Block.makeCuboidShape(-5.876471538461541, 3, 14.876471538461544, 2.1235284615384575, 13, 15.876471538461544),
            Block.makeCuboidShape(21.123528461538456, 3, 0.8764715384615442, 22.123528461538456, 13, 14.876471538461544),
            Block.makeCuboidShape(-5.876471538461541, 3, 0.8764715384615442, -4.876471538461541, 13, 14.876471538461544),
            Block.makeCuboidShape(-5.876471538461541, 3, -0.12352846153845576, 22.123528461538456, 13, 0.8764715384615442),
            Block.makeCuboidShape(14.123528461538458, 3, 14.876471538461544, 22.123528461538456, 13, 15.876471538461544),
            Block.makeCuboidShape(-3.27589153846154, 4.92599, 14.866471538461544, 4.724108461538458, 11.92599, 15.866471538461544),
            Block.makeCuboidShape(11.522948461538457, 4.92599, 14.866471538461544, 19.522948461538455, 11.92599, 15.866471538461544),
            Block.makeCuboidShape(2.1235284615384575, 3, 14.876471538461544, 14.123528461538458, 7, 15.876471538461544),
            Block.makeCuboidShape(-4.876471538461541, 3, 0.8764715384615442, 21.123528461538456, 4, 14.876471538461544),
            Block.makeCuboidShape(-4.376471538461541, 4, 1.1264715384615442, 20.873528461538456, 8, 14.376471538461544),
            Block.makeCuboidShape(20.123528461538456, 0, 13.876471538461544, 22.123528461538456, 3, 15.876471538461544),
            Block.makeCuboidShape(20.123528461538456, 0, -0.12352846153845576, 22.123528461538456, 3, 1.8764715384615442),
            Block.makeCuboidShape(-5.876471538461541, 0, 13.876471538461544, -3.8764715384615407, 3, 15.876471538461544),
            Block.makeCuboidShape(-5.876471538461541, 0, -0.12352846153845576, -3.8764715384615407, 3, 1.8764715384615442),
            Block.makeCuboidShape(-6.126471538461541, 2.5, -0.37352846153845576, 22.373528461538456, 4.5, 16.126471538461544),
            Block.makeCuboidShape(-6.126471538461541, 13, -0.37352846153845576, 22.373528461538456, 13.5, 1.1264715384615442),
            Block.makeCuboidShape(13.873528461538458, 13, 14.626471538461544, 22.373528461538456, 13.5, 16.126471538461544),
            Block.makeCuboidShape(-6.126471538461541, 13, 14.626471538461544, 2.3735284615384575, 13.5, 16.126471538461544),
            Block.makeCuboidShape(20.873528461538456, 13, 1.1264715384615442, 22.373528461538456, 13.5, 14.626471538461544),
            Block.makeCuboidShape(-6.126471538461541, 13, 1.1264715384615442, -4.626471538461541, 13.5, 14.626471538461544),
            Block.makeCuboidShape(-1.8764715384615407, 8, 4.876471538461544, 0.12352846153845931, 10, 6.876471538461544),
            Block.makeCuboidShape(4.1235284615384575, 8, 4.876471538461544, 6.1235284615384575, 10, 6.876471538461544),
            Block.makeCuboidShape(-0.8764715384615407, 8.5, 5.376471538461544, 5.1235284615384575, 9.5, 6.376471538461544),
            Block.makeCuboidShape(11.123528461538458, 6, 0.8764715384615442, 21.123528461538456, 8.25, 11.876471538461544),
            Block.makeCuboidShape(9.477988461538457, 6.001, 0.9037915384615438, 11.177988461538456, 8.251, 7.903791538461544),
            Block.makeCuboidShape(11.582328461538458, 5.999, 7.883031538461545, 13.582328461538458, 8.249, 12.183031538461544)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

    public static final VoxelShape SHAPE_W = Stream.of(
            Block.makeCuboidShape(0.12352846153845576, 3, -5.876471538461537, 1.1235284615384558, 13, 2.123528461538461),
            Block.makeCuboidShape(1.1235284615384558, 3, 21.12352846153846, 15.123528461538456, 13, 22.12352846153846),
            Block.makeCuboidShape(1.1235284615384558, 3, -5.876471538461537, 15.123528461538456, 13, -4.876471538461537),
            Block.makeCuboidShape(15.123528461538456, 3, -5.876471538461537, 16.123528461538456, 13, 22.12352846153846),
            Block.makeCuboidShape(0.12352846153845576, 3, 14.123528461538461, 1.1235284615384558, 13, 22.12352846153846),
            Block.makeCuboidShape(0.13352846153845555, 4.92599, -3.2758915384615364, 1.1335284615384555, 11.92599, 4.724108461538462),
            Block.makeCuboidShape(0.13352846153845555, 4.92599, 11.52294846153846, 1.1335284615384555, 11.92599, 19.52294846153846),
            Block.makeCuboidShape(0.12352846153845576, 3, 2.123528461538461, 1.1235284615384558, 7, 14.123528461538461),
            Block.makeCuboidShape(1.1235284615384558, 3, -4.876471538461537, 15.123528461538456, 4, 21.12352846153846),
            Block.makeCuboidShape(1.6235284615384558, 4, -4.376471538461537, 14.873528461538456, 8, 20.87352846153846),
            Block.makeCuboidShape(0.12352846153845576, 0, 20.12352846153846, 2.1235284615384558, 3, 22.12352846153846),
            Block.makeCuboidShape(14.123528461538456, 0, 20.12352846153846, 16.123528461538456, 3, 22.12352846153846),
            Block.makeCuboidShape(0.12352846153845576, 0, -5.876471538461537, 2.1235284615384558, 3, -3.876471538461537),
            Block.makeCuboidShape(14.123528461538456, 0, -5.876471538461537, 16.123528461538456, 3, -3.876471538461537),
            Block.makeCuboidShape(-0.12647153846154424, 2.5, -6.126471538461537, 16.373528461538456, 4.5, 22.37352846153846),
            Block.makeCuboidShape(14.873528461538456, 13, -6.126471538461537, 16.373528461538456, 13.5, 22.37352846153846),
            Block.makeCuboidShape(-0.12647153846154424, 13, 13.873528461538461, 1.3735284615384558, 13.5, 22.37352846153846),
            Block.makeCuboidShape(-0.12647153846154424, 13, -6.126471538461537, 1.3735284615384558, 13.5, 2.373528461538461),
            Block.makeCuboidShape(1.3735284615384558, 13, 20.87352846153846, 14.873528461538456, 13.5, 22.37352846153846),
            Block.makeCuboidShape(1.3735284615384558, 13, -6.126471538461537, 14.873528461538456, 13.5, -4.626471538461537),
            Block.makeCuboidShape(9.123528461538456, 8, -1.8764715384615371, 11.123528461538456, 10, 0.12352846153846286),
            Block.makeCuboidShape(9.123528461538456, 8, 4.123528461538461, 11.123528461538456, 10, 6.123528461538461),
            Block.makeCuboidShape(9.623528461538456, 8.5, -0.8764715384615371, 10.623528461538456, 9.5, 5.123528461538461),
            Block.makeCuboidShape(4.123528461538456, 6, 11.123528461538461, 15.123528461538456, 8.25, 21.12352846153846),
            Block.makeCuboidShape(8.096208461538456, 6.001, 9.47798846153846, 15.096208461538456, 8.251, 11.17798846153846),
            Block.makeCuboidShape(3.8169684615384565, 5.999, 11.582328461538461, 8.116968461538455, 8.249, 13.582328461538461)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

    public Honden_Bedje() {
        super(Properties.create(Material.WOOD)
                .hardnessAndResistance(3.5f, 4.0f)
                .harvestLevel(0)
                .sound(SoundType.WOOD)
                .harvestTool(ToolType.AXE)
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
