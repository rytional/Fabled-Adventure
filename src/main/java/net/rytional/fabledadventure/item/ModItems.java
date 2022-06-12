package net.rytional.fabledadventure.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.rytional.fabledadventure.FabledAdventure;
import net.rytional.fabledadventure.entity.ModEntities;
import net.rytional.fabledadventure.fluid.ModFluids;
import net.rytional.fabledadventure.item.custom.*;
import net.rytional.fabledadventure.sound.ModSounds;

public class ModItems {

    //ULTIUM
    public static final Item ULTIUM_INGOT = registerItem("ultium_ingot", new Item(new FabricItemSettings().group(ModItemGroups.FABLED)));

    public static final Item ULTIUM_NUGGET = registerItem("ultium_nugget", new Item(new FabricItemSettings().group(ModItemGroups.FABLED)));

    public static final Item ULTIUM_AXE = registerItem("ultium_axe", new net.rytional.fabledadventure.item.custom.ModAxeItem(ModToolMaterials.ULTIUM, 2, 1f,
            new FabricItemSettings().group(ModItemGroups.FABLED)));

    public static final Item ULTIUM_PICKAXE = registerItem("ultium_pickaxe", new ModPickaxeItem(ModToolMaterials.ULTIUM, 1, 2f,
            new FabricItemSettings().group(ModItemGroups.FABLED)));

    public static final Item ULTIUM_PAXEL = registerItem("ultium_paxel", new ModPaxelItem(ModToolMaterials.ULTIUM, 10, 3f,
            new FabricItemSettings().group(ModItemGroups.FABLED)));

    public static final Item ULTIUM_HELMET = registerItem("ultium_helmet", new ModArmorItem(ModArmorMaterials.ULTIUM, EquipmentSlot.HEAD,
            new FabricItemSettings().group(ModItemGroups.FABLED)));

    public static final Item ULTIUM_CHESTPLATE = registerItem("ultium_chestplate", new ModArmorItem(ModArmorMaterials.ULTIUM, EquipmentSlot.CHEST,
            new FabricItemSettings().group(ModItemGroups.FABLED)));

    public static final Item ULTIUM_LEGGINGS = registerItem("ultium_leggings", new ModArmorItem(ModArmorMaterials.ULTIUM, EquipmentSlot.LEGS,
            new FabricItemSettings().group(ModItemGroups.FABLED)));

    public static final Item ULTIUM_BOOTS = registerItem("ultium_boots", new ModArmorItem(ModArmorMaterials.ULTIUM, EquipmentSlot.FEET,
            new FabricItemSettings().group(ModItemGroups.FABLED)));

    //ENTITIES
    public static final Item RACCOON_SPAWN_EGG = registerItem("raccoon_spawn_egg", new SpawnEggItem(ModEntities.RACCOON, 0x948e8d, 0x3b3635,
            new FabricItemSettings().group(ModItemGroups.FABLED)));
    public static final Item SKY_SPAWN_EGG = registerItem("sky_spawn_egg", new SpawnEggItem(ModEntities.SKY, 0x948e8d, 0x3b3635,
            new FabricItemSettings().group(ModItemGroups.FABLED)));

    //MUSIC DISCS
    public static final Item RAINING_TACOS_MUSIC_DISC = registerItem("raining_tacos_music_disc",
            new ModMusicDiscItem(9, ModSounds.RAINING_TACOS,
    new FabricItemSettings().group(ModItemGroups.FABLED).maxCount(1)));

    //SORCIUM
    public static final Item SORCIUM_INGOT = registerItem("sorcium_ingot", new Item(new FabricItemSettings().group(ModItemGroups.FABLED)));
    public static final Item SORCIUM_BLUE_STAFF = registerItem("sorcium_blue_staff", new ModWitherSwordItem(ModToolMaterials.SORCIUM, 4, 2f,
            new FabricItemSettings().group(ModItemGroups.FABLED)));
    public static final Item SORCIUM_BLUE_HELMET = registerItem("sorcium_blue_helmet", new SorciumBlueRobeItem(ModArmorMaterials.SORCIUM, EquipmentSlot.HEAD,
            new FabricItemSettings().group(ModItemGroups.FABLED)));
    public static final Item SORCIUM_BLUE_CHESTPLATE = registerItem("sorcium_blue_chestplate", new SorciumBlueRobeItem(ModArmorMaterials.SORCIUM, EquipmentSlot.CHEST,
            new FabricItemSettings().group(ModItemGroups.FABLED)));
    public static final Item SORCIUM_BLUE_LEGGINGS = registerItem("sorcium_blue_leggings", new SorciumBlueRobeItem(ModArmorMaterials.SORCIUM, EquipmentSlot.LEGS,
            new FabricItemSettings().group(ModItemGroups.FABLED)));
    public static final Item SORCIUM_BLUE_BOOTS = registerItem("sorcium_blue_boots", new SorciumBlueRobeItem(ModArmorMaterials.SORCIUM, EquipmentSlot.FEET,
            new FabricItemSettings().group(ModItemGroups.FABLED)));
    public static final Item SORCIUM_TOME = registerItem("sorcium_tome", new Item(new FabricItemSettings().group(ModItemGroups.FABLED)));

