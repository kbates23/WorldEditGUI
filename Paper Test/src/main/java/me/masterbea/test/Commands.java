package me.masterbea.test;

import me.masterbea.test.Items.CustomItems;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Commands implements CommandExecutor {

    public String cmd1 = "hi";
    public String cmd2 = "wand";

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player){
            if(command.getName().equalsIgnoreCase(cmd1)){
                ((Player) sender).sendMessage(ChatColor.RED + "Nice to meet you");
            }
            else if(command.getName().equalsIgnoreCase(cmd2)){
                ((Player)sender).getInventory().addItem(CustomItems.getWand());
            }
        }

        return false;
    }
}
