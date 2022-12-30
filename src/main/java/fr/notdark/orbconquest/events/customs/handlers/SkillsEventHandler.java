package fr.notdark.orbconquest.events.customs.handlers;

import fr.notdark.orbconquest.enums.GameSkills;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class SkillsEventHandler extends Event implements Cancellable {

    private static final HandlerList HANDLERS = new HandlerList();

    private boolean cancelled;
    private Player player;
    private GameSkills skill;

    public SkillsEventHandler(Player player, GameSkills skill) {
        cancelled = false;
        this.player = player;
        this.skill = skill;
    }

    public Player getPlayer() {
        return player;
    }

    public GameSkills getSkill() {
        return skill;
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
