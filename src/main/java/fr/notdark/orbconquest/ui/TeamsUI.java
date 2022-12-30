package fr.notdark.orbconquest.ui;

import fr.notdark.orbconquest.Main;
import fr.notdark.orbconquest.tools.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class TeamsUI {

    private final Main main;
    private final Player player;

    public TeamsUI(Main main, Player player) {
        this.main = main;
        this.player = player;
    }

    public void openTeamChoiceUI() {
        Inventory inv = Bukkit.createInventory(null, 54, "Choix de l'équipe");

        ItemStack vitre = new ItemBuilder(Material.STAINED_GLASS_PANE, 1, (short) 4).setDisplayName(" ").build(false);

        player.openInventory(inv);
    }
}
