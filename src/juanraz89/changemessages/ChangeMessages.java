package juanraz89.changemessages;


import java.io.File;

import juanraz89.changemessages.commands.BroadcastMessage;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import juanraz89.changemessages.commands.BanTimeReason;
import juanraz89.changemessages.commands.KickReason;
import juanraz89.changemessages.commands.Reload;
import juanraz89.changemessages.events.DeathEvent;
import juanraz89.changemessages.events.JoinEvent;
import juanraz89.changemessages.events.LeaveEvent;



public class ChangeMessages extends JavaPlugin {
	
 PluginDescriptionFile pdffile = getDescription();
 public String nombre = ChatColor.BLUE+"["+ChatColor.DARK_RED+"ChangeMessages"+ChatColor.BLUE+"]";
 public String version = pdffile.getVersion();
 public String rutaConfig;
 public void onEnable() {
	 
	 Bukkit.getConsoleSender().sendMessage(nombre+ChatColor.GREEN+" Activated "+ChatColor.DARK_RED+"Version: "+ChatColor.GREEN+version);
	 RegisterCommands();
	 RegisterEvents();
	 RegisterConfig();

	 
	 
 }
	
	public void onDisable() {



	 }
	
	public void RegisterCommands() {
		
		this.getCommand("ChangeMessages").setExecutor(new Reload(this));
		this.getCommand("kick").setExecutor(new KickReason(this));
		this.getCommand("Ban").setExecutor(new BanTimeReason(this));
		this.getCommand("Broadcast").setExecutor(new BroadcastMessage(this));
	}
	
	public void RegisterEvents() {
		
		PluginManager pm = getServer().getPluginManager();
		pm.registerEvents(new JoinEvent(this), this);
		pm.registerEvents(new DeathEvent(this), this);
		pm.registerEvents(new LeaveEvent(this), this);
	}
	
	public void RegisterConfig() {
		
		File config = new File(this.getDataFolder(),"config.yml");
		rutaConfig = config.getPath();
		if(!config.exists()) {
			this.getConfig().options().copyDefaults(true);
			saveConfig();
		}
		
		
		
		
		
	}

}
