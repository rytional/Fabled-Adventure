package net.rytional.fabledadventure.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalFacingBlock;
import net.minecraft.block.ShapeContext;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.util.BlockMirror;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import org.jetbrains.annotations.Nullable;

public class FaeniteHomeBlock extends Block {

    public static final DirectionProperty FACING;

    protected static VoxelShape NORTH_SHAPE = null;
    protected static VoxelShape SOUTH_SHAPE = null;
    protected static VoxelShape WEST_SHAPE = null;
    protected static VoxelShape EAST_SHAPE = null;


    public FaeniteHomeBlock(Settings settings) {
        super(settings);
        this.setDefaultState(this.stateManager.getDefaultState().with(FACING, Direction.NORTH));
    }

    public BlockState rotate(BlockState state, BlockRotation rotation) {
        return state.with(FACING, rotation.rotate(state.get(FACING)));
    }

    public BlockState mirror(BlockState state, BlockMirror mirror) {
        return state.rotate(mirror.getRotation(state.get(FACING)));
    }


    @Nullable
    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx)  {

        Direction direction = ctx.getPlayerFacing().getOpposite();

        if(direction != Direction.UP && direction != Direction.DOWN){
            return this.getDefaultState().with(FACING, direction);
        }

        return null;
    }

    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        switch(state.get(FACING)) {
            case NORTH:
                return NORTH_SHAPE;
            case SOUTH:
                return SOUTH_SHAPE;
            case WEST:
                return WEST_SHAPE;
            case EAST:
            default:
                return EAST_SHAPE;
        }
    }

    static {
        FACING = HorizontalFacingBlock.FACING;
    }
}
