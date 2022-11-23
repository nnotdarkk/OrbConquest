package fr.notdark.orbconquest.events;

import fr.notdark.orbconquest.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

public class HostInteract implements Listener {

    private final Main main;

    public HostInteract(Main main) {
        this.main = main;
    }

    @EventHandler
    public void event(PlayerInteractEvent e){

    }
}
