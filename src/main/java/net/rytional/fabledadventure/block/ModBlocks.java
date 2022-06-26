package net.rytional.fabledadventure.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.util.registry.Registry;
import net.rytional.fabledadventure.FabledAdventure;
import net.rytional.fabledadventure.block.custom.*;
import net.rytional.fabledadventure.fluid.ModFluids;
import net.rytional.fabledadventure.world.feature.tree.FaeniteSaplingGenerator;
import net.rytional.fabledadventure.world.feature.tree.NaturiteSaplingGenerator;
import net.rytional.fabledadventure.item.ModItemGroups;


public class ModBlocks {

    //ULTIUM
    public static final Block ULTIUM_BLOCK = registerBlock("ultium_block",
            new Block(FabricBlockSettings.of(Material.METAL).strength(4.0f).requiresTool().luminance(14)), ModItemGroups.FABLED);
    public static final Block SPEEDY_BLOCK = registerBlock("speedy_block",
            new SpeedyBlock(FabricBlockSettings.of(Material.METAL).strength(4.0f).luminance(14)), ModItemGroups.FABLED);
    public static final Block ULTIUM_BEDROCK_ORE = registerBlock("ultium_bedrock_ore",
            new OreBlock(FabricBlockSettings.of(Material.STONE).strength(1.5f).requiresTool().sounds(BlockSoundGroup.LODESTONE),
                    UniformIntProvider.create(3, 7)), ModItemGroups.FABLED);
    public static final Block ULTIUM_NETHERRACK_ORE = registerBlock("ultium_netherrack_ore",
            new OreBlock(FabricBlockSettings.of(Material.STONE).strength(1.5f).requiresTool().sounds(BlockSoundGroup.NETHERRACK),
                    UniformIntProvider.create(3, 7)), ModItemGroups.FABLED);
    public static final Block ULTIUM_ENDSTONE_ORE = registerBlock("ultium_endstone_ore",
            new OreBlock(FabricBlockSettings.of(Material.STONE).strength(1.5f).requiresTool(),
                    UniformIntProvider.create(3, 7)), ModItemGroups.FABLED);

    //ORCANITE
    public static final Block ORCANITE_STONE_ORE = registerBlock("orcanite_stone_ore",
            new OrcanitePoisonOre(FabricBlockSettings.of(Material.STONE).strength(1.5f).requiresTool()), ModItemGroups.FABLED);
    public static final Block COBBLED_ORCANITE = registerBlock("cobbled_orcanite",
            new OrcanitePoisonOre(FabricBlockSettings.of(Material.METAL).strength(2f).requiresTool()), ModItemGroups.FABLED);
    public static final Block ORCANITE_DEEPSLATE_ORE = registerBlock("orcanite_deepslate_ore",
            new OrcanitePoisonOre(FabricBlockSettings.of(Material.STONE).strength(1.5f).requiresTool().sounds(BlockSoundGroup.DEEPSLATE)), ModItemGroups.FABLED);
    public static final Block ORCANITE_NETHERRACK_ORE = registerBlock("orcanite_netherrack_ore",
            new OrcanitePoisonOre(FabricBlockSettings.of(Material.STONE).strength(1.5f).requiresTool().sounds(BlockSoundGroup.NETHERRACK)), ModItemGroups.FABLED);
    public static final Block ORCANITE_ENDSTONE_ORE = registerBlock("orcanite_endstone_ore",
            new OrcanitePoisonOre(FabricBlockSettings.of(Material.STONE).strength(1.5f).requiresTool()), ModItemGroups.FABLED);
    public static final Block ORCANITE_BLOCK = registerBlock("orcanite_block",
            new Block(FabricBlockSettings.of(Material.AMETHYST).strength(4.0f).requiresTool().luminance(14)), ModItemGroups.FABLED);
    public static final Block ORCANITE_FLUID_BLOCK = registerBlockWithoutBlockItem("orcanite_fluid_block",
            new ModFluidBlock(ModFluids.MOLTEN_ORCANITE_STILL, FabricBlockSettings.of(Material.LAVA).noCollision().ticksRandomly().strength(100.0f).luminance(state -> 15).dropsNothing()), ModItemGroups.FABLED);
    public static final Block MOLTEN_ORCANITE_CAULDRON = registerBlockWithoutBlockItem("molten_orcanite_cauldron",
            new OrcaniteCauldronBlock(FabricBlockSettings.copy(Blocks.CAULDRON)), ModItemGroups.FABLED);



