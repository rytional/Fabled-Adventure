package net.rytional.rytionalsadventure.item;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.rytional.rytionalsadventure.RytionalsAdventure;

public class ModItemGroup {
    public static final ItemGroup RYTIONAL = FabricItemGroupBuilder.build(new Identifier(RytionalsAdventure.MOD_ID, "rytional"),
            () -> new ItemStack(ModItems.RYTIONAL_INGOT));
}
