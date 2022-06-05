package net.rytional.fabledadventure.fluid;

import net.minecraft.block.*;
import net.minecraft.fluid.*;
import net.minecraft.item.Item;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.tag.FluidTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.*;
import net.rytional.fabledadventure.block.ModBlocks;
import net.rytional.fabledadventure.item.ModItems;
import net.rytional.fabledadventure.util.ModTags;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;
import java.util.Random;

public abstract class OrcaniteFluid
        extends FlowableFluid {
    public static final float field_31729 = 0.44444445f;

    @Override
    public Fluid getFlowing() {
        return ModFluids.MOLTEN_ORCANITE_FLOWING;
    }

    @Override
    public Fluid getStill() {
        return ModFluids.MOLTEN_ORCANITE_STILL;
    }

    @Override
    public Item getBucketItem() {
        return ModItems.ORCANITE_BUCKET;
    }

    @Override
    public void randomDisplayTick(World world, BlockPos pos, FluidState state, Random random) {
        BlockPos blockPos = pos.up();
        if (world.getBlockState(blockPos).isAir() && !world.getBlockState(blockPos).isOpaqueFullCube(world, blockPos)) {
            if (random.nextInt(100) == 0) {
                double d = (double)pos.getX() + random.nextDouble();
                double e = (double)pos.getY() + 1.0;
                double f = (double)pos.getZ() + random.nextDouble();
                world.addParticle(ParticleTypes.LAVA, d, e, f, 0.0, 0.0, 0.0);
                world.playSound(d, e, f, SoundEvents.BLOCK_LAVA_POP, SoundCategory.BLOCKS, 0.2f + random.nextFloat() * 0.2f, 0.9f + random.nextFloat() * 0.15f, false);
            }
            if (random.nextInt(200) == 0) {
                world.playSound(pos.getX(), (double)pos.getY(), (double)pos.getZ(), SoundEvents.BLOCK_LAVA_AMBIENT, SoundCategory.BLOCKS, 0.2f + random.nextFloat() * 0.2f, 0.9f + random.nextFloat() * 0.15f, false);
            }
        }
    }

    @Override
    public void onRandomTick(World world, BlockPos pos, FluidState state, Random random) {
        if (!world.getGameRules().getBoolean(GameRules.DO_FIRE_TICK)) {
            return;
        }
        int i = random.nextInt(3);
        if (i > 0) {
            BlockPos blockPos = pos;
            for (int j = 0; j < i; ++j) {
                if (!world.canSetBlock(blockPos = blockPos.add(random.nextInt(3) - 1, 1, random.nextInt(3) - 1))) {
                    return;
                }
                BlockState blockState = world.getBlockState(blockPos);
                if (blockState.isAir()) {
                    if (!this.canLightFire(world, blockPos)) continue;
                    world.setBlockState(blockPos, AbstractFireBlock.getState(world, blockPos));
                    return;
                }
                if (!blockState.getMaterial().blocksMovement()) continue;
                return;
            }
        } else {
            for (int k = 0; k < 3; ++k) {
                BlockPos blockPos2 = pos.add(random.nextInt(3) - 1, 0, random.nextInt(3) - 1);
                if (!world.canSetBlock(blockPos2)) {
                    return;
                }
                if (!world.isAir(blockPos2.up()) || !this.hasBurnableBlock(world, blockPos2)) continue;
                world.setBlockState(blockPos2.up(), AbstractFireBlock.getState(world, blockPos2));
            }
        }
    }

    private boolean canLightFire(WorldView world, BlockPos pos) {
        for (Direction direction : Direction.values()) {
            if (!this.hasBurnableBlock(world, pos.offset(direction))) continue;
            return true;
        }
        return false;
    }

    private boolean hasBurnableBlock(WorldView world, BlockPos pos) {
        if (pos.getY() >= world.getBottomY() && pos.getY() < world.getTopY() && !world.isChunkLoaded(pos)) {
            return false;
        }
        return world.getBlockState(pos).getMaterial().isBurnable();
    }

    @Override
    @Nullable
    public ParticleEffect getParticle() {
        return ParticleTypes.DRIPPING_LAVA;
    }

    @Override
    protected void beforeBreakingBlock(WorldAccess world, BlockPos pos, BlockState state) {
        this.playExtinguishEvent(world, pos);
    }

    @Override
    public int getFlowSpeed(WorldView world) {
        return world.getDimension().isUltrawarm() ? 4 : 2;
    }

    @Override
    public BlockState toBlockState(FluidState state) {
        return ModBlocks.ORCANITE_FLUID_BLOCK.getDefaultState().with(FluidBlock.LEVEL, LavaFluid.getBlockStateLevel(state));
    }

    @Override
    public boolean matchesType(Fluid fluid) {
        return fluid == ModFluids.MOLTEN_ORCANITE_STILL || fluid == ModFluids.MOLTEN_ORCANITE_FLOWING;
    }

    @Override
    public int getLevelDecreasePerBlock(WorldView world) {
        return world.getDimension().isUltrawarm() ? 1 : 2;
    }

    @Override
    public boolean canBeReplacedWith(FluidState state, BlockView world, BlockPos pos, Fluid fluid, Direction direction) {
        return state.getHeight(world, pos) >= 0.44444445f && fluid.isIn(FluidTags.WATER);
    }

    @Override
    public int getTickRate(WorldView world) {
        return world.getDimension().isUltrawarm() ? 10 : 30;
    }

    @Override
    public int getNextTickDelay(World world, BlockPos pos, FluidState oldState, FluidState newState) {
        int i = this.getTickRate(world);
        if (!(oldState.isEmpty() || newState.isEmpty() || oldState.get(FALLING).booleanValue() || newState.get(FALLING).booleanValue() || !(newState.getHeight(world, pos) > oldState.getHeight(world, pos)) || world.getRandom().nextInt(4) == 0)) {
            i *= 4;
        }
        return i;
    }

    private void playExtinguishEvent(WorldAccess world, BlockPos pos) {
        world.syncWorldEvent(WorldEvents.LAVA_EXTINGUISHED, pos, 0);
    }

    @Override
    protected boolean isInfinite() {
        return false;
    }

    @Override
    protected void flow(WorldAccess world, BlockPos pos, BlockState state, Direction direction, FluidState fluidState) {
        if (direction == Direction.DOWN) {
            FluidState fluidState2 = world.getFluidState(pos);
            if (this.isIn(ModTags.Fluids.MOLTEN_FLUID) && fluidState2.isIn(FluidTags.WATER)) {
                if (state.getBlock() instanceof FluidBlock) {
                    world.setBlockState(pos, Blocks.STONE.getDefaultState(), Block.NOTIFY_ALL);
                }
                this.playExtinguishEvent(world, pos);
                return;
            }
        }
        super.flow(world, pos, state, direction, fluidState);
    }

    @Override
    protected boolean hasRandomTicks() {
        return true;
    }

    @Override
    protected float getBlastResistance() {
        return 100.0f;
    }

    @Override
    public Optional<SoundEvent> getBucketFillSound() {
        return Optional.of(SoundEvents.ITEM_BUCKET_FILL_LAVA);
    }

    public static class Flowing
            extends OrcaniteFluid {
        @Override
        protected void appendProperties(StateManager.Builder<Fluid, FluidState> builder) {
            super.appendProperties(builder);
            builder.add(LEVEL);
        }

        @Override
        public int getLevel(FluidState state) {
            return state.get(LEVEL);
        }

        @Override
        public boolean isStill(FluidState state) {
            return false;
        }
    }

    public static class Still
            extends OrcaniteFluid {
        @Override
        public int getLevel(FluidState state) {
            return 8;
        }

        @Override
        public boolean isStill(FluidState state) {
            return true;
        }
    }
}
