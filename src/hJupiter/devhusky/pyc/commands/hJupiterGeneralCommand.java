package hJupiter.devhusky.pyc.commands;

import hJupiter.devhusky.pyc.Files.ConfigFile;
import hJupiter.devhusky.pyc.Files.MessageFile;
import hJupiter.devhusky.pyc.Files.TranslaterFile;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import hJupiter.devhusky.pyc.utils.CC;
import hJupiter.devhusky.pyc.devCMDMain;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.Material;

import java.security.MessageDigest;

public class hJupiterGeneralCommand implements CommandExecutor {
	private devCMDMain main;
	private devCMDMain plugin;

	public hJupiterGeneralCommand(devCMDMain plugin) {
		this.plugin = plugin;
	}

	private void reloadFiles() {
		ConfigFile.getConfig().reload();
		MessageFile.getConfig().reload();
		TranslaterFile.getConfig().reload();
	}

	@Override
	public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {

		// (DIFICULTY yep Strings CAN USE)

		//config.yml
		Player jugador = (Player) commandSender;
		FileConfiguration config = ConfigFile.getConfig();
		String npvp = "name-pvp-panel";
		String itm1 = "name-pvp-item-1";
		String itm2 = "name-pvp-item-2";

		//Translater.yml

		FileConfiguration translater = TranslaterFile.getConfig();
		String itmaccept = "toAccept-Go.Item-displayname-Accept";
		String itmdeny = "toDeny-Go.Item-displayname-Deny";

		//Use easy Strings

		// Sender Commands USE
		if (!(commandSender instanceof Player)) {
			commandSender.sendMessage(CC.translate("&cOnly players can execute this command..."));
		} else {
			if (args.length > 0) {
				if (args[0].equalsIgnoreCase("version") || args[0].equalsIgnoreCase("ver") || args[0].equalsIgnoreCase("authors") || args[0].equalsIgnoreCase("author")) {
					commandSender.sendMessage(CC.translate("&7&m-----------------------------"));
					commandSender.sendMessage(CC.translate("&d&l &nh&f&l&nJupiter"));
					commandSender.sendMessage(CC.translate(""));
					commandSender.sendMessage(CC.translate("&7[&b*&7] &dVersion: &r&f" + devCMDMain.getInstance().getDescription().getVersion()));
					commandSender.sendMessage(CC.translate("&7[&b*&7] &dAuthors: &r&f" + CC.convertString(devCMDMain.getInstance().getDescription().getAuthors()).replace("[", "").replace("]", "")));
					commandSender.sendMessage(CC.translate("&7[&b*&7] &dLast Update: &r&f" + devCMDMain.getInstance().lu));
					commandSender.sendMessage(CC.translate(""));
					commandSender.sendMessage(CC.translate("&7&m-----------------------------"));
				} else {
					if (args.length > 0) {
						if (args[0].equalsIgnoreCase("reload")) {
							Player j = (Player) commandSender;
							this.reloadFiles();
							j.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7[&d&l&nh&f&l&nJupiter&7] &bAll &6[&aConfig.yml, Messages.yml, Transalater.yml&6] &bwas been reloaded"));

						} else if (args[0].equalsIgnoreCase("help")) {
							if (commandSender.hasPermission("hjupiter.admin"))
								commandSender.sendMessage(CC.translate("&7&m-----------------------------"));
							commandSender.sendMessage(CC.translate("&d&l   &nh&f&l&nJupiter"));
							commandSender.sendMessage(CC.translate(""));
							commandSender.sendMessage(CC.translate("&7[&b*&7] &f/hjupiter setspawn"));
							commandSender.sendMessage(CC.translate("&7[&b*&7] &f/hjupiter help"));
							commandSender.sendMessage(CC.translate(""));
							commandSender.sendMessage(CC.translate("&7&m-----------------------------"));
						} else {
							commandSender.sendMessage(CC.translate("&7&m-----------------------------"));
							commandSender.sendMessage(CC.translate("&d&l   &nh&f&l&nJupiter"));
							commandSender.sendMessage(CC.translate(""));
							commandSender.sendMessage(CC.translate("&7[&b*&7] &f/hjupiter checkpl"));
							commandSender.sendMessage(CC.translate("&7[&b*&7] &f/hjupiter spigot"));
							commandSender.sendMessage(CC.translate("&7[&b*&7] &f/hjupiter discord"));
							commandSender.sendMessage(CC.translate("&7[&b*&7] &f/hjupiter help"));
							commandSender.sendMessage(CC.translate(""));
							commandSender.sendMessage(CC.translate("&7&m-----------------------------"));

							if (args[0].equalsIgnoreCase("checkpl")) {
								commandSender.sendMessage(CC.translate("&7&m-----------------------------"));
								commandSender.sendMessage(CC.translate("&d&l &nh&f&l&nJupiter"));
								commandSender.sendMessage(CC.translate(""));
								commandSender.sendMessage(CC.translate("&7[&b*&7] &dVersion: &r&f" + devCMDMain.getInstance().getDescription().getVersion()));
								commandSender.sendMessage(CC.translate("&7[&b*&7] &dAuthors: &r&f" + CC.convertString(devCMDMain.getInstance().getDescription().getAuthors()).replace("[", "").replace("]", "")));
								commandSender.sendMessage(CC.translate("&7[&b*&7] &dSpigot:"));
								commandSender.sendMessage(CC.translate(""));
								commandSender.sendMessage(CC.translate("&7&m-----------------------------"));

							} else if (args[0].equalsIgnoreCase("spigot")) {
								commandSender.sendMessage(CC.translate("&7&m-----------------------------"));
								commandSender.sendMessage(CC.translate("&d&l &nh&f&l&nJupiter"));
								commandSender.sendMessage(CC.translate(""));
								commandSender.sendMessage(CC.translate("&7[&b*&7] &6&lSpigot: &7"));
								commandSender.sendMessage(CC.translate(""));
								commandSender.sendMessage(CC.translate("&7&m-----------------------------"));

								// START WITH THE "PANELS"

							} else if (args[0].equalsIgnoreCase("setspawn")) {
								Player p = (Player) commandSender;
								if (p.hasPermission("hjupiter.setpvpspawn"));
								Inventory setpvpspawn = Bukkit.createInventory(null, 27, CC.translate(config.getString(npvp)));
								for (int i = 0; i < setpvpspawn.getSize(); i++) {
									setpvpspawn.setItem(i, new ItemStack(160,
											1,
											(short) 7));
								}
								// Itemstack COLISEOPVP
								ItemStack coliseo = new ItemStack(Material.DIAMOND_AXE, 1);
								ItemMeta coliseoItemMeta = coliseo.getItemMeta();
								coliseoItemMeta.setDisplayName(CC.translate(config.getString(itm1)));
								coliseo.setItemMeta(coliseoItemMeta);
								setpvpspawn.setItem(11, coliseo);

								// Other colocate ITEM PVPSPAWN NORMALLY

								ItemStack pvpnm = new ItemStack(Material.DIAMOND_SWORD, 1);
								ItemMeta pvpnmitemmeta = pvpnm.getItemMeta();
								pvpnmitemmeta.setDisplayName(CC.translate(config.getString(itm2)));
								pvpnm.setItemMeta(pvpnmitemmeta);
								setpvpspawn.setItem(15, pvpnm);
								p.openInventory(setpvpspawn);

								//FINISH TO BE THE ITEMSTACKS




								//          ACCEPT OR DENY PANEL

							} else if (args[0].equalsIgnoreCase("pvp")) {
								Player p = (Player) commandSender;
								if (p.hasPermission("hjupiter.go"));
								Inventory accepttp = Bukkit.createInventory(null, 27, CC.translate(translater.getString("Go-to-1.panel-name-1")));
								for (int i = 0; i < accepttp.getSize(); i++) {
									accepttp.setItem(i, new ItemStack(160,
											1,
											(short) 7));
								}

								//           ITEMSTACK ACCEPT TP

								ItemStack acceptpa = new ItemStack(Material.GREEN_RECORD, 1);
								ItemMeta acceptpameta = acceptpa.getItemMeta();
								acceptpameta.setDisplayName(CC.translate(translater.getString(itmaccept)));
								acceptpa.setItemMeta(acceptpameta);
								accepttp.setItem(11, acceptpa);

								//	    ITEMSTACK DENY TP

								ItemStack denytp = new ItemStack(Material.REDSTONE_BLOCK, 1);
								ItemMeta denytpmeta = denytp.getItemMeta();
								denytpmeta.setDisplayName(CC.translate(translater.getString(itmdeny)));
								denytp.setItemMeta(denytpmeta);
								accepttp.setItem(15, denytp);
								p.openInventory(accepttp);
							}
						}
					}
				}
			}
		}
		return false;
	}
}
