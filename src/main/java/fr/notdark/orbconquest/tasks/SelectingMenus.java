package fr.notdark.orbconquest.tasks;

import fr.notdark.orbconquest.Main;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class SelectingMenus extends BukkitRunnable {

    private final Main main;

    public SelectingMenus(Main main) {
        this.main = main;
    }

    @Override
    public void run() {
        for(Player player : main.getGameManager().getPlayersInSelectMenu()){
            String menu = player.getOpenInventory().getTitle();
            if(!(main.getGameManager().getSelectMenuNames().contains(menu))){
                player.openInventory(main.getGameManager().getInventoryFromSelectMenu(player));
            }
        }
    }
}
