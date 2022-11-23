package fr.notdark.orbconquest.skills.elements.feu;

import fr.notdark.orbconquest.enums.GameElements;
import fr.notdark.orbconquest.events.customs.handlers.ElementsEventHandler;
import fr.notdark.orbconquest.tools.Cuboid;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

public class HellAura implements Listener {

    public String getName() {
        return "§c§lHell Aura";
    }

    @EventHandler
    public void event(PlayerInteractEvent e){
        if(e.getItem() == null) return;
        if(e.getItem().getItemMeta() == null) return;
        if(e.getItem().getItemMeta().getDisplayName() == null) return;

        Player player = e.getPlayer();

        if(e.getItem().getItemMeta().getDisplayName().equals(getName())){


            ElementsEventHandler elementsEventHandler = new ElementsEventHandler(player, GameElements.HellAura);
            Bukkit.getPluginManager().callEvent(elementsEventHandler);

            Cuboid cuboid = new Cuboid(player.getLocation().add(10, 10, 10), player.getLocation().add(-10, -10, -10));
            for(Player p : Bukkit.getOnlinePlayers()){
                if(cuboid.contains(p.getLocation())){
                    if(p != player){
                        p.setFireTicks(120);
                    }
                }
            }
        }
    }
}
