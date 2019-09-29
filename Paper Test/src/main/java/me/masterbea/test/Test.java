package me.masterbea.test;

import me.masterbea.test.Events.EventsClass;
import me.masterbea.test.Items.Recipes;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public final class Test extends JavaPlugin {

    private Commands commands = new Commands();

    @Override
    public void onEnable() {
        // Plugin startup logic
        getCommand(commands.cmd1).setExecutor(commands);
        getCommand(commands.cmd2).setExecutor(commands);
        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "\n\nHELLO IVE BEEN STARTED\n\n");

        getServer().getPluginManager().registerEvents(new EventsClass(), this);

        Recipes.addRecipes(this);
        loadConfig();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getServer().getConsoleSender().sendMessage(ChatColor.RED + "\n\nGOODBYE IVE BEEN ENDED\n\n");
    }

    private void loadConfig(){
        getConfig().options().copyDefaults(true);
        saveConfig();
    }

}
