package me.masterbea.test;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.configuration.Configuration;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

public class WorldHandler {
    public static void set(Player player, ItemStack item){
        Plugin plugin = Test.getPlugin(Test.class);
        Configuration config = plugin.getConfig();
        String ID = player.getUniqueId().toString();
        if(config.contains(player.getUniqueId() + ".wand.cord1")
        && config.contains(player.getUniqueId() + ".wand.cord2")){
            int x1, x2, y1, y2, z1, z2;
            x1 = config.getInt(ID + ".wand.cord1.x");
            x2 = config.getInt(ID + ".wand.cord2.x");
            y1 = config.getInt(ID + ".wand.cord1.y");
            y2 = config.getInt(ID + ".wand.cord2.y");
            z1 = config.getInt(ID + ".wand.cord1.z");
            z2 = config.getInt(ID + ".wand.cord2.z");

            for(int x = Math.min(x1, x2); x <= Math.max(x1, x2); x++){
                for(int y = Math.min(y1, y2); y <= Math.max(y1, y2); y++){
                    for(int z = Math.min(z1, z2); z <= Math.max(z1, z2); z++){
                        new Location(player.getWorld(), x, y, z).getBlock().setType(item.getType());
                    }
                }
            }
        }
        else{
            player.sendMessage(ChatColor.RED + "One or both of your coordinates are not set.");
        }
    }

    public static void solidCircle(Player player, ItemStack item, int radius){
        Location loc = player.getLocation();
        int xLoc = loc.getBlockX();
        int zLoc = loc.getBlockZ();
        for(int x  = xLoc - radius; x <= xLoc + radius; x++){
            for(int z = zLoc - radius; z <= zLoc + radius; z++){
                if((int)(Math.sqrt(Math.pow(x-xLoc, 2) + Math.pow(z-zLoc, 2)) + 0.5) <= radius){
                    new Location(player.getWorld(), x, loc.getBlockY(), z).getBlock().setType(item.getType());
                }
            }
        }
    }
    public static void hollowCircle(Player player, ItemStack item, int radius){
        Location loc = player.getLocation();
        int xLoc = loc.getBlockX();
        int zLoc = loc.getBlockZ();
        for(int x  = xLoc - radius; x <= xLoc + radius; x++){
            for(int z = zLoc - radius; z <= zLoc + radius; z++){
                if((int)(Math.sqrt(Math.pow(x-xLoc, 2) + Math.pow(z-zLoc, 2)) + 0.5) == radius){
                    new Location(player.getWorld(), x, loc.getBlockY(), z).getBlock().setType(item.getType());
                }
            }
        }
    }
}
