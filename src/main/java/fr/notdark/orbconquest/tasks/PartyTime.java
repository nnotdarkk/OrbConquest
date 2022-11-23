package fr.notdark.orbconquest.task;

import fr.notdark.orbconquest.Main;
import org.bukkit.scheduler.BukkitRunnable;

public class PartyTime extends BukkitRunnable {

    private final Main main;
    private int seconds;
    private int minutes;

    public PartyTime(Main main) {
        this.main = main;
        this.seconds = main.getGameManager().getSeconds();
        this.minutes = main.getGameManager().getMinutes();
    }

    @Override
    public void run() {
        if(seconds == 60) {
            seconds = 0;
            main.getGameManager().setSeconds(seconds);
            minutes++;
            main.getGameManager().setMinutes(minutes);
        }

        seconds++;
        main.getGameManager().setSeconds(seconds);
    }
}
