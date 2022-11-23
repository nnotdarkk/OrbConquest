package fr.notdark.orbconquest.events;

import fr.notdark.orbconquest.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public class PlayerCancels implements Listener {

    private final Main main;

    public PlayerCancels(Main main) {
        this.main = main;
    }
}
