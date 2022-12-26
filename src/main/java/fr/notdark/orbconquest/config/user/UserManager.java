package fr.notdark.orbconquest.config.user;

import fr.notdark.orbconquest.Main;
import fr.notdark.orbconquest.config.FileManager;
import fr.notdark.orbconquest.enums.*;
import lombok.SneakyThrows;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class UserManager {

    private final Player player;

    private final Main main;

    private FileManager fileManager;

    public UserManager(Main main, Player player) {
        this.player = player;
        this.main = main;
        this.fileManager = new FileManager(main);
    }

    public UserManager(Main main) {
        this.main = main;
        this.player = null;
        this.fileManager = new FileManager(main);
    }
    public void setupFile() {
        fileManager.createFile("users");
    }

    public void clearFile() {
        fileManager.removeFile("users");
    }

    @SneakyThrows
    public void setupPlayer() {
        YamlConfiguration f = YamlConfiguration.loadConfiguration(fileManager.getFile("users"));
        assert player != null;

        f.set(player.getName() + ".team", null);
        f.set(player.getName() + ".classe", null);
        f.set(player.getName() + ".elements", new ArrayList<GameElements>());
        f.set(player.getName() + ".str", 0);
        f.set(player.getName() + ".res", 0);
        f.set(player.getName() + ".agi", 0);
        f.set(player.getName() + ".hp", 0);
        f.set(player.getName() + ".mp", 0);

        f.save(fileManager.getFile("users"));
    }

    public GameTeams getTeam() {
        YamlConfiguration f = YamlConfiguration.loadConfiguration(fileManager.getFile("users"));
        assert player != null;
        return GameTeams.valueOf(f.getString(player.getName() + ".team"));
    }

    @SneakyThrows
    public void setTeam(GameTeams team) {
        YamlConfiguration f = YamlConfiguration.loadConfiguration(fileManager.getFile("users"));
        assert player != null;
        f.set(player.getName() + ".team", team.toString());
        f.save(fileManager.getFile("users"));
    }

    public GameClasses getClasse() {
        YamlConfiguration f = YamlConfiguration.loadConfiguration(fileManager.getFile("users"));
        assert player != null;
        return GameClasses.valueOf(f.getString(player.getName() + ".classe"));
    }

    @SneakyThrows
    public void setClasse(GameClasses classe) {
        YamlConfiguration f = YamlConfiguration.loadConfiguration(fileManager.getFile("users"));
        assert player != null;
        f.set(player.getName() + ".classe", classe.toString());
        f.save(fileManager.getFile("users"));
    }

    public int getInt(String path) {
        YamlConfiguration f = YamlConfiguration.loadConfiguration(fileManager.getFile("users"));
        assert player != null;
        return f.getInt(player.getName() + "." + path);
    }

    @SneakyThrows
    public void setInt(String path, int value) {
        YamlConfiguration f = YamlConfiguration.loadConfiguration(fileManager.getFile("users"));
        assert player != null;
        f.set(player.getName() + "." + path, value);
        f.save(fileManager.getFile("users"));
    }

    public List<GameElements> getElements() {
        YamlConfiguration f = YamlConfiguration.loadConfiguration(fileManager.getFile("users"));
        assert player != null;
        List<GameElements> elements = new ArrayList<>();
        for (String s : f.getStringList(player.getName() + ".elements")) {
            elements.add(GameElements.valueOf(s));
        }
        return elements;
    }

    @SneakyThrows
    public void setElements(List<GameElements> elements) {
        YamlConfiguration f = YamlConfiguration.loadConfiguration(fileManager.getFile("users"));
        assert player != null;
        List<String> elementsString = new ArrayList<>();
        for (GameElements element : elements) {
            elementsString.add(element.toString());
        }
        f.set(player.getName() + ".elements", elementsString);
        f.save(fileManager.getFile("users"));
    }

}
