package fr.notdark_.nakimeparty.scoreboard;

import fr.notdark_.nakimeparty.Main;
import fr.notdark_.nakimeparty.enums.GameState;
import fr.notdark_.nakimeparty.manager.GameManager;
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

    private GameManager gameManager;
    private Main main = Main.getInstance();

    PersonalScoreboard(Player player){
        this.player = player;
        uuid = player.getUniqueId();
        objectiveSign = new ObjectiveSign("sidebar", "Scoreboard");

        reloadData();
        objectiveSign.addReceiver(player);
    }

    public void reloadData(){
        this.gameManager = new GameManager(main);
    }

    public void setLines(String ip){
        objectiveSign.setDisplayName("§9SpaceRush");
        if(gameManager.isState(GameState.GAME)){
            objectiveSign.setLine(0, "§1");
            objectiveSign.setLine(1, "§8▪ §7Equipe: " + gameManager.getTeamString(player));
            objectiveSign.setLine(2, "§2");
            objectiveSign.setLine(3, "§8▪ §7Demons restants: §c" + gameManager + "§7/§c100");
            objectiveSign.setLine(4, "§8▪ §7Slayers restants: §a" + gameManager. + "§7/§a100");
            objectiveSign.setLine(5, "§3");
            objectiveSign.setLine(6, "§8▪ §7Serveur: §a" + DNSpigotAPI.getInstance().getProcessName());
            objectiveSign.setLine(7, "§8▪ §7Connectés: §a" + connected);
            objectiveSign.setLine(8, "§4");
            objectiveSign.setLine(9, ip);

            objectiveSign.updateLines();
            return;
        }
        objectiveSign.setLine(0, "§1");
        objectiveSign.setLine(1, "§8▪ §7Staut: §9En attente");
        objectiveSign.setLine(2, "§2");
        objectiveSign.setLine(3, "§8▪ §7Serveur: §a" + DNSpigotAPI.getInstance().getProcessName());
        objectiveSign.setLine(4, "§8▪ §7Connectés: §a" + connected);
        objectiveSign.setLine(5, "§3");
        objectiveSign.setLine(6, ip);

        objectiveSign.updateLines();
    }

    public void onLogout(){
        objectiveSign.removeReceiver(Bukkit.getServer().getOfflinePlayer(uuid));
    }
}