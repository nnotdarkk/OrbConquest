package fr.notdark.orbconquest.enums;

import org.bukkit.ChatColor;

import java.util.ArrayList;
import java.util.List;

public class EnumsManager {

    public String convertEnumToString(Object object) {
        return object.toString();
    }

    public ChatColor convertTeamToColor(GameTeams team) {
        if(team.equals(GameTeams.Rouge)) return ChatColor.RED;
        if(team.equals(GameTeams.Orange)) return ChatColor.GOLD;
        if(team.equals(GameTeams.Jaune)) return ChatColor.YELLOW;
        if(team.equals(GameTeams.Vert)) return ChatColor.GREEN;
        if(team.equals(GameTeams.Lime)) return ChatColor.DARK_GREEN;
        if(team.equals(GameTeams.Aqua)) return ChatColor.AQUA;
        if(team.equals(GameTeams.Marine)) return ChatColor.DARK_AQUA;
        if(team.equals(GameTeams.Blue)) return ChatColor.BLUE;
        if(team.equals(GameTeams.Rose)) return ChatColor.LIGHT_PURPLE;
        if(team.equals(GameTeams.Violet)) return ChatColor.DARK_PURPLE;
        if(team.equals(GameTeams.Blanc)) return ChatColor.WHITE;
        if(team.equals(GameTeams.Gris)) return ChatColor.GRAY;
        return null;
    }

    public String convertPowerToCategory(GameElements power){
        if(power.equals(GameElements.Fireball) || power.equals(GameElements.FlareAccel) || power.equals(GameElements.HellAura)) return "Feu";
        if(power.equals(GameElements.ParalyzeShot) || power.equals(GameElements.LightningBolt) || power.equals(GameElements.ThunderCharge)) return "Foudre";
        if(power.equals(GameElements.IceFreeze) || power.equals(GameElements.IceAura) || power.equals(GameElements.SnowBall)) return "Glace";
        if(power.equals(GameElements.AerialSpeed) || power.equals(GameElements.Mist) || power.equals(GameElements.WindCutter)) return "Air";
        if(power.equals(GameElements.PoisonSynthesis) || power.equals(GameElements.PouisonBall) || power.equals(GameElements.PoisonBreath)) return "Poison";
        if(power.equals(GameElements.FlashBomb) || power.equals(GameElements.Heal) || power.equals(GameElements.HealingZone)) return "Lumière";
        if(power.equals(GameElements.Zombie) || power.equals(GameElements.Skeleton) || power.equals(GameElements.IronGolem) || power.equals(GameElements.Horse) || power.equals(GameElements.Rabbit) || power.equals(GameElements.Sheep)) return "Invocation";
        return null;
    }

    public GameClasses convertSkilltoClasse(GameSkills skill){
        if(skill.equals(GameSkills.Slash) || skill.equals(GameSkills.FastStrike) || skill.equals(GameSkills.LastStanding) || skill.equals(GameSkills.LastWarrior) || skill.equals(GameSkills.Fortitude)) return GameClasses.Guerrier;
        if(skill.equals(GameSkills.CoverMoove) || skill.equals(GameSkills.Unbreakable) || skill.equals(GameSkills.AnchorHowl) || skill.equals(GameSkills.Repulser) || skill.equals(GameSkills.HolyProtection)) return GameClasses.Tank;
        if(skill.equals(GameSkills.MPDrainer) || skill.equals(GameSkills.MPLife) || skill.equals(GameSkills.SelfDestruct) || skill.equals(GameSkills.MultiBarrier)) return GameClasses.Mage;
        if(skill.equals(GameSkills.Controller) || skill.equals(GameSkills.SoulRetrieval) || skill.equals(GameSkills.PlaceChanger)) return GameClasses.Invocateur;
        if(skill.equals(GameSkills.Boost) || skill.equals(GameSkills.ElementalTrap) || skill.equals(GameSkills.Alarm) || skill.equals(GameSkills.MPBalancer)) return GameClasses.Support;
        if(skill.equals(GameSkills.BombArrow) || skill.equals(GameSkills.Jump) || skill.equals(GameSkills.ElementalArrow) || skill.equals(GameSkills.HomingArrow)) return GameClasses.Archer;
        if(skill.equals(GameSkills.ShadowStrike) || skill.equals(GameSkills.Bleeding) || skill.equals(GameSkills.Hide)) return GameClasses.Assassin;
        return null;
    }

    public List<GameSkills> getClassicSkills(){
        List<GameSkills> skills = new ArrayList<>();
        skills.add(GameSkills.Meditation);
        skills.add(GameSkills.Detection);
        skills.add(GameSkills.SteadfastWarrior);
        skills.add(GameSkills.SuperAccel);
        return skills;
    }

    public List<GameSkills> getUniqueSkills(){
        List<GameSkills> skills = new ArrayList<>();
        skills.add(GameSkills.DeadOrAlive);
        skills.add(GameSkills.HeavenlyRoad);
        skills.add(GameSkills.SoulEater);
        return skills;
    }
}
