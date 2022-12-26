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

    public GameElements convertSortToElement(GameSorts sort){
        if(sort.equals(GameSorts.Fireball) || sort.equals(GameSorts.FlareAccel) || sort.equals(GameSorts.HellAura)) return GameElements.Feu;
        if(sort.equals(GameSorts.ParalyzeShot) || sort.equals(GameSorts.LightningBolt) || sort.equals(GameSorts.ThunderCharge)) return GameElements.Foudre;
        if(sort.equals(GameSorts.IceFreeze) || sort.equals(GameSorts.IceAura) || sort.equals(GameSorts.SnowBall)) return GameElements.Glace;
        if(sort.equals(GameSorts.AerialSpeed) || sort.equals(GameSorts.Mist) || sort.equals(GameSorts.WindCutter)) return GameElements.Air;
        if(sort.equals(GameSorts.PoisonSynthesis) || sort.equals(GameSorts.PouisonBall) || sort.equals(GameSorts.PoisonBreath)) return GameElements.Poison;
        if(sort.equals(GameSorts.FlashBomb) || sort.equals(GameSorts.Heal) || sort.equals(GameSorts.HealingZone)) return GameElements.Lumiere;
        if(sort.equals(GameSorts.Zombie) || sort.equals(GameSorts.Skeleton) || sort.equals(GameSorts.IronGolem) || sort.equals(GameSorts.Horse) || sort.equals(GameSorts.Rabbit) || sort.equals(GameSorts.Sheep)) return GameElements.Invocation;
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

    public GameCreationMode getCreationMode(String mode){
        if(mode.equals("Choosen")) return GameCreationMode.Choosen;
        if(mode.equals("Random")) return GameCreationMode.Random;
        if(mode.equals("Captains")) return GameCreationMode.Captains;
        return null;
    }
}
