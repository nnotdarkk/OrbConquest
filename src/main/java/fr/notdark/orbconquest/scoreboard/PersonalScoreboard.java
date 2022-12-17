package fr.notdark.orbconquest.scoreboard;

import fr.notdark.orbconquest.Main;
import fr.notdark.orbconquest.config.ConfigManager;
import fr.notdark.orbconquest.config.user.UserManager;
import fr.notdark.orbconquest.enums.EnumsManager;
import fr.notdark.orbconquest.enums.GameStates;
import fr.notdark.orbconquest.managers.GameManager;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.UUID;

/*
 * This file is part of SamaGamesAPI.
 *
 * SamaGamesAPI is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * SamaGamesAPI is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with SamaGamesAPI.  If not, see <http://www.gnu.org/licenses/>.
 */
public class PersonalScoreboard {
    private Player player;
    private final UUID uuid;
    private final ObjectiveSign objectiveSign;

    private GameStates gameState;
    private Integer players;
    private String host;
    private String preTeam;

    PersonalScoreboard(Player player){
        this.player = player;
        uuid = player.getUniqueId();
        objectiveSign = new ObjectiveSign("sidebar", "Scoreboard");

        reloadData();
        objectiveSign.addReceiver(player);
    }

    public void reloadData(){
        Main main = Main.getInstance();
        GameManager gameManager = main.getGameManager();
        gameState = gameManager.getGameState();
        players = gameManager.getPlayers().size();
        host = gameManager.getHost();
        preTeam = gameManager.getPreGameTeam(player);
    }

    public void setLines(){
        objectiveSign.setDisplayName("§5§lOrb§7§lConquest");
        if(gameState == GameStates.GAME){
            objectiveSign.setLine(0, "§1");
            objectiveSign.setLine(1, " §7» §cJoueurs: §7" + players);
            objectiveSign.setLine(2, "§2");
            objectiveSign.setLine(3, "§5§lTemps");
            objectiveSign.setLine(4, "§7» §cFin de partie:§7 " + "10s");
            objectiveSign.setLine(5, "§7» §cRestitution:§7 " + "10s");
            objectiveSign.setLine(6, "§7» §cDécompte:§7 " + "10s");
            objectiveSign.setLine(7, "§3");
            objectiveSign.setLine(8, "§5§lMon équipe");
            objectiveSign.setLine(9, "§7» §cPoints:§6§l ");
            objectiveSign.setLine(10, "§7» §cOrbe:§f§l " + "↓" + " §7(§8" + "28" + " blocs§7)");
            objectiveSign.setLine(11, "§4");
            objectiveSign.setLine(12, "§7» §cClasse: §7");
            objectiveSign.setLine(13, "§7» §cÉlément: §7");

            objectiveSign.updateLines();
            return;
        }
        objectiveSign.setLine(0, "§1");
        objectiveSign.setLine(1, " §7» §cJoueurs: §7" + players);
        objectiveSign.setLine(2, "§2");
        objectiveSign.setLine(3, " §7» §cVotre équipe: " + preTeam);
        objectiveSign.setLine(4, " §7» §cHost: " + host);

        objectiveSign.updateLines();
    }

    public void onLogout(){
        objectiveSign.removeReceiver(Bukkit.getServer().getOfflinePlayer(uuid));
    }
}