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
import net.rytional.fabledadventure.block.entity.DragoniteInfuserEntity;
import net.rytional.fabledadventure.block.entity.DwarfiumBlasterEntity;
import net.rytional.fabledadventure.block.entity.ModBlockEntities;
import org.jetbrains.annotations.Nullable;

import java.util.stream.Stream;

public class DragoniteInfuserBlock extends BlockWithEntity implements BlockEntityProvider {
    public static final DirectionProperty FACING = Properties.HORIZONTAL_FACING;

    public DragoniteInfuserBlock(Settings settings) {
        super(settings);
    }
    private static final VoxelShape SHAPE_N = Stream.of(
            Block.createCuboidShape(3, 0, 3, 13, 1, 13),
            Block.createCuboidShape(6, 15, 6, 10, 16, 10),
            Block.createCuboidShape(5, 14, 5, 11, 15, 11),
            Block.createCuboidShape(5, 13, 5, 11, 14, 11),
            Block.createCuboidShape(3, 11, 3, 13, 13, 13),
            Block.createCuboidShape(2, 8, 2, 14, 11, 14),
            Block.createCuboidShape(1, 3, 1, 15, 8, 15),
            Block.createCuboidShape(2, 1, 2, 14, 3, 14),
            Block.createCuboidShape(-5, 5.5, 9.5, -4, 6, 10),
            Block.createCuboidShape(-1, 8, 6, 1, 9.5, 7),
            Block.createCuboidShape(-1, 8, 9, 1, 9.5, 10),
            Block.createCuboidShape(-2, 3, 5, 1, 8, 11),
            Block.createCuboidShape(-6.827843506985502, 3.264124495484193, 5.5, -2.827843506985502, 4.764124495484193, 10.5),
            Block.createCuboidShape(-6, 4, 5.5, -2, 5.5, 10.5),
            Block.createCuboidShape(-5, 5.5, 6, -4, 6, 6.5),
            Block.createCuboidShape(5.75, 8, 15, 6.75, 9.5, 17),
            Block.createCuboidShape(8.75, 8, 15, 9.75, 9.5, 17),
            Block.createCuboidShape(4.75, 3, 15, 10.75, 8, 18),
            Block.createCuboidShape(5.25, 3.264124495484193, 18, 10.25, 4.764124495484193, 22),
            Block.createCuboidShape(5.25, 4, 18, 10.25, 5.5, 22),
            Block.createCuboidShape(5.75, 5.5, 20, 6.25, 6, 21),
            Block.createCuboidShape(9.25, 5.5, 20, 9.75, 6, 21),
            Block.createCuboidShape(8.75, 8, -1, 9.75, 9.5, 1),
            Block.createCuboidShape(5.75, 8, -1, 6.75, 9.5, 1),
            Block.createCuboidShape(4.75, 3, -2, 10.75, 8, 1),
            Block.createCuboidShape(5.25, 3.26, -6, 10.25, 4.76, -2),
            Block.createCuboidShape(5.25, 4, -6, 10.25, 5.5, -2),
            Block.createCuboidShape(9.25, 5.5, -5, 9.75, 6, -4),
            Block.createCuboidShape(5.75, 5.5, -5, 6.25, 6, -4),
            Block.createCuboidShape(15, 8, 9, 17, 9.5, 10),
            Block.createCuboidShape(15, 8, 6, 17, 9.5, 7),
            Block.createCuboidShape(15, 3, 5, 18, 8, 11),
            Block.createCuboidShape(18, 3.26, 5.5, 22, 4.76, 10.5),
            Block.createCuboidShape(18, 4, 5.5, 22, 5.5, 10.5),
            Block.createCuboidShape(20, 5.5, 9.5, 21, 6, 10),
            Block.createCuboidShape(20, 5.5, 6, 21, 6, 6.5)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();


    private static final VoxelShape SHAPE_E = Stream.of(
            Block.createCuboidShape(3, 0, 3, 13, 1, 13),
            Block.createCuboidShape(6, 15, 6, 10, 16, 10),
            Block.createCuboidShape(5, 14, 5, 11, 15, 11),
            Block.createCuboidShape(5, 13, 5, 11, 14, 11),
            Block.createCuboidShape(3, 11, 3, 13, 13, 13),
            Block.createCuboidShape(2, 8, 2, 14, 11, 14),
            Block.createCuboidShape(1, 3, 1, 15, 8, 15),
            Block.createCuboidShape(2, 1, 2, 14, 3, 14),
            Block.createCuboidShape(-5, 5.5, 9.5, -4, 6, 10),
            Block.createCuboidShape(-1, 8, 6, 1, 9.5, 7),
            Block.createCuboidShape(-1, 8, 9, 1, 9.5, 10),
            Block.createCuboidShape(-2, 3, 5, 1, 8, 11),
            Block.createCuboidShape(-6.827843506985502, 3.264124495484193, 5.5, -2.827843506985502, 4.764124495484193, 10.5),
            Block.createCuboidShape(-6, 4, 5.5, -2, 5.5, 10.5),
            Block.createCuboidShape(-5, 5.5, 6, -4, 6, 6.5),
            Block.createCuboidShape(5.75, 8, 15, 6.75, 9.5, 17),
            Block.createCuboidShape(8.75, 8, 15, 9.75, 9.5, 17),
            Block.createCuboidShape(4.75, 3, 15, 10.75, 8, 18),
            Block.createCuboidShape(5.25, 3.264124495484193, 18, 10.25, 4.764124495484193, 22),
            Block.createCuboidShape(5.25, 4, 18, 10.25, 5.5, 22),
            Block.createCuboidShape(5.75, 5.5, 20, 6.25, 6, 21),
            Block.createCuboidShape(9.25, 5.5, 20, 9.75, 6, 21),
            Block.createCuboidShape(8.75, 8, -1, 9.75, 9.5, 1),
            Block.createCuboidShape(5.75, 8, -1, 6.75, 9.5, 1),
            Block.createCuboidShape(4.75, 3, -2, 10.75, 8, 1),
            Block.createCuboidShape(5.25, 3.26, -6, 10.25, 4.76, -2),
            Block.createCuboidShape(5.25, 4, -6, 10.25, 5.5, -2),
            Block.createCuboidShape(9.25, 5.5, -5, 9.75, 6, -4),
            Block.createCuboidShape(5.75, 5.5, -5, 6.25, 6, -4),
            Block.createCuboidShape(15, 8, 9, 17, 9.5, 10),
            Block.createCuboidShape(15, 8, 6, 17, 9.5, 7),
            Block.createCuboidShape(15, 3, 5, 18, 8, 11),
            Block.createCuboidShape(18, 3.26, 5.5, 22, 4.76, 10.5),
            Block.createCuboidShape(18, 4, 5.5, 22, 5.5, 10.5),
            Block.createCuboidShape(20, 5.5, 9.5, 21, 6, 10),
            Block.createCuboidShape(20, 5.5, 6, 21, 6, 6.5)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();

    private static final VoxelShape SHAPE_S = Stream.of(
            Block.createCuboidShape(3, 0, 3, 13, 1, 13),
            Block.createCuboidShape(6, 15, 6, 10, 16, 10),
            Block.createCuboidShape(5, 14, 5, 11, 15, 11),
            Block.createCuboidShape(5, 13, 5, 11, 14, 11),
            Block.createCuboidShape(3, 11, 3, 13, 13, 13),
            Block.createCuboidShape(2, 8, 2, 14, 11, 14),
            Block.createCuboidShape(1, 3, 1, 15, 8, 15),
            Block.createCuboidShape(2, 1, 2, 14, 3, 14),
            Block.createCuboidShape(-5, 5.5, 9.5, -4, 6, 10),
            Block.createCuboidShape(-1, 8, 6, 1, 9.5, 7),
            Block.createCuboidShape(-1, 8, 9, 1, 9.5, 10),
            Block.createCuboidShape(-2, 3, 5, 1, 8, 11),
            Block.createCuboidShape(-6.827843506985502, 3.264124495484193, 5.5, -2.827843506985502, 4.764124495484193, 10.5),
            Block.createCuboidShape(-6, 4, 5.5, -2, 5.5, 10.5),
            Block.createCuboidShape(-5, 5.5, 6, -4, 6, 6.5),
            Block.createCuboidShape(5.75, 8, 15, 6.75, 9.5, 17),
            Block.createCuboidShape(8.75, 8, 15, 9.75, 9.5, 17),
            Block.createCuboidShape(4.75, 3, 15, 10.75, 8, 18),
            Block.createCuboidShape(5.25, 3.264124495484193, 18, 10.25, 4.764124495484193, 22),
            Block.createCuboidShape(5.25, 4, 18, 10.25, 5.5, 22),
            Block.createCuboidShape(5.75, 5.5, 20, 6.25, 6, 21),
            Block.createCuboidShape(9.25, 5.5, 20, 9.75, 6, 21),
            Block.createCuboidShape(8.75, 8, -1, 9.75, 9.5, 1),
            Block.createCuboidShape(5.75, 8, -1, 6.75, 9.5, 1),
            Block.createCuboidShape(4.75, 3, -2, 10.75, 8, 1),
            Block.createCuboidShape(5.25, 3.26, -6, 10.25, 4.76, -2),
            Block.createCuboidShape(5.25, 4, -6, 10.25, 5.5, -2),
            Block.createCuboidShape(9.25, 5.5, -5, 9.75, 6, -4),
            Block.createCuboidShape(5.75, 5.5, -5, 6.25, 6, -4),
            Block.createCuboidShape(15, 8, 9, 17, 9.5, 10),
            Block.createCuboidShape(15, 8, 6, 17, 9.5, 7),
            Block.createCuboidShape(15, 3, 5, 18, 8, 11),
            Block.createCuboidShape(18, 3.26, 5.5, 22, 4.76, 10.5),
            Block.createCuboidShape(18, 4, 5.5, 22, 5.5, 10.5),
            Block.createCuboidShape(20, 5.5, 9.5, 21, 6, 10),
            Block.createCuboidShape(20, 5.5, 6, 21, 6, 6.5)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();

    private static final VoxelShape SHAPE_W = Stream.of(
            Block.createCuboidShape(3, 0, 3, 13, 1, 13),
            Block.createCuboidShape(6, 15, 6, 10, 16, 10),
            Block.createCuboidShape(5, 14, 5, 11, 15, 11),
            Block.createCuboidShape(5, 13, 5, 11, 14, 11),
            Block.createCuboidShape(3, 11, 3, 13, 13, 13),
            Block.createCuboidShape(2, 8, 2, 14, 11, 14),
            Block.createCuboidShape(1, 3, 1, 15, 8, 15),
            Block.createCuboidShape(2, 1, 2, 14, 3, 14),
            Block.createCuboidShape(-5, 5.5, 9.5, -4, 6, 10),
            Block.createCuboidShape(-1, 8, 6, 1, 9.5, 7),
            Block.createCuboidShape(-1, 8, 9, 1, 9.5, 10),
            Block.createCuboidShape(-2, 3, 5, 1, 8, 11),
            Block.createCuboidShape(-6.827843506985502, 3.264124495484193, 5.5, -2.827843506985502, 4.764124495484193, 10.5),
            Block.createCuboidShape(-6, 4, 5.5, -2, 5.5, 10.5),
            Block.createCuboidShape(-5, 5.5, 6, -4, 6, 6.5),
            Block.createCuboidShape(5.75, 8, 15, 6.75, 9.5, 17),
            Block.createCuboidShape(8.75, 8, 15, 9.75, 9.5, 17),
            Block.createCuboidShape(4.75, 3, 15, 10.75, 8, 18),
            Block.createCuboidShape(5.25, 3.264124495484193, 18, 10.25, 4.764124495484193, 22),
            Block.createCuboidShape(5.25, 4, 18, 10.25, 5.5, 22),
            Block.createCuboidShape(5.75, 5.5, 20, 6.25, 6, 21),
            Block.createCuboidShape(9.25, 5.5, 20, 9.75, 6, 21),
            Block.createCuboidShape(8.75, 8, -1, 9.75, 9.5, 1),
            Block.createCuboidShape(5.75, 8, -1, 6.75, 9.5, 1),
            Block.createCuboidShape(4.75, 3, -2, 10.75, 8, 1),
            Block.createCuboidShape(5.25, 3.26, -6, 10.25, 4.76, -2),
            Block.createCuboidShape(5.25, 4, -6, 10.25, 5.5, -2),
            Block.createCuboidShape(9.25, 5.5, -5, 9.75, 6, -4),
            Block.createCuboidShape(5.75, 5.5, -5, 6.25, 6, -4),
            Block.createCuboidShape(15, 8, 9, 17, 9.5, 10),
            Block.createCuboidShape(15, 8, 6, 17, 9.5, 7),
            Block.createCuboidShape(15, 3, 5, 18, 8, 11),
            Block.createCuboidShape(18, 3.26, 5.5, 22, 4.76, 10.5),
            Block.createCuboidShape(18, 4, 5.5, 22, 5.5, 10.5),
            Block.createCuboidShape(20, 5.5, 9.5, 21, 6, 10),
            Block.createCuboidShape(20, 5.5, 6, 21, 6, 6.5)
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
            if (blockEntity instanceof DragoniteInfuserEntity) {
                ItemScatterer.spawn(world, pos, (DragoniteInfuserEntity)blockEntity);
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
        return new DragoniteInfuserEntity(pos, state);
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
        return checkType(type, ModBlockEntities.DRAGONITE_INFUSER, DragoniteInfuserEntity::tick);
    }
}