    //NATURITE
    public static final Block NATURITE_LOG = registerBlock("naturite_log",
            new PillarBlock(FabricBlockSettings.copy(Blocks.OAK_LOG)), ModItemGroups.FABLED);
    public static final Block STRIPPED_NATURITE_LOG = registerBlock("stripped_naturite_log",
            new PillarBlock(FabricBlockSettings.copy(Blocks.STRIPPED_OAK_LOG)), ModItemGroups.FABLED);
    public static final Block NATURITE_WOOD = registerBlock("naturite_wood",
            new PillarBlock(FabricBlockSettings.copy(Blocks.OAK_WOOD)), ModItemGroups.FABLED);
    public static final Block STRIPPED_NATURITE_WOOD = registerBlock("stripped_naturite_wood",
            new PillarBlock(FabricBlockSettings.copy(Blocks.STRIPPED_OAK_WOOD)), ModItemGroups.FABLED);
    public static final Block NATURITE_PLANKS = registerBlock("naturite_planks",
            new Block(FabricBlockSettings.copy(Blocks.OAK_PLANKS)), ModItemGroups.FABLED);
    public static final Block NATURITE_LEAVES = registerBlock("naturite_leaves",
            new LeavesBlock(FabricBlockSettings.copy(Blocks.OAK_LEAVES)), ModItemGroups.FABLED);
    public static final Block NATURITE_SAPLING = registerBlock("naturite_sapling",
            new ModSaplingBlock(new NaturiteSaplingGenerator(),
                    FabricBlockSettings.copy(Blocks.OAK_SAPLING)), ModItemGroups.FABLED);
    public static final Block NATURITE_ROSE = registerBlock("naturite_rose",
            new FlowerBlock(StatusEffects.GLOWING, 8,
                    FabricBlockSettings.copy(Blocks.PINK_TULIP)), ModItemGroups.FABLED);
    public static final Block NATURITE_STONE_ORE = registerBlock("naturite_stone_ore",
            new OreBlock(FabricBlockSettings.of(Material.STONE).strength(1.5f).requiresTool(),
                    UniformIntProvider.create(3, 7)), ModItemGroups.FABLED);
    public static final Block NATURITE_DEEPSLATE_ORE = registerBlock("naturite_deepslate_ore",
            new OreBlock(FabricBlockSettings.of(Material.STONE).strength(1.5f).requiresTool().sounds(BlockSoundGroup.DEEPSLATE),
                    UniformIntProvider.create(3, 7)), ModItemGroups.FABLED);
    public static final Block NATURITE_DIRT_ORE = registerBlock("naturite_dirt_ore",
            new OreBlock(FabricBlockSettings.of(Material.SOIL).strength(1.5f).requiresTool().sounds(BlockSoundGroup.ROOTED_DIRT),
                    UniformIntProvider.create(3, 7)), ModItemGroups.FABLED);
    public static final Block NAURITE_BLOCK = registerBlock("naturite_block",
            new Block(FabricBlockSettings.of(Material.METAL).strength(4.0f).requiresTool().luminance(14)), ModItemGroups.FABLED);

    //DWARFIUM
    public static final Block DWARFIUM_STONE_ORE = registerBlock("dwarfium_stone_ore",
            new OreBlock(FabricBlockSettings.of(Material.STONE).strength(1.5f).requiresTool(),
                    UniformIntProvider.create(3, 7)), ModItemGroups.FABLED);
    public static final Block DWARFIUM_DEEPSLATE_ORE = registerBlock("dwarfium_deepslate_ore",
            new OreBlock(FabricBlockSettings.of(Material.STONE).strength(1.5f).requiresTool().sounds(BlockSoundGroup.DEEPSLATE),
                    UniformIntProvider.create(3, 7)), ModItemGroups.FABLED);
    public static final Block DWARFIUM_BEDROCK_ORE = registerBlock("dwarfium_bedrock_ore",
            new OreBlock(FabricBlockSettings.of(Material.STONE).strength(1.5f).requiresTool().sounds(BlockSoundGroup.LODESTONE),
                    UniformIntProvider.create(3, 7)), ModItemGroups.FABLED);
    public static final Block DWARFIUM_BLOCK = registerBlock("dwarfium_block",
            new Block(FabricBlockSettings.of(Material.METAL).strength(4.0f).requiresTool().luminance(14)), ModItemGroups.FABLED);

