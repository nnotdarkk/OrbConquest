package fr.notdark.orbconquest.ui;

import fr.notdark.orbconquest.Main;
import fr.notdark.orbconquest.config.user.UserManager;
import fr.notdark.orbconquest.enums.GameElements;
import fr.notdark.orbconquest.enums.GameSorts;
import fr.notdark.orbconquest.tools.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;
import java.util.List;

public class SortsChoiceUI {

    private final Main main;

    public SortsChoiceUI(Main main) {
        this.main = main;
    }

    public Inventory getInventory(Player p){
        Inventory inv = Bukkit.createInventory(null, 54, "Choix des sorts");

        ItemStack vitre = new ItemBuilder(Material.STAINED_GLASS_PANE, 1, (short) 1).setDisplayName(" ").build(false);

        int i = 20;

        UserManager userManager = new UserManager(main, p);
        for (GameElements element : userManager.getElements()){
            for (GameSorts sorts : main.getEnumsManager().convertElementToSorts(element)) {
                ItemBuilder ib = main.getEnumsManager().gameElementToItemStack(element, sorts.toString(), sorts);
                ib.setLoreWithList(Arrays.asList("", "", ""));

                inv.setItem(i, ib.build(false));
                i++;
                if (i == 25) {
                    i = 29;
                }
                if(i == 34){
                    i = 39;
                }
            }
        }

        inv.setItem(0, vitre);
        inv.setItem(1, vitre);
        inv.setItem(7, vitre);
        inv.setItem(8, vitre);
        inv.setItem(9, vitre);
        inv.setItem(17, vitre);
        inv.setItem(36, vitre);
        inv.setItem(44, vitre);
        inv.setItem(45, vitre);
        inv.setItem(46, vitre);
        inv.setItem(52, vitre);
        inv.setItem(53, vitre);

        return inv;
    }

    private String symbol(Player player, GameElements element) {
        UserManager um = new UserManager(main, player);
        List<GameElements> elements = um.getElements();
        if(elements.contains(element)) {
            return "§a✔";
        } else {
            return "§c✘";
        }
    }

}
