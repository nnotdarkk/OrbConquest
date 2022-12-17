package fr.notdark.orbconquest.config;

import fr.notdark.orbconquest.Main;
import fr.notdark.orbconquest.enums.GameCreationMode;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.IOException;

public class ConfigManager {

    private final Main main;

    private FileManager fileManager;

    public ConfigManager(Main main) {
        this.main = main;
        fileManager = new FileManager(main);
    }

    public void setupFile() {
        fileManager.createFile("config");

        YamlConfiguration f = YamlConfiguration.loadConfiguration(fileManager.getFile("config"));

        f.set("temps-partie", 5);
        f.set("temps-prep", 5);
        f.set("temps-calcul-point", 5);
        f.set("temps-restitution-orbe", 5);
        f.set("temps-info-chat", 5);
        f.set("points-notre-orbe", 2);
        f.set("points-orbe-adverse", 3);
        f.set("rayon-de-spawn", 250);
        f.set("players-per-team", 5);
        f.set("players-points-start", 10);
        f.set("cycle-jour-nuit", 5);
        f.set("creation-mode", GameCreationMode.Choosen.toString());
        f.set("host", null);

        try {
            f.save(fileManager.getFile("config"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void clearFile() {
        fileManager.removeFile("config");
    }

    public int getInt(String path) {
        YamlConfiguration f = YamlConfiguration.loadConfiguration(fileManager.getFile("config"));
        return f.getInt(path);
    }

    public String getString(String path) {
        YamlConfiguration f = YamlConfiguration.loadConfiguration(fileManager.getFile("config"));
        return f.getString(path);
    }

    public void setInt(String path, int value) {
        YamlConfiguration f = YamlConfiguration.loadConfiguration(fileManager.getFile("config"));
        f.set(path, value);
        try {
            f.save(fileManager.getFile("config"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void setString(String path, String value) {
        YamlConfiguration f = YamlConfiguration.loadConfiguration(fileManager.getFile("config"));
        f.set(path, value);
        try {
            f.save(fileManager.getFile("config"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
