package fr.notdark.orbconquest.skills.elements.foudre;

import fr.notdark.orbconquest.Main;
import fr.notdark.orbconquest.enums.GameSorts;
import fr.notdark.orbconquest.events.customs.handlers.ElementsEventHandler;
import fr.notdark.orbconquest.managers.SkillsManager;
import fr.notdark.orbconquest.tools.Cuboid;
import fr.notdark.orbconquest.tools.Title;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;

public class ParalyzeShot implements Listener {

    private final Main main;

    public ParalyzeShot(Main main) {
        this.main = main;
    }

    public String getName() {
        return "§b§lParalyze Shot";
    }

    @EventHandler
    public void event(PlayerInteractEvent e){
        if(e.getItem() == null) return;
        if(e.getItem().getItemMeta() == null) return;
        if(e.getItem().getItemMeta().getDisplayName() == null) return;

        if(e.getItem().getItemMeta().getDisplayName().equals(getName())){

            ElementsEventHandler elementsEventHandler = new ElementsEventHandler(e.getPlayer(), GameSorts.ParalyzeShot);
            Bukkit.getPluginManager().callEvent(elementsEventHandler);

            Cuboid cuboid = new Cuboid(e.getPlayer().getLocation().add(15, 15, 15), e.getPlayer().getLocation().add(-15, -15, -15));
            for(Player p : Bukkit.getOnlinePlayers()){
                if(cuboid.contains(p.getLocation())){
                    if(p != e.getPlayer()){
                        SkillsManager skillsManager = new SkillsManager();
                        if(!skillsManager.isParalyzed(p)) {
                            skillsManager.addParalyzed(p);
                            Bukkit.getScheduler().runTaskLater(main, new Runnable() {
                                @Override
                                public void run() {
                                    skillsManager.removeParalyzed(p);
                                }
                            }, 100L);
                        }
                    }
                }
            }
        }
    }

    @EventHandler
    public void event(PlayerMoveEvent e){
        Player p = e.getPlayer();
        SkillsManager skillsManager = new SkillsManager();
        if(skillsManager.isParalyzed(p)){
            e.setCancelled(true);
            Title title = new Title();
            title.sendFullTitle(p, 5, 15, 5, "", "§bVous êtes paralysé !");
        }
    }

    @EventHandler
    public void event(EntityDamageByEntityEvent e){
        if(e.getEntity() instanceof Player){
            Player p = (Player) e.getEntity();
            Player damager = (Player) e.getDamager();
            if(damager == null) return;
            if(damager == p) return;
            SkillsManager skillsManager = new SkillsManager();
            if(skillsManager.isParalyzed(p) || skillsManager.isParalyzed(damager)){
                e.setCancelled(true);
            }
        }
    }
}
