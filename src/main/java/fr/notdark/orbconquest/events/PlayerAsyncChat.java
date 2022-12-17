package fr.notdark.orbconquest.events;

import fr.notdark.orbconquest.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class PlayerAsyncChat implements Listener {

    private final Main main;

    public PlayerAsyncChat(Main main) {
        this.main = main;
    }

    @EventHandler
    public void event(AsyncPlayerChatEvent e){
        //TODO
    }
}
