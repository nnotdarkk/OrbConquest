package fr.notdark.orbconquest.events;

import fr.notdark.orbconquest.Main;
import fr.notdark.orbconquest.config.ConfigManager;
import fr.notdark.orbconquest.enums.GameCreationMode;
import fr.notdark.orbconquest.ui.ConfigUI;
import org.bukkit.Effect;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;

public class HostInventoryClick implements Listener {

    private final Main main;

    public HostInventoryClick(Main main) {
        this.main = main;
    }

    @EventHandler
    public void event(InventoryClickEvent e){
        if(e.getCurrentItem() == null) return;
        if(e.getCurrentItem().getItemMeta() == null) return;
        if(e.getCurrentItem().getItemMeta().getDisplayName() == null) return;

        if(e.getInventory().getTitle().equals("Configuration")){
            e.setCancelled(true);
            ClickType clickType = e.getClick();
            if(e.getCurrentItem() == null || e.getCurrentItem().getType() == Material.AIR) return;

            switch (e.getCurrentItem().getItemMeta().getDisplayName()){
                case "§eTemps de partie":
                    e.getWhoClicked().getWorld().playEffect(e.getWhoClicked().getLocation(), Effect.CLICK1, 1);
                    switch (clickType){
                        case LEFT:
                            addInt("temps-partie", 1);
                            break;
                        case RIGHT:
                            removeInt("temps-partie", 1);
                            break;
                        case SHIFT_LEFT:
                            addInt("temps-partie", 5);
                            break;
                        case SHIFT_RIGHT:
                            removeInt("temps-partie", 5);
                            break;
                    }
                    break;

                case "§9Temps de préparation":
                    e.getWhoClicked().getWorld().playEffect(e.getWhoClicked().getLocation(), Effect.CLICK1, 1);
                    switch (clickType){
                        case LEFT:
                            addInt("temps-prep", 1);
                            break;
                        case RIGHT:
                            removeInt("temps-prep", 1);
                            break;
                        case SHIFT_LEFT:
                            addInt("temps-prep", 5);
                            break;
                        case SHIFT_RIGHT:
                            removeInt("temps-prep", 5);
                            break;
                    }
                    break;

                case "§fTemps entre calculs":
                    e.getWhoClicked().getWorld().playEffect(e.getWhoClicked().getLocation(), Effect.CLICK1, 1);
                    switch (clickType){
                        case LEFT:
                            addInt("temps-calcul-point", 1);
                            break;
                        case RIGHT:
                            removeInt("temps-calcul-point", 1);
                            break;
                        case SHIFT_LEFT:
                            addInt("temps-calcul-point", 5);
                            break;
                        case SHIFT_RIGHT:
                            removeInt("temps-calcul-point", 5);
                            break;
                    }
                    break;

                case "§3Temps entre restitutions":
                    e.getWhoClicked().getWorld().playEffect(e.getWhoClicked().getLocation(), Effect.CLICK1, 1);
                    switch (clickType){
                        case LEFT:
                            addInt("temps-restitution-orbe", 1);
                            break;
                        case RIGHT:
                            removeInt("temps-restitution-orbe", 1);
                            break;
                        case SHIFT_LEFT:
                            addInt("temps-restitution-orbe", 5);
                            break;
                        case SHIFT_RIGHT:
                            removeInt("temps-restitution-orbe", 5);
                            break;
                    }
                    break;

                case "§bTemps entre scores":
                    e.getWhoClicked().getWorld().playEffect(e.getWhoClicked().getLocation(), Effect.CLICK1, 1);
                    switch (clickType){
                        case LEFT:
                            addInt("temps-info-chat", 1);
                            break;
                        case RIGHT:
                            removeInt("temps-info-chat", 1);
                            break;
                        case SHIFT_LEFT:
                            addInt("temps-info-chat", 5);
                            break;
                        case SHIFT_RIGHT:
                            removeInt("temps-info-chat", 5);
                            break;
                    }
                    break;

                case "§aPoints obtenus (Notre orbe)":
                    e.getWhoClicked().getWorld().playEffect(e.getWhoClicked().getLocation(), Effect.CLICK1, 1);
                    switch (clickType){
                        case LEFT:
                            addInt("points-notre-orbe", 1);
                            break;
                        case RIGHT:
                            removeInt("points-notre-orbe", 1);
                            break;
                    }
                    break;

                case "§2Points obtenus (Orbe adverse)":
                    e.getWhoClicked().getWorld().playEffect(e.getWhoClicked().getLocation(), Effect.CLICK1, 1);
                    switch (clickType){
                        case LEFT:
                            addInt("points-orbe-adverse", 1);
                            break;
                        case RIGHT:
                            removeInt("points-orbe-adverse", 1);
                            break;
                    }
                    break;

                case "§6Rayon de spawn":
                    e.getWhoClicked().getWorld().playEffect(e.getWhoClicked().getLocation(), Effect.CLICK1, 1);
                    switch (clickType){
                        case LEFT:
                            addInt("rayon-de-spawn", 50);
                            break;
                        case RIGHT:
                            removeInt("rayon-de-spawn", 50);
                            break;
                        case SHIFT_LEFT:
                            addInt("rayon-de-spawn", 100);
                            break;
                        case SHIFT_RIGHT:
                            removeInt("rayon-de-spawn", 100);
                            break;
                    }
                    break;

                case "§dJoueurs par équipe":
                    e.getWhoClicked().getWorld().playEffect(e.getWhoClicked().getLocation(), Effect.CLICK1, 1);
                    switch (clickType){
                        case LEFT:
                            addInt("players-per-team", 1);
                            break;
                        case RIGHT:
                            removeInt("players-per-team", 1);
                            break;
                    }
                    break;

                case "§eMode de création":
                    e.getWhoClicked().getWorld().playEffect(e.getWhoClicked().getLocation(), Effect.CLICK1, 1);
                    switch (clickType){
                        case LEFT:
                            goNext();
                            break;
                        case RIGHT:
                            goPrevious();
                            break;
                    }
                    break;

                case "§2Statistiques à attribuer":
                    e.getWhoClicked().getWorld().playEffect(e.getWhoClicked().getLocation(), Effect.CLICK1, 1);
                    switch (clickType){
                        case LEFT:
                            addInt("players-points-start", 10);
                            break;
                        case RIGHT:
                            removeInt("players-points-start", 10);
                            break;
                    }
                    break;

                case "§9Cycle jour/nuit":
                    e.getWhoClicked().getWorld().playEffect(e.getWhoClicked().getLocation(), Effect.CLICK1, 1);
                    switch (clickType){
                        case LEFT:
                            addInt("cycle-jour-nuit", 5);
                            break;
                        case RIGHT:
                            removeInt("cycle-jour-nuit", 5);
                            break;
                    }
                    break;

                case "§cRetour":
                    e.getWhoClicked().closeInventory();
                    break;
            }

            ConfigUI configUI = new ConfigUI(main, (Player) e.getWhoClicked());
            configUI.openConfigUI();
        }
    }

