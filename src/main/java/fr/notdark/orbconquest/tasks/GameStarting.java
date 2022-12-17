package fr.notdark.orbconquest.tasks;

import fr.notdark.orbconquest.Main;
import fr.notdark.orbconquest.enums.GameSelectMenu;
import fr.notdark.orbconquest.enums.GameStates;
import fr.notdark.orbconquest.tools.Title;
import fr.notdark.orbconquest.ui.ChoiceUI;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class GameStarting extends BukkitRunnable {

    private final Main main;
    private int timer = 10;

    public GameStarting(Main main) {
        this.main = main;
    }

    @Override
    public void run() {
        Title title = new Title();

        switch (timer) {
            case 10: case 5:
                for (Player p : Bukkit.getServer().getOnlinePlayers()) {
                    title.sendFullTitle(p, 5, 10, 5, "§a" + timer, " ");
                    Location loc = p.getLocation();
                    Bukkit.getWorld("world").playSound(loc, Sound.NOTE_PLING, 3.0F, 0.5F);
                }
                break;

            case 3: case 2:
                for (Player p : Bukkit.getServer().getOnlinePlayers()) {
                    title.sendFullTitle(p, 5, 10, 5, "§e" + timer, " ");
                    Location loc = p.getLocation();
                    Bukkit.getWorld("world").playSound(loc, Sound.NOTE_PLING, 3.0F, 0.5F);
                }
                break;

            case 1:
                for (Player p : Bukkit.getServer().getOnlinePlayers()) {
                    title.sendFullTitle(p, 5, 10, 5, "§c" + timer, " ");
                    Location loc = p.getLocation();
                    Bukkit.getWorld("world").playSound(loc, Sound.NOTE_PLING, 3.0F, 0.5F);
                }
                break;
        }

        if (timer == 0) {
            for (Player p : Bukkit.getServer().getOnlinePlayers()) {
                p.getInventory().clear();
                main.getGameManager().setSelectMenu(p, GameSelectMenu.Classe);
                SelectingMenus selectingMenus = new SelectingMenus(main);
                selectingMenus.runTaskTimer(main, 0, 10);
            }
            main.getGameManager().setGameState(GameStates.GAME);
            cancel();
        }

        timer--;
    }
}
