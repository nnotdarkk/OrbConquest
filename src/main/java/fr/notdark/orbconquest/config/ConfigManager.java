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

        f.set("temps-partie", 0);
        f.set("temps-prep", 0);
        f.set("temps-calcul-point", 0);
        f.set("points-garde", 0);
        f.set("points-perte", 0);
        f.set("players-per-team", 0);
        f.set("players-points-start", 0);

        f.set("creation-mode", GameCreationMode.Choosen.toString());
        f.set("host", "null");
        //TODO locations

        try {
            f.save(fileManager.getFile("config"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void clearFile() {
        fileManager.removeFile("config");
    }

    public int getTempsPartie() {
        YamlConfiguration f = YamlConfiguration.loadConfiguration(fileManager.getFile("config"));
        return f.getInt("temps-partie");
    }

    public void setTempsPartie(int tempsPartie) {
        YamlConfiguration f = YamlConfiguration.loadConfiguration(fileManager.getFile("config"));
        f.set("temps-partie", tempsPartie);

        try {
            f.save(fileManager.getFile("config"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public int getTempsPrep() {
        YamlConfiguration f = YamlConfiguration.loadConfiguration(fileManager.getFile("config"));
        return f.getInt("temps-prep");
    }

    public void setTempsPrep(int tempsPrep) {
        YamlConfiguration f = YamlConfiguration.loadConfiguration(fileManager.getFile("config"));
        f.set("temps-prep", tempsPrep);

        try {
            f.save(fileManager.getFile("config"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public int getTempsCalculPoint() {
        YamlConfiguration f = YamlConfiguration.loadConfiguration(fileManager.getFile("config"));
        return f.getInt("temps-calcul-point");
    }

    public void setTempsCalculPoint(int tempsCalculPoint) {
        YamlConfiguration f = YamlConfiguration.loadConfiguration(fileManager.getFile("config"));
        f.set("temps-calcul-point", tempsCalculPoint);

        try {
            f.save(fileManager.getFile("config"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public int getPointsGarde() {
        YamlConfiguration f = YamlConfiguration.loadConfiguration(fileManager.getFile("config"));
        return f.getInt("points-garde");
    }

    public void setPointsGarde(int pointsGarde) {
        YamlConfiguration f = YamlConfiguration.loadConfiguration(fileManager.getFile("config"));
        f.set("points-garde", pointsGarde);

        try {
            f.save(fileManager.getFile("config"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public int getPointsPerte() {
        YamlConfiguration f = YamlConfiguration.loadConfiguration(fileManager.getFile("config"));
        return f.getInt("points-perte");
    }

    public void setPointsPerte(int pointsPerte) {
        YamlConfiguration f = YamlConfiguration.loadConfiguration(fileManager.getFile("config"));
        f.set("points-perte", pointsPerte);

        try {
            f.save(fileManager.getFile("config"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public int getPlayersPerTeam() {
        YamlConfiguration f = YamlConfiguration.loadConfiguration(fileManager.getFile("config"));
        return f.getInt("players-per-team");
    }

    public void setPlayersPerTeam(int playersPerTeam) {
        YamlConfiguration f = YamlConfiguration.loadConfiguration(fileManager.getFile("config"));
        f.set("players-per-team", playersPerTeam);

        try {
            f.save(fileManager.getFile("config"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public int getPlayersPointsStart() {
        YamlConfiguration f = YamlConfiguration.loadConfiguration(fileManager.getFile("config"));
        return f.getInt("players-points-start");
    }

    public void setPlayersPointsStart(int playersPointsStart) {
        YamlConfiguration f = YamlConfiguration.loadConfiguration(fileManager.getFile("config"));
        f.set("players-points-start", playersPointsStart);

        try {
            f.save(fileManager.getFile("config"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public GameCreationMode getCreationTeams() {
        YamlConfiguration f = YamlConfiguration.loadConfiguration(fileManager.getFile("config"));
        return GameCreationMode.valueOf(f.getString("creation-teams"));
    }

    public void setCreationTeams(GameCreationMode creationTeams) {
        YamlConfiguration f = YamlConfiguration.loadConfiguration(fileManager.getFile("config"));
        f.set("creation-teams", creationTeams);

        try {
            f.save(fileManager.getFile("config"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String getHost() {
        YamlConfiguration f = YamlConfiguration.loadConfiguration(fileManager.getFile("config"));
        return f.getString("host");
    }

    public void setHost(String host) {
        YamlConfiguration f = YamlConfiguration.loadConfiguration(fileManager.getFile("config"));
        f.set("host", host);

        try {
            f.save(fileManager.getFile("config"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
