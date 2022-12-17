package fr.notdark.orbconquest.skills.elements.foudre;

import fr.notdark.orbconquest.Main;
import fr.notdark.orbconquest.enums.GameElements;
import fr.notdark.orbconquest.events.customs.handlers.ElementsEventHandler;
import fr.notdark.orbconquest.managers.SkillsManager;
import fr.notdark.orbconquest.tools.Cuboid;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.util.Vector;

public class ThunderCharge implements Listener {

    private final Main main;

    private SkillsManager skillsManager;

    public ThunderCharge(Main main) {
        this.main = main;
        skillsManager = new SkillsManager();
    }

    public String getName() {
        return "§b§lThunder Charge";
    }

    @EventHandler
    public void event(PlayerInteractEvent e){
        if(e.getItem() == null) return;
        if(e.getItem().getItemMeta() == null) return;
        if(e.getItem().getItemMeta().getDisplayName() == null) return;

        Player player = e.getPlayer();

        if(e.getItem().getItemMeta().getDisplayName().equals(getName())){

            ElementsEventHandler elementsEventHandler = new ElementsEventHandler(player, GameElements.ThunderCharge);
            Bukkit.getPluginManager().callEvent(elementsEventHandler);

            if(!player.isOnGround()){
                player.sendMessage("§cVous devez être au sol pour utiliser cette compétence !");
                return;
            }

            Vector unitVector = new Vector(player.getLocation().getDirection().getX(), 0, player.getLocation().getDirection().getZ());
            unitVector = unitVector.normalize();
            player.setVelocity(unitVector.multiply(15));

            skillsManager.addThunderCharge(player);
            Bukkit.getScheduler().runTaskLater(main, () -> skillsManager.removeThunderCharge(player), 20L);
        }
    }

    @EventHandler
    public void event(PlayerMoveEvent e){
        if(skillsManager.isInFlareAccel(e.getPlayer())){
            Cuboid cuboid = new Cuboid(e.getPlayer().getLocation().add(2, 2, 2), e.getPlayer().getLocation().add(-2, -2, -2));
            for(Player p : Bukkit.getOnlinePlayers()){
                Location l = p.getLocation();
                if(cuboid.contains(l)){
                    if(p == e.getPlayer()){
                        return;
                    }

                    SkillsManager skillsManager = new SkillsManager();
                    if(skillsManager.isThunderedByThunderCharge(p)){
                        return;
                    }
                    p.getWorld().strikeLightning(p.getLocation());
                    skillsManager.addThunderedByThunderCharge(p);
                    Bukkit.getScheduler().runTaskLater(main, () -> skillsManager.removeThunderedByThunderCharge(p), 20L);
                }
            }
        }
    }
}
