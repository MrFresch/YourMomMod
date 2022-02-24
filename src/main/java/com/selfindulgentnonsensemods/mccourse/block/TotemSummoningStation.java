package com.selfindulgentnonsensemods.mccourse.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalBlock;
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

import java.util.stream.Stream;

public class TotemSummoningStation extends Block
{
    private static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;

    private static final VoxelShape SHAPE_E = Stream.of(
            Block.makeCuboidShape(13, 7, 3, 14, 17, 13),
            Block.makeCuboidShape(2, 7, 3, 3, 17, 13),
            Block.makeCuboidShape(3, 16, 3, 13, 17, 13),
            Block.makeCuboidShape(2, 0, 2, 14, 4, 14),
            Block.makeCuboidShape(4, 4, 3, 12, 5, 13),
            Block.makeCuboidShape(6, 5, 4, 10, 10, 12),
            Block.makeCuboidShape(3, 10, 0, 13, 16, 16)
            ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

    private static final VoxelShape SHAPE_S = Stream.of(
            Block.makeCuboidShape(3, 7, 2, 13, 17, 3),
            Block.makeCuboidShape(3, 7, 13, 13, 17, 14),
            Block.makeCuboidShape(3, 16, 3, 13, 17, 13),
            Block.makeCuboidShape(2, 0, 2, 14, 4, 14),
            Block.makeCuboidShape(3, 4, 4, 13, 5, 12),
            Block.makeCuboidShape(4, 5, 6, 12, 10, 10),
            Block.makeCuboidShape(0, 10, 3, 16, 16, 13)
            ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

    private static final VoxelShape SHAPE_W = Stream.of(
            Block.makeCuboidShape(2, 7, 3, 3, 17, 13),
            Block.makeCuboidShape(13, 7, 3, 14, 17, 13),
            Block.makeCuboidShape(3, 16, 3, 13, 17, 13),
            Block.makeCuboidShape(2, 0, 2, 14, 4, 14),
            Block.makeCuboidShape(4, 4, 3, 12, 5, 13),
            Block.makeCuboidShape(6, 5, 4, 10, 10, 12),
            Block.makeCuboidShape(3, 10, 0, 13, 16, 16)
            ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

    private static final VoxelShape SHAPE_N = Stream.of(
            Block.makeCuboidShape(3, 7, 13, 13, 17, 14),
            Block.makeCuboidShape(3, 7, 2, 13, 17, 3),
            Block.makeCuboidShape(3, 16, 3, 13, 17, 13),
            Block.makeCuboidShape(2, 0, 2, 14, 4, 14),
            Block.makeCuboidShape(3, 4, 4, 13, 5, 12),
            Block.makeCuboidShape(4, 5, 6, 12, 10, 10),
            Block.makeCuboidShape(0, 10, 3, 16, 16, 13)
            ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();
    
    public TotemSummoningStation(Properties properties)
    {
        super(properties);
    }

    @SuppressWarnings("deprecation")
    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context)
    {
        switch  (state.get(FACING))
        {
            case NORTH:
                return SHAPE_N;
            case EAST:
                return SHAPE_E;
            case SOUTH:
                return SHAPE_S;
            case WEST:
                return SHAPE_W;
            default:
                return SHAPE_N;
        }
    }

    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context)
    {
        return this.getDefaultState().with(FACING, context.getPlacementHorizontalFacing().getOpposite());
    }

    @SuppressWarnings("deprecation")
    @Override
    public BlockState rotate(BlockState state, Rotation rot)
    {
        return state.with(FACING, rot.rotate(state.get(FACING)));
    }

    @SuppressWarnings("deprecation")
    @Override
    public BlockState mirror(BlockState state, Mirror mirrorIn)
    {
        return state.rotate(mirrorIn.toRotation(state.get(FACING)));
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder)
    {
        builder.add(FACING);
    }
}
