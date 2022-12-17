package fr.notdark.orbconquest.ui;

import fr.notdark.orbconquest.Main;
import fr.notdark.orbconquest.tools.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;

import java.util.Arrays;

public class ConfigUI {

    private final Main main;

    private final Player player;

    public ConfigUI(Main main, Player player) {
        this.main = main;
        this.player = player;
    }
    public void openConfigUI(){
        Inventory inv = Bukkit.createInventory(null, 54, "Configuration");

        ItemStack vitre = new ItemBuilder(Material.STAINED_GLASS_PANE, 1, (short) 3).setDisplayName(" ").build(false);

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


        inv.setItem(19, new ItemBuilder(Material.WATCH).setDisplayName("§eTemps de partie").setLoreWithList(Arrays.asList(
                "§7Permet de choisir le temps de la partie que l'on",
                "§7souhaite. (en minutes)",
                "",
                "§6§l▪ §e" + main.getConfigManager().getInt("temps-partie"),
                "",
                "§7Clique-gauche pour augmenter de 1",
                "§7Clique-droit pour diminuer de 1",
                "§7Maintenir shift pour augmenter/diminuer de 5"
        )).build(false));

        inv.setItem(20, new ItemBuilder(Material.BEACON).setDisplayName("§9Temps de préparation").setLoreWithList(Arrays.asList(
                "§7Permet de choisir la temps de préparation que l'on",
                "§7souhaite. (en minutes)",
                "",
                "§6§l▪ §e" + main.getConfigManager().getInt("temps-prep"),
                "",
                "§7Clique-gauche pour augmenter de 1",
                "§7Clique-droit pour diminuer de 1",
                "§7Maintenir shift pour augmenter/diminuer de 5"
        )).build(false));

        inv.setItem(21, new ItemBuilder(Material.PAPER).setDisplayName("§fTemps entre calculs").setLoreWithList(Arrays.asList(
                "§7Permet de choisir le temps entre chaque calcul de points",
                "§7que l'on souhaite. (en minutes)",
                "",
                "§6§l▪ §e" + main.getConfigManager().getInt("temps-calcul-point"),
                "",
                "§7Clique-gauche pour augmenter de 1",
                "§7Clique-droit pour diminuer de 1",
                "§7Maintenir shift pour augmenter/diminuer de 5"
        )).build(false));

        inv.setItem(22, new ItemBuilder(Material.OBSIDIAN).setDisplayName("§3Temps entre restitutions").setLoreWithList(Arrays.asList(
                "§7Permet de choisir le temps entre chaque restitution des",
                "§7Orbes que l'on souhaite. (en minutes)",
                "",
                "§6§l▪ §e" + main.getConfigManager().getInt("temps-restitution-orbe"),
                "",
                "§7Clique-gauche pour augmenter de 1",
                "§7Clique-droit pour diminuer de 1",
                "§7Maintenir shift pour augmenter/diminuer de 5"
        )).build(false));

        inv.setItem(23, new ItemBuilder(Material.BOOK).setDisplayName("§bTemps entre scores").setLoreWithList(Arrays.asList(
                "§7Permet de choisir le temps auquels sera envoyé dans le chat",
                "§7général que l'on souhaite. (en minutes)",
                "",
                "§6§l▪ §e" + main.getConfigManager().getInt("temps-info-chat"),
                "§7(-1 pour désactiver)",
                "",
                "§7Clique-gauche pour augmenter de 1",
                "§7Clique-droit pour diminuer de 1",
                "§7Maintenir shift pour augmenter/diminuer de 5"
        )).build(false));

        inv.setItem(24, new ItemBuilder(Material.INK_SACK, 1, (short) 7).setDisplayName("§aPoints obtenus (Notre orbe)").setLoreWithList(Arrays.asList(
                "§7Permet de choisir le nombre de points obtenus losqu'on",
                "§7garde notre orbe que l'on souhaite. (en points)",
                "",
                "§6§l▪ §e" + main.getConfigManager().getInt("points-notre-orbe"),
                "",
                "§7Clique-gauche pour augmenter de 1",
                "§7Clique-droit pour diminuer de 1"
        )).build(false));

        inv.setItem(25, new ItemBuilder(Material.INK_SACK).setDisplayName("§2Points obtenus (Orbe adverse)").setLoreWithList(Arrays.asList(
                "§7Permet de choisir le nombre de points obtenus losqu'on",
                "§7garde une orbe volé que l'on souhaite. (en points)",
                "",
                "§6§l▪ §e" + main.getConfigManager().getInt("points-orbe-adverse"),
                "",
                "§7Clique-gauche pour augmenter de 1",
                "§7Clique-droit pour diminuer de 1"
        )).build(false));

        inv.setItem(29, new ItemBuilder(Material.BARRIER).setDisplayName("§6Rayon de spawn").setLoreWithList(Arrays.asList(
                "§7Permet de choisir le rayon de spawn de la map",
                "§7que l'on souhaite. (en blocks)",
                "",
                "§6§l▪ §e" + main.getConfigManager().getInt("rayon-de-spawn"),
                "",
                "§7Clique-gauche pour augmenter de 50",
                "§7Clique-droit pour diminuer de 50",
                "§7Maintenir shift pour augmenter/diminuer de 100"
        )).build(false));

        inv.setItem(30, new ItemBuilder(Material.BANNER).setDisplayName("§dJoueurs par équipe").setLoreWithList(Arrays.asList(
                "§7Permet de choisir le nombre de joueurs par équipe",
                "§7que l'on souhaite. (en joueurs)",
                "",
                "§6§l▪ §e" + main.getConfigManager().getInt("players-per-team"),
                "",
                "§7Clique-gauche pour augmenter de 1",
                "§7Clique-droit pour diminuer de 1"
        )).build(false));

        inv.setItem(31, new ItemBuilder(Material.STONE_HOE).setDisplayName("§eMode de création").setLoreWithList(Arrays.asList(
                "§7Permet de choisir le mode des créations des équipes",
                "§7que l'on souhaite.",
                "",
                "§6§l▪ §e" + main.getConfigManager().getString("creation-mode"),
                "",
                "§7Clique-gauche pour passer au suivant",
                "§7Clique-droit pour revenir au précédent"
        )).build(false));

        inv.setItem(32, new ItemBuilder(Material.BED).setDisplayName("§2Statistiques à attribuer").setLoreWithList(Arrays.asList(
                "§7Permet de choisir le nombre de points de statistiques à",
                "§7attribuer au début que l'on souhaite. (en points)",
                "",
                "§6§l▪ §e" + main.getConfigManager().getInt("players-points-start"),
                "",
                "§7Clique-gauche pour augmenter de 10",
                "§7Clique-droit pour diminuer de 10"
        )).build(false));

        inv.setItem(33, new ItemBuilder(Material.DOUBLE_PLANT).setDisplayName("§9Cycle jour/nuit").setLoreWithList(Arrays.asList(
                "§7Permet de choisir le temps du cycle jour/nuit",
                "§7que l'on souhaite. (en minutes)",
                "",
                "§6§l▪ §e" + main.getConfigManager().getInt("cycle-jour-nuit"),
                "",
                "§7Clique-gauche pour augmenter de 5",
                "§7Clique-droit pour diminuer de 5"
        )).build(false));

        inv.setItem(49, new ItemBuilder(Material.ARROW).setDisplayName("§cRetour").build(false));
        player.openInventory(inv);
    }
}
