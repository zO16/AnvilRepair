package AnvilRepair;

import org.bukkit.plugin.java.JavaPlugin;

import AnvilRepair.Commands.ReloadCommand;
import AnvilRepair.Listeners.PlayerInteract;

public class Main extends JavaPlugin {

	public void onEnable() {

		getServer().getConsoleSender().sendMessage("§8[§bVenixRepair§8]§a has been enabled! by [VenixCoding - Devo] discord.gg/Kak7pWH8mg");
		getServer().getPluginManager().registerEvents(new PlayerInteract(this), this);
		getCommand("repair").setExecutor(new ReloadCommand(this));
		saveDefaultConfig();
		
	}
	
	public void onDisable() {
		getServer().getConsoleSender().sendMessage("§8[§bVenixRepair§8]§4 has been disabled! by [VenixCoding - Devo] discord.gg/Kak7pWH8mg");
		
	}
}
