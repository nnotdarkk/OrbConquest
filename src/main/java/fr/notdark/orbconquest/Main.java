package fr.notdark.orbconquest;

import com.github.fierioziy.particlenativeapi.api.ParticleNativeAPI;
import com.github.fierioziy.particlenativeapi.api.Particles_1_8;
import com.github.fierioziy.particlenativeapi.plugin.ParticleNativePlugin;
import fr.notdark.orbconquest.commands.SetHost;
import fr.notdark.orbconquest.config.ClassesManager;
import fr.notdark.orbconquest.config.ConfigManager;
import fr.notdark.orbconquest.config.user.TeamManager;
import fr.notdark.orbconquest.config.user.UserManager;
import fr.notdark.orbconquest.enums.EnumsManager;
import fr.notdark.orbconquest.enums.GameStates;
import fr.notdark.orbconquest.events.*;
import fr.notdark.orbconquest.events.customs.ElementsEvent;
import fr.notdark.orbconquest.events.customs.SkillsEvent;
import fr.notdark.orbconquest.scoreboard.ScoreboardManager;
import fr.notdark.orbconquest.managers.GameManager;
import fr.notdark.orbconquest.skills.SkillsRegister;
import fr.notdark.orbconquest.tasks.Lag;
import fr.notdark.orbconquest.tasks.TAB;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandMap;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.lang.reflect.Field;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class Main extends JavaPlugin {

    @Getter
    private static Main instance;

    @Getter
    private ScoreboardManager scoreboardManager;

    @Getter
    private ScheduledExecutorService executorMonoThread;
    @Getter
    private ScheduledExecutorService scheduledExecutorService;

    @Getter
    private UserManager userManager;
    @Getter
    private TeamManager teamManager;
    @Getter
    private ConfigManager configManager;
    @Getter
    private GameManager gameManager;
    @Getter
    private Particles_1_8 particles;
    @Getter
    private EnumsManager enumsManager;
    @Getter
    private ClassesManager classesManager;

    @Override
    public void onEnable() {
        instance = this;

        (userManager = new UserManager(this)).setupFile();
        (teamManager = new TeamManager(this)).setupFile();
        (configManager = new ConfigManager(this)).setupFile();
        (gameManager = new GameManager(this)).setGameState(GameStates.LOBBY);
        enumsManager = new EnumsManager();
        (classesManager = new ClassesManager(this)).setupFile();

        scheduledExecutorService = Executors.newScheduledThreadPool(16);
        executorMonoThread = Executors.newScheduledThreadPool(1);
        scoreboardManager = new ScoreboardManager();

        PluginManager pm = Bukkit.getPluginManager();
        pm.registerEvents(new PlayerJoin(this), this);
        pm.registerEvents(new PlayerQuit(this), this);
        pm.registerEvents(new PlayerCancels(this), this);
        pm.registerEvents(new HostInteract(this), this);
        pm.registerEvents(new HostInventoryClick(this), this);
        pm.registerEvents(new SkillsEvent(this), this);
        pm.registerEvents(new ElementsEvent(this), this);
        pm.registerEvents(new ChoiceInventoryClick(this), this);
        new SkillsRegister(this).registerSkills();

        registerCommand("sethost", new SetHost("sethost", this));

        ParticleNativeAPI api = ParticleNativePlugin.getAPI();
        particles = api.getParticles_1_8();

        TAB tab = new TAB(this);
        tab.runTaskTimer(this, 0, 10);
        getServer().getScheduler().scheduleSyncRepeatingTask(this, new Lag(), 100L, 1L);
    }

    @Override
    public void onDisable() {
        userManager.clearFile();
        teamManager.clearFile();
        configManager.clearFile();
    }

    public void registerCommand(String commandName, Command commandClass) {
        try {
            Field bukkitCommandMap = Bukkit.getServer().getClass().getDeclaredField("commandMap");
            bukkitCommandMap.setAccessible(true);
            CommandMap commandMap = (CommandMap)bukkitCommandMap.get(Bukkit.getServer());
            commandMap.register(commandName, commandClass);
        } catch (Exception var5) {
            var5.printStackTrace();
        }

    }

}
