package juanraz89.changemessages.events;

import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;


import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

import juanraz89.changemessages.ChangeMessages;

public class DeathEvent implements Listener {
	
	private ChangeMessages plugin;
	
	public DeathEvent (ChangeMessages plugin) {
		this.plugin = plugin;
	}
	
	@EventHandler
	
	public void DeathMessage(PlayerDeathEvent event) {
	event.setDeathMessage(null);
	Player jugador = event.getEntity();
	String targetkiller = jugador.getKiller().getName();
	String targetdeath = jugador.getName();
	FileConfiguration config = plugin.getConfig();
	String path = "Config.death-message";
	if(config.getString(path).equals("true")) {
	String pathtext = "Config.death-message-text";
		event.setDeathMessage(ChatColor.translateAlternateColorCodes('&', config.getString(pathtext).replaceAll("%targetdeath%", targetdeath).replaceAll("%targetkiller%", targetkiller)));
		
	}
	
	
	
	
	
	
		
	}
	

}
