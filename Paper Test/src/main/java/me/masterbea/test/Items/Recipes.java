package me.masterbea.test.Items;

import org.bukkit.Material;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.ShapelessRecipe;
import org.bukkit.plugin.Plugin;

public class Recipes {

    public static void addRecipes(Plugin plugin){
        addZeusSword(plugin);
        addPoseidenTrident(plugin);
    }

    private static void addZeusSword(Plugin plugin){
        ShapedRecipe recipe = new ShapedRecipe(CustomItems.getZeusSword());

        recipe.shape(" G ", "GRG", " S ");
        recipe.setIngredient('G', Material.GOLD_INGOT);
        recipe.setIngredient('R', Material.REDSTONE_BLOCK);
        recipe.setIngredient('S', Material.STICK);

        plugin.getServer().addRecipe(recipe);
    }

    private static void addPoseidenTrident(Plugin plugin){
        ShapelessRecipe recipe = new ShapelessRecipe(CustomItems.getPoseidenTrident());

        recipe.addIngredient(Material.TRIDENT);
        recipe.addIngredient(3, Material.DIAMOND);

        plugin.getServer().addRecipe(recipe);
    }

}
