package fr.notdark.orbconquest.manager;

import fr.notdark.orbconquest.enums.GameElements;
import fr.notdark.orbconquest.enums.GameSkills;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;

public class SkillsManager {

    private static Map<Player, Map<GameElements, Long>> powersCooldown = new HashMap<>();
    private static Map<Player, Map<GameSkills, Long>> skillsCooldown = new HashMap<>();

    public void initPlayer(Player player){
        powersCooldown.put(player, new HashMap<>());
        skillsCooldown.put(player, new HashMap<>());
    }

    public void clearPlayer(Player player){
        powersCooldown.remove(player);
        skillsCooldown.put(player, new HashMap<>());
    }

    /*
    * Elements
     */

    public void addElementsCooldown(Player player, GameElements gamePowers, int cooldown){
        powersCooldown.get(player).put(gamePowers, cooldown * 1000L);
    }

    public boolean isInElementsCooldown(Player player, GameElements gamePowers) {
        if (powersCooldown.get(player).containsKey(gamePowers)) {
            if (powersCooldown.get(player).get(gamePowers) <= System.currentTimeMillis()) {
                return true;
            }
        }
        return false;
    }

    public void removeElementsCooldown(Player player, GameElements gamePowers){
        powersCooldown.get(player).remove(gamePowers);
    }

    /*
    * Skills
     */

    public void addSkillsCooldown(Player player, GameSkills gameSkills, int cooldown) {
        skillsCooldown.get(player).put(gameSkills, System.currentTimeMillis() + (cooldown * 1000L));
    }

    public boolean isInSkillsCooldown(Player player, GameSkills gameSkills) {
        if (skillsCooldown.get(player).containsKey(gameSkills)) {
            if (skillsCooldown.get(player).get(gameSkills) <= System.currentTimeMillis()) {
                return true;
            }
        }
        return false;
    }

    public void removeSkillsCooldown(Player player, GameSkills gameSkills){
        skillsCooldown.get(player).remove(gameSkills);
    }

}
