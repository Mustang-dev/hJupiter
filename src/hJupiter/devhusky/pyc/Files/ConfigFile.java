package hJupiter.devhusky.pyc.Files;

import java.io.File;
import hJupiter.devhusky.pyc.devCMDMain;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

public class ConfigFile extends YamlConfiguration {

   private static ConfigFile config;
   private Plugin plugin;
   private File configFile;

   private Plugin main() {
      return devCMDMain.getInstance();
   }

   public void save() {
      try {
         super.save(this.configFile);
      } catch (Exception var2) {
      }

   }

   public void saveDefault() {
      this.plugin.saveResource("config.yml", false);
   }

   public ConfigFile() {
      this.plugin = this.main();
      this.configFile = new File(this.plugin.getDataFolder(), "config.yml");
      this.saveDefault();
      this.reload();
   }

   public void saveAll() {
      this.save();
      this.reload();
   }

   public static ConfigFile getConfig() {
      if (config == null) {
         config = new ConfigFile();
      }

      return config;
   }

   public void reload() {
      try {
         super.load(this.configFile);
      } catch (Exception var2) {
      }

   }
}
