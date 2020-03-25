package juanraz89.changemessages.events;

import juanraz89.changemessages.ChangeMessages;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class LeaveEvent implements Listener {

    private ChangeMessages plugin;

    public LeaveEvent (ChangeMessages plugin){
        this.plugin = plugin;

    }
    @EventHandler
    public void LeaveMessage (PlayerQuitEvent event){
        Player jugador = event.getPlayer();
        FileConfiguration file = plugin.getConfig();
        String path = "Config.leave-message";
        if(file.getString(path).equals("true")){

        String pathtexto = "Config.leave-message-text";

        event.setQuitMessage(ChatColor.translateAlternateColorCodes('&', file.getString(pathtexto)).replaceAll("%Player%", jugador.getPlayer().getName() ));



        }










    }


}
