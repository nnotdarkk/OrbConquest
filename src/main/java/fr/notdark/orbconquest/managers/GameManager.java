package fr.notdark.orbconquest.managers;

import fr.notdark.orbconquest.Main;
import fr.notdark.orbconquest.enums.GameSelectMenu;
import fr.notdark.orbconquest.enums.GameStates;
import fr.notdark.orbconquest.enums.GameTeams;
import fr.notdark.orbconquest.tasks.GameStarting;
import fr.notdark.orbconquest.tools.Title;
import fr.notdark.orbconquest.ui.ChoiceUI;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import fr.notdark.orbconquest.tools.ItemBuilder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GameManager {

    private GameStates gameState;

    private static List<Player> players = new ArrayList<>();
    private static HashMap<Player, GameTeams> playerPreGameTeam = new HashMap<>();
    private static HashMap<Player, GameSelectMenu> playerSelectMenu = new HashMap<>();
    private static HashMap<Player, Integer> playerUsedPointsStart = new HashMap<>();

    private int seconds;
    private int minutes;

    private final Main main;
    private GameStarting gameStarting;

    public GameManager(Main main) {
        this.main = main;
    }

    public void initPlayer(Player player){
        playerPreGameTeam.put(player, null);
        playerUsedPointsStart.put(player, 0);
    }

    public void setPreGameTeam(Player player, GameTeams team){
        playerPreGameTeam.put(player, team);
    }

    public String getPreGameTeam(Player player){
        if(playerPreGameTeam.get(player) == null) return "§cAucune";
        return playerPreGameTeam.get(player).toString();
    }

    public void removePreGameTeam(Player player){
        playerPreGameTeam.remove(player);
    }

    public void addPlayerUserPointsStart(Player player, int points){
        playerUsedPointsStart.put(player, playerUsedPointsStart.get(player) + points);
    }

    public int getPlayerUserPointsStart(Player player){
        return playerUsedPointsStart.get(player);
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

    public String getHost(){
        if(main.getConfigManager().getString("host") == null) {
            return "Aucun";
        } else {
            return "§a" + main.getConfigManager().getString("host");
        }
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

    public void initSelectMenu(Player player){
        playerSelectMenu.put(player, null);
    }

    public void setSelectMenu(Player player, GameSelectMenu menu){
        playerSelectMenu.put(player, menu);
    }

    public GameSelectMenu getSelectMenu(Player player){
        return playerSelectMenu.get(player);
    }

    public List<String> getSelectMenuNames(){
        List<String> list = new ArrayList<>();

        list.add("Choix de la classe");
        list.add("Points de statistiques");
        list.add("Choix des classe");
        list.add("Choix des éléments");
        list.add("Choix des sorts");
        list.add("Choix des skills de classe");
        list.add("Choix des skills classiques");

        return list;
    }

    public List<Player> getPlayersInSelectMenu(){
        List<Player> players = new ArrayList<>();
        for(Player player : playerSelectMenu.keySet()){
            if(playerSelectMenu.get(player) != null){
                players.add(player);
            }
        }
        return players;
    }

    public Inventory getInventoryFromSelectMenu(Player player){
        ChoiceUI choiceUI = new ChoiceUI(main);
        if(playerSelectMenu.get(player) == GameSelectMenu.Classe) return choiceUI.getClasseUI();
        if(playerSelectMenu.get(player) == GameSelectMenu.Statistiques) return choiceUI.getStatistiquesUI(player);
        if(playerSelectMenu.get(player) == GameSelectMenu.Elements) return choiceUI.getElementsUI();
        if(playerSelectMenu.get(player) == GameSelectMenu.SkillsClasse) return choiceUI.getSkillsClasseUI();
        if(playerSelectMenu.get(player) == GameSelectMenu.SkillsClassiques) return choiceUI.getSkillsClassiquesUI();
        return null;
    }
    public void startGame(){
        setGameState(GameStates.STARTING);
        gameStarting = new GameStarting(main);
        gameStarting.runTaskTimer(main, 0, 20);
    }

    public void stopGameStarting(){
        gameStarting.cancel();
        for (Player player : players) {
            Title title = new Title();
            title.sendFullTitle(player, 20, 40, 20, "", "§cPartie annulée");
        }
    }
}
