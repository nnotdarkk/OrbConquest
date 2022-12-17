package fr.notdark.orbconquest.skills.elements.glace;

import fr.notdark.orbconquest.Main;
import fr.notdark.orbconquest.managers.SkillsManager;
import org.bukkit.entity.Player;
import org.bukkit.entity.Snowball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;

public class SnowBall implements Listener {

    private SkillsManager skillsManager;

    public SnowBall() {
        this.skillsManager = new SkillsManager();
    }

    public String getName() {
        return "§f§lSnow Ball";
    }

    @EventHandler
    public void event(PlayerInteractEvent e){
        if(e.getItem() == null) return;
        if(e.getItem().getItemMeta() == null) return;
        if(e.getItem().getItemMeta().getDisplayName() == null) return;

        Player player = e.getPlayer();

        if(e.getItem().getItemMeta().getDisplayName().equals(getName())){
            Snowball snowball = player.launchProjectile(Snowball.class);
            skillsManager.addProjectile(snowball.getUniqueId());
        }
    }

    @EventHandler
    public void event(EntityDamageByEntityEvent e){
        if (e.getDamager() instanceof Snowball && skillsManager.isProjectile(e.getDamager().getUniqueId()) && e.getEntity() instanceof Player) {
            if(e.getEntity() instanceof Player){
                //TODO reduire agi de 10
                skillsManager.addNoSkillsOrElements((Player) e.getEntity(), 5);
            }
            skillsManager.removeProjectile(e.getDamager().getUniqueId());
        }
    }

}
