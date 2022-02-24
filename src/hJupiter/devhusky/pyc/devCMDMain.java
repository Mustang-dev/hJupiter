package hJupiter.devhusky.pyc;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import hJupiter.devhusky.pyc.Files.MessageFile;
import hJupiter.devhusky.pyc.Files.TranslaterFile;
import org.bukkit.Bukkit;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import Listener.EventClass;
import hJupiter.devhusky.pyc.utils.CC;
import hJupiter.devhusky.pyc.Files.ConfigFile;
import hJupiter.devhusky.pyc.commands.hJupiterGeneralCommand;

public class devCMDMain extends JavaPlugin{

	/*
	 *  Maked by Pyc Paint AlX_#7967
	 *  hJupiter.java ! devCMDMain
	 *  06-12-2021
	 */
	
	private static devCMDMain instance;
	public String lu = "07/12/2021";
	
	
	
	public void onEnable() {
		instance = this;
		
		// Loading ConfigFiles
		ConfigFile.getConfig();
		TranslaterFile.getConfig();
		MessageFile.getConfig();
		
		// Loading Commands
		Bukkit.getPluginCommand("hjupiter").setExecutor(new hJupiterGeneralCommand(this));
		
		// Loading Events
		Bukkit.getServer().getPluginManager().registerEvents( new EventClass(), this);


		// Send inicializating messages
			Bukkit.getConsoleSender().sendMessage(CC.translate("&7&m+---------------***---------------+"));
			Bukkit.getConsoleSender().sendMessage(CC.translate("&d&l         h&f&lJupiter"));
			Bukkit.getConsoleSender().sendMessage(CC.translate("&7"));
			Bukkit.getConsoleSender().sendMessage(CC.translate("  &5Version:&f "+this.getDescription().getVersion()));
			Bukkit.getConsoleSender().sendMessage(CC.translate("  &5Last Update:&f "+lu));
			Bukkit.getConsoleSender().sendMessage(CC.translate("  &5Authors:&f "+this.getDescription().getAuthors()).replace("[", "").replace("]", ""));
			Bukkit.getConsoleSender().sendMessage(CC.translate(""));
			Bukkit.getConsoleSender().sendMessage(CC.translate("&7&m+---------------***---------------+"));
			Bukkit.getConsoleSender().sendMessage(CC.translate("&7"));

	}
	
	public void onDisable() {
		// Send stoping messages
		Bukkit.getConsoleSender().sendMessage(CC.translate("&7[&b*&7] &dh&fJupiter sussesfuly stopped"));
		Bukkit.getConsoleSender().sendMessage(CC.translate("&7[&b*&7] &cCreated by &d"+this.getDescription().getAuthors()).replace("[", "").replace("]", ""));
		
	}
	
	public static devCMDMain getInstance() {
		return instance;
	}
}
