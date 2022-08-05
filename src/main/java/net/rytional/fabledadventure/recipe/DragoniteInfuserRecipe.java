package net.rytional.fabledadventure.recipe;

import com.google.gson.JsonObject;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.recipe.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.JsonHelper;
import net.minecraft.world.World;
import net.rytional.fabledadventure.block.entity.ModBlockEntities;

import java.util.stream.Stream;

public class DragoniteInfuserRecipe implements Recipe<Inventory> {
    final Ingredient base;
    final Ingredient addition;
    final ItemStack result;
    private final Identifier id;

    public DragoniteInfuserRecipe(Identifier id, Ingredient base, Ingredient addition, ItemStack result) {
        this.id = id;
        this.base = base;
        this.addition = addition;
        this.result = result;
    }

    @Override
    public boolean matches(Inventory inventory, World world) {
        return this.base.test(inventory.getStack(0)) && this.addition.test(inventory.getStack(1));
    }

    @Override
    public ItemStack craft(Inventory inventory) {
        ItemStack itemStack = this.result.copy();
        NbtCompound nbtCompound = inventory.getStack(0).getNbt();
        if (nbtCompound != null) {
            itemStack.setNbt(nbtCompound.copy());
        }
        return itemStack;
    }

    @Override
    public boolean fits(int width, int height) {
        return width * height >= 2;
    }

    @Override
    public ItemStack getOutput() {
        return this.result;
    }

    public boolean testAddition(ItemStack stack) {
        return this.addition.test(stack);
    }

    @Override
    public ItemStack createIcon() {
        return new ItemStack((ItemConvertible) ModBlockEntities.DRAGONITE_INFUSER);
    }

    @Override
    public Identifier getId() {
        return this.id;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return Serializer.INSTANCE;
    }

    @Override
    public RecipeType<?> getType() {
        return DragoniteInfuserRecipe.Type.INSTANCE;
    }

    @Override
    public boolean isEmpty() {
        return Stream.of(this.base, this.addition).anyMatch(ingredient -> ingredient.getMatchingStacks().length == 0);
    }

    public static class Type implements RecipeType<DragoniteInfuserRecipe> {
        private Type() { }
        public static final DragoniteInfuserRecipe.Type INSTANCE = new DragoniteInfuserRecipe.Type();
        public static final String ID = "dragonite_infuser";
    }

    public static class Serializer implements RecipeSerializer<DragoniteInfuserRecipe> {
        public static final DragoniteInfuserRecipe.Serializer INSTANCE = new DragoniteInfuserRecipe.Serializer();
        public static final String ID = "dragonite_infuser";
        // this is the name given in the json file


        @Override
        public DragoniteInfuserRecipe read(Identifier id, JsonObject json) {
            Ingredient ingredient = Ingredient.fromJson(JsonHelper.getObject(json, "base"));
            Ingredient ingredient2 = Ingredient.fromJson(JsonHelper.getObject(json, "addition"));
            ItemStack itemStack = ShapedRecipe.outputFromJson(JsonHelper.getObject(json, "result"));
            return new DragoniteInfuserRecipe(id, ingredient, ingredient2, itemStack);
        }

        @Override
        public DragoniteInfuserRecipe read(Identifier id, PacketByteBuf buf) {
            Ingredient ingredient = Ingredient.fromPacket(buf);
            Ingredient ingredient2 = Ingredient.fromPacket(buf);
            ItemStack itemStack = buf.readItemStack();
            return new DragoniteInfuserRecipe(id, ingredient, ingredient2, itemStack);
        }

        @Override
        public void write(PacketByteBuf buf, DragoniteInfuserRecipe recipe) {
            recipe.base.write(buf);
            recipe.addition.write(buf);
            buf.writeItemStack(recipe.result);
        }
    }
}