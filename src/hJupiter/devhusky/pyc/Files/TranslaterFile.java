package hJupiter.devhusky.pyc.Files;

import java.io.File;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

import hJupiter.devhusky.pyc.devCMDMain;

import javax.xml.transform.Transformer;

public class TranslaterFile extends YamlConfiguration {

    private static TranslaterFile translater;
    private Plugin plugin;
    private File Translater;

    private Plugin main() {
        return devCMDMain.getInstance();
    }

    public void save() {
        try {
            super.save(this.Translater);
        } catch (Exception var2) {
        }

    }

    public void saveDefault() {
        this.plugin.saveResource("translater.yml", false);
    }

    public TranslaterFile() {
        this.plugin = this.main();
        this.Translater = new File(this.plugin.getDataFolder(), "translater.yml");
        this.saveDefault();
        this.reload();
    }

    public void saveAll() {
        this.save();
        this.reload();
    }

    public static TranslaterFile getConfig() {
        if (translater == null) {
            translater = new TranslaterFile();
        }

        return translater;
    }

    public void reload() {
        try {
            super.load(this.Translater);
        } catch (Exception var2) {
        }

    }
}
