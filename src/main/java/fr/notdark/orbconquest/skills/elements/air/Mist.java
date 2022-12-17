package fr.notdark.orbconquest.skills.elements.air;

import fr.notdark.orbconquest.Main;
import fr.notdark.orbconquest.managers.SkillsManager;
import fr.notdark.orbconquest.tools.Title;
import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerInteractEvent;

public class Mist implements Listener {

    private final Main main;
    private final SkillsManager skillsManager;

    public Mist(Main main) {
        this.main = main;
        this.skillsManager = new SkillsManager();
    }

    public String getName() {
        return "§a§lMist";
    }

    @EventHandler
    public void event(PlayerInteractEvent e){
        if(e.getItem() == null) return;
        if(e.getItem().getItemMeta() == null) return;
        if(e.getItem().getItemMeta().getDisplayName() == null) return;

        if(e.getItem().getItemMeta().getDisplayName().equals(getName())){
            for(Player p : Bukkit.getOnlinePlayers()){
                p.hidePlayer(e.getPlayer());
            }

            Bukkit.getScheduler().runTaskLater(main, () -> {
                Title title = new Title();
                if(skillsManager.isMist(e.getPlayer())){
                    title.sendFullTitle(e.getPlayer(),20, 40, 20, "", "");
                }
            }, 20 * 10);

            Bukkit.getScheduler().runTaskLater(main, () -> {
                if(skillsManager.isMist(e.getPlayer())){
                    for(Player p : Bukkit.getOnlinePlayers()){
                        p.showPlayer(e.getPlayer());
                    }
                }
            }, 30 * 10);
        }
    }

    @EventHandler
    public void event(EntityDamageByEntityEvent e){
        Entity entity = e.getEntity();
        Entity damager = e.getDamager();

        if(entity instanceof Player && damager instanceof Player){
            if(skillsManager.isMist((Player) damager)){
                for (Player p : Bukkit.getOnlinePlayers()) {
                    p.showPlayer((Player) damager);
                }
                skillsManager.removeMist((Player) damager);
            }

            if(skillsManager.isMist((Player) entity)){
                for (Player p : Bukkit.getOnlinePlayers()) {
                    p.showPlayer((Player) entity);
                }
                skillsManager.removeMist((Player) entity);
            }
        }
    }
}
