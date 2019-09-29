package me.masterbea.test.UI;

import me.masterbea.test.WorldHandler;
import me.masterbea.test.indexSheet;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class AchievementTest implements InventoryHolder, Listener {
    // Create a new inventory, with "this" owner for comparison with other inventories, a size of nine, called example
    private final Inventory inv;

    public AchievementTest() {
        inv = Bukkit.createInventory(this, 54, "Achievements");
    }


    public Inventory getInventory() {
        return inv;
    }

    // You can call this whenever you want to put the items in
    public void initializeItems() {


    }

    // Nice little method to create a gui item with a custom name, and description
    private ItemStack createGuiItem(Material material, String name, String...lore) {
        ItemStack item = new ItemStack(material, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(name);
        ArrayList<String> metalore = new ArrayList<String>();

        for(String lorecomments : lore) {

            metalore.add(lorecomments);

        }

        meta.setLore(metalore);
        item.setItemMeta(meta);
        return item;
    }

    // You can open the inventory with this
    public void openInventory(Player p) {
        initializeItems();
        p.openInventory(inv);
    }

    // Check for clicks on items
    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        if (inv.getHolder() != this || !event.getClickedInventory().equals(inv)) {
            return;
        }

        event.setCancelled(true);
        Player p = (Player) event.getWhoClicked();
        ItemStack clickedItem = event.getCurrentItem();
        int slot = event.getRawSlot();


        // verify current item is not null
        // if (clickedItem == null || clickedItem.getType() == Material.AIR) return;

        // Using slots click is a best option for your inventory click's
        if (event.getRawSlot() == 10) p.sendMessage("You clicked at slot " + 10);
    }
}
