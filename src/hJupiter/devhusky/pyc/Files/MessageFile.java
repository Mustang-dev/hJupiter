package hJupiter.devhusky.pyc.Files;

import java.io.File;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

import hJupiter.devhusky.pyc.devCMDMain;

public class MessageFile extends YamlConfiguration {

	   private static MessageFile config;
	   private Plugin plugin;
	   private File MessageFile;
	   

	   public void reload() {
	      try {
	         super.load(this.MessageFile);
	      } catch (Exception var2) {
	      }

	   }

	   public void saveDefault() {
	      this.plugin.saveResource("messages.yml", false);
	   }

	   public static MessageFile getConfig() {
	      if (config == null) {
	         config = new MessageFile();
	      }

	      return config;
	   }

	   public void save() {
	      try {
	         super.save(this.MessageFile);
	      } catch (Exception var2) {
	      }

	   }

	   public MessageFile() {
	      this.plugin = this.main();
	      this.MessageFile = new File(this.plugin.getDataFolder(), "messages.yml");
	      this.saveDefault();
	      this.reload();
	   }

	   private Plugin main() {
	      return devCMDMain.getInstance();
	   }
	}
