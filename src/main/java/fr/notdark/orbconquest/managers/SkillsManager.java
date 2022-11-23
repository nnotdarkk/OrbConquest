package fr.notdark.orbconquest.managers;

import fr.notdark.orbconquest.enums.GameElements;
import fr.notdark.orbconquest.enums.GameSkills;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitTask;

import java.util.*;

public class SkillsManager {

    private static Map<Player, Map<GameElements, Long>> powersCooldown = new HashMap<>();
    private static Map<Player, Map<GameSkills, Long>> skillsCooldown = new HashMap<>();
    private static Map<Player, Long> noSkillsOrElements = new HashMap<>();
    private static List<UUID> projectiles = new ArrayList<>();
    private static Map<Player, Boolean> isInFlareAccel = new HashMap<>();
    private static List<Player> isFiredByFlareAccel = new ArrayList<>();
    private static List<Player> ifParalyzed = new ArrayList<>();
    private static List<Player> isInThunderCharge = new ArrayList<>();
    private static List<Player> thunderedByThunderCharge = new ArrayList<>();
    private static List<Player> isInIceAura = new ArrayList<>();
    private static HashMap<Player, BukkitTask> iceAuraRunnable = new HashMap<>();


    public void initPlayer(Player player){
        powersCooldown.put(player, new HashMap<>());
        skillsCooldown.put(player, new HashMap<>());
        isInFlareAccel.put(player, false);
        iceAuraRunnable.put(player, null);
        noSkillsOrElements.put(player, System.currentTimeMillis());
    }

    public void clearPlayer(Player player){
        powersCooldown.remove(player);
        skillsCooldown.remove(player);
        isInFlareAccel.remove(player);
        iceAuraRunnable.remove(player);
        noSkillsOrElements.remove(player);
    }

    /*
    * Elements
     */

    public void addElementsCooldown(Player player, GameElements gamePowers, int cooldown){
        powersCooldown.get(player).put(gamePowers, System.currentTimeMillis() + (cooldown * 1000L));
    }

    public boolean isInElementsCooldown(Player player, GameElements gamePowers) {
        if (powersCooldown.get(player).containsKey(gamePowers)) {
            if (powersCooldown.get(player).get(gamePowers) > System.currentTimeMillis()) {
                return true;
            }
        }
        return false;
    }

    public int secondsLeftElementsCooldown(Player player, GameElements gamePowers){
        return (int) ((powersCooldown.get(player).get(gamePowers) - System.currentTimeMillis()) / 1000L);
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

    /*
    * Projectiles
     */

    public void addProjectile(UUID uuid) {
        projectiles.add(uuid);
    }

    public void removeProjectile(UUID uuid) {
        projectiles.remove(uuid);
    }

    public boolean isProjectile(UUID uuid) {
        return projectiles.contains(uuid);
    }

    /*
    * NoSkillsOrElements
     */

    public void addNoSkillsOrElements(Player player, int cooldown) {
        noSkillsOrElements.put(player, System.currentTimeMillis() + (cooldown * 1000L));
    }

    public boolean isInNoSkillsOrElements(Player player) {
        if (noSkillsOrElements.containsKey(player)) {
            if (noSkillsOrElements.get(player) > System.currentTimeMillis()) {
                return true;
            }
        }
        return false;
    }

    public void removeNoSkillsOrElements(Player player){
        noSkillsOrElements.put(player, System.currentTimeMillis());
    }

    /*
    * FlareAccel
     */

    public void setFlareAccel(Player player, boolean bool) {
        isInFlareAccel.put(player, bool);
    }

    public boolean isInFlareAccel(Player player) {
        return isInFlareAccel.get(player);
    }

    /*
    * IsFlamed
     */

    public void addFlamedByFlareAccel(Player player) {
        isFiredByFlareAccel.add(player);
    }

    public void removeFlamedByFlareAccel(Player player) {
        isFiredByFlareAccel.remove(player);
    }

    public boolean isFlamedByFlareAccel(Player player) {
        return isFiredByFlareAccel.contains(player);
    }

    /*
    * Paralyzed
     */

    public void addParalyzed(Player player) {
        ifParalyzed.add(player);
    }

    public void removeParalyzed(Player player) {
        ifParalyzed.remove(player);
    }

    public boolean isParalyzed(Player player) {
        return ifParalyzed.contains(player);
    }

    /*
    * ThunderCharge
     */

    public void addThunderCharge(Player player) {
        isInThunderCharge.add(player);
    }

    public void removeThunderCharge(Player player) {
        isInThunderCharge.remove(player);
    }

    public boolean isThunderCharge(Player player) {
        return isInThunderCharge.contains(player);
    }

    /*
    * ThunderedByThunderCharge
     */

    public void addThunderedByThunderCharge(Player player) {
        thunderedByThunderCharge.add(player);
    }

    public void removeThunderedByThunderCharge(Player player) {
        thunderedByThunderCharge.remove(player);
    }

    public boolean isThunderedByThunderCharge(Player player) {
        return thunderedByThunderCharge.contains(player);
    }

    /*
    * IceAura
     */

    public void addIceAura(Player player) {
        isInIceAura.add(player);
    }

    public void removeIceAura(Player player) {
        isInIceAura.remove(player);
    }

    public boolean isIceAura(Player player) {
        return isInIceAura.contains(player);
    }

    /*
    * IceAuraRunnable
     */

    public void addIceAuraRunnable(Player player, BukkitTask runnable) {
        iceAuraRunnable.put(player, runnable);
    }

    public BukkitTask getIceAuraRunnable(Player player) {
        return iceAuraRunnable.get(player);
    }

    public void removeIceAuraRunnable(Player player) {
        iceAuraRunnable.remove(player);
    }

}
