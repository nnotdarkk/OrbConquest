package fr.notdark.orbconquest.events.customs.handlers;

import fr.notdark.orbconquest.enums.GameSorts;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class ElementsEventHandler extends Event implements Cancellable {

    private static final HandlerList HANDLERS = new HandlerList();

    private boolean cancelled;
    private Player player;
    private GameSorts sorts;

    public ElementsEventHandler(Player player, GameSorts sorts) {
        cancelled = false;
        this.player = player;
        this.sorts = sorts;
    }

    public Player getPlayer() {
        return player;
    }

    public GameSorts getSkill() {
        return sorts;
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