    //ELFIUM
    public static final Block ELFIUM_STONE_ORE = registerBlock("elfium_stone_ore",
            new OreBlock(FabricBlockSettings.of(Material.STONE).strength(1.5f).requiresTool(),
                    UniformIntProvider.create(3, 7)), ModItemGroups.FABLED);
    public static final Block ELFIUM_DEEPSLATE_ORE = registerBlock("elfium_deepslate_ore",
            new OreBlock(FabricBlockSettings.of(Material.STONE).strength(1.5f).requiresTool().sounds(BlockSoundGroup.DEEPSLATE),
                    UniformIntProvider.create(3, 7)), ModItemGroups.FABLED);
    public static final Block ELFIUM_ENDSTONE_ORE = registerBlock("elfium_endstone_ore",
            new OreBlock(FabricBlockSettings.of(Material.STONE).strength(1.5f).requiresTool(),
                    UniformIntProvider.create(3, 7)), ModItemGroups.FABLED);
    public static final Block ELFIUM_BLOCK = registerBlock("elfium_block",
            new Block(FabricBlockSettings.of(Material.METAL).strength(4.0f).requiresTool().luminance(14)), ModItemGroups.FABLED);

    //FAENITE
    public static final Block FAENITE_STONE_ORE = registerBlock("faenite_stone_ore",
            new FaeniteOre(FabricBlockSettings.of(Material.STONE).strength(1.5f).requiresTool()), ModItemGroups.FABLED);
    public static final Block FAENITE_DEEPSLATE_ORE = registerBlock("faenite_deepslate_ore",
            new FaeniteOre(FabricBlockSettings.of(Material.STONE).strength(1.5f).requiresTool().sounds(BlockSoundGroup.DEEPSLATE)), ModItemGroups.FABLED);
    public static final Block FAENITE_ENDSTONE_ORE = registerBlock("faenite_endstone_ore",
            new FaeniteOre(FabricBlockSettings.of(Material.STONE).strength(1.5f).requiresTool()), ModItemGroups.FABLED);
    public static final Block FAENITE_DIRT_ORE = registerBlock("faenite_dirt_ore",
            new FaeniteOre(FabricBlockSettings.of(Material.SOIL).strength(1.5f).requiresTool().sounds(BlockSoundGroup.ROOTED_DIRT)), ModItemGroups.FABLED);
    public static final Block FAENITE_BLOCK = registerBlock("faenite_block",
            new FaeniteOre(FabricBlockSettings.of(Material.METAL).strength(1.5f).requiresTool().sounds(BlockSoundGroup.AMETHYST_BLOCK)), ModItemGroups.FABLED);
    public static final Block FAENITE_SAPLING = registerBlock("faenite_sapling",
            new ModSaplingBlock(new FaeniteSaplingGenerator(),
                    FabricBlockSettings.copy(Blocks.OAK_SAPLING)), ModItemGroups.FABLED);

    //GINORMIUM
    public static final Block GINORMIUM_STONE_ORE = registerBlock("ginormium_stone_ore",
            new OreBlock(FabricBlockSettings.of(Material.STONE).strength(1.5f).requiresTool(),
                    UniformIntProvider.create(3, 7)), ModItemGroups.FABLED);
    public static final Block GINORMIUM_DEEPSLATE_ORE = registerBlock("ginormium_deepslate_ore",
            new OreBlock(FabricBlockSettings.of(Material.STONE).strength(1.5f).requiresTool().sounds(BlockSoundGroup.DEEPSLATE),
                    UniformIntProvider.create(3, 7)), ModItemGroups.FABLED);
    public static final Block GINORMIUM_NETHERRACK_ORE = registerBlock("ginormium_netherrack_ore",
            new OreBlock(FabricBlockSettings.of(Material.STONE).strength(1.5f).requiresTool().sounds(BlockSoundGroup.NETHERRACK),
                    UniformIntProvider.create(3, 7)), ModItemGroups.FABLED);
    public static final Block GINORMIUM_BLOCK = registerBlock("ginormium_block",
            new Block(FabricBlockSettings.of(Material.METAL).strength(4.0f).requiresTool().luminance(14)), ModItemGroups.FABLED);

