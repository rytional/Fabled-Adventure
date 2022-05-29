package net.rytional.fabledadventure.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.rytional.fabledadventure.FabledAdventure;
import net.rytional.fabledadventure.block.custom.*;
import net.rytional.fabledadventure.world.feature.tree.NaturiteSaplingGenerator;
import net.rytional.fabledadventure.item.ModItemGroups;


public class ModBlocks {

    public static final Block ULTIUM_BLOCK = registerBlock("ultium_block",
            new Block(FabricBlockSettings.of(Material.METAL).strength(4.0f).requiresTool().luminance(14)), net.rytional.fabledadventure.item.ModItemGroups.FABLED);
    public static final Block SPEEDY_BLOCK = registerBlock("speedy_block",
            new SpeedyBlock(FabricBlockSettings.of(Material.METAL).strength(4.0f).luminance(14)), net.rytional.fabledadventure.item.ModItemGroups.FABLED);
    public static final Block ULTIUM_ORE = registerBlock("ultium_ore",
            new Block(FabricBlockSettings.of(Material.STONE).strength(1.5f).requiresTool()), net.rytional.fabledadventure.item.ModItemGroups.FABLED);
    public static final Block ORCANITE_ORE_BLOCK = registerBlock("orcanite_ore_block",
            new OrcanitePoisonOre(FabricBlockSettings.of(Material.STONE).strength(1.5f).requiresTool()), net.rytional.fabledadventure.item.ModItemGroups.FABLED);
    public static final Block ORCANITE_DEEPSLATE_ORE_BLOCK = registerBlock("orcanite_deepslate_ore_block",
            new OrcanitePoisonOre(FabricBlockSettings.of(Material.STONE).strength(1.5f).requiresTool()), net.rytional.fabledadventure.item.ModItemGroups.FABLED);
    public static final Block ORCANITE_BLOCK = registerBlock("orcanite_block",
            new Block(FabricBlockSettings.of(Material.METAL).strength(4.0f).requiresTool().luminance(14)), net.rytional.fabledadventure.item.ModItemGroups.FABLED);
    public static final Block FABLED_BLASTER = registerBlock("fabled_blaster",
            new FabledBlasterBlock(FabricBlockSettings.of(Material.METAL).nonOpaque().strength(1f).requiresTool().luminance(5)), net.rytional.fabledadventure.item.ModItemGroups.FABLED);

    public static final Block NATURITE_LOG = registerBlock("naturite_log",
            new PillarBlock(FabricBlockSettings.copy(Blocks.STRIPPED_OAK_LOG)), ModItemGroups.FABLED);
    public static final Block NATURITE_LEAVES = registerBlock("naturite_leaves",
            new LeavesBlock(FabricBlockSettings.copy(Blocks.OAK_LEAVES)), ModItemGroups.FABLED);
    public static final Block NATURITE_SAPLING = registerBlock("naturite_sapling",
            new ModSaplingBlock(new NaturiteSaplingGenerator(),
                    FabricBlockSettings.copy(Blocks.OAK_SAPLING)), ModItemGroups.FABLED);
    public static final Block NATURITE_ROSE = registerBlock("naturite_rose",
            new FlowerBlock(StatusEffects.GLOWING, 8,
                    FabricBlockSettings.copy(Blocks.PINK_TULIP)), ModItemGroups.FABLED);

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
