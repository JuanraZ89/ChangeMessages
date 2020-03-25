package juanraz89.changemessages.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import juanraz89.changemessages.ChangeMessages;

public class KickReason implements CommandExecutor {

		private ChangeMessages plugin;

		public KickReason (ChangeMessages plugin) {
			
			this.plugin = plugin;
		}
	
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		
		if(!(sender instanceof Player)) {
		
			Bukkit.getConsoleSender().sendMessage(plugin.nombre+ChatColor.AQUA+" No puedes usar comandos desde la consola. ");
		
		return false;
	}

		else {

			Player jugador = (Player) sender;

			if(args.length == 0) {
				
				jugador.sendMessage(plugin.nombre+ChatColor.AQUA+" Utiliza el siguiente comando: \n "+ChatColor.BLUE+"/Kick <PlayerName> <Reason> ");
				return true;
			
			}






			else if (args.length == 1) {
				jugador.sendMessage(plugin.nombre+ChatColor.AQUA+" Utiliza el siguiente comando: \n "+ChatColor.BLUE+"/Kick <PlayerName> <Reason> ");
				return true;	
				
			}
				
			else if (args.length >= 2) {
			Player target = Bukkit.getPlayerExact(args[0]);	
			if(target == null) {
				
				jugador.sendMessage(plugin.nombre+ChatColor.AQUA+" El jugador en este momento no esta online. ");
				return true;
			}
				
			else {

			StringBuilder sb = new StringBuilder();
			
			for(int i = 1; i <args.length; i++) {
			sb.append(args[i]).append(" ");
			}
			
			 String allargs = sb.toString().trim();

				FileConfiguration file = plugin.getConfig();

				String pathmessage = "Config.kick-message";


			target.kickPlayer(ChatColor.translateAlternateColorCodes('&', file.getString(pathmessage))+ChatColor.AQUA+" You have been kicked by: "+ChatColor.BLUE+jugador.getName()+ChatColor.DARK_RED+ChatColor.BOLD+"\n Reason: "+ChatColor.AQUA+allargs);
			jugador.sendMessage(plugin.nombre+ChatColor.AQUA+" Has kickeado al jugador: "+ChatColor.BLUE+target.getName());
			
			
			}
				
				
				
				
				
			}
				
				
				
				
				
			}
			
			
			
			
			return true;
			
		}
	
	
	
}