    //HUMANITE
    public static final Block HUMANITE_STONE_ORE = registerBlock("humanite_stone_ore",
            new OreBlock(FabricBlockSettings.of(Material.STONE).strength(1.5f).requiresTool(),
                    UniformIntProvider.create(3, 7)), ModItemGroups.FABLED);
    public static final Block HUMANITE_DEEPSLATE_ORE = registerBlock("humanite_deepslate_ore",
            new OreBlock(FabricBlockSettings.of(Material.STONE).strength(1.5f).requiresTool().sounds(BlockSoundGroup.DEEPSLATE),
                    UniformIntProvider.create(3, 7)), ModItemGroups.FABLED);
    public static final Block HUMANITE_NETHERRACK_ORE = registerBlock("humanite_netherrack_ore",
            new OreBlock(FabricBlockSettings.of(Material.STONE).strength(1.5f).requiresTool().sounds(BlockSoundGroup.NETHERRACK),
                    UniformIntProvider.create(3, 7)), ModItemGroups.FABLED);
    public static final Block HUMANITE_BLOCK = registerBlock("humanite_block",
            new Block(FabricBlockSettings.of(Material.METAL).strength(4.0f).requiresTool().luminance(14)), ModItemGroups.FABLED);

    //SORCIUM
    public static final Block SORCIUM_STONE_ORE = registerBlock("sorcium_stone_ore",
            new OreBlock(FabricBlockSettings.of(Material.STONE).strength(1.5f).requiresTool(),
                    UniformIntProvider.create(3, 7)), ModItemGroups.FABLED);
    public static final Block SORCIUM_DEEPSLATE_ORE = registerBlock("sorcium_deepslate_ore",
            new OreBlock(FabricBlockSettings.of(Material.STONE).strength(1.5f).requiresTool().sounds(BlockSoundGroup.DEEPSLATE),
                    UniformIntProvider.create(3, 7)), ModItemGroups.FABLED);
    public static final Block SORCIUM_NETHERRACK_ORE = registerBlock("sorcium_netherrack_ore",
            new OreBlock(FabricBlockSettings.of(Material.STONE).strength(1.5f).requiresTool().sounds(BlockSoundGroup.NETHERRACK),
                    UniformIntProvider.create(3, 7)), ModItemGroups.FABLED);
    public static final Block SORCIUM_ENDSTONE_ORE = registerBlock("sorcium_endstone_ore",
            new OreBlock(FabricBlockSettings.of(Material.STONE).strength(1.5f).requiresTool(),
                    UniformIntProvider.create(3, 7)), ModItemGroups.FABLED);
    public static final Block SORCIUM_BLOCK = registerBlock("sorcium_block",
            new SorciumBlock(FabricBlockSettings.of(Material.METAL).strength(4.0f).requiresTool().luminance(14)), ModItemGroups.FABLED);
    public static final Block SORCIUM_TOME_BLOCK = registerBlock("sorcium_tome_block",
            new Block(FabricBlockSettings.of(Material.DECORATION).strength(4.0f).requiresTool().luminance(14)), ModItemGroups.FABLED);

