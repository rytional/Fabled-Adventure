package net.rytional.fabledadventure.block.custom;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.AbstractCauldronBlock;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.rytional.fabledadventure.util.ModCauldronBehavior;

public class OrcaniteCauldronBlock
        extends AbstractCauldronBlock {
    public OrcaniteCauldronBlock(AbstractBlock.Settings settings) {
        super(settings, ModCauldronBehavior.MOLTEN_ORCANITE_CAULDRON_BEHAVIOR);
    }

    @Override
    protected double getFluidHeight(BlockState state) {
        return 0.9375;
    }

    @Override
    public boolean isFull(BlockState state) {
        return true;
    }

    @Override
    public void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity) {
        if (this.isEntityTouchingFluid(state, pos, entity)) {
            entity.setOnFireFromLava();
        }
    }

    @Override
    public int getComparatorOutput(BlockState state, World world, BlockPos pos) {
        return 3;
    }
}
