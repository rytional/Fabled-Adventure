package net.rytional.fabledadventure.villager;

import com.google.common.collect.ImmutableSet;
import net.fabricmc.fabric.mixin.object.builder.PointOfInterestTypeAccessor;
import net.fabricmc.fabric.mixin.object.builder.VillagerProfessionAccessor;
import net.minecraft.block.Block;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.village.VillagerProfession;
import net.minecraft.world.poi.PointOfInterestType;
import net.rytional.fabledadventure.FabledAdventure;
import net.rytional.fabledadventure.block.ModBlocks;

public class ModVillagers {
    public static final PointOfInterestType DWARFIUMBLASTER_POI = registerPOI("dwarfiumblasterpoi", ModBlocks.DWARFIUM_BLASTER);
    public static final VillagerProfession DWARFIUM_MASTER = registerProfession("dwarfiummaster", DWARFIUMBLASTER_POI);

    public static VillagerProfession registerProfession(String name, PointOfInterestType type) {
        return Registry.register(Registry.VILLAGER_PROFESSION, new Identifier(FabledAdventure.MOD_ID, name),
                VillagerProfessionAccessor.create(name, type, ImmutableSet.of(), ImmutableSet.of(),
                        SoundEvents.ENTITY_VILLAGER_WORK_CARTOGRAPHER));
    }

    public static PointOfInterestType registerPOI(String name, Block block) {
        return Registry.register(Registry.POINT_OF_INTEREST_TYPE, new Identifier(FabledAdventure.MOD_ID, name),
                PointOfInterestTypeAccessor.callCreate(name,
                        ImmutableSet.copyOf(block.getStateManager().getStates()),
                        1, 1));
    }

    public static void setupPOIs() {
        PointOfInterestTypeAccessor.callSetup(DWARFIUMBLASTER_POI);
    }
}
