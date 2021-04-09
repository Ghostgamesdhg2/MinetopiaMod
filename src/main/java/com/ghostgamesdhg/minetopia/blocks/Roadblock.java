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

public class Roadblock extends Block {

    private static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;
    private static final VoxelShape SHAPE_N = Stream.of(
            Block.makeCuboidShape(11.75, 19.25, 7.4, 19, 23.5, 8.9),
            Block.makeCuboidShape(19, 0.6999999999999993, 0.2, 20, 20.9, 1.2),
            Block.makeCuboidShape(19, -0.3276299999999992, 9.96623, 20, 19.87237, 10.96623),
            Block.makeCuboidShape(19, 18.5, 7.4, 20, 24, 8.9),
            Block.makeCuboidShape(19.25, 3.9000000000000004, 2.2, 19.75, 4.9, 14.6),
            Block.makeCuboidShape(19.25, 4.4, 7.7, 19.75, 18.2, 8.7),
            Block.makeCuboidShape(-4, 0.6999999999999993, 0.2, -3, 20.9, 1.2),
            Block.makeCuboidShape(-4, -0.3276299999999992, 9.96623, -3, 19.87237, 10.96623),
            Block.makeCuboidShape(-4, 18.5, 7.4, -3, 24, 8.9),
            Block.makeCuboidShape(-3.75, 3.9000000000000004, 2.2, -3.25, 4.9, 14.6),
            Block.makeCuboidShape(-3.75, 4.4, 7.7, -3.25, 18.2, 8.7),
            Block.makeCuboidShape(4.25, 19.25, 7.4, 11.75, 23.5, 8.9),
            Block.makeCuboidShape(-3, 19.25, 7.4, 4.25, 23.5, 8.9),
            Block.makeCuboidShape(-11.25, 19.25, 7.4, -4, 23.5, 8.9),
            Block.makeCuboidShape(20, 19.25, 7.4, 27.25, 23.5, 8.9),
            Block.makeCuboidShape(-11.25, 12.25, 7.4, -3.75, 16.5, 8.9),
            Block.makeCuboidShape(-3.25, 12.25, 7.4, 4.25, 16.5, 8.9),
            Block.makeCuboidShape(4.25, 12.25, 7.4, 11.75, 16.5, 8.9),
            Block.makeCuboidShape(11.75, 12.25, 7.4, 19.25, 16.5, 8.9),
            Block.makeCuboidShape(19.75, 12.25, 7.4, 27.25, 16.5, 8.9),
            Block.makeCuboidShape(19.5, 12, 7.65, 27.75, 16.75, 8.65),
            Block.makeCuboidShape(11.5, 12, 7.65, 19.75, 16.75, 8.65),
            Block.makeCuboidShape(4, 12, 7.65, 12.25, 16.75, 8.65),
            Block.makeCuboidShape(-3.5, 12, 7.65, 4.75, 16.75, 8.65),
            Block.makeCuboidShape(-11.5, 12, 7.65, -3.25, 16.75, 8.65),
            Block.makeCuboidShape(19.5, 19, 7.65, 27.75, 23.75, 8.65),
            Block.makeCuboidShape(11.5, 19, 7.65, 19.75, 23.75, 8.65),
            Block.makeCuboidShape(4, 19, 7.65, 12.25, 23.75, 8.65),
            Block.makeCuboidShape(-3.5, 19, 7.65, 4.75, 23.75, 8.65),
            Block.makeCuboidShape(-11.5, 19, 7.65, -3.25, 23.75, 8.65)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

    public static final VoxelShape SHAPE_E = Stream.of(
            Block.makeCuboidShape(7.1, 19.25, 11.75, 8.6, 23.5, 19),
            Block.makeCuboidShape(14.8, 0.6999999999999993, 19, 15.8, 20.9, 20),
            Block.makeCuboidShape(5.0337700000000005, -0.3276299999999992, 19, 6.0337700000000005, 19.87237, 20),
            Block.makeCuboidShape(7.1, 18.5, 19, 8.6, 24, 20),
            Block.makeCuboidShape(1.4000000000000004, 3.9000000000000004, 19.25, 13.8, 4.9, 19.75),
            Block.makeCuboidShape(7.300000000000001, 4.4, 19.25, 8.3, 18.2, 19.75),
            Block.makeCuboidShape(14.8, 0.6999999999999993, -4, 15.8, 20.9, -3),
            Block.makeCuboidShape(5.0337700000000005, -0.3276299999999992, -4, 6.0337700000000005, 19.87237, -3),
            Block.makeCuboidShape(7.1, 18.5, -4, 8.6, 24, -3),
            Block.makeCuboidShape(1.4000000000000004, 3.9000000000000004, -3.75, 13.8, 4.9, -3.25),
            Block.makeCuboidShape(7.300000000000001, 4.4, -3.75, 8.3, 18.2, -3.25),
            Block.makeCuboidShape(7.1, 19.25, 4.25, 8.6, 23.5, 11.75),
            Block.makeCuboidShape(7.1, 19.25, -3, 8.6, 23.5, 4.25),
            Block.makeCuboidShape(7.1, 19.25, -11.25, 8.6, 23.5, -4),
            Block.makeCuboidShape(7.1, 19.25, 20, 8.6, 23.5, 27.25),
            Block.makeCuboidShape(7.1, 12.25, -11.25, 8.6, 16.5, -3.75),
            Block.makeCuboidShape(7.1, 12.25, -3.25, 8.6, 16.5, 4.25),
            Block.makeCuboidShape(7.1, 12.25, 4.25, 8.6, 16.5, 11.75),
            Block.makeCuboidShape(7.1, 12.25, 11.75, 8.6, 16.5, 19.25),
            Block.makeCuboidShape(7.1, 12.25, 19.75, 8.6, 16.5, 27.25),
            Block.makeCuboidShape(7.35, 12, 19.5, 8.35, 16.75, 27.75),
            Block.makeCuboidShape(7.35, 12, 11.5, 8.35, 16.75, 19.75),
            Block.makeCuboidShape(7.35, 12, 4, 8.35, 16.75, 12.25),
            Block.makeCuboidShape(7.35, 12, -3.5, 8.35, 16.75, 4.75),
            Block.makeCuboidShape(7.35, 12, -11.5, 8.35, 16.75, -3.25),
            Block.makeCuboidShape(7.35, 19, 19.5, 8.35, 23.75, 27.75),
            Block.makeCuboidShape(7.35, 19, 11.5, 8.35, 23.75, 19.75),
            Block.makeCuboidShape(7.35, 19, 4, 8.35, 23.75, 12.25),
            Block.makeCuboidShape(7.35, 19, -3.5, 8.35, 23.75, 4.75),
            Block.makeCuboidShape(7.35, 19, -11.5, 8.35, 23.75, -3.25)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

    public static final VoxelShape SHAPE_S = Stream.of(
            Block.makeCuboidShape(-3, 19.25, 7.1, 4.25, 23.5, 8.6),
            Block.makeCuboidShape(-4, 0.6999999999999993, 14.8, -3, 20.9, 15.8),
            Block.makeCuboidShape(-4, -0.3276299999999992, 5.0337700000000005, -3, 19.87237, 6.0337700000000005),
            Block.makeCuboidShape(-4, 18.5, 7.1, -3, 24, 8.6),
            Block.makeCuboidShape(-3.75, 3.9000000000000004, 1.4000000000000004, -3.25, 4.9, 13.8),
            Block.makeCuboidShape(-3.75, 4.4, 7.300000000000001, -3.25, 18.2, 8.3),
            Block.makeCuboidShape(19, 0.6999999999999993, 14.8, 20, 20.9, 15.8),
            Block.makeCuboidShape(19, -0.3276299999999992, 5.0337700000000005, 20, 19.87237, 6.0337700000000005),
            Block.makeCuboidShape(19, 18.5, 7.1, 20, 24, 8.6),
            Block.makeCuboidShape(19.25, 3.9000000000000004, 1.4000000000000004, 19.75, 4.9, 13.8),
            Block.makeCuboidShape(19.25, 4.4, 7.300000000000001, 19.75, 18.2, 8.3),
            Block.makeCuboidShape(4.25, 19.25, 7.1, 11.75, 23.5, 8.6),
            Block.makeCuboidShape(11.75, 19.25, 7.1, 19, 23.5, 8.6),
            Block.makeCuboidShape(20, 19.25, 7.1, 27.25, 23.5, 8.6),
            Block.makeCuboidShape(-11.25, 19.25, 7.1, -4, 23.5, 8.6),
            Block.makeCuboidShape(19.75, 12.25, 7.1, 27.25, 16.5, 8.6),
            Block.makeCuboidShape(11.75, 12.25, 7.1, 19.25, 16.5, 8.6),
            Block.makeCuboidShape(4.25, 12.25, 7.1, 11.75, 16.5, 8.6),
            Block.makeCuboidShape(-3.25, 12.25, 7.1, 4.25, 16.5, 8.6),
            Block.makeCuboidShape(-11.25, 12.25, 7.1, -3.75, 16.5, 8.6),
            Block.makeCuboidShape(-11.75, 12, 7.35, -3.5, 16.75, 8.35),
            Block.makeCuboidShape(-3.75, 12, 7.35, 4.5, 16.75, 8.35),
            Block.makeCuboidShape(3.75, 12, 7.35, 12, 16.75, 8.35),
            Block.makeCuboidShape(11.25, 12, 7.35, 19.5, 16.75, 8.35),
            Block.makeCuboidShape(19.25, 12, 7.35, 27.5, 16.75, 8.35),
            Block.makeCuboidShape(-11.75, 19, 7.35, -3.5, 23.75, 8.35),
            Block.makeCuboidShape(-3.75, 19, 7.35, 4.5, 23.75, 8.35),
            Block.makeCuboidShape(3.75, 19, 7.35, 12, 23.75, 8.35),
            Block.makeCuboidShape(11.25, 19, 7.35, 19.5, 23.75, 8.35),
            Block.makeCuboidShape(19.25, 19, 7.35, 27.5, 23.75, 8.35)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

    public static final VoxelShape SHAPE_W = Stream.of(
            Block.makeCuboidShape(7.399999999999999, 19.25, -3, 8.899999999999999, 23.5, 4.25),
            Block.makeCuboidShape(0.1999999999999993, 0.6999999999999993, -4, 1.1999999999999993, 20.9, -3),
            Block.makeCuboidShape(9.96623, -0.3276299999999992, -4, 10.96623, 19.87237, -3),
            Block.makeCuboidShape(7.399999999999999, 18.5, -4, 8.899999999999999, 24, -3),
            Block.makeCuboidShape(2.1999999999999993, 3.9000000000000004, -3.75, 14.600000000000001, 4.9, -3.25),
            Block.makeCuboidShape(7.699999999999999, 4.4, -3.75, 8.7, 18.2, -3.25),
            Block.makeCuboidShape(0.1999999999999993, 0.6999999999999993, 19, 1.1999999999999993, 20.9, 20),
            Block.makeCuboidShape(9.96623, -0.3276299999999992, 19, 10.96623, 19.87237, 20),
            Block.makeCuboidShape(7.399999999999999, 18.5, 19, 8.899999999999999, 24, 20),
            Block.makeCuboidShape(2.1999999999999993, 3.9000000000000004, 19.25, 14.600000000000001, 4.9, 19.75),
            Block.makeCuboidShape(7.699999999999999, 4.4, 19.25, 8.7, 18.2, 19.75),
            Block.makeCuboidShape(7.399999999999999, 19.25, 4.25, 8.899999999999999, 23.5, 11.75),
            Block.makeCuboidShape(7.399999999999999, 19.25, 11.75, 8.899999999999999, 23.5, 19),
            Block.makeCuboidShape(7.399999999999999, 19.25, 20, 8.899999999999999, 23.5, 27.25),
            Block.makeCuboidShape(7.399999999999999, 19.25, -11.25, 8.899999999999999, 23.5, -4),
            Block.makeCuboidShape(7.399999999999999, 12.25, 19.75, 8.899999999999999, 16.5, 27.25),
            Block.makeCuboidShape(7.399999999999999, 12.25, 11.75, 8.899999999999999, 16.5, 19.25),
            Block.makeCuboidShape(7.399999999999999, 12.25, 4.25, 8.899999999999999, 16.5, 11.75),
            Block.makeCuboidShape(7.399999999999999, 12.25, -3.25, 8.899999999999999, 16.5, 4.25),
            Block.makeCuboidShape(7.399999999999999, 12.25, -11.25, 8.899999999999999, 16.5, -3.75),
            Block.makeCuboidShape(7.649999999999999, 12, -11.75, 8.649999999999999, 16.75, -3.5),
            Block.makeCuboidShape(7.649999999999999, 12, -3.75, 8.649999999999999, 16.75, 4.5),
            Block.makeCuboidShape(7.649999999999999, 12, 3.75, 8.649999999999999, 16.75, 12),
            Block.makeCuboidShape(7.649999999999999, 12, 11.25, 8.649999999999999, 16.75, 19.5),
            Block.makeCuboidShape(7.649999999999999, 12, 19.25, 8.649999999999999, 16.75, 27.5),
            Block.makeCuboidShape(7.649999999999999, 19, -11.75, 8.649999999999999, 23.75, -3.5),
            Block.makeCuboidShape(7.649999999999999, 19, -3.75, 8.649999999999999, 23.75, 4.5),
            Block.makeCuboidShape(7.649999999999999, 19, 3.75, 8.649999999999999, 23.75, 12),
            Block.makeCuboidShape(7.649999999999999, 19, 11.25, 8.649999999999999, 23.75, 19.5),
            Block.makeCuboidShape(7.649999999999999, 19, 19.25, 8.649999999999999, 23.75, 27.5)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

    public Roadblock() {
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
