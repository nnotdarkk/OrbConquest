package fr.notdark.orbconquest.events;

import fr.notdark.orbconquest.Main;
import fr.notdark.orbconquest.enums.GameSelectMenu;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

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
        if(e.getInventory().getTitle().equals("Choix de la classe")){
            switch (e.getSlot()){
                case 20:
                    main.getGameManager().setSelectMenu(player, GameSelectMenu.Statistiques);
                    //Guerrier
                    break;
                case 21:
                    main.getGameManager().setSelectMenu(player, GameSelectMenu.Statistiques);
                    //Tank
                    break;
                case 22:
                    main.getGameManager().setSelectMenu(player, GameSelectMenu.Statistiques);
                    //Mage
                    break;
                case 23:
                    main.getGameManager().setSelectMenu(player, GameSelectMenu.Statistiques);
                    //Invocateur
                    break;
                case 24:
                    main.getGameManager().setSelectMenu(player, GameSelectMenu.Statistiques);
                    //Support
                    break;
                case 30:
                    main.getGameManager().setSelectMenu(player, GameSelectMenu.Statistiques);
                    //Archer
                    break;
                case 32:
                    main.getGameManager().setSelectMenu(player, GameSelectMenu.Statistiques);
                    //Assassin
                    break;
            }
            e.setCancelled(true);
        }
    }
}
