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

public class boombox extends Block {

    private static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;

    private static final VoxelShape SHAPE_N = Stream.of(
            Block.makeCuboidShape(17.0144, 8.224, 8.6288, 17.392, 12, 9.7616),
            Block.makeCuboidShape(-2.2432, 11.6224, 9.7616, 17.392, 13.1328, 11.272),
            Block.makeCuboidShape(-2.2432, 8.224, 8.6288, -1.8656, 12, 9.7616),
            Block.makeCuboidShape(14.7488, 8.9792, 5.9856, 15.504, 9.3568, 6.7408),
            Block.makeCuboidShape(16.2592, 8.9792, 5.9856, 17.0144, 9.3568, 6.7408),
            Block.makeCuboidShape(13.2384, 8.9792, 5.9856, 13.9936, 9.3568, 6.7408),
            Block.makeCuboidShape(4.176, 8.9792, 5.608, 11.3504, 9.3568, 6.3632),
            Block.makeCuboidShape(1.5328, 8.9792, 6.3632, 2.288, 9.3568, 7.1184),
            Block.makeCuboidShape(-1.488, 8.9792, 5.9856, -0.7328, 9.3568, 6.7408),
            Block.makeCuboidShape(-0.3552, 8.9792, 5.9856, 1.1552, 9.3568, 7.496),
            Block.makeCuboidShape(1.9104, 6.7136, 4.8528, 13.2384, 8.6016, 5.2304),
            Block.makeCuboidShape(-2.2432, 7.8464, 4.8528, 0.0224, 8.6016, 5.2304),
            Block.makeCuboidShape(15.1264, 7.8464, 4.8528, 17.392, 8.6016, 5.2304),
            Block.makeCuboidShape(-2.2432, 6.7136, 4.8528, 0.0224, 7.4688, 5.2304),
            Block.makeCuboidShape(15.1264, 6.7136, 4.8528, 17.392, 7.4688, 5.2304),
            Block.makeCuboidShape(17.2516, 23.2136, 9.7304, 18.3972, 23.9792, 10.8944),
            Block.makeCuboidShape(17.5016, 8.9636, 9.9804, 18.1472, 23.4792, 10.6444),
            Block.makeCuboidShape(-2.9984, 6.7136, 5.2304, 18.1472, 8.9792, 10.8944),
            Block.makeCuboidShape(18.1472, -0.0832, 5.9856, 18.5248, 7.8464, 10.5168),
            Block.makeCuboidShape(-3.376, -0.0832, 5.9856, -2.9984, 7.8464, 10.5168),
            Block.makeCuboidShape(4.9312, 2.1824, 4.4752, 10.2176, 3.3152, 4.8528),
            Block.makeCuboidShape(4.9312, 3.6928, 4.4752, 10.2176, 5.9532, 4.8528),
            Block.makeCuboidShape(4.9312, 1.0496, 4.4752, 10.2176, 1.8048, 4.8528),
            Block.makeCuboidShape(-0.7328, 1.0496, 4.4752, 3.7984, 5.5808, 4.8528),
            Block.makeCuboidShape(11.728, 1.0496, 4.4752, 16.2592, 5.5808, 4.8528),
            Block.makeCuboidShape(-2.9984, -0.0832, 4.8528, 18.1472, 6.7136, 10.8944)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

    public static final VoxelShape SHAPE_E = Stream.of(
            Block.makeCuboidShape(6.070399999999999, 8.224, 16.439999999999998, 7.203199999999999, 12, 16.8176),
            Block.makeCuboidShape(4.559999999999999, 11.6224, -2.817599999999997, 6.070399999999999, 13.1328, 16.8176),
            Block.makeCuboidShape(6.070399999999999, 8.224, -2.817599999999997, 7.203199999999999, 12, -2.4399999999999995),
            Block.makeCuboidShape(9.0912, 8.9792, 14.1744, 9.8464, 9.3568, 14.9296),
            Block.makeCuboidShape(9.0912, 8.9792, 15.684800000000003, 9.8464, 9.3568, 16.439999999999998),
            Block.makeCuboidShape(9.0912, 8.9792, 12.664000000000001, 9.8464, 9.3568, 13.419200000000002),
            Block.makeCuboidShape(9.468799999999998, 8.9792, 3.6016000000000012, 10.224, 9.3568, 10.776000000000002),
            Block.makeCuboidShape(8.7136, 8.9792, 0.958400000000001, 9.468799999999998, 9.3568, 1.7136000000000013),
            Block.makeCuboidShape(9.0912, 8.9792, -2.0623999999999985, 9.8464, 9.3568, -1.3072),
            Block.makeCuboidShape(8.335999999999999, 8.9792, -0.9295999999999989, 9.8464, 9.3568, 0.5808000000000018),
            Block.makeCuboidShape(10.601599999999998, 6.7136, 1.3360000000000003, 10.979199999999999, 8.6016, 12.664000000000001),
            Block.makeCuboidShape(10.601599999999998, 7.8464, -2.817599999999997, 10.979199999999999, 8.6016, -0.5519999999999978),
            Block.makeCuboidShape(10.601599999999998, 7.8464, 14.552000000000001, 10.979199999999999, 8.6016, 16.8176),
            Block.makeCuboidShape(10.601599999999998, 6.7136, -2.817599999999997, 10.979199999999999, 7.4688, -0.5519999999999978),
            Block.makeCuboidShape(10.601599999999998, 6.7136, 14.552000000000001, 10.979199999999999, 7.4688, 16.8176),
            Block.makeCuboidShape(4.9376, 23.2136, 16.6772, 6.101599999999998, 23.9792, 17.8228),
            Block.makeCuboidShape(5.1876, 8.9636, 16.9272, 5.8515999999999995, 23.4792, 17.5728),
            Block.makeCuboidShape(4.9376, 6.7136, -3.572799999999999, 10.601599999999998, 8.9792, 17.5728),
            Block.makeCuboidShape(5.315199999999999, -0.0832, 17.5728, 9.8464, 7.8464, 17.950400000000002),
            Block.makeCuboidShape(5.315199999999999, -0.0832, -3.9504, 9.8464, 7.8464, -3.572799999999999),
            Block.makeCuboidShape(10.979199999999999, 2.1824, 4.356800000000002, 11.3568, 3.3152, 9.6432),
            Block.makeCuboidShape(10.979199999999999, 3.6928, 4.356800000000002, 11.3568, 5.9532, 9.6432),
            Block.makeCuboidShape(10.979199999999999, 1.0496, 4.356800000000002, 11.3568, 1.8048, 9.6432),
            Block.makeCuboidShape(10.979199999999999, 1.0496, -1.3072, 11.3568, 5.5808, 3.224000000000002),
            Block.makeCuboidShape(10.979199999999999, 1.0496, 11.1536, 11.3568, 5.5808, 15.684800000000003),
            Block.makeCuboidShape(4.9376, -0.0832, -3.572799999999999, 10.979199999999999, 6.7136, 17.5728)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

    public static final VoxelShape SHAPE_S = Stream.of(
            Block.makeCuboidShape(-0.9856000000000016, 8.224, 6.495999999999999, -0.6080000000000005, 12, 7.628799999999998),
            Block.makeCuboidShape(-0.9856000000000016, 11.6224, 4.985599999999998, 18.649599999999996, 13.1328, 6.495999999999999),
            Block.makeCuboidShape(18.271999999999995, 8.224, 6.495999999999999, 18.649599999999996, 12, 7.628799999999998),
            Block.makeCuboidShape(0.9023999999999965, 8.9792, 9.5168, 1.6575999999999969, 9.3568, 10.271999999999998),
            Block.makeCuboidShape(-0.6080000000000005, 8.9792, 9.5168, 0.14719999999999445, 9.3568, 10.271999999999998),
            Block.makeCuboidShape(2.4127999999999954, 8.9792, 9.5168, 3.1679999999999957, 9.3568, 10.271999999999998),
            Block.makeCuboidShape(5.055999999999996, 8.9792, 9.894399999999997, 12.230399999999996, 9.3568, 10.6496),
            Block.makeCuboidShape(14.118399999999994, 8.9792, 9.139199999999999, 14.873599999999996, 9.3568, 9.894399999999997),
            Block.makeCuboidShape(17.1392, 8.9792, 9.5168, 17.894399999999994, 9.3568, 10.271999999999998),
            Block.makeCuboidShape(15.251199999999994, 8.9792, 8.761599999999998, 16.761599999999998, 9.3568, 10.271999999999998),
            Block.makeCuboidShape(3.1679999999999957, 6.7136, 11.027199999999997, 14.495999999999995, 8.6016, 11.404799999999998),
            Block.makeCuboidShape(16.383999999999997, 7.8464, 11.027199999999997, 18.649599999999996, 8.6016, 11.404799999999998),
            Block.makeCuboidShape(-0.9856000000000016, 7.8464, 11.027199999999997, 1.2799999999999958, 8.6016, 11.404799999999998),
            Block.makeCuboidShape(16.383999999999997, 6.7136, 11.027199999999997, 18.649599999999996, 7.4688, 11.404799999999998),
            Block.makeCuboidShape(-0.9856000000000016, 6.7136, 11.027199999999997, 1.2799999999999958, 7.4688, 11.404799999999998),
            Block.makeCuboidShape(-1.9908000000000037, 23.2136, 5.363199999999999, -0.845200000000002, 23.9792, 6.527199999999997),
            Block.makeCuboidShape(-1.7408000000000037, 8.9636, 5.613199999999999, -1.095200000000002, 23.4792, 6.277199999999999),
            Block.makeCuboidShape(-1.7408000000000037, 6.7136, 5.363199999999999, 19.404799999999998, 8.9792, 11.027199999999997),
            Block.makeCuboidShape(-2.1184000000000047, -0.0832, 5.740799999999998, -1.7408000000000037, 7.8464, 10.271999999999998),
            Block.makeCuboidShape(19.404799999999998, -0.0832, 5.740799999999998, 19.7824, 7.8464, 10.271999999999998),
            Block.makeCuboidShape(6.188799999999997, 2.1824, 11.404799999999998, 11.475199999999994, 3.3152, 11.782399999999999),
            Block.makeCuboidShape(6.188799999999997, 3.6928, 11.404799999999998, 11.475199999999994, 5.9532, 11.782399999999999),
            Block.makeCuboidShape(6.188799999999997, 1.0496, 11.404799999999998, 11.475199999999994, 1.8048, 11.782399999999999),
            Block.makeCuboidShape(12.607999999999997, 1.0496, 11.404799999999998, 17.1392, 5.5808, 11.782399999999999),
            Block.makeCuboidShape(0.14719999999999445, 1.0496, 11.404799999999998, 4.678399999999996, 5.5808, 11.782399999999999),
            Block.makeCuboidShape(-1.7408000000000037, -0.0832, 5.363199999999999, 19.404799999999998, 6.7136, 11.404799999999998)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

    public static final VoxelShape SHAPE_W = Stream.of(
            Block.makeCuboidShape(8.203199999999999, 8.224, -1.5600000000000023, 9.335999999999999, 12, -1.1824000000000012),
            Block.makeCuboidShape(9.335999999999999, 11.6224, -1.5600000000000023, 10.8464, 13.1328, 18.075199999999995),
            Block.makeCuboidShape(8.203199999999999, 8.224, 17.697599999999994, 9.335999999999999, 12, 18.075199999999995),
            Block.makeCuboidShape(5.559999999999999, 8.9792, 0.32799999999999585, 6.315199999999997, 9.3568, 1.0831999999999962),
            Block.makeCuboidShape(5.559999999999999, 8.9792, -1.1824000000000012, 6.315199999999997, 9.3568, -0.42720000000000624),
            Block.makeCuboidShape(5.559999999999999, 8.9792, 1.8383999999999947, 6.315199999999997, 9.3568, 2.593599999999995),
            Block.makeCuboidShape(5.182399999999998, 8.9792, 4.481599999999995, 5.9376, 9.3568, 11.655999999999995),
            Block.makeCuboidShape(5.9376, 8.9792, 13.543999999999993, 6.692799999999998, 9.3568, 14.299199999999995),
            Block.makeCuboidShape(5.559999999999999, 8.9792, 16.564799999999998, 6.315199999999997, 9.3568, 17.319999999999993),
            Block.makeCuboidShape(5.559999999999999, 8.9792, 14.676799999999993, 7.070399999999999, 9.3568, 16.187199999999997),
            Block.makeCuboidShape(4.427199999999999, 6.7136, 2.593599999999995, 4.8048, 8.6016, 13.921599999999994),
            Block.makeCuboidShape(4.427199999999999, 7.8464, 15.809599999999996, 4.8048, 8.6016, 18.075199999999995),
            Block.makeCuboidShape(4.427199999999999, 7.8464, -1.5600000000000023, 4.8048, 8.6016, 0.7055999999999951),
            Block.makeCuboidShape(4.427199999999999, 6.7136, 15.809599999999996, 4.8048, 7.4688, 18.075199999999995),
            Block.makeCuboidShape(4.427199999999999, 6.7136, -1.5600000000000023, 4.8048, 7.4688, 0.7055999999999951),
            Block.makeCuboidShape(9.3048, 23.2136, -2.5652000000000044, 10.468799999999998, 23.9792, -1.4196000000000026),
            Block.makeCuboidShape(9.554799999999998, 8.9636, -2.3152000000000044, 10.218799999999998, 23.4792, -1.6696000000000026),
            Block.makeCuboidShape(4.8048, 6.7136, -2.3152000000000044, 10.468799999999998, 8.9792, 18.830399999999997),
            Block.makeCuboidShape(5.559999999999999, -0.0832, -2.6928000000000054, 10.091199999999999, 7.8464, -2.3152000000000044),
            Block.makeCuboidShape(5.559999999999999, -0.0832, 18.830399999999997, 10.091199999999999, 7.8464, 19.208),
            Block.makeCuboidShape(4.049599999999998, 2.1824, 5.614399999999996, 4.427199999999999, 3.3152, 10.900799999999993),
            Block.makeCuboidShape(4.049599999999998, 3.6928, 5.614399999999996, 4.427199999999999, 5.9532, 10.900799999999993),
            Block.makeCuboidShape(4.049599999999998, 1.0496, 5.614399999999996, 4.427199999999999, 1.8048, 10.900799999999993),
            Block.makeCuboidShape(4.049599999999998, 1.0496, 12.033599999999996, 4.427199999999999, 5.5808, 16.564799999999998),
            Block.makeCuboidShape(4.049599999999998, 1.0496, -0.42720000000000624, 4.427199999999999, 5.5808, 4.103999999999996),
            Block.makeCuboidShape(4.427199999999999, -0.0832, -2.3152000000000044, 10.468799999999998, 6.7136, 18.830399999999997)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

    public boombox() {
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
