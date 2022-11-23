package fr.notdark.orbconquest.enums;

import org.bukkit.ChatColor;

public class EnumsConvertor {

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

    public String convertPowerToCategory(GamePowers power){
        if(power.equals(GamePowers.Fireball) || power.equals(GamePowers.FlareAccel) || power.equals(GamePowers.HellAura)) return "Feu";
        if(power.equals(GamePowers.ParalyzeShot) || power.equals(GamePowers.LightningBolt) || power.equals(GamePowers.ThunderCharge)) return "Foudre";
        if(power.equals(GamePowers.IceFreeze) || power.equals(GamePowers.IceAura) || power.equals(GamePowers.SnowBall)) return "Glace";
        if(power.equals(GamePowers.AerialSpeed) || power.equals(GamePowers.Mist) || power.equals(GamePowers.WindCutter)) return "Air";
        if(power.equals(GamePowers.PoisonSynthesis) || power.equals(GamePowers.PouisonBall) || power.equals(GamePowers.PoisonBreath)) return "Poison";
        if(power.equals(GamePowers.FlashBomb) || power.equals(GamePowers.Heal) || power.equals(GamePowers.HealingZone)) return "Lumière";
        if(power.equals(GamePowers.Zombie) || power.equals(GamePowers.Skeleton) || power.equals(GamePowers.IronGolem) || power.equals(GamePowers.Horse) || power.equals(GamePowers.Rabbit) || power.equals(GamePowers.Sheep)) return "Invocation";
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
        if(skill.equals(GameSkills.SoulStealer) || skill.equals(GameSkills.SoulStealer2) || skill.equals(GameSkills.SoulStealer3) || skill.equals(GameSkills.SoulStealer4) || skill.equals(GameSkills.SoulStealer5)) return GameClasses.Assassin;
        return null;
    }
}
