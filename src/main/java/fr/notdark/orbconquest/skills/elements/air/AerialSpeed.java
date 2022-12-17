package fr.notdark.orbconquest.skills.elements.air;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

public class AerialSpeed implements Listener {

    public String getName() {
        return "§a§lAerial Speed";
    }

    @EventHandler
    public void event(PlayerInteractEvent e){
        if(e.getItem() == null) return;
        if(e.getItem().getItemMeta() == null) return;
        if(e.getItem().getItemMeta().getDisplayName() == null) return;

        if(e.getItem().getItemMeta().getDisplayName().equals(getName())){
            //TODO Augmente l'AGI de 40 pendant 10 secondes
        }
    }
}
