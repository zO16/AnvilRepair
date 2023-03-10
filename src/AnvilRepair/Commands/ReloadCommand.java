package AnvilRepair.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import AnvilRepair.Main;

public class ReloadCommand implements CommandExecutor {
	
	private final Main main;
	public ReloadCommand(Main main) {
		this.main = main;
	}

	  public boolean onCommand(CommandSender sender, Command cmd, String command, String[] args) {
		  
		  if (command.equalsIgnoreCase("repair")) {
			  if (!(sender.hasPermission("anvilrepair.reload"))) {
				  sender.sendMessage(main.getConfig().getString("Messages.no-permission").replace("%prefix%", main.getConfig().getString("Messages.prefix")).replaceAll("&", "§"));
			  
			  }else {
				  if (args.length == 1) {
					  if (args[0].equals("reload")) {
						  main.saveDefaultConfig();
						  main.reloadConfig();
						  sender.sendMessage(main.getConfig().getString("Messages.config-reload").replace("%prefix%", main.getConfig().getString("Messages.prefix")).replaceAll("&", "§"));
					  }
				  }else {
					  sender.sendMessage(main.getConfig().getString("Messages.invaild-usage").replace("%prefix%", main.getConfig().getString("Messages.prefix")).replaceAll("&", "§"));
				  }
			  }
		  }
		  
		return true;
	  }
}
