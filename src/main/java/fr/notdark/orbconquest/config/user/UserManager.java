package fr.notdark.orbconquest.config.user;

import fr.notdark.orbconquest.Main;
import fr.notdark.orbconquest.config.FileManager;
import fr.notdark.orbconquest.enums.GameClasses;
import fr.notdark.orbconquest.enums.GameElements;
import fr.notdark.orbconquest.enums.GameTeams;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

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

    public void setupPlayer() {
        YamlConfiguration f = YamlConfiguration.loadConfiguration(fileManager.getFile("users"));

        f.set(player.getName() + ".team", null);
        f.set(player.getName() + ".classe", null);
        f.set(player.getName() + ".str", null);
        f.set(player.getName() + ".res", null);
        f.set(player.getName() + ".agi", null);
        f.set(player.getName() + ".hp", null);
        f.set(player.getName() + ".mp", null);
        f.set(player.getName() + ".sorts", null);
        f.set(player.getName() + ".skills", null);
    }

    public GameTeams getTeam() {
        YamlConfiguration f = YamlConfiguration.loadConfiguration(fileManager.getFile("users"));
        return GameTeams.valueOf(f.getString(player.getName() + ".team"));
    }

    public void setTeam(GameTeams team) {
        YamlConfiguration f = YamlConfiguration.loadConfiguration(fileManager.getFile("users"));
        f.set(player.getName() + ".team", team.toString());
    }

    public GameClasses getClasse() {
        YamlConfiguration f = YamlConfiguration.loadConfiguration(fileManager.getFile("users"));
        return GameClasses.valueOf(f.getString(player.getName() + ".classe"));
    }

    public void setClasse(GameClasses classe) {
        YamlConfiguration f = YamlConfiguration.loadConfiguration(fileManager.getFile("users"));
        f.set(player.getName() + ".classe", classe.toString());
    }


    public int getStr() {
        YamlConfiguration f = YamlConfiguration.loadConfiguration(fileManager.getFile("users"));
        return f.getInt(player.getName() + ".str");
    }

    public void setStr(int str) {
        YamlConfiguration f = YamlConfiguration.loadConfiguration(fileManager.getFile("users"));
        f.set(player.getName() + ".str", str);
    }


    public int getRes() {
        YamlConfiguration f = YamlConfiguration.loadConfiguration(fileManager.getFile("users"));
        return f.getInt(player.getName() + ".res");
    }

    public void setRes(int res) {
        YamlConfiguration f = YamlConfiguration.loadConfiguration(fileManager.getFile("users"));
        f.set(player.getName() + ".res", res);
    }


    public int getAgi() {
        YamlConfiguration f = YamlConfiguration.loadConfiguration(fileManager.getFile("users"));
        return f.getInt(player.getName() + ".agi");
    }

    public void setAgi(int agi) {
        YamlConfiguration f = YamlConfiguration.loadConfiguration(fileManager.getFile("users"));
        f.set(player.getName() + ".agi", agi);
    }


    public int getHp() {
        YamlConfiguration f = YamlConfiguration.loadConfiguration(fileManager.getFile("users"));
        return f.getInt(player.getName() + ".hp");
    }

    public void setHp(int hp) {
        YamlConfiguration f = YamlConfiguration.loadConfiguration(fileManager.getFile("users"));
        f.set(player.getName() + ".hp", hp);
    }


    public int getMp() {
        YamlConfiguration f = YamlConfiguration.loadConfiguration(fileManager.getFile("users"));
        return f.getInt(player.getName() + ".mp");
    }

    public void setMp(int mp) {
        YamlConfiguration f = YamlConfiguration.loadConfiguration(fileManager.getFile("users"));
        f.set(player.getName() + ".mp", mp);
    }


    public List<GameElements> getSort() {
        YamlConfiguration f = YamlConfiguration.loadConfiguration(fileManager.getFile("users"));
        return (List<GameElements>) f.getList(player.getName() + ".sorts");
    }

    public void addSort(GameElements gamePowers) {
        YamlConfiguration f = YamlConfiguration.loadConfiguration(fileManager.getFile("users"));
        List<GameElements> list = getSort();
        list.add(gamePowers);
        f.set(player.getName() + ".sorts", list);
    }

    public void removeSort(GameElements gamePowers) {
        YamlConfiguration f = YamlConfiguration.loadConfiguration(fileManager.getFile("users"));
        List<GameElements> list = getSort();
        list.remove(gamePowers);
        f.set(player.getName() + ".sorts", list);
    }

    public String getSkills() {
        YamlConfiguration f = YamlConfiguration.loadConfiguration(fileManager.getFile("users"));
        return f.getString(player.getName() + ".skills");
    }

    public void setSkills(String skills) {
        YamlConfiguration f = YamlConfiguration.loadConfiguration(fileManager.getFile("users"));
        f.set(player.getName() + ".skills", skills);
    }


}
