package net.rytional.fabledadventure.block.custom;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.*;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.rytional.fabledadventure.block.entity.ModBlockEntities;
import net.rytional.fabledadventure.block.entity.SorciumCrafterEntity;
import org.jetbrains.annotations.Nullable;

public class SorciumCrafterBlock extends BlockWithEntity implements BlockEntityProvider {
    public static final DirectionProperty FACING = Properties.HORIZONTAL_FACING;

    public SorciumCrafterBlock(Settings settings) {
        super(settings);
    }
    public static final VoxelShape BOTTOM_SHAPE = Block.createCuboidShape(0.0, 0.0, 0.0, 16.0, 2.0, 16.0);
    public static final VoxelShape MIDDLE_SHAPE = Block.createCuboidShape(4.0, 2.0, 4.0, 12.0, 14.0, 12.0);
    public static final VoxelShape BASE_SHAPE = VoxelShapes.union(BOTTOM_SHAPE, MIDDLE_SHAPE);
    public static final VoxelShape COLLISION_SHAPE_TOP = Block.createCuboidShape(0.0, 15.0, 0.0, 16.0, 15.0, 16.0);
    public static final VoxelShape COLLISION_SHAPE = VoxelShapes.union(BASE_SHAPE, COLLISION_SHAPE_TOP);
    public static final VoxelShape WEST_SHAPE = VoxelShapes.union(Block.createCuboidShape(1.0, 10.0, 0.0, 5.333333, 14.0, 16.0), Block.createCuboidShape(5.333333, 12.0, 0.0, 9.666667, 16.0, 16.0), Block.createCuboidShape(9.666667, 14.0, 0.0, 14.0, 18.0, 16.0), BASE_SHAPE);
    public static final VoxelShape NORTH_SHAPE = VoxelShapes.union(Block.createCuboidShape(0.0, 10.0, 1.0, 16.0, 14.0, 5.333333), Block.createCuboidShape(0.0, 12.0, 5.333333, 16.0, 16.0, 9.666667), Block.createCuboidShape(0.0, 14.0, 9.666667, 16.0, 18.0, 14.0), BASE_SHAPE);
    public static final VoxelShape EAST_SHAPE = VoxelShapes.union(Block.createCuboidShape(10.666667, 10.0, 0.0, 15.0, 14.0, 16.0), Block.createCuboidShape(6.333333, 12.0, 0.0, 10.666667, 16.0, 16.0), Block.createCuboidShape(2.0, 14.0, 0.0, 6.333333, 18.0, 16.0), BASE_SHAPE);
    public static final VoxelShape SOUTH_SHAPE = VoxelShapes.union(Block.createCuboidShape(0.0, 10.0, 10.666667, 16.0, 14.0, 15.0), Block.createCuboidShape(0.0, 12.0, 6.333333, 16.0, 16.0, 10.666667), Block.createCuboidShape(0.0, 14.0, 2.0, 16.0, 18.0, 6.333333), BASE_SHAPE);
    private static final int SCHEDULED_TICK_DELAY = 2;


    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        switch (state.get(FACING)) {
            case NORTH:
                return NORTH_SHAPE;
            case SOUTH:
                return SOUTH_SHAPE;
            case WEST:
                return WEST_SHAPE;
            case EAST:
                return EAST_SHAPE;
            default:
                return NORTH_SHAPE;
        }
    }

    @Nullable
    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState().with(FACING, ctx.getPlayerFacing().getOpposite());
    }

    @Override
    public BlockState rotate(BlockState state, BlockRotation rotation) {
        return state.with(FACING, rotation.rotate(state.get(FACING)));
    }

    @Override
    public BlockState mirror(BlockState state, BlockMirror mirror) {
        return state.rotate(mirror.getRotation(state.get(FACING)));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

    @Override
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }

    @Override
    public void onStateReplaced(BlockState state, World world, BlockPos pos, BlockState newState, boolean moved) {
        if (state.getBlock() != newState.getBlock()) {
            BlockEntity blockEntity = world.getBlockEntity(pos);
            if (blockEntity instanceof SorciumCrafterEntity) {
                ItemScatterer.spawn(world, pos, (SorciumCrafterEntity)blockEntity);
                world.updateComparators(pos,this);
            }
            super.onStateReplaced(state, world, pos, newState, moved);
        }
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos,
                              PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (!world.isClient) {
            NamedScreenHandlerFactory screenHandlerFactory = state.createScreenHandlerFactory(world, pos);

            if (screenHandlerFactory != null) {
                player.openHandledScreen(screenHandlerFactory);
            }
        }

        return ActionResult.SUCCESS;
    }

    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new SorciumCrafterEntity(pos, state);
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
        return checkType(type, ModBlockEntities.SORCIUM_CRAFTER, SorciumCrafterEntity::tick);
    }
}
