package fr.notdark.orbconquest.events.customs;

import fr.notdark.orbconquest.Main;
import fr.notdark.orbconquest.events.customs.handlers.ElementsEventHandler;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class ElementsEvent implements Listener {

    private final Main main;

    public ElementsEvent(Main main) {
        this.main = main;
    }

    @EventHandler
    public void event(ElementsEventHandler e){

    }

}
