package fr.notdark.orbconquest.events;

import fr.notdark.orbconquest.Main;
import fr.notdark.orbconquest.ui.ConfigUI;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

public class HostInteract implements Listener {

    private final Main main;

    public HostInteract(Main main) {
        this.main = main;
    }

    @EventHandler
    public void event(PlayerInteractEvent e){
        if(e.getItem() == null) return;
        if(e.getItem().getItemMeta() == null) return;
        if(e.getItem().getItemMeta().getDisplayName() == null) return;

        if(e.getItem().getItemMeta().getDisplayName().equals("§cParamètres §8▏ §7(Clique droit)")){
            ConfigUI configUI = new ConfigUI(main, e.getPlayer());
            configUI.openConfigUI();
        }

        if(e.getItem().getItemMeta().getDisplayName().equals("§aLancer la partie §8▏ §7(Clique droit)")){
            main.getGameManager().startGame();
            e.getPlayer().getInventory().setItem(7, main.getGameManager().getStopGameItem());
        }

        if(e.getItem().getItemMeta().getDisplayName().equals("§cArrêter la partie §8▏ §7(Clique droit)")){
            main.getGameManager().stopGameStarting();
            e.getPlayer().getInventory().setItem(7, main.getGameManager().getLaunchGameItem());
        }
    }
}
