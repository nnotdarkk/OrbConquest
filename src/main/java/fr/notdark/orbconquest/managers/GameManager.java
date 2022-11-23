package fr.notdark.orbconquest.manager;

import fr.notdark.orbconquest.enums.GameStates;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import fr.notdark.orbconquest.tools.ItemBuilder;

import java.util.List;

public class GameManager {

    private GameStates gameState;

    private List<Player> players;

    private int seconds;
    private int minutes;

    public GameManager(){

    }

    public GameStates getGameState() {
        return gameState;
    }

    public void setGameState(GameStates gameState) {
        this.gameState = gameState;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void addPlayer(Player player){
        players.add(player);
    }

    public void removePlayer(Player player){
        players.remove(player);
    }

    public int getSeconds() {
        return seconds;
    }

    public void setSeconds(int seconds) {
        this.seconds = seconds;
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public ItemStack getOptionsHostItem(){
        return new ItemBuilder(Material.REDSTONE_COMPARATOR).setDisplayName("§cParamètres §8▏ §7(Clique droit)").build(false);
    }

    public ItemStack getLaunchGameItem(){
        return new ItemBuilder(Material.INK_SACK, 1, (short) 10).setDisplayName("§aLancer la partie §8▏ §7(Clique droit)").build(false);
    }

    public ItemStack getStopGameItem(){
        return new ItemBuilder(Material.INK_SACK, 1, (short) 1).setDisplayName("§cArrêter la partie §8▏ §7(Clique droit)").build(false);
    }
}
