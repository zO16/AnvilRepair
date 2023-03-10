package AnvilRepair.Listeners;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import AnvilRepair.Main;

public class PlayerInteract implements Listener {
	
	private final Main main;
	public PlayerInteract(Main main) {
		this.main = main;
	}
	

	@SuppressWarnings("deprecation")
	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		if (e.getAction() == Action.RIGHT_CLICK_BLOCK) {
			if (e.getClickedBlock().getType() == Material.ANVIL) {
				e.setCancelled(true);

				if (!p.hasPermission("anvilrepair.use")) {
					p.sendMessage(main.getConfig().getString("Messages.no-permission").replace("%prefix%", main.getConfig().getString("Messages.prefix")).replaceAll("&", "§"));
					
				}else {
					if (p.getInventory().contains(Material.valueOf(main.getConfig().getString("Currency")), main.getConfig().getInt("Price"))) {
						if (main.getConfig().getIntegerList("Repairable").contains(p.getItemInHand().getTypeId())) {
							if (p.getItemInHand().getDurability() > (short)0) {
									
								p.getInventory().removeItem(new ItemStack(Material.valueOf(main.getConfig().getString("Currency")), main.getConfig().getInt("Price")));
								p.getInventory().getItemInHand().setDurability((short)0);
								p.playSound(e.getClickedBlock().getLocation(), Sound.ANVIL_USE, 0.9F, 0.8F);
								
						
						}else {
							p.sendMessage(main.getConfig().getString("Messages.repaired").replace("%prefix%", main.getConfig().getString("Messages.prefix")).replaceAll("&", "§"));
						}

						}else { 
							p.sendMessage(main.getConfig().getString("Messages.no-repair").replace("%prefix%", main.getConfig().getString("Messages.prefix")).replaceAll("&", "§"));
						}

						}else {
							p.sendMessage(main.getConfig().getString("Messages.no-enough").replace("%currency%", main.getConfig().getString("Currency")).replace("%prefix%", main.getConfig().getString("Messages.prefix")).replaceAll("&", "§"));
						}
				}
			}
			
		}
	}
}
