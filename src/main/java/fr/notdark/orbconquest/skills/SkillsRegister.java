package fr.notdark.orbconquest.skills;

import fr.notdark.orbconquest.Main;
import fr.notdark.orbconquest.skills.elements.air.AerialSpeed;
import fr.notdark.orbconquest.skills.elements.air.Mist;
import fr.notdark.orbconquest.skills.elements.air.WindCutter;
import fr.notdark.orbconquest.skills.elements.feu.FireBall;
import fr.notdark.orbconquest.skills.elements.feu.FlareAccel;
import fr.notdark.orbconquest.skills.elements.feu.HellAura;
import fr.notdark.orbconquest.skills.elements.foudre.LighningBolt;
import fr.notdark.orbconquest.skills.elements.foudre.ParalyzeShot;
import fr.notdark.orbconquest.skills.elements.foudre.ThunderCharge;
import fr.notdark.orbconquest.skills.elements.glace.CryoStasis;
import fr.notdark.orbconquest.skills.elements.glace.IceAura;
import fr.notdark.orbconquest.skills.elements.glace.SnowBall;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;

import java.util.ArrayList;
import java.util.List;

public class SkillsRegister {

    private final Main main;

    public SkillsRegister(Main main) {
        this.main = main;
    }

    public void registerSkills() {
        PluginManager pm = Bukkit.getPluginManager();
        pm.registerEvents(new FireBall(), main);
        pm.registerEvents(new FlareAccel(), main);
        pm.registerEvents(new HellAura(main), main);

        pm.registerEvents(new LighningBolt(), main);
        pm.registerEvents(new ParalyzeShot(main), main);
        pm.registerEvents(new ThunderCharge(main), main);

        pm.registerEvents(new CryoStasis(main), main);
        pm.registerEvents(new IceAura(main), main);
        pm.registerEvents(new SnowBall(), main);

        pm.registerEvents(new AerialSpeed(), main);
        pm.registerEvents(new Mist(main), main);
        pm.registerEvents(new WindCutter(), main);

    }

    public List<String> getAllSkillsName() {
        List<String> skills = new ArrayList<>();
        skills.add("FireBall");
        skills.add("FlareAccel");
        skills.add("HellAura");
        skills.add("LighningBolt");
        skills.add("ParalyzeShot");

        return new ArrayList<>();
    }
}
