package modernera.SimpleTag;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import net.md_5.bungee.api.ChatColor;

public class MyListener implements Listener {
	
	public static boolean tagOn = false;
	public static Player itPlayer = null;
	
	@EventHandler
	public void onEntityDamageByEntity(EntityDamageByEntityEvent event) {
		if (tagOn == true) {
			if (event.getDamager() instanceof Player && event.getEntity() instanceof Player) {
				if (event.getDamager().equals(itPlayer)) {
					itPlayer = (Player) event.getEntity();
					Bukkit.broadcastMessage(ChatColor.RED + "" + ChatColor.BOLD + itPlayer.getName() + " is now it!");
				}
			}
		}
	}
}
