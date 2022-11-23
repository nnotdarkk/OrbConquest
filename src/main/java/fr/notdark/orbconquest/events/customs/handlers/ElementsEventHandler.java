package fr.notdark.orbconquest.events.customs.handlers;

import fr.notdark.orbconquest.enums.GameElements;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class ElementsEventHandler extends Event implements Cancellable {

    private static final HandlerList HANDLERS = new HandlerList();

    private boolean cancelled;
    private Player player;
    private GameElements elements;

    public ElementsEventHandler(Player player, GameElements skill) {
        cancelled = false;
        this.player = player;
        this.elements = elements;
    }

    public Player getPlayer() {
        return player;
    }

    public GameElements getSkill() {
        return elements;
    }

    @Override
    public HandlerList getHandlers() {
        return HANDLERS;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS;
    }

    @Override
    public boolean isCancelled() {
        return cancelled;
    }

    @Override
    public void setCancelled(boolean b) {
        this.cancelled = b;
    }
}