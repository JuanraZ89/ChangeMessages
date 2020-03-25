package juanraz89.changemessages.commands;

		import org.bukkit.Bukkit;
		import org.bukkit.ChatColor;
		import org.bukkit.command.Command;
		import org.bukkit.command.CommandExecutor;
		import org.bukkit.command.CommandSender;
		import org.bukkit.configuration.file.FileConfiguration;
		import org.bukkit.entity.Player;

		import juanraz89.changemessages.ChangeMessages;

		import java.io.FileDescriptor;

public class BanTimeReason implements CommandExecutor{

	private ChangeMessages plugin;
	public BanTimeReason (ChangeMessages plugin) {
		this.plugin = plugin;
	}


	@SuppressWarnings("deprecation")
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

		if(!(sender instanceof Player)) {

			Bukkit.getConsoleSender().sendMessage("");


			return false;

		}

		else {

			Player jugador = (Player) sender;

			if(args.length == 0) {

				jugador.sendMessage(plugin.nombre+ChatColor.AQUA+" Utiliza el siguiente comando: \n "+ChatColor.BLUE+"/Ban <PlayerName> <Reason> ");


				return true;
			}

			else if(args.length == 1 ) {

				jugador.sendMessage(plugin.nombre+ChatColor.AQUA+" Utiliza el siguiente comando: \n "+ChatColor.BLUE+"/Ban <PlayerName> <Reason> ");
				return true;
			}

			else if(args.length >= 2) {
				Player targetban = Bukkit.getPlayerExact(args[0]);

				if(targetban == null) {

					jugador.sendMessage(plugin.nombre+ChatColor.AQUA+ " El jugador en este momento no esta online. ");
					return true;
				}

				else {

					StringBuilder sb = new StringBuilder();

					for (int i = 1; i < args.length; i++) {
						sb.append(args[i]).append(" ");
					}

					String allargs = sb.toString().trim();

					FileConfiguration file = plugin.getConfig();
					String pathban = "Config.ban-message";
					String ts3ban = "Config.ts3-ip";
					String pathunban = "Config.appeal-ban-site";
					targetban.kickPlayer(ChatColor.translateAlternateColorCodes('&', file.getString(pathban))+ChatColor.AQUA+" You have been banned by: "+ChatColor.BLUE+jugador.getName()+ChatColor.DARK_RED+ChatColor.BOLD+"\n Reason: "+ChatColor.AQUA+allargs+ChatColor.GREEN+ChatColor.BOLD+"\n TS3/Discord : "+ChatColor.translateAlternateColorCodes('&', file.getString(ts3ban))+ChatColor.BOLD+ChatColor.AQUA+"\n Appeal the ban here: "+ChatColor.translateAlternateColorCodes('&', file.getString(pathunban)));
					jugador.sendMessage(plugin.nombre+ChatColor.AQUA+" Has baneado al jugador: "+ChatColor.BLUE+targetban.getName());


					return true;
				}



			}



		}
		return false;


	}




}
