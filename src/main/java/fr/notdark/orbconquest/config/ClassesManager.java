package fr.notdark.orbconquest.config;

import fr.notdark.orbconquest.Main;
import lombok.SneakyThrows;
import org.bukkit.configuration.file.YamlConfiguration;

import java.util.ArrayList;
import java.util.List;

public class ClassesManager {

    private final Main main;
    private final FileManager fileManager;

    public ClassesManager(Main main) {
        this.main = main;
        fileManager = new FileManager(main);
    }

    @SneakyThrows
    public void setupFile(){
        if(fileManager.getFile("classes").exists()) return;

        fileManager.createFile("classes");

        YamlConfiguration f = YamlConfiguration.loadConfiguration(fileManager.getFile("classes"));

        List<String> e1 = new ArrayList<>();
        e1.add("PROTECTION_ENVIRONMENTAL:1");

        List<String> e2 = new ArrayList<>();
        e2.add("DAMAGE_ALL:1");

        List<String> e3 = new ArrayList<>();

        List<String> e4 = new ArrayList<>();
        e4.add("DAMAGE_ALL:2");

        List<String> e5 = new ArrayList<>();
        e5.add("DAMAGE_ALL:3");

        f.set("guerrier.str", 120);
        f.set("guerrier.res", 110);
        f.set("guerrier.agi", 100);
        f.set("guerrier.hp", 120);
        f.set("guerrier.mp", 50);
        f.set("guerrier.armure.nombre", 2);
        f.set("guerrier.armure.enchant", e3);
        f.set("guerrier.epee.type", "DIAMOND_SWORD");
        f.set("guerrier.epee.enchant", e2);
        f.set("guerrier.arc.boolean", false);
        f.set("guerrier.arc.enchants", e3);
        f.set("guerrier.arc.fleches", 0);
        f.set("guerrier.elementsMax", 1);
        f.set("guerrier.sortsMax", 2);
        f.set("guerrier.skillsClassesMax", 2);
        f.set("guerrier.skillsClassiquesMax", 1);

        f.set("tank.str", 80);
        f.set("tank.res", 160);
        f.set("tank.agi", 80);
        f.set("tank.hp", 130);
        f.set("tank.mp", 50);
        f.set("tank.armure.nombre", 3);
        f.set("tank.armure.enchant", e1);
        f.set("tank.epee.type", "IRON_SWORD");
        f.set("tank.epee.enchant", e2);
        f.set("tank.arc.boolean", false);
        f.set("tank.arc.enchants", e3);
        f.set("tank.arc.fleches", 0);
        f.set("tank.elementsMax", 1);
        f.set("tank.sortsMax", 1);
        f.set("tank.skillsClassesMax", 3);
        f.set("tank.skillsClassiquesMax", 1);

        f.set("mage.str", 100);
        f.set("mage.res", 90);
        f.set("mage.agi", 100);
        f.set("mage.hp", 110);
        f.set("mage.mp", 100);
        f.set("mage.armure.nombre", 1);
        f.set("mage.armure.enchant", e3);
        f.set("mage.epee.type", "IRON_SWORD");
        f.set("mage.epee.enchant", e2);
        f.set("mage.arc.boolean", true);
        f.set("mage.arc.enchants", e3);
        f.set("mage.arc.fleches", 32);
        f.set("mage.elementsMax", 3);
        f.set("mage.sortsMax", 5);
        f.set("mage.skillsClassesMax", 1);
        f.set("mage.skillsClassiquesMax", 1);

        f.set("invocateur.str", 100);
        f.set("invocateur.res", 110);
        f.set("invocateur.agi", 100);
        f.set("invocateur.hp", 110);
        f.set("invocateur.mp", 80);
        f.set("invocateur.armure.nombre", 1);
        f.set("invocateur.armure.enchant", e3);
        f.set("invocateur.epee.type", "IRON_SWORD");
        f.set("invocateur.epee.enchant", e4);
        f.set("invocateur.arc.boolean", false);
        f.set("invocateur.arc.enchants", e3);
        f.set("invocateur.arc.fleches", 0);
        f.set("invocateur.sortsMax", 4);
        f.set("invocateur.skillsClassesMax", 2);
        f.set("invocateur.skillsClassiquesMax", 1);

        f.set("support.str", 110);
        f.set("support.res", 100);
        f.set("support.agi", 110);
        f.set("support.hp", 100);
        f.set("support.mp", 80);
        f.set("support.armure.nombre", 2);
        f.set("support.armure.enchant", e3);
        f.set("support.epee.type", "IRON_SWORD");
        f.set("support.epee.enchant", e4);
        f.set("support.arc.boolean", true);
        f.set("support.arc.enchants", e3);
        f.set("support.arc.fleches", 32);
        f.set("support.elementsMax", 1);
        f.set("support.sortsMax", 3);
        f.set("support.skillsClassesMax", 2);
        f.set("support.skillsClassiquesMax", 1);

        f.set("archer.str", 100);
        f.set("archer.res", 110);
        f.set("archer.agi", 120);
        f.set("archer.hp", 110);
        f.set("archer.mp", 60);
        f.set("archer.armure.nombre", 1);
        f.set("archer.armure.enchant", e3);
        f.set("archer.epee.type", "IRON_SWORD");
        f.set("archer.epee.enchant", e2);
        f.set("archer.arc.boolean", true);
        f.set("archer.arc.enchants", e3);
        f.set("archer.elementsMax", 2);
        f.set("archer.sortsMax", 3);
        f.set("archer.skillsClassesMax", 2);
        f.set("archer.skillsClassiquesMax", 1);

        f.set("assassin.str", 140);
        f.set("assassin.res", 80);
        f.set("assassin.agi", 140);
        f.set("assassin.hp", 80);
        f.set("assassin.mp", 60);
        f.set("assassin.armure.nombre", 0);
        f.set("assassin.armure.enchant", e3);
        f.set("assassin.epee.type", "DIAMOND_SWORD");
        f.set("assassin.epee.enchant", e5);
        f.set("assassin.arc.boolean", false);
        f.set("assassin.arc.enchants", e3);
        f.set("assassin.elementsMax", 1);
        f.set("assassin.sortsMax", 2);
        f.set("assassin.skillsClassesMax", 2);
        f.set("assassin.skillsClassiquesMax", 1);

        f.save(fileManager.getFile("classes"));
    }

    public int getInt(String path) {
        YamlConfiguration f = YamlConfiguration.loadConfiguration(fileManager.getFile("classes"));
        return f.getInt(path);
    }

    public String getString(String path) {
        YamlConfiguration f = YamlConfiguration.loadConfiguration(fileManager.getFile("classes"));
        return f.getString(path);
    }

    public List<String> getStringList(String path) {
        YamlConfiguration f = YamlConfiguration.loadConfiguration(fileManager.getFile("classes"));
        return f.getStringList(path);

    }

    public <T> T getStringListNonNull(String path) {
        YamlConfiguration f = YamlConfiguration.loadConfiguration(fileManager.getFile("classes"));
        if(f.getStringList(path).isEmpty()) return (T) "§cAucun";
        return (T) f.getStringList(path);
    }
    public String getBooleanToString(String path) {
        YamlConfiguration f = YamlConfiguration.loadConfiguration(fileManager.getFile("classes"));
        if(f.getBoolean(path)) return "§aOui";
        return "§cNon";
    }

    public boolean getBoolean(String path) {
        YamlConfiguration f = YamlConfiguration.loadConfiguration(fileManager.getFile("classes"));
        return f.getBoolean(path);
    }
}
