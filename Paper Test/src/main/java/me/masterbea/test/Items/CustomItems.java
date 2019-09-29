package me.masterbea.test.Items;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class CustomItems {

    public static ItemStack getZeusSword(){
        ItemStack item = new ItemStack(Material.GOLDEN_SWORD, 1);
        ItemMeta meta = item.getItemMeta();

        meta.setDisplayName(ChatColor.YELLOW + "Zeus' Sword");
        meta.setLore(Arrays.asList(ChatColor.WHITE + "The hammer of the", "Almighty Zeus!"));
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        meta.setCustomModelData(1);

        item.setItemMeta(meta);
        return item;
    }

    public static ItemStack getPoseidenTrident(){
        ItemStack item = new ItemStack(Material.TRIDENT, 1);
        ItemMeta meta = item.getItemMeta();

        meta.setDisplayName(ChatColor.DARK_BLUE + "Poseiden's Trident");
        meta.setLore(Arrays.asList(ChatColor.BLUE + "The hammer of the", ChatColor.BLUE + "Almighty Zeus!"));
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        meta.setCustomModelData(2);


        item.setItemMeta(meta);
        return item;
    }

    public static ItemStack getWand(){
        ItemStack item = new ItemStack(Material.STICK, 1);
        ItemMeta meta = item.getItemMeta();

        meta.setDisplayName(ChatColor.BLUE + "Magic Wand");
        meta.setLore(Arrays.asList(ChatColor.WHITE + "A wand to help make building", ChatColor.WHITE + "quick and easy."));
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        meta.setCustomModelData('m' + 'w');

        item.setItemMeta(meta);
        return item;
    }



}