    private void addInt(String string, int i){
        main.getConfigManager().setInt(string, main.getConfigManager().getInt(string) + i);
    }

    private void removeInt(String string, int i){
        main.getConfigManager().setInt(string, main.getConfigManager().getInt(string) - i);

        if(string == "temps-info-chat"){
            if(main.getConfigManager().getInt(string) < -1){
                main.getConfigManager().setInt(string, -1);
            }
            return;
        }
        if(main.getConfigManager().getInt(string) < 0){
            main.getConfigManager().setInt(string, 0);
        }
    }

    private void goNext(){
        String string = main.getConfigManager().getString("creation-mode");
        GameCreationMode gcm = main.getEnumsManager().getCreationMode(string);
        main.getServer().getConsoleSender().sendMessage(string);
        main.getServer().getConsoleSender().sendMessage(gcm.toString());
        switch (gcm){
            case Choosen:
                main.getConfigManager().setString("creation-mode", GameCreationMode.Random.toString());
                main.getServer().getConsoleSender().sendMessage("n1");
            case Random:
                main.getConfigManager().setString("creation-mode", GameCreationMode.Captains.toString());
                main.getServer().getConsoleSender().sendMessage("n2");
            case Captains:
                main.getConfigManager().setString("creation-mode", GameCreationMode.Choosen.toString());
                main.getServer().getConsoleSender().sendMessage("n3");
        }
    }

    private void goPrevious(){
        String string = main.getConfigManager().getString("creation-mode");
        GameCreationMode gcm = main.getEnumsManager().getCreationMode(string);
        main.getServer().getConsoleSender().sendMessage(string);
        main.getServer().getConsoleSender().sendMessage(gcm.toString());
        switch (gcm){
            case Choosen:
                main.getConfigManager().setString("creation-mode", GameCreationMode.Captains.toString());
                main.getServer().getConsoleSender().sendMessage("p1");
            case Random:
                main.getConfigManager().setString("creation-mode", GameCreationMode.Choosen.toString());
                main.getServer().getConsoleSender().sendMessage("p2");
            case Captains:
                main.getConfigManager().setString("creation-mode", GameCreationMode.Random.toString());
                main.getServer().getConsoleSender().sendMessage("p3");
        }
    }
}
