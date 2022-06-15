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
import net.minecraft.util.function.BooleanBiFunction;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.rytional.fabledadventure.block.entity.FaeniteHomeEntity;
import net.rytional.fabledadventure.block.entity.ModBlockEntities;
import org.jetbrains.annotations.Nullable;

import java.util.stream.Stream;

public class FaeniteHomeBlock extends BlockWithEntity implements BlockEntityProvider {
    public static final DirectionProperty FACING = Properties.HORIZONTAL_FACING;

    public FaeniteHomeBlock(Settings settings) {
        super(settings);
    }
    private static final VoxelShape SHAPE_N = Stream.of(
            Block.createCuboidShape(4, 8, 0, 12, 11, 1),
            Block.createCuboidShape(2, 8, 2, 14, 12, 14),
            Block.createCuboidShape(3, 2, 3, 13, 8, 13),
            Block.createCuboidShape(5, 1, 5, 11, 2, 11),
            Block.createCuboidShape(7, 0, 7, 9, 1, 9),
            Block.createCuboidShape(3, 12, 3, 13, 13, 13),
            Block.createCuboidShape(6, 13, 6, 10, 14, 10),
            Block.createCuboidShape(7, 14, 7, 9, 15, 9),
            Block.createCuboidShape(7.75, 15, 7.75, 9.75, 16, 9.75),
            Block.createCuboidShape(14, 8, 3, 15, 12, 13),
            Block.createCuboidShape(15, 8, 5, 16, 11, 11),
            Block.createCuboidShape(0, 8, 5, 1, 11, 11),
            Block.createCuboidShape(1, 8, 3, 2, 12, 13),
            Block.createCuboidShape(4, 8, 15, 12, 11, 16),
            Block.createCuboidShape(3, 8, 14, 13, 12, 15),
            Block.createCuboidShape(3, 8, 1, 13, 12, 2),
            Block.createCuboidShape(5, 3, 13, 11, 8, 14),
            Block.createCuboidShape(13, 3, 5, 14, 8, 11),
            Block.createCuboidShape(2, 3, 5, 3, 8, 11),
            Block.createCuboidShape(5, 3, 2, 11, 8, 3)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();

    private static final VoxelShape SHAPE_W = Stream.of(
            Block.createCuboidShape(0, 8, 4, 1, 11, 12),
            Block.createCuboidShape(2, 8, 2, 14, 12, 14),
            Block.createCuboidShape(3, 2, 3, 13, 8, 13),
            Block.createCuboidShape(5, 1, 5, 11, 2, 11),
            Block.createCuboidShape(7, 0, 7, 9, 1, 9),
            Block.createCuboidShape(3, 12, 3, 13, 13, 13),
            Block.createCuboidShape(6, 13, 6, 10, 14, 10),
            Block.createCuboidShape(7, 14, 7, 9, 15, 9),
            Block.createCuboidShape(7.75, 15, 6.25, 9.75, 16, 8.25),
            Block.createCuboidShape(3, 8, 1, 13, 12, 2),
            Block.createCuboidShape(5, 8, 0, 11, 11, 1),
            Block.createCuboidShape(5, 8, 15, 11, 11, 16),
            Block.createCuboidShape(3, 8, 14, 13, 12, 15),
            Block.createCuboidShape(15, 8, 4, 16, 11, 12),
            Block.createCuboidShape(14, 8, 3, 15, 12, 13),
            Block.createCuboidShape(1, 8, 3, 2, 12, 13),
            Block.createCuboidShape(13, 3, 5, 14, 8, 11),
            Block.createCuboidShape(5, 3, 2, 11, 8, 3),
            Block.createCuboidShape(5, 3, 13, 11, 8, 14),
            Block.createCuboidShape(2, 3, 5, 3, 8, 11)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();

    private static final VoxelShape SHAPE_S = Stream.of(
            Block.createCuboidShape(4, 8, 15, 12, 11, 16),
            Block.createCuboidShape(2, 8, 2, 14, 12, 14),
            Block.createCuboidShape(3, 2, 3, 13, 8, 13),
            Block.createCuboidShape(5, 1, 5, 11, 2, 11),
            Block.createCuboidShape(7, 0, 7, 9, 1, 9),
            Block.createCuboidShape(3, 12, 3, 13, 13, 13),
            Block.createCuboidShape(6, 13, 6, 10, 14, 10),
            Block.createCuboidShape(7, 14, 7, 9, 15, 9),
            Block.createCuboidShape(6.25, 15, 6.25, 8.25, 16, 8.25),
            Block.createCuboidShape(1, 8, 3, 2, 12, 13),
            Block.createCuboidShape(0, 8, 5, 1, 11, 11),
            Block.createCuboidShape(15, 8, 5, 16, 11, 11),
            Block.createCuboidShape(14, 8, 3, 15, 12, 13),
            Block.createCuboidShape(4, 8, 0, 12, 11, 1),
            Block.createCuboidShape(3, 8, 1, 13, 12, 2),
            Block.createCuboidShape(3, 8, 14, 13, 12, 15),
            Block.createCuboidShape(5, 3, 2, 11, 8, 3),
            Block.createCuboidShape(2, 3, 5, 3, 8, 11),
            Block.createCuboidShape(13, 3, 5, 14, 8, 11),
            Block.createCuboidShape(5, 3, 13, 11, 8, 14)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();

    private static final VoxelShape SHAPE_E = Stream.of(
            Block.createCuboidShape(15, 8, 4, 16, 11, 12),
            Block.createCuboidShape(2, 8, 2, 14, 12, 14),
            Block.createCuboidShape(3, 2, 3, 13, 8, 13),
            Block.createCuboidShape(5, 1, 5, 11, 2, 11),
            Block.createCuboidShape(7, 0, 7, 9, 1, 9),
            Block.createCuboidShape(3, 12, 3, 13, 13, 13),
            Block.createCuboidShape(6, 13, 6, 10, 14, 10),
            Block.createCuboidShape(7, 14, 7, 9, 15, 9),
            Block.createCuboidShape(6.25, 15, 7.75, 8.25, 16, 9.75),
            Block.createCuboidShape(3, 8, 14, 13, 12, 15),
            Block.createCuboidShape(5, 8, 15, 11, 11, 16),
            Block.createCuboidShape(5, 8, 0, 11, 11, 1),
            Block.createCuboidShape(3, 8, 1, 13, 12, 2),
            Block.createCuboidShape(0, 8, 4, 1, 11, 12),
            Block.createCuboidShape(1, 8, 3, 2, 12, 13),
            Block.createCuboidShape(14, 8, 3, 15, 12, 13),
            Block.createCuboidShape(2, 3, 5, 3, 8, 11),
            Block.createCuboidShape(5, 3, 13, 11, 8, 14),
            Block.createCuboidShape(5, 3, 2, 11, 8, 3),
            Block.createCuboidShape(13, 3, 5, 14, 8, 11)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        switch (state.get(FACING)) {
            case NORTH:
                return SHAPE_N;
            case SOUTH:
                return SHAPE_S;
            case WEST:
                return SHAPE_W;
            case EAST:
                return SHAPE_E;
            default:
                return SHAPE_N;
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
            if (blockEntity instanceof FaeniteHomeEntity) {
                ItemScatterer.spawn(world, pos, (FaeniteHomeEntity)blockEntity);
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
        return new FaeniteHomeEntity(pos, state);
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
        return checkType(type, ModBlockEntities.FAENITE_HOME, FaeniteHomeEntity::tick);
    }
}
