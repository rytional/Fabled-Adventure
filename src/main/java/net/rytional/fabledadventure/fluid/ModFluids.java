package net.rytional.fabledadventure.fluid;

import net.minecraft.fluid.FlowableFluid;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.rytional.fabledadventure.FabledAdventure;

public class ModFluids {
    public static final FlowableFluid MOLTEN_ORCANITE_STILL = register("molten_orcanite_still", new OrcaniteFluid.Still());
    public static final FlowableFluid MOLTEN_ORCANITE_FLOWING = register("molten_orcanite_flowing", new OrcaniteFluid.Flowing());

    private static FlowableFluid register(String name, FlowableFluid flowableFluid) {
        return Registry.register(Registry.FLUID, new Identifier(FabledAdventure.MOD_ID, name), flowableFluid);
    }
}
