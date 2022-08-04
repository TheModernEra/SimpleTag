package modernera.SimpleTag;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import net.md_5.bungee.api.ChatColor;

public final class SimpleTag extends JavaPlugin {
	@Override
	public void onEnable() {
		getLogger().info("SimpleTag enabled!");
		getServer().getPluginManager().registerEvents(new MyListener(), this);
	}
	
	@Override
	public void onDisable() {
		getLogger().info("SimpleTag disabled!");
	}
	
	@Override
	public boolean onCommand(CommandSender command, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("tag")) {
			MyListener.tagOn = !MyListener.tagOn;
			List<Player> list = new ArrayList<Player>(Bukkit.getOnlinePlayers());
			Random random = new Random();
			MyListener.itPlayer = list.get(random.nextInt(list.size()));
			Bukkit.broadcastMessage(ChatColor.RED + "" + ChatColor.BOLD + MyListener.itPlayer.getName() + " is now it!");
			return true;
		}
		
		if (cmd.getName().equalsIgnoreCase("whosit")) {
			if (MyListener.tagOn == true) {
				Bukkit.broadcastMessage(ChatColor.RED + "" + ChatColor.BOLD + MyListener.itPlayer.getName() + " is it right now!");
				return true;
			}
		}
		return false;
	}
}
