package net.rytional.fabledadventure.mixin;

import com.mojang.serialization.Codec;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(net.minecraft.world.gen.treedecorator.TreeDecoratorType.class)
public interface TreeDecoratorType<F extends net.minecraft.world.gen.treedecorator.TreeDecorator> {
    @Invoker
    static <P extends net.minecraft.world.gen.treedecorator.TreeDecorator> net.minecraft.world.gen.treedecorator.TreeDecoratorType<P> callRegister(String id, Codec<P> codec) {
        throw new IllegalStateException();
    }
}
