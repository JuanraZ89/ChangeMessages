package juanraz89.changemessages.commands;

import juanraz89.changemessages.ChangeMessages;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public class BroadcastMessage implements CommandExecutor {

    private ChangeMessages plugin;

    public BroadcastMessage(ChangeMessages plugin) {
        this.plugin = plugin;
    }
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {



        if (!(sender instanceof Player)) {

            Bukkit.getConsoleSender().sendMessage(plugin.nombre + ChatColor.AQUA + " No puedes usar comandos desde la consola. ");
            return false;
        }

        else {
            Player jugador = (Player) sender;
            if (args.length == 0) {
                jugador.sendMessage(plugin.nombre+ChatColor.AQUA+" Utiliza el siguiente comando: \n "+ChatColor.BLUE+"/Broadcast <Message> ");
                return true;
            }

            else if (args.length >= 1){

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < args.length; i++){
                sb.append(args[i]).append(" ");
                }
                java.lang.String allargs = sb.toString().trim();

                FileConfiguration file = plugin.getConfig();
                String pathtexto = "Config.broadcast-message";
                String pathcolor = "Config.broadcast-message-color";
                Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', file.getString(pathtexto)+ " " +ChatColor.translateAlternateColorCodes('&', file.getString(pathcolor)+allargs)));
                return true;
            }

        }
        return true;
    }


}