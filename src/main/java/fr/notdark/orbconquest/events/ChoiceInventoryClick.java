package fr.notdark.orbconquest.events;

import fr.notdark.orbconquest.Main;
import fr.notdark.orbconquest.config.user.UserManager;
import fr.notdark.orbconquest.enums.GameClasses;
import fr.notdark.orbconquest.enums.GameElements;
import fr.notdark.orbconquest.enums.GameSelectMenu;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ChoiceInventoryClick implements Listener {

    private final Main main;

    public ChoiceInventoryClick(Main main) {
        this.main = main;
    }

    @EventHandler
    public void event(InventoryClickEvent e){
        if(e.getCurrentItem() == null) return;
        if(e.getCurrentItem().getItemMeta() == null) return;
        if(e.getCurrentItem().getItemMeta().getDisplayName() == null) return;

        Player player = (Player) e.getWhoClicked();
        UserManager um = new UserManager(main, player);
        if(e.getInventory().getTitle().equals("Choix de la classe")){
            switch (e.getSlot()){
                case 20:
                    main.getGameManager().setSelectMenu(player, GameSelectMenu.Statistiques);
                    player.closeInventory();
                    um.setClasse(GameClasses.Guerrier);
                    um.setInt("str", main.getClassesManager().getInt("guerrier.str"));
                    um.setInt("res", main.getClassesManager().getInt("guerrier.res"));
                    um.setInt("agi", main.getClassesManager().getInt("guerrier.agi"));
                    um.setInt("hp", main.getClassesManager().getInt("guerrier.hp"));
                    um.setInt("mp", main.getClassesManager().getInt("guerrier.mp"));
                    //Guerrier
                    break;
                case 21:
                    main.getGameManager().setSelectMenu(player, GameSelectMenu.Statistiques);
                    player.closeInventory();
                    um.setClasse(GameClasses.Tank);
                    um.setInt("str", main.getClassesManager().getInt("tank.str"));
                    um.setInt("res", main.getClassesManager().getInt("tank.res"));
                    um.setInt("agi", main.getClassesManager().getInt("tank.agi"));
                    um.setInt("hp", main.getClassesManager().getInt("tank.hp"));
                    um.setInt("mp", main.getClassesManager().getInt("tank.mp"));
                    //Tank
                    break;
                case 22:
                    main.getGameManager().setSelectMenu(player, GameSelectMenu.Statistiques);
                    player.closeInventory();
                    um.setClasse(GameClasses.Mage);
                    um.setInt("str", main.getClassesManager().getInt("mage.str"));
                    um.setInt("res", main.getClassesManager().getInt("mage.res"));
                    um.setInt("agi", main.getClassesManager().getInt("mage.agi"));
                    um.setInt("hp", main.getClassesManager().getInt("mage.hp"));
                    um.setInt("mp", main.getClassesManager().getInt("mage.mp"));
                    //Mage
                    break;
                case 23:
                    main.getGameManager().setSelectMenu(player, GameSelectMenu.Statistiques);
                    player.closeInventory();
                    um.setClasse(GameClasses.Invocateur);
                    um.setInt("str", main.getClassesManager().getInt("invocateur.str"));
                    um.setInt("res", main.getClassesManager().getInt("invocateur.res"));
                    um.setInt("agi", main.getClassesManager().getInt("invocateur.agi"));
                    um.setInt("hp", main.getClassesManager().getInt("invocateur.hp"));
                    um.setInt("mp", main.getClassesManager().getInt("invocateur.mp"));
                    //Invocateur
                    break;
                case 24:
                    main.getGameManager().setSelectMenu(player, GameSelectMenu.Statistiques);
                    player.closeInventory();
                    um.setClasse(GameClasses.Support);
                    um.setInt("str", main.getClassesManager().getInt("support.str"));
                    um.setInt("res", main.getClassesManager().getInt("support.res"));
                    um.setInt("agi", main.getClassesManager().getInt("support.agi"));
                    um.setInt("hp", main.getClassesManager().getInt("support.hp"));
                    um.setInt("mp", main.getClassesManager().getInt("support.mp"));
                    //Support
                    break;
                case 30:
                    main.getGameManager().setSelectMenu(player, GameSelectMenu.Statistiques);
                    player.closeInventory();
                    um.setClasse(GameClasses.Archer);
                    um.setInt("str", main.getClassesManager().getInt("archer.str"));
                    um.setInt("res", main.getClassesManager().getInt("archer.res"));
                    um.setInt("agi", main.getClassesManager().getInt("archer.agi"));
                    um.setInt("hp", main.getClassesManager().getInt("archer.hp"));
                    um.setInt("mp", main.getClassesManager().getInt("archer.mp"));
                    //Archer
                    break;
                case 32:
                    main.getGameManager().setSelectMenu(player, GameSelectMenu.Statistiques);
                    player.closeInventory();
                    um.setClasse(GameClasses.Assassin);
                    um.setInt("str", main.getClassesManager().getInt("assassin.str"));
                    um.setInt("res", main.getClassesManager().getInt("assassin.res"));
                    um.setInt("agi", main.getClassesManager().getInt("assassin.agi"));
                    um.setInt("hp", main.getClassesManager().getInt("assassin.hp"));
                    um.setInt("mp", main.getClassesManager().getInt("assassin.mp"));
                    //Assassin
                    break;
            }
            e.setCancelled(true);
        }
        if(e.getInventory().getTitle().equals("Points de statistiques")){
            switch (e.getSlot()){
                case 20:
                    um.setInt("str", um.getInt("str") + 10);
                    main.getGameManager().addPlayerUserPointsStart(player, 10);
                    checkPointsStats(player);
                    break;
                case 30:
                    um.setInt("res", um.getInt("res") + 10);
                    main.getGameManager().addPlayerUserPointsStart(player, 10);
                    checkPointsStats(player);
                    break;
                case 22:
                    um.setInt("agi", um.getInt("agi") + 10);
                    main.getGameManager().addPlayerUserPointsStart(player, 10);
                    checkPointsStats(player);
                    break;
                case 32:
                    um.setInt("hp", um.getInt("hp") + 10);
                    main.getGameManager().addPlayerUserPointsStart(player, 10);
                    checkPointsStats(player);
                    break;
                case 24:
                    um.setInt("mp", um.getInt("mp") + 10);
                    main.getGameManager().addPlayerUserPointsStart(player, 10);
                    checkPointsStats(player);
                    break;
            }
            player.closeInventory();
            e.setCancelled(true);
        }

        if(e.getInventory().getTitle().equals("Choix des éléments")){
            List<GameElements> elements = um.getElements();
            switch (e.getSlot()){
                case 21:
                    if(!elements.contains(GameElements.Feu)){
                        elements.add(GameElements.Feu);
                        um.setElements(elements);
                        main.getGameManager().addPlayerUsedElementsPointsStart(player, 1);
                        checkPointsElements(player);
                    }
                    break;
                case 23:
                    if(!elements.contains(GameElements.Foudre)){
                        elements.add(GameElements.Foudre);
                        um.setElements(elements);
                        main.getGameManager().addPlayerUsedElementsPointsStart(player, 1);
                        checkPointsElements(player);
                    }
                    break;
                case 29:
                    if(!elements.contains(GameElements.Glace)){
                        elements.add(GameElements.Glace);
                        um.setElements(elements);
                        main.getGameManager().addPlayerUsedElementsPointsStart(player, 1);
                        checkPointsElements(player);
                    }
                    break;
                case 30:
                    if(!elements.contains(GameElements.Air)){
                        elements.add(GameElements.Air);
                        um.setElements(elements);
                        main.getGameManager().addPlayerUsedElementsPointsStart(player, 1);
                        checkPointsElements(player);
                    }
                    break;
                case 31:
                    if(!elements.contains(GameElements.Poison)){
                        elements.add(GameElements.Poison);
                        um.setElements(elements);
                        main.getGameManager().addPlayerUsedElementsPointsStart(player, 1);
                        checkPointsElements(player);
                    }
                    break;
                case 32:
                    if(!elements.contains(GameElements.Lumiere)){
                        elements.add(GameElements.Lumiere);
                        um.setElements(elements);
                        main.getGameManager().addPlayerUsedElementsPointsStart(player, 1);
                        checkPointsElements(player);
                    }
                    break;
                case 33:
                    if(!elements.contains(GameElements.Invocation)){
                        elements.add(GameElements.Invocation);
                        um.setElements(elements);
                        main.getGameManager().addPlayerUsedElementsPointsStart(player, 1);
                        checkPointsElements(player);
                    }
                    break;
            }

            player.closeInventory();
            e.setCancelled(true);
        }

        if(e.getInventory().getTitle().equals("Choix des sorts")){

        }
    }

    public void checkPointsElements(Player player){
        UserManager um = new UserManager(main, player);
        String classe = um.getClasse().toString().toLowerCase(Locale.ROOT);
        int i = main.getGameManager().getPlayerUsedElementsPointsStart(player);
        int a = main.getClassesManager().getInt(classe + ".elementsMax");

        if(i >= a) {
            main.getGameManager().setSelectMenu(player, GameSelectMenu.Sorts);
            player.closeInventory();
        }
    }

    private void checkPointsStats(Player player){
        int i = main.getConfigManager().getInt("players-points-start");
        int a = main.getGameManager().getPlayerUserPointsStart(player);

        if(a >= i){
            main.getGameManager().setSelectMenu(player, GameSelectMenu.Elements);
            player.closeInventory();
        }
    }
}