    //ELFIUM
    public static final Item ELFIUM_BOW = registerItem("elfium_bow",
            new ModBowItem(new FabricItemSettings().group(ModItemGroups.FABLED).maxCount(1)));

    //ORCANITE
    public static final Item ORCANITE_INGOT = registerItem("orcanite_ingot", new ModGlowItem(new FabricItemSettings().group(ModItemGroups.FABLED)));
    public static final Item ORCANITE_NUGGET = registerItem("orcanite_nugget", new ModGlowItem(new FabricItemSettings().group(ModItemGroups.FABLED)));
    public static final Item ORCANITE_DUST = registerItem("orcanite_dust", new ModGlowItem(new FabricItemSettings().group(ModItemGroups.FABLED)));
    public static final Item RAW_ORCANITE = registerItem("raw_orcanite", new ModGlowItem(new FabricItemSettings().group(ModItemGroups.FABLED)));
    public static final Item ORCANITE_GEM = registerItem("orcanite_gem", new ModGlowItem(new FabricItemSettings().group(ModItemGroups.FABLED)));
    public static final Item ORCANITE_SHEET = registerItem("orcanite_sheet", new ModGlowItem(new FabricItemSettings().group(ModItemGroups.FABLED)));
    public static final Item ORCANITE_SHARD = registerItem("orcanite_shard", new ModGlowItem(new FabricItemSettings().group(ModItemGroups.FABLED)));
    public static final Item ORCANITE_CREAM = registerItem("orcanite_cream", new ModGlowItem(new FabricItemSettings().group(ModItemGroups.FABLED)));
    public static final Item ORCANITE_BUCKET = registerItem("orcanite_bucket", new BucketItem(ModFluids.MOLTEN_ORCANITE_STILL, new FabricItemSettings().group(ModItemGroups.FABLED).maxCount(1)));
    public static final Item ORCANITE_AXE = registerItem("orcanite_axe", new ModAxeItem(ModToolMaterials.ORCANITE, 2, 1f,
            new FabricItemSettings().group(ModItemGroups.FABLED)));
    public static final Item ORCANITE_PICKAXE = registerItem("orcanite_pickaxe", new ModPickaxeItem(ModToolMaterials.ORCANITE, 2, 1f,
            new FabricItemSettings().group(ModItemGroups.FABLED)));
    public static final Item ORCANITE_SHOVEL = registerItem("orcanite_shovel", new ModShoveltem(ModToolMaterials.ORCANITE, 2, 1f,
            new FabricItemSettings().group(ModItemGroups.FABLED)));
    public static final Item ORCANITE_SWORD = registerItem("orcanite_sword", new ModSwordItem(ModToolMaterials.ORCANITE, 2, 1f,
            new FabricItemSettings().group(ModItemGroups.FABLED)));
    public static final Item ORCANITE_PAXEL = registerItem("orcanite_paxel", new ModPaxelItem(ModToolMaterials.ORCANITE, 2, 1f,
            new FabricItemSettings().group(ModItemGroups.FABLED)));
    public static final Item ORCANITE_LANCE = registerItem("orcanite_lance", new ModLanceItem(ModToolMaterials.ORCANITE, 2, 1f,4,4,
            new FabricItemSettings().group(ModItemGroups.FABLED)));
    public static final Item ORCANITE_HOE = registerItem("orcanite_hoe", new ModShoveltem(ModToolMaterials.ORCANITE, 2, 1f,
            new FabricItemSettings().group(ModItemGroups.FABLED)));
    public static final Item ORCANITE_HORSE_ARMOR = registerItem("orcanite_horse_armor", new HorseArmorItem(15, "orcanite",
            new FabricItemSettings().group(ModItemGroups.FABLED)));

    //DWARFIUM

    //FAENITE
    public static final Item FAENITE_DUST = registerItem("faenite_dust", new ModGlowItem(new FabricItemSettings().group(ModItemGroups.FABLED)));

    //GYNORMIUM

    //HUMANITE

    //NATURITE

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registry.ITEM, new Identifier(FabledAdventure.MOD_ID, name), item);
    }
    public static void registerModItems() {
        FabledAdventure.LOGGER.info("Registering Mod Items for " + FabledAdventure.MOD_ID);
    }
}