    //DRAGONITE
    public static final Block DRAGONITE_STONE_ORE = registerBlock("dragonite_stone_ore",
            new OreBlock(FabricBlockSettings.of(Material.STONE).strength(1.5f).requiresTool(),
                    UniformIntProvider.create(3, 7)), ModItemGroups.FABLED);
    public static final Block DRAGONITE_DEEPSLATE_ORE = registerBlock("dragonite_deepslate_ore",
            new OreBlock(FabricBlockSettings.of(Material.STONE).strength(1.5f).requiresTool().sounds(BlockSoundGroup.DEEPSLATE),
                    UniformIntProvider.create(3, 7)), ModItemGroups.FABLED);
    public static final Block DRAGONITE_NETHERRACK_ORE = registerBlock("dragonite_netherrack_ore",
            new OreBlock(FabricBlockSettings.of(Material.STONE).strength(1.5f).requiresTool().sounds(BlockSoundGroup.NETHERRACK),
                    UniformIntProvider.create(3, 7)), ModItemGroups.FABLED);
    public static final Block DRAGONITE_ENDSTONE_ORE = registerBlock("dragonite_endstone_ore",
            new OreBlock(FabricBlockSettings.of(Material.STONE).strength(1.5f).requiresTool(),
                    UniformIntProvider.create(3, 7)), ModItemGroups.FABLED);
    public static final Block DRAGONITE_BEDROCK_ORE = registerBlock("dragonite_bedrock_ore",
            new OreBlock(FabricBlockSettings.of(Material.STONE).strength(5.0f).requiresTool().sounds(BlockSoundGroup.LODESTONE),
                    UniformIntProvider.create(3, 7)), ModItemGroups.FABLED);
    public static final Block DRAGONITE_BLOCK = registerBlock("dragonite_block",
            new Block(FabricBlockSettings.of(Material.METAL).strength(4.0f).requiresTool().luminance(14)), ModItemGroups.FABLED);

    //MACHINES
    public static final Block DWARFIUM_BLASTER = registerBlock("dwarfium_blaster",
            new DwarfiumBlasterBlock(FabricBlockSettings.of(Material.METAL).nonOpaque().strength(1f).requiresTool().luminance(5)), net.rytional.fabledadventure.item.ModItemGroups.FABLED);
    public static final Block SORCIUM_CRAFTER = registerBlock("sorcium_crafter",
            new SorciumCrafterBlock(FabricBlockSettings.of(Material.STONE).strength(4.0f).requiresTool().luminance(14)), ModItemGroups.FABLED);
    public static final Block GINORMIUM_TABLE = registerBlock("ginormium_table",
            new GinormiumTableBlock(FabricBlockSettings.of(Material.METAL).strength(4.0f).requiresTool().luminance(14)), ModItemGroups.FABLED);
    public static final Block DRAGONITE_INFUSER = registerBlock("dragonite_infuser",
            new DragoniteInfuserBlock(FabricBlockSettings.of(Material.METAL).strength(4.0f).requiresTool().luminance(14)), ModItemGroups.FABLED);
    public static final Block FAENITE_HOME = registerBlock("faenite_home",
            new FaeniteHomeBlock(FabricBlockSettings.of(Material.METAL).strength(4.0f).requiresTool().luminance(14)), ModItemGroups.FABLED);
    public static final Block NATURITE_STUMP = registerBlock("naturite_stump",
            new NaturiteStumpBlock(FabricBlockSettings.of(Material.WOOD).strength(4.0f).requiresTool().luminance(14)), ModItemGroups.FABLED);
    public static final Block ORCANITE_MECHANISM = registerBlockWithoutBlockItem("orcanite_mechanism",
            new OrcaniteMechanismBlock(FabricBlockSettings.of(Material.METAL).nonOpaque().strength(4.0f).requiresTool().luminance(14)), ModItemGroups.FABLED);
    public static final Block ULTIUM_IMBUING_STATION = registerBlockWithoutBlockItem("ultium_imbuing_station",
            new UltiumImbuingStationBlock(FabricBlockSettings.of(Material.METAL).nonOpaque().strength(4.0f).requiresTool().luminance(14)), ModItemGroups.FABLED);

    private static Block registerBlockWithoutBlockItem(String name, Block block, ItemGroup group) {
        return Registry.register(Registry.BLOCK, new Identifier(FabledAdventure.MOD_ID, name), block);
    }

    private static Block registerBlock(String name, Block block, ItemGroup group) {
        registerBlockItem(name, block, group);
        return Registry.register(Registry.BLOCK, new Identifier(FabledAdventure.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block, ItemGroup group) {
        return Registry.register(Registry.ITEM, new Identifier(FabledAdventure.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings().group(group)));
    }

    public static void registerModBlocks() {
        FabledAdventure.LOGGER.info("Registering ModBlocks for " + FabledAdventure.MOD_ID);
    }

}
