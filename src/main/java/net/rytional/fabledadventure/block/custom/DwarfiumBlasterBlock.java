package net.rytional.fabledadventure.block.custom;

import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
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
import net.rytional.fabledadventure.block.entity.DwarfiumBlasterEntity;
import net.rytional.fabledadventure.block.entity.ModBlockEntities;
import org.jetbrains.annotations.Nullable;

import java.util.Random;
import java.util.stream.Stream;

public class DwarfiumBlasterBlock extends BlockWithEntity implements BlockEntityProvider {
    public static final DirectionProperty FACING = Properties.HORIZONTAL_FACING;

    public DwarfiumBlasterBlock(Settings settings) {
        super(settings);
    }
    private static final VoxelShape SHAPE_N = Stream.of(
            Block.createCuboidShape(12, 0, 0, 16, 3, 4),
            Block.createCuboidShape(12, 0, 12, 16, 3, 16),
            Block.createCuboidShape(0, 0, 12, 4, 3, 16),
            Block.createCuboidShape(0, 0, 0, 4, 3, 4),
            Block.createCuboidShape(3, 4, 3, 13, 8, 5),
            Block.createCuboidShape(2, 0, 1, 14, 4, 14),
            Block.createCuboidShape(4, 0, 15, 12, 2, 16),
            Block.createCuboidShape(0, 0, 4, 1, 2, 12),
            Block.createCuboidShape(15, 0, 4, 16, 2, 12),
            Block.createCuboidShape(3, 4, 5, 13, 23, 14),
            Block.createCuboidShape(4, 0, 14, 12, 10, 15),
            Block.createCuboidShape(4, 23, 6, 12, 29, 13)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();

    private static final VoxelShape SHAPE_E = Stream.of(
            Block.createCuboidShape(12, 0, 12, 16, 3, 16),
            Block.createCuboidShape(0, 0, 12, 4, 3, 16),
            Block.createCuboidShape(0, 0, 0, 4, 3, 4),
            Block.createCuboidShape(12, 0, 0, 16, 3, 4),
            Block.createCuboidShape(11, 4, 3, 13, 8, 13),
            Block.createCuboidShape(2, 0, 2, 15, 4, 14),
            Block.createCuboidShape(0, 0, 4, 1, 2, 12),
            Block.createCuboidShape(4, 0, 0, 12, 2, 1),
            Block.createCuboidShape(4, 0, 15, 12, 2, 16),
            Block.createCuboidShape(2, 4, 3, 11, 23, 13),
            Block.createCuboidShape(1, 0, 4, 2, 10, 12),
            Block.createCuboidShape(3, 23, 4, 10, 29, 12)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();

    private static final VoxelShape SHAPE_S = Stream.of(
            Block.createCuboidShape(0, 0, 12, 4, 3, 16),
            Block.createCuboidShape(0, 0, 0, 4, 3, 4),
            Block.createCuboidShape(12, 0, 0, 16, 3, 4),
            Block.createCuboidShape(12, 0, 12, 16, 3, 16),
            Block.createCuboidShape(3, 4, 11, 13, 8, 13),
            Block.createCuboidShape(2, 0, 2, 14, 4, 15),
            Block.createCuboidShape(4, 0, 0, 12, 2, 1),
            Block.createCuboidShape(15, 0, 4, 16, 2, 12),
            Block.createCuboidShape(0, 0, 4, 1, 2, 12),
            Block.createCuboidShape(3, 4, 2, 13, 23, 11),
            Block.createCuboidShape(4, 0, 1, 12, 10, 2),
            Block.createCuboidShape(4, 23, 3, 12, 29, 10)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();

    private static final VoxelShape SHAPE_W = Stream.of(
            Block.createCuboidShape(0, 0, 0, 4, 3, 4),
            Block.createCuboidShape(12, 0, 0, 16, 3, 4),
            Block.createCuboidShape(12, 0, 12, 16, 3, 16),
            Block.createCuboidShape(0, 0, 12, 4, 3, 16),
            Block.createCuboidShape(3, 4, 3, 5, 8, 13),
            Block.createCuboidShape(1, 0, 2, 14, 4, 14),
            Block.createCuboidShape(15, 0, 4, 16, 2, 12),
            Block.createCuboidShape(4, 0, 15, 12, 2, 16),
            Block.createCuboidShape(4, 0, 0, 12, 2, 1),
            Block.createCuboidShape(5, 4, 3, 14, 23, 13),
            Block.createCuboidShape(14, 0, 4, 15, 10, 12),
            Block.createCuboidShape(6, 23, 4, 13, 29, 12)
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
    public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {
        float chance = 0.35f;

        if(chance < random.nextFloat()) {
            world.addParticle(ParticleTypes.SMOKE, pos.getX() + random.nextDouble(),
                    pos.getY() + 2D, pos.getZ() + random.nextDouble(),
                    0d, 0.015d + random.nextDouble(0.075d), 0d);
        }

        if(chance < random.nextFloat()) {
            world.addParticle(ParticleTypes.SMOKE, pos.getX() + random.nextDouble(),
                    pos.getY() + 2D, pos.getZ() + random.nextDouble(),
                    0d, 0.015d + random.nextDouble(0.075d), 0d);
        }

        if(chance < random.nextFloat()) {
            world.addParticle(ParticleTypes.SMOKE, pos.getX() + random.nextDouble(),
                    pos.getY() + 2D, pos.getZ() + random.nextDouble(),
                    0d, 0.015d + random.nextDouble(0.075d), 0d);
        }

        if(chance < random.nextFloat()) {
            world.addParticle(ParticleTypes.SMOKE, pos.getX() + random.nextDouble(),
                    pos.getY() + 2D, pos.getZ() + random.nextDouble(),
                    0d, 0.015d + random.nextDouble(0.075d), 0d);
        }
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
            if (blockEntity instanceof DwarfiumBlasterEntity) {
                ItemScatterer.spawn(world, pos, (DwarfiumBlasterEntity)blockEntity);
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
        return new DwarfiumBlasterEntity(pos, state);
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
        return checkType(type, ModBlockEntities.DWARFIUM_BLASTER, DwarfiumBlasterEntity::tick);
    }
}
