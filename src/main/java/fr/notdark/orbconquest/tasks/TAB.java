package fr.notdark.orbconquest.tasks;

import fr.notdark.orbconquest.Main;
import fr.notdark.orbconquest.tools.Title;
import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class TAB extends BukkitRunnable {

    private final Main main;

    public TAB(Main main) {
        this.main = main;
    }

    @Override
    public void run() {
        Title title = new Title();
        for (Player player : Bukkit.getOnlinePlayers()) {
            switch (main.getGameManager().getGameState()) {
                case LOBBY:
                case STARTING:
                    title.sendTabTitle(player, "§5§lOrb§7§lConquest\n ", "\n§7Ping: §6" + ((CraftPlayer)player).getHandle().ping + " §8▏ §7TPS: §e" + new Lag().getTPS() + "\n§7(Dev by Karam)");
                    break;
                case GAME:
                    title.sendTabTitle(player, "§5§lOrb§7§lConquest\n ", "\n§7Ping: §6" + ((CraftPlayer)player).getHandle().ping + " §8▏ §7TPS: §e" + new Lag().getTPS() + "\n§7(Dev by Karam)");
                    break;
                case END:
                    title.sendTabTitle(player, "§5§lOrb§7§lConquest\n ", "\n§7Ping: §6" + ((CraftPlayer)player).getHandle().ping + " §8▏ §7TPS: §e" + new Lag().getTPS() + "\n§7(Dev by Karam)");
                    break;
            }
        }
    }
}
