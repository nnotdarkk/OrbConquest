package fr.notdark.orbconquest.events;

import fr.notdark.orbconquest.Main;
import fr.notdark.orbconquest.enums.GameStates;
import fr.notdark.orbconquest.managers.SkillsManager;
import fr.notdark.orbconquest.tools.NametagImpl;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoin implements Listener, NametagImpl {

    private final Main main;

    public PlayerJoin(Main main) {
        this.main = main;
    }

    @EventHandler
    public void event(PlayerJoinEvent e){
        Player player = e.getPlayer();
        new SkillsManager().initPlayer(player);

        player.setHealth(20);
        player.setFoodLevel(20);
        player.setExp(0);
        player.setLevel(0);
        player.setFireTicks(0);
        player.getInventory().clear();
        player.getInventory().setArmorContents(null);
        player.setGameMode(GameMode.SURVIVAL);
        player.teleport(Bukkit.getWorld("world").getSpawnLocation());

        if(main.getConfigManager().getString("host") != null){
            if(main.getConfigManager().getString("host").equals(player.getName())){
                player.getInventory().setItem(8, main.getGameManager().getOptionsHostItem());
                player.getInventory().setItem(7, main.getGameManager().getLaunchGameItem());
            }
        }

        if(main.getGameManager().getGameState() == GameStates.LOBBY){
            main.getGameManager().addPlayer(player);
            e.setJoinMessage("§a+ §e" + player.getName());
        }

        setNameTag(player, "preGame", "§7", null);
        main.getGameManager().initPlayer(player);
        main.getGameManager().initSelectMenu(player);
        main.getScoreboardManager().onLogin(player);
    }
}
