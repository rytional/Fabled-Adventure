package net.rytional.fabledadventure.world.gen;

import com.mojang.serialization.Codec;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.TestableWorld;
import net.minecraft.world.gen.treedecorator.TreeDecorator;
import net.minecraft.world.gen.treedecorator.TreeDecoratorType;
import net.rytional.fabledadventure.block.ModBlocks;
import net.rytional.fabledadventure.world.ModConfiguredFeatures;

import java.util.List;
import java.util.Random;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FaeniteHomeTreeDecorator extends TreeDecorator {
    public static final FaeniteHomeTreeDecorator INSTANCE = new FaeniteHomeTreeDecorator();
    // Our constructor doesn't have any arguments, so we create a unit codec that returns the singleton instance
    public static final Codec<FaeniteHomeTreeDecorator> CODEC = Codec.unit(() -> INSTANCE);

    @Override
    protected TreeDecoratorType<?> getType() {
        return (TreeDecoratorType<?>) ModConfiguredFeatures.FAENITE_HOME_TREE_DECORATOR;
    }

    @Override
    public void generate(TestableWorld world, BiConsumer<BlockPos, BlockState> replacer, Random random, List<BlockPos> logPositions, List<BlockPos> leavesPositions) {
        // Iterate through block positions
        for (BlockPos logPosition : logPositions) {
            // Pick a value from 0 (inclusive) to 4 (exclusive) and if it's 0, continue
            // This is the chance for spawning the gold block
            if (random.nextInt(24) == 0) {
                // Pick a random value from 0 to 4 and determine the side where the gold block will be placed using it
                int sideRaw = random.nextInt(4);
                Direction side = switch (sideRaw) {
                    case 0 -> Direction.NORTH;
                    case 1 -> Direction.SOUTH;
                    case 2 -> Direction.EAST;
                    case 3 -> Direction.WEST;
                    default -> throw new ArithmeticException("The picked side value doesn't fit in the 0 to 4 bounds");
                };

                // Offset the log position by the resulting side
                BlockPos targetPosition = logPosition.offset(side, 1);

                // Place the gold block using the replacer BiConsumer
                // This is the standard way of placing blocks in TrunkPlacers, FoliagePlacers and TreeDecorators
                replacer.accept(targetPosition, ModBlocks.FAENITE_HOME.getDefaultState());
            }
        }
    }
}
