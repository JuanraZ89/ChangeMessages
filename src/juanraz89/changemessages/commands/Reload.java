
package juanraz89.changemessages.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import juanraz89.changemessages.ChangeMessages;

public class Reload implements CommandExecutor {

	private ChangeMessages plugin;

	public Reload(ChangeMessages plugin) {
		this.plugin = plugin;
	}


	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {


		if (!(sender instanceof Player)) {

			Bukkit.getConsoleSender().sendMessage(plugin.nombre + ChatColor.AQUA + " No se pueden ejecutar comandos desde la consola. ");

			return false;
		} else {

			Player jugador = (Player) sender;
			if (args.length == 0) {

				jugador.sendMessage(plugin.nombre + ChatColor.BLUE + " /Help ChangeMessages "+ChatColor.AQUA+ "para ver los comandos de el plugin. ");
				return true;

			}
				else if (args[0].contentEquals("reload")) {
					plugin.reloadConfig();
					jugador.sendMessage(plugin.nombre + ChatColor.AQUA + " La configuración se ha recargado correctamente. ");
					return true;
				} else if (args[0].contentEquals("developer")) {
					jugador.sendMessage(plugin.nombre + ChatColor.BLUE + " JuanraZ89" + ChatColor.AQUA + " ha creado este plugin. ");

					return true;

				}

				else{

					jugador.sendMessage(plugin.nombre+ChatColor.AQUA+" El comando que has introducido no existe. ");

			}



				}


		return false;
	}


	}


