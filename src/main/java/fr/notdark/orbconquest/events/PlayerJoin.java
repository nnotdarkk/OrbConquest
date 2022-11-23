package fr.notdark.orbconquest.events;

import fr.notdark.orbconquest.Main;
import fr.notdark.orbconquest.config.user.UserManager;
import fr.notdark.orbconquest.enums.GameStates;
import fr.notdark.orbconquest.managers.SkillsManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoin implements Listener {

    private final Main main;

    public PlayerJoin(Main main) {
        this.main = main;
    }

    @EventHandler
    public void event(PlayerJoinEvent e){
        Player player = e.getPlayer();
        new UserManager(main, player).setupPlayer();
        new SkillsManager().initPlayer(player);

        if(main.getGameManager().getGameState() == GameStates.LOBBY){
            main.getGameManager().addPlayer(player);
        }

        main.getScoreboardManager().onLogin(player);
    }
}
