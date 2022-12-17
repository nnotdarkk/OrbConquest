package fr.notdark.orbconquest.tools;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

import java.util.Iterator;

public interface NametagImpl {

    default void setNameTag(Player player, String teamName, String prefix, String suffix) {
        Scoreboard score = Bukkit.getScoreboardManager().getMainScoreboard();
        Team t = score.getTeam(teamName);
        if (t == null) {
            t = score.registerNewTeam(teamName);
        }

        if (prefix != null) {
            t.setPrefix(prefix);
        }

        if (suffix != null) {
            t.setSuffix(suffix);
        }

        t.addPlayer(player);
        Iterator var7 = Bukkit.getOnlinePlayers().iterator();

        while(var7.hasNext()) {
            Player players = (Player)var7.next();
            players.setScoreboard(score);
        }

    }

    default void removeNameTag(Player player, String teamName) {
        Scoreboard score = Bukkit.getScoreboardManager().getMainScoreboard();
        Team t = score.getTeam(teamName);
        if (t == null) {
            t = score.registerNewTeam(teamName);
        }

        t.removePlayer(player);
        Iterator var5 = Bukkit.getOnlinePlayers().iterator();

        while(var5.hasNext()) {
            Player players = (Player)var5.next();
            players.setScoreboard(score);
        }

    }
}
