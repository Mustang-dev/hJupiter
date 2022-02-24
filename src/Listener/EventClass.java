package Listener;

import hJupiter.devhusky.pyc.Files.ConfigFile;
import hJupiter.devhusky.pyc.Files.TranslaterFile;
import hJupiter.devhusky.pyc.devCMDMain;
import hJupiter.devhusky.pyc.utils.CC;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class EventClass implements Listener {

    private devCMDMain plugin = devCMDMain.getInstance();

    @EventHandler
    public void onSettingClick(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();
        if (event.getClickedInventory() != null && event.getInventory() == event.getClickedInventory()) {
            if (event.getInventory().getTitle().equals(CC.translate(ConfigFile.getConfig().getString("name-pvp-panel")))) {
                event.setCancelled(true);
                ItemStack stack = event.getCurrentItem();
                if (stack == null || stack.getType().equals(Material.AIR) || stack.getType().equals(Material.STAINED_GLASS_PANE)) {
                    return;
                }
            }
        }
                    if (event.getClickedInventory() != null && event.getInventory() == event.getClickedInventory()) {
                        if (event.getInventory().getTitle().equals(ChatColor.translateAlternateColorCodes('&', "&7&lChoose You want"))){
                            event.setCancelled(true);
                            ItemStack stack1 = event.getCurrentItem();
                            if (stack1 == null || stack1.getType().equals(Material.AIR) || stack1.getType().equals(Material.STAINED_GLASS_PANE)) {
                                return;
                            } else {
                                if (event.getCurrentItem().hasItemMeta()) {
                                    event.setCancelled(true);
                                    if (event.getSlot() == 11) {
                                        player.sendMessage(CC.translate(TranslaterFile.getConfig().getString("toAccept-Go.Accept-Message")));
                                        player.closeInventory();
                                    }else {
                                        if (event.getSlot() == 15) {
                                            player.sendMessage(CC.translate(TranslaterFile.getConfig().getString("toDeny-Go.Deny-Message")));
                                            player.closeInventory();
                                            return;
                                        }
                                    }
                            }
                        }
                    }
                }
            }
        }