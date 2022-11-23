package fr.notdark.orbconquest.events;

import fr.notdark.orbconquest.Main;
import fr.notdark.orbconquest.enums.GameStates;
import fr.notdark.orbconquest.managers.SkillsManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerQuit implements Listener {

    private final Main main;

    public PlayerQuit(Main main) {
        this.main = main;
    }

    @EventHandler
    public void event(PlayerQuitEvent e){
        Player player = e.getPlayer();
        new SkillsManager().clearPlayer(player);

        if(main.getGameManager().getGameState() == GameStates.LOBBY){
            main.getGameManager().removePlayer(player);
        }

        main.getScoreboardManager().onLogout(player);
    }
}
