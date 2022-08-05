package net.rytional.fabledadventure.util;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.village.TradeOffer;
import net.minecraft.village.VillagerProfession;
import net.rytional.fabledadventure.FabledAdventure;
import net.rytional.fabledadventure.block.ModBlocks;
import net.rytional.fabledadventure.entity.ModEntities;
import net.rytional.fabledadventure.entity.custom.OrcEntity;
import net.rytional.fabledadventure.entity.custom.RaccoonEntity;
import net.rytional.fabledadventure.entity.custom.SkyEntity;
import net.rytional.fabledadventure.item.ModItems;
import net.rytional.fabledadventure.villager.ModVillagers;

public class ModRegistries {
    public static void registerModStuffs() {

        registerAttributes();
        registerStrippables();
        registerFuels();
        registerCustomTrades();
    }


    private static void registerAttributes() {
        FabricDefaultAttributeRegistry.register(ModEntities.RACCOON, RaccoonEntity.setAttributes());
        FabricDefaultAttributeRegistry.register(ModEntities.SKY, SkyEntity.setAttributes());
        FabricDefaultAttributeRegistry.register(ModEntities.ORC, OrcEntity.setAttributes());
    }
    private static void registerStrippables() {
        StrippableBlockRegistry.register(ModBlocks.NATURITE_LOG, ModBlocks.STRIPPED_NATURITE_LOG);
        StrippableBlockRegistry.register(ModBlocks.NATURITE_WOOD, ModBlocks.STRIPPED_NATURITE_WOOD);
    }
    private static void registerFuels() {
        System.out.println("Registering Fuels for + " + FabledAdventure.MOD_ID);
        FuelRegistry registry = FuelRegistry.INSTANCE;
        // 400 / 20 = 20 Seconds
        registry.add(ModItems.SORCIUM_POWDER, 400);
    }
    private static void registerCustomTrades() {
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.FARMER, 5,
                factories -> {
                    factories.add((entity, random) -> new TradeOffer(
                            new ItemStack(Items.EMERALD_BLOCK, 9),
                            new ItemStack(ModItems.ORCANITE_GEM, 1),
                            6,2,0.02f));
                });

        TradeOfferHelper.registerVillagerOffers(VillagerProfession.TOOLSMITH, 4,
                factories -> {
                    factories.add((entity, random) -> new TradeOffer(
                            new ItemStack(Items.EMERALD_BLOCK, 64),
                            new ItemStack(ModItems.ORCANITE_PAXEL, 1),
                            12,3,0.08f));
                });
        TradeOfferHelper.registerVillagerOffers(ModVillagers.DWARFIUM_MASTER, 1,
                factories -> {
                    factories.add((entity, random) -> new TradeOffer(
                            new ItemStack(Items.EMERALD, 18),
                            new ItemStack(ModItems.FAENITE_DUST, 1),
                            12,2,0.08f));
                });

        TradeOfferHelper.registerVillagerOffers(ModVillagers.DWARFIUM_MASTER, 1,
                factories -> {
                    factories.add((entity, random) -> new TradeOffer(
                            new ItemStack(Items.EMERALD, 22),
                            new ItemStack(ModItems.RAW_ORCANITE, 1),
                            12,3,0.08f));
                });

        TradeOfferHelper.registerVillagerOffers(ModVillagers.DWARFIUM_MASTER, 2,
                factories -> {
                    factories.add((entity, random) -> new TradeOffer(
                            new ItemStack(Items.EMERALD, 32),
                            new ItemStack(ModItems.SORCIUM_INGOT, 1),
                            12,3,0.08f));
                });
    }
}
