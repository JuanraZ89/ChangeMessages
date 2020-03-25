package juanraz89.changemessages.events;

import juanraz89.changemessages.ChangeMessages;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinEvent implements Listener {

    private ChangeMessages plugin;

    public JoinEvent(ChangeMessages plugin) {
        this.plugin = plugin;
    }


    @EventHandler
    public void JoinMessage(PlayerJoinEvent event) {
        


        FileConfiguration config = plugin.getConfig();
        String path = "Config.join-message";
        if (config.getString(path).equals("true")) {
            String pathmessage = "Config.join-message-text";
            event.setJoinMessage(ChatColor.translateAlternateColorCodes('&', config.getString(pathmessage)).replaceAll("%Player%", event.getPlayer().getName()));

        }
    }


}
	
	
	
	
	
	

