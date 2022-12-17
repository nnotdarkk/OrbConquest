package fr.notdark.orbconquest.events.customs;

import fr.notdark.orbconquest.Main;
import fr.notdark.orbconquest.events.customs.handlers.SkillsEventHandler;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class SkillsEvent implements Listener {

    private final Main main;

    public SkillsEvent(Main main) {
        this.main = main;
    }

    @EventHandler
    public void event(SkillsEventHandler e){

    }

}
