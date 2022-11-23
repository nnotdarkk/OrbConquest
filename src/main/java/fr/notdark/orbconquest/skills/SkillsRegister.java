package fr.notdark.orbconquest.skills;

import fr.notdark.orbconquest.Main;
import fr.notdark.orbconquest.skills.elements.feu.FireBall;
import fr.notdark.orbconquest.skills.elements.feu.FlareAccel;
import fr.notdark.orbconquest.skills.elements.feu.HellAura;
import fr.notdark.orbconquest.skills.elements.foudre.LighningBolt;
import fr.notdark.orbconquest.skills.elements.foudre.ParalyzeShot;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;

public class SkillsRegister {

    private final Main main;

    public SkillsRegister(Main main) {
        this.main = main;
    }

    public void registerSkills() {
        PluginManager pm = Bukkit.getPluginManager();
        pm.registerEvents(new FireBall(), main);
        pm.registerEvents(new FlareAccel(main), main);
        pm.registerEvents(new HellAura(), main);
        pm.registerEvents(new LighningBolt(), main);
        pm.registerEvents(new ParalyzeShot(main), main);
    }
}
