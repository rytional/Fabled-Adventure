package net.rytional.fabledadventure.item;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.rytional.fabledadventure.FabledAdventure;

public class ModItemGroups {
    public static final ItemGroup ULTIUM = FabricItemGroupBuilder.build(new Identifier(FabledAdventure.MOD_ID, "ultium"),
            () -> new ItemStack(ModItems.ULTIUM_INGOT));
}
