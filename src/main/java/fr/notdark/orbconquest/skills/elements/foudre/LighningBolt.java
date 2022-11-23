package fr.notdark.orbconquest.skills.elements.foudre;

import fr.notdark.orbconquest.enums.GameElements;
import fr.notdark.orbconquest.events.customs.handlers.ElementsEventHandler;
import fr.notdark.orbconquest.tools.Cuboid;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

public class LighningBolt implements Listener {

    public String getName() {
        return "§b§lLightning Bolt";
    }

    @EventHandler
    public void event(PlayerInteractEvent e){
        if(e.getItem() == null) return;
        if(e.getItem().getItemMeta() == null) return;
        if(e.getItem().getItemMeta().getDisplayName() == null) return;

        if(e.getItem().getItemMeta().getDisplayName().equals(getName())){

            ElementsEventHandler elementsEventHandler = new ElementsEventHandler(e.getPlayer(), GameElements.LightningBolt);
            Bukkit.getPluginManager().callEvent(elementsEventHandler);

            Cuboid cuboid = new Cuboid(e.getPlayer().getLocation().add(10, 10, 10), e.getPlayer().getLocation().add(-10, -10, -10));
            for(Player p : Bukkit.getOnlinePlayers()){
                if(cuboid.contains(p.getLocation())){
                    if(p != e.getPlayer()){
                        p.getWorld().strikeLightning(p.getLocation());

                        //TODO réduisant l' AGI de 20 pendant 5 secondes
                    }
                }
            }
        }
    }
}
