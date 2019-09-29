package me.masterbea.test.Events;

import me.masterbea.test.Items.CustomItems;
import me.masterbea.test.Test;
import me.masterbea.test.UI.MagicWandUI;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

public class EventsClass implements Listener {

    private Plugin plugin;

    public EventsClass(){
        plugin = Test.getPlugin(Test.class);
    }

    @EventHandler
    public void onBreak(BlockBreakEvent event){
        ItemStack hand = event.getPlayer().getInventory().getItemInMainHand();
        if(hand != null && hand.hasItemMeta() && hand.getItemMeta().hasCustomModelData()
        && hand.getItemMeta().getCustomModelData() == 'm' + 'w')
            event.setCancelled(true);
    }

    @EventHandler
    public void onMagicClick(PlayerInteractEvent event){
        ItemStack item = event.getItem();
        Block clickedItem = event.getClickedBlock();
        Player player = event.getPlayer();
        if(item != null && item.hasItemMeta() && item.getItemMeta().hasCustomModelData()
        && item.getItemMeta().getCustomModelData() == ('m' + 'w')){
            if(clickedItem != null){
                Location loc = clickedItem.getLocation();
                if(event.getAction().equals(Action.LEFT_CLICK_BLOCK)){
                    plugin.getConfig().set(player.getUniqueId() + ".wand.cord1.x", loc.getBlockX());
                    plugin.getConfig().set(player.getUniqueId() + ".wand.cord1.y", loc.getBlockY());
                    plugin.getConfig().set(player.getUniqueId() + ".wand.cord1.z", loc.getBlockZ());
                    player.sendMessage(ChatColor.LIGHT_PURPLE + "Pos 1: set at X: " + loc.getBlockX() +
                            ", Y: " + loc.getBlockY() + ", Z: " + loc.getBlockZ());
                }
                else{
                    plugin.getConfig().set(player.getUniqueId() + ".wand.cord2.x", loc.getBlockX());
                    plugin.getConfig().set(player.getUniqueId() + ".wand.cord2.y", loc.getBlockY());
                    plugin.getConfig().set(player.getUniqueId() + ".wand.cord2.z", loc.getBlockZ());
                    player.sendMessage(ChatColor.LIGHT_PURPLE + "Pos 2: set at X: " + loc.getBlockX() +
                            ", Y: " + loc.getBlockY() + ", Z: " + loc.getBlockZ());
                }
                plugin.saveConfig();
            }
            else if(event.getAction().equals(Action.RIGHT_CLICK_AIR)){
                MagicWandUI UI = new MagicWandUI();
                plugin.getServer().getPluginManager().registerEvents(UI, plugin);
                UI.openInventory(player);
            }
        }
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event){
        event.getPlayer().getInventory().addItem(CustomItems.getZeusSword());
        event.getPlayer().getInventory().addItem(CustomItems.getPoseidenTrident());
    }
//
//    @EventHandler
//    public void printCustomID(PlayerInteractEvent event){
//        ItemStack item = event.getItem();
//        Player player = event.getPlayer();
//        if(item != null && item.hasItemMeta() && item.getItemMeta().hasCustomModelData()) {
//            player.sendMessage("Item ID:" + ChatColor.RED + item.getItemMeta().getCustomModelData());
//        }
//    }

//    @EventHandler
//    public void onPlace(PlayerDropItemEvent event){
//        System.out.println("oops, " + event.getPlayer().getDisplayName() + " dropped a " + event.getItemDrop().getName());
//    }

//    @EventHandler
//    public void onInteract(PlayerInteractEvent event){
//        Location loc = new Location(plugin.getServer().getWorld("world"),161, 70, -110);
//        if(event.getHand().equals(EquipmentSlot.OFF_HAND)){
//            if(event.getClickedBlock().getType().equals(Material.EMERALD_BLOCK)){
//                if(event.getClickedBlock().getLocation().equals(loc)){
//                    event.getPlayer().sendMessage(ChatColor.GREEN + "You have been healed :)");
//                    event.getPlayer().setHealth(20);
//                }
//                else{
//                    event.getPlayer().sendMessage(ChatColor.RED + "This is not a healing block :(");
//                }
//            }
//        }
//    }
}